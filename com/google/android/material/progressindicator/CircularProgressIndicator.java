package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.tencent.mobileqq.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public final class CircularProgressIndicator extends BaseProgressIndicator<CircularProgressIndicatorSpec> {
    public static final int L = 2131953428;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface IndicatorDirection {
    }

    public CircularProgressIndicator(@NonNull Context context) {
        this(context, null);
    }

    private void w() {
        setIndeterminateDrawable(i.v(getContext(), (CircularProgressIndicatorSpec) this.f33936d));
        setProgressDrawable(e.x(getContext(), (CircularProgressIndicatorSpec) this.f33936d));
    }

    public void setIndicatorDirection(int i3) {
        ((CircularProgressIndicatorSpec) this.f33936d).f33946i = i3;
        invalidate();
    }

    public void setIndicatorInset(@Px int i3) {
        S s16 = this.f33936d;
        if (((CircularProgressIndicatorSpec) s16).f33945h != i3) {
            ((CircularProgressIndicatorSpec) s16).f33945h = i3;
            invalidate();
        }
    }

    public void setIndicatorSize(@Px int i3) {
        int max = Math.max(i3, n() * 2);
        S s16 = this.f33936d;
        if (((CircularProgressIndicatorSpec) s16).f33944g != max) {
            ((CircularProgressIndicatorSpec) s16).f33944g = max;
            ((CircularProgressIndicatorSpec) s16).e();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int i3) {
        super.setTrackThickness(i3);
        ((CircularProgressIndicatorSpec) this.f33936d).e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public CircularProgressIndicatorSpec i(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new CircularProgressIndicatorSpec(context, attributeSet);
    }

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.a6h);
    }

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3) {
        super(context, attributeSet, i3, L);
        w();
    }
}
