package com.tencent.mobileqq.mini.entry.expDesktop.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001#B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\tH\u0014J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\tH\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u001a\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u001f\u0010\u0019\u001a\u00020\f2\u0010\u0010\u001a\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u001bH\u0016\u00a2\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001f\u0010 \u001a\u00020\f2\u0010\u0010\u001a\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u001bH\u0002\u00a2\u0006\u0002\u0010\u001cJ\u0010\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\tH\u0014\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniAppExpDesktopTabBar;", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addTab", "", "position", "title", "", "getCurrentTabText", "getTabMargin", "getUnderLineRect", "", "isSingleTab", "", "setTabClickListener", "tab", "Landroid/view/View;", "setTabData", "arrayText", "", "([Ljava/lang/String;)V", "setTabTextSize", "textSize", "", "updateTabStyle", "updateTextColor", "currentPos", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopTabBar extends QUIPageTabBar {
    private static final String TAG = "MiniAppExpDesktopTabBar";

    public MiniAppExpDesktopTabBar(Context context) {
        super(context);
    }

    private final boolean isSingleTab() {
        String[] strArr = this.mTabTexts;
        return (strArr != null ? strArr.length : 0) <= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTabClickListener$lambda$0(MiniAppExpDesktopTabBar this$0, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setCurrentPosition(i3, false, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void addTab(int position, String title) {
        ColorStateList colorStateList;
        Typeface typeface;
        TextView textView = new TextView(getContext());
        textView.setFocusable(true);
        textView.setText(title);
        textView.setTextSize(this.mTabTextSize);
        if (position == getCurrentPosition()) {
            colorStateList = this.mCheckedTextColor;
        } else {
            colorStateList = this.mUncheckedTextColor;
        }
        textView.setTextColor(colorStateList);
        if (isSingleTab()) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setGravity(80);
            textView.setPadding(0, 0, 0, com.tencent.biz.qui.quicommon.e.a(11.0f));
        } else {
            if (position == getCurrentPosition()) {
                typeface = Typeface.DEFAULT_BOLD;
            } else {
                typeface = Typeface.DEFAULT;
            }
            textView.setTypeface(typeface);
            textView.setGravity(17);
            textView.setPadding(0, 0, 0, 0);
        }
        textView.setSingleLine();
        textView.setTag(Integer.valueOf(position));
        setAccessibilityDelegate(textView);
        setTabClickListener(position, textView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        if (position == 0) {
            layoutParams.leftMargin = 0;
        }
        layoutParams.rightMargin = com.tencent.biz.qui.quicommon.e.a(20.0f);
        this.mTabContainer.addView(textView, position, layoutParams);
    }

    public final String getCurrentTabText() {
        String[] strArr = this.mTabTexts;
        if (strArr != null && strArr.length > getCurrentPosition()) {
            String str = this.mTabTexts[getCurrentPosition()];
            Intrinsics.checkNotNullExpressionValue(str, "mTabTexts[currentPosition]");
            return str;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public int[] getUnderLineRect(int position) {
        View childAt = this.mTabContainer.getChildAt(position);
        if (childAt == null) {
            QLog.e(TAG, 1, "getUnderLineRect, currentTab is null!");
            return new int[]{0, 0, 0, 0};
        }
        int width = childAt.getWidth();
        int height = getHeight();
        int measureText = ((int) (width - this.mPaint.measureText(this.mTabTexts[position]))) / 2;
        int left = childAt.getLeft() + measureText + com.tencent.biz.qui.quicommon.e.a(8.0f);
        int right = (childAt.getRight() - measureText) - com.tencent.biz.qui.quicommon.e.a(8.0f);
        int b16 = (height / 2) + (com.tencent.biz.qui.quicommon.e.b(getContext(), this.mTabTextSize) / 2) + com.tencent.biz.qui.quicommon.e.d(getContext(), 16.0f);
        return new int[]{left, b16, right, com.tencent.biz.qui.quicommon.e.d(getContext(), 3.0f) + b16};
    }

    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void setTabTextSize(float textSize) {
        this.mTabTextSize = textSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void updateTextColor(int currentPos) {
        int childCount = this.mTabContainer.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.mTabContainer.getChildAt(i3);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) childAt;
            if (i3 == currentPos) {
                textView.setTextColor(this.mCheckedTextColor);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                textView.setTextColor(this.mUncheckedTextColor);
                textView.setTypeface(Typeface.DEFAULT);
            }
        }
    }

    public MiniAppExpDesktopTabBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MiniAppExpDesktopTabBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public int getTabMargin() {
        return com.tencent.biz.qui.quicommon.e.a(24.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void setTabClickListener(final int position, View tab) {
        if (tab != null) {
            tab.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.ui.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniAppExpDesktopTabBar.setTabClickListener$lambda$0(MiniAppExpDesktopTabBar.this, position, view);
                }
            });
        }
    }

    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void setTabData(String[] arrayText) {
        if (arrayText != null) {
            if (!(arrayText.length == 0)) {
                String[] strArr = this.mTabTexts;
                boolean z16 = (strArr != null ? strArr.length : 0) != arrayText.length;
                Object clone = arrayText.clone();
                this.mTabTexts = clone instanceof String[] ? (String[]) clone : null;
                if (z16) {
                    updateTabStyle(arrayText);
                }
                notifyDataSetChanged();
            }
        }
    }

    private final void updateTabStyle(String[] arrayText) {
        if (arrayText == null) {
            return;
        }
        if (arrayText.length <= 1) {
            setCheckedColor(getContext().getColorStateList(R.color.qui_common_text_primary));
            setIsShowLine(false);
        } else {
            setCheckedColor(getContext().getColorStateList(R.color.qui_common_text_primary));
            setIsShowLine(true);
        }
    }
}
