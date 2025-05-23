package com.tencent.luggage.wxa.fp;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends AppCompatButton {
    public a(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
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
}
