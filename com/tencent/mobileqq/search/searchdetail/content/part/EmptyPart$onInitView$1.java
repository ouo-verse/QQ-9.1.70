package com.tencent.mobileqq.search.searchdetail.content.part;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.flock.api.IFlockLauncher;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.searchdetail.content.SearchDetailTabContentFragment;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tmassistantbase.util.GlobalUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
final class EmptyPart$onInitView$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ EmptyPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyPart$onInitView$1(EmptyPart emptyPart) {
        super(1);
        this.this$0 = emptyPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(EmptyPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(EmptyPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IFlockLauncher iFlockLauncher = (IFlockLauncher) QRoute.api(IFlockLauncher.class);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iFlockLauncher.launchFlockPublishPage(context, 3, 0L);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke2(String str) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        boolean isBlank;
        TextView textView;
        boolean isBlank2;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        SearchDetailTabContentFragment.PageData pageData;
        QUIEmptyState qUIEmptyState;
        QUIEmptyState qUIEmptyState2;
        SearchDetailTabListViewModel.TabInfo tabInfo;
        boolean isBlank3;
        TextView textView5;
        boolean z16 = false;
        if (Intrinsics.areEqual(str, GlobalUtil.DEF_STRING)) {
            Logger logger = Logger.f235387a;
            EmptyPart emptyPart = this.this$0;
            Logger.a d16 = logger.d();
            SearchDetailTabContentFragment.PageData pageData2 = emptyPart.viewModel.getPageData();
            SearchDetailTabListViewModel.TabInfo tabInfo2 = pageData2 != null ? pageData2.getTabInfo() : null;
            d16.i("QQSearch.NetDetail.EmptyPart", 1, "tabinfo=" + tabInfo2 + " show empty view " + emptyPart.viewModel.getEmptyPageExtraInfo());
            this.this$0.initView();
            frameLayout3 = this.this$0.emptyViewContainer;
            if (frameLayout3 != null) {
                frameLayout3.setVisibility(0);
            }
            String str2 = this.this$0.viewModel.getEmptyPageExtraInfo().title;
            Intrinsics.checkNotNullExpressionValue(str2, "viewModel.getEmptyPageInfo().title");
            isBlank = StringsKt__StringsJVMKt.isBlank(str2);
            if (!(!isBlank)) {
                String str3 = this.this$0.viewModel.getEmptyPageExtraInfo().text;
                Intrinsics.checkNotNullExpressionValue(str3, "viewModel.getEmptyPageInfo().text");
                isBlank3 = StringsKt__StringsJVMKt.isBlank(str3);
                if (!(!isBlank3)) {
                    textView5 = this.this$0.bottomLinkTextView;
                    if (textView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bottomLinkTextView");
                        textView5 = null;
                    }
                    textView5.setVisibility(4);
                    pageData = this.this$0.viewModel.getPageData();
                    if ((pageData == null && (tabInfo = pageData.getTabInfo()) != null && tabInfo.getTabMask() == 9) == true) {
                        return;
                    }
                    qUIEmptyState = this.this$0.emptyState;
                    QUIButton button = qUIEmptyState != null ? qUIEmptyState.getButton() : null;
                    if (button != null) {
                        button.setVisibility(0);
                    }
                    qUIEmptyState2 = this.this$0.emptyState;
                    if (qUIEmptyState2 != null) {
                        final EmptyPart emptyPart2 = this.this$0;
                        qUIEmptyState2.setBtnText("\u521b\u5efa\u65b0\u6d3b\u52a8", 1, new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.o
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                EmptyPart$onInitView$1.d(EmptyPart.this, view);
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            textView = this.this$0.bottomLinkTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomLinkTextView");
                textView = null;
            }
            textView.setVisibility(0);
            String str4 = this.this$0.viewModel.getEmptyPageExtraInfo().title;
            Intrinsics.checkNotNullExpressionValue(str4, "viewModel.getEmptyPageInfo().title");
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str4);
            if (!isBlank2) {
                textView4 = this.this$0.bottomLinkTextView;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomLinkTextView");
                    textView4 = null;
                }
                textView4.setText(this.this$0.viewModel.getEmptyPageExtraInfo().title);
            } else {
                textView2 = this.this$0.bottomLinkTextView;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomLinkTextView");
                    textView2 = null;
                }
                textView2.setText(this.this$0.viewModel.getEmptyPageExtraInfo().text);
            }
            textView3 = this.this$0.bottomLinkTextView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomLinkTextView");
                textView3 = null;
            }
            final EmptyPart emptyPart3 = this.this$0;
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EmptyPart$onInitView$1.c(EmptyPart.this, view);
                }
            });
            pageData = this.this$0.viewModel.getPageData();
            if ((pageData == null && (tabInfo = pageData.getTabInfo()) != null && tabInfo.getTabMask() == 9) == true) {
            }
        } else {
            if (Intrinsics.areEqual(str, "error")) {
                this.this$0.showErrorView();
                return;
            }
            frameLayout = this.this$0.emptyViewContainer;
            if (frameLayout != null && frameLayout.getVisibility() == 0) {
                z16 = true;
            }
            if (z16) {
                frameLayout2 = this.this$0.emptyViewContainer;
                if (frameLayout2 != null) {
                    frameLayout2.setVisibility(8);
                }
                Logger logger2 = Logger.f235387a;
                EmptyPart emptyPart4 = this.this$0;
                Logger.a d17 = logger2.d();
                SearchDetailTabContentFragment.PageData pageData3 = emptyPart4.viewModel.getPageData();
                d17.i("QQSearch.NetDetail.EmptyPart", 1, "tabinfo=" + (pageData3 != null ? pageData3.getTabInfo() : null) + " state=" + str + " hide part");
            }
        }
    }
}
