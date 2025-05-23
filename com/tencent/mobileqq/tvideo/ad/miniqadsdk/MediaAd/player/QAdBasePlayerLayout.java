package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.player;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import kt3.e;
import kt3.f;

/* loaded from: classes19.dex */
public abstract class QAdBasePlayerLayout extends FrameLayout implements f {
    public QAdBasePlayerLayout(@NonNull Context context) {
        super(context);
    }

    public /* synthetic */ void d(boolean z16) {
        e.a(this, z16);
    }

    public abstract /* synthetic */ void setPlayerCallback(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player.a aVar);

    public abstract /* synthetic */ void setResizePlayerEnable(boolean z16);

    public abstract /* synthetic */ void setVideoWidthAndHeight(int i3, int i16);

    public QAdBasePlayerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QAdBasePlayerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @Override // kt3.f
    public void a(com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.a aVar) {
    }
}
