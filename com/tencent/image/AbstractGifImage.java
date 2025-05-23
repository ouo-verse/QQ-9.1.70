package com.tencent.image;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class AbstractGifImage {
    static IPatchRedirector $redirector_ = null;
    public static final int DENSITY_NONE = 0;
    public static final String KEY_REFRESH_DELAY = "gif_refresh_delay";
    private static final int PENDING_ACTION_CAPACITY = 100;
    protected static ArgumentsRunnable<WeakReference<AbstractGifImage>> sAccumulativeRunnable;
    protected static boolean sPaused;
    protected static final ArrayList<WeakReference<AbstractGifImage>> sPendingActions;
    protected static Handler sUIThreadHandler;
    public float mDefaultRoundCorner;
    protected int mDensity;
    protected Vector<WeakReference<GifDrawable>> mDrawableList;
    protected boolean mIsInPendingAction;
    protected long mLastRefreshTime;
    protected WeakReference<GifDrawable.OnGIFPlayOnceListener> mPlayOnceListener;
    public int mRefreshDelay;
    protected GifDrawable.OnGIFPlayOnceListener mStrongPlayOnceListener;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class DoAccumulativeRunnable extends ArgumentsRunnable<WeakReference<AbstractGifImage>> {
        static IPatchRedirector $redirector_;
        public static int DELAY;
        private long lastRefreshTime;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7999);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                DELAY = 100;
            }
        }

        public DoAccumulativeRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.lastRefreshTime = 0L;
            }
        }

        @Override // com.tencent.image.ArgumentsRunnable
        protected void run(List<WeakReference<AbstractGifImage>> list) {
            AbstractGifImage abstractGifImage;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                return;
            }
            for (WeakReference<AbstractGifImage> weakReference : list) {
                if (weakReference != null && (abstractGifImage = weakReference.get()) != null) {
                    abstractGifImage.doApplyNextFrame();
                }
            }
            this.lastRefreshTime = SystemClock.uptimeMillis();
        }

        @Override // com.tencent.image.ArgumentsRunnable
        protected void submit() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            if (NativeGifImage.QZONE_DELAY == -1) {
                long j3 = this.lastRefreshTime;
                if (j3 != 0 && uptimeMillis - j3 <= DELAY) {
                    AbstractGifImage.sUIThreadHandler.postDelayed(this, DELAY - (uptimeMillis - j3));
                    return;
                } else {
                    run();
                    this.lastRefreshTime = uptimeMillis;
                    return;
                }
            }
            run();
            this.lastRefreshTime = uptimeMillis;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class ItemRefreshRunnable implements Runnable {
        static IPatchRedirector $redirector_;
        private WeakReference<AbstractGifImage> imageWeakReference;

        public ItemRefreshRunnable(AbstractGifImage abstractGifImage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractGifImage);
            } else {
                this.imageWeakReference = null;
                this.imageWeakReference = new WeakReference<>(abstractGifImage);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AbstractGifImage abstractGifImage = this.imageWeakReference.get();
            if (abstractGifImage != null) {
                abstractGifImage.doApplyNextFrame();
                abstractGifImage.mLastRefreshTime = SystemClock.uptimeMillis();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(MessageHandlerConstants.NOTIFY_TYPE_DELETE_SYSTEM_MSG);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            sPaused = false;
            sPendingActions = new ArrayList<WeakReference<AbstractGifImage>>(105) { // from class: com.tencent.image.AbstractGifImage.1
                static IPatchRedirector $redirector_;

                {
                    super(r4);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, r4);
                    }
                }

                private void ensureCapacity() {
                    if (size() > 100) {
                        removeRange(0, (r0 - 100) - 1);
                    }
                }

                @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
                public boolean add(WeakReference<AbstractGifImage> weakReference) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) weakReference)).booleanValue();
                    }
                    boolean add = super.add((AnonymousClass1) weakReference);
                    ensureCapacity();
                    return add;
                }
            };
        }
    }

    public AbstractGifImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mDensity = 160;
        this.mIsInPendingAction = false;
        this.mDefaultRoundCorner = 0.0f;
        this.mRefreshDelay = -1;
        this.mLastRefreshTime = 0L;
        this.mDrawableList = new Vector<>();
    }

    public static final void pauseAll() {
        sPaused = true;
    }

    public static final void resumeAll() {
        sPaused = false;
        for (int size = sPendingActions.size() - 1; size >= 0; size--) {
            AbstractGifImage abstractGifImage = sPendingActions.get(size).get();
            if (abstractGifImage != null) {
                abstractGifImage.reDraw();
            }
        }
        sPendingActions.clear();
    }

    private static int scaleFromDensity(int i3, int i16, int i17) {
        if (i16 != 0 && i16 != i17) {
            return ((i3 * i17) + (i16 >> 1)) / i16;
        }
        return i3;
    }

    protected abstract void applyNextFrame();

    public void attachDrawable(GifDrawable gifDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) gifDrawable);
        } else if (gifDrawable != null) {
            synchronized (this.mDrawableList) {
                if (!this.mDrawableList.contains(gifDrawable)) {
                    this.mDrawableList.add(new WeakReference<>(gifDrawable));
                }
            }
        }
    }

    public void detachDrawable(GifDrawable gifDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) gifDrawable);
            return;
        }
        if (gifDrawable != null) {
            synchronized (this.mDrawableList) {
                int i3 = 0;
                while (i3 < this.mDrawableList.size()) {
                    WeakReference<GifDrawable> weakReference = this.mDrawableList.get(i3);
                    if (weakReference != null && weakReference.get() != null) {
                        if (weakReference.get() == gifDrawable) {
                            this.mDrawableList.remove(i3);
                            return;
                        }
                        i3++;
                    }
                    this.mDrawableList.remove(i3);
                    i3--;
                    i3++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doApplyNextFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        applyNextFrame();
        if (!sPaused) {
            invalidateSelf();
        } else if (!this.mIsInPendingAction) {
            sPendingActions.add(new WeakReference<>(this));
            this.mIsInPendingAction = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doApplyNextFrameItemRefresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        long j3 = this.mLastRefreshTime;
        if (j3 != 0 && uptimeMillis - j3 <= this.mRefreshDelay) {
            sUIThreadHandler.postDelayed(new ItemRefreshRunnable(this), this.mRefreshDelay - (uptimeMillis - this.mLastRefreshTime));
        } else {
            doApplyNextFrame();
            this.mLastRefreshTime = uptimeMillis;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void draw(Canvas canvas, Rect rect, Paint paint, boolean z16);

    protected abstract void executeNewTask();

    public abstract int getByteSize();

    public abstract int getHeight();

    public int getScaledHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, i3)).intValue();
        }
        return scaleFromDensity(getHeight(), this.mDensity, i3);
    }

    public int getScaledWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, i3)).intValue();
        }
        return scaleFromDensity(getWidth(), this.mDensity, i3);
    }

    public abstract int getWidth();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void initHandlerAndRunnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (sUIThreadHandler == null) {
            sUIThreadHandler = new Handler(Looper.getMainLooper());
            sAccumulativeRunnable = new DoAccumulativeRunnable();
        }
    }

    protected void invalidateSelf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        synchronized (this.mDrawableList) {
            int i3 = 0;
            while (i3 < this.mDrawableList.size()) {
                WeakReference<GifDrawable> weakReference = this.mDrawableList.get(i3);
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().invalidateSelf();
                    i3++;
                }
                this.mDrawableList.remove(i3);
                i3--;
                i3++;
            }
        }
    }

    protected void reDraw() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            invalidateSelf();
            this.mIsInPendingAction = false;
        }
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    public void setDensity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.mDensity = i3;
        }
    }

    public void setGIFPlayOnceListener(GifDrawable.OnGIFPlayOnceListener onGIFPlayOnceListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) onGIFPlayOnceListener);
        } else {
            this.mPlayOnceListener = new WeakReference<>(onGIFPlayOnceListener);
        }
    }

    public void setStrongGIFPlayOnceListener(GifDrawable.OnGIFPlayOnceListener onGIFPlayOnceListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) onGIFPlayOnceListener);
        } else {
            this.mStrongPlayOnceListener = onGIFPlayOnceListener;
        }
    }

    public AbstractGifImage(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        this.mDensity = 160;
        this.mIsInPendingAction = false;
        this.mDefaultRoundCorner = 0.0f;
        this.mRefreshDelay = -1;
        this.mLastRefreshTime = 0L;
        this.mDrawableList = new Vector<>();
        if (bundle != null) {
            this.mRefreshDelay = bundle.getInt(KEY_REFRESH_DELAY, -1);
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.d("AbstractGifImage", 2, "refresh delay: " + this.mRefreshDelay);
            }
        }
    }
}
