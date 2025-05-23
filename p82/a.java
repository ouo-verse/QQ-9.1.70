package p82;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.QQStrangerOnChatListUIUpdateState;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\t*\u0001\u0017\u0018\u0000 \u001d2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00110\u0010H\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lp82/a;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/part/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/qqnt/kernel/api/w;", "getMsgService", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "z9", "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "", "e", "Z", "hasRefreshLIA", "p82/a$b", "f", "Lp82/a$b;", "msgListener", "<init>", "()V", h.F, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a extends com.tencent.mobileqq.matchfriend.reborn.content.msg.part.a implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    private static final HashSet<Long> f425780i = new HashSet<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasRefreshLIA;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final b msgListener = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR$\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\fj\b\u0012\u0004\u0012\u00020\u0002`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lp82/a$a;", "", "", "contactId", "", "a", "", "b", "c", "", "TAG", "Ljava/lang/String;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "exposedRecentContactIdList", "Ljava/util/HashSet;", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: p82.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(long contactId) {
            a.f425780i.add(Long.valueOf(contactId));
        }

        public final boolean b(long contactId) {
            return a.f425780i.contains(Long.valueOf(contactId));
        }

        public final void c(long contactId) {
            if (a.f425780i.contains(Long.valueOf(contactId))) {
                a.f425780i.remove(Long.valueOf(contactId));
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"p82/a$b", "Lcom/tencent/qqnt/msg/i;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onRecvMsg", "msgRecord", "onAddSendMsg", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends i {
        b() {
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onAddSendMsg(MsgRecord msgRecord) {
            List<MsgRecord> listOf;
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            if (msgRecord.chatType != 104) {
                return;
            }
            QQStrangerLIAHelper qQStrangerLIAHelper = QQStrangerLIAHelper.f245114a;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(msgRecord);
            qQStrangerLIAHelper.z(listOf);
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRecvMsg(ArrayList<MsgRecord> msgList) {
            Intrinsics.checkNotNullParameter(msgList, "msgList");
            QQStrangerLIAHelper qQStrangerLIAHelper = QQStrangerLIAHelper.f245114a;
            ArrayList arrayList = new ArrayList();
            for (Object obj : msgList) {
                if (((MsgRecord) obj).chatType == 104) {
                    arrayList.add(obj);
                }
            }
            qQStrangerLIAHelper.z(arrayList);
        }
    }

    private final w getMsgService() {
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) == null) {
            return null;
        }
        return iKernelService.getMsgService();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        w msgService = getMsgService();
        if (msgService != null) {
            msgService.addMsgListener(this.msgListener);
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        w msgService = getMsgService();
        if (msgService != null) {
            msgService.removeMsgListener(this.msgListener);
        }
        QQStrangerLIAHelper.f245114a.r();
        f425780i.clear();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        int collectionSizeOrDefault;
        if (event instanceof QQStrangerOnChatListUIUpdateState) {
            QQStrangerOnChatListUIUpdateState qQStrangerOnChatListUIUpdateState = (QQStrangerOnChatListUIUpdateState) event;
            if (qQStrangerOnChatListUIUpdateState.getDataList().isEmpty() || this.hasRefreshLIA) {
                return;
            }
            List<com.tencent.qqnt.chats.core.adapter.itemdata.b> dataList = qQStrangerOnChatListUIUpdateState.getDataList();
            ArrayList arrayList = new ArrayList();
            for (Object obj : dataList) {
                if (obj instanceof g) {
                    arrayList.add(obj);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((g) it.next()).s());
            }
            QQStrangerLIAHelper.f245114a.A(arrayList2);
            this.hasRefreshLIA = true;
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.a
    public void z9() {
        super.z9();
        QQStrangerLIAHelper.f245114a.n();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QQStrangerOnChatListUIUpdateState.class);
        return arrayListOf;
    }
}
