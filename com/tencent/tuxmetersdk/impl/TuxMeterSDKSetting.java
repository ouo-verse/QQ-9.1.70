package com.tencent.tuxmetersdk.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.export.config.TuxEnvironment;
import com.tencent.tuxmetersdk.export.injector.event.ITuxRemoteEventReport;
import com.tencent.tuxmetersdk.export.injector.log.ITuxLog;
import com.tencent.tuxmetersdk.export.injector.storage.ITuxStorage;
import com.tencent.tuxmetersdk.model.TuxDomain;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class TuxMeterSDKSetting {
    static IPatchRedirector $redirector_;
    private final String appId;
    private final String appKey;
    private final String appVersion;
    private final boolean debug;
    private final TuxEnvironment environment;
    private final ITuxLog logger;
    private final String mobileModel;
    private final ITuxRemoteEventReport reporter;
    private final ExecutorService threadPool;
    private final TuxDomain tuxDomain;
    private final ITuxStorage tuxInjectStorage;
    private String uid;
    private String zoneId;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class Builder {
        static IPatchRedirector $redirector_;
        private String appId;
        private String appKey;
        private String appVersion;
        private boolean debug;
        private TuxEnvironment environment;
        private ITuxLog logger;
        private String mobileModel;
        private ITuxRemoteEventReport reporter;
        private ExecutorService threadPool;
        private TuxDomain tuxDomain;
        private ITuxStorage tuxStorage;
        private String uid;
        private String zoneId;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.environment = TuxEnvironment.RELEASE;
                this.debug = false;
            }
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

        public Builder appVersion(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.appVersion = str;
            return this;
        }

        public TuxMeterSDKSetting build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (TuxMeterSDKSetting) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            return new TuxMeterSDKSetting(this, null);
        }

        public Builder debug(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, z16);
            }
            this.debug = z16;
            return this;
        }

        public Builder domain(TuxDomain tuxDomain) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (Builder) iPatchRedirector.redirect((short) 14, (Object) this, (Object) tuxDomain);
            }
            this.tuxDomain = tuxDomain;
            return this;
        }

        public Builder environment(TuxEnvironment tuxEnvironment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) tuxEnvironment);
            }
            this.environment = tuxEnvironment;
            return this;
        }

        public Builder getSelf() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (Builder) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            return this;
        }

        public Builder logger(ITuxLog iTuxLog) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) iTuxLog);
            }
            this.logger = iTuxLog;
            return this;
        }

        public Builder mobileModel(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.mobileModel = str;
            return this;
        }

        public Builder reporter(ITuxRemoteEventReport iTuxRemoteEventReport) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) iTuxRemoteEventReport);
            }
            this.reporter = iTuxRemoteEventReport;
            return this;
        }

        public Builder storage(ITuxStorage iTuxStorage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (Builder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) iTuxStorage);
            }
            this.tuxStorage = iTuxStorage;
            return this;
        }

        public Builder threadPool(ExecutorService executorService) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) executorService);
            }
            this.threadPool = executorService;
            return this;
        }

        public Builder uid(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            this.uid = str;
            return this;
        }

        public Builder zoneId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            this.zoneId = str;
            return this;
        }
    }

    /* synthetic */ TuxMeterSDKSetting(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) builder, (Object) anonymousClass1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getAppId() {
        return this.appId;
    }

    public String getAppKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.appKey;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getAppVersion() {
        String str = this.appVersion;
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ITuxRemoteEventReport getBeaconReporter() {
        return this.reporter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TuxEnvironment getEnvironment() {
        return this.environment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ITuxLog getLogger() {
        return this.logger;
    }

    public String getMobileModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        String str = this.mobileModel;
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExecutorService getThreadPool() {
        return this.threadPool;
    }

    public TuxDomain getTuxDomainWithDefault() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TuxDomain) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        TuxDomain tuxDomain = this.tuxDomain;
        if (tuxDomain == null) {
            return TuxDomain.getDefaultDomain();
        }
        return tuxDomain;
    }

    public ITuxStorage getTuxInjectStorage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ITuxStorage) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.tuxInjectStorage;
    }

    public String getUid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.uid;
    }

    public String getZoneId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        String str = this.zoneId;
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isDebug() {
        return this.debug;
    }

    public void resetUserData(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        } else {
            this.uid = str;
            this.zoneId = str2;
        }
    }

    TuxMeterSDKSetting(Builder builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) builder);
            return;
        }
        this.appId = builder.appId;
        this.appKey = builder.appKey;
        this.appVersion = builder.appVersion;
        this.uid = builder.uid;
        this.mobileModel = builder.mobileModel;
        this.environment = builder.environment;
        this.reporter = builder.reporter;
        this.threadPool = builder.threadPool;
        if (builder.logger != null) {
            this.logger = builder.logger;
        } else {
            this.logger = new TuxLogImpl();
        }
        this.debug = builder.debug;
        this.tuxInjectStorage = builder.tuxStorage;
        this.tuxDomain = builder.tuxDomain;
        this.zoneId = builder.zoneId;
    }
}
