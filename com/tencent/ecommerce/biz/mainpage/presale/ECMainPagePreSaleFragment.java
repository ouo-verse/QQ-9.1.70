package com.tencent.ecommerce.biz.mainpage.presale;

import android.net.Uri;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.ecommerce.biz.mainpage.ECBaseMainPageFragment;
import com.tencent.ecommerce.biz.mainpage.ECGoodsTopViewCardFragment;
import com.tencent.ecommerce.biz.mainpage.ECMainPageFragmentType;
import com.tencent.ecommerce.biz.mainpage.ECMainPageItem;
import com.tencent.ecommerce.biz.mainpage.ECMainPageLiveFragment;
import com.tencent.ecommerce.biz.mainpage.ECMainPageQPlusFragment;
import com.tencent.ecommerce.biz.mainpage.ECMainPageShopFragment;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eB\t\b\u0016\u00a2\u0006\u0004\b\r\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016R\u001a\u0010\f\u001a\u00020\u00078\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/mainpage/presale/ECMainPagePreSaleFragment;", "Lcom/tencent/ecommerce/biz/mainpage/ECBaseMainPageFragment;", "", "Bh", "", "Lcom/tencent/ecommerce/biz/mainpage/d;", "Lh", "Lcom/tencent/ecommerce/biz/mainpage/ECMainPageFragmentType;", "T", "Lcom/tencent/ecommerce/biz/mainpage/ECMainPageFragmentType;", "Mh", "()Lcom/tencent/ecommerce/biz/mainpage/ECMainPageFragmentType;", "type", "<init>", "(Lcom/tencent/ecommerce/biz/mainpage/ECMainPageFragmentType;)V", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECMainPagePreSaleFragment extends ECBaseMainPageFragment {

    /* renamed from: T, reason: from kotlin metadata */
    private final ECMainPageFragmentType type;

    public ECMainPagePreSaleFragment(ECMainPageFragmentType eCMainPageFragmentType) {
        this.type = eCMainPageFragmentType;
    }

    @Override // com.tencent.ecommerce.biz.mainpage.ECBaseMainPageFragment, com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Bh() {
        return false;
    }

    @Override // com.tencent.ecommerce.biz.mainpage.ECBaseMainPageFragment
    public List<ECMainPageItem> Lh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ECMainPageItem("\u81ea\u8425\u5c0f\u5e97", null, ECMainPageShopFragment.class, null, 10, null));
        arrayList.add(new ECMainPageItem("\u76f4\u64ad\u6a71\u7a97", null, ECMainPageLiveFragment.class, null, 10, null));
        arrayList.add(new ECMainPageItem("\u5f00\u901a\u6ce8\u518c", "mqqapi://ecommerce/open?target=1&channel=2&jump_scheme=bXFxYXBpOi8vZWNvbW1lcmNlL29wZW4/dGFyZ2V0PTQmY2hhbm5lbD0x", null, null, 12, null));
        arrayList.add(new ECMainPageItem("\u79ef\u5206\u5546\u57ce", "mqqapi://ecommerce/open?target=52&channel=2&page_name=RewardPointsMall&source=1", null, null, 12, null));
        arrayList.add(new ECMainPageItem("\u5e26\u8d27\u4e2d\u5fc3-\u65b0\u7248", "mqqapi://ecommerce/open?target=52&channel=2&page_name=goods_center", null, null, 12, null));
        arrayList.add(new ECMainPageItem("\u4e3b\u6001\u6a71\u7a97", "mqqapi://ecommerce/open?target=7&channel=2&content_id=test", null, null, 12, null));
        arrayList.add(new ECMainPageItem("\u5ba2\u6001\u6a71\u7a97", "mqqapi://ecommerce/open?target=7&media_id=e18cf522b701442389c7b579705af9cd&media_name=alan&channel=2", null, null, 12, null));
        arrayList.add(new ECMainPageItem("\u738b\u8005\u6a71\u7a97", "mqqapi://ecommerce/open?target=7&channel=2&window_type=2", null, null, 12, null));
        arrayList.add(new ECMainPageItem("Q+\u63a8\u5e7f", null, ECMainPageQPlusFragment.class, null, 10, null));
        arrayList.add(new ECMainPageItem("\u4efb\u52a1\u4e2d\u5fc3\u9875", "mqqapi://ecommerce/open?target=17&channel=2&moduleName=ECTaskCenter", null, null, 12, null));
        arrayList.add(new ECMainPageItem("\u5546\u5355\u63a8\u5e7f\u9875", "mqqapi://ecommerce/open?target=17&channel=2&modulename=ECOrderCenter&framework=react&source=1&params=%7B%22pageId%22%3A%22order%22%7D", null, null, 12, null));
        arrayList.add(new ECMainPageItem("\u5546\u5361\u4fe1\u606f\u7f16\u8f91\u9875", "mqqapi://ecommerce/open?src_type=internal&version=1&target=35&channel=2&product_id=16849334&goods_type=1&product_type=jd&saas_product_id=10023182559719", null, null, 12, null));
        arrayList.add(new ECMainPageItem("\u6211\u7684\u4f18\u60e0\u5238", "mqqapi://ecommerce/open?target=52&channel=2&page_name=my_coupon_list", null, null, 12, null));
        arrayList.add(new ECMainPageItem("\u7ed3\u7b97\u6388\u6743", "mqqapi://ecommerce/open?target=56&channel=2", null, null, 12, null));
        arrayList.add(new ECMainPageItem("\u6ce8\u518c\u534f\u8bae\u7b7e\u7f72\u9875", "mqqapi://ecommerce/open?target=48&channel=2", null, null, 12, null));
        arrayList.add(new ECMainPageItem("\u6781\u5149\u8d4f\u76f2\u76d2\u4e3b\u9875", "mqqapi://ecommerce/open?target=52&channel=2&page_name=blind_box_home&single_mode=1", null, null, 12, null));
        arrayList.add(new ECMainPageItem("\u6e38\u620f\u5185\u5bb9\u805a\u5408\u9875", "mqqapi://ecommerce/open?target=52&channel=2&page_name=game_content_page", null, null, 12, null));
        arrayList.add(new ECMainPageItem("qq\u5173\u8054\u8bcd\u641c\u7d22\u9875\u9762", Uri.parse("mqqapi://ecommerce/open?target=52&channel=2&page_name=qsearch_detail").buildUpon().appendQueryParameter("sessionId", "android_12345").appendQueryParameter(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "1").appendQueryParameter("keyword", URLEncoder.encode("\u738b\u8005")).toString(), null, null, 12, null));
        arrayList.add(new ECMainPageItem("TopView\u6d4b\u8bd5\u9875", null, ECGoodsTopViewCardFragment.class, null, 10, null));
        return arrayList;
    }

    @Override // com.tencent.ecommerce.biz.mainpage.ECBaseMainPageFragment
    /* renamed from: Mh, reason: from getter */
    public ECMainPageFragmentType getType() {
        return this.type;
    }

    public ECMainPagePreSaleFragment() {
        this(ECMainPageFragmentType.MAIN_PAGE_TYPE_OTHER);
    }
}
