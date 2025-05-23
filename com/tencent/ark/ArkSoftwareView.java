package com.tencent.ark;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;
import com.tencent.ark.ArkTextureView;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkSoftwareView extends View implements ArkTextureView.ArkTextureViewInterface {
    protected static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
    protected static final String TAG = "ArkApp.ArkSoftwareView";
    private Bitmap mBitmap;
    protected Lock mBitmapLock;
    private Bitmap mBitmapView;
    private Canvas mCanvas;
    private Canvas mCanvasView;
    private final Runnable mOnInvalidUIThread;
    private final boolean mOptimized;
    private Path mPath;
    private Rect mRectBitmap;
    protected Rect mRectUpdate;
    protected Lock mUpdateLock;
    public ArkViewImplement mViewImpl;

    public ArkSoftwareView(Context context, ArkViewImplement arkViewImplement, boolean z16) {
        super(context);
        this.mRectUpdate = new Rect();
        this.mBitmapLock = new ReentrantLock();
        this.mUpdateLock = new ReentrantLock();
        this.mPath = new Path();
        this.mRectBitmap = new Rect();
        this.mOnInvalidUIThread = new Runnable() { // from class: com.tencent.ark.ArkSoftwareView.1
            @Override // java.lang.Runnable
            public void run() {
                ArkSoftwareView.this.mUpdateLock.lock();
                if (!ArkSoftwareView.this.mRectUpdate.isEmpty()) {
                    ArkSoftwareView arkSoftwareView = ArkSoftwareView.this;
                    Rect scaleRect = ArkViewModelBase.scaleRect(arkSoftwareView.mRectUpdate, arkSoftwareView.mViewImpl.mScale);
                    ArkSoftwareView.this.invalidate(scaleRect.left, scaleRect.top, scaleRect.right, scaleRect.bottom);
                    ArkSoftwareView.this.invalidate();
                    ArkSoftwareView.this.mRectUpdate.setEmpty();
                }
                ArkSoftwareView.this.mUpdateLock.unlock();
            }
        };
        this.mViewImpl = arkViewImplement;
        this.mOptimized = z16;
    }

    @Override // com.tencent.ark.ArkTextureView.ArkTextureViewInterface
    public void destroyBitmapBuffer() {
        this.mBitmapLock.lock();
        try {
            this.mCanvas = null;
            this.mCanvasView = null;
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.mBitmap.recycle();
                this.mBitmap = null;
            }
            Bitmap bitmap2 = this.mBitmapView;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.mBitmapView.recycle();
                this.mBitmapView = null;
            }
            Rect rect = this.mRectBitmap;
            if (rect != null) {
                rect.setEmpty();
            }
        } finally {
            this.mBitmapLock.unlock();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.mViewImpl.getViewModel() == null) {
            return;
        }
        this.mBitmapLock.lock();
        try {
            Rect rect = this.mViewImpl.mRectView;
            Bitmap bitmap = this.mBitmapView;
            if (bitmap != null && !bitmap.isRecycled() && !this.mRectBitmap.isEmpty() && !rect.isEmpty()) {
                ArkViewImplement arkViewImplement = this.mViewImpl;
                if (arkViewImplement.mOpaque && arkViewImplement.mBorderType == 0) {
                    canvas.drawBitmap(this.mBitmapView, this.mRectBitmap, rect, ArkViewImplement.sPaintOpaque);
                } else {
                    canvas.drawBitmap(this.mBitmapView, this.mRectBitmap, rect, ArkViewImplement.sPaint);
                }
                return;
            }
            Logger.logI(TAG, String.format("draw.return.bitmap is null uiview: %h", this));
        } finally {
            this.mBitmapLock.unlock();
        }
    }

    @Override // com.tencent.ark.ArkTextureView.ArkTextureViewInterface
    public Bitmap getBitmapBuffer() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            return this.mBitmap;
        }
        return null;
    }

    @Override // com.tencent.ark.ArkTextureView.ArkTextureViewInterface
    public void initArkView(ArkViewModel arkViewModel) {
        this.mRectUpdate.setEmpty();
    }

    @Override // com.tencent.ark.ArkTextureView.ArkTextureViewInterface
    public boolean onInvalidate(Rect rect) {
        Rect scaleRect = ArkViewModelBase.scaleRect(rect, this.mViewImpl.mScale);
        Canvas canvas = this.mCanvas;
        if (canvas != null) {
            try {
                ArkViewImplement arkViewImplement = this.mViewImpl;
                if (arkViewImplement.mBorderType != 0 && arkViewImplement.mRound) {
                    canvas.save();
                    this.mCanvas.clipRect(scaleRect);
                    this.mCanvas.drawPath(this.mPath, ArkViewImplement.sPaintPath);
                    this.mCanvas.restore();
                }
            } catch (Exception e16) {
                Logger.logE(TAG, String.format("onInvalidate.exception: %s", e16));
            }
        }
        this.mUpdateLock.lock();
        this.mRectUpdate.union(rect);
        this.mUpdateLock.unlock();
        this.mBitmapLock.lock();
        try {
            try {
                Bitmap bitmap = this.mBitmapView;
                if (bitmap != null && !bitmap.isRecycled() && this.mCanvasView != null) {
                    if (this.mOptimized) {
                        ByteBuffer allocate = ByteBuffer.allocate(this.mBitmap.getWidth() * this.mBitmap.getHeight() * 4);
                        allocate.clear();
                        this.mBitmap.copyPixelsToBuffer(allocate);
                        allocate.rewind();
                        this.mBitmapView.copyPixelsFromBuffer(allocate);
                    } else {
                        this.mBitmapView = this.mBitmap.copy(Bitmap.Config.ARGB_8888, true);
                    }
                    this.mBitmapLock.unlock();
                    ArkDispatchTask.getInstance().postToMainThread(this.mOnInvalidUIThread);
                    return true;
                }
                Logger.logE(TAG, String.format("onInvalidate.return.2.view: %h", this));
            } catch (OutOfMemoryError e17) {
                Logger.logE(TAG, e17.getMessage());
            }
            return false;
        } finally {
            this.mBitmapLock.unlock();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        Rect rect = this.mViewImpl.mRectView;
        if (!rect.isEmpty()) {
            setMeasuredDimension(rect.width(), rect.height());
        } else {
            super.onMeasure(i3, i16);
        }
    }

    @Override // com.tencent.ark.ArkTextureView.ArkTextureViewInterface
    public Bitmap recreateBitmapBuffer(Rect rect) {
        if (rect.isEmpty()) {
            Logger.logE(TAG, String.format("recreateBitmapBuffer.rect.empty.uiview: %h", this));
            return null;
        }
        Rect scaleRect = ArkViewModelBase.scaleRect(rect, this.mViewImpl.mScale);
        int width = scaleRect.width();
        int height = scaleRect.height();
        this.mBitmapLock.lock();
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && !bitmap.isRecycled() && this.mBitmap.getWidth() >= width && this.mBitmap.getHeight() >= height) {
            this.mRectBitmap = scaleRect;
            this.mBitmap.eraseColor(0);
            this.mViewImpl.refreshDrawPath(scaleRect, this.mPath);
            this.mBitmapLock.unlock();
            return this.mBitmap;
        }
        Logger.logI(TAG, String.format("recreateBitmapBuffer.1 uiview: %h", this));
        this.mCanvas = null;
        this.mCanvasView = null;
        Bitmap bitmap2 = this.mBitmap;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        Bitmap bitmap3 = this.mBitmapView;
        if (bitmap3 != null && !bitmap3.isRecycled()) {
            this.mBitmapView.recycle();
            this.mBitmapView = null;
        }
        Rect rect2 = this.mRectBitmap;
        if (rect2 != null) {
            rect2.setEmpty();
        }
        try {
            try {
                this.mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.mBitmapView = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.mRectBitmap = scaleRect;
                if (this.mBitmap != null) {
                    this.mCanvas = new Canvas(this.mBitmap);
                }
                if (this.mBitmapView != null) {
                    this.mCanvasView = new Canvas(this.mBitmapView);
                }
                this.mBitmapLock.unlock();
                this.mViewImpl.refreshDrawPath(scaleRect, this.mPath);
                return this.mBitmap;
            } catch (OutOfMemoryError e16) {
                Logger.logE(TAG, e16.getMessage());
                Bitmap bitmap4 = this.mBitmap;
                if (bitmap4 != null) {
                    bitmap4.recycle();
                    this.mBitmap = null;
                }
                Bitmap bitmap5 = this.mBitmapView;
                if (bitmap5 != null) {
                    bitmap5.recycle();
                    this.mBitmapView = null;
                }
                Logger.logE(TAG, String.format("recreateBitmapBuffer.return.null.oom.uiview: %h", this));
                this.mBitmapLock.unlock();
                return null;
            }
        } catch (Throwable th5) {
            this.mBitmapLock.unlock();
            throw th5;
        }
    }

    @Override // com.tencent.ark.ArkTextureView.ArkTextureViewInterface
    public void checkSurfaceAvailable() {
    }

    @Override // com.tencent.ark.ArkTextureView.ArkTextureViewInterface
    public void createContext() {
    }

    @Override // com.tencent.ark.ArkTextureView.ArkTextureViewInterface
    public void releaseContext() {
    }
}
