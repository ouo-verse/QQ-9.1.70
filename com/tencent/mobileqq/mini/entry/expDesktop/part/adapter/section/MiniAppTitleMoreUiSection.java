package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.section;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.base.utils.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0018\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/section/MiniAppTitleMoreUiSection;", "", "titleMoreView", "Landroid/view/View;", "(Landroid/view/View;)V", "mModuleArrow", "Landroid/widget/ImageView;", "mRootView", "mRvTitleMoreLl", "Landroid/widget/LinearLayout;", "mRvTitleMoreTv", "Landroid/widget/TextView;", "mRvTitleTv", "bindView", "", "title", "", "getRootView", "getTitleText", "hideMoreLayoutView", "setMoreBtnClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setTitleText", "showMoreLayoutView", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppTitleMoreUiSection {
    private static final String TAG = "MiniAppTitleMoreUiSection";
    private ImageView mModuleArrow;
    private View mRootView;
    private LinearLayout mRvTitleMoreLl;
    private TextView mRvTitleMoreTv;
    private TextView mRvTitleTv;
    private final View titleMoreView;

    public MiniAppTitleMoreUiSection(View titleMoreView) {
        Intrinsics.checkNotNullParameter(titleMoreView, "titleMoreView");
        this.titleMoreView = titleMoreView;
        this.mRootView = titleMoreView;
        this.mRvTitleTv = (TextView) titleMoreView.findViewById(R.id.rjz);
        View findViewById = titleMoreView.findViewById(R.id.rjx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "titleMoreView.findViewBy\u2026module_title_more_layout)");
        this.mRvTitleMoreLl = (LinearLayout) findViewById;
        View findViewById2 = titleMoreView.findViewById(R.id.rjy);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "titleMoreView.findViewBy\u2026d.module_title_more_text)");
        this.mRvTitleMoreTv = (TextView) findViewById2;
        View findViewById3 = titleMoreView.findViewById(R.id.rjw);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "titleMoreView.findViewBy\u2026d.module_title_more_icon)");
        this.mModuleArrow = (ImageView) findViewById3;
    }

    public final void bindView(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        TextView textView = this.mRvTitleTv;
        if (textView != null) {
            textView.setText(title);
        }
        LinearLayout linearLayout = this.mRvTitleMoreLl;
        c cVar = c.f353052a;
        UIUtils.c(linearLayout, cVar.b(10), 0, cVar.b(10), 0);
        this.mModuleArrow.clearColorFilter();
        TextView textView2 = this.mRvTitleTv;
        if (textView2 != null) {
            textView2.setTextColor(this.titleMoreView.getContext().getColor(R.color.qui_common_text_secondary));
        }
        this.mRvTitleMoreTv.setTextColor(this.titleMoreView.getContext().getColor(R.color.qui_common_text_secondary));
    }

    /* renamed from: getRootView, reason: from getter */
    public final View getMRootView() {
        return this.mRootView;
    }

    public final String getTitleText() {
        TextView textView = this.mRvTitleTv;
        return String.valueOf(textView != null ? textView.getText() : null);
    }

    public final void hideMoreLayoutView() {
        this.mRvTitleMoreLl.setVisibility(8);
    }

    public final void setMoreBtnClickListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.mRvTitleMoreLl.setOnClickListener(onClickListener);
    }

    public final void setTitleText(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        TextView textView = this.mRvTitleTv;
        if (textView == null) {
            return;
        }
        textView.setText(title);
    }

    public final void showMoreLayoutView() {
        this.mRvTitleMoreLl.setVisibility(0);
    }
}
