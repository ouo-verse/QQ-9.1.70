package com.tencent.robot.profile.adapterdelegates;

import a54.a;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.profile.data.RobotProfileMyServiceData;
import com.tencent.robot.profile.utils.RobotProfileUtils;
import com.tencent.robot.relation.api.IRobotRelationService;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0019\u001aB\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0014J&\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0014J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0013H\u0014J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0013H\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/robot/profile/adapterdelegates/RobotMyServiceCardDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/robot/profile/data/k$b;", "Lcom/tencent/robot/profile/adapterdelegates/RobotMyServiceCardDelegate$MyServiceCardViewHolder;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "holder", "", "payloads", "", "p", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "g", tl.h.F, "<init>", "()V", "d", "a", "MyServiceCardViewHolder", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotMyServiceCardDelegate extends AbsListItemAdapterDelegate<RobotProfileMyServiceData.RobotService, RobotProfileMyServiceData.RobotService, MyServiceCardViewHolder> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\b*\u0003\u001c $\u0018\u00002\u00020\u0001:\u0001*B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b(\u0010)J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\fH\u0002J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\bR\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/robot/profile/adapterdelegates/RobotMyServiceCardDelegate$MyServiceCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "allowAddC2C", "allowAddGroup", "isFromTroop", "", "u", "", "v", "Lhn2/n;", "binding", "Lcom/tencent/robot/profile/data/k$b;", "robotService", "r", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/robot/profile/adapterdelegates/RobotMyServiceCardDelegate$MyServiceCardViewHolder$SettingState;", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "onViewAttachedToWindow", "onViewDetachedFromWindow", "E", "Lhn2/n;", ReportConstant.COSTREPORT_PREFIX, "()Lhn2/n;", UserInfo.SEX_FEMALE, "Lcom/tencent/robot/profile/data/k$b;", "data", "com/tencent/robot/profile/adapterdelegates/RobotMyServiceCardDelegate$MyServiceCardViewHolder$b", "G", "Lcom/tencent/robot/profile/adapterdelegates/RobotMyServiceCardDelegate$MyServiceCardViewHolder$b;", "clickListener", "com/tencent/robot/profile/adapterdelegates/RobotMyServiceCardDelegate$MyServiceCardViewHolder$d", "H", "Lcom/tencent/robot/profile/adapterdelegates/RobotMyServiceCardDelegate$MyServiceCardViewHolder$d;", "relationObserver", "com/tencent/robot/profile/adapterdelegates/RobotMyServiceCardDelegate$MyServiceCardViewHolder$c", "I", "Lcom/tencent/robot/profile/adapterdelegates/RobotMyServiceCardDelegate$MyServiceCardViewHolder$c;", "lifecycleListener", "<init>", "(Lhn2/n;)V", "SettingState", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class MyServiceCardViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final hn2.n binding;

        /* renamed from: F, reason: from kotlin metadata */
        @Nullable
        private RobotProfileMyServiceData.RobotService data;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final b clickListener;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final d relationObserver;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final c lifecycleListener;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/profile/adapterdelegates/RobotMyServiceCardDelegate$MyServiceCardViewHolder$SettingState;", "", "(Ljava/lang/String;I)V", "SETTING_STATE_NONE", "SETTING_STATE_GUEST", "SETTING_STATE_TROOP_MEMBER", "SETTING_STATE_ADMIN_CAN_SET", "SETTING_STATE_CAN_USE", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes25.dex */
        public enum SettingState {
            SETTING_STATE_NONE,
            SETTING_STATE_GUEST,
            SETTING_STATE_TROOP_MEMBER,
            SETTING_STATE_ADMIN_CAN_SET,
            SETTING_STATE_CAN_USE
        }

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes25.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f367834a;

            static {
                int[] iArr = new int[SettingState.values().length];
                try {
                    iArr[SettingState.SETTING_STATE_NONE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SettingState.SETTING_STATE_GUEST.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SettingState.SETTING_STATE_TROOP_MEMBER.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[SettingState.SETTING_STATE_ADMIN_CAN_SET.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[SettingState.SETTING_STATE_CAN_USE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                f367834a = iArr;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/profile/adapterdelegates/RobotMyServiceCardDelegate$MyServiceCardViewHolder$b", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes25.dex */
        public static final class b implements View.OnClickListener {

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes25.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f367836a;

                static {
                    int[] iArr = new int[SettingState.values().length];
                    try {
                        iArr[SettingState.SETTING_STATE_CAN_USE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[SettingState.SETTING_STATE_ADMIN_CAN_SET.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[SettingState.SETTING_STATE_GUEST.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[SettingState.SETTING_STATE_TROOP_MEMBER.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[SettingState.SETTING_STATE_NONE.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    f367836a = iArr;
                }
            }

            b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(@Nullable View v3) {
                String str;
                boolean z16;
                EventCollector.getInstance().onViewClickedBefore(v3);
                RobotProfileMyServiceData.RobotService robotService = MyServiceCardViewHolder.this.data;
                if (robotService != null) {
                    MyServiceCardViewHolder myServiceCardViewHolder = MyServiceCardViewHolder.this;
                    int i3 = a.f367836a[myServiceCardViewHolder.t(robotService).ordinal()];
                    if (i3 != 1 && i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                if (i3 != 5) {
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else {
                                QQToast.makeText(myServiceCardViewHolder.getBinding().getRoot().getContext(), R.string.f222516dq, 0).show();
                            }
                        } else {
                            Context context = myServiceCardViewHolder.getBinding().getRoot().getContext();
                            boolean allowAddC2C = robotService.getAllowAddC2C();
                            boolean allowAddGroup = robotService.getAllowAddGroup();
                            RobotProfileMyServiceData.RobotService robotService2 = myServiceCardViewHolder.data;
                            if (robotService2 != null) {
                                z16 = robotService2.getIsFromTroop();
                            } else {
                                z16 = false;
                            }
                            QQToast.makeText(context, myServiceCardViewHolder.u(allowAddC2C, allowAddGroup, z16), 0).show();
                        }
                    } else {
                        j44.c cVar = (j44.c) RFWIocAbilityProvider.g().getIocInterface(j44.c.class, RobotProfileUtils.f368193a.j(v3), null);
                        if (cVar != null) {
                            cVar.a();
                        }
                        Context context2 = myServiceCardViewHolder.getBinding().getRoot().getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "binding.root.context");
                        RobotProfileMyServiceData.RobotService robotService3 = myServiceCardViewHolder.data;
                        if (robotService3 == null || (str = robotService3.getSettingUrl()) == null) {
                            str = "";
                        }
                        RobotProfileUtils.t(context2, str);
                    }
                }
                EventCollector.getInstance().onViewClicked(v3);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/robot/profile/adapterdelegates/RobotMyServiceCardDelegate$MyServiceCardViewHolder$c", "Lj44/b;", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes25.dex */
        public static final class c implements j44.b {
            c() {
            }

            @Override // j44.b
            public void onDestroy() {
                IRuntimeService iRuntimeService;
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
                } else {
                    iRuntimeService = null;
                }
                IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
                if (iRobotRelationService != null) {
                    iRobotRelationService.removeRelationObserver(MyServiceCardViewHolder.this.relationObserver);
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/robot/profile/adapterdelegates/RobotMyServiceCardDelegate$MyServiceCardViewHolder$d", "La54/a;", "", "robotUin", "troopUin", "", WadlProxyConsts.EXTRA_DATA, "", "d", "f", "c", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes25.dex */
        public static final class d implements a54.a {
            d() {
            }

            @Override // a54.a
            public void a(@NotNull String robotUin) {
                Intrinsics.checkNotNullParameter(robotUin, "robotUin");
                RobotProfileMyServiceData.RobotService robotService = MyServiceCardViewHolder.this.data;
                if (robotService != null) {
                    MyServiceCardViewHolder myServiceCardViewHolder = MyServiceCardViewHolder.this;
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("robot.profile.RobotMyServiceCardDelegate", 2, "onRemoveRobotFriendSuccess " + robotService);
                    }
                    myServiceCardViewHolder.r(myServiceCardViewHolder.getBinding(), robotService);
                }
            }

            @Override // a54.a
            public void b(@NotNull String str) {
                a.C0013a.d(this, str);
            }

            @Override // a54.a
            public void c(@NotNull String robotUin) {
                Intrinsics.checkNotNullParameter(robotUin, "robotUin");
                RobotProfileMyServiceData.RobotService robotService = MyServiceCardViewHolder.this.data;
                if (robotService != null) {
                    MyServiceCardViewHolder myServiceCardViewHolder = MyServiceCardViewHolder.this;
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("robot.profile.RobotMyServiceCardDelegate", 2, "onAddRobotFriendSuccess " + robotService);
                    }
                    myServiceCardViewHolder.r(myServiceCardViewHolder.getBinding(), robotService);
                }
            }

            @Override // a54.a
            public void d(@NotNull String robotUin, @NotNull String troopUin, @Nullable Object extraData) {
                Intrinsics.checkNotNullParameter(robotUin, "robotUin");
                Intrinsics.checkNotNullParameter(troopUin, "troopUin");
                RobotProfileMyServiceData.RobotService robotService = MyServiceCardViewHolder.this.data;
                if (robotService != null) {
                    MyServiceCardViewHolder myServiceCardViewHolder = MyServiceCardViewHolder.this;
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("robot.profile.RobotMyServiceCardDelegate", 2, "onAddRobotToGroupSucc " + robotService);
                    }
                    myServiceCardViewHolder.r(myServiceCardViewHolder.getBinding(), robotService);
                }
            }

            @Override // a54.a
            public void e(@NotNull String str, @NotNull String str2, @Nullable Object obj) {
                a.C0013a.b(this, str, str2, obj);
            }

            @Override // a54.a
            public void f(@NotNull String robotUin, @NotNull String troopUin) {
                Intrinsics.checkNotNullParameter(robotUin, "robotUin");
                Intrinsics.checkNotNullParameter(troopUin, "troopUin");
                RobotProfileMyServiceData.RobotService robotService = MyServiceCardViewHolder.this.data;
                if (robotService != null) {
                    MyServiceCardViewHolder myServiceCardViewHolder = MyServiceCardViewHolder.this;
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("robot.profile.RobotMyServiceCardDelegate", 2, "onRemoveRobotFromGroupSucc " + robotService);
                    }
                    myServiceCardViewHolder.r(myServiceCardViewHolder.getBinding(), robotService);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyServiceCardViewHolder(@NotNull hn2.n binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
            this.clickListener = new b();
            this.relationObserver = new d();
            this.lifecycleListener = new c();
            v();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void r(hn2.n binding, RobotProfileMyServiceData.RobotService robotService) {
            boolean isBlank;
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("robot.profile.RobotMyServiceCardDelegate", "bindSettingState " + robotService.getRelationShip());
            }
            SettingState t16 = t(robotService);
            binding.getRoot().setTag(t16);
            binding.getRoot().setOnClickListener(this.clickListener);
            int i3 = a.f367834a[t16.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                binding.f405395d.setVisibility(0);
                                binding.f405396e.setVisibility(0);
                                binding.f405397f.setVisibility(8);
                                binding.f405398g.setVisibility(8);
                                return;
                            }
                            return;
                        }
                        binding.f405395d.setVisibility(0);
                        binding.f405396e.setVisibility(0);
                        binding.f405397f.setVisibility(0);
                        binding.f405398g.setVisibility(8);
                        if (robotService.getIsSet()) {
                            binding.f405397f.setText("\u5df2\u8bbe\u7f6e");
                            return;
                        } else {
                            binding.f405397f.setText("\u672a\u8bbe\u7f6e");
                            return;
                        }
                    }
                    binding.f405395d.setVisibility(0);
                    binding.f405396e.setVisibility(8);
                    binding.f405397f.setVisibility(8);
                    binding.f405398g.setVisibility(0);
                    isBlank = StringsKt__StringsJVMKt.isBlank(robotService.getAvailableRangeDesc());
                    if (isBlank) {
                        binding.f405398g.setText("\u4ec5\u7ba1\u7406\u5458\u53ef\u7528");
                        return;
                    } else {
                        binding.f405398g.setText(robotService.getAvailableRangeDesc());
                        return;
                    }
                }
                binding.f405395d.setVisibility(8);
                return;
            }
            binding.f405395d.setVisibility(8);
            binding.getRoot().setOnClickListener(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final SettingState t(RobotProfileMyServiceData.RobotService item) {
            boolean isBlank;
            boolean isBlank2;
            boolean isBlank3;
            if (item.getIsFromTroop()) {
                if (item.getRelationShip().getRobotMemberShip() == -1) {
                    return SettingState.SETTING_STATE_GUEST;
                }
                if (com.tencent.robot.profile.data.g.INSTANCE.a(item.getRelationShip().getUserMemberShip())) {
                    isBlank2 = StringsKt__StringsJVMKt.isBlank(item.getSettingUrl());
                    if (!isBlank2) {
                        return SettingState.SETTING_STATE_ADMIN_CAN_SET;
                    }
                    return SettingState.SETTING_STATE_NONE;
                }
                if (item.a()) {
                    isBlank3 = StringsKt__StringsJVMKt.isBlank(item.getSettingUrl());
                    if (!isBlank3) {
                        return SettingState.SETTING_STATE_CAN_USE;
                    }
                }
                return SettingState.SETTING_STATE_TROOP_MEMBER;
            }
            if (!item.getRelationShip().getCom.tencent.mobileqq.profilecard.api.IProfileProtocolConst.PARAM_IS_FRIEND java.lang.String()) {
                return SettingState.SETTING_STATE_GUEST;
            }
            if (item.a()) {
                isBlank = StringsKt__StringsJVMKt.isBlank(item.getSettingUrl());
                if (!isBlank) {
                    return SettingState.SETTING_STATE_CAN_USE;
                }
            }
            return SettingState.SETTING_STATE_NONE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int u(boolean allowAddC2C, boolean allowAddGroup, boolean isFromTroop) {
            if (isFromTroop && allowAddGroup) {
                return R.string.f223116fc;
            }
            if (!isFromTroop && allowAddC2C) {
                return R.string.f223126fd;
            }
            return R.string.f223146ff;
        }

        private final void v() {
            j44.a aVar = (j44.a) RFWIocAbilityProvider.g().getIocInterface(j44.a.class, RobotProfileUtils.f368193a.j(this.itemView), null);
            if (aVar != null) {
                aVar.a(this.lifecycleListener);
            }
        }

        public final void onViewAttachedToWindow() {
            IRuntimeService iRuntimeService;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
            } else {
                iRuntimeService = null;
            }
            IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
            if (iRobotRelationService != null) {
                iRobotRelationService.addRelationObserver(this.relationObserver);
            }
        }

        public final void onViewDetachedFromWindow() {
            IRuntimeService iRuntimeService;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
            } else {
                iRuntimeService = null;
            }
            IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
            if (iRobotRelationService != null) {
                iRobotRelationService.removeRelationObserver(this.relationObserver);
            }
        }

        public final void q(@NotNull RobotProfileMyServiceData.RobotService item) {
            boolean isBlank;
            Intrinsics.checkNotNullParameter(item, "item");
            this.data = item;
            this.binding.f405394c.setText(item.getName());
            this.binding.f405393b.setText(item.getDesc());
            TextView textView = this.binding.f405393b;
            isBlank = StringsKt__StringsJVMKt.isBlank(item.getDesc());
            Boolean valueOf = Boolean.valueOf(isBlank);
            textView.setVisibility(8);
            if (((View) au.a(valueOf, textView)) == null) {
                textView.setVisibility(0);
            }
            r(this.binding, item);
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("robot.profile.RobotMyServiceCardDelegate", "bindData " + item);
            }
        }

        @NotNull
        /* renamed from: s, reason: from getter */
        public final hn2.n getBinding() {
            return this.binding;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void g(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.g(holder);
        if (holder instanceof MyServiceCardViewHolder) {
            ((MyServiceCardViewHolder) holder).onViewAttachedToWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void h(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.h(holder);
        if (holder instanceof MyServiceCardViewHolder) {
            ((MyServiceCardViewHolder) holder).onViewDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull RobotProfileMyServiceData.RobotService item, @NotNull List<RobotProfileMyServiceData.RobotService> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull RobotProfileMyServiceData.RobotService item, @NotNull MyServiceCardViewHolder holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.q(item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public MyServiceCardViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        hn2.n g16 = hn2.n.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        return new MyServiceCardViewHolder(g16);
    }
}
