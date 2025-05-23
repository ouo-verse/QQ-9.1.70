package cooperation.qzone.zipanimate;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.webkit.URLUtil;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.zipanimate.life.PageLifeCycle;
import cooperation.qzone.zipanimate.life.PageLiveCycleProxy;

/* compiled from: P */
/* loaded from: classes38.dex */
public class ZipAnimationDrawable extends Drawable implements Animatable, PageLifeCycle {
    static final int MSG_LOAD_NEXT_FRAME = 1000;
    private static final String TAG = "zip_drawable";
    private OnDrawableCallBack drawCallback;
    private ZipAnimationState mAnimationState;
    private boolean mIsPagePause;
    private boolean mIsShowFirstFrame;
    private Lifecycle mLifecycle;
    OnAnimationListener mListener;
    private boolean mRepeatAnimation;
    private volatile boolean mRunning;
    private float mScale;
    private boolean mShowLastFrameWhenStop;
    long startTime;
    Handler uiHandler;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public final class ZipAnimationState extends Drawable.ConstantState {
        boolean aniResLoaded;
        String aniResUrl;
        ZipDrawableLoader animationResLoader;
        ZipLoadedListener animationResLoaderListener;
        int frameRate = 30;
        private boolean mOneShot = false;

        ZipAnimationState() {
        }

        public int getAnimationDuration() {
            return (getChildCount() * 1000) / this.frameRate;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public int getChildCount() {
            ZipDrawableLoader zipDrawableLoader = this.animationResLoader;
            if (zipDrawableLoader == null) {
                return 0;
            }
            return zipDrawableLoader.getFrameCount();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new ZipAnimationDrawable(this);
        }

        public void onBoundsChange(Rect rect) {
            this.animationResLoader.onBoundsChange(rect);
        }

        public void setAnimationRes(String str, int i3) {
            String str2;
            String str3 = this.aniResUrl;
            if (str3 != null && !str3.equals(str)) {
                this.aniResLoaded = false;
            }
            ZipDrawableLoader zipDrawableLoader = this.animationResLoader;
            if (zipDrawableLoader == null) {
                this.animationResLoader = new ZipDrawableLoader(BaseApplicationImpl.getApplication());
            } else if (!this.aniResLoaded) {
                zipDrawableLoader.release();
            }
            if (this.animationResLoaderListener == null) {
                this.animationResLoaderListener = new ZipLoadedListener() { // from class: cooperation.qzone.zipanimate.ZipAnimationDrawable.ZipAnimationState.1
                    @Override // cooperation.qzone.zipanimate.ZipLoadedListener
                    public void onZipLoaded(boolean z16) {
                        ZipAnimationState zipAnimationState = ZipAnimationState.this;
                        if (zipAnimationState.aniResLoaded) {
                            return;
                        }
                        zipAnimationState.aniResLoaded = z16;
                        ZipAnimationDrawable.this.uiHandler.post(new Runnable() { // from class: cooperation.qzone.zipanimate.ZipAnimationDrawable.ZipAnimationState.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                OnAnimationListener onAnimationListener = ZipAnimationDrawable.this.mListener;
                                if (onAnimationListener != null) {
                                    onAnimationListener.onDrawableLoaded();
                                }
                                if (ZipAnimationDrawable.this.mRunning) {
                                    ZipAnimationDrawable.this.restartAnimation();
                                }
                            }
                        });
                    }
                };
            }
            this.animationResLoader.setZipLoadedListener(this.animationResLoaderListener);
            if (!this.aniResLoaded || (str2 = this.aniResUrl) == null || !str2.equals(str)) {
                if (URLUtil.isNetworkUrl(str)) {
                    this.animationResLoader.setDrawableData(str, -1, true);
                } else {
                    this.animationResLoader.loadLocalZipData(str, true);
                }
            }
            if (i3 > 0) {
                this.frameRate = i3;
            }
            this.aniResUrl = str;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new ZipAnimationDrawable(this);
        }

        public void loadAndShowFirstFrame() {
        }
    }

