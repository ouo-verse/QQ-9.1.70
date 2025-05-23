package com.tencent.robot.profile.parts;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.robot.profile.RobotProfileViewModel;
import com.tencent.robot.profile.event.RobotProfileFetchDataEvent;
import com.tencent.robot.profile.parts.RobotProfileOperationPart;
import com.tencent.robot.profile.section.story.section.RobotStoryProfileItemSection;
import com.tencent.robot.profile.utils.RobotProfileUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 >2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005:\u0001?B\u0017\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010/\u001a\u00020,\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u001a\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010!\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001f0\u001ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001f` H\u0016J \u0010&\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"H\u0016J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\"H\u0016R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006@"}, d2 = {"Lcom/tencent/robot/profile/parts/RobotProfileListPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$NavigationBarHeightChangeCallback;", "Lcom/tencent/robot/profile/parts/a;", "", "initData", "", "delay", "D9", "", "Lcom/tencent/robot/profile/data/g;", "profileDataList", "G9", "", "matchParent", "H9", "Landroid/view/View;", "parentView", "onInitView", "", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "", "naviHeight", "left", "right", "onChange", "height", "Lcom/tencent/robot/profile/RobotProfileViewModel;", "d", "Lcom/tencent/robot/profile/RobotProfileViewModel;", "viewModel", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "profileListView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", tl.h.F, "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "profileListAdapter", "Lcom/tencent/robot/profile/parts/d;", "i", "Lcom/tencent/robot/profile/parts/d;", "intimateAdapters", "<init>", "(Lcom/tencent/robot/profile/RobotProfileViewModel;Landroidx/lifecycle/LifecycleOwner;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotProfileListPart extends Part implements SimpleEventReceiver<SimpleBaseEvent>, RFWNavigationBarImmersiveHelper.NavigationBarHeightChangeCallback, a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotProfileViewModel viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner viewLifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView profileListView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter profileListAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d intimateAdapters;

    public RobotProfileListPart(@NotNull RobotProfileViewModel viewModel, @NotNull LifecycleOwner viewLifecycleOwner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        this.viewModel = viewModel;
        this.viewLifecycleOwner = viewLifecycleOwner;
    }

    private final void D9(long delay) {
        C11736d.b((int) delay, new Runnable() { // from class: com.tencent.robot.profile.parts.f
            @Override // java.lang.Runnable
            public final void run() {
                RobotProfileListPart.E9(RobotProfileListPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(RobotProfileListPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.viewModel.b2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9(List<? extends com.tencent.robot.profile.data.g> profileDataList) {
        com.tencent.robot.profile.data.m mVar;
        com.tencent.robot.profile.data.g gVar;
        boolean z16;
        if (profileDataList.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("robot.profile.RobotProfileListPart", 1, "needReverseEmpty return, profileDataList isEmpty");
                return;
            }
            return;
        }
        if (!RobotProfileUtils.f368193a.q()) {
            if (QLog.isColorLevel()) {
                QLog.d("robot.profile.RobotProfileListPart", 1, "needReverseEmpty return, needReverseEmptySwitch is false");
            }
            H9(true);
            return;
        }
        ListIterator<? extends com.tencent.robot.profile.data.g> listIterator = profileDataList.listIterator(profileDataList.size());
        while (true) {
            mVar = null;
            if (listIterator.hasPrevious()) {
                gVar = listIterator.previous();
                if (gVar instanceof com.tencent.robot.profile.data.m) {
                    break;
                }
            } else {
                gVar = null;
                break;
            }
        }
        com.tencent.robot.profile.data.g gVar2 = gVar;
        if (gVar2 instanceof com.tencent.robot.profile.data.m) {
            mVar = (com.tencent.robot.profile.data.m) gVar2;
        }
        if (mVar != null) {
            z16 = mVar.getNeedReverseEmpty();
        } else {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("robot.profile.RobotProfileListPart", 1, "needReverseEmpty result = " + z16);
        }
        H9(!z16);
    }

    private final void H9(final boolean matchParent) {
        ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.robot.profile.parts.g
            @Override // java.lang.Runnable
            public final void run() {
                RobotProfileListPart.I9(RobotProfileListPart.this, matchParent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(RobotProfileListPart this$0, boolean z16) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.profileListView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileListView");
            recyclerView = null;
        }
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        if (z16) {
            i3 = -1;
        } else {
            i3 = -2;
        }
        layoutParams.height = i3;
        recyclerView.setLayoutParams(layoutParams);
    }

    private final void initData() {
        LiveData<List<com.tencent.robot.profile.data.g>> n26 = this.viewModel.n2();
        LifecycleOwner lifecycleOwner = this.viewLifecycleOwner;
        final Function1<List<? extends com.tencent.robot.profile.data.g>, Unit> function1 = new Function1<List<? extends com.tencent.robot.profile.data.g>, Unit>() { // from class: com.tencent.robot.profile.parts.RobotProfileListPart$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.robot.profile.data.g> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends com.tencent.robot.profile.data.g> profileDataList) {
                d dVar;
                dVar = RobotProfileListPart.this.intimateAdapters;
                if (dVar != null) {
                    dVar.setItems(profileDataList);
                }
                RobotProfileListPart robotProfileListPart = RobotProfileListPart.this;
                Intrinsics.checkNotNullExpressionValue(profileDataList, "profileDataList");
                robotProfileListPart.G9(profileDataList);
                QLog.d("robot.profile.RobotProfileListPart", 1, "initData submitList end");
            }
        };
        n26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.robot.profile.parts.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotProfileListPart.F9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(RobotProfileFetchDataEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "robot.profile.RobotProfileListPart";
    }

    @Override // com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper.NavigationBarHeightChangeCallback
    public void onChange(int naviHeight, int left, int right) {
        if (QLog.isColorLevel()) {
            QLog.i("robot.profile.RobotProfileListPart", 2, "onChange naviHeight: " + naviHeight);
        }
        this.viewModel.N2(naviHeight);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View parentView) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        View findViewById = parentView.findViewById(R.id.f772743x);
        Intrinsics.checkNotNullExpressionValue(findViewById, "parentView.findViewById(R.id.robot_profile_list)");
        this.profileListView = (RecyclerView) findViewById;
        this.intimateAdapters = new d(new c());
        this.profileListAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.intimateAdapters});
        RecyclerView recyclerView = this.profileListView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileListView");
            recyclerView = null;
        }
        RFWConcatAdapter rFWConcatAdapter = this.profileListAdapter;
        if (rFWConcatAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileListAdapter");
            rFWConcatAdapter = null;
        }
        recyclerView.setAdapter(rFWConcatAdapter);
        RecyclerView recyclerView3 = this.profileListView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileListView");
            recyclerView3 = null;
        }
        recyclerView3.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        RecyclerView recyclerView4 = this.profileListView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileListView");
            recyclerView4 = null;
        }
        recyclerView4.setItemAnimator(null);
        RecyclerView recyclerView5 = this.profileListView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileListView");
        } else {
            recyclerView2 = recyclerView5;
        }
        recyclerView2.setOverScrollMode(2);
        initData();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        RobotStoryProfileItemSection.INSTANCE.a();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        com.tencent.mobileqq.qui.b.f276860a.n(this);
        RobotProfileOperationPart.INSTANCE.f(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        SimpleEventBus.getInstance().registerReceiver(this);
        com.tencent.mobileqq.qui.b.f276860a.k(activity, nf2.b.a(activity), this);
        RobotProfileOperationPart.Companion.e(RobotProfileOperationPart.INSTANCE, this, false, 2, null);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof RobotProfileFetchDataEvent) {
            D9(((RobotProfileFetchDataEvent) event).getDelay());
        }
    }

    @Override // com.tencent.robot.profile.parts.a
    public void onChange(int height) {
        if (QLog.isColorLevel()) {
            QLog.i("robot.profile.RobotProfileListPart", 2, "onChange height: " + height);
        }
        this.viewModel.M2(height);
    }
}
