package com.tencent.mm.hardcoder;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mm.hardcoder.HCPerfManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.ProtoServlet;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import eipc.EIPCResult;
import java.io.File;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes9.dex */
public class HardCoderManager implements Handler.Callback {
    private static final int FLAG_AB_TEST = 1;
    private static final int FLAG_DISABLE = 2;
    private static final int FLAG_ENABLE = 0;
    public static final boolean IS_DEBUG;
    private static final String KEY_CFG_FLAG = "key_cfg_flag";
    private static final String KEY_CRASH_COUNT;
    private static final String KEY_LAST_DOWNLOAD_TIME = "key_last_down_time";
    private static final String KEY_STATE = "key_state";
    private static final int MAX_CRASH_COUNT = 3;
    private static final long MIN_DOWNLOAD_INTERVAL = 86400000;
    private static final int MSG_START = 0;
    private static final int MSG_STOP = 1;
    private static final String SO_URL_FOR_32 = "https://downv6.qq.com/qqAVCodecLib/HardCoderLibDir/20230724/armeabi-v7a/libhc4.jpeg";
    private static final String SO_URL_FOR_64 = "https://downv6.qq.com/qqAVCodecLib/HardCoderLibDir/20230724/arm64-v8a/libhc4.jpeg";
    static final int STATE_B_TEST = 8;
    static final int STATE_CRASH_PROTECT = 9;
    static final int STATE_DOWNLOAD_FAIL = 5;
    static final int STATE_DOWNLOAD_SUC = 6;
    static final int STATE_EXCEPTION = 7;
    static final int STATE_FILE_CFG_DISABLE = 2;
    static final int STATE_NO_SO = 4;
    static final int STATE_OK = 10;
    static final int STATE_SVC_CFG_DISABLE = 3;
    static final int STATE_UNINIT = 0;
    static final int STATE_UNSUPRT = 1;
    private static final String TAG = "HardCoder.QQManager";
    private static volatile HardCoderManager sInstance;
    private static final Random sRand;
    private static Bundle sStartBundle;
    private static Bundle sStopBundle;
    private Handler mHandler;
    private volatile int state = 0;
    private volatile boolean isRunning = false;
    private final HashMap<Integer, Boolean> sceneFlagMap = new HashMap<>();
    private final ConcurrentHashMap<Integer, Integer> codeMap = new ConcurrentHashMap<>();
    private MMKVOptionEntity mmkv = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class HardCoderIPCModule extends QIPCModule {
        public static final String NAME = "HardCoderModule";
        private static HardCoderIPCModule sInstance;

        public HardCoderIPCModule(String str) {
            super(str);
        }

        public static HardCoderIPCModule getInstance() {
            if (sInstance == null) {
                synchronized (HardCoderIPCModule.class) {
                    sInstance = new HardCoderIPCModule(NAME);
                }
            }
            return sInstance;
        }

        @Override // eipc.EIPCModule
        public EIPCResult onCall(String str, Bundle bundle, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d(HardCoderManager.TAG, 2, "onCall action = " + str);
            }
            if (str.equals("start")) {
                return EIPCResult.createResult(HCPerfManager.getInstance().start(bundle.getInt("key_delay"), bundle.getInt("key_cpu"), bundle.getInt("key_io"), bundle.getInt("key_gpu"), bundle.getIntArray("key_binds"), bundle.getInt(ProtoServlet.KEY_TIMEOUT), bundle.getInt("key_scene"), bundle.getLong("key_action"), Process.myTid(), bundle.getString("key_tag")), null);
            }
            if (str.equals("stop")) {
                HCPerfManager.getInstance().stop(bundle.getInt(MiniAppAbstractServlet.KEY_CODE));
            }
            return null;
        }
    }

    static {
        boolean z16;
        if (AppSetting.isPublicVersion() && (!QLog.isColorLevel() || !new File("/sdcard/debug_hc").exists())) {
            z16 = false;
        } else {
            z16 = true;
        }
        IS_DEBUG = z16;
        KEY_CRASH_COUNT = AppSetting.getRevision() + "key_crash_cnt";
        sRand = new Random();
        sStartBundle = new Bundle(8);
        sStopBundle = new Bundle(2);
    }

    HardCoderManager() {
    }

    public static HardCoderManager getInstance() {
        if (sInstance == null) {
            synchronized (HardCoderManager.class) {
                if (sInstance == null) {
                    sInstance = new HardCoderManager();
                }
            }
        }
        return sInstance;
    }

    static String getSoUrl() {
        if (AppSetting.isCpu64Bit()) {
            return SO_URL_FOR_64;
        }
        return SO_URL_FOR_32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        if (IS_DEBUG && new File("/sdcard/disable_hc").exists()) {
            QLog.d(TAG, 1, "disable by file cfg");
            this.state = 2;
            return;
        }
        int decodeInt = this.mmkv.decodeInt(KEY_CFG_FLAG, 0);
        if (decodeInt == 2) {
            QLog.d(TAG, 1, "disable by server cfg");
            this.state = 3;
            return;
        }
        String str = Build.MANUFACTURER;
        if (str != null && str.toUpperCase().contains("VIVO")) {
            QLog.d(TAG, 1, "disable vivo");
            this.state = 3;
            return;
        }
        if (MobileQQ.sProcessId == 1) {
            MMKVOptionEntity mMKVOptionEntity = this.mmkv;
            String str2 = KEY_CRASH_COUNT;
            int decodeInt2 = mMKVOptionEntity.decodeInt(str2, 0);
            if (decodeInt2 > 3) {
                this.state = 9;
            } else {
                this.mmkv.encodeInt(str2, decodeInt2 + 1);
                this.state = HCPerfManager.getInstance().init();
                if (this.state == 10 && decodeInt == 1 && Math.random() < 0.5d) {
                    this.state = 8;
                    HCPerfManager.getInstance().uninit();
                }
            }
            this.mmkv.encodeInt("key_state", this.state);
            if (this.state == 10) {
                this.mmkv.encodeInt(str2, decodeInt2 + 1);
                ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mm.hardcoder.HardCoderManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HardCoderManager.this.clearCrashRecord();
                    }
                }, 10000L);
            } else {
                this.mmkv.encodeInt(str2, decodeInt2);
            }
        } else {
            this.state = this.mmkv.decodeInt("key_state", 1);
            if (this.state == 10) {
                this.mHandler = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
            }
        }
        QLog.d(TAG, 1, "hc init " + this.state);
    }

    public void clearCrashRecord() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("crash count = ");
        MMKVOptionEntity mMKVOptionEntity = this.mmkv;
        String str = KEY_CRASH_COUNT;
        sb5.append(mMKVOptionEntity.decodeInt(str, 0));
        QLog.d(TAG, 1, sb5.toString());
        this.mmkv.encodeInt(str, 0);
    }

    public int getState() {
        return this.state;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 == 0) {
            HCPerfManager.PerformanceTask performanceTask = (HCPerfManager.PerformanceTask) message.obj;
            sStartBundle.putInt("key_delay", performanceTask.delay);
            sStartBundle.putInt("key_cpu", performanceTask.cpuLevel);
            sStartBundle.putInt("key_io", performanceTask.ioLevel);
            sStartBundle.putInt("key_gpu", performanceTask.gpuLevel);
            sStartBundle.putIntArray("key_binds", performanceTask.bindTids);
            sStartBundle.putInt(ProtoServlet.KEY_TIMEOUT, performanceTask.timeout);
            sStartBundle.putInt("key_scene", performanceTask.scene);
            sStartBundle.putLong("key_action", performanceTask.action);
            sStartBundle.putString("key_tag", performanceTask.tag);
            EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), HardCoderIPCModule.NAME, "start", sStartBundle);
            int i16 = message.arg1;
            if (i16 != 0 && callServer != null && callServer.code != 0) {
                this.codeMap.put(Integer.valueOf(i16), Integer.valueOf(callServer.code));
                return false;
            }
            return false;
        }
        if (i3 == 1) {
            sStopBundle.putInt(MiniAppAbstractServlet.KEY_CODE, message.arg1);
            BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), HardCoderIPCModule.NAME, "stop", sStopBundle);
            return false;
        }
        return false;
    }

    public boolean isEnable() {
        if (this.state == 10) {
            return true;
        }
        return false;
    }

    public boolean isSceneEnable(int i3) {
        if (!this.sceneFlagMap.containsKey(Integer.valueOf(i3))) {
            this.sceneFlagMap.put(Integer.valueOf(i3), Boolean.valueOf(this.mmkv.decodeBool(String.valueOf(i3), true)));
        }
        return Boolean.TRUE.equals(this.sceneFlagMap.get(Integer.valueOf(i3)));
    }

    public boolean isSupported() {
        if (this.state != 10 && this.state != 8) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSocketDisconnect() {
        if (this.state == 10) {
            this.state = 1;
            QLog.d(TAG, 1, "onDisconnect");
            this.mmkv.encodeInt("key_state", this.state);
            HCPerfManager.getInstance().uninit();
        }
    }

    public void setSceneEnable(int i3, boolean z16) {
        this.sceneFlagMap.put(Integer.valueOf(i3), Boolean.valueOf(z16));
        this.mmkv.encodeBool(String.valueOf(i3), z16);
    }

    public int start(int i3, int i16, int i17, int i18, int[] iArr, int i19, int i26, long j3, int i27, String str, boolean z16) {
        int[] iArr2;
        if (this.state != 10) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "start failed state is " + this.state);
            }
            tryInit();
            return 0;
        }
        if (!AppSetting.isPublicVersion() && !isSceneEnable(i26)) {
            return 0;
        }
        if (MobileQQ.sProcessId == 1) {
            return HCPerfManager.getInstance().start(i3, i16, i18, i17, iArr, i19, i26, j3, i27, str);
        }
        Message obtainMessage = this.mHandler.obtainMessage(0);
        HCPerfManager.PerformanceTask performanceTask = (HCPerfManager.PerformanceTask) HCPerfManager.sStartTaskPool.obtain(HCPerfManager.PerformanceTask.class);
        performanceTask.delay = i3;
        performanceTask.cpuLevel = i16;
        performanceTask.ioLevel = i18;
        performanceTask.gpuLevel = i17;
        if (iArr == null) {
            iArr2 = null;
        } else {
            iArr2 = (int[]) iArr.clone();
        }
        performanceTask.bindTids = iArr2;
        performanceTask.timeout = i19;
        performanceTask.scene = i26;
        performanceTask.action = j3;
        performanceTask.tag = str;
        obtainMessage.obj = performanceTask;
        obtainMessage.sendToTarget();
        if (z16) {
            int nextInt = sRand.nextInt();
            obtainMessage.arg1 = nextInt;
            this.codeMap.put(Integer.valueOf(nextInt), 0);
        } else {
            obtainMessage.arg1 = 0;
        }
        return obtainMessage.arg1;
    }

    public void stop(int i3, boolean z16) {
        if (i3 == 0) {
            return;
        }
        if (MobileQQ.sProcessId == 1) {
            HCPerfManager.getInstance().stop(i3);
            return;
        }
        if (this.mHandler != null) {
            if (this.codeMap.containsKey(Integer.valueOf(i3))) {
                Message obtainMessage = this.mHandler.obtainMessage(1);
                obtainMessage.arg1 = this.codeMap.remove(Integer.valueOf(i3)).intValue();
                obtainMessage.sendToTarget();
            } else if (z16) {
                Message obtainMessage2 = this.mHandler.obtainMessage(1);
                obtainMessage2.arg1 = i3;
                obtainMessage2.sendToTarget();
            }
        }
    }

    public synchronized void tryInit() {
        if (this.state == 0) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mm.hardcoder.HardCoderManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (HardCoderManager.this.state == 0) {
                            HardCoderManager.this.init();
                        }
                    }
                }, 16, null, false);
            } else {
                init();
            }
        }
    }

    public void tryUpdateSo() {
        if (this.isRunning) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "isRunning return");
                return;
            }
            return;
        }
        this.isRunning = true;
        tryInit();
        if (this.state != 1) {
            String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.batteryCfg.name());
            if (!TextUtils.isEmpty(featureValue)) {
                String[] split = featureValue.split("#");
                if (split.length >= 4) {
                    String str = split[3];
                    QLog.d(TAG, 1, "hcConfig = " + str);
                    if (!TextUtils.isEmpty(str)) {
                        String str2 = str.split("\\|")[0];
                        try {
                            this.mmkv.decodeInt(KEY_CFG_FLAG, Integer.parseInt(str2));
                        } catch (Exception e16) {
                            QLog.e(TAG, 1, "", e16);
                        }
                        QLog.d(TAG, 1, "svc flag = " + str2);
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "tryUpdateSo check download state is " + this.state);
        }
        if (this.state == 4 && !AppSetting.isGooglePlayVersion()) {
            if (Math.abs(System.currentTimeMillis() - this.mmkv.decodeLong(KEY_LAST_DOWNLOAD_TIME, 0L)) > 86400000 && NetworkUtil.isWifiConnected(BaseApplication.getContext())) {
                this.mmkv.encodeLong(KEY_LAST_DOWNLOAD_TIME, System.currentTimeMillis());
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mm.hardcoder.HardCoderManager.3
                    @Override // java.lang.Runnable
                    public void run() {
                        QLog.d(HardCoderManager.TAG, 1, "start download");
                        File file = new File(HCPerfManager.getSoPath() + "_tmp");
                        int downloadData = HttpDownloadUtil.downloadData(MobileQQ.sMobileQQ.peekAppRuntime(), HardCoderManager.getSoUrl(), file);
                        if (downloadData != 0) {
                            HardCoderManager.this.state = 5;
                        } else if (file.exists() && HCPerfManager.getSoMd5().equalsIgnoreCase(g.b(file))) {
                            File file2 = new File(HCPerfManager.getSoPath());
                            file.renameTo(file2);
                            ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFile(BaseApplication.getContext(), file2);
                            HardCoderManager.this.state = 6;
                        } else {
                            QLog.d(HardCoderManager.TAG, 1, "check md5 fail");
                            file.delete();
                            HardCoderManager.this.state = 5;
                        }
                        File file3 = new File(HCPerfManager.SO_PATH_OLD);
                        if (file3.exists()) {
                            file3.delete();
                        }
                        QLog.d(HardCoderManager.TAG, 1, "downloadResult = " + downloadData + ", state = " + HardCoderManager.this.state);
                    }
                }, 128, null, false);
            }
        }
    }

    public void stop(int i3) {
        stop(i3, false);
    }
}
