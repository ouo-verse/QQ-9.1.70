package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.t;

/* compiled from: P */
/* loaded from: classes20.dex */
public class CommonImageView extends ImageView implements t.a {

    /* renamed from: d, reason: collision with root package name */
    private t f315555d;

    public CommonImageView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        t tVar = this.f315555d;
        if (tVar != null) {
            tVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        t tVar = this.f315555d;
        if (tVar != null) {
            tVar.b(canvas);
        } else {
            super.onDraw(canvas);
        }
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void setMosaicEffect(t tVar) {
        t tVar2 = this.f315555d;
        if (tVar2 != null) {
            tVar2.c(null);
        }
        this.f315555d = tVar;
        if (tVar != null) {
            tVar.c(this);
        }
        invalidate();
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void superDrawMosaic(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void superOnDrawMosaic(Canvas canvas) {
        super.onDraw(canvas);
    }

    public CommonImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CommonImageView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
