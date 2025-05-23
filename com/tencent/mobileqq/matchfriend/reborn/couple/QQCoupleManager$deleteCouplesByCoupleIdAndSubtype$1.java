package com.tencent.mobileqq.matchfriend.reborn.couple;

import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/IQQCoupleModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class QQCoupleManager$deleteCouplesByCoupleIdAndSubtype$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $coupleId;
    final /* synthetic */ List<String> $subTypes;
    final /* synthetic */ QQCoupleManager<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQCoupleManager$deleteCouplesByCoupleIdAndSubtype$1(QQCoupleManager<T> qQCoupleManager, String str, List<String> list) {
        super(0);
        this.this$0 = qQCoupleManager;
        this.$coupleId = str;
        this.$subTypes = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Set needDeleteSubTypes, QQCoupleManager this$0, String coupleId) {
        QQCoupleStorage qQCoupleStorage;
        Intrinsics.checkNotNullParameter(needDeleteSubTypes, "$needDeleteSubTypes");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(coupleId, "$coupleId");
        Iterator it = needDeleteSubTypes.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            qQCoupleStorage = this$0.com.tencent.mobileqq.qqpermission.QQPermissionConstants.Permission.STORAGE_GROUP java.lang.String;
            if (qQCoupleStorage != null) {
                qQCoupleStorage.b(coupleId, str);
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
        ConcurrentHashMap concurrentHashMap;
        Set set;
        final Set intersect;
        ConcurrentHashMap concurrentHashMap2;
        List list;
        concurrentHashMap = ((QQCoupleManager) this.this$0).cache;
        ConcurrentHashMap concurrentHashMap3 = (ConcurrentHashMap) concurrentHashMap.get(this.$coupleId);
        if (concurrentHashMap3 == null || concurrentHashMap3.isEmpty()) {
            return;
        }
        if (this.$subTypes.isEmpty()) {
            ArrayList arrayList = new ArrayList(concurrentHashMap3.size());
            Iterator it = concurrentHashMap3.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add((String) ((Map.Entry) it.next()).getKey());
            }
            intersect = CollectionsKt___CollectionsKt.toSet(arrayList);
        } else {
            ArrayList arrayList2 = new ArrayList(concurrentHashMap3.size());
            Iterator it5 = concurrentHashMap3.entrySet().iterator();
            while (it5.hasNext()) {
                arrayList2.add((String) ((Map.Entry) it5.next()).getKey());
            }
            set = CollectionsKt___CollectionsKt.toSet(this.$subTypes);
            intersect = CollectionsKt___CollectionsKt.intersect(arrayList2, set);
        }
        if (intersect.isEmpty()) {
            return;
        }
        Iterator it6 = intersect.iterator();
        while (it6.hasNext()) {
            concurrentHashMap3.remove((String) it6.next());
        }
        concurrentHashMap2 = ((QQCoupleManager) this.this$0).cache;
        concurrentHashMap2.put(this.$coupleId, concurrentHashMap3);
        QQCoupleManager<T> qQCoupleManager = this.this$0;
        String str = this.$coupleId;
        list = CollectionsKt___CollectionsKt.toList(intersect);
        qQCoupleManager.u(str, list);
        final QQCoupleManager<T> qQCoupleManager2 = this.this$0;
        final String str2 = this.$coupleId;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.couple.e
            @Override // java.lang.Runnable
            public final void run() {
                QQCoupleManager$deleteCouplesByCoupleIdAndSubtype$1.b(intersect, qQCoupleManager2, str2);
            }
        }, 32, null, false);
    }
}
