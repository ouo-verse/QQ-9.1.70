package com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service.InteractiveMsgServicePB$GetUnReadMsgCntReq;
import com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service.InteractiveMsgServicePB$GetUnReadMsgCntRsp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0004J\u001a\u0010\r\u001a\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/q;", "", "", "f", "", "unread", "g", "", "notifyUI", "e", "d", "Lkotlin/Function1;", "cb", "b", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f244623a = new q();

    q() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(int i3, boolean z16, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d("QQStrangerLiteActionUnreadHelper", 2, "[SsoUnreadMsgCntSvr] isSuccess=" + z16);
        }
        if (z16 && (obj instanceof byte[])) {
            InteractiveMsgServicePB$GetUnReadMsgCntRsp interactiveMsgServicePB$GetUnReadMsgCntRsp = new InteractiveMsgServicePB$GetUnReadMsgCntRsp();
            try {
                interactiveMsgServicePB$GetUnReadMsgCntRsp.mergeFrom((byte[]) obj);
                if (interactiveMsgServicePB$GetUnReadMsgCntRsp.rsp_head.ret_code.get() != 0) {
                    return;
                }
                int i16 = interactiveMsgServicePB$GetUnReadMsgCntRsp.unread_msg_cnt.get();
                QLog.i("QQStrangerLiteActionUnreadHelper", 1, "[SsoUnreadMsgCntSvr] unread=" + i16);
                com.tencent.mobileqq.matchfriend.reborn.utils.h.v(i16);
                f244623a.f();
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQStrangerLiteActionUnreadHelper", 2, "[SsoUnreadMsgCntSvr] error: ", e16);
            }
        }
    }

    private final void f() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4).notifyUI(14, true, null);
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerLiteActionUnreadUpdateEvent());
    }

    public final void b(Function1<? super Integer, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        String j3 = com.tencent.mobileqq.matchfriend.utils.b.d().j();
        if (j3 == null) {
            j3 = "";
        }
        Object businessHandler = appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
        com.tencent.relation.common.servlet.a aVar = (com.tencent.relation.common.servlet.a) businessHandler;
        InteractiveMsgServicePB$GetUnReadMsgCntReq interactiveMsgServicePB$GetUnReadMsgCntReq = new InteractiveMsgServicePB$GetUnReadMsgCntReq();
        if (j3.length() > 0) {
            interactiveMsgServicePB$GetUnReadMsgCntReq.open_id.set(j3);
        }
        aVar.Z0("trpc.kuolie.interactive_msg.UnreadMsgCntSvr.SsoUnreadMsgCntSvr", interactiveMsgServicePB$GetUnReadMsgCntReq.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.p
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                q.c(i3, z16, obj);
            }
        });
    }

    public final int d() {
        return com.tencent.mobileqq.matchfriend.reborn.utils.h.d();
    }

    public final void g(int unread) {
        com.tencent.mobileqq.matchfriend.reborn.utils.h.v(unread);
        f();
    }

    public final void e(boolean notifyUI) {
        com.tencent.mobileqq.matchfriend.reborn.utils.h.v(0);
        if (notifyUI) {
            f();
        }
    }
}
