package com.tencent.mobileqq.aio.msglist.msgrepo;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.MsgNavigationEvent;
import com.tencent.mobileqq.aio.helper.ae;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext;
import com.tencent.mobileqq.aio.msgbox.event.MsgBoxEvent;
import com.tencent.mobileqq.aio.msglist.AIOMsgRepo;
import com.tencent.mobileqq.aio.msglist.BaseMsgRepo;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.MarkdownMsgItem;
import com.tencent.mobileqq.aio.utils.ac;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.MsgRevokeEvent;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/B\u001f\u0012\u0006\u0010'\u001a\u00020\u0002\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0016\u0010\n\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0016\u0010\u000e\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0016\u0010\u0013\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0002J$\u0010\u0018\u001a\u00020\u00032\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016H\u0002J\u0016\u0010\u001a\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH\u0002J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!H\u0016J\u000e\u0010&\u001a\u00020\u00032\u0006\u0010%\u001a\u00020$\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/MsgNotificationAbility;", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/g;", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;", "", "B", "Lcom/tencent/aio/data/msglist/a;", "msg", "v", "", TabPreloadItem.TAB_NAME_MESSAGE, "E", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioMsgItem", BdhLogUtil.LogTag.Tag_Conn, "receivedMsg", "D", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "msgIdList", "y", "notifyMsgList", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "msgItem", "oldItem", "t", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "g", "Lcom/tencent/mobileqq/aio/msg/service/AIOMsgServiceWithContext;", "aioMsgService", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernel/data/a;", "recentContactNotification", "u", "msgRepo", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "i", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class MsgNotificationAbility extends g<AIOMsgRepo> {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/MsgNotificationAbility$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.msgrepo.MsgNotificationAbility$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64206);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgNotificationAbility(@NotNull AIOMsgRepo msgRepo, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(msgRepo, aioContext, scope);
        Intrinsics.checkNotNullParameter(msgRepo, "msgRepo");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgRepo, aioContext, scope);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(List<? extends AIOMsgItem> notifyMsgList) {
        String str;
        Iterator it;
        boolean z16;
        Iterator<com.tencent.aio.data.msglist.a> it5;
        int i3;
        int i16;
        ArrayList arrayListOf;
        String j3 = d().g().r().c().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : notifyMsgList) {
            if (Intrinsics.areEqual(((AIOMsgItem) obj).getMsgRecord().peerUid, j3)) {
                arrayList.add(obj);
            }
        }
        boolean z17 = true;
        if (!(!arrayList.isEmpty())) {
            arrayList = null;
        }
        if (arrayList != null) {
            MsgList M = e().M();
            Iterator it6 = arrayList.iterator();
            boolean z18 = false;
            boolean z19 = false;
            while (it6.hasNext()) {
                AIOMsgItem aIOMsgItem = (AIOMsgItem) it6.next();
                if (com.tencent.mobileqq.aio.utils.d.Q(aIOMsgItem)) {
                    SimpleEventBus.getInstance().dispatchEvent(new MsgRevokeEvent(j3, aIOMsgItem.getMsgId()));
                    d().e().h(new AIOMsgSendEvent.MsgOnRevokeEvent(aIOMsgItem.getMsgSeq(), aIOMsgItem.getMsgId()));
                }
                Iterator<com.tencent.aio.data.msglist.a> it7 = M.iterator();
                int i17 = 0;
                while (it7.hasNext()) {
                    com.tencent.aio.data.msglist.a next = it7.next();
                    int i18 = i17 + 1;
                    if (i17 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    com.tencent.aio.data.msglist.a oldItem = next;
                    if (aIOMsgItem.getMsgId() == oldItem.getMsgId()) {
                        str = j3;
                        it = it6;
                        it5 = it7;
                        int i19 = i17;
                        boolean z26 = z19;
                        i3 = i18;
                        QLog.d("AIOMsgListVM", 1, "onMsgStatusUpdateNotificationFlow update msgItem,  msgTime is " + aIOMsgItem.getMsgRecord().msgTime + ", msgId=" + aIOMsgItem.getMsgId() + ", status=" + aIOMsgItem.getMsgRecord().sendStatus + ", msgType is" + aIOMsgItem.getMsgRecord().msgType + ", msgItem is " + System.identityHashCode(M.get(i17)) + ", seq=" + aIOMsgItem.getMsgSeq() + " stream=" + com.tencent.qqnt.aio.msg.d.g(aIOMsgItem));
                        AIOMsgRepo e16 = e();
                        Intrinsics.checkNotNullExpressionValue(oldItem, "oldItem");
                        e16.q0(aIOMsgItem, oldItem);
                        AIOMsgItem aIOMsgItem2 = (AIOMsgItem) oldItem;
                        if (aIOMsgItem.getMsgRecord().msgType == aIOMsgItem2.getMsgRecord().msgType) {
                            t(aIOMsgItem, aIOMsgItem2);
                            Unit unit = Unit.INSTANCE;
                            i16 = i19;
                            M.set(i16, (com.tencent.aio.data.msglist.a) aIOMsgItem);
                        } else {
                            i16 = i19;
                            if (aIOMsgItem.getMsgRecord().msgType == 5) {
                                M.set(i16, (com.tencent.aio.data.msglist.a) aIOMsgItem);
                                z19 = ac.f194103a.d(aIOMsgItem);
                                AIOMsgRepo e17 = e();
                                z16 = true;
                                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(M.get(i16));
                                e17.l0(arrayListOf);
                                M.size();
                                z18 = true;
                            } else if (aIOMsgItem2.getMsgRecord().msgType == 12) {
                                M.set(i16, (com.tencent.aio.data.msglist.a) aIOMsgItem);
                                QLog.i("AIOMsgRepo", 1, "[onMsgStatusUpdateNotificationFlow]: oldMsgItem is longMsg");
                            } else if ((oldItem instanceof MarkdownMsgItem) && ((MarkdownMsgItem) oldItem).E2()) {
                                t(aIOMsgItem, aIOMsgItem2);
                                Unit unit2 = Unit.INSTANCE;
                                M.set(i16, (com.tencent.aio.data.msglist.a) aIOMsgItem);
                            } else if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
                                throw new RuntimeException("onMsgStatusUpdateNotificationFlow wrong type\uff1a" + aIOMsgItem.getMsgRecord().msgType);
                            }
                        }
                        z19 = z26;
                        AIOMsgRepo e172 = e();
                        z16 = true;
                        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(M.get(i16));
                        e172.l0(arrayListOf);
                        M.size();
                        z18 = true;
                    } else {
                        str = j3;
                        it = it6;
                        z16 = z17;
                        it5 = it7;
                        i3 = i18;
                    }
                    z17 = z16;
                    j3 = str;
                    it7 = it5;
                    it6 = it;
                    i17 = i3;
                }
            }
            if (z18) {
                BaseMsgRepo.o0(e(), e().M(), "msg_update", IMsgListRepository.MsgListRepoOpType.LoadMessageUpdate, null, 8, null);
            }
            if (z19) {
                ac.f194103a.b(d(), notifyMsgList);
            }
        }
    }

    private final void B() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        aa recentContactService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getRecentContactService();
        if (recentContactService == null || FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(recentContactService.Q(), new MsgNotificationAbility$registerContactNotification$1$1(this, null)), Dispatchers.getMain()), f()) == null) {
            QLog.i("AIOMsgRepo MsgAbility", 1, "[registerContactNotification]: recentService is null");
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C(AIOMsgItem aioMsgItem) {
        aioMsgItem.E1(true);
        if (aioMsgItem instanceof com.tencent.mobileqq.aio.msg.l) {
            ((com.tencent.mobileqq.aio.msg.l) aioMsgItem).b(com.tencent.qqnt.aio.msg.d.M(aioMsgItem));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0027, code lost:
    
        if (r1 < r3.getMsgSeq()) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void D(List<? extends com.tencent.aio.data.msglist.a> receivedMsg) {
        Object first;
        Object last;
        Object last2;
        Object first2;
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.a E = e().E();
        if (E.a() != null) {
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) receivedMsg);
            long msgSeq = ((com.tencent.aio.data.msglist.a) first2).getMsgSeq();
            com.tencent.aio.data.msglist.a a16 = E.a();
            Intrinsics.checkNotNull(a16);
        }
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.a E2 = e().E();
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) receivedMsg);
        E2.f((com.tencent.aio.data.msglist.a) first);
        if (E.c() != null) {
            last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) receivedMsg);
            long msgSeq2 = ((com.tencent.aio.data.msglist.a) last2).getMsgSeq();
            com.tencent.aio.data.msglist.a c16 = E.c();
            Intrinsics.checkNotNull(c16);
            if (msgSeq2 <= c16.getMsgSeq()) {
                return;
            }
        }
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.a E3 = e().E();
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) receivedMsg);
        E3.h((com.tencent.aio.data.msglist.a) last);
    }

    private final void E(List<? extends com.tencent.aio.data.msglist.a> msgList) {
        boolean a16 = ae.INSTANCE.a();
        for (com.tencent.aio.data.msglist.a aVar : msgList) {
            if (aVar instanceof AIOMsgItem) {
                ((AIOMsgItem) aVar).x1(a16);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t(AIOMsgItem msgItem, AIOMsgItem oldItem) {
        if (msgItem instanceof com.tencent.mobileqq.aio.msg.l) {
            com.tencent.mobileqq.aio.msg.l lVar = (com.tencent.mobileqq.aio.msg.l) msgItem;
            lVar.h(true);
            if (com.tencent.qqnt.aio.msg.d.k(msgItem, oldItem)) {
                lVar.e(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(com.tencent.aio.data.msglist.a msg2) {
        List<? extends com.tencent.aio.data.msglist.a> listOf;
        ArrayList arrayListOf;
        String j3 = d().g().r().c().j();
        Intrinsics.checkNotNull(msg2, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
        AIOMsgItem aIOMsgItem = (AIOMsgItem) msg2;
        if (!Intrinsics.areEqual(aIOMsgItem.getMsgRecord().peerUid, j3)) {
            return;
        }
        boolean i16 = e().i1(e().M());
        aIOMsgItem.Q1(true);
        AIOMsgItem aIOMsgItem2 = (AIOMsgItem) msg2;
        QLog.i("AIOMsgRepo", 1, "[onAddLocalSendMsg]: hasLatestMsg=" + i16 + " msg Seq = " + msg2.getMsgSeq() + " msgId is " + msg2.getMsgId() + ", msgTime is " + aIOMsgItem2.getMsgRecord().msgTime);
        if (MsgExtKt.B(aIOMsgItem2.getMsgRecord())) {
            Contact b16 = com.tencent.mobileqq.aio.utils.o.b(d().g().r().c());
            long j16 = aIOMsgItem2.getMsgRecord().msgId;
            ArrayList<MsgElement> elements = aIOMsgItem2.getMsgRecord().elements;
            IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
            Intrinsics.checkNotNullExpressionValue(elements, "elements");
            iMsgService.sendMsg(b16, j16, elements, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msglist.msgrepo.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    MsgNotificationAbility.w(i3, str);
                }
            });
        }
        if (i16) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(msg2);
            E(listOf);
            e().M().add(msg2);
            AIOMsgRepo e16 = e();
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(aIOMsgItem2);
            e16.l0(arrayListOf);
            aIOMsgItem2.E1(true);
            Bundle Y0 = e().Y0(false, true);
            Y0.putBoolean("check_eliminate_msg", true);
            Y0.putBoolean("eliminate_top_msg", true);
            e().p0(IMsgListRepository.MsgListRepoOpType.LoadSendMessage, e().M(), Y0, "send_msg");
            return;
        }
        e().v("addLocalSendMsg");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.d("AIOMsgRepo", 1, "sendLocalFileToNt result:" + i3 + " errMsg:" + errMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(Contact contact) {
        AIOContact c16 = d().g().r().c();
        if (Intrinsics.areEqual(contact.peerUid, c16.j()) && contact.chatType == c16.e()) {
            QLog.i("AIOMsgRepo", 1, "onClearMsgRecords uid=" + contact.peerUid + ", chatType=" + contact.chatType);
            e().M().clear();
            e().p0(IMsgListRepository.MsgListRepoOpType.OtherOperation, e().M(), e().Y0(false, false), "clear_msg");
            d().e().h(new AIOMsgSendEvent.OnDeleteMsgRecordEvent());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(ArrayList<Long> msgIdList) {
        if (msgIdList == null) {
            return;
        }
        MsgList M = e().M();
        MsgList msgList = new MsgList();
        int size = M.size();
        for (int i3 = 0; i3 < size && msgList.size() != msgIdList.size(); i3++) {
            int size2 = msgIdList.size();
            int i16 = 0;
            while (true) {
                if (i16 < size2) {
                    Long l3 = msgIdList.get(i16);
                    long msgId = M.get(i3).getMsgId();
                    if (l3 != null && l3.longValue() == msgId) {
                        com.tencent.aio.data.msglist.a aVar = M.get(i3);
                        Intrinsics.checkNotNullExpressionValue(aVar, "displayList[index]");
                        msgList.add(aVar);
                        break;
                    }
                    i16++;
                }
            }
        }
        QLog.d("AIOMsgRepo", 1, "onMsgDelete list:" + msgList);
        M.removeAll(msgList);
        BaseMsgRepo.o0(e(), M, "delete_msg", null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(List<? extends com.tencent.aio.data.msglist.a> msgList) {
        Object last;
        String j3 = d().g().r().c().j();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = msgList.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) next;
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
            String str = ((AIOMsgItem) aVar).getMsgRecord().peerUid;
            QLog.i("AIOMsgRepo", 1, "onMsgReceive, msg uid = " + str + ", seq = " + aVar.getMsgSeq() + ", viewtype = " + aVar.getViewType());
            if (!TextUtils.equals(str, j3) || ((AIOMsgItem) aVar).getMsgRecord().msgType == 1) {
                z16 = false;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        AIOMsgItem aIOMsgItem = null;
        if (!(!arrayList.isEmpty())) {
            arrayList = null;
        }
        if (arrayList != null) {
            E(msgList);
            MsgList M = e().M();
            if (e().i1(M)) {
                QLog.i("AIOMsgRepo", 1, "onMsgReceive continuous seq");
                M.addAll(arrayList);
                e().l0(arrayList);
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList);
                if (last instanceof AIOMsgItem) {
                    aIOMsgItem = (AIOMsgItem) last;
                }
                if (aIOMsgItem != null) {
                    C(aIOMsgItem);
                }
                Bundle Y0 = e().Y0(true, true);
                Y0.putBoolean("check_eliminate_msg", true);
                e().p0(IMsgListRepository.MsgListRepoOpType.LoadMessageReceive, e().M(), Y0, "receive_msg");
            }
            D(arrayList);
            d().e().h(new AIOMsgListEvent.OnReceiveMsgs(msgList));
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void g(@NotNull MsgIntent intent) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof MsgNavigationEvent.NavigateToBottomEvent) {
            e().z();
            return;
        }
        if (intent instanceof AIOMsgListEvent.GetLastMsgSeq) {
            AIOMsgListEvent.GetLastMsgSeq getLastMsgSeq = (AIOMsgListEvent.GetLastMsgSeq) intent;
            com.tencent.aio.data.msglist.a e16 = e().E().e();
            if (e16 != null) {
                j3 = e16.getMsgSeq();
            } else {
                j3 = 0;
            }
            getLastMsgSeq.b(j3);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.MsgNavigationEvent.NavigateToBottomEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.GetLastMsgSeq");
        return hashSet;
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Set) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void m(@NotNull AIOMsgServiceWithContext aioMsgService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aioMsgService);
            return;
        }
        Intrinsics.checkNotNullParameter(aioMsgService, "aioMsgService");
        Flow onEach = FlowKt.onEach(aioMsgService.t(), new MsgNotificationAbility$registerNotification$1(this, null));
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        FlowKt.launchIn(FlowKt.flowOn(onEach, zs.b.a(dispatchers)), f());
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(aioMsgService.q(), new MsgNotificationAbility$registerNotification$2(this, null)), zs.b.a(dispatchers)), f());
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(aioMsgService.p(), new MsgNotificationAbility$registerNotification$3(this, null)), zs.b.a(dispatchers)), f());
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(aioMsgService.s(), new MsgNotificationAbility$registerNotification$4(this, null)), zs.b.a(dispatchers)), f());
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(aioMsgService.r(), new MsgNotificationAbility$registerNotification$5(this, null)), zs.b.a(dispatchers)), f());
        B();
    }

    public final void u(@NotNull com.tencent.qqnt.kernel.data.a recentContactNotification) {
        Object last;
        Object last2;
        Object last3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) recentContactNotification);
            return;
        }
        Intrinsics.checkNotNullParameter(recentContactNotification, "recentContactNotification");
        ArrayList<RecentContactInfo> a16 = recentContactNotification.a();
        if (a16 != null && a16.size() > 0) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) a16);
            if (((RecentContactInfo) last).unreadCnt != 0) {
                if (QLog.isDevelopLevel()) {
                    int size = a16.size();
                    last3 = CollectionsKt___CollectionsKt.last((List<? extends Object>) a16);
                    QLog.i("AIOMsgRepo MsgAbility", 4, "onRecentContactNotification changeSize=" + size + " unReadCnt=" + ((RecentContactInfo) last3).unreadCnt);
                }
                com.tencent.mvi.base.route.j e16 = d().e();
                last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) a16);
                e16.h(new MsgBoxEvent.ShowMsgBoxEvent((RecentContactInfo) last2));
            }
        }
    }
}
