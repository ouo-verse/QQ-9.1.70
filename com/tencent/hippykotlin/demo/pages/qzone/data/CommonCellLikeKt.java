package com.tencent.hippykotlin.demo.pages.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonLikeMan;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonLikeManKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellLike;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StLikeMan;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class CommonCellLikeKt {
    public static final CommonCellLike toCommon(StFeedCellLike stFeedCellLike) {
        int collectionSizeOrDefault;
        List<CommonLikeMan> mutableList;
        if (stFeedCellLike == null) {
            return null;
        }
        CommonCellLike commonCellLike = new CommonCellLike();
        Integer num = stFeedCellLike.num;
        commonCellLike.num = num != null ? num.intValue() : 0;
        Boolean bool = stFeedCellLike.liked;
        commonCellLike.liked = bool != null ? bool.booleanValue() : false;
        List<StLikeMan> list = stFeedCellLike.likeMans;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonLikeManKt.toCommon((StLikeMan) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        commonCellLike.likeMans = mutableList;
        commonCellLike.text = stFeedCellLike.text;
        return commonCellLike;
    }

    public static final StFeedCellLike toPb(CommonCellLike commonCellLike) {
        int collectionSizeOrDefault;
        List mutableList;
        if (commonCellLike == null) {
            return null;
        }
        Integer valueOf = Integer.valueOf(commonCellLike.num);
        Boolean valueOf2 = Boolean.valueOf(commonCellLike.liked);
        List<CommonLikeMan> list = commonCellLike.likeMans;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonLikeManKt.toPb((CommonLikeMan) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return new StFeedCellLike(valueOf, valueOf2, mutableList, commonCellLike.text);
    }
}
