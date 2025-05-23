package com.tencent.qqnt.selectable;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class a implements i<Object>, Handler.Callback {
    static IPatchRedirector $redirector_;
    private static final int U;
    private static final int V;
    private static final int W;
    private static final int X;
    private List<WeakReference<c>> C;
    private int D;
    private int E;
    private boolean F;
    private final int[] G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int[] N;
    private float P;
    public long Q;
    Object R;
    private final Handler S;
    private boolean T;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<b> f362087d;

    /* renamed from: e, reason: collision with root package name */
    private g f362088e;

    /* renamed from: f, reason: collision with root package name */
    private h f362089f;

    /* renamed from: h, reason: collision with root package name */
    private h f362090h;

    /* renamed from: i, reason: collision with root package name */
    protected k f362091i;

    /* renamed from: m, reason: collision with root package name */
    private j f362092m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.qqnt.selectable.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C9695a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final a f362093a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30442);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f362093a = new a();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30446);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 46)) {
            redirector.redirect((short) 46);
            return;
        }
        U = ViewUtils.dpToPx(30.0f);
        V = ViewUtils.dpToPx(28.0f);
        W = ViewUtils.dpToPx(72.0f);
        X = ViewUtils.dpToPx(63.0f);
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.C = new ArrayList();
        this.D = -1;
        this.E = -1;
        this.F = false;
        this.G = new int[2];
        this.H = -1;
        this.I = -1;
        this.J = -1;
        this.K = -1;
        this.N = new int[]{0, 0};
        this.P = 1.0f;
        this.Q = -1L;
        this.T = true;
        this.S = new Handler(Looper.getMainLooper(), this);
    }

    private void A() {
        this.f362088e.n(this.L);
        this.f362088e.j(this.D, this.E);
        this.f362088e.m();
        this.f362089f.a(this.M);
        this.f362090h.a(this.M);
        this.f362088e.i(this.D, this.G, true);
        h hVar = this.f362089f;
        int[] iArr = this.G;
        hVar.e(iArr[0], iArr[1], 1);
        this.f362088e.i(this.E, this.G, false);
        h hVar2 = this.f362090h;
        int[] iArr2 = this.G;
        hVar2.e(iArr2[0], iArr2[1], 2);
    }

    public static a C() {
        return C9695a.f362093a;
    }

    private void D() {
        Iterator<WeakReference<c>> it = this.C.iterator();
        while (it.hasNext()) {
            c cVar = it.next().get();
            if (cVar != null) {
                cVar.a(this);
            }
        }
    }

    private boolean u() {
        if (this.f362088e == null) {
            return false;
        }
        return true;
    }

    private void v() {
        if (this.f362089f != null && this.f362090h != null) {
        } else {
            throw new IllegalStateException("Has not bound cursors.");
        }
    }

    private void w() {
        if (this.f362092m != null) {
        } else {
            throw new IllegalStateException("Has no magnifier.");
        }
    }

    private boolean x() {
        if (this.f362091i == null) {
            return false;
        }
        return true;
    }

    private void y() {
        g gVar = this.f362088e;
        if (gVar instanceof e) {
            ((e) gVar).setCursorOffset(this.N, this.P);
        }
        h hVar = this.f362089f;
        if (hVar instanceof f) {
            ((f) hVar).c(this.N, this.P);
        }
        h hVar2 = this.f362090h;
        if (hVar2 instanceof f) {
            ((f) hVar2).c(this.N, this.P);
        }
    }

    void B() {
        if (this.f362091i != null) {
            this.S.removeMessages(1);
            if (this.f362091i.isShow()) {
                this.f362091i.dismiss();
            }
        }
        g gVar = this.f362088e;
        if (gVar != null) {
            gVar.j(-1, -1);
            this.f362088e.h();
            this.f362088e = null;
        }
        h hVar = this.f362089f;
        if (hVar != null) {
            if (hVar.d(1)) {
                this.f362089f.b(1);
            }
            this.f362089f = null;
        }
        h hVar2 = this.f362090h;
        if (hVar2 != null) {
            if (hVar2.d(2)) {
                this.f362090h.b(2);
            }
            this.f362090h = null;
        }
        G(null);
    }

    public boolean E(int i3, int i16) {
        g gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        if (!isSelected() || (gVar = this.f362088e) == null) {
            return false;
        }
        View f16 = gVar.f();
        f16.getLocationInWindow(this.G);
        int[] iArr = this.G;
        int i17 = iArr[0];
        int i18 = iArr[1];
        int measuredWidth = f16.getMeasuredWidth() + i17;
        int measuredHeight = f16.getMeasuredHeight() + i18;
        if (i3 >= i17 && i3 <= measuredWidth && i16 >= i18 && i16 <= measuredHeight) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public b F() {
        WeakReference<b> weakReference = this.f362087d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(@Nullable b bVar) {
        WeakReference<b> weakReference = this.f362087d;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f362087d = new WeakReference<>(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void H(int i3) {
        int f16;
        int e16;
        int i16;
        int i17;
        int i18;
        int i19;
        View findViewById;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, i3);
            return;
        }
        if (!u() || !x()) {
            return;
        }
        k kVar = this.f362091i;
        if (kVar instanceof com.tencent.qqnt.textpreview.inject.a) {
            f16 = ((com.tencent.qqnt.textpreview.inject.a) kVar).c();
        } else {
            f16 = kVar.f();
        }
        k kVar2 = this.f362091i;
        if (kVar2 instanceof com.tencent.qqnt.textpreview.inject.a) {
            e16 = ((com.tencent.qqnt.textpreview.inject.a) kVar2).b();
        } else {
            e16 = kVar2.e();
        }
        View f17 = this.f362088e.f();
        if (f17.getId() != R.id.chat_item_content_layout && (findViewById = f17.findViewById(R.id.chat_item_content_layout)) != null) {
            f17 = findViewById;
        }
        f17.getLocationInWindow(this.G);
        int i26 = 1;
        int i27 = this.G[1];
        int height = f17.getHeight() + i27;
        int paddingLeft = this.G[0] + this.f362088e.f().getPaddingLeft();
        this.f362088e.i(this.D, this.G, true);
        int[] iArr = this.G;
        int i28 = iArr[0];
        this.f362088e.i(this.E, iArr, false);
        int i29 = this.G[0];
        if (this.I == 2) {
            int i36 = i29 - f16;
            int i37 = U;
            if (i36 > i37 || i36 < 0) {
                if (i29 - i37 >= paddingLeft) {
                    i29 -= i37;
                }
                int i38 = V;
                i16 = i27 - i38;
                i17 = W;
                i18 = ImmersiveUtils.statusHeight;
                if (i16 >= i17 + i18) {
                    int i39 = height + 0;
                    if (i39 < i17 + i18) {
                        if (e16 != 0 && e16 - i38 > i17 + i18) {
                            i19 = e16 - i38;
                            i26 = 0;
                        } else if (e16 != 0 && (X + e16) - i38 < i3) {
                            i19 = e16 - i38;
                        } else {
                            i19 = i17 + i18;
                        }
                    } else {
                        int i46 = X;
                        if (i39 + i46 > i3) {
                            if (e16 != 0 && e16 - i38 > i17 + i18) {
                                i39 = e16 - i38;
                                i26 = 0;
                            } else if (e16 != 0 && (e16 + i46) - i38 < i3) {
                                i39 = e16 - i38;
                            } else {
                                i39 = i17 + i18 + i46 + i38;
                                i26 = 0;
                            }
                            i19 = i39;
                        }
                        f16 = i29;
                        i19 = i39;
                    }
                    K(f16, i19, i26);
                }
                if (i27 <= i3) {
                    i3 = i27 - i38;
                }
                i19 = i3;
                i26 = 0;
                f16 = i29;
                K(f16, i19, i26);
            }
            i29 = f16;
            int i382 = V;
            i16 = i27 - i382;
            i17 = W;
            i18 = ImmersiveUtils.statusHeight;
            if (i16 >= i17 + i18) {
            }
            i26 = 0;
            f16 = i29;
            K(f16, i19, i26);
        }
        int i47 = f16 - i28;
        int i48 = U;
        if (i47 > i48 || i47 < 0) {
            i29 = i48 + i28;
            int i3822 = V;
            i16 = i27 - i3822;
            i17 = W;
            i18 = ImmersiveUtils.statusHeight;
            if (i16 >= i17 + i18) {
            }
            i26 = 0;
            f16 = i29;
            K(f16, i19, i26);
        }
        i29 = f16;
        int i38222 = V;
        i16 = i27 - i38222;
        i17 = W;
        i18 = ImmersiveUtils.statusHeight;
        if (i16 >= i17 + i18) {
        }
        i26 = 0;
        f16 = i29;
        K(f16, i19, i26);
    }

    public void I(View view) {
        int screenHeight;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) view);
            return;
        }
        if (view != null) {
            view.getLocationInWindow(this.G);
            screenHeight = this.G[1];
        } else {
            screenHeight = ViewUtils.getScreenHeight();
        }
        H(screenHeight);
    }

    @Nullable
    public String J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        u();
        CharSequence k3 = this.f362088e.k();
        if (k3 != null) {
            return k3.toString();
        }
        return null;
    }

    public void K(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        u();
        x();
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i3;
        obtain.arg2 = i16;
        obtain.obj = Integer.valueOf(i17);
        this.S.sendMessageDelayed(obtain, 10L);
    }

    @Override // com.tencent.qqnt.selectable.i
    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, i3);
        } else {
            this.M = i3;
        }
    }

    @Override // com.tencent.qqnt.selectable.i
    public int b(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        u();
        return this.f362088e.b(i3, i16);
    }

    @Override // com.tencent.qqnt.selectable.i
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqnt.selectable.i
    public void d(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.H = i3;
        if (!z16) {
            this.I = i3;
        }
    }

    @Override // com.tencent.qqnt.selectable.i
    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, i3);
        } else {
            this.L = i3;
        }
    }

    @Override // com.tencent.qqnt.selectable.i
    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        u();
        return this.E;
    }

    @Override // com.tencent.qqnt.selectable.i
    public void g(@NonNull k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) kVar);
        } else {
            this.f362091i = kVar;
        }
    }

    @Override // com.tencent.qqnt.selectable.i
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            I(null);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        h hVar;
        h hVar2;
        k kVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == 1) {
            this.S.removeMessages(1);
            g gVar = this.f362088e;
            if (gVar != null && (kVar = this.f362091i) != null) {
                kVar.a(gVar.f(), message.arg1, message.arg2, ((Integer) message.obj).intValue());
                j jVar = this.f362092m;
                if (jVar != null && jVar.isShow()) {
                    this.f362092m.dismiss();
                }
            }
            return true;
        }
        if (i3 == 2) {
            this.S.removeMessages(2);
            this.S.removeMessages(3);
            if (this.f362092m != null) {
                if (((Integer) message.obj).intValue() == 1) {
                    hVar2 = this.f362089f;
                } else {
                    hVar2 = this.f362090h;
                }
                if (hVar2 != null && this.f362088e != null) {
                    this.f362092m.a(hVar2.f(), message.arg1, message.arg2, this.f362088e.f(), true);
                    return false;
                }
                return false;
            }
            return false;
        }
        if (i3 == 3) {
            this.S.removeMessages(2);
            this.S.removeMessages(3);
            if (this.f362092m != null) {
                if (((Integer) message.obj).intValue() == 1) {
                    hVar = this.f362089f;
                } else {
                    hVar = this.f362090h;
                }
                if (hVar != null && this.f362088e != null) {
                    this.f362092m.a(hVar.f(), message.arg1, message.arg2, this.f362088e.f(), false);
                    return false;
                }
                return false;
            }
            return false;
        }
        if (i3 == 4) {
            this.S.removeMessages(4);
            if (this.f362088e != null && this.f362089f != null && this.f362090h != null) {
                A();
                h();
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.qqnt.selectable.i
    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.H;
    }

    @Override // com.tencent.qqnt.selectable.i
    public boolean isSelected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        return this.F;
    }

    @Override // com.tencent.qqnt.selectable.i
    public void j(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 != -1 && i16 != -1) {
            if (i3 > i16) {
                this.D = i16;
                this.E = i3;
            } else {
                this.D = i3;
                this.E = i16;
            }
            if (this.E - this.D > 0) {
                this.F = true;
            }
        } else {
            this.D = -1;
            this.E = -1;
            this.F = false;
        }
        u();
        this.f362088e.j(this.D, this.E);
        this.f362088e.m();
        v();
        this.f362088e.i(this.D, this.G, true);
        h hVar = this.f362089f;
        int[] iArr = this.G;
        hVar.e(iArr[0], iArr[1], 1);
        this.f362088e.i(this.E, this.G, false);
        h hVar2 = this.f362090h;
        int[] iArr2 = this.G;
        hVar2.e(iArr2[0], iArr2[1], 2);
        D();
    }

    @Override // com.tencent.qqnt.selectable.i
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            x();
            this.f362091i.dismiss();
        }
    }

    @Override // com.tencent.qqnt.selectable.i
    public void l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.I = i3;
        }
    }

    @Override // com.tencent.qqnt.selectable.i
    public int length() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        u();
        g gVar = this.f362088e;
        if (gVar != null) {
            return gVar.contentLength();
        }
        return 0;
    }

    @Override // com.tencent.qqnt.selectable.i
    public void m(int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        u();
        w();
        if (this.H == -1 || !this.T) {
            return;
        }
        Message obtain = Message.obtain();
        if (z16) {
            i17 = 2;
        }
        obtain.what = i17;
        obtain.arg1 = i3;
        obtain.arg2 = i16;
        obtain.obj = Integer.valueOf(this.H);
        this.S.sendMessageDelayed(obtain, 10L);
    }

    @Override // com.tencent.qqnt.selectable.i
    public void n(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, obj);
            return;
        }
        if (this.f362088e == null) {
            return;
        }
        u();
        this.D = 0;
        int contentLength = this.f362088e.contentLength();
        this.E = contentLength;
        if (this.D >= contentLength) {
            this.F = false;
            return;
        }
        this.Q = System.currentTimeMillis();
        this.R = obj;
        this.F = true;
        this.f362088e.n(this.L);
        this.f362088e.j(this.D, this.E);
        this.f362088e.m();
        v();
        this.H = -1;
        this.I = -1;
        this.J = -1;
        this.K = -1;
        this.f362089f.a(this.M);
        this.f362090h.a(this.M);
        y();
        this.f362088e.i(this.D, this.G, true);
        h hVar = this.f362089f;
        int[] iArr = this.G;
        hVar.e(iArr[0], iArr[1], 1);
        this.f362088e.i(this.E, this.G, false);
        h hVar2 = this.f362090h;
        int[] iArr2 = this.G;
        hVar2.e(iArr2[0], iArr2[1], 2);
        h();
        j jVar = this.f362092m;
        if (jVar == null) {
            d dVar = new d();
            this.f362092m = dVar;
            dVar.c(this.N, this.P);
        } else if (jVar.isShow()) {
            this.f362092m.dismiss();
        }
        D();
    }

    @Override // com.tencent.qqnt.selectable.i
    public boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        k kVar = this.f362091i;
        if (kVar != null) {
            return kVar.isShow();
        }
        return false;
    }

    @Override // com.tencent.qqnt.selectable.i
    public void p(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.J = i3;
            this.K = i16;
        }
    }

    @Override // com.tencent.qqnt.selectable.i
    public int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        u();
        return this.D;
    }

    @Override // com.tencent.qqnt.selectable.i
    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        } else {
            D();
        }
    }

    public void s(@NonNull g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) gVar);
        } else {
            this.f362088e = gVar;
        }
    }

    public void t(@NonNull h hVar, @NonNull h hVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) hVar, (Object) hVar2);
        } else {
            this.f362089f = hVar;
            this.f362090h = hVar2;
        }
    }

    public void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        this.R = null;
        j jVar = this.f362092m;
        if (jVar != null) {
            if (jVar.isShow()) {
                this.f362092m.dismiss();
            }
            this.f362092m = null;
        }
        B();
        this.f362091i = null;
        this.F = false;
        this.D = -1;
        this.E = -1;
        this.H = -1;
        this.I = -1;
        this.J = -1;
        this.K = -1;
        this.Q = -1L;
        D();
    }
}
