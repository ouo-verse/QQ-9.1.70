package com.qwallet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class BaseNestHeaderLayout extends BaseLayout implements a {
    public BaseNestHeaderLayout(@NonNull Context context) {
        super(context);
    }

    @Override // com.qwallet.view.a
    public void onScrollTo(int i3, int i16, int i17, int i18) {
        View view = this.f41789d;
        if (view != null) {
            view.scrollTo(0, i16);
        }
    }

    public BaseNestHeaderLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
