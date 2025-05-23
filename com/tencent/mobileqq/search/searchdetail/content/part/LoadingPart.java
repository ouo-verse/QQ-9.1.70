package com.tencent.mobileqq.search.searchdetail.content.part;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.search.searchdetail.content.SearchDetailTabContentFragment;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/part/LoadingPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "showLoadingView", "hideLoadingView", "initView", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onPartDestroy", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;", "d", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;", "viewModel", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "Landroid/view/ViewStub;", "f", "Landroid/view/ViewStub;", "loadingViewStub", "Landroid/widget/LinearLayout;", tl.h.F, "Landroid/widget/LinearLayout;", "viewContainer", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;Landroidx/lifecycle/LifecycleOwner;)V", "i", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class LoadingPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.search.searchdetail.content.viewmodel.k viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner viewLifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewStub loadingViewStub;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout viewContainer;

    public LoadingPart(@NotNull com.tencent.mobileqq.search.searchdetail.content.viewmodel.k viewModel, @NotNull LifecycleOwner viewLifecycleOwner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        this.viewModel = viewModel;
        this.viewLifecycleOwner = viewLifecycleOwner;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideLoadingView() {
        SearchDetailTabListViewModel.TabInfo tabInfo;
        LinearLayout linearLayout = this.viewContainer;
        boolean z16 = false;
        if (linearLayout != null && linearLayout.getVisibility() == 0) {
            z16 = true;
        }
        if (z16) {
            LinearLayout linearLayout2 = this.viewContainer;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            Logger.a d16 = Logger.f235387a.d();
            SearchDetailTabContentFragment.PageData pageData = this.viewModel.getPageData();
            if (pageData != null) {
                tabInfo = pageData.getTabInfo();
            } else {
                tabInfo = null;
            }
            d16.i("QQSearch.NetDetail.LoadingPart", 1, "tabinfo=" + tabInfo + " hideLoadingView");
        }
    }

    private final void initView() {
        if (this.viewContainer == null) {
            ViewStub viewStub = this.loadingViewStub;
            ImageView imageView = null;
            if (viewStub == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingViewStub");
                viewStub = null;
            }
            View inflate = viewStub.inflate();
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout = (LinearLayout) inflate;
            this.viewContainer = linearLayout;
            if (linearLayout != null) {
                imageView = (ImageView) linearLayout.findViewById(R.id.ysu);
            }
            if (imageView != null) {
                imageView.setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoadingView() {
        SearchDetailTabListViewModel.TabInfo tabInfo;
        Logger.a d16 = Logger.f235387a.d();
        SearchDetailTabContentFragment.PageData pageData = this.viewModel.getPageData();
        if (pageData != null) {
            tabInfo = pageData.getTabInfo();
        } else {
            tabInfo = null;
        }
        d16.i("QQSearch.NetDetail.LoadingPart", 1, "tabinfo=" + tabInfo + " showLoadingView");
        initView();
        LinearLayout linearLayout = this.viewContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.loading_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.loading_layout)");
        this.loadingViewStub = (ViewStub) findViewById;
        MutableLiveData<String> l26 = this.viewModel.l2();
        LifecycleOwner lifecycleOwner = this.viewLifecycleOwner;
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.LoadingPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                if (Intrinsics.areEqual(str, ToastView.ICON_LOADING)) {
                    Logger logger = Logger.f235387a;
                    LoadingPart loadingPart = LoadingPart.this;
                    if (QLog.isDevelopLevel()) {
                        SearchDetailTabContentFragment.PageData pageData = loadingPart.viewModel.getPageData();
                        Log.d("QQSearch.NetDetail.LoadingPart", "tabinfo=" + (pageData != null ? pageData.getTabInfo() : null) + " state=" + str + " show loading");
                    }
                    LoadingPart.this.showLoadingView();
                    return;
                }
                Logger logger2 = Logger.f235387a;
                LoadingPart loadingPart2 = LoadingPart.this;
                if (QLog.isDevelopLevel()) {
                    SearchDetailTabContentFragment.PageData pageData2 = loadingPart2.viewModel.getPageData();
                    Log.d("QQSearch.NetDetail.LoadingPart", "tabinfo=" + (pageData2 != null ? pageData2.getTabInfo() : null) + " state=" + str + " hide part");
                }
                LoadingPart.this.hideLoadingView();
            }
        };
        l26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LoadingPart.C9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        SearchDetailTabListViewModel.TabInfo tabInfo;
        super.onPartPause(activity);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            SearchDetailTabContentFragment.PageData pageData = this.viewModel.getPageData();
            if (pageData != null) {
                tabInfo = pageData.getTabInfo();
            } else {
                tabInfo = null;
            }
            Log.d("QQSearch.NetDetail.LoadingPart", "onPartPause=" + tabInfo);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        SearchDetailTabListViewModel.TabInfo tabInfo;
        super.onPartResume(activity);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            SearchDetailTabContentFragment.PageData pageData = this.viewModel.getPageData();
            if (pageData != null) {
                tabInfo = pageData.getTabInfo();
            } else {
                tabInfo = null;
            }
            Log.d("QQSearch.NetDetail.LoadingPart", "onPartResume=" + tabInfo);
        }
    }
}
