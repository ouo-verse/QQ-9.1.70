package com.tencent.av.ui;

import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.foldable.FoldInfoUtils;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ad extends x {
    /* JADX INFO: Access modifiers changed from: protected */
    public ad(Context context, VideoAppInterface videoAppInterface) {
        super(context, videoAppInterface);
    }

    private void m(GLVideoView gLVideoView, GLVideoView gLVideoView2, int i3, int i16) {
        int i17 = i3 >> 1;
        gLVideoView.O(0, 0, 0, 0);
        gLVideoView.I(-15197410);
        gLVideoView.n0(false);
        gLVideoView2.O(0, 0, 0, 0);
        gLVideoView2.I(-15197410);
        gLVideoView2.n0(false);
        if (FoldInfoUtils.j(this.f76644a)) {
            gLVideoView.q(i17, 0, i3, i16);
            gLVideoView2.q(0, 0, i17, i16);
            if (!gLVideoView.M0()) {
                gLVideoView.P(270);
                return;
            }
            return;
        }
        gLVideoView.q(0, 0, i17, i16);
        gLVideoView2.q(i17, 0, i3, i16);
    }

    @Override // com.tencent.av.ui.x
    public boolean a() {
        return false;
    }

    @Override // com.tencent.av.ui.x
    public int c() {
        return 9;
    }

    @Override // com.tencent.av.ui.x
    public void h(GLVideoView[] gLVideoViewArr, int i3, int i16, int i17, int i18, int i19, boolean z16) {
        m(gLVideoViewArr[0], gLVideoViewArr[1], i3, i16);
    }
}
