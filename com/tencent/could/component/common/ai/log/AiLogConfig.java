package com.tencent.could.component.common.ai.log;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AiLogConfig {
    static IPatchRedirector $redirector_ = null;
    private static final String DEFAULT_STRING = "aiLog";
    private String defaultTag;
    private String dirLog;
    private long fileOutTime;
    private boolean isLogCat;
    private boolean isOpen;
    private boolean isUseExternalFile;
    private String logName;
    private int minLevel;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class AiLogConfigBuilder {
        static IPatchRedirector $redirector_;
        private String defaultTag;
        private String dirLog;
        private long fileOutTime;
        private boolean isLogCat;
        private boolean isOpen;
        private boolean isUseExternalFile;
        private String logName;
        private int minLevel;

        public AiLogConfigBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.defaultTag = AiLogConfig.DEFAULT_STRING;
            this.dirLog = AiLogConfig.DEFAULT_STRING;
            this.logName = AiLogConfig.DEFAULT_STRING;
            this.isLogCat = true;
            this.isOpen = true;
            this.minLevel = 2;
            this.fileOutTime = 259200000L;
            this.isUseExternalFile = false;
        }

        public AiLogConfig create() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (AiLogConfig) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return new AiLogConfig(this, null);
        }

        public AiLogConfigBuilder setDefaultTag(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AiLogConfigBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.defaultTag = str;
            return this;
        }

        public AiLogConfigBuilder setDirLog(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AiLogConfigBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.dirLog = str;
            return this;
        }

        public AiLogConfigBuilder setFileOutTime(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (AiLogConfigBuilder) iPatchRedirector.redirect((short) 6, (Object) this, j3);
            }
            this.fileOutTime = j3;
            return this;
        }

        public AiLogConfigBuilder setLogCat(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (AiLogConfigBuilder) iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
            this.isLogCat = z16;
            return this;
        }

        public AiLogConfigBuilder setLogName(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (AiLogConfigBuilder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            }
            this.logName = str;
            return this;
        }

        public AiLogConfigBuilder setMinLevel(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (AiLogConfigBuilder) iPatchRedirector.redirect((short) 7, (Object) this, i3);
            }
            this.minLevel = i3;
            return this;
        }

        public AiLogConfigBuilder setOpen(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (AiLogConfigBuilder) iPatchRedirector.redirect((short) 5, (Object) this, z16);
            }
            this.isOpen = z16;
            return this;
        }

        public AiLogConfigBuilder setUseExternalFile(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (AiLogConfigBuilder) iPatchRedirector.redirect((short) 9, (Object) this, z16);
            }
            this.isUseExternalFile = z16;
            return this;
        }
    }

    public /* synthetic */ AiLogConfig(AiLogConfigBuilder aiLogConfigBuilder, a aVar) {
        this(aiLogConfigBuilder);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aiLogConfigBuilder, (Object) aVar);
    }

    public String getDefaultTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.defaultTag;
    }

    public String getDirLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.dirLog;
    }

    public long getFileOutTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.fileOutTime;
    }

    public String getLogName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.logName;
    }

    public int getMinLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.minLevel;
    }

    public boolean isLogCat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.isLogCat;
    }

    public boolean isOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isOpen;
    }

    public boolean isUseExternalFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.isUseExternalFile;
    }

    AiLogConfig(AiLogConfigBuilder aiLogConfigBuilder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aiLogConfigBuilder);
            return;
        }
        this.isUseExternalFile = false;
        this.defaultTag = aiLogConfigBuilder.defaultTag;
        this.dirLog = aiLogConfigBuilder.dirLog;
        this.isLogCat = aiLogConfigBuilder.isLogCat;
        this.isOpen = aiLogConfigBuilder.isOpen;
        this.fileOutTime = aiLogConfigBuilder.fileOutTime;
        this.minLevel = aiLogConfigBuilder.minLevel;
        this.logName = aiLogConfigBuilder.logName;
        this.isUseExternalFile = aiLogConfigBuilder.isUseExternalFile;
    }
}
