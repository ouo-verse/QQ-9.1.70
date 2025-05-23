package com.tencent.component.media.animwebp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.GifRenderingExecutor;
import com.tencent.component.media.utils.ImageManagerLog;
import java.nio.ByteBuffer;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes5.dex */
public class WebpDrawable extends Drawable implements Runnable {
    private static final int DEFAULT_DELAY_MILLIS = 100;
    private static final int DEFAULT_INTRINSIC_HEIGHT = 480;
    private static final int DEFAULT_INTRINSIC_WIDTH = 270;
    private static final int DEFAULT_POLLING_TIME = 200;
    private static final String TAG = "AnimWebPDrawable";
    private Bitmap currentBitmap;
    private int delay;
    private AnimWebPInfo globalWebPInfo;
    private AnimWebPNative webPNative;
    private byte[] webpFileBytes;
    private String webpFilePath;
    private AtomicBoolean running = new AtomicBoolean(false);
    private Handler mainHandler = new Handler(Looper.getMainLooper());
    Runnable runnable = new Runnable() { // from class: com.tencent.component.media.animwebp.WebpDrawable.2
        @Override // java.lang.Runnable
        public void run() {
            WebpDrawable.this.invalidateSelf();
        }
    };
    private ScheduledThreadPoolExecutor mExecutor = GifRenderingExecutor.getInstance();

    public WebpDrawable(String str) {
        this.webpFilePath = str;
    }

    private void pause() {
        synchronized (this) {
            this.running.set(false);
        }
    }

    private void resume() {
        start();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Bitmap bitmap = this.currentBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas.drawBitmap(this.currentBitmap, 0.0f, 0.0f, (Paint) null);
            if (this.running.get()) {
                this.mExecutor.schedule(this, this.delay, TimeUnit.MILLISECONDS);
            }
        }
    }

    public void finalize() throws Throwable {
        try {
            stop();
        } finally {
            super.finalize();
        }
    }

    public Bitmap getCurrentBitmap() {
        return this.currentBitmap;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        AnimWebPInfo animWebPInfo = this.globalWebPInfo;
        if (animWebPInfo != null) {
            return animWebPInfo.getCanvasHeight();
        }
        return 480;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        AnimWebPInfo animWebPInfo = this.globalWebPInfo;
        if (animWebPInfo != null) {
            return animWebPInfo.getCanvasWidth();
        }
        return 270;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public boolean isRunning() {
        return this.running.get();
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            if (this.webPNative == null) {
                if (this.webpFileBytes == null) {
                    this.webpFileBytes = AnimWebPHelper.bytesFromFile(this.webpFilePath);
                }
                AnimWebPNative animWebPNative = new AnimWebPNative(this.webpFileBytes);
                this.webPNative = animWebPNative;
                AnimWebPInfo initialize = animWebPNative.initialize();
                this.globalWebPInfo = initialize;
                if (initialize == null) {
                    ImageManagerLog.e(TAG, "webp initialize error");
                    return;
                } else {
                    this.mainHandler.post(new Runnable() { // from class: com.tencent.component.media.animwebp.WebpDrawable.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WebpDrawable webpDrawable = WebpDrawable.this;
                            webpDrawable.setBounds(0, 0, webpDrawable.globalWebPInfo.getCanvasWidth(), WebpDrawable.this.globalWebPInfo.getCanvasHeight());
                        }
                    });
                    this.currentBitmap = Bitmap.createBitmap(this.globalWebPInfo.getCanvasWidth(), this.globalWebPInfo.getCanvasHeight(), Bitmap.Config.ARGB_8888);
                }
            }
            if (!ImageManagerEnv.g().shouldPlayAnimWebp() && this.running.get()) {
                this.mExecutor.schedule(this, 200L, TimeUnit.MILLISECONDS);
                return;
            }
            AnimWebPNative animWebPNative2 = this.webPNative;
            if (animWebPNative2 != null) {
                AnimWebPInfo nextFrame = animWebPNative2.nextFrame();
                if (nextFrame != null) {
                    ByteBuffer currentFrameByteBuffer = this.webPNative.getCurrentFrameByteBuffer();
                    currentFrameByteBuffer.position(0);
                    currentFrameByteBuffer.limit(nextFrame.getCanvasWidth() * nextFrame.getCanvasHeight() * 4);
                    this.currentBitmap.copyPixelsFromBuffer(currentFrameByteBuffer);
                    int durationMillis = nextFrame.getDurationMillis();
                    this.delay = durationMillis;
                    if (durationMillis == 0) {
                        this.delay = 100;
                    }
                    this.mainHandler.post(this.runnable);
                } else {
                    ImageManagerLog.e(TAG, "webp getNextFrame error");
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        if (z16) {
            start();
        } else {
            stop();
        }
        return super.setVisible(z16, z17);
    }

    public void start() {
        synchronized (this) {
            if (!this.running.get()) {
                this.mExecutor.schedule(this, 0L, TimeUnit.MILLISECONDS);
                this.running.set(true);
            }
        }
    }

    public void stop() {
        synchronized (this) {
            this.running.set(false);
            AnimWebPNative animWebPNative = this.webPNative;
            if (animWebPNative != null) {
                animWebPNative.release();
                this.webPNative = null;
            }
            Bitmap bitmap = this.currentBitmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.currentBitmap.recycle();
                this.currentBitmap = null;
            }
        }
    }

    public WebpDrawable(byte[] bArr) {
        this.webpFileBytes = bArr;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }
}
