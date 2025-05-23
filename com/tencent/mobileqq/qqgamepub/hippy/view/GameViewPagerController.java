package com.tencent.mobileqq.qqgamepub.hippy.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.views.viewpager.HippyViewPager;
import com.tencent.mtt.hippy.views.viewpager.HippyViewPagerController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

@HippyController(name = "ViewPager")
/* loaded from: classes16.dex */
public class GameViewPagerController extends HippyViewPagerController {
    public static final int CODE_ANIM_IS_RUNNING = -2;
    public static final int CODE_PARAMS_ERROR = -1;
    public static final int CODE_SUCCESS = 0;
    private static final String FUNC_SIDLE = "slide";
    private static final String KEY_DLEFT = "dLeft";
    private static final String KEY_DURATION = "duration";
    public static final int NOTIFY_END_DELAY = 300;
    public static final int RESET_ANIM_DELAY = 100;
    private static final String TAG = "GameViewPagerController";
    private boolean isHandleOnTouch;
    private final AtomicBoolean isSlideAnimating = new AtomicBoolean(false);

    @SuppressLint({"ClickableViewAccessibility"})
    private void bindOnTouchListener(final HippyViewPager hippyViewPager, final int i3, final int i16) {
        this.isHandleOnTouch = false;
        hippyViewPager.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.qqgamepub.hippy.view.f
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean lambda$bindOnTouchListener$4;
                lambda$bindOnTouchListener$4 = GameViewPagerController.this.lambda$bindOnTouchListener$4(hippyViewPager, i3, i16, view, motionEvent);
                return lambda$bindOnTouchListener$4;
            }
        });
    }

    private void callbackSlide(int i3, String str, Promise promise) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("result", i3);
        hippyMap.pushString("msg", str);
        promise.resolve(hippyMap);
        QLog.i(TAG, 1, "[callbackSlide] code:" + i3 + ",msg:" + str);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void doSlideAnim(final HippyViewPager hippyViewPager, final int i3, double d16, final int i16, final int i17, final Promise promise) {
        QLog.i(TAG, 1, "[doSlideAnim] dLeft:" + i3 + ",duration:" + d16 + ",x:" + i16 + ",y:" + i17);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.qqgamepub.hippy.view.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                GameViewPagerController.this.lambda$doSlideAnim$2(i3, hippyViewPager, i16, i17, promise, valueAnimator);
            }
        });
        ofFloat.setDuration((long) (d16 * 1000.0d));
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ensureSlideResetByEvent, reason: merged with bridge method [inline-methods] */
    public void lambda$bindOnTouchListener$3(HippyViewPager hippyViewPager, int i3, int i16) {
        if (hippyViewPager != null) {
            int scaledTouchSlop = ViewConfiguration.get(MobileQQ.sMobileQQ).getScaledTouchSlop();
            if (hippyViewPager.getScrollX() > scaledTouchSlop) {
                long uptimeMillis = SystemClock.uptimeMillis();
                float f16 = i16;
                hippyViewPager.dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, i3, f16, 0));
                hippyViewPager.dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, SystemClock.uptimeMillis(), 2, i3 - scaledTouchSlop, f16, 0));
                float f17 = i3 - (scaledTouchSlop * 2);
                hippyViewPager.dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, SystemClock.uptimeMillis(), 2, f17, f16, 0));
                hippyViewPager.dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, SystemClock.uptimeMillis(), 1, f17, f16, 0));
            }
            QLog.i(TAG, 1, "[ensureSlideReset] x:" + i3 + ",y:" + i16 + ",scrollX:" + hippyViewPager.getScrollX() + ",scaledTouchSlop:" + scaledTouchSlop);
        }
    }

    private void ensureSlideResetByScroll(final HippyViewPager hippyViewPager) {
        int currentItem = hippyViewPager.getCurrentItem();
        int scrollX = hippyViewPager.getScrollX();
        int scaledTouchSlop = ViewConfiguration.get(MobileQQ.sMobileQQ).getScaledTouchSlop();
        if (currentItem == 0 && scrollX > scaledTouchSlop) {
            hippyViewPager.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.view.e
                @Override // java.lang.Runnable
                public final void run() {
                    GameViewPagerController.lambda$ensureSlideResetByScroll$5(HippyViewPager.this);
                }
            }, 100L);
        }
        QLog.i(TAG, 1, "[ensureSlideResetByScroll] currentItem:" + currentItem + ",scrollX:" + scrollX + ",scaledTouchSlop:" + scaledTouchSlop);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$bindOnTouchListener$4(final HippyViewPager hippyViewPager, final int i3, final int i16, View view, MotionEvent motionEvent) {
        this.isHandleOnTouch = true;
        if (motionEvent.getAction() == 1) {
            unBindOnTouchListener(hippyViewPager);
            hippyViewPager.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.view.c
                @Override // java.lang.Runnable
                public final void run() {
                    GameViewPagerController.this.lambda$bindOnTouchListener$3(hippyViewPager, i3, i16);
                }
            }, 100L);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doSlideAnim$1(HippyViewPager hippyViewPager, Promise promise) {
        if (!this.isHandleOnTouch) {
            unBindOnTouchListener(hippyViewPager);
            ensureSlideResetByScroll(hippyViewPager);
        }
        callbackSlide(0, "success", promise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doSlideAnim$2(int i3, final HippyViewPager hippyViewPager, int i16, int i17, final Promise promise, ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        float f16 = (-i3) * animatedFraction;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (animatedFraction == 0.0f) {
            hippyViewPager.dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, i16, i17, 0));
        }
        float f17 = i16 + f16;
        float f18 = i17;
        hippyViewPager.dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, SystemClock.uptimeMillis(), 2, f17, f18, 0));
        if (animatedFraction == 1.0f) {
            this.isSlideAnimating.set(false);
            hippyViewPager.dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, SystemClock.uptimeMillis(), 1, i16 - i3, f18, 0));
            bindOnTouchListener(hippyViewPager, i16, i17);
            hippyViewPager.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.view.d
                @Override // java.lang.Runnable
                public final void run() {
                    GameViewPagerController.this.lambda$doSlideAnim$1(hippyViewPager, promise);
                }
            }, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$ensureSlideResetByScroll$5(HippyViewPager hippyViewPager) {
        hippyViewPager.scrollTo(0, hippyViewPager.getTop());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$slide$0(Promise promise, HippyViewPager hippyViewPager, int i3, double d16) {
        if (this.isSlideAnimating.getAndSet(true)) {
            callbackSlide(-2, "\u52a8\u753b\u6b63\u5728\u6267\u884c", promise);
            return;
        }
        int width = hippyViewPager.getWidth() / 2;
        int height = hippyViewPager.getHeight() / 2;
        if (width != 0 && height != 0) {
            doSlideAnim(hippyViewPager, i3, d16, width, height, promise);
            return;
        }
        QLog.e(TAG, 1, "[slide] invalid,x:" + width + ",y:" + height);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void unBindOnTouchListener(HippyViewPager hippyViewPager) {
        hippyViewPager.setOnTouchListener(null);
    }

    public void slide(final HippyViewPager hippyViewPager, final int i3, final double d16, final Promise promise) {
        if (hippyViewPager != null && i3 != 0 && d16 != 0.0d) {
            hippyViewPager.post(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.view.g
                @Override // java.lang.Runnable
                public final void run() {
                    GameViewPagerController.this.lambda$slide$0(promise, hippyViewPager, i3, d16);
                }
            });
            return;
        }
        QLog.i(TAG, 1, "[slide] invalid,vp:" + hippyViewPager + ",dLeft:" + i3 + ",duration:" + d16);
        callbackSlide(-1, MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR, promise);
    }

    @Override // com.tencent.mtt.hippy.views.viewpager.HippyViewPagerController, com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyViewPager hippyViewPager, String str, HippyArray hippyArray, Promise promise) {
        HippyMap map;
        QLog.i(TAG, 1, "[dispatchFunction] hippyViewPager:" + hippyViewPager + ",functionName,:" + str + ",params:" + hippyArray);
        super.dispatchFunction(hippyViewPager, str, hippyArray, promise);
        if (!"slide".equals(str) || hippyArray == null || hippyArray.size() <= 0 || (map = hippyArray.getMap(0)) == null || !map.containsKey(KEY_DLEFT) || !map.containsKey("duration")) {
            return;
        }
        slide(hippyViewPager, ViewUtils.dpToPx(map.getInt(KEY_DLEFT)), map.getDouble("duration") / 2.0d, promise);
    }
}
