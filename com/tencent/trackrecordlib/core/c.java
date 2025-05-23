package com.tencent.trackrecordlib.core;

import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.trackrecordlib.b.f;
import com.tencent.trackrecordlib.b.g;
import com.tencent.trackrecordlib.b.i;
import com.tencent.trackrecordlib.c.d;
import com.tencent.trackrecordlib.enums.UiAction;
import com.tencent.trackrecordlib.enums.UiActionKey;
import com.tencent.trackrecordlib.enums.UiActionScreenRotation;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String f381038a;

    /* renamed from: b, reason: collision with root package name */
    private static LinkedList<String> f381039b;

    /* renamed from: c, reason: collision with root package name */
    private static int f381040c;

    /* renamed from: d, reason: collision with root package name */
    private static long f381041d;

    /* renamed from: e, reason: collision with root package name */
    private float f381042e;

    /* renamed from: f, reason: collision with root package name */
    private float f381043f;

    /* renamed from: g, reason: collision with root package name */
    private float f381044g;

    /* renamed from: h, reason: collision with root package name */
    private float f381045h;

    /* renamed from: i, reason: collision with root package name */
    private float f381046i;

    /* renamed from: j, reason: collision with root package name */
    private float f381047j;

    /* renamed from: k, reason: collision with root package name */
    private long f381048k;

    /* renamed from: l, reason: collision with root package name */
    private int f381049l;

    /* renamed from: m, reason: collision with root package name */
    private int f381050m;

    /* renamed from: n, reason: collision with root package name */
    private float f381051n;

    /* renamed from: o, reason: collision with root package name */
    private float f381052o;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final c f381080a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11153);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f381080a = new c(null);
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11188);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        f381038a = c.class.getSimpleName();
        f381039b = new LinkedList<>();
        f381040c = 0;
        f381041d = 0L;
    }

    /* synthetic */ c(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return;
        }
        iPatchRedirector.redirect((short) 12, (Object) this, (Object) anonymousClass1);
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f381049l = -1;
            this.f381050m = -1;
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            d.a(new Runnable() { // from class: com.tencent.trackrecordlib.core.c.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) c.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.trackrecordlib.c.d a16 = new d.a().a(UiAction.KEY).a(f.a(UiActionKey.LOCK)).h(com.tencent.trackrecordlib.g.b.b()).g(com.tencent.trackrecordlib.g.b.c()).a();
                    RecordManager.getInstance().recordEvent(a16);
                    c.this.b(a16);
                }
            });
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            d.a(new Runnable() { // from class: com.tencent.trackrecordlib.core.c.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) c.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.trackrecordlib.c.d a16 = new d.a().a(UiAction.KEY).a(f.a(UiActionKey.HOME)).h(com.tencent.trackrecordlib.g.b.b()).g(com.tencent.trackrecordlib.g.b.c()).a();
                    RecordManager.getInstance().recordEvent(a16);
                    c.this.b(a16);
                }
            });
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            d.a(new Runnable() { // from class: com.tencent.trackrecordlib.core.c.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) c.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.trackrecordlib.c.d a16 = new d.a().a(UiAction.KEY).a(f.a(UiActionKey.BACK)).h(com.tencent.trackrecordlib.g.b.a()).g(com.tencent.trackrecordlib.g.b.d()).a();
                    RecordManager.getInstance().recordEvent(a16);
                    c.this.b(a16);
                }
            });
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return f381040c > 0 ? f381039b.toString() : "noCachedEvents";
    }

    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            d.a(new Runnable(i3) { // from class: com.tencent.trackrecordlib.core.c.5
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f381069a;

                {
                    this.f381069a = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) c.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    g a16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int i16 = this.f381069a;
                    if (i16 != 0) {
                        if (i16 != 1) {
                            if (i16 != 2) {
                                if (i16 != 3) {
                                    a16 = null;
                                } else {
                                    a16 = f.a(UiActionScreenRotation.RIGHT);
                                }
                            } else {
                                a16 = f.a(UiActionScreenRotation.ROLLBACK);
                            }
                        } else {
                            a16 = f.a(UiActionScreenRotation.LEFT);
                        }
                    } else {
                        a16 = f.a(UiActionScreenRotation.NATURAL);
                    }
                    com.tencent.trackrecordlib.c.d a17 = new d.a().a(UiAction.SCREEN_ROTATION).a(a16).h(com.tencent.trackrecordlib.g.b.b()).g(com.tencent.trackrecordlib.g.b.c()).a();
                    RecordManager.getInstance().recordEvent(a17);
                    c.this.b(a17);
                }
            });
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.tencent.trackrecordlib.c.b bVar) {
        if (f381040c <= 0 || bVar == null) {
            return;
        }
        String jSONObject = bVar.e().toString();
        try {
            if (f381041d < f381040c) {
                f381039b.addLast(jSONObject + "\r\n");
                f381041d = f381041d + 1;
            } else {
                f381039b.removeFirst();
                f381039b.addLast(jSONObject + "\r\n");
            }
        } catch (Throwable th5) {
            Log.e(f381038a, "\u5199\u5165\u4e8b\u4ef6\u961f\u5217\u5931\u8d25\uff01");
            th5.printStackTrace();
        }
    }

    public static c a() {
        return a.f381080a;
    }

    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            f381040c = i3;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }

    public void a(View view, int i3, int i16, long j3, long j16, float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            d.a(new Runnable(i3, i16, j3, f16, f17, f18, f19, j16, view) { // from class: com.tencent.trackrecordlib.core.c.1
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f381053a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ int f381054b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ long f381055c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ float f381056d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ float f381057e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ float f381058f;

                /* renamed from: g, reason: collision with root package name */
                final /* synthetic */ float f381059g;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ long f381060h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ View f381061i;

                {
                    this.f381053a = i3;
                    this.f381054b = i16;
                    this.f381055c = j3;
                    this.f381056d = f16;
                    this.f381057e = f17;
                    this.f381058f = f18;
                    this.f381059g = f19;
                    this.f381060h = j16;
                    this.f381061i = view;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, c.this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Long.valueOf(j16), view);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    i a16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        int i17 = this.f381053a & 255;
                        if (i17 == 0) {
                            c.this.f381049l = this.f381054b;
                            c.this.f381048k = this.f381055c;
                            c.this.f381042e = this.f381056d;
                            c.this.f381043f = this.f381057e;
                            c.this.f381051n = this.f381058f;
                            c.this.f381052o = this.f381059g;
                            return;
                        }
                        if (i17 != 1) {
                            if (i17 == 5) {
                                c.this.f381050m = this.f381054b;
                                c.this.f381044g = this.f381056d;
                                c.this.f381045h = this.f381057e;
                                return;
                            } else {
                                if (i17 != 6) {
                                    return;
                                }
                                c.this.f381046i = this.f381056d;
                                c.this.f381047j = this.f381057e;
                                return;
                            }
                        }
                        int i18 = (int) (this.f381060h - c.this.f381048k);
                        String str = null;
                        if (c.this.f381049l == -1 || c.this.f381050m != -1) {
                            if (c.this.f381049l != -1 && c.this.f381050m != -1) {
                                if (c.this.f381049l == this.f381054b) {
                                    a16 = f.a((int) c.this.f381042e, (int) c.this.f381043f, (int) c.this.f381044g, (int) c.this.f381045h, (int) this.f381056d, (int) this.f381057e, (int) c.this.f381046i, (int) c.this.f381047j);
                                } else {
                                    a16 = c.this.f381050m == this.f381054b ? f.a((int) c.this.f381042e, (int) c.this.f381043f, (int) c.this.f381044g, (int) c.this.f381045h, (int) c.this.f381046i, (int) c.this.f381047j, (int) this.f381056d, (int) this.f381057e) : null;
                                }
                                d.a b16 = new d.a().a(UiAction.ZOOM).a(a16).a(this.f381061i.getClass().getName()).b(com.tencent.trackrecordlib.g.i.a(this.f381061i));
                                if (!RecordManager.getInstance().f381005b || !(this.f381061i instanceof EditText)) {
                                    str = com.tencent.trackrecordlib.g.i.c(this.f381061i);
                                }
                                com.tencent.trackrecordlib.c.d a17 = b16.c(str).d(com.tencent.trackrecordlib.g.i.b(this.f381061i)).e(com.tencent.trackrecordlib.g.i.f(this.f381061i)).f(com.tencent.trackrecordlib.g.i.d(this.f381061i)).h(com.tencent.trackrecordlib.g.b.b()).g(com.tencent.trackrecordlib.g.b.c()).a();
                                RecordManager.getInstance().recordEvent(a17);
                                c.this.b(a17);
                            }
                        } else {
                            boolean a18 = c.this.a(this.f381058f, this.f381059g);
                            boolean a19 = c.this.a(this.f381060h);
                            if (!a18 && !a19) {
                                d.a b17 = new d.a().a(UiAction.CLICK).a(f.a((int) this.f381056d, (int) this.f381057e, (int) this.f381058f, (int) this.f381059g)).a(this.f381061i.getClass().getName()).b(com.tencent.trackrecordlib.g.i.a(this.f381061i));
                                if (!RecordManager.getInstance().f381005b || !(this.f381061i instanceof EditText)) {
                                    str = com.tencent.trackrecordlib.g.i.c(this.f381061i);
                                }
                                com.tencent.trackrecordlib.c.d a26 = b17.c(str).d(com.tencent.trackrecordlib.g.i.b(this.f381061i)).e(com.tencent.trackrecordlib.g.i.f(this.f381061i)).f(com.tencent.trackrecordlib.g.i.d(this.f381061i)).h(com.tencent.trackrecordlib.g.b.b()).g(com.tencent.trackrecordlib.g.b.c()).a();
                                RecordManager.getInstance().recordEvent(a26);
                                c.this.b(a26);
                            } else if (!a18) {
                                d.a b18 = new d.a().a(UiAction.LONG_PRESS).a(f.a((int) this.f381056d, (int) this.f381057e, (int) this.f381058f, (int) this.f381059g, i18)).a(this.f381061i.getClass().getName()).b(com.tencent.trackrecordlib.g.i.a(this.f381061i));
                                if (!RecordManager.getInstance().f381005b || !(this.f381061i instanceof EditText)) {
                                    str = com.tencent.trackrecordlib.g.i.c(this.f381061i);
                                }
                                com.tencent.trackrecordlib.c.d a27 = b18.c(str).d(com.tencent.trackrecordlib.g.i.b(this.f381061i)).e(com.tencent.trackrecordlib.g.i.f(this.f381061i)).f(com.tencent.trackrecordlib.g.i.d(this.f381061i)).h(com.tencent.trackrecordlib.g.b.b()).g(com.tencent.trackrecordlib.g.b.c()).a();
                                RecordManager.getInstance().recordEvent(a27);
                                c.this.b(a27);
                            } else {
                                d.a b19 = new d.a().a(UiAction.SCROLL).a(f.a((int) c.this.f381042e, (int) c.this.f381043f, (int) this.f381056d, (int) this.f381057e, (int) c.this.f381051n, (int) c.this.f381052o, (int) this.f381058f, (int) this.f381059g, i18)).a(this.f381061i.getClass().getName()).b(com.tencent.trackrecordlib.g.i.a(this.f381061i));
                                if (!RecordManager.getInstance().f381005b || !(this.f381061i instanceof EditText)) {
                                    str = com.tencent.trackrecordlib.g.i.c(this.f381061i);
                                }
                                com.tencent.trackrecordlib.c.d a28 = b19.c(str).d(com.tencent.trackrecordlib.g.i.b(this.f381061i)).e(com.tencent.trackrecordlib.g.i.f(this.f381061i)).f(com.tencent.trackrecordlib.g.i.d(this.f381061i)).h(com.tencent.trackrecordlib.g.b.b()).g(com.tencent.trackrecordlib.g.b.c()).a();
                                RecordManager.getInstance().recordEvent(a28);
                                c.this.b(a28);
                            }
                        }
                        c.this.f381049l = -1;
                        c.this.f381050m = -1;
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
            });
        } else {
            iPatchRedirector.redirect((short) 3, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Long.valueOf(j16), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
        }
    }

    public void a(View view, int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            d.a(new Runnable(keyEvent) { // from class: com.tencent.trackrecordlib.core.c.2
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ KeyEvent f381063a;

                {
                    this.f381063a = keyEvent;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) c.this, (Object) keyEvent);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.trackrecordlib.b.d a16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (this.f381063a.getAction() == 1) {
                            int keyCode = this.f381063a.getKeyCode();
                            if (keyCode != 3) {
                                if (keyCode != 4) {
                                    switch (keyCode) {
                                        case 24:
                                            a16 = f.a(UiActionKey.VOLUME_PLUS);
                                            break;
                                        case 25:
                                            a16 = f.a(UiActionKey.VOLUME_SUB);
                                            break;
                                        case 26:
                                            a16 = f.a(UiActionKey.LOCK);
                                            break;
                                        default:
                                            a16 = null;
                                            break;
                                    }
                                } else {
                                    a16 = f.a(UiActionKey.BACK);
                                }
                            } else {
                                a16 = f.a(UiActionKey.HOME);
                            }
                            com.tencent.trackrecordlib.c.d a17 = new d.a().a(UiAction.KEY).a(a16).h(com.tencent.trackrecordlib.g.b.b()).g(com.tencent.trackrecordlib.g.b.c()).a();
                            RecordManager.getInstance().recordEvent(a17);
                            c.this.b(a17);
                        }
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
            });
        } else {
            iPatchRedirector.redirect((short) 4, this, view, Integer.valueOf(i3), keyEvent);
        }
    }

    public void a(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            d.a(new Runnable(i3, view) { // from class: com.tencent.trackrecordlib.core.c.3
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f381065a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ View f381066b;

                {
                    this.f381065a = i3;
                    this.f381066b = view;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, c.this, Integer.valueOf(i3), view);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String c16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int i16 = this.f381065a;
                    if (i16 == 16 || i16 == 8192) {
                        if (c.this.a(this.f381066b)) {
                            Log.w(c.f381038a, "This event conatain message of password,it will be abandon,record input event intead of.");
                        } else {
                            d.a b16 = new d.a().a(UiAction.INPUT).a(this.f381066b.getClass().getName()).b(com.tencent.trackrecordlib.g.i.a(this.f381066b));
                            if (RecordManager.getInstance().f381005b && (this.f381066b instanceof EditText)) {
                                c16 = null;
                            } else {
                                c16 = com.tencent.trackrecordlib.g.i.c(this.f381066b);
                            }
                            com.tencent.trackrecordlib.c.d a16 = b16.c(c16).d(com.tencent.trackrecordlib.g.i.b(this.f381066b)).e(com.tencent.trackrecordlib.g.i.f(this.f381066b)).f(com.tencent.trackrecordlib.g.i.d(this.f381066b)).h(com.tencent.trackrecordlib.g.b.b()).g(com.tencent.trackrecordlib.g.b.c()).a();
                            RecordManager.getInstance().recordEvent(a16);
                            c.this.b(a16);
                        }
                    }
                    Log.d(c.f381038a, "End record accessibility event.");
                }
            });
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, i3);
        }
    }

    public void a(com.tencent.trackrecordlib.c.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            d.a(new Runnable(bVar) { // from class: com.tencent.trackrecordlib.core.c.8
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ com.tencent.trackrecordlib.c.b f381073a;

                {
                    this.f381073a = bVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) c.this, (Object) bVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        RecordManager.getInstance().recordEvent(this.f381073a);
                        c.this.b(this.f381073a);
                    }
                }
            });
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar);
        }
    }

    public void a(View view, int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            d.a(new Runnable(i3, view, str, str2) { // from class: com.tencent.trackrecordlib.core.c.9
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f381075a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ View f381076b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ String f381077c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f381078d;

                {
                    this.f381075a = i3;
                    this.f381076b = view;
                    this.f381077c = str;
                    this.f381078d = str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, c.this, Integer.valueOf(i3), view, str, str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String c16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    d.a b16 = new d.a().a(UiAction.EXPOSE).a(f.a(this.f381075a)).a(this.f381076b.getClass().getName()).b(com.tencent.trackrecordlib.g.i.a(this.f381076b));
                    if (RecordManager.getInstance().f381005b && (this.f381076b instanceof EditText)) {
                        c16 = null;
                    } else {
                        c16 = com.tencent.trackrecordlib.g.i.c(this.f381076b);
                    }
                    com.tencent.trackrecordlib.c.d a16 = b16.c(c16).d(com.tencent.trackrecordlib.g.i.b(this.f381076b)).e(com.tencent.trackrecordlib.g.i.f(this.f381076b)).f(com.tencent.trackrecordlib.g.i.d(this.f381076b)).h(this.f381077c).g(this.f381078d).a();
                    RecordManager.getInstance().recordEvent(a16);
                    c.this.b(a16);
                }
            });
        } else {
            iPatchRedirector.redirect((short) 11, this, view, Integer.valueOf(i3), str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(float f16, float f17) {
        return Math.abs(f16 - this.f381051n) > 10.0f || Math.abs(f17 - this.f381052o) > 10.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(long j3) {
        return j3 - this.f381048k > ((long) com.tencent.trackrecordlib.g.c.f381139e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view) {
        return (view instanceof EditText) && (((EditText) view).getTransformationMethod() instanceof PasswordTransformationMethod);
    }
}
