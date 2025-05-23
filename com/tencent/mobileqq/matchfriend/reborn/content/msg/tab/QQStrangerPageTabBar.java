package com.tencent.mobileqq.matchfriend.reborn.content.msg.tab;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0006B\u001b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0014\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/tab/QQStrangerPageTabBar;", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "", "getTabMargin", "position", "Landroid/view/View;", "a", "currentPos", "", "updateTextColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "d", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerPageTabBar extends QUIPageTabBar {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerPageTabBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void updateTextColor(int currentPos) {
        int childCount = this.mTabContainer.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.mTabContainer.getChildAt(i3);
            TextView textView = childAt instanceof TextView ? (TextView) childAt : null;
            if (textView == null) {
                QLog.e("QQStrangerPageTabBar", 1, "updateTextColor, but textview is null.");
                return;
            }
            if (i3 == currentPos) {
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                textView.setTextColor(this.mCheckedTextColor);
            } else {
                textView.setTypeface(Typeface.DEFAULT);
                textView.setTextColor(this.mUncheckedTextColor);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public int getTabMargin() {
        return l.b(32);
    }

    public final View a(int position) {
        if (position < 0 || position >= this.mTabTexts.length || position >= this.mTabContainer.getChildCount()) {
            return null;
        }
        return this.mTabContainer.getChildAt(position);
    }
}
