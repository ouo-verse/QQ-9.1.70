package com.tencent.tgpa.lite.g;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tdm.TDataMaster;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static c f375966a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f375967b = false;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* renamed from: com.tencent.tgpa.lite.g.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class EnumC9913b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        public static final EnumC9913b f375968b;

        /* renamed from: c, reason: collision with root package name */
        public static final EnumC9913b f375969c;

        /* renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumC9913b[] f375970d;

        /* renamed from: a, reason: collision with root package name */
        private int f375971a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15583);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            EnumC9913b enumC9913b = new EnumC9913b("ReportNow", 0, 0);
            f375968b = enumC9913b;
            EnumC9913b enumC9913b2 = new EnumC9913b("ReportLater", 1, 1);
            f375969c = enumC9913b2;
            f375970d = new EnumC9913b[]{enumC9913b, enumC9913b2};
        }

        EnumC9913b(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.f375971a = i16;
            }
        }

        public static EnumC9913b valueOf(String str) {
            return (EnumC9913b) Enum.valueOf(EnumC9913b.class, str);
        }

        public static EnumC9913b[] values() {
            return (EnumC9913b[]) f375970d.clone();
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f375971a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static class c {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* synthetic */ c(a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, int i3, HashMap<String, String> hashMap) {
            try {
                TDataMaster.getInstance().reportEvent(2007, str, hashMap);
            } catch (Exception e16) {
                e16.printStackTrace();
                h.b("TDM is not available, ple check!", new Object[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            try {
                TDataMaster.getInstance().getTDMUID();
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    public static void a() {
        c cVar = new c(null);
        f375966a = cVar;
        if (!cVar.a()) {
            h.d("No report sdk is available, use self report.", new Object[0]);
        } else {
            h.a("checkTDM: tdm is available in this app.", new Object[0]);
            f375967b = true;
        }
    }

    public static void a(com.tencent.tgpa.lite.b.b bVar, EnumC9913b enumC9913b, HashMap<String, String> hashMap) {
        c cVar;
        if (!f375967b || (cVar = f375966a) == null) {
            new k(bVar.a(), new JSONObject(hashMap).toString()).execute(new Void[0]);
        } else {
            cVar.a(bVar.a(), enumC9913b.a(), hashMap);
        }
    }
}