    public ZipAnimationDrawable() {
        this.mScale = 1.0f;
        this.mShowLastFrameWhenStop = false;
        this.mRepeatAnimation = false;
        this.mIsShowFirstFrame = false;
        this.mIsPagePause = false;
        this.drawCallback = new OnDrawableCallBack() { // from class: cooperation.qzone.zipanimate.ZipAnimationDrawable.1
            @Override // cooperation.qzone.zipanimate.OnDrawableCallBack
            public Drawable.Callback getDrawableCallBack() {
                return ZipAnimationDrawable.this.getCallback();
            }
        };
        this.uiHandler = new Handler(Looper.getMainLooper()) { // from class: cooperation.qzone.zipanimate.ZipAnimationDrawable.3
            /* JADX WARN: Code restructure failed: missing block: B:34:0x0088, code lost:
            
                if (r6 >= r5.this$0.mAnimationState.animationResLoader.getFrameCount()) goto L27;
             */
            @Override // android.os.Handler
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void handleMessage(Message message) {
                if (ZipAnimationDrawable.this.drawCallback.getDrawableCallBack() != null && message.what == 1000 && ZipAnimationDrawable.this.mAnimationState.aniResLoaded && ZipAnimationDrawable.this.mRunning) {
                    int uptimeMillis = (int) (((float) (SystemClock.uptimeMillis() - ZipAnimationDrawable.this.startTime)) / (1000.0f / r6.mAnimationState.frameRate));
                    boolean z16 = true;
                    if (ZipAnimationDrawable.this.mAnimationState.animationResLoader.getFrameCount() != 1 || !ZipAnimationDrawable.this.isZipDrawableShow()) {
                        if (ZipAnimationDrawable.this.mRepeatAnimation && ZipAnimationDrawable.this.mAnimationState.animationResLoader.getFrameCount() != 0) {
                            uptimeMillis %= ZipAnimationDrawable.this.mAnimationState.animationResLoader.getFrameCount();
                        }
                        z16 = false;
                    }
                    ZipAnimationDrawable.this.mAnimationState.animationResLoader.setFrame(uptimeMillis);
                    if (!z16) {
                        ZipAnimationDrawable.this.uiHandler.sendEmptyMessageDelayed(1000, 1000 / ZipAnimationDrawable.this.mAnimationState.frameRate);
                        ZipAnimationDrawable.this.invalidateSelf();
                    } else {
                        ZipAnimationDrawable.this.stop();
                        ZipAnimationDrawable.this.invalidateSelf();
                        OnAnimationListener onAnimationListener = ZipAnimationDrawable.this.mListener;
                        if (onAnimationListener != null) {
                            onAnimationListener.onAnimationFinished();
                        }
                    }
                }
            }
        };
        this.mAnimationState = new ZipAnimationState();
    }

    @Deprecated
    public void clearFirstFrame() {
        ZipDrawableLoader zipDrawableLoader;
        ZipAnimationState zipAnimationState = this.mAnimationState;
        if (zipAnimationState == null || (zipDrawableLoader = zipAnimationState.animationResLoader) == null) {
            return;
        }
        zipDrawableLoader.release();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        BitmapDrawable currentDrawable;
        Bitmap bitmap;
        if (this.mRunning || this.mShowLastFrameWhenStop || this.mIsShowFirstFrame) {
            ZipAnimationState zipAnimationState = this.mAnimationState;
            if (!zipAnimationState.aniResLoaded || (currentDrawable = zipAnimationState.animationResLoader.getCurrentDrawable()) == null || (bitmap = currentDrawable.getBitmap()) == null || bitmap.isRecycled()) {
                return;
            }
            currentDrawable.setBounds(getBounds());
            currentDrawable.draw(canvas);
        }
    }

    public String getAnimationResZipUrl() {
        return this.mAnimationState.aniResUrl;
    }

    public int getDuration() {
        return this.mAnimationState.getAnimationDuration();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        BitmapDrawable currentDrawable;
        ZipDrawableLoader zipDrawableLoader = this.mAnimationState.animationResLoader;
        if (zipDrawableLoader == null || (currentDrawable = zipDrawableLoader.getCurrentDrawable()) == null) {
            return -1;
        }
        return (int) (currentDrawable.getIntrinsicHeight() * this.mScale);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        BitmapDrawable currentDrawable;
        ZipDrawableLoader zipDrawableLoader = this.mAnimationState.animationResLoader;
        if (zipDrawableLoader == null || (currentDrawable = zipDrawableLoader.getCurrentDrawable()) == null) {
            return -1;
        }
        return (int) (currentDrawable.getIntrinsicWidth() * this.mScale);
    }

