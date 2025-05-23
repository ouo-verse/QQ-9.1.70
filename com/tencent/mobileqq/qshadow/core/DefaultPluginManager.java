package com.tencent.mobileqq.qshadow.core;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qshadow.constant.QShadowConstant;
import com.tencent.mobileqq.qshadow.interfaces.IQShadowPluginManager;
import com.tencent.mobileqq.qshadow.utils.AssetUtil;
import com.tencent.mobileqq.qshadow.utils.FileUtil;
import com.tencent.mobileqq.qshadow.utils.PluginIdUtil;
import com.tencent.mobileqq.qshadow.utils.QShadowRepository;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.QShadowLoadInfo;
import com.tencent.shadow.dynamic.host.ShadowTag;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;
import nk2.a;

/* loaded from: classes17.dex */
public class DefaultPluginManager implements IQShadowPluginManager {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_RETRY_COUNT = 2;
    private static final String PLUGIN_MANAGER_APK_NAME = "qshadow-manager.apk";
    private Context mContext;
    private volatile DynamicPluginManager mDynamicPluginManager;
    private String mGroupId;
    private Logger mLogger;
    private final File mPluginManagerFile;
    private final String mPluginSdcardRootPath;
    private final String mPluginSdcardRootTempPath;
    private final File mPluginZipFile;
    private Executor mSinglePool;
    private int retryCount;

