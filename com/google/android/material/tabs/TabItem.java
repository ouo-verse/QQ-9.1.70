package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;

/* compiled from: P */
/* loaded from: classes2.dex */
public class TabItem extends View {

    /* renamed from: d, reason: collision with root package name */
    public final CharSequence f34230d;

    /* renamed from: e, reason: collision with root package name */
    public final Drawable f34231e;

    /* renamed from: f, reason: collision with root package name */
    public final int f34232f;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, w0.a.f444039t8);
        this.f34230d = obtainStyledAttributes.getText(w0.a.f444073w8);
        this.f34231e = obtainStyledAttributes.getDrawable(w0.a.f444051u8);
        this.f34232f = obtainStyledAttributes.getResourceId(w0.a.f444062v8, 0);
        obtainStyledAttributes.recycle();
    }
}
