package com.tencent.av.ui;

import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.avcore.util.AVCoreLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class y extends x {
    /* JADX INFO: Access modifiers changed from: protected */
    public y(Context context, VideoAppInterface videoAppInterface) {
        super(context, videoAppInterface);
    }

    private void m(GLVideoView gLVideoView, GLVideoView gLVideoView2, int i3, int i16) {
        int i17 = i3 >> 1;
        gLVideoView.O(0, 0, 0, 0);
        gLVideoView.q(0, 0, i17, i16);
        gLVideoView.I(-15197410);
        gLVideoView.n0(false);
        gLVideoView2.O(0, 0, 0, 0);
        gLVideoView2.q(i17, 0, i3, i16);
        gLVideoView2.I(-15197410);
        gLVideoView2.n0(false);
    }

    @Override // com.tencent.av.ui.x
    public boolean a() {
        return false;
    }

    @Override // com.tencent.av.ui.x
    public int c() {
        return 7;
    }

    @Override // com.tencent.av.ui.x
    public void h(GLVideoView[] gLVideoViewArr, int i3, int i16, int i17, int i18, int i19, boolean z16) {
        boolean z17 = !this.f76645b.getCurrentAccountUin().equals(gLVideoViewArr[1].l(0));
        AVCoreLog.printColorLog("ScreenLayoutDoubleHorizontalScreen", "layoutCommon: " + z16 + "|" + z17);
        if (!z17) {
            m(gLVideoViewArr[1], gLVideoViewArr[0], i3, i16);
        } else {
            m(gLVideoViewArr[0], gLVideoViewArr[1], i3, i16);
        }
    }
}
