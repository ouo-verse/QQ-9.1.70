package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes4.dex */
public class StatusBarView extends View {
    public StatusBarView(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, Math.round(ViewUtils.getStatusBarHeight(getContext())) | 1073741824);
    }

    public StatusBarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StatusBarView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
