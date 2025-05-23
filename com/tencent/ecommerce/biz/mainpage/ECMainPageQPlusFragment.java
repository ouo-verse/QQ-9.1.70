package com.tencent.ecommerce.biz.mainpage;

import android.os.Bundle;
import android.view.View;
import com.tencent.ams.dsdk.core.DKEngine;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/mainpage/ECMainPageQPlusFragment;", "Lcom/tencent/ecommerce/biz/mainpage/ECBaseMainPageFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lcom/tencent/ecommerce/biz/mainpage/d;", "Lh", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECMainPageQPlusFragment extends ECBaseMainPageFragment {
    @Override // com.tencent.ecommerce.biz.mainpage.ECBaseMainPageFragment, com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTitle("Q+\u5165\u53e3\u9875");
    }

    @Override // com.tencent.ecommerce.biz.mainpage.ECBaseMainPageFragment
    public List<ECMainPageItem> Lh() {
        List<ECMainPageItem> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ECMainPageItem[]{new ECMainPageItem("\u9996\u9875", "mqqapi://ecommerce/open?target=52&channel=2&page_name=qplus_traffic_home", null, null, 12, null), new ECMainPageItem("\u5206\u4eab\u9762\u677f\u8df3\u5230\u63a8\u5e7f\u8bbe\u7f6e\u9875", "mqqapi://ecommerce/open?target=52&src_type=internal&channel=2&page_name=qplus_promotion_setting&source_from=1&target_uin=2073161969&target_nick=%E6%88%91%E6%98%AF%E4%B8%AA%E7%BD%91%E7%BA%A2%E5%A6%B9%E5%AD%90&feed_id=B_ha2f21e6498600500cz0TcP4ScjASeg0X5c", null, null, 12, null)});
        return listOf;
    }
}
