package com.tencent.mtt.hippy.views.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.mtt.supportui.views.asyncimage.ContentDrawable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes20.dex */
class HippyContentDrawable extends ContentDrawable {
    private NinePatchDrawable mNinePatchDrawable;
    private Rect mNinePatchRect;

    private byte[] createNinePatchTrunk(Bitmap bitmap, Rect rect) {
        int[] iArr = {rect.left, bitmap.getWidth() - rect.right};
        int[] iArr2 = {rect.top, bitmap.getHeight() - rect.bottom};
        ByteBuffer order = ByteBuffer.allocate(84).order(ByteOrder.nativeOrder());
        order.put((byte) 1);
        order.put((byte) 2);
        order.put((byte) 2);
        order.put((byte) 9);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(iArr[0]);
        order.putInt(iArr[1]);
        order.putInt(iArr2[0]);
        order.putInt(iArr2[1]);
        for (int i3 = 0; i3 < 9; i3++) {
            order.putInt(1);
        }
        return order.array();
    }

    @Override // com.tencent.mtt.supportui.views.asyncimage.ContentDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mNinePatchRect != null && this.mContentBitmap != null) {
            if (this.mNinePatchDrawable == null) {
                Resources resources = ContextHolder.getAppContext().getResources();
                Bitmap bitmap = this.mContentBitmap;
                this.mNinePatchDrawable = new NinePatchDrawable(resources, bitmap, createNinePatchTrunk(bitmap, this.mNinePatchRect), null, null);
            }
            this.mNinePatchDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.mNinePatchDrawable.setAlpha(this.mAlpha);
            if (this.mTintColor != 0) {
                this.mNinePatchDrawable.setColorFilter(new PorterDuffColorFilter(this.mTintColor, PorterDuff.Mode.SRC_ATOP));
            }
            this.mNinePatchDrawable.draw(canvas);
            return;
        }
        super.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNinePatchCoordinate(Rect rect) {
        this.mNinePatchRect = rect;
        this.mNinePatchDrawable = null;
    }
}
