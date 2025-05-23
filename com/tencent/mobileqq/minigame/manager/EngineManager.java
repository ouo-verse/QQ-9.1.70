package com.tencent.mobileqq.minigame.manager;

import android.app.ActivityManager;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.minigame.manager.EngineChannel;
import com.tencent.mobileqq.minigame.manager.EngineInstaller;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.minigame.utils.thread.TTHandleThread;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class EngineManager {
    public static final String LOG_TAG = "EngineManager";
    private static volatile EngineManager sInstance;
    private SparseArray<EngineChannel> mChannels;
    private SparseArray<EngineInstaller> mEngineInstallers;
    private SparseArray<EngineChannel> mOutChannels;
    private Runnable removeOldEngine = new Runnable() { // from class: com.tencent.mobileqq.minigame.manager.EngineManager.1
        @Override // java.lang.Runnable
        public void run() {
            EngineInstaller.removeOutDatedEngine(2);
            EngineInstaller.removeOldEngine(2);
            EngineInstaller.removeOldEngine(3);
            EngineInstaller.removeOldEngine(99);
        }
    };

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class EngineChannelReceiver implements EngineChannel.Receiver {
        public EngineChannelReceiver() {
        }

        @Override // com.tencent.mobileqq.minigame.manager.EngineChannel.Receiver
        public void onReceiveData(int i3, Bundle bundle) {
            boolean z16;
            bundle.setClassLoader(getClass().getClassLoader());
            final int i16 = bundle.getInt("baseLibType");
            int i17 = bundle.getInt("enginePid");
            EngineChannel engineChannel = (EngineChannel) bundle.getParcelable("engineChannel");
            if (engineChannel != null) {
                if (EngineManager.this.mOutChannels.indexOfKey(i17) > 0) {
                    QLog.w("EngineManager", 1, "[MiniEng] channel already exists for pid " + i17 + " replacing");
                }
                EngineManager.this.mOutChannels.put(i17, engineChannel);
            }
            final EngineChannel engineChannel2 = (EngineChannel) EngineManager.this.mOutChannels.get(i17);
            if (engineChannel2 == null) {
                QLog.e("EngineManager", 1, "[MiniEng]no channel available for pid " + i17);
                return;
            }
            QLog.i("EngineManager", 1, "[MiniEng] onReceiveData what=" + i3 + ",baseLibType=" + i16 + ",pid=" + i17 + ",remote=" + engineChannel2 + ",channelCount=" + EngineManager.this.mOutChannels.size());
            engineChannel2.send(55, null);
            if (i3 == 1) {
                ArrayList<InstalledEngine> engineList = EngineManager.g().getEngineList(i16);
                Bundle bundle2 = new Bundle();
                bundle2.putParcelableArrayList("installedEngineList", engineList);
                engineChannel2.send(51, bundle2);
                EngineManager.this.removeDeadChannelExcept(engineChannel2);
                QLog.i("EngineManager", 1, "[MiniEng]LiveChannel count " + EngineManager.this.mOutChannels.size());
                return;
            }
            if (i3 == 3) {
                if (i16 == 2) {
                    Iterator<InstalledEngine> it = EngineManager.this.getEngineList(i16).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z16 = false;
                            break;
                        }
                        InstalledEngine next = it.next();
                        if (next.isPersist && next.isVerify && EngineManager.isEngineGTLocalQQVersion(next.engineVersion)) {
                            z16 = true;
                            break;
                        }
                    }
                    if (!LocalGameEngine.g().isDisabled() && !z16) {
                        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.minigame.manager.EngineManager.EngineChannelReceiver.1
                            @Override // java.lang.Runnable
                            public void run() {
                                EngineManager.this.installBaseLibForChannel(LocalGameEngine.g().mLocalBaseLibInfo, engineChannel2);
                            }
                        });
                        return;
                    }
                    if (LocalGameEngine.g().isWnsConfigModel()) {
                        BaseLibInfo gameBaseLibInfo = GameWnsUtils.getGameBaseLibInfo();
                        QLog.i("EngineManager", 1, "[MiniEng] QQSpeed INSTALL_LATEST_ENGINE gameEngineLib " + gameBaseLibInfo);
                        if (gameBaseLibInfo == null || gameBaseLibInfo.baseLibType != 2) {
                            return;
                        }
                        EngineManager.this.installEngine(gameBaseLibInfo, engineChannel2);
                        return;
                    }
                }
                MiniAppCmdUtil.getInstance().updateBaseLib("0.0.1", false, true, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.minigame.manager.EngineManager.EngineChannelReceiver.2
                    @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                    public void onCmdListener(boolean z17, JSONObject jSONObject) {
                        QLog.i("EngineManager", 1, "[MiniEng] updateBaseLib response. isSuc=" + z17 + " rsp=" + jSONObject);
                        if (!z17 || jSONObject == null) {
                            return;
                        }
                        BaseLibInfo fromJSON = BaseLibInfo.fromJSON(jSONObject.optJSONObject(BaseLibInfo.getKey(i16)));
                        QLog.i("EngineManager", 1, "[MiniEng] engineLibInfo " + fromJSON);
                        EngineManager.this.installEngine(fromJSON, engineChannel2);
                    }
                });
                return;
            }
            if (i3 == 5) {
                if (i16 == 2 && LocalGameEngine.g().isWnsConfigModel()) {
                    BaseLibInfo gameBaseLibInfo2 = GameWnsUtils.getGameBaseLibInfo();
                    QLog.i("EngineManager", 1, "[MiniEng] QQSpeed UPGRADE_ENGINE gameEngineLib " + gameBaseLibInfo2);
                    if (gameBaseLibInfo2 == null || gameBaseLibInfo2.baseLibType != 2) {
                        return;
                    }
                    EngineManager.this.upgradeEngine(gameBaseLibInfo2, engineChannel2);
                    return;
                }
                MiniAppCmdUtil.getInstance().updateBaseLib("0.0.1", false, true, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.minigame.manager.EngineManager.EngineChannelReceiver.3
                    @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                    public void onCmdListener(boolean z17, JSONObject jSONObject) {
                        QLog.i("EngineManager", 1, "[MiniEng] updateBaseLib response. isSuc=" + z17 + " rsp=" + jSONObject);
                        if (!z17 || jSONObject == null) {
                            return;
                        }
                        BaseLibInfo fromJSON = BaseLibInfo.fromJSON(jSONObject.optJSONObject(BaseLibInfo.getKey(i16)));
                        QLog.i("EngineManager", 1, "[MiniEng] engineLibInfo " + fromJSON);
                        EngineManager.this.upgradeEngine(fromJSON, engineChannel2);
                    }
                });
                return;
            }
            if (i3 == 56) {
                InstalledEngine installedEngine = (InstalledEngine) bundle.getParcelable("invalidEngine");
                QLog.i("EngineManager", 1, "[MiniEng] receive delete InstalledEngine from pid:" + i17 + ", baseLibType:" + i16 + ", targetEngine:" + installedEngine);
                if (installedEngine != null) {
                    EngineInstaller.removeEngine(installedEngine);
                }
            }
        }
    }

    EngineManager() {
        QLog.i("EngineManager", 1, "[MiniEng]init start");
        long currentTimeMillis = System.currentTimeMillis();
        this.mEngineInstallers = new SparseArray<>();
        this.mChannels = new SparseArray<>();
        EngineChannel engineChannel = new EngineChannel();
        engineChannel.setName("MainGame");
        engineChannel.setReceiver(new EngineChannelReceiver());
        this.mChannels.put(2, engineChannel);
        EngineChannel engineChannel2 = new EngineChannel();
        engineChannel2.setName("MainApp");
        engineChannel2.setReceiver(new EngineChannelReceiver());
        this.mChannels.put(3, engineChannel2);
        this.mOutChannels = new SparseArray<>();
        EngineInstaller.updateInstalledEngine();
        ThreadManagerV2.excute(this.removeOldEngine, 64, null, false);
        QLog.i("EngineManager", 1, "[MiniEng]init end cost=" + (System.currentTimeMillis() - currentTimeMillis));
    }

    private ArrayList<Integer> getRunningPidList() {
        ActivityManager activityManager;
        ArrayList<Integer> arrayList = new ArrayList<>();
        BaseApplication context = BaseApplication.getContext();
        if (context == null || (activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)) == null) {
            return arrayList;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = SystemMethodProxy.getRunningAppProcesses(activityManager).iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().pid));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void installBaseLibForChannel(final BaseLibInfo baseLibInfo, final EngineChannel engineChannel) {
        QLog.i("EngineManager", 1, "[MiniEng] installBaseLibForChannel " + baseLibInfo + "," + engineChannel);
        installBaseLib(baseLibInfo, new EngineInstaller.Callback() { // from class: com.tencent.mobileqq.minigame.manager.EngineManager.4
            @Override // com.tencent.mobileqq.minigame.manager.EngineInstaller.Callback
            public void onEngineWorkAbort() {
                engineChannel.send(54, null);
            }

            @Override // com.tencent.mobileqq.minigame.manager.EngineInstaller.Callback
            public void onEngineWorkBegin() {
                engineChannel.send(52, null);
            }

            @Override // com.tencent.mobileqq.minigame.manager.EngineInstaller.Callback
            public void onEngineWorkFinish() {
                engineChannel.send(54, null);
                EngineInstaller engineInstaller = (EngineInstaller) EngineManager.this.mEngineInstallers.get(baseLibInfo.baseLibType);
                if (engineInstaller != null) {
                    engineInstaller.removeCallback(this);
                }
            }

            @Override // com.tencent.mobileqq.minigame.manager.EngineInstaller.Callback
            public void onMessageUpdate(float f16, String str) {
                Bundle bundle = new Bundle();
                bundle.putFloat("engineInstallerProgress", f16);
                bundle.putString("engineInstallerMessage", str);
                engineChannel.send(53, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void removeDeadChannelExcept(EngineChannel engineChannel) {
        ArrayList<Integer> runningPidList = getRunningPidList();
        if (this.mOutChannels != null) {
            for (int i3 = 0; i3 < this.mOutChannels.size(); i3++) {
                int keyAt = this.mOutChannels.keyAt(i3);
                if (!runningPidList.contains(Integer.valueOf(keyAt))) {
                    if (this.mOutChannels.valueAt(i3).equals(engineChannel)) {
                        QLog.e("EngineManager", 1, "[MiniEng] removeDeadChannelExcept error pid=" + keyAt);
                    } else {
                        this.mOutChannels.remove(keyAt);
                        QLog.i("EngineManager", 1, "[MiniEng] removeDeadChannelExcept pid=" + keyAt);
                    }
                }
            }
        }
    }

    public EngineChannel getChannelForType(int i3) {
        EngineChannel engineChannel = this.mChannels.get(i3);
        if (engineChannel == null) {
            QLog.e("EngineManager", 1, "[MiniEng]getChannelForType error type" + i3);
        }
        return engineChannel;
    }

    public ArrayList<InstalledEngine> getEngineList(int i3) {
        return EngineInstaller.getInstalledEngine(i3);
    }

    public void preInstallLocalGameLibWithDelay() {
        if (LocalGameEngine.g().isDisabled()) {
            QLog.i("EngineManager", 1, "[MiniEng] installLocalLib skip disabled");
        } else {
            TTHandleThread.getInstance().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.minigame.manager.EngineManager.5
                @Override // java.lang.Runnable
                public void run() {
                    EngineManager.this.preInstallLocalGameLib();
                }
            }, 2000L);
        }
    }

    public static EngineManager g() {
        if (sInstance == null) {
            synchronized (EngineManager.class) {
                if (sInstance == null) {
                    sInstance = new EngineManager();
                }
            }
        }
        if (!AppUtil.isMainProcess()) {
            QLog.e("EngineManager", 1, "[MiniEng]EngineManager can not be called at " + BaseApplicationImpl.getApplication().getQQProcessName());
        }
        return sInstance;
    }

    public static boolean isEngineGTLocalQQVersion(EngineVersion engineVersion) {
        return engineVersion.compareTo(LocalGameEngine.g().mLocalEngineVersion) >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preInstallLocalGameLib() {
        Iterator<InstalledEngine> it = getEngineList(2).iterator();
        while (it.hasNext()) {
            InstalledEngine next = it.next();
            if (next.isPersist && next.isVerify) {
                QLog.i("EngineManager", 1, "[MiniEng] installLocalLib skip already installed");
                return;
            }
        }
        QLog.i("EngineManager", 1, "[MiniEng] installLocalGameEngine " + LocalGameEngine.g().mLocalBaseLibInfo);
        installBaseLib(LocalGameEngine.g().mLocalBaseLibInfo, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void installEngine(final BaseLibInfo baseLibInfo, final EngineChannel engineChannel) {
        if (baseLibInfo != null) {
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.minigame.manager.EngineManager.2
                @Override // java.lang.Runnable
                public void run() {
                    EngineManager.this.installBaseLibForChannel(baseLibInfo, engineChannel);
                }
            });
        } else {
            engineChannel.send(54, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upgradeEngine(final BaseLibInfo baseLibInfo, final EngineChannel engineChannel) {
        if (baseLibInfo != null) {
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.minigame.manager.EngineManager.3
                @Override // java.lang.Runnable
                public void run() {
                    QLog.i("EngineManager", 1, "[MiniEng] installBaseLibForChannel " + baseLibInfo + "," + engineChannel);
                    EngineManager.this.installBaseLib(baseLibInfo, new EngineInstaller.Callback() { // from class: com.tencent.mobileqq.minigame.manager.EngineManager.3.1
                        @Override // com.tencent.mobileqq.minigame.manager.EngineInstaller.Callback
                        public void onEngineWorkAbort() {
                            engineChannel.send(54, null);
                            EngineInstaller engineInstaller = (EngineInstaller) EngineManager.this.mEngineInstallers.get(baseLibInfo.baseLibType);
                            if (engineInstaller != null) {
                                engineInstaller.removeCallback(this);
                            }
                        }

                        @Override // com.tencent.mobileqq.minigame.manager.EngineInstaller.Callback
                        public void onEngineWorkBegin() {
                            engineChannel.send(52, null);
                        }

                        @Override // com.tencent.mobileqq.minigame.manager.EngineInstaller.Callback
                        public void onEngineWorkFinish() {
                            engineChannel.send(54, null);
                            EngineInstaller engineInstaller = (EngineInstaller) EngineManager.this.mEngineInstallers.get(baseLibInfo.baseLibType);
                            if (engineInstaller != null) {
                                engineInstaller.removeCallback(this);
                            }
                        }

                        @Override // com.tencent.mobileqq.minigame.manager.EngineInstaller.Callback
                        public void onMessageUpdate(float f16, String str) {
                            Bundle bundle = new Bundle();
                            bundle.putFloat("engineInstallerProgress", f16);
                            bundle.putString("engineInstallerMessage", str);
                            engineChannel.send(53, bundle);
                        }
                    });
                }
            });
        } else {
            engineChannel.send(54, null);
        }
    }

    public void installBaseLib(BaseLibInfo baseLibInfo, EngineInstaller.Callback callback) {
        if (baseLibInfo != null) {
            EngineInstaller engineInstaller = this.mEngineInstallers.get(baseLibInfo.baseLibType);
            if (engineInstaller == null) {
                engineInstaller = new EngineInstaller(new DefaultDownloader());
                this.mEngineInstallers.put(baseLibInfo.baseLibType, engineInstaller);
            }
            engineInstaller.installWithCallback(baseLibInfo, callback);
            return;
        }
        QLog.i("EngineManager", 1, "[MiniEng] libInfo is null ");
    }
}
