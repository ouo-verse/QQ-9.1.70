package com.tencent.sonic.sdk;

import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SonicConfig {
    static IPatchRedirector $redirector_;
    boolean AUTO_INIT_DB_WHEN_CREATE;
    boolean GET_COOKIE_WHEN_SESSION_CREATE;
    int MAX_PRELOAD_SESSION_COUNT;
    long SONIC_CACHE_CHECK_TIME_INTERVAL;
    int SONIC_CACHE_MAX_AGE;
    long SONIC_CACHE_MAX_SIZE;
    public int SONIC_MAX_NUM_OF_DOWNLOADING_TASK;
    long SONIC_RESOURCE_CACHE_MAX_SIZE;
    long SONIC_UNAVAILABLE_TIME;
    public boolean VERIFY_CACHE_FILE_WITH_SHA1;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private final SonicConfig target;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.target = new SonicConfig(null);
            }
        }

        public SonicConfig build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (SonicConfig) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.target;
        }

        public Builder setAutoInitDBWhenCreate(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, z16);
            }
            this.target.AUTO_INIT_DB_WHEN_CREATE = z16;
            return this;
        }

        public Builder setCacheCheckTimeInterval(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, j3);
            }
            this.target.SONIC_CACHE_CHECK_TIME_INTERVAL = j3;
            return this;
        }

        public Builder setCacheMaxSize(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, j3);
            }
            this.target.SONIC_CACHE_MAX_SIZE = j3;
            return this;
        }

        public Builder setCacheVerifyWithSha1(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, z16);
            }
            this.target.VERIFY_CACHE_FILE_WITH_SHA1 = z16;
            return this;
        }

        public Builder setGetCookieWhenSessionCreate(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, z16);
            }
            this.target.GET_COOKIE_WHEN_SESSION_CREATE = z16;
            return this;
        }

        public Builder setResourceCacheMaxSize(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, j3);
            }
            this.target.SONIC_RESOURCE_CACHE_MAX_SIZE = j3;
            return this;
        }

        public Builder setSonicCacheMaxAge(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, i3);
            }
            this.target.SONIC_CACHE_MAX_AGE = i3;
            return this;
        }

        public Builder setUnavailableTime(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, j3);
            }
            this.target.SONIC_UNAVAILABLE_TIME = j3;
            return this;
        }
    }

    /* synthetic */ SonicConfig(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) anonymousClass1);
    }

    SonicConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.MAX_PRELOAD_SESSION_COUNT = 5;
        this.SONIC_UNAVAILABLE_TIME = 21600000L;
        this.SONIC_CACHE_MAX_SIZE = GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV;
        this.SONIC_RESOURCE_CACHE_MAX_SIZE = 62914560L;
        this.SONIC_CACHE_CHECK_TIME_INTERVAL = 86400000L;
        this.SONIC_MAX_NUM_OF_DOWNLOADING_TASK = 3;
        this.SONIC_CACHE_MAX_AGE = 300000;
        this.VERIFY_CACHE_FILE_WITH_SHA1 = true;
        this.AUTO_INIT_DB_WHEN_CREATE = true;
        this.GET_COOKIE_WHEN_SESSION_CREATE = true;
    }
}
