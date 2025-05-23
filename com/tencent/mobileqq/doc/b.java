package com.tencent.mobileqq.doc;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import ta1.j;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f203563a;

        /* renamed from: b, reason: collision with root package name */
        public String f203564b;

        /* renamed from: c, reason: collision with root package name */
        public String f203565c;

        /* renamed from: d, reason: collision with root package name */
        public int f203566d;

        /* renamed from: e, reason: collision with root package name */
        public String f203567e;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f203563a = false;
            this.f203564b = "";
            this.f203565c = "";
            this.f203566d = 1;
            this.f203567e = "";
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "enable:" + this.f203563a + ",mPlainContent:" + this.f203564b + ",mHighLightContent:" + this.f203565c + ",times:" + this.f203566d + ",mJumpLinkUrls:" + this.f203567e + ",";
        }
    }

    public static Pair<Boolean, Integer> a(AppInterface appInterface) {
        ta1.e eVar = new ta1.e();
        return new Pair<>(Boolean.valueOf(eVar.b()), Integer.valueOf(eVar.a()));
    }

    public static a b(AppInterface appInterface) {
        a aVar = new a();
        j jVar = new j();
        aVar.f203563a = jVar.e();
        aVar.f203564b = jVar.c();
        aVar.f203565c = jVar.a();
        aVar.f203566d = jVar.d();
        aVar.f203567e = jVar.b();
        if (QLog.isColorLevel()) {
            QLog.d("TencentDocEntryUtils", 2, "getGrayTipsInfo " + aVar.toString());
        }
        return aVar;
    }
}
