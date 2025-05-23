package com.qzone.preview.photodanmaku.core;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.TextureView;
import com.qzone.preview.photodanmaku.config.PhotoDanmakuConfig;
import com.qzone.preview.photodanmaku.entity.AbsDanmaku;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.reborn.configx.g;
import java.lang.Thread;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import n8.d;

/* loaded from: classes39.dex */
public class PhotoDanmakuManager implements Thread.UncaughtExceptionHandler, Handler.Callback, TextureView.SurfaceTextureListener {
    private static final int CLEAR = 9;
    private static final int CLICK = 10;
    private static final int CONFIG_CHANGED = 7;
    private static final int PAUSE = 3;
    private static final int QUIT = 6;
    private static final int RELEASE = 8;
    private static final int RESUME = 2;
    private static final int SEEK_POS = 5;
    private static final int START = 1;
    private static final String TAG = "PhotoDanmakuManager";
    public static final int THREAD_OPTION_HIGH_PRIORITY = -8;
    public static final int THREAD_OPTION_LOW_PRIORITY = -2;
    public static final int THREAD_OPTION_NORMAL_PRIORITY = -4;
    private static final int UPDATE = 4;
    private long mBaseTime;
    private boolean mClearDrawingData;
    private final a mDanmakuComparator;
    private final n8.a mDanmakuImageFetcher;
    private final TextureView mDanmakuTextureView;
    private final n8.c mDrawCacheManager;
    private final Handler mDrawHandler;
    private volatile boolean mEnableDanmakuClick;
    private volatile boolean mIsPlaying;
    private volatile boolean mIsQuited;
    private volatile boolean mIsSurfaceCreated;
    private long mNow;
    private long mPausedTime;
    private final PhotoDanmakuDataSource mPhotoDanmakuDataSource;
    private final PhotoDanmakuFactory mPhotoDanmakuFactory;
    private final com.qzone.preview.photodanmaku.core.a mR2lWindow;
    private final com.qzone.preview.photodanmaku.entity.b mTimer;
    private int mTouchDistanceOfError;
    private final Queue<b> mTouchPoints = new LinkedBlockingDeque();
    private final List<AbsDanmaku> mToDeleteDanmakus = new LinkedList();

