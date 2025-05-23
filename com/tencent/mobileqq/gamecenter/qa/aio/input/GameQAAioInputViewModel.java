package com.tencent.mobileqq.gamecenter.qa.aio.input;

import android.widget.EditText;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.part.root.panel.mvx.intent.PanelStatusIntent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.activity.GuildChatActivityAbility;
import com.tencent.guild.aio.event.GuildMsgSendEvent;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.input.GuildPermissionsChangeWrapperMsgIntent;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.aio.msglist.holder.component.GuildBubbleAvatarLongClickEvent;
import com.tencent.guild.aio.reserve2.busi.navigate.GuildMsgNavigateEvent;
import com.tencent.guild.aio.sendmsg.SendMsgInterceptUtil;
import com.tencent.guild.aio.util.y;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.input.GuildAioInputMsgIntent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.gamecenter.qa.aio.input.GameQAAioInputUIState;
import com.tencent.mobileqq.gamecenter.qa.aio.input.p;
import com.tencent.mobileqq.gamecenter.qa.aio.reserve2.GameQAMsgIntent;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi;
import com.tencent.mobileqq.guild.mainframe.centerpanel.MFGestureListIntent;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import fo0.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kr0.a;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\b*\u0003>BF\u0018\u0000 K2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001LB\u0007\u00a2\u0006\u0004\bI\u0010JJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\b\u0010 \u001a\u00020\u0007H\u0002J\b\u0010!\u001a\u00020\u0007H\u0002J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\"H\u0002J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0016H\u0002J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%H\u0002J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010&\u001a\u00020(H\u0002J\u0016\u0010-\u001a\u00020\u00072\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002J\b\u0010.\u001a\u00020\u0007H\u0002J\b\u0010/\u001a\u00020\u001bH\u0002J\u0010\u00102\u001a\u00020\u00072\u0006\u00101\u001a\u000200H\u0016J\b\u00103\u001a\u00020\u0007H\u0016J\u0010\u00104\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0002H\u0016J\b\u00105\u001a\u00020\u001bH\u0016R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010H\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010G\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputViewModel;", "Lcom/tencent/aio/base/mvvm/b;", "Lfo0/e;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState;", "Lcom/tencent/aio/api/runtime/emitter/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "action", "", "B", "Lcom/tencent/guild/aio/activity/GuildChatActivityAbility$ActivityResultIntent;", ReportConstant.COSTREPORT_PREFIX, "E", "i", "Lcom/tencent/mvi/base/route/k;", "I", "u", "Lcom/tencent/guild/aio/input/GuildPermissionsChangeWrapperMsgIntent;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgItem", "w", "D", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "v", "Lrr1/i;", "notifyData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "isMultiSelectMode", "H", "G", "J", "r", "p", "Lcom/tencent/aio/data/msglist/a;", "y", "t", "Lfo0/e$k;", "intent", "L", "Lfo0/e$l;", "M", "", "Lsr0/b;", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "K", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, UserInfo.SEX_FEMALE, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "onBackEvent", "Lvd1/b;", "d", "Lvd1/b;", "mSessionInfo", "Lcom/tencent/aio/data/AIOContact;", "e", "Lcom/tencent/aio/data/AIOContact;", "mContact", "com/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputViewModel$b", "f", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputViewModel$b;", "mAction1", "com/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputViewModel$c", tl.h.F, "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputViewModel$c;", "mActionR", "com/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputViewModel$d", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputViewModel$d;", "msgSendAction", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GameQAAioInputViewModel extends com.tencent.aio.base.mvvm.b<fo0.e, GameQAAioInputUIState> implements com.tencent.aio.api.runtime.emitter.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private vd1.b mSessionInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AIOContact mContact;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction1 = new b();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mActionR = new c();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d msgSendAction = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputViewModel$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "action", "", "call", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent action) {
            Intrinsics.checkNotNullParameter(action, "action");
            GameQAAioInputViewModel.this.E(action);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputViewModel$c", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements com.tencent.mvi.base.route.b {
        c() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return GameQAAioInputViewModel.this.I(i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputViewModel$d", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "call", "", "sticky", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class d implements com.tencent.mvi.base.route.a {
        d() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            GameQAAioInputViewModel.this.B(intent);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return true;
        }
    }

    private final void A(rr1.i notifyData) {
        if (notifyData.f() == 3) {
            if (notifyData.c() != 1) {
                QLog.i("GameQAAioInputViewModel", 1, "handleMFGestureNotify, fold finished");
                updateUI(GameQAAioInputUIState.AioFoldFinish.f212326d);
                return;
            } else {
                if (notifyData.c() == 1) {
                    if (notifyData.a() == 3 || notifyData.a() == 2) {
                        QLog.i("GameQAAioInputViewModel", 1, "handleMFGestureNotify, open");
                        updateUI(GameQAAioInputUIState.AioUnFoldFinish.f212328d);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (notifyData.f() == 1 && notifyData.a() == 1) {
            QLog.i("GameQAAioInputViewModel", 1, "handleMFGestureNotify, start fold");
            updateUI(GameQAAioInputUIState.AioFoldStart.f212327d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(MsgIntent action) {
        if (action instanceof GuildChatActivityAbility.ActivityResultIntent) {
            s((GuildChatActivityAbility.ActivityResultIntent) action);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C(GuildPermissionsChangeWrapperMsgIntent i3) {
        QLog.d("GameQAAioInputViewModel", 1, "handleAction input permissions = " + i3.getPermissions());
        GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
        int permissions = i3.getPermissions();
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        if (!companion.d(permissions, com.tencent.guild.aio.util.a.b(g16))) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("GameQAAioInputViewModel", false));
        }
        updateUI(new GameQAAioInputUIState.GuildHandlePermissionsChange(i3.getPermissions()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void D(MsgRecord msgItem) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.UpdateReeditRecallMsgListEvent(msgItem));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent action) {
        if (action instanceof PanelStatusIntent.PanelStatusChangeIntent) {
            PanelStatusIntent.PanelStatusChangeIntent panelStatusChangeIntent = (PanelStatusIntent.PanelStatusChangeIntent) action;
            QLog.i("GameQAAioInputViewModel", 1, "receivePanelChange curPanelId=" + panelStatusChangeIntent.a() + " isKeyboardShow=" + panelStatusChangeIntent.b());
            updateUI(new GameQAAioInputUIState.KeyboardStatusChange(panelStatusChangeIntent.b()));
            return;
        }
        if (action instanceof GameQAMsgIntent.SessionInfoChange) {
            vd1.b gameSessionInfo = ((GameQAMsgIntent.SessionInfoChange) action).getGameSessionInfo();
            this.mSessionInfo = gameSessionInfo;
            if (gameSessionInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                gameSessionInfo = null;
            }
            updateUI(new GameQAAioInputUIState.SessionInfoChange(gameSessionInfo));
            return;
        }
        if (action instanceof GuildMsgSendEvent.MsgOnClickReplyEvent) {
            y(((GuildMsgSendEvent.MsgOnClickReplyEvent) action).getMsgItem());
            return;
        }
        if (action instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            H(((GuildMsgListIntent.GuildMultiSelectModeChangeEvent) action).getIsSelectMode());
            return;
        }
        if (action instanceof GuildMsgListIntent.GuildMultiSelectCountChangeEvent) {
            G();
            return;
        }
        if (action instanceof MFGestureListIntent.NotifyEvent) {
            A(((MFGestureListIntent.NotifyEvent) action).getNotifyData());
            return;
        }
        if (action instanceof GuildBubbleAvatarLongClickEvent) {
            v(((GuildBubbleAvatarLongClickEvent) action).getMsgItem());
        } else if (action instanceof GuildMsgSendEvent.MsgOnClickRecallMsgsEvent) {
            w(((GuildMsgSendEvent.MsgOnClickRecallMsgsEvent) action).getMsgItem());
        } else if (action instanceof GuildPermissionsChangeWrapperMsgIntent) {
            C((GuildPermissionsChangeWrapperMsgIntent) action);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean F() {
        return GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void G() {
        updateUI(new GameQAAioInputUIState.GuildMultiSelectCountChanged(GuildMultiMsgManager.INSTANCE.a().f(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void H(boolean isMultiSelectMode) {
        if (isMultiSelectMode) {
            updateUI(new GameQAAioInputUIState.GuildMultiSelectCountChanged(GuildMultiMsgManager.INSTANCE.a().f(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())))));
        }
        GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
        AIOContact aIOContact = this.mContact;
        AIOContact aIOContact2 = null;
        if (aIOContact == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContact");
            aIOContact = null;
        }
        String f16 = aIOContact.f();
        AIOContact aIOContact3 = this.mContact;
        if (aIOContact3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContact");
            aIOContact3 = null;
        }
        int a16 = fo0.h.a(f16, aIOContact3.j());
        AIOContact aIOContact4 = this.mContact;
        if (aIOContact4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContact");
        } else {
            aIOContact2 = aIOContact4;
        }
        updateUI(new GameQAAioInputUIState.GuildMultiSelectModeChanged(isMultiSelectMode, com.tencent.guild.aio.util.ex.a.a((com.tencent.aio.api.runtime.a) getMContext()), companion.a(a16, aIOContact2.f())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k I(MsgIntent i3) {
        if (i3 instanceof GuildAioInputMsgIntent.GetInputEditTextEventR) {
            return u();
        }
        return pn0.b.f426490a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void J() {
        if (zp0.b.x(zp0.b.f452962a, (com.tencent.aio.api.runtime.a) getMContext(), 0, 2, null)) {
            p();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void K(List<sr0.b> elements) {
        if (elements.isEmpty()) {
            return;
        }
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(SendMsgInterceptUtil.b(SendMsgInterceptUtil.f112285a, new com.tencent.aio.msgservice.k(((com.tencent.aio.api.runtime.a) getMContext()).g().r(), elements), (com.tencent.aio.api.runtime.a) getMContext(), null, 4, null), new GameQAAioInputViewModel$sendMsg$1(this, null)), Dispatchers.getMain()), vmScope());
    }

    private final void L(e.InputSendMultiTextIntent intent) {
        K(lp0.a.f415333a.e(intent));
    }

    private final void M(e.InputSendTextIntent intent) {
        K(lp0.a.f415333a.f(intent));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p() {
        GuildMultiMsgManager.INSTANCE.a().n(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())), false);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMultiSelectModeChangeEvent("GameQAAioInputViewModel", false));
        H(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        updateUI(GameQAAioInputUIState.GuideClearEditInput.f212329d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r() {
        List<GuildMsgItem> g16 = GuildMultiMsgManager.INSTANCE.a().g(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())));
        if (g16.isEmpty()) {
            QQToast.makeText(((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity(), R.string.f139010a4, 0).show();
        } else {
            zp0.b.f452962a.t((com.tencent.aio.api.runtime.a) getMContext(), g16);
            p();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s(GuildChatActivityAbility.ActivityResultIntent action) {
        if (action.getResultCode() == -1 && action.getData() != null) {
            if ((action.getRequestCode() == 10025 || action.getRequestCode() == 10022 || action.getRequestCode() == 10023) && (((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity() instanceof QBaseActivity)) {
                FragmentActivity activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
                ((IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class)).getStrategyDialogFragment((QBaseActivity) activity).onActivityResult(action.getRequestCode(), action.getResultCode(), action.getData());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t(GuildMsgItem msgItem) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgNavigateEvent.GuildNavigateToMsgEvent("GameQAAioInputViewModel", msgItem.getMsgSeq()));
    }

    private final com.tencent.mvi.base.route.k u() {
        p.a aVar = new p.a(null);
        fetchVBState(aVar);
        if (aVar.getEditText() != null) {
            EditText editText = aVar.getEditText();
            Intrinsics.checkNotNull(editText);
            return new a.C10677a(editText);
        }
        return pn0.b.f426490a;
    }

    private final void v(GuildMsgItem msgItem) {
        updateUI(new GameQAAioInputUIState.GuildInputInsertAt(msgItem));
    }

    private final void w(final MsgRecord msgItem) {
        updateUI(new GameQAAioInputUIState.GuideInputRecallMsg(msgItem));
        ((IMsgService) QRoute.api(IMsgService.class)).reeditRecallMsg(new Contact(msgItem.chatType, msgItem.peerUid, msgItem.guildId), msgItem.msgId, new IOperateCallback() { // from class: com.tencent.mobileqq.gamecenter.qa.aio.input.q
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                GameQAAioInputViewModel.x(GameQAAioInputViewModel.this, msgItem, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(GameQAAioInputViewModel this$0, MsgRecord msgItem, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        QLog.i("GameQAAioInputViewModel", 4, "handleReeditRecallMsg result:" + i3 + ", errMsg:" + str);
        if (y.b(i3)) {
            this$0.D(msgItem);
        }
    }

    private final void y(com.tencent.aio.data.msglist.a msgItem) {
        updateUI(new GameQAAioInputUIState.GuideInputReplyMsg(msgItem, !msgItem.isSelf()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        if (!com.tencent.guild.aio.util.ex.a.a((com.tencent.aio.api.runtime.a) getMContext()) && F()) {
            p();
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class).getQualifiedName(), this.mAction1);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GameQAMsgIntent.SessionInfoChange.class).getQualifiedName(), this.mAction1);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.MsgOnClickReplyEvent.class).getQualifiedName(), this.mAction1);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction1);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectCountChangeEvent.class).getQualifiedName(), this.mAction1);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), this.mAction1);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildBubbleAvatarLongClickEvent.class).getQualifiedName(), this.mAction1);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.MsgOnClickRecallMsgsEvent.class).getQualifiedName(), this.mAction1);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildPermissionsChangeWrapperMsgIntent.class).getQualifiedName(), this.mAction1);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().a(Reflection.getOrCreateKotlinClass(GuildAioInputMsgIntent.GetInputEditTextEventR.class).getQualifiedName());
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.a.class).c(this);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildChatActivityAbility.ActivityResultIntent.class).getQualifiedName(), this.msgSendAction);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull fo0.e intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof e.InputSendTextIntent) {
            M((e.InputSendTextIntent) intent);
            return;
        }
        if (intent instanceof e.InputSendMultiTextIntent) {
            L((e.InputSendMultiTextIntent) intent);
            return;
        }
        if (intent instanceof e.c) {
            t(((e.c) intent).getMsgItem());
        } else if (intent instanceof e.j) {
            J();
        } else if (intent instanceof e.h) {
            r();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        this.mContact = context.g().r().c();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class).getQualifiedName(), this.mAction1);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GameQAMsgIntent.SessionInfoChange.class).getQualifiedName(), this.mAction1);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.MsgOnClickReplyEvent.class).getQualifiedName(), this.mAction1);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction1);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectCountChangeEvent.class).getQualifiedName(), this.mAction1);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), this.mAction1);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildBubbleAvatarLongClickEvent.class).getQualifiedName(), this.mAction1);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.MsgOnClickRecallMsgsEvent.class).getQualifiedName(), this.mAction1);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildPermissionsChangeWrapperMsgIntent.class).getQualifiedName(), this.mAction1);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().j(Reflection.getOrCreateKotlinClass(GuildAioInputMsgIntent.GetInputEditTextEventR.class).getQualifiedName(), this.mActionR);
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.a.class).a(this);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildChatActivityAbility.ActivityResultIntent.class).getQualifiedName(), this.msgSendAction);
    }
}
