package com.tencent.aelight.camera.aioeditor.capture.view;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingItemView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QIMSlidingTabView extends HorizontalScrollView {
    private static final int[] ATTRS = {R.attr.textSize, R.attr.textColor};
    private static final int DEFAULT_ROUNDED_SIZE = 2;
    public static final String KEY_CHECKED_IMAGE_BG_ID = "checked_image_bg_id";
    public static final String KEY_NOMAL_IMAGE_BG_ID = "normal_image_bg_id";
    private static final String TAG = "SlidingTabView";
    private boolean mCheckX;
    private int mCurrentIndex;
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private int mIndicatorPadding;
    private int mIndicatorStartX;
    private LinearLayout.LayoutParams mLayoutParam;
    private c mListener;
    private Paint mPaint;
    private int mPrevIndex;
    private LinearLayout mRootLayout;
    private int mScrollOffset;
    private ArrayList<View> mTabItemList;
    private int mTabPadding;
    private int mTabStartEndMargin;
    private int mTabTextSize;
    private int mTextColorChecked;
    private int mTextColorNormal;
    private int mUnderlineColor;
    private int mUnderlineHeight;
    private int roundedSize;
    private int roundedSizeDP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f67313d;

        a(int i3) {
            this.f67313d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QIMSlidingTabView.this.onTabChecked(this.f67313d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QIMSlidingTabView.this.mIndicatorStartX = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            QIMSlidingTabView.this.invalidate();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface c {
        void onTabChecked(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public String f67316a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f67317b;

        /* renamed from: c, reason: collision with root package name */
        String f67318c;
    }

    public QIMSlidingTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLayoutParam = null;
        this.mRootLayout = null;
        this.mTabItemList = new ArrayList<>(5);
        this.mTextColorNormal = -7829368;
        this.mTextColorChecked = -16777216;
        this.mTabTextSize = 14;
        this.mTabStartEndMargin = 0;
        this.mTabPadding = 15;
        this.mIndicatorPadding = 0;
        this.mScrollOffset = 52;
        this.mIndicatorStartX = 0;
        this.mIndicatorHeight = 4;
        this.mIndicatorColor = -16776961;
        this.mUnderlineHeight = 1;
        this.mUnderlineColor = -3355444;
        this.mCurrentIndex = 0;
        this.mPrevIndex = 0;
        this.mPaint = null;
        this.roundedSizeDP = 2;
        this.roundedSize = 2;
        this.mCheckX = false;
        initUI(context, attributeSet);
    }

    private void doIndicatorAnimation() {
        int i3 = this.mPrevIndex;
        int i16 = this.mCurrentIndex;
        if (i3 != i16) {
            View childAt = this.mRootLayout.getChildAt(i3);
            View childAt2 = this.mRootLayout.getChildAt(this.mCurrentIndex);
            if (childAt == null || childAt2 == null) {
                return;
            }
            int left = childAt.getLeft();
            int left2 = childAt2.getLeft();
            if (left == 0 && left2 == 0) {
                this.mCheckX = true;
                return;
            }
            this.mCheckX = false;
            ValueAnimator ofInt = ValueAnimator.ofInt(left, left2);
            ofInt.setDuration(100L);
            ofInt.addUpdateListener(new b());
            ofInt.start();
            return;
        }
        this.mIndicatorStartX = this.mRootLayout.getChildAt(i16).getLeft();
        this.mCheckX = true;
        invalidate();
    }

    private void initUI(Context context, AttributeSet attributeSet) {
        this.mLayoutParam = new LinearLayout.LayoutParams(-2, -1);
        LinearLayout linearLayout = new LinearLayout(context);
        this.mRootLayout = linearLayout;
        linearLayout.setOrientation(0);
        this.mRootLayout.setLayoutParams(this.mLayoutParam);
        addView(this.mRootLayout);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mTabStartEndMargin = (int) TypedValue.applyDimension(1, this.mTabStartEndMargin, displayMetrics);
        this.mScrollOffset = (int) TypedValue.applyDimension(1, this.mScrollOffset, displayMetrics);
        this.mIndicatorHeight = (int) TypedValue.applyDimension(1, this.mIndicatorHeight, displayMetrics);
        this.mUnderlineHeight = (int) TypedValue.applyDimension(1, this.mUnderlineHeight, displayMetrics);
        this.mTabPadding = (int) TypedValue.applyDimension(1, this.mTabPadding, displayMetrics);
        this.mTabTextSize = (int) TypedValue.applyDimension(1, this.mTabTextSize, displayMetrics);
        this.mIndicatorPadding = (int) TypedValue.applyDimension(1, this.mIndicatorPadding, displayMetrics);
        context.obtainStyledAttributes(attributeSet, ATTRS).recycle();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.I5);
        this.mTabStartEndMargin = obtainStyledAttributes.getDimensionPixelSize(4, this.mTabStartEndMargin);
        this.mTabPadding = obtainStyledAttributes.getDimensionPixelSize(3, this.mTabPadding);
        this.mIndicatorColor = obtainStyledAttributes.getColor(0, this.mIndicatorColor);
        this.mIndicatorHeight = obtainStyledAttributes.getDimensionPixelSize(1, this.mIndicatorHeight);
        this.mTextColorNormal = obtainStyledAttributes.getColor(6, this.mTextColorNormal);
        this.mTextColorChecked = obtainStyledAttributes.getColor(5, this.mTextColorChecked);
        this.mUnderlineColor = obtainStyledAttributes.getColor(8, this.mUnderlineColor);
        this.mUnderlineHeight = obtainStyledAttributes.getDimensionPixelSize(9, this.mUnderlineHeight);
        this.mTabTextSize = obtainStyledAttributes.getDimensionPixelSize(7, this.mTabTextSize);
        this.mIndicatorPadding = obtainStyledAttributes.getDimensionPixelSize(2, this.mIndicatorPadding);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(this.mIndicatorColor);
        this.mPaint.setStyle(Paint.Style.FILL);
        setFillViewport(true);
        setWillNotDraw(false);
        setHorizontalScrollBarEnabled(false);
        this.roundedSize = ScreenUtil.dip2px(this.roundedSizeDP);
    }

    private void resetTabItemLayoutParams() {
        int childCount = this.mRootLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.mRootLayout.getChildAt(i3);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            if (i3 == 0) {
                layoutParams.setMargins(this.mTabStartEndMargin, 0, 0, 0);
            } else if (i3 == childCount - 1) {
                layoutParams.setMargins(0, 0, this.mTabStartEndMargin, 0);
            }
            childAt.setLayoutParams(layoutParams);
        }
    }

    private void scrollToTab(int i3) {
        View childAt = this.mRootLayout.getChildAt(i3);
        if (childAt != null) {
            int scrollX = getScrollX();
            int i16 = this.mTabPadding * 4;
            int right = ((childAt.getRight() - scrollX) - getWidth()) + i16;
            if (right > 0) {
                smoothScrollBy(right, 0);
                return;
            }
            int left = (childAt.getLeft() - scrollX) - i16;
            if (left < 0) {
                smoothScrollBy(left, 0);
            }
        }
    }

    private void setTabChangeBackgroud(int i3) {
        int childCount = this.mRootLayout.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = this.mRootLayout.getChildAt(i16);
            ArrayList<View> arrayList = this.mTabItemList;
            if (arrayList != null && i16 < arrayList.size()) {
                View view = this.mTabItemList.get(i16);
                if (i16 == i3) {
                    if (view instanceof ImageView) {
                        Bundle bundle = (Bundle) view.getTag();
                        if (bundle != null) {
                            ((ImageView) view).setImageResource(bundle.getInt(KEY_CHECKED_IMAGE_BG_ID, com.tencent.mobileqq.R.drawable.ff5));
                        }
                    } else if (view instanceof RedDotTextView) {
                        RedDotTextView redDotTextView = (RedDotTextView) childAt;
                        redDotTextView.setTextColor(this.mTextColorChecked);
                        redDotTextView.c(false);
                    } else if (view instanceof TextView) {
                        ((TextView) childAt).setTextColor(this.mTextColorChecked);
                    } else if (view instanceof QIMSlidingItemView) {
                        ((QIMSlidingItemView) childAt).a(this.mTextColorChecked, true);
                    }
                } else if (view instanceof ImageView) {
                    Bundle bundle2 = (Bundle) view.getTag();
                    if (bundle2 != null) {
                        ((ImageView) view).setImageResource(bundle2.getInt(KEY_NOMAL_IMAGE_BG_ID, com.tencent.mobileqq.R.drawable.f161987ff4));
                    }
                } else if (view instanceof RedDotTextView) {
                    ((RedDotTextView) childAt).setTextColor(this.mTextColorNormal);
                } else if (view instanceof TextView) {
                    ((TextView) childAt).setTextColor(this.mTextColorNormal);
                } else if (view instanceof QIMSlidingItemView) {
                    ((QIMSlidingItemView) childAt).a(this.mTextColorNormal, false);
                }
            }
        }
    }

    public int getTabCount() {
        return this.mTabItemList.size();
    }

    public ArrayList<View> getmTabItemList() {
        return this.mTabItemList;
    }

    public void initTabItemsWithIconString(ArrayList<QIMSlidingItemView.a> arrayList) {
        this.mRootLayout.removeAllViews();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (arrayList.get(i3).f67311b == 0) {
                TextView textView = new TextView(getContext());
                textView.setText(arrayList.get(i3).f67310a);
                textView.setGravity(17);
                textView.setSingleLine();
                textView.setTextSize(0, this.mTabTextSize);
                int i16 = this.mTabPadding;
                textView.setPadding(i16, 0, i16, 0);
                addTabItem(i3, textView);
            } else {
                QIMSlidingItemView qIMSlidingItemView = new QIMSlidingItemView(getContext());
                qIMSlidingItemView.c(this.mTabTextSize, this.mTabPadding);
                qIMSlidingItemView.setData(arrayList.get(i3));
                addTabItem(i3, qIMSlidingItemView);
            }
        }
        resetTabItemLayoutParams();
        onTabChecked(0);
    }

    public void initTabItemsWithString(ArrayList<String> arrayList, int i3) {
        this.mRootLayout.removeAllViews();
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            TextView textView = new TextView(getContext());
            textView.setText(arrayList.get(i16));
            textView.setGravity(17);
            textView.setSingleLine();
            textView.setTextSize(0, this.mTabTextSize);
            int i17 = this.mTabPadding;
            textView.setPadding(i17, 0, i17, 0);
            addTabItem(i16, textView);
        }
        resetTabItemLayoutParams();
        onTabChecked(i3);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        View childAt = this.mRootLayout.getChildAt(this.mCurrentIndex);
        if (childAt != null) {
            if (this.mCheckX) {
                this.mIndicatorStartX = childAt.getLeft();
                scrollToTab(this.mCurrentIndex);
                this.mCheckX = false;
            }
            if (this.mCurrentIndex == 0 && this.mIndicatorStartX < childAt.getLeft()) {
                this.mIndicatorStartX = childAt.getLeft();
            }
            this.mPaint.setColor(this.mIndicatorColor);
            int i3 = this.mIndicatorStartX;
            RectF rectF = new RectF(this.mIndicatorPadding + i3, height - this.mIndicatorHeight, (i3 + childAt.getWidth()) - this.mIndicatorPadding, height);
            int i16 = this.roundedSize;
            canvas.drawRoundRect(rectF, i16, i16, this.mPaint);
        }
    }

    public void onTabChecked(int i3) {
        ms.a.a(TAG, "selected index: " + i3);
        if (i3 < 0 || i3 >= this.mTabItemList.size()) {
            return;
        }
        this.mCurrentIndex = i3;
        setTabChangeBackgroud(i3);
        scrollToTab(i3);
        doIndicatorAnimation();
        c cVar = this.mListener;
        if (cVar != null) {
            cVar.onTabChecked(i3);
        }
        this.mPrevIndex = this.mCurrentIndex;
    }

    public void setIndicateColor(int i3) {
        this.mIndicatorColor = i3;
        this.mPaint.setColor(i3);
        invalidate();
    }

    public void setTabCheckListener(c cVar) {
        this.mListener = cVar;
    }

    public void initTabItemsWithRedDot(ArrayList<d> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            this.mTabItemList.clear();
            this.mRootLayout.removeAllViews();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                RedDotTextView redDotTextView = new RedDotTextView(getContext());
                redDotTextView.setText(arrayList.get(i3).f67316a);
                redDotTextView.setGravity(17);
                redDotTextView.setSingleLine();
                redDotTextView.setTextSize(0, this.mTabTextSize);
                int i16 = this.mTabPadding;
                redDotTextView.setPadding(i16, 0, i16, 0);
                redDotTextView.c(arrayList.get(i3).f67317b);
                String str = arrayList.get(i3).f67318c;
                if (!TextUtils.isEmpty(str)) {
                    redDotTextView.setContentDescription(str);
                }
                addTabItem(i3, redDotTextView);
            }
            resetTabItemLayoutParams();
            return;
        }
        this.mRootLayout.removeAllViews();
    }

    private int addTabItem(int i3, View view) {
        if (i3 < 0) {
            return -1;
        }
        view.setOnClickListener(new a(i3));
        this.mTabItemList.add(i3, view);
        this.mRootLayout.addView(view, i3);
        return 0;
    }

    public QIMSlidingTabView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mLayoutParam = null;
        this.mRootLayout = null;
        this.mTabItemList = new ArrayList<>(5);
        this.mTextColorNormal = -7829368;
        this.mTextColorChecked = -16777216;
        this.mTabTextSize = 14;
        this.mTabStartEndMargin = 0;
        this.mTabPadding = 15;
        this.mIndicatorPadding = 0;
        this.mScrollOffset = 52;
        this.mIndicatorStartX = 0;
        this.mIndicatorHeight = 4;
        this.mIndicatorColor = -16776961;
        this.mUnderlineHeight = 1;
        this.mUnderlineColor = -3355444;
        this.mCurrentIndex = 0;
        this.mPrevIndex = 0;
        this.mPaint = null;
        this.roundedSizeDP = 2;
        this.roundedSize = 2;
        this.mCheckX = false;
        initUI(context, attributeSet);
    }
}
