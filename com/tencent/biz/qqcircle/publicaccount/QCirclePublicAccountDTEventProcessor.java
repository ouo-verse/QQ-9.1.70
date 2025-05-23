package com.tencent.biz.qqcircle.publicaccount;

import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountMessageInfo;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountRedDotType;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.impl.QCirclePublicAccountMessageServiceImplKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.bizEvent.ChatBizConst$DTActionId;
import com.tencent.qqnt.chats.core.bizEvent.a;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 +2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b)\u0010*J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J&\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00052\u0014\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u00070\u0011H\u0002J\f\u0010\u0016\u001a\u00020\u0005*\u00020\u0015H\u0002J\u0012\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002*\u00020\u0015H\u0002J\u000e\u0010\u0019\u001a\u0004\u0018\u00010\u0018*\u00020\u0015H\u0002J\u001e\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u0002H\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0002H\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010!R\u0016\u0010&\u001a\u0004\u0018\u00010#8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u0018\u0010\u0010\u001a\u00020\u0005*\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/biz/qqcircle/publicaccount/QCirclePublicAccountDTEventProcessor;", "Lcom/tencent/qqnt/chats/core/bizEvent/e;", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", VideoTemplateParser.ITEM_LIST, "", "timestamp", "", "o", "p", "recentContactChatItem", "startExpoTimestamp", "endExpoTimestamp", "", "reason", "f", "msgId", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountMessageInfo;", "callback", "k", "Lcom/tencent/qqnt/chats/core/bizEvent/b;", DomainData.DOMAIN_NAME, "i", "Lcom/tencent/qqnt/chats/core/bizEvent/ChatBizConst$DTActionId;", tl.h.F, "Lcom/tencent/qqnt/chats/core/bizEvent/a;", "event", "items", "b", "a", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "lastQCirclePublicAccountChatItem", "J", "lastExpoTime", "Lcom/tencent/common/app/business/BaseQQAppInterface;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/common/app/business/BaseQQAppInterface;", "qqAppInterface", "j", "(Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;)J", "<init>", "()V", "c", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QCirclePublicAccountDTEventProcessor implements com.tencent.qqnt.chats.core.bizEvent.e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.chats.core.adapter.itemdata.g lastQCirclePublicAccountChatItem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long lastExpoTime;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f91665a;

        static {
            int[] iArr = new int[ChatBizConst$DTActionId.values().length];
            try {
                iArr[ChatBizConst$DTActionId.ListExpo.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ChatBizConst$DTActionId.PageOut.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f91665a = iArr;
        }
    }

    private final void f(final com.tencent.qqnt.chats.core.adapter.itemdata.g recentContactChatItem, long startExpoTimestamp, long endExpoTimestamp, final String reason) {
        final BaseQQAppInterface m3 = m();
        if (m3 == null) {
            return;
        }
        if (startExpoTimestamp == 0) {
            QLog.e("QCirclePublicAccountDTEventProcessor", 1, "endExpoAndReport, but startExpoTimestamp is 0");
            return;
        }
        final long j3 = endExpoTimestamp - startExpoTimestamp;
        if (j3 < 0) {
            QLog.e("QCirclePublicAccountDTEventProcessor", 1, "endExpoAndReport, but cost is negative");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.qqcircle.publicaccount.c
                @Override // java.lang.Runnable
                public final void run() {
                    QCirclePublicAccountDTEventProcessor.g(QCirclePublicAccountDTEventProcessor.this, recentContactChatItem, reason, j3, m3);
                }
            }, 16, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(QCirclePublicAccountDTEventProcessor this$0, com.tencent.qqnt.chats.core.adapter.itemdata.g recentContactChatItem, String reason, final long j3, final BaseQQAppInterface qqRuntime) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recentContactChatItem, "$recentContactChatItem");
        Intrinsics.checkNotNullParameter(reason, "$reason");
        Intrinsics.checkNotNullParameter(qqRuntime, "$qqRuntime");
        long j16 = this$0.j(recentContactChatItem);
        final QCirclePublicAccountRedDotType redDotType = QCirclePublicAccountMessageServiceImplKt.getRedDotType(recentContactChatItem.s());
        QLog.i("QCirclePublicAccountDTEventProcessor", 1, "end exposure on " + reason + ", cost=" + j3 + ", msgId=" + j16);
        this$0.k(j16, new Function1<QCirclePublicAccountMessageInfo, Unit>() { // from class: com.tencent.biz.qqcircle.publicaccount.QCirclePublicAccountDTEventProcessor$endExpoAndReport$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
                invoke2(qCirclePublicAccountMessageInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
                ((IQCirclePublicAccountReporter) QRoute.api(IQCirclePublicAccountReporter.class)).reportMessageCellExposureCost(BaseQQAppInterface.this, j3, redDotType, qCirclePublicAccountMessageInfo);
            }
        });
    }

    private final ChatBizConst$DTActionId h(com.tencent.qqnt.chats.core.bizEvent.b bVar) {
        Object obj;
        Map<String, Object> b16 = bVar.b();
        if (b16 != null) {
            obj = b16.get("dt_action_id");
        } else {
            obj = null;
        }
        if (!(obj instanceof ChatBizConst$DTActionId)) {
            return null;
        }
        return (ChatBizConst$DTActionId) obj;
    }

    private final List<com.tencent.qqnt.chats.core.adapter.itemdata.g> i(com.tencent.qqnt.chats.core.bizEvent.b bVar) {
        Object obj;
        List<com.tencent.qqnt.chats.core.adapter.itemdata.g> filterIsInstance;
        Map<String, Object> b16 = bVar.b();
        List list = null;
        if (b16 != null) {
            obj = b16.get("dt_expo_data");
        } else {
            obj = null;
        }
        if (obj instanceof List) {
            list = (List) obj;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        filterIsInstance = CollectionsKt___CollectionsJvmKt.filterIsInstance(list, com.tencent.qqnt.chats.core.adapter.itemdata.g.class);
        return filterIsInstance;
    }

    private final long j(com.tencent.qqnt.chats.core.adapter.itemdata.g gVar) {
        return gVar.s().msgId;
    }

    private final void k(long msgId, final Function1<? super QCirclePublicAccountMessageInfo, Unit> callback) {
        ArrayList<Long> arrayListOf;
        if (msgId == 0) {
            callback.invoke(null);
            return;
        }
        BaseQQAppInterface m3 = m();
        if (m3 == null) {
            return;
        }
        w msgService = ((IKernelService) m3.getRuntimeService(IKernelService.class, "all")).getMsgService();
        if (msgService == null) {
            callback.invoke(null);
            return;
        }
        Contact contact = new Contact(103, AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UID, "");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(msgId));
        msgService.getMsgsByMsgId(contact, arrayListOf, new IMsgOperateCallback() { // from class: com.tencent.biz.qqcircle.publicaccount.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                QCirclePublicAccountDTEventProcessor.l(Function1.this, i3, str, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void l(Function1 callback, int i3, String str, ArrayList arrayList) {
        MsgRecord msgRecord;
        Object orNull;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo = null;
        if (i3 == 0) {
            if (arrayList != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, 0);
                msgRecord = (MsgRecord) orNull;
                if (msgRecord != null) {
                    qCirclePublicAccountMessageInfo = QCirclePublicAccountMessageServiceImplKt.toQCirclePublicAccountMessageInfo(msgRecord);
                }
                callback.invoke(qCirclePublicAccountMessageInfo);
            }
        } else {
            QLog.e("QCirclePublicAccountDTEventProcessor", 1, "getQCirclePublicAccountMessageInfoByMsgId failed, result=" + i3 + ",errMsg=" + str);
        }
        msgRecord = null;
        if (msgRecord != null) {
        }
        callback.invoke(qCirclePublicAccountMessageInfo);
    }

    private final BaseQQAppInterface m() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            return (BaseQQAppInterface) peekAppRuntime;
        }
        return null;
    }

    private final long n(com.tencent.qqnt.chats.core.bizEvent.b bVar) {
        Object obj;
        Map<String, Object> b16 = bVar.b();
        Long l3 = null;
        if (b16 != null) {
            obj = b16.get("dt_expo_time");
        } else {
            obj = null;
        }
        if (obj instanceof Long) {
            l3 = (Long) obj;
        }
        if (l3 != null) {
            return l3.longValue();
        }
        return 0L;
    }

    private final void o(List<com.tencent.qqnt.chats.core.adapter.itemdata.g> itemList, long timestamp) {
        Object obj;
        if (RFSafeListUtils.isEmpty(itemList)) {
            QLog.w("QCirclePublicAccountDTEventProcessor", 1, "[handleListExpo] current item list is empty.");
            return;
        }
        Iterator<T> it = itemList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (ia0.a.a((com.tencent.qqnt.chats.core.adapter.itemdata.g) obj)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) obj;
        if (gVar != null) {
            com.tencent.qqnt.chats.core.adapter.itemdata.g gVar2 = this.lastQCirclePublicAccountChatItem;
            if (gVar2 == null) {
                this.lastQCirclePublicAccountChatItem = gVar;
                this.lastExpoTime = timestamp;
                QLog.i("QCirclePublicAccountDTEventProcessor", 1, "start exposure, msgId=" + j(gVar));
                return;
            }
            boolean z16 = false;
            if (gVar2 != null && j(gVar2) == j(gVar)) {
                z16 = true;
            }
            if (!z16) {
                com.tencent.qqnt.chats.core.adapter.itemdata.g gVar3 = this.lastQCirclePublicAccountChatItem;
                if (gVar3 != null) {
                    f(gVar3, this.lastExpoTime, timestamp, "update");
                }
                QLog.i("QCirclePublicAccountDTEventProcessor", 1, "start exposure on update, msgId=" + j(gVar));
                this.lastQCirclePublicAccountChatItem = gVar;
                this.lastExpoTime = timestamp;
                return;
            }
            return;
        }
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar4 = this.lastQCirclePublicAccountChatItem;
        if (gVar4 != null) {
            f(gVar4, this.lastExpoTime, timestamp, "slide out");
            this.lastQCirclePublicAccountChatItem = null;
            this.lastExpoTime = 0L;
        }
    }

    private final void p(long timestamp) {
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = this.lastQCirclePublicAccountChatItem;
        if (gVar != null) {
            f(gVar, this.lastExpoTime, timestamp, "page out");
            this.lastQCirclePublicAccountChatItem = null;
            this.lastExpoTime = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(List items, QCirclePublicAccountDTEventProcessor this$0) {
        int i3;
        Intrinsics.checkNotNullParameter(items, "$items");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = items.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.chats.core.bizEvent.b bVar = (com.tencent.qqnt.chats.core.bizEvent.b) it.next();
            ChatBizConst$DTActionId h16 = this$0.h(bVar);
            if (h16 == null) {
                i3 = -1;
            } else {
                i3 = b.f91665a[h16.ordinal()];
            }
            if (i3 != 1) {
                if (i3 == 2) {
                    this$0.p(this$0.n(bVar));
                }
            } else {
                this$0.o(this$0.i(bVar), this$0.n(bVar));
            }
        }
    }

    @Override // com.tencent.qqnt.chats.core.bizEvent.e
    @NotNull
    public List<com.tencent.qqnt.chats.core.bizEvent.a> a() {
        List<com.tencent.qqnt.chats.core.bizEvent.a> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(a.b.f354761a);
        return listOf;
    }

    @Override // com.tencent.qqnt.chats.core.bizEvent.e
    public void b(@NotNull com.tencent.qqnt.chats.core.bizEvent.a event, @NotNull final List<com.tencent.qqnt.chats.core.bizEvent.b> items) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(items, "items");
        if (!(event instanceof a.b)) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.biz.qqcircle.publicaccount.b
            @Override // java.lang.Runnable
            public final void run() {
                QCirclePublicAccountDTEventProcessor.q(items, this);
            }
        });
    }
}
