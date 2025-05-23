package com.tencent.shadow.dynamic.host;

import android.app.Application;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.shadow.core.common.InstalledApk;
import com.tencent.shadow.dynamic.host.BasePluginProcessService;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes25.dex */
public class MultiLoaderPluginProcessService extends BasePluginProcessService {
    static final BasePluginProcessService.ActivityHolder sActivityHolder = new BasePluginProcessService.ActivityHolder();
    private final MultiLoaderPpsBinder mPpsControllerBinder = new MultiLoaderPpsBinder(this);
    private HashMap<String, String> mUuidMap = new HashMap<>();
    private HashMap<String, UuidManager> mUuidManagerMap = new HashMap<>();
    private HashMap<String, PluginLoaderImpl> mPluginLoaderMap = new HashMap<>();
    private HashMap<String, Boolean> mRuntimeLoadedMap = new HashMap<>();

    private void addUuidForPlugin(String str, String str2) throws FailedException {
        String str3 = this.mUuidMap.get(str);
        if (str3 != null && !TextUtils.equals(str2, str3)) {
            throw new FailedException(6, "Plugin=" + str + "\u5df2\u8bbe\u7f6e\u8fc7uuid==" + str3 + ", \u8bd5\u56fe\u8bbe\u7f6euuid==" + str2);
        }
        if (str3 == null) {
            this.mUuidMap.put(str, str2);
        }
    }

    private UuidManager checkUuidManagerNotNull(String str) throws FailedException {
        UuidManager uuidManager = this.mUuidManagerMap.get(str);
        if (uuidManager != null) {
            return uuidManager;
        }
        throw new FailedException(4, "mUuidManager == null");
    }

    public static Application.ActivityLifecycleCallbacks getActivityHolder() {
        return sActivityHolder;
    }

    private boolean isRuntimeLoaded(String str) {
        Boolean bool = this.mRuntimeLoadedMap.get(str);
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        return false;
    }

    private void markRuntimeLoaded(String str) {
        this.mRuntimeLoadedMap.put(str, Boolean.TRUE);
    }

