package com.tencent.mobileqq.search.searchdetail.content.wxminapp.moredetail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.ams.dsdk.core.DKEngine;
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
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.search.searchdetail.SearchDetailFragment;
import com.tencent.mobileqq.search.searchdetail.SearchPageType;
import com.tencent.mobileqq.search.searchdetail.content.SearchDetailTabContentFragment;
import com.tencent.mobileqq.search.searchdetail.content.part.ContentPart;
import com.tencent.mobileqq.search.searchdetail.content.part.EmptyPart;
import com.tencent.mobileqq.search.searchdetail.content.part.LoadingPart;
import com.tencent.mobileqq.search.searchdetail.content.repo.RefreshType;
import com.tencent.mobileqq.search.searchdetail.content.viewmodel.SearchDetailMinGameViewModel;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.SpecialAction;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.c;
import com.tencent.mobileqq.search.searchdetail.eventbus.QSearchPostEvent;
import com.tencent.mobileqq.search.searchdetail.eventbus.StartSearchEvent;
import com.tencent.mobileqq.search.searchdetail.eventbus.ThemeChangedEvent;
import com.tencent.mobileqq.search.searchdetail.searchbox.SearchHistoryPart;
import com.tencent.mobileqq.search.searchdetail.searchbox.k;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel;
import com.tencent.mobileqq.search.util.af;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 :2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002;<B\u0007\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J$\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0011`\u0012H\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\"\u001a\u0004\u0018\u00010\u001a2\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010#\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J\u0012\u0010&\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010*\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030(0'j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030(`)H\u0016J\b\u0010+\u001a\u00020\u0004H\u0016J\b\u0010,\u001a\u00020\u0004H\u0016J\b\u0010-\u001a\u00020\u0004H\u0016J\b\u0010.\u001a\u00020\nH\u0016J\b\u0010/\u001a\u00020\nH\u0016R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/moredetail/WXMinGameMoreDetailFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initArguments", "", "xh", "wh", "getKeyword", "", "uh", "initViewModel", "Landroid/view/ViewGroup;", "contentView", "th", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "vh", "sh", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/view/LayoutInflater;", "inflater", ParseCommon.CONTAINER, "onCreateView", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onPostThemeChanged", "needImmersive", "isWrapContent", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/SearchDetailMinGameViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/SearchDetailMinGameViewModel;", "viewModel", "Lcom/tencent/mobileqq/search/searchdetail/content/SearchDetailTabContentFragment$b;", "D", "Lcom/tencent/mobileqq/search/searchdetail/content/SearchDetailTabContentFragment$b;", ISchemeApi.KEY_PAGE_DATA, "<init>", "()V", "E", "a", "b", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class WXMinGameMoreDetailFragment extends QPublicBaseFragment implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private SearchDetailMinGameViewModel viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private SearchDetailTabContentFragment.PageData pageData = new SearchDetailTabContentFragment.PageData(new SearchDetailTabListViewModel.TabInfo("\u5c0f\u6e38\u620f", 11), 0, 0, null, null, null, false, null, null, 0, 0, 0, 4094, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J6\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0006R\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/moredetail/WXMinGameMoreDetailFragment$a;", "", "Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;", "a", "Landroid/content/Context;", "context", "", "keyWord", "hint", "", QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "userSource", "sourceUrl", "", "b", "TAB_NAME_MIN_GAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.content.wxminapp.moredetail.WXMinGameMoreDetailFragment$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SearchDetailTabListViewModel.TabInfo a() {
            return new SearchDetailTabListViewModel.TabInfo("\u5c0f\u6e38\u620f", 11L);
        }

        public final void b(@NotNull Context context, @NotNull String keyWord, @NotNull String hint, int querySource, int userSource, @NotNull String sourceUrl) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(keyWord, "keyWord");
            Intrinsics.checkNotNullParameter(hint, "hint");
            Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
            Logger.f235387a.d().i("QQSearch.NetDetail.WXMinGameMoreDetailFragment", 1, "launch sourceUrl:" + sourceUrl);
            String str = "";
            try {
                String queryParameter = Uri.parse(sourceUrl).getQueryParameter("wx_search_id");
                if (queryParameter != null) {
                    str = queryParameter;
                }
            } catch (Exception e16) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str2 = "launch error " + e16;
                if (str2 instanceof String) {
                    bVar.a().add(str2);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("QQSearch.NetDetail.WXMinGameMoreDetailFragment", 1, (String) it.next(), null);
                }
            }
            Intent intent = new Intent();
            intent.putExtra(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, querySource);
            intent.putExtra("user_source", userSource);
            intent.putExtra("hint", hint);
            intent.putExtra("keyword", keyWord);
            intent.putExtra("wx_search_id", str);
            if (context instanceof Activity) {
                QPublicFragmentActivity.start(context, intent, WXMinGameMoreDetailFragment.class);
            } else {
                intent.addFlags(268435456);
                QPublicFragmentActivity.start(BaseApplication.getContext(), intent, WXMinGameMoreDetailFragment.class);
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/moredetail/WXMinGameMoreDetailFragment$b;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "event", "", "", "getDynamicParams", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/moredetail/WXMinGameMoreDetailFragment;", "a", "Lmqq/util/WeakReference;", "fragmentRef", "<init>", "(Lmqq/util/WeakReference;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<WXMinGameMoreDetailFragment> fragmentRef;

        public b(@NotNull WeakReference<WXMinGameMoreDetailFragment> fragmentRef) {
            Intrinsics.checkNotNullParameter(fragmentRef, "fragmentRef");
            this.fragmentRef = fragmentRef;
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        @NotNull
        public Map<String, Object> getDynamicParams(@Nullable String event) {
            HashMap hashMap;
            WXMinGameMoreDetailFragment wXMinGameMoreDetailFragment = this.fragmentRef.get();
            if (wXMinGameMoreDetailFragment == null || (hashMap = wXMinGameMoreDetailFragment.vh()) == null) {
                hashMap = new HashMap();
            }
            af afVar = af.f284993a;
            if (QLog.isDebugVersion()) {
                QLog.d("QS.QQSearch.NetDetail.SearchDetailFragment", 2, "getDynamicParams " + hashMap, (Throwable) null);
            }
            return hashMap;
        }
    }

    private final String getKeyword() {
        String str;
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
        int i16;
        String str;
        String str2;
        String string;
        String string2;
        Bundle arguments = getArguments();
        int i17 = 0;
        if (arguments != null) {
            i3 = arguments.getInt(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE);
        } else {
            i3 = 0;
        }
        SearchDetailTabListViewModel.TabInfo tabInfo = new SearchDetailTabListViewModel.TabInfo("\u5c0f\u6e38\u620f", 11L);
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            i16 = arguments2.getInt(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE);
        } else {
            i16 = 0;
        }
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            i17 = arguments3.getInt("user_source");
        }
        int i18 = i17;
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (string2 = arguments4.getString("sessionId")) == null) {
            str = "";
        } else {
            str = string2;
        }
        String keyword = getKeyword();
        Bundle arguments5 = getArguments();
        if (arguments5 == null || (string = arguments5.getString("func_payload")) == null) {
            str2 = "";
        } else {
            str2 = string;
        }
        this.pageData = new SearchDetailTabContentFragment.PageData(tabInfo, i16, i18, str, keyword, str2, uh(), wh(), xh(), c.f284375a.a(i3, SpecialAction.ACTION_MINI_GAME_MORE), SearchDetailFragment.Companion.PageMode.MODE_NORMAL.getValue(), 0L, 2048, null);
        Logger.f235387a.d().d("QQSearch.NetDetail.WXMinGameMoreDetailFragment", 1, "initArguments " + this.pageData);
    }

    private final void initViewModel() {
        ViewModel viewModel = new ViewModelProvider(this).get(SearchDetailMinGameViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026ameViewModel::class.java)");
        SearchDetailMinGameViewModel searchDetailMinGameViewModel = (SearchDetailMinGameViewModel) viewModel;
        this.viewModel = searchDetailMinGameViewModel;
        SearchDetailMinGameViewModel searchDetailMinGameViewModel2 = null;
        if (searchDetailMinGameViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            searchDetailMinGameViewModel = null;
        }
        SearchDetailTabContentFragment.PageData pageData = this.pageData;
        SearchDetailMinGameViewModel searchDetailMinGameViewModel3 = this.viewModel;
        if (searchDetailMinGameViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            searchDetailMinGameViewModel3 = null;
        }
        searchDetailMinGameViewModel.T2(pageData, searchDetailMinGameViewModel3.getSessionId());
        SearchDetailMinGameViewModel searchDetailMinGameViewModel4 = this.viewModel;
        if (searchDetailMinGameViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            searchDetailMinGameViewModel2 = searchDetailMinGameViewModel4;
        }
        MutableLiveData<String> t26 = searchDetailMinGameViewModel2.t2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final WXMinGameMoreDetailFragment$initViewModel$1 wXMinGameMoreDetailFragment$initViewModel$1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.wxminapp.moredetail.WXMinGameMoreDetailFragment$initViewModel$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String keyword) {
                Intrinsics.checkNotNullExpressionValue(keyword, "keyword");
                if (keyword.length() > 0) {
                    Logger.f235387a.d().i("QQSearch.NetDetail.WXMinGameMoreDetailFragment", 1, "search success " + keyword);
                }
            }
        };
        t26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.content.wxminapp.moredetail.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WXMinGameMoreDetailFragment.yh(Function1.this, obj);
            }
        });
    }

    private final boolean sh() {
        if (!QQTheme.isNowThemeIsNight() && !QQTheme.isNowThemeSimpleNight()) {
            return false;
        }
        return true;
    }

    private final void th(ViewGroup contentView) {
        VideoReport.addToDetectionWhitelist(getActivity());
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        hashMap.put("pageId", "pg_qq_network_search_result_level2_page");
        hashMap.put("user_source", Integer.valueOf(this.pageData.getUserSource()));
        hashMap.put("tab_name", "\u5c0f\u6e38\u620f");
        VideoReport.setEventDynamicParams(contentView, new b(new WeakReference(this)));
        VideoReport.setPageId(contentView, "pg_qq_network_search_result_level2_page");
        VideoReport.setPageParams(contentView, new PageParams(hashMap));
    }

    private final boolean uh() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getBoolean("disableCorrect");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, Object> vh() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(PictureConst.KEY_PAGE_MODE, Integer.valueOf(this.pageData.getPageMode()));
        hashMap.put("tab_name", "\u5c0f\u6e38\u620f");
        return hashMap;
    }

    private final String wh() {
        String str;
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

    private final String xh() {
        String str;
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
    public static final void yh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        SearchDetailMinGameViewModel searchDetailMinGameViewModel;
        List<Part> mutableListOf;
        Part[] partArr = new Part[6];
        partArr[0] = new k(SearchPageType.PAGE_NET_SEARCH_MINI_GAME_MORE);
        partArr[1] = new SearchHistoryPart();
        SearchDetailMinGameViewModel searchDetailMinGameViewModel2 = this.viewModel;
        SearchDetailMinGameViewModel searchDetailMinGameViewModel3 = null;
        if (searchDetailMinGameViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            searchDetailMinGameViewModel2 = null;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        partArr[2] = new WXMinGameFilterPart(searchDetailMinGameViewModel2, viewLifecycleOwner);
        SearchDetailMinGameViewModel searchDetailMinGameViewModel4 = this.viewModel;
        if (searchDetailMinGameViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            searchDetailMinGameViewModel = null;
        } else {
            searchDetailMinGameViewModel = searchDetailMinGameViewModel4;
        }
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        SearchDetailMinGameViewModel searchDetailMinGameViewModel5 = this.viewModel;
        if (searchDetailMinGameViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            searchDetailMinGameViewModel5 = null;
        }
        partArr[3] = new ContentPart(searchDetailMinGameViewModel, viewLifecycleOwner2, null, searchDetailMinGameViewModel5.getSessionId(), 4, null);
        SearchDetailMinGameViewModel searchDetailMinGameViewModel6 = this.viewModel;
        if (searchDetailMinGameViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            searchDetailMinGameViewModel6 = null;
        }
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        partArr[4] = new LoadingPart(searchDetailMinGameViewModel6, viewLifecycleOwner3);
        SearchDetailMinGameViewModel searchDetailMinGameViewModel7 = this.viewModel;
        if (searchDetailMinGameViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            searchDetailMinGameViewModel3 = searchDetailMinGameViewModel7;
        }
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "viewLifecycleOwner");
        partArr[5] = new EmptyPart(searchDetailMinGameViewModel3, viewLifecycleOwner4);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(partArr);
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.h2n;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(StartSearchEvent.class, QSearchPostEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
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

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        SimpleEventBus.getInstance().dispatchEvent(new ThemeChangedEvent(sh()));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        int i3;
        SearchDetailMinGameViewModel searchDetailMinGameViewModel = null;
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
            SearchDetailTabContentFragment.PageData pageData = this.pageData;
            if (startSearchEvent.getRefreshType() == RefreshType.TYPE_CANCEL_CORRECT) {
                z16 = true;
            }
            pageData.m(z16);
            this.pageData.s(startSearchEvent.getSugTraceId());
            this.pageData.t(startSearchEvent.getWxPreSearchId());
            this.pageData.p(startSearchEvent.getParentType());
            SearchDetailMinGameViewModel searchDetailMinGameViewModel2 = this.viewModel;
            if (searchDetailMinGameViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                searchDetailMinGameViewModel2 = null;
            }
            SearchDetailTabContentFragment.PageData pageData2 = this.pageData;
            SearchDetailMinGameViewModel searchDetailMinGameViewModel3 = this.viewModel;
            if (searchDetailMinGameViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                searchDetailMinGameViewModel3 = null;
            }
            searchDetailMinGameViewModel2.T2(pageData2, searchDetailMinGameViewModel3.getSessionId());
            Logger.f235387a.d().i("QQSearch.NetDetail.WXMinGameMoreDetailFragment", 1, "onReceive tabInfo=" + this.pageData.getTabInfo() + " StartSearchEvent " + event);
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                SearchDetailMinGameViewModel searchDetailMinGameViewModel4 = this.viewModel;
                if (searchDetailMinGameViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    searchDetailMinGameViewModel4 = null;
                }
                searchDetailMinGameViewModel4.R2(activity2, this.pageData.getKeyword(), startSearchEvent.getRefreshType(), startSearchEvent.getSource());
            }
        }
        if (event instanceof QSearchPostEvent) {
            SearchDetailMinGameViewModel searchDetailMinGameViewModel5 = this.viewModel;
            if (searchDetailMinGameViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                searchDetailMinGameViewModel = searchDetailMinGameViewModel5;
            }
            searchDetailMinGameViewModel.I2((QSearchPostEvent) event);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AbstractGifImage.resumeAll();
        ApngImage.resumeAll();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        th((ViewGroup) view);
    }
}
