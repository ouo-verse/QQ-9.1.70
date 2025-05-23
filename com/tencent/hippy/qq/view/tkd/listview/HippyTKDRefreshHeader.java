package com.tencent.hippy.qq.view.tkd.listview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.raft.measure.utils.MeasureConst;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyTKDRefreshHeader implements HippyTKDInvalidateCallback, IHippyTKDRefreshHeader {
    public static final int BALL_COLOR_CUSTOM = 3;
    public static final int BALL_COLOR_DEFAULT = -1;
    public static final int BALL_COLOR_GREEN = 1;
    public static final int BALL_COLOR_RED = 0;
    public static final int BALL_COLOR_YELLOW = 2;
    static final int BALL_COUNT = 3;
    public static final int REFRESH_RESULT_FAILED = 3;
    public static final int REFRESH_RESULT_NOTCARE = 1;
    public static final int REFRESH_RESULT_SUCCESSS = 2;
    public static final int REFRESH_STATE_FAILED = 3;
    public static final int REFRESH_STATE_ING = 1;
    public static final int REFRESH_STATE_NOTCARE = 6;
    public static final int REFRESH_STATE_PULLING = 4;
    public static final int REFRESH_STATE_SETTLING = 5;
    public static final int REFRESH_STATE_SUCCESSS = 2;
    public static final int REFRESH_STATE_WAIT = 0;
    static final String TAG = "QBRefreshHeader";
    public static final int TARGET_REFRESH_TYPE_KINGCARD_USER = 3;
    public static final int TARGET_REFRESH_TYPE_NONE = -1;

    /* renamed from: gm, reason: collision with root package name */
    UIGdiMeasure f114173gm;
    ObjectAnimator hideAnimator;
    boolean isSuccess;
    LinearGradient mBackGradient;
    AnimatingBall[] mBalls;
    public RefreshableCallback mCb;
    int mColor;
    int mColorType;
    public int mContentheight;
    HippyTKDRefreshAnimation mCustomAnimation;
    String mCustomCompleteText;
    private View mCustomHippyRefreshView;
    private HippyTKDCustomRefreshHeader mCustomRefreshHeaderView;
    private View.OnLayoutChangeListener mCustomRefreshViewLayoutChangeListener;
    int mCustomTipBackgroundColorID;
    int mCustomTipBgBeginColor;
    int mCustomTipBgEndColor;
    int mCustomTipTextColor;
    int mCustomTipTextSize;
    String mDescriptionText;
    int mDescriptionTextColor;
    int mDescriptionTextFontSize;
    private boolean mEnableCustomRefreshHeaderView;
    private IHippyTKDRefreshHeaderEventExtension[] mEventExtensions;
    private int mHideIndex;
    private View mHostView;
    private String mIconUrl;
    private int mInitLayerType;
    InternalStageCallback mInternalStageCallback;
    Paint mPaint;
    private PendingComplete mPendingCompleteObject;
    Promise mPromise;
    public BitmapDrawable mPullDownToRefreshDesIcon;
    public int mPullDownToRefreshDesIconHeigth;
    public int mPullDownToRefreshDesIconWidth;
    public int mPullDownToRefreshDistanceBetweenIconText;
    public Drawable mPullDownToRefreshFailIcon;
    public Drawable mPullDownToRefreshSucIcon;
    public String mPullDownToRefreshTextFail;
    public HippyTKDUISize mPullDownToRefreshTextFailTextSize;
    public String mPullDownToRefreshTextSuc;
    public HippyTKDUISize mPullDownToRefreshTextSucTextSize;
    public Drawable mRefreshDrawable;
    public int mRefreshOffset;
    public int mRefreshState;
    float mRefreshToastAlpha;
    float mRefreshToastOffsetY;
    float mRefreshToastSize;
    private boolean mShowRefreshBall;
    boolean mShowRefreshIcon;
    boolean mStatShow5p;
    boolean mStatShow80p;
    Runnable mStayRunnable;
    private int mTargetRefreshType;
    int mTipsBgColor;
    private Paint mToastBgPaint;
    private RectF mToastBgRect;
    PropertyValuesHolder offsetHolderShow;
    public int refreshBgColor;
    ObjectAnimator showAnimator;
    public static final int BALL_MARGIN_H = ImmersiveUtils.dpToPx(12.0f);
    public static final int BALL_MARING_V = ImmersiveUtils.dpToPx(18.0f);
    public static final int BALL_MARGING_WITH_TEXT = ImmersiveUtils.dpToPx(26.0f);
    public static final int TEXT_MARGING_WITH_BALL = ImmersiveUtils.dpToPx(6.0f);
    public static final int CONTENT_HEIGHT = ImmersiveUtils.dpToPx(42.0f);
    public static final int REFRESH_HEADER_TOP_PADDING = ImmersiveUtils.dpToPx(0.0f);

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface ExternalStageCallback {
        void onEnterStage(int i3);

        void onUpAction(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class ExternalStageInfo {
        Drawable mBackgroundDrawable;
        String mDescriptionText;
        int mDescriptionTextColor;
        int mDistanceFromTop;
        ExternalStageCallback mExternalStageCallback;
        boolean mNeedLoadingRefreshBall;
        boolean mNeedShowBackgroundImage;
        boolean mNeedShowDescriptionText;

        public ExternalStageInfo(ExternalStageCallback externalStageCallback, int i3, boolean z16, boolean z17, boolean z18, String str, int i16, Drawable drawable) {
            this.mExternalStageCallback = externalStageCallback;
            this.mDistanceFromTop = ImmersiveUtils.dpToPx(i3);
            this.mNeedLoadingRefreshBall = z16;
            this.mNeedShowDescriptionText = z17;
            this.mNeedShowBackgroundImage = z18;
            this.mDescriptionText = str;
            this.mDescriptionTextColor = i16;
            this.mBackgroundDrawable = drawable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface ImageRequestListener {
        void onRequestFail(Throwable th5, String str);

        void onRequestSuccess(Bitmap bitmap, String str);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface InternalStageCallback {
        public static final int STATE_NOREFRESH = 0;
        public static final int STATE_REFRESH = 1;

        void onUpAction(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class PendingComplete {
        String mCompleteToastString = null;
        long mCompleteToastLastTime = 0;
        boolean mShowRefreshIcon = false;

        public void setPendingCompleteInfo(String str, boolean z16, long j3) {
            this.mCompleteToastString = str;
            this.mCompleteToastLastTime = j3;
            this.mShowRefreshIcon = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface RefreshableCallback {
        void completeRefresh(int i3);

        void completeRefresh(int i3, String str, int i16, int i17, int i18, int i19, String str2, boolean z16, long j3, int i26, Promise promise, int i27);

        int getHeight();

        int getOffsetY();

        boolean getOverScrollEnabled();

        int getTotalHeight();

        int getWidth();

        void onAboutToRefresh();

        void onRefresh();

        void onShowToast();

        void postDelayedDelegate(Runnable runnable, long j3);

        void postInvalidate();

        void removeCallbacksDelegate(Runnable runnable);

        void removeOnScrollFinishListener();

        void scrollBack(int i3, RecyclerViewBase.OnScrollFinishListener onScrollFinishListener, int i16);

        void scrollToShowHeader(int i3, RecyclerViewBase.OnScrollFinishListener onScrollFinishListener);

        void scrollToShowHeaderAtOnce(int i3);

        void scrollToShowHeaderSmooth(int i3);

        void scrollToTop(RecyclerViewBase.OnScrollFinishListener onScrollFinishListener, int i3);

        void scrollToTopAtOnce();
    }

    public HippyTKDRefreshHeader(RefreshableCallback refreshableCallback, boolean z16) {
        this.mShowRefreshBall = true;
        this.mToastBgRect = new RectF();
        this.mToastBgPaint = new Paint();
        this.mHostView = null;
        this.mInitLayerType = 0;
        this.mIconUrl = null;
        this.mPendingCompleteObject = null;
        this.mRefreshState = 0;
        this.mPullDownToRefreshDistanceBetweenIconText = ImmersiveUtils.dpToPx(8.0f);
        this.mPullDownToRefreshTextSuc = ResourceUtil.getString(R.string.f2207069u);
        this.mPullDownToRefreshTextSucTextSize = new HippyTKDUISize();
        this.mPullDownToRefreshTextFail = ResourceUtil.getString(R.string.f2206969t);
        this.mPullDownToRefreshTextFailTextSize = new HippyTKDUISize();
        int i3 = CONTENT_HEIGHT;
        int i16 = REFRESH_HEADER_TOP_PADDING;
        this.mRefreshOffset = i3 + i16;
        this.mContentheight = i3 + i16;
        this.mPaint = new Paint();
        this.mShowRefreshIcon = true;
        this.mCustomAnimation = null;
        this.refreshBgColor = 0;
        this.mDescriptionTextFontSize = ImmersiveUtils.dpToPx(12.0f);
        this.mCustomTipTextSize = 0;
        this.mCustomTipBackgroundColorID = 0;
        this.mCustomTipBgBeginColor = 0;
        this.mCustomTipBgEndColor = 0;
        this.isSuccess = false;
        this.mInternalStageCallback = null;
        this.mStayRunnable = new Runnable() { // from class: com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z17;
                Log.d(HippyTKDRefreshHeader.TAG, "mStayRunnable run");
                HippyTKDRefreshHeader hippyTKDRefreshHeader = HippyTKDRefreshHeader.this;
                Runnable runnable = new Runnable() { // from class: com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HippyTKDRefreshHeader hippyTKDRefreshHeader2 = HippyTKDRefreshHeader.this;
                        hippyTKDRefreshHeader2.mCustomCompleteText = null;
                        hippyTKDRefreshHeader2.f114173gm.getStringWidthHeight(hippyTKDRefreshHeader2.mPullDownToRefreshTextSuc, hippyTKDRefreshHeader2.mPullDownToRefreshTextSucTextSize);
                        HippyTKDRefreshHeader hippyTKDRefreshHeader3 = HippyTKDRefreshHeader.this;
                        hippyTKDRefreshHeader3.f114173gm.getStringWidthHeight(hippyTKDRefreshHeader3.mPullDownToRefreshTextFail, hippyTKDRefreshHeader3.mPullDownToRefreshTextFailTextSize);
                        HippyTKDRefreshHeader.this.mShowRefreshIcon = true;
                        Log.d(HippyTKDRefreshHeader.TAG, "setRefreshState aa");
                        HippyTKDRefreshHeader.this.setRefreshState(5);
                    }
                };
                if (HippyTKDRefreshHeader.this.mRefreshState == 6) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                hippyTKDRefreshHeader.hideToast(runnable, z17);
            }
        };
        this.mCustomRefreshHeaderView = null;
        this.mEnableCustomRefreshHeaderView = false;
        this.mTargetRefreshType = -1;
        this.mHideIndex = 0;
        this.mStatShow5p = false;
        this.mStatShow80p = false;
        this.mCb = refreshableCallback;
        UIGdiMeasure uIGdiMeasure = new UIGdiMeasure();
        this.f114173gm = uIGdiMeasure;
        uIGdiMeasure.setFontSize(ImmersiveUtils.dpToPx(12.0f));
        this.f114173gm.getStringWidthHeight(this.mPullDownToRefreshTextSuc, this.mPullDownToRefreshTextSucTextSize);
        this.f114173gm.getStringWidthHeight(this.mPullDownToRefreshTextFail, this.mPullDownToRefreshTextFailTextSize);
        this.mBalls = new AnimatingBall[3];
        for (int i17 = 0; i17 < 3; i17++) {
            this.mBalls[i17] = new AnimatingBall(this, i17);
        }
        setRefreshBallColor(-1);
        setRefreshToastOffsetY(-this.mContentheight);
        setRefreshToastAlpha(1.0f);
        this.offsetHolderShow = PropertyValuesHolder.ofFloat("refreshToastOffsetY", 0.0f);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, this.offsetHolderShow, PropertyValuesHolder.ofFloat("refreshToastAlpha", 0.5f, 1.0f), PropertyValuesHolder.ofFloat("refreshToastSize", 0.0f, 1.0f));
        this.showAnimator = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setDuration(200L);
        this.showAnimator.setEvaluator(new FloatEvaluator());
        this.showAnimator.setInterpolator(new CurvedInterpolator(2));
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("refreshToastOffsetY", -this.mContentheight), PropertyValuesHolder.ofFloat("refreshToastAlpha", 1.0f, 0.5f));
        this.hideAnimator = ofPropertyValuesHolder2;
        ofPropertyValuesHolder2.setDuration(200L);
        this.hideAnimator.setEvaluator(new FloatEvaluator());
        this.hideAnimator.setInterpolator(new CurvedInterpolator(3));
        this.mCustomRefreshViewLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.2
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37) {
                int i38 = i27 - i19;
                if (i38 > 0) {
                    HippyTKDRefreshHeader.this.mContentheight = i38;
                }
            }
        };
        this.mDescriptionTextColor = ResourceUtil.getColor(R.color.cva);
    }

    private String getStateStr(int i3) {
        switch (i3) {
            case 0:
                return "WAIT";
            case 1:
                return "ING";
            case 2:
                return "SUCCESSS";
            case 3:
                return "FAILED";
            case 4:
                return "PULLING";
            case 5:
                return "SETTLING";
            case 6:
                return "NOTCARE";
            default:
                return "";
        }
    }

    private boolean isCustomRefreshMode() {
        if (this.mCustomRefreshHeaderView != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFakeRefreshState(int i3) {
        if (i3 == this.mRefreshState) {
            return;
        }
        Log.e(TAG, "setRefreshState:old=" + stateToString(this.mRefreshState) + ",new=" + stateToString(i3));
        int i16 = this.mRefreshState;
        if (i16 == 0 || i16 == 5) {
            if (i3 == 1) {
                int i17 = 0;
                while (true) {
                    AnimatingBall[] animatingBallArr = this.mBalls;
                    if (i17 < animatingBallArr.length) {
                        animatingBallArr[i17].animateRefresh();
                        i17++;
                    } else {
                        this.mRefreshState = i3;
                        return;
                    }
                }
            } else {
                Log.d(TAG, "refresh notify");
            }
        }
        this.mRefreshState = i3;
    }

    public void advancedStopRefresh() {
        int i3 = this.mRefreshState;
        if (i3 == 2 || i3 == 3) {
            stopRefresh();
            hideToast(null, false);
            this.mCb.removeCallbacksDelegate(this.mStayRunnable);
            this.mCb.postDelayedDelegate(this.mStayRunnable, 0L);
        }
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.IHippyTKDRefreshHeader
    public boolean checkRefreshState(int i3) {
        if (i3 == this.mRefreshState) {
            return true;
        }
        return false;
    }

    public void clearCompletePending() {
        this.mPendingCompleteObject = null;
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.IHippyTKDRefreshHeader
    public void completeRefresh(int i3) {
        completeRefresh(i3, null, 0, 0, 0, 0, this.mIconUrl, true, 1200L, null, 0);
    }

    public void fetchImage(final String str, @NonNull final ImageRequestListener imageRequestListener) {
        if (TextUtils.isEmpty(str)) {
            imageRequestListener.onRequestFail(new IllegalArgumentException("null url"), str);
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        drawable.setURLDrawableListener(new URLDrawable.URLDrawableListener() { // from class: com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.14
            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
                imageRequestListener.onRequestFail(th5, str);
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadSuccessed(URLDrawable uRLDrawable) {
                imageRequestListener.onRequestSuccess(BaseImageUtil.drawableToBitmap(uRLDrawable), str);
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadCanceled(URLDrawable uRLDrawable) {
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            }
        });
        if (drawable.getStatus() != 2 && drawable.getStatus() != 3) {
            drawable.startDownload();
        } else {
            drawable.restartDownload();
        }
    }

    public int getRefreshState() {
        return this.mRefreshState;
    }

    public float getRefreshToastAlpha() {
        return this.mRefreshToastAlpha;
    }

    public float getRefreshToastOffsetY() {
        return this.mRefreshToastOffsetY;
    }

    public float getRefreshToastSize() {
        return this.mRefreshToastSize;
    }

    void hideToast(final Runnable runnable, boolean z16) {
        Log.d(TAG, UIJsPlugin.EVENT_HIDE_TOAST);
        this.showAnimator.cancel();
        if (!z16) {
            this.hideAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                    HippyTKDRefreshHeader.this.hideAnimator.removeListener(this);
                    super.onAnimationEnd(animator);
                }
            });
            this.hideAnimator.start();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public boolean isInRefreshArea() {
        int totalHeight = this.mCb.getTotalHeight();
        if (this.mCb.getOffsetY() >= 0 && this.mCb.getHeight() <= totalHeight) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.IHippyTKDRefreshHeader
    public boolean isRefreshHeaderShowing() {
        if (this.mRefreshState != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.IHippyTKDRefreshHeader
    public boolean isRefreshing() {
        int i3 = this.mRefreshState;
        if (i3 == 1 || i3 == 3 || i3 == 2 || i3 == 6) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.IHippyTKDRefreshHeader
    public void onCancelTouch() {
        if (this.mRefreshState == 5) {
            setRefreshState(0);
        }
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.IHippyTKDRefreshHeader
    public void onDraw(Canvas canvas) {
        int i3;
        boolean z16;
        boolean z17;
        int i16;
        String str;
        int i17;
        int i18;
        Drawable drawable;
        int intrinsicWidth;
        int i19;
        int i26;
        int i27;
        boolean z18;
        boolean z19;
        boolean isCustomRefreshMode = isCustomRefreshMode();
        int i28 = 255;
        if (isCustomRefreshMode) {
            HippyTKDCustomRefreshHeader hippyTKDCustomRefreshHeader = this.mCustomRefreshHeaderView;
            if (hippyTKDCustomRefreshHeader != null && hippyTKDCustomRefreshHeader.isShowMasterRefreshText()) {
                z18 = true;
            } else {
                z18 = false;
            }
            HippyTKDCustomRefreshHeader hippyTKDCustomRefreshHeader2 = this.mCustomRefreshHeaderView;
            if (hippyTKDCustomRefreshHeader2 != null && hippyTKDCustomRefreshHeader2.isShowMasterRefreshToastBg()) {
                z19 = true;
            } else {
                z19 = false;
            }
            HippyTKDCustomRefreshHeader hippyTKDCustomRefreshHeader3 = this.mCustomRefreshHeaderView;
            if (hippyTKDCustomRefreshHeader3 != null) {
                i28 = hippyTKDCustomRefreshHeader3.getMasterRefreshTextAlpha();
            }
            HippyTKDCustomRefreshHeader hippyTKDCustomRefreshHeader4 = this.mCustomRefreshHeaderView;
            if (hippyTKDCustomRefreshHeader4 != null) {
                hippyTKDCustomRefreshHeader4.onTranslating(-this.mCb.getOffsetY());
                canvas.save();
                canvas.translate(0.0f, (-this.mCb.getOffsetY()) - this.mCustomRefreshHeaderView.getRefreshViewHeight());
                this.mCustomRefreshHeaderView.draw(canvas);
                canvas.restore();
            }
            i3 = i28;
            z16 = z18;
            z17 = z19;
        } else {
            i3 = 255;
            z16 = true;
            z17 = true;
        }
        int save = canvas.save();
        if (this.mCustomHippyRefreshView != null && this.mRefreshState != 0) {
            canvas.save();
            canvas.translate(0.0f, (-this.mCb.getOffsetY()) - this.mCustomHippyRefreshView.getHeight());
            this.mCustomHippyRefreshView.draw(canvas);
            this.mCb.postInvalidate();
            canvas.restore();
            canvas.restoreToCount(save);
            return;
        }
        if (!isCustomRefreshMode) {
            this.mPaint.setColor(this.refreshBgColor);
            canvas.drawRect(0.0f, 0.0f, this.mCb.getWidth(), -this.mCb.getOffsetY(), this.mPaint);
        }
        int width = (this.mCb.getWidth() - ((AnimatingBall.BALL_SIZE * 2) + (BALL_MARGIN_H * 2))) / 2;
        if (this.mShowRefreshBall && (i27 = this.mRefreshState) != 3 && i27 != 2) {
            HippyTKDRefreshAnimation hippyTKDRefreshAnimation = this.mCustomAnimation;
            if (hippyTKDRefreshAnimation != null) {
                hippyTKDRefreshAnimation.draw(canvas, this.mCb.getOffsetY(), Integer.MAX_VALUE, width);
            } else if (!isCustomRefreshMode) {
                int i29 = 0;
                while (true) {
                    AnimatingBall[] animatingBallArr = this.mBalls;
                    if (i29 >= animatingBallArr.length) {
                        break;
                    }
                    animatingBallArr[i29].draw(canvas, this.mCb.getOffsetY(), Integer.MAX_VALUE, width);
                    i29++;
                }
            }
            BitmapDrawable bitmapDrawable = this.mPullDownToRefreshDesIcon;
            if (bitmapDrawable != null && bitmapDrawable.getBitmap() != null && !this.mPullDownToRefreshDesIcon.getBitmap().isRecycled()) {
                try {
                    int width2 = (this.mCb.getWidth() - this.mPullDownToRefreshDesIconWidth) / 2;
                    int dpToPx = (((-this.mCb.getOffsetY()) - this.mContentheight) - this.mPullDownToRefreshDesIconHeigth) - ImmersiveUtils.dpToPx(0.0f);
                    if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
                        this.mPullDownToRefreshDesIcon.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
                    } else {
                        this.mPullDownToRefreshDesIcon.clearColorFilter();
                    }
                    this.mPullDownToRefreshDesIcon.setBounds(width2, dpToPx, this.mPullDownToRefreshDesIconWidth + width2, this.mPullDownToRefreshDesIconHeigth + dpToPx);
                    this.mPullDownToRefreshDesIcon.draw(canvas);
                    if (!this.mStatShow80p && (-(this.mCb.getOffsetY() + this.mContentheight)) / this.mPullDownToRefreshDesIconHeigth > 0.8d) {
                        this.mStatShow80p = true;
                        IHippyTKDRefreshHeaderEventExtension[] iHippyTKDRefreshHeaderEventExtensionArr = this.mEventExtensions;
                        if (iHippyTKDRefreshHeaderEventExtensionArr != null) {
                            for (IHippyTKDRefreshHeaderEventExtension iHippyTKDRefreshHeaderEventExtension : iHippyTKDRefreshHeaderEventExtensionArr) {
                                iHippyTKDRefreshHeaderEventExtension.onRefreshHeaderShow80P();
                            }
                        }
                    }
                    if (!this.mStatShow5p && (-(this.mCb.getOffsetY() + this.mContentheight)) / this.mPullDownToRefreshDesIconHeigth > 0.05d) {
                        this.mStatShow5p = true;
                        IHippyTKDRefreshHeaderEventExtension[] iHippyTKDRefreshHeaderEventExtensionArr2 = this.mEventExtensions;
                        if (iHippyTKDRefreshHeaderEventExtensionArr2 != null) {
                            for (IHippyTKDRefreshHeaderEventExtension iHippyTKDRefreshHeaderEventExtension2 : iHippyTKDRefreshHeaderEventExtensionArr2) {
                                iHippyTKDRefreshHeaderEventExtension2.onRefreshHeaderShow5P();
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            } else if (!TextUtils.isEmpty(this.mDescriptionText) && z16) {
                this.mPaint.setTextSize(this.mDescriptionTextFontSize);
                this.mPaint.setColor(this.mDescriptionTextColor);
                int textWidth = UIUtilBase.getTextWidth(this.mDescriptionText, this.mPaint, this.mDescriptionTextFontSize);
                int textHeight = UIUtilBase.getTextHeight(this.mPaint, this.mDescriptionTextFontSize);
                int width3 = (this.mCb.getWidth() - textWidth) / 2;
                this.mPaint.setAlpha(i3);
                UIStringUtils.drawText(canvas, this.mPaint, width3, (((-this.mCb.getOffsetY()) - this.mContentheight) - textHeight) - ImmersiveUtils.dpToPx(0.0f), this.mDescriptionText);
            }
        }
        float f16 = this.mRefreshToastOffsetY;
        if (f16 > (-this.mContentheight)) {
            int saveLayerAlpha = canvas.saveLayerAlpha(0.0f, f16, this.mCb.getWidth(), this.mContentheight, (int) (this.mRefreshToastAlpha * 255.0f), 31);
            int alpha = this.mPaint.getAlpha();
            if (z17) {
                canvas.translate(0.0f, this.mRefreshToastOffsetY);
                canvas.clipRect(0, 0, this.mCb.getWidth(), this.mContentheight);
                int i36 = this.mCustomTipBackgroundColorID;
                if (i36 != 0) {
                    i26 = ResourceUtil.getColor(i36);
                } else {
                    i26 = this.mTipsBgColor;
                }
                canvas.drawColor(i26);
                this.mPaint.setAlpha(Color.alpha(this.mCustomTipBgBeginColor));
                if (this.mBackGradient == null) {
                    this.mBackGradient = new LinearGradient(0.0f, 0.0f, this.mCb.getWidth(), 0.0f, new int[]{this.mCustomTipBgBeginColor, this.mCustomTipBgEndColor}, (float[]) null, Shader.TileMode.CLAMP);
                }
                this.mPaint.setShader(this.mBackGradient);
                i16 = alpha;
                canvas.drawRect((this.mCb.getWidth() / 2) - ((this.mCb.getWidth() / 2) * this.mRefreshToastSize), 0.0f, ((this.mCb.getWidth() / 2) * this.mRefreshToastSize) + (this.mCb.getWidth() / 2), this.mContentheight, this.mPaint);
            } else {
                i16 = alpha;
            }
            Drawable drawable2 = null;
            this.mPaint.setShader(null);
            this.mPaint.setAlpha(i16);
            if (!TextUtils.isEmpty(this.mCustomCompleteText)) {
                str = this.mCustomCompleteText;
            } else if (this.isSuccess) {
                str = this.mPullDownToRefreshTextSuc;
            } else {
                str = this.mPullDownToRefreshTextFail;
            }
            boolean z26 = this.isSuccess;
            if (!z26) {
                i17 = this.mPullDownToRefreshTextFailTextSize.mWidth;
            } else {
                i17 = this.mPullDownToRefreshTextSucTextSize.mWidth;
            }
            if (!z26) {
                i18 = this.mPullDownToRefreshTextFailTextSize.mHeight;
            } else {
                i18 = this.mPullDownToRefreshTextSucTextSize.mHeight;
            }
            Paint paint = this.mPaint;
            int i37 = this.mCustomTipTextSize;
            if (i37 == 0) {
                i37 = ImmersiveUtils.dpToPx(12.0f);
            }
            paint.setTextSize(i37);
            Paint paint2 = this.mPaint;
            int i38 = this.mCustomTipTextColor;
            if (i38 == 0) {
                i38 = this.mColor;
            }
            paint2.setColor(i38);
            int i39 = this.mContentheight;
            int i46 = REFRESH_HEADER_TOP_PADDING;
            float f17 = (((i39 - i46) - i18) / 2) + i46;
            if (this.mShowRefreshIcon) {
                if (z16) {
                    int save2 = canvas.save();
                    if (this.isSuccess) {
                        if (this.mPullDownToRefreshSucIcon == null) {
                            Bitmap bitmap = ResourceUtil.getBitmap(R.drawable.f162595mh3);
                            int i47 = this.mCustomTipTextColor;
                            if (i47 == 0) {
                                i47 = this.mColor;
                            }
                            this.mPullDownToRefreshSucIcon = UIBitmapUtils.getColorImage(bitmap, i47);
                        }
                        drawable = this.mPullDownToRefreshSucIcon;
                    } else {
                        if (this.mPullDownToRefreshFailIcon == null) {
                            Bitmap bitmap2 = ResourceUtil.getBitmap(R.drawable.f162594mh2);
                            int i48 = this.mCustomTipTextColor;
                            if (i48 == 0) {
                                i48 = this.mColor;
                            }
                            this.mPullDownToRefreshFailIcon = UIBitmapUtils.getColorImage(bitmap2, i48);
                        }
                        drawable = this.mPullDownToRefreshFailIcon;
                    }
                    if (this.mTargetRefreshType == 3) {
                        if (ThemeUtil.isNowThemeIsNight(null, false, "")) {
                            i19 = Integer.MIN_VALUE;
                        } else {
                            i19 = 0;
                        }
                        drawable2 = UIBitmapUtils.getColorImage(ResourceUtil.getBitmap(R.drawable.f162593mh1), i19);
                    }
                    int width4 = ((this.mCb.getWidth() - drawable.getIntrinsicWidth()) - this.mPullDownToRefreshDistanceBetweenIconText) - i17;
                    if (drawable2 == null) {
                        intrinsicWidth = 0;
                    } else {
                        intrinsicWidth = drawable2.getIntrinsicWidth();
                    }
                    int i49 = (width4 - intrinsicWidth) / 2;
                    int intrinsicHeight = (((this.mContentheight - i46) - drawable.getIntrinsicHeight()) / 2) + i46;
                    drawable.setBounds(i49, intrinsicHeight, i49 + drawable.getIntrinsicWidth(), intrinsicHeight + drawable.getIntrinsicHeight());
                    drawable.setAlpha(i3);
                    drawable.draw(canvas);
                    canvas.restoreToCount(save2);
                    this.mPaint.setAlpha(i3);
                    UIStringUtils.drawText(canvas, this.mPaint, drawable.getIntrinsicWidth() + i49 + this.mPullDownToRefreshDistanceBetweenIconText, f17, str);
                    if (this.mTargetRefreshType == 3 && drawable2 != null) {
                        int intrinsicWidth2 = (int) (i49 + drawable.getIntrinsicWidth() + this.mPullDownToRefreshDistanceBetweenIconText + i17 + PixelUtil.dp2px(8.0f));
                        int intrinsicHeight2 = (((this.mContentheight - i46) - drawable2.getIntrinsicHeight()) / 2) + i46;
                        drawable2.setBounds(intrinsicWidth2, intrinsicHeight2, drawable2.getIntrinsicWidth() + intrinsicWidth2, drawable2.getIntrinsicHeight() + intrinsicHeight2);
                        drawable2.setAlpha(i3);
                        drawable2.draw(canvas);
                    }
                }
            } else if (z16) {
                this.mPaint.setAlpha(i3);
                UIStringUtils.drawText(canvas, this.mPaint, (this.mCb.getWidth() - i17) / 2.0f, f17, str);
            }
            canvas.restoreToCount(saveLayerAlpha);
        }
        canvas.restoreToCount(save);
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.IHippyTKDRefreshHeader
    public boolean onScrolled() {
        if (isInRefreshArea() && this.mCb.getOffsetY() != 0) {
            if (!this.mCb.getOverScrollEnabled()) {
                return false;
            }
            Log.d(TAG, "setRefreshState ee");
            setRefreshState(4);
        } else {
            setRefreshState(0);
        }
        if (this.mCb.getOffsetY() >= 0) {
            this.mStatShow80p = false;
            this.mStatShow5p = false;
            return true;
        }
        return true;
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.IHippyTKDRefreshHeader
    public void onSwitchSkin() {
        int i3 = this.mColorType;
        if (i3 != 3) {
            setRefreshBallColor(i3);
        }
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.IHippyTKDRefreshHeader
    public boolean onUpAction(boolean z16) {
        Log.d(TAG, "onUpAction");
        if (!z16) {
            Log.d(TAG, "onUpAction,!canGoRefresh,return early");
            return false;
        }
        if (isInRefreshArea()) {
            int i3 = this.mRefreshState;
            if (i3 == 4) {
                if (this.mCb.getOffsetY() < (-this.mRefreshOffset)) {
                    Log.d(TAG, "onUpAction,scroll to show header");
                    this.mCb.onAboutToRefresh();
                    this.mCb.scrollToShowHeader(this.mRefreshOffset, new RecyclerViewBase.OnScrollFinishListener() { // from class: com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.8
                        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.OnScrollFinishListener
                        public void onScrollFinished() {
                            HippyTKDRefreshHeader.this.setRefreshState(1);
                        }
                    });
                    Log.d(TAG, "setRefreshState cc");
                    setRefreshState(5);
                    InternalStageCallback internalStageCallback = this.mInternalStageCallback;
                    if (internalStageCallback != null) {
                        internalStageCallback.onUpAction(1);
                    }
                } else {
                    Log.d(TAG, "onUpAction,scrollToTop");
                    this.mCb.scrollToTop(new RecyclerViewBase.OnScrollFinishListener() { // from class: com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.9
                        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.OnScrollFinishListener
                        public void onScrollFinished() {
                            HippyTKDRefreshHeader.this.setRefreshState(0);
                        }
                    }, 0);
                    Log.d(TAG, "setRefreshState dd");
                    setRefreshState(5);
                    InternalStageCallback internalStageCallback2 = this.mInternalStageCallback;
                    if (internalStageCallback2 != null) {
                        internalStageCallback2.onUpAction(0);
                    }
                }
                return true;
            }
            if (i3 != 1 && i3 != 2 && i3 != 3) {
                Log.d(TAG, "onUpAction,not pulling or settling");
                return false;
            }
            Log.d(TAG, "onUpAction,pulling");
            return true;
        }
        Log.d(TAG, "onUpAction,not in overscroll area");
        return false;
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDInvalidateCallback
    public void postInvalidate() {
        this.mCb.postInvalidate();
    }

    public void resetRefreshState() {
        this.mRefreshState = 0;
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.IHippyTKDRefreshHeader
    public void restoreRefresh() {
        if (this.mRefreshState == 1) {
            HippyTKDRefreshAnimation hippyTKDRefreshAnimation = this.mCustomAnimation;
            if (hippyTKDRefreshAnimation != null) {
                hippyTKDRefreshAnimation.animateRefresh();
                return;
            }
            int i3 = 0;
            while (true) {
                AnimatingBall[] animatingBallArr = this.mBalls;
                if (i3 < animatingBallArr.length) {
                    animatingBallArr[i3].animateRefresh();
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    public void setCustomAnimation(AnimatingBall animatingBall) {
        this.mCustomAnimation = animatingBall;
        animatingBall.setInvalidateCallback(this);
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.IHippyTKDRefreshHeader
    public void setCustomHippyRefreshView(View view) {
        View view2 = this.mCustomHippyRefreshView;
        if (view2 != null) {
            view2.removeOnLayoutChangeListener(this.mCustomRefreshViewLayoutChangeListener);
        }
        this.mCustomHippyRefreshView = view;
        view.addOnLayoutChangeListener(this.mCustomRefreshViewLayoutChangeListener);
    }

    public void setCustomRefreshBallColor(int i3) {
        setCustomRefreshBallColor(i3, 0, 0);
    }

    public void setCustomRefreshHeader(HippyTKDCustomRefreshHeader hippyTKDCustomRefreshHeader) {
        this.mCustomRefreshHeaderView = hippyTKDCustomRefreshHeader;
    }

    public void setInternalStageCallback(InternalStageCallback internalStageCallback) {
        this.mInternalStageCallback = internalStageCallback;
    }

    public void setRefreshBallColor(int i3) {
        this.mColorType = i3;
        this.refreshBgColor = ResourceUtil.getColor(R.color.cvh);
        this.mTipsBgColor = ResourceUtil.getColor(R.color.cvb);
        int i16 = this.mColorType;
        if (i16 != -1) {
            if (i16 != 0) {
                if (i16 != 1) {
                    if (i16 == 2) {
                        this.mColor = ResourceUtil.getColor(R.color.cvg);
                    }
                } else {
                    this.mColor = ResourceUtil.getColor(R.color.cvc);
                }
            } else {
                this.mColor = ResourceUtil.getColor(R.color.cvf);
            }
        } else {
            this.mColor = ResourceUtil.getColor(R.color.cve);
            this.refreshBgColor = ResourceUtil.getColor(R.color.cvi);
            this.mTipsBgColor = ResourceUtil.getColor(R.color.cvb);
        }
        for (int i17 = 0; i17 < 3; i17++) {
            this.mBalls[i17].setInitialColor(this.mColor);
        }
        this.mPullDownToRefreshSucIcon = null;
        this.mPullDownToRefreshFailIcon = null;
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.IHippyTKDRefreshHeader
    public void setRefreshPromptInfo(String str, int i3, int i16, String str2, int i17, int i18, final int i19) {
        this.mDescriptionText = str;
        this.mDescriptionTextColor = i3;
        this.mDescriptionTextFontSize = i16;
        this.mPullDownToRefreshDesIconWidth = i17;
        this.mPullDownToRefreshDesIconHeigth = i18;
        if (!TextUtils.isEmpty(str2)) {
            fetchImage(str2, new ImageRequestListener() { // from class: com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.7
                @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.ImageRequestListener
                public void onRequestSuccess(Bitmap bitmap, String str3) {
                    if (bitmap != null) {
                        HippyTKDRefreshHeader.this.mPullDownToRefreshDesIcon = new BitmapDrawable(bitmap);
                    }
                    HippyTKDRefreshHeader hippyTKDRefreshHeader = HippyTKDRefreshHeader.this;
                    hippyTKDRefreshHeader.mRefreshOffset = hippyTKDRefreshHeader.mContentheight + i19;
                }

                @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.ImageRequestListener
                public void onRequestFail(Throwable th5, String str3) {
                }
            });
        } else {
            this.mPullDownToRefreshDesIcon = null;
        }
        if (!TextUtils.isEmpty(this.mDescriptionText)) {
            this.mRefreshOffset = this.mContentheight + i19;
        }
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.mDescriptionText)) {
            this.mRefreshOffset = this.mContentheight;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0093, code lost:
    
        if (r2 != 6) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void setRefreshState(int i3) {
        IHippyTKDRefreshHeaderEventExtension[] iHippyTKDRefreshHeaderEventExtensionArr;
        if (i3 == this.mRefreshState) {
            return;
        }
        LogUtils.d(TAG, "harryguo mRefreshState=" + getStateStr(this.mRefreshState) + ", newState=" + getStateStr(i3) + ",this:" + this);
        int i16 = 0;
        if (i3 == 0 && (iHippyTKDRefreshHeaderEventExtensionArr = this.mEventExtensions) != null) {
            for (IHippyTKDRefreshHeaderEventExtension iHippyTKDRefreshHeaderEventExtension : iHippyTKDRefreshHeaderEventExtensionArr) {
                iHippyTKDRefreshHeaderEventExtension.onRefreshWait();
            }
        }
        if (isCustomRefreshMode()) {
            switch (i3) {
                case 0:
                    this.mCustomRefreshHeaderView.onFinishing();
                    this.mEnableCustomRefreshHeaderView = false;
                    break;
                case 1:
                    this.mCustomRefreshHeaderView.startLoadingAnimation();
                    break;
                case 2:
                case 3:
                case 6:
                    this.mCustomRefreshHeaderView.endLoadingAnimation(this.mCustomCompleteText);
                    break;
                case 4:
                    this.mCustomRefreshHeaderView.startPulling();
                    break;
                case 5:
                    this.mCustomRefreshHeaderView.startSettling();
                    break;
            }
        }
        Promise promise = this.mPromise;
        if (promise != null && i3 == 0) {
            promise.resolve(Boolean.TRUE);
        }
        int i17 = this.mRefreshState;
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 != 2 && i17 != 3) {
                    if (i17 != 5) {
                    }
                }
                if (i3 == 4) {
                    stopRefresh();
                    hideToast(null, false);
                    this.mCb.removeCallbacksDelegate(this.mStayRunnable);
                } else if (i3 == 5) {
                    stopRefresh();
                    this.mShowRefreshBall = false;
                    this.mCb.scrollToTop(new RecyclerViewBase.OnScrollFinishListener() { // from class: com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.3
                        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.OnScrollFinishListener
                        public void onScrollFinished() {
                            HippyTKDRefreshHeader.this.setRefreshState(0);
                            HippyTKDRefreshHeader.this.mShowRefreshBall = true;
                        }
                    }, this.mHideIndex);
                    ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!HippyTKDRefreshHeader.this.mShowRefreshBall) {
                                HippyTKDRefreshHeader.this.setRefreshState(0);
                                HippyTKDRefreshHeader.this.mShowRefreshBall = true;
                            }
                        }
                    }, 1000L);
                }
            } else {
                if (i3 == 2 || i3 == 3) {
                    showToast();
                    this.mCb.onShowToast();
                }
                stopRefresh();
            }
            this.mRefreshState = i3;
        }
        if (i3 == 1) {
            HippyTKDRefreshAnimation hippyTKDRefreshAnimation = this.mCustomAnimation;
            if (hippyTKDRefreshAnimation != null) {
                hippyTKDRefreshAnimation.animateRefresh();
            } else {
                while (true) {
                    AnimatingBall[] animatingBallArr = this.mBalls;
                    if (i16 < animatingBallArr.length) {
                        animatingBallArr[i16].animateRefresh();
                        i16++;
                    }
                }
            }
            this.mRefreshState = i3;
            this.mCb.onRefresh();
            if (this.mPendingCompleteObject != null) {
                this.mCb.postDelayedDelegate(new Runnable() { // from class: com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (HippyTKDRefreshHeader.this.mPendingCompleteObject != null) {
                            HippyTKDRefreshHeader.this.mPendingCompleteObject = null;
                        }
                    }
                }, 50L);
                return;
            }
            return;
        }
        Log.d(TAG, "refresh notify");
        this.mRefreshState = i3;
    }

    public void setRefreshToastAlpha(float f16) {
        this.mRefreshToastAlpha = f16;
        this.mCb.postInvalidate();
    }

    public void setRefreshToastInfo(int i3, int i16, int i17) {
        if (i3 != 0) {
            this.mCustomTipTextColor = ResourceUtil.getColor(i3);
        }
        this.mCustomTipTextSize = i16;
        this.mCustomTipBackgroundColorID = i17;
    }

    public void setRefreshToastOffsetY(float f16) {
        this.mRefreshToastOffsetY = f16;
        this.mCb.postInvalidate();
    }

    public void setRefreshToastSize(float f16) {
        this.mRefreshToastSize = f16;
        this.mCb.postInvalidate();
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.IHippyTKDRefreshHeader
    public void setRefreshWithTargetType(int i3) {
        this.mTargetRefreshType = i3;
    }

    void showToast() {
        Log.d(TAG, "showAnimator");
        this.hideAnimator.cancel();
        this.showAnimator.start();
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.IHippyTKDRefreshHeader
    public void startRefresh(boolean z16) {
        Log.d(TAG, "startRefresh:init=" + z16);
        if (this.mRefreshState == 0) {
            Log.d(TAG, "startRefresh:1");
            if (z16) {
                this.mCb.scrollToShowHeaderAtOnce(this.mRefreshOffset);
                setRefreshState(1);
            } else {
                this.mCb.scrollToShowHeader(this.mRefreshOffset, new RecyclerViewBase.OnScrollFinishListener() { // from class: com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.11
                    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.OnScrollFinishListener
                    public void onScrollFinished() {
                        HippyTKDRefreshHeader.this.setRefreshState(1);
                    }
                });
                Log.d(TAG, "setRefreshState bb");
                setRefreshState(5);
            }
        }
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.IHippyTKDRefreshHeader
    public void startRefreshOnlyWithAimation(boolean z16) {
        Log.d(TAG, "startRefreshOnlyWithAimation:init=" + z16);
        if (this.mRefreshState == 0) {
            Log.d(TAG, "startRefresh:1");
            if (z16) {
                this.mCb.scrollToShowHeaderAtOnce(this.mRefreshOffset);
                setFakeRefreshState(1);
            } else {
                this.mCb.scrollToShowHeader(this.mRefreshOffset, new RecyclerViewBase.OnScrollFinishListener() { // from class: com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.12
                    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.OnScrollFinishListener
                    public void onScrollFinished() {
                        HippyTKDRefreshHeader.this.setFakeRefreshState(1);
                    }
                });
                Log.d(TAG, "setRefreshState bb");
                setFakeRefreshState(5);
            }
        }
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.IHippyTKDRefreshHeader
    public void startRefreshWithType(boolean z16) {
        HippyTKDCustomRefreshHeader hippyTKDCustomRefreshHeader = this.mCustomRefreshHeaderView;
        if (hippyTKDCustomRefreshHeader != null && this.mRefreshState == 0) {
            this.mEnableCustomRefreshHeaderView = true;
            if (z16) {
                this.mCb.scrollToShowHeaderAtOnce(hippyTKDCustomRefreshHeader.getRefreshViewHeight());
                setRefreshState(1);
            } else {
                this.mCb.scrollToShowHeader(hippyTKDCustomRefreshHeader.getRefreshViewHeight(), new RecyclerViewBase.OnScrollFinishListener() { // from class: com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.10
                    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.OnScrollFinishListener
                    public void onScrollFinished() {
                        HippyTKDRefreshHeader.this.setRefreshState(1);
                    }
                });
                setRefreshState(5);
            }
        }
    }

    String stateToString(int i3) {
        if (i3 == 3) {
            return "failed";
        }
        if (i3 == 6) {
            return "notcare";
        }
        if (i3 == 1) {
            return "refreshing";
        }
        if (i3 == 4) {
            return "pulling";
        }
        if (i3 == 2) {
            return MeasureConst.SLI_TYPE_SUCCESS;
        }
        if (i3 == 5) {
            return "settlling";
        }
        if (i3 == 0) {
            return "wait";
        }
        return "";
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.IHippyTKDRefreshHeader
    public void stopRefresh() {
        HippyTKDRefreshAnimation hippyTKDRefreshAnimation = this.mCustomAnimation;
        if (hippyTKDRefreshAnimation != null) {
            hippyTKDRefreshAnimation.stopAllAnimators();
            return;
        }
        for (AnimatingBall animatingBall : this.mBalls) {
            animatingBall.stopAllAnimators();
        }
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.IHippyTKDRefreshHeader
    public void completeRefresh(final int i3, String str, int i16, int i17, int i18, int i19, String str2, boolean z16, long j3, Promise promise, int i26) {
        Log.d("HippyQBRefreshHeader", "completeRefresh state " + stateToString(this.mRefreshState));
        this.mCustomTipBgBeginColor = i16;
        this.mCustomTipBgEndColor = i17;
        this.mCustomTipTextColor = i18;
        this.mCustomTipTextSize = i19;
        this.mPromise = promise;
        this.mBackGradient = null;
        this.mHideIndex = i26;
        if (i16 != 0 && i17 != 0) {
            this.offsetHolderShow.setFloatValues(0.0f, 0.0f);
        } else {
            this.offsetHolderShow.setFloatValues(-this.mContentheight, 0.0f);
        }
        if (!TextUtils.isEmpty(str2) && this.mHostView != null && !TextUtils.equals(this.mIconUrl, str2)) {
            this.mIconUrl = str2;
            fetchImage(str2, new ImageRequestListener() { // from class: com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.13
                @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.ImageRequestListener
                public void onRequestSuccess(Bitmap bitmap, String str3) {
                    if (bitmap != null) {
                        if (i3 == 2) {
                            HippyTKDRefreshHeader.this.mPullDownToRefreshSucIcon = new BitmapDrawable(BaseApplication.getContext().getResources(), Bitmap.createScaledBitmap(bitmap, (ImmersiveUtils.dpToPx(12.0f) * bitmap.getWidth()) / bitmap.getHeight(), ImmersiveUtils.dpToPx(12.0f), true));
                        } else {
                            HippyTKDRefreshHeader.this.mPullDownToRefreshFailIcon = new BitmapDrawable(BaseApplication.getContext().getResources(), Bitmap.createScaledBitmap(bitmap, (ImmersiveUtils.dpToPx(12.0f) * bitmap.getWidth()) / bitmap.getHeight(), ImmersiveUtils.dpToPx(12.0f), true));
                        }
                    }
                }

                @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.ImageRequestListener
                public void onRequestFail(Throwable th5, String str3) {
                }
            });
        }
        if (TextUtils.isEmpty(str2)) {
            this.mIconUrl = null;
            this.mPullDownToRefreshSucIcon = null;
            this.mPullDownToRefreshFailIcon = null;
        }
        int i27 = this.mRefreshState;
        if (i27 != 1) {
            if ((i27 != 2 && i27 != 3) || (i3 != 2 && i3 != 3)) {
                if (i3 != 1) {
                    if (this.mPendingCompleteObject == null) {
                        this.mPendingCompleteObject = new PendingComplete();
                    }
                    this.mPendingCompleteObject.setPendingCompleteInfo(str, z16, j3);
                    return;
                }
                return;
            }
            Log.d(TAG, "completeRefresh:already in success or fail, update toast info, mRefreshState=" + this.mRefreshState);
            if (TextUtils.isEmpty(str) || str.equals(this.mCustomCompleteText)) {
                return;
            }
            this.mCustomCompleteText = str;
            this.mShowRefreshIcon = z16;
            UIGdiMeasure uIGdiMeasure = this.f114173gm;
            int i28 = this.mCustomTipTextSize;
            if (i28 == 0) {
                i28 = ImmersiveUtils.dpToPx(12.0f);
            }
            uIGdiMeasure.setFontSize(i28);
            this.f114173gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextSucTextSize);
            this.f114173gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextFailTextSize);
            postInvalidate();
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.mCustomCompleteText = str;
            this.mShowRefreshIcon = z16;
            UIGdiMeasure uIGdiMeasure2 = this.f114173gm;
            int i29 = this.mCustomTipTextSize;
            if (i29 == 0) {
                i29 = ImmersiveUtils.dpToPx(12.0f);
            }
            uIGdiMeasure2.setFontSize(i29);
            this.f114173gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextSucTextSize);
            this.f114173gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextFailTextSize);
        }
        if (this.mCb.getOffsetY() < 0) {
            Log.d(TAG, "completeRefresh offset<=0");
            if (i3 == 2) {
                setRefreshState(2);
                this.isSuccess = true;
            } else if (i3 == 3) {
                setRefreshState(3);
                this.isSuccess = false;
            } else if (i3 == 1) {
                setRefreshState(6);
            }
            this.mCb.removeCallbacksDelegate(this.mStayRunnable);
            this.mCb.removeOnScrollFinishListener();
            RefreshableCallback refreshableCallback = this.mCb;
            Runnable runnable = this.mStayRunnable;
            if (i3 == 1) {
                j3 = 0;
            }
            refreshableCallback.postDelayedDelegate(runnable, j3);
            this.mCb.scrollToShowHeaderSmooth(this.mContentheight);
            return;
        }
        this.mCb.scrollToTopAtOnce();
        setRefreshState(0);
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.IHippyTKDRefreshHeader
    public void setCustomRefreshBallColor(int i3, int i16, int i17) {
        this.mColorType = 3;
        if (i16 == 0) {
            this.refreshBgColor = ResourceUtil.getColor(R.color.cvh);
        } else {
            this.refreshBgColor = i16;
        }
        if (i17 == 0) {
            this.mTipsBgColor = ResourceUtil.getColor(R.color.cvb);
        } else {
            this.mTipsBgColor = i17;
        }
        this.mColor = i3;
        for (int i18 = 0; i18 < 3; i18++) {
            this.mBalls[i18].setInitialColor(this.mColor);
        }
        this.mPullDownToRefreshSucIcon = null;
        this.mPullDownToRefreshFailIcon = null;
    }

    public void addExternalStageInfo(ExternalStageInfo externalStageInfo) {
    }

    public void completeRefresh(int i3, String str, boolean z16, long j3, boolean z17) {
        int i16 = this.mRefreshState;
        if (i16 != 1) {
            if ((i16 != 2 && i16 != 3) || (i3 != 2 && i3 != 3)) {
                if (i3 != 1) {
                    if (this.mPendingCompleteObject == null) {
                        this.mPendingCompleteObject = new PendingComplete();
                    }
                    this.mPendingCompleteObject.setPendingCompleteInfo(str, z16, j3);
                    return;
                }
                return;
            }
            Log.d(TAG, "completeRefresh:already in success or fail, update toast info, mRefreshState=" + this.mRefreshState);
            if (TextUtils.isEmpty(str) || str.equals(this.mCustomCompleteText)) {
                return;
            }
            this.mCustomCompleteText = str;
            this.mShowRefreshIcon = z16;
            UIGdiMeasure uIGdiMeasure = this.f114173gm;
            int i17 = this.mCustomTipTextSize;
            if (i17 == 0) {
                i17 = ImmersiveUtils.dpToPx(12.0f);
            }
            uIGdiMeasure.setFontSize(i17);
            this.f114173gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextSucTextSize);
            this.f114173gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextFailTextSize);
            postInvalidate();
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.mCustomCompleteText = str;
            this.mShowRefreshIcon = z16;
            UIGdiMeasure uIGdiMeasure2 = this.f114173gm;
            int i18 = this.mCustomTipTextSize;
            if (i18 == 0) {
                i18 = ImmersiveUtils.dpToPx(12.0f);
            }
            uIGdiMeasure2.setFontSize(i18);
            this.f114173gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextSucTextSize);
            this.f114173gm.getStringWidthHeight(this.mCustomCompleteText, this.mPullDownToRefreshTextFailTextSize);
        }
        if (this.mCb.getOffsetY() >= 0 && !z17) {
            this.mCb.scrollToTopAtOnce();
            setRefreshState(0);
            return;
        }
        Log.d(TAG, "completeRefresh offset<=0");
        if (i3 == 2) {
            setRefreshState(2);
            this.isSuccess = true;
        } else if (i3 == 3) {
            setRefreshState(3);
            this.isSuccess = false;
        } else if (i3 == 1) {
            setRefreshState(6);
        }
        this.mCb.removeCallbacksDelegate(this.mStayRunnable);
        this.mCb.removeOnScrollFinishListener();
        RefreshableCallback refreshableCallback = this.mCb;
        Runnable runnable = this.mStayRunnable;
        if (i3 == 1) {
            j3 = 0;
        }
        refreshableCallback.postDelayedDelegate(runnable, j3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HippyTKDRefreshHeader(RefreshableCallback refreshableCallback) {
        this(refreshableCallback, true);
        if (refreshableCallback instanceof View) {
            this.mHostView = (View) refreshableCallback;
        }
    }
}
