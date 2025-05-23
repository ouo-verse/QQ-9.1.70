package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellComment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellComment;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellComment;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellCommentKt {
    public static final CommonCellComment toCommon(StFeedCellComment stFeedCellComment) {
        int collectionSizeOrDefault;
        List<CommonComment> mutableList;
        if (stFeedCellComment == null) {
            return null;
        }
        CommonCellComment commonCellComment = new CommonCellComment();
        Integer num = stFeedCellComment.num;
        commonCellComment.setNum(num != null ? num.intValue() : 0);
        List<StComment> list = stFeedCellComment.comments;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonCommentKt.toCommon((StComment) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        commonCellComment.setComments(mutableList);
        return commonCellComment;
    }

    public static final StFeedCellComment toPb(CommonCellComment commonCellComment) {
        int collectionSizeOrDefault;
        List mutableList;
        if (commonCellComment == null) {
            return null;
        }
        Integer valueOf = Integer.valueOf(commonCellComment.getNum());
        List<CommonComment> comments = commonCellComment.getComments();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(comments, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = comments.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonCommentKt.toPb((CommonComment) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return new StFeedCellComment(valueOf, mutableList);
    }
}
