package com.tencent.ecommerce.biz.mainpage;

import android.os.Bundle;
import android.view.View;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/mainpage/ECMainPageShopFragment;", "Lcom/tencent/ecommerce/biz/mainpage/ECBaseMainPageFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lcom/tencent/ecommerce/biz/mainpage/d;", "Lh", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECMainPageShopFragment extends ECBaseMainPageFragment {
    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        super.onCreate(savedInstanceState);
        if (QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getRuntime().isTestEnv()) {
            str = "59854995328073731";
        } else {
            str = "74957518543257603";
        }
        e.b(str);
    }

    @Override // com.tencent.ecommerce.biz.mainpage.ECBaseMainPageFragment, com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTitle("\u81ea\u8425\u5c0f\u5e97\u9875");
    }

    @Override // com.tencent.ecommerce.biz.mainpage.ECBaseMainPageFragment
    public List<ECMainPageItem> Lh() {
        List<ECMainPageItem> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ECMainPageItem[]{new ECMainPageItem("\u5e97\u94fa\u4e3b\u9875\u6d4b\u8bd5", null, null, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.mainpage.ECMainPageShopFragment$createData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                new g(ECMainPageShopFragment.this.requireContext()).show();
            }
        }, 6, null), new ECMainPageItem("\u8ba2\u5355\u6a21\u5757\u6d4b\u8bd5", null, null, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.mainpage.ECMainPageShopFragment$createData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                new h(ECMainPageShopFragment.this.requireContext()).show();
            }
        }, 6, null), new ECMainPageItem("\u5e97\u94fa\u4e3b\u9875(\u4f18\u60e0\u5238\u6d3b\u52a8)", "mqqapi://ecommerce/open?target=21&channel=2&shop_id=50369043852427267&coupon_id=600021&source=2", null, null, 12, null), new ECMainPageItem("\u5546\u54c1\u8be6\u60c5\u9875(\u9009\u62e9\u6001)", "mqqapi://ecommerce/open?target=9&channel=5&media_product_id=&spu_id=55416103064829954&product_type=&biz_type=1&source_from=5&is_select=1&qz_gdt=1234567890", null, null, 12, null), new ECMainPageItem("\u5546\u54c1\u8be6\u60c5\u9875(\u5206\u9500\u6001)", "mqqapi://ecommerce/open?target=9&channel=5&media_product_id=&spu_id=55416103064829954&product_type=&biz_type=1&source_from=5&is_distributor=1&qz_gdt=1234567890", null, null, 12, null), new ECMainPageItem("\u5546\u54c1\u8be6\u60c5\u534a\u6d6e\u5c42\u9875(\u9009\u62e9\u6001)", "mqqapi://ecommerce/open?target=9&channel=5&media_product_id=&spu_id=55416103064829954&product_type=&biz_type=1&source_from=5&is_trans_activity=1&half=1&is_select=1&qz_gdt=1234567890", null, null, 12, null), new ECMainPageItem("\u5546\u54c1\u8be6\u60c5\u9875(\u5546\u54c1\u4e0b\u67b6\u534a\u6d6e\u5c42)", "mqqapi://ecommerce/open?target=9&channel=5&spu_id=55416103064829954&biz_type=1&source_from=5&is_trans_activity=1&half=1&seller_id=47a2a5b3-7e83-411a-bb07-17b0ef2df2a6&role=2&is_off_sale=1&qz_gdt=1234567890", null, null, 12, null), new ECMainPageItem("\u5546\u54c1\u8be6\u60c5\u9875(\u6d4f\u89c8\u6001)", "mqqapi://ecommerce/open?target=9&channel=5&media_product_id=&spu_id=55416103064829954&product_type=&biz_type=1&is_select=0&source_from=5&buy_now=1&qz_gdt=1234567890", null, null, 12, null), new ECMainPageItem("\u5546\u54c1\u8be6\u60c5\u89c4\u683c\u9009\u62e9\u9875", "mqqapi://ecommerce/open?target=33&src_type=internal&version=1&spu_id=55416103064829954&channel=5&is_trans_activity=1", null, null, 12, null), new ECMainPageItem("\u5546\u5bb6\u8d44\u8d28\u9875", "mqqapi://ecommerce/open?target=32&channel=2&shop_id=" + e.a(), null, null, 12, null), new ECMainPageItem("\u5546\u54c1\u641c\u7d22\u5386\u53f2", "mqqapi://ecommerce/open?target=30&channel=2&source=2", null, null, 12, null), new ECMainPageItem("\u5e97\u94fa\u641c\u7d22\u5386\u53f2", "mqqapi://ecommerce/open?target=30&channel=2&source=2", null, null, 12, null), new ECMainPageItem("\u552e\u540e\u8be6\u60c5\u9875", "mqqapi://ecommerce/open?target=38&channel=8&order_id=13390511570047307294198726660", null, null, 12, null), new ECMainPageItem("\u552e\u540e\u7533\u8bf7", "mqqapi://ecommerce/open?target=36&channel=2&page_type=0&sku_id=123456&process_id=987654&order_id=202208014", null, null, 12, null), new ECMainPageItem("\u63d0\u4ea4\u7269\u6d41\u4fe1\u606f", "mqqapi://ecommerce/open?target=41&after_sales_id=66150934208839686&phone_num=13725397975&process_id=66150934208839686-2&channel=2", null, null, 12, null), new ECMainPageItem("\u534f\u5546\u5386\u53f2", "mqqapi://ecommerce/open?target=40&after_sales_id=66150934208839686&channel=2", null, null, 12, null), new ECMainPageItem("\u7269\u6d41\u8be6\u60c5", "mqqapi://ecommerce/open?target=49&channel=2&order_id=74749582265548804&logistics_code=78616030768034", null, null, 12, null), new ECMainPageItem("\u540c\u57ce\u7269\u6d41\u8be6\u60c5", "mqqapi://ecommerce/open?target=49&channel=2&order_id=65461918819418116&logistics_code=SF1655179358445", null, null, 12, null), new ECMainPageItem("\u81ea\u5b9a\u4e49\u8df3\u8f6c", null, ECMainPageSchemaTestFragment.class, null, 10, null)});
        return listOf;
    }
}
