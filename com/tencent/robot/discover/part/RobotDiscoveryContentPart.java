package com.tencent.robot.discover.part;

import a54.a;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RobotBase;
import com.tencent.robot.discover.viewmodel.RobotDiscoveryListViewModel;
import com.tencent.robot.relation.api.IRobotRelationService;
import com.tencent.util.LoadingUtil;
import com.tencent.util.LongSparseArray;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\t*\u0001F\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0001MB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u001c\u0010\u0017\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001e\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dH\u0016J\u0018\u0010\"\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00132\u0006\u0010!\u001a\u00020 H\u0016R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\"\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001d0=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001b0=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010?R\u0016\u0010E\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010H\u00a8\u0006N"}, d2 = {"Lcom/tencent/robot/discover/part/RobotDiscoveryContentPart;", "Lcom/tencent/biz/richframework/part/Part;", "Ll34/c;", "", "E9", "initViewModel", "", "robotUin", "G9", "Ll34/a;", "D9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "handleBroadcastMessage", "onPartResume", "onPartPause", "onPartDestroy", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotBase;", IRobotUtilApi.MMKV_SCENE_ID, "Lkotlin/Function0;", "callback", "i1", "", "redDot", "B2", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerview", "Li34/b;", "e", "Li34/b;", "mAdapter", "Lcom/tencent/robot/discover/viewmodel/RobotDiscoveryListViewModel;", "f", "Lcom/tencent/robot/discover/viewmodel/RobotDiscoveryListViewModel;", "mViewModel", "Landroid/app/Dialog;", tl.h.F, "Landroid/app/Dialog;", "mLoadingDialog", "i", "Ljava/lang/String;", "mTroopUin", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mSceneId", BdhLogUtil.LogTag.Tag_Conn, "Ll34/a;", "mAddRobotListener", "Lcom/tencent/util/LongSparseArray;", "D", "Lcom/tencent/util/LongSparseArray;", "mAddRobotCallBack", "E", "mAddRobotCurrentData", UserInfo.SEX_FEMALE, "Z", "mOnPause", "com/tencent/robot/discover/part/RobotDiscoveryContentPart$b", "G", "Lcom/tencent/robot/discover/part/RobotDiscoveryContentPart$b;", "mRobotObserver", "<init>", "()V", "H", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotDiscoveryContentPart extends Part implements l34.c {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private l34.a mAddRobotListener;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mOnPause;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mRecyclerview;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private i34.b mAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RobotDiscoveryListViewModel mViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog mLoadingDialog;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mSceneId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mTroopUin = "";

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private LongSparseArray<Function0<Unit>> mAddRobotCallBack = new LongSparseArray<>();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LongSparseArray<RobotBase> mAddRobotCurrentData = new LongSparseArray<>();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final b mRobotObserver = new b();

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/robot/discover/part/RobotDiscoveryContentPart$b", "La54/a;", "", "robotUin", "troopUin", "", WadlProxyConsts.EXTRA_DATA, "", "d", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements a54.a {
        b() {
        }

        @Override // a54.a
        public void a(@NotNull String str) {
            a.C0013a.e(this, str);
        }

        @Override // a54.a
        public void b(@NotNull String str) {
            a.C0013a.d(this, str);
        }

        @Override // a54.a
        public void c(@NotNull String str) {
            a.C0013a.a(this, str);
        }

        @Override // a54.a
        public void d(@NotNull String robotUin, @NotNull String troopUin, @Nullable Object extraData) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            a.C0013a.c(this, robotUin, troopUin, extraData);
            if (Intrinsics.areEqual(troopUin, RobotDiscoveryContentPart.this.mTroopUin) && !RobotDiscoveryContentPart.this.mOnPause) {
                QLog.d(RobotDiscoveryContentPart.this.getTAG(), 2, "onAddRobotToGroupSucc " + robotUin + " " + troopUin);
                RobotDiscoveryContentPart.this.G9(Util.toLongOrDefault(robotUin, 0L));
            }
        }

        @Override // a54.a
        public void e(@NotNull String str, @NotNull String str2, @Nullable Object obj) {
            a.C0013a.b(this, str, str2, obj);
        }

        @Override // a54.a
        public void f(@NotNull String str, @NotNull String str2) {
            a.C0013a.f(this, str, str2);
        }
    }

    private final l34.a D9() {
        if (this.mAddRobotListener == null) {
            View rootView = getPartRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            this.mAddRobotListener = l34.e.b(rootView);
        }
        return this.mAddRobotListener;
    }

    private final void E9() {
        i34.b bVar = new i34.b();
        bVar.setHasStableIds(true);
        this.mAdapter = bVar;
        RecyclerView recyclerView = this.mRecyclerview;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerview");
            recyclerView = null;
        }
        recyclerView.setAdapter(new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.mAdapter}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(RobotDiscoveryContentPart this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Dialog dialog = this$0.mLoadingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        i34.b bVar = this$0.mAdapter;
        if (bVar != null) {
            bVar.setItems(new ArrayList(list));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9(final long robotUin) {
        Activity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.robot.discover.part.l
                @Override // java.lang.Runnable
                public final void run() {
                    RobotDiscoveryContentPart.H9(RobotDiscoveryContentPart.this, robotUin);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(RobotDiscoveryContentPart this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RobotBase robotBase = this$0.mAddRobotCurrentData.get(j3);
        if (robotBase != null) {
            l34.a D9 = this$0.D9();
            if (D9 != null) {
                D9.o(robotBase);
            }
            this$0.mAddRobotCallBack.get(j3, new Function0<Unit>() { // from class: com.tencent.robot.discover.part.RobotDiscoveryContentPart$setAddRobotResult$1$1$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }).invoke();
        }
        this$0.mAddRobotCurrentData.remove(j3);
        this$0.mAddRobotCallBack.remove(j3);
    }

    private final void initViewModel() {
        MutableLiveData<List<k34.a>> T1;
        RobotDiscoveryListViewModel robotDiscoveryListViewModel = (RobotDiscoveryListViewModel) getViewModel(RobotDiscoveryListViewModel.class);
        this.mViewModel = robotDiscoveryListViewModel;
        if (this.mSceneId == 1 && robotDiscoveryListViewModel != null) {
            robotDiscoveryListViewModel.W1(false);
        }
        RobotDiscoveryListViewModel robotDiscoveryListViewModel2 = this.mViewModel;
        if (robotDiscoveryListViewModel2 != null) {
            String str = this.mTroopUin;
            int i3 = this.mSceneId;
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
            robotDiscoveryListViewModel2.S1(str, i3, lifecycleOwner);
        }
        RobotDiscoveryListViewModel robotDiscoveryListViewModel3 = this.mViewModel;
        if (robotDiscoveryListViewModel3 != null && (T1 = robotDiscoveryListViewModel3.T1()) != null) {
            T1.observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.robot.discover.part.k
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RobotDiscoveryContentPart.F9(RobotDiscoveryContentPart.this, (List) obj);
                }
            });
        }
    }

    @Override // l34.c
    public void B2(@NotNull String robotUin, boolean redDot) {
        l34.a D9;
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        if (redDot && (D9 = D9()) != null) {
            D9.c(this.mTroopUin, robotUin);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        RecyclerView recyclerView;
        if (!Intrinsics.areEqual(action, "list_scroll_to_top") || (recyclerView = this.mRecyclerview) == null) {
            return;
        }
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerview");
            recyclerView = null;
        }
        recyclerView.scrollToPosition(0);
    }

    @Override // l34.c
    public void i1(@NotNull RobotBase robot, @NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(robot, "robot");
        Intrinsics.checkNotNullParameter(callback, "callback");
        long j3 = robot.robotUin;
        this.mAddRobotCallBack.append(j3, callback);
        this.mAddRobotCurrentData.append(j3, robot);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.f765441y);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026t_discovery_recyclerview)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.mRecyclerview = recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerview");
            recyclerView = null;
        }
        recyclerView.setItemAnimator(null);
        RecyclerView recyclerView3 = this.mRecyclerview;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerview");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        E9();
        initViewModel();
        Dialog dialog = this.mLoadingDialog;
        if (dialog != null) {
            dialog.show();
        }
        l34.e.f(rootView, this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(activity, "activity");
        String stringExtra = activity.getIntent().getStringExtra("troop_uin");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mTroopUin = stringExtra;
        this.mSceneId = activity.getIntent().getIntExtra("scene_id", 0);
        this.mLoadingDialog = LoadingUtil.showLoadingDialogTipsRight(getContext(), false, true);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
        } else {
            iRuntimeService = null;
        }
        IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
        if (iRobotRelationService != null) {
            iRobotRelationService.addRelationObserver(this.mRobotObserver);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IRuntimeService iRuntimeService;
        super.onPartDestroy(activity);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
        } else {
            iRuntimeService = null;
        }
        IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
        if (iRobotRelationService != null) {
            iRobotRelationService.removeRelationObserver(this.mRobotObserver);
        }
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        l34.e.g(rootView, l34.c.class);
        View rootView2 = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView2, "rootView");
        l34.e.g(rootView2, l34.a.class);
        View rootView3 = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView3, "rootView");
        l34.e.g(rootView3, l34.b.class);
        this.mAddRobotCallBack.clear();
        this.mAddRobotCurrentData.clear();
        this.mAddRobotListener = null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        this.mOnPause = true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        int i3;
        super.onPartResume(activity);
        if (this.mOnPause && (i3 = this.mSceneId) == 0) {
            RobotDiscoveryListViewModel robotDiscoveryListViewModel = this.mViewModel;
            if (robotDiscoveryListViewModel != null) {
                String str = this.mTroopUin;
                LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
                robotDiscoveryListViewModel.S1(str, i3, lifecycleOwner);
            }
            QLog.d(getTAG(), 2, "[fetchRobotDiscoverList] reLoading...");
        }
        this.mOnPause = false;
    }
}
