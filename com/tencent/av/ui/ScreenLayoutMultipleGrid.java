package com.tencent.av.ui;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ScreenLayoutMultipleGrid extends x {

    /* renamed from: e, reason: collision with root package name */
    static final int[][] f75147e;

    /* renamed from: f, reason: collision with root package name */
    static final int[] f75148f = {0, 3, 4, 1, 6, 7, 8, 5, 2};

    /* renamed from: g, reason: collision with root package name */
    static final int[] f75149g = {0, 4, 5, 1, 8, 9, 12, 6, 2, 13, 10, 14, 15, 11, 7, 3};

    /* renamed from: h, reason: collision with root package name */
    public static final int f75150h;

    /* renamed from: c, reason: collision with root package name */
    private volatile ConcurrentHashMap<Long, am> f75151c;

    /* renamed from: d, reason: collision with root package name */
    private volatile int f75152d;

    static {
        int[][] iArr = {new int[]{1}, new int[]{1, 1}, new int[]{1, 2}, new int[]{2, 2}, new int[]{2, 2, 1}, new int[]{2, 2, 2}, new int[]{2, 2, 3}, new int[]{2, 3, 3}, new int[]{3, 3, 3}, new int[]{3, 3, 2, 2}, new int[]{3, 3, 3, 2}, new int[]{3, 3, 3, 3}, new int[]{3, 3, 3, 4}, new int[]{3, 3, 4, 4}, new int[]{3, 4, 4, 4}, new int[]{4, 4, 4, 4}};
        f75147e = iArr;
        f75150h = iArr.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ScreenLayoutMultipleGrid(Context context, VideoAppInterface videoAppInterface) {
        super(context, videoAppInterface);
        this.f75152d = f75150h;
    }

    private List<Rect> m(int i3, int i16, int i17) {
        boolean z16;
        boolean z17;
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        boolean z18;
        Rect rect;
        int i36;
        if (i3 <= 0) {
            return null;
        }
        int[] iArr4 = f75147e[i3 - 1];
        int length = iArr4.length;
        int i37 = 0;
        int i38 = ((i17 + 0) / length) - 0;
        ArrayList arrayList = new ArrayList();
        if (i3 <= 9) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i3 == 5) {
            z17 = true;
        } else {
            z17 = false;
        }
        int i39 = 3;
        if (z17) {
            int i46 = i17 / 10;
            int i47 = i46 * 3;
            int i48 = i46 * 6;
            iArr = new int[]{i47, i47, i17 - i48};
            iArr2 = new int[]{0, i47, i48};
        } else {
            iArr = null;
            iArr2 = null;
        }
        if (z16) {
            iArr3 = f75148f;
        } else {
            iArr3 = f75149g;
        }
        if (z16) {
            i18 = 3;
        } else {
            i18 = 4;
        }
        if (!z16) {
            i39 = 4;
        }
        int i49 = 0;
        while (i49 < i18) {
            if (z17) {
                i19 = iArr2[i49];
            } else {
                i19 = (i38 + 0) * i49;
            }
            int i56 = i19;
            if (i49 < length) {
                int i57 = iArr4[i49];
                i26 = ((i16 + 0) / i57) + 0;
                i37 = i57;
            } else {
                i26 = i37;
            }
            int[] iArr5 = iArr4;
            int i58 = 0;
            while (i58 < i39) {
                if (i37 > 0 && i58 < i37) {
                    i27 = length;
                    int i59 = i58 * (i26 + 0);
                    i28 = i38;
                    i29 = i37;
                    int i65 = i59 + i26;
                    if (z17) {
                        i36 = iArr[i49];
                        z18 = z17;
                    } else {
                        z18 = z17;
                        i36 = i28;
                    }
                    rect = new Rect(i59, i56, i65, i56 + i36);
                } else {
                    i27 = length;
                    i28 = i38;
                    i29 = i37;
                    z18 = z17;
                    rect = null;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.w("ScreenLayoutMultipleGrid", 1, "getViewRects, creat rect: [" + i49 + "|" + i58 + "] :" + rect);
                }
                arrayList.add(rect);
                i58++;
                i37 = i29;
                i38 = i28;
                length = i27;
                z17 = z18;
            }
            i49++;
            iArr4 = iArr5;
            i37 = 0;
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i66 = 0; i66 < i3; i66++) {
            int i67 = iArr3[i66];
            Rect rect2 = (Rect) arrayList.get(i67);
            if (rect2 != null) {
                arrayList2.add(rect2);
            } else if (QLog.isDevelopLevel()) {
                QLog.w("ScreenLayoutMultipleGrid", 1, "getViewRects, sort rect has wrong: " + i66 + "|" + i67);
            }
        }
        return arrayList2;
    }

    @Override // com.tencent.av.ui.x
    public boolean a() {
        return false;
    }

    @Override // com.tencent.av.ui.x
    public int c() {
        return 3;
    }

    @Override // com.tencent.av.ui.x
    public void h(GLVideoView[] gLVideoViewArr, int i3, int i16, int i17, int i18, int i19, boolean z16) {
        if (QLog.isDevelopLevel()) {
            QLog.w("ScreenLayoutMultipleGrid", 1, "layoutCommon, wrong call\uff01 " + new Throwable());
        }
        gLVideoViewArr[0].O(0, 0, 0, 0);
        gLVideoViewArr[0].q(0, 0, i3, i16);
        gLVideoViewArr[0].I(-15197410);
        gLVideoViewArr[1].O(3, 3, 3, 3);
        gLVideoViewArr[1].I(-15197410);
        l(gLVideoViewArr, i17, i3, i16, i18, i19);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x014f  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r4v12 */
    @Override // com.tencent.av.ui.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i(SessionInfo sessionInfo, final GLVideoView[] gLVideoViewArr, int i3, int i16, boolean z16, int i17, int i18) {
        boolean z17;
        int i19;
        List<Rect> list;
        int i26;
        boolean z18;
        char c16;
        if (this.f76644a == null) {
            return;
        }
        int min = Math.min(Math.min(sessionInfo.f73045k1.size(), gLVideoViewArr.length), f75150h);
        ?? r46 = 0;
        boolean z19 = 1;
        if (this.f75152d != min) {
            this.f75152d = min;
            z17 = true;
        } else {
            z17 = false;
        }
        if (min >= 2 && ba.isEnableShowTips(1)) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.av.ui.ScreenLayoutMultipleGrid.1
                @Override // java.lang.Runnable
                public void run() {
                    cw.e.n(ScreenLayoutMultipleGrid.this.f76645b, 1054);
                    ba.disableShowTips(1);
                }
            });
        }
        List<Rect> m3 = m(min, i3, i16);
        float dp2px = ba.dp2px(this.f76644a, 12.0f);
        float dp2px2 = ba.dp2px(this.f76644a, 18.0f);
        int i27 = 0;
        while (true) {
            if (i27 < min) {
                gLVideoViewArr[i27].n0(r46);
                gLVideoViewArr[i27].e(z19);
                Rect rect = m3.get(i27);
                if (rect != null) {
                    gLVideoViewArr[i27].q(rect.left, rect.top, rect.right, rect.bottom);
                    gLVideoViewArr[i27].O(r46, r46, r46, r46);
                    long v3 = com.tencent.av.utils.e.v(gLVideoViewArr[i27].G0());
                    long H0 = gLVideoViewArr[i27].H0();
                    String D0 = gLVideoViewArr[i27].D0();
                    if (v3 != 0) {
                        list = m3;
                        am amVar = this.f75151c.get(Long.valueOf(v3));
                        if (amVar != null) {
                            boolean d16 = amVar.d();
                            int i28 = d16;
                            if (d16 == 0) {
                                if (amVar.f() && H0 != 2) {
                                    i28 = 2;
                                } else {
                                    i28 = 3;
                                }
                            }
                            gLVideoViewArr[i27].T0(i28);
                            i26 = i28;
                            if (z17) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.w("ScreenLayoutMultipleGrid", 1, "layoutMulti showCountChanged and force refresh text");
                                }
                                gLVideoViewArr[i27].r0();
                                i26 = i28;
                            }
                            if (!TextUtils.isEmpty(D0) && v3 != 0) {
                                String U = com.tencent.av.r.h0().U(String.valueOf(v3), String.valueOf(com.tencent.av.n.e().f().P0), com.tencent.av.n.e().f().S0);
                                gLVideoViewArr[i27].u1(U);
                                if (i27 == 0) {
                                    z18 = true;
                                    this.f76645b.k0(new Object[]{9100, Integer.valueOf(i27), Boolean.TRUE, U, Integer.valueOf(i26)});
                                } else {
                                    z18 = true;
                                    gLVideoViewArr[i27].C1(true);
                                }
                            } else {
                                z18 = true;
                            }
                            if (min != z18) {
                                gLVideoViewArr[i27].w1(false);
                                gLVideoViewArr[i27].y1(dp2px2);
                                c16 = 2;
                            } else {
                                c16 = 2;
                                if (min >= 2) {
                                    gLVideoViewArr[i27].w1(z18);
                                    gLVideoViewArr[i27].y1(dp2px);
                                }
                            }
                            i27++;
                            m3 = list;
                            r46 = 0;
                            z19 = 1;
                        }
                    } else {
                        list = m3;
                    }
                    i26 = -2;
                    if (!TextUtils.isEmpty(D0)) {
                    }
                    z18 = true;
                    if (min != z18) {
                    }
                    i27++;
                    m3 = list;
                    r46 = 0;
                    z19 = 1;
                } else if (QLog.isDevelopLevel()) {
                    i19 = 1;
                    QLog.w("ScreenLayoutMultipleGrid", 1, "layoutMulti, layout rect has wrong: " + i27);
                } else {
                    i19 = 1;
                }
            } else {
                i19 = z19;
                break;
            }
        }
        if (min == i19) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.ui.ScreenLayoutMultipleGrid.2
                @Override // java.lang.Runnable
                public void run() {
                    boolean z26;
                    aj ajVar;
                    AVActivity aVActivity = (AVActivity) gLVideoViewArr[0].s0();
                    if (aVActivity != null && (ajVar = aVActivity.I0) != null) {
                        z26 = ajVar.I();
                    } else {
                        z26 = false;
                    }
                    ScreenLayoutMultipleGrid.this.f76645b.k0(new Object[]{9100, 0, Boolean.valueOf(z26)});
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.av.ui.x
    public void j(int i3, Rect rect, Rect rect2, ConcurrentHashMap<Long, am> concurrentHashMap) {
        this.f75151c = concurrentHashMap;
    }

    @Override // com.tencent.av.ui.x
    public void l(GLVideoView[] gLVideoViewArr, int i3, int i16, int i17, int i18, int i19) {
        if (QLog.isDevelopLevel()) {
            QLog.w("ScreenLayoutMultipleGrid", 1, "setSmallVideoViewLayout, wrong call\uff01 " + new Throwable());
        }
    }
}
