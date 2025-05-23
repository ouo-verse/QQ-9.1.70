package com.tencent.mobileqq.gamecenter.qa.aio.reserve2;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.part.root.panel.mvx.intent.PanelStatusIntent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.mobileqq.gamecenter.qa.aio.reserve2.GameQAMsgIntent;
import com.tencent.mobileqq.gamecenter.qa.aio.reserve2.GameQAUIState;
import com.tencent.mobileqq.gamecenter.qa.aio.reserve2.b;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyService;
import com.tencent.mobileqq.gamecenter.qa.util.GameQAUtil;
import com.tencent.mobileqq.guild.mainframe.centerpanel.MFGestureListIntent;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import rr1.i;
import tencent.im.common.nt_msg_common$Msg;
import tencent.im.common.nt_msg_common$MsgHead;
import tencent.im.group_pro_proto.msgpush.servtype$EventBody;
import tencent.im.group_pro_proto.msgpush.servtype$QuestionChannelSystemMsg;
import tencent.im.msg.nt_im_msg_body$CommonElem;
import tencent.im.msg.nt_im_msg_body$Elem;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u00013\u0018\u0000 92\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0016H\u0002J\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u00020\u0007H\u0016J\b\u0010%\u001a\u00020\u0007H\u0007J\b\u0010&\u001a\u00020\u0007H\u0007R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAViewModel;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/b;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState;", "Landroidx/lifecycle/LifecycleObserver;", "Lvd1/b;", "gameSessionInfo", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "topMargin", "y", "v", "Lcom/tencent/mvi/base/route/MsgIntent;", "action", "E", "Lrr1/i;", "notifyData", "p", ReportConstant.COSTREPORT_PREFIX, "w", "Lkotlinx/coroutines/flow/Flow;", "Ltencent/im/common/nt_msg_common$Msg;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "msg", "r", "Ltencent/im/group_pro_proto/msgpush/servtype$EventBody;", "eventBody", "Ltencent/im/common/nt_msg_common$MsgHead;", "msgHead", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "intent", "o", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "d", "Z", "mIsInit", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "e", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "mCoroutineDispatcher", "Lkotlinx/coroutines/CoroutineScope;", "f", "Lkotlinx/coroutines/CoroutineScope;", "mIMLogicScope", "com/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAViewModel$b", h.F, "Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAViewModel$b;", "mAction", "<init>", "()V", "i", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GameQAViewModel extends com.tencent.aio.base.mvvm.b<com.tencent.mobileqq.gamecenter.qa.aio.reserve2.b, GameQAUIState> implements LifecycleObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mIsInit;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ExecutorCoroutineDispatcher mCoroutineDispatcher;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CoroutineScope mIMLogicScope;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAViewModel$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GameQAViewModel.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    private final Flow<nt_msg_common$Msg> A() {
        return FlowKt.flow(new GameQAViewModel$updateSysMsgNotificationFlow$$inlined$transform$1(((IMsgService) QRoute.api(IMsgService.class)).receiveSysMsgNotificationFlow(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent action) {
        if (action instanceof PanelStatusIntent.PanelStatusChangeIntent) {
            updateUI(new GameQAUIState.KeyboardStatusChange(((PanelStatusIntent.PanelStatusChangeIntent) action).b()));
        } else if (action instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            updateUI(new GameQAUIState.MultiSelectModeChange(Boolean.valueOf(((GuildMsgListIntent.GuildMultiSelectModeChangeEvent) action).getIsSelectMode())));
        } else if (action instanceof MFGestureListIntent.NotifyEvent) {
            p(((MFGestureListIntent.NotifyEvent) action).getNotifyData());
        }
    }

    private final void p(i notifyData) {
        if (notifyData.f() == 3) {
            if (notifyData.c() != 1) {
                QLog.i("GameQAViewModel", 1, "handleMFGestureNotify, fold finished");
                updateUI(GameQAUIState.AioFoldFinish.f212380d);
                return;
            } else {
                if (notifyData.c() == 1) {
                    if (notifyData.a() == 3 || notifyData.a() == 2) {
                        QLog.i("GameQAViewModel", 1, "handleMFGestureNotify, open");
                        updateUI(GameQAUIState.AioUnFoldFinish.f212382d);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (notifyData.f() == 1 && notifyData.a() == 1) {
            QLog.i("GameQAViewModel", 1, "handleMFGestureNotify, start fold");
            updateUI(GameQAUIState.AioFoldStart.f212381d);
        }
    }

    private final void q(servtype$EventBody eventBody, nt_msg_common$MsgHead msgHead) {
        if (!eventBody.question_channel_system_msg.has()) {
            return;
        }
        servtype$QuestionChannelSystemMsg servtype_questionchannelsystemmsg = eventBody.question_channel_system_msg.get();
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameStrategyService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026nstant.MAIN\n            )");
        ((IQQGameStrategyService) runtimeService).handleSystemMsg(msgHead.content_head.random.get(), servtype_questionchannelsystemmsg, String.valueOf(msgHead.routing_head.guild_id.get()), String.valueOf(msgHead.routing_head.channel_id.get()));
    }

    private final void r(nt_msg_common$Msg msg2) {
        nt_im_msg_body$CommonElem nt_im_msg_body_commonelem;
        if (msg2.head.has() && msg2.head.routing_head.has()) {
            String valueOf = String.valueOf(msg2.head.routing_head.channel_id.get());
            QLog.i("GameQAViewModel", 1, "channelId = " + valueOf);
            Iterator<nt_im_msg_body$Elem> it = msg2.body.get().rich_text.get().elems.get().iterator();
            while (true) {
                if (it.hasNext()) {
                    nt_im_msg_body$Elem next = it.next();
                    if (next.common_elem.has()) {
                        nt_im_msg_body_commonelem = next.common_elem.get();
                        break;
                    }
                } else {
                    nt_im_msg_body_commonelem = null;
                    break;
                }
            }
            if (nt_im_msg_body_commonelem == null || 500 != nt_im_msg_body_commonelem.uint32_service_type.get()) {
                return;
            }
            servtype$EventBody servtype_eventbody = new servtype$EventBody();
            try {
                servtype_eventbody.mergeFrom(nt_im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
                nt_msg_common$MsgHead nt_msg_common_msghead = msg2.head.get();
                Intrinsics.checkNotNullExpressionValue(nt_msg_common_msghead, "msg.head.get()");
                q(servtype_eventbody, nt_msg_common_msghead);
            } catch (InvalidProtocolBufferMicroException unused) {
                QLog.i("GameQAViewModel", 1, "channelId = " + valueOf);
            }
        }
    }

    private final void s() {
        List mutableListOf;
        IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(63L);
        Intrinsics.checkNotNull(mutableListOf, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Long>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Long> }");
        iMsgService.registerSysMsgNotification(1, 3841L, (ArrayList) mutableListOf, new IOperateCallback() { // from class: com.tencent.mobileqq.gamecenter.qa.aio.reserve2.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                GameQAViewModel.t(i3, str);
            }
        });
        try {
            ExecutorCoroutineDispatcher executorCoroutineDispatcher = this.mCoroutineDispatcher;
            if (executorCoroutineDispatcher != null && this.mIMLogicScope != null) {
                Flow flowOn = FlowKt.flowOn(FlowKt.onEach(A(), new GameQAViewModel$registerSysMsgNotification$2(this)), executorCoroutineDispatcher);
                CoroutineScope coroutineScope = this.mIMLogicScope;
                Intrinsics.checkNotNull(coroutineScope);
                FlowKt.launchIn(flowOn, coroutineScope);
            } else {
                QLog.w("GameQAViewModel", 1, "registerSysMsgNotification, dispatcher null");
            }
        } catch (Exception e16) {
            QLog.e("GameQAViewModel", 1, "registerSysMsgNotification, exception=", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(int i3, String str) {
        QLog.d("GameQAViewModel", 1, "registerSysMsgNotification, result = " + i3 + ", errMsg = " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object u(GameQAViewModel gameQAViewModel, nt_msg_common$Msg nt_msg_common_msg, Continuation continuation) {
        gameQAViewModel.r(nt_msg_common_msg);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v() {
        String string = ((com.tencent.aio.api.runtime.a) getMContext()).g().l().getString("jumpsecret");
        QLog.d("GameQAViewModel", 1, "sendInitState, jumpSecret=" + string);
        int i3 = 0;
        try {
            i3 = new JSONObject(string).optInt("appid", 0);
        } catch (Exception e16) {
            QLog.e("GameQAViewModel", 1, "sendInitState, exception", e16);
        }
        QLog.i("GameQAViewModel", 1, "sendInitState, appid=" + i3);
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        String g17 = com.tencent.guild.aio.util.a.g(g16);
        AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
        vd1.b bVar = new vd1.b(g17, com.tencent.guild.aio.util.a.b(g18), i3);
        updateUI(new GameQAUIState.InitState(bVar));
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GameQAMsgIntent.SessionInfoChange(bVar));
        GameQAUtil.G(bVar);
    }

    private final void w() {
        List mutableListOf;
        IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(63L);
        Intrinsics.checkNotNull(mutableListOf, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Long>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Long> }");
        iMsgService.unregisterSysMsgNotification(1, 3841L, (ArrayList) mutableListOf, new IOperateCallback() { // from class: com.tencent.mobileqq.gamecenter.qa.aio.reserve2.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                GameQAViewModel.x(i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(int i3, String str) {
        QLog.i("GameQAViewModel", 1, "unregisterSysMsgNotification, result = " + i3 + ", errMsg = " + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y(int topMargin) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMsgListTopMarginUpdateEvent(topMargin));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z(vd1.b gameSessionInfo) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GameQAMsgIntent.SessionInfoChange(gameSessionInfo));
        GameQAUtil.G(gameSessionInfo);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.mobileqq.gamecenter.qa.aio.reserve2.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.C7646b) {
            y(((b.C7646b) intent).getTopMargin());
        } else if (intent instanceof b.a) {
            z(((b.a) intent).getGameSessionInfo());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        QLog.i("GameQAViewModel", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), this.mAction);
        try {
            ExecutorCoroutineDispatcher executorCoroutineDispatcher = this.mCoroutineDispatcher;
            if (executorCoroutineDispatcher != null) {
                executorCoroutineDispatcher.close();
            }
            this.mCoroutineDispatcher = null;
        } catch (Throwable th5) {
            QLog.e("GameQAViewModel", 1, "onDestroy, mCoroutineDispatcher cancel error:", th5);
        }
        try {
            CoroutineScope coroutineScope = this.mIMLogicScope;
            if (coroutineScope != null) {
                CoroutineScopeKt.cancel$default(coroutineScope, "destroy", null, 2, null);
            }
            this.mIMLogicScope = null;
        } catch (Throwable th6) {
            QLog.e("GameQAViewModel", 1, "onDestroy, mIMLogicScope cancel error:", th6);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        QLog.i("GameQAViewModel", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        updateUI(new GameQAUIState.OnPauseState());
        w();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        QLog.i("GameQAViewModel", 1, "onResume");
        if (!this.mIsInit) {
            v();
            this.mIsInit = true;
        }
        updateUI(new GameQAUIState.OnResumeState());
        s();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.i("GameQAViewModel", 1, "onCreate");
        context.d().getLifecycle().addObserver(this);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), this.mAction);
        ExecutorService newSingleThreadExecutor = ProxyExecutors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor()");
        ExecutorCoroutineDispatcher from = ExecutorsKt.from(newSingleThreadExecutor);
        this.mCoroutineDispatcher = from;
        if (from != null) {
            this.mIMLogicScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(from).plus(new CoroutineName("GameQAViewModel")));
        }
    }
}
