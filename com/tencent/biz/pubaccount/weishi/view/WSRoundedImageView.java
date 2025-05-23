package com.tencent.biz.pubaccount.weishi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSRoundedImageView extends KandianUrlImageView {

    /* renamed from: d, reason: collision with root package name */
    a f82424d;

    public WSRoundedImageView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f82424d.f82438e) {
            canvas.save();
            canvas.clipPath(this.f82424d.f82434a);
            super.draw(canvas);
            canvas.restore();
            return;
        }
        super.draw(canvas);
    }

    @Override // android.view.View
    public void invalidate() {
        a aVar = this.f82424d;
        if (aVar != null) {
            aVar.d(this);
        }
        super.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.kandian.base.view.widget.ZImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.saveLayer(this.f82424d.f82440g, null, 31);
        super.onDraw(canvas);
        this.f82424d.b(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.f82424d.c(this, i3, i16);
    }

    public void setStrokeColor(int i3) {
        this.f82424d.f82436c = i3;
        invalidate();
    }

    public void setStrokeWidth(int i3) {
        this.f82424d.f82437d = i3;
        invalidate();
    }

    public WSRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WSRoundedImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a aVar = new a();
        this.f82424d = aVar;
        aVar.a();
    }
}
