package com.tencent.robot.aio.helper;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.robot.aio.input.shortcutbar.RobotPlusPanelIdListEvent;
import com.tencent.robot.aio.input.styleconfig.InputStyleConfigMsgIntent;
import com.tencent.robot.aio.input.styleconfig.b;
import com.tencent.robot.api.IRobotInputStyleConfigApi;
import com.tencent.robot.api.IRobotProfileInfoApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001,\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00016B\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"0!H\u0016R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R&\u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020,01008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00102\u00a8\u00067"}, d2 = {"Lcom/tencent/robot/aio/helper/i;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "robotUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "j", "p", "i", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "Lcom/tencent/mvi/base/route/k;", "g", tl.h.F, "Lcom/tencent/robot/aio/input/shortcutbar/RobotPlusPanelIdListEvent;", "event", "k", "", "getId", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mContext", "Lcom/tencent/robot/aio/input/styleconfig/a;", "e", "Lcom/tencent/robot/aio/input/styleconfig/a;", "mInputStyleConfig", "com/tencent/robot/aio/helper/i$b", "f", "Lcom/tencent/robot/aio/helper/i$b;", "mAction", "", "Lkotlin/Pair;", "Ljava/util/List;", "mMessageList", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class i implements com.tencent.aio.main.businesshelper.h, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.robot.aio.input.styleconfig.a mInputStyleConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> mMessageList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/aio/helper/i$b", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "Lcom/tencent/mvi/base/route/k;", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.b {
        b() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent msgIntent) {
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            return i.this.g(msgIntent);
        }
    }

    public i() {
        List<Pair<String, b>> listOf;
        b bVar = new b();
        this.mAction = bVar;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(TuplesKt.to(com.tencent.qqnt.aio.utils.j.f352301a.a(Reflection.getOrCreateKotlinClass(InputStyleConfigMsgIntent.GetIsSupportSlashAbility.class)), bVar));
        this.mMessageList = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k g(MsgIntent msgIntent) {
        if (msgIntent instanceof InputStyleConfigMsgIntent.GetIsSupportSlashAbility) {
            return h();
        }
        return new j54.a();
    }

    private final com.tencent.mvi.base.route.k h() {
        com.tencent.robot.aio.input.styleconfig.a aVar = this.mInputStyleConfig;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputStyleConfig");
            aVar = null;
        }
        return new b.IsSupportSlashAbility(aVar.getIsSupportSlashPanel());
    }

    private final void i() {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.robot.aio.input.styleconfig.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        String b16 = su3.c.b(g16);
        com.tencent.robot.aio.input.styleconfig.a aVar3 = this.mInputStyleConfig;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputStyleConfig");
            aVar3 = null;
        }
        QLog.i("RobotInputStyleConfigHelper", 1, "callback config changed robotUin = " + b16 + " config = " + aVar3);
        com.tencent.aio.api.runtime.a aVar4 = this.mContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar4 = null;
        }
        aVar4.e().h(new PanelContainerMsgIntent.HideAllPanelMsgIntent("RobotInputStyleConfigHelper", true));
        com.tencent.aio.api.runtime.a aVar5 = this.mContext;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar5 = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar5.e();
        com.tencent.robot.aio.input.styleconfig.a aVar6 = this.mInputStyleConfig;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputStyleConfig");
            aVar6 = null;
        }
        e16.h(new InputStyleConfigMsgIntent.OnInputStyleConfigChanged(aVar6));
        com.tencent.aio.api.runtime.a aVar7 = this.mContext;
        if (aVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar7 = null;
        }
        com.tencent.mvi.base.route.j e17 = aVar7.e();
        com.tencent.robot.aio.input.styleconfig.a aVar8 = this.mInputStyleConfig;
        if (aVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputStyleConfig");
            aVar8 = null;
        }
        boolean e18 = aVar8.e();
        com.tencent.robot.aio.input.styleconfig.a aVar9 = this.mInputStyleConfig;
        if (aVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputStyleConfig");
        } else {
            aVar2 = aVar9;
        }
        e17.h(new FullScreenMsgIntent.UpdateFullScreenAbilityMsgIntent(e18, aVar2.d()));
    }

    private final void j(String robotUin, GroupRobotProfile robotProfile) {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.robot.aio.input.styleconfig.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        if (!Intrinsics.areEqual(robotUin, su3.c.b(g16))) {
            return;
        }
        com.tencent.robot.aio.input.styleconfig.d dVar = com.tencent.robot.aio.input.styleconfig.d.f367243a;
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar3 = null;
        }
        com.tencent.robot.aio.input.styleconfig.a a16 = dVar.a(aVar3, robotProfile);
        com.tencent.robot.aio.input.styleconfig.a aVar4 = this.mInputStyleConfig;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputStyleConfig");
        } else {
            aVar2 = aVar4;
        }
        if (Intrinsics.areEqual(a16, aVar2)) {
            return;
        }
        this.mInputStyleConfig = a16;
        p();
        i();
    }

    private final void k(RobotPlusPanelIdListEvent event) {
        com.tencent.robot.aio.input.styleconfig.a aVar = null;
        if (this.mInputStyleConfig == null) {
            String robotUin = event.getRobotUin();
            com.tencent.aio.api.runtime.a aVar2 = this.mContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar2 = null;
            }
            AIOParam g16 = aVar2.g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (!Intrinsics.areEqual(robotUin, su3.c.b(g16))) {
                return;
            }
        }
        event.getIdList().clear();
        ArrayList<Integer> idList = event.getIdList();
        com.tencent.robot.aio.input.styleconfig.a aVar3 = this.mInputStyleConfig;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputStyleConfig");
        } else {
            aVar = aVar3;
        }
        idList.addAll(aVar.b());
    }

    private final void m() {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        final String b16 = su3.c.b(g16);
        IRobotInputStyleConfigApi iRobotInputStyleConfigApi = (IRobotInputStyleConfigApi) QRoute.api(IRobotInputStyleConfigApi.class);
        com.tencent.robot.aio.input.styleconfig.a inputStyleConfigFromMMKV = iRobotInputStyleConfigApi.getInputStyleConfigFromMMKV(b16);
        if (inputStyleConfigFromMMKV == null) {
            inputStyleConfigFromMMKV = iRobotInputStyleConfigApi.createDefaultInputStyleConfig();
        }
        this.mInputStyleConfig = inputStyleConfigFromMMKV;
        i();
        ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).getRobotProfileInfoFromLocal(b16, null, new IGetGroupRobotProfileCallback() { // from class: com.tencent.robot.aio.helper.f
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback
            public final void onResult(int i3, String str, GroupRobotProfile groupRobotProfile) {
                i.n(i.this, b16, i3, str, groupRobotProfile);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(final i this$0, final String robotUin, int i3, String str, final GroupRobotProfile groupRobotProfile) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.robot.aio.helper.g
            @Override // java.lang.Runnable
            public final void run() {
                i.o(i.this, robotUin, groupRobotProfile);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(i this$0, String robotUin, GroupRobotProfile groupRobotProfile) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        this$0.j(robotUin, groupRobotProfile);
    }

    private final void p() {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.robot.aio.helper.h
            @Override // java.lang.Runnable
            public final void run() {
                i.q(i.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IRobotInputStyleConfigApi iRobotInputStyleConfigApi = (IRobotInputStyleConfigApi) QRoute.api(IRobotInputStyleConfigApi.class);
        com.tencent.aio.api.runtime.a aVar = this$0.mContext;
        com.tencent.robot.aio.input.styleconfig.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        String b16 = su3.c.b(g16);
        com.tencent.robot.aio.input.styleconfig.a aVar3 = this$0.mInputStyleConfig;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputStyleConfig");
        } else {
            aVar2 = aVar3;
        }
        iRobotInputStyleConfigApi.saveInputStyleConfigToMMKV(b16, aVar2);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(RobotPlusPanelIdListEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350693z1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "RobotInputStyleConfigHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[0];
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        this.mContext = param.a();
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.api.runtime.a aVar = this.mContext;
            com.tencent.aio.api.runtime.a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar = null;
            }
            com.tencent.mvi.base.route.j e16 = aVar.e();
            String str = (String) pair.getFirst();
            com.tencent.mvi.base.route.b bVar = (com.tencent.mvi.base.route.b) pair.getSecond();
            com.tencent.aio.api.runtime.a aVar3 = this.mContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                aVar2 = aVar3;
            }
            LifecycleOwner d16 = aVar2.d();
            Intrinsics.checkNotNullExpressionValue(d16, "mContext.lifecycleOwner");
            e16.g(str, bVar, d16);
        }
        SimpleEventBus.getInstance().registerReceiver(this);
        m();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.api.runtime.a aVar = this.mContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar = null;
            }
            aVar.e().a((String) pair.getFirst());
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof RobotPlusPanelIdListEvent) {
            k((RobotPlusPanelIdListEvent) event);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
    }
}
