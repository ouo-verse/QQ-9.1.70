package com.tencent.av.ui;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ae extends x {

    /* renamed from: c, reason: collision with root package name */
    private int f75332c;

    public ae(Context context, VideoAppInterface videoAppInterface) {
        super(context, videoAppInterface);
        this.f75332c = (int) com.tencent.mobileqq.utils.al.a(context, 100.0f);
    }

    @Override // com.tencent.av.ui.x
    public boolean a() {
        if (QLog.isDevelopLevel()) {
            QLog.w("ScreenLayoutSliderWindow", 1, "canSwitchView true");
        }
        return true;
    }

    @Override // com.tencent.av.ui.x
    public int c() {
        return 4;
    }

    @Override // com.tencent.av.ui.x
    public void h(GLVideoView[] gLVideoViewArr, int i3, int i16, int i17, int i18, int i19, boolean z16) {
        gLVideoViewArr[0].O(0, 0, 0, 0);
        gLVideoViewArr[0].n0(true);
        gLVideoViewArr[0].q(0, 0, i3, i16);
        gLVideoViewArr[0].I(-15197410);
        gLVideoViewArr[1].n0(true);
        gLVideoViewArr[1].O(3, 3, 3, 3);
        gLVideoViewArr[1].I(-15197410);
        l(gLVideoViewArr, i17, i3, i16, i18, i19);
    }

    @Override // com.tencent.av.ui.x
    public void i(SessionInfo sessionInfo, GLVideoView[] gLVideoViewArr, int i3, int i16, boolean z16, int i17, int i18) {
        if (this.f76644a == null) {
            return;
        }
        if (gLVideoViewArr.length >= 1) {
            gLVideoViewArr[0].n0(false);
        }
        for (int i19 = 1; i19 < gLVideoViewArr.length; i19++) {
            gLVideoViewArr[i19].n0(true);
        }
    }

    @Override // com.tencent.av.ui.x
    public void j(int i3, Rect rect, Rect rect2, ConcurrentHashMap<Long, am> concurrentHashMap) {
        rect2.set(rect.left, rect.top - i3, rect.right, rect.bottom - i3);
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
                            QLog.w("ScreenLayoutSliderWindow", 1, "setSmallVideoViewLayout, position[" + i3 + "], width[" + i16 + "], height[" + i17 + "], layout[" + dimensionPixelSize3 + ", " + i27 + ", " + i26 + ", " + i28 + "], topOffset[" + i18 + "], bottomOffset[" + i19 + "], mGlSmallViewTopOffset[" + this.f75332c + "]");
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
