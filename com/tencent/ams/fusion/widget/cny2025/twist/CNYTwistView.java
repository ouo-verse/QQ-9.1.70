package com.tencent.ams.fusion.widget.cny2025.twist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.AnimatorView;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.ProgressAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.DrawableLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.ams.fusion.widget.apng.APNGDrawable;
import com.tencent.ams.fusion.widget.apng.frame.animation.Animatable2;
import com.tencent.ams.fusion.widget.apng.frame.animation.loader.FileLoader;
import com.tencent.ams.fusion.widget.cny2025.twist.CNYTwistAnimationHelper;
import com.tencent.ams.fusion.widget.twist.TwistRotationHandlerV2;
import com.tencent.ams.fusion.widget.utils.HighRateRotationSensor;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.RotationSensor;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class CNYTwistView extends FrameLayout implements ICNYTwistView {
    static IPatchRedirector $redirector_ = null;
    private static final int APNG_HEIGHT = 132;
    private static final int APNG_MARGIN_BOTTOM = 115;
    private static final int APNG_MARGIN_LEFT_ON_TO_LEFT = 114;
    private static final int APNG_MARGIN_LEFT_ON_TO_RIGHT = 129;
    private static final int APNG_WIDTH = 132;
    private static final int BG_HEIGHT = 240;
    private static final int DEFAULT_BG_SHADER_COLOR_END;
    private static final int DEFAULT_BG_SHADER_COLOR_START;
    private static final String DEFAULT_REVERSE_TITLE = "\u6446\u6b63\u624b\u673a\u8fdb\u884c\u8df3\u8f6c";
    private static final String DEFAULT_SUBTITLE = "\u8df3\u8f6c\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528";
    private static final String DEFAULT_TITLE = "\u626d\u8f6c\u624b\u673a";
    private static final int GUIDE_ANIMATION_REPEAT_COUNT = 5;
    private static final int ICON_HEIGHT = 92;
    private static final int ICON_MARGIN_BOTTOM = 128;
    private static final int ICON_WIDTH = 92;
    private static final int MARGIN_BETWEEN_ICONS = 4;
    private static final int MARGIN_BOTTOM_SUBTITLE_PX = 70;
    private static final int MARGIN_BOTTOM_TITLE_PX = 94;
    private static final int SUBTITLE_TEXT_COLOR;
    private static final int SUBTITLE_TEXT_SIZE = 14;
    private static final String TAG = "CNYTwistView";
    private static final int TITLE_TEXT_COLOR = -1;
    private static final int TITLE_TEXT_SIZE = 18;
    private final AnimatorView mAnimatorView;
    private PathShapeLayer mBgShaderLayer;
    private String mCollisionApngPath;
    private DrawableLayer mDrawableLayer;
    private volatile boolean mHasPause;
    private volatile boolean mHasSetProgressAnimator;
    private volatile boolean mHasStart;
    private int mIconY;
    private ICNYTwistViewListener mInteractListener;
    private volatile boolean mIsInteractStart;
    private volatile boolean mIsInteractSuccess;
    private volatile boolean mIsUserStarted;
    private CNYTwistArrowLayer mLeftArrowLayer;
    private ProgressAnimator mLeftArrowProgressAnimator;
    private Bitmap mLeftIconBitmap;
    private CNYBitmapLayer mLeftIconLayer;
    private int mLeftIconX;
    private volatile boolean mNeedCallCollisionApngAnimationEnd;
    private float mReverseAngle;
    private String mReverseTitle;
    private CNYTwistArrowLayer mRightArrowLayer;
    private ProgressAnimator mRightArrowProgressAnimator;
    private Bitmap mRightIconBitmap;
    private CNYBitmapLayer mRightIconLayer;
    private int mRightIconX;
    private final RotationSensor mSensor;
    private String mSubtitle;
    private TextLayer mSubtitleTextLayer;
    private String mTitle;
    private TextLayer mTitleTextLayer;
    TwistRotationHandlerV2.TwistCallbackV2 mTwistCallback;
    private final TwistRotationHandlerV2 mTwistRotationHandler;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54195);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
            return;
        }
        SUBTITLE_TEXT_COLOR = Color.parseColor("#CCFFFFFF");
        DEFAULT_BG_SHADER_COLOR_START = Color.parseColor("#00000000");
        DEFAULT_BG_SHADER_COLOR_END = Color.parseColor("#80000000");
    }

    public CNYTwistView(@NonNull Context context) {
        this(context, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callApngAnimationEnd() {
        RotationSensor rotationSensor = this.mSensor;
        if (rotationSensor == null) {
            Logger.i(TAG, "callApngAnimationEnd, sensor is null");
            return;
        }
        Handler handler = rotationSensor.getHandler();
        if (handler == null) {
            Logger.i(TAG, "callApngAnimationEnd, the handler of sensor is null");
        } else {
            handler.post(new Runnable() { // from class: com.tencent.ams.fusion.widget.cny2025.twist.CNYTwistView.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) CNYTwistView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!CNYTwistView.this.mIsInteractSuccess) {
                        CNYTwistView.this.mNeedCallCollisionApngAnimationEnd = true;
                        return;
                    }
                    ICNYTwistViewListener iCNYTwistViewListener = CNYTwistView.this.mInteractListener;
                    if (iCNYTwistViewListener != null) {
                        CNYTwistView.this.mNeedCallCollisionApngAnimationEnd = false;
                        iCNYTwistViewListener.onInteractSuccessAnimationEnd();
                    } else {
                        Logger.i(CNYTwistView.TAG, "onAnimationEnd, mInteractListener is null");
                    }
                }
            });
        }
    }

    private void createArrowGuideAnimation() {
        CNYTwistArrowLayer cNYTwistArrowLayer = this.mLeftArrowLayer;
        if (cNYTwistArrowLayer == null) {
            Logger.e(TAG, "createArrowGuideAnimation, leftArrowLayer is null, just return");
            return;
        }
        CNYTwistArrowLayer cNYTwistArrowLayer2 = this.mRightArrowLayer;
        if (cNYTwistArrowLayer2 == null) {
            Logger.e(TAG, "createArrowGuideAnimation, rightArrowLayer is null, just return");
        } else {
            CNYTwistAnimationHelper.createArrowsAnimation(cNYTwistArrowLayer, new CNYTwistAnimationHelper.ArrowAnimationConfig[]{new CNYTwistAnimationHelper.ArrowAnimationConfig(0.0f, 0.0f, 1083L), new CNYTwistAnimationHelper.ArrowAnimationConfig(0.0f, 1.0f, 500L), new CNYTwistAnimationHelper.ArrowAnimationConfig(1.0f, 0.0f, 500L), new CNYTwistAnimationHelper.ArrowAnimationConfig(0.0f, 0.0f, 83L)}, cNYTwistArrowLayer2, new CNYTwistAnimationHelper.ArrowAnimationConfig[]{new CNYTwistAnimationHelper.ArrowAnimationConfig(0.0f, 1.0f, 500L), new CNYTwistAnimationHelper.ArrowAnimationConfig(1.0f, 0.0f, 500L), new CNYTwistAnimationHelper.ArrowAnimationConfig(0.0f, 0.0f, 1166L)}, 5);
        }
    }

    private PathShapeLayer createBgShaderLayer() {
        int relativeSize = getRelativeSize(240);
        int[] iArr = {DEFAULT_BG_SHADER_COLOR_START, DEFAULT_BG_SHADER_COLOR_END};
        int width = getWidth();
        int height = getHeight();
        float f16 = height - relativeSize;
        float f17 = height;
        LinearGradient linearGradient = new LinearGradient(0.0f, f16, 0.0f, f17, iArr, (float[]) null, Shader.TileMode.MIRROR);
        Path path = new Path();
        path.moveTo(0.0f, f16);
        path.lineTo(0.0f, f17);
        float f18 = width;
        path.lineTo(f18, f17);
        path.lineTo(f18, f16);
        path.lineTo(0.0f, f16);
        PathShapeLayer pathShapeLayer = new PathShapeLayer(path, linearGradient, Paint.Style.FILL);
        pathShapeLayer.setAnimator(new KeepAnimator(pathShapeLayer));
        return pathShapeLayer;
    }

    private void createGuideAnimation() {
        synchronized (this.mAnimatorView) {
            this.mHasSetProgressAnimator = false;
            createIconsGuideAnimation();
            createArrowGuideAnimation();
        }
    }

    private void createIconsGuideAnimation() {
        CNYBitmapLayer cNYBitmapLayer = this.mLeftIconLayer;
        if (cNYBitmapLayer == null) {
            Logger.e(TAG, "createIconsGuideAnimation, leftIconLayer is null, just return");
            return;
        }
        CNYBitmapLayer cNYBitmapLayer2 = this.mRightIconLayer;
        if (cNYBitmapLayer2 == null) {
            Logger.e(TAG, "createIconsGuideAnimation, rightIconLayer is null, just return");
            return;
        }
        int relativeSize = this.mLeftIconX + getRelativeSize(15);
        int relativeSize2 = this.mLeftIconX + getRelativeSize(35);
        int relativeSize3 = this.mIconY - getRelativeSize(9);
        int relativeSize4 = this.mRightIconX - getRelativeSize(35);
        int relativeSize5 = this.mRightIconX - getRelativeSize(15);
        float f16 = this.mLeftIconX;
        float f17 = relativeSize;
        int i3 = this.mIconY;
        float f18 = this.mLeftIconX;
        int i16 = this.mIconY;
        int i17 = this.mLeftIconX;
        float f19 = i17;
        float f26 = i17;
        int i18 = this.mIconY;
        float f27 = relativeSize2;
        float f28 = relativeSize3;
        int i19 = this.mLeftIconX;
        int i26 = this.mIconY;
        CNYTwistAnimationHelper.IconAnimationConfig[] iconAnimationConfigArr = {new CNYTwistAnimationHelper.IconAnimationConfig(f16, f17, i3, i3, 0.0f, 5.0f, 1.0d, 1.0d, 500L), new CNYTwistAnimationHelper.IconAnimationConfig(f17, f18, i16, i16, 5.0f, 0.0f, 1.0d, 1.0d, 500L), new CNYTwistAnimationHelper.IconAnimationConfig(f19, f26, i18, i18, 0.0f, 0.0f, 1.0d, 1.0d, 83L), new CNYTwistAnimationHelper.IconAnimationConfig(this.mLeftIconX, f27, this.mIconY, f28, 0.0f, 10.0f, 1.0d, 1.1d, 500L), new CNYTwistAnimationHelper.IconAnimationConfig(f27, this.mLeftIconX, f28, this.mIconY, 10.0f, 0.0f, 1.1d, 1.0d, 500L), new CNYTwistAnimationHelper.IconAnimationConfig(i19, i19, i26, i26, 0.0f, 0.0f, 1.0d, 1.0d, 83L)};
        float f29 = relativeSize4;
        int i27 = this.mRightIconX;
        int i28 = this.mIconY;
        float f36 = this.mRightIconX;
        float f37 = relativeSize5;
        int i29 = this.mIconY;
        float f38 = this.mRightIconX;
        int i36 = this.mIconY;
        int i37 = this.mRightIconX;
        float f39 = i37;
        float f46 = i37;
        int i38 = this.mIconY;
        CNYTwistAnimationHelper.createIconsAnimation(cNYBitmapLayer, iconAnimationConfigArr, cNYBitmapLayer2, new CNYTwistAnimationHelper.IconAnimationConfig[]{new CNYTwistAnimationHelper.IconAnimationConfig(this.mRightIconX, f29, this.mIconY, f28, 0.0f, -10.0f, 1.0d, 1.1d, 500L), new CNYTwistAnimationHelper.IconAnimationConfig(f29, this.mRightIconX, f28, this.mIconY, -10.0f, 0.0f, 1.1d, 1.0d, 500L), new CNYTwistAnimationHelper.IconAnimationConfig(i27, i27, i28, i28, 0.0f, 0.0f, 1.0d, 1.0d, 83L), new CNYTwistAnimationHelper.IconAnimationConfig(f36, f37, i29, i29, 0.0f, -5.0f, 1.0d, 1.0d, 500L), new CNYTwistAnimationHelper.IconAnimationConfig(f37, f38, i36, i36, -5.0f, 0.0f, 1.0d, 1.0d, 500L), new CNYTwistAnimationHelper.IconAnimationConfig(f39, f46, i38, i38, 0.0f, 0.0f, 1.0d, 1.0d, 83L)}, 5);
    }

    private CNYTwistArrowLayer createLeftArrowLayer() {
        Context context = getContext();
        if (context == null) {
            Logger.e(TAG, "createLeftArrowLayer, context is null, return null");
            return null;
        }
        CNYTwistArrowLayer cNYTwistArrowLayer = new CNYTwistArrowLayer(context, CNYTwistArrowLayer.LEFT_ARROW_BASE64, CNYTwistArrowLayer.FILL_LEFT_ARROW_BASE64, getWidth(), getHeight(), -118.0f, 13.0f);
        cNYTwistArrowLayer.setX(getRelativeSize(-4));
        cNYTwistArrowLayer.setY(getHeight() - getRelativeSize(181));
        this.mLeftArrowProgressAnimator = new ProgressAnimator(cNYTwistArrowLayer, 1.0f, 1.0f);
        return cNYTwistArrowLayer;
    }

    private CNYTwistArrowLayer createRightArrowLayer() {
        Context context = getContext();
        if (context == null) {
            Logger.e(TAG, "createRightIconLayer, context is null, return null");
            return null;
        }
        CNYTwistArrowLayer cNYTwistArrowLayer = new CNYTwistArrowLayer(context, CNYTwistArrowLayer.RIGHT_ARROW_BASE64, CNYTwistArrowLayer.FILL_RIGHT_ARROW_BASE64, getWidth(), getHeight(), -62.0f, -13.0f);
        cNYTwistArrowLayer.setX(getWidth() - getRelativeSize(82));
        cNYTwistArrowLayer.setY(getHeight() - getRelativeSize(181));
        this.mRightArrowProgressAnimator = new ProgressAnimator(cNYTwistArrowLayer, 1.0f, 1.0f);
        return cNYTwistArrowLayer;
    }

    private TextLayer createSubtitleLayer() {
        return createTextLayer(this.mSubtitle, SUBTITLE_TEXT_COLOR, getRelativeSize(14), getWidth() / 2.0f, getHeight() - getRelativeSize(70), false);
    }

    private TextLayer createTextLayer(String str, int i3, float f16, float f17, float f18, boolean z16) {
        Logger.i(TAG, "createTextLayer, text:" + str + ", x:" + f17 + ", y:" + f18);
        if (str == null) {
            str = "";
        }
        TextLayer textLayer = new TextLayer(str, i3, f16);
        textLayer.setShadowLayer(1.0f, 1.0f, 1.0f, Utils.buildColorFromARGB(0.2f, 0.0f, 0.0f, 0.0f));
        textLayer.setTextAlign(Paint.Align.CENTER);
        textLayer.setX(f17);
        textLayer.setY(f18);
        textLayer.setTextBold(z16);
        textLayer.setAnimator(new KeepAnimator(textLayer));
        return textLayer;
    }

    private TextLayer createTitleLayer() {
        return createTextLayer(this.mTitle, -1, getRelativeSize(18), getWidth() / 2.0f, getHeight() - getRelativeSize(94), true);
    }

    private APNGDrawable getApngDrawable(String str) {
        APNGDrawable aPNGDrawable;
        APNGDrawable aPNGDrawable2 = null;
        if (!isFilePathValid(str)) {
            Logger.i(TAG, "getApngDrawable, invalid path: " + str);
            return null;
        }
        try {
            aPNGDrawable = new APNGDrawable(new FileLoader(str), getHandler());
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            aPNGDrawable.setLoopLimit(1);
            return aPNGDrawable;
        } catch (Throwable th6) {
            th = th6;
            aPNGDrawable2 = aPNGDrawable;
            Logger.e(TAG, "getApngDrawable, apng create fail:", th);
            return aPNGDrawable2;
        }
    }

    private Bitmap getFixBitmap(Context context, Bitmap bitmap, int i3, int i16) {
        if (context == null) {
            Logger.e(TAG, "getFixBitmap, context is null");
            return null;
        }
        if (!isBitmapValid(bitmap)) {
            Logger.e(TAG, "getFixBitmap, originBitmap is invalid, originBitmap = " + bitmap);
            return null;
        }
        return Utils.scaleBitmapSafe(bitmap, i3, i16);
    }

    private int getRelativeSize(int i3) {
        Context context = getContext();
        if (context == null) {
            Logger.e(TAG, "getRelativeSize, context is null, return origin size");
            return i3;
        }
        return Utils.getRelativeSize375(context, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInteractSuccess() {
        if (this.mIsInteractSuccess) {
            Logger.i(TAG, "handleInteractSuccess, interact has finished, just return");
            return;
        }
        RotationSensor rotationSensor = this.mSensor;
        if (rotationSensor != null) {
            rotationSensor.stop();
        } else {
            Logger.i(TAG, "onInteractSuccess, sensor is null");
        }
        ICNYTwistViewListener iCNYTwistViewListener = this.mInteractListener;
        if (iCNYTwistViewListener != null) {
            iCNYTwistViewListener.onInteractResult(true);
            if (this.mNeedCallCollisionApngAnimationEnd) {
                iCNYTwistViewListener.onInteractSuccessAnimationEnd();
            }
        } else {
            Logger.i(TAG, "onInteractSuccess, listener is null");
        }
        this.mIsInteractSuccess = true;
    }

    private void initIconsLayer(Bitmap bitmap, Bitmap bitmap2) {
        Context context = getContext();
        if (context == null) {
            Logger.e(TAG, "createBitmapLayer, context is null");
            return;
        }
        if (!isBitmapValid(bitmap)) {
            Logger.e(TAG, "createBitmapLayer, invalid leftIconBitmap: " + bitmap);
            return;
        }
        if (!isBitmapValid(bitmap2)) {
            Logger.e(TAG, "createBitmapLayer, invalid rightIconBitmap: " + bitmap2);
            return;
        }
        int relativeSize = getRelativeSize(92);
        int relativeSize2 = getRelativeSize(92);
        int width = ((getWidth() - getRelativeSize(4)) - (relativeSize * 2)) / 2;
        this.mLeftIconX = width;
        this.mRightIconX = (getWidth() - width) - relativeSize;
        this.mIconY = (getHeight() - getRelativeSize(128)) - relativeSize2;
        Bitmap fixBitmap = getFixBitmap(context, bitmap, relativeSize, relativeSize2);
        if (fixBitmap != null) {
            CNYBitmapLayer cNYBitmapLayer = new CNYBitmapLayer(fixBitmap);
            this.mLeftIconLayer = cNYBitmapLayer;
            cNYBitmapLayer.setWidth(relativeSize);
            this.mLeftIconLayer.setHeight(relativeSize2);
            this.mLeftIconLayer.setX(this.mLeftIconX);
            this.mLeftIconLayer.setY(this.mIconY);
            CNYBitmapLayer cNYBitmapLayer2 = this.mLeftIconLayer;
            cNYBitmapLayer2.setAnimator(new KeepAnimator(cNYBitmapLayer2));
        } else {
            Logger.e(TAG, "createBitmapLayer, leftIconFixBitmap is null");
        }
        Bitmap fixBitmap2 = getFixBitmap(context, bitmap2, relativeSize, relativeSize2);
        if (fixBitmap2 != null) {
            CNYBitmapLayer cNYBitmapLayer3 = new CNYBitmapLayer(fixBitmap2);
            this.mRightIconLayer = cNYBitmapLayer3;
            cNYBitmapLayer3.setWidth(relativeSize);
            this.mRightIconLayer.setHeight(relativeSize2);
            this.mRightIconLayer.setX(this.mRightIconX);
            this.mRightIconLayer.setY(this.mIconY);
            CNYBitmapLayer cNYBitmapLayer4 = this.mRightIconLayer;
            cNYBitmapLayer4.setAnimator(new KeepAnimator(cNYBitmapLayer4));
            return;
        }
        Logger.e(TAG, "createBitmapLayer, rightIconFixBitmap is null");
    }

    private boolean isBitmapValid(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            return true;
        }
        return false;
    }

    private boolean isFilePathValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    private void notifyFailIfNeed() {
        ICNYTwistViewListener iCNYTwistViewListener = this.mInteractListener;
        if (iCNYTwistViewListener == null) {
            Logger.i(TAG, "notifyFailIfNeed, mInteractListener is null");
        } else if (this.mIsInteractStart && !this.mIsInteractSuccess) {
            iCNYTwistViewListener.onInteractResult(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playApngAnimator() {
        boolean z16;
        int i3;
        ICNYTwistViewListener iCNYTwistViewListener = this.mInteractListener;
        if (iCNYTwistViewListener != null) {
            iCNYTwistViewListener.onInteractSuccessAnimationStart();
        } else {
            Logger.i(TAG, "playApngAnimator, mInteractListener is null");
        }
        String str = this.mCollisionApngPath;
        if (!isFilePathValid(str)) {
            this.mNeedCallCollisionApngAnimationEnd = true;
            Logger.e(TAG, "playApngAnimator, invalid apngImagePath: " + str);
            return;
        }
        TwistRotationHandlerV2 twistRotationHandlerV2 = this.mTwistRotationHandler;
        if (twistRotationHandlerV2 == null) {
            this.mNeedCallCollisionApngAnimationEnd = true;
            Logger.e(TAG, "playApngAnimator, twistRotationHandler is null");
            return;
        }
        if (twistRotationHandlerV2.getInteractSuccessDirection() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Logger.i(TAG, "playApngAnimator, isLeftToRight = " + z16);
        APNGDrawable apngDrawable = getApngDrawable(str);
        if (apngDrawable == null) {
            this.mNeedCallCollisionApngAnimationEnd = true;
            Logger.e(TAG, "playApngAnimator, apngDrawable is null");
            return;
        }
        apngDrawable.registerAnimationCallback(new Animatable2.AnimationCallback(apngDrawable) { // from class: com.tencent.ams.fusion.widget.cny2025.twist.CNYTwistView.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ APNGDrawable val$apngDrawable;

            {
                this.val$apngDrawable = apngDrawable;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) CNYTwistView.this, (Object) apngDrawable);
                }
            }

            @Override // com.tencent.ams.fusion.widget.apng.frame.animation.Animatable2.AnimationCallback
            public void onAnimationEnd(Drawable drawable) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
                    return;
                }
                super.onAnimationEnd(drawable);
                APNGDrawable aPNGDrawable = this.val$apngDrawable;
                if (aPNGDrawable != null) {
                    aPNGDrawable.stop();
                    this.val$apngDrawable.clearAnimationCallbacks();
                }
                if (CNYTwistView.this.mAnimatorView != null && CNYTwistView.this.mDrawableLayer != null) {
                    CNYTwistView.this.mAnimatorView.removeLayer(CNYTwistView.this.mDrawableLayer);
                    CNYTwistView.this.mDrawableLayer.setDrawable(null);
                }
                CNYTwistView.this.callApngAnimationEnd();
            }

            @Override // com.tencent.ams.fusion.widget.apng.frame.animation.Animatable2.AnimationCallback
            public void onAnimationStart(Drawable drawable) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable);
                } else {
                    super.onAnimationStart(drawable);
                }
            }
        });
        int relativeSize = getRelativeSize(132);
        int relativeSize2 = getRelativeSize(132);
        DrawableLayer drawableLayer = new DrawableLayer();
        this.mDrawableLayer = drawableLayer;
        drawableLayer.setDrawable(apngDrawable);
        this.mDrawableLayer.setWidth(relativeSize);
        this.mDrawableLayer.setHeight(relativeSize2);
        if (z16) {
            i3 = 129;
        } else {
            i3 = 114;
        }
        int relativeSize3 = getRelativeSize(i3);
        int height = (getHeight() - relativeSize2) - getRelativeSize(115);
        apngDrawable.setBounds(relativeSize3, height, relativeSize + relativeSize3, relativeSize2 + height);
        this.mDrawableLayer.setX(relativeSize3);
        this.mDrawableLayer.setY(height);
        DrawableLayer drawableLayer2 = this.mDrawableLayer;
        drawableLayer2.setAnimator(new KeepAnimator(drawableLayer2));
        this.mAnimatorView.addLayer(this.mDrawableLayer);
        apngDrawable.setCanTranslate(true);
        apngDrawable.setVisible(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAnimationByProgress(float f16, float f17) {
        CNYTwistArrowLayer cNYTwistArrowLayer = this.mLeftArrowLayer;
        if (cNYTwistArrowLayer == null) {
            Logger.e(TAG, "updateAnimationByProgress, leftArrowLayer is null");
            return;
        }
        CNYTwistArrowLayer cNYTwistArrowLayer2 = this.mRightArrowLayer;
        if (cNYTwistArrowLayer2 == null) {
            Logger.e(TAG, "updateAnimationByProgress, rightArrowLayer is null");
            return;
        }
        CNYBitmapLayer cNYBitmapLayer = this.mLeftIconLayer;
        if (cNYBitmapLayer == null) {
            Logger.e(TAG, "updateAnimationByProgress, leftIconLayer is null");
            return;
        }
        CNYBitmapLayer cNYBitmapLayer2 = this.mRightIconLayer;
        if (cNYBitmapLayer2 == null) {
            Logger.e(TAG, "updateAnimationByProgress, rightIconLayer is null");
            return;
        }
        ProgressAnimator progressAnimator = this.mLeftArrowProgressAnimator;
        if (progressAnimator == null) {
            Logger.e(TAG, "updateAnimationByProgress, leftArrowProgressAnimator is null");
            return;
        }
        ProgressAnimator progressAnimator2 = this.mRightArrowProgressAnimator;
        if (progressAnimator2 == null) {
            Logger.e(TAG, "updateAnimationByProgress, rightArrowProgressAnimator is null");
            return;
        }
        float f18 = f17 / 100.0f;
        synchronized (this.mAnimatorView) {
            if (!this.mHasSetProgressAnimator) {
                cNYTwistArrowLayer.setAnimator(progressAnimator);
                cNYTwistArrowLayer2.setAnimator(progressAnimator2);
                cNYBitmapLayer.setAnimator(new KeepAnimator(cNYBitmapLayer));
                cNYBitmapLayer2.setAnimator(new KeepAnimator(cNYBitmapLayer2));
                this.mHasSetProgressAnimator = true;
            }
        }
        if (f16 < 0.0f) {
            progressAnimator.setFromProgress(f18);
            progressAnimator.setToProgress(f18);
            progressAnimator2.setFromProgress(0.0f);
            progressAnimator2.setToProgress(0.0f);
            updateCNYBitmapLayer(cNYBitmapLayer, this.mLeftIconX + (getRelativeSize(35) * f18), this.mIconY - (getRelativeSize(9) * f18), f18 * 10.0f, 1.0f + (0.1f * f18));
            updateCNYBitmapLayer(cNYBitmapLayer2, this.mRightIconX - (getRelativeSize(15) * f18), this.mIconY, f18 * (-5.0f), 1.0f);
            return;
        }
        progressAnimator.setFromProgress(0.0f);
        progressAnimator.setToProgress(0.0f);
        progressAnimator2.setFromProgress(f18);
        progressAnimator2.setToProgress(f18);
        updateCNYBitmapLayer(cNYBitmapLayer, this.mLeftIconX + (getRelativeSize(15) * f18), this.mIconY, f18 * 5.0f, 1.0f);
        updateCNYBitmapLayer(cNYBitmapLayer2, this.mRightIconX - (getRelativeSize(35) * f18), this.mIconY - (getRelativeSize(9) * f18), f18 * (-10.0f), (f18 * 0.1f) + 1.0f);
    }

    private void updateCNYBitmapLayer(CNYBitmapLayer cNYBitmapLayer, float f16, float f17, float f18, float f19) {
        if (cNYBitmapLayer == null) {
            Logger.e(TAG, "updateCNYBitmapLayer, cnyBitmapLayer is null");
            return;
        }
        cNYBitmapLayer.setX(f16);
        cNYBitmapLayer.setY(f17);
        cNYBitmapLayer.setDegrees(f18);
        cNYBitmapLayer.setScale(f19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTitleLayer(String str) {
        TextLayer textLayer = this.mTitleTextLayer;
        if (textLayer == null) {
            Logger.e(TAG, "updateTitleLayer, titleTextLayer is null");
            return;
        }
        if (str == null) {
            str = "";
        }
        textLayer.setText(str);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        Logger.i(TAG, "onSizeChanged w:" + i3 + ", h:" + i16 + ", oldw:" + i17 + ", oldh:" + i18);
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.mIsUserStarted && !this.mIsInteractSuccess) {
            Logger.i(TAG, "onSizeChanged, perform start, mHasPause: " + this.mHasPause);
            if (this.mHasPause) {
                return;
            }
            start();
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        Logger.i(TAG, "pause");
        AnimatorView animatorView = this.mAnimatorView;
        if (animatorView != null) {
            animatorView.pauseAnimation();
        } else {
            Logger.i(TAG, "pause, animatorView is null");
        }
        RotationSensor rotationSensor = this.mSensor;
        if (rotationSensor != null) {
            rotationSensor.pause();
        } else {
            Logger.i(TAG, "start, sensor is null");
        }
        this.mHasPause = true;
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        Logger.i(TAG, "resume");
        if (this.mIsUserStarted && !this.mHasStart) {
            Logger.i(TAG, "resume, has started but not start completely, preform start");
            start();
            return;
        }
        AnimatorView animatorView = this.mAnimatorView;
        if (animatorView != null) {
            animatorView.resumeAnimation();
        } else {
            Logger.i(TAG, "start, animatorView is null");
        }
        RotationSensor rotationSensor = this.mSensor;
        if (rotationSensor != null) {
            rotationSensor.resume();
        } else {
            Logger.i(TAG, "start, sensor is null");
        }
        this.mHasPause = false;
    }

    @Override // com.tencent.ams.fusion.widget.cny2025.twist.ICNYTwistView
    public void setCollisionApng(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        if (!isFilePathValid(str)) {
            Logger.e(TAG, "setCollisionApng, invalid path: " + str);
            return;
        }
        this.mCollisionApngPath = str;
    }

    @Override // com.tencent.ams.fusion.widget.cny2025.twist.ICNYTwistView
    public void setIcons(Bitmap bitmap, Bitmap bitmap2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bitmap, (Object) bitmap2);
            return;
        }
        if (isBitmapValid(bitmap) && isBitmapValid(bitmap2)) {
            this.mLeftIconBitmap = bitmap;
            this.mRightIconBitmap = bitmap2;
            return;
        }
        Logger.e(TAG, "setIcons, invalid leftIcon or rightIcon, leftIcon = " + bitmap + ", rightIcon = " + bitmap2);
    }

    @Override // com.tencent.ams.fusion.widget.cny2025.twist.ICNYTwistView
    public void setInteractListener(ICNYTwistViewListener iCNYTwistViewListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) iCNYTwistViewListener);
        } else {
            this.mInteractListener = iCNYTwistViewListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.cny2025.twist.ICNYTwistView
    public void setReverseAngle(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
            return;
        }
        if (f16 < 0.0f) {
            Logger.e(TAG, "setReverseAngle, invalid reverseAngle: " + f16);
            return;
        }
        this.mReverseAngle = f16;
        TwistRotationHandlerV2 twistRotationHandlerV2 = this.mTwistRotationHandler;
        if (twistRotationHandlerV2 != null) {
            twistRotationHandlerV2.setReverseAngle(f16);
        } else {
            Logger.i(TAG, "setReverseAngle, twistRotationHandler is null");
        }
    }

    @Override // com.tencent.ams.fusion.widget.cny2025.twist.ICNYTwistView
    public void setReverseTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else if (str == null) {
            Logger.i(TAG, "setReverseTitle, reverseTitle is null");
        } else {
            this.mReverseTitle = str;
        }
    }

    @Override // com.tencent.ams.fusion.widget.cny2025.twist.ICNYTwistView
    public void setSubtitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else if (str == null) {
            Logger.i(TAG, "setTitle, subtitle is null");
        } else {
            this.mSubtitle = str;
        }
    }

    @Override // com.tencent.ams.fusion.widget.cny2025.twist.ICNYTwistView
    public void setTargetAngle(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
            return;
        }
        if (f16 <= 0.0f) {
            Logger.e(TAG, "setTargetAngle, invalid targetAngle: " + f16);
            return;
        }
        TwistRotationHandlerV2 twistRotationHandlerV2 = this.mTwistRotationHandler;
        if (twistRotationHandlerV2 != null) {
            twistRotationHandlerV2.setTargetAngle(f16);
        } else {
            Logger.i(TAG, "setTargetAngle, twistRotationHandler is null");
        }
    }

    @Override // com.tencent.ams.fusion.widget.cny2025.twist.ICNYTwistView
    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else if (str == null) {
            Logger.i(TAG, "setTitle, title is null");
        } else {
            this.mTitle = str;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        Logger.i(TAG, "start");
        Bitmap bitmap = this.mLeftIconBitmap;
        Bitmap bitmap2 = this.mRightIconBitmap;
        if (isBitmapValid(bitmap) && isBitmapValid(bitmap2)) {
            AnimatorView animatorView = this.mAnimatorView;
            if (animatorView == null) {
                Logger.e(TAG, "start, animatorView is null, do nothing");
                return;
            }
            this.mIsUserStarted = true;
            if (getWidth() > 0 && getHeight() > 0) {
                animatorView.clearLayers();
                PathShapeLayer createBgShaderLayer = createBgShaderLayer();
                this.mBgShaderLayer = createBgShaderLayer;
                animatorView.addLayer(createBgShaderLayer);
                TextLayer createTitleLayer = createTitleLayer();
                this.mTitleTextLayer = createTitleLayer;
                animatorView.addLayer(createTitleLayer);
                TextLayer createSubtitleLayer = createSubtitleLayer();
                this.mSubtitleTextLayer = createSubtitleLayer;
                animatorView.addLayer(createSubtitleLayer);
                initIconsLayer(bitmap, bitmap2);
                CNYBitmapLayer cNYBitmapLayer = this.mLeftIconLayer;
                if (cNYBitmapLayer != null) {
                    animatorView.addLayer(cNYBitmapLayer);
                } else {
                    Logger.e(TAG, "start, mLeftIconLayer is null");
                }
                CNYBitmapLayer cNYBitmapLayer2 = this.mRightIconLayer;
                if (cNYBitmapLayer2 != null) {
                    animatorView.addLayer(cNYBitmapLayer2);
                } else {
                    Logger.e(TAG, "start, mRightIconLayer is null");
                }
                CNYTwistArrowLayer createLeftArrowLayer = createLeftArrowLayer();
                this.mLeftArrowLayer = createLeftArrowLayer;
                if (createLeftArrowLayer != null) {
                    animatorView.addLayer(createLeftArrowLayer);
                } else {
                    Logger.e(TAG, "start, mLeftArrowLayer is null");
                }
                CNYTwistArrowLayer createRightArrowLayer = createRightArrowLayer();
                this.mRightArrowLayer = createRightArrowLayer;
                if (createRightArrowLayer != null) {
                    animatorView.addLayer(createRightArrowLayer);
                } else {
                    Logger.e(TAG, "start, mRightArrowLayer is null");
                }
                createGuideAnimation();
                animatorView.startAnimation();
                RotationSensor rotationSensor = this.mSensor;
                if (rotationSensor != null) {
                    rotationSensor.start();
                } else {
                    Logger.i(TAG, "start, sensor is null");
                }
                this.mHasStart = true;
                return;
            }
            Logger.i(TAG, "start, width or height is 0, do nothing");
            return;
        }
        Logger.e(TAG, "start, invalid icons, do nothing, leftIconBitmap = " + bitmap + ", rightIconBitmap = " + bitmap2);
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        Logger.i(TAG, "stop");
        this.mIsUserStarted = false;
        this.mHasStart = false;
        this.mHasPause = false;
        AnimatorView animatorView = this.mAnimatorView;
        if (animatorView != null) {
            animatorView.stopAnimation();
        } else {
            Logger.i(TAG, "stop, animatorView is null");
        }
        RotationSensor rotationSensor = this.mSensor;
        if (rotationSensor != null) {
            rotationSensor.stop();
        } else {
            Logger.i(TAG, "sensor is null");
        }
        notifyFailIfNeed();
    }

    public CNYTwistView(@NonNull Context context, boolean z16) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(z16));
            return;
        }
        this.mTitle = DEFAULT_TITLE;
        this.mSubtitle = DEFAULT_SUBTITLE;
        this.mReverseTitle = "\u6446\u6b63\u624b\u673a\u8fdb\u884c\u8df3\u8f6c";
        this.mTwistCallback = new TwistRotationHandlerV2.TwistCallbackV2() { // from class: com.tencent.ams.fusion.widget.cny2025.twist.CNYTwistView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CNYTwistView.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.twist.TwistRotationHandler.TwistCallback
            public void onBackInteractProgress(float f16, int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, this, Float.valueOf(f16), Integer.valueOf(i3));
                    return;
                }
                int max = Math.max(0, Math.min(i3, 100));
                CNYTwistView.this.updateAnimationByProgress(f16, max);
                CNYTwistView cNYTwistView = CNYTwistView.this;
                cNYTwistView.updateTitleLayer(cNYTwistView.mReverseTitle);
                ICNYTwistViewListener iCNYTwistViewListener = CNYTwistView.this.mInteractListener;
                if (iCNYTwistViewListener != null) {
                    iCNYTwistViewListener.onBackInteractProgress(f16, max);
                } else {
                    Logger.i(CNYTwistView.TAG, "onBackInteractProgress, listener is null");
                }
            }

            @Override // com.tencent.ams.fusion.widget.twist.TwistRotationHandlerV2.TwistCallbackV2
            public void onBackInteractStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                Logger.i(CNYTwistView.TAG, "onBackInteractStart");
                if (CNYTwistView.this.mReverseAngle > 0.0f) {
                    CNYTwistView.this.playApngAnimator();
                }
            }

            @Override // com.tencent.ams.fusion.widget.twist.TwistRotationHandler.TwistCallback
            public void onInteractProgress(float f16, int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, this, Float.valueOf(f16), Integer.valueOf(i3));
                    return;
                }
                int max = Math.max(0, Math.min(i3, 100));
                CNYTwistView.this.updateAnimationByProgress(f16, max);
                ICNYTwistViewListener iCNYTwistViewListener = CNYTwistView.this.mInteractListener;
                if (iCNYTwistViewListener != null) {
                    iCNYTwistViewListener.onInteractProgress(f16, max);
                } else {
                    Logger.i(CNYTwistView.TAG, "onInteractProgress, listener is null");
                }
            }

            @Override // com.tencent.ams.fusion.widget.twist.TwistRotationHandler.TwistCallback
            public void onInteractStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this);
                    return;
                }
                Logger.i(CNYTwistView.TAG, "onInteractStart");
                CNYTwistView.this.mIsInteractStart = true;
                ICNYTwistViewListener iCNYTwistViewListener = CNYTwistView.this.mInteractListener;
                if (iCNYTwistViewListener != null) {
                    iCNYTwistViewListener.onInteractStart();
                } else {
                    Logger.i(CNYTwistView.TAG, "onInteractStart, listener is null");
                }
            }

            @Override // com.tencent.ams.fusion.widget.twist.TwistRotationHandler.TwistCallback
            public void onInteractSuccess() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 7)) {
                    iPatchRedirector2.redirect((short) 7, (Object) this);
                    return;
                }
                Logger.i(CNYTwistView.TAG, "onInteractSuccess");
                if (CNYTwistView.this.mReverseAngle == 0.0f) {
                    CNYTwistView.this.playApngAnimator();
                }
                CNYTwistView.this.handleInteractSuccess();
            }

            @Override // com.tencent.ams.fusion.widget.twist.TwistRotationHandlerV2.TwistCallbackV2
            public void onSensorError() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this);
                    return;
                }
                Logger.i(CNYTwistView.TAG, "onSensorError");
                ICNYTwistViewListener iCNYTwistViewListener = CNYTwistView.this.mInteractListener;
                if (iCNYTwistViewListener != null) {
                    iCNYTwistViewListener.onSensorError();
                } else {
                    Logger.i(CNYTwistView.TAG, "onSensorError, listener is null");
                }
            }
        };
        AnimatorView animatorView = new AnimatorView(context);
        this.mAnimatorView = animatorView;
        RotationSensor highRateRotationSensor = z16 ? new HighRateRotationSensor(context, false) : new RotationSensor(context, false);
        this.mSensor = highRateRotationSensor;
        TwistRotationHandlerV2 twistRotationHandlerV2 = new TwistRotationHandlerV2(this.mTwistCallback);
        this.mTwistRotationHandler = twistRotationHandlerV2;
        twistRotationHandlerV2.setDirection(2);
        highRateRotationSensor.setOnRotationChangeListener(twistRotationHandlerV2);
        addView(animatorView);
    }
}
