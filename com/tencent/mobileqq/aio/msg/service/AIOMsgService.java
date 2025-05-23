package com.tencent.mobileqq.aio.msg.service;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.report.AIOMsgSendResultReport;
import com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoSendingManager;
import com.tencent.mobileqq.aio.utils.AIOObjectTransform;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.IForwardOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetMsgsBoxesCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RevealAuthorityReq;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b;\u0010<J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00060\u000bH\u0016J\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00060\u000bJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bJ\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016JF\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\"\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017j\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019`\u001aJ\u000e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012J\u001a\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u000b2\u0006\u0010\u0013\u001a\u00020\u001eJ\u001a\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u000b2\u0006\u0010\u0013\u001a\u00020 J\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u000bJ\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u000bJ\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\u000bJ\u0012\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00060\u000bJ\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00060\u000bJ&\u0010.\u001a\u00020\t2\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00020)j\b\u0012\u0004\u0012\u00020\u0002`*2\u0006\u0010-\u001a\u00020,J\u001c\u00101\u001a\b\u0012\u0004\u0012\u0002000\u000b2\u0006\u0010/\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u00103\u001a\b\u0012\u0004\u0012\u0002020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u00106\u001a\b\u0012\u0004\u0012\u0002050\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u000204J*\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e090\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0004\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/aio/msg/service/AIOMsgService;", "Lcom/tencent/aio/msgservice/a;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "", "msgId", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElements", "", "l", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/aio/data/msglist/a;", "o", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "p", "v", "w", "Lcom/tencent/aio/msgservice/k;", "req", "Lcom/tencent/aio/msgservice/j;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAttributeInfo;", "Lkotlin/collections/HashMap;", "msgAttrs", HippyTKDListViewAdapter.X, "d", "Lcom/tencent/mobileqq/aio/msg/service/u;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/msg/service/s;", "g", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", ReportConstant.COSTREPORT_PREFIX, "u", "t", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "contacts", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgsBoxesCallback;", "cb", "i", "contact", "Lcom/tencent/mobileqq/aio/msg/service/q;", "f", "Lcom/tencent/mobileqq/aio/msg/service/n;", "j", "Lcom/tencent/qqnt/kernel/nativeinterface/RevealAuthorityReq;", "Lcom/tencent/mobileqq/aio/msg/service/t;", "e", "rootMsgId", "replyMsgId", "Lcom/tencent/aio/msgservice/h;", "k", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOMsgService extends com.tencent.aio.msgservice.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AIOMsgService f190196a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57586);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
            return;
        }
        f190196a = new AIOMsgService();
        AIOVideoSendingManager.INSTANCE.e();
        AIOMsgSendResultReport.INSTANCE.a();
    }

    AIOMsgService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Contact peer, s req, Ref.ObjectRef sendMsgsCB, int i3, String str, HashMap hashMap) {
        boolean z16;
        Intrinsics.checkNotNullParameter(peer, "$peer");
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(sendMsgsCB, "$sendMsgsCB");
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("AIOMsgService", 1, "[forwardMsgs]: success is " + z16 + ", errMsg is " + str + ", srcContact is " + peer + ", dstContact is " + req.c());
        Function1 function1 = (Function1) sendMsgsCB.element;
        if (function1 != null) {
            function1.invoke(new com.tencent.aio.msgservice.j(z16, i3, str, ""));
        }
    }

    private final void l(Contact peer, long msgId, List<MsgElement> msgElements) {
        Object first;
        if (!msgElements.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) msgElements);
            QLog.i("AIOMsgService", 1, "[sendMsgWithMsgId] peer=" + peer + " msgId=" + msgId + " elementType=" + ((MsgElement) first).elementType);
            return;
        }
        QLog.w("AIOMsgService", 1, "[sendMsgWithMsgId] elements is empty, peer=" + peer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Contact peer, u req, Ref.ObjectRef sendMsgsCB, int i3, String str) {
        boolean z16;
        Intrinsics.checkNotNullParameter(peer, "$peer");
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(sendMsgsCB, "$sendMsgsCB");
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("AIOMsgService", 1, "[multiForwardMsgs]: success is " + z16 + ", errMsg is " + str + ", srcContact is " + peer + ", dstContact is " + req.c());
        Function1 function1 = (Function1) sendMsgsCB.element;
        if (function1 != null) {
            function1.invoke(new com.tencent.aio.msgservice.j(z16, i3, str, ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(long j3, Ref.ObjectRef sendMsgsCB, int i3, String str) {
        Intrinsics.checkNotNullParameter(sendMsgsCB, "$sendMsgsCB");
        boolean z16 = true;
        QLog.i("AIOMsgService", 1, "[sendMsgWithMsgId] msgId=" + j3 + " result=" + i3 + " msg=" + str);
        Function1 function1 = (Function1) sendMsgsCB.element;
        if (function1 != null) {
            if (i3 != 0) {
                z16 = false;
            }
            function1.invoke(new com.tencent.aio.msgservice.j(z16, i3, str, ""));
        }
    }

    public final void d(@NotNull com.tencent.aio.msgservice.k req) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) req);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Contact h16 = AIOUtil.f194084a.h(req.a());
        AIOObjectTransform aIOObjectTransform = AIOObjectTransform.f194080a;
        List<Object> b16 = req.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.mobileqq.aio.msg.data.AIOMsgElement>");
        ArrayList<MsgElement> m3 = AIOObjectTransform.m(aIOObjectTransform, b16, 0, 2, null);
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            Long j06 = e16.j0(h16.chatType);
            if (j06 != null) {
                j3 = j06.longValue();
            } else {
                j3 = 0;
            }
            e16.o0(j3, h16, m3);
        }
    }

    @NotNull
    public final Flow<t> e(long msgId, @NotNull RevealAuthorityReq req) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (Flow) iPatchRedirector.redirect((short) 27, this, Long.valueOf(msgId), req);
        }
        Intrinsics.checkNotNullParameter(req, "req");
        return FlowKt.callbackFlow(new AIOMsgService$authorityTofu$1(req, msgId, null));
    }

    @NotNull
    public final Flow<q> f(@NotNull Contact contact, long msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (Flow) iPatchRedirector.redirect((short) 25, this, contact, Long.valueOf(msgId));
        }
        Intrinsics.checkNotNullParameter(contact, "contact");
        return FlowKt.callbackFlow(new AIOMsgService$fetchLongMsg$1(contact, msgId, null));
    }

    @NotNull
    public final Flow<com.tencent.aio.msgservice.j<String>> g(@NotNull final s req) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Flow) iPatchRedirector.redirect((short) 18, (Object) this, (Object) req);
        }
        Intrinsics.checkNotNullParameter(req, "req");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Contact h16 = AIOUtil.f194084a.h(req.a());
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.forwardMsg(req.d(), h16, req.c(), req.b(), new IForwardOperateCallback() { // from class: com.tencent.mobileqq.aio.msg.service.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IForwardOperateCallback
                public final void onResult(int i3, String str, HashMap hashMap) {
                    AIOMsgService.h(Contact.this, req, objectRef, i3, str, hashMap);
                }
            });
        }
        return FlowKt.callbackFlow(new AIOMsgService$forwardMsgs$2(objectRef, null));
    }

    public final void i(@NotNull ArrayList<Contact> contacts, @NotNull IGetMsgsBoxesCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) contacts, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(contacts, "contacts");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ((IMsgService) QRoute.api(IMsgService.class)).getABatchOfContactMsgBoxInfo(contacts, cb5);
    }

    @NotNull
    public final Flow<n> j(@NotNull Contact peer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (Flow) iPatchRedirector.redirect((short) 26, (Object) this, (Object) peer);
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        return FlowKt.callbackFlow(new AIOMsgService$getFirstUnreadMsgSeq$1(peer, null));
    }

    @NotNull
    public final Flow<com.tencent.aio.msgservice.h<MsgRecord>> k(@NotNull Contact peer, long rootMsgId, long replyMsgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (Flow) iPatchRedirector.redirect((short) 28, this, peer, Long.valueOf(rootMsgId), Long.valueOf(replyMsgId));
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        return FlowKt.callbackFlow(new AIOMsgService$getSourceOfReplyMsgV2$1(peer, rootMsgId, replyMsgId, null));
    }

    @NotNull
    public final Flow<com.tencent.aio.msgservice.j<String>> m(@NotNull final u req) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Flow) iPatchRedirector.redirect((short) 17, (Object) this, (Object) req);
        }
        Intrinsics.checkNotNullParameter(req, "req");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Contact h16 = AIOUtil.f194084a.h(req.a());
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.t0(req.d(), h16, req.c(), req.b(), new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msg.service.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    AIOMsgService.n(Contact.this, req, objectRef, i3, str);
                }
            });
        }
        return FlowKt.callbackFlow(new AIOMsgService$multiForwardMsgs$2(objectRef, null));
    }

    @NotNull
    public Flow<List<com.tencent.aio.data.msglist.a>> o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Flow) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return new AIOMsgServiceWithContext(null).q();
    }

    @NotNull
    public final Flow<List<MsgRecord>> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Flow) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return FlowKt.flow(new AIOMsgService$receiveMsgRecordNotificationFlow$$inlined$transform$1(((IMsgService) QRoute.api(IMsgService.class)).registerReceiveMsgNotificationFlow(), null));
    }

    @NotNull
    public final Flow<List<MsgRecord>> q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Flow) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return FlowKt.flow(new AIOMsgService$registerMsgRecordStatusUpdateNotificationFlow$$inlined$transform$1(((IMsgService) QRoute.api(IMsgService.class)).registerMsgStatusUpdateNotificationFlow(), null));
    }

    @NotNull
    public final Flow<List<AIOMsgItem>> r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Flow) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return new AIOMsgServiceWithContext(null).r();
    }

    @NotNull
    public final Flow<FileTransNotifyInfo> s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Flow) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return ((IMsgService) QRoute.api(IMsgService.class)).registerRichMediaDownloadCompleteFlow();
    }

    @NotNull
    public final Flow<FileTransNotifyInfo> t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Flow) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return ((IMsgService) QRoute.api(IMsgService.class)).registerRichMediaDownloadProgressFlow();
    }

    @NotNull
    public final Flow<FileTransNotifyInfo> u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Flow) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return ((IMsgService) QRoute.api(IMsgService.class)).registerRichMediaUploadCompleteFlow();
    }

    @NotNull
    public Flow<com.tencent.aio.data.msglist.a> v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Flow) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return new AIOMsgServiceWithContext(null).t();
    }

    @NotNull
    public final Flow<MsgRecord> w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Flow) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return FlowKt.flow(new AIOMsgService$sendMsgRecordNotificationFlow$$inlined$transform$1(((IMsgService) QRoute.api(IMsgService.class)).registerSendMsgNotificationFlow(), null));
    }

    @NotNull
    public final Flow<com.tencent.aio.msgservice.j<String>> x(@NotNull com.tencent.aio.msgservice.k req, final long msgId, @NotNull HashMap<Integer, MsgAttributeInfo> msgAttrs) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Flow) iPatchRedirector.redirect((short) 15, this, req, Long.valueOf(msgId), msgAttrs);
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(msgAttrs, "msgAttrs");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Contact h16 = AIOUtil.f194084a.h(req.a());
        AIOObjectTransform aIOObjectTransform = AIOObjectTransform.f194080a;
        List<Object> b16 = req.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.mobileqq.aio.msg.data.AIOMsgElement>");
        ArrayList<MsgElement> m3 = AIOObjectTransform.m(aIOObjectTransform, b16, 0, 2, null);
        l(h16, msgId, m3);
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.sendMsg(msgId, h16, m3, msgAttrs, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msg.service.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    AIOMsgService.y(msgId, objectRef, i3, str);
                }
            });
        }
        return FlowKt.callbackFlow(new AIOMsgService$sendMsgWithMsgId$2(objectRef, null));
    }

    @NotNull
    public Flow<com.tencent.aio.msgservice.j<String>> z(@NotNull com.tencent.aio.msgservice.k req) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Flow) iPatchRedirector.redirect((short) 14, (Object) this, (Object) req);
        }
        Intrinsics.checkNotNullParameter(req, "req");
        return x(req, 0L, new HashMap<>());
    }
}