    public DefaultPluginManager(String str, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) context);
            return;
        }
        this.mLogger = LoggerFactory.getLogger(ShadowTag.class);
        this.mSinglePool = ProxyExecutors.newSingleThreadExecutor();
        this.retryCount = 0;
        this.mGroupId = PluginIdUtil.getGroupId(str);
        this.mContext = context;
        String str2 = "qshadow-" + this.mGroupId + ".zip";
        String pluginRootPath = QShadowConstant.getPluginRootPath(this.mContext, this.mGroupId);
        this.mPluginSdcardRootPath = pluginRootPath;
        this.mPluginSdcardRootTempPath = pluginRootPath + "-temp";
        this.mPluginManagerFile = new File(pluginRootPath, PLUGIN_MANAGER_APK_NAME);
        this.mPluginZipFile = new File(pluginRootPath, str2);
    }

    static /* synthetic */ int access$408(DefaultPluginManager defaultPluginManager) {
        int i3 = defaultPluginManager.retryCount;
        defaultPluginManager.retryCount = i3 + 1;
        return i3;
    }

    private boolean checkPluginFileExists(String str) {
        File file = new File(str, this.mPluginZipFile.getName());
        File file2 = new File(str, this.mPluginManagerFile.getName());
        File file3 = new File(str, "config.json");
        if (file.exists() && file.length() > 0 && file2.exists() && file2.length() > 0 && file3.exists() && file3.length() > 0) {
            return true;
        }
        return false;
    }

    private String getAssetConfigFilePath() {
        return QShadowConstant.getAssetRootPath(this.mGroupId) + File.separator + "config.json";
    }

    private long getFolderSize(File file) {
        File[] listFiles = file.listFiles();
        long j3 = 0;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    j3 += file2.length();
                }
            }
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initPluginManager() {
        this.mDynamicPluginManager = new DynamicPluginManager(new QShadowPmUpdater(this.mPluginManagerFile));
    }

    private void prepareFromAsset() {
        Context context = this.mContext;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(QShadowConstant.getAssetRootPath(this.mGroupId));
        String str = File.separator;
        sb5.append(str);
        sb5.append("config.json");
        AssetUtil.copyFilesFromAssets(context, sb5.toString(), this.mPluginSdcardRootPath);
        AssetUtil.copyFilesFromAssets(this.mContext, QShadowConstant.getAssetRootPath(this.mGroupId) + str + this.mPluginManagerFile.getName(), this.mPluginSdcardRootPath);
        AssetUtil.copyFilesFromAssets(this.mContext, QShadowConstant.getAssetRootPath(this.mGroupId) + str + this.mPluginZipFile.getName(), this.mPluginSdcardRootPath);
    }

    private void prepareFromFile(String str, String str2) throws IOException {
        for (File file : new File(str).listFiles()) {
            File file2 = new File(str2, file.getName());
            if (!file2.getParentFile().exists() && !file2.getParentFile().mkdirs()) {
                this.mLogger.warn("plugin_tag \u521b\u5efa\u76ee\u5f55\u5931\u8d25: " + file2.getParentFile());
            }
            if (FileUtil.moveFile(file2, file)) {
                this.mLogger.warn("plugin_tag File: " + file2.getAbsolutePath() + " move result: " + file2.exists() + ", size: " + file2.length() + ", lastModify: " + file2.lastModified());
            } else {
                throw new RuntimeException("plugin_tag \u63d2\u4ef6\u5347\u7ea7\u5305\u5b89\u88c5\u5931\u8d25: " + file.getAbsolutePath());
            }
        }
    }

    public void afterEnter(long j3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), bundle);
        }
    }

    public void beforeEnter(long j3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), bundle);
        }
    }

    public final void enter(Context context, long j3, Bundle bundle, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, Long.valueOf(j3), bundle, aVar);
            return;
        }
        if (this.mLogger.isWarnEnabled()) {
            this.mLogger.warn("enter " + this.mGroupId + " bundle " + bundle);
        }
        this.mSinglePool.execute(new Runnable(j3, bundle, context, aVar) { // from class: com.tencent.mobileqq.qshadow.core.DefaultPluginManager.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Bundle val$bundle;
            final /* synthetic */ Context val$context;
            final /* synthetic */ long val$fromId;
            final /* synthetic */ a val$listener;

            {
                this.val$fromId = j3;
                this.val$bundle = bundle;
                this.val$context = context;
                this.val$listener = aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, DefaultPluginManager.this, Long.valueOf(j3), bundle, context, aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                QShadowLoadInfo qShadowLoadInfo;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                synchronized (DefaultPluginManager.this) {
                    if (!DefaultPluginManager.this.isPluginInstalled()) {
                        if (DefaultPluginManager.this.mLogger.isWarnEnabled()) {
                            DefaultPluginManager.this.mLogger.warn("installPlugin " + DefaultPluginManager.this.mGroupId);
                        }
                        DefaultPluginManager.this.installPlugin();
                    } else if (!DefaultPluginManager.this.isPluginRunning()) {
                        if (DefaultPluginManager.this.mLogger.isWarnEnabled()) {
                            DefaultPluginManager.this.mLogger.warn("initPluginManager" + DefaultPluginManager.this.mGroupId);
                        }
                        DefaultPluginManager.this.initPluginManager();
                    }
                }
                DefaultPluginManager.this.beforeEnter(this.val$fromId, this.val$bundle);
                QShadowLoadInfo qShadowLoadInfo2 = null;
                try {
                    DefaultPluginManager.this.mDynamicPluginManager.enter(this.val$context, this.val$fromId, this.val$bundle, null);
                    DefaultPluginManager.this.retryCount = 0;
                    try {
                        qShadowLoadInfo = (QShadowLoadInfo) this.val$bundle.getParcelable(QShadowConstant.KEY_LOAD_INFO);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        qShadowLoadInfo = null;
                    }
                    DefaultPluginManager.this.mLogger.warn("load plugin " + DefaultPluginManager.this.mGroupId + " success info: " + qShadowLoadInfo);
                    a aVar2 = this.val$listener;
                    if (aVar2 != null) {
                        aVar2.a(true, qShadowLoadInfo);
                    }
                } catch (Exception e17) {
                    DefaultPluginManager.this.mLogger.warn("enter error retryCount: " + DefaultPluginManager.this.retryCount, (Throwable) e17);
                    DefaultPluginManager.this.release();
                    if (DefaultPluginManager.this.retryCount >= 2) {
                        DefaultPluginManager.this.retryCount = 0;
                        PluginRuntime.handleCrash(e17, DefaultPluginManager.this.mGroupId, DefaultPluginManager.this.mContext);
                        com.tencent.mobileqq.qshadow.utils.a.a(DefaultPluginManager.this.mContext, DefaultPluginManager.this.mGroupId, e17, 4001);
                        DefaultPluginManager.this.mLogger.error("exceed max retry count, throw exception!", (Throwable) e17);
                        try {
                            qShadowLoadInfo2 = (QShadowLoadInfo) this.val$bundle.getParcelable(QShadowConstant.KEY_LOAD_INFO);
                        } catch (Exception e18) {
                            e18.printStackTrace();
                        }
                        DefaultPluginManager.this.mLogger.warn("load plugin " + DefaultPluginManager.this.mGroupId + " failed info: " + qShadowLoadInfo2);
                        a aVar3 = this.val$listener;
                        if (aVar3 != null) {
                            aVar3.a(false, qShadowLoadInfo2);
                        }
                    } else {
                        try {
                            LockMethodProxy.sleep(1500L);
                        } catch (InterruptedException e19) {
                            e19.printStackTrace();
                        }
                        DefaultPluginManager.access$408(DefaultPluginManager.this);
                        DefaultPluginManager.this.enter(this.val$context, this.val$fromId, this.val$bundle, this.val$listener);
                    }
                }
                DefaultPluginManager.this.afterEnter(this.val$fromId, this.val$bundle);
            }
        });
    }

    public String getPluginZipPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mPluginZipFile.getAbsolutePath();
    }

    @Override // com.tencent.mobileqq.qshadow.interfaces.IQShadowPluginManager
    public synchronized boolean installPlugin() {
        String uuidFromFile;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            String installedPlugin = QShadowRepository.getInstalledPlugin(this.mContext, this.mGroupId, "");
            if (checkPluginFileExists(this.mPluginSdcardRootTempPath)) {
                uuidFromFile = QShadowRepository.getUuidFromFile(new File(this.mPluginSdcardRootTempPath, "config.json"));
                if (!uuidFromFile.equalsIgnoreCase(installedPlugin)) {
                    prepareFromFile(this.mPluginSdcardRootTempPath, this.mPluginSdcardRootPath);
                    z16 = true;
                } else {
                    this.mLogger.warn("plugin_tag Temp\u76ee\u5f55\u63d2\u4ef6\u4e0e\u5f53\u524d\u63d2\u4ef6\u7248\u672cuuid\u4e00\u81f4\uff0c\u65e0\u9700\u5b89\u88c5");
                    z16 = false;
                }
            } else if (AssetUtil.isFileExists(this.mContext, getAssetConfigFilePath())) {
                uuidFromFile = QShadowRepository.getUuidFromStream(this.mContext.getAssets().open(getAssetConfigFilePath()));
                if (!uuidFromFile.equalsIgnoreCase(installedPlugin)) {
                    prepareFromAsset();
                    z16 = true;
                } else {
                    this.mLogger.warn("plugin_tag Asset\u76ee\u5f55\u63d2\u4ef6\u4e0e\u5f53\u524d\u63d2\u4ef6\u7248\u672cuuid\u4e00\u81f4\uff0c\u65e0\u9700\u5b89\u88c5");
                    z16 = false;
                }
            } else {
                uuidFromFile = QShadowRepository.getUuidFromFile(new File(this.mPluginSdcardRootPath, "config.json"));
                if (uuidFromFile.equalsIgnoreCase(installedPlugin)) {
                    this.mLogger.warn("plugin_tag qshadow-plugins\u76ee\u5f55\u63d2\u4ef6\u4e0e\u5f53\u524d\u63d2\u4ef6\u7248\u672cuuid\u4e00\u81f4\uff0c\u65e0\u9700\u5b89\u88c5");
                    z16 = false;
                }
                z16 = true;
            }
            initPluginManager();
            Bundle bundle = new Bundle();
            bundle.putString("pluginZipPath", getPluginZipPath());
            this.mLogger.info("plugin_tag old plugin: " + installedPlugin + ", new plugin: " + uuidFromFile);
            if (z16 && !TextUtils.isEmpty(installedPlugin)) {
                this.mLogger.warn("plugin_tag delete old plugin uuid: " + installedPlugin);
                Bundle bundle2 = new Bundle();
                bundle2.putString(Constant.KEY_PLUGIN_UUID, installedPlugin);
                this.mDynamicPluginManager.enter(this.mContext, Constant.FROM_ID_UNINSTALL_PLUGIN, bundle2, null);
                initPluginManager();
            }
            this.mDynamicPluginManager.enter(this.mContext, 1001L, bundle, null);
            if (!TextUtils.isEmpty(uuidFromFile)) {
                QShadowRepository.saveInstalledPlugin(this.mContext, this.mGroupId, uuidFromFile);
            }
            this.mLogger.warn("plugin_tag install manager success!");
            return true;
        } catch (Exception e16) {
            this.mLogger.error("plugin_tag \u63d2\u4ef6\u5b89\u88c5\u5931\u8d25\uff1a", (Throwable) e16);
            QShadowRepository.deleteInstalledPlugin(this.mContext, this.mGroupId);
            PluginRuntime.handleCrash(e16, this.mGroupId, this.mContext);
            release();
            return false;
        }
    }

    @Override // com.tencent.mobileqq.qshadow.interfaces.IQShadowPluginManager
    public long installedPluginSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return getFolderSize(new File(this.mPluginSdcardRootPath)) + 0 + getFolderSize(new File(Constant.getPluginInstalledPath(this.mContext, this.mGroupId)));
    }

    @Override // com.tencent.mobileqq.qshadow.interfaces.IQShadowPluginManager
    public boolean isPluginInstalled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return !TextUtils.isEmpty(QShadowRepository.getInstalledPlugin(this.mContext, this.mGroupId, ""));
    }

    @Override // com.tencent.mobileqq.qshadow.interfaces.IQShadowPluginManager
    public boolean isPluginRunning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this.mDynamicPluginManager != null) {
            return true;
        }
        return false;
    }

    public final synchronized boolean preInstall(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) file)).booleanValue();
        }
        try {
            File file2 = new File(this.mPluginSdcardRootTempPath);
            if (file2.exists()) {
                FileUtil.cleanDirectory(file2);
            } else {
                file2.mkdirs();
            }
            FileUtil.unZipFolder(file.getAbsolutePath(), this.mPluginSdcardRootTempPath);
            boolean checkPluginFileExists = checkPluginFileExists(this.mPluginSdcardRootTempPath);
            if (!checkPluginFileExists) {
                this.mLogger.warn("plugin_tag \u63d2\u4ef6\u5305\u6587\u4ef6\u4e0d\u5408\u6cd5\uff0c\u538b\u7f29\u5305\u5e94\u5185\u5305\u542b config.json qshadow-manager.apk qshadow-pluginId.zip\u6587\u4ef6");
                FileUtil.cleanDirectory(file2);
            }
            return checkPluginFileExists;
        } catch (Exception e16) {
            this.mLogger.error("plugin_tag \u63d2\u4ef6\u5305\u5347\u7ea7\u5931\u8d25\uff1a", (Throwable) e16);
            PluginRuntime.handleCrash(e16, this.mGroupId, this.mContext);
            return false;
        }
    }

    public final void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.mSinglePool.execute(new Runnable() { // from class: com.tencent.mobileqq.qshadow.core.DefaultPluginManager.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DefaultPluginManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (DefaultPluginManager.this.mDynamicPluginManager != null) {
                        DefaultPluginManager.this.mDynamicPluginManager.release();
                        DefaultPluginManager.this.mDynamicPluginManager = null;
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qshadow.interfaces.IQShadowPluginManager
    public boolean uninstallPlugin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        File file = new File(this.mPluginSdcardRootPath);
        File file2 = new File(Constant.getPluginInstalledPath(this.mContext, this.mGroupId));
        this.mLogger.info("plugin_tag uninstall plugin " + file);
        try {
            QShadowRepository.deleteInstalledPlugin(this.mContext, this.mGroupId);
            FileUtil.cleanDirectory(file);
            FileUtil.cleanDirectory(file2);
            release();
            return true;
        } catch (Exception e16) {
            this.mLogger.error("plugin_tag uninstall plugin", (Throwable) e16);
            return false;
        }
    }
}
