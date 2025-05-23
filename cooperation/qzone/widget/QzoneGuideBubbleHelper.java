package cooperation.qzone.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qzonehub.api.IQzoneGuideBubbleHelperProxy;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QzoneGuideBubbleHelper {
    public static final long GUIDE_BUBBLE_NODELAY = 0;
    public static final int GUIDE_DIRECTION_BOTTOM = 1;
    public static final int GUIDE_DIRECTION_TOP = 0;
    public static final int GUIDE_SHOW_TYPE_POPUPWINDOW = 0;
    public static final int GUIDE_SHOW_TYPE_SUBVIEW = 1;
    private static volatile QzoneGuideBubbleHelper sInstance;
    private QzoneBubblePopWindow mPopupWindow;
    private Handler mHandler = new Handler();
    private WeakReference<Context> mContext = null;
    private Runnable disMissRunnable = new Runnable() { // from class: cooperation.qzone.widget.QzoneGuideBubbleHelper.1
        @Override // java.lang.Runnable
        public void run() {
            QzoneGuideBubbleHelper.this.dismissGuideBubble();
        }
    };
    private int mShowType = 0;
    private WeakReference<View> mAtachView = null;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class CompoundDrawableInfo {
        public int drawableHeight;
        public int drawableId;
        public int drawableMarginRight;
        public String drawableUrl;
        public int drawableWidth;

        public void setDrawableHeight(int i3) {
            this.drawableHeight = i3;
        }

        public void setDrawableId(int i3) {
            this.drawableId = i3;
        }

        public void setDrawableUrl(String str) {
            this.drawableUrl = str;
        }

        public void setDrawableWidth(int i3) {
            this.drawableWidth = i3;
        }
    }

    private int[] createContentView(ViewGroup viewGroup, View view, String str, float f16, int i3, int i16, CompoundDrawableInfo compoundDrawableInfo, int i17, int i18) {
        int i19;
        Drawable drawable;
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        Rect viewAbsoluteLocation = getViewAbsoluteLocation(view);
        if (viewAbsoluteLocation.left <= 0 && viewAbsoluteLocation.right <= 0 && viewAbsoluteLocation.top <= 0 && viewAbsoluteLocation.bottom <= 0) {
            return null;
        }
        TextView textView = new TextView(this.mContext.get());
        textView.setId(R.id.hjb);
        textView.setTextColor(-1);
        textView.setTextSize(f16);
        textView.setText(str);
        int dimensionPixelSize = this.mContext.get().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.apq);
        if (compoundDrawableInfo != null && (drawable = this.mContext.get().getResources().getDrawable(compoundDrawableInfo.drawableId)) != null) {
            drawable.setBounds(0, 0, compoundDrawableInfo.drawableWidth, compoundDrawableInfo.drawableHeight);
            textView.setCompoundDrawables(drawable, null, null, null);
            textView.setCompoundDrawablePadding(compoundDrawableInfo.drawableMarginRight);
        }
        int dimensionPixelSize2 = this.mContext.get().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.aps);
        int dimensionPixelSize3 = this.mContext.get().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.apr);
        textView.setPadding(dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize2);
        textView.setGravity(17);
        if (i18 > 0) {
            textView.setMaxLines(i18);
            textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        }
        int dimensionPixelSize4 = this.mContext.get().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.apt);
        setViewBackground(textView, createRoundCornerShapeDrawable(dimensionPixelSize4, 0.0f, i16));
        View triangleView = new TriangleView(this.mContext.get(), i3, i16);
        triangleView.setId(R.id.hj_);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int dimensionPixelSize5 = this.mContext.get().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.app);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimensionPixelSize5, this.mContext.get().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.apo));
        if (i3 == 0) {
            layoutParams.addRule(10);
            layoutParams2.addRule(3, R.id.hjb);
        } else if (i3 == 1) {
            layoutParams.addRule(3, R.id.hj_);
        }
        layoutParams.addRule(14);
        layoutParams2.leftMargin = i17;
        viewGroup.addView(textView, layoutParams);
        viewGroup.addView(triangleView, layoutParams2);
        int dpToPx = dpToPx(12.0f);
        viewGroup.measure(View.MeasureSpec.makeMeasureSpec(getScreenWidth() - (dpToPx(12.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = viewGroup.getMeasuredWidth();
        int measuredHeight = viewGroup.getMeasuredHeight();
        int i26 = viewAbsoluteLocation.left;
        int i27 = (i26 + ((viewAbsoluteLocation.right - i26) / 2)) - (measuredWidth / 2);
        if (i3 == 0) {
            i19 = (viewAbsoluteLocation.top - measuredHeight) - dimensionPixelSize;
        } else {
            i19 = viewAbsoluteLocation.bottom + dimensionPixelSize;
            measuredHeight = 0;
        }
        int screenWidth = getScreenWidth();
        if (i27 >= dpToPx && i27 <= (dpToPx = (screenWidth - measuredWidth) - dpToPx)) {
            dpToPx = i27;
        }
        int i28 = viewAbsoluteLocation.left;
        int i29 = (i28 - dpToPx) + (((viewAbsoluteLocation.right - i28) - dimensionPixelSize5) / 2);
        if (i29 >= dimensionPixelSize4) {
            int i36 = measuredWidth - dimensionPixelSize4;
            if (i29 + dimensionPixelSize5 > i36) {
                dimensionPixelSize4 = i36 - dimensionPixelSize5;
            } else {
                dimensionPixelSize4 = i29;
            }
        }
        ((IQzoneGuideBubbleHelperProxy) QRoute.api(IQzoneGuideBubbleHelperProxy.class)).setX(triangleView, dimensionPixelSize4);
        return new int[]{dpToPx, i19, dimensionPixelSize4, measuredHeight};
    }

    private int[] createGuideBubble(View view, ViewGroup viewGroup, String str, float f16, int i3, double d16, double d17, int i16, boolean z16, CompoundDrawableInfo compoundDrawableInfo, int i17, int i18) {
        WeakReference<Context> weakReference;
        if (this.mShowType == 0 && this.mPopupWindow == null && (weakReference = this.mContext) != null && weakReference.get() != null) {
            QzoneBubblePopWindow qzoneBubblePopWindow = new QzoneBubblePopWindow(this.mContext.get());
            this.mPopupWindow = qzoneBubblePopWindow;
            qzoneBubblePopWindow.setWidth(-2);
            this.mPopupWindow.setHeight(-2);
            this.mPopupWindow.setTouchable(z16);
            if (z16) {
                viewGroup.setOnTouchListener(new View.OnTouchListener() { // from class: cooperation.qzone.widget.QzoneGuideBubbleHelper.2
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        QzoneGuideBubbleHelper.this.dismissGuideBubble();
                        return false;
                    }
                });
            }
            this.mPopupWindow.setOutsideTouchable(true);
            this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
        }
        int[] createContentView = createContentView(viewGroup, view, str, f16, i3, i16, compoundDrawableInfo, i17, i18);
        if (createContentView == null) {
            return createContentView;
        }
        QzoneBubblePopWindow qzoneBubblePopWindow2 = this.mPopupWindow;
        if (qzoneBubblePopWindow2 != null) {
            qzoneBubblePopWindow2.setContentView(viewGroup);
            this.mPopupWindow.update();
        }
        return createContentView;
    }

    public static ShapeDrawable createRoundCornerShapeDrawable(float f16, float f17, int i3) {
        float[] fArr = new float[8];
        float[] fArr2 = new float[8];
        for (int i16 = 0; i16 < 8; i16++) {
            fArr[i16] = f16 + f17;
            fArr2[i16] = f16;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, new RectF(f17, f17, f17, f17), fArr2));
        shapeDrawable.getPaint().setColor(i3);
        return shapeDrawable;
    }

    private static FrameLayout getBubbleParentView(Context context) {
        if (context != null && (context instanceof Activity)) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) context).getWindow().getDecorView();
            FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(R.id.hja);
            if (frameLayout == null) {
                return (FrameLayout) viewGroup.findViewById(android.R.id.content);
            }
            return frameLayout;
        }
        return null;
    }

    public static QzoneGuideBubbleHelper getInstance() {
        if (sInstance == null) {
            synchronized (QzoneGuideBubbleHelper.class) {
                if (sInstance == null) {
                    sInstance = new QzoneGuideBubbleHelper();
                }
            }
        }
        return sInstance;
    }

    private static Rect getViewAbsoluteLocation(View view) {
        if (view == null) {
            return new Rect();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        return new Rect(i3, iArr[1], view.getMeasuredWidth() + i3, iArr[1] + view.getMeasuredHeight());
    }

    public void dismissGuideBubble() {
        WeakReference<Context> weakReference;
        FrameLayout bubbleParentView;
        View findViewById;
        int i3 = this.mShowType;
        if (i3 != 0) {
            if (i3 == 1 && (weakReference = this.mContext) != null && (bubbleParentView = getBubbleParentView(weakReference.get())) != null && (findViewById = bubbleParentView.findViewById(R.id.hjc)) != null) {
                bubbleParentView.removeViewInLayout(findViewById);
                return;
            }
            return;
        }
        if (this.mPopupWindow != null) {
            this.mHandler.removeCallbacks(this.disMissRunnable);
            try {
                this.mPopupWindow.dismiss();
                this.mPopupWindow = null;
            } catch (Exception unused) {
            }
        }
    }

    public int dpToPx(float f16) {
        return Math.round(f16 * getDensity());
    }

    public float getDensity() {
        return BaseApplication.getContext().getResources().getDisplayMetrics().density;
    }

    public int getScreenWidth() {
        int i3;
        if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2) {
            int i16 = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
            i3 = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
            if (i16 > i3) {
                return i16;
            }
        } else {
            int i17 = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
            i3 = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
            if (i3 > i17) {
                return i17;
            }
        }
        return i3;
    }

    @TargetApi(16)
    public void setViewBackground(View view, Drawable drawable) {
        if (view == null) {
            return;
        }
        view.setBackground(drawable);
    }

    public void showGuideBubble(Activity activity, View view, String str, int i3, float f16, double d16, double d17, long j3, int i16, boolean z16, boolean z17, int i17, CompoundDrawableInfo compoundDrawableInfo, int i18) {
        showGuideBubble(activity, view, str, i3, f16, d16, d17, j3, i16, z16, z17, i17, compoundDrawableInfo, i18, 0, 0);
    }

    public void showGuideBubble(Activity activity, View view, String str, int i3, float f16, double d16, double d17, long j3, int i16, boolean z16, boolean z17, int i17, CompoundDrawableInfo compoundDrawableInfo, int i18, int i19, int i26) {
        FrameLayout bubbleParentView;
        this.mShowType = i26;
        dismissGuideBubble();
        if (activity == null || view == null || i3 < 0 || i3 > 1) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mContext = new WeakReference<>(activity);
        RelativeLayout relativeLayout = new RelativeLayout(activity);
        int i27 = this.mShowType;
        if (i27 == 0) {
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        } else if (i27 == 1) {
            relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        }
        int[] createGuideBubble = createGuideBubble(view, relativeLayout, str, f16, i3, d16, d17, i16, z17, compoundDrawableInfo, i18, i19);
        if (createGuideBubble == null) {
            return;
        }
        int i28 = createGuideBubble[0] - i18;
        int i29 = createGuideBubble[1];
        int i36 = i17;
        if (i3 == 0) {
            i36 = -i36;
        }
        int i37 = i29 + i36;
        int i38 = this.mShowType;
        if (i38 == 0) {
            try {
                this.mPopupWindow.showAtLocation(view, 0, i28, i37);
                relativeLayout.setVisibility(0);
                if (j3 > 0) {
                    this.mHandler.postDelayed(this.disMissRunnable, j3);
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (i38 == 1 && (bubbleParentView = getBubbleParentView(this.mContext.get())) != null) {
            relativeLayout.setId(R.id.hjc);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.leftMargin = Math.max(i28, ViewUtils.dip2px(12.0f));
            layoutParams.topMargin = i37;
            layoutParams.rightMargin = ViewUtils.dip2px(12.0f);
            bubbleParentView.addView(relativeLayout);
        }
    }
}
