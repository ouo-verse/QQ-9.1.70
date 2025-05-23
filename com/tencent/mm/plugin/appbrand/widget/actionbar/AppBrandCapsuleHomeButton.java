package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AppBrandCapsuleHomeButton extends AppBrandOptionButton {
    public AppBrandCapsuleHomeButton(@NonNull Context context) {
        super(context);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton
    public String getDefaultAccessibilityLabel() {
        return getContext().getString(R.string.ywe);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton
    public Drawable getDefaultImageDrawable() {
        return ContextCompat.getDrawable(getContext(), R.drawable.f160301og0);
    }

    public AppBrandCapsuleHomeButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppBrandCapsuleHomeButton(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3) {
        super(context, attributeSet, i3);
    }

    @TargetApi(21)
    public AppBrandCapsuleHomeButton(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        super(context, attributeSet, i3, i16);
    }
}
