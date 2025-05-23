package com.tencent.av.ui;

import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.avcore.util.AVCoreLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class z extends x {
    /* JADX INFO: Access modifiers changed from: protected */
    public z(Context context, VideoAppInterface videoAppInterface) {
        super(context, videoAppInterface);
    }

    public static int m(int i3) {
        return ((i3 << 16) / 1201) >> 6;
    }

    public static int n(int i3) {
        return (i3 * 1201) >> 10;
    }

    private void o(GLVideoView gLVideoView, GLVideoView gLVideoView2, int i3) {
        int i16 = i3 >> 1;
        int n3 = n(i3);
        gLVideoView.O(0, 0, 0, 0);
        gLVideoView.q(0, 0, i16, n3);
        gLVideoView.I(-15197410);
        gLVideoView2.O(0, 0, 0, 0);
        gLVideoView2.q(i16, 0, i3, n3);
        gLVideoView2.I(-15197410);
    }

    @Override // com.tencent.av.ui.x
    public boolean a() {
        return false;
    }

    @Override // com.tencent.av.ui.x
    public int c() {
        return 2;
    }

    @Override // com.tencent.av.ui.x
    public void h(GLVideoView[] gLVideoViewArr, int i3, int i16, int i17, int i18, int i19, boolean z16) {
        boolean z17 = !this.f76645b.getCurrentAccountUin().equals(gLVideoViewArr[1].l(0));
        AVCoreLog.printColorLog("ScreenLayoutDoubleScreen", "layoutCommon: " + z16 + "|" + z17);
        if (z17) {
            z16 = !z16;
        }
        gLVideoViewArr[0].n0(false);
        gLVideoViewArr[1].n0(false);
        if (z16) {
            o(gLVideoViewArr[1], gLVideoViewArr[0], i3);
        } else {
            o(gLVideoViewArr[0], gLVideoViewArr[1], i3);
        }
    }
}
