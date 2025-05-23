package com.tencent.mobileqq.zootopia.portal.detail.main;

import android.content.Context;
import android.os.Bundle;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.z1.cloudmod.api.ZPlanCloudGameInfo;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.portal.detail.ZootopiaDetailFragment;
import com.tencent.mobileqq.zootopia.portal.detail.ah;
import com.tencent.mobileqq.zootopia.portal.detail.am;
import com.tencent.mobileqq.zootopia.portal.detail.an;
import com.tencent.mobileqq.zootopia.portal.detail.events.ZootopiaDetailFragmentCloseEvent;
import com.tencent.mobileqq.zootopia.view.ZootopiaDetailFloatBar;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButtonBinder;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.fragment.ZootopiaBaseFragment;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import com.tencent.sqshow.zootopia.data.ZootopiaMapDetail;
import com.tencent.sqshow.zootopia.data.ZootopiaMapSimpleInfo;
import com.tencent.sqshow.zootopia.data.ZootopiaMapTab;
import com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaLoadMoreView;
import com.tencent.widget.pull2refresh.ILoadMoreLayout;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import fi3.w;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import zb3.ZootopiaMapCommentResp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\bt\u0010uJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0014J.\u0010\u001e\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0012\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010&\u001a\u0004\u0018\u00010\t2\u0006\u0010#\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010'\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u0012H\u0016J\b\u0010*\u001a\u00020\u0004H\u0016J\b\u0010+\u001a\u00020\u0004H\u0016J\b\u0010,\u001a\u00020\u0012H\u0016J*\u00103\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00101\u001a\u00020-2\u0006\u00102\u001a\u00020-H\u0016J\n\u00104\u001a\u0004\u0018\u00010/H\u0016J\b\u00105\u001a\u00020-H\u0016J\b\u00106\u001a\u00020\u0004H\u0016J\u0012\u00109\u001a\u00020\u00042\b\u00108\u001a\u0004\u0018\u000107H\u0016J\u0010\u0010;\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0012H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u001b\u0010G\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010T\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010X\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010VR\u0016\u00102\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010VR\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R$\u0010c\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001a\u0010h\u001a\b\u0012\u0004\u0012\u00020e0d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u001a\u0010k\u001a\b\u0012\u0004\u0012\u00020i0d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bj\u0010gR\u0018\u0010o\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010s\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010r\u00a8\u0006v"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/main/ZootopiaDetailMainFragment;", "Lcom/tencent/sqshow/fragment/ZootopiaBaseFragment;", "Lcom/tencent/widget/pull2refresh/LoadingMoreHelper$OnLoadMoreListener;", "Lxc3/b;", "", "ci", "Lcom/tencent/sqshow/zootopia/data/m;", "detail", "Oh", "Landroid/view/View;", "view", "Ph", "Uh", "Th", "di", "bi", "Lcom/tencent/mobileqq/zootopia/portal/detail/an;", "Sh", "", "Zh", "", "getSubSource", "Lcom/tencent/mobileqq/zootopia/portal/detail/am;", "vm", "Loa4/a;", "mapResVm", "Lcom/tencent/mobileqq/zootopia/portal/detail/ah;", "reportHelper", "Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragment$Config;", DownloadInfo.spKey_Config, "Qh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "isManual", "onLoadMore", "onLoadMoreComplete", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onBackPressedEvent", "", "mapId", "Lcom/tencent/sqshow/zootopia/data/n;", "mapTab", com.tencent.luggage.wxa.c8.c.G, "totalTabCount", "r7", "G", "lb", "X0", "Lxc3/a;", HippyNestedScrollComponent.PRIORITY_PARENT, "zd", "isAppBarPin", "x8", "N", "Lcom/tencent/mobileqq/zootopia/portal/detail/am;", "P", "Loa4/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/zootopia/portal/detail/ah;", "Lcom/tencent/mobileqq/zootopia/portal/detail/main/d;", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/Lazy;", "Rh", "()Lcom/tencent/mobileqq/zootopia/portal/detail/main/d;", "adapter", "Lcom/tencent/mobileqq/zootopia/portal/detail/main/ZootopiaDetailMainHeaderView;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/zootopia/portal/detail/main/ZootopiaDetailMainHeaderView;", "commentHeadView", "Lfi3/w;", "T", "Lfi3/w;", "binding", "U", "Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragment$Config;", "V", "Lcom/tencent/sqshow/zootopia/data/n;", "mapTabInfo", "W", "I", "X", "tabPos", "Y", "Z", "Lxc3/a;", "Lcom/tencent/mobileqq/zootopia/api/b;", "a0", "Lcom/tencent/mobileqq/zootopia/api/b;", "getBackListener", "()Lcom/tencent/mobileqq/zootopia/api/b;", "setBackListener", "(Lcom/tencent/mobileqq/zootopia/api/b;)V", "backListener", "Landroidx/lifecycle/Observer;", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "b0", "Landroidx/lifecycle/Observer;", "statusObserver", "", "c0", "progressObserver", "Lcom/tencent/widget/pull2refresh/LoadingMoreHelper;", "d0", "Lcom/tencent/widget/pull2refresh/LoadingMoreHelper;", "loadMoreLayoutHelper", "Lcom/tencent/widget/pull2refresh/ILoadMoreLayout;", "e0", "Lcom/tencent/widget/pull2refresh/ILoadMoreLayout;", "loadMoreLayout", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDetailMainFragment extends ZootopiaBaseFragment implements LoadingMoreHelper.OnLoadMoreListener, xc3.b {

    /* renamed from: N, reason: from kotlin metadata */
    private am vm;

    /* renamed from: P, reason: from kotlin metadata */
    private oa4.a mapResVm;

    /* renamed from: Q, reason: from kotlin metadata */
    private ah reportHelper;

    /* renamed from: R, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: S, reason: from kotlin metadata */
    private ZootopiaDetailMainHeaderView commentHeadView;

    /* renamed from: T, reason: from kotlin metadata */
    private w binding;

    /* renamed from: U, reason: from kotlin metadata */
    private ZootopiaDetailFragment.Config config;

    /* renamed from: V, reason: from kotlin metadata */
    private ZootopiaMapTab mapTabInfo;

    /* renamed from: W, reason: from kotlin metadata */
    private int mapId;

    /* renamed from: X, reason: from kotlin metadata */
    private int tabPos;

    /* renamed from: Y, reason: from kotlin metadata */
    private int totalTabCount;

    /* renamed from: Z, reason: from kotlin metadata */
    private xc3.a parent;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zootopia.api.b backListener;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final Observer<ButtonStatus> statusObserver;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final Observer<Float> progressObserver;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private LoadingMoreHelper loadMoreLayoutHelper;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private ILoadMoreLayout loadMoreLayout;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/portal/detail/main/ZootopiaDetailMainFragment$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
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
                    LoadingMoreHelper loadingMoreHelper2 = ZootopiaDetailMainFragment.this.loadMoreLayoutHelper;
                    if (!(itemCount - childCount <= findFirstVisibleItemPosition + (loadingMoreHelper2 != null ? loadingMoreHelper2.getProLoaderCount() : 0)) || (loadingMoreHelper = ZootopiaDetailMainFragment.this.loadMoreLayoutHelper) == null) {
                        return;
                    }
                    loadingMoreHelper.setLoadMore(true);
                }
            }
        }
    }

    public ZootopiaDetailMainFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<d>() { // from class: com.tencent.mobileqq.zootopia.portal.detail.main.ZootopiaDetailMainFragment$adapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d invoke() {
                return new d();
            }
        });
        this.adapter = lazy;
        this.statusObserver = new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.main.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailMainFragment.ei(ZootopiaDetailMainFragment.this, (ButtonStatus) obj);
            }
        };
        this.progressObserver = new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.main.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailMainFragment.ai(ZootopiaDetailMainFragment.this, (Float) obj);
            }
        };
    }

    private final void Oh(ZootopiaMapDetail detail) {
        LiveData<Float> O1;
        LiveData<ButtonStatus> P1;
        oa4.a aVar = this.mapResVm;
        if (aVar != null) {
            aVar.M1(String.valueOf(detail.getId()));
        }
        oa4.a aVar2 = this.mapResVm;
        if (aVar2 != null && (P1 = aVar2.P1(String.valueOf(detail.getId()))) != null) {
            P1.removeObserver(this.statusObserver);
            P1.observe(getViewLifecycleOwner(), this.statusObserver);
        }
        oa4.a aVar3 = this.mapResVm;
        if (aVar3 == null || (O1 = aVar3.O1(String.valueOf(detail.getId()))) == null) {
            return;
        }
        O1.removeObserver(this.progressObserver);
        O1.observe(getViewLifecycleOwner(), this.progressObserver);
    }

    private final void Ph(ZootopiaMapDetail detail, View view) {
        MutableLiveData<ZootopiaMapDetail> R1;
        ZootopiaMapDetail value;
        MutableLiveData<ZootopiaMapDetail> R12;
        ZootopiaMapDetail value2;
        w wVar = this.binding;
        if (wVar == null) {
            return;
        }
        ZootopiaDetailFloatBar zootopiaDetailFloatBar = wVar.f399421b;
        zootopiaDetailFloatBar.setMapDetailData(detail);
        am amVar = this.vm;
        boolean z16 = false;
        if (!((amVar == null || (R12 = amVar.R1()) == null || (value2 = R12.getValue()) == null || value2.getQqVersionTipsCode() != 0) ? false : true)) {
            am amVar2 = this.vm;
            if (amVar2 != null && (R1 = amVar2.R1()) != null && (value = R1.getValue()) != null && value.getMapVersionTipsCode() == 0) {
                z16 = true;
            }
            if (!z16) {
                zootopiaDetailFloatBar.setSizeTextVisible(8);
            }
        }
        wVar.f399421b.getBtnDownload().setButtonStatusListener(Sh(detail));
        if (ZPlanCloudGameInfo.INSTANCE.a(detail.getCloudGameInfo())) {
            wVar.f399421b.getBtnDownload().setIsInitCloudModType(true);
            wVar.f399421b.getBtnDownload().setStatus(ButtonStatus.CLOUD_GAME);
            wVar.f399421b.setSizeTextVisible(8);
        } else {
            wVar.f399421b.getBtnDownload().B();
            wVar.f399421b.getBtnDownload().setStatusText(ButtonStatus.LOADED, detail.getButtonText());
        }
    }

    private final d Rh() {
        return (d) this.adapter.getValue();
    }

    private final an Sh(ZootopiaMapDetail detail) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        oa4.a aVar = this.mapResVm;
        ZootopiaSource Ch = Ch();
        ZootopiaDetailFragment.Config config = this.config;
        return new an(requireContext, detail, aVar, Ch, config != null ? config.getUeParams() : null);
    }

    private final void Th() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ZootopiaLoadMoreView zootopiaLoadMoreView = new ZootopiaLoadMoreView(requireContext, null, 0, 6, null);
        this.loadMoreLayout = zootopiaLoadMoreView;
        Intrinsics.checkNotNull(zootopiaLoadMoreView, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaLoadMoreView");
        zootopiaLoadMoreView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        ILoadMoreLayout iLoadMoreLayout = this.loadMoreLayout;
        Intrinsics.checkNotNull(iLoadMoreLayout);
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        com.tencent.sqshow.zootopia.view.pull2refresh.a aVar = new com.tencent.sqshow.zootopia.view.pull2refresh.a(iLoadMoreLayout, requireContext2);
        this.loadMoreLayoutHelper = aVar;
        aVar.setOnLoadMoreListener(this);
    }

    private final void Uh() {
        w wVar = this.binding;
        if (wVar == null) {
            return;
        }
        Th();
        LoadingMoreHelper loadingMoreHelper = this.loadMoreLayoutHelper;
        if (loadingMoreHelper != null) {
            loadingMoreHelper.setPreLoaderCount(12);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), 1, false);
        RecyclerView recyclerView = wVar.f399424e;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        if (this.vm != null && this.config != null) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            am amVar = this.vm;
            Intrinsics.checkNotNull(amVar);
            ZootopiaDetailFragment.Config config = this.config;
            Intrinsics.checkNotNull(config);
            ButtonStatus buttonStatus = config.getButtonStatus();
            ZootopiaDetailFragment.Config config2 = this.config;
            Intrinsics.checkNotNull(config2);
            this.commentHeadView = new ZootopiaDetailMainHeaderView(requireContext, this, amVar, buttonStatus, config2.getButtonProgress(), Dh());
            Rh().k0(this.commentHeadView);
        }
        d Rh = Rh();
        Object obj = this.loadMoreLayout;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
        Rh.j0((View) obj);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(Rh());
        recyclerView.setItemAnimator(null);
        recyclerView.addOnScrollListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(w binding, ZootopiaDetailMainFragment this$0, View view, ZootopiaMapDetail zootopiaMapDetail) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        if (binding.f399425f.getVisibility() == 0) {
            binding.f399425f.setVisibility(8);
        }
        if (zootopiaMapDetail != null) {
            LoadingMoreHelper loadingMoreHelper = this$0.loadMoreLayoutHelper;
            if (loadingMoreHelper != null) {
                loadingMoreHelper.setLoadMoreEnabled(!zootopiaMapDetail.g().isEmpty());
            }
            this$0.Rh().i0(zootopiaMapDetail.g());
            this$0.Oh(zootopiaMapDetail);
            this$0.Ph(zootopiaMapDetail, view);
            xc3.a aVar = this$0.parent;
            if (aVar != null) {
                aVar.Y();
            }
            LoadingMoreHelper loadingMoreHelper2 = this$0.loadMoreLayoutHelper;
            if (loadingMoreHelper2 != null) {
                loadingMoreHelper2.setLoadMoreComplete(true, zootopiaMapDetail.g().size() == 3);
            }
            binding.f399424e.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(w binding, final ZootopiaDetailMainFragment this$0, final ZootopiaMapCommentResp zootopiaMapCommentResp) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        binding.f399424e.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.portal.detail.main.j
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaDetailMainFragment.Xh(ZootopiaDetailMainFragment.this, zootopiaMapCommentResp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(ZootopiaDetailMainFragment this$0, ZootopiaMapCommentResp zootopiaMapCommentResp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Rh().appendList(zootopiaMapCommentResp.a());
        LoadingMoreHelper loadingMoreHelper = this$0.loadMoreLayoutHelper;
        if (loadingMoreHelper != null) {
            loadingMoreHelper.setLoadMoreComplete(true, zootopiaMapCommentResp.getHasMore());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(w binding, ZootopiaDetailMainFragment this$0, ErrorMessage errorMessage) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (binding.f399425f.getVisibility() == 0) {
            binding.f399425f.setVisibility(8);
        }
        if (errorMessage != null) {
            QLog.d("ZootopiaBaseFragment", 1, "errorMessage:" + errorMessage);
            xc3.a aVar = this$0.parent;
            if (aVar != null) {
                aVar.Y();
            }
            QQToast.makeText(this$0.getActivity(), 1, R.string.xi6, 0).show();
        }
    }

    private final boolean Zh() {
        return this.totalTabCount > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(ZootopiaDetailMainFragment this$0, Float it) {
        ZootopiaDetailFloatBar zootopiaDetailFloatBar;
        ZootopiaDownloadButton btnDownload;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w wVar = this$0.binding;
        if (wVar == null || (zootopiaDetailFloatBar = wVar.f399421b) == null || (btnDownload = zootopiaDetailFloatBar.getBtnDownload()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        btnDownload.setProcess(it.floatValue());
    }

    private final void ci() {
        w wVar = this.binding;
        if (wVar == null) {
            return;
        }
        int i3 = Zh() ? 0 : 8;
        wVar.f399422c.setVisibility(i3);
        wVar.f399423d.setVisibility(i3);
        ZootopiaDetailMainHeaderView zootopiaDetailMainHeaderView = this.commentHeadView;
        if (zootopiaDetailMainHeaderView != null) {
            zootopiaDetailMainHeaderView.j(Zh());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(ZootopiaDetailMainFragment this$0, ButtonStatus it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w wVar = this$0.binding;
        if (wVar == null) {
            return;
        }
        if (wVar.f399421b.getBtnDownload().getIsInitCloudModType()) {
            ZootopiaDownloadButtonBinder.Companion companion = ZootopiaDownloadButtonBinder.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (companion.a(it)) {
                wVar.f399421b.getBtnDownload().setStatus(ButtonStatus.CLOUD_GAME);
                wVar.f399421b.setSizeTextVisible(8);
                return;
            }
        }
        wVar.f399421b.getBtnDownload().B();
        ZootopiaDownloadButton btnDownload = wVar.f399421b.getBtnDownload();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        btnDownload.setStatus(it);
        if (wVar.f399421b.g()) {
            wVar.f399421b.setSizeTextVisible(0);
        } else {
            wVar.f399421b.setSizeTextVisible(8);
        }
    }

    @Override // xc3.b
    /* renamed from: G, reason: from getter */
    public ZootopiaMapTab getMapTabInfo() {
        return this.mapTabInfo;
    }

    public final void Qh(am vm5, oa4.a mapResVm, ah reportHelper, ZootopiaDetailFragment.Config config) {
        this.vm = vm5;
        this.mapResVm = mapResVm;
        this.reportHelper = reportHelper;
        this.config = config;
    }

    @Override // xc3.b
    public void X0() {
        bi();
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

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        FragmentManager supportFragmentManager;
        FragmentActivity activity = getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            if (supportFragmentManager.getFragments().size() > 1) {
                com.tencent.mobileqq.zootopia.api.b bVar = this.backListener;
                if (bVar != null) {
                    bVar.onBackPressedEvent();
                }
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                am amVar = this.vm;
                simpleEventBus.dispatchEvent(new ZootopiaDetailFragmentCloseEvent(amVar != null ? amVar.T1() : 0, Ch(), true));
            } else {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
            }
        }
        return true;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setEnterTransition(new Fade());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        w g16 = w.g(inflater, container, false);
        this.binding = g16;
        if (g16 != null) {
            return g16.getRoot();
        }
        return null;
    }

    @Override // com.tencent.widget.pull2refresh.LoadingMoreHelper.OnLoadMoreListener
    public boolean onLoadMore(boolean isManual) {
        di();
        return true;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        String str;
        ZootopiaMapSimpleInfo mapItemInfo;
        ZootopiaMapSimpleInfo mapItemInfo2;
        MutableLiveData<ErrorMessage> S1;
        MutableLiveData<ZootopiaMapCommentResp> Q1;
        MutableLiveData<ZootopiaMapDetail> R1;
        Intrinsics.checkNotNullParameter(view, "view");
        final w wVar = this.binding;
        if (wVar == null) {
            return;
        }
        Uh();
        am amVar = this.vm;
        int i3 = 0;
        if ((amVar != null ? amVar.getMapItemInfo() : null) == null) {
            wVar.f399424e.setVisibility(4);
            wVar.f399425f.setVisibility(0);
        }
        wVar.f399421b.getBtnDownload().setCloudModButtonStyle(s84.b.f433495a.a(4));
        am amVar2 = this.vm;
        if (amVar2 != null && (R1 = amVar2.R1()) != null) {
            R1.observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.main.g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ZootopiaDetailMainFragment.Vh(w.this, this, view, (ZootopiaMapDetail) obj);
                }
            });
        }
        am amVar3 = this.vm;
        if (amVar3 != null && (Q1 = amVar3.Q1()) != null) {
            Q1.observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.main.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ZootopiaDetailMainFragment.Wh(w.this, this, (ZootopiaMapCommentResp) obj);
                }
            });
        }
        am amVar4 = this.vm;
        if (amVar4 != null && (S1 = amVar4.S1()) != null) {
            S1.observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.main.i
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ZootopiaDetailMainFragment.Yh(w.this, this, (ErrorMessage) obj);
                }
            });
        }
        am amVar5 = this.vm;
        if (amVar5 != null) {
            amVar5.a2();
        }
        ci();
        ah ahVar = this.reportHelper;
        if (ahVar != null) {
            am amVar6 = this.vm;
            if (amVar6 != null && (mapItemInfo2 = amVar6.getMapItemInfo()) != null) {
                i3 = mapItemInfo2.getMapID();
            } else {
                am amVar7 = this.vm;
                if (amVar7 != null) {
                    i3 = amVar7.T1();
                }
            }
            int i16 = i3;
            am amVar8 = this.vm;
            if (amVar8 == null || (mapItemInfo = amVar8.getMapItemInfo()) == null || (str = mapItemInfo.getName()) == null) {
                str = "";
            }
            ah.f(ahVar, view, i16, str, Dh(), null, 16, null);
            ah.c(ahVar, wVar.f399421b.getBtnDownload(), false, false, 6, null);
        }
    }

    @Override // xc3.b
    public void r7(int mapId, ZootopiaMapTab mapTab, int pos, int totalTabCount) {
        this.tabPos = pos;
        this.mapId = mapId;
        this.mapTabInfo = mapTab;
        this.totalTabCount = totalTabCount;
        ci();
    }

    @Override // xc3.b
    public void x8(boolean isAppBarPin) {
        ZootopiaDetailFloatBar zootopiaDetailFloatBar;
        ah ahVar;
        MutableLiveData<ZootopiaMapDetail> R1;
        ZootopiaMapDetail value;
        ZootopiaDetailFloatBar zootopiaDetailFloatBar2;
        ZootopiaDownloadButton btnDownload;
        ZootopiaDetailFloatBar zootopiaDetailFloatBar3;
        ZootopiaDetailFloatBar zootopiaDetailFloatBar4;
        if (Zh()) {
            return;
        }
        if (isAppBarPin) {
            w wVar = this.binding;
            boolean z16 = false;
            if (wVar != null && (zootopiaDetailFloatBar4 = wVar.f399421b) != null && zootopiaDetailFloatBar4.k()) {
                z16 = true;
            }
            if (!z16 || (ahVar = this.reportHelper) == null) {
                return;
            }
            w wVar2 = this.binding;
            pv4.j jVar = null;
            ZootopiaDownloadButton btnDownload2 = (wVar2 == null || (zootopiaDetailFloatBar3 = wVar2.f399421b) == null) ? null : zootopiaDetailFloatBar3.getBtnDownload();
            w wVar3 = this.binding;
            ButtonStatus status = (wVar3 == null || (zootopiaDetailFloatBar2 = wVar3.f399421b) == null || (btnDownload = zootopiaDetailFloatBar2.getBtnDownload()) == null) ? null : btnDownload.getStatus();
            am amVar = this.vm;
            if (amVar != null && (R1 = amVar.R1()) != null && (value = R1.getValue()) != null) {
                jVar = value.getReserveItem();
            }
            ahVar.h(btnDownload2, status, jVar);
            return;
        }
        w wVar4 = this.binding;
        if (wVar4 == null || (zootopiaDetailFloatBar = wVar4.f399421b) == null) {
            return;
        }
        zootopiaDetailFloatBar.i();
    }

    @Override // xc3.b
    public void zd(xc3.a parent) {
        this.parent = parent;
    }

    private final void bi() {
        QLog.i("ZootopiaBaseFragment", 1, "DetailMainFragment -- refreshData");
        am amVar = this.vm;
        if (amVar != null) {
            amVar.b2();
        }
    }

    private final void di() {
        QLog.i("ZootopiaBaseFragment", 1, "DetailMainFragment -- requestNextPageData");
        am amVar = this.vm;
        if (amVar != null) {
            amVar.a2();
        }
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.binding = null;
        super.onDestroy();
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        am amVar = this.vm;
        simpleEventBus.dispatchEvent(new ZootopiaDetailFragmentCloseEvent(amVar != null ? amVar.T1() : 0, Ch(), false, 4, null));
    }

    @Override // com.tencent.widget.pull2refresh.LoadingMoreHelper.OnLoadMoreListener
    public void onLoadMoreComplete() {
        QLog.i("ZootopiaBaseFragment", 1, "DetailMainFragment -- onLoadMoreComplete");
    }
}
