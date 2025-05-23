package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;

/* compiled from: P */
/* loaded from: classes15.dex */
public class KanDianUrlRoundCornerImageView extends KandianUrlImageView {

    /* renamed from: d, reason: collision with root package name */
    private int f239181d;

    public KanDianUrlRoundCornerImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f239181d = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.kandian.base.view.widget.ZImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f239181d > 0) {
            Path path = new Path();
            RectF rectF = new RectF(new Rect(0, 0, getWidth(), getHeight()));
            int i3 = this.f239181d;
            path.addRoundRect(rectF, i3, i3, Path.Direction.CCW);
            if (Build.VERSION.SDK_INT >= 28) {
                canvas.clipPath(path);
            } else {
                canvas.clipPath(path, Region.Op.REPLACE);
            }
        }
        super.onDraw(canvas);
    }

    public void setCorner(int i3) {
        if (i3 < 0) {
            return;
        }
        this.f239181d = i3;
    }

    public KanDianUrlRoundCornerImageView(Context context) {
        super(context);
        this.f239181d = 0;
    }

    public KanDianUrlRoundCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f239181d = 0;
    }
}
