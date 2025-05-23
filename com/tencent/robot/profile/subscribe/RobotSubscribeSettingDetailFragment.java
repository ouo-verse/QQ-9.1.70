package com.tencent.robot.profile.subscribe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.kernel.nativeinterface.SubscribeMsgTemplateID;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u64.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\f\u001a\u00020\u00042\u001a\u0010\u000b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\b\u0012\u00060\bj\u0002`\t0\u0007j\u0002`\n0\u0006H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\u001a\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/robot/profile/subscribe/RobotSubscribeSettingDetailFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "", "uh", "", "Lcom/tencent/robot/profile/subscribe/e;", "Lcom/tencent/qqnt/kernel/nativeinterface/SubscribeMsgTemplateID;", "Lcom/tencent/robot/profile/subscribe/TemplateID;", "Lcom/tencent/robot/profile/subscribe/RobotSwitchTagSingleLineConfig1;", "configList", "xh", "wh", "", "useQUISecNavBar", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "mTroopUin", "D", "mRobotUin", "Lcom/tencent/robot/profile/subscribe/RobotSubscribeSettingViewModel;", "E", "Lcom/tencent/robot/profile/subscribe/RobotSubscribeSettingViewModel;", "mViewModel", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotSubscribeSettingDetailFragment extends QIphoneTitleBarFragment {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String mTroopUin = "";

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String mRobotUin = "";

    /* renamed from: E, reason: from kotlin metadata */
    private RobotSubscribeSettingViewModel mViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/profile/subscribe/RobotSubscribeSettingDetailFragment$a;", "", "Landroid/content/Context;", "context", "", "troopUin", "robotUin", "", "userMemberShip", "", "a", "USER_MEMBERSHIP", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.profile.subscribe.RobotSubscribeSettingDetailFragment$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @Nullable String troopUin, @NotNull String robotUin, int userMemberShip) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intent intent = new Intent();
            intent.putExtra("uin", robotUin);
            intent.putExtra("troop_uin", troopUin);
            intent.putExtra("user_membership", userMemberShip);
            QPublicFragmentActivity.start(context, intent, RobotSubscribeSettingDetailFragment.class);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/robot/profile/subscribe/RobotSubscribeSettingDetailFragment$b", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f368179a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RobotSubscribeSettingDetailFragment f368180b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f368181c;

        public b(ViewModelStoreOwner viewModelStoreOwner, RobotSubscribeSettingDetailFragment robotSubscribeSettingDetailFragment, int i3) {
            this.f368179a = viewModelStoreOwner;
            this.f368180b = robotSubscribeSettingDetailFragment;
            this.f368181c = i3;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            RobotSubscribeSettingDetailFragment robotSubscribeSettingDetailFragment = this.f368180b;
            return new RobotSubscribeSettingViewModel(robotSubscribeSettingDetailFragment, this.f368181c, robotSubscribeSettingDetailFragment.mTroopUin, this.f368180b.mRobotUin);
        }
    }

    private final void uh(final QUIListItemAdapter adapter) {
        RobotSubscribeSettingViewModel robotSubscribeSettingViewModel = this.mViewModel;
        RobotSubscribeSettingViewModel robotSubscribeSettingViewModel2 = null;
        if (robotSubscribeSettingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            robotSubscribeSettingViewModel = null;
        }
        robotSubscribeSettingViewModel.c2(new Function1<e<SubscribeMsgTemplateID>, Unit>() { // from class: com.tencent.robot.profile.subscribe.RobotSubscribeSettingDetailFragment$bindViewAndData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e<SubscribeMsgTemplateID> eVar) {
                invoke2(eVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull e<SubscribeMsgTemplateID> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                QUIListItemAdapter.this.l0(it);
            }
        });
        RobotSubscribeSettingViewModel robotSubscribeSettingViewModel3 = this.mViewModel;
        if (robotSubscribeSettingViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        } else {
            robotSubscribeSettingViewModel2 = robotSubscribeSettingViewModel3;
        }
        LiveData<List<e<SubscribeMsgTemplateID>>> S1 = robotSubscribeSettingViewModel2.S1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<e<SubscribeMsgTemplateID>>, Unit> function1 = new Function1<List<e<SubscribeMsgTemplateID>>, Unit>() { // from class: com.tencent.robot.profile.subscribe.RobotSubscribeSettingDetailFragment$bindViewAndData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<e<SubscribeMsgTemplateID>> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<e<SubscribeMsgTemplateID>> configList) {
                RobotSubscribeSettingDetailFragment robotSubscribeSettingDetailFragment = RobotSubscribeSettingDetailFragment.this;
                Intrinsics.checkNotNullExpressionValue(configList, "configList");
                robotSubscribeSettingDetailFragment.xh(configList);
                QUIListItemAdapter qUIListItemAdapter = adapter;
                Object[] array = configList.toArray(new e[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                e[] eVarArr = (e[]) array;
                qUIListItemAdapter.t0(new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(eVarArr, eVarArr.length)));
            }
        };
        S1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.robot.profile.subscribe.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotSubscribeSettingDetailFragment.vh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void wh() {
        String str;
        int i3;
        Bundle arguments = getArguments();
        String str2 = null;
        if (arguments != null) {
            str = arguments.getString("troop_uin");
        } else {
            str = null;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str2 = arguments2.getString("uin");
        }
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            i3 = arguments3.getInt("user_membership");
        } else {
            i3 = -1;
        }
        if (!Intrinsics.areEqual(this.mTroopUin, str) || !Intrinsics.areEqual(this.mRobotUin, str2)) {
            if (str == null) {
                str = "";
            }
            this.mTroopUin = str;
            if (str2 == null) {
                str2 = "";
            }
            this.mRobotUin = str2;
            i iVar = i.f438514a;
            ViewModel viewModel = new ViewModelProvider(this, new b(this, this, i3)).get(RobotSubscribeSettingViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelStoreOwner.genV\u2026        })[T::class.java]");
            this.mViewModel = (RobotSubscribeSettingViewModel) viewModel;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xh(List<e<SubscribeMsgTemplateID>> configList) {
        for (final e<SubscribeMsgTemplateID> eVar : configList) {
            x.c O = eVar.O();
            if (O instanceof x.c.f) {
                ((x.c.f) O).h(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.robot.profile.subscribe.b
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                        RobotSubscribeSettingDetailFragment.yh(e.this, this, compoundButton, z16);
                    }
                });
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(e config, RobotSubscribeSettingDetailFragment this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(config, "$config");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SubscribeMsgTemplateID subscribeMsgTemplateID = (SubscribeMsgTemplateID) config.V();
        if (subscribeMsgTemplateID != null) {
            RobotSubscribeSettingViewModel robotSubscribeSettingViewModel = this$0.mViewModel;
            if (robotSubscribeSettingViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                robotSubscribeSettingViewModel = null;
            }
            robotSubscribeSettingViewModel.W1(config, z16, subscribeMsgTemplateID);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.hox;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        RobotSubscribeSettingViewModel robotSubscribeSettingViewModel = this.mViewModel;
        if (robotSubscribeSettingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            robotSubscribeSettingViewModel = null;
        }
        robotSubscribeSettingViewModel.c2(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTitle(getString(R.string.f222426dh));
        wh();
        if (this.mViewModel == null) {
            return;
        }
        QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.i4m);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(QUIListItemStyle.Card, false, false, 6, null);
        qUISettingsRecyclerView.setAdapter(qUIListItemAdapter);
        uh(qUIListItemAdapter);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        return true;
    }
}
