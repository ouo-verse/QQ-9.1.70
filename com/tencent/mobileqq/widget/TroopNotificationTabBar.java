package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TroopNotificationTabBar extends QUIPageTabBar {

    /* renamed from: d, reason: collision with root package name */
    protected boolean[] f316486d;

    /* renamed from: e, reason: collision with root package name */
    protected int[] f316487e;

    public TroopNotificationTabBar(Context context) {
        this(context, null);
    }

    private int b() {
        int[] iArr = this.f316487e;
        if (iArr == null || iArr.length == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i16 : iArr) {
            if (i16 == 0) {
                i3++;
            }
        }
        return i3;
    }

    private void c() {
        this.mMinTabMargin = ViewUtils.dip2px(3.0f);
    }

    protected void a(int i3, String str, boolean z16) {
        ColorStateList colorStateList;
        RedDotTextView redDotTextView = new RedDotTextView(getContext());
        redDotTextView.c(z16);
        redDotTextView.setFocusable(true);
        redDotTextView.setText(str);
        redDotTextView.setTextSize(17.0f);
        if (i3 == getCurrentPosition()) {
            colorStateList = this.mCheckedTextColor;
        } else {
            colorStateList = this.mUncheckedTextColor;
        }
        redDotTextView.setTextColor(colorStateList);
        redDotTextView.setGravity(17);
        redDotTextView.setSingleLine();
        redDotTextView.setTag(Integer.valueOf(i3));
        redDotTextView.setPadding(ViewUtils.dip2px(9.0f), 0, ViewUtils.dip2px(9.0f), 0);
        setAccessibilityDelegate(redDotTextView);
        setTabClickListener(i3, redDotTextView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        if (i3 == 0) {
            layoutParams.leftMargin = getTabMargin() + ViewUtils.dip2px(9.0f);
        }
        if (i3 == this.mTabCount - 1) {
            layoutParams.rightMargin = getTabMargin() + ViewUtils.dip2px(9.0f);
        } else {
            layoutParams.rightMargin = getTabMargin();
        }
        this.mTabContainer.addView(redDotTextView, i3, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public int getTabMargin() {
        if (this.mTabTexts == null) {
            return this.mMinTabMargin;
        }
        int i3 = this.mWidth;
        if (i3 == 0) {
            i3 = ViewUtils.getScreenWidth();
        }
        int dip2px = ViewUtils.dip2px(9.0f) * 2;
        int i16 = 0;
        while (true) {
            String[] strArr = this.mTabTexts;
            if (i16 < strArr.length) {
                if (this.f316487e[i16] == 0) {
                    dip2px = (int) (dip2px + this.mPaint.measureText(strArr[i16]) + (ViewUtils.dip2px(9.0f) * 2));
                }
                i16++;
            } else {
                return Math.max(this.mMinTabMargin, (i3 - dip2px) / (this.mTabCount + 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public int[] getUnderLineRect(int i3) {
        RedDotTextView redDotTextView = (RedDotTextView) this.mTabContainer.getChildAt(i3);
        if (redDotTextView == null) {
            QLog.e("TroopNotificationTabBar", 1, "getUnderLineRect, currentTab is null!");
            return new int[]{0, 0, 0, 0};
        }
        int width = redDotTextView.getWidth();
        int height = getHeight();
        int measureText = ((int) (width - this.mPaint.measureText(redDotTextView.getText().toString()))) / 2;
        int left = redDotTextView.getLeft() + measureText;
        int right = redDotTextView.getRight() - measureText;
        int dip2px = (height / 2) + (ViewUtils.dip2px(17.0f) / 2) + ViewUtils.dpToPx(5.0f);
        return new int[]{left, dip2px, right, ViewUtils.dpToPx(2.0f) + dip2px};
    }

    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void notifyDataSetChanged() {
        boolean[] zArr;
        int[] iArr;
        String[] strArr = this.mTabTexts;
        if (strArr != null && strArr.length != 0 && (zArr = this.f316486d) != null && zArr.length != 0 && (iArr = this.f316487e) != null && iArr.length != 0 && strArr.length == zArr.length && strArr.length == iArr.length) {
            ViewPager viewPager = this.mViewPager;
            if (viewPager != null && (viewPager.getAdapter() == null || this.mViewPager.getAdapter().getCount() != this.mTabTexts.length)) {
                QLog.e("TroopNotificationTabBar", 1, "tabTexts size not match pages size");
                return;
            }
            this.mTabContainer.removeAllViews();
            this.mTabCount = b();
            int i3 = 0;
            int i16 = 0;
            while (true) {
                String[] strArr2 = this.mTabTexts;
                if (i3 < strArr2.length) {
                    if (this.f316487e[i3] == 0) {
                        a(i16, strArr2[i3], this.f316486d[i3]);
                        i16++;
                    }
                    i3++;
                } else {
                    this.mAnimationStartX = 0;
                    return;
                }
            }
        } else {
            QLog.e("TroopNotificationTabBar", 1, "tabTexts or tabShowRed is empty!");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void setCurrentPosition(int i3, boolean z16, boolean z17) {
        if (this.mTabCount == 0) {
            QLog.e("TroopNotificationTabBar", 1, "setCurrentPosition: tabCount = 0");
        } else {
            super.setCurrentPosition(i3, z16, z17);
        }
    }

    public void setTabShowRed(boolean[] zArr) {
        if (zArr != null && zArr.length != 0) {
            this.f316486d = (boolean[]) zArr.clone();
            notifyDataSetChanged();
        }
    }

    public void setTabVisibility(int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            this.f316487e = (int[]) iArr.clone();
            notifyDataSetChanged();
        }
    }

    public TroopNotificationTabBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TroopNotificationTabBar(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public TroopNotificationTabBar(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        c();
    }
}
