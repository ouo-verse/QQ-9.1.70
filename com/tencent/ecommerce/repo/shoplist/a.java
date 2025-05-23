package com.tencent.ecommerce.repo.shoplist;

import com.tencent.ecommerce.biz.shoplist.ECPromoteShopItem;
import com.tencent.ecommerce.repo.proto.ecom.window_info_svr.ECWindowInfoSvr$ShowWindowInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0002\u00a8\u0006\u0004"}, d2 = {"", "Lcom/tencent/ecommerce/repo/proto/ecom/window_info_svr/ECWindowInfoSvr$ShowWindowInfo;", "Lcom/tencent/ecommerce/biz/shoplist/a;", "b", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final List<ECPromoteShopItem> b(List<ECWindowInfoSvr$ShowWindowInfo> list) {
        int collectionSizeOrDefault;
        List<ECWindowInfoSvr$ShowWindowInfo> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (ECWindowInfoSvr$ShowWindowInfo eCWindowInfoSvr$ShowWindowInfo : list2) {
            arrayList.add(new ECPromoteShopItem(eCWindowInfoSvr$ShowWindowInfo.name.get(), eCWindowInfoSvr$ShowWindowInfo.icon.get(), eCWindowInfoSvr$ShowWindowInfo.url.get(), eCWindowInfoSvr$ShowWindowInfo.desc.get()));
        }
        return arrayList;
    }
}
