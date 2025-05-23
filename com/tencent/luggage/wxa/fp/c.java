package com.tencent.luggage.wxa.fp;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c extends AppCompatImageView {
    public c(Context context) {
        super(context);
    }

    @Override // android.view.View
    @NotNull
    public Resources getResources() {
        Resources resources = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        return resources;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public c(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
