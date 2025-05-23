package com.tencent.state.square.mayknow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.friend.observer.a;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragmentKt;
import com.tencent.state.VasBaseSubFragment;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.ISquareFriendObserver;
import com.tencent.state.square.api.ISquareFriendService;
import com.tencent.state.square.components.fragment.SquareServiceProvider;
import com.tencent.state.square.databinding.VasSquareErrorViewBinding;
import com.tencent.state.square.databinding.VasSquareFragmentMayKnowFriendBinding;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0014H\u0016J4\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00172\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u0006+"}, d2 = {"Lcom/tencent/state/square/mayknow/VasMayKnowFragment;", "Lcom/tencent/state/VasBaseSubFragment;", "Lcom/tencent/state/square/api/ISquareFriendObserver;", "()V", "adapter", "Lcom/tencent/state/square/mayknow/MayKnowGirdAdapter;", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentMayKnowFriendBinding;", "dataProvider", "Lcom/tencent/state/square/mayknow/MayKnowDataProvider;", "serviceProvider", "Lcom/tencent/state/square/components/fragment/SquareServiceProvider;", "getServiceProvider", "()Lcom/tencent/state/square/components/fragment/SquareServiceProvider;", "serviceProvider$delegate", "Lkotlin/Lazy;", "getComponents", "", "Lcom/tencent/state/FragmentComponent;", "initListReport", "", "initView", "onBackPressed", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onUpdateAddFriend", "isSuccess", "addSuccess", a.ADD_DIRECT, "requestUin", "", "bundle", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasMayKnowFragment extends VasBaseSubFragment implements ISquareFriendObserver {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DO_BACK_EVENT = "mayKnowFriendBackDetail";
    public static final int FRIEND_REQUEST_CODE_SQUARE_ADD_MAY_KNOW = 10998;
    private static final String TAG = "VasMayKnowFragment";
    private MayKnowGirdAdapter adapter;
    private VasSquareFragmentMayKnowFriendBinding binding;
    private final MayKnowDataProvider dataProvider = new MayKnowDataProvider();

    /* renamed from: serviceProvider$delegate, reason: from kotlin metadata */
    private final Lazy serviceProvider;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/square/mayknow/VasMayKnowFragment$Companion;", "", "()V", "DO_BACK_EVENT", "", "FRIEND_REQUEST_CODE_SQUARE_ADD_MAY_KNOW", "", "TAG", "newInstance", "Lcom/tencent/state/square/mayknow/VasMayKnowFragment;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final VasMayKnowFragment newInstance() {
            return new VasMayKnowFragment();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public VasMayKnowFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SquareServiceProvider>() { // from class: com.tencent.state.square.mayknow.VasMayKnowFragment$serviceProvider$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SquareServiceProvider invoke() {
                return new SquareServiceProvider(null, null, null, null, 15, null);
            }
        });
        this.serviceProvider = lazy;
    }

    private final SquareServiceProvider getServiceProvider() {
        return (SquareServiceProvider) this.serviceProvider.getValue();
    }

    private final void initListReport() {
        Map mutableMapOf;
        VasSquareFragmentMayKnowFriendBinding vasSquareFragmentMayKnowFriendBinding = this.binding;
        if (vasSquareFragmentMayKnowFriendBinding != null) {
            VideoReport.setPageId(vasSquareFragmentMayKnowFriendBinding.mayKnowList, SquareReportConst.PageId.PAGE_ID_MAY_KNOW);
            VideoReport.setPageReportPolicy(vasSquareFragmentMayKnowFriendBinding.mayKnowList, PageReportPolicy.REPORT_ALL);
            RecyclerView recyclerView = vasSquareFragmentMayKnowFriendBinding.mayKnowList;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY));
            VideoReport.setPageParams(recyclerView, new PageParams((Map<String, ?>) mutableMapOf));
        }
    }

    private final void initView() {
        VasSquareFragmentMayKnowFriendBinding vasSquareFragmentMayKnowFriendBinding = this.binding;
        if (vasSquareFragmentMayKnowFriendBinding != null) {
            this.adapter = new MayKnowGirdAdapter();
            RecyclerView recyclerView = vasSquareFragmentMayKnowFriendBinding.mayKnowList;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.mayKnowList");
            recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
            vasSquareFragmentMayKnowFriendBinding.mayKnowList.addItemDecoration(new MayKnowGridDivider());
            MayKnowGirdAdapter mayKnowGirdAdapter = this.adapter;
            if (mayKnowGirdAdapter != null) {
                RecyclerView recyclerView2 = vasSquareFragmentMayKnowFriendBinding.mayKnowList;
                Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.mayKnowList");
                recyclerView2.setAdapter(mayKnowGirdAdapter);
            }
            vasSquareFragmentMayKnowFriendBinding.getMContainer().setOnClickListener(null);
            vasSquareFragmentMayKnowFriendBinding.back.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.mayknow.VasMayKnowFragment$initView$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VasMayKnowFragment.this.onBackPressed();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.VasBaseLifecycleFragment
    public List<FragmentComponent> getComponents() {
        List<FragmentComponent> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(getServiceProvider());
        return listOf;
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.state.VasBaseFragment
    public boolean onBackPressed() {
        super.onBackPressed();
        VasBaseFragmentKt.setFragmentResult(this, DO_BACK_EVENT, new Bundle());
        popFragment(this);
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        VasSquareFragmentMayKnowFriendBinding inflate = VasSquareFragmentMayKnowFriendBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareFragmentMayKnow\u2026 binding = this\n        }");
        LinearLayout mContainer = inflate.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "VasSquareFragmentMayKnow\u2026ing = this\n        }.root");
        return mContainer;
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ISquareFriendService friendService = getServiceProvider().getFriendService();
        if (friendService != null) {
            friendService.removeObserver(this);
        }
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.state.square.api.ISquareFriendObserver
    public void onUpdateAddFriend(boolean isSuccess, boolean addSuccess, boolean addDirect, final String requestUin, Bundle bundle) {
        boolean isBlank;
        SquareBaseKt.getSquareLog().d(TAG, "onUpdateAddFriend:[" + requestUin + "] isSuccess:" + isSuccess + ", addSuccess:" + addSuccess + ", addDirect:" + addDirect);
        if (!isSuccess || requestUin == null) {
            return;
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(requestUin);
        if (!isBlank) {
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.mayknow.VasMayKnowFragment$onUpdateAddFriend$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    MayKnowGirdAdapter mayKnowGirdAdapter;
                    mayKnowGirdAdapter = VasMayKnowFragment.this.adapter;
                    if (mayKnowGirdAdapter != null) {
                        mayKnowGirdAdapter.updateAddFriendStatus(requestUin);
                    }
                }
            });
        }
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListReport();
        this.dataProvider.getMayKnowUserList(new ResultCallback<MayKnowListInfo>() { // from class: com.tencent.state.square.mayknow.VasMayKnowFragment$onViewCreated$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
                VasSquareFragmentMayKnowFriendBinding vasSquareFragmentMayKnowFriendBinding;
                VasSquareErrorViewBinding vasSquareErrorViewBinding;
                RelativeLayout mContainer;
                vasSquareFragmentMayKnowFriendBinding = VasMayKnowFragment.this.binding;
                if (vasSquareFragmentMayKnowFriendBinding == null || (vasSquareErrorViewBinding = vasSquareFragmentMayKnowFriendBinding.requestErrorBackground) == null || (mContainer = vasSquareErrorViewBinding.getMContainer()) == null) {
                    return;
                }
                mContainer.setVisibility(0);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(MayKnowListInfo result) {
                VasSquareFragmentMayKnowFriendBinding vasSquareFragmentMayKnowFriendBinding;
                MayKnowGirdAdapter mayKnowGirdAdapter;
                VasSquareErrorViewBinding vasSquareErrorViewBinding;
                RelativeLayout mContainer;
                Intrinsics.checkNotNullParameter(result, "result");
                vasSquareFragmentMayKnowFriendBinding = VasMayKnowFragment.this.binding;
                if (vasSquareFragmentMayKnowFriendBinding != null && (vasSquareErrorViewBinding = vasSquareFragmentMayKnowFriendBinding.requestErrorBackground) != null && (mContainer = vasSquareErrorViewBinding.getMContainer()) != null) {
                    mContainer.setVisibility(8);
                }
                mayKnowGirdAdapter = VasMayKnowFragment.this.adapter;
                if (mayKnowGirdAdapter != null) {
                    mayKnowGirdAdapter.setData(result.getList());
                }
            }
        });
        ISquareFriendService friendService = getServiceProvider().getFriendService();
        if (friendService != null) {
            friendService.addObserver(this);
        }
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
