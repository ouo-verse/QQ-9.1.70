package com.epicgames.ue4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes2.dex */
public class OffscreenSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, Runnable {
    public static final String TAG = "CEOffscreenSurfaceView";
    private Bitmap mBitmap;
    private volatile boolean mIsRunning;
    private final Lock mLock;
    private final ArrayList<Bitmap> mPendingBitmapList;
    private Thread mRenderThread;
    private SurfaceHolder mSurfaceHolder;

    public OffscreenSurfaceView(Context context) {
        super(context);
        this.mRenderThread = null;
        this.mSurfaceHolder = null;
        this.mIsRunning = false;
        this.mLock = new ReentrantLock();
        this.mPendingBitmapList = new ArrayList<>();
        this.mBitmap = null;
        SurfaceHolder holder = getHolder();
        this.mSurfaceHolder = holder;
        holder.setFormat(-2);
        this.mSurfaceHolder.addCallback(this);
    }

    public void pause() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            while (!this.mIsRunning) {
                try {
                    this.mRenderThread.join();
                    return;
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public void resume() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            BaseThread baseThread = new BaseThread(this);
            this.mRenderThread = baseThread;
            baseThread.start();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (this.mIsRunning) {
            if (this.mSurfaceHolder.getSurface().isValid() && !this.mPendingBitmapList.isEmpty()) {
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.STROKE);
                Canvas lockCanvas = this.mSurfaceHolder.lockCanvas();
                this.mLock.lock();
                this.mBitmap = this.mPendingBitmapList.remove(0);
                Iterator<Bitmap> it = this.mPendingBitmapList.iterator();
                while (it.hasNext()) {
                    Bitmap next = it.next();
                    if (next != null && !next.isRecycled()) {
                        next.recycle();
                    }
                    it.remove();
                }
                this.mPendingBitmapList.clear();
                this.mLock.unlock();
                if (this.mBitmap != null) {
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                    lockCanvas.drawPaint(paint);
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
                    lockCanvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, paint);
                }
                this.mSurfaceHolder.unlockCanvasAndPost(lockCanvas);
                Bitmap bitmap = this.mBitmap;
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.mBitmap.recycle();
                    this.mBitmap = null;
                    System.gc();
                }
            }
        }
    }

    public void setRenderData(Bitmap bitmap) {
        this.mLock.lock();
        this.mPendingBitmapList.add(0, bitmap);
        this.mLock.unlock();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
    }
}
