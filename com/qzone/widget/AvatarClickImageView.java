package com.qzone.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AvatarClickImageView extends AvatarImageView {
    private Bitmap I;
    private Bitmap J;
    public boolean K;
    private Paint L;

    public AvatarClickImageView(Context context) {
        super(context);
        this.K = false;
    }

    private void i() {
        if (this.L == null) {
            this.L = new Paint();
        }
    }

    private Bitmap l(Bitmap bitmap, int i3, int i16) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i3 / width, i16 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.AvatarImageView, com.qzone.widget.ExtendImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        super.onDraw(canvas);
        if (!this.K || (bitmap = this.I) == null) {
            return;
        }
        Bitmap l3 = l(bitmap, getMeasuredWidth() / 3, getMeasuredHeight() / 3);
        this.I = l3;
        canvas.drawBitmap(l3, getMeasuredWidth() - this.I.getWidth(), getMeasuredHeight() - this.I.getHeight(), this.L);
        Bitmap bitmap2 = this.J;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, (getMeasuredWidth() / 2) - (this.J.getWidth() / 2), (getMeasuredHeight() / 2) - (this.J.getHeight() / 2), this.L);
        }
    }

    public void setSelectedBackground(boolean z16) {
        this.K = z16;
        invalidate();
    }

    public void setSelectedBitmapLayer(int... iArr) {
        try {
            if (iArr.length != 0) {
                this.I = BitmapFactory.decodeResource(getResources(), iArr[0]);
            }
            if (iArr.length > 1) {
                this.J = BitmapFactory.decodeResource(getResources(), iArr[1]);
            }
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
        }
    }

    public AvatarClickImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        i();
    }

    public AvatarClickImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.K = false;
        i();
    }
}
