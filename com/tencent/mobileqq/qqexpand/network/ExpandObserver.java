package com.tencent.mobileqq.qqexpand.network;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.Card;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import vg2.f;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ExpandObserver implements BusinessObserver {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes16.dex */
    public @interface UpdateStatusScene {
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        int i16 = -1;
        switch (i3) {
            case 1:
                b(z16);
                return;
            case 2:
                if (obj != null && (obj instanceof Object[])) {
                    Object[] objArr = (Object[]) obj;
                    if (z16 && objArr.length == 9) {
                        h(true, ((Long) objArr[0]).longValue(), (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), (byte[]) objArr[3], ((Boolean) objArr[4]).booleanValue(), ((Boolean) objArr[5]).booleanValue(), ((Integer) objArr[6]).intValue(), (List) objArr[7], (vg2.c) objArr[8]);
                        return;
                    } else {
                        if (!z16 && objArr.length == 2) {
                            h(false, ((Long) objArr[0]).longValue(), (String) objArr[1], false, null, false, false, 0, null, null);
                            return;
                        }
                        return;
                    }
                }
                return;
            case 3:
                Object[] objArr2 = (Object[]) obj;
                d(z16, (Card) objArr2[0]);
                e(z16, (Card) objArr2[0], ((Integer) objArr2[1]).intValue());
                return;
            case 4:
            case 10:
            case 24:
            case 25:
            case 27:
            case 29:
            default:
                return;
            case 5:
                t(((Boolean) obj).booleanValue());
                return;
            case 6:
                if (obj instanceof Object[]) {
                    Object[] objArr3 = (Object[]) obj;
                    if (objArr3.length == 4) {
                        o(z16, ((Integer) objArr3[0]).intValue(), ((Integer) objArr3[1]).intValue(), (vg2.d) objArr3[2], ((Integer) objArr3[3]).intValue());
                        return;
                    } else {
                        o(z16, -1, -1, null, -1);
                        return;
                    }
                }
                o(z16, -1, -1, null, -1);
                return;
            case 7:
                if (obj instanceof Object[]) {
                    Object[] objArr4 = (Object[]) obj;
                    if (objArr4 != null && objArr4.length == 2) {
                        n(z16, ((Integer) objArr4[0]).intValue(), (vg2.d) objArr4[1]);
                        return;
                    } else {
                        n(false, -1, null);
                        return;
                    }
                }
                n(z16, -1, null);
                return;
            case 8:
                m(((Boolean) obj).booleanValue());
                return;
            case 9:
                Object[] objArr5 = (Object[]) obj;
                i(z16, (com.tencent.mobileqq.qqexpand.bean.feed.b) objArr5[0], ((Integer) objArr5[1]).intValue());
                return;
            case 11:
                if (z16) {
                    if (obj != null && (obj instanceof Object[])) {
                        Object[] objArr6 = (Object[]) obj;
                        if (objArr6.length == 4) {
                            w(z16, ((Integer) objArr6[0]).intValue(), (vg2.d) objArr6[1], (String) objArr6[3]);
                            return;
                        } else {
                            w(false, -1, null, null);
                            return;
                        }
                    }
                    w(false, -1, null, null);
                    return;
                }
                w(false, -1, null, null);
                return;
            case 12:
                a(z16);
                return;
            case 13:
                if (z16 && obj != null && (obj instanceof Object[])) {
                    Object[] objArr7 = (Object[]) obj;
                    if (objArr7.length == 5) {
                        j(true, (ArrayList) objArr7[0], ((Boolean) objArr7[1]).booleanValue(), ((Integer) objArr7[2]).intValue(), (ArrayList) objArr7[3], ((Boolean) objArr7[4]).booleanValue());
                        return;
                    } else {
                        j(false, null, true, 0, null, false);
                        return;
                    }
                }
                j(false, null, true, 0, null, false);
                return;
            case 14:
                u(z16);
                return;
            case 15:
                if (z16) {
                    if (obj != null && (obj instanceof Object[])) {
                        Object[] objArr8 = (Object[]) obj;
                        if (objArr8.length == 4) {
                            k(z16, ((Integer) objArr8[0]).intValue(), ((Integer) objArr8[2]).intValue(), (vg2.d) objArr8[1], (String) objArr8[3]);
                            return;
                        } else {
                            k(false, -1, -1, null, null);
                            return;
                        }
                    }
                    k(false, -1, -1, null, null);
                    return;
                }
                k(false, -1, -1, null, null);
                return;
            case 16:
                if (z16 && obj != null && (obj instanceof Object[])) {
                    Object[] objArr9 = (Object[]) obj;
                    if (objArr9.length == 1) {
                        v(z16, (vg2.d) objArr9[0]);
                        return;
                    } else {
                        v(false, null);
                        return;
                    }
                }
                v(false, null);
                return;
            case 17:
                B(((Integer) obj).intValue());
                return;
            case 18:
                A(z16);
                return;
            case 19:
                if (obj instanceof Object[]) {
                    Object[] objArr10 = (Object[]) obj;
                    f(z16, (ArrayList) objArr10[0], ((Integer) objArr10[1]).intValue(), (List) objArr10[2]);
                    return;
                }
                return;
            case 20:
                if (obj != null && (obj instanceof Object[])) {
                    Object[] objArr11 = (Object[]) obj;
                    if (objArr11.length > 0) {
                        i16 = ((Integer) objArr11[0]).intValue();
                    }
                }
                x(z16, i16);
                return;
            case 21:
                g(z16, obj);
                return;
            case 22:
                z(z16, obj);
                return;
            case 23:
                if (obj instanceof Object[]) {
                    Object[] objArr12 = (Object[]) obj;
                    if (objArr12.length > 0) {
                        C(z16, (String) objArr12[0]);
                        return;
                    }
                    return;
                }
                return;
            case 26:
                if (obj instanceof Object[]) {
                    Object[] objArr13 = (Object[]) obj;
                    if (objArr13.length == 3) {
                        s(z16, (String) objArr13[0], ((Integer) objArr13[1]).intValue(), ((Boolean) objArr13[2]).booleanValue());
                        return;
                    }
                    return;
                }
                return;
            case 28:
                c(z16);
                return;
            case 30:
                p(z16, obj);
                return;
            case 31:
                r(z16, obj);
                return;
            case 32:
                q(z16, obj, 32);
                return;
            case 33:
                q(z16, obj, 33);
                return;
            case 34:
                y(z16);
                return;
            case 35:
                l(z16, obj);
                return;
        }
    }

    protected void A(boolean z16) {
    }

    protected void B(int i3) {
    }

    protected void a(boolean z16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(boolean z16) {
    }

    protected void c(boolean z16) {
    }

    protected void m(boolean z16) {
    }

    protected void t(boolean z16) {
    }

    protected void u(boolean z16) {
    }

    protected void y(boolean z16) {
    }

    protected void C(boolean z16, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(boolean z16, Card card) {
    }

    protected void g(boolean z16, Object obj) {
    }

    protected void l(boolean z16, Object obj) {
    }

    protected void p(boolean z16, Object obj) {
    }

    protected void r(boolean z16, Object obj) {
    }

    protected void v(boolean z16, vg2.d dVar) {
    }

    protected void x(boolean z16, int i3) {
    }

    protected void z(boolean z16, Object obj) {
    }

    protected void e(boolean z16, Card card, int i3) {
    }

    protected void i(boolean z16, com.tencent.mobileqq.qqexpand.bean.feed.b bVar, int i3) {
    }

    protected void n(boolean z16, int i3, vg2.d dVar) {
    }

    protected void q(boolean z16, Object obj, int i3) {
    }

    protected void h(boolean z16, long j3, String str, boolean z17, byte[] bArr, boolean z18, boolean z19, int i3, List<com.tencent.mobileqq.qqexpand.bean.feed.b> list, vg2.c cVar) {
    }

    protected void f(boolean z16, List<Long> list, int i3, List<Long> list2) {
    }

    protected void s(boolean z16, String str, int i3, boolean z17) {
    }

    protected void w(boolean z16, int i3, vg2.d dVar, String str) {
    }

    protected void k(boolean z16, int i3, int i16, vg2.d dVar, String str) {
    }

    protected void o(boolean z16, int i3, int i16, vg2.d dVar, int i17) {
    }

    protected void j(boolean z16, ArrayList<f> arrayList, boolean z17, int i3, ArrayList<String> arrayList2, boolean z18) {
    }
}
