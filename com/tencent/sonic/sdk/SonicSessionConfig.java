package com.tencent.sonic.sdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SonicSessionConfig {
    static IPatchRedirector $redirector_;
    boolean ACCEPT_DIFF_DATA;
    boolean AUTO_START_WHEN_CREATE;
    int CONNECT_TIMEOUT_MILLIS;
    boolean IS_ACCOUNT_RELATED;
    long PRELOAD_SESSION_EXPIRED_TIME;
    int READ_BUF_SIZE;
    int READ_TIMEOUT_MILLIS;
    boolean RELOAD_IN_BAD_NETWORK;
    boolean SUPPORT_CACHE_CONTROL;
    boolean SUPPORT_LOCAL_SERVER;
    boolean SUPPORT_SONIC_CHUNK_DATA;
    String USE_SONIC_CACHE_IN_BAD_NETWORK_TOAST;
    SonicCacheInterceptor cacheInterceptor;
    SonicSessionConnectionInterceptor connectionInterceptor;
    Map<String, String> customRequestHeaders;
    Map<String, String> customResponseHeaders;
    int sessionMode;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private final SonicSessionConfig target;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.target = new SonicSessionConfig(null);
            }
        }

        public SonicSessionConfig build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (SonicSessionConfig) iPatchRedirector.redirect((short) 19, (Object) this);
            }
            return this.target;
        }

        public Builder setAcceptDiff(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, z16);
            }
            this.target.ACCEPT_DIFF_DATA = z16;
            return this;
        }

        public Builder setAutoStartWhenCreate(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, z16);
            }
            this.target.AUTO_START_WHEN_CREATE = z16;
            return this;
        }

        public Builder setCacheInterceptor(SonicCacheInterceptor sonicCacheInterceptor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, (Object) sonicCacheInterceptor);
            }
            this.target.cacheInterceptor = sonicCacheInterceptor;
            return this;
        }

        public Builder setConnectTimeoutMillis(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            this.target.CONNECT_TIMEOUT_MILLIS = i3;
            return this;
        }

        public Builder setConnectionInterceptor(SonicSessionConnectionInterceptor sonicSessionConnectionInterceptor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (Builder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) sonicSessionConnectionInterceptor);
            }
            this.target.connectionInterceptor = sonicSessionConnectionInterceptor;
            return this;
        }

        public Builder setCustomRequestHeaders(Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (Builder) iPatchRedirector.redirect((short) 14, (Object) this, (Object) map);
            }
            this.target.customRequestHeaders = map;
            return this;
        }

        public Builder setCustomResponseHeaders(Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (Builder) iPatchRedirector.redirect((short) 15, (Object) this, (Object) map);
            }
            this.target.customResponseHeaders = map;
            return this;
        }

        public Builder setIsAccountRelated(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, z16);
            }
            this.target.IS_ACCOUNT_RELATED = z16;
            return this;
        }

        public Builder setPreloadSessionExpiredTimeMillis(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, j3);
            }
            this.target.PRELOAD_SESSION_EXPIRED_TIME = j3;
            return this;
        }

        public Builder setReadBufferSize(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.target.READ_BUF_SIZE = i3;
            return this;
        }

        public Builder setReadTimeoutMillis(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            this.target.READ_TIMEOUT_MILLIS = i3;
            return this;
        }

        public Builder setReloadInBadNetwork(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, z16);
            }
            this.target.RELOAD_IN_BAD_NETWORK = z16;
            return this;
        }

        public Builder setSessionMode(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, i3);
            }
            this.target.sessionMode = i3;
            return this;
        }

        public Builder setSupportCacheControl(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (Builder) iPatchRedirector.redirect((short) 16, (Object) this, z16);
            }
            this.target.SUPPORT_CACHE_CONTROL = z16;
            return this;
        }

        public Builder setSupportLocalServer(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (Builder) iPatchRedirector.redirect((short) 17, (Object) this, z16);
            }
            this.target.SUPPORT_LOCAL_SERVER = z16;
            return this;
        }

        public Builder setSupportSonicChunkData(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (Builder) iPatchRedirector.redirect((short) 18, (Object) this, z16);
            }
            this.target.SUPPORT_SONIC_CHUNK_DATA = z16;
            return this;
        }

        public Builder setUseSonicCacheInBadNetworkToastMessage(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            }
            this.target.USE_SONIC_CACHE_IN_BAD_NETWORK_TOAST = str;
            return this;
        }
    }

    /* synthetic */ SonicSessionConfig(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, (Object) this, (Object) anonymousClass1);
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, obj)).booleanValue();
        }
        if (!(obj instanceof SonicSessionConfig)) {
            return false;
        }
        SonicSessionConfig sonicSessionConfig = (SonicSessionConfig) obj;
        if (this.sessionMode != sonicSessionConfig.sessionMode || this.SUPPORT_LOCAL_SERVER != sonicSessionConfig.SUPPORT_LOCAL_SERVER) {
            return false;
        }
        return true;
    }

    public SonicCacheInterceptor getCacheInterceptor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (SonicCacheInterceptor) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.cacheInterceptor;
    }

    public SonicSessionConnectionInterceptor getConnectionInterceptor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (SonicSessionConnectionInterceptor) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.connectionInterceptor;
    }

    public Map<String, String> getCustomRequestHeaders() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Map) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.customRequestHeaders;
    }

    public Map<String, String> getCustomResponseHeaders() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Map) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.customResponseHeaders;
    }

    public int getSessionMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.sessionMode;
    }

    public boolean isAcceptDiffData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }
        return this.ACCEPT_DIFF_DATA;
    }

    public boolean isAccountRelated() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.IS_ACCOUNT_RELATED;
    }

    public boolean isAutoStartWhenCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.AUTO_START_WHEN_CREATE;
    }

    public boolean isReloadInBadNetWork() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.RELOAD_IN_BAD_NETWORK;
    }

    public boolean isSupportCacheControl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.SUPPORT_CACHE_CONTROL;
    }

    public boolean isSupportLocalServer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.SUPPORT_LOCAL_SERVER;
    }

    public boolean isSupportSonicCHunkData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.SUPPORT_SONIC_CHUNK_DATA;
    }

    SonicSessionConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        this.CONNECT_TIMEOUT_MILLIS = 5000;
        this.READ_TIMEOUT_MILLIS = 15000;
        this.READ_BUF_SIZE = 10240;
        this.PRELOAD_SESSION_EXPIRED_TIME = 180000L;
        this.ACCEPT_DIFF_DATA = true;
        this.IS_ACCOUNT_RELATED = true;
        this.RELOAD_IN_BAD_NETWORK = false;
        this.AUTO_START_WHEN_CREATE = true;
        this.SUPPORT_CACHE_CONTROL = false;
        this.SUPPORT_LOCAL_SERVER = false;
        this.SUPPORT_SONIC_CHUNK_DATA = true;
        this.USE_SONIC_CACHE_IN_BAD_NETWORK_TOAST = "Bad Network!";
        this.sessionMode = 1;
        this.cacheInterceptor = null;
        this.connectionInterceptor = null;
        this.customRequestHeaders = null;
        this.customResponseHeaders = null;
    }
}
