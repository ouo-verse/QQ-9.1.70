package com.tencent.robot.aio.helper;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.config.AppSetting;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.input.AIOInputMsgIntent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.BatchGetBotsMenuResponse;
import com.tencent.qqnt.kernel.nativeinterface.BotsMenuRequest;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFilter;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotScene;
import com.tencent.qqnt.kernel.nativeinterface.GProNTBotClientInfo;
import com.tencent.qqnt.kernel.nativeinterface.IBatchGetBotsMenuCallback;
import com.tencent.qqnt.kernel.nativeinterface.MenuInfo;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.robot.aio.input.RobotMenuMsgIntent;
import com.tencent.robot.aio.input.inputbar.pttrecord.RobotInputPttRecordMsgIntent;
import com.tencent.robot.aio.input.styleconfig.InputStyleConfigMsgIntent;
import com.tencent.robot.api.IRobotProfileInfoApi;
import com.tencent.robot.slash.api.IRobotSlashApi;
import com.tencent.robot.slash.manager.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\t*\u0001+\b\u0007\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u0003:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lcom/tencent/robot/aio/helper/RobotMenuHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/aio/api/runtime/emitter/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "j", "k", "Lcom/tencent/qqnt/kernel/api/ac;", "i", "", "getId", "", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "onBackEvent", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Lcom/tencent/robot/slash/manager/c;", "e", "Lcom/tencent/robot/slash/manager/c;", "mDialogManagerApi", "f", "Z", "mIsFetching", "Lcom/tencent/qqnt/kernel/nativeinterface/MenuInfo;", tl.h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/MenuInfo;", "mMenuInfo", "", "J", "mRobotUin", "com/tencent/robot/aio/helper/RobotMenuHelper$b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/robot/aio/helper/RobotMenuHelper$b;", "mAction", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes25.dex */
public final class RobotMenuHelper implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g, com.tencent.aio.api.runtime.emitter.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.robot.slash.manager.c mDialogManagerApi;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFetching;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MenuInfo mMenuInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long mRobotUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/aio/helper/RobotMenuHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent msgIntent) {
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            RobotMenuHelper.this.j(msgIntent);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    private final ac i() {
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null) {
            return iKernelService.getRobotService();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(MsgIntent msgIntent) {
        boolean z16;
        boolean z17;
        boolean z18;
        com.tencent.robot.slash.manager.c cVar = null;
        if (msgIntent instanceof RobotMenuMsgIntent.ShowRobotMenuDialog) {
            com.tencent.robot.slash.manager.c cVar2 = this.mDialogManagerApi;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
            } else {
                cVar = cVar2;
            }
            cVar.showDialog();
            return;
        }
        if (msgIntent instanceof InputEditTextMsgIntent.DispatchKeyBackEventInPreIme) {
            ((InputEditTextMsgIntent.DispatchKeyBackEventInPreIme) msgIntent).b(onBackEvent());
            return;
        }
        if (msgIntent instanceof FullScreenMsgIntent.OnFullScreenModeChanged) {
            z16 = true;
        } else {
            z16 = msgIntent instanceof RobotInputPttRecordMsgIntent.OnPttRecordModeChanged;
        }
        if (z16) {
            z17 = true;
        } else {
            z17 = msgIntent instanceof InputEvent.SendVoiceInputStatusEvent;
        }
        if (z17) {
            z18 = true;
        } else {
            z18 = msgIntent instanceof InputEditTextMsgIntent.EditTextChangedMsgIntent;
        }
        if (z18) {
            com.tencent.robot.slash.manager.c cVar3 = this.mDialogManagerApi;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
                cVar3 = null;
            }
            c.a.a(cVar3, false, 1, null);
            return;
        }
        if (msgIntent instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            if (((PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) msgIntent).b()) {
                com.tencent.robot.slash.manager.c cVar4 = this.mDialogManagerApi;
                if (cVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
                    cVar4 = null;
                }
                c.a.a(cVar4, false, 1, null);
                return;
            }
            return;
        }
        if (msgIntent instanceof KeyboardMsgIntent.OnKeyboardStateChanged) {
            if (((KeyboardMsgIntent.OnKeyboardStateChanged) msgIntent).b()) {
                com.tencent.robot.slash.manager.c cVar5 = this.mDialogManagerApi;
                if (cVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
                } else {
                    cVar = cVar5;
                }
                cVar.b(true);
                return;
            }
            return;
        }
        if (msgIntent instanceof InputStyleConfigMsgIntent.OnInputStyleConfigChanged) {
            if (this.mMenuInfo == null && ((InputStyleConfigMsgIntent.OnInputStyleConfigChanged) msgIntent).getInputStyleConfig().c().contains(1011)) {
                k();
                return;
            }
            return;
        }
        if (msgIntent instanceof RobotMenuMsgIntent.RequestBotMenuMsgIntent) {
            k();
        }
    }

    private final void k() {
        if (this.mIsFetching) {
            QLog.d("RobotMenuHelper", 1, "[requestBatchGetBotMenu] isFetching return");
        } else {
            this.mIsFetching = true;
            RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.robot.aio.helper.j
                @Override // java.lang.Runnable
                public final void run() {
                    RobotMenuHelper.m(RobotMenuHelper.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(final RobotMenuHelper this$0) {
        ArrayList<Long> arrayListOf;
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GProNTBotClientInfo gProNTBotClientInfo = new GProNTBotClientInfo();
        gProNTBotClientInfo.platform = 2;
        gProNTBotClientInfo.version = AppSetting.f99551k;
        String buildNum = AppSetting.f99542b;
        Intrinsics.checkNotNullExpressionValue(buildNum, "buildNum");
        gProNTBotClientInfo.buildNum = Integer.parseInt(buildNum);
        BotsMenuRequest botsMenuRequest = new BotsMenuRequest();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(this$0.mRobotUin));
        botsMenuRequest.uins = arrayListOf;
        botsMenuRequest.num = 25;
        botsMenuRequest.clientInfo = gProNTBotClientInfo;
        botsMenuRequest.page = 0;
        botsMenuRequest.scene = CommonBotScene.C2C;
        botsMenuRequest.filter = CommonBotFilter.KNONE.ordinal();
        botsMenuRequest.bkn = ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).getBKN();
        ac i3 = this$0.i();
        if (i3 != null) {
            i3.batchGetBotsMenu(botsMenuRequest, new IBatchGetBotsMenuCallback() { // from class: com.tencent.robot.aio.helper.k
                @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchGetBotsMenuCallback
                public final void onResult(int i16, String str, BatchGetBotsMenuResponse batchGetBotsMenuResponse) {
                    RobotMenuHelper.n(RobotMenuHelper.this, i16, str, batchGetBotsMenuResponse);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this$0.mIsFetching = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(final RobotMenuHelper this$0, final int i3, final String str, final BatchGetBotsMenuResponse batchGetBotsMenuResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.aio.helper.RobotMenuHelper$requestBatchGetBotMenu$1$1$1$1
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
                com.tencent.aio.api.runtime.a aVar;
                Object firstOrNull;
                RobotMenuHelper.this.mIsFetching = false;
                aVar = RobotMenuHelper.this.mAIOContext;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                    aVar = null;
                }
                com.tencent.mvi.base.route.j e16 = aVar.e();
                int i16 = i3;
                String errMsg = str;
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                e16.h(new RobotMenuMsgIntent.GetBotMenuResponseMsgIntent(i16, errMsg, batchGetBotsMenuResponse));
                RobotMenuHelper robotMenuHelper = RobotMenuHelper.this;
                ArrayList<MenuInfo> arrayList = batchGetBotsMenuResponse.menuInfo;
                Intrinsics.checkNotNullExpressionValue(arrayList, "response.menuInfo");
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
                robotMenuHelper.mMenuInfo = (MenuInfo) firstOrNull;
            }
        });
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.G0;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.robot.aio.input.RobotMenuMsgIntent.ShowRobotMenuDialog");
        hashSet.add("com.tencent.robot.aio.input.RobotMenuMsgIntent.RequestBotMenuMsgIntent");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.EditTextChangedMsgIntent");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.DispatchKeyBackEventInPreIme");
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.OnPanelStateChangedMsgIntent");
        hashSet.add("com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent.OnKeyboardStateChanged");
        hashSet.add("com.tencent.robot.aio.input.inputbar.pttrecord.RobotInputPttRecordMsgIntent.OnPttRecordModeChanged");
        hashSet.add("com.tencent.mobileqq.aio.event.InputEvent.SendVoiceInputStatusEvent");
        hashSet.add("com.tencent.robot.aio.input.styleconfig.InputStyleConfigMsgIntent.OnInputStyleConfigChanged");
        hashSet.add("com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent.OnFullScreenModeChanged");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "RobotMenuHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[0];
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        com.tencent.robot.slash.manager.c cVar = this.mDialogManagerApi;
        com.tencent.robot.slash.manager.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
            cVar = null;
        }
        if (cVar.a()) {
            com.tencent.robot.slash.manager.c cVar3 = this.mDialogManagerApi;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
            } else {
                cVar2 = cVar3;
            }
            cVar2.b(true);
            return true;
        }
        com.tencent.robot.slash.manager.c cVar4 = this.mDialogManagerApi;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
            cVar4 = null;
        }
        if (cVar4.r()) {
            com.tencent.robot.slash.manager.c cVar5 = this.mDialogManagerApi;
            if (cVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
                cVar5 = null;
            }
            c.a.a(cVar5, false, 1, null);
        }
        return false;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        com.tencent.aio.api.runtime.a aVar = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        AIOParam g16 = a16.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        this.mRobotUin = su3.c.a(g16);
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar2 = null;
        }
        aVar2.e().f(this, this.mAction);
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar3 = null;
        }
        ml3.a a17 = aVar3.b().a(com.tencent.aio.api.runtime.emitter.a.class);
        com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar4 = null;
        }
        LifecycleOwner d16 = aVar4.d();
        Intrinsics.checkNotNullExpressionValue(d16, "mAIOContext.lifecycleOwner");
        a17.b(this, d16);
        com.tencent.aio.api.runtime.a aVar5 = this.mAIOContext;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar5 = null;
        }
        com.tencent.mvi.base.route.k k3 = aVar5.e().k(AIOInputMsgIntent.GetInputDialogAnchor.f189144d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.mobileqq.aio.input.edit.AIOInputMsgResult.GetInputDialogAnchor");
        View a18 = ((d.e) k3).a();
        IRobotSlashApi iRobotSlashApi = (IRobotSlashApi) QRoute.api(IRobotSlashApi.class);
        com.tencent.aio.api.runtime.a aVar6 = this.mAIOContext;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar6;
        }
        this.mDialogManagerApi = iRobotSlashApi.createRobotMenuManager(aVar, a18);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        this.mRobotUin = 0L;
        com.tencent.aio.api.runtime.a aVar = null;
        this.mMenuInfo = null;
        this.mIsFetching = false;
        com.tencent.robot.slash.manager.c cVar = this.mDialogManagerApi;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogManagerApi");
            cVar = null;
        }
        cVar.onDestroy();
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar2 = null;
        }
        aVar2.e().i(this, this.mAction);
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar3;
        }
        aVar.b().a(com.tencent.aio.api.runtime.emitter.a.class).c(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
    }
}
