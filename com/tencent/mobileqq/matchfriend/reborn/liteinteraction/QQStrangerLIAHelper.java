package com.tencent.mobileqq.matchfriend.reborn.liteinteraction;

import android.os.Handler;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.repo.QQStrangerLIARepo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bD\u0010EJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0002J*\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0002J\u0016\u0010\u0012\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH\u0002J\f\u0010\u0013\u001a\u00020\u000b*\u00020\u000fH\u0002J\u0016\u0010\u0016\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\u0002J\u0014\u0010\u0018\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00170\bJ\u0006\u0010\u0019\u001a\u00020\u0006J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\u001d\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\bJ\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u001f\u001a\u00020\u0006J\u0010\u0010!\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\u000fJ\u0018\u0010\"\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004R$\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u00100\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b.\u0010/R\u001b\u00105\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010(\u001a\u0004\b3\u00104R\u001b\u0010:\u001a\u0002068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u0010(\u001a\u0004\b8\u00109R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020<0;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R&\u0010C\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0;0@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/QQStrangerLIAHelper;", "", "Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/d;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "scene", "", "B", "", VideoTemplateParser.ITEM_LIST, "Ljava/util/concurrent/ConcurrentHashMap;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "newList", "oldList", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "contactList", "y", UserInfo.SEX_FEMALE, "Lkotlin/Function0;", "block", "D", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, DomainData.DOMAIN_NAME, "o", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", TabPreloadItem.TAB_NAME_MESSAGE, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, BdhLogUtil.LogTag.Tag_Conn, "r", "contact", "t", "u", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "liaItemMap", "Landroid/os/Handler;", "c", "Lkotlin/Lazy;", HippyTKDListViewAdapter.X, "()Landroid/os/Handler;", "uiHandler", "Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/b;", "d", "v", "()Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/b;", "msgCollector", "Lo82/b;", "e", ReportConstant.COSTREPORT_PREFIX, "()Lo82/b;", "filter", "Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/repo/QQStrangerLIARepo;", "f", "w", "()Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/repo/QQStrangerLIARepo;", "repo", "", "Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/a;", "g", "Ljava/util/List;", "anyLIAChangedListenerList", "", h.F, "Ljava/util/Map;", "singleLIAChangedListenerMap", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerLIAHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final QQStrangerLIAHelper f245114a = new QQStrangerLIAHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static ConcurrentHashMap<String, QQStrangerLIAItem> liaItemMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy uiHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Lazy msgCollector;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final Lazy filter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final Lazy repo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final List<a> anyLIAChangedListenerList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, List<a>> singleLIAChangedListenerMap;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAHelper$uiHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        uiHandler = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAHelper$msgCollector$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new b();
            }
        });
        msgCollector = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<o82.b>() { // from class: com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAHelper$filter$2
            @Override // kotlin.jvm.functions.Function0
            public final o82.b invoke() {
                return new o82.b();
            }
        });
        filter = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<QQStrangerLIARepo>() { // from class: com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAHelper$repo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQStrangerLIARepo invoke() {
                return new QQStrangerLIARepo();
            }
        });
        repo = lazy4;
        anyLIAChangedListenerList = new ArrayList();
        singleLIAChangedListenerMap = new LinkedHashMap();
    }

    QQStrangerLIAHelper() {
    }

    private final void D(final Function0<Unit> block) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            block.invoke();
        } else {
            x().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.liteinteraction.c
                @Override // java.lang.Runnable
                public final void run() {
                    QQStrangerLIAHelper.E(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String F(Contact contact) {
        return contact.chatType + "-" + contact.peerUid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Contact> m(List<QQStrangerLIAItem> newList, List<QQStrangerLIAItem> oldList) {
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap<String, QQStrangerLIAItem> q16 = q(newList);
        ConcurrentHashMap<String, QQStrangerLIAItem> q17 = q(oldList);
        for (QQStrangerLIAItem qQStrangerLIAItem : newList) {
            Contact e16 = e.e(qQStrangerLIAItem);
            QQStrangerLIAItem qQStrangerLIAItem2 = q17.get(f245114a.F(e16));
            if (qQStrangerLIAItem2 == null || qQStrangerLIAItem2 != qQStrangerLIAItem) {
                arrayList.add(e16);
            }
        }
        Iterator<T> it = oldList.iterator();
        while (it.hasNext()) {
            Contact e17 = e.e((QQStrangerLIAItem) it.next());
            if (q16.get(f245114a.F(e17)) == null) {
                arrayList.add(e17);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConcurrentHashMap<String, QQStrangerLIAItem> q(List<QQStrangerLIAItem> itemList) {
        ConcurrentHashMap<String, QQStrangerLIAItem> concurrentHashMap = new ConcurrentHashMap<>();
        for (QQStrangerLIAItem qQStrangerLIAItem : itemList) {
            concurrentHashMap.put(f245114a.F(e.e(qQStrangerLIAItem)), qQStrangerLIAItem);
        }
        return concurrentHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final o82.b s() {
        return (o82.b) filter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b v() {
        return (b) msgCollector.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQStrangerLIARepo w() {
        return (QQStrangerLIARepo) repo.getValue();
    }

    private final Handler x() {
        return (Handler) uiHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(List<Contact> contactList) {
        List<Contact> listOf;
        if (contactList.isEmpty()) {
            return;
        }
        Iterator<T> it = anyLIAChangedListenerList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(contactList);
        }
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerLIAChangedEvent(contactList));
        for (Contact contact : contactList) {
            List<a> list = singleLIAChangedListenerMap.get(f245114a.F(contact));
            if (list != null) {
                for (a aVar : list) {
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(contact);
                    aVar.a(listOf);
                }
            }
        }
    }

    public final void A(List<RecentContactInfo> contactList) {
        Intrinsics.checkNotNullParameter(contactList, "contactList");
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.b.f261780e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "QQStrangerLIAHelper#refreshLIA", null, null, null, new QQStrangerLIAHelper$refreshLIA$1(contactList, null), 14, null);
        }
    }

    public final void C(QQStrangerLIAItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getHasReportExpose()) {
            return;
        }
        item.j(true);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.b.f261780e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "QQStrangerLIAHelper#reportExpoLIA", null, null, null, new QQStrangerLIAHelper$reportExpoLIA$1(item, null), 14, null);
        }
    }

    public final void n() {
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.b.f261780e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "QQStrangerLIAHelper#checkLIA", null, null, null, new QQStrangerLIAHelper$checkLIA$1(null), 14, null);
        }
    }

    public final void o(QQStrangerLIAItem item, int scene) {
        QQStrangerLIAItem qQStrangerLIAItem;
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.d("QQStrangerLIAHelper", 1, "closeLIA chatType=" + item.getChatType() + ", peerTinyId=" + item.getPeerTinyId() + ", scene=" + scene);
        ConcurrentHashMap<String, QQStrangerLIAItem> concurrentHashMap = liaItemMap;
        if (concurrentHashMap == null || (qQStrangerLIAItem = concurrentHashMap.get(F(e.e(item)))) == null) {
            return;
        }
        f245114a.B(qQStrangerLIAItem, scene);
    }

    public final QQStrangerLIAItem t(Contact contact) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        ConcurrentHashMap<String, QQStrangerLIAItem> concurrentHashMap = liaItemMap;
        if (concurrentHashMap != null) {
            return concurrentHashMap.get(F(contact));
        }
        return null;
    }

    public final QQStrangerLIAItem u(Contact contact, int scene) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        QQStrangerLIAItem t16 = t(contact);
        if (t16 != null && t16.i(scene)) {
            return t16;
        }
        return null;
    }

    public final void z(List<MsgRecord> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (MsgRecord msgRecord : msgList) {
            String str = msgRecord.chatType + "-" + msgRecord.peerUid;
            if (linkedHashMap.get(str) == null) {
                linkedHashMap.put(str, new Contact(msgRecord.chatType, msgRecord.peerUid, ""));
            }
        }
        for (Contact contact : linkedHashMap.values()) {
            ConcurrentHashMap<String, QQStrangerLIAItem> concurrentHashMap = liaItemMap;
            QQStrangerLIAItem qQStrangerLIAItem = concurrentHashMap != null ? concurrentHashMap.get(f245114a.F(contact)) : null;
            if (qQStrangerLIAItem != null) {
                QLog.d("QQStrangerLIAHelper", 1, "onAddNewMsg " + contact.chatType + "-" + contact.peerUid);
                f245114a.B(qQStrangerLIAItem, 3);
            }
        }
    }

    private final void B(QQStrangerLIAItem item, int scene) {
        boolean z16 = item.i(1) && (scene & 1) == 1;
        int showScene = (~scene) & item.getShowScene();
        boolean z17 = showScene != item.getShowScene();
        item.k(showScene);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "QQStrangerLIAHelper#removeAndReportLIA", null, null, null, new QQStrangerLIAHelper$removeAndReportLIA$1(item, z17, z16, null), 14, null);
        }
    }

    public final void r() {
        liaItemMap = null;
        D(new Function0<Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAHelper$destroyLIA$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List list;
                Map map;
                list = QQStrangerLIAHelper.anyLIAChangedListenerList;
                list.clear();
                map = QQStrangerLIAHelper.singleLIAChangedListenerMap;
                map.clear();
            }
        });
    }

    public static /* synthetic */ void p(QQStrangerLIAHelper qQStrangerLIAHelper, QQStrangerLIAItem qQStrangerLIAItem, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 3;
        }
        qQStrangerLIAHelper.o(qQStrangerLIAItem, i3);
    }
}
