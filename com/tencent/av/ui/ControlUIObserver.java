package com.tencent.av.ui;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.at;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.utils.cp;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ControlUIObserver implements Observer {

    /* renamed from: d, reason: collision with root package name */
    Handler f74767d = null;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private long f74769a = 0;

        /* renamed from: b, reason: collision with root package name */
        String f74770b = null;

        /* renamed from: c, reason: collision with root package name */
        private int f74771c;

        a(int i3) {
            this.f74771c = i3;
        }

        public long a() {
            if (this.f74769a == 0 && com.tencent.av.utils.e.j()) {
                throw new IllegalArgumentException("seq\u672a\u521d\u59cb\u5316:" + getClass().getSimpleName());
            }
            return this.f74769a;
        }

        public void b(VideoAppInterface videoAppInterface) {
            if (videoAppInterface == null) {
                return;
            }
            videoAppInterface.k0(new Object[]{Integer.valueOf(this.f74771c), this});
        }

        public void c(long j3, String str) {
            this.f74769a = j3;
            this.f74770b = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b extends c {

        /* renamed from: f, reason: collision with root package name */
        public int f74772f;

        /* renamed from: g, reason: collision with root package name */
        public int f74773g;

        public b(View view, int i3) {
            super(view);
            this.f74773g = -1;
            this.f74772f = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class d extends c {

        /* renamed from: i, reason: collision with root package name */
        public static String f74776i;

        /* renamed from: j, reason: collision with root package name */
        public static boolean f74777j;

        /* renamed from: k, reason: collision with root package name */
        public static int f74778k;

        /* renamed from: f, reason: collision with root package name */
        public final String f74779f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f74780g;

        /* renamed from: h, reason: collision with root package name */
        public final int f74781h;

        public d(long j3, String str, boolean z16, int i3) {
            super(6100, null);
            c(j3, null);
            this.f74779f = str;
            this.f74780g = z16;
            this.f74781h = i3;
            f74776i = str;
            f74777j = z16;
            f74778k = i3;
        }

        public String toString() {
            return "mId[" + this.f74779f + "], mFrom[" + this.f74781h + "], mSender[" + this.f74780g + "], seq[" + a() + "]";
        }
    }

    public static <T extends a> T c(Object[] objArr) {
        return (T) objArr[1];
    }

    void b(Object obj) {
        String str;
        int i3;
        Object[] objArr = (Object[]) obj;
        int i16 = 0;
        int intValue = ((Integer) objArr[0]).intValue();
        if (intValue != 118) {
            if (intValue != 119) {
                if (intValue != 6104) {
                    if (intValue != 6105) {
                        if (intValue != 9006) {
                            if (intValue != 9007) {
                                if (intValue != 15001) {
                                    if (intValue != 15002) {
                                        switch (intValue) {
                                            case 101:
                                                k(at.e(objArr, 1));
                                                return;
                                            case 102:
                                                u();
                                                return;
                                            case 103:
                                                Q(at.e(objArr, 2), (ArrayList) objArr[1], ((Boolean) objArr[3]).booleanValue());
                                                return;
                                            case 104:
                                                i((ArrayList) objArr[1]);
                                                return;
                                            case 105:
                                                O(((Boolean) objArr[1]).booleanValue(), at.e(objArr, 2));
                                                return;
                                            case 106:
                                                I(at.e(objArr, 1));
                                                return;
                                            case 107:
                                                R(at.e(objArr, 1));
                                                return;
                                            case 108:
                                                r();
                                                return;
                                            case 109:
                                                h();
                                                return;
                                            case 110:
                                                S(at.e(objArr, 1));
                                                return;
                                            case 111:
                                                l(((Boolean) objArr[1]).booleanValue());
                                                return;
                                            default:
                                                switch (intValue) {
                                                    case 113:
                                                        j();
                                                        return;
                                                    case 115:
                                                        m((String) objArr[1], ((Integer) objArr[2]).intValue(), (String) objArr[3], ((Integer) objArr[4]).intValue());
                                                        return;
                                                    case 129:
                                                        break;
                                                    case 134:
                                                        x();
                                                        return;
                                                    case 167:
                                                        g(((Boolean) objArr[1]).booleanValue());
                                                        return;
                                                    case 169:
                                                        C((cp.b) objArr[1]);
                                                        return;
                                                    case 172:
                                                        n(((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), (String) objArr[3]);
                                                        return;
                                                    case 174:
                                                        q(at.e(objArr, 1));
                                                        return;
                                                    case 1001:
                                                        U();
                                                        return;
                                                    case AppConstants.RichMediaErrorCode.ERROR_NET_SOCKET_EXCEPTION /* 9051 */:
                                                        B();
                                                        return;
                                                    case 9100:
                                                        if (objArr.length > 4) {
                                                            str = (String) objArr[3];
                                                            i3 = ((Integer) objArr[4]).intValue();
                                                        } else {
                                                            str = null;
                                                            i3 = -2;
                                                        }
                                                        T(((Integer) objArr[1]).intValue(), ((Boolean) objArr[2]).booleanValue(), str, i3);
                                                        return;
                                                    case FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_TIME_OUT /* 9205 */:
                                                        H();
                                                        return;
                                                    case 10005:
                                                        d();
                                                        return;
                                                    case 20001:
                                                        F(at.e(objArr, 1), ((Boolean) objArr[2]).booleanValue(), (String) objArr[3]);
                                                        return;
                                                    case 22204:
                                                        v(((Boolean) objArr[1]).booleanValue());
                                                        return;
                                                    default:
                                                        switch (intValue) {
                                                            case 123:
                                                                if (objArr.length > 1) {
                                                                    i16 = ((Integer) objArr[1]).intValue();
                                                                }
                                                                E(at.e(objArr, 2), i16);
                                                                return;
                                                            case 124:
                                                                K(at.e(objArr, 1));
                                                                return;
                                                            case 125:
                                                                N(at.e(objArr, 1));
                                                                return;
                                                            case 126:
                                                                J(at.e(objArr, 3), ((Boolean) objArr[1]).booleanValue(), ((Integer) objArr[2]).intValue());
                                                                return;
                                                            default:
                                                                switch (intValue) {
                                                                    case 161:
                                                                        f();
                                                                        return;
                                                                    case 162:
                                                                        z((String) objArr[1], (String) objArr[2]);
                                                                        return;
                                                                    case 163:
                                                                        t();
                                                                        return;
                                                                    case 164:
                                                                        s(((Integer) objArr[1]).intValue());
                                                                        return;
                                                                    case 165:
                                                                        o(((Integer) objArr[1]).intValue());
                                                                        return;
                                                                    default:
                                                                        switch (intValue) {
                                                                            case 8001:
                                                                                M((String) objArr[1]);
                                                                                return;
                                                                            case 8002:
                                                                                P();
                                                                                return;
                                                                            case 8003:
                                                                                L(((Integer) objArr[1]).intValue());
                                                                                return;
                                                                            default:
                                                                                return;
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                    } else {
                                        e(at.e(objArr, 1), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                                        return;
                                    }
                                } else {
                                    p(at.e(objArr, 1), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
                                    return;
                                }
                            } else {
                                A(((Integer) objArr[1]).intValue(), ((Boolean) objArr[2]).booleanValue());
                                return;
                            }
                        } else {
                            D(((Integer) objArr[1]).intValue(), ((Long) objArr[2]).longValue());
                            return;
                        }
                    } else {
                        a(((Integer) objArr[1]).intValue(), at.e(objArr, 2));
                        return;
                    }
                }
                y((String) objArr[1]);
                return;
            }
            w(((Integer) objArr[1]).intValue());
            return;
        }
        if (objArr.length >= 4) {
            G(at.e(objArr, 4), ((Boolean) objArr[1]).booleanValue(), ((Boolean) objArr[2]).booleanValue(), ((Long) objArr[3]).longValue());
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, final Object obj) {
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            if (this.f74767d == null) {
                this.f74767d = new Handler(mainLooper);
            }
            this.f74767d.post(new Runnable() { // from class: com.tencent.av.ui.ControlUIObserver.1
                @Override // java.lang.Runnable
                public void run() {
                    ControlUIObserver.this.b(obj);
                }
            });
            return;
        }
        b(obj);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class c extends a {

        /* renamed from: d, reason: collision with root package name */
        public boolean f74774d;

        /* renamed from: e, reason: collision with root package name */
        private View f74775e;

        public c(View view) {
            super(0);
            this.f74774d = false;
            this.f74775e = view;
        }

        public c(int i3, View view) {
            super(i3);
            this.f74774d = false;
            this.f74775e = view;
        }
    }

    protected void B() {
    }

    protected void H() {
    }

    public void P() {
    }

    protected void U() {
    }

    protected void d() {
    }

    protected void f() {
    }

    protected void h() {
    }

    protected void j() {
    }

    protected void r() {
    }

    public void t() {
    }

    protected void u() {
    }

    protected void x() {
    }

    protected void C(cp.b bVar) {
    }

    public void I(long j3) {
    }

    protected void K(long j3) {
    }

    protected void L(int i3) {
    }

    protected void M(String str) {
    }

    protected void N(long j3) {
    }

    protected void R(long j3) {
    }

    protected void S(long j3) {
    }

    protected void g(boolean z16) {
    }

    protected void i(ArrayList<com.tencent.av.gaudio.c> arrayList) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(long j3) {
    }

    protected void l(boolean z16) {
    }

    protected void o(int i3) {
    }

    protected void q(long j3) {
    }

    public void s(int i3) {
    }

    protected void v(boolean z16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(int i3) {
    }

    protected void y(String str) {
    }

    protected void A(int i3, boolean z16) {
    }

    protected void D(int i3, long j3) {
    }

    protected void E(long j3, int i3) {
    }

    public void O(boolean z16, long j3) {
    }

    protected void a(int i3, long j3) {
    }

    public void z(String str, String str2) {
    }

    protected void F(long j3, boolean z16, String str) {
    }

    protected void J(long j3, boolean z16, int i3) {
    }

    protected void Q(long j3, ArrayList<com.tencent.av.gaudio.c> arrayList, boolean z16) {
    }

    protected void e(long j3, int i3, int i16) {
    }

    protected void n(int i3, int i16, String str) {
    }

    protected void p(long j3, int i3, int i16) {
    }

    protected void G(long j3, boolean z16, boolean z17, long j16) {
    }

    protected void T(int i3, boolean z16, String str, int i16) {
    }

    protected void m(String str, int i3, String str2, int i16) {
    }
}
