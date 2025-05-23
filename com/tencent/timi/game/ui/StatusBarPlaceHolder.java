package com.tencent.timi.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;

/* loaded from: classes26.dex */
public class StatusBarPlaceHolder extends View {
    public StatusBarPlaceHolder(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, Math.round(ViewUtils.getStatusBarHeight(BaseApplication.context)) | 1073741824);
    }

    public StatusBarPlaceHolder(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StatusBarPlaceHolder(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