    public int getNumberOfFrames() {
        return this.mAnimationState.getChildCount();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    public boolean hasDownloadComplete() {
        ZipAnimationState zipAnimationState = this.mAnimationState;
        return zipAnimationState != null && zipAnimationState.aniResLoaded;
    }

    public boolean isOneShot() {
        return this.mAnimationState.mOneShot;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mRunning;
    }

    public boolean isZipDrawableShow() {
        ZipDrawableLoader zipDrawableLoader;
        ZipAnimationState zipAnimationState = this.mAnimationState;
        return (zipAnimationState == null || (zipDrawableLoader = zipAnimationState.animationResLoader) == null || zipDrawableLoader.getCurrentDrawable() == null) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.mAnimationState.onBoundsChange(rect);
        super.onBoundsChange(rect);
    }

    @Override // cooperation.qzone.zipanimate.life.PageLifeCycle
    public void onPageDestroy(LifecycleOwner lifecycleOwner) {
        stop();
        release();
    }

    @Override // cooperation.qzone.zipanimate.life.PageLifeCycle
    public void onPageStop(LifecycleOwner lifecycleOwner) {
        stop();
    }

    public void preLoadFrame(int i3) {
        ZipDrawableLoader zipDrawableLoader;
        ZipAnimationState zipAnimationState = this.mAnimationState;
        if (zipAnimationState == null || (zipDrawableLoader = zipAnimationState.animationResLoader) == null) {
            return;
        }
        zipDrawableLoader.loadFrame(i3, null);
    }

    public void release() {
        ZipDrawableLoader zipDrawableLoader;
        ZipAnimationState zipAnimationState = this.mAnimationState;
        if (zipAnimationState == null || (zipDrawableLoader = zipAnimationState.animationResLoader) == null) {
            return;
        }
        zipDrawableLoader.release();
    }

    public void restartAnimation() {
        if (this.mIsPagePause) {
            QLog.e("zip_drawable", 1, "restartAnimation stop , page is pause" + hashCode());
            return;
        }
        this.mRunning = true;
        if (this.mAnimationState.aniResLoaded) {
            PageLiveCycleProxy.addPageLifeCycle(this);
            this.mAnimationState.animationResLoader.loadFrame(0, null);
            this.mRunning = true;
            this.startTime = SystemClock.uptimeMillis();
            this.uiHandler.removeMessages(1000);
            this.uiHandler.sendEmptyMessageDelayed(1000, 1000 / this.mAnimationState.frameRate);
        }
    }

    public void setAnimationListener(OnAnimationListener onAnimationListener) {
        this.mListener = onAnimationListener;
    }

    public void setAnimationRes(String str, int i3) {
        this.mAnimationState.setAnimationRes(str, i3);
    }

    public void setDrawableCallback(OnDrawableCallBack onDrawableCallBack) {
        this.drawCallback = onDrawableCallBack;
    }

    public void setDrawableLoadedListener(ZipFrameLoadedListener zipFrameLoadedListener) {
        ZipDrawableLoader zipDrawableLoader = this.mAnimationState.animationResLoader;
        if (zipDrawableLoader != null) {
            zipDrawableLoader.setDrawableLoadedListener(zipFrameLoadedListener);
        }
    }

    public void setIsShowFirstFrame(boolean z16) {
        this.mIsShowFirstFrame = z16;
    }

    public void setOneShot(boolean z16) {
        this.mAnimationState.mOneShot = z16;
    }

    public void setPreloadNum(int i3) {
        ZipDrawableLoader zipDrawableLoader;
        ZipAnimationState zipAnimationState = this.mAnimationState;
        if (zipAnimationState == null || (zipDrawableLoader = zipAnimationState.animationResLoader) == null) {
            return;
        }
        zipDrawableLoader.setPreloadNum(i3);
    }

    public void setRepeatAnimation(boolean z16) {
        this.mRepeatAnimation = z16;
    }

    public void setScale(float f16) {
        this.mScale = f16;
        ZipDrawableLoader zipDrawableLoader = this.mAnimationState.animationResLoader;
        if (zipDrawableLoader != null) {
            zipDrawableLoader.setScale(f16);
        }
    }

    public void setShowLastFrameWhenStop(boolean z16) {
        this.mShowLastFrameWhenStop = z16;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        if (isVisible() != z16) {
            if (z16) {
                if (this.mRunning) {
                    this.uiHandler.sendEmptyMessage(1000);
                }
            } else {
                this.uiHandler.removeMessages(1000);
            }
        }
        return super.setVisible(z16, z17);
    }

    public void setZipFirstFrameLoadedListener(ZipFirstFrameLoadedListener zipFirstFrameLoadedListener) {
        ZipDrawableLoader zipDrawableLoader = this.mAnimationState.animationResLoader;
        if (zipDrawableLoader != null) {
            zipDrawableLoader.setZipFirstFrameLoadedListener(zipFirstFrameLoadedListener);
        }
    }

    public void showFirstFrame() {
        this.mAnimationState.animationResLoader.selectFrame(0);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.mIsPagePause) {
            QLog.e("zip_drawable", 1, "start stop , page is pause" + hashCode());
            return;
        }
        this.mRunning = true;
        if (this.mAnimationState.aniResLoaded) {
            restartAnimation();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (QZLog.isColorLevel()) {
            QZLog.i("zip_drawable", 2, "stop " + hashCode());
        }
        this.uiHandler.removeMessages(1000);
        this.mRunning = false;
    }

    public void loadAndShowFirstFrame() {
        this.mIsShowFirstFrame = true;
        this.mAnimationState.animationResLoader.setDrawableLoadedListener(new ZipFrameLoadedListener() { // from class: cooperation.qzone.zipanimate.ZipAnimationDrawable.2
            @Override // cooperation.qzone.zipanimate.ZipFrameLoadedListener
            public void onLoaded(int i3, Drawable drawable) {
                if (i3 == 0) {
                    ZipAnimationDrawable.this.mAnimationState.animationResLoader.selectFrame(0);
                    ZipAnimationDrawable.this.uiHandler.post(new Runnable() { // from class: cooperation.qzone.zipanimate.ZipAnimationDrawable.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ZipAnimationDrawable.this.invalidateSelf();
                        }
                    });
                }
            }
        });
    }

