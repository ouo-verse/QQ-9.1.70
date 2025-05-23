package com.tencent.could.component.common.ai.eventreport.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class EventReportConfig {
    static IPatchRedirector $redirector_ = null;
    public static String STRING_INIT = "";

    /* renamed from: a, reason: collision with root package name */
    public String f99932a;

    /* renamed from: b, reason: collision with root package name */
    public String f99933b;

    /* renamed from: c, reason: collision with root package name */
    public String f99934c;

    /* renamed from: d, reason: collision with root package name */
    public String f99935d;

    /* renamed from: e, reason: collision with root package name */
    public String f99936e;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class ConfigBuilder {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f99937a;

        /* renamed from: b, reason: collision with root package name */
        public String f99938b;

        /* renamed from: c, reason: collision with root package name */
        public String f99939c;

        /* renamed from: d, reason: collision with root package name */
        public String f99940d;

        /* renamed from: e, reason: collision with root package name */
        public String f99941e;

        public ConfigBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            String str = EventReportConfig.STRING_INIT;
            this.f99937a = str;
            this.f99938b = str;
            this.f99939c = str;
            this.f99940d = str;
            this.f99941e = str;
        }

        public EventReportConfig create() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (EventReportConfig) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new EventReportConfig(this);
        }

        public ConfigBuilder setBusiness(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ConfigBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.f99937a = str;
            return this;
        }

        public ConfigBuilder setDeviceInfoUrl(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (ConfigBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            this.f99940d = str;
            return this;
        }

        public ConfigBuilder setErrorInfoUrl(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (ConfigBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            this.f99941e = str;
            return this;
        }

        public ConfigBuilder setOrigin(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (ConfigBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.f99939c = str;
            return this;
        }

        public ConfigBuilder setSdkVersion(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ConfigBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.f99938b = str;
            return this;
        }
    }

    public EventReportConfig(ConfigBuilder configBuilder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) configBuilder);
            return;
        }
        this.f99932a = configBuilder.f99937a;
        this.f99934c = configBuilder.f99939c;
        this.f99933b = configBuilder.f99938b;
        this.f99935d = configBuilder.f99940d;
        this.f99936e = configBuilder.f99941e;
    }

    public static ConfigBuilder builder() {
        return new ConfigBuilder();
    }

    public String getBusiness() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f99932a;
    }

    public String getDeviceInfoUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f99935d;
    }

    public String getErrorInfoUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f99936e;
    }

    public String getOrigin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f99934c;
    }

    public String getSdkVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f99933b;
    }
}
