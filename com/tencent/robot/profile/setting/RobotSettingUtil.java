package com.tencent.robot.profile.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.util.Consumer;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.friend.api.IFriendExtensionService;
import com.tencent.mobileqq.profilecard.api.IProfileCardBlacklistApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.api.IRelationBlacklistApi;
import com.tencent.mobileqq.profilecard.listener.CheckBlacklistListener;
import com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener;
import com.tencent.mobileqq.profilecard.service.IProfileCardBlacklistService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRemoveFriendCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetRemoveRobotFromGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetRobotMessagePushCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotMsgPushSetReq;
import com.tencent.qqnt.kernel.nativeinterface.RobtMsgSettingType;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.robot.api.IRobotExtApi;
import com.tencent.robot.profile.addtotroop.RobotAddToTroopFragment;
import com.tencent.robot.profile.subscribe.RobotSubscribeSettingDetailFragment;
import com.tencent.robot.profile.utils.RobotProfileUtils;
import com.tencent.robot.relation.api.IRobotRelationService;
import java.util.ArrayList;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001b\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ*\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0002J2\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0012J*\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u0012J@\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001aJ&\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0016J\"\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u0012J\"\u0010!\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u0012J\"\u0010\"\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u0012J0\u0010#\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006&"}, d2 = {"Lcom/tencent/robot/profile/setting/RobotSettingUtil;", "", "", "robotUin", "", "j", "uin", "", DomainData.DOMAIN_NAME, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "troopUin", "Landroid/os/Bundle;", "reportData", "r", "adderUin", "v", "Lkotlin/Function1;", "callback", "t", "robotUid", "", "l", "isChecked", "isFromTroop", "Lkotlin/Function2;", "E", "userMemberShip", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "D", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", HippyTKDListViewAdapter.X, "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotSettingUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RobotSettingUtil f368093a = new RobotSettingUtil();

    RobotSettingUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(String robotUin, final Function1 callback, final boolean z16, Object obj) {
        IProfileCardBlacklistService iProfileCardBlacklistService;
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (z16) {
            ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).updateUserIsBlacklistUinFlag(robotUin, true);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && (iProfileCardBlacklistService = (IProfileCardBlacklistService) peekAppRuntime.getRuntimeService(IProfileCardBlacklistService.class, "all")) != null) {
                iProfileCardBlacklistService.deleteBlacklistUinMessage(robotUin);
            }
        }
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.profile.setting.RobotSettingUtil$sendAddBlacklist$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                callback.invoke(Boolean.valueOf(z16));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(String robotUin, final Function1 callback, final boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (z16) {
            ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).updateUserIsBlacklistUinFlag(robotUin, false);
        }
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.profile.setting.RobotSettingUtil$sendCancelBlacklist$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                callback.invoke(Boolean.valueOf(z16));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(final Function2 callback, final int i3, final String str) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.profile.setting.RobotSettingUtil$switchReceiveRobotMsg$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                Function2<Boolean, String, Unit> function2 = callback;
                Boolean valueOf = Boolean.valueOf(i3 == 0);
                String errMsg = str;
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                function2.invoke(valueOf, errMsg);
            }
        });
    }

    private final void j(String robotUin) {
        aa recentContactService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getRecentContactService();
        ArrayList<Contact> arrayList = new ArrayList<>();
        Contact contact = new Contact();
        contact.setPeerUid(robotUin);
        contact.setChatType(1);
        arrayList.add(contact);
        if (recentContactService != null) {
            recentContactService.a0(arrayList, new IOperateCallback() { // from class: com.tencent.robot.profile.setting.l
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotSettingUtil.k(i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(int i3, String str) {
        QLog.i("RobotSettingUtil", 1, "deleteRecentContact result: " + i3 + ", errMsg: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(String robotUin, Function1 callback, int i3, String str) {
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        boolean z16 = true;
        QLog.i("RobotSettingUtil", 1, "deleteRobot result=" + i3 + ", errMsg=" + str);
        if (i3 == 0) {
            f368093a.j(robotUin);
            com.tencent.mobileqq.tts.data.g.h().f(robotUin);
        }
        if (i3 != 0) {
            z16 = false;
        }
        callback.invoke(Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object n(String str, Continuation<? super Integer> continuation) {
        RobotSettingUtil$getOpenProfileApiParamPA$1 robotSettingUtil$getOpenProfileApiParamPA$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        String str2;
        if (continuation instanceof RobotSettingUtil$getOpenProfileApiParamPA$1) {
            robotSettingUtil$getOpenProfileApiParamPA$1 = (RobotSettingUtil$getOpenProfileApiParamPA$1) continuation;
            int i16 = robotSettingUtil$getOpenProfileApiParamPA$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                robotSettingUtil$getOpenProfileApiParamPA$1.label = i16 - Integer.MIN_VALUE;
                obj = robotSettingUtil$getOpenProfileApiParamPA$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = robotSettingUtil$getOpenProfileApiParamPA$1.label;
                int i17 = 1;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime != null) {
                        str2 = peekAppRuntime.getCurrentUin();
                    } else {
                        str2 = null;
                    }
                    if (Intrinsics.areEqual(str, str2)) {
                        i17 = 0;
                        return Boxing.boxInt(i17);
                    }
                    CoroutineDispatcher io5 = Dispatchers.getIO();
                    RobotSettingUtil$getOpenProfileApiParamPA$isFriend$1 robotSettingUtil$getOpenProfileApiParamPA$isFriend$1 = new RobotSettingUtil$getOpenProfileApiParamPA$isFriend$1(str, null);
                    robotSettingUtil$getOpenProfileApiParamPA$1.label = 1;
                    obj = BuildersKt.withContext(io5, robotSettingUtil$getOpenProfileApiParamPA$isFriend$1, robotSettingUtil$getOpenProfileApiParamPA$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (!((Boolean) obj).booleanValue()) {
                    i17 = 19;
                }
                return Boxing.boxInt(i17);
            }
        }
        robotSettingUtil$getOpenProfileApiParamPA$1 = new RobotSettingUtil$getOpenProfileApiParamPA$1(this, continuation);
        obj = robotSettingUtil$getOpenProfileApiParamPA$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = robotSettingUtil$getOpenProfileApiParamPA$1.label;
        int i172 = 1;
        if (i3 == 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
        return Boxing.boxInt(i172);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(final Function1 callback, final boolean z16) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.profile.setting.RobotSettingUtil$isBlackList$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                callback.invoke(Boolean.valueOf(z16));
            }
        });
    }

    public static /* synthetic */ void s(RobotSettingUtil robotSettingUtil, Context context, String str, String str2, Bundle bundle, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            bundle = null;
        }
        robotSettingUtil.r(context, str, str2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Context context, Function1 callback, String str) {
        LifecycleCoroutineScope lifecycleScope;
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        LifecycleOwner a16 = nf2.b.a(context);
        if (a16 != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(a16)) != null) {
            CorountineFunKt.e(lifecycleScope, "RobotSettingUtilloadAdderNick", Boolean.TRUE, null, null, new RobotSettingUtil$loadAdderNick$1$1(callback, str, null), 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(final Function2 callback, final int i3, final String str) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.i("RobotSettingUtil", 1, "removeRobot result=" + i3);
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.profile.setting.RobotSettingUtil$removeRobotFromTroop$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                Function2<Boolean, String, Unit> function2 = callback;
                Boolean valueOf = Boolean.valueOf(i3 == 0);
                String errMsg = str;
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                function2.invoke(valueOf, errMsg);
            }
        });
    }

    public final void B(@NotNull final String robotUin, @NotNull final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).sendDeleteBlacklistRequest(robotUin, new RelationBlacklistListener() { // from class: com.tencent.robot.profile.setting.g
            @Override // com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener
            public final void onResult(boolean z16, Object obj) {
                RobotSettingUtil.C(robotUin, callback, z16, obj);
            }
        });
    }

    public final void D(@NotNull String robotUin, @NotNull String robotUid, boolean isChecked) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(robotUid, "robotUid");
        ((IRobotExtApi) QRoute.api(IRobotExtApi.class)).setMsgNotDisturb(robotUin, robotUid, isChecked);
    }

    public final void E(boolean isChecked, boolean isFromTroop, @NotNull String robotUin, @NotNull String troopUin, @NotNull final Function2<? super Boolean, ? super String, Unit> callback) {
        RobtMsgSettingType robtMsgSettingType;
        Long longOrNull;
        long j3;
        Long longOrNull2;
        long j16;
        IRuntimeService iRuntimeService;
        ac robotService;
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (isFromTroop) {
            robtMsgSettingType = RobtMsgSettingType.GROUP;
        } else {
            robtMsgSettingType = RobtMsgSettingType.C2C;
        }
        RobtMsgSettingType robtMsgSettingType2 = robtMsgSettingType;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(robotUin);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        if (longOrNull2 != null) {
            j16 = longOrNull2.longValue();
        } else {
            j16 = 0;
        }
        RobotMsgPushSetReq robotMsgPushSetReq = new RobotMsgPushSetReq(j3, robtMsgSettingType2, isChecked, j16);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IKernelService.class, "");
        } else {
            iRuntimeService = null;
        }
        IKernelService iKernelService = (IKernelService) iRuntimeService;
        if (iKernelService != null && (robotService = iKernelService.getRobotService()) != null) {
            robotService.setRobotMessagePush(robotMsgPushSetReq, new ISetRobotMessagePushCallback() { // from class: com.tencent.robot.profile.setting.i
                @Override // com.tencent.qqnt.kernel.nativeinterface.ISetRobotMessagePushCallback
                public final void onResult(int i3, String str) {
                    RobotSettingUtil.F(Function2.this, i3, str);
                }
            });
        }
    }

    public final void l(@NotNull final String robotUin, @NotNull String robotUid, @NotNull final Function1<? super Boolean, Unit> callback) {
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(robotUid, "robotUid");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
        } else {
            iRuntimeService = null;
        }
        IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
        if (iRobotRelationService != null) {
            iRobotRelationService.removeRobotFriend(robotUin, robotUid, new IRemoveFriendCallback() { // from class: com.tencent.robot.profile.setting.j
                @Override // com.tencent.qqnt.kernel.nativeinterface.IRemoveFriendCallback
                public final void onResult(int i3, String str) {
                    RobotSettingUtil.m(robotUin, callback, i3, str);
                }
            });
        }
    }

    public final void o(@NotNull String robotUin, @NotNull final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((IProfileCardBlacklistApi) QRoute.api(IProfileCardBlacklistApi.class)).isBlackOrBlackedUin(robotUin, new CheckBlacklistListener() { // from class: com.tencent.robot.profile.setting.f
            @Override // com.tencent.mobileqq.profilecard.listener.CheckBlacklistListener
            public final void onResult(boolean z16) {
                RobotSettingUtil.p(Function1.this, z16);
            }
        });
    }

    public final boolean q(@NotNull String robotUin) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IFriendExtensionService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
        ExtensionInfo extensionInfo = ((IFriendExtensionService) runtimeService).getExtensionInfo(robotUin);
        if (extensionInfo == null || extensionInfo.openDoNotDisturbTime <= 0) {
            return false;
        }
        return true;
    }

    public final void r(@NotNull Context context, @NotNull String robotUin, @NotNull String troopUin, @Nullable Bundle reportData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intent intent = new Intent();
        intent.putExtra("uin", robotUin);
        intent.putExtra("troop_uin", troopUin);
        intent.putExtra(AppConstants.Key.EXTRA_TYPE, reportData);
        QPublicFragmentActivity.start(context, intent, RobotAddToTroopFragment.class);
    }

    public final void t(@NotNull final Context context, @NotNull String adderUin, @NotNull String troopUin, @NotNull final Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adderUin, "adderUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        RobotProfileUtils.f368193a.k(adderUin, troopUin, new Consumer() { // from class: com.tencent.robot.profile.setting.e
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                RobotSettingUtil.u(context, callback, (String) obj);
            }
        });
    }

    public final void v(@NotNull Context context, @NotNull String adderUin) {
        LifecycleCoroutineScope lifecycleScope;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adderUin, "adderUin");
        LifecycleOwner a16 = nf2.b.a(context);
        if (a16 != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(a16)) != null) {
            BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new RobotSettingUtil$lookAtAdder$1(adderUin, context, null), 3, null);
        }
    }

    public final void w(@NotNull Context context, @NotNull String troopUin, @NotNull String robotUin, int userMemberShip) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        RobotSubscribeSettingDetailFragment.INSTANCE.a(context, troopUin, robotUin, userMemberShip);
    }

    public final void x(@NotNull String robotUin, @NotNull String troopUin, @NotNull final Function2<? super Boolean, ? super String, Unit> callback) {
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
        } else {
            iRuntimeService = null;
        }
        IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
        if (iRobotRelationService != null) {
            iRobotRelationService.removeRobotFromGroup(robotUin, troopUin, new ISetRemoveRobotFromGroupCallback() { // from class: com.tencent.robot.profile.setting.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.ISetRemoveRobotFromGroupCallback
                public final void onResult(int i3, String str) {
                    RobotSettingUtil.y(Function2.this, i3, str);
                }
            });
        }
    }

    public final void z(@NotNull final String robotUin, @NotNull final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).sendAddBlacklistRequest(robotUin, new RelationBlacklistListener() { // from class: com.tencent.robot.profile.setting.k
            @Override // com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener
            public final void onResult(boolean z16, Object obj) {
                RobotSettingUtil.A(robotUin, callback, z16, obj);
            }
        });
    }
}
