package com.tencent.mobileqq.listentogether;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.listentogether.data.ISong;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class e implements BusinessObserver {
    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        switch (i3) {
            case 4:
                u((ListenTogetherSession) ((Object[]) obj)[0]);
                return;
            case 5:
                Object[] objArr = (Object[]) obj;
                i(((Integer) objArr[0]).intValue(), (String) objArr[1], ((Boolean) objArr[2]).booleanValue());
                return;
            case 6:
                Object[] objArr2 = (Object[]) obj;
                o(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                return;
            case 7:
                Object[] objArr3 = (Object[]) obj;
                s(((Integer) objArr3[0]).intValue(), (String) objArr3[1]);
                return;
            case 8:
                Object[] objArr4 = (Object[]) obj;
                m(((Integer) objArr4[0]).intValue(), (String) objArr4[1]);
                return;
            case 9:
                Object[] objArr5 = (Object[]) obj;
                q((String) objArr5[0], ((Integer) objArr5[1]).intValue(), ((Integer) objArr5[2]).intValue());
                return;
            case 10:
                Object[] objArr6 = (Object[]) obj;
                f((String) objArr6[0], (String) objArr6[1], ((Boolean) objArr6[2]).booleanValue());
                return;
            case 11:
                Object[] objArr7 = (Object[]) obj;
                l(((Integer) objArr7[0]).intValue(), (String) objArr7[1], ((Boolean) objArr7[2]).booleanValue(), ((Boolean) objArr7[3]).booleanValue());
                return;
            case 12:
                Object[] objArr8 = (Object[]) obj;
                r((String) objArr8[0], ((Integer) objArr8[1]).intValue());
                return;
            case 13:
                p((ISong) ((Object[]) obj)[0]);
                return;
            case 14:
                Object[] objArr9 = (Object[]) obj;
                k(((Integer) objArr9[0]).intValue(), (String) objArr9[1]);
                return;
            case 15:
                Object[] objArr10 = (Object[]) obj;
                d(((Boolean) objArr10[0]).booleanValue(), (ListenTogetherSession) objArr10[1]);
                return;
            case 16:
                t();
                return;
            case 17:
                Object[] objArr11 = (Object[]) obj;
                if (z16) {
                    e(true, (String) objArr11[0], ((Integer) objArr11[1]).intValue(), (List) objArr11[2]);
                    return;
                } else {
                    e(true, (String) objArr11[0], 0, null);
                    return;
                }
            case 18:
                Object[] objArr12 = (Object[]) obj;
                j(((Integer) objArr12[0]).intValue(), (String) objArr12[1], (String) objArr12[2]);
                return;
            case 19:
                Object[] objArr13 = (Object[]) obj;
                c(((Integer) objArr13[0]).intValue(), (String) objArr13[1]);
                return;
            case 20:
                Object[] objArr14 = (Object[]) obj;
                b(((Integer) objArr14[0]).intValue(), (String) objArr14[1]);
                return;
            case 21:
                Object[] objArr15 = (Object[]) obj;
                a(((Integer) objArr15[0]).intValue(), (String) objArr15[1]);
                return;
            case 22:
                Object[] objArr16 = (Object[]) obj;
                h(((Integer) objArr16[0]).intValue(), (String) objArr16[1]);
                return;
            case 23:
                Object[] objArr17 = (Object[]) obj;
                n(z16, ((Integer) objArr17[0]).intValue(), (String) objArr17[1], (String) objArr17[2], ((Integer) objArr17[3]).intValue(), (String) objArr17[4]);
                return;
            case 24:
                Object[] objArr18 = (Object[]) obj;
                if (z16) {
                    g(z16, ((Integer) objArr18[0]).intValue(), (String) objArr18[1], ((Long) objArr18[2]).longValue(), ((Integer) objArr18[3]).intValue(), 0, "");
                    return;
                } else {
                    g(z16, ((Integer) objArr18[0]).intValue(), (String) objArr18[1], ((Long) objArr18[2]).longValue(), 0, ((Integer) objArr18[3]).intValue(), (String) objArr18[4]);
                    return;
                }
            default:
                return;
        }
    }

    protected void t() {
    }

    protected void p(ISong iSong) {
    }

    protected void u(ListenTogetherSession listenTogetherSession) {
    }

    protected void a(int i3, String str) {
    }

    protected void b(int i3, String str) {
    }

    protected void c(int i3, String str) {
    }

    protected void d(boolean z16, ListenTogetherSession listenTogetherSession) {
    }

    protected void h(int i3, String str) {
    }

    protected void k(int i3, String str) {
    }

    protected void m(int i3, String str) {
    }

    protected void o(int i3, String str) {
    }

    protected void r(String str, int i3) {
    }

    protected void s(int i3, String str) {
    }

    protected void f(String str, String str2, boolean z16) {
    }

    protected void i(int i3, String str, boolean z16) {
    }

    protected void j(int i3, String str, String str2) {
    }

    protected void q(String str, int i3, int i16) {
    }

    protected void n(boolean z16, int i3, String str, String str2, int i16, String str3) {
    }

    protected void g(boolean z16, int i3, String str, long j3, int i16, int i17, String str2) {
    }

    protected void e(boolean z16, String str, int i3, List<String> list) {
    }

    protected void l(int i3, String str, boolean z16, boolean z17) {
    }
}
