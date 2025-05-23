package com.tencent.ams.fusion.widget.olympicshake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.tencent.ams.fusion.widget.animatorview.AnimatorView;
import com.tencent.ams.fusion.widget.animatorview.animator.AlphaAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.SequentialAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.TranslateAnimator;
import com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateConfig;
import com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateListener;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.CircleShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.ams.fusion.widget.base.ShakeView;
import com.tencent.ams.fusion.widget.olympicshake.OlympicShakeAnimationHelper;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes3.dex */
public class OlympicShakeView extends FrameLayout implements Animator.AnimatorListener, IFrameRateConfig, ShakeView<OlympicShakeListener>, OnShakeListener {
    static IPatchRedirector $redirector_ = null;
    private static final float BOTTOM_VIEW_HEIGHT_DP = 240.0f;
    private static final int DEFAULT_SUB_TITLE_SIZE_DP = 14;
    private static final int DEFAULT_TITLE_SIZE_DP = 18;
    private static final float SHACK_ANIMATOR_VIEW_ENDING_CIRCLE_RADIUS = 50.0f;
    private static final int SHADOW_END_COLOR = 0;
    private static final int SHADOW_START_COLOR = 2130706432;
    private static final float SHAKE_ANIMATOR_VIEW_ICON_HEIGHT_DP = 70.0f;
    private static final float SHAKE_ANIMATOR_VIEW_ICON_WIDTH_DP = 70.0f;
    private static final float SHAKE_CIRCLE_TOP_PADDING_DP = 36.0f;
    private static final float SHAKE_ICON_TITLE_PADDING_DP = 12.0f;
    private static final String TAG = "OlympicShakeView";
    private static final float TITLE_SUB_TITLE_PADDING_DP = 4.0f;
    private float mBottomPaddingDp;
    private View mBottomShadowView;
    private OnDebugShakeListener mDebugShakeListener;
    private TextView mDebugView;
    private int mInteractiveMode;
    private boolean mIsDebug;
    private boolean mIsStop;
    private boolean mIsTouchDownInShakeCircle;
    private double mMaxShakeValue;
    private boolean mSensorEventsDeliveredOnMainThread;
    private AnimatorView mShakeAnimView;
    private String mShakeCircleBgColor;
    private float mShakeCircleBgRadiusDp;
    private boolean mShakeCircleBgShowAlways;
    private int[] mShakeDirectcombine;
    private int mShakeDuration;
    private float mShakeFactorX;
    private float mShakeFactorY;
    private float mShakeFactorZ;
    private Bitmap mShakeIconBitmap;
    private float mShakeIconCenterYDp;
    private float mShakeIconHeightDp;
    private float mShakeIconWidthDp;
    private OlympicShakeListener mShakeListener;
    private int mShakeSampleRate;
    private ShakeSensor mShakeSensor;
    private float mShakeThreshold;
    private int mShakeValidCount;
    private List<Integer> mShakeValidValues;
    private float mShakeViewBottomHeightDp;
    private String mSubTitleText;
    private TextLayer mSubTitleTextLayer;
    private int mSubTitleTextSizeDp;
    private String mTitleText;
    private TextLayer mTitleTextLayer;
    private int mTitleTextSizeDp;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface InteractiveMode {
        public static final int MODE_CLICK = 2;
        public static final int MODE_CLICK_SHAKE = 3;
        public static final int MODE_SHAKE = 1;
    }

    public OlympicShakeView(Context context) {
        this(context, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void addShakeValidValue(double d16) {
        if (this.mShakeValidValues == null) {
            this.mShakeValidValues = new ArrayList();
        }
        this.mShakeValidValues.add(Integer.valueOf((int) (d16 * 100.0d)));
    }

    private void changeViewHeight(View view, float f16) {
        ViewGroup.LayoutParams layoutParams;
        if (view != null && (layoutParams = view.getLayoutParams()) != null) {
            layoutParams.height = (int) f16;
            view.setLayoutParams(layoutParams);
        }
    }

    private View createBottomShadowView() {
        View view = new View(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) dp2px(getShakeViewBottomHeightDp()));
        layoutParams.gravity = 80;
        view.setLayoutParams(layoutParams);
        view.setBackground(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{2130706432, 0}));
        this.mBottomShadowView = view;
        return view;
    }

    private View createDebugView() {
        TextView textView = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(SupportMenu.CATEGORY_MASK);
        textView.setVisibility(8);
        this.mDebugView = textView;
        return textView;
    }

