package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.section;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.expDesktop.ui.MiniAppExpDesktopTabBar;
import com.tencent.qqnt.base.utils.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u00a2\u0006\u0004\b)\u0010*J%\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\n\u001a\u00020\u0003J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/section/MiniAppTabBarMoreUiSection;", "", "", "", "tabData", "", "textSize", "", "bindView", "([Ljava/lang/String;F)V", "getCurrentTabText", "Landroid/view/View$OnClickListener;", "onClickListener", "setMoreBtnClickListener", "hideMoreLayoutView", "", "position", "setCurrentPosition", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar$i;", "onTabChangeListener", "setTabBarChangeListener", "setMoreListener", "Landroid/view/View;", "getRootView", "miniAppMoreRootView", "Landroid/view/View;", "mRootView", "Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniAppExpDesktopTabBar;", "mTabBar", "Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniAppExpDesktopTabBar;", "Landroid/widget/LinearLayout;", "mRvTitleMoreLl", "Landroid/widget/LinearLayout;", "Landroid/widget/TextView;", "mRvTitleMoreTv", "Landroid/widget/TextView;", "Landroid/widget/ImageView;", "mModuleArrow", "Landroid/widget/ImageView;", "size", "I", "<init>", "(Landroid/view/View;)V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniAppTabBarMoreUiSection {
    private static final String TAG = "MiniAppTabBarMoreUiSection";
    private ImageView mModuleArrow;
    private View mRootView;
    private LinearLayout mRvTitleMoreLl;
    private TextView mRvTitleMoreTv;
    private MiniAppExpDesktopTabBar mTabBar;
    private final View miniAppMoreRootView;
    private int size;

    public MiniAppTabBarMoreUiSection(View miniAppMoreRootView) {
        Intrinsics.checkNotNullParameter(miniAppMoreRootView, "miniAppMoreRootView");
        this.miniAppMoreRootView = miniAppMoreRootView;
        this.mRootView = miniAppMoreRootView;
        View findViewById = miniAppMoreRootView.findViewById(R.id.rjv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "miniAppMoreRootView.find\u2026odule_tabbar_tabbar_view)");
        this.mTabBar = (MiniAppExpDesktopTabBar) findViewById;
        View findViewById2 = miniAppMoreRootView.findViewById(R.id.rjt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "miniAppMoreRootView.find\u2026odule_tabbar_more_layout)");
        this.mRvTitleMoreLl = (LinearLayout) findViewById2;
        View findViewById3 = miniAppMoreRootView.findViewById(R.id.rju);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "miniAppMoreRootView.find\u2026.module_tabbar_more_text)");
        this.mRvTitleMoreTv = (TextView) findViewById3;
        View findViewById4 = miniAppMoreRootView.findViewById(R.id.rjs);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "miniAppMoreRootView.find\u2026.module_tabbar_more_icon)");
        this.mModuleArrow = (ImageView) findViewById4;
    }

    public final void bindView(String[] tabData, float textSize) {
        Intrinsics.checkNotNullParameter(tabData, "tabData");
        this.mTabBar.setTabTextSize(textSize);
        this.size = tabData.length;
        this.mTabBar.setTabData(tabData);
        LinearLayout linearLayout = this.mRvTitleMoreLl;
        c cVar = c.f353052a;
        UIUtils.c(linearLayout, cVar.b(10), 0, cVar.b(30), 0);
        this.mModuleArrow.clearColorFilter();
        this.mRvTitleMoreTv.setTextColor(this.miniAppMoreRootView.getContext().getColor(R.color.qui_common_text_secondary));
    }

    public final String getCurrentTabText() {
        return this.mTabBar.getCurrentTabText();
    }

    /* renamed from: getRootView, reason: from getter */
    public final View getMRootView() {
        return this.mRootView;
    }

    public final void hideMoreLayoutView() {
        this.mRvTitleMoreLl.setVisibility(8);
    }

    public final void setCurrentPosition(int position) {
        if (this.size <= 0) {
            return;
        }
        this.mTabBar.setCurrentPosition(position);
    }

    public final void setMoreBtnClickListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.mRvTitleMoreTv.setOnClickListener(onClickListener);
    }

    public final void setMoreListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.mRvTitleMoreLl.setOnClickListener(onClickListener);
    }

    public final void setTabBarChangeListener(QUIPageTabBar.i onTabChangeListener) {
        Intrinsics.checkNotNullParameter(onTabChangeListener, "onTabChangeListener");
        this.mTabBar.setTabChangeListener(onTabChangeListener);
    }

    public static /* synthetic */ void bindView$default(MiniAppTabBarMoreUiSection miniAppTabBarMoreUiSection, String[] strArr, float f16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f16 = 16.0f;
        }
        miniAppTabBarMoreUiSection.bindView(strArr, f16);
    }
}
