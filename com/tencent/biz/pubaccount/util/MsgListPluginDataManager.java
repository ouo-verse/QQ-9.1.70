package com.tencent.biz.pubaccount.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.entity.MsgListPluginEntity;
import com.tencent.biz.pb.clientbusilogic$GetPluginListReq;
import com.tencent.biz.pb.clientbusilogic$GetPluginListRsp;
import com.tencent.biz.pb.clientbusilogic$PublicAccountInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.cardcontainer.api.IChatListTestAndVibrateApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.DeleteTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.apache.httpcore.message.TokenParser;

@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0007*\u0001-\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0018\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJL\u0010\u001e\u001a\u00020\u00022D\u0010\u001d\u001a@\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0018J\u0006\u0010\u001f\u001a\u00020\u0002R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000e0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010\"R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/biz/pubaccount/util/MsgListPluginDataManager;", "", "", "o", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/persistence/EntityManager;", "j", "l", "", "Lcom/tencent/biz/entity/MsgListPluginEntity;", "changeList", DomainData.DOMAIN_NAME, "", "from", "Lux/a;", "listener", "g", "p", "", "uin", "i", "data", "t", tl.h.F, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "enableList", "disableList", "onGetData", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/util/concurrent/CopyOnWriteArrayList;", "b", "Ljava/util/concurrent/CopyOnWriteArrayList;", "pluginList", "c", "Lcom/tencent/mobileqq/persistence/EntityManager;", "entityManager", "d", "bizListeners", "", "e", "Z", "hasDBInit", "com/tencent/biz/pubaccount/util/MsgListPluginDataManager$receiver$1", "f", "Lcom/tencent/biz/pubaccount/util/MsgListPluginDataManager$receiver$1;", "receiver", "<init>", "()V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class MsgListPluginDataManager {

    /* renamed from: a, reason: collision with root package name */
    public static final MsgListPluginDataManager f80156a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static CopyOnWriteArrayList<MsgListPluginEntity> pluginList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static EntityManager entityManager;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<ux.a> bizListeners;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean hasDBInit;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final MsgListPluginDataManager$receiver$1 receiver;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/biz/pubaccount/util/MsgListPluginDataManager$a", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class a extends ProtoUtils.TroopProtocolObserver {
        a() {
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, byte[] data, Bundle bundle) {
            ArrayList arrayList;
            ArrayList arrayList2;
            int collectionSizeOrDefault;
            int collectionSizeOrDefault2;
            if (errorCode == 0 && data != null) {
                clientbusilogic$GetPluginListRsp clientbusilogic_getpluginlistrsp = new clientbusilogic$GetPluginListRsp();
                try {
                    clientbusilogic_getpluginlistrsp.mergeFrom(data);
                    List<clientbusilogic$PublicAccountInfo> list = clientbusilogic_getpluginlistrsp.enable_list.get();
                    List<clientbusilogic$PublicAccountInfo> list2 = clientbusilogic_getpluginlistrsp.disable_list.get();
                    if (list != null) {
                        List<clientbusilogic$PublicAccountInfo> list3 = list;
                        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                        arrayList = new ArrayList(collectionSizeOrDefault2);
                        Iterator<T> it = list3.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new MsgListPluginEntity().convertFromPublicAccountInfo((clientbusilogic$PublicAccountInfo) it.next(), true));
                        }
                    } else {
                        arrayList = null;
                    }
                    if (list2 != null) {
                        List<clientbusilogic$PublicAccountInfo> list4 = list2;
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
                        arrayList2 = new ArrayList(collectionSizeOrDefault);
                        Iterator<T> it5 = list4.iterator();
                        while (it5.hasNext()) {
                            arrayList2.add(new MsgListPluginEntity().convertFromPublicAccountInfo((clientbusilogic$PublicAccountInfo) it5.next(), false));
                        }
                    } else {
                        arrayList2 = null;
                    }
                    MsgListPluginDataManager.pluginList.clear();
                    if (arrayList != null) {
                        MsgListPluginDataManager.pluginList.addAll(arrayList);
                    }
                    if (arrayList2 != null) {
                        MsgListPluginDataManager.pluginList.addAll(arrayList2);
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("fetchMsgListPluginData rsp enable ");
                    sb5.append(arrayList != null ? Integer.valueOf(arrayList.size()) : null);
                    sb5.append(" disable ");
                    sb5.append(arrayList2 != null ? Integer.valueOf(arrayList2.size()) : null);
                    sb5.append(" total ");
                    sb5.append(MsgListPluginDataManager.pluginList.size());
                    QLog.i("MsgListPluginDataManager", 1, sb5.toString());
                    MsgListPluginDataManager msgListPluginDataManager = MsgListPluginDataManager.f80156a;
                    msgListPluginDataManager.q();
                    msgListPluginDataManager.n(MsgListPluginDataManager.pluginList);
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            QLog.d("MsgListPluginDataManager", 2, "getPluginList fail, server error:" + errorCode);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes32.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((MsgListPluginEntity) t16).pluginIndex), Integer.valueOf(((MsgListPluginEntity) t17).pluginIndex));
            return compareValues;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.biz.pubaccount.util.MsgListPluginDataManager$receiver$1] */
    static {
        MsgListPluginDataManager msgListPluginDataManager = new MsgListPluginDataManager();
        f80156a = msgListPluginDataManager;
        pluginList = new CopyOnWriteArrayList<>();
        bizListeners = new CopyOnWriteArrayList<>();
        if (((IChatListTestAndVibrateApi) QRoute.api(IChatListTestAndVibrateApi.class)).getPublicAccountPluginSwitch()) {
            QLog.i("MsgListPluginDataManager", 1, "on init change");
            hasDBInit = false;
            msgListPluginDataManager.o();
            msgListPluginDataManager.s();
        }
        receiver = new BroadcastReceiver() { // from class: com.tencent.biz.pubaccount.util.MsgListPluginDataManager$receiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (((IChatListTestAndVibrateApi) QRoute.api(IChatListTestAndVibrateApi.class)).getPublicAccountPluginSwitch()) {
                    MsgListPluginDataManager.hasDBInit = false;
                    QLog.i("MsgListPluginDataManager", 1, "on account change");
                    MsgListPluginDataManager.f80156a.s();
                }
            }
        };
    }

    MsgListPluginDataManager() {
    }

    private final EntityManager j() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("MsgListPluginDataManager", 1, "fetchPageData error. app is null.");
            return null;
        }
        return peekAppRuntime.getEntityManagerFactory().createEntityManager();
    }

    private final void l() {
        if (!((IChatListTestAndVibrateApi) QRoute.api(IChatListTestAndVibrateApi.class)).getPublicAccountPluginSwitch()) {
            QLog.i("MsgListPluginDataManager", 1, "loadPluginListFromDB fail because switch is off");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.pubaccount.util.e
                @Override // java.lang.Runnable
                public final void run() {
                    MsgListPluginDataManager.m();
                }
            }, 32, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m() {
        EntityManager entityManager2 = entityManager;
        List<? extends Entity> query = entityManager2 != null ? entityManager2.query(MsgListPluginEntity.class, true, null, null, null, null, "", null) : null;
        if (!(query instanceof List)) {
            query = null;
        }
        boolean z16 = false;
        if (query != null && (!query.isEmpty())) {
            z16 = true;
        }
        if (!z16) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("loadPluginFromDB entryList ");
            sb5.append(query != null ? Integer.valueOf(query.size()) : null);
            QLog.i("MsgListPluginDataManager", 1, sb5.toString());
            f80156a.h("after loadPluginListFromDB");
            return;
        }
        pluginList.clear();
        pluginList.addAll(query);
        hasDBInit = true;
        QLog.i("MsgListPluginDataManager", 1, "loaded from db " + pluginList.size());
        MsgListPluginDataManager msgListPluginDataManager = f80156a;
        msgListPluginDataManager.n(pluginList);
        msgListPluginDataManager.h("after loadPluginListFromDB");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(List<? extends MsgListPluginEntity> changeList) {
        Iterator<T> it = bizListeners.iterator();
        while (it.hasNext()) {
            ((ux.a) it.next()).a(new ArrayList<>(changeList));
        }
    }

    private final void o() {
        if (BaseApplication.getContext() == null || BaseApplication.getContext().getContentResolver() == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NewIntent.ACTION_LOGIN);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        MobileQQ.sMobileQQ.registerReceiver(receiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DeleteTransaction(MsgListPluginEntity.class.getSimpleName(), null, null));
        for (MsgListPluginEntity msgListPluginEntity : pluginList) {
            msgListPluginEntity.setStatus(1000);
            arrayList.add(new PersistOrReplaceTransaction(msgListPluginEntity));
        }
        EntityManager entityManager2 = entityManager;
        QLog.d("MsgListPluginDataManager", 1, "savePluginList to DB result " + (entityManager2 != null ? Boolean.valueOf(entityManager2.doMultiDBOperateByTransaction(arrayList)) : null) + " size " + arrayList.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        EntityManager entityManager2 = entityManager;
        if (entityManager2 != null) {
            entityManager2.close();
        }
        entityManager = j();
        l();
    }

    public final void g(String from, ux.a listener) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<ux.a> copyOnWriteArrayList = bizListeners;
        if (copyOnWriteArrayList.contains(listener)) {
            QLog.i("MsgListPluginDataManager", 1, from + " Add listener repeatedly");
            return;
        }
        QLog.i("MsgListPluginDataManager", 1, from + " Add listener " + listener);
        copyOnWriteArrayList.add(listener);
    }

    public final void h(String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        if (!((IChatListTestAndVibrateApi) QRoute.api(IChatListTestAndVibrateApi.class)).getPublicAccountPluginSwitch()) {
            QLog.i("MsgListPluginDataManager", 1, "loadPluginListFromDB from " + from + " fail because switch is off");
            return;
        }
        QLog.i("MsgListPluginDataManager", 1, "fetchMsgListPluginData from " + from);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ProtoUtils.a(peekAppRuntime, new a(), new MessageMicro<clientbusilogic$GetPluginListReq>() { // from class: com.tencent.biz.pb.clientbusilogic$GetPluginListReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], clientbusilogic$GetPluginListReq.class);
        }.toByteArray(), "OidbSvcTrpcTcp.0x93ef_1", 37871, 1);
    }

    public final MsgListPluginEntity i(String from, long uin) {
        Object obj;
        Intrinsics.checkNotNullParameter(from, "from");
        Iterator<T> it = pluginList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((MsgListPluginEntity) obj).luin == uin) {
                break;
            }
        }
        MsgListPluginEntity msgListPluginEntity = (MsgListPluginEntity) obj;
        if (msgListPluginEntity == null && !hasDBInit) {
            EntityManager entityManager2 = entityManager;
            MsgListPluginEntity msgListPluginEntity2 = (MsgListPluginEntity) (entityManager2 != null ? DBMethodProxy.find(entityManager2, (Class<? extends Entity>) MsgListPluginEntity.class, String.valueOf(uin)) : null);
            QLog.i("MsgListPluginDataManager", 1, "getEntityByUin by db from " + from + ",  uin " + uin + " , entity " + msgListPluginEntity2 + " , entityManager " + entityManager);
            return msgListPluginEntity2;
        }
        QLog.i("MsgListPluginDataManager", 1, "getEntityByUin by cache from " + from + " uin " + uin + " hasDBInit " + hasDBInit + " entity " + msgListPluginEntity);
        return msgListPluginEntity;
    }

    public final void k(Function2<? super List<? extends MsgListPluginEntity>, ? super List<? extends MsgListPluginEntity>, Unit> onGetData) {
        List emptyList;
        List emptyList2;
        if (pluginList.isEmpty() && onGetData != null) {
            onGetData.invoke(new ArrayList(), new ArrayList());
        }
        CopyOnWriteArrayList<MsgListPluginEntity> copyOnWriteArrayList = pluginList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        for (Object obj : copyOnWriteArrayList) {
            if (((MsgListPluginEntity) obj).isEnable) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList();
                }
                TypeIntrinsics.asMutableList(emptyList).add(obj);
            }
        }
        CopyOnWriteArrayList<MsgListPluginEntity> copyOnWriteArrayList2 = pluginList;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        for (Object obj2 : copyOnWriteArrayList2) {
            if (true ^ ((MsgListPluginEntity) obj2).isEnable) {
                if (emptyList2.isEmpty()) {
                    emptyList2 = new ArrayList();
                }
                TypeIntrinsics.asMutableList(emptyList2).add(obj2);
            }
        }
        if (onGetData != null) {
            QLog.i("MsgListPluginDataManager", 1, "fetchMsgListPluginData rsp enable " + emptyList.size() + " disable " + emptyList2.size() + " total " + pluginList.size());
            onGetData.invoke(emptyList, emptyList2);
        }
    }

    public final void p(String from, ux.a listener) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<ux.a> copyOnWriteArrayList = bizListeners;
        if (!copyOnWriteArrayList.contains(listener)) {
            QLog.i("MsgListPluginDataManager", 1, from + TokenParser.SP + listener + " listener not add");
            return;
        }
        QLog.i("MsgListPluginDataManager", 1, from + " remove listener " + listener);
        copyOnWriteArrayList.remove(listener);
    }

    public final void q() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.pubaccount.util.f
            @Override // java.lang.Runnable
            public final void run() {
                MsgListPluginDataManager.r();
            }
        }, 32, null, true);
    }

    public final void t(String from, MsgListPluginEntity data) {
        Intrinsics.checkNotNullParameter(from, "from");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getEntityByUin by db from ");
        sb5.append(from);
        sb5.append(" uin ");
        sb5.append(data != null ? Long.valueOf(data.luin) : null);
        QLog.i("MsgListPluginDataManager", 1, sb5.toString());
        if (data == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(pluginList);
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "tempPluginList.iterator()");
        boolean z16 = false;
        while (it.hasNext()) {
            MsgListPluginEntity msgListPluginEntity = (MsgListPluginEntity) it.next();
            if (msgListPluginEntity.luin == data.luin && Intrinsics.areEqual(msgListPluginEntity.accountUid, data.accountUid)) {
                it.remove();
                z16 = true;
            }
        }
        if (z16) {
            arrayList.add(data);
        }
        if (arrayList.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new b());
        }
        pluginList.clear();
        pluginList.addAll(arrayList);
        ArrayList arrayList2 = new ArrayList(Collections.singletonList(data));
        q();
        n(arrayList2);
    }
}
