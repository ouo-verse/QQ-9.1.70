package org.light.extDecoder.apng;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import org.light.extDecoder.apng.ApngWrapper;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ApngFrame {
    IFrame iFrame;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface IFrame {
        void draw(Canvas canvas, Paint paint, Bitmap bitmap);

        Bitmap getBitmap();

        int getHeight();

        int getSize();

        int getWidth();

        void initialize();

        boolean isRecycled();

        void recycle();
    }

    public void draw(Canvas canvas, Paint paint, Bitmap bitmap) {
        IFrame iFrame = this.iFrame;
        if (iFrame == null) {
            return;
        }
        iFrame.draw(canvas, paint, bitmap);
    }

    public IFrame getFrameSource() {
        return this.iFrame;
    }

    public int getHeight() {
        IFrame iFrame = this.iFrame;
        if (iFrame == null) {
            return 0;
        }
        return iFrame.getHeight();
    }

    public int getSize() {
        IFrame iFrame = this.iFrame;
        if (iFrame == null) {
            return 0;
        }
        return iFrame.getSize();
    }

    public int getWidth() {
        IFrame iFrame = this.iFrame;
        if (iFrame == null) {
            return 0;
        }
        return iFrame.getWidth();
    }

    public void initialize() {
        IFrame iFrame = this.iFrame;
        if (iFrame == null) {
            return;
        }
        iFrame.initialize();
    }

    public boolean isRecycled() {
        IFrame iFrame = this.iFrame;
        if (iFrame == null) {
            return true;
        }
        return iFrame.isRecycled();
    }

    public void recycle() {
        IFrame iFrame = this.iFrame;
        if (iFrame == null) {
            return;
        }
        iFrame.recycle();
    }

    public void setSource(ApngWrapper.ApngFrameResource apngFrameResource, Bitmap bitmap, ApngRender apngRender) {
        if (bitmap == null) {
            return;
        }
        this.iFrame = new FrameBitmap(apngFrameResource, bitmap, apngRender);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class FrameBitmap implements IFrame {
        private final ApngRender apngRender;
        private final Bitmap bitmap;
        private final ApngWrapper.ApngFrameResource frameResource;

        public FrameBitmap(ApngWrapper.ApngFrameResource apngFrameResource, Bitmap bitmap, ApngRender apngRender) {
            this.frameResource = apngFrameResource;
            this.bitmap = bitmap;
            this.apngRender = apngRender;
        }

        @Override // org.light.extDecoder.apng.ApngFrame.IFrame
        public void draw(Canvas canvas, Paint paint, Bitmap bitmap) {
            this.apngRender.renderDraw(canvas, paint, this.frameResource, this.bitmap, bitmap);
        }

        @Override // org.light.extDecoder.apng.ApngFrame.IFrame
        public Bitmap getBitmap() {
            return this.bitmap;
        }

        @Override // org.light.extDecoder.apng.ApngFrame.IFrame
        public int getHeight() {
            return this.bitmap.getHeight();
        }

        @Override // org.light.extDecoder.apng.ApngFrame.IFrame
        public int getSize() {
            return this.bitmap.getAllocationByteCount();
        }

        @Override // org.light.extDecoder.apng.ApngFrame.IFrame
        public int getWidth() {
            return this.bitmap.getWidth();
        }

        @Override // org.light.extDecoder.apng.ApngFrame.IFrame
        public boolean isRecycled() {
            return this.bitmap.isRecycled();
        }

        @Override // org.light.extDecoder.apng.ApngFrame.IFrame
        public void recycle() {
            this.bitmap.recycle();
        }

        @Override // org.light.extDecoder.apng.ApngFrame.IFrame
        public void initialize() {
        }
    }
}
