package com.tencent.mobileqq.search.searchdetail.content;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDetailInteractiveEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDetailViewDestroyEvent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.SearchDetailFragment;
import com.tencent.mobileqq.search.searchdetail.content.part.ChannelTabFilterPart;
import com.tencent.mobileqq.search.searchdetail.content.part.ContentPart;
import com.tencent.mobileqq.search.searchdetail.content.part.EmptyPart;
import com.tencent.mobileqq.search.searchdetail.content.part.FloatButtonPart;
import com.tencent.mobileqq.search.searchdetail.content.part.LoadingPart;
import com.tencent.mobileqq.search.searchdetail.content.part.TroopTabFilterPart;
import com.tencent.mobileqq.search.searchdetail.content.part.v;
import com.tencent.mobileqq.search.searchdetail.content.repo.RefreshType;
import com.tencent.mobileqq.search.searchdetail.content.viewmodel.SearchDetailTroopTabViewModel;
import com.tencent.mobileqq.search.searchdetail.content.viewmodel.h;
import com.tencent.mobileqq.search.searchdetail.content.viewmodel.k;
import com.tencent.mobileqq.search.searchdetail.eventbus.QSearchPostEvent;
import com.tencent.mobileqq.search.searchdetail.eventbus.StartSearchEvent;
import com.tencent.mobileqq.search.searchdetail.eventbus.UpdateParentTpEvent;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel;
import com.tencent.mobileqq.search.util.ag;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 52\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u000267B\u0007\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\u0012\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030#0\"H\u0016J\b\u0010%\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000e0+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/SearchDetailTabContentFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initArguments", "", "th", "uh", "vh", "getKeyword", "", "sh", "initViewModel", "Lcom/tencent/mobileqq/search/searchdetail/tablist/a;", "context", "xh", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;", "viewModel", "Lmqq/util/WeakReference;", "D", "Lmqq/util/WeakReference;", "searchContext", "Lcom/tencent/mobileqq/search/searchdetail/content/SearchDetailTabContentFragment$b;", "E", "Lcom/tencent/mobileqq/search/searchdetail/content/SearchDetailTabContentFragment$b;", ISchemeApi.KEY_PAGE_DATA, "<init>", "()V", UserInfo.SEX_FEMALE, "a", "b", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchDetailTabContentFragment extends QPublicBaseFragment implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private k viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private WeakReference<com.tencent.mobileqq.search.searchdetail.tablist.a> searchContext = new WeakReference<>(null);

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private PageData pageData = new PageData(new SearchDetailTabListViewModel.TabInfo("\u5168\u90e8", 1), 0, 0, null, null, null, false, null, null, 0, 0, 0, 4094, null);

    private final String getKeyword() {
        String str;
        String keyword;
        com.tencent.mobileqq.search.searchdetail.tablist.a aVar = this.searchContext.get();
        if (aVar != null && (keyword = aVar.getKeyword()) != null) {
            return keyword;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("keyword");
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final void initArguments() {
        int i3;
        String str;
        long j3;
        int i16;
        String str2;
        String str3;
        int value;
        String string;
        String string2;
        Bundle arguments = getArguments();
        int i17 = 0;
        if (arguments != null) {
            i3 = arguments.getInt(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE);
        } else {
            i3 = 0;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str = arguments2.getString("tabName")) == null) {
            str = "\u5168\u90e8";
        }
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            j3 = arguments3.getLong("tabMask");
        } else {
            j3 = 1;
        }
        SearchDetailTabListViewModel.TabInfo tabInfo = new SearchDetailTabListViewModel.TabInfo(str, j3);
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            i16 = arguments4.getInt("user_source");
        } else {
            i16 = 0;
        }
        Bundle arguments5 = getArguments();
        if (arguments5 == null || (string2 = arguments5.getString("sessionId")) == null) {
            str2 = "";
        } else {
            str2 = string2;
        }
        String keyword = getKeyword();
        Bundle arguments6 = getArguments();
        if (arguments6 == null || (string = arguments6.getString("func_payload")) == null) {
            str3 = "";
        } else {
            str3 = string;
        }
        boolean sh5 = sh();
        String uh5 = uh();
        String vh5 = vh();
        Bundle arguments7 = getArguments();
        if (arguments7 != null) {
            i17 = arguments7.getInt("wx_parent_type");
        }
        Bundle arguments8 = getArguments();
        if (arguments8 != null) {
            value = arguments8.getInt("voice_ai_mode");
        } else {
            value = SearchDetailFragment.Companion.PageMode.MODE_NORMAL.getValue();
        }
        this.pageData = new PageData(tabInfo, i3, i16, str2, keyword, str3, sh5, uh5, vh5, i17, value, 0L, 2048, null);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QQSearch.NetDetail.SearchDetailTabContentFragment", "initArguments " + this.pageData);
        }
    }

    private final void initViewModel() {
        k kVar;
        int tabMask = (int) this.pageData.getTabInfo().getTabMask();
        if (tabMask != 3) {
            if (tabMask != 6) {
                ViewModel viewModel = new ViewModelProvider(this).get(k.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026entViewModel::class.java)");
                kVar = (k) viewModel;
            } else {
                ViewModel viewModel2 = new ViewModelProvider(this).get(SearchDetailTroopTabViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(this).\u2026TabViewModel::class.java)");
                kVar = (k) viewModel2;
            }
        } else {
            ViewModel viewModel3 = new ViewModelProvider(this).get(h.class);
            Intrinsics.checkNotNullExpressionValue(viewModel3, "ViewModelProvider(this).\u2026TabViewModel::class.java)");
            kVar = (k) viewModel3;
        }
        this.viewModel = kVar;
        k kVar2 = null;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            kVar = null;
        }
        kVar.T2(this.pageData, th());
        k kVar3 = this.viewModel;
        if (kVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            kVar2 = kVar3;
        }
        MutableLiveData<String> t26 = kVar2.t2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.SearchDetailTabContentFragment$initViewModel$1
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
            public final void invoke2(String keyword) {
                WeakReference weakReference;
                Intrinsics.checkNotNullExpressionValue(keyword, "keyword");
                if (keyword.length() > 0) {
                    Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabContentFragment", 1, "search succ " + ag.b(keyword, 0, 1, null));
                    weakReference = SearchDetailTabContentFragment.this.searchContext;
                    com.tencent.mobileqq.search.searchdetail.tablist.a aVar = (com.tencent.mobileqq.search.searchdetail.tablist.a) weakReference.get();
                    if (aVar != null) {
                        aVar.a(keyword);
                    }
                }
            }
        };
        t26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.content.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchDetailTabContentFragment.wh(Function1.this, obj);
            }
        });
    }

    private final boolean sh() {
        com.tencent.mobileqq.search.searchdetail.tablist.a aVar = this.searchContext.get();
        if (aVar != null) {
            return aVar.d();
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getBoolean("disableCorrect");
        }
        return false;
    }

    private final String th() {
        String str;
        String miniAppSessionId;
        com.tencent.mobileqq.search.searchdetail.tablist.a aVar = this.searchContext.get();
        if (aVar != null && (miniAppSessionId = aVar.getMiniAppSessionId()) != null) {
            return miniAppSessionId;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("detailPageSessionId");
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final String uh() {
        String str;
        String sugTraceId;
        com.tencent.mobileqq.search.searchdetail.tablist.a aVar = this.searchContext.get();
        if (aVar != null && (sugTraceId = aVar.getSugTraceId()) != null) {
            return sugTraceId;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("sug_trace_id");
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final String vh() {
        String str;
        String b16;
        com.tencent.mobileqq.search.searchdetail.tablist.a aVar = this.searchContext.get();
        if (aVar != null && (b16 = aVar.b()) != null) {
            return b16;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("wx_search_id");
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        com.tencent.mobileqq.search.tux.b bVar;
        List<Part> mutableListOf;
        Part[] partArr = new Part[7];
        k kVar = this.viewModel;
        k kVar2 = null;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            kVar = null;
        }
        partArr[0] = new ChannelTabFilterPart(kVar);
        k kVar3 = this.viewModel;
        if (kVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            kVar3 = null;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        partArr[1] = new TroopTabFilterPart(kVar3, viewLifecycleOwner);
        k kVar4 = this.viewModel;
        if (kVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            kVar4 = null;
        }
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        com.tencent.mobileqq.search.searchdetail.tablist.a aVar = this.searchContext.get();
        if (aVar != null) {
            bVar = aVar.c();
        } else {
            bVar = null;
        }
        partArr[2] = new ContentPart(kVar4, viewLifecycleOwner2, bVar, th());
        k kVar5 = this.viewModel;
        if (kVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            kVar5 = null;
        }
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        partArr[3] = new FloatButtonPart(kVar5, viewLifecycleOwner3);
        k kVar6 = this.viewModel;
        if (kVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            kVar6 = null;
        }
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "viewLifecycleOwner");
        partArr[4] = new LoadingPart(kVar6, viewLifecycleOwner4);
        k kVar7 = this.viewModel;
        if (kVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            kVar7 = null;
        }
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "viewLifecycleOwner");
        partArr[5] = new EmptyPart(kVar7, viewLifecycleOwner5);
        k kVar8 = this.viewModel;
        if (kVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            kVar2 = kVar8;
        }
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "viewLifecycleOwner");
        partArr[6] = new v(kVar2, viewLifecycleOwner6);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(partArr);
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.h2h;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(StartSearchEvent.class, QSearchPostEvent.class, UpdateParentTpEvent.class, GuildFeedDetailInteractiveEvent.class, GuildFeedDetailViewDestroyEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        initArguments();
        initViewModel();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AbstractGifImage.resumeAll();
        ApngImage.resumeAll();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        int i3;
        k kVar = null;
        if (event instanceof StartSearchEvent) {
            StartSearchEvent startSearchEvent = (StartSearchEvent) event;
            int i16 = startSearchEvent.mHashCode;
            boolean z16 = false;
            if (i16 != 0) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    i3 = activity.hashCode();
                } else {
                    i3 = 0;
                }
                if (i16 != i3) {
                    Logger.f235387a.d().i("QQSearch.NetDetail.WXMinGameMoreDetailFragment", 1, "onReceive but no current activity, StartSearchEvent " + event);
                    return;
                }
            }
            this.pageData.n(startSearchEvent.getKeyword());
            this.pageData.q(startSearchEvent.getQuerySource());
            this.pageData.o(startSearchEvent.getPageMode());
            PageData pageData = this.pageData;
            if (startSearchEvent.getRefreshType() == RefreshType.TYPE_CANCEL_CORRECT) {
                z16 = true;
            }
            pageData.m(z16);
            this.pageData.s(startSearchEvent.getSugTraceId());
            this.pageData.t(startSearchEvent.getWxPreSearchId());
            this.pageData.p(startSearchEvent.getParentType());
            k kVar2 = this.viewModel;
            if (kVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                kVar2 = null;
            }
            kVar2.T2(this.pageData, th());
            Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabContentFragment", 1, "onReceive tabInfo=" + this.pageData.getTabInfo() + " StartSearchEvent " + event);
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                k kVar3 = this.viewModel;
                if (kVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    kVar3 = null;
                }
                kVar3.R2(activity2, this.pageData.getKeyword(), startSearchEvent.getRefreshType(), startSearchEvent.getSource());
            }
        }
        if (event instanceof QSearchPostEvent) {
            k kVar4 = this.viewModel;
            if (kVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                kVar4 = null;
            }
            kVar4.I2((QSearchPostEvent) event);
        }
        if (event instanceof GuildFeedDetailInteractiveEvent) {
            k kVar5 = this.viewModel;
            if (kVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                kVar5 = null;
            }
            kVar5.H2((GuildFeedDetailInteractiveEvent) event);
        }
        if (event instanceof GuildFeedDetailViewDestroyEvent) {
            k kVar6 = this.viewModel;
            if (kVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                kVar6 = null;
            }
            kVar6.G2((GuildFeedDetailViewDestroyEvent) event);
        }
        if (event instanceof UpdateParentTpEvent) {
            k kVar7 = this.viewModel;
            if (kVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                kVar = kVar7;
            }
            kVar.D2((UpdateParentTpEvent) event);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AbstractGifImage.resumeAll();
        ApngImage.resumeAll();
    }

    public final void xh(@NotNull com.tencent.mobileqq.search.searchdetail.tablist.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.searchContext = new WeakReference<>(context);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\u0007\u0012\b\b\u0002\u0010+\u001a\u00020\u0002\u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u0012\b\b\u0002\u00100\u001a\u00020\u0004\u0012\b\b\u0002\u00102\u001a\u00020\u0004\u0012\b\b\u0002\u00108\u001a\u000203\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012R\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u0016\u0010\u001c\"\u0004\b\u001f\u0010 R\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u000f\u0010\u001cR\"\u0010'\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010#\u001a\u0004\b\n\u0010$\"\u0004\b%\u0010&R\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u001a\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010 R\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u001a\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010 R\"\u00100\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b/\u0010\u0014R\"\u00102\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b1\u0010\u0014R\"\u00108\u001a\u0002038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u00104\u001a\u0004\b(\u00105\"\u0004\b6\u00107\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/SearchDetailTabContentFragment$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;", "a", "Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;", "j", "()Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;", "tabInfo", "b", "I", "f", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(I)V", QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "c", "k", "userSource", "d", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "sessionId", "e", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "keyword", "functionPayload", "Z", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Z)V", "disableCorrectionQuery", tl.h.F, "i", ReportConstant.COSTREPORT_PREFIX, "sugTraceId", "l", "t", "wxPreSearchId", "p", "parentType", "o", "pageMode", "", "J", "()J", "r", "(J)V", "startSearchTimeStamps", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;IIJ)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.content.SearchDetailTabContentFragment$b, reason: from toString */
    /* loaded from: classes18.dex */
    public static final /* data */ class PageData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final SearchDetailTabListViewModel.TabInfo tabInfo;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private int querySource;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int userSource;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String sessionId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String keyword;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String functionPayload;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean disableCorrectionQuery;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String sugTraceId;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String wxPreSearchId;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
        private int parentType;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
        private int pageMode;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
        private long startSearchTimeStamps;

        public PageData(@NotNull SearchDetailTabListViewModel.TabInfo tabInfo, int i3, int i16, @NotNull String sessionId, @NotNull String keyword, @NotNull String functionPayload, boolean z16, @NotNull String sugTraceId, @NotNull String wxPreSearchId, int i17, int i18, long j3) {
            Intrinsics.checkNotNullParameter(tabInfo, "tabInfo");
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            Intrinsics.checkNotNullParameter(functionPayload, "functionPayload");
            Intrinsics.checkNotNullParameter(sugTraceId, "sugTraceId");
            Intrinsics.checkNotNullParameter(wxPreSearchId, "wxPreSearchId");
            this.tabInfo = tabInfo;
            this.querySource = i3;
            this.userSource = i16;
            this.sessionId = sessionId;
            this.keyword = keyword;
            this.functionPayload = functionPayload;
            this.disableCorrectionQuery = z16;
            this.sugTraceId = sugTraceId;
            this.wxPreSearchId = wxPreSearchId;
            this.parentType = i17;
            this.pageMode = i18;
            this.startSearchTimeStamps = j3;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getDisableCorrectionQuery() {
            return this.disableCorrectionQuery;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getFunctionPayload() {
            return this.functionPayload;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getKeyword() {
            return this.keyword;
        }

        /* renamed from: d, reason: from getter */
        public final int getPageMode() {
            return this.pageMode;
        }

        /* renamed from: e, reason: from getter */
        public final int getParentType() {
            return this.parentType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageData)) {
                return false;
            }
            PageData pageData = (PageData) other;
            if (Intrinsics.areEqual(this.tabInfo, pageData.tabInfo) && this.querySource == pageData.querySource && this.userSource == pageData.userSource && Intrinsics.areEqual(this.sessionId, pageData.sessionId) && Intrinsics.areEqual(this.keyword, pageData.keyword) && Intrinsics.areEqual(this.functionPayload, pageData.functionPayload) && this.disableCorrectionQuery == pageData.disableCorrectionQuery && Intrinsics.areEqual(this.sugTraceId, pageData.sugTraceId) && Intrinsics.areEqual(this.wxPreSearchId, pageData.wxPreSearchId) && this.parentType == pageData.parentType && this.pageMode == pageData.pageMode && this.startSearchTimeStamps == pageData.startSearchTimeStamps) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final int getQuerySource() {
            return this.querySource;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: h, reason: from getter */
        public final long getStartSearchTimeStamps() {
            return this.startSearchTimeStamps;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((((((((this.tabInfo.hashCode() * 31) + this.querySource) * 31) + this.userSource) * 31) + this.sessionId.hashCode()) * 31) + this.keyword.hashCode()) * 31) + this.functionPayload.hashCode()) * 31;
            boolean z16 = this.disableCorrectionQuery;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((((((((((hashCode + i3) * 31) + this.sugTraceId.hashCode()) * 31) + this.wxPreSearchId.hashCode()) * 31) + this.parentType) * 31) + this.pageMode) * 31) + androidx.fragment.app.a.a(this.startSearchTimeStamps);
        }

        @NotNull
        /* renamed from: i, reason: from getter */
        public final String getSugTraceId() {
            return this.sugTraceId;
        }

        @NotNull
        /* renamed from: j, reason: from getter */
        public final SearchDetailTabListViewModel.TabInfo getTabInfo() {
            return this.tabInfo;
        }

        /* renamed from: k, reason: from getter */
        public final int getUserSource() {
            return this.userSource;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final String getWxPreSearchId() {
            return this.wxPreSearchId;
        }

        public final void m(boolean z16) {
            this.disableCorrectionQuery = z16;
        }

        public final void n(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.keyword = str;
        }

        public final void o(int i3) {
            this.pageMode = i3;
        }

        public final void p(int i3) {
            this.parentType = i3;
        }

        public final void q(int i3) {
            this.querySource = i3;
        }

        public final void r(long j3) {
            this.startSearchTimeStamps = j3;
        }

        public final void s(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.sugTraceId = str;
        }

        public final void t(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.wxPreSearchId = str;
        }

        @NotNull
        public String toString() {
            String str = "PageData(tabInfo=" + this.tabInfo + ", querySource=" + this.querySource + ", userSource=" + this.userSource + ", sessionId='" + this.sessionId + "', keyword='" + ag.b(this.keyword, 0, 1, null) + "', functionPayload='" + this.functionPayload + "', disableCorrectionQuery=" + this.disableCorrectionQuery + ", sugTraceId='" + this.sugTraceId + "', wxPreSearchId='" + this.wxPreSearchId + "', parentType=" + this.parentType + ", pageMode=" + this.pageMode + ", startSearchTimeStamps=" + this.startSearchTimeStamps + ")";
            Intrinsics.checkNotNullExpressionValue(str, "StringBuilder().apply {\n\u2026\n            }.toString()");
            return str;
        }

        public /* synthetic */ PageData(SearchDetailTabListViewModel.TabInfo tabInfo, int i3, int i16, String str, String str2, String str3, boolean z16, String str4, String str5, int i17, int i18, long j3, int i19, DefaultConstructorMarker defaultConstructorMarker) {
            this(tabInfo, (i19 & 2) != 0 ? 2 : i3, (i19 & 4) != 0 ? 0 : i16, (i19 & 8) != 0 ? "" : str, (i19 & 16) != 0 ? "" : str2, (i19 & 32) != 0 ? "" : str3, (i19 & 64) != 0 ? false : z16, (i19 & 128) != 0 ? "" : str4, (i19 & 256) == 0 ? str5 : "", (i19 & 512) == 0 ? i17 : 0, (i19 & 1024) != 0 ? SearchDetailFragment.Companion.PageMode.MODE_NORMAL.getValue() : i18, (i19 & 2048) != 0 ? 0L : j3);
        }
    }
}
