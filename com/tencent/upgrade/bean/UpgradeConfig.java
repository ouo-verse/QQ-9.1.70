package com.tencent.upgrade.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.standard.net.IRNetwork;
import com.tencent.raft.standard.task.IRTask;
import com.tencent.upgrade.core.IBasePkgFile;
import com.tencent.upgrade.core.a;
import com.tencent.upgrade.download.b;
import java.util.HashMap;
import java.util.Map;
import pw4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UpgradeConfig {
    static IPatchRedirector $redirector_;
    private boolean allow32BitApkOn64BitDevice;
    private boolean allowDownloadOverMobile;
    private String appId;
    private String appKey;
    private long cacheExpireTime;
    private int currentBuildNo;
    private b customDownloader;
    private pw4.b customInstaller;
    private c customLogger;
    private Map<String, String> customParams;
    private boolean debugMode;
    private String devManufacturer;
    private String devModel;
    private a diffPkgHandler;
    private IBasePkgFile iBasePkgFileForDiffUpgrade;
    private Boolean internalInitMMKVForRDelivery;
    private IRNetwork irNetwork;
    private IRTask irTask;
    private Boolean isDebugPackage;
    private Boolean isEnableBuglyQQCrashReport;
    private Boolean isMainProcess;
    private Boolean isUseSPStorage;
    private boolean monitorLifecycle;
    private boolean printInternalLog;
    private String systemVersion;
    private boolean useShiplyChannel;
    private String userId;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class Builder {
        static IPatchRedirector $redirector_;
        private boolean allow32BitApkOn64BitDevice;
        private boolean allowDownloadOverMobile;
        private String appId;
        private String appKey;
        private long cacheExpireTime;
        private int currentBuildNo;
        private b customDownloader;
        private pw4.b customInstaller;
        private c customLogger;
        private Map<String, String> customParams;
        private boolean debugMode;
        private String devManufacturer;
        private String devModel;
        private a diffPkgHandler;
        private IBasePkgFile iBasePkgFileForDiffUpgrade;
        private Boolean internalInitMMKVForRDelivery;
        private IRNetwork irNetwork;
        private IRTask irTask;
        private Boolean isDebugPackage;
        private Boolean isEnableBuglyQQCrashReport;
        private Boolean isMainProcess;
        private Boolean isUseSPStorage;
        private boolean monitorLifecycle;
        private boolean printInternalLog;
        private String systemVersion;
        private boolean useShiplyChannel;
        private String userId;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.appId = "";
            this.appKey = "";
            this.userId = "";
            Boolean bool = Boolean.TRUE;
            this.internalInitMMKVForRDelivery = bool;
            this.isEnableBuglyQQCrashReport = bool;
            this.isUseSPStorage = bool;
            this.cacheExpireTime = -1L;
            this.allowDownloadOverMobile = true;
            this.allow32BitApkOn64BitDevice = false;
            this.printInternalLog = true;
            this.isMainProcess = null;
            this.monitorLifecycle = true;
            this.useShiplyChannel = true;
            this.customParams = new HashMap();
        }

        public Builder allow32BitApkOn64BitDevice(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (Builder) iPatchRedirector.redirect((short) 16, (Object) this, z16);
            }
            this.allow32BitApkOn64BitDevice = z16;
            return this;
        }

        public Builder allowDownloadOverMobile(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (Builder) iPatchRedirector.redirect((short) 14, (Object) this, z16);
            }
            this.allowDownloadOverMobile = z16;
            return this;
        }

        public Builder appId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.appId = str;
            return this;
        }

        public Builder appKey(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.appKey = str;
            return this;
        }

        public Builder basePkgFileForDiffUpgrade(IBasePkgFile iBasePkgFile) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                return (Builder) iPatchRedirector.redirect((short) 27, (Object) this, (Object) iBasePkgFile);
            }
            this.iBasePkgFileForDiffUpgrade = iBasePkgFile;
            return this;
        }

        public UpgradeConfig build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                return (UpgradeConfig) iPatchRedirector.redirect((short) 29, (Object) this);
            }
            return new UpgradeConfig(this, null);
        }

        public Builder cacheExpireTime(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (Builder) iPatchRedirector.redirect((short) 13, (Object) this, j3);
            }
            this.cacheExpireTime = j3;
            return this;
        }

        public Builder currentBuildNo(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, i3);
            }
            this.currentBuildNo = i3;
            return this;
        }

        public Builder customDownloader(b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (Builder) iPatchRedirector.redirect((short) 22, (Object) this, (Object) bVar);
            }
            this.customDownloader = bVar;
            return this;
        }

        public Builder customInstaller(pw4.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                return (Builder) iPatchRedirector.redirect((short) 28, (Object) this, (Object) bVar);
            }
            this.customInstaller = bVar;
            return this;
        }

        public Builder customLogger(c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return (Builder) iPatchRedirector.redirect((short) 23, (Object) this, (Object) cVar);
            }
            this.customLogger = cVar;
            return this;
        }

        public Builder customParams(Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (Builder) iPatchRedirector.redirect((short) 21, (Object) this, (Object) map);
            }
            this.customParams = map;
            return this;
        }

        public Builder debugMode(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (Builder) iPatchRedirector.redirect((short) 15, (Object) this, z16);
            }
            this.debugMode = z16;
            return this;
        }

        public Builder devManufacturer(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            this.devManufacturer = str;
            return this;
        }

        public Builder devModel(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.devModel = str;
            return this;
        }

        public Builder diffPkgHandler(a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return (Builder) iPatchRedirector.redirect((short) 26, (Object) this, (Object) aVar);
            }
            this.diffPkgHandler = aVar;
            return this;
        }

        public Builder enableBuglyQQCrashReport(Boolean bool) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) bool);
            }
            this.isEnableBuglyQQCrashReport = bool;
            return this;
        }

        public Builder internalInitMMKVForRDelivery(Boolean bool) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) bool);
            }
            this.internalInitMMKVForRDelivery = bool;
            return this;
        }

        public Builder irNetwork(IRNetwork iRNetwork) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return (Builder) iPatchRedirector.redirect((short) 24, (Object) this, (Object) iRNetwork);
            }
            this.irNetwork = iRNetwork;
            return this;
        }

        public Builder irTask(IRTask iRTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return (Builder) iPatchRedirector.redirect((short) 25, (Object) this, (Object) iRTask);
            }
            this.irTask = iRTask;
            return this;
        }

        public Builder isDebugPackage(Boolean bool) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) bool);
            }
            this.isDebugPackage = bool;
            return this;
        }

        public Builder isMainProcess(Boolean bool) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (Builder) iPatchRedirector.redirect((short) 18, (Object) this, (Object) bool);
            }
            this.isMainProcess = bool;
            return this;
        }

        public Builder monitorLifecycle(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (Builder) iPatchRedirector.redirect((short) 19, (Object) this, z16);
            }
            this.monitorLifecycle = z16;
            return this;
        }

        public Builder printInternalLog(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (Builder) iPatchRedirector.redirect((short) 17, (Object) this, z16);
            }
            this.printInternalLog = z16;
            return this;
        }

        public Builder systemVersion(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            this.systemVersion = str;
            return this;
        }

        public Builder useSPStorage(Boolean bool) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, (Object) bool);
            }
            this.isUseSPStorage = bool;
            return this;
        }

        public Builder useShiplyChannel(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (Builder) iPatchRedirector.redirect((short) 20, (Object) this, z16);
            }
            this.useShiplyChannel = z16;
            return this;
        }

        public Builder userId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.userId = str;
            return this;
        }
    }

    /* synthetic */ UpgradeConfig(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 30)) {
            return;
        }
        iPatchRedirector.redirect((short) 30, (Object) this, (Object) builder, (Object) anonymousClass1);
    }

    public String getAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.appId;
    }

    public String getAppKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.appKey;
    }

    public long getCacheExpireTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return this.cacheExpireTime;
    }

    public int getCurrentBuildNo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.currentBuildNo;
    }

    public b getCustomDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (b) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.customDownloader;
    }

    public pw4.b getCustomInstaller() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (pw4.b) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.customInstaller;
    }

    public c getCustomLogger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (c) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.customLogger;
    }

    public Map<String, String> getCustomParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Map) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.customParams;
    }

    public String getDevManufacturer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.devManufacturer;
    }

    public String getDevModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.devModel;
    }

    public a getDiffPkgHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (a) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.diffPkgHandler;
    }

    public IRNetwork getIrNetwork() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (IRNetwork) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.irNetwork;
    }

    public IRTask getIrTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (IRTask) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.irTask;
    }

    public String getSystemVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.systemVersion;
    }

    public String getUserId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.userId;
    }

    public IBasePkgFile getiBasePkgFileForDiffUpgrade() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (IBasePkgFile) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.iBasePkgFileForDiffUpgrade;
    }

    public boolean isAllow32BitApkOn64BitDevice() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return this.allow32BitApkOn64BitDevice;
    }

    public boolean isAllowDownloadOverMobile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.allowDownloadOverMobile;
    }

    public boolean isDebugMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.debugMode;
    }

    public Boolean isDebugPackage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Boolean) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.isDebugPackage;
    }

    public Boolean isEnableBuglyQQCrashReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Boolean) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.isEnableBuglyQQCrashReport;
    }

    public Boolean isInternalInitMMKVForRDelivery() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Boolean) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.internalInitMMKVForRDelivery;
    }

    public Boolean isMainProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Boolean) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.isMainProcess;
    }

    public boolean isMonitorLifecycle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return this.monitorLifecycle;
    }

    public boolean isPrintInternalLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.printInternalLog;
    }

    public Boolean isUseSPStorage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Boolean) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.isUseSPStorage;
    }

    public boolean isUseShiplyChannel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.useShiplyChannel;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (String) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return "UpgradeConfig{appId='" + getAppId() + "', userId='" + getUserId() + "', debugMode='" + isDebugMode() + "', allow32BitApkOn64BitDevice='" + isAllow32BitApkOn64BitDevice() + "', printInternalLog='" + isPrintInternalLog() + "', isMainProcess='" + isMainProcess() + "', monitorLifecycle='" + isMonitorLifecycle() + "', currentBuildNo=" + getCurrentBuildNo() + '}';
    }

    UpgradeConfig(Builder builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) builder);
            return;
        }
        this.appId = "";
        this.appKey = "";
        this.userId = "";
        this.devModel = "";
        this.devManufacturer = "";
        this.systemVersion = "";
        this.currentBuildNo = 0;
        this.isDebugPackage = Boolean.FALSE;
        this.cacheExpireTime = -1L;
        this.allowDownloadOverMobile = true;
        this.debugMode = false;
        this.customParams = new HashMap();
        this.customDownloader = null;
        this.customLogger = null;
        this.irNetwork = null;
        this.useShiplyChannel = true;
        this.appId = builder.appId;
        this.appKey = builder.appKey;
        this.userId = builder.userId;
        this.devModel = builder.devModel;
        this.devManufacturer = builder.devManufacturer;
        this.systemVersion = builder.systemVersion;
        this.currentBuildNo = builder.currentBuildNo;
        this.isDebugPackage = builder.isDebugPackage;
        this.internalInitMMKVForRDelivery = builder.internalInitMMKVForRDelivery;
        this.isEnableBuglyQQCrashReport = builder.isEnableBuglyQQCrashReport;
        this.isUseSPStorage = builder.isUseSPStorage;
        this.cacheExpireTime = builder.cacheExpireTime;
        this.allowDownloadOverMobile = builder.allowDownloadOverMobile;
        this.debugMode = builder.debugMode;
        this.allow32BitApkOn64BitDevice = builder.allow32BitApkOn64BitDevice;
        this.printInternalLog = builder.printInternalLog;
        this.isMainProcess = builder.isMainProcess;
        this.monitorLifecycle = builder.monitorLifecycle;
        this.useShiplyChannel = builder.useShiplyChannel;
        this.customParams = builder.customParams;
        this.customDownloader = builder.customDownloader;
        this.customLogger = builder.customLogger;
        this.irNetwork = builder.irNetwork;
        this.irTask = builder.irTask;
        this.diffPkgHandler = builder.diffPkgHandler;
        this.iBasePkgFileForDiffUpgrade = builder.iBasePkgFileForDiffUpgrade;
        this.customInstaller = builder.customInstaller;
    }
}