    private Animator createEndingAnimator(AnimatorLayer animatorLayer) {
        SequentialAnimator sequentialAnimator = new SequentialAnimator(animatorLayer);
        sequentialAnimator.addAnimator(createEndingStep1Animator(animatorLayer, 0.0f, dp2px(-20.0f)));
        sequentialAnimator.addAnimator(createEndingStep1Animator(animatorLayer, dp2px(-20.0f), dp2px(20.0f)));
        sequentialAnimator.addAnimator(createEndingStep1Animator(animatorLayer, dp2px(20.0f), 0.0f));
        sequentialAnimator.addAnimator(createEndingStep1Animator(animatorLayer, 0.0f, dp2px(-13.0f)));
        sequentialAnimator.addAnimator(createEndingStep1Animator(animatorLayer, dp2px(-13.0f), dp2px(15.0f)));
        sequentialAnimator.addAnimator(createEndingStep1Animator(animatorLayer, dp2px(15.0f), dp2px(-8.0f)));
        sequentialAnimator.addAnimator(createEndingStep1Animator(animatorLayer, dp2px(-8.0f), 0.0f));
        sequentialAnimator.addAnimator(createEndingStep2Animator(animatorLayer));
        sequentialAnimator.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.tencent.ams.fusion.widget.olympicshake.OlympicShakeView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) OlympicShakeView.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
            public void onAnimationFinish() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    OlympicShakeView.this.stop();
                    Logger.d(OlympicShakeView.TAG, "Ending Animation Finish");
                }
            }
        });
        return sequentialAnimator;
    }

    private Animator createEndingStep1Animator(AnimatorLayer animatorLayer, float f16, float f17) {
        TranslateAnimator translateAnimator = new TranslateAnimator(animatorLayer, 0.0f, 0.0f, f16, f17);
        translateAnimator.setDuration(40L);
        translateAnimator.setPathInterpolator(0.33f, 0.0f, 0.67f, 0.0f);
        return translateAnimator;
    }

    private Animator createEndingStep2Animator(AnimatorLayer animatorLayer) {
        AlphaAnimator alphaAnimator = new AlphaAnimator(animatorLayer, 1.0f, 0.0f);
        alphaAnimator.setDuration(80L);
        return alphaAnimator;
    }

    private AnimatorView createShakeAnimView() {
        AnimatorView animatorView = new AnimatorView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) dp2px(getShakeViewBottomHeightDp()));
        layoutParams.gravity = 80;
        animatorView.setLayoutParams(layoutParams);
        this.mShakeAnimView = animatorView;
        return animatorView;
    }

    private Bitmap createShakeIconBitmap() {
        return Utils.bitmapFromBase64String("iVBORw0KGgoAAAANSUhEUgAAARgAAAEYCAMAAACwUBm+AAAA8FBMVEUAAACJiYl1dXV7e3t2dnZ1dXVzc3N0dHRycnJzc3N0dHR4eHj///////+Tk5OQkJCFhYX+/v79/f3t7e3ExMS/v7/09PTm5ub5+fmenp5zc3PJycn8/Pzn5+f+/v739/f19fXy8vL8/Pz29vba2trX19enp6f////u7u75+fn9/f3p6em7u7v6+vrx8fHl5eXMzMz9/f339/fU1NTR0dGzs7Pk5OTg4OC0tLT6+vrj4+Ph4eHd3d3q6urc3NzX19esrKz4+Pjw8PDz8/Pr6+vw8PD5+fn19fX8/Pz6+vrr6+vu7u78/Pzv7++EhIT////a8W1ZAAAAT3RSTlMAAwYJCxEXFBwaDx79+CgjIvXskkRBs33NLCJH54Hvx7es5L5fWS/6mdPzhDzWpntM6sNWUjR2azjacm9nh2RcMsqjr46f0Lvg3ouV4ZwyQFPe0QAAFT9JREFUeNrsnGlb2kAQgBuTze6GcB9yeFRExQNBRbytqBVra+f//5tmwT4TsNjAJIGWvI+PH/yS9c3s7OxOkk8RERERERERERERERERERFzjvbGp4hhK0u/iey4rei6YVmMMcswdD2So1CxoluMm1IopMmZFcnpezEsLrev73eraztrTw8vJ0kRyfmkOdHCReuzDUh8/XHh5ThemJk7hgGRHPRiMNFJAzIsJ7ugchwvPPUAfSI5w/MoNvASyXGj6UzegyKSMzKRzEtAvMjZWgQ5ms63M+AQyRkJGEsegiKSMxow5zY4RHLeZZhHUERyRsQw8Q3crHfOS63Vz5nJ5HT/Nzmazlvgwr4pC9NBxCoLLUfNpBdwcVM2meFgMT6tnMT/IMdZk8QxIEcJ09CX+mcz+kLL0XSWSgPyKJiu/g9NW3A5ms5PwEXLNJYG/8Jiy1EpJgvIWozpg9EvuByVYoqA9IQ1CJgP5OQml/P9y78mR9NZIg7IKs4kn+UU/y05msFr4CLH32bSgstxUoysA3KEKWYcvsiR8y5H7QeeAClITDEe5chYbpkmZx7VaDov2YA0nRTzCQlUDk6rpfkLG80wb8HFATdwiGHJYZY+b1GjUsxXQKoCU8y0cgoTylnvlCSfNzUqxTQA2cAUE6KceOFAMmOuzGg6v7MBucQUQ5dzNIGabJIb+hyZcfYDZ+DiHKuYkOVcHJjW/JhRKeYQkG+C4UwKWc5RxbSW5kfM8KnmocT9QOhy9lqmMS9mVH8AXJwRUgxdTrXE9TkxM9KBtO8oKYYup4fFwszQFKrTtgFIg5Zi6HKuyJOJPlI1Vt3g5SogXzHFBCon3xwj5yI2w5BRQ1QjVHCRBxe35iT7AbqcuQqZwSOIphTJ00SsXG4CYpc8pRi6HAPlZGCIopzVkt3XIivZbhoAMsXHHiBPU6QYohyRWF4BF/Y2YS4RvTDZ3nSNBJD6FCmGOK0YF+dVcHFGCFqaF558teHP1KZIMVQ5BhP5HUDuCZUUzcv2E4xhJ8GNkDcrmhpRuQdIjxC1BC86T471At2yGf7WX5VS14AUhTUDMTqTPRjLfVlwQw9NDfb7WoB8I4ihjOEaxrNTaMVMFrYaZ1BbgDRmIUZnySp8yPGWMMM6SsODj31ANgmFDCHzXsLf2D0T3Aplj4sd4gIg94TkS0hzm/B3uhWThWAGw1hUAdkPcbnGIZR2wAP2jQzPjKbzU3BxEmKBh0NogzdeJQvr+FUbXhB2EmwWYi7BI4/SIoyP0DrfFWwGi5J5Ax6xt3jQORBzb5eae+kR0wSvVFOEkCY8AHhJ2K4RxJyBZ5qEEyPCM8YHfCZiKuCZ54ArUKx7VwHJEI42KT2kWAY8kwt23cTa6gGQTcLtIC0ABfDMqs+zXRvwvuH3DMgLYQIHW8ggG1iC+v29iOE3yMDFFiFMaUvjOnhl089ura6OeB3wexF/fGzJJpR3xF1kJQ4e6fqzzVVWjNHvRQzcDA5CvhMafj6GjLkcVsSgFsZlslYvPK1UL54K++2kkqMCR4USG4rhQ2nNRow6wvsKHsBTaaoXg5mitpkGJN3r3AnlZtAJ3QOkQ7gm+b1z+QIfg/t/jX4jDC7OGjCKXbzJC8kZ47ICLnKzKO8U/cCWtWfwwAHXNfrnRczTcUdAF/V2TMTKzXfvd4SJUtLvbzk/FpfJlwz8jV0stSi9ves1GM/Rxu3PDUCOQy7vtLeVgXEH9dsUidVqgHslnLYdGz4mnQYkG+7WWmmxlIxcu3ZyqlZM05QiddWAD2ioqCbmF0s2bZiEWliLEmqR+Wwx/va4cXNbSOmoKdfGV3t2m5MDxqndJvNi/xQsjN4NLphy5PtKTv9I9NXg30dYNi2yF36+BhOx8rMsg29roReeqtvv+0flvppY/jAO78nimS/h8L8LE5J+qKWC7/jhjSv+uX/0pua0vjc6vivHC30incEUVFcTwXb80MvduKrluZkQ0kGUblYAsTfz/aGRu0W7MBWZTpAdP9wCJD4YX+alFOvn4dT15/jbPN+oyH5nn3xDajAtx4G/cYFPq44j/Xrez8NSJCrXy5e3eWHiCzK0C6/D1KSXBQ/GDN63tg0fE9/IxYQ5QJV/gyMBH5qeNhA4TgRjBg95PUx0u9eODY5J8BCJLIbfAoliKYjGFg5vy+MwbmOSY7D4cfZfBxq724GYwVduPHLRSUluoRlyiikCkcYdmvF9JqXWwDMr+wlUQxYjqkBlN0WppugNNmTt+53ktMITmyIZIFOXTA9IzDVMRvzwQKAakpg9IGN/CabLpBnmzeSDKbQEblcIYuJAZ2Wb65oWhJjsVDXEF6oalWNWgAR+TyEQMftTpr0r2iZXrUrH4AN2BVcmX3NMB6bkx3JioGbqvfUr+MEDhozP9d3UZB4J+3/NwHtCYmdMr4L8vDMlBR5d4lZu8kuf2+AH9z6HDG5xKXTv0Azh03oU4iU/axncsTSBxPMBVhKEAzwC+LEJn+cScdXM5FXMTHfpDPjB50DmklqwaTSSzNC0qS79i7or7UojCIKPJCxLdjlWRA4jxEhA8QKVQxFPiCYhmf//b+Is+uqZwO7Y1KKpj/kQ9zXdPdPT1dWc9Nt04tGk32+M7MfvEsi4gMwnvL1Fi5aWvpaL/nQ+pQjokrmAaAemCEEuIykdMo7sbW4liQaydbyYz7h57csyktIupV6CYciWWT9VMoBiKmWBDNXCuAY3hG2ZRHZ3Eaep6liS8kAOPSWAgKgjpMHpPqwUqayQSun/5b2qWgynkRgGPJDSsK2E6OAmIVhl5Ww036RhnkRRLDt9+F14k4BhRO5a3xYcjJFOqIOUPSWYlc9F170THEsinm8i2T9oKAEwb8x3Fp+UbSWTlkbSLn/dctVLkYfHSCPZzq+5SgAIrbHTbiKZvsjd3B4Mz9NTgpmzfvvCX8/NwDALmKYle4fgzxv7Tmx/PXoyg/e59kgV2ht7L3qrR5CLLeMTxI9F3ckaApm3xC9ffJ7gz7I+58Op51aUMW61LzNGCiz7Yl+9GDwFOtzIB96MPqwfUSD6Sn4yuWmcweSl3DPyQIpm2RZm9mFzV04yCaJvKCqYp2WYJlNoi2pYpiLKnHPAu9lz7BCiL30aD6ZJpn80lTmG1Nwb04oJ8zOsG0r0Be5xJpFu4ZaTD89w/GFADKeG9GEDib5ADQ5DMs1Hq7ypjMAfBox9eD7mHUL0rQQEEkQeeM5cXjOvlJB7SRlmrAATou9sjG26LIg2jNGJCA1zKivxk1kftj49ojLd01l+PLJBaiIaJq+MUeDm3vfxVQWYEH3t8nnxnx7tsYA6T24DthLcFGPGJgXR1zfN8Vbj+V3QAnWdei6smX8cLlEkb91Q5nC3Th7z8FWhOk3Ek4NexopDD5/5bWZhDllUqmEgsWFK9C0/Tr45pfX1ftoGS5FumERYmEt0dviiSyD6ZvQYvY+4HqaHWdgppiBo6dMMUxNQAYelx901Acx5Ror5rAIhH8TmzziA6KvZrNFYBSlmRdDR5/0ssmZ+6qYuVwfks7Kr4jcyPv+jUrDjEc59QHopEHxJamzyWxEzJbNRcEjBQbtTxjgH04H3wwzlU1SZCKIJKaaiDIDdPfwPqC5CFuKTdaDuZow2ci+TMtRpKynOyZwUSfLja5yBTHWvnuPVdRN1itlSxhhxfx+M6F+Jo6nL/iQISFYELSW6ZeyBgM4qVO7mpxi3TjcMmAaZjYkSwL0SxBL7sLyPSuNs2shB/8gc/E0bYNJzppU4ndFaVUK8wzcxU0yT0M4nmgb9I0P84n4UNC0JvBwinyph2egfGeEAhqGmmB/KGI00DBOFWZ62PNnoHxkgJzAMOcXslyNRxYPKZcKaAv0jA5yRfy3IYBvjqIzLVATZpV4bFLpTMTP0j8KxHsnMR+JYmaPdp4ulgC852neVj50h+kcqFFi9Sk4xoxc9Q5/YQRo/cpXLzLY3s390Ek5QzAm8mCUnDLi/iIJVGCHI78/tH61uBh9RzU78bQyvTi5tKCCRvPYE7gIUzx9N0x97wVertzLuvFnnOA2mqCoB/SOdh+ujlbn9P7w6cFNMTjKWOYDTMJz2PrB/5JsmXZjMLt4gaUNOMUUZN7wPlbNob5iVnx3ddbSS2d7OjBNpj2wXPNCnlAjNgmMRnEZ/QscL6R9tp30BZsu+PPo7qNOwCznFXCopiqtQ54v4YfXT+UPo+lMprbUU/vn60sBt5fuCxEiNMhakW+XBbKLytvFgggfEE8lSd2vSUG7zOtdCoqMbJi5IMaTrHiLJ7M1FE6b8ekrzoUv6+vfgRO/YcYQU01CLwB3juhddSQINKL+o8tdf6z0TEDUjIwb1TTG+1OA0kbJjVvQOZR+zFpO8pRTzhFtwDkSGMaXm/NQuM2+VDT3F7Cg5cN3zDwepYQamFwSJOov0o0oNxcAYnIMI+VSHS1gdgbU4HFxnEjqaRPm/7hL0AdgpZqxI+Cykq+t7jGkrqS3oOApTTPg3yXva/DLWdQQvdcIU4yoWUpo3I4wlT5mhHnn2xWJVFjB6Idfnk8sT0FPMjeLBrcelLpP+buaUUYcSUsypIqKL05S5rE2+wV6eYq5cRcRn4Wmq5+u+Ns12Hi7DMAJZPD5/B0JDnwicJaJ6ORMV9L0EQkPpX42wyiMbf/8/phjlwjCi9UGrIQIXhaWtKO4oKlbkuTHmS0SV8w3R2i16ihkoGiBDJGeaJZyg92dPoq8sOwp0inkLpxJCO6A2SF1ayyuUvisqznCPob8/V2rWAzF+SYVSX1HRAKmU3uK67kdvF6QY/db6+rUSKjerphRw11QYDrUTwhlZ+ZanV6+u57w/t3//7o23Tvev1wr5ZELaiJAp2H5RTOTgMIz35zWfAeJzzvREaPR2QeNkTzGxn8ULHuNxSC+N8/eUf8AipWUAYtAcNFq4llIehzSJYQppp0SuZUMOpPcxxvszVLDeC9pHlGE7ZorZyUKSWl65iY44eorJM0+kdQQS53FoIOV6v/p2hAAJJEbl1pGc/SxZFBp2cCIRKjcppZkni8JCahWBRKjcjEROYzF2aoYsCg1DJEpW5dbDZNbcQRWyDghkUVgoOtirQbhWYfAy8FlLD6polRQYhyaLQoKXRyCxKrd9pJh5owfJ1u7uRXoqIQPbUGRRSNhFINGuVePAFKObCl/vpyv3h+v+Zlo4DkEWhYNrBBLvWnWBFDO7QXfWQBm+OajDcR5AkEUhwMNKI961qlFCijFhTLvF3El2QceBLAoHGwgkwrXKSDZttgJlZe2sYyf9dc9wHJEsCgVVBBIn50G6J6jcnF3muTvbx1lbOw7SsUANlQEPEw7MnHeJV/XZ7pWaT2C8O9yzk5Z/jps7Dkw+VBQccmrgv3JeCqq4cz5/EtzfGtcyknNcv2p6ioEjjkys9oE781U8JkQj72gj7zsO0vES64FmXwcSp8VVMZj9xA9rRKeZHJhdAPmrV7uBgSSfszgOfnKImXd+cAH0bbOkFuQWAok6l+mB7TH/5tu7N9ae3OyV7KltYmGfkXYZbJjFAwmnZEEBVdxiAug0Tu/WuKppFEctO1Tu9x2JDn5Ga7LHns/E38AwwQtknNao2DAekuk6mASJsj9wh0Ai7wC/0f+zmUKGZZd6m6YvbsUMvnjOLbNNCKQOj60Se14p7ZTRcQhbUqUVVZz1YTVlRFOxgmt2Sn9gwAgkfFJPKSCfxKBliG2eHCd9cTNRoWjBFaOqrDFSwTmu/7R3pk2JA0EYLlZyAYrKtchRcgoIuFyiSAElongV///fbGJCNSHHTC8ZjOy8n63Cavphpnv6aJqOO2NHvioq2xh9kolciXBvrUGogZgGiNG5R93xcIEompupZUghYBwnWl7cu4W8Kktu8wJ2jwfG3oAEXrx1HmRTaT2FQO04Ad1xJEW+u3lpOIUwYBgv20NBSQCJ1dTwKy33RJ2YA8cJao5z2qvV7a5qMbhSM+nd6lQ9AwnC2pZdCiHVlBGJOb3BNqg7zmCUPN+OLKELhE3V88SzQmRy9PPRHhvT5CEUJDuOcY73n35HtrZCBRjWC81lgcWkY5inviNVgc2f4/TD+gJ4lRJDbiTt/JifTVtAYrgcHahKAFVIx8m8le6fnxJQ98nmsC6LbObYEFMJxTVVKOMYy0ohvEYMvUOp4DlIsKGcGPRHnmM9eqrAcTRpB79bgF/ZcZKD9yDBhnKqrfaNUg5PFfwho1kOkSmAxMAyE4iUCVQN07KCogpV6IZ/XGqzAAn2cIvpR3AaElXvBKpQ8b25CiV3k0eCdCKxWY4ARQyZxTn9sxaGKhD5sE5czAoRDEgVPEj4tfHR4TyL+K4KwyqCKsfD+nIFer2QFblfR+yMYAcSmOYraZm57tKfnpE6gSrsEOyFLAmCGM7R8rRkCRIcIesUwhQiQSqq4pZKGfQ4KLiqaZdDZTan+gciPQCJoTZTCDP9Qk/9UPJAoIrusD470TKIGtZyr7Uia+E9SOQUghKO46iqVSxUYRtfutoTsTFj+PS6QZwf4DFIiEjwtIKj6tqgyjAOTT9xxDrt1djrfJckfBd9MkgMHOffqZrRUhXY7sRJrPNZmtOoPE1f3fdwIUBiRlUJR1XUShW5nusDfjIMnqJvzh97j5pB5RuquhaqyEtxHqFWweBJUpovjt3gWJAYUlV9KBQ9pAo2VlhLRoGn8oetWw730Q2OST7FcxiqWrWpDVVwWMec67mAp9ixNbmYUr6eBb5dZqp6788oqjIWqiCt6rLtEXjazvHlp6Jw9O0OY0/VsI2gqjMfmakyziTrYW0fxsmT+qa7tAdiyD92sVClPc02EFR9blD1S3tukcKf5oWyQJKFJ7m8fpRpxRKKFPQFR55RddxdF6CpUv2gebbdpeoW4MrxynjY16r0VXfxn12sVKWxVA30ndnhP9kVXQuZUXkiSHpDkG/NYkdV6gVFVXmQnrbNp1sFSHL8sCP9N8rXdrGhKgb1Z3gtSZFyQJf/rWIOHYznx3EbrmPobXD+Omc8p6oJVCGUrwpHB2cXK1V9NFWjQ3QYk3E2qFpimiMO1GGcqLqkS2sX76QDdhgHqihqpbPNQwbJjarHV1e7JP4bu9hQdeNI1WXVl6EPQwFVQWeqOiNZCvr7jg9iR9XJxExV6zYqCj6PfTwSuZC8ebvoZo/znWUylZFFIeizzMretUGVah1Niij5PlTei+AnJxQSBL1QlpvFZBxdPyGBsF/9rPwBFxcXFxcXFxcXFxcXFxcXF9eu+gs/smvry3b92wAAAABJRU5ErkJggg==", (int) dp2px(getShakeIconWidthDp()), (int) dp2px(getShakeIconHeightDp()));
    }

    private AnimatorLayer createSubTitleLayer() {
        TextLayer textLayer = this.mSubTitleTextLayer;
        if (textLayer == null) {
            TextLayer textLayer2 = new TextLayer(this.mSubTitleText, -1, dp2px(this.mSubTitleTextSizeDp));
            this.mSubTitleTextLayer = textLayer2;
            textLayer2.setTextAlign(Paint.Align.CENTER);
            this.mSubTitleTextLayer.setShadowLayer(1.0f, 1.0f, 1.0f, Utils.buildColorFromARGB(0.2f, 0.0f, 0.0f, 0.0f));
            TextLayer textLayer3 = this.mSubTitleTextLayer;
            textLayer3.setAnimator(new KeepAnimator(textLayer3));
        } else {
            textLayer.reset();
        }
        this.mSubTitleTextLayer.setX(getScreenWidth() / 2.0f);
        this.mSubTitleTextLayer.setY(dp2px(getShakeIconCenterYDp() + getShakeCircleBgRadiusDp() + SHAKE_ICON_TITLE_PADDING_DP + 4.0f) + getTitleTextPaintHeight() + Utils.getTextPaintBaselineToTop(Utils.dp2px(this.mSubTitleTextSizeDp)));
        return this.mSubTitleTextLayer;
    }

    private AnimatorLayer createTitleLayer() {
        TextLayer textLayer = this.mTitleTextLayer;
        if (textLayer == null) {
            TextLayer textLayer2 = new TextLayer(this.mTitleText, -1, dp2px(this.mTitleTextSizeDp));
            this.mTitleTextLayer = textLayer2;
            textLayer2.setTextAlign(Paint.Align.CENTER);
            this.mTitleTextLayer.setShadowLayer(1.0f, 1.0f, 1.0f, Utils.buildColorFromARGB(0.2f, 0.0f, 0.0f, 0.0f));
            this.mTitleTextLayer.setTextBold(true);
            TextLayer textLayer3 = this.mTitleTextLayer;
            textLayer3.setAnimator(new KeepAnimator(textLayer3));
        } else {
            textLayer.reset();
        }
        this.mTitleTextLayer.setX(getScreenWidth() / 2.0f);
        this.mTitleTextLayer.setY(dp2px(getShakeIconCenterYDp() + getShakeCircleBgRadiusDp() + SHAKE_ICON_TITLE_PADDING_DP) + Utils.getTextPaintBaselineToTop(Utils.dp2px(this.mTitleTextSizeDp)));
        return this.mTitleTextLayer;
    }

    private float dp2px(float f16) {
        return Utils.dp2px(f16);
    }

    private float getIconX() {
        return (getScreenWidth() / 2) - (dp2px(getShakeIconWidthDp()) / 2.0f);
    }

    private float getIconY() {
        return dp2px(getShakeIconCenterYDp()) - (dp2px(getShakeIconHeightDp()) / 2.0f);
    }

    private int getScreenWidth() {
        return getWidth();
    }

    private int getShakeCircleBgColor() {
        if (!TextUtils.isEmpty(this.mShakeCircleBgColor)) {
            try {
                return Color.parseColor(this.mShakeCircleBgColor);
            } catch (Throwable unused) {
                return 0;
            }
        }
        return 0;
    }

    private float getShakeCircleBgRadiusDp() {
        float f16 = this.mShakeCircleBgRadiusDp;
        if (f16 > 0.0f) {
            return f16;
        }
        return 50.0f;
    }

    private float getShakeIconHeightDp() {
        float f16 = this.mShakeIconHeightDp;
        if (f16 > 0.0f) {
            return f16;
        }
        return 70.0f;
    }

    private float getShakeIconWidthDp() {
        float f16 = this.mShakeIconWidthDp;
        if (f16 > 0.0f) {
            return f16;
        }
        return 70.0f;
    }

    private String getShakeValidValues() {
        List<Integer> list = this.mShakeValidValues;
        if (list != null) {
            return list.toString();
        }
        return "";
    }

    private float getSubTitleTextPaintHeight() {
        return Utils.getTextPaintHeight(Utils.dp2px(this.mSubTitleTextSizeDp));
    }

    private float getTitleTextPaintHeight() {
        return Utils.getTextPaintHeight(Utils.dp2px(this.mTitleTextSizeDp));
    }

    private void initView(boolean z16) {
        if (z16) {
            addView(createBottomShadowView());
        }
        addView(createShakeAnimView());
        addView(createDebugView());
    }

    private boolean isTouchDownInShakeCircle(float f16, float f17) {
        if (getShakeAnimViewCenterPoint() == null || ((float) Math.sqrt(Math.pow(Math.abs(r0.x - f16), 2.0d) + Math.pow(Math.abs(r0.y - f17), 2.0d))) > Utils.dp2px(getShakeCircleBgRadiusDp())) {
            return false;
        }
        return true;
    }

    private void reset() {
        this.mMaxShakeValue = 0.0d;
        this.mIsStop = false;
        List<Integer> list = this.mShakeValidValues;
        if (list != null) {
            list.clear();
        }
    }

    private void startEndingAnimation() {
        if (this.mShakeIconBitmap == null) {
            this.mShakeIconBitmap = createShakeIconBitmap();
        }
        AnimatorView animatorView = this.mShakeAnimView;
        if (animatorView == null) {
            return;
        }
        animatorView.clearLayers();
        this.mShakeAnimView.clearCanvas();
        GroupLayer groupLayer = new GroupLayer(new CircleShapeLayer(getScreenWidth() / 2, dp2px(getShakeIconCenterYDp()), dp2px(getShakeCircleBgRadiusDp()), getShakeCircleBgColor()), new BitmapLayer(this.mShakeIconBitmap).setX(getIconX()).setY(getIconY()).setWidth((int) dp2px(getShakeIconWidthDp())).setHeight((int) dp2px(getShakeIconHeightDp())), createTitleLayer(), createSubTitleLayer());
        groupLayer.setAnimator(createEndingAnimator(groupLayer));
        this.mShakeAnimView.addLayer(groupLayer);
        this.mShakeAnimView.startAnimation();
        Logger.d(TAG, "startEndingAnimation");
    }

    private void startShakeAnimation() {
        AnimatorView animatorView;
        GroupLayer groupLayer;
        if (!this.mIsStop && (animatorView = this.mShakeAnimView) != null) {
            animatorView.clearLayers();
            AnimatorLayer shakeIconAnimatorLayer = OlympicShakeAnimationHelper.getShakeIconAnimatorLayer(createShakeIconBitmap(), new OlympicShakeAnimationHelper.IconParams(getIconX(), getIconY(), Utils.dp2px(getShakeIconWidthDp()), Utils.dp2px(getShakeIconHeightDp())), this);
            AnimatorLayer createTitleLayer = createTitleLayer();
            AnimatorLayer createSubTitleLayer = createSubTitleLayer();
            if (this.mShakeCircleBgShowAlways) {
                CircleShapeLayer circleShapeLayer = new CircleShapeLayer(getScreenWidth() / 2, dp2px(getShakeIconCenterYDp()), dp2px(getShakeCircleBgRadiusDp()), getShakeCircleBgColor());
                circleShapeLayer.setAnimator(new KeepAnimator(circleShapeLayer));
                groupLayer = new GroupLayer(circleShapeLayer, shakeIconAnimatorLayer, createTitleLayer, createSubTitleLayer);
            } else {
                groupLayer = new GroupLayer(shakeIconAnimatorLayer, createTitleLayer, createSubTitleLayer);
            }
            this.mShakeAnimView.addLayer(groupLayer);
            this.mShakeAnimView.startAnimation();
        }
    }

    private void updateViewHeight() {
        changeViewHeight(this.mShakeAnimView, dp2px(getShakeViewBottomHeightDp()));
        changeViewHeight(this.mBottomShadowView, dp2px(getShakeViewBottomHeightDp()));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i3;
        OlympicShakeListener olympicShakeListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this, (Object) motionEvent)).booleanValue();
        }
        AnimatorView animatorView = this.mShakeAnimView;
        if (animatorView != null && animatorView.isUserStarted() && !this.mIsStop && ((i3 = this.mInteractiveMode) == 2 || i3 == 3)) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    if (this.mIsTouchDownInShakeCircle && (olympicShakeListener = this.mShakeListener) != null) {
                        olympicShakeListener.onShakeIconClick();
                    }
                    this.mIsTouchDownInShakeCircle = false;
                }
            } else if (isTouchDownInShakeCircle(motionEvent.getX(), motionEvent.getY())) {
                this.mIsTouchDownInShakeCircle = true;
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public PointF getShakeAnimViewCenterPoint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (PointF) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        if (this.mShakeAnimView == null) {
            return null;
        }
        return new PointF(getScreenWidth() / 2.0f, (getHeight() - dp2px(getShakeViewBottomHeightDp() - getShakeIconCenterYDp())) - getPaddingBottom());
    }

    public float getShakeIconCenterYDp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Float) iPatchRedirector.redirect((short) 26, (Object) this)).floatValue();
        }
        float f16 = this.mShakeIconCenterYDp;
        if (f16 > 0.0f) {
            return f16;
        }
        return getShakeCircleBgRadiusDp() + 36.0f;
    }

    public float getShakeViewBottomHeightDp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Float) iPatchRedirector.redirect((short) 25, (Object) this)).floatValue();
        }
        float f16 = this.mBottomPaddingDp;
        if (f16 > 0.0f) {
            return f16 + Utils.px2dp(getSubTitleTextPaintHeight()) + 4.0f + Utils.px2dp(getTitleTextPaintHeight()) + SHAKE_ICON_TITLE_PADDING_DP + (getShakeCircleBgRadiusDp() * 2.0f) + 36.0f;
        }
        float f17 = this.mShakeViewBottomHeightDp;
        if (f17 > 0.0f) {
            return f17;
        }
        return 240.0f;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
    public void onAnimationFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.OnShakeListener
    public void onShakeComplete(double d16) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, Double.valueOf(d16));
            return;
        }
        stop(false);
        OlympicShakeListener olympicShakeListener = this.mShakeListener;
        if (olympicShakeListener != null) {
            olympicShakeListener.onShakeComplete(d16);
        }
        startEndingAnimation();
        if (this.mMaxShakeValue < d16) {
            this.mMaxShakeValue = d16;
        }
        if (this.mIsDebug && (textView = this.mDebugView) != null) {
            textView.setText(String.format(Locale.getDefault(), "\u6447\u52a8\u6210\u529f\uff1a%d \n \u5cf0\u503c\uff1a%d \n \u6709\u6548\u6447\u52a8\uff1a%s", Integer.valueOf((int) (d16 * 100.0d)), Integer.valueOf((int) (this.mMaxShakeValue * 100.0d)), getShakeValidValues()));
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.OnShakeListener
    public void onShaking(double d16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, Double.valueOf(d16), Integer.valueOf(i3));
            return;
        }
        OlympicShakeListener olympicShakeListener = this.mShakeListener;
        if (olympicShakeListener != null) {
            olympicShakeListener.onShaking(d16, i3);
        }
        if (this.mMaxShakeValue < d16) {
            this.mMaxShakeValue = d16;
        }
        if (this.mIsDebug && this.mDebugView != null) {
            if (d16 >= this.mShakeThreshold) {
                addShakeValidValue(d16);
            }
            this.mDebugView.setText(String.format(Locale.getDefault(), "\u6447\u52a8\u4e2d\uff1a%d \n \u5cf0\u503c\uff1a%d \n \u5df2\u6447\u52a8\u6b21\u6570\uff1a%d \n \u6709\u6548\u6447\u52a8\uff1a%s", Integer.valueOf((int) (d16 * 100.0d)), Integer.valueOf((int) (this.mMaxShakeValue * 100.0d)), Integer.valueOf(i3), getShakeValidValues()));
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        Logger.i(TAG, "onSizeChanged w:" + i3 + ", h:" + i16 + ", oldw:" + i17 + ", oldh:" + i18);
        if (this.mShakeAnimView.isUserStarted()) {
            startShakeAnimation();
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        Logger.i(TAG, "pause");
        AnimatorView animatorView = this.mShakeAnimView;
        if (animatorView != null) {
            animatorView.pauseAnimation();
        }
        ShakeSensor shakeSensor = this.mShakeSensor;
        if (shakeSensor != null) {
            shakeSensor.pause();
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        Logger.i(TAG, "resume");
        AnimatorView animatorView = this.mShakeAnimView;
        if (animatorView != null) {
            animatorView.resumeAnimation();
        }
        ShakeSensor shakeSensor = this.mShakeSensor;
        if (shakeSensor != null) {
            shakeSensor.resume();
        }
    }

    public void setBottomPaddingDp(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16));
        } else {
            this.mBottomPaddingDp = f16;
            updateViewHeight();
        }
    }

    public void setDebug(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
            return;
        }
        this.mIsDebug = z16;
        TextView textView = this.mDebugView;
        if (textView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
        Logger.setDebug(z16);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateConfig
    public void setEnableFrameRate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
            return;
        }
        AnimatorView animatorView = this.mShakeAnimView;
        if (animatorView != null) {
            animatorView.setEnableFrameRate(z16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateConfig
    public void setFrameRateListener(IFrameRateListener iFrameRateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) iFrameRateListener);
            return;
        }
        AnimatorView animatorView = this.mShakeAnimView;
        if (animatorView != null) {
            animatorView.setFrameRateListener(iFrameRateListener);
        }
    }

    public void setInteractiveMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else {
            this.mInteractiveMode = i3;
        }
    }

    public void setOnDebugShakeListener(OnDebugShakeListener onDebugShakeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) onDebugShakeListener);
        } else {
            this.mDebugShakeListener = onDebugShakeListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setSensorEventsDeliveredOnMainThread(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
        } else {
            this.mSensorEventsDeliveredOnMainThread = z16;
        }
    }

    public void setShakeCircleBgColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            this.mShakeCircleBgColor = str;
        }
    }

    public void setShakeCircleBgRadiusDp(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Float.valueOf(f16));
        } else {
            this.mShakeCircleBgRadiusDp = f16;
        }
    }

    public void setShakeCircleBgShowAlways(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.mShakeCircleBgShowAlways = z16;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setShakeDirectCombine(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) iArr);
        } else {
            this.mShakeDirectcombine = iArr;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setShakeFactor(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        this.mShakeFactorX = f16;
        this.mShakeFactorY = f17;
        this.mShakeFactorZ = f18;
    }

    public void setShakeIconCenterYDp(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Float.valueOf(f16));
        } else {
            this.mShakeIconCenterYDp = f16;
        }
    }

    public void setShakeIconSizeDp(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.mShakeIconWidthDp = f16;
            this.mShakeIconHeightDp = f17;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setShakeSampleRate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.mShakeSampleRate = i3;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setShakeTimeDuration(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.mShakeDuration = i3;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setShakeValue(float f16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16), Integer.valueOf(i3));
        } else {
            this.mShakeThreshold = f16;
            this.mShakeValidCount = i3;
        }
    }

    public void setShakeViewBottomHeightDp(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16));
        } else {
            this.mShakeViewBottomHeightDp = f16;
            updateViewHeight();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateConfig
    public void setShowFrameRate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
            return;
        }
        AnimatorView animatorView = this.mShakeAnimView;
        if (animatorView != null) {
            animatorView.setShowFrameRate(z16);
        }
    }

    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        this.mSubTitleText = str;
        TextLayer textLayer = this.mSubTitleTextLayer;
        if (textLayer != null) {
            textLayer.setText(str);
        }
    }

    public void setSubTitleTextSizeDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        if (i3 > 0) {
            if (this.mSubTitleTextSizeDp != i3) {
                this.mSubTitleTextSizeDp = i3;
                updateViewHeight();
                return;
            }
            return;
        }
        Logger.w(TAG, "Set sub title text size with an invalid value: " + i3);
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        this.mTitleText = str;
        TextLayer textLayer = this.mTitleTextLayer;
        if (textLayer != null) {
            textLayer.setText(str);
        }
    }

    public void setTitleTextSizeDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (i3 > 0) {
            if (this.mTitleTextSizeDp != i3) {
                this.mTitleTextSizeDp = i3;
                updateViewHeight();
                return;
            }
            return;
        }
        Logger.w(TAG, "Set title text size with an invalid value: " + i3);
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        Logger.i(TAG, "start");
        reset();
        startShakeAnimation();
        int i3 = this.mInteractiveMode;
        if (i3 == 1 || i3 == 3) {
            ShakeSensor shakeSensor = this.mShakeSensor;
            if (shakeSensor == null) {
                shakeSensor = new ShakeSensor(getContext());
                shakeSensor.setShakeListener(this);
                shakeSensor.setDebugShakeListener(new OnDebugShakeListener() { // from class: com.tencent.ams.fusion.widget.olympicshake.OlympicShakeView.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OlympicShakeView.this);
                        }
                    }

                    @Override // com.tencent.ams.fusion.widget.olympicshake.OnDebugShakeListener
                    public void onShakeSensorChanged(double[] dArr) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dArr);
                        } else if (OlympicShakeView.this.mDebugShakeListener != null) {
                            OlympicShakeView.this.mDebugShakeListener.onShakeSensorChanged(dArr);
                        }
                    }
                });
                this.mShakeSensor = shakeSensor;
            }
            shakeSensor.reset();
            shakeSensor.setSensorEventsDeliveredOnMainThread(this.mSensorEventsDeliveredOnMainThread);
            shakeSensor.setShakeValue(this.mShakeThreshold, this.mShakeValidCount);
            shakeSensor.setShakeFactor(this.mShakeFactorX, this.mShakeFactorY, this.mShakeFactorZ);
            shakeSensor.setShakeDirectCombine(this.mShakeDirectcombine);
            shakeSensor.setShakeTimeDuration(this.mShakeDuration);
            shakeSensor.setShakeSampleRate(this.mShakeSampleRate);
            shakeSensor.register();
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 33)) {
            stop(true);
        } else {
            iPatchRedirector.redirect((short) 33, (Object) this);
        }
    }

    public OlympicShakeView(Context context, boolean z16) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(z16));
            return;
        }
        this.mSensorEventsDeliveredOnMainThread = true;
        this.mShakeThreshold = 3.0f;
        this.mShakeValidCount = 60;
        this.mShakeFactorX = 1.0f;
        this.mShakeFactorY = 1.0f;
        this.mShakeFactorZ = 0.5f;
        this.mShakeDuration = 0;
        this.mShakeSampleRate = 60;
        this.mShakeDirectcombine = null;
        this.mTitleTextSizeDp = 18;
        this.mSubTitleTextSizeDp = 14;
        this.mInteractiveMode = 3;
        Logger.setDebug(Utils.isInDebug(context));
        initView(z16);
    }

    private void stop(boolean z16) {
        Logger.i(TAG, "stop clearCanvas:" + z16);
        this.mIsStop = true;
        AnimatorView animatorView = this.mShakeAnimView;
        if (animatorView != null) {
            animatorView.stopAnimation(z16, true);
        }
        ShakeSensor shakeSensor = this.mShakeSensor;
        if (shakeSensor != null) {
            shakeSensor.unregister();
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setOnShakeListener(OlympicShakeListener olympicShakeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
            this.mShakeListener = olympicShakeListener;
        } else {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) olympicShakeListener);
        }
    }
}
