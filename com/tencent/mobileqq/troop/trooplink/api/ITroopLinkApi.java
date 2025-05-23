package com.tencent.mobileqq.troop.trooplink.api;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopLinkApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f300491a;

        /* renamed from: b, reason: collision with root package name */
        public String f300492b;

        /* renamed from: c, reason: collision with root package name */
        public String f300493c;

        /* renamed from: d, reason: collision with root package name */
        public String f300494d;

        /* renamed from: e, reason: collision with root package name */
        public String f300495e;

        /* renamed from: f, reason: collision with root package name */
        public String f300496f;

        /* renamed from: g, reason: collision with root package name */
        public String f300497g;

        /* renamed from: h, reason: collision with root package name */
        public String f300498h;

        /* renamed from: i, reason: collision with root package name */
        public String f300499i;

        /* renamed from: j, reason: collision with root package name */
        public String f300500j;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static a a() {
            return new a();
        }

        public a b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.f300493c = str;
            return this;
        }

        public a c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.f300491a = str;
            return this;
        }

        public a d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (a) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            }
            this.f300500j = str;
            return this;
        }

        public a e(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (a) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            this.f300495e = str;
            return this;
        }

        public a f(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.f300494d = str;
            return this;
        }

        public a g(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.f300492b = str;
            return this;
        }
    }

    String getSmartManagerUrl(String str, String str2, long j3, int i3);

    String getTroopHonorSettingUrl(String str, boolean z16);

    String getTroopHonorUrl(String str, int i3);

    String getTroopMemberHonorUrl(String str, String str2);

    String getTroopMemberLevelUrl(String str, String str2, String str3, String str4, String str5);

    String getUrl(String str);

    String getUrl(String str, Bundle bundle);

    String replaceParams(String str, a aVar);

    boolean saveConfig(String str);
}
