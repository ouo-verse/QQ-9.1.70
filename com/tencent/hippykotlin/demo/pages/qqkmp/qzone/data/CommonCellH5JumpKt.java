package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellH5Jump;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StH5JumpUrl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001H\u0000\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellH5Jump;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellH5Jump;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellH5JumpKt {
    public static final CommonCellH5Jump toCommon(StCellH5Jump stCellH5Jump) {
        int collectionSizeOrDefault;
        List<CommonH5JumpUrl> mutableList;
        if (stCellH5Jump == null) {
            return null;
        }
        CommonCellH5Jump commonCellH5Jump = new CommonCellH5Jump();
        List<StH5JumpUrl> list = stCellH5Jump.h5JumpUrl;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonH5JumpUrl_Kt.toCommon((StH5JumpUrl) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        commonCellH5Jump.setH5JumpUrl(mutableList);
        return commonCellH5Jump;
    }

    public static final StCellH5Jump toPb(CommonCellH5Jump commonCellH5Jump) {
        int collectionSizeOrDefault;
        List mutableList;
        if (commonCellH5Jump == null) {
            return null;
        }
        List<CommonH5JumpUrl> h5JumpUrl = commonCellH5Jump.getH5JumpUrl();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(h5JumpUrl, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = h5JumpUrl.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonH5JumpUrl_Kt.toPb((CommonH5JumpUrl) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return new StCellH5Jump(mutableList);
    }
}