    public static MultiLoaderPpsController wrapBinder(IBinder iBinder) {
        return new MultiLoaderPpsController(iBinder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void exit() {
        if (this.mLogger.isInfoEnabled()) {
            this.mLogger.info("exit ");
        }
        sActivityHolder.finishAll();
        System.exit(0);
        try {
            LockMethodProxy.wait(this);
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized IBinder getPluginLoaderForPlugin(String str) {
        return this.mPluginLoaderMap.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized PpsStatus getPpsStatusForPlugin(String str) {
        String str2;
        boolean isRuntimeLoaded;
        boolean z16;
        boolean z17;
        str2 = this.mUuidMap.get(str);
        isRuntimeLoaded = isRuntimeLoaded(str);
        z16 = true;
        if (this.mPluginLoaderMap.get(str) != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (this.mUuidManagerMap.get(str) == null) {
            z16 = false;
        }
        return new PpsStatus(str2, isRuntimeLoaded, z17, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void loadPluginLoaderForPlugin(String str, String str2) throws FailedException {
        String str3 = "pluginKey=" + str + "|uuid=" + str2;
        if (this.mLogger.isInfoEnabled()) {
            this.mLogger.info("loadPluginLoader:" + str3);
        }
        UuidManager checkUuidManagerNotNull = checkUuidManagerNotNull(str);
        addUuidForPlugin(str, str2);
        if (this.mPluginLoaderMap.get(str) == null) {
            try {
                try {
                    try {
                        try {
                            InstalledApk pluginLoader = checkUuidManagerNotNull.getPluginLoader(str2);
                            if (this.mLogger.isInfoEnabled()) {
                                this.mLogger.info("\u53d6\u51fa" + str3 + "\u7684Loader apk:" + pluginLoader.apkFilePath);
                            }
                            File file = new File(pluginLoader.apkFilePath);
                            if (file.exists()) {
                                PluginLoaderImpl load = new LoaderImplLoader().load(pluginLoader, str2, getApplicationContext());
                                load.setUuidManager(checkUuidManagerNotNull);
                                this.mPluginLoaderMap.put(str, load);
                            } else {
                                throw new FailedException(3, file.getAbsolutePath() + ImageTaskConst.ErrorDesciption.IMAGE_TASK_NO_SUCH_FILE_DESC);
                            }
                        } catch (RemoteException e16) {
                            if (this.mLogger.isErrorEnabled()) {
                                this.mLogger.error("\u83b7\u53d6Loader Apk\u5931\u8d25", (Throwable) e16);
                            }
                            throw new FailedException(5, e16.getMessage());
                        } catch (NotFoundException e17) {
                            throw new FailedException(3, str3 + "\u7684PluginLoader\u6ca1\u6709\u627e\u5230\u3002cause:" + e17.getMessage());
                        }
                    } catch (FailedException e18) {
                        throw e18;
                    }
                } catch (Exception e19) {
                    e = e19;
                    if (this.mLogger.isErrorEnabled()) {
                        this.mLogger.error("loadPluginLoader\u53d1\u751fException", e);
                    }
                    if (e.getCause() != null) {
                        e = e.getCause();
                    }
                    throw new FailedException(2, "\u52a0\u8f7d\u52a8\u6001\u5b9e\u73b0\u5931\u8d25 cause\uff1a" + e.getMessage());
                }
            } catch (RuntimeException e26) {
                if (this.mLogger.isErrorEnabled()) {
                    this.mLogger.error("loadPluginLoader\u53d1\u751fRuntimeException", (Throwable) e26);
                }
                throw new FailedException(e26);
            }
        } else {
            throw new FailedException(8, "\u91cd\u590d\u8c03\u7528loadPluginLoader");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void loadRuntimeForPlugin(String str, String str2) throws FailedException {
        String str3 = "pluginKey=" + str + "|uuid=" + str2;
        if (this.mLogger.isInfoEnabled()) {
            this.mLogger.info("loadRuntimeForPlugin:" + str3);
        }
        UuidManager checkUuidManagerNotNull = checkUuidManagerNotNull(str);
        addUuidForPlugin(str, str2);
        try {
            if (!isRuntimeLoaded(str)) {
                try {
                    InstalledApk runtime = checkUuidManagerNotNull.getRuntime(str2);
                    InstalledApk installedApk = new InstalledApk(runtime.apkFilePath, runtime.oDexPath, runtime.libraryPath);
                    MultiDynamicContainer.loadContainerApk(str, installedApk);
                    markRuntimeLoaded(str);
                    DynamicRuntime.saveLastRuntimeInfo(getApplicationContext(), installedApk);
                } catch (RemoteException e16) {
                    Log.i("PluginProcessService", "uuidManager.getRuntime new FailedException");
                    throw new FailedException(5, e16.getMessage());
                } catch (NotFoundException e17) {
                    Log.i("PluginProcessService", "uuidManager.getRuntime new NotFoundException");
                    throw new FailedException(3, "pluginKey=" + str + ", uuid=" + str2 + "\u7684Runtime\u6ca1\u6709\u627e\u5230\u3002cause:" + e17.getMessage());
                }
            } else {
                throw new FailedException(7, "\u91cd\u590d\u8c03\u7528loadRuntime," + str3);
            }
        } catch (RuntimeException e18) {
            if (this.mLogger.isErrorEnabled()) {
                this.mLogger.error("loadRuntimeForPlugin\u53d1\u751fRuntimeException", (Throwable) e18);
            }
            throw new FailedException(e18);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.mLogger.isInfoEnabled()) {
            this.mLogger.info("onBind:" + this);
        }
        return this.mPpsControllerBinder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void setUuidManagerForPlugin(String str, UuidManager uuidManager) {
        if (this.mLogger.isInfoEnabled()) {
            this.mLogger.info("setUuidManagerForPlugin pluginKey=" + str + ", uuidManager==" + uuidManager);
        }
        this.mUuidManagerMap.put(str, uuidManager);
        PluginLoaderImpl pluginLoaderImpl = this.mPluginLoaderMap.get(str);
        if (pluginLoaderImpl != null) {
            if (this.mLogger.isInfoEnabled()) {
                this.mLogger.info("\u66f4\u65b0PluginLoader\u7684uuidManager");
            }
            pluginLoaderImpl.setUuidManager(uuidManager);
        }
    }
}
