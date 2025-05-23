package com.qzone.album.base;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.drawable.ScaleDrawable;
import com.tencent.component.media.image.drawable.SpecifiedDrawable;
import com.tencent.component.media.image.processor.SpecifiedSizeCropByPivotProcessor;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends SpecifiedSizeCropByPivotProcessor {

    /* renamed from: a, reason: collision with root package name */
    private int f42053a;

    /* renamed from: b, reason: collision with root package name */
    private int f42054b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f42055c;

    public a(int i3, int i16) {
        super(i3, i16);
        this.f42053a = i3;
        this.f42054b = i16;
    }

    @Override // com.tencent.component.media.image.processor.SpecifiedSizeCropByPivotProcessor, com.tencent.component.media.image.processor.CropByPivotProcessor, com.tencent.component.media.image.ImageProcessor
    public Drawable process(Drawable drawable) {
        ScaleDrawable scaleDrawable;
        if (this.f42053a <= 0 || this.f42054b <= 0) {
            return drawable;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight > intrinsicWidth) {
            this.f42055c = true;
            this.mPivotXRate = 0.5f;
            this.mPivotYRate = 0.33f;
        }
        if (intrinsicWidth == this.f42053a && intrinsicHeight == this.f42054b) {
            return drawable;
        }
        if (intrinsicWidth < intrinsicHeight * 2 && !this.f42055c) {
            scaleDrawable = new ScaleDrawable(drawable, 0);
        } else {
            scaleDrawable = new ScaleDrawable(drawable, 10);
        }
        scaleDrawable.setPivot(this.mPivotXRate, this.mPivotYRate);
        return new SpecifiedDrawable(scaleDrawable, this.f42053a, this.f42054b);
    }
}
