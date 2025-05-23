package org.light.extDecoder.apng;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import org.light.extDecoder.apng.ApngWrapper;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ApngRender {
    private Rect mDisposeRect = new Rect();
    private byte mLastDisposeOp = 0;
    private Bitmap prBitmap = null;

    public void renderDraw(Canvas canvas, Paint paint, ApngWrapper.ApngFrameResource apngFrameResource, Bitmap bitmap, Bitmap bitmap2) {
        int i3 = apngFrameResource.frameX;
        int i16 = apngFrameResource.frameY;
        Rect rect = new Rect(i3, i16, apngFrameResource.frameWidth + i3, apngFrameResource.frameHeight + i16);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        canvas.save();
        byte b16 = this.mLastDisposeOp;
        if (b16 != 1) {
            if (b16 == 2) {
                canvas.clipRect(0, 0, width, height);
                Bitmap bitmap3 = this.prBitmap;
                if (bitmap3 != null) {
                    canvas.drawBitmap(bitmap3, 0.0f, 0.0f, paint);
                } else {
                    canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                }
            }
        } else {
            canvas.clipRect(this.mDisposeRect);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        canvas.restore();
        if (apngFrameResource.dispose_op == 2) {
            this.prBitmap = bitmap2.copy(Bitmap.Config.ARGB_8888, true);
        } else {
            this.prBitmap = null;
        }
        canvas.save();
        if (apngFrameResource.blend_op == 0) {
            canvas.clipRect(rect);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        canvas.restore();
        canvas.save();
        canvas.clipRect(0, 0, width, height);
        canvas.drawBitmap(bitmap, apngFrameResource.frameX, apngFrameResource.frameY, paint);
        canvas.restore();
        this.mLastDisposeOp = apngFrameResource.dispose_op;
        this.mDisposeRect = rect;
    }

    public void reset() {
        this.mLastDisposeOp = (byte) 0;
        this.mDisposeRect = new Rect();
        this.prBitmap = null;
    }
}
