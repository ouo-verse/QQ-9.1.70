package com.tencent.mobileqq.intervideo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface ILoginKeyHelper extends QRouteApi {
    public static final int FLAG_ACCESS_TOKEN = 2;
    public static final int FLAG_OPENID = 1;
    public static final int FLAG_PAY_TOKEN = 4;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f238092a;

        /* renamed from: b, reason: collision with root package name */
        public String f238093b;

        /* renamed from: c, reason: collision with root package name */
        public String f238094c;

        /* renamed from: d, reason: collision with root package name */
        public Intent f238095d;

        /* renamed from: e, reason: collision with root package name */
        public long f238096e;

        /* renamed from: f, reason: collision with root package name */
        public long f238097f;

        /* renamed from: g, reason: collision with root package name */
        public String f238098g;

        /* renamed from: h, reason: collision with root package name */
        public String f238099h;

        /* renamed from: i, reason: collision with root package name */
        public int f238100i;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f238092a = "";
            this.f238093b = "";
            this.f238094c = "";
            this.f238096e = 0L;
            this.f238097f = 0L;
            this.f238098g = "";
            this.f238099h = "";
            this.f238100i = 1;
        }

        public Bundle a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bundle) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            Bundle bundle = new Bundle();
            if (this.f238100i == 1) {
                bundle.putString("authKey", this.f238092a);
                bundle.putString("authid", this.f238093b);
            } else {
                bundle.putString("authPSKey", this.f238099h);
            }
            bundle.putLong("authUin", this.f238097f);
            bundle.putInt("authtype", this.f238100i);
            return bundle;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface b {
        void a(String str, boolean z16, int i3);
    }

    void cancelRequest();

    void clearAccount();

    boolean getA1(String str, String str2, String str3, String str4, b bVar, boolean z16, String str5);

    void getAccessToken(AppInterface appInterface, String str, Context context, String str2, b bVar);

    a getAccountInfo();

    void getPSkey(AppInterface appInterface, String str, b bVar);
}
