package com.tencent.qqcamerakit.capture.camerastrategy;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Hashtable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected static Hashtable<String, String> f344891a;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static String f344892a;

        /* renamed from: b, reason: collision with root package name */
        public static String f344893b;

        /* renamed from: c, reason: collision with root package name */
        public static String f344894c;

        /* renamed from: d, reason: collision with root package name */
        public static String f344895d;

        /* renamed from: e, reason: collision with root package name */
        public static String f344896e;

        /* renamed from: f, reason: collision with root package name */
        public static String f344897f;

        /* renamed from: g, reason: collision with root package name */
        public static String f344898g;

        /* renamed from: h, reason: collision with root package name */
        public static String f344899h;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11458);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            f344892a = "PREVIEW_ORIENTATION_270_OF_FRONT_MODEL";
            f344893b = "PREVIEW_ORIENTATION_270_OF_FRONT_MODEL_2";
            f344894c = "PREVIEW_ORIENTATION_270_OF_BACK_MODEL";
            f344895d = "NOT_FOCUS_MODEL";
            f344896e = "NEED_DRAW_ON_SINGLE_THREAD";
            f344897f = "NEED_FORBID_CAMERA2";
            f344898g = "KEY_NEED_FORBID_PREVIEW_DARK";
            f344899h = "Xiaomi;MIX 2S|Meizu;15";
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static String f344900a;

        /* renamed from: b, reason: collision with root package name */
        static String f344901b;

        /* renamed from: c, reason: collision with root package name */
        static String f344902c;

        /* renamed from: d, reason: collision with root package name */
        static String f344903d;

        /* renamed from: e, reason: collision with root package name */
        static String f344904e;

        /* renamed from: f, reason: collision with root package name */
        static String f344905f;

        /* renamed from: g, reason: collision with root package name */
        static String f344906g;

        /* renamed from: h, reason: collision with root package name */
        static String f344907h;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11466);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            f344900a = "Nexus 6|Lenovo K860|Nexus 6P|Lenovo A3000-H|M823";
            f344901b = "ZTE;U9180;18;JLS36C|motorola;Moto X Pro;21;LXG22.67-7.1|redbird;redbird H1;23;MMB29M";
            f344902c = "Nexus 5X";
            f344903d = "GT-I8262D|SCH-I879|SCH-I829";
            f344904e = "OPPO;OPPO R9 Plustm A;22";
            f344905f = "Google;Pixel XL|Google;Pixel 2";
            f344906g = "";
            f344907h = "Xiaomi;MIX 2S|Meizu|15";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11476);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        Hashtable<String, String> hashtable = new Hashtable<>();
        f344891a = hashtable;
        hashtable.put(a.f344892a, b.f344900a);
        f344891a.put(a.f344893b, b.f344901b);
        f344891a.put(a.f344894c, b.f344902c);
        f344891a.put(a.f344895d, b.f344903d);
        f344891a.put(a.f344896e, b.f344904e);
        f344891a.put(a.f344897f, b.f344905f);
        f344891a.put(a.f344898g, b.f344906g);
        f344891a.put(a.f344899h, b.f344907h);
    }
}
