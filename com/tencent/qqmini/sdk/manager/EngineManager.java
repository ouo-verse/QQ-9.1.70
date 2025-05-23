package com.tencent.qqmini.sdk.manager;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.action.EngineChannel;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.manager.EngineInstaller;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.utils.WnsUtil;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class EngineManager {
    public static final String LOG_TAG = "EngineManager";
    private static volatile EngineManager sInstance;
    private SparseArray<EngineChannel> mChannels;
    private SparseArray<EngineInstaller> mEngineInstallers;
    private SparseArray<EngineChannel> mOutChannels;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class EngineChannelReceiver implements EngineChannel.Receiver {
        public EngineChannelReceiver() {
        }

        private void doInstallEngine(final int i3, final EngineChannel engineChannel) {
            boolean z16;
            if (i3 == 2) {
                Iterator<InstalledEngine> it = EngineManager.this.getEngineList(i3).iterator();
                while (true) {
                    if (it.hasNext()) {
                        InstalledEngine next = it.next();
                        if (next.isPersist && next.isVerify) {
                            z16 = true;
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
                if (!LocalGameEngine.g().isDisabled() && !z16 && (QUAUtil.isQQMainApp() || QUAUtil.isDemoApp() || !TextUtils.isEmpty(miniAppProxy.getSoPath()))) {
                    ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.manager.EngineManager.EngineChannelReceiver.2
                        @Override // java.lang.Runnable
                        public void run() {
                            EngineManager.this.installBaseLibForChannel(LocalGameEngine.g().mLocalBaseLibInfo, engineChannel);
                        }
                    });
                    return;
                }
                if (LocalGameEngine.g().isWnsConfigModel()) {
                    BaseLibInfo gameBaseLibInfo = WnsUtil.getGameBaseLibInfo();
                    QMLog.i("EngineManager", "[MiniEng] QQSpeed INSTALL_LATEST_ENGINE gameEngineLib " + gameBaseLibInfo);
                    if (gameBaseLibInfo != null && gameBaseLibInfo.baseLibType == 2) {
                        EngineManager.this.installEngine(gameBaseLibInfo, engineChannel);
                        return;
                    }
                    return;
                }
            }
            ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).updateBaseLib("0,0,1", false, true, new AsyncResult() { // from class: com.tencent.qqmini.sdk.manager.EngineManager.EngineChannelReceiver.3
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z17, JSONObject jSONObject) {
                    QMLog.i("EngineManager", "[MiniEng] updateBaseLib response. isSuc=" + z17 + " rsp=" + jSONObject);
                    if (z17 && jSONObject != null) {
                        BaseLibInfo fromJSON = BaseLibInfo.fromJSON(jSONObject.optJSONObject(BaseLibInfo.getKey(i3)));
                        QMLog.i("EngineManager", "[MiniEng] engineLibInfo " + fromJSON);
                        EngineManager.this.installEngine(fromJSON, engineChannel);
                    }
                }
            });
        }

        private void doUpgradeEngine(final int i3, final EngineChannel engineChannel) {
            if (i3 == 2 && LocalGameEngine.g().isWnsConfigModel()) {
                BaseLibInfo gameBaseLibInfo = WnsUtil.getGameBaseLibInfo();
                QMLog.i("EngineManager", "[MiniEng] QQSpeed UPGRADE_ENGINE gameEngineLib " + gameBaseLibInfo);
                if (gameBaseLibInfo != null && gameBaseLibInfo.baseLibType == 2) {
                    EngineManager.this.upgradeEngine(gameBaseLibInfo, engineChannel);
                    return;
                }
                return;
            }
            ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).updateBaseLib("0,0,1", false, true, new AsyncResult() { // from class: com.tencent.qqmini.sdk.manager.EngineManager.EngineChannelReceiver.1
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                    QMLog.i("EngineManager", "[MiniEng] updateBaseLib response. isSuc=" + z16 + " rsp=" + jSONObject);
                    if (z16 && jSONObject != null) {
                        BaseLibInfo fromJSON = BaseLibInfo.fromJSON(jSONObject.optJSONObject(BaseLibInfo.getKey(i3)));
                        QMLog.i("EngineManager", "[MiniEng] engineLibInfo " + fromJSON);
                        EngineManager.this.upgradeEngine(fromJSON, engineChannel);
                    }
                }
            });
        }

        @Override // com.tencent.qqmini.sdk.launcher.action.EngineChannel.Receiver
        public void onReceiveData(int i3, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            int i16 = bundle.getInt("baseLibType");
            int i17 = bundle.getInt("enginePid");
            EngineChannel engineChannel = (EngineChannel) bundle.getParcelable("engineChannel");
            if (engineChannel != null) {
                if (EngineManager.this.mOutChannels.indexOfKey(i17) > 0) {
                    QMLog.w("EngineManager", "[MiniEng] channel already exists for pid " + i17 + " replacing");
                }
                EngineManager.this.mOutChannels.put(i17, engineChannel);
            }
            EngineChannel engineChannel2 = (EngineChannel) EngineManager.this.mOutChannels.get(i17);
            if (engineChannel2 == null) {
                QMLog.e("EngineManager", "[MiniEng]no channel available for pid " + i17);
                return;
            }
            QMLog.i("EngineManager", "[MiniEng] onReceiveData what=" + i3 + ",baseLibType=" + i16 + ",pid=" + i17 + ",remote=" + engineChannel2 + ",channelCount=" + EngineManager.this.mOutChannels.size());
            engineChannel2.send(55, null);
            if (i3 == 1) {
                ArrayList<InstalledEngine> engineList = EngineManager.g().getEngineList(i16);
                Bundle bundle2 = new Bundle();
                bundle2.putParcelableArrayList("installedEngineList", engineList);
                engineChannel2.send(51, bundle2);
                EngineManager.this.removeDeadChannelExcept(engineChannel2);
                QMLog.i("EngineManager", "[MiniEng]LiveChannel count " + EngineManager.this.mOutChannels.size());
                return;
            }
            if (i3 == 3) {
                doInstallEngine(i16, engineChannel2);
                return;
            }
            if (i3 == 5) {
                doUpgradeEngine(i16, engineChannel2);
                return;
            }
            if (i3 == 56) {
                InstalledEngine installedEngine = (InstalledEngine) bundle.getParcelable("invalidEngine");
                QMLog.i("EngineManager", "[MiniEng] receive delete InstalledEngine from pid:" + i17 + ", baseLibType:" + i16 + ", targetEngine:" + installedEngine);
                if (installedEngine != null) {
                    EngineInstaller.removeEngine(installedEngine);
                }
            }
        }
    }

    EngineManager() {
        QMLog.i("EngineManager", "[MiniEng]init start");
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
        EngineInstaller.removeOutDatedEngine(2);
        EngineInstaller.removeOldEngine(2);
        EngineInstaller.removeOldEngine(3);
        QMLog.i("EngineManager", "[MiniEng]init end cost=" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public static EngineManager g() {
        if (sInstance == null) {
            synchronized (EngineManager.class) {
                if (sInstance == null) {
                    sInstance = new EngineManager();
                }
            }
        }
        return sInstance;
    }

    private ArrayList<Integer> getRunningPidList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Context context = AppLoaderFactory.g().getContext();
        if (context == null) {
            return arrayList;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager == null) {
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
        QMLog.i("EngineManager", "[MiniEng] installBaseLibForChannel " + baseLibInfo + "," + engineChannel);
        installBaseLib(baseLibInfo, new EngineInstaller.Callback() { // from class: com.tencent.qqmini.sdk.manager.EngineManager.3
            @Override // com.tencent.qqmini.sdk.manager.EngineInstaller.Callback
            public void onEngineWorkAbort() {
                engineChannel.send(54, null);
            }

            @Override // com.tencent.qqmini.sdk.manager.EngineInstaller.Callback
            public void onEngineWorkBegin() {
                engineChannel.send(52, null);
            }

            @Override // com.tencent.qqmini.sdk.manager.EngineInstaller.Callback
            public void onEngineWorkFinish() {
                engineChannel.send(54, null);
                EngineInstaller engineInstaller = (EngineInstaller) EngineManager.this.mEngineInstallers.get(baseLibInfo.baseLibType);
                if (engineInstaller != null) {
                    engineInstaller.removeCallback(this);
                }
            }

            @Override // com.tencent.qqmini.sdk.manager.EngineInstaller.Callback
            public void onMessageUpdate(float f16, String str) {
                Bundle bundle = new Bundle();
                bundle.putFloat("engineInstallerProgress", f16);
                bundle.putString("engineInstallerMessage", str);
                engineChannel.send(53, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void installEngine(final BaseLibInfo baseLibInfo, final EngineChannel engineChannel) {
        if (baseLibInfo != null) {
            ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.manager.EngineManager.1
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
    public synchronized void removeDeadChannelExcept(EngineChannel engineChannel) {
        ArrayList<Integer> runningPidList = getRunningPidList();
        if (this.mOutChannels != null) {
            for (int i3 = 0; i3 < this.mOutChannels.size(); i3++) {
                int keyAt = this.mOutChannels.keyAt(i3);
                if (!runningPidList.contains(Integer.valueOf(keyAt))) {
                    if (this.mOutChannels.valueAt(i3).equals(engineChannel)) {
                        QMLog.e("EngineManager", "[MiniEng] removeDeadChannelExcept error pid=" + keyAt);
                    } else {
                        this.mOutChannels.remove(keyAt);
                        QMLog.i("EngineManager", "[MiniEng] removeDeadChannelExcept pid=" + keyAt);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upgradeEngine(final BaseLibInfo baseLibInfo, final EngineChannel engineChannel) {
        if (baseLibInfo != null) {
            ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.manager.EngineManager.2
                @Override // java.lang.Runnable
                public void run() {
                    QMLog.i("EngineManager", "[MiniEng] installBaseLibForChannel " + baseLibInfo + "," + engineChannel);
                    EngineManager.this.installBaseLib(baseLibInfo, new EngineInstaller.Callback() { // from class: com.tencent.qqmini.sdk.manager.EngineManager.2.1
                        @Override // com.tencent.qqmini.sdk.manager.EngineInstaller.Callback
                        public void onEngineWorkAbort() {
                            engineChannel.send(54, null);
                            EngineInstaller engineInstaller = (EngineInstaller) EngineManager.this.mEngineInstallers.get(baseLibInfo.baseLibType);
                            if (engineInstaller != null) {
                                engineInstaller.removeCallback(this);
                            }
                        }

                        @Override // com.tencent.qqmini.sdk.manager.EngineInstaller.Callback
                        public void onEngineWorkBegin() {
                            engineChannel.send(52, null);
                        }

                        @Override // com.tencent.qqmini.sdk.manager.EngineInstaller.Callback
                        public void onEngineWorkFinish() {
                            engineChannel.send(54, null);
                            EngineInstaller engineInstaller = (EngineInstaller) EngineManager.this.mEngineInstallers.get(baseLibInfo.baseLibType);
                            if (engineInstaller != null) {
                                engineInstaller.removeCallback(this);
                            }
                        }

                        @Override // com.tencent.qqmini.sdk.manager.EngineInstaller.Callback
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

    public EngineChannel getChannelForType(int i3) {
        EngineChannel engineChannel = this.mChannels.get(i3);
        if (engineChannel == null) {
            QMLog.e("EngineManager", "[MiniEng]getChannelForType error type" + i3);
        }
        return engineChannel;
    }

    public ArrayList<InstalledEngine> getEngineList(int i3) {
        return EngineInstaller.getInstalledEngine(i3);
    }

    public void installBaseLib(BaseLibInfo baseLibInfo, EngineInstaller.Callback callback) {
        if (baseLibInfo != null) {
            EngineInstaller engineInstaller = this.mEngineInstallers.get(baseLibInfo.baseLibType);
            if (engineInstaller == null) {
                engineInstaller = new EngineInstaller();
                this.mEngineInstallers.put(baseLibInfo.baseLibType, engineInstaller);
            }
            engineInstaller.installWithCallback(baseLibInfo, callback);
            return;
        }
        QMLog.i("EngineManager", "[MiniEng] libInfo is null ");
    }
}
