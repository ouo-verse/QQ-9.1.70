package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.guild.util.TraceUtils;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildBannerTitleLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private long[] f235815d;

    /* renamed from: e, reason: collision with root package name */
    private int f235816e;

    public GuildBannerTitleLayout(Context context) {
        this(context, null);
    }

    private void a() {
        b();
        Arrays.fill(this.f235815d, 0L);
        this.f235816e = 0;
    }

    private void b() {
        if (this.f235815d == null) {
            this.f235815d = new long[4];
        }
    }

    private long c(long j3) {
        b();
        int i3 = 0;
        while (true) {
            long[] jArr = this.f235815d;
            if (i3 < jArr.length) {
                if (jArr[i3] == j3) {
                    return jArr[i3 + 1];
                }
                i3 += 2;
            } else {
                return -1L;
            }
        }
    }

    private boolean d() {
        if (getChildCount() > 0 && (getChildAt(0) instanceof TextView)) {
            return false;
        }
        return true;
    }

    private void e(long j3, long j16) {
        long[] jArr = this.f235815d;
        int i3 = this.f235816e;
        jArr[i3] = j3;
        jArr[i3 + 1] = j16;
        this.f235816e = (i3 + 2) % jArr.length;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00a5  */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int lineWidth;
        int i19;
        if (d()) {
            super.onLayout(z16, i3, i16, i17, i18);
            return;
        }
        TextView textView = (TextView) getChildAt(0);
        int measuredWidth = textView.getMeasuredWidth();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
        int paddingLeft = getPaddingLeft() + layoutParams.leftMargin;
        int paddingTop = layoutParams.topMargin + getPaddingTop() + textView.getMeasuredHeight();
        textView.layout(paddingLeft, paddingTop - textView.getMeasuredHeight(), paddingLeft + measuredWidth, paddingTop);
        int i26 = layoutParams.leftMargin + layoutParams.rightMargin + measuredWidth;
        int maxLines = textView.getMaxLines();
        int paddingLeft2 = getPaddingLeft();
        if (maxLines >= 2) {
            StaticLayout staticLayout = new StaticLayout(textView.getText(), textView.getPaint(), measuredWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            if (staticLayout.getLineCount() >= 2) {
                lineWidth = paddingLeft2 + layoutParams.leftMargin + layoutParams.rightMargin + ((int) staticLayout.getLineWidth(Math.min(maxLines, staticLayout.getLineCount()) - 1));
                Paint.FontMetrics fontMetrics = textView.getPaint().getFontMetrics();
                float f16 = fontMetrics.descent - fontMetrics.ascent;
                int paddingBottom = paddingTop - textView.getPaddingBottom();
                for (i19 = 1; i19 < getChildCount(); i19++) {
                    View childAt = getChildAt(i19);
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                    if (childAt.getVisibility() == 0) {
                        int i27 = lineWidth + layoutParams2.leftMargin;
                        int measuredHeight = paddingBottom - ((int) ((f16 - childAt.getMeasuredHeight()) / 2.0f));
                        childAt.layout(i27, measuredHeight - childAt.getMeasuredHeight(), childAt.getMeasuredWidth() + i27, measuredHeight);
                        lineWidth = i27 + childAt.getMeasuredWidth() + layoutParams2.rightMargin;
                    }
                }
            }
        }
        lineWidth = paddingLeft2 + i26;
        Paint.FontMetrics fontMetrics2 = textView.getPaint().getFontMetrics();
        float f162 = fontMetrics2.descent - fontMetrics2.ascent;
        int paddingBottom2 = paddingTop - textView.getPaddingBottom();
        while (i19 < getChildCount()) {
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (d()) {
            return;
        }
        long j3 = (i3 << 32) | (i16 & 4294967295L);
        long c16 = c(j3);
        if (c16 >= 0) {
            setMeasuredDimension((int) (c16 >> 32), (int) c16);
            return;
        }
        TraceUtils.h("GuildBannerTitleLayout.onMeasure");
        int i17 = 0;
        for (int i18 = 1; i18 < getChildCount(); i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() == 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i17 += childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            }
        }
        View childAt2 = getChildAt(0);
        int measuredHeight = childAt2.getMeasuredHeight();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) childAt2.getLayoutParams();
        int measuredWidth = ((((getMeasuredWidth() - i17) - layoutParams2.leftMargin) - layoutParams2.rightMargin) - getPaddingLeft()) - getPaddingRight();
        measureChild(childAt2, View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), i16);
        int measuredHeight2 = childAt2.getMeasuredHeight();
        int size = View.MeasureSpec.getSize(i3);
        int measuredHeight3 = (getMeasuredHeight() - measuredHeight) + measuredHeight2;
        e(j3, (4294967295L & measuredHeight3) | (size << 32));
        setMeasuredDimension(size, measuredHeight3);
        Log.d("GuildBannerTitleLayout", System.identityHashCode(this) + " onMeasure: " + measuredWidth + "/" + i17 + ", beforeHeight = " + measuredHeight + ", afterHeight = " + measuredHeight2);
        TraceUtils.k();
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        a();
    }

    public GuildBannerTitleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildBannerTitleLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f235816e = 0;
    }
}
