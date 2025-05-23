package com.tencent.ecommerce.biz.mainpage;

import android.os.Bundle;
import android.view.View;
import com.tencent.ams.dsdk.core.DKEngine;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/mainpage/ECMainPageLiveFragment;", "Lcom/tencent/ecommerce/biz/mainpage/ECBaseMainPageFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lcom/tencent/ecommerce/biz/mainpage/d;", "Lh", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECMainPageLiveFragment extends ECBaseMainPageFragment {
    @Override // com.tencent.ecommerce.biz.mainpage.ECBaseMainPageFragment, com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTitle("\u76f4\u64ad\u6a71\u7a97\u9875");
    }

    @Override // com.tencent.ecommerce.biz.mainpage.ECBaseMainPageFragment
    public List<ECMainPageItem> Lh() {
        List<ECMainPageItem> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ECMainPageItem[]{new ECMainPageItem("\u76f4\u64ad\u6a71\u7a97(\u672a\u5f00\u64ad)", "mqqapi://ecommerce/open?target=19&channel=8&is_master=1&is_live_opened=0&is_trans_activity=1&is_appcompat_style=1", null, null, 12, null), new ECMainPageItem("\u76f4\u64ad\u6a71\u7a97(\u672a\u5f00\u64adsaas)", "mqqapi://ecommerce/open?target=19&channel=8&is_master=1&is_live_opened=0&is_trans_activity=1&is_appcompat_style=1&default_tab_id=0", null, null, 12, null), new ECMainPageItem("\u76f4\u64ad\u6a71\u7a97(\u672a\u5f00\u64adgok)", "mqqapi://ecommerce/open?target=19&channel=8&is_master=1&is_live_opened=0&is_trans_activity=1&is_appcompat_style=1&default_tab_id=1", null, null, 12, null), new ECMainPageItem("\u76f4\u64ad\u6a71\u7a97(\u672a\u5f00\u64adshop)", "mqqapi://ecommerce/open?target=19&channel=8&is_master=1&is_live_opened=0&is_trans_activity=1&is_appcompat_style=1&default_tab_id=2", null, null, 12, null), new ECMainPageItem("\u76f4\u64ad\u6a71\u7a97(\u4e3b\u64ad\u5df2\u5f00\u64ad)", "mqqapi://ecommerce/open?target=19&channel=8&is_master=1&is_live_opened=1&is_trans_activity=1&is_appcompat_style=1", null, null, 12, null), new ECMainPageItem("\u76f4\u64ad\u6a71\u7a97(\u89c2\u4f17\u6001)", "mqqapi://ecommerce/open?target=19&channel=8&is_master=0&is_live_opened=1&is_trans_activity=1&is_appcompat_style=1&live_user_id=298886143&live_room_id=1289812673&live_play_time=50&live_program_id=298886143_1668408218&live_type=1", null, null, 12, null), new ECMainPageItem("\u76f4\u64ad\u6a71\u7a97\u4f18\u60e0\u5238\u805a\u5408\u5546\u54c1(\u89c2\u4f17\u6001)", "mqqapi://ecommerce/open?target=19&channel=8&is_trans_activity=1&is_appcompat_style=1&is_live_opened=1&is_master=0&coupon_id=600015_115519754013769744", null, null, 12, null), new ECMainPageItem("\u76f4\u64ad\u95f4\u6211\u7684\u6a71\u7a97", "mqqapi://ecommerce/open?target=7&channel=2&window_type=3", null, null, 12, null), new ECMainPageItem("\u76f4\u64ad\u95f4\u5c0f\u5e97\u6a71\u7a97", "mqqapi://ecommerce/open?target=51&channel=2&window_type=4&is_appcompat_style=1&no_exit_anim=1&no_enter_anim=1", null, null, 12, null)});
        return listOf;
    }
}
