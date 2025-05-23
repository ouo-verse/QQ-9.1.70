package cooperation.qzone.networkedmodule;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.ProcessUtils;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QzoneModuleManager {
    private static final int DISABLE_MODULE = 1;
    private static final int ENABLE_MODULE = 0;
    private static final String TAG = "QzoneModuleManager";
    private static volatile QzoneModuleManager sModuleManager;
    private Map<String, Boolean> mModueLoadState = new ConcurrentHashMap();
    public volatile boolean hasLoadNewMapSDK = false;
    public volatile boolean hasLoadOldMapSDK = false;
    private volatile boolean hasSetVersionNum = false;
    private int mNextModuleIndex = 0;
    private volatile boolean mHasStartedUpdateTask = false;
    QzoneModuleDownloadManager mDownloadManager = new QzoneModuleDownloadManager(BaseApplicationImpl.getApplication());
    public Object mLock = new Object();

    QzoneModuleManager() {
    }

    public static QzoneModuleManager getInstance() {
        if (sModuleManager == null) {
            synchronized (TAG) {
                if (sModuleManager == null) {
                    sModuleManager = new QzoneModuleManager();
                }
            }
        }
        return sModuleManager;
    }

    private boolean securityCheck(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneModuleConst.QZONE_MODULE_DISABLE, 0) == 1) {
            QLog.e(TAG, 1, "loadModule error: networked module is disabled");
            return false;
        }
        if (!QzoneModuleCompat.isDeviceInBlackList()) {
            return QzoneModuleConst.isLoadAccordingToCrashCount(str);
        }
        QLog.w(TAG, 1, "loadModule error:device is in the blacklist.");
        return false;
    }

    public void abortDownloadModule(String str) {
        this.mDownloadManager.abortDownloadModule(str);
    }

    public void cancelDownloadModule(String str) {
        this.mDownloadManager.cancelDownloadModule(str);
    }

    public boolean checkIfNeedUpdate(String str) {
        if (!TextUtils.isEmpty(str)) {
            QzoneModuleRecord moduleRecord = QzoneModuleConfigManager.getInstance().getModuleRecord(str);
            if (moduleRecord != null) {
                if (moduleRecord.hasNewConfig() || !isModuleDownloaded(str)) {
                    return true;
                }
                QLog.i(TAG, 2, "checkIfNeedUpdate: " + str + ",no new configs");
                return false;
            }
            QLog.w(TAG, 2, "checkIfNeedUpdate: record is null," + str);
            return false;
        }
        throw new IllegalArgumentException("moduleId is null or empty.");
    }

    public boolean downloadModule(String str, ModuleDownloadListener moduleDownloadListener) {
        QzoneModuleRecord moduleRecord = QzoneModuleConfigManager.getInstance().getModuleRecord(str);
        if (moduleRecord == null) {
            return false;
        }
        return this.mDownloadManager.downloadModule(moduleRecord.getDownloadRecord(), moduleDownloadListener);
    }

    public String getModuleFilePath(String str) {
        QzoneModuleRecord moduleRecord = QzoneModuleConfigManager.getInstance().getModuleRecord(str);
        if (moduleRecord != null) {
            return QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), moduleRecord);
        }
        return "";
    }

    public boolean hasStartedUpdateTask() {
        return this.mHasStartedUpdateTask;
    }

    public boolean isModuleDownloaded(String str) {
        QzoneModuleRecord moduleRecord = QzoneModuleConfigManager.getInstance().getModuleRecord(str);
        if (moduleRecord == null) {
            return false;
        }
        File file = new File(QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), moduleRecord));
        if (!file.exists()) {
            return false;
        }
        long j3 = moduleRecord.mModuleFileLength;
        return j3 != 0 && j3 == file.length();
    }

    public synchronized boolean isModuleLoaded(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.mModueLoadState.get(str).booleanValue();
    }

    public boolean loadLibraryById(String str) {
        String moduleFilePath = getModuleFilePath(str);
        if (!TextUtils.isEmpty(moduleFilePath)) {
            try {
                System.load(moduleFilePath);
                return true;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "catch an exception:", th5);
            }
        }
        return false;
    }

    public boolean loadModule(String str, ClassLoader classLoader, boolean z16, boolean z17) {
        QzoneModuleRecord moduleRecord = QzoneModuleConfigManager.getInstance().getModuleRecord(str);
        if (moduleRecord == null) {
            QLog.e(TAG, 1, "loadModule error: can't find information about " + str + ",please ensure is do exist");
            return false;
        }
        if (!securityCheck(str)) {
            QLog.e(TAG, 1, "securityCheck: reject");
            return false;
        }
        if (z16) {
            return loadModule2QQClassLoader(moduleRecord);
        }
        return loadModule(moduleRecord, classLoader, z17);
    }

    public boolean loadModuleAsQQPatch(String str) {
        QzoneModuleRecord moduleRecord = QzoneModuleConfigManager.getInstance().getModuleRecord(str);
        if (moduleRecord == null) {
            QLog.e(TAG, 1, "loadModule error: can't find information about " + str + ",please ensure is do exist");
            return false;
        }
        if (!securityCheck(str)) {
            QLog.e(TAG, 1, "securityCheck: reject");
            return false;
        }
        return loadModule2QQClassLoader(moduleRecord);
    }

    public boolean loadModuleAsQzonePatch(String str, ClassLoader classLoader) {
        QzoneModuleRecord moduleRecord = QzoneModuleConfigManager.getInstance().getModuleRecord(str);
        if (moduleRecord == null) {
            QLog.e(TAG, 1, "loadModule error: can't find information about " + str + ",please ensure is do exist");
            return false;
        }
        if (!securityCheck(str)) {
            QLog.e(TAG, 1, "securityCheck: reject");
            return false;
        }
        return loadModule(moduleRecord, classLoader, true);
    }

    public void updateAllModules() {
        if (this.mHasStartedUpdateTask) {
            return;
        }
        this.mHasStartedUpdateTask = true;
        QLog.i(TAG, 1, "start to updateAllModules.");
        ModuleDownloadListenerAdapter moduleDownloadListenerAdapter = new ModuleDownloadListenerAdapter() { // from class: cooperation.qzone.networkedmodule.QzoneModuleManager.1
            private void updateNextModule() {
                List<String> list;
                if (!NetworkState.isWifiConn()) {
                    QLog.w(QzoneModuleManager.TAG, 1, "isWifiConn:false,so stop update.");
                    return;
                }
                QzoneModuleManager.this.mNextModuleIndex++;
                while (true) {
                    int i3 = QzoneModuleManager.this.mNextModuleIndex;
                    list = QzoneModuleConst.QZONE_MODULES_PREDOWNLOAD;
                    if (i3 >= list.size()) {
                        break;
                    }
                    String str = list.get(QzoneModuleManager.this.mNextModuleIndex);
                    if (QzoneModuleManager.this.checkIfNeedUpdate(str)) {
                        QzoneModuleManager.this.updateModule(str, this);
                        break;
                    } else {
                        QzoneModuleManager.this.mNextModuleIndex++;
                    }
                }
                if (QzoneModuleManager.this.mNextModuleIndex == list.size()) {
                    QLog.i(QzoneModuleManager.TAG, 1, "updateAllModules completed--totalModules:" + QzoneModuleManager.this.mNextModuleIndex);
                }
            }

            @Override // cooperation.qzone.networkedmodule.ModuleDownloadListenerAdapter, cooperation.qzone.networkedmodule.ModuleDownloadListener
            public void onDownloadCanceled(String str) {
                super.onDownloadCanceled(str);
                updateNextModule();
            }

            @Override // cooperation.qzone.networkedmodule.ModuleDownloadListenerAdapter, cooperation.qzone.networkedmodule.ModuleDownloadListener
            public void onDownloadFailed(String str) {
                super.onDownloadFailed(str);
                updateNextModule();
            }

            @Override // cooperation.qzone.networkedmodule.ModuleDownloadListenerAdapter, cooperation.qzone.networkedmodule.ModuleDownloadListener
            public void onDownloadSucceed(String str) {
                super.onDownloadSucceed(str);
                updateNextModule();
            }
        };
        while (true) {
            int i3 = this.mNextModuleIndex;
            List<String> list = QzoneModuleConst.QZONE_MODULES_PREDOWNLOAD;
            if (i3 >= list.size()) {
                return;
            }
            String str = list.get(this.mNextModuleIndex);
            if (checkIfNeedUpdate(str)) {
                updateModule(str, moduleDownloadListenerAdapter);
                return;
            }
            this.mNextModuleIndex++;
        }
    }

    public void updateModule(String str, ModuleDownloadListener moduleDownloadListener) {
        if (checkIfNeedUpdate(str)) {
            QLog.i(TAG, 1, "updateModule: " + str);
            downloadModule(str, moduleDownloadListener);
        }
    }

    boolean loadModule2QQClassLoader(QzoneModuleRecord qzoneModuleRecord) {
        if (qzoneModuleRecord == null) {
            QLog.e(TAG, 1, "record is null");
            return false;
        }
        String str = qzoneModuleRecord.mModuleId;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (ProcessUtils.isQQ(ProcessUtils.getCurProcessName(application))) {
            QLog.e(TAG, 1, "-------try to load module into MainClassLoader in QQ process.This shouldn't happen,please ensure this is really what you want...");
            return false;
        }
        if (this.mModueLoadState.containsKey(str)) {
            return this.mModueLoadState.get(str).booleanValue();
        }
        String moduleSavePath = QzoneModuleConst.getModuleSavePath(application, qzoneModuleRecord);
        synchronized (this.mLock) {
            if (this.mModueLoadState.containsKey(str)) {
                return this.mModueLoadState.get(str).booleanValue();
            }
            boolean loadModuleDex2MainClassLoader = QzoneModuleLoader.loadModuleDex2MainClassLoader(moduleSavePath, application.getApplicationContext(), qzoneModuleRecord.mKeyClassName, qzoneModuleRecord);
            this.mModueLoadState.put(str, Boolean.valueOf(loadModuleDex2MainClassLoader));
            if (loadModuleDex2MainClassLoader && !this.hasSetVersionNum) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: cooperation.qzone.networkedmodule.QzoneModuleManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int qzonePatchTag = StatisticCollector.getQzonePatchTag();
                        QLog.i(QzoneModuleManager.TAG, 1, "current versionNum is:" + qzonePatchTag);
                        StatisticCollector.setQzonePatchTag(qzonePatchTag + 6000);
                        QzoneModuleManager.this.hasSetVersionNum = true;
                    }
                });
            }
            return loadModuleDex2MainClassLoader;
        }
    }

    boolean loadModule(QzoneModuleRecord qzoneModuleRecord, ClassLoader classLoader, boolean z16) {
        if (qzoneModuleRecord == null) {
            QLog.e(TAG, 1, "record is null");
            return false;
        }
        String str = qzoneModuleRecord.mModuleId;
        if (this.mModueLoadState.containsKey(str)) {
            return this.mModueLoadState.get(str).booleanValue();
        }
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        String moduleSavePath = QzoneModuleConst.getModuleSavePath(application, qzoneModuleRecord);
        synchronized (this.mLock) {
            if (this.mModueLoadState.containsKey(str)) {
                return this.mModueLoadState.get(str).booleanValue();
            }
            boolean loadModuleDex = QzoneModuleLoader.loadModuleDex(moduleSavePath, application.getApplicationContext(), classLoader, qzoneModuleRecord.mKeyClassName, qzoneModuleRecord, z16);
            this.mModueLoadState.put(str, Boolean.valueOf(loadModuleDex));
            return loadModuleDex;
        }
    }

    public boolean loadModule(File file) {
        if (!file.exists()) {
            QLog.e(TAG, 1, file.getAbsolutePath() + " is not exist.");
            return false;
        }
        String absolutePath = file.getAbsolutePath();
        String name = file.getName();
        if (this.mModueLoadState.containsKey(name)) {
            return this.mModueLoadState.get(name).booleanValue();
        }
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        QzoneModuleRecord qzoneModuleRecord = new QzoneModuleRecord(name, file.getName(), "", "", "", "", "", 0, 0L, null);
        synchronized (this.mLock) {
            if (this.mModueLoadState.containsKey(name)) {
                return this.mModueLoadState.get(name).booleanValue();
            }
            boolean loadModuleDex = QzoneModuleLoader.loadModuleDex(absolutePath, application.getApplicationContext(), getClass().getClassLoader(), qzoneModuleRecord.mKeyClassName, qzoneModuleRecord);
            this.mModueLoadState.put(name, Boolean.valueOf(loadModuleDex));
            return loadModuleDex;
        }
    }
}
