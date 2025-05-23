package com.tencent.av.app;

import android.os.Handler;
import android.os.Looper;
import com.tencent.av.utils.at;
import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.avcore.jni.data.UinOpenIdResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GAudioUIObserver implements Observer {

    /* renamed from: d, reason: collision with root package name */
    Handler f72973d = null;

    void a(Object obj) {
        Object[] objArr = (Object[]) obj;
        int intValue = ((Integer) objArr[0]).intValue();
        if (intValue != 10) {
            if (intValue != 21) {
                if (intValue != 157) {
                    if (intValue != 307) {
                        if (intValue != 404) {
                            if (intValue != 406) {
                                if (intValue != 409) {
                                    if (intValue != 521) {
                                        if (intValue != 302) {
                                            if (intValue != 303) {
                                                if (intValue != 311) {
                                                    if (intValue != 312) {
                                                        switch (intValue) {
                                                            case 61:
                                                                F(((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), ((Boolean) objArr[3]).booleanValue(), ((Boolean) objArr[4]).booleanValue());
                                                                return;
                                                            case 62:
                                                                G(((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), ((Boolean) objArr[3]).booleanValue(), ((Boolean) objArr[4]).booleanValue());
                                                                return;
                                                            case 63:
                                                                I(((Long) objArr[1]).longValue(), ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue(), ((Integer) objArr[4]).intValue());
                                                                return;
                                                            case 64:
                                                                S(((Long) objArr[1]).longValue(), (ArrayList) objArr[2], ((Integer) objArr[3]).intValue(), ((Integer) objArr[4]).intValue());
                                                                return;
                                                            default:
                                                                switch (intValue) {
                                                                    case 66:
                                                                        i(((Long) objArr[1]).longValue());
                                                                        return;
                                                                    case 67:
                                                                        h(((Long) objArr[1]).longValue(), ((Integer) objArr[2]).intValue());
                                                                        return;
                                                                    case 68:
                                                                        B(((Long) objArr[1]).longValue(), ((Integer) objArr[2]).intValue());
                                                                        return;
                                                                    case 69:
                                                                        J(((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue());
                                                                        return;
                                                                    case 70:
                                                                        K(at.e(objArr, 4), ((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue());
                                                                        return;
                                                                    case 71:
                                                                        E(((Long) objArr[1]).longValue(), ((Long) objArr[3]).longValue(), ((Integer) objArr[2]).intValue(), true);
                                                                        return;
                                                                    case 72:
                                                                        E(((Long) objArr[1]).longValue(), ((Long) objArr[3]).longValue(), ((Integer) objArr[2]).intValue(), false);
                                                                        return;
                                                                    case 73:
                                                                        H(at.e(objArr, 4), ((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue(), true);
                                                                        return;
                                                                    case 74:
                                                                        H(at.e(objArr, 4), ((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue(), false);
                                                                        return;
                                                                    default:
                                                                        switch (intValue) {
                                                                            case 77:
                                                                                u(((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), true, ((Boolean) objArr[3]).booleanValue());
                                                                                return;
                                                                            case 78:
                                                                                u(((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), false, ((Boolean) objArr[3]).booleanValue());
                                                                                return;
                                                                            case 79:
                                                                                L(((Long) objArr[1]).longValue(), ((Boolean) objArr[2]).booleanValue(), ((Integer) objArr[3]).intValue());
                                                                                return;
                                                                            case 80:
                                                                                k(at.e(objArr, 2), ((Long) objArr[1]).longValue());
                                                                                return;
                                                                            case 81:
                                                                                l(((Long) objArr[1]).longValue(), ((Integer) objArr[2]).intValue());
                                                                                return;
                                                                            case 82:
                                                                                M((String) objArr[1], (String[]) objArr[2]);
                                                                                return;
                                                                            case 83:
                                                                                g(at.e(objArr, 2), ((Long) objArr[1]).longValue());
                                                                                return;
                                                                            default:
                                                                                switch (intValue) {
                                                                                    case 85:
                                                                                        N(((Integer) objArr[1]).intValue(), ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue());
                                                                                        return;
                                                                                    case 86:
                                                                                        Q(((Integer) objArr[1]).intValue(), ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue());
                                                                                        return;
                                                                                    case 87:
                                                                                        T(((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue(), ((Integer) objArr[4]).intValue());
                                                                                        return;
                                                                                    case 88:
                                                                                        z(((Long) objArr[1]).longValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
                                                                                        return;
                                                                                    case 89:
                                                                                        w(((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), (String) objArr[3]);
                                                                                        return;
                                                                                    case 90:
                                                                                    case 91:
                                                                                    case 92:
                                                                                    case 93:
                                                                                    case 94:
                                                                                    case 95:
                                                                                        v(at.e(objArr, 5), intValue, ((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), ((Long) objArr[3]).longValue(), ((Integer) objArr[4]).intValue());
                                                                                        return;
                                                                                    case 96:
                                                                                    case 97:
                                                                                    case 98:
                                                                                        v(at.e(objArr, 4), intValue, 0L, ((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue());
                                                                                        return;
                                                                                    case 99:
                                                                                        n();
                                                                                        return;
                                                                                    default:
                                                                                        switch (intValue) {
                                                                                            case 138:
                                                                                                p(((Long) objArr[1]).longValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue(), ((Boolean) objArr[4]).booleanValue());
                                                                                                return;
                                                                                            case 139:
                                                                                                r(((Long) objArr[1]).longValue(), ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue());
                                                                                                return;
                                                                                            case 140:
                                                                                                q(((Long) objArr[1]).longValue(), ((Integer) objArr[2]).intValue());
                                                                                                return;
                                                                                            case 141:
                                                                                                s((ArrayList) objArr[1]);
                                                                                                return;
                                                                                            case 142:
                                                                                                t((ArrayList) objArr[1], ((Integer) objArr[2]).intValue());
                                                                                                return;
                                                                                            default:
                                                                                                switch (intValue) {
                                                                                                    case 513:
                                                                                                        A(((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), (String) objArr[3]);
                                                                                                        return;
                                                                                                    case 514:
                                                                                                        b(((Long) objArr[1]).longValue());
                                                                                                        return;
                                                                                                    case 515:
                                                                                                        c(((Long) objArr[1]).longValue());
                                                                                                        return;
                                                                                                    case 516:
                                                                                                        d(((Long) objArr[1]).longValue(), (String) objArr[2]);
                                                                                                        return;
                                                                                                    default:
                                                                                                        return;
                                                                                                }
                                                                                        }
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                    }
                                                    m((UinOpenIdResponse) objArr[1]);
                                                    return;
                                                }
                                                o();
                                                return;
                                            }
                                            x(((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), ((Boolean) objArr[3]).booleanValue());
                                            return;
                                        }
                                        y(((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), ((Boolean) objArr[3]).booleanValue());
                                        return;
                                    }
                                    f(((Integer) objArr[1]).intValue(), (byte[]) objArr[2]);
                                    return;
                                }
                                C(((Integer) objArr[1]).intValue(), (String) objArr[2]);
                                return;
                            }
                            R();
                            return;
                        }
                        D(((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue());
                        return;
                    }
                    j();
                    return;
                }
                P(((Long) objArr[1]).longValue(), ((Boolean) objArr[2]).booleanValue());
                return;
            }
            e(((Integer) objArr[1]).intValue());
            return;
        }
        O();
    }

    @Override // java.util.Observer
    public void update(Observable observable, final Object obj) {
        if (obj == null) {
            QLog.e("qav.GAudioUIObserver", 1, "update null == data");
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            if (this.f72973d == null) {
                this.f72973d = new Handler(mainLooper);
            }
            this.f72973d.post(new Runnable() { // from class: com.tencent.av.app.GAudioUIObserver.1
                @Override // java.lang.Runnable
                public void run() {
                    GAudioUIObserver.this.a(obj);
                }
            });
            return;
        }
        a(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void O() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void R() {
    }

    protected void j() {
    }

    protected void n() {
    }

    protected void o() {
    }

    protected void b(long j3) {
    }

    protected void c(long j3) {
    }

    protected void e(int i3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(long j3) {
    }

    protected void m(UinOpenIdResponse uinOpenIdResponse) {
    }

    protected void s(ArrayList<AVUserInfo> arrayList) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(long j3, int i3) {
    }

    protected void C(int i3, String str) {
    }

    protected void D(long j3, long j16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(long j3, long j16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(String str, String[] strArr) {
    }

    protected void P(long j3, boolean z16) {
    }

    protected void d(long j3, String str) {
    }

    protected void f(int i3, byte[] bArr) {
    }

    protected void g(long j3, long j16) {
    }

    protected void h(long j3, int i3) {
    }

    protected void k(long j3, long j16) {
    }

    protected void l(long j3, int i3) {
    }

    protected void q(long j3, int i3) {
    }

    protected void t(ArrayList<Long> arrayList, int i3) {
    }

    protected void A(long j3, long j16, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(long j3, boolean z16, int i3) {
    }

    protected void N(int i3, long j3, int i16) {
    }

    protected void Q(int i3, long j3, int i16) {
    }

    protected void r(long j3, boolean z16, boolean z17) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(long j3, long j16, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(long j3, long j16, boolean z16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(long j3, long j16, boolean z16) {
    }

    protected void z(long j3, int i3, int i16) {
    }

    protected void E(long j3, long j16, int i3, boolean z16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(long j3, long j16, boolean z16, boolean z17) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G(long j3, long j16, boolean z16, boolean z17) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I(long j3, boolean z16, boolean z17, int i3) {
    }

    protected void K(long j3, long j16, long j17, int i3) {
    }

    protected void S(long j3, ArrayList<com.tencent.av.e> arrayList, int i3, int i16) {
    }

    protected void T(long j3, long j16, int i3, int i16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(long j3, int i3, int i16, boolean z16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(long j3, long j16, boolean z16, boolean z17) {
    }

    protected void H(long j3, long j16, long j17, int i3, boolean z16) {
    }

    protected void v(long j3, int i3, long j16, long j17, long j18, int i16) {
    }
}
