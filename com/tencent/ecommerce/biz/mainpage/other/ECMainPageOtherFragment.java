package com.tencent.ecommerce.biz.mainpage.other;

import com.tencent.ecommerce.biz.mainpage.ECBaseMainPageFragment;
import com.tencent.ecommerce.biz.mainpage.ECHRMainPageFragment;
import com.tencent.ecommerce.biz.mainpage.ECMainPageFragmentType;
import com.tencent.ecommerce.biz.mainpage.ECMainPageItem;
import com.tencent.ecommerce.biz.mainpage.ECMainPagePayConfigFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eB\t\b\u0016\u00a2\u0006\u0004\b\r\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016R\u001a\u0010\f\u001a\u00020\u00078\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/mainpage/other/ECMainPageOtherFragment;", "Lcom/tencent/ecommerce/biz/mainpage/ECBaseMainPageFragment;", "", "Bh", "", "Lcom/tencent/ecommerce/biz/mainpage/d;", "Lh", "Lcom/tencent/ecommerce/biz/mainpage/ECMainPageFragmentType;", "T", "Lcom/tencent/ecommerce/biz/mainpage/ECMainPageFragmentType;", "Mh", "()Lcom/tencent/ecommerce/biz/mainpage/ECMainPageFragmentType;", "type", "<init>", "(Lcom/tencent/ecommerce/biz/mainpage/ECMainPageFragmentType;)V", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECMainPageOtherFragment extends ECBaseMainPageFragment {

    /* renamed from: T, reason: from kotlin metadata */
    private final ECMainPageFragmentType type;

    public ECMainPageOtherFragment(ECMainPageFragmentType eCMainPageFragmentType) {
        this.type = eCMainPageFragmentType;
    }

    @Override // com.tencent.ecommerce.biz.mainpage.ECBaseMainPageFragment, com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Bh() {
        return false;
    }

    @Override // com.tencent.ecommerce.biz.mainpage.ECBaseMainPageFragment
    public List<ECMainPageItem> Lh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ECMainPageItem("HippyDebug\u8bbe\u7f6e", "mqqapi://ecommerce/open?target=17&channel=2&moduleName=ECOrderCenter&framework=react&source=1&params=%7B%22pageId%22%3A%22order%22%7D", null, null, 12, null));
        arrayList.add(new ECMainPageItem("\u7c73\u5927\u5e08\u652f\u4ed8\u73af\u5883\u8bbe\u7f6e", null, ECMainPagePayConfigFragment.class, null, 10, null));
        arrayList.add(new ECMainPageItem("Kuikly\u8c03\u8bd5\u9875\u9762", null, ECHRMainPageFragment.class, null, 10, null));
        return arrayList;
    }

    @Override // com.tencent.ecommerce.biz.mainpage.ECBaseMainPageFragment
    /* renamed from: Mh, reason: from getter */
    public ECMainPageFragmentType getType() {
        return this.type;
    }

    public ECMainPageOtherFragment() {
        this(ECMainPageFragmentType.MAIN_PAGE_TYPE_OTHER);
    }
}
