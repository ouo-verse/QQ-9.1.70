package com.tencent.mobileqq.zootopia.portal.detail.rank;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.portal.detail.ao;
import com.tencent.mobileqq.zootopia.portal.detail.rank.l;
import com.tencent.mobileqq.zootopia.view.ZootopiaSelfRankFloatBar;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.sqshow.fragment.ZootopiaBaseFragment;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import com.tencent.sqshow.zootopia.data.ZootopiaMapTab;
import com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaLoadMoreView;
import com.tencent.widget.pull2refresh.ILoadMoreLayout;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import fi3.s;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import zb3.ZootopiaUserRankData;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 _2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001`B\u0007\u00a2\u0006\u0004\b]\u0010^J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\u0006\u0010 \u001a\u00020\u0004J*\u0010'\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020!H\u0016J\n\u0010(\u001a\u0004\u0018\u00010#H\u0016J\b\u0010)\u001a\u00020!H\u0016J\b\u0010*\u001a\u00020\u0004H\u0016J\u0012\u0010-\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u000fH\u0016R\u001b\u00105\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R$\u0010A\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010H\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010L\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010JR\u0016\u0010N\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010JR\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/rank/ZootopiaDetailRankFragment;", "Lcom/tencent/sqshow/fragment/ZootopiaBaseFragment;", "Lcom/tencent/widget/pull2refresh/LoadingMoreHelper$OnLoadMoreListener;", "Lxc3/b;", "", "initData", "Th", "Sh", "Lzb3/k;", "selfRankData", "Nh", "Vh", "Uh", "", "getSubSource", "", "onBackPressedEvent", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "isManual", "onLoadMore", "onLoadMoreComplete", "loadData", "", "mapId", "Lcom/tencent/sqshow/zootopia/data/n;", "mapTab", com.tencent.luggage.wxa.c8.c.G, "totalTabCount", "r7", "G", "lb", "X0", "Lxc3/a;", HippyNestedScrollComponent.PRIORITY_PARENT, "zd", "isAppBarPin", "x8", "Lcom/tencent/mobileqq/zootopia/portal/detail/rank/d;", "N", "Lkotlin/Lazy;", "Oh", "()Lcom/tencent/mobileqq/zootopia/portal/detail/rank/d;", "adapter", "Lcom/tencent/mobileqq/zootopia/portal/detail/rank/ZootopiaDetailRankHeaderView;", "P", "Lcom/tencent/mobileqq/zootopia/portal/detail/rank/ZootopiaDetailRankHeaderView;", "rankHeaderView", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaSelfRankFloatBar;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/zootopia/view/ZootopiaSelfRankFloatBar;", "getRankBootFloatBar", "()Lcom/tencent/mobileqq/zootopia/view/ZootopiaSelfRankFloatBar;", "Wh", "(Lcom/tencent/mobileqq/zootopia/view/ZootopiaSelfRankFloatBar;)V", "rankBootFloatBar", "Lfi3/s;", BdhLogUtil.LogTag.Tag_Req, "Lfi3/s;", "binding", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/sqshow/zootopia/data/n;", "mapTabInfo", "T", "I", "U", "curSwitchShowType", "V", "tabPos", "W", "Lxc3/a;", "Lcom/tencent/mobileqq/zootopia/portal/detail/rank/l;", "X", "Lcom/tencent/mobileqq/zootopia/portal/detail/rank/l;", "vm", "Lcom/tencent/widget/pull2refresh/LoadingMoreHelper;", "Y", "Lcom/tencent/widget/pull2refresh/LoadingMoreHelper;", "loadMoreLayoutHelper", "Lcom/tencent/widget/pull2refresh/ILoadMoreLayout;", "Z", "Lcom/tencent/widget/pull2refresh/ILoadMoreLayout;", "loadMoreLayout", "<init>", "()V", "a0", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDetailRankFragment extends ZootopiaBaseFragment implements LoadingMoreHelper.OnLoadMoreListener, xc3.b {

    /* renamed from: N, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: P, reason: from kotlin metadata */
    private ZootopiaDetailRankHeaderView rankHeaderView;

    /* renamed from: Q, reason: from kotlin metadata */
    private ZootopiaSelfRankFloatBar rankBootFloatBar;

    /* renamed from: R, reason: from kotlin metadata */
    private s binding;

    /* renamed from: S, reason: from kotlin metadata */
    private ZootopiaMapTab mapTabInfo;

    /* renamed from: T, reason: from kotlin metadata */
    private int mapId;

    /* renamed from: U, reason: from kotlin metadata */
    private int curSwitchShowType;

    /* renamed from: V, reason: from kotlin metadata */
    private int tabPos;

    /* renamed from: W, reason: from kotlin metadata */
    private xc3.a parent;

    /* renamed from: X, reason: from kotlin metadata */
    private l vm;

    /* renamed from: Y, reason: from kotlin metadata */
    private LoadingMoreHelper loadMoreLayoutHelper;

    /* renamed from: Z, reason: from kotlin metadata */
    private ILoadMoreLayout loadMoreLayout;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/portal/detail/rank/ZootopiaDetailRankFragment$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            LoadingMoreHelper loadingMoreHelper;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                if (linearLayoutManager != null) {
                    int childCount = recyclerView.getChildCount();
                    int itemCount = linearLayoutManager.getItemCount();
                    int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    LoadingMoreHelper loadingMoreHelper2 = ZootopiaDetailRankFragment.this.loadMoreLayoutHelper;
                    if (!(itemCount - childCount <= findFirstVisibleItemPosition + (loadingMoreHelper2 != null ? loadingMoreHelper2.getProLoaderCount() : 0)) || (loadingMoreHelper = ZootopiaDetailRankFragment.this.loadMoreLayoutHelper) == null) {
                        return;
                    }
                    loadingMoreHelper.setLoadMore(true);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/portal/detail/rank/ZootopiaDetailRankFragment$c", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements ViewModelProvider.Factory {
        c() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x001c, code lost:
        
            r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r1);
         */
        @Override // androidx.lifecycle.ViewModelProvider.Factory
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public <T extends ViewModel> T create(Class<T> modelClass) {
            Integer intOrNull;
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            int i3 = ZootopiaDetailRankFragment.this.mapId;
            ZootopiaMapTab zootopiaMapTab = ZootopiaDetailRankFragment.this.mapTabInfo;
            int intValue = (zootopiaMapTab == null || (r1 = zootopiaMapTab.b()) == null || intOrNull == null) ? 0 : intOrNull.intValue();
            return new l(i3, intValue, new ao(1));
        }
    }

    public ZootopiaDetailRankFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<d>() { // from class: com.tencent.mobileqq.zootopia.portal.detail.rank.ZootopiaDetailRankFragment$adapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d invoke() {
                return new d();
            }
        });
        this.adapter = lazy;
    }

    private final void Nh(zb3.k selfRankData) {
        ZootopiaSelfRankFloatBar zootopiaSelfRankFloatBar = this.rankBootFloatBar;
        if (zootopiaSelfRankFloatBar != null) {
            zootopiaSelfRankFloatBar.setMapDetailRankData(selfRankData);
        }
        ZootopiaSelfRankFloatBar zootopiaSelfRankFloatBar2 = this.rankBootFloatBar;
        if (zootopiaSelfRankFloatBar2 != null) {
            zootopiaSelfRankFloatBar2.i();
        }
    }

    private final d Oh() {
        return (d) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(ZootopiaDetailRankFragment this$0, zb3.k it) {
        List<ZootopiaUserRankData> arrayList;
        Resources resources;
        Resources resources2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LoadingMoreHelper loadingMoreHelper = this$0.loadMoreLayoutHelper;
        if (loadingMoreHelper != null) {
            loadingMoreHelper.setLoadMoreEnabled(!it.g().isEmpty());
        }
        LoadingMoreHelper loadingMoreHelper2 = this$0.loadMoreLayoutHelper;
        if (loadingMoreHelper2 != null) {
            loadingMoreHelper2.setLoadMoreComplete(true, it.getHasMore());
        }
        if (this$0.Oh().getNUM_BACKGOURND_ICON() == 0 || this$0.curSwitchShowType != it.getShowSwitch()) {
            this$0.curSwitchShowType = it.getShowSwitch();
        }
        ILoadMoreLayout iLoadMoreLayout = this$0.loadMoreLayout;
        String str = null;
        ZootopiaLoadMoreView zootopiaLoadMoreView = iLoadMoreLayout instanceof ZootopiaLoadMoreView ? (ZootopiaLoadMoreView) iLoadMoreLayout : null;
        if (zootopiaLoadMoreView != null) {
            if (it.g().size() <= 3) {
                str = "";
            } else if (it.g().size() != it.getRankConfig().getRankDataMax()) {
                Context context = this$0.getContext();
                if (context != null && (resources2 = context.getResources()) != null) {
                    str = resources2.getString(R.string.xjz);
                }
            } else {
                Context context2 = this$0.getContext();
                if (context2 != null && (resources = context2.getResources()) != null) {
                    str = resources.getString(R.string.xi8, Integer.valueOf(Math.max(it.getRankConfig().getRankDataMax(), it.g().size())));
                }
            }
            zootopiaLoadMoreView.h(str);
        }
        ZootopiaDetailRankHeaderView zootopiaDetailRankHeaderView = this$0.rankHeaderView;
        if (zootopiaDetailRankHeaderView != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            zootopiaDetailRankHeaderView.h(it, it.g(), this$0.curSwitchShowType);
        }
        xc3.a aVar = this$0.parent;
        if (aVar != null) {
            aVar.Y();
        }
        d Oh = this$0.Oh();
        if (it.g().size() > 3) {
            arrayList = it.g().subList(3, it.g().size());
        } else {
            arrayList = new ArrayList<>();
        }
        Oh.i0(arrayList);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.Nh(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(ZootopiaDetailRankFragment this$0, l.LoadingMessage loadingMessage) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = loadingMessage.getLoadingViewStatus() != l.INSTANCE.c();
        ZootopiaDetailRankHeaderView zootopiaDetailRankHeaderView = this$0.rankHeaderView;
        if (zootopiaDetailRankHeaderView != null) {
            zootopiaDetailRankHeaderView.i(z16, loadingMessage.getLoadingViewStatus());
        }
        this$0.Oh().l0(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(ZootopiaDetailRankFragment this$0, ErrorMessage errorMessage) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        xc3.a aVar = this$0.parent;
        if (aVar != null) {
            aVar.Y();
        }
    }

    private final void Sh() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ZootopiaLoadMoreView zootopiaLoadMoreView = new ZootopiaLoadMoreView(requireContext, null, 0, 6, null);
        zootopiaLoadMoreView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.loadMoreLayout = zootopiaLoadMoreView;
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        com.tencent.sqshow.zootopia.view.pull2refresh.a aVar = new com.tencent.sqshow.zootopia.view.pull2refresh.a(zootopiaLoadMoreView, requireContext2);
        this.loadMoreLayoutHelper = aVar;
        aVar.setOnLoadMoreListener(this);
    }

    private final void Th() {
        s sVar = this.binding;
        if (sVar == null) {
            return;
        }
        Sh();
        LoadingMoreHelper loadingMoreHelper = this.loadMoreLayoutHelper;
        if (loadingMoreHelper != null) {
            loadingMoreHelper.setPreLoaderCount(10);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), 1, false);
        RecyclerView recyclerView = sVar.f399357b;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        this.rankHeaderView = new ZootopiaDetailRankHeaderView(requireContext, null, 0, 6, null);
        Oh().k0(this.rankHeaderView);
        d Oh = Oh();
        Object obj = this.loadMoreLayout;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
        Oh.j0((View) obj);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(Oh());
        recyclerView.setItemAnimator(null);
        recyclerView.addOnScrollListener(new b());
    }

    private final void initData() {
        MutableLiveData<ErrorMessage> S1;
        MutableLiveData<l.LoadingMessage> U1;
        MutableLiveData<zb3.k> W1;
        ZootopiaDetailRankHeaderView zootopiaDetailRankHeaderView = this.rankHeaderView;
        if (zootopiaDetailRankHeaderView != null) {
            zootopiaDetailRankHeaderView.setMapTabInfo(this.mapTabInfo);
        }
        ZootopiaDetailRankHeaderView zootopiaDetailRankHeaderView2 = this.rankHeaderView;
        if (zootopiaDetailRankHeaderView2 != null) {
            zootopiaDetailRankHeaderView2.setViewModel(this.vm);
        }
        l lVar = this.vm;
        if (lVar != null && (W1 = lVar.W1()) != null) {
            W1.observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.rank.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ZootopiaDetailRankFragment.Ph(ZootopiaDetailRankFragment.this, (zb3.k) obj);
                }
            });
        }
        l lVar2 = this.vm;
        if (lVar2 != null && (U1 = lVar2.U1()) != null) {
            U1.observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.rank.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ZootopiaDetailRankFragment.Qh(ZootopiaDetailRankFragment.this, (l.LoadingMessage) obj);
                }
            });
        }
        l lVar3 = this.vm;
        if (lVar3 != null && (S1 = lVar3.S1()) != null) {
            S1.observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.rank.g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ZootopiaDetailRankFragment.Rh(ZootopiaDetailRankFragment.this, (ErrorMessage) obj);
                }
            });
        }
        l lVar4 = this.vm;
        if (lVar4 != null) {
            lVar4.b2(0);
        }
    }

    @Override // xc3.b
    /* renamed from: G, reason: from getter */
    public ZootopiaMapTab getMapTabInfo() {
        return this.mapTabInfo;
    }

    public final void Wh(ZootopiaSelfRankFloatBar zootopiaSelfRankFloatBar) {
        this.rankBootFloatBar = zootopiaSelfRankFloatBar;
    }

    @Override // xc3.b
    public void X0() {
        Uh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public String getSubSource() {
        return ZootopiaSource.SUB_SOURCE_MAP_DETAIL;
    }

    @Override // xc3.b
    /* renamed from: lb, reason: from getter */
    public int getTabPos() {
        return this.tabPos;
    }

    public final void loadData() {
        l lVar;
        if (this.mapTabInfo == null || (lVar = this.vm) == null) {
            return;
        }
        lVar.b2(this.curSwitchShowType);
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        return false;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QLog.i("ZootopiaDetailRankFragment", 1, "onViewCreated - " + this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        s g16 = s.g(inflater, container, false);
        this.binding = g16;
        if (g16 != null) {
            return g16.getRoot();
        }
        return null;
    }

    @Override // com.tencent.widget.pull2refresh.LoadingMoreHelper.OnLoadMoreListener
    public boolean onLoadMore(boolean isManual) {
        Vh();
        return true;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (this.binding == null) {
            return;
        }
        QLog.i("ZootopiaDetailRankFragment", 1, "onViewCreated, mapId = " + this.mapId + " mapTabInfo = " + this.mapTabInfo);
        this.vm = (l) com.tencent.mobileqq.mvvm.h.b(this, new c()).get(l.class);
        Th();
        initData();
    }

    @Override // xc3.b
    public void r7(int mapId, ZootopiaMapTab mapTab, int pos, int totalTabCount) {
        this.mapId = mapId;
        this.mapTabInfo = mapTab;
        this.tabPos = pos;
        QLog.i("ZootopiaDetailRankFragment", 1, "setTabInfo, mapId = " + mapId + " mapTabInfo = " + mapTab);
    }

    @Override // xc3.b
    public void zd(xc3.a parent) {
        this.parent = parent;
    }

    private final void Uh() {
        QLog.i("ZootopiaDetailRankFragment", 1, "refreshData");
        l lVar = this.vm;
        if (lVar != null) {
            lVar.e2(this.curSwitchShowType);
        }
        loadData();
    }

    private final void Vh() {
        QLog.i("ZootopiaDetailRankFragment", 1, "requestNextPageData");
        loadData();
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.binding = null;
        super.onDestroy();
    }

    @Override // com.tencent.widget.pull2refresh.LoadingMoreHelper.OnLoadMoreListener
    public void onLoadMoreComplete() {
        QLog.i("ZootopiaDetailRankFragment", 1, "onLoadMoreComplete");
    }

    @Override // xc3.b
    public void x8(boolean isAppBarPin) {
    }
}
