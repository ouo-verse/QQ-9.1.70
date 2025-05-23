package com.tencent.robot.aio.input.inputbar.interceptor;

import android.os.Bundle;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.msgservice.k;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IMsgSendHelper;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.api.ag;
import com.tencent.qqnt.kernel.api.m;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IAddFriendCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.RobotAddFriendRequest;
import com.tencent.qqnt.kernel.nativeinterface.RobotAddFriendResponse;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.f;
import com.tencent.robot.relation.api.IRobotRelationService;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import l24.e;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 52\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J2\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J8\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00042\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J.\u0010#\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0!H\u0002J\u0010\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$H\u0002J\u0010\u0010(\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\u0018\u0010)\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010+\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020'2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010-\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020'2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010/\u001a\u00020.2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0018\u00102\u001a\u00020'2\u0006\u0010 \u001a\u00020\u001f2\u0006\u00101\u001a\u000200H\u0016\u00a8\u00067"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/interceptor/RobotAIOSendMsgInterceptor;", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/a;", "Lcom/tencent/aio/data/AIOSession;", "aioSession", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "k", "Lcom/tencent/mvi/base/route/j;", "messenger", "", "msgId", "Lcom/tencent/aio/msgservice/k;", "sendMsgsReq", "Landroid/os/Bundle;", "extData", "", DomainData.DOMAIN_NAME, "contact", "", "result", "", "errMsg", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "peer", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "msgElements", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/c;", "paramWrapper", "i", "oldMsgId", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlin/Function0;", "afterAddFriend", "g", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "o", "", "l", "e", "success", "reportAfterKernelSend", "isOriginBuddy", "reportBeforeKernelSend", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/d;", "intercept", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "interceptResend", "<init>", "()V", "d", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotAIOSendMsgInterceptor implements com.tencent.qqnt.aio.interceptor.sendmsg.a {
    private final void e(Contact peer, String errMsg) {
        String str = peer.peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "peer.peerUid");
        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(str, peer.chatType, 2201L, 0, false, false, null, 120, null);
        LocalGrayTip.LocalGrayTipBuilder.i(localGrayTipBuilder, errMsg, 0, 2, null);
        LocalGrayTip m3 = localGrayTipBuilder.m();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((INtGrayTipApi) QRoute.api(INtGrayTipApi.class)).addLocalGrayTip(peekAppRuntime, m3, new IAddJsonGrayTipMsgCallback() { // from class: com.tencent.robot.aio.input.inputbar.interceptor.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback
                public final void onResult(int i3, long j3) {
                    RobotAIOSendMsgInterceptor.f(i3, j3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(int i3, long j3) {
        QLog.d("RobotAIOSendMsgInterceptor", 1, "addLocalGrayTip result=" + i3);
    }

    private final void g(final long oldMsgId, final com.tencent.aio.api.runtime.a aioContext, final Contact peer, final Function0<Unit> afterAddFriend) {
        boolean z16;
        IRuntimeService iRuntimeService;
        RobotAddFriendRequest robotAddFriendRequest = new RobotAddFriendRequest();
        String str = peer.peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "peer.peerUid");
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            robotAddFriendRequest.robotUid = peer.peerUid;
        } else {
            AIOParam g16 = aioContext.g();
            Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
            robotAddFriendRequest.robotUin = o(g16);
        }
        QLog.d("RobotAIOSendMsgInterceptor", 1, "[addFriend] req=" + robotAddFriendRequest);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Unit unit = null;
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
        } else {
            iRuntimeService = null;
        }
        IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
        if (iRobotRelationService != null) {
            String valueOf = String.valueOf(robotAddFriendRequest.robotUin);
            String str2 = robotAddFriendRequest.robotUid;
            Intrinsics.checkNotNullExpressionValue(str2, "robot.robotUid");
            iRobotRelationService.addRobotFriend(valueOf, str2, new IAddFriendCallback() { // from class: com.tencent.robot.aio.input.inputbar.interceptor.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAddFriendCallback
                public final void onResult(int i3, String str3, RobotAddFriendResponse robotAddFriendResponse) {
                    RobotAIOSendMsgInterceptor.h(Function0.this, this, oldMsgId, peer, aioContext, i3, str3, robotAddFriendResponse);
                }
            });
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            j e16 = aioContext.e();
            Intrinsics.checkNotNullExpressionValue(e16, "aioContext.messenger");
            m(oldMsgId, peer, e16, -1, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function0 afterAddFriend, RobotAIOSendMsgInterceptor this$0, long j3, Contact peer, com.tencent.aio.api.runtime.a aioContext, int i3, String str, RobotAddFriendResponse robotAddFriendResponse) {
        Intrinsics.checkNotNullParameter(afterAddFriend, "$afterAddFriend");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(peer, "$peer");
        Intrinsics.checkNotNullParameter(aioContext, "$aioContext");
        QLog.d("RobotAIOSendMsgInterceptor", 1, "[addFriend] res=" + i3 + ", errMsg=" + str + ", robotUid=" + robotAddFriendResponse.robotUid);
        if (i3 == 0) {
            afterAddFriend.invoke();
            return;
        }
        if (i3 == 1002) {
            str = "";
        } else if (i3 <= 1000) {
            str = HardCodeUtil.qqStr(R.string.f223106fb);
        }
        j e16 = aioContext.e();
        Intrinsics.checkNotNullExpressionValue(e16, "aioContext.messenger");
        this$0.m(j3, peer, e16, i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(final long msgId, final Contact peer, ArrayList<MsgElement> msgElements, final com.tencent.qqnt.aio.interceptor.sendmsg.c paramWrapper) {
        reportBeforeKernelSend(false, msgId);
        w e16 = f.e();
        if (e16 != null) {
            e16.F(msgId, peer, msgElements, new IOperateCallback() { // from class: com.tencent.robot.aio.input.inputbar.interceptor.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotAIOSendMsgInterceptor.j(RobotAIOSendMsgInterceptor.this, msgId, paramWrapper, peer, i3, str);
                }
            });
        }
        paramWrapper.a().e().h(AIOMsgSendEvent.AfterSendMsg.f188416d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(RobotAIOSendMsgInterceptor this$0, long j3, com.tencent.qqnt.aio.interceptor.sendmsg.c paramWrapper, Contact peer, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(paramWrapper, "$paramWrapper");
        Intrinsics.checkNotNullParameter(peer, "$peer");
        boolean z16 = true;
        QLog.d("RobotAIOSendMsgInterceptor", 1, "[sendMsg] after addFriend result=" + i3 + ", errMsg=" + str);
        if (i3 != 0) {
            z16 = false;
        }
        this$0.reportAfterKernelSend(z16, j3);
        if (i3 == 0) {
            j e16 = paramWrapper.a().e();
            Intrinsics.checkNotNullExpressionValue(e16, "paramWrapper.aioContext.messenger");
            this$0.n(e16, j3, paramWrapper.d(), paramWrapper.b());
        } else {
            j e17 = paramWrapper.a().e();
            Intrinsics.checkNotNullExpressionValue(e17, "paramWrapper.aioContext.messenger");
            this$0.m(j3, peer, e17, i3, str);
        }
    }

    private final Contact k(AIOSession aioSession) {
        return new Contact(aioSession.c().e(), aioSession.c().j(), aioSession.c().f());
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean l(Contact peer) {
        boolean z16;
        m b16 = f.b();
        if (b16 != null) {
            String str = peer.peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "peer.peerUid");
            Boolean isBuddy = b16.isBuddy(str);
            if (isBuddy != null) {
                z16 = isBuddy.booleanValue();
                if (QLog.isColorLevel()) {
                    QLog.d("RobotAIOSendMsgInterceptor", 1, "isBuddy robot result = " + z16);
                }
                return z16;
            }
        }
        z16 = false;
        if (QLog.isColorLevel()) {
        }
        return z16;
    }

    private final void m(long msgId, Contact contact, j messenger, int result, String errMsg) {
        boolean z16;
        if (QLog.isDevelopLevel()) {
            QLog.d("RobotAIOSendMsgInterceptor", 4, "[sendMsgSentFailEvent] res=" + result + ", errMsg=" + errMsg);
        }
        w e16 = f.e();
        if (e16 != null) {
            String str = contact.peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "contact.peerUid");
            e16.cancelSendMsg(msgId, str, contact.chatType);
        }
        messenger.h(new AIOMsgSendEvent.OnMsgSendFailEvent(result, errMsg));
        if (errMsg != null && errMsg.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            e(contact, errMsg);
        }
    }

    private final void n(j messenger, long msgId, k sendMsgsReq, Bundle extData) {
        CharSequence charSequence;
        if (extData != null) {
            charSequence = extData.getCharSequence("input_text");
        } else {
            charSequence = null;
        }
        messenger.h(new AIOMsgSendEvent.OnMsgSendSuccessEvent(msgId, sendMsgsReq, charSequence, extData));
    }

    private final long o(AIOParam aioParam) {
        Long l3;
        Long valueOf = Long.valueOf(aioParam.l().getLong("key_peerUin"));
        if (valueOf.longValue() == 0) {
            ag l16 = f.l();
            if (l16 != null) {
                l3 = l16.z0(aioParam.r().c().j());
            } else {
                l3 = null;
            }
            valueOf = l3;
            if (QLog.isDevelopLevel()) {
                QLog.d("RobotAIOSendMsgInterceptor", 4, "[addFriend] tryGetUin to use uid to uin. uin=" + valueOf);
            }
        }
        if (valueOf == null) {
            return 0L;
        }
        return valueOf.longValue();
    }

    @Override // com.tencent.qqnt.aio.interceptor.sendmsg.a
    @NotNull
    public com.tencent.qqnt.aio.interceptor.sendmsg.d intercept(@NotNull final com.tencent.qqnt.aio.interceptor.sendmsg.c paramWrapper) {
        long j3;
        Long j06;
        Intrinsics.checkNotNullParameter(paramWrapper, "paramWrapper");
        final Contact k3 = k(paramWrapper.d().a());
        boolean z16 = !l(k3);
        if (QLog.isDevelopLevel()) {
            QLog.d("RobotAIOSendMsgInterceptor", 4, "[intercept] needIntercept=" + z16 + ", uid=" + k3.peerUid);
        }
        if (z16) {
            final Ref.LongRef longRef = new Ref.LongRef();
            Bundle b16 = paramWrapper.b();
            long j16 = 0;
            if (b16 != null) {
                j3 = b16.getLong("msg_id");
            } else {
                j3 = 0;
            }
            longRef.element = j3;
            if (j3 == 0) {
                w e16 = f.e();
                if (e16 != null && (j06 = e16.j0(k3.chatType)) != null) {
                    j16 = j06.longValue();
                }
                longRef.element = j16;
            }
            QLog.d("RobotAIOSendMsgInterceptor", 1, "[intercept] is not buddy, need add before send, msgId=" + longRef.element);
            e.f413735a.m("send_btn_click", longRef.element);
            final ArrayList<MsgElement> transformAioMsgToElements = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).transformAioMsgToElements(paramWrapper.d().b());
            Iterator<T> it = transformAioMsgToElements.iterator();
            boolean z17 = false;
            while (it.hasNext()) {
                if (((MsgElement) it.next()).elementType == 5) {
                    z17 = true;
                }
            }
            if (z17) {
                g(longRef.element, paramWrapper.a(), k3, new Function0<Unit>() { // from class: com.tencent.robot.aio.input.inputbar.interceptor.RobotAIOSendMsgInterceptor$intercept$2
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
                        w e17 = f.e();
                        if (e17 != null) {
                            e17.o0(Ref.LongRef.this.element, k3, transformAioMsgToElements);
                        }
                    }
                });
            } else {
                w e17 = f.e();
                if (e17 != null) {
                    e17.o0(longRef.element, k3, transformAioMsgToElements);
                }
                g(longRef.element, paramWrapper.a(), k3, new Function0<Unit>() { // from class: com.tencent.robot.aio.input.inputbar.interceptor.RobotAIOSendMsgInterceptor$intercept$3
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
                        RobotAIOSendMsgInterceptor.this.i(longRef.element, k3, transformAioMsgToElements, paramWrapper);
                    }
                });
            }
        }
        return new com.tencent.qqnt.aio.interceptor.sendmsg.d(z16, true);
    }

    @Override // com.tencent.qqnt.aio.interceptor.sendmsg.a
    public boolean interceptResend(@NotNull final com.tencent.aio.api.runtime.a aioContext, @NotNull final com.tencent.aio.data.msglist.a msgItem) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Contact k3 = k(aioContext.g().r());
        boolean z16 = !l(k3);
        if (QLog.isDevelopLevel()) {
            QLog.d("RobotAIOSendMsgInterceptor", 4, "[interceptResend] needIntercept=" + z16 + ", uid=" + k3.peerUid);
        }
        if (z16) {
            g(msgItem.getMsgId(), aioContext, k3, new Function0<Unit>() { // from class: com.tencent.robot.aio.input.inputbar.interceptor.RobotAIOSendMsgInterceptor$interceptResend$1
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
                    ((IMsgSendHelper) QRoute.api(IMsgSendHelper.class)).reSendMsg(com.tencent.aio.api.runtime.a.this, msgItem);
                }
            });
        }
        return z16;
    }

    @Override // com.tencent.qqnt.aio.interceptor.sendmsg.a
    public void reportAfterKernelSend(boolean success, long msgId) {
        if (success) {
            e.f413735a.m("kernel_msg_resp", msgId);
            return;
        }
        e eVar = e.f413735a;
        eVar.m("kernel_msg_resp", msgId);
        eVar.i("robot_msg_receive", "4");
    }

    @Override // com.tencent.qqnt.aio.interceptor.sendmsg.a
    public void reportBeforeKernelSend(boolean isOriginBuddy, long msgId) {
        if (isOriginBuddy) {
            e.f413735a.m("send_btn_click", msgId);
        }
        e.f413735a.m("kernel_msg_send", msgId);
    }
}
