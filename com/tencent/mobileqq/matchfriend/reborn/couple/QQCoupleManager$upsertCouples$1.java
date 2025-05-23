package com.tencent.mobileqq.matchfriend.reborn.couple;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.IQQCoupleModel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/IQQCoupleModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class QQCoupleManager$upsertCouples$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $coupleId;
    final /* synthetic */ List<T> $newCoupleList;
    final /* synthetic */ QQCoupleManager<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QQCoupleManager$upsertCouples$1(List<? extends T> list, QQCoupleManager<T> qQCoupleManager, String str) {
        super(0);
        this.$newCoupleList = list;
        this.this$0 = qQCoupleManager;
        this.$coupleId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Map needNotifyCoupleMap, QQCoupleManager this$0) {
        QQCoupleStorage qQCoupleStorage;
        Intrinsics.checkNotNullParameter(needNotifyCoupleMap, "$needNotifyCoupleMap");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList<IQQCoupleModel> arrayList = new ArrayList(needNotifyCoupleMap.size());
        Iterator it = needNotifyCoupleMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((IQQCoupleModel) ((Map.Entry) it.next()).getValue());
        }
        for (IQQCoupleModel iQQCoupleModel : arrayList) {
            qQCoupleStorage = this$0.com.tencent.mobileqq.qqpermission.QQPermissionConstants.Permission.STORAGE_GROUP java.lang.String;
            if (qQCoupleStorage != null) {
                qQCoupleStorage.e(iQQCoupleModel);
            }
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        String str;
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        String str2;
        Iterable iterable = this.$newCoupleList;
        String str3 = this.$coupleId;
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (Intrinsics.areEqual(((IQQCoupleModel) obj).coupleId, str3)) {
                arrayList.add(obj);
            }
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        QQCoupleManager<T> qQCoupleManager = this.this$0;
        String str4 = this.$coupleId;
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            IQQCoupleModel iQQCoupleModel = (IQQCoupleModel) it.next();
            concurrentHashMap = ((QQCoupleManager) qQCoupleManager).cache;
            ConcurrentHashMap concurrentHashMap3 = (ConcurrentHashMap) concurrentHashMap.get(str4);
            IQQCoupleModel iQQCoupleModel2 = concurrentHashMap3 != null ? (IQQCoupleModel) concurrentHashMap3.get(iQQCoupleModel.subtype) : null;
            if (QLog.isDevelopLevel()) {
                str2 = ((QQCoupleManager) qQCoupleManager).tag;
                QLog.i(str2, 1, "[upsertCouples]cacheCouple=" + iQQCoupleModel2 + ", newCouple=" + iQQCoupleModel);
            }
            if (!Intrinsics.areEqual(iQQCoupleModel, iQQCoupleModel2)) {
                concurrentHashMap2 = ((QQCoupleManager) qQCoupleManager).cache;
                ConcurrentHashMap concurrentHashMap4 = (ConcurrentHashMap) concurrentHashMap2.get(str4);
                if (concurrentHashMap4 != null) {
                    Intrinsics.checkNotNullExpressionValue(concurrentHashMap4, "cache[coupleId]");
                    concurrentHashMap4.put(iQQCoupleModel.subtype, iQQCoupleModel);
                }
                linkedHashMap.put(iQQCoupleModel.subtype, iQQCoupleModel);
            }
        }
        if (!linkedHashMap.isEmpty()) {
            QQCoupleManager<T> qQCoupleManager2 = this.this$0;
            String str5 = this.$coupleId;
            ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
            Iterator it5 = linkedHashMap.entrySet().iterator();
            while (it5.hasNext()) {
                arrayList2.add((String) ((Map.Entry) it5.next()).getKey());
            }
            qQCoupleManager2.u(str5, arrayList2);
            final QQCoupleManager<T> qQCoupleManager3 = this.this$0;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.couple.f
                @Override // java.lang.Runnable
                public final void run() {
                    QQCoupleManager$upsertCouples$1.b(linkedHashMap, qQCoupleManager3);
                }
            }, 32, null, false);
            return;
        }
        if (QLog.isDevelopLevel()) {
            str = ((QQCoupleManager) this.this$0).tag;
            QLog.i(str, 1, "[upsertCouples] coupleId=" + this.$coupleId + " needn't notify.");
        }
    }
}
