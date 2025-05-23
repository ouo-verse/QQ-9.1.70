package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.Entry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StLike;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StReply;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StRichMsg;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StReply;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonReplyKt {
    public static final CommonReply toCommon(StReply stReply) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        List<CommonEntry> mutableList;
        CommonReply commonReply = new CommonReply();
        commonReply.setId(stReply.id);
        commonReply.setUser(CommonUserKt.toCommon(stReply.user));
        List<StRichMsg> list = stReply.content;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonRichMsgKt.toCommon((StRichMsg) it.next()));
        }
        commonReply.setContent(arrayList);
        Long l3 = stReply.time;
        commonReply.setTime(l3 != null ? l3.longValue() : 0L);
        commonReply.setClientKey(stReply.clientKey);
        commonReply.setTargetUser(CommonUserKt.toCommon(stReply.targetUser));
        commonReply.setLike(CommonLikeKt.toCommon(stReply.like));
        List<Entry> list2 = stReply.mapExt;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = list2.iterator();
        while (it5.hasNext()) {
            arrayList2.add(CommonEntryKt.toCommon((Entry) it5.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        commonReply.setMapExt(mutableList);
        return commonReply;
    }

    public static final StReply toPb(CommonReply commonReply) {
        int collectionSizeOrDefault;
        List mutableList;
        int collectionSizeOrDefault2;
        List mutableList2;
        String id5 = commonReply.getId();
        StUser pb5 = CommonUserKt.toPb(commonReply.getUser());
        List<CommonRichMsg> content = commonReply.getContent();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(content, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = content.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonRichMsgKt.toPb((CommonRichMsg) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        Long valueOf = Long.valueOf(commonReply.getTime());
        String clientKey = commonReply.getClientKey();
        StUser pb6 = CommonUserKt.toPb(commonReply.getTargetUser());
        StLike pb7 = CommonLikeKt.toPb(commonReply.getLike());
        List<CommonEntry> mapExt = commonReply.getMapExt();
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(mapExt, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = mapExt.iterator();
        while (it5.hasNext()) {
            arrayList2.add(CommonEntryKt.toPb((CommonEntry) it5.next()));
        }
        mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        return new StReply(id5, pb5, mutableList, valueOf, clientKey, pb6, pb7, mutableList2);
    }
}
