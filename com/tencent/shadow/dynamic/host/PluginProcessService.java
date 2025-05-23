package com.tencent.shadow.dynamic.host;

import android.app.Application;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.shadow.core.common.InstalledApk;
import com.tencent.shadow.dynamic.host.BasePluginProcessService;
import java.io.File;

/* loaded from: classes25.dex */
public class PluginProcessService extends BasePluginProcessService {
    static final BasePluginProcessService.ActivityHolder sActivityHolder = new BasePluginProcessService.ActivityHolder();
    private PluginLoaderImpl mPluginLoader;
    private final PpsBinder mPpsControllerBinder = new PpsBinder(this);
    private boolean mRuntimeLoaded = false;
    private String mUuid = "";
    private UuidManager mUuidManager;

    private void checkUuidManagerNotNull() throws FailedException {
        if (this.mUuidManager != null) {
        } else {
            throw new FailedException(4, "mUuidManager == null");
        }
    }

    public static Application.ActivityLifecycleCallbacks getActivityHolder() {
        return sActivityHolder;
    }

    private void setUuid(String str) throws FailedException {
        if (this.mUuid.isEmpty()) {
            this.mUuid = str;
            return;
        }
        if (this.mUuid.equals(str)) {
            return;
        }
        throw new FailedException(6, "\u5df2\u8bbe\u7f6e\u8fc7uuid==" + this.mUuid + "\u8bd5\u56fe\u8bbe\u7f6euuid==" + str);
    }

    public static PpsController wrapBinder(IBinder iBinder) {
        return new PpsController(iBinder);
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
    public IBinder getPluginLoader() {
        return this.mPluginLoader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PpsStatus getPpsStatus() {
        boolean z16;
        String str = this.mUuid;
        boolean z17 = this.mRuntimeLoaded;
        boolean z18 = true;
        if (this.mPluginLoader != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.mUuidManager == null) {
            z18 = false;
        }
        return new PpsStatus(str, z17, z16, z18);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadPluginLoader(String str) throws FailedException {
        if (this.mLogger.isInfoEnabled()) {
            this.mLogger.info("loadPluginLoader uuid:" + str + " mPluginLoader:" + this.mPluginLoader);
        }
        checkUuidManagerNotNull();
        setUuid(str);
        if (this.mPluginLoader == null) {
            try {
                try {
                    InstalledApk pluginLoader = this.mUuidManager.getPluginLoader(str);
                    if (this.mLogger.isInfoEnabled()) {
                        this.mLogger.info("\u53d6\u51fauuid==" + str + "\u7684Loader apk:" + pluginLoader.apkFilePath);
                    }
                    File file = new File(pluginLoader.apkFilePath);
                    if (file.exists()) {
                        PluginLoaderImpl load = new LoaderImplLoader().load(pluginLoader, str, getApplicationContext());
                        load.setUuidManager(this.mUuidManager);
                        this.mPluginLoader = load;
                        return;
                    } else {
                        throw new FailedException(3, file.getAbsolutePath() + ImageTaskConst.ErrorDesciption.IMAGE_TASK_NO_SUCH_FILE_DESC);
                    }
                } catch (FailedException e16) {
                    throw e16;
                } catch (RuntimeException e17) {
                    if (this.mLogger.isErrorEnabled()) {
                        this.mLogger.error("loadPluginLoader\u53d1\u751fRuntimeException", (Throwable) e17);
                    }
                    throw new FailedException(e17);
                } catch (Exception e18) {
                    e = e18;
                    if (this.mLogger.isErrorEnabled()) {
                        this.mLogger.error("loadPluginLoader\u53d1\u751fException", e);
                    }
                    if (e.getCause() != null) {
                        e = e.getCause();
                    }
                    throw new FailedException(2, "\u52a0\u8f7d\u52a8\u6001\u5b9e\u73b0\u5931\u8d25 cause\uff1a" + e.getMessage());
                }
            } catch (RemoteException e19) {
                if (this.mLogger.isErrorEnabled()) {
                    this.mLogger.error("\u83b7\u53d6Loader Apk\u5931\u8d25", (Throwable) e19);
                }
                throw new FailedException(5, e19.getMessage());
            } catch (NotFoundException e26) {
                throw new FailedException(3, "uuid==" + str + "\u7684PluginLoader\u6ca1\u6709\u627e\u5230\u3002cause:" + e26.getMessage());
            }
        }
        throw new FailedException(8, "\u91cd\u590d\u8c03\u7528loadPluginLoader");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadRuntime(String str) throws FailedException {
        checkUuidManagerNotNull();
        setUuid(str);
        if (!this.mRuntimeLoaded) {
            try {
                if (this.mLogger.isInfoEnabled()) {
                    this.mLogger.info("loadRuntime uuid:" + str);
                }
                try {
                    InstalledApk runtime = this.mUuidManager.getRuntime(str);
                    InstalledApk installedApk = new InstalledApk(runtime.apkFilePath, runtime.oDexPath, runtime.libraryPath);
                    if (DynamicRuntime.loadRuntime(installedApk)) {
                        DynamicRuntime.saveLastRuntimeInfo(this, installedApk);
                    }
                    this.mRuntimeLoaded = true;
                    return;
                } catch (RemoteException e16) {
                    throw new FailedException(5, e16.getMessage());
                } catch (NotFoundException e17) {
                    throw new FailedException(3, "uuid==" + str + "\u7684Runtime\u6ca1\u6709\u627e\u5230\u3002cause:" + e17.getMessage());
                }
            } catch (RuntimeException e18) {
                if (this.mLogger.isErrorEnabled()) {
                    this.mLogger.error("loadRuntime\u53d1\u751fRuntimeException", (Throwable) e18);
                }
                throw new FailedException(e18);
            }
        }
        throw new FailedException(7, "\u91cd\u590d\u8c03\u7528loadRuntime");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.mLogger.isInfoEnabled()) {
            this.mLogger.info("onBind:" + this);
        }
        return this.mPpsControllerBinder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUuidManager(UuidManager uuidManager) {
        if (this.mLogger.isInfoEnabled()) {
            this.mLogger.info("setUuidManager uuidManager==" + uuidManager);
        }
        this.mUuidManager = uuidManager;
        if (this.mPluginLoader != null) {
            if (this.mLogger.isInfoEnabled()) {
                this.mLogger.info("\u66f4\u65b0mPluginLoader\u7684uuidManager");
            }
            this.mPluginLoader.setUuidManager(uuidManager);
        }
    }
}