    @Override // cooperation.qzone.zipanimate.life.PageLifeCycle
    public void onPagePause(LifecycleOwner lifecycleOwner) {
        this.mIsPagePause = true;
        stop();
    }

    @Override // cooperation.qzone.zipanimate.life.PageLifeCycle
    public void onPageResume(LifecycleOwner lifecycleOwner) {
        this.mIsPagePause = false;
        restartAnimation();
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        this.mRunning = false;
        super.unscheduleSelf(runnable);
    }

    public ZipAnimationDrawable(String str, int i3) {
        this.mScale = 1.0f;
        this.mShowLastFrameWhenStop = false;
        this.mRepeatAnimation = false;
        this.mIsShowFirstFrame = false;
        this.mIsPagePause = false;
        this.drawCallback = new OnDrawableCallBack() { // from class: cooperation.qzone.zipanimate.ZipAnimationDrawable.1
            @Override // cooperation.qzone.zipanimate.OnDrawableCallBack
            public Drawable.Callback getDrawableCallBack() {
                return ZipAnimationDrawable.this.getCallback();
            }
        };
        this.uiHandler = new Handler(Looper.getMainLooper()) { // from class: cooperation.qzone.zipanimate.ZipAnimationDrawable.3
            /* JADX WARN: Code restructure failed: missing block: B:34:0x0088, code lost:
            
                if (r6 >= r5.this$0.mAnimationState.animationResLoader.getFrameCount()) goto L27;
             */
            @Override // android.os.Handler
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void handleMessage(Message message) {
                if (ZipAnimationDrawable.this.drawCallback.getDrawableCallBack() != null && message.what == 1000 && ZipAnimationDrawable.this.mAnimationState.aniResLoaded && ZipAnimationDrawable.this.mRunning) {
                    int uptimeMillis = (int) (((float) (SystemClock.uptimeMillis() - ZipAnimationDrawable.this.startTime)) / (1000.0f / r6.mAnimationState.frameRate));
                    boolean z16 = true;
                    if (ZipAnimationDrawable.this.mAnimationState.animationResLoader.getFrameCount() != 1 || !ZipAnimationDrawable.this.isZipDrawableShow()) {
                        if (ZipAnimationDrawable.this.mRepeatAnimation && ZipAnimationDrawable.this.mAnimationState.animationResLoader.getFrameCount() != 0) {
                            uptimeMillis %= ZipAnimationDrawable.this.mAnimationState.animationResLoader.getFrameCount();
                        }
                        z16 = false;
                    }
                    ZipAnimationDrawable.this.mAnimationState.animationResLoader.setFrame(uptimeMillis);
                    if (!z16) {
                        ZipAnimationDrawable.this.uiHandler.sendEmptyMessageDelayed(1000, 1000 / ZipAnimationDrawable.this.mAnimationState.frameRate);
                        ZipAnimationDrawable.this.invalidateSelf();
                    } else {
                        ZipAnimationDrawable.this.stop();
                        ZipAnimationDrawable.this.invalidateSelf();
                        OnAnimationListener onAnimationListener = ZipAnimationDrawable.this.mListener;
                        if (onAnimationListener != null) {
                            onAnimationListener.onAnimationFinished();
                        }
                    }
                }
            }
        };
        this.mAnimationState = new ZipAnimationState();
        setAnimationRes(str, i3);
    }

