package com.tencent.mobileqq.emoticonview.anisticker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.emoticon.QQSysFaceSwitcher;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rlottie.AXrLottieDrawable;
import com.tencent.rlottie.OnLottieFrameListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class AniStickerLottieView extends AppCompatImageView {
    static IPatchRedirector $redirector_ = null;
    protected static final ArrayList<WeakReference<AniStickerLottieView>> PENDING_ACTIONS;
    private static final int PENDING_ACTION_CAPACITY = 30;
    private static final String TAG = "AniStickerLottieView";
    protected static boolean sPaused;
    private static ConcurrentHashMap<String, String> sRandomMapResult;
    private static HashSet<String> sReloadCacheKeySet;
    protected String cacheKey;
    AniStickerAnimationListener defRandomResultPlayListener;
    protected int defaultLoadingRes;
    private boolean isInPendingAction;
    protected int localId;
    private AXrLottieDrawable lottieDrawable;
    boolean playFrameFinish;
    protected String randomKey;
    protected String resutId;
    AniStickerAnimationListener secRandomResultPlayListener;
    private AXrLottieDrawable secondLottieDrawable;
    boolean showLastFrame;
    private boolean showLoading;
    protected Drawable stickerLoadingDrawable;
    String surpriseId;
    private boolean wasAnimatingWhenDetached;
    private boolean wasDetached;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41570);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
            return;
        }
        PENDING_ACTIONS = new ArrayList<WeakReference<AniStickerLottieView>>(35) { // from class: com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottieView.1
            static IPatchRedirector $redirector_;

            {
                super(r4);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, r4);
                }
            }

            private void ensureCapacity() {
                if (size() > 30) {
                    removeRange(0, (r0 - 30) - 1);
                }
            }

            @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public boolean add(WeakReference<AniStickerLottieView> weakReference) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) weakReference)).booleanValue();
                }
                boolean add = super.add((AnonymousClass1) weakReference);
                ensureCapacity();
                return add;
            }
        };
        sPaused = false;
        sRandomMapResult = new ConcurrentHashMap<>(8);
    }

    public AniStickerLottieView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.showLastFrame = false;
        this.playFrameFinish = false;
        this.surpriseId = null;
        this.isInPendingAction = false;
        this.cacheKey = null;
        this.localId = -1;
        this.randomKey = null;
        this.resutId = null;
        this.defaultLoadingRes = R.drawable.c0i;
        this.wasDetached = false;
    }

    public static synchronized void addReloadCacheKey(String str) {
        synchronized (AniStickerLottieView.class) {
            if (sReloadCacheKeySet == null) {
                sReloadCacheKeySet = new HashSet<>();
            }
            sReloadCacheKeySet.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSecAnimatorListener(AXrLottieDrawable aXrLottieDrawable) {
        aXrLottieDrawable.y0(new OnLottieFrameListener() { // from class: com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottieView.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AniStickerLottieView.this);
                }
            }

            @Override // com.tencent.rlottie.OnLottieFrameListener
            public void onStartOnUi() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                    return;
                }
                AniStickerLottieView aniStickerLottieView = AniStickerLottieView.this;
                AniStickerAnimationListener aniStickerAnimationListener = aniStickerLottieView.secRandomResultPlayListener;
                if (aniStickerAnimationListener != null) {
                    aniStickerAnimationListener.onAnimationStart(aniStickerLottieView.localId, aniStickerLottieView.resutId);
                }
            }

            @Override // com.tencent.rlottie.OnLottieFrameListener
            public void onStopOnUi(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                    return;
                }
                if (z16) {
                    AniStickerLottieView aniStickerLottieView = AniStickerLottieView.this;
                    aniStickerLottieView.playFrameFinish = true;
                    AniStickerAnimationListener aniStickerAnimationListener = aniStickerLottieView.secRandomResultPlayListener;
                    if (aniStickerAnimationListener != null) {
                        aniStickerAnimationListener.onAnimationEnd(aniStickerLottieView.localId, aniStickerLottieView.resutId);
                    }
                }
            }
        });
    }

    public static synchronized void clearReloadCacheKey() {
        synchronized (AniStickerLottieView.class) {
            HashSet<String> hashSet = sReloadCacheKeySet;
            if (hashSet != null) {
                hashSet.clear();
            }
            sRandomMapResult.clear();
        }
    }

    @SuppressLint({"RestrictedApi"})
    private void enableOrDisableHardwareLayer() {
        boolean z16;
        if (this.lottieDrawable == null) {
            return;
        }
        int i3 = Build.VERSION.SDK_INT;
        int i16 = 1;
        if (i3 != 24 && i3 != 25) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i16 = 2;
        }
        if (i16 != getLayerType()) {
            setLayerType(i16, null);
        }
        QLog.d(TAG, 2, "enableOrDisableHardwareLayer useHardwareLayer: " + z16);
    }

    private int getFrame() {
        AXrLottieDrawable aXrLottieDrawable = this.lottieDrawable;
        if (aXrLottieDrawable != null) {
            return aXrLottieDrawable.X();
        }
        return 0;
    }

    public static boolean isAddPauseCache(AniStickerLottieView aniStickerLottieView, String str) {
        if (aniStickerLottieView == null || aniStickerLottieView.getIsEnable() || str == null || !TextUtils.isEmpty(aniStickerLottieView.surpriseId) || ((!TextUtils.isEmpty(aniStickerLottieView.resutId) && !isAnimationFinish(aniStickerLottieView)) || Build.VERSION.SDK_INT >= 26)) {
            return false;
        }
        aniStickerLottieView.cacheKey = str;
        aniStickerLottieView.showLoading = true;
        aniStickerLottieView.isInPendingAction = false;
        addReloadCacheKey(str);
        aniStickerLottieView.addToPendingActions(aniStickerLottieView);
        return true;
    }

    static final boolean isAllPause() {
        return sPaused;
    }

    private static boolean isAnimationFinish(AniStickerLottieView aniStickerLottieView) {
        if (aniStickerLottieView != null && !TextUtils.isEmpty(aniStickerLottieView.resutId) && (aniStickerLottieView.playFrameFinish || aniStickerLottieView.showLastFrame)) {
            return true;
        }
        return false;
    }

    public static final void pauseAll() {
        sPaused = true;
        QLog.d(TAG, 2, "pauseAll.");
    }

    private void pauseAnimation() {
        AXrLottieDrawable aXrLottieDrawable = this.lottieDrawable;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.stop();
        }
    }

    public static final synchronized void resumeAll() {
        synchronized (AniStickerLottieView.class) {
            QLog.d(TAG, 2, "resumeAll.");
            sPaused = false;
            HashSet<String> hashSet = sReloadCacheKeySet;
            if (hashSet != null && !hashSet.isEmpty()) {
                Iterator<String> it = sReloadCacheKeySet.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    startReloadDrawable(next);
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "startReloadDrawable cacheKey : " + next);
                    }
                }
                sReloadCacheKeySet.clear();
            }
            for (int size = PENDING_ACTIONS.size() - 1; size >= 0; size--) {
                ArrayList<WeakReference<AniStickerLottieView>> arrayList = PENDING_ACTIONS;
                AniStickerLottieView aniStickerLottieView = arrayList.get(size).get();
                if (aniStickerLottieView == null) {
                    arrayList.remove(size);
                } else if (aniStickerLottieView.getIsEnable()) {
                    arrayList.remove(size);
                    if (!aniStickerLottieView.wasDetached) {
                        aniStickerLottieView.reDraw();
                    }
                }
            }
        }
    }

    private void resumeAnimation() {
        AXrLottieDrawable aXrLottieDrawable = this.lottieDrawable;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setAniStickerRandomResult(AniStickerLottieView aniStickerLottieView, String str) {
        if (aniStickerLottieView == null) {
            QLog.e(TAG, 2, "setAniStickerRandomResult lottieView is null.");
        } else {
            sRandomMapResult.put(aniStickerLottieView.randomKey, str);
        }
    }

    public static synchronized void startReloadDrawable(String str) {
        synchronized (AniStickerLottieView.class) {
            if (str == null) {
                return;
            }
            if (isAllPause()) {
                addReloadCacheKey(str);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "addReloadCacheKey cacheKey : " + str);
                }
                return;
            }
            for (int size = PENDING_ACTIONS.size() - 1; size >= 0; size--) {
                ArrayList<WeakReference<AniStickerLottieView>> arrayList = PENDING_ACTIONS;
                AniStickerLottieView aniStickerLottieView = arrayList.get(size).get();
                if (aniStickerLottieView == null) {
                    arrayList.remove(size);
                } else if (aniStickerLottieView.getIsEnable() && str.equals(aniStickerLottieView.cacheKey)) {
                    arrayList.remove(size);
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "startReloadDrawable key: " + str);
                    }
                    aniStickerLottieView.isInPendingAction = false;
                    if (isAnimationFinish(aniStickerLottieView)) {
                        AniStickerHelper.setAniStickerRandomLastFrameResource(new AniStickerHelper.Builder(aniStickerLottieView).localId(aniStickerLottieView.localId).placeholderDrawable(aniStickerLottieView.defaultLoadingRes).resultId(aniStickerLottieView.resutId).build());
                    } else {
                        AniStickerHelper.setAniStickerResource(new AniStickerHelper.Builder(aniStickerLottieView).localId(aniStickerLottieView.localId).placeholderDrawable(aniStickerLottieView.defaultLoadingRes).showLoading(aniStickerLottieView.showLoading).build());
                    }
                }
            }
        }
    }

    public void addPreAnimatorListener(AXrLottieDrawable aXrLottieDrawable) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) aXrLottieDrawable);
            return;
        }
        if (this.randomKey != null && !this.showLastFrame) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean isEmpty = true ^ TextUtils.isEmpty(this.surpriseId);
        if (!z16 && !isEmpty) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "addPreAnimatorListener do nothing");
                return;
            }
            return;
        }
        aXrLottieDrawable.y0(new OnLottieFrameListener(aXrLottieDrawable) { // from class: com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottieView.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ AXrLottieDrawable val$lottieDrawable;

            {
                this.val$lottieDrawable = aXrLottieDrawable;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AniStickerLottieView.this, (Object) aXrLottieDrawable);
                }
            }

            @Override // com.tencent.rlottie.OnLottieFrameListener
            public void onRepeatOnUi(int i3, boolean z17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z17));
                    return;
                }
                if (TextUtils.isEmpty(AniStickerLottieView.this.surpriseId) && AniStickerLottieView.this.randomKey != null && AniStickerLottieView.sRandomMapResult.containsKey(AniStickerLottieView.this.randomKey) && AniStickerLottieView.this.secondLottieDrawable != null) {
                    this.val$lottieDrawable.stop();
                    AniStickerLottieView.sRandomMapResult.remove(AniStickerLottieView.this.randomKey);
                    AniStickerLottieView aniStickerLottieView = AniStickerLottieView.this;
                    aniStickerLottieView.addSecAnimatorListener(aniStickerLottieView.secondLottieDrawable);
                    AniStickerLottieView aniStickerLottieView2 = AniStickerLottieView.this;
                    aniStickerLottieView2.playLottieAnimation(aniStickerLottieView2.secondLottieDrawable);
                    if (QLog.isColorLevel()) {
                        QLog.d(AniStickerLottieView.TAG, 2, "play second LottieAnimation: ", Integer.valueOf(AniStickerLottieView.this.localId), " randomKey:", AniStickerLottieView.this.randomKey);
                    }
                }
            }

            @Override // com.tencent.rlottie.OnLottieFrameListener
            public void onStartOnUi() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(AniStickerLottieView.TAG, 2, "def onAnimationStart. ");
                }
                AniStickerLottieView aniStickerLottieView = AniStickerLottieView.this;
                AniStickerAnimationListener aniStickerAnimationListener = aniStickerLottieView.defRandomResultPlayListener;
                if (aniStickerAnimationListener != null) {
                    aniStickerAnimationListener.onAnimationStart(aniStickerLottieView.localId, aniStickerLottieView.resutId);
                }
            }

            @Override // com.tencent.rlottie.OnLottieFrameListener
            public void onStopOnUi(boolean z17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, z17);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(AniStickerLottieView.TAG, 2, "def onAnimationEnd. ");
                }
                AniStickerLottieView aniStickerLottieView = AniStickerLottieView.this;
                AniStickerAnimationListener aniStickerAnimationListener = aniStickerLottieView.defRandomResultPlayListener;
                if (aniStickerAnimationListener != null) {
                    aniStickerAnimationListener.onAnimationEnd(aniStickerLottieView.localId, aniStickerLottieView.resutId);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addToPendingActions(AniStickerLottieView aniStickerLottieView) {
        if (aniStickerLottieView != null && !this.isInPendingAction) {
            for (int size = PENDING_ACTIONS.size() - 1; size >= 0; size--) {
                if (PENDING_ACTIONS.get(size).get() == aniStickerLottieView) {
                    return;
                }
            }
            PENDING_ACTIONS.add(new WeakReference<>(aniStickerLottieView));
            this.isInPendingAction = true;
        }
    }

    void cancelAnimation() {
        AXrLottieDrawable aXrLottieDrawable = this.lottieDrawable;
        if (aXrLottieDrawable != null) {
            this.wasAnimatingWhenDetached = false;
            aXrLottieDrawable.stop();
        }
    }

    public void cancelLottieAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        AXrLottieDrawable aXrLottieDrawable = this.lottieDrawable;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.stop();
        }
    }

    public void clearLoadingDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Drawable drawable = this.stickerLoadingDrawable;
        if (drawable != null) {
            drawable.setCallback(null);
            this.stickerLoadingDrawable = null;
        }
    }

    public void clearLottieDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        AXrLottieDrawable aXrLottieDrawable = this.lottieDrawable;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.recycle();
            this.lottieDrawable.y0(null);
            this.lottieDrawable = null;
        }
    }

    public void clearSecondLottieDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        AXrLottieDrawable aXrLottieDrawable = this.secondLottieDrawable;
        if (aXrLottieDrawable != null && this.lottieDrawable != aXrLottieDrawable) {
            aXrLottieDrawable.recycle();
            this.secondLottieDrawable.y0(null);
            this.secondLottieDrawable = null;
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
            return;
        }
        if (this.stickerLoadingDrawable != null) {
            if (getLayerType() != 1 && Build.VERSION.SDK_INT < 28) {
                setLayerType(1, null);
                return;
            } else {
                this.stickerLoadingDrawable.setBounds(0, 0, getWidth(), getHeight());
                this.stickerLoadingDrawable.draw(canvas);
            }
        }
        super.draw(canvas);
        if (!getIsEnable() && this.lottieDrawable != null && getFrame() >= 1) {
            pauseAnimation();
            addToPendingActions(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean getIsEnable() {
        if (sPaused && this.surpriseId == null) {
            return false;
        }
        return true;
    }

    public boolean isAnimating() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        AXrLottieDrawable aXrLottieDrawable = this.lottieDrawable;
        if (aXrLottieDrawable != null) {
            return aXrLottieDrawable.isRunning();
        }
        return false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        AXrLottieDrawable aXrLottieDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        this.wasDetached = false;
        if (!isInEditMode() && (aXrLottieDrawable = this.lottieDrawable) != null && this.wasAnimatingWhenDetached) {
            if (!aXrLottieDrawable.isRunning()) {
                this.lottieDrawable.start();
            }
            this.wasAnimatingWhenDetached = false;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onAttachedToWindow playAnimation : " + this.localId);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (isAnimating()) {
            cancelAnimation();
            this.wasAnimatingWhenDetached = true;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onDetachedFromWindow cancelAnimation : " + this.localId);
            }
        }
        if ((getContext() instanceof Activity) && ((Activity) getContext()).isFinishing()) {
            clearLottieDrawable();
            clearSecondLottieDrawable();
            this.localId = -1;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onDetachedFromWindow clear res.");
            }
        }
        this.wasDetached = true;
        super.onDetachedFromWindow();
        clearLoadingDrawable();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) canvas);
            return;
        }
        if (QQSysFaceSwitcher.f204652a.f() && !FontSettingManager.isFontSizeNormal() && ((i3 = Build.VERSION.SDK_INT) == 24 || i3 == 25)) {
            int density = canvas.getDensity();
            canvas.setDensity(0);
            try {
                super.onDraw(canvas);
            } finally {
                canvas.setDensity(density);
            }
        }
        super.onDraw(canvas);
    }

    public void playAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        AXrLottieDrawable aXrLottieDrawable = this.lottieDrawable;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void playLottieAnimation(AXrLottieDrawable aXrLottieDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) aXrLottieDrawable);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        clearLoadingDrawable();
        enableOrDisableHardwareLayer();
        this.showLoading = false;
        setImageDrawable(aXrLottieDrawable);
        this.isInPendingAction = false;
        if (this.showLastFrame) {
            aXrLottieDrawable.s0(aXrLottieDrawable.Z() - 1);
            playAnimation();
        } else if (!getIsEnable()) {
            addToPendingActions(this);
        } else {
            playAnimation();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "playLottieAnimation cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void reDraw() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.isInPendingAction = false;
        if (!this.showLastFrame && !this.playFrameFinish && TextUtils.isEmpty(this.surpriseId)) {
            if (!isAnimating()) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "resumeAnimation");
                }
                resumeAnimation();
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "reDraw return, showLastFrame:" + this.showLastFrame + " playFrameFinish:" + this.playFrameFinish + " surpriseId:" + this.surpriseId);
        }
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.localId = -1;
        this.resutId = null;
        this.surpriseId = null;
        this.playFrameFinish = false;
        this.showLastFrame = false;
        AXrLottieDrawable aXrLottieDrawable = this.lottieDrawable;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.s0(0);
            this.lottieDrawable.stop();
            this.lottieDrawable = null;
        }
        AXrLottieDrawable aXrLottieDrawable2 = this.secondLottieDrawable;
        if (aXrLottieDrawable2 != null) {
            aXrLottieDrawable2.s0(0);
            this.secondLottieDrawable.stop();
            this.secondLottieDrawable = null;
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable);
            return;
        }
        if (drawable != null) {
            if (drawable instanceof AXrLottieDrawable) {
                if (this.lottieDrawable != drawable) {
                    clearLottieDrawable();
                }
                this.lottieDrawable = (AXrLottieDrawable) drawable;
            } else {
                clearLottieDrawable();
            }
        }
        super.setImageDrawable(drawable);
    }

    public void setSecondLottieDrawable(AniStickerInfo aniStickerInfo, AXrLottieDrawable aXrLottieDrawable, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, aniStickerInfo, aXrLottieDrawable, Integer.valueOf(i3));
            return;
        }
        if (aniStickerInfo == null) {
            return;
        }
        if (aXrLottieDrawable != null) {
            if (this.secondLottieDrawable == aXrLottieDrawable) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "secondLottieDrawable composition can reuse");
                    return;
                }
                return;
            }
            clearSecondLottieDrawable();
            aXrLottieDrawable.p0(i3);
            aXrLottieDrawable.c(true);
            if (AniStickerHelper.isChangeAniSticker(this, aniStickerInfo)) {
                QLog.d(TAG, 2, "view load other res. id: " + aniStickerInfo.localId);
                return;
            }
            this.secondLottieDrawable = aXrLottieDrawable;
            return;
        }
        QLog.e(TAG, 2, "lottie composition is null. ");
    }

    public void stopAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        AXrLottieDrawable aXrLottieDrawable = this.lottieDrawable;
        if (aXrLottieDrawable != null) {
            aXrLottieDrawable.stop();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) drawable)).booleanValue();
        }
        if (!super.verifyDrawable(drawable) && ((drawable2 = this.stickerLoadingDrawable) == null || drawable != drawable2)) {
            return false;
        }
        return true;
    }

    public AniStickerLottieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.showLastFrame = false;
        this.playFrameFinish = false;
        this.surpriseId = null;
        this.isInPendingAction = false;
        this.cacheKey = null;
        this.localId = -1;
        this.randomKey = null;
        this.resutId = null;
        this.defaultLoadingRes = R.drawable.c0i;
        this.wasDetached = false;
    }

    public AniStickerLottieView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.showLastFrame = false;
        this.playFrameFinish = false;
        this.surpriseId = null;
        this.isInPendingAction = false;
        this.cacheKey = null;
        this.localId = -1;
        this.randomKey = null;
        this.resutId = null;
        this.defaultLoadingRes = R.drawable.c0i;
        this.wasDetached = false;
    }
}
