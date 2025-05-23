package com.tencent.ecommerce.biz.shoplist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.QQECChannel;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.list.ListViewModel;
import com.tencent.ecommerce.base.list.ListViewModelLazyKt$listViewModels$1;
import com.tencent.ecommerce.base.list.ListViewModelLazyKt$listViewModels$2;
import com.tencent.ecommerce.base.list.d;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.repo.ServiceLocator;
import com.tencent.ecommerce.repo.shoplist.ECPromoteShopRequestInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 82\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010#R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R-\u00105\u001a\u0014\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\r0.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/ecommerce/biz/shoplist/ECQShopPromoteListFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "initArguments", "Landroid/view/View;", "view", "initViews", "Uh", "Vh", "Wh", "Xh", "", "getContentLayoutId", "", "getBusinessDescription", "", "Bh", "Dh", "Eh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView;", "P", "Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView;", "refreshLayout", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "stateCenterView", "Lcom/tencent/ecommerce/biz/shoplist/b;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/ecommerce/biz/shoplist/b;", "adapter", ExifInterface.LATITUDE_SOUTH, "I", WadlProxyConsts.CHANNEL, "T", "Ljava/lang/String;", "callbackId", "U", "scene", "", "V", "J", "ownerId", "Lcom/tencent/ecommerce/base/list/ListViewModel;", "Lcom/tencent/ecommerce/repo/shoplist/b;", "Lcom/tencent/ecommerce/biz/shoplist/a;", "W", "Lkotlin/Lazy;", "Th", "()Lcom/tencent/ecommerce/base/list/ListViewModel;", "listViewModel", "<init>", "()V", "X", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECQShopPromoteListFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private ECommercePullRefreshView refreshLayout;

    /* renamed from: Q, reason: from kotlin metadata */
    private ECStateCenterView stateCenterView;

    /* renamed from: R, reason: from kotlin metadata */
    private com.tencent.ecommerce.biz.shoplist.b adapter;

    /* renamed from: V, reason: from kotlin metadata */
    private long ownerId;

    /* renamed from: S, reason: from kotlin metadata */
    private int channel = QQECChannel.CHANNEL_UNKNOWN.ordinal();

    /* renamed from: T, reason: from kotlin metadata */
    private String callbackId = "";

    /* renamed from: U, reason: from kotlin metadata */
    private int scene = -1;

    /* renamed from: W, reason: from kotlin metadata */
    private final Lazy listViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ListViewModel.class), new ListViewModelLazyKt$listViewModels$1(this), new ListViewModelLazyKt$listViewModels$2(new d(ServiceLocator.f104891i.m())));

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/shoplist/ECQShopPromoteListFragment$initViews$3$1", "Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView$OnRefreshStateListener;", "", "tag", "", "onRefreshBegin", "onLoadMoreBegin", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements ECommercePullRefreshView.OnRefreshStateListener {
        b() {
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView.OnRefreshStateListener
        public void onLoadMoreBegin() {
            ECQShopPromoteListFragment.this.Wh();
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView.OnRefreshStateListener
        public void onRefreshBegin(int tag) {
            ECQShopPromoteListFragment.this.Xh();
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView.OnRefreshStateListener
        public void onRefreshFinished(boolean z16, int i3) {
            ECommercePullRefreshView.OnRefreshStateListener.a.a(this, z16, i3);
        }
    }

    public static final /* synthetic */ com.tencent.ecommerce.biz.shoplist.b Lh(ECQShopPromoteListFragment eCQShopPromoteListFragment) {
        com.tencent.ecommerce.biz.shoplist.b bVar = eCQShopPromoteListFragment.adapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return bVar;
    }

    public static final /* synthetic */ ECommercePullRefreshView Oh(ECQShopPromoteListFragment eCQShopPromoteListFragment) {
        ECommercePullRefreshView eCommercePullRefreshView = eCQShopPromoteListFragment.refreshLayout;
        if (eCommercePullRefreshView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        }
        return eCommercePullRefreshView;
    }

    public static final /* synthetic */ ECStateCenterView Ph(ECQShopPromoteListFragment eCQShopPromoteListFragment) {
        ECStateCenterView eCStateCenterView = eCQShopPromoteListFragment.stateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateCenterView");
        }
        return eCStateCenterView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ListViewModel<ECPromoteShopRequestInfo, ECPromoteShopItem, String> Th() {
        return (ListViewModel) this.listViewModel.getValue();
    }

    private final void Uh() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECQShopPromoteListFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1(this, Lifecycle.State.STARTED, null, this), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh() {
        Th().X1(new ECPromoteShopRequestInfo(this.channel, this.scene, this.ownerId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wh() {
        Th().Z1(new ECPromoteShopRequestInfo(this.channel, this.scene, this.ownerId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xh() {
        Th().a2(new ECPromoteShopRequestInfo(this.channel, this.scene, this.ownerId));
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x007d, code lost:
    
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initArguments() {
        int ordinal;
        String str;
        Intent intent;
        Long longOrNull;
        Intent intent2;
        String stringExtra;
        Intent intent3;
        Intent intent4;
        String stringExtra2;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent4 = activity.getIntent()) != null && (stringExtra2 = intent4.getStringExtra(WadlProxyConsts.CHANNEL)) != null) {
            ordinal = Integer.parseInt(stringExtra2);
        } else {
            ordinal = QQECChannel.CHANNEL_UNKNOWN.ordinal();
        }
        this.channel = ordinal;
        FragmentActivity activity2 = getActivity();
        if (activity2 == null || (intent3 = activity2.getIntent()) == null || (str = intent3.getStringExtra("scheme_callback_id")) == null) {
            str = "";
        }
        this.callbackId = str;
        FragmentActivity activity3 = getActivity();
        this.scene = (activity3 == null || (intent2 = activity3.getIntent()) == null || (stringExtra = intent2.getStringExtra("scene")) == null) ? -1 : Integer.parseInt(stringExtra);
        long currentAccount = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount();
        FragmentActivity activity4 = getActivity();
        if (activity4 != null && (intent = activity4.getIntent()) != null && (r2 = intent.getStringExtra("owner_id")) != null && longOrNull != null) {
            currentAccount = longOrNull.longValue();
        }
        this.ownerId = currentAccount;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Bh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Dh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECQShopPromoteListFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.ctb;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTitle(R.string.whc);
        initArguments();
        initViews(view);
        Uh();
        Vh();
    }

    private final void initViews(View view) {
        this.refreshLayout = (ECommercePullRefreshView) view.findViewById(R.id.o8o);
        ECStateCenterView eCStateCenterView = (ECStateCenterView) view.findViewById(R.id.oax);
        eCStateCenterView.setRetryListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.shoplist.ECQShopPromoteListFragment$initViews$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ECQShopPromoteListFragment.this.Vh();
            }
        });
        Unit unit = Unit.INSTANCE;
        this.stateCenterView = eCStateCenterView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.o8m);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        com.tencent.ecommerce.biz.shoplist.b bVar = new com.tencent.ecommerce.biz.shoplist.b(requireContext());
        bVar.l0(new Function1<String, Unit>() { // from class: com.tencent.ecommerce.biz.shoplist.ECQShopPromoteListFragment$initViews$$inlined$apply$lambda$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/shoplist/ECQShopPromoteListFragment$initViews$2$1$1", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
            /* loaded from: classes31.dex */
            public static final class a implements IECSchemeCallback {
                a() {
                }

                @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
                public void onCallbackFinished(JSONObject data) {
                    String str;
                    if (data.optInt("code") != 1) {
                        str = ECQShopPromoteListFragment.this.callbackId;
                        IECSchemeCallback b16 = ug0.a.b(str);
                        if (b16 != null) {
                            b16.onCallbackFinished(data);
                        }
                        FragmentActivity activity = ECQShopPromoteListFragment.this.getActivity();
                        if (activity != null) {
                            activity.finish();
                        }
                    }
                }
            }

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
                ECScheme.f(str, new a(), null, 4, null);
            }
        });
        this.adapter = bVar;
        recyclerView.setAdapter(bVar);
        recyclerView.addItemDecoration(new yh0.a(requireContext()));
        ECommercePullRefreshView eCommercePullRefreshView = this.refreshLayout;
        if (eCommercePullRefreshView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        }
        eCommercePullRefreshView.setHideFooterIfNoMore(true);
        eCommercePullRefreshView.setOnRefreshStateListener(new b());
    }
}