    public ZipAnimationDrawable(ZipAnimationState zipAnimationState) {
        this.mScale = 1.0f;
        this.mShowLastFrameWhenStop = false;
        this.mRepeatAnimation = false;
        this.mIsShowFirstFrame = false;
        this.mIsPagePause = false;
        this.drawCallback = new OnDrawableCallBack() { // from class: cooperation.qzone.zipanimate.ZipAnimationDrawable.1
            @Override // cooperation.qzone.zipanimate.OnDrawableCallBack
            public Drawable.Callback getDrawableCallBack() {
                return ZipAnimationDrawable.this.getCallback();
            }
        };
        this.uiHandler = new Handler(Looper.getMainLooper()) { // from class: cooperation.qzone.zipanimate.ZipAnimationDrawable.3
            /* JADX WARN: Code restructure failed: missing block: B:34:0x0088, code lost:
            
                if (r6 >= r5.this$0.mAnimationState.animationResLoader.getFrameCount()) goto L27;
             */
            @Override // android.os.Handler
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void handleMessage(Message message) {
                if (ZipAnimationDrawable.this.drawCallback.getDrawableCallBack() != null && message.what == 1000 && ZipAnimationDrawable.this.mAnimationState.aniResLoaded && ZipAnimationDrawable.this.mRunning) {
                    int uptimeMillis = (int) (((float) (SystemClock.uptimeMillis() - ZipAnimationDrawable.this.startTime)) / (1000.0f / r6.mAnimationState.frameRate));
                    boolean z16 = true;
                    if (ZipAnimationDrawable.this.mAnimationState.animationResLoader.getFrameCount() != 1 || !ZipAnimationDrawable.this.isZipDrawableShow()) {
                        if (ZipAnimationDrawable.this.mRepeatAnimation && ZipAnimationDrawable.this.mAnimationState.animationResLoader.getFrameCount() != 0) {
                            uptimeMillis %= ZipAnimationDrawable.this.mAnimationState.animationResLoader.getFrameCount();
                        }
                        z16 = false;
                    }
                    ZipAnimationDrawable.this.mAnimationState.animationResLoader.setFrame(uptimeMillis);
                    if (!z16) {
                        ZipAnimationDrawable.this.uiHandler.sendEmptyMessageDelayed(1000, 1000 / ZipAnimationDrawable.this.mAnimationState.frameRate);
                        ZipAnimationDrawable.this.invalidateSelf();
                    } else {
                        ZipAnimationDrawable.this.stop();
                        ZipAnimationDrawable.this.invalidateSelf();
                        OnAnimationListener onAnimationListener = ZipAnimationDrawable.this.mListener;
                        if (onAnimationListener != null) {
                            onAnimationListener.onAnimationFinished();
                        }
                    }
                }
            }
        };
        this.mAnimationState = zipAnimationState;
    }

    public void bindLifeCycle(Lifecycle lifecycle) {
    }

    @Override // cooperation.qzone.zipanimate.life.PageLifeCycle
    public void onPageCreate(LifecycleOwner lifecycleOwner) {
    }

    @Override // cooperation.qzone.zipanimate.life.PageLifeCycle
    public void onPageStart(LifecycleOwner lifecycleOwner) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // cooperation.qzone.zipanimate.life.PageLifeCycle
    public void onLifecycleChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
    }
}
