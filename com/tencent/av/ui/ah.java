package com.tencent.av.ui;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ah extends x {

    /* renamed from: c, reason: collision with root package name */
    protected Display f75334c;

    /* JADX INFO: Access modifiers changed from: protected */
    public ah(Context context, VideoAppInterface videoAppInterface) {
        super(context, videoAppInterface);
        this.f75334c = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    @Override // com.tencent.av.ui.x
    public boolean a() {
        return false;
    }

    @Override // com.tencent.av.ui.x
    public int c() {
        return 5;
    }

    @Override // com.tencent.av.ui.x
    public void h(GLVideoView[] gLVideoViewArr, int i3, int i16, int i17, int i18, int i19, boolean z16) {
        gLVideoViewArr[1].O(3, 3, 3, 3);
        gLVideoViewArr[1].I(-15197410);
        l(gLVideoViewArr, i17, i3, i16, i18, i19);
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
        Context context = this.f76644a;
        if (context == null) {
            return;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.f159624b25);
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

    @Override // com.tencent.av.ui.x
    public void l(GLVideoView[] gLVideoViewArr, int i3, int i16, int i17, int i18, int i19) {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        int dimensionPixelSize3;
        int i26;
        int i27;
        int i28;
        int i29;
        if (QLog.isColorLevel()) {
            QLog.d("ScreenLayoutSmallUIOrigin", 2, "setSmallVideoViewLayout position: " + i3);
        }
        Context context = this.f76644a;
        if (context == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ScreenLayoutSmallUIOrigin", 2, "setSmallVideoViewLayout mContext == null");
                return;
            }
            return;
        }
        context.getResources().getDimensionPixelSize(R.dimen.b27);
        this.f76644a.getResources().getDimensionPixelSize(R.dimen.f159623b24);
        this.f76644a.getResources().getDimensionPixelSize(R.dimen.f159624b25);
        this.f76644a.getResources().getDimensionPixelSize(R.dimen.b26);
        if (this.f75334c.getRotation() % 2 == 0) {
            dimensionPixelSize = this.f76644a.getResources().getDimensionPixelSize(R.dimen.a9f);
            dimensionPixelSize2 = this.f76644a.getResources().getDimensionPixelSize(R.dimen.a9c);
            i26 = this.f76644a.getResources().getDimensionPixelSize(R.dimen.a9d);
            dimensionPixelSize3 = this.f76644a.getResources().getDimensionPixelSize(R.dimen.a9e);
        } else {
            dimensionPixelSize = this.f76644a.getResources().getDimensionPixelSize(R.dimen.a9c);
            dimensionPixelSize2 = this.f76644a.getResources().getDimensionPixelSize(R.dimen.a9f);
            int dimensionPixelSize4 = this.f76644a.getResources().getDimensionPixelSize(R.dimen.a9e);
            dimensionPixelSize3 = this.f76644a.getResources().getDimensionPixelSize(R.dimen.a9d);
            i26 = dimensionPixelSize4;
        }
        if (i19 == 0) {
            dimensionPixelSize3 = i26;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        i26 = 0;
                        i27 = 0;
                        i28 = 0;
                        i29 = 0;
                    } else {
                        i27 = i26 + dimensionPixelSize;
                        i28 = ((i17 - dimensionPixelSize2) - dimensionPixelSize3) - i19;
                        i29 = i28 + dimensionPixelSize2;
                    }
                } else {
                    i26 = (i16 - dimensionPixelSize) - i26;
                    int i36 = ((i17 - dimensionPixelSize2) - dimensionPixelSize3) - i19;
                    i29 = i36 + dimensionPixelSize2;
                    i28 = i36;
                    i27 = i26 + dimensionPixelSize;
                }
                gLVideoViewArr[1].q(i26, i28, i27, i29);
            }
            i26 = (i16 - dimensionPixelSize) - i26;
        }
        i27 = i26 + dimensionPixelSize;
        i28 = dimensionPixelSize3 + i18;
        i29 = i28 + dimensionPixelSize2;
        gLVideoViewArr[1].q(i26, i28, i27, i29);
    }
}
