package com.tencent.image;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.image.VideoDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class AbstractVideoImage {
    static IPatchRedirector $redirector_ = null;
    private static final int PENDING_ACTION_CAPACITY = 100;
    private static final String TAG;
    public static boolean loopEnable;
    protected static Object sPauseLock;
    protected static volatile boolean sPaused;
    protected static final ArrayList<WeakReference<AbstractVideoImage>> sPendingActions;
    public float mDefaultRoundCorner;
    private int mDensity;
    private Vector<WeakReference<VideoDrawable>> mDrawableList;
    protected boolean mIsInPendingAction;
    protected ArrayList<WeakReference<VideoDrawable.OnPlayRepeatListener>> mListener;
    protected VideoDrawable.OnAudioPlayOnceListener mPlayOnceListener;
    public boolean mSupportGlobalPause;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8482);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        TAG = AbstractVideoImage.class.getSimpleName();
        sPendingActions = new ArrayList<WeakReference<AbstractVideoImage>>(105) { // from class: com.tencent.image.AbstractVideoImage.1
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
            public boolean add(WeakReference<AbstractVideoImage> weakReference) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) weakReference)).booleanValue();
                }
                boolean add = super.add((AnonymousClass1) weakReference);
                ensureCapacity();
                return add;
            }
        };
        loopEnable = true;
        sPaused = false;
        sPauseLock = new Object();
    }

    public AbstractVideoImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mDefaultRoundCorner = 5.0f;
        this.mSupportGlobalPause = true;
        this.mIsInPendingAction = false;
        this.mListener = new ArrayList<>();
        this.mDensity = 160;
        this.mDrawableList = new Vector<>();
    }

    public static final void pauseAll() {
        if (!sPaused) {
            sPaused = true;
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.d(TAG, 2, " pauseAll ");
            }
        }
    }

    public static final void resumeAll() {
        if (sPaused) {
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.d(TAG, 2, " resumeAll ");
            }
            synchronized (sPauseLock) {
                sPaused = false;
                sPauseLock.notifyAll();
            }
            for (int size = sPendingActions.size() - 1; size >= 0; size--) {
                AbstractVideoImage abstractVideoImage = sPendingActions.get(size).get();
                if (abstractVideoImage != null) {
                    abstractVideoImage.reDraw();
                }
            }
            sPendingActions.clear();
        }
    }

    public static int scaleFromDensity(int i3, int i16, int i17) {
        if (i16 != 0 && i16 != i17) {
            return ((i3 * i17) + (i16 >> 1)) / i16;
        }
        return i3;
    }

    protected abstract void applyNextFrame();

    public void attachDrawable(VideoDrawable videoDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) videoDrawable);
        } else if (videoDrawable != null) {
            synchronized (this.mDrawableList) {
                if (!this.mDrawableList.contains(videoDrawable)) {
                    this.mDrawableList.add(new WeakReference<>(videoDrawable));
                }
            }
        }
    }

    public void detachDrawable(VideoDrawable videoDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) videoDrawable);
            return;
        }
        if (videoDrawable != null) {
            synchronized (this.mDrawableList) {
                int i3 = 0;
                while (i3 < this.mDrawableList.size()) {
                    WeakReference<VideoDrawable> weakReference = this.mDrawableList.get(i3);
                    if (weakReference != null && weakReference.get() != videoDrawable) {
                        if (weakReference.get() == videoDrawable) {
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

    public abstract void disableGlobalPause();

    /* JADX INFO: Access modifiers changed from: protected */
    public void doApplyNextFrame(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        applyNextFrame();
        if (this.mSupportGlobalPause) {
            if (!sPaused) {
                invalidateSelf();
                return;
            } else {
                if (!this.mIsInPendingAction) {
                    sPendingActions.add(new WeakReference<>(this));
                    this.mIsInPendingAction = true;
                    return;
                }
                return;
            }
        }
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void draw(Canvas canvas, Rect rect, Paint paint, boolean z16);

    public abstract int getByteSize();

    public abstract int getHeight();

    public int getScaledHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, i3)).intValue();
        }
        return scaleFromDensity(getHeight(), this.mDensity, i3);
    }

    public int getScaledWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, i3)).intValue();
        }
        return scaleFromDensity(getWidth(), this.mDensity, i3);
    }

    public abstract int getWidth();

    protected void invalidateSelf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        synchronized (this.mDrawableList) {
            int i3 = 0;
            while (i3 < this.mDrawableList.size()) {
                WeakReference<VideoDrawable> weakReference = this.mDrawableList.get(i3);
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

    public abstract boolean isAudioPlaying();

    /* JADX INFO: Access modifiers changed from: protected */
    public void reDraw() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            invalidateSelf();
            this.mIsInPendingAction = false;
        }
    }

    public void removeOnPlayRepeatListener(VideoDrawable.OnPlayRepeatListener onPlayRepeatListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) onPlayRepeatListener);
            return;
        }
        if (onPlayRepeatListener != null) {
            synchronized (this.mListener) {
                for (int size = this.mListener.size() - 1; size >= 0; size--) {
                    if (this.mListener.get(size).get() == onPlayRepeatListener) {
                        this.mListener.remove(size);
                    }
                }
            }
        }
    }

    public abstract void resetAndPlayAudioCircle();

    public abstract void resetAndPlayAudioOnce();

    public void setOnAudioPlayOnceListener(VideoDrawable.OnAudioPlayOnceListener onAudioPlayOnceListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) onAudioPlayOnceListener);
        } else {
            this.mPlayOnceListener = onAudioPlayOnceListener;
        }
    }

    public void setOnPlayRepeatListener(VideoDrawable.OnPlayRepeatListener onPlayRepeatListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) onPlayRepeatListener);
            return;
        }
        if (onPlayRepeatListener != null) {
            synchronized (this.mListener) {
                boolean z16 = false;
                int i3 = 0;
                while (true) {
                    if (i3 >= this.mListener.size()) {
                        break;
                    }
                    if (this.mListener.get(i3).get() == onPlayRepeatListener) {
                        z16 = true;
                        break;
                    }
                    i3++;
                }
                if (!z16) {
                    this.mListener.add(new WeakReference<>(onPlayRepeatListener));
                }
            }
        }
    }

    public abstract void stopPlayAudio();
}
