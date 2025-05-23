package com.tencent.mobileqq.search.searchdetail.content.part;

import android.app.Activity;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.searchdetail.content.SearchDetailTabContentFragment;
import com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection;
import com.tencent.mobileqq.search.searchdetail.content.repo.RefreshType;
import com.tencent.mobileqq.search.searchdetail.content.viewmodel.SearchDetailTroopTabViewModel;
import com.tencent.mobileqq.search.searchdetail.content.viewmodel.SortRule;
import com.tencent.mobileqq.search.searchdetail.eventbus.StartSearchEvent;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/part/EmptyPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "showErrorView", "J9", "initView", "", "traceId", CacheTable.TABLE_NAME, "Lorg/json/JSONObject;", "H9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;", "d", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;", "viewModel", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "Landroid/view/ViewStub;", "f", "Landroid/view/ViewStub;", "emptyViewStub", "Landroid/widget/FrameLayout;", tl.h.F, "Landroid/widget/FrameLayout;", "emptyViewContainer", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "bottomLinkTextView", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "emptyState", "Lcom/tencent/mobileqq/search/searchdetail/content/view/f;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/search/searchdetail/content/view/f;", "emptyDialog", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;Landroidx/lifecycle/LifecycleOwner;)V", "D", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class EmptyPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.search.searchdetail.content.view.f emptyDialog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.search.searchdetail.content.viewmodel.k viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner viewLifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewStub emptyViewStub;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout emptyViewContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView bottomLinkTextView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIEmptyState emptyState;

    public EmptyPart(@NotNull com.tencent.mobileqq.search.searchdetail.content.viewmodel.k viewModel, @NotNull LifecycleOwner viewLifecycleOwner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        this.viewModel = viewModel;
        this.viewLifecycleOwner = viewLifecycleOwner;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final JSONObject H9(String traceId, String reportInfo) {
        String str;
        String str2;
        long j3;
        Object obj;
        Object obj2;
        String str3;
        Object firstOrNull;
        List listOf;
        String joinToString$default;
        byte b16;
        SearchDetailTabListViewModel.TabInfo tabInfo;
        SearchDetailTabListViewModel.TabInfo tabInfo2;
        JSONObject jSONObject = new JSONObject();
        SearchDetailTabContentFragment.PageData pageData = this.viewModel.getPageData();
        String str4 = "";
        if (pageData == null || (str = pageData.getKeyword()) == null) {
            str = "";
        }
        jSONObject.put("search_query_text", str);
        jSONObject.put("search_trace_id", traceId);
        SearchDetailTabContentFragment.PageData pageData2 = this.viewModel.getPageData();
        if (pageData2 == null || (tabInfo2 = pageData2.getTabInfo()) == null || (str2 = tabInfo2.getTabName()) == null) {
            str2 = "";
        }
        jSONObject.put("tab_name", str2);
        SearchDetailTabContentFragment.PageData pageData3 = this.viewModel.getPageData();
        if (pageData3 != null && (tabInfo = pageData3.getTabInfo()) != null) {
            j3 = tabInfo.getTabMask();
        } else {
            j3 = 1;
        }
        jSONObject.put("tab_mask", j3);
        SearchDetailTabContentFragment.PageData pageData4 = this.viewModel.getPageData();
        if (pageData4 == null) {
            obj = "";
        } else {
            obj = Integer.valueOf(pageData4.getQuerySource());
        }
        jSONObject.put("query_source", obj);
        SearchDetailTabContentFragment.PageData pageData5 = this.viewModel.getPageData();
        if (pageData5 == null) {
            obj2 = "";
        } else {
            obj2 = Integer.valueOf(pageData5.getUserSource());
        }
        jSONObject.put("user_source", obj2);
        BaseSearchTemplateSection.Companion companion = BaseSearchTemplateSection.INSTANCE;
        if (reportInfo == null) {
            reportInfo = "{}";
        }
        jSONObject.put("transfer_info", companion.c(reportInfo, jSONObject));
        com.tencent.mobileqq.search.searchdetail.content.viewmodel.k kVar = this.viewModel;
        if (kVar instanceof SearchDetailTroopTabViewModel) {
            SortRule W2 = ((SearchDetailTroopTabViewModel) kVar).W2();
            if (W2 == null || (str3 = W2.getText()) == null) {
                str3 = "\u667a\u80fd\u6392\u5e8f";
            }
            jSONObject.put("sort_type", str3);
            ArrayList<String> arrayList = ((SearchDetailTroopTabViewModel) this.viewModel).getGroupFilter().tags;
            Intrinsics.checkNotNullExpressionValue(arrayList, "viewModel.groupFilter.tags");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
            String str5 = (String) firstOrNull;
            if (str5 != null) {
                str4 = str5;
            }
            jSONObject.put("tag_type", str4);
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{((SearchDetailTroopTabViewModel) this.viewModel).getGroupFilter().geoInfo.province, ((SearchDetailTroopTabViewModel) this.viewModel).getGroupFilter().geoInfo.city, ((SearchDetailTroopTabViewModel) this.viewModel).getGroupFilter().geoInfo.district});
            ArrayList arrayList2 = new ArrayList();
            for (Object obj3 : listOf) {
                String it = (String) obj3;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.length() > 0) {
                    b16 = true;
                } else {
                    b16 = false;
                }
                if (b16 != false) {
                    arrayList2.add(obj3);
                }
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList2, ",", null, null, 0, null, null, 62, null);
            jSONObject.put("regional_type", joinToString$default);
            jSONObject.put("grp_search_exist_grp", !com.tencent.mobileqq.search.searchdetail.content.viewmodel.k.h2(this.viewModel, null, 1, null).isEmpty() ? 1 : 0);
        }
        return jSONObject;
    }

    static /* synthetic */ JSONObject I9(EmptyPart emptyPart, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        return emptyPart.H9(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9() {
        boolean z16;
        String str = this.viewModel.getEmptyPageExtraInfo().jumpUrl;
        Intrinsics.checkNotNullExpressionValue(str, "viewModel.getEmptyPageInfo().jumpUrl");
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            IReadInJoyUtils iReadInJoyUtils = (IReadInJoyUtils) QRoute.api(IReadInJoyUtils.class);
            Activity hostActivity = getPartHost().getHostActivity();
            Intrinsics.checkNotNullExpressionValue(hostActivity, "partHost.hostActivity");
            String str2 = this.viewModel.getEmptyPageExtraInfo().jumpUrl;
            Intrinsics.checkNotNullExpressionValue(str2, "viewModel.getEmptyPageInfo().jumpUrl");
            iReadInJoyUtils.jumpTo(hostActivity, str2, null);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(this.viewModel.getEmptyPageExtraInfo().richText.highlightTextList, "viewModel.getEmptyPageIn\u2026ichText.highlightTextList");
        if (!r0.isEmpty()) {
            com.tencent.mobileqq.search.searchdetail.content.view.f fVar = this.emptyDialog;
            if (fVar != null) {
                fVar.dismiss();
            }
            if (getActivity() != null && !getActivity().isFinishing()) {
                Activity activity = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                com.tencent.mobileqq.search.searchdetail.content.view.f fVar2 = new com.tencent.mobileqq.search.searchdetail.content.view.f(activity);
                this.emptyDialog = fVar2;
                fVar2.S(this.viewModel.getEmptyPageExtraInfo());
                com.tencent.mobileqq.search.searchdetail.content.view.f fVar3 = this.emptyDialog;
                if (fVar3 != null) {
                    fVar3.show();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(EmptyPart this$0, View view) {
        String str;
        int i3;
        int i16;
        String str2;
        String str3;
        int i17;
        String wxPreSearchId;
        String sugTraceId;
        String keyword;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("QQSearch.NetDetail.EmptyPart_buttonJump", 500L)) {
            this$0.viewModel.Q2(ToastView.ICON_LOADING);
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            SearchDetailTabContentFragment.PageData pageData = this$0.viewModel.getPageData();
            if (pageData == null || (keyword = pageData.getKeyword()) == null) {
                str = "";
            } else {
                str = keyword;
            }
            SearchDetailTabContentFragment.PageData pageData2 = this$0.viewModel.getPageData();
            int i18 = 0;
            if (pageData2 != null) {
                i3 = pageData2.getQuerySource();
            } else {
                i3 = 0;
            }
            SearchDetailTabContentFragment.PageData pageData3 = this$0.viewModel.getPageData();
            if (pageData3 != null) {
                i16 = pageData3.getPageMode();
            } else {
                i16 = 0;
            }
            RefreshType refreshType = RefreshType.TYPE_ERROR_RETRY;
            SearchDetailTabContentFragment.PageData pageData4 = this$0.viewModel.getPageData();
            if (pageData4 == null || (sugTraceId = pageData4.getSugTraceId()) == null) {
                str2 = "";
            } else {
                str2 = sugTraceId;
            }
            SearchDetailTabContentFragment.PageData pageData5 = this$0.viewModel.getPageData();
            if (pageData5 == null || (wxPreSearchId = pageData5.getWxPreSearchId()) == null) {
                str3 = "";
            } else {
                str3 = wxPreSearchId;
            }
            SearchDetailTabContentFragment.PageData pageData6 = this$0.viewModel.getPageData();
            if (pageData6 != null) {
                i17 = pageData6.getParentType();
            } else {
                i17 = 0;
            }
            StartSearchEvent startSearchEvent = new StartSearchEvent(str, i16, i3, refreshType, str2, str3, i17, "errorRetry");
            Activity activity = this$0.getActivity();
            if (activity != null) {
                i18 = activity.hashCode();
            }
            startSearchEvent.mHashCode = i18;
            simpleEventBus.dispatchEvent(startSearchEvent);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initView() {
        if (this.emptyViewContainer == null) {
            ViewStub viewStub = this.emptyViewStub;
            if (viewStub == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyViewStub");
                viewStub = null;
            }
            View inflate = viewStub.inflate();
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
            this.emptyViewContainer = (FrameLayout) inflate;
            this.emptyState = new QUIEmptyState.Builder(getContext()).setImageType(9).setBackgroundColorType(0).setTitle("\u6ca1\u6709\u641c\u7d22\u5230\u76f8\u5173\u7ed3\u679c").build();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
            layoutParams.gravity = 17;
            FrameLayout frameLayout = this.emptyViewContainer;
            Intrinsics.checkNotNull(frameLayout);
            frameLayout.addView(this.emptyState, layoutParams);
            FrameLayout frameLayout2 = this.emptyViewContainer;
            Intrinsics.checkNotNull(frameLayout2);
            View findViewById = frameLayout2.findViewById(R.id.yj9);
            Intrinsics.checkNotNullExpressionValue(findViewById, "emptyViewContainer!!.fin\u2026ById(R.id.link_text_view)");
            this.bottomLinkTextView = (TextView) findViewById;
            FrameLayout frameLayout3 = this.emptyViewContainer;
            if (frameLayout3 != null) {
                com.tencent.mobileqq.search.searchdetail.r.f284572a.e(frameLayout3, "em_search_no_result_card", I9(this, "", null, 2, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showErrorView() {
        SearchDetailTabListViewModel.TabInfo tabInfo;
        QUIButton qUIButton;
        QUIButton button;
        Logger.a d16 = Logger.f235387a.d();
        SearchDetailTabContentFragment.PageData pageData = this.viewModel.getPageData();
        if (pageData != null) {
            tabInfo = pageData.getTabInfo();
        } else {
            tabInfo = null;
        }
        d16.w("QQSearch.NetDetail.EmptyPart", 1, "tabinfo=" + tabInfo + " show error view");
        initView();
        FrameLayout frameLayout = this.emptyViewContainer;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        TextView textView = this.bottomLinkTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomLinkTextView");
            textView = null;
        }
        textView.setVisibility(8);
        QUIEmptyState qUIEmptyState = this.emptyState;
        if (qUIEmptyState != null) {
            qUIEmptyState.setTitle("\u65e0\u6cd5\u8fde\u63a5");
        }
        QUIEmptyState qUIEmptyState2 = this.emptyState;
        if (qUIEmptyState2 != null) {
            qUIButton = qUIEmptyState2.getButton();
        } else {
            qUIButton = null;
        }
        if (qUIButton != null) {
            qUIButton.setVisibility(0);
        }
        QUIEmptyState qUIEmptyState3 = this.emptyState;
        if (qUIEmptyState3 != null) {
            qUIEmptyState3.setBtnText("\u91cd\u65b0\u52a0\u8f7d", 1, new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EmptyPart.L9(EmptyPart.this, view);
                }
            });
        }
        QUIEmptyState qUIEmptyState4 = this.emptyState;
        if (qUIEmptyState4 != null && (button = qUIEmptyState4.getButton()) != null) {
            com.tencent.mobileqq.search.searchdetail.content.view.i.g(button, "em_search_reload_button", true, I9(this, "", null, 2, null), null);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.uuz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.empty_view_contianer)");
        this.emptyViewStub = (ViewStub) findViewById;
        MutableLiveData<String> l26 = this.viewModel.l2();
        LifecycleOwner lifecycleOwner = this.viewLifecycleOwner;
        final EmptyPart$onInitView$1 emptyPart$onInitView$1 = new EmptyPart$onInitView$1(this);
        l26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EmptyPart.K9(Function1.this, obj);
            }
        });
    }
}
