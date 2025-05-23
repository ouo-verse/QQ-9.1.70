package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellShare;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StRichMsg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001H\u0000\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellShare;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellShare;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellShareKt {
    public static final CommonCellShare toCommon(StCellShare stCellShare) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        int collectionSizeOrDefault3;
        if (stCellShare == null) {
            return null;
        }
        CommonCellShare commonCellShare = new CommonCellShare();
        Integer num = stCellShare.type;
        commonCellShare.setType(num != null ? num.intValue() : 0);
        List<StRichMsg> list = stCellShare.title;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonRichMsgKt.toCommon((StRichMsg) it.next()));
        }
        commonCellShare.setTitle(arrayList);
        List<StRichMsg> list2 = stCellShare.summary;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = list2.iterator();
        while (it5.hasNext()) {
            arrayList2.add(CommonRichMsgKt.toCommon((StRichMsg) it5.next()));
        }
        commonCellShare.setSummary(arrayList2);
        List<StMedia> list3 = stCellShare.medias;
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault3);
        Iterator<T> it6 = list3.iterator();
        while (it6.hasNext()) {
            arrayList3.add(CommonMediaKt.toCommon((StMedia) it6.next()));
        }
        commonCellShare.setMedias(arrayList3);
        commonCellShare.setActionUrl(stCellShare.actionUrl);
        commonCellShare.setAdditionalInfo(stCellShare.additionalInfo);
        return commonCellShare;
    }

    public static final StCellShare toPb(CommonCellShare commonCellShare) {
        int collectionSizeOrDefault;
        List mutableList;
        int collectionSizeOrDefault2;
        List mutableList2;
        int collectionSizeOrDefault3;
        List mutableList3;
        if (commonCellShare == null) {
            return null;
        }
        Integer valueOf = Integer.valueOf(commonCellShare.getType());
        List<CommonRichMsg> title = commonCellShare.getTitle();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(title, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = title.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonRichMsgKt.toPb((CommonRichMsg) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        List<CommonRichMsg> summary = commonCellShare.getSummary();
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(summary, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = summary.iterator();
        while (it5.hasNext()) {
            arrayList2.add(CommonRichMsgKt.toPb((CommonRichMsg) it5.next()));
        }
        mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        List<CommonMedia> medias = commonCellShare.getMedias();
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(medias, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault3);
        Iterator<T> it6 = medias.iterator();
        while (it6.hasNext()) {
            arrayList3.add(CommonMediaKt.toPb((CommonMedia) it6.next()));
        }
        mutableList3 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList3);
        return new StCellShare(valueOf, mutableList, mutableList2, mutableList3, commonCellShare.getActionUrl(), commonCellShare.getAdditionalInfo());
    }
}
