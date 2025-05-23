package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.Entry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StLike;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StComment;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCommentKt {
    public static final CommonComment toCommon(StComment stComment) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        List<CommonReply> mutableList;
        int collectionSizeOrDefault3;
        int collectionSizeOrDefault4;
        List<CommonEntry> mutableList2;
        CommonComment commonComment = new CommonComment();
        commonComment.setId(stComment.id);
        commonComment.setUser(CommonUserKt.toCommon(stComment.user));
        List<StRichMsg> list = stComment.content;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonRichMsgKt.toCommon((StRichMsg) it.next()));
        }
        commonComment.setContent(arrayList);
        Long l3 = stComment.time;
        commonComment.setTime(l3 != null ? l3.longValue() : 0L);
        List<StReply> list2 = stComment.replys;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = list2.iterator();
        while (it5.hasNext()) {
            arrayList2.add(CommonReplyKt.toCommon((StReply) it5.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        commonComment.setReplys(mutableList);
        Long l16 = stComment.replyNum;
        commonComment.setReplyNum(l16 != null ? l16.longValue() : 0L);
        commonComment.setClientKey(stComment.clientKey);
        List<StMedia> list3 = stComment.mediaItems;
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault3);
        Iterator<T> it6 = list3.iterator();
        while (it6.hasNext()) {
            arrayList3.add(CommonMediaKt.toCommon((StMedia) it6.next()));
        }
        commonComment.setMediaItems(arrayList3);
        commonComment.setLike(CommonLikeKt.toCommon(stComment.like));
        List<Entry> list4 = stComment.mapExt;
        collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault4);
        Iterator<T> it7 = list4.iterator();
        while (it7.hasNext()) {
            arrayList4.add(CommonEntryKt.toCommon((Entry) it7.next()));
        }
        mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList4);
        commonComment.setMapExt(mutableList2);
        commonComment.setHasMoreReply(stComment.hasMoreReply);
        commonComment.setReplyAttachInfo(stComment.replyAttachInfo);
        return commonComment;
    }

    public static final StComment toPb(CommonComment commonComment) {
        int collectionSizeOrDefault;
        List mutableList;
        int collectionSizeOrDefault2;
        List mutableList2;
        int collectionSizeOrDefault3;
        List mutableList3;
        int collectionSizeOrDefault4;
        List mutableList4;
        String id5 = commonComment.getId();
        StUser pb5 = CommonUserKt.toPb(commonComment.getUser());
        List<CommonRichMsg> content = commonComment.getContent();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(content, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = content.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonRichMsgKt.toPb((CommonRichMsg) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        Long valueOf = Long.valueOf(commonComment.getTime());
        List<CommonReply> replys = commonComment.getReplys();
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(replys, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = replys.iterator();
        while (it5.hasNext()) {
            arrayList2.add(CommonReplyKt.toPb((CommonReply) it5.next()));
        }
        mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        Long valueOf2 = Long.valueOf(commonComment.getReplyNum());
        String clientKey = commonComment.getClientKey();
        List<CommonMedia> mediaItems = commonComment.getMediaItems();
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(mediaItems, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault3);
        Iterator<T> it6 = mediaItems.iterator();
        while (it6.hasNext()) {
            arrayList3.add(CommonMediaKt.toPb((CommonMedia) it6.next()));
        }
        mutableList3 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList3);
        StLike pb6 = CommonLikeKt.toPb(commonComment.getLike());
        List<CommonEntry> mapExt = commonComment.getMapExt();
        collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(mapExt, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault4);
        Iterator<T> it7 = mapExt.iterator();
        while (it7.hasNext()) {
            arrayList4.add(CommonEntryKt.toPb((CommonEntry) it7.next()));
        }
        mutableList4 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList4);
        return new StComment(id5, pb5, mutableList, valueOf, mutableList2, valueOf2, clientKey, mutableList3, pb6, mutableList4, commonComment.getHasMoreReply(), commonComment.getReplyAttachInfo());
    }
}
