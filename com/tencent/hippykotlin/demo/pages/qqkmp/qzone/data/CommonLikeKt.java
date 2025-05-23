package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StLike;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StLikeMan;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonLike;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StLike;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonLikeKt {
    public static final CommonLike toCommon(StLike stLike) {
        int collectionSizeOrDefault;
        List<CommonLikeMan> mutableList;
        if (stLike == null) {
            return null;
        }
        CommonLike commonLike = new CommonLike();
        commonLike.setId(stLike.id);
        Integer num = stLike.count;
        commonLike.setCount(num != null ? num.intValue() : 0);
        Integer num2 = stLike.status;
        commonLike.setStatus(num2 != null ? num2.intValue() : 0);
        commonLike.setPostUser(CommonUserKt.toCommon(stLike.postUser));
        Integer num3 = stLike.ownerStatus;
        commonLike.setOwnerStatus(num3 != null ? num3.intValue() : 0);
        List<StLikeMan> list = stLike.likeMans;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonLikeManKt.toCommon((StLikeMan) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        commonLike.setLikeMans(mutableList);
        return commonLike;
    }

    public static final StLike toPb(CommonLike commonLike) {
        int collectionSizeOrDefault;
        List mutableList;
        if (commonLike == null) {
            return null;
        }
        String id5 = commonLike.getId();
        Integer valueOf = Integer.valueOf(commonLike.getCount());
        Integer valueOf2 = Integer.valueOf(commonLike.getStatus());
        StUser pb5 = CommonUserKt.toPb(commonLike.getPostUser());
        Integer valueOf3 = Integer.valueOf(commonLike.getOwnerStatus());
        List<CommonLikeMan> likeMans = commonLike.getLikeMans();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(likeMans, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = likeMans.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonLikeManKt.toPb((CommonLikeMan) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return new StLike(id5, valueOf, valueOf2, pb5, valueOf3, mutableList);
    }
}
