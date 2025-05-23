package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionExtID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionID;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0000\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0001\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0001\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/UnionID;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "toCommon", "toPb", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "toJson", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonUnionIDKt {
    public static final e toJson(final CommonUnionID commonUnionID) {
        e eVar = new e();
        eVar.z("ufKey", commonUnionID.getUfKey());
        eVar.z("ugcId", commonUnionID.getUgcId());
        eVar.z("feedId", commonUnionID.getFeedId());
        eVar.D("extIds", new Function1<b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionIDKt$toJson$1$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(b bVar) {
                Iterator<T> it = CommonUnionID.this.getExtIds().iterator();
                while (it.hasNext()) {
                    bVar.a(bVar, CommonUnionExtIDKt.toJson((CommonUnionExtID) it.next()));
                }
            }
        });
        eVar.z("serializedData", commonUnionID.getSerializedData());
        return eVar;
    }

    public static final CommonUnionID toCommon(UnionID unionID) {
        int collectionSizeOrDefault;
        List<CommonUnionExtID> mutableList;
        if (unionID == null) {
            return null;
        }
        CommonUnionID commonUnionID = new CommonUnionID();
        commonUnionID.setUfKey(unionID.ufKey);
        commonUnionID.setUgcId(unionID.ugcId);
        commonUnionID.setFeedId(unionID.feedId);
        List<UnionExtID> list = unionID.extIds;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonUnionExtIDKt.toCommon((UnionExtID) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        commonUnionID.setExtIds(mutableList);
        commonUnionID.setSerializedData(commonUnionID.getSerializedData());
        return commonUnionID;
    }

    public static final UnionID toPb(CommonUnionID commonUnionID) {
        int collectionSizeOrDefault;
        List mutableList;
        if (commonUnionID == null) {
            return null;
        }
        String ufKey = commonUnionID.getUfKey();
        String ugcId = commonUnionID.getUgcId();
        String feedId = commonUnionID.getFeedId();
        List<CommonUnionExtID> extIds = commonUnionID.getExtIds();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(extIds, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = extIds.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonUnionExtIDKt.toPb((CommonUnionExtID) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return new UnionID(ufKey, ugcId, feedId, mutableList, commonUnionID.getSerializedData());
    }
}
