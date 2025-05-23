package com.tencent.mobileqq.search.business.guild;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Region;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import gp2.a;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GuildSearchHeaderLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private float f283039d;

    /* renamed from: e, reason: collision with root package name */
    private float f283040e;

    /* renamed from: f, reason: collision with root package name */
    private float f283041f;

    public GuildSearchHeaderLayout(@NonNull Context context) {
        this(context, null);
    }

    private void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.f402860j2);
        if (obtainStyledAttributes != null) {
            this.f283039d = obtainStyledAttributes.getDimension(a.f402869k2, 0.0f);
            this.f283040e = obtainStyledAttributes.getDimension(a.f402878l2, 0.0f);
            this.f283041f = obtainStyledAttributes.getDimension(a.f402887m2, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Path path = new Path();
        path.addCircle(this.f283039d, this.f283040e, this.f283041f, Path.Direction.CW);
        canvas.clipPath(path, Region.Op.DIFFERENCE);
        super.dispatchDraw(canvas);
    }

    public GuildSearchHeaderLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildSearchHeaderLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(attributeSet);
    }
}
