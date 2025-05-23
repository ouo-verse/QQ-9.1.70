package com.tencent.ecommerce.biz.mainpage;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ecommerce/biz/mainpage/ECHRMainPageFragment;", "Lcom/tencent/ecommerce/biz/mainpage/ECBaseMainPageFragment;", "", "Lcom/tencent/ecommerce/biz/mainpage/d;", "Lh", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECHRMainPageFragment extends ECBaseMainPageFragment {
    @Override // com.tencent.ecommerce.biz.mainpage.ECBaseMainPageFragment
    public List<ECMainPageItem> Lh() {
        List<ECMainPageItem> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new ECMainPageItem("Kuikly\u9875\u9762Debug\u8def\u7531", "mqqapi://ecommerce/open?target=52&src_type=internal&version=1&biz_type=1&channel=8&page_name=router", null, null, 12, null));
        return listOf;
    }
}
