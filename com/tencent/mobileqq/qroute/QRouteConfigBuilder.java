package com.tencent.mobileqq.qroute;

import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.module.b;
import com.tencent.mobileqq.qroute.route.g;
import com.tencent.mobileqq.qroute.utils.c;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QRouteConfigBuilder {
    static IPatchRedirector $redirector_;
    private static final g DEFAULT_LOGGER;
    private boolean mForceCheck;
    private g mLogger;
    private List<String> mModules;
    private b mPluginFactory;
    private c mProcessCheck;
    private String mProcessName;
    private com.tencent.mobileqq.qroute.remote.a mRemoteProxy;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements g {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.qroute.route.g
        public void a(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            } else {
                Log.w(str, str2);
            }
        }

        @Override // com.tencent.mobileqq.qroute.route.g
        public void b(String str, String str2, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, str, str2, th5);
            } else {
                Log.w(str, str2, th5);
            }
        }

        @Override // com.tencent.mobileqq.qroute.route.g
        public void debug(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            } else {
                Log.d(str, str2);
            }
        }

        @Override // com.tencent.mobileqq.qroute.route.g
        public void info(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            } else {
                Log.i(str, str2);
            }
        }

        @Override // com.tencent.mobileqq.qroute.route.g
        public boolean isColorLevel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7491);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            DEFAULT_LOGGER = new a();
        }
    }

    public QRouteConfigBuilder(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.mForceCheck = false;
        this.mProcessCheck = null;
        this.mLogger = DEFAULT_LOGGER;
        this.mRemoteProxy = null;
        this.mModules = null;
        this.mProcessName = str;
    }

    public QRouteConfig create() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (QRouteConfig) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return new QRouteConfig(this.mProcessName, this.mForceCheck, this.mProcessCheck, this.mLogger, this.mRemoteProxy, this.mPluginFactory, this.mModules);
    }

    public QRouteConfigBuilder setForceCheck(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QRouteConfigBuilder) iPatchRedirector.redirect((short) 3, (Object) this, z16);
        }
        this.mForceCheck = z16;
        return this;
    }

    public QRouteConfigBuilder setLogger(@NonNull g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (QRouteConfigBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) gVar);
        }
        this.mLogger = gVar;
        return this;
    }

    public QRouteConfigBuilder setModules(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (QRouteConfigBuilder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
        }
        this.mModules = list;
        return this;
    }

    public QRouteConfigBuilder setPluginFactory(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (QRouteConfigBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) bVar);
        }
        this.mPluginFactory = bVar;
        return this;
    }

    public QRouteConfigBuilder setProcessCheck(@NonNull c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QRouteConfigBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar);
        }
        this.mProcessCheck = cVar;
        return this;
    }

    public QRouteConfigBuilder setProcessName(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QRouteConfigBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        this.mProcessName = str;
        return this;
    }

    public QRouteConfigBuilder setRemoteProxy(@NonNull com.tencent.mobileqq.qroute.remote.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (QRouteConfigBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        }
        this.mRemoteProxy = aVar;
        return this;
    }
}
