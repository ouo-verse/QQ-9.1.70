package com.tencent.aekit.api.standard;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.AEProfiler;
import com.tencent.camerasdk.avreport.AVReportCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.ttpic.AEBaseConfig;
import com.tencent.ttpic.baseutils.device.DeviceAttrs;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.device.DeviceUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.util.MustRunOnGLThread;
import com.tencent.ttpic.util.SecurityUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AEModule {
    static IPatchRedirector $redirector_ = null;
    private static final String[] AEKIT_FORMER_VERSION;
    private static final String AEKIT_VERSION = "2.0.0";
    private static final String AEKIT_VERSION_FILE = "aekit_meta.txt";
    public static final String DEFAULT_LICENSE_NAME = "com_tencent_2118.lic";
    private static final String DEFAULT_RESOURCE_DIR;
    private static final String TAG = "AEKitModule";
    private static String aekitVersion;
    private static boolean debugMode;
    private static boolean enableDefaultBasic3;
    private static boolean enableReducedMeidaLibrary;
    private static String mFilamentPath;
    private static String mLicense;
    private static int mLicenseInitType;
    private static String mLutDirPath;
    private static String mModelPath;
    private static String mPagPath;
    private static String mSoPath;
    private static Context sContext;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12048);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        AEKIT_FORMER_VERSION = new String[]{"1.0.0", "1.1.0", "1.2.0", "1.3.0", "1.4.0", "1.5.0", "1.6.0", "1.7.0", "1.7.1", "1.7.2", "1.7.3", "1.7.4", "1.7.5", "1.7.6", "1.7.7", "1.7.8", "1.7.9", "1.8.0", "1.8.1", "1.8.2", "1.8.4", "1.8.5", "1.8.7", AEKIT_VERSION};
        DEFAULT_RESOURCE_DIR = "tencent" + File.separator + "aekit";
        aekitVersion = null;
        debugMode = false;
        mModelPath = null;
        mSoPath = null;
        mFilamentPath = null;
        mPagPath = null;
        mLutDirPath = null;
        enableDefaultBasic3 = false;
        enableReducedMeidaLibrary = false;
    }

    public AEModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @MustRunOnGLThread
    public static void clear() {
        ShaderManager.getInstance().clear();
    }

    public static Context getContext() {
        return sContext;
    }

    public static String[] getFormerVersions() {
        return AEKIT_FORMER_VERSION;
    }

    public static String getLicense() {
        return mLicense;
    }

    public static int getLicenseInitType() {
        return mLicenseInitType;
    }

    public static String getLutDirPath() {
        return mLutDirPath;
    }

    public static String getResouceRoot() {
        if (getContext() == null) {
            return null;
        }
        try {
            return getContext().getExternalFilesDir(null).getAbsolutePath() + File.separator + DEFAULT_RESOURCE_DIR;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Deprecated
    public static String getVersion(Context context) {
        if (aekitVersion == null) {
            String loadAssetsString = FileUtils.loadAssetsString(context, AEKIT_VERSION_FILE);
            if (TextUtils.isEmpty(loadAssetsString)) {
                aekitVersion = AEKIT_VERSION;
            } else {
                aekitVersion = loadAssetsString.split("\n")[0];
            }
        }
        return aekitVersion;
    }

    private static boolean initImpl(Context context, AEModuleConfig aEModuleConfig, boolean z16) {
        mLutDirPath = aEModuleConfig.getLutDir();
        mModelPath = aEModuleConfig.getModelDir();
        enableDefaultBasic3 = aEModuleConfig.isEnableDefaultBasic3();
        mSoPath = aEModuleConfig.getSoDir();
        mLicense = aEModuleConfig.getLicense();
        mLicenseInitType = aEModuleConfig.getLicenseInitType();
        enableReducedMeidaLibrary = aEModuleConfig.isEnableReducedMeidaLibrary();
        mFilamentPath = aEModuleConfig.getFilamentDir();
        mPagPath = aEModuleConfig.getPagDir();
        aEModuleConfig.isFramebufferFetchEnable();
        boolean isEnableResourceCheck = aEModuleConfig.isEnableResourceCheck();
        boolean isEnableDataReport = aEModuleConfig.isEnableDataReport();
        boolean isEnableProfiler = aEModuleConfig.isEnableProfiler();
        boolean isEnableSoLoadCheck = aEModuleConfig.isEnableSoLoadCheck();
        aEModuleConfig.isCacheBeautyBitmaps();
        setContext(context);
        AEBaseConfig.setContext(context);
        boolean isDebugMode = aEModuleConfig.isDebugMode();
        debugMode = isDebugMode;
        AEOpenRenderConfig.setEnableLog(isDebugMode);
        LogUtils.setEnable(debugMode);
        AEOpenRenderConfig.setEnableStrictMode(aEModuleConfig.isStrictMode());
        if (!TextUtils.isEmpty(mLutDirPath) && !FileUtils.isDirectoryWritable(mLutDirPath)) {
            mLutDirPath = null;
        }
        LogUtils.d("AEModule", "ModelDir config.modelDir = " + mModelPath);
        if (!TextUtils.isEmpty(mModelPath) && !FileUtils.isDirectoryWritable(mModelPath)) {
            LogUtils.d("AEModule", "ModelDir mModelPath = " + mModelPath + " and Directory is not Writable. reset");
            mModelPath = null;
        }
        if (!TextUtils.isEmpty(mSoPath) && !FileUtils.isDirectoryWritable(mSoPath)) {
            LogUtils.d("AEModule", "ModelDir mSoPath = " + mSoPath + " and Directory is not Writable. reset");
            mSoPath = null;
        }
        LogUtils.d("AEModule", "ModelDir soAndModelDir = " + mModelPath);
        FeatureManager.setModelDir(mModelPath);
        FeatureManager.setSoDir(mSoPath);
        FeatureManager.setFilamentDir(mFilamentPath);
        FeatureManager.setPagDir(mPagPath);
        FeatureManager.enableResourceCheck(isEnableResourceCheck);
        FeatureManager.createNoMedia();
        FeatureManager.enableSoLoadCheck(isEnableSoLoadCheck);
        AVReportCenter.getInstance().setEnable(isEnableDataReport);
        AVReportCenter.getInstance().init(getContext());
        VideoFilterBase.setDumpFilterParams(aEModuleConfig.isEnableDumpFilterParams());
        AEProfiler.getInstance().setEnable(isEnableProfiler);
        FeatureManager.Features.YT_COMMON.setAuthMode(aEModuleConfig.getAuthMode());
        return loadSoImpl(z16, aEModuleConfig.getIsLoadSo());
    }

    public static boolean initialize(Context context, AEModuleConfig aEModuleConfig) {
        return initImpl(context, aEModuleConfig, true);
    }

    public static boolean isAeKitSupportVersion() {
        if (DeviceInstance.getSDKVersion() >= 23) {
            return true;
        }
        return false;
    }

    public static boolean isDebug() {
        return debugMode;
    }

    public static boolean isEnableDefaultBasic3() {
        return enableDefaultBasic3;
    }

    public static boolean isEnableReducedMeidaLibrary() {
        return enableReducedMeidaLibrary;
    }

    public static boolean isStrictMode() {
        return AEOpenRenderConfig.isStrictMode();
    }

    private static boolean loadBasicFeatures(boolean z16) {
        if (!isAeKitSupportVersion()) {
            return false;
        }
        boolean z17 = true;
        if (z16) {
            z17 = true & FeatureManager.Features.YT_COMMON.init();
        }
        return FeatureManager.Features.PTU_TOOLS.init() & z17 & FeatureManager.Features.PTU_ALGO.init() & FeatureManager.Features.LIGHT_SDK.init();
    }

    private static boolean loadSoImpl(boolean z16, boolean z17) {
        if (z17) {
            if (!loadBasicFeatures(z16)) {
                return false;
            }
            updateDeviceAttr(false);
            return true;
        }
        return true;
    }

    public static void setContext(Context context) {
        if (context == null) {
            return;
        }
        sContext = context;
    }

    public static void updateDeviceAttr(boolean z16) {
        LogUtils.d(TAG, "updateDeviceAttr foceUpdate = " + z16);
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable(z16) { // from class: com.tencent.aekit.api.standard.AEModule.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean val$forceUpdate;

            {
                this.val$forceUpdate = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, z16);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Context context = AEModule.getContext();
                try {
                    try {
                        DeviceAttrs.getInstance().init(context.getApplicationContext(), SecurityUtils.getSignMD5(context));
                        if (this.val$forceUpdate) {
                            DeviceAttrs.getInstance().update(FileUtils.genSeperateFileDir(FeatureManager.getSoDir()) + "phone_attrs_config.dat", new DeviceAttrs.UpdateListener() { // from class: com.tencent.aekit.api.standard.AEModule.1.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                    }
                                }

                                @Override // com.tencent.ttpic.baseutils.device.DeviceAttrs.UpdateListener
                                public void onFailed(String str) {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) str);
                                        return;
                                    }
                                    AEOpenRenderConfig.checkStrictMode(false, "phone_attrs_config.dat decrypt faild.");
                                    LogUtils.w(AEModule.TAG, "[DeviceAttrs update][onFailed] errorMsg = " + str);
                                }

                                @Override // com.tencent.ttpic.baseutils.device.DeviceAttrs.UpdateListener
                                public void onSuccess(String str) {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str);
                                        return;
                                    }
                                    LogUtils.e(AEModule.TAG, "updateDeviceInfo socClass = " + DeviceUtils.getDeviceSocClass(AEModule.getContext()).desc);
                                    LogUtils.d(AEModule.TAG, "[DeviceAttrs update][onSuccess] okMsg = " + str);
                                }
                            });
                        }
                    } catch (Error e16) {
                        e16.printStackTrace();
                        LogUtils.e(AEModule.TAG, "initPhoneAttrs\uff1a" + e16.getMessage());
                    }
                } finally {
                    GpuScopeAttrs.getInstance().init(context, DeviceInstance.getInstance().getDeviceName(), FeatureManager.getResourceDir());
                }
            }
        });
    }

    public static boolean initialize(Context context, AEModuleConfig aEModuleConfig, boolean z16) {
        return initImpl(context, aEModuleConfig, z16);
    }

    @Deprecated
    public static String getVersion() {
        if (!TextUtils.isEmpty(aekitVersion)) {
            return aekitVersion;
        }
        Context context = sContext;
        if (context == null) {
            aekitVersion = AEKIT_VERSION;
        } else {
            String loadAssetsString = FileUtils.loadAssetsString(context, AEKIT_VERSION_FILE);
            if (TextUtils.isEmpty(loadAssetsString)) {
                aekitVersion = AEKIT_VERSION;
            } else {
                aekitVersion = loadAssetsString.split("\n")[0];
            }
        }
        return aekitVersion;
    }
}
