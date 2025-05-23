package com.tencent.hippy.qq.view.tkd.listview;

import android.graphics.Canvas;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface HippyTKDRefreshAnimation {
    void animateRefresh();

    void draw(Canvas canvas, int i3, int i16, int i17);

    void onSkinChange();

    void setInvalidateCallback(HippyTKDInvalidateCallback hippyTKDInvalidateCallback);

    void stopAllAnimators();
}
