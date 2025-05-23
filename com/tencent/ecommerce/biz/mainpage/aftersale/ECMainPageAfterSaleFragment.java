package com.tencent.ecommerce.biz.mainpage.aftersale;

import com.tencent.ecommerce.biz.mainpage.ECBaseMainPageFragment;
import com.tencent.ecommerce.biz.mainpage.ECMainPageFragmentType;
import com.tencent.ecommerce.biz.mainpage.ECMainPageItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eB\t\b\u0016\u00a2\u0006\u0004\b\r\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016R\u001a\u0010\f\u001a\u00020\u00078\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/mainpage/aftersale/ECMainPageAfterSaleFragment;", "Lcom/tencent/ecommerce/biz/mainpage/ECBaseMainPageFragment;", "", "Bh", "", "Lcom/tencent/ecommerce/biz/mainpage/d;", "Lh", "Lcom/tencent/ecommerce/biz/mainpage/ECMainPageFragmentType;", "T", "Lcom/tencent/ecommerce/biz/mainpage/ECMainPageFragmentType;", "Mh", "()Lcom/tencent/ecommerce/biz/mainpage/ECMainPageFragmentType;", "type", "<init>", "(Lcom/tencent/ecommerce/biz/mainpage/ECMainPageFragmentType;)V", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECMainPageAfterSaleFragment extends ECBaseMainPageFragment {

    /* renamed from: T, reason: from kotlin metadata */
    private final ECMainPageFragmentType type;

    public ECMainPageAfterSaleFragment(ECMainPageFragmentType eCMainPageFragmentType) {
        this.type = eCMainPageFragmentType;
    }

    @Override // com.tencent.ecommerce.biz.mainpage.ECBaseMainPageFragment, com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Bh() {
        return false;
    }

    @Override // com.tencent.ecommerce.biz.mainpage.ECBaseMainPageFragment
    public List<ECMainPageItem> Lh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ECMainPageItem("\u6210\u4ea4\u6570\u636e", "mqqapi://ecommerce/open?target=12&channel=2", null, null, 12, null));
        arrayList.add(new ECMainPageItem("\u5356\u65b9\u8ba2\u5355\u9875", "mqqapi://ecommerce/open?target=6&channel=2", null, null, 12, null));
        arrayList.add(new ECMainPageItem("\u4e70\u65b9\u8ba2\u5355\u9875", "mqqapi://ecommerce/open?target=2&channel=2", null, null, 12, null));
        arrayList.add(new ECMainPageItem("\u4f63\u91d1\u660e\u7ec6", "mqqapi://ecommerce/open?target=4&channel=2", null, null, 12, null));
        arrayList.add(new ECMainPageItem("\u6211\u7684\u4f63\u91d1", "mqqapi://ecommerce/open?target=11&channel=2", null, null, 12, null));
        arrayList.add(new ECMainPageItem("\u9884\u4f30\u4f63\u91d1", "mqqapi://ecommerce/open?target=29&channel=2", null, null, 12, null));
        arrayList.add(new ECMainPageItem("\u8ba2\u5355\u8bc4\u4ef7", "mqqapi://ecommerce/open?target=3&channel=2", null, null, 12, null));
        return arrayList;
    }

    @Override // com.tencent.ecommerce.biz.mainpage.ECBaseMainPageFragment
    /* renamed from: Mh, reason: from getter */
    public ECMainPageFragmentType getType() {
        return this.type;
    }

    public ECMainPageAfterSaleFragment() {
        this(ECMainPageFragmentType.MAIN_PAGE_TYPE_OTHER);
    }
}