    /* loaded from: classes39.dex */
    public static final class a implements Comparator<AbsDanmaku> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(AbsDanmaku absDanmaku, AbsDanmaku absDanmaku2) {
            return n8.b.a(absDanmaku, absDanmaku2);
        }
    }

    /* loaded from: classes39.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final long f49956a;

        /* renamed from: b, reason: collision with root package name */
        public final Point f49957b;

        /* renamed from: c, reason: collision with root package name */
        public final int f49958c;

        public b(long j3, Point point, int i3) {
            this.f49956a = j3;
            this.f49957b = point;
            this.f49958c = i3;
        }

        public String toString() {
            return "TouchPoint{mTime=" + this.f49956a + ", mPoint=" + this.f49957b + ", distanceOfError=" + this.f49958c + '}';
        }
    }

    public PhotoDanmakuManager(Context context, TextureView textureView, int i3) {
        PhotoDanmakuConfig config = PhotoDanmakuConfig.getConfig(context, 1, i3);
        this.mDanmakuTextureView = textureView;
        textureView.setSurfaceTextureListener(this);
        com.qzone.preview.photodanmaku.entity.b bVar = new com.qzone.preview.photodanmaku.entity.b();
        this.mTimer = bVar;
        n8.c cVar = new n8.c(context);
        this.mDrawCacheManager = cVar;
        a aVar = new a();
        this.mDanmakuComparator = aVar;
        this.mPhotoDanmakuDataSource = new PhotoDanmakuDataSource(bVar, config, aVar);
        n8.a aVar2 = new n8.a();
        this.mDanmakuImageFetcher = aVar2;
        this.mR2lWindow = com.qzone.preview.photodanmaku.core.a.h(context, aVar2, cVar, config, aVar, 1);
        this.mPhotoDanmakuFactory = new PhotoDanmakuFactory(context, bVar, i3);
        this.mDrawHandler = new Handler(Looper.getMainLooper(), this);
    }

    private void draw() {
        String th5;
        if (this.mClearDrawingData) {
            this.mR2lWindow.c();
            this.mClearDrawingData = false;
        }
        this.mPhotoDanmakuDataSource.update();
        List<AbsDanmaku> drawingDanmakuList = this.mPhotoDanmakuDataSource.getDrawingDanmakuList();
        try {
            Canvas lockCanvas = this.mDanmakuTextureView.lockCanvas();
            d.a(lockCanvas);
            if (lockCanvas != null) {
                try {
                    this.mR2lWindow.k(lockCanvas);
                    Iterator<AbsDanmaku> it = drawingDanmakuList.iterator();
                    while (it.hasNext()) {
                        AbsDanmaku next = it.next();
                        it.remove();
                        while (next.isTimeOut()) {
                            next.setTime(time() + 800);
                        }
                        if (next.getType() == 1) {
                            if (!next.isMeasured()) {
                                next.onMeasure(this.mR2lWindow.e());
                            }
                            this.mR2lWindow.a(next);
                        }
                    }
                    this.mR2lWindow.g();
                    this.mR2lWindow.i();
                    this.mR2lWindow.d();
                    this.mToDeleteDanmakus.addAll(this.mR2lWindow.f());
                    this.mR2lWindow.b();
                    this.mToDeleteDanmakus.clear();
                    if (this.mIsSurfaceCreated) {
                        try {
                            this.mDanmakuTextureView.unlockCanvasAndPost(lockCanvas);
                        } catch (Throwable th6) {
                            th = th6;
                            th5 = th.toString();
                            j.d(TAG, th5, th);
                        }
                    }
                } catch (Throwable th7) {
                    try {
                        j.c(TAG, "PhotoDanmakuManager - draw() get an Error:" + th7.toString());
                        if (this.mIsSurfaceCreated) {
                            try {
                                this.mDanmakuTextureView.unlockCanvasAndPost(lockCanvas);
                            } catch (Throwable th8) {
                                th = th8;
                                th5 = th.toString();
                                j.d(TAG, th5, th);
                            }
                        }
                    } finally {
                    }
                }
            }
        } catch (Throwable th9) {
            j.d(TAG, th9.toString(), th9);
        }
    }

    private void handelUpdate() {
        removeUpdateMessage();
        this.mNow = now();
        if (isPrepared() && !this.mIsQuited) {
            this.mTimer.c(this.mNow);
            draw();
            sendMessageDelayed(4, 8L);
            return;
        }
        sendMessageDelayed(4, 100L);
    }

    private void handleClear() {
        this.mR2lWindow.c();
        this.mPhotoDanmakuDataSource.clear();
    }

    private void handleConfigChanged() {
        this.mR2lWindow.j();
    }

    private void handlePause() {
        removeUpdateMessage();
        this.mIsPlaying = false;
        this.mPausedTime = this.mTimer.a();
    }

    private void handleSeek(Message message) {
        Object obj = message.obj;
        if (obj != null) {
            this.mPausedTime = ((Long) obj).longValue();
            this.mClearDrawingData = true;
            handleResume();
        }
    }

    private void removeUpdateMessage() {
        this.mDrawHandler.removeMessages(4);
    }

    private void resumeUpdateMessage() {
        if (isPlaying()) {
            sendEmptyMeesage(4);
        }
    }

    private void sendEmptyMeesage(int i3) {
        this.mDrawHandler.sendEmptyMessage(i3);
    }

    private void sendMeesage(Message message) {
        this.mDrawHandler.sendMessage(message);
    }

    private void sendMessageDelayed(int i3, long j3) {
        this.mDrawHandler.sendEmptyMessageDelayed(i3, j3);
    }

    public void addClickPoint(Point point, int i3) {
        this.mTouchPoints.add(new b(now(), point, i3));
        Message obtain = Message.obtain();
        obtain.what = 10;
        sendMeesage(obtain);
    }

    public void clear() {
        Message obtain = Message.obtain();
        obtain.what = 9;
        sendMeesage(obtain);
    }

    public PhotoDanmakuDataSource getDanmakuDataSource() {
        return this.mPhotoDanmakuDataSource;
    }

    public PhotoDanmakuFactory getDanmakuFactory() {
        return this.mPhotoDanmakuFactory;
    }

    public com.qzone.preview.photodanmaku.core.a getR2lWindow() {
        return this.mR2lWindow;
    }

    public int getTouchDistanceOfError() {
        return this.mTouchDistanceOfError;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0002. Please report as an issue. */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                handleStart(message);
            case 2:
                handleResume();
                return false;
            case 3:
                handlePause();
                return false;
            case 4:
                handelUpdate();
                return false;
            case 5:
                handleSeek(message);
                return false;
            case 6:
                handleQuit();
                return false;
            case 7:
                handleConfigChanged();
                return false;
            case 8:
                handleRelease();
                return false;
            case 9:
                handleClear();
                return false;
            case 10:
                handleClick();
                return false;
            default:
                return false;
        }
    }

    public boolean isPlaying() {
        return !this.mIsQuited && this.mIsPlaying;
    }

    public boolean isPrepared() {
        return this.mIsSurfaceCreated && !this.mIsQuited && this.mIsPlaying;
    }

    public boolean isStarted() {
        return !this.mIsQuited;
    }

    public void notifyConfigChanged() {
        Message obtain = Message.obtain();
        obtain.what = 7;
        sendMeesage(obtain);
    }

    public long now() {
        return timeLine() - this.mBaseTime;
    }

    public void onDestroy() {
        com.qzone.preview.photodanmaku.core.a aVar = this.mR2lWindow;
        if (aVar == null || aVar.e() == null) {
            return;
        }
        this.mR2lWindow.e().z();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        Canvas lockCanvas = this.mDanmakuTextureView.lockCanvas();
        if (lockCanvas != null) {
            d.a(lockCanvas);
        }
        this.mDanmakuTextureView.unlockCanvasAndPost(lockCanvas);
        this.mIsSurfaceCreated = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        resumeUpdateMessage();
    }

    public void pause() {
        Message obtain = Message.obtain();
        obtain.what = 3;
        sendMeesage(obtain);
    }

    public void release() {
        if (!this.mIsQuited) {
            quit();
        }
        Message obtain = Message.obtain();
        obtain.what = 8;
        sendMeesage(obtain);
    }

    public void resume() {
        Message obtain = Message.obtain();
        obtain.what = 2;
        sendMeesage(obtain);
    }

    public void seek(long j3) {
        Message obtain = Message.obtain();
        obtain.what = 5;
        obtain.obj = Long.valueOf(j3);
        sendMeesage(obtain);
    }

    public void setDanmakuClickEnable(boolean z16) {
        this.mEnableDanmakuClick = z16;
    }

    public void setTouchDistanceOfError(int i3) {
        this.mTouchDistanceOfError = i3;
    }

    public void start() {
        start(0L);
    }

    public long time() {
        return this.mTimer.a();
    }

    public long timeLine() {
        return System.currentTimeMillis();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th5) {
        j.d(TAG, "photoDanmaku crash thread:" + thread, th5);
    }

    private void handleQuit() {
        this.mIsQuited = true;
        this.mPhotoDanmakuDataSource.clear();
        this.mDrawCacheManager.a();
    }

    private void handleResume() {
        this.mIsPlaying = true;
        this.mBaseTime = timeLine() - this.mPausedTime;
        resumeUpdateMessage();
    }

    private void handleStart(Message message) {
        this.mIsQuited = false;
        this.mClearDrawingData = true;
        Object obj = message.obj;
        if (obj != null) {
            this.mPausedTime = ((Long) obj).longValue();
        } else {
            this.mPausedTime = 0L;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.mIsSurfaceCreated = false;
        removeUpdateMessage();
        return g.f53821a.b().t0();
    }

    public void quit() {
        this.mIsQuited = true;
        Message obtain = Message.obtain();
        obtain.what = 6;
        sendMeesage(obtain);
    }

    public void start(long j3) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = Long.valueOf(j3);
        sendMeesage(obtain);
    }

    private void handleClick() {
    }

    private void handleRelease() {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
