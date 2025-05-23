package com.tencent.mobileqq.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AioTitleLayoutSimple extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private TextView f315390d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f315391e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f315392f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f315393h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f315394i;

    public AioTitleLayoutSimple(Context context) {
        super(context);
        this.f315394i = false;
    }

    private boolean a() {
        if (!this.f315392f && !this.f315394i) {
            return false;
        }
        return true;
    }

    private void b(int i3, int i16, int i17) {
        for (int i18 = 0; i18 < getChildCount(); i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                int left = childAt.getLeft() + i17;
                int right = childAt.getRight() + i17;
                if (QLog.isDevelopLevel()) {
                    QLog.d("AioTitleLayoutSimple", 4, "alignScreenHorizontalCenter() called with: l = [" + i3 + "], r = [" + i16 + "], diff = [" + i17 + "], i = [" + i18 + "], candidateLeft = [" + left + "]", ", candidateRight = [" + right + "]");
                }
                childAt.layout(left, childAt.getTop(), right, childAt.getBottom());
            }
        }
    }

    private int c() {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                return childAt.getLeft();
            }
        }
        return Integer.MAX_VALUE;
    }

    private int d() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                return childAt.getRight();
            }
        }
        return -2147483647;
    }

    private TextView e() {
        if (this.f315390d == null) {
            this.f315390d = (TextView) findViewById(R.id.blz);
        }
        return this.f315390d;
    }

    private TextView f() {
        if (this.f315391e == null) {
            this.f315391e = (TextView) findViewById(R.id.title);
        }
        return this.f315391e;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int measuredWidth;
        int i19;
        int c16;
        if (a()) {
            super.onLayout(z16, i3, i16, i17, i18);
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i26 = 0; i26 < getChildCount(); i26++) {
            View childAt = getChildAt(i26);
            if (childAt.getVisibility() != 8) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                int i27 = paddingLeft + layoutParams.leftMargin;
                int measuredHeight = (getMeasuredHeight() - childAt.getMeasuredHeight()) / 2;
                childAt.layout(i27, measuredHeight, childAt.getMeasuredWidth() + i27, childAt.getMeasuredHeight() + measuredHeight);
                paddingLeft = i27 + childAt.getMeasuredWidth() + layoutParams.rightMargin;
            }
        }
        if (!this.f315393h && getResources().getConfiguration().orientation != 2) {
            measuredWidth = getResources().getDisplayMetrics().widthPixels;
        } else {
            measuredWidth = ((View) getParent()).getMeasuredWidth();
        }
        TextView f16 = f();
        TextView e16 = e();
        int i28 = measuredWidth / 2;
        int left = f16.getLeft() + i3;
        int right = f16.getRight();
        if (e16.isShown()) {
            i19 = e16.getRight();
        } else {
            i19 = Integer.MIN_VALUE;
        }
        int max = i28 - (left + ((Math.max(right, i19) - f16.getLeft()) / 2));
        int i29 = -1;
        if (max == 0) {
            c16 = -1;
        } else if (max > 0) {
            int measuredWidth2 = getMeasuredWidth() - d();
            max = Math.min(measuredWidth2, max);
            c16 = -1;
            i29 = measuredWidth2;
        } else {
            c16 = c();
            max = Math.max(-c16, max);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("AioTitleLayoutSimple", 4, "onLayout() called diff = " + max + ", rightSpace=" + i29 + ", leftSpace=" + c16);
        }
        if (max != 0) {
            b(i3, i17, max);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        this.f315392f = QQTheme.isNowSimpleUI();
        if (a()) {
            super.onMeasure(i3, i16);
        }
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int i17 = 0;
        if (mode == 1073741824) {
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int i18 = 0;
            for (int i19 = 0; i19 < getChildCount(); i19++) {
                View childAt = getChildAt(i19);
                if (childAt.getVisibility() != 8 && childAt.getId() != R.id.title) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    int i26 = layoutParams.width;
                    if (i26 == -2) {
                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    } else if (i26 == -1) {
                        QLog.e("AioTitleLayoutSimple", 1, "onMeasure: ", new IllegalArgumentException("lp.width == ViewGroup.LayoutParams.MATCH_PARENT is not support now"));
                    } else {
                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i26, 1073741824);
                    }
                    int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                    int i27 = layoutParams.height;
                    if (i27 == -2) {
                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                    } else if (i27 == -1) {
                        QLog.e("AioTitleLayoutSimple", 1, "onMeasure: ", new IllegalArgumentException("lp.height == ViewGroup.LayoutParams.MATCH_PARENT is not support now"));
                    } else {
                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i27, 1073741824);
                    }
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                    paddingLeft = paddingLeft + layoutParams.leftMargin + childAt.getMeasuredWidth() + layoutParams.rightMargin;
                    i18 = Math.max(i18, childAt.getMeasuredHeight());
                }
            }
            int i28 = size - paddingLeft;
            if (size < paddingLeft && QLog.isDevelopLevel()) {
                QLog.e("AioTitleLayoutSimple", 4, "onMeasure: ", "icon totalLength = [" + paddingLeft + "]> measuredWidth = [" + size + "]");
            }
            TextView f16 = f();
            f16.setMaxWidth(i28);
            boolean z16 = false;
            do {
                f16.measure(View.MeasureSpec.makeMeasureSpec(i28, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
                Layout layout = f16.getLayout();
                if (layout != null) {
                    int ellipsisStart = layout.getEllipsisStart(0);
                    int ellipsisCount = layout.getEllipsisCount(0);
                    int ellipsizedWidth = layout.getEllipsizedWidth();
                    if (ellipsisCount > 0 && ellipsisStart == 0 && ellipsizedWidth == i28) {
                        float textSize = f16.getTextSize() * 0.75f;
                        QLog.d("AioTitleLayoutSimple", 1, "onMeasure() called with: autoResizeText from = [" + f16.getTextSize() + "], to = [" + textSize + "]");
                        f16.setTextSize(0, textSize);
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                }
            } while (z16);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) f16.getLayoutParams();
            int measuredWidth = paddingLeft + layoutParams2.leftMargin + f16.getMeasuredWidth() + layoutParams2.rightMargin;
            if (size < measuredWidth && QLog.isDevelopLevel()) {
                QLog.e("AioTitleLayoutSimple", 4, "onMeasure: ", "icon totalLength = [" + measuredWidth + "]> measuredWidth = [" + size + "]");
            }
            i17 = Math.max(i18, f16.getMeasuredHeight());
        } else {
            QLog.e("AioTitleLayoutSimple", 1, "onMeasure: ", new IllegalArgumentException("widthMeasureSpec is not support now"));
            size = 0;
        }
        setMeasuredDimension(size, i17);
    }

    public void setIsTroopGuild(boolean z16) {
        this.f315394i = z16;
    }

    public void setMiniChat(boolean z16) {
        this.f315393h = z16;
    }

    public AioTitleLayoutSimple(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315394i = false;
    }
}
