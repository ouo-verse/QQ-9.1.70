package com.tencent.av.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BidirectionSeekBar extends SeekBar {

    /* renamed from: d, reason: collision with root package name */
    private int f77198d;

    /* renamed from: e, reason: collision with root package name */
    private int f77199e;

    public BidirectionSeekBar(Context context) {
        super(context);
        this.f77198d = 0;
        this.f77199e = 0;
        a();
    }

    @TargetApi(11)
    private void a() {
        if (getThumbOffset() != 0) {
            setThumbOffset(0);
        }
        int intrinsicWidth = getResources().getDrawable(R.drawable.d9x).getIntrinsicWidth();
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) progressDrawable;
            Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.progress);
            a aVar = new a(getResources().getDrawable(R.drawable.f161310uo), getResources().getDrawable(R.drawable.f161311up), 1, intrinsicWidth);
            if (findDrawableByLayerId != null) {
                aVar.setLevel(findDrawableByLayerId.getLevel());
            }
            layerDrawable.setDrawableByLayerId(android.R.id.progress, aVar);
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.f77198d = i3;
        this.f77199e = i16;
    }

    @Override // android.widget.AbsSeekBar
    public void setThumb(Drawable drawable) {
        super.setThumb(drawable);
        setThumbOffset(0);
        int i3 = this.f77198d;
        int i16 = this.f77199e;
        onSizeChanged(i3, i16, i3, i16);
    }

    public BidirectionSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f77198d = 0;
        this.f77199e = 0;
        a();
    }

    public BidirectionSeekBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f77198d = 0;
        this.f77199e = 0;
        a();
    }
}
