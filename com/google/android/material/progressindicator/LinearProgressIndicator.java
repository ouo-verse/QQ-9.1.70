package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public final class LinearProgressIndicator extends BaseProgressIndicator<LinearProgressIndicatorSpec> {
    public static final int L = 2131953440;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface IndeterminateAnimationType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface IndicatorDirection {
    }

    public LinearProgressIndicator(@NonNull Context context) {
        this(context, null);
    }

    private void w() {
        setIndeterminateDrawable(i.w(getContext(), (LinearProgressIndicatorSpec) this.f33936d));
        setProgressDrawable(e.y(getContext(), (LinearProgressIndicatorSpec) this.f33936d));
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        S s16 = this.f33936d;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s16;
        boolean z17 = true;
        if (((LinearProgressIndicatorSpec) s16).f33948h != 1 && ((ViewCompat.getLayoutDirection(this) != 1 || ((LinearProgressIndicatorSpec) this.f33936d).f33948h != 2) && (ViewCompat.getLayoutDirection(this) != 0 || ((LinearProgressIndicatorSpec) this.f33936d).f33948h != 3))) {
            z17 = false;
        }
        linearProgressIndicatorSpec.f33949i = z17;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        int paddingLeft = i3 - (getPaddingLeft() + getPaddingRight());
        int paddingTop = i16 - (getPaddingTop() + getPaddingBottom());
        i<LinearProgressIndicatorSpec> indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
        e<LinearProgressIndicatorSpec> progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
    }

    public void setIndeterminateAnimationType(int i3) {
        if (((LinearProgressIndicatorSpec) this.f33936d).f33947g == i3) {
            return;
        }
        if (u() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        S s16 = this.f33936d;
        ((LinearProgressIndicatorSpec) s16).f33947g = i3;
        ((LinearProgressIndicatorSpec) s16).e();
        if (i3 == 0) {
            getIndeterminateDrawable().z(new k((LinearProgressIndicatorSpec) this.f33936d));
        } else {
            getIndeterminateDrawable().z(new l(getContext(), (LinearProgressIndicatorSpec) this.f33936d));
        }
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(@NonNull int... iArr) {
        super.setIndicatorColor(iArr);
        ((LinearProgressIndicatorSpec) this.f33936d).e();
    }

    public void setIndicatorDirection(int i3) {
        S s16 = this.f33936d;
        ((LinearProgressIndicatorSpec) s16).f33948h = i3;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s16;
        boolean z16 = true;
        if (i3 != 1 && ((ViewCompat.getLayoutDirection(this) != 1 || ((LinearProgressIndicatorSpec) this.f33936d).f33948h != 2) && (ViewCompat.getLayoutDirection(this) != 0 || i3 != 3))) {
            z16 = false;
        }
        linearProgressIndicatorSpec.f33949i = z16;
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setProgressCompat(int i3, boolean z16) {
        S s16 = this.f33936d;
        if (s16 != 0 && ((LinearProgressIndicatorSpec) s16).f33947g == 0 && isIndeterminate()) {
            return;
        }
        super.setProgressCompat(i3, z16);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int i3) {
        super.setTrackCornerRadius(i3);
        ((LinearProgressIndicatorSpec) this.f33936d).e();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public LinearProgressIndicatorSpec i(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new LinearProgressIndicatorSpec(context, attributeSet);
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.arb);
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3) {
        super(context, attributeSet, i3, L);
        w();
    }
}
