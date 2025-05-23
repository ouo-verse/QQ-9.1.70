package com.tencent.av.app;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.av.utils.at;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import java.util.Observable;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoObserver implements Observer {

    /* renamed from: d, reason: collision with root package name */
    Handler f73128d = null;

    void d0(Object obj) {
        Object obj2;
        Object obj3;
        int i3;
        int i16;
        boolean z16;
        if (obj == null) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        boolean z17 = false;
        boolean z18 = false;
        int i17 = 0;
        int intValue = ((Integer) objArr[0]).intValue();
        if (intValue != 10) {
            if (intValue != 52) {
                if (intValue != 201) {
                    if (intValue != 203) {
                        if (intValue != 308) {
                            if (intValue != 400) {
                                if (intValue != 600) {
                                    if (intValue != 10004) {
                                        if (intValue != 20002) {
                                            if (intValue != 518) {
                                                if (intValue != 519) {
                                                    String str = null;
                                                    switch (intValue) {
                                                        case 13:
                                                            g(at.e(objArr, 1));
                                                            return;
                                                        case 14:
                                                            int intValue2 = ((Integer) objArr[1]).intValue();
                                                            if (objArr.length > 2) {
                                                                str = (String) objArr[2];
                                                            }
                                                            e(at.e(objArr, 3), intValue2, str);
                                                            return;
                                                        case 15:
                                                            K();
                                                            return;
                                                        case 16:
                                                            U(at.e(objArr, 1));
                                                            return;
                                                        case 17:
                                                            J();
                                                            return;
                                                        case 18:
                                                            V();
                                                            return;
                                                        case 19:
                                                            b0((String) objArr[1]);
                                                            return;
                                                        case 20:
                                                            u();
                                                            return;
                                                        case 21:
                                                            b(((Integer) objArr[1]).intValue());
                                                            return;
                                                        case 22:
                                                            M(true, ((Boolean) objArr[1]).booleanValue());
                                                            return;
                                                        case 23:
                                                            M(false, ((Boolean) objArr[1]).booleanValue());
                                                            return;
                                                        case 24:
                                                            v(((Boolean) objArr[1]).booleanValue());
                                                            return;
                                                        case 25:
                                                            P(at.e(objArr, 2), ((Boolean) objArr[1]).booleanValue());
                                                            return;
                                                        default:
                                                            switch (intValue) {
                                                                case 27:
                                                                    r((String) objArr[1]);
                                                                    return;
                                                                case 28:
                                                                    String str2 = (String) objArr[1];
                                                                    boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
                                                                    if (TextUtils.isEmpty(str2)) {
                                                                        str2 = "";
                                                                    }
                                                                    h(str2, booleanValue);
                                                                    return;
                                                                case 29:
                                                                    s();
                                                                    return;
                                                                case 30:
                                                                    String str3 = (String) objArr[1];
                                                                    try {
                                                                        if (objArr.length > 2 && (obj3 = objArr[2]) != null && (obj3 instanceof String)) {
                                                                            str = (String) obj3;
                                                                        }
                                                                    } catch (Exception unused) {
                                                                    }
                                                                    p(str3, str);
                                                                    return;
                                                                default:
                                                                    switch (intValue) {
                                                                        case 32:
                                                                            if (objArr.length > 2) {
                                                                                i3 = ((Integer) objArr[1]).intValue();
                                                                                i16 = ((Integer) objArr[2]).intValue();
                                                                            } else {
                                                                                i3 = -1;
                                                                                i16 = -1;
                                                                            }
                                                                            S(at.e(objArr, 3), i3, i16);
                                                                            return;
                                                                        case 33:
                                                                            L((String) objArr[1], ((Boolean) objArr[2]).booleanValue());
                                                                            return;
                                                                        case 34:
                                                                            c0(((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                                                                            return;
                                                                        default:
                                                                            switch (intValue) {
                                                                                case 36:
                                                                                    W();
                                                                                    return;
                                                                                case 37:
                                                                                    I();
                                                                                    return;
                                                                                case 38:
                                                                                    i(at.e(objArr, 2), ((Integer) objArr[1]).intValue());
                                                                                    return;
                                                                                case 39:
                                                                                    N(((Integer) objArr[1]).intValue());
                                                                                    return;
                                                                                case 40:
                                                                                    k((String) objArr[1], ((Boolean) objArr[2]).booleanValue());
                                                                                    return;
                                                                                case 41:
                                                                                    t(((Integer) objArr[1]).intValue(), (String) objArr[2]);
                                                                                    return;
                                                                                case 42:
                                                                                    n(((Integer) objArr[1]).intValue());
                                                                                    return;
                                                                                case 43:
                                                                                    o(((Integer) objArr[1]).intValue());
                                                                                    return;
                                                                                default:
                                                                                    switch (intValue) {
                                                                                        case 205:
                                                                                            T((String) objArr[1]);
                                                                                            return;
                                                                                        case 206:
                                                                                            a((String) objArr[1]);
                                                                                            return;
                                                                                        case 207:
                                                                                            R((String) objArr[1]);
                                                                                            return;
                                                                                        case 208:
                                                                                            d((String) objArr[1]);
                                                                                            return;
                                                                                        default:
                                                                                            switch (intValue) {
                                                                                                case 526:
                                                                                                    w((String) objArr[1]);
                                                                                                    return;
                                                                                                case 527:
                                                                                                    E();
                                                                                                    return;
                                                                                                case 528:
                                                                                                    F();
                                                                                                    return;
                                                                                                case 529:
                                                                                                    a0();
                                                                                                    return;
                                                                                                case 530:
                                                                                                    z((String) objArr[1], ((Boolean) objArr[2]).booleanValue(), (String) objArr[3], ((Integer) objArr[4]).intValue());
                                                                                                    return;
                                                                                                case TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARED /* 531 */:
                                                                                                    A(((Boolean) objArr[1]).booleanValue());
                                                                                                    return;
                                                                                                case TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED /* 532 */:
                                                                                                    x((String) objArr[1], ((Boolean) objArr[2]).booleanValue());
                                                                                                    return;
                                                                                                case 533:
                                                                                                    y();
                                                                                                    return;
                                                                                                case 534:
                                                                                                    H();
                                                                                                    return;
                                                                                                case 535:
                                                                                                    G();
                                                                                                    return;
                                                                                                case TVKQQLiveAssetPlayerMsg.PLAYER_INFO_REFRESH_PLAYER_WITH_REOPEN_START /* 536 */:
                                                                                                    if (objArr.length > 2) {
                                                                                                        z17 = ((Boolean) objArr[1]).booleanValue();
                                                                                                        z16 = ((Boolean) objArr[2]).booleanValue();
                                                                                                    } else {
                                                                                                        z16 = false;
                                                                                                    }
                                                                                                    D(z17, z16);
                                                                                                    return;
                                                                                                case TVKQQLiveAssetPlayerMsg.PLAYER_INFO_REFRESH_PLAYER_WITH_REOPEN_END /* 537 */:
                                                                                                    if (objArr.length > 1) {
                                                                                                        i17 = ((Integer) objArr[1]).intValue();
                                                                                                    }
                                                                                                    C(i17);
                                                                                                    return;
                                                                                                case TVKQQLiveAssetPlayerMsg.PLAYER_INFO_DETECTED_MULTI_NETWORK_CARD_AND_LOW_SPEED /* 538 */:
                                                                                                    if (objArr.length > 1) {
                                                                                                        z18 = ((Boolean) objArr[1]).booleanValue();
                                                                                                    }
                                                                                                    B(z18);
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
                                                Z(((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue(), ((Long) objArr[4]).longValue(), ((Integer) objArr[5]).intValue());
                                                return;
                                            }
                                            q(((Boolean) objArr[1]).booleanValue(), ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue(), ((Integer) objArr[4]).intValue(), ((Integer) objArr[5]).intValue(), (String) objArr[6]);
                                            return;
                                        }
                                        c(((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), ((Long) objArr[3]).longValue());
                                        return;
                                    }
                                    Q(((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                                    return;
                                }
                                l((String) objArr[1]);
                                return;
                            }
                            try {
                                if (objArr.length > 1 && (obj2 = objArr[1]) != null && (obj2 instanceof String)) {
                                    Y(at.e(objArr, 2), (String) obj2, true);
                                    return;
                                }
                                return;
                            } catch (Exception unused2) {
                                return;
                            }
                        }
                        j(((Long) objArr[1]).longValue());
                        return;
                    }
                    f(at.e(objArr, 3), (String) objArr[1], ((Boolean) objArr[2]).booleanValue());
                    return;
                }
                m((String) objArr[1], (Bitmap) objArr[2]);
                return;
            }
            O((byte[]) objArr[2], ((Integer) objArr[3]).intValue(), ((Integer) objArr[4]).intValue());
            return;
        }
        X();
    }

    @Override // java.util.Observer
    public void update(Observable observable, final Object obj) {
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            if (this.f73128d == null) {
                this.f73128d = new Handler(mainLooper);
            }
            this.f73128d.post(new Runnable() { // from class: com.tencent.av.app.VideoObserver.1
                @Override // java.lang.Runnable
                public void run() {
                    VideoObserver.this.d0(obj);
                }
            });
            return;
        }
        d0(obj);
    }

    protected void E() {
    }

    protected void F() {
    }

    protected void G() {
    }

    protected void H() {
    }

    protected void I() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J() {
    }

    protected void K() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
    }

    protected void W() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X() {
    }

    protected void a0() {
    }

    protected void s() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u() {
    }

    protected void y() {
    }

    protected void A(boolean z16) {
    }

    protected void B(boolean z16) {
    }

    protected void C(int i3) {
    }

    protected void N(int i3) {
    }

    protected void R(String str) {
    }

    protected void T(String str) {
    }

    protected void U(long j3) {
    }

    protected void a(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i3) {
    }

    protected void b0(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(String str) {
    }

    protected void g(long j3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(long j3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(String str) {
    }

    protected void n(int i3) {
    }

    protected void o(int i3) {
    }

    protected void r(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(boolean z16) {
    }

    protected void w(String str) {
    }

    protected void D(boolean z16, boolean z17) {
    }

    protected void L(String str, boolean z16) {
    }

    protected void M(boolean z16, boolean z17) {
    }

    protected void P(long j3, boolean z16) {
    }

    protected void Q(int i3, int i16) {
    }

    protected void c0(int i3, int i16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(String str, boolean z16) {
    }

    protected void i(long j3, int i3) {
    }

    protected void k(String str, boolean z16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(String str, Bitmap bitmap) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(String str, String str2) {
    }

    protected void t(int i3, String str) {
    }

    protected void x(String str, boolean z16) {
    }

    protected void O(byte[] bArr, int i3, int i16) {
    }

    protected void S(long j3, int i3, int i16) {
    }

    protected void Y(long j3, String str, boolean z16) {
    }

    protected void c(long j3, long j16, long j17) {
    }

    protected void e(long j3, int i3, String str) {
    }

    protected void f(long j3, String str, boolean z16) {
    }

    protected void z(String str, boolean z16, String str2, int i3) {
    }

    public void Z(int i3, int i16, int i17, long j3, int i18) {
    }

    protected void q(boolean z16, long j3, int i3, int i16, int i17, String str) {
    }
}
