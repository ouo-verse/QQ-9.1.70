package com.tencent.mobileqq.vas.message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.vas.message.processor.SquareTempProcessor;
import com.tencent.mobileqq.vas.social.u;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.AnchorPointContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactListener;
import com.tencent.qqnt.kernel.nativeinterface.NotificationCommonInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactExtra;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactListChangedInfo;
import com.tencent.qqnt.kernel.nativeinterface.bh;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.i;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.state.square.SquareConstants;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.api.MessageRecordType;
import com.tencent.state.square.api.PttMessage;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SquareMiniAioMultiSelectedRecord;
import com.tencent.state.square.api.UnreadMessageObserver;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.remote.ServiceConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import tl.h;
import x13.e;
import x13.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c1\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001d\u0018\u0000 i2\u00020\u00012\u00020\u0002:\u0001OB\u0007\u00a2\u0006\u0004\bg\u0010hJ\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J3\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tH\u0002J \u0010\u0016\u001a\u00020\u000e2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001bH\u0016Js\u0010(\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010\u00182#\u0010'\u001a\u001f\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tH\u0016J4\u0010-\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u00101\u001a\u0002002\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\u0018\u00103\u001a\b\u0012\u0004\u0012\u000200022\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\u0010\u00106\u001a\u00020\u000e2\u0006\u00105\u001a\u000204H\u0016J\u0010\u00107\u001a\u00020\u000e2\u0006\u00105\u001a\u000204H\u0016JC\u0010:\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001b2)\u0010'\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000502\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tH\u0016J*\u0010>\u001a\u00020\u000e2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00112\b\u0010=\u001a\u0004\u0018\u00010<2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016JG\u0010@\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b2%\u0010'\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tH\u0016J\u0018\u0010B\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010A\u001a\u00020\u001bH\u0016J\b\u0010C\u001a\u00020\u000eH\u0016J*\u0010G\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010D\u001a\u00020\u00182\u0006\u0010E\u001a\u00020\u00182\u0006\u0010F\u001a\u00020\u0018H\u0016J\u0010\u0010H\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010J\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010I\u001a\u00020\nH\u0016J*\u0010K\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001bH\u0016R2\u0010Q\u001a\u001e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020M0Lj\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020M`N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR2\u0010T\u001a\u001e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020R0Lj\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020R`N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010PR\u001a\u0010X\u001a\b\u0012\u0004\u0012\u0002040U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010[\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010_\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010f\u001a\u00020d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010e\u00a8\u0006j"}, d2 = {"Lcom/tencent/mobileqq/vas/message/SquareAioService;", "Lcom/tencent/state/square/api/ISquareBaseMessageService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRecentContactListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "info", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "g", "", "startTime", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isTimeout", "", "onDone", "j", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactListChangedInfo;", "changedRecentContactLists", "", "seq", "onRecentContactListChangedVer2", "init", "", "uin", IProfileProtocolConst.PARAM_IS_FRIEND, "Lcom/tencent/state/square/api/MessageRecordType;", "type", "isReceiveNotify", "Landroidx/fragment/app/Fragment;", "fragment", "scene", "needShowKeyboard", ServiceConst.EXTRA_NEEDCALLBACK, "Lcom/tencent/state/square/api/PttMessage;", "message", "nickname", "success", "callback", "openMiniMsgAio", QzoneIPCModule.RESULT_CODE, "multiSelect", "needTroop", "title", "openMiniSelectPage", "Landroid/content/Intent;", "intent", "Lcom/tencent/state/square/api/SquareMiniAioMultiSelectedRecord;", "pareSingleSelectUinInfo", "", "parseMultiSelectedUinInfo", "Lcom/tencent/state/square/api/UnreadMessageObserver;", "observer", "addUnreadMessageObserver", "deleteUnreadMessageObserver", "limitNum", "msg", "getRecentMsgListSyncAioTable", "changedList", "Lcom/tencent/qqnt/kernel/nativeinterface/NotificationCommonInfo;", "commonInfo", "onRecentContactNotification", "includeUnNotifyMsg", "getSingleUnreadMsg", "messageRecordType", "getName", "destroy", "eviluin", "srv_Para", TPReportKeys.LiveExKeys.LIVE_EX_CONTENT_ID, "openReportPage", "isInShieldList", "isShield", "setShieldList", "openSettingsPage", "Ljava/util/HashMap;", "Lx13/b;", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "converterMap", "Lcom/tencent/mobileqq/vas/message/processor/a;", "b", "processorMap", "Ljava/util/concurrent/CopyOnWriteArraySet;", "c", "Ljava/util/concurrent/CopyOnWriteArraySet;", "messageListenerSet", "d", "Z", "isNotify", "Lcom/tencent/mobileqq/vas/social/u;", "e", "Lcom/tencent/mobileqq/vas/social/u;", "threadManager", "Ljava/util/concurrent/atomic/AtomicBoolean;", "f", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRecentContactLoaded", "com/tencent/mobileqq/vas/message/SquareAioService$b", "Lcom/tencent/mobileqq/vas/message/SquareAioService$b;", "mMsgListener", "<init>", "()V", h.F, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SquareAioService implements ISquareBaseMessageService, IKernelRecentContactListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isNotify;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private b mMsgListener;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private HashMap<MessageRecordType, x13.b> converterMap = new HashMap<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private HashMap<MessageRecordType, com.tencent.mobileqq.vas.message.processor.a> processorMap = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArraySet<UnreadMessageObserver> messageListenerSet = new CopyOnWriteArraySet<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final u threadManager = new u();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private AtomicBoolean isRecentContactLoaded = new AtomicBoolean(false);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/vas/message/SquareAioService$b", "Lcom/tencent/qqnt/msg/i;", "", "msgId", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "", "errorCode", "", "errorMsg", "", "onSendMsgError", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends i {
        b() {
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onSendMsgError(long msgId, Contact peer, int errorCode, String errorMsg) {
            QLog.d("IMsgListenerAdapter", 1, "onSendMsgError: " + msgId + ", " + peer + ", " + errorCode + ", " + errorMsg);
            if (peer == null || errorCode == 0) {
                return;
            }
            com.tencent.mobileqq.vas.message.processor.a aVar = (com.tencent.mobileqq.vas.message.processor.a) SquareAioService.this.processorMap.get(c.f310029a.c(com.tencent.nt.adapter.session.c.c(peer.chatType)));
            if (aVar != null) {
                aVar.onSendMsgError(msgId, peer, errorCode, errorMsg);
            }
        }
    }

    public SquareAioService() {
        HashMap<MessageRecordType, x13.b> hashMap = this.converterMap;
        MessageRecordType messageRecordType = MessageRecordType.RECORD_TYPE_FRIEND;
        hashMap.put(messageRecordType, new x13.c());
        HashMap<MessageRecordType, x13.b> hashMap2 = this.converterMap;
        MessageRecordType messageRecordType2 = MessageRecordType.RECORD_TYPE_TROOP;
        hashMap2.put(messageRecordType2, new f());
        HashMap<MessageRecordType, x13.b> hashMap3 = this.converterMap;
        MessageRecordType messageRecordType3 = MessageRecordType.RECORD_TYPE_SQUARE_TEMP;
        hashMap3.put(messageRecordType3, new e());
        this.processorMap.put(messageRecordType, new com.tencent.mobileqq.vas.message.processor.b());
        this.processorMap.put(messageRecordType2, new com.tencent.mobileqq.vas.message.processor.f());
        this.processorMap.put(messageRecordType3, new SquareTempProcessor());
        this.mMsgListener = new b();
    }

    private final SquareBaseMessageRecord g(RecentContactInfo info) {
        x13.b bVar = this.converterMap.get(c.f310029a.c(com.tencent.nt.adapter.session.c.c(info.chatType)));
        if (bVar != null) {
            return bVar.a(info);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(QQAppInterface runtime, SquareAioService this$0) {
        Intrinsics.checkNotNullParameter(runtime, "$runtime");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SettingCloneUtil.writeValue(runtime.getApp(), runtime.getCurrentUin(), (String) null, AppConstants.TOP_MSG_NOTIFICATION_KEY, this$0.isNotify);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(QQAppInterface runtime) {
        Intrinsics.checkNotNullParameter(runtime, "$runtime");
        SettingCloneUtil.writeValue((Context) runtime.getApp(), runtime.getCurrentUin(), (String) null, AppConstants.TOP_MSG_NOTIFICATION_KEY, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(final long startTime, final Function1<? super Boolean, Unit> onDone) {
        if (this.isRecentContactLoaded.get()) {
            QLog.i("BaseMessageService", 1, "waitForRecentContactLoaded cost:" + (System.currentTimeMillis() - startTime));
            onDone.invoke(Boolean.FALSE);
            return;
        }
        this.threadManager.postOnSubThreadDelay(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.message.SquareAioService$waitForRecentContactLoaded$1
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
                AtomicBoolean atomicBoolean;
                atomicBoolean = SquareAioService.this.isRecentContactLoaded;
                if (atomicBoolean.get()) {
                    QLog.i("BaseMessageService", 1, "waitForRecentContactLoaded cost:" + (System.currentTimeMillis() - startTime));
                    onDone.invoke(Boolean.FALSE);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                long j3 = startTime;
                if (currentTimeMillis - j3 <= 2000) {
                    SquareAioService.this.j(j3, onDone);
                } else {
                    QLog.e("BaseMessageService", 1, "waitForRecentContactLoaded timeout.");
                    onDone.invoke(Boolean.TRUE);
                }
            }
        }, 100L);
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public void addUnreadMessageObserver(UnreadMessageObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.messageListenerSet.contains(observer)) {
            return;
        }
        this.messageListenerSet.add(observer);
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public void deleteUnreadMessageObserver(UnreadMessageObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.messageListenerSet.contains(observer)) {
            this.messageListenerSet.remove(observer);
        }
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public void destroy() {
        aa recentContactService;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        final QQAppInterface qQAppInterface = runtime instanceof QQAppInterface ? (QQAppInterface) runtime : null;
        if (qQAppInterface == null || (recentContactService = ((IKernelService) qQAppInterface.getRuntimeService(IKernelService.class, "zplan")).getRecentContactService()) == null) {
            return;
        }
        recentContactService.b0(this);
        recentContactService.c0(11);
        w msgService = ((IKernelService) qQAppInterface.getRuntimeService(IKernelService.class, "zplan")).getMsgService();
        if (msgService != null) {
            msgService.removeMsgListener(this.mMsgListener);
        }
        this.processorMap.clear();
        this.converterMap.clear();
        this.messageListenerSet.clear();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.message.a
            @Override // java.lang.Runnable
            public final void run() {
                SquareAioService.h(QQAppInterface.this, this);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public String getName(String uin, MessageRecordType messageRecordType) {
        String name;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(messageRecordType, "messageRecordType");
        com.tencent.mobileqq.vas.message.processor.a aVar = this.processorMap.get(messageRecordType);
        return (aVar == null || (name = aVar.getName(uin, messageRecordType)) == null) ? uin : name;
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public void getRecentMsgListSyncAioTable(final int limitNum, final MessageRecordType type, final Function1<? super List<? extends SquareBaseMessageRecord>, Unit> callback) {
        Intrinsics.checkNotNullParameter(type, "type");
        j(System.currentTimeMillis(), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.vas.message.SquareAioService$getRecentMsgListSyncAioTable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                u uVar;
                QLog.i("BaseMessageService", 1, "getRecentMsgListSyncAioTable isTimeout:" + z16);
                uVar = SquareAioService.this.threadManager;
                final Function1<List<? extends SquareBaseMessageRecord>, Unit> function1 = callback;
                final SquareAioService squareAioService = SquareAioService.this;
                final MessageRecordType messageRecordType = type;
                final int i3 = limitNum;
                uVar.postOnUi(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.message.SquareAioService$getRecentMsgListSyncAioTable$1.1
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
                        List<SquareBaseMessageRecord> emptyList;
                        Function1<List<? extends SquareBaseMessageRecord>, Unit> function12 = function1;
                        if (function12 != null) {
                            com.tencent.mobileqq.vas.message.processor.a aVar = (com.tencent.mobileqq.vas.message.processor.a) squareAioService.processorMap.get(messageRecordType);
                            if (aVar == null || (emptyList = aVar.c(i3, messageRecordType)) == null) {
                                emptyList = CollectionsKt__CollectionsKt.emptyList();
                            }
                            function12.invoke(emptyList);
                        }
                    }
                });
            }
        });
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public void getSingleUnreadMsg(final String uin, final boolean includeUnNotifyMsg, final MessageRecordType type, final Function1<? super SquareBaseMessageRecord, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(type, "type");
        j(System.currentTimeMillis(), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.vas.message.SquareAioService$getSingleUnreadMsg$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                u uVar;
                QLog.i("BaseMessageService", 1, "getSingleUnreadMsg isTimeout:" + z16);
                uVar = SquareAioService.this.threadManager;
                final Function1<SquareBaseMessageRecord, Unit> function1 = callback;
                final SquareAioService squareAioService = SquareAioService.this;
                final MessageRecordType messageRecordType = type;
                final String str = uin;
                final boolean z17 = includeUnNotifyMsg;
                uVar.postOnUi(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.message.SquareAioService$getSingleUnreadMsg$1.1
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
                        Function1<SquareBaseMessageRecord, Unit> function12 = function1;
                        if (function12 != null) {
                            com.tencent.mobileqq.vas.message.processor.a aVar = (com.tencent.mobileqq.vas.message.processor.a) squareAioService.processorMap.get(messageRecordType);
                            function12.invoke(aVar != null ? aVar.b(str, z17, messageRecordType) : null);
                        }
                    }
                });
            }
        });
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public void init() {
        aa recentContactService;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        final QQAppInterface qQAppInterface = runtime instanceof QQAppInterface ? (QQAppInterface) runtime : null;
        if (qQAppInterface == null || (recentContactService = ((IKernelService) qQAppInterface.getRuntimeService(IKernelService.class, "zplan")).getRecentContactService()) == null) {
            return;
        }
        recentContactService.l(this);
        aa.b.a(recentContactService, new AnchorPointContactInfo(), true, 11, 0, null, 24, null);
        w msgService = ((IKernelService) qQAppInterface.getRuntimeService(IKernelService.class, "zplan")).getMsgService();
        if (msgService != null) {
            msgService.addMsgListener(this.mMsgListener);
        }
        this.isNotify = SettingCloneUtil.readValue((Context) qQAppInterface.getApp(), qQAppInterface.getCurrentUin(), (String) null, AppConstants.TOP_MSG_NOTIFICATION_KEY, false);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.message.b
            @Override // java.lang.Runnable
            public final void run() {
                SquareAioService.i(QQAppInterface.this);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public boolean isFriend(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        return iFriendsInfoService.isFriend(uid, "BaseMessageService");
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public boolean isInShieldList(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        QQAppInterface qQAppInterface = runtime instanceof QQAppInterface ? (QQAppInterface) runtime : null;
        if (qQAppInterface == null) {
            return false;
        }
        Manager manager = qQAppInterface.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
        ShieldMsgManger shieldMsgManger = manager instanceof ShieldMsgManger ? (ShieldMsgManger) manager : null;
        if (shieldMsgManger == null) {
            return false;
        }
        return shieldMsgManger.h(uin);
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public boolean isReceiveNotify(String uin, MessageRecordType type) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(type, "type");
        com.tencent.mobileqq.vas.message.processor.a aVar = this.processorMap.get(type);
        if (aVar != null) {
            return aVar.isReceiveNotify(uin, type);
        }
        return true;
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactListener
    public /* synthetic */ void onDeletedContactsNotify(ArrayList arrayList) {
        bh.a(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactListener
    public /* synthetic */ void onMsgUnreadCountUpdate(HashMap hashMap) {
        bh.b(this, hashMap);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactListener
    public /* synthetic */ void onRecentContactListChanged(ArrayList arrayList, ArrayList arrayList2, RecentContactExtra recentContactExtra) {
        bh.c(this, arrayList, arrayList2, recentContactExtra);
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public void openReportPage(Fragment fragment, String eviluin, String srv_Para, String contentid) {
        Intrinsics.checkNotNullParameter(eviluin, "eviluin");
        Intrinsics.checkNotNullParameter(srv_Para, "srv_Para");
        Intrinsics.checkNotNullParameter(contentid, "contentid");
        if (fragment != null) {
            if (!(eviluin.length() == 0)) {
                com.tencent.mobileqq.dt.api.b bVar = new com.tencent.mobileqq.dt.api.b();
                bVar.i("10053");
                bVar.n(eviluin);
                bVar.o(2);
                bVar.j("0");
                bVar.s(0);
                bVar.m(contentid);
                bVar.v(srv_Para);
                QLog.i("BaseMessageService", 1, "openReportPage");
                ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(fragment.getContext(), bVar);
                return;
            }
        }
        QLog.e("BaseMessageService", 1, "openReportPage params empty");
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public void openSettingsPage(Fragment fragment, int scene, String uin, MessageRecordType type) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(type, "type");
        QLog.i("BaseMessageService", 1, "openSettingsPage " + uin + ", " + type);
        com.tencent.mobileqq.vas.message.processor.a aVar = this.processorMap.get(type);
        if (aVar == null) {
            QLog.w("BaseMessageService", 1, "openSettingsPage, handler is null");
        } else {
            if (fragment == null) {
                return;
            }
            aVar.openSettingsPage(fragment, scene, uin, type);
        }
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public List<SquareMiniAioMultiSelectedRecord> parseMultiSelectedUinInfo(Intent intent) {
        ArrayList arrayList = new ArrayList();
        if (intent == null) {
            return arrayList;
        }
        try {
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("selected_target_list");
            QLog.i("BaseMessageService", 1, "parseMultiSelectedUinInfo source.size:" + (parcelableArrayListExtra != null ? parcelableArrayListExtra.size() : 0));
            if (parcelableArrayListExtra != null) {
                Iterator it = parcelableArrayListExtra.iterator();
                while (it.hasNext()) {
                    ResultRecord resultRecord = (ResultRecord) it.next();
                    int i3 = resultRecord.uinType;
                    if (i3 == 1 || i3 == 0) {
                        String str = resultRecord.uin;
                        Intrinsics.checkNotNullExpressionValue(str, "item.uin");
                        arrayList.add(new SquareMiniAioMultiSelectedRecord(str, resultRecord.uinType == 1 ? 1 : 0));
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e("BaseMessageService", 1, "getParcelableList err.", th5);
        }
        QLog.i("BaseMessageService", 1, "parseMultiSelectedUinInfo result.size:" + arrayList.size());
        return arrayList;
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public void setShieldList(String uin, boolean isShield) {
        Long longOrNull;
        List<Long> listOf;
        List<Long> listOf2;
        Intrinsics.checkNotNullParameter(uin, "uin");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            QQAppInterface qQAppInterface = runtime instanceof QQAppInterface ? (QQAppInterface) runtime : null;
            if (qQAppInterface == null) {
                return;
            }
            Manager manager = qQAppInterface.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
            ShieldMsgManger shieldMsgManger = manager instanceof ShieldMsgManger ? (ShieldMsgManger) manager : null;
            if (shieldMsgManger == null) {
                return;
            }
            QLog.i("BaseMessageService", 1, "setShieldList uin:" + uin + ", isShield:" + isShield);
            if (isShield) {
                listOf2 = CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(longValue));
                shieldMsgManger.k(10019, listOf2);
            } else {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(longValue));
                shieldMsgManger.m(10019, listOf);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SquareMiniAioMultiSelectedRecord pareSingleSelectUinInfo(Intent intent) {
        String stringExtra;
        String str = "";
        if (intent == null) {
            return new SquareMiniAioMultiSelectedRecord("", 0);
        }
        try {
            int intExtra = intent.getIntExtra("uintype", 0);
            if (intExtra == 1) {
                stringExtra = intent.getStringExtra("uin");
                if (stringExtra == null) {
                    return new SquareMiniAioMultiSelectedRecord(str, intExtra != 1 ? 1 : 0);
                }
                str = stringExtra;
                return new SquareMiniAioMultiSelectedRecord(str, intExtra != 1 ? 1 : 0);
            }
            stringExtra = intent.getStringExtra("extra_choose_friend_uin");
            if (stringExtra == null) {
                return new SquareMiniAioMultiSelectedRecord(str, intExtra != 1 ? 1 : 0);
            }
            str = stringExtra;
            return new SquareMiniAioMultiSelectedRecord(str, intExtra != 1 ? 1 : 0);
        } catch (Throwable th5) {
            QLog.e("BaseMessageService", 1, "pareSingleSelectUinInfo err.", th5);
            QLog.i("BaseMessageService", 1, "pareSingleSelectUinInfo uin:" + str);
            return new SquareMiniAioMultiSelectedRecord(str, 0);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactListener
    public void onRecentContactListChangedVer2(ArrayList<RecentContactListChangedInfo> changedRecentContactLists, int seq) {
        Object obj = null;
        QLog.d("BaseMessageService", 1, "onRecentContactListChangedVer2: " + (changedRecentContactLists != null ? Integer.valueOf(changedRecentContactLists.size()) : null) + ", " + seq);
        this.isRecentContactLoaded.compareAndSet(false, true);
        if (changedRecentContactLists != null) {
            Iterator<T> it = changedRecentContactLists.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((RecentContactListChangedInfo) next).listType == 11) {
                    obj = next;
                    break;
                }
            }
            RecentContactListChangedInfo recentContactListChangedInfo = (RecentContactListChangedInfo) obj;
            if (recentContactListChangedInfo == null) {
                return;
            }
            Iterator<RecentContactInfo> it5 = recentContactListChangedInfo.changedList.iterator();
            while (it5.hasNext()) {
                RecentContactInfo info = it5.next();
                Intrinsics.checkNotNullExpressionValue(info, "info");
                final SquareBaseMessageRecord g16 = g(info);
                if (g16 != null) {
                    Iterator<UnreadMessageObserver> it6 = this.messageListenerSet.iterator();
                    while (it6.hasNext()) {
                        final UnreadMessageObserver next2 = it6.next();
                        this.threadManager.postOnUi(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.message.SquareAioService$onRecentContactListChangedVer2$1$1
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
                                UnreadMessageObserver.this.notifyUnreadMessage(g16);
                            }
                        });
                    }
                }
            }
        }
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public void openMiniMsgAio(Fragment fragment, int scene, String uin, MessageRecordType type, boolean needShowKeyboard, boolean needCallback, PttMessage message, String nickname, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(type, "type");
        QLog.d("BaseMessageService", 1, "openMiniMsgAio, " + uin + ", " + type);
        if (fragment == null) {
            QLog.i("BaseMessageService", 1, "openMiniMsgAio, fragment is null");
            if (callback != null) {
                callback.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        Bundle bundle = new Bundle();
        if (message != null) {
            bundle.putBoolean("KEY_NEED_AUTO_JUMP_MSG", true);
            bundle.putLong("KEY_AUTO_JUMP_MSG_UID", message.getMsgUid());
            bundle.putLong("KEY_AUTO_JUMP_MSG_TIME", message.getMsgTimeStamp());
        }
        bundle.putString(SquareConstants.RESULT_KEY_SQUARE_AIO_UIN_STR, uin);
        bundle.putInt(SquareConstants.RESULT_KEY_SQUARE_AIO_UIN_TYPE_INT, 1);
        bundle.putInt(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 26);
        bundle.putBoolean("key_open_keyboard", needShowKeyboard);
        bundle.putBoolean("key_square_aio_start_activity_for_result", needCallback);
        com.tencent.mobileqq.vas.message.processor.a aVar = this.processorMap.get(type);
        if (aVar == null) {
            QLog.w("BaseMessageService", 1, "openMiniMsgAio, handler is null");
            if (callback != null) {
                callback.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        aVar.a(fragment, scene, uin, type, bundle, nickname, callback);
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public void openMiniSelectPage(Fragment fragment, int resultCode, boolean multiSelect, boolean needTroop, String title) {
        if (fragment == null) {
            return;
        }
        if (title == null) {
            title = "\u6dfb\u52a0\u5230\u5e7f\u573a";
        }
        ForwardUtils.X(fragment, resultCode, title, "\u9009\u62e9\u7fa4\u804a", "\u5b8c\u6210", needTroop, multiSelect);
        QLog.i("BaseMessageService", 1, "openMiniSelectPage");
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactListener
    public void onRecentContactNotification(ArrayList<RecentContactInfo> changedList, NotificationCommonInfo commonInfo, int seq) {
    }
}
