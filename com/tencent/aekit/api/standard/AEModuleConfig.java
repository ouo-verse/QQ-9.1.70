package com.tencent.aekit.api.standard;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.light.LightEngine;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AEModuleConfig {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AEModuleConfig";
    private int authMode;
    private boolean cacheBeautyBitmaps;
    private boolean debugMode;
    private boolean enableDataReport;
    private boolean enableDefaultBasic3;
    private boolean enableDumpFilterParams;
    private boolean enableProfiler;
    private boolean enableReducedMeidaLibrary;
    private boolean enableResourceCheck;
    private boolean enableSoLoadCheck;
    private String filamentDir;
    private boolean isFramebufferFetchEnable;
    private boolean isLoadSo;
    private String license;
    private int licenseInitType;
    private String lutDir;
    private String modelDir;
    private String pagDir;
    private LightEngine.SDKServiceCallback serviceCallback;
    private String soDir;
    private boolean strictMode;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private int authMode;
        private boolean cacheBeautyBitmaps;
        private boolean debugMode;
        private boolean enableDataReport;
        private boolean enableDefaultBasic3;
        private boolean enableDumpFilterParams;
        private boolean enableProfiler;
        private boolean enableReducedMeidaLibrary;
        private boolean enableResourceCheck;
        private boolean enableSoLoadCheck;
        private String filamentDir;
        private boolean isFramebufferFetchEnable;
        private boolean isLoadSo;
        private String license;
        private int licenseInitType;
        private String lutDir;
        private String modelDir;
        private String pagDir;
        public LightEngine.SDKServiceCallback serviceCallback;
        private String soDir;
        private boolean strictMode;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.enableDefaultBasic3 = true;
            this.isLoadSo = true;
            this.isFramebufferFetchEnable = true;
            this.enableDataReport = true;
            this.enableProfiler = false;
            this.enableDumpFilterParams = false;
            this.enableReducedMeidaLibrary = false;
            this.enableSoLoadCheck = true;
            this.cacheBeautyBitmaps = true;
        }

        public AEModuleConfig build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return (AEModuleConfig) iPatchRedirector.redirect((short) 23, (Object) this);
            }
            return new AEModuleConfig(this, null);
        }

        public Builder setAuthMode(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (Builder) iPatchRedirector.redirect((short) 22, (Object) this, i3);
            }
            this.authMode = i3;
            return this;
        }

        public Builder setCacheBeautyBitmaps(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (Builder) iPatchRedirector.redirect((short) 21, (Object) this, z16);
            }
            this.cacheBeautyBitmaps = z16;
            return this;
        }

        public Builder setEnableDataReport(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (Builder) iPatchRedirector.redirect((short) 16, (Object) this, z16);
            }
            this.enableDataReport = z16;
            return this;
        }

        public Builder setEnableDebug(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (Builder) iPatchRedirector.redirect((short) 13, (Object) this, z16);
            }
            this.debugMode = z16;
            return this;
        }

        public Builder setEnableDefaultBasic3(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, z16);
            }
            this.enableDefaultBasic3 = z16;
            return this;
        }

        public Builder setEnableDumpFilterParams(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (Builder) iPatchRedirector.redirect((short) 18, (Object) this, z16);
            }
            this.enableDumpFilterParams = z16;
            return this;
        }

        public Builder setEnableProfiler(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (Builder) iPatchRedirector.redirect((short) 17, (Object) this, z16);
            }
            this.enableProfiler = z16;
            return this;
        }

        public Builder setEnableReducedMeidaLibrary(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (Builder) iPatchRedirector.redirect((short) 19, (Object) this, z16);
            }
            this.enableReducedMeidaLibrary = z16;
            return this;
        }

        public Builder setEnableResourceCheck(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (Builder) iPatchRedirector.redirect((short) 15, (Object) this, z16);
            }
            this.enableResourceCheck = z16;
            return this;
        }

        public Builder setEnableSoLoadCheck(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (Builder) iPatchRedirector.redirect((short) 20, (Object) this, z16);
            }
            this.enableSoLoadCheck = z16;
            return this;
        }

        public Builder setEnableStrcitMode(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (Builder) iPatchRedirector.redirect((short) 14, (Object) this, z16);
            }
            this.strictMode = z16;
            return this;
        }

        public Builder setFilamentDir(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            this.filamentDir = str;
            return this;
        }

        public Builder setFramebufferFetchEnable(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, z16);
            }
            this.isFramebufferFetchEnable = z16;
            return this;
        }

        public Builder setLicense(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? setLicense(str, 0) : (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }

        public Builder setLoadSo(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, z16);
            }
            this.isLoadSo = z16;
            return this;
        }

        public Builder setLutDir(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.lutDir = str;
            return this;
        }

        public Builder setModelDir(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.modelDir = str;
            return this;
        }

        public Builder setPagDir(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            this.pagDir = str;
            return this;
        }

        public Builder setServiceCallback(LightEngine.SDKServiceCallback sDKServiceCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) sDKServiceCallback);
            }
            this.serviceCallback = sDKServiceCallback;
            return this;
        }

        public Builder setSoDir(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.soDir = str;
            return this;
        }

        public Builder setLicense(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3);
            }
            this.license = str;
            this.licenseInitType = i3;
            return this;
        }
    }

    /* synthetic */ AEModuleConfig(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
            return;
        }
        iPatchRedirector.redirect((short) 23, (Object) this, (Object) builder, (Object) anonymousClass1);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getAuthMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.authMode;
    }

    public String getFilamentDir() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.filamentDir;
    }

    public boolean getIsLoadSo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isLoadSo;
    }

    public String getLicense() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.license;
    }

    public int getLicenseInitType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.licenseInitType;
    }

    public String getLutDir() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.lutDir;
    }

    public String getModelDir() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.modelDir;
    }

    public String getPagDir() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.pagDir;
    }

    public LightEngine.SDKServiceCallback getServiceCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LightEngine.SDKServiceCallback) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.serviceCallback;
    }

    public String getSoDir() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.soDir;
    }

    public boolean isCacheBeautyBitmaps() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.cacheBeautyBitmaps;
    }

    public boolean isDebugMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.debugMode;
    }

    public boolean isEnableDataReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.enableDataReport;
    }

    public boolean isEnableDefaultBasic3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.enableDefaultBasic3;
    }

    public boolean isEnableDumpFilterParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.enableDumpFilterParams;
    }

    public boolean isEnableProfiler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return this.enableProfiler;
    }

    public boolean isEnableReducedMeidaLibrary() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.enableReducedMeidaLibrary;
    }

    public boolean isEnableResourceCheck() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.enableResourceCheck;
    }

    public boolean isEnableSoLoadCheck() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return this.enableSoLoadCheck;
    }

    public boolean isFramebufferFetchEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.isFramebufferFetchEnable;
    }

    public boolean isStrictMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.strictMode;
    }

    AEModuleConfig(Builder builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) builder);
            return;
        }
        this.enableSoLoadCheck = true;
        this.cacheBeautyBitmaps = true;
        this.serviceCallback = new LightEngine.SDKServiceCallback() { // from class: com.tencent.aekit.api.standard.AEModuleConfig.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AEModuleConfig.this);
                }
            }

            @Override // org.light.LightEngine.SDKServiceCallback
            public void onServiceCreateError(String str, boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, str, Boolean.valueOf(z16));
                    return;
                }
                Log.e(AEModuleConfig.TAG, "onServiceCreateError: " + str);
            }

            @Override // org.light.LightEngine.SDKServiceRuntimeErrorCallback
            public void onServiceRuntimeError(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) str);
                    return;
                }
                Log.e(AEModuleConfig.TAG, "onServiceRuntimeError: " + str);
            }

            @Override // org.light.LightEngine.SDKServiceCallback
            public void onServiceStarted(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                } else {
                    Log.i(AEModuleConfig.TAG, "onServiceStarted: ");
                    LightLogUtil.init();
                }
            }
        };
        this.isLoadSo = builder.isLoadSo;
        this.lutDir = builder.lutDir;
        this.modelDir = builder.modelDir;
        this.enableDefaultBasic3 = builder.enableDefaultBasic3;
        this.soDir = builder.soDir;
        this.license = builder.license;
        this.licenseInitType = builder.licenseInitType;
        this.isFramebufferFetchEnable = builder.isFramebufferFetchEnable;
        this.debugMode = builder.debugMode;
        this.strictMode = builder.strictMode;
        this.enableResourceCheck = builder.enableResourceCheck;
        this.enableDataReport = builder.enableDataReport;
        this.enableProfiler = builder.enableProfiler;
        this.enableDumpFilterParams = builder.enableDumpFilterParams;
        this.enableReducedMeidaLibrary = builder.enableReducedMeidaLibrary;
        this.authMode = builder.authMode;
        this.enableSoLoadCheck = builder.enableSoLoadCheck;
        this.cacheBeautyBitmaps = builder.cacheBeautyBitmaps;
        this.serviceCallback = builder.serviceCallback;
        this.filamentDir = builder.filamentDir;
        this.pagDir = builder.pagDir;
    }
}
