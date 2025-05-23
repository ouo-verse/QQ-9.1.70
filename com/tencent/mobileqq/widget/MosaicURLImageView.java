package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.t;

/* compiled from: P */
/* loaded from: classes20.dex */
public class MosaicURLImageView extends URLImageView implements t.a {

    /* renamed from: d, reason: collision with root package name */
    private t f315853d;

    public MosaicURLImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        t tVar = this.f315853d;
        if (tVar != null) {
            tVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        t tVar = this.f315853d;
        if (tVar != null) {
            tVar.b(canvas);
        } else {
            super.onDraw(canvas);
        }
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void setMosaicEffect(t tVar) {
        t tVar2 = this.f315853d;
        if (tVar2 != null) {
            tVar2.c(null);
        }
        this.f315853d = tVar;
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

    public MosaicURLImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MosaicURLImageView(Context context) {
        super(context);
    }
}
