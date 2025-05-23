package com.tencent.gamematrix.gmcg.sdk.view;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;

/* loaded from: classes6.dex */
public class GmCgTVPlaySessionViewHolder extends GmCgPlaySessionViewHolder {
    public GmCgTVPlaySessionViewHolder() {
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.view.GmCgPlaySessionViewHolder, com.tencent.gamematrix.gmcg.sdk.view.CGCommPlaySessionViewHolder
    protected void setupPlayRenderView() {
        if (this.mPlayContainerView == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= this.mPlayContainerView.getChildCount()) {
                break;
            }
            if (this.mPlayContainerView.getChildAt(i3) instanceof GmCgPlayView) {
                this.mPlayContainerView.removeViewAt(i3);
                break;
            }
            i3++;
        }
        this.mPlayRenderView = new GmCgTVPlayView(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(1, 1, 1, 1);
        this.mPlayContainerView.addView(this.mPlayRenderView, 0, layoutParams);
    }

    public GmCgTVPlaySessionViewHolder(@NonNull FrameLayout frameLayout, boolean z16, boolean z17, boolean z18, boolean z19) {
        super(frameLayout, z16, z17, z18, z19);
    }

    public GmCgTVPlaySessionViewHolder(@NonNull GmCgPlayView gmCgPlayView) {
        super(gmCgPlayView);
    }
}
