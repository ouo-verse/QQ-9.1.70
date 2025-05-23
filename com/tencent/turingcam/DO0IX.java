package com.tencent.turingcam;

import android.hardware.Camera;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DO0IX {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String f381761a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f381762b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f381763c;

    /* renamed from: d, reason: collision with root package name */
    private static final String f381764d;

    /* renamed from: e, reason: collision with root package name */
    private static final String f381765e;

    /* renamed from: f, reason: collision with root package name */
    private static final String f381766f;

    /* renamed from: g, reason: collision with root package name */
    private static final String f381767g;

    /* renamed from: h, reason: collision with root package name */
    private static final String f381768h;

    /* renamed from: i, reason: collision with root package name */
    private static final String f381769i;

    /* renamed from: j, reason: collision with root package name */
    private static final String f381770j;

    /* renamed from: k, reason: collision with root package name */
    private static final String f381771k;

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f381772l = 0;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class spXPg {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private float f381773a;

        /* renamed from: b, reason: collision with root package name */
        private Camera f381774b;

        /* renamed from: c, reason: collision with root package name */
        private int f381775c;

        /* renamed from: d, reason: collision with root package name */
        private int f381776d;

        /* renamed from: e, reason: collision with root package name */
        private int f381777e;

        /* renamed from: f, reason: collision with root package name */
        private int f381778f;

        /* renamed from: g, reason: collision with root package name */
        private String f381779g;

        /* renamed from: h, reason: collision with root package name */
        private int f381780h;

        /* renamed from: i, reason: collision with root package name */
        private View f381781i;

        /* renamed from: j, reason: collision with root package name */
        private long f381782j;

        public spXPg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f381775c = 0;
            this.f381776d = 0;
            this.f381777e = 0;
            this.f381778f = 0;
            this.f381782j = 500L;
        }

        public spXPg a(Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (spXPg) iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
            }
            if (map == null) {
                return this;
            }
            String str = map.get(DO0IX.f381767g);
            if (str != null) {
                str.split("_");
            }
            String str2 = map.get(DO0IX.f381761a);
            if (str2 != null) {
                this.f381773a = Float.parseFloat(str2);
            }
            String str3 = map.get(DO0IX.f381765e);
            if (str3 != null) {
                str3.split("_");
            }
            String str4 = map.get(DO0IX.f381764d);
            if (str4 != null) {
                try {
                    this.f381776d = Integer.parseInt(str4);
                } catch (Exception unused) {
                }
            }
            String str5 = map.get(DO0IX.f381765e);
            if (str5 != null) {
                str5.split("_");
            }
            String str6 = map.get(DO0IX.f381766f);
            if (str6 != null) {
                try {
                    Integer.parseInt(str6);
                } catch (Exception unused2) {
                }
            }
            String str7 = map.get(DO0IX.f381768h);
            if (str7 != null) {
                try {
                    this.f381775c = Integer.parseInt(str7);
                } catch (Exception unused3) {
                }
            }
            String str8 = map.get(DO0IX.f381763c);
            if (str8 != null) {
                try {
                    this.f381777e = Integer.parseInt(str8);
                } catch (Exception unused4) {
                }
            }
            String str9 = map.get(DO0IX.f381762b);
            if (str9 != null) {
                try {
                    this.f381778f = Integer.parseInt(str9);
                } catch (Exception unused5) {
                }
            }
            this.f381779g = map.get(DO0IX.f381769i);
            String str10 = map.get(DO0IX.f381770j);
            if (str10 != null) {
                try {
                    this.f381780h = Integer.parseInt(str10);
                } catch (Exception unused6) {
                }
            }
            String str11 = map.get(DO0IX.f381771k);
            if (str11 != null) {
                try {
                    this.f381782j = Long.parseLong(str11);
                } catch (Exception unused7) {
                }
            }
            return this;
        }

        public View b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? this.f381781i : (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }

        public float c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f381773a : ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
        }

        public int d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, i3)).intValue();
            }
            int i16 = this.f381776d;
            return i16 > 0 ? i16 : i3;
        }

        public int e(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, i3)).intValue();
            }
            int i16 = this.f381777e;
            return i16 > 0 ? i16 : i3;
        }

        public int b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, i3)).intValue();
            }
            int i16 = this.f381775c;
            return i16 > 0 ? i16 : i3;
        }

        public int c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, i3)).intValue();
            }
            int i16 = this.f381778f;
            return i16 > 0 ? i16 : i3;
        }

        public String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? this.f381779g : (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }

        public long e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) ? this.f381782j : ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }

        public spXPg a(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (spXPg) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            }
            this.f381781i = view;
            return this;
        }

        public spXPg a(Camera camera2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (spXPg) iPatchRedirector.redirect((short) 4, (Object) this, (Object) camera2);
            }
            this.f381774b = camera2;
            return this;
        }

        public Camera a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? this.f381774b : (Camera) iPatchRedirector.redirect((short) 10, (Object) this);
        }

        public int a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, i3)).intValue();
            }
            int i16 = this.f381780h;
            return i16 > 0 ? i16 : i3;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14182);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f381761a = FxCVY.b("MtgFbiApIVD3jXJqCLt/bt5rkOw=");
        f381762b = FxCVY.b("+cCcc23pI7PKMKrSVgxsZsPbclBvL8nzPyVl/A==");
        f381763c = FxCVY.b("zJ+vMS29evWmRb1DSUyS4qT5+NHKl4KpLi9JENdY++M=");
        f381764d = FxCVY.b("F7V8SjDFWDGEHyhQJR/vmJ2PsYQvMxifBN46aQ==");
        f381765e = FxCVY.b("loortpg4288gBQkZu13SWTiWdIoZjskllRDZLQ==");
        f381766f = FxCVY.b("6DSRX7wn8gyuk+q/kxETe0VQRVj1BK8BZd0Lbw==");
        f381767g = FxCVY.b("u2xfuQx4IjM=");
        f381768h = FxCVY.b("Mnyu7C/RGC+JS0uIqev/3mXSPxY=");
        f381769i = FxCVY.b("Z86b4PLjU2vaBVXm");
        f381770j = FxCVY.b("E/elQq9Fz2/OYi4i");
        f381771k = FxCVY.b("CX8j6UeNDbaimerGJKcSkIzaGUY3pwfjnkV71g==");
    }
}
