package com.tencent.ams.fusion.widget.cny2025.twist;

import android.graphics.Bitmap;
import com.tencent.ams.fusion.widget.base.AnimatableView;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface ICNYTwistView extends AnimatableView {
    void setCollisionApng(String str);

    void setIcons(Bitmap bitmap, Bitmap bitmap2);

    void setInteractListener(ICNYTwistViewListener iCNYTwistViewListener);

    void setReverseAngle(float f16);

    void setReverseTitle(String str);

    void setSubtitle(String str);

    void setTargetAngle(float f16);

    void setTitle(String str);
}
