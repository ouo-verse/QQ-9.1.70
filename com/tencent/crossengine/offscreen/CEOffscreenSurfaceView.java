package com.tencent.crossengine.offscreen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes32.dex */
public class CEOffscreenSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, Runnable {

    /* renamed from: d, reason: collision with root package name */
    private Thread f100519d;

    /* renamed from: e, reason: collision with root package name */
    private SurfaceHolder f100520e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f100521f;

    /* renamed from: h, reason: collision with root package name */
    private final Lock f100522h;

    /* renamed from: i, reason: collision with root package name */
    private final ArrayList<Bitmap> f100523i;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f100524m;

    public CEOffscreenSurfaceView(Context context) {
        super(context);
        this.f100519d = null;
        this.f100520e = null;
        this.f100521f = false;
        this.f100522h = new ReentrantLock();
        this.f100523i = new ArrayList<>();
        this.f100524m = null;
        SurfaceHolder holder = getHolder();
        this.f100520e = holder;
        holder.setFormat(-2);
        this.f100520e.addCallback(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        while (this.f100521f) {
            if (this.f100520e.getSurface().isValid() && !this.f100523i.isEmpty()) {
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.STROKE);
                Canvas lockCanvas = this.f100520e.lockCanvas();
                this.f100522h.lock();
                this.f100524m = this.f100523i.remove(0);
                Iterator<Bitmap> it = this.f100523i.iterator();
                while (it.hasNext()) {
                    Bitmap next = it.next();
                    if (next != null && !next.isRecycled()) {
                        next.recycle();
                    }
                    it.remove();
                }
                this.f100523i.clear();
                this.f100522h.unlock();
                if (this.f100524m != null) {
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                    lockCanvas.drawPaint(paint);
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
                    lockCanvas.drawBitmap(this.f100524m, 0.0f, 0.0f, paint);
                }
                this.f100520e.unlockCanvasAndPost(lockCanvas);
                Bitmap bitmap = this.f100524m;
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.f100524m.recycle();
                    this.f100524m = null;
                    System.gc();
                }
            }
        }
    }

    public void setRenderData(Bitmap bitmap) {
        this.f100522h.lock();
        this.f100523i.add(0, bitmap);
        this.f100522h.unlock();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
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
}
