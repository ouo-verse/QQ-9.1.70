package com.tencent.robot.profile.addtotroop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.robot.profile.utils.RobotProfileUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u64.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001 \u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J&\u0010\u000e\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/robot/profile/addtotroop/RobotAddToTroopFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "initView", "initData", "xh", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/robot/profile/addtotroop/RobotAddToTroopViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/robot/profile/addtotroop/RobotAddToTroopViewModel;", "viewModel", "Landroidx/recyclerview/widget/RecyclerView;", "D", "Landroidx/recyclerview/widget/RecyclerView;", "addToTroopListView", "Landroid/widget/FrameLayout;", "E", "Landroid/widget/FrameLayout;", "emptyView", "Lcom/tencent/robot/profile/addtotroop/AddToTroopAdapter;", UserInfo.SEX_FEMALE, "Lcom/tencent/robot/profile/addtotroop/AddToTroopAdapter;", "addToTroopListAdapter", "com/tencent/robot/profile/addtotroop/RobotAddToTroopFragment$c", "G", "Lcom/tencent/robot/profile/addtotroop/RobotAddToTroopFragment$c;", "scrollListener", "<init>", "()V", "H", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotAddToTroopFragment extends QIphoneTitleBarFragment {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private RobotAddToTroopViewModel viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private RecyclerView addToTroopListView;

    /* renamed from: E, reason: from kotlin metadata */
    private FrameLayout emptyView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final AddToTroopAdapter addToTroopListAdapter = new AddToTroopAdapter();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final c scrollListener = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007R\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/profile/addtotroop/RobotAddToTroopFragment$a;", "", "Landroid/content/Context;", "context", "", "robotUin", "troopUin", "Landroid/os/Bundle;", "reportData", "", "a", "", "PRE_LOAD_BUF", "I", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.profile.addtotroop.RobotAddToTroopFragment$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String robotUin, @NotNull String troopUin, @Nullable Bundle reportData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intent intent = new Intent();
            intent.putExtra("uin", robotUin);
            intent.putExtra("troop_uin", troopUin);
            intent.putExtra(AppConstants.Key.EXTRA_TYPE, reportData);
            QPublicFragmentActivity.start(context, intent, RobotAddToTroopFragment.class);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/robot/profile/addtotroop/RobotAddToTroopFragment$b", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f367856a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f367857b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f367858c;

        public b(ViewModelStoreOwner viewModelStoreOwner, String str, String str2) {
            this.f367856a = viewModelStoreOwner;
            this.f367857b = str;
            this.f367858c = str2;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return new RobotAddToTroopViewModel(this.f367857b, this.f367858c);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/robot/profile/addtotroop/RobotAddToTroopFragment$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            int i3;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            RobotAddToTroopViewModel robotAddToTroopViewModel = RobotAddToTroopFragment.this.viewModel;
            RobotAddToTroopViewModel robotAddToTroopViewModel2 = null;
            if (robotAddToTroopViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                robotAddToTroopViewModel = null;
            }
            if (!robotAddToTroopViewModel.getIsEnd() && newState == 0) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (!(layoutManager instanceof LinearLayoutManager)) {
                    return;
                }
                int findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    i3 = adapter.getNUM_BACKGOURND_ICON();
                } else {
                    i3 = 0;
                }
                if (i3 - findLastVisibleItemPosition < 5) {
                    RobotAddToTroopViewModel robotAddToTroopViewModel3 = RobotAddToTroopFragment.this.viewModel;
                    if (robotAddToTroopViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        robotAddToTroopViewModel2 = robotAddToTroopViewModel3;
                    }
                    robotAddToTroopViewModel2.T1();
                }
            }
        }
    }

    private final void initData() {
        String str;
        String string;
        Bundle arguments = getArguments();
        String str2 = "0";
        if (arguments == null || (str = arguments.getString("uin")) == null) {
            str = "0";
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (string = arguments2.getString("troop_uin")) != null) {
            str2 = string;
        }
        QLog.i("RobotAddToTroopFragment", 2, "robotUin=" + str + " troopUin=" + str2);
        i iVar = i.f438514a;
        ViewModel viewModel = new ViewModelProvider(this, new b(this, str, str2)).get(RobotAddToTroopViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelStoreOwner.genV\u2026        })[T::class.java]");
        RobotAddToTroopViewModel robotAddToTroopViewModel = (RobotAddToTroopViewModel) viewModel;
        this.viewModel = robotAddToTroopViewModel;
        Bundle bundle = null;
        if (robotAddToTroopViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            robotAddToTroopViewModel = null;
        }
        LiveData<List<com.tencent.robot.profile.data.a>> Z1 = robotAddToTroopViewModel.Z1();
        final Function1<List<? extends com.tencent.robot.profile.data.a>, Unit> function1 = new Function1<List<? extends com.tencent.robot.profile.data.a>, Unit>() { // from class: com.tencent.robot.profile.addtotroop.RobotAddToTroopFragment$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.robot.profile.data.a> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends com.tencent.robot.profile.data.a> dataList) {
                FrameLayout frameLayout;
                RecyclerView recyclerView;
                AddToTroopAdapter addToTroopAdapter;
                frameLayout = RobotAddToTroopFragment.this.emptyView;
                RecyclerView recyclerView2 = null;
                if (frameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("emptyView");
                    frameLayout = null;
                }
                Boolean valueOf = Boolean.valueOf(dataList.isEmpty());
                frameLayout.setVisibility(0);
                if (((View) au.a(valueOf, frameLayout)) == null) {
                    frameLayout.setVisibility(8);
                }
                recyclerView = RobotAddToTroopFragment.this.addToTroopListView;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addToTroopListView");
                } else {
                    recyclerView2 = recyclerView;
                }
                Intrinsics.checkNotNullExpressionValue(dataList, "dataList");
                Boolean valueOf2 = Boolean.valueOf(!dataList.isEmpty());
                recyclerView2.setVisibility(0);
                if (((View) au.a(valueOf2, recyclerView2)) == null) {
                    recyclerView2.setVisibility(8);
                }
                addToTroopAdapter = RobotAddToTroopFragment.this.addToTroopListAdapter;
                addToTroopAdapter.submitList(dataList);
            }
        };
        Z1.observe(this, new Observer() { // from class: com.tencent.robot.profile.addtotroop.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotAddToTroopFragment.vh(Function1.this, obj);
            }
        });
        RobotAddToTroopViewModel robotAddToTroopViewModel2 = this.viewModel;
        if (robotAddToTroopViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            robotAddToTroopViewModel2 = null;
        }
        robotAddToTroopViewModel2.W1();
        AddToTroopAdapter addToTroopAdapter = this.addToTroopListAdapter;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            bundle = arguments3.getBundle(AppConstants.Key.EXTRA_TYPE);
        }
        addToTroopAdapter.k0(bundle);
    }

    private final void initView() {
        setTitle(getString(R.string.f170077yl0));
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.sdr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI\u2026add_to_troop_detail_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.addToTroopListView = recyclerView;
        FrameLayout frameLayout = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToTroopListView");
            recyclerView = null;
        }
        recyclerView.setAdapter(this.addToTroopListAdapter);
        RecyclerView recyclerView2 = this.addToTroopListView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToTroopListView");
            recyclerView2 = null;
        }
        recyclerView2.setItemAnimator(null);
        RecyclerView recyclerView3 = this.addToTroopListView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToTroopListView");
            recyclerView3 = null;
        }
        recyclerView3.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        RecyclerView recyclerView4 = this.addToTroopListView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToTroopListView");
            recyclerView4 = null;
        }
        recyclerView4.addOnScrollListener(this.scrollListener);
        View findViewById2 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.bww);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewById(R.id.empty_view)");
        FrameLayout frameLayout2 = (FrameLayout) findViewById2;
        this.emptyView = frameLayout2;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyView");
            frameLayout2 = null;
        }
        QUIEmptyState build = new QUIEmptyState.Builder(frameLayout2.getContext()).setThemeType(0).setBackgroundColorType(0).setImageType(8).setTitle("\u6682\u65e0\u53ef\u6dfb\u52a0\u7684\u7fa4").setDesc("\u53ef\u4ee5@\u7fa4\u7ba1\u7406\u5458\u6dfb\u52a0\u673a\u5668\u4eba").setButton("\u5206\u4eab\u673a\u5668\u4eba", new View.OnClickListener() { // from class: com.tencent.robot.profile.addtotroop.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RobotAddToTroopFragment.wh(RobotAddToTroopFragment.this, view);
            }
        }).build();
        FrameLayout frameLayout3 = this.emptyView;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyView");
        } else {
            frameLayout = frameLayout3;
        }
        frameLayout.addView(build);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(RobotAddToTroopFragment this$0, View view) {
        Context it;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!u64.g.f438512a.g() && (it = this$0.getContext()) != null) {
            RobotProfileUtils robotProfileUtils = RobotProfileUtils.f368193a;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            RobotAddToTroopViewModel robotAddToTroopViewModel = this$0.viewModel;
            if (robotAddToTroopViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                robotAddToTroopViewModel = null;
            }
            robotProfileUtils.y(it, robotAddToTroopViewModel.getRobotUin());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void xh() {
        Map emptyMap;
        VideoReport.setPageId(((QIphoneTitleBarFragment) this).mContentView, "pg_bas_add_group_chat");
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        emptyMap = MapsKt__MapsKt.emptyMap();
        VideoReport.reportEvent("dt_pgin", view, emptyMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        initView();
        initData();
        xh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.hob;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Map emptyMap;
        super.onDestroy();
        this.addToTroopListAdapter.destroy();
        RecyclerView recyclerView = this.addToTroopListView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addToTroopListView");
            recyclerView = null;
        }
        recyclerView.removeOnScrollListener(this.scrollListener);
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        emptyMap = MapsKt__MapsKt.emptyMap();
        VideoReport.reportEvent("dt_pgout", view, emptyMap);
    }
}
