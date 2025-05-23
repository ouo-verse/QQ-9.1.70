package com.tencent.av.ui;

import android.content.Context;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ac extends x {

    /* renamed from: c, reason: collision with root package name */
    private int f75331c;

    public ac(Context context, VideoAppInterface videoAppInterface) {
        super(context, videoAppInterface);
        this.f75331c = (int) com.tencent.mobileqq.utils.al.a(context, 100.0f);
    }

    private void m(GLVideoView[] gLVideoViewArr, int i3, int i16, int i17, int i18, int i19, boolean z16) {
        gLVideoViewArr[0].O(0, 0, 0, 0);
        gLVideoViewArr[0].q(0, 0, i3, i16);
        gLVideoViewArr[0].n0(false);
        gLVideoViewArr[0].I(-15197410);
        gLVideoViewArr[1].O(3, 3, 3, 3);
        gLVideoViewArr[1].I(-15197410);
        gLVideoViewArr[1].n0(true);
        l(gLVideoViewArr, i17, i3, i16, i18, i19);
    }

    @Override // com.tencent.av.ui.x
    public boolean a() {
        if (QLog.isDevelopLevel()) {
            QLog.w("OriginScreenLayout", 1, "canSwitchView true.");
        }
        return true;
    }

    @Override // com.tencent.av.ui.x
    public int c() {
        return 1;
    }

    @Override // com.tencent.av.ui.x
    public void h(GLVideoView[] gLVideoViewArr, int i3, int i16, int i17, int i18, int i19, boolean z16) {
        gLVideoViewArr[0].e(true);
        gLVideoViewArr[1].e(false);
        m(gLVideoViewArr, i3, i16, i17, i18, i19, z16);
    }

    @Override // com.tencent.av.ui.x
    public void i(SessionInfo sessionInfo, GLVideoView[] gLVideoViewArr, int i3, int i16, boolean z16, int i17, int i18) {
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        if (this.f76644a == null) {
            return;
        }
        gLVideoViewArr[0].O(0, 0, 0, 0);
        gLVideoViewArr[0].q(0, 0, i3, i16);
        gLVideoViewArr[0].I(-15197410);
        if (sessionInfo.f73063p == 2) {
            gLVideoViewArr[0].e1(Boolean.FALSE);
            GLVideoView gLVideoView = gLVideoViewArr[1];
            Boolean bool = Boolean.TRUE;
            gLVideoView.e1(bool);
            gLVideoViewArr[2].e1(bool);
            gLVideoViewArr[3].e1(bool);
            gLVideoViewArr[4].e1(bool);
            if (gLVideoViewArr[0].a0() && ((i17 == 0 || i17 == 180) && !gLVideoViewArr[0].w0())) {
                if (i17 == 0) {
                    gLVideoViewArr[0].O(0, 0, 0, this.f76644a.getResources().getDimensionPixelSize(R.dimen.a5x));
                } else {
                    gLVideoViewArr[0].O(0, this.f76644a.getResources().getDimensionPixelSize(R.dimen.a5x), 0, 0);
                }
            } else {
                gLVideoViewArr[0].O(0, 0, 0, 0);
            }
        }
        int dimensionPixelSize = this.f76644a.getResources().getDimensionPixelSize(R.dimen.f159624b25);
        if (i18 != 0) {
            i19 = this.f76644a.getResources().getDimensionPixelSize(R.dimen.b26);
        } else {
            i19 = dimensionPixelSize;
        }
        int i46 = (i3 - (dimensionPixelSize * 2)) / 4;
        int i47 = ((i16 - i46) - i19) - i18;
        int i48 = (i16 - i19) - i18;
        if (z16) {
            i27 = gLVideoViewArr[1].f().left;
            i26 = gLVideoViewArr[1].f().right;
        } else {
            int i49 = (i3 - i46) - dimensionPixelSize;
            i26 = i3 - dimensionPixelSize;
            i27 = i49;
        }
        gLVideoViewArr[1].q(i27, i47, i26, i48);
        if (z16) {
            i29 = gLVideoViewArr[2].f().left;
            i28 = gLVideoViewArr[2].f().right;
        } else {
            i28 = i27;
            i29 = i27 - i46;
        }
        gLVideoViewArr[2].q(i29, i47, i28, i48);
        if (z16) {
            i37 = gLVideoViewArr[3].f().left;
            i36 = gLVideoViewArr[3].f().right;
        } else {
            i36 = i29;
            i37 = i29 - i46;
        }
        gLVideoViewArr[3].q(i37, i47, i36, i48);
        if (z16) {
            i39 = gLVideoViewArr[4].f().left;
            i38 = gLVideoViewArr[4].f().right;
        } else {
            i38 = i37;
            i39 = i37 - i46;
        }
        gLVideoViewArr[4].q(i39, i47, i38, i48);
        gLVideoViewArr[1].I(-15197410);
        gLVideoViewArr[2].I(-15197410);
        gLVideoViewArr[3].I(-15197410);
        gLVideoViewArr[4].I(-15197410);
        gLVideoViewArr[1].O(2, 3, 3, 3);
        gLVideoViewArr[2].O(2, 3, 2, 3);
        gLVideoViewArr[3].O(2, 3, 2, 3);
        gLVideoViewArr[4].O(3, 3, 2, 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.av.ui.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(GLVideoView[] gLVideoViewArr, int i3, int i16, int i17, int i18, int i19) {
        int i26;
        int i27;
        int i28;
        Context context = this.f76644a;
        if (context == null || gLVideoViewArr == null) {
            return;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.b27);
        int dimensionPixelSize2 = this.f76644a.getResources().getDimensionPixelSize(R.dimen.f159623b24);
        int dimensionPixelSize3 = this.f76644a.getResources().getDimensionPixelSize(R.dimen.f159624b25);
        int dimensionPixelSize4 = this.f76644a.getResources().getDimensionPixelSize(R.dimen.b26);
        if (i19 == 0) {
            dimensionPixelSize4 = dimensionPixelSize3;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        dimensionPixelSize3 = 0;
                        i26 = 0;
                        i28 = 0;
                        i27 = 0;
                        gLVideoViewArr[1].q(dimensionPixelSize3, i27, i26, i28);
                        if (QLog.isColorLevel()) {
                            QLog.w("OriginScreenLayout", 1, "setSmallVideoViewLayout, position[" + i3 + "], width[" + i16 + "], height[" + i17 + "], layout[" + dimensionPixelSize3 + ", " + i27 + ", " + i26 + ", " + i28 + "], topOffset[" + i18 + "], bottomOffset[" + i19 + "], mGlSmallViewTopOffset[" + this.f75331c + "]");
                            return;
                        }
                        return;
                    }
                } else {
                    dimensionPixelSize3 = (i16 - dimensionPixelSize) - dimensionPixelSize3;
                }
                i26 = dimensionPixelSize + dimensionPixelSize3;
                i27 = ((i17 - dimensionPixelSize2) - dimensionPixelSize4) - i19;
                i28 = dimensionPixelSize2 + i27;
                gLVideoViewArr[1].q(dimensionPixelSize3, i27, i26, i28);
                if (QLog.isColorLevel()) {
                }
            } else {
                dimensionPixelSize3 = (i16 - dimensionPixelSize) - dimensionPixelSize3;
            }
        }
        i26 = dimensionPixelSize + dimensionPixelSize3;
        i27 = dimensionPixelSize4 + i18;
        i28 = dimensionPixelSize2 + i27;
        gLVideoViewArr[1].q(dimensionPixelSize3, i27, i26, i28);
        if (QLog.isColorLevel()) {
        }
    }
}
