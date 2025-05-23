package com.tencent.gdtad.views.crossad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.PathInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.views.image.GdtDrawableLoader;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtCrossView extends RelativeLayout {
    public static final int ERROR_IMAGE_FORMAT_INCORRECT = 1;
    public static final int ERROR_LOAD_IMAGE_FAIL = 0;
    public static final int ERROR_PARAMS_INVALID = 2;
    private static final int STATUS_CLOSED = 1;
    private static final int STATUS_CREATED = 0;
    private static final int STATUS_IMAGE_MOVES_DOWN = 5;
    private static final int STATUS_IMAGE_MOVES_UP = 4;
    private static final int STATUS_LOADING = 2;
    private static final int STATUS_READY = 3;
    private static final String TAG = "GdtCrossView";
    private static final String TEXT_CLOSE_BUTTON = "\u5173\u95ed\u5e7f\u544a\u6d6e\u5c42";
    private Bitmap mBitmap;
    private final Rect mDstRect;
    private final GdtDrawableLoader.Listener mLoaderListener;
    private double mOffsetScale;
    private Params mParams;
    private int mStatus;
    private int mTopOfMInThisView;
    private double mTopOfMInThisViewToTriggerImageDropStart;
    private double mTopOfMInThisViewToTriggerImageDropStop;
    private int mTouchSlopPx;
    private final Handler mUIHandler;
    private WeakReference<Listener> mWeakListener;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface Listener {
        void onClosed();

        void onInteractionTriggered();

        void onShowCrossViewFailed(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class Params {
        public int imageWidthPx = Integer.MIN_VALUE;
        public int imageHeightPx = Integer.MIN_VALUE;
        public String imageUrl = null;
        public int topOfHOnScreen = Integer.MIN_VALUE;

        public boolean isValid() {
            if (this.imageWidthPx > 0 && this.topOfHOnScreen > 0 && this.imageHeightPx > 0 && !TextUtils.isEmpty(this.imageUrl)) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (GdtCrossView.this.mStatus != 1) {
                GdtCrossView gdtCrossView = GdtCrossView.this;
                gdtCrossView.startAnimation(gdtCrossView.createAlphaAnimation());
                GdtCrossView.this.changeStatus(1);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public GdtCrossView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeStatus(int i3) {
        int i16 = this.mStatus;
        if (i3 == i16) {
            return;
        }
        this.mStatus = i3;
        GdtLog.d(TAG, "[changeStatus] pre: " + i16 + " now: " + this.mStatus);
        int i17 = this.mStatus;
        boolean z16 = false;
        if (i17 != 4) {
            if (i17 == 5 && i16 == 3) {
                try {
                    ((Vibrator) getContext().getSystemService("vibrator")).vibrate(200L);
                    GdtLog.d(TAG, "[vibrator]");
                } catch (Throwable th5) {
                    GdtLog.e(TAG, "[vibrator] error", th5);
                }
            }
        } else if (i16 == 5 || i16 == 3) {
            z16 = true;
        }
        if (z16) {
            GdtLog.d(TAG, "[triggerInteraction]");
            notifyTriggerInteraction();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AlphaAnimation createAlphaAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setInterpolator(new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f));
        alphaAnimation.setAnimationListener(new a());
        return alphaAnimation;
    }

    @NonNull
    private TextView createCloseButtonView() {
        TextView textView = new TextView(getContext());
        textView.setText(TEXT_CLOSE_BUTTON);
        textView.setTextSize(1, 12.0f);
        textView.setTextColor(-1);
        textView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(GdtUIUtils.dp2px(96.0f, getResources()), GdtUIUtils.dp2px(28.0f, getResources()));
        layoutParams.addRule(21);
        layoutParams.topMargin = GdtUIUtils.dp2px(8.0f, getResources());
        textView.setLayoutParams(layoutParams);
        textView.setOnClickListener(new b());
        int dp2px = GdtUIUtils.dp2px(14.0f, getResources());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dp2px);
        gradientDrawable.setColor(-1721342362);
        textView.setBackground(gradientDrawable);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyClose() {
        Listener listener;
        WeakReference<Listener> weakReference = this.mWeakListener;
        if (weakReference != null) {
            listener = weakReference.get();
        } else {
            listener = null;
        }
        if (listener != null) {
            listener.onClosed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFailed(int i3) {
        Listener listener;
        WeakReference<Listener> weakReference = this.mWeakListener;
        if (weakReference != null) {
            listener = weakReference.get();
        } else {
            listener = null;
        }
        if (listener != null) {
            listener.onShowCrossViewFailed(i3);
        }
    }

    private void notifyTriggerInteraction() {
        Listener listener;
        WeakReference<Listener> weakReference = this.mWeakListener;
        if (weakReference != null) {
            listener = weakReference.get();
        } else {
            listener = null;
        }
        if (listener != null) {
            listener.onInteractionTriggered();
        }
    }

    public void init(Params params) {
        int i3;
        if (!isInitialized() && getHeight() != 0) {
            if (params != null && params.isValid()) {
                this.mParams = params;
                GdtDrawableLoader gdtDrawableLoader = new GdtDrawableLoader(params.imageUrl, 5000L, new WeakReference(this.mLoaderListener));
                changeStatus(2);
                gdtDrawableLoader.load();
                Rect rect = this.mDstRect;
                rect.left = 0;
                rect.right = this.mParams.imageWidthPx;
                this.mTopOfMInThisViewToTriggerImageDropStop = getHeight() * 0.627d;
                double height = getHeight() * 0.738d;
                this.mTopOfMInThisViewToTriggerImageDropStart = height;
                double d16 = this.mTopOfMInThisViewToTriggerImageDropStop;
                this.mOffsetScale = (this.mParams.imageHeightPx + d16) / (height - d16);
                if (getContext() != null) {
                    ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
                    if (viewConfiguration != null) {
                        i3 = viewConfiguration.getScaledTouchSlop();
                    } else {
                        i3 = 16;
                    }
                    this.mTouchSlopPx = i3;
                }
                if (this.mTouchSlopPx <= 0) {
                    this.mTouchSlopPx = 16;
                    return;
                }
                return;
            }
            GdtLog.e(TAG, "[init] error, rect is null");
            notifyFailed(2);
        }
    }

    public boolean isInitialized() {
        int i3 = this.mStatus;
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 5 || i3 == 4) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Params params;
        super.onDraw(canvas);
        if (canvas != null && this.mBitmap != null && (params = this.mParams) != null && params.isValid()) {
            canvas.clipRect(0, 0, this.mParams.imageWidthPx, this.mTopOfMInThisView);
            canvas.drawBitmap(this.mBitmap, (Rect) null, this.mDstRect, (Paint) null);
        } else {
            GdtLog.e(TAG, "[onDraw] error");
        }
    }

    public void onRecycled() {
        GdtLog.i(TAG, "[onRecycled]");
        changeStatus(0);
        this.mBitmap = null;
        setVisibility(8);
    }

    public void setListener(WeakReference<Listener> weakReference) {
        this.mWeakListener = weakReference;
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        if (i3 == getVisibility()) {
            return;
        }
        super.setVisibility(i3);
    }

    public void update(int i3) {
        Params params;
        if (isInitialized() && (params = this.mParams) != null && params.isValid()) {
            Params params2 = this.mParams;
            int i16 = i3 - params2.topOfHOnScreen;
            this.mTopOfMInThisView = i16;
            double d16 = i16;
            double d17 = this.mTopOfMInThisViewToTriggerImageDropStop;
            int i17 = 4;
            if (d16 < d17) {
                Rect rect = this.mDstRect;
                int i18 = (int) d17;
                rect.top = i18;
                rect.bottom = i18 + params2.imageHeightPx;
                setVisibility(4);
                changeStatus(3);
                return;
            }
            double d18 = i16;
            double d19 = this.mTopOfMInThisViewToTriggerImageDropStart;
            if (d18 > d19) {
                Rect rect2 = this.mDstRect;
                rect2.top = -params2.imageHeightPx;
                rect2.bottom = 0;
                setVisibility(4);
                changeStatus(3);
                return;
            }
            int i19 = this.mDstRect.top;
            int i26 = (int) ((this.mOffsetScale * (d19 - i16)) - params2.imageHeightPx);
            if (Math.abs(i26 - i19) < this.mTouchSlopPx) {
                return;
            }
            Rect rect3 = this.mDstRect;
            rect3.top = i26;
            rect3.bottom = i26 + this.mParams.imageHeightPx;
            setVisibility(0);
            if (i19 < this.mDstRect.top) {
                i17 = 5;
            }
            changeStatus(i17);
            invalidate();
        }
    }

    public GdtCrossView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDstRect = new Rect();
        this.mWeakListener = null;
        this.mStatus = 0;
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.mLoaderListener = new GdtDrawableLoader.Listener() { // from class: com.tencent.gdtad.views.crossad.GdtCrossView.1
            @Override // com.tencent.gdtad.views.image.GdtDrawableLoader.Listener
            public void onLoadFailed(URLDrawable uRLDrawable) {
                GdtLog.e(GdtCrossView.TAG, "[onLoadFailed]");
                GdtCrossView.this.mUIHandler.post(new Runnable() { // from class: com.tencent.gdtad.views.crossad.GdtCrossView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        GdtCrossView.this.notifyFailed(0);
                        GdtCrossView.this.changeStatus(0);
                    }
                });
            }

            @Override // com.tencent.gdtad.views.image.GdtDrawableLoader.Listener
            public void onLoadSuccessful(final URLDrawable uRLDrawable) {
                GdtLog.d(GdtCrossView.TAG, "[onLoadSuccessful]");
                GdtCrossView.this.mUIHandler.post(new Runnable() { // from class: com.tencent.gdtad.views.crossad.GdtCrossView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        URLDrawable uRLDrawable2 = uRLDrawable;
                        if (uRLDrawable2 == null || !(uRLDrawable2.getCurrDrawable() instanceof RegionDrawable)) {
                            GdtCrossView.this.notifyFailed(1);
                            GdtCrossView.this.changeStatus(0);
                        } else {
                            GdtCrossView.this.mBitmap = ((RegionDrawable) uRLDrawable.getCurrDrawable()).getBitmap();
                            GdtCrossView.this.changeStatus(3);
                        }
                    }
                });
            }
        };
        setWillNotDraw(false);
        addView(createCloseButtonView());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            GdtCrossView.this.notifyClose();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
