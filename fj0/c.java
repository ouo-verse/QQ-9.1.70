package fj0;

import android.text.TextUtils;
import ck0.Category;
import ck0.Product;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.biz.util.i;
import com.tencent.ecommerce.biz.util.k;
import com.tencent.ecommerce.biz.util.l;
import com.tencent.ecommerce.repo.live.ECShopExt;
import com.tencent.ecommerce.repo.live.LivePicInfo;
import com.tencent.ecommerce.repo.live.LiveShowItem;
import com.tencent.pts.core.PTSComposer;
import gh0.d;
import java.util.ArrayList;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JD\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000fj\b\u0012\u0004\u0012\u00020\u0002`\u00102\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004J@\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0016\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0006\u00a8\u0006\u001e"}, d2 = {"Lfj0/c;", "", "Lck0/c;", "product", "", "isNight", "", h.F, "Lorg/json/JSONArray;", "b", "i", "productListJson", "isShowAddBtn", "isEdited", "isMaster", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Lorg/json/JSONObject;", "productJson", "Lcom/tencent/ecommerce/repo/live/i;", "shopExt", "c", "Lcom/tencent/pts/core/PTSComposer;", "a", "goodsType", "", "g", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f399474a = new c();

    c() {
    }

    private final JSONArray b(Product product) {
        JSONArray jSONArray;
        LivePicInfo titleIcon;
        JSONObject dataJson = product.getDataJson();
        if (dataJson == null || (jSONArray = dataJson.optJSONArray("labels")) == null) {
            jSONArray = new JSONArray();
        }
        l h16 = new k(null, 1, null).h(jSONArray);
        LiveShowItem b16 = Product.INSTANCE.b(product);
        if (b16 != null && (titleIcon = b16.getTitleIcon()) != null) {
            h16.b(titleIcon.getUrl(), titleIcon.getWidth(), titleIcon.getHeight());
        }
        h16.e(product.getTitle(), 14, "qecommerce_skin_color_text_primary", 2);
        return h16.g();
    }

    private final String h(Product product, boolean isNight) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("product", product.getDataJson());
            jSONObject.put("is_master", product.getIsMaster());
            jSONObject.put("add_btn", product.getShowAddBtn());
            jSONObject.put("ec_discountprefix", "\u8d5a\u00a5");
            jSONObject.put("is_shop", product.getLiveShopExt() != null);
            jSONObject.put("title_right_padding", product.getIsEdited() ? 36 : 0);
            jSONObject.put("nodes", b(product));
        } catch (JSONException e16) {
            cg0.a.a("ECShowWindowDataUtil", "[getProductPtsJsonData]", e16.toString());
        }
        return jSONObject.toString();
    }

    private final String i(Product product) {
        if (TextUtils.isEmpty(product.getPageName())) {
            return "commodity_big_pic_product_card";
        }
        return product.getPageName();
    }

    public final PTSComposer a(Product product, boolean isNight) {
        String i3 = i(product);
        String e16 = ECPTSStyleManager.e(i3, wg0.a.a());
        if (TextUtils.isEmpty(e16)) {
            e16 = ECPTSStyleManager.e("commodity_big_pic_product_card", wg0.a.a());
        }
        return d.f402041a.b(i3, e16, h(product, isNight), null);
    }

    public final ArrayList<Product> e(JSONArray productListJson, boolean isShowAddBtn, boolean isEdited, boolean isMaster, boolean isNight) {
        ArrayList<Product> arrayList = new ArrayList<>();
        int length = productListJson.length();
        for (int i3 = 0; i3 < length; i3++) {
            arrayList.add(d(this, productListJson.optJSONObject(i3), isShowAddBtn, isEdited, isMaster, isNight, null, 32, null));
        }
        return arrayList;
    }

    public final int g(String goodsType) {
        try {
            return Integer.parseInt(goodsType);
        } catch (NumberFormatException e16) {
            cg0.a.a("ECDetailHostRepo", "[getGoodsType]", e16.toString());
            return 1;
        }
    }

    public final Product c(JSONObject productJson, boolean isShowAddBtn, boolean isEdited, boolean isMaster, boolean isNight, ECShopExt shopExt) {
        Product product;
        String optString = productJson.optString("media_product_id", "");
        String optString2 = productJson.optString("saas_product_id", "");
        String optString3 = productJson.optString("title", "");
        String optString4 = productJson.optString("desc", "");
        long optLong = productJson.optLong("price", 0L);
        long optLong2 = productJson.optLong("ori_price", 0L);
        long optLong3 = productJson.optLong("coupon_price", 0L);
        long optLong4 = productJson.optLong("inventory", 0L);
        long optLong5 = productJson.optLong("sales", 0L);
        String optString5 = productJson.optString("saas_type_str", "");
        String optString6 = productJson.optString("sass_type_name", "");
        String optString7 = productJson.optString("detail_url", "");
        long optLong6 = productJson.optLong("commission", 0L);
        int optInt = productJson.optInt("state", 0);
        int optInt2 = productJson.optInt("goods_type", 0);
        String optString8 = productJson.optString("page_name", "");
        boolean optBoolean = productJson.optBoolean("is_price_exceed", false);
        boolean optBoolean2 = productJson.optBoolean("is_unsupport_add", false);
        JSONObject optJSONObject = productJson.optJSONObject("shop_info");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        Product product2 = new Product(optString, optString2, optString3, optString4, optLong, optLong2, optLong3, optLong6, 0.0d, 0L, 0L, 0L, 0L, optLong4, optLong5, optString5, optString6, optString7, false, null, null, null, false, false, productJson, isMaster, isShowAddBtn, isEdited, optInt, null, false, false, false, optInt2, optString8, false, null, null, 0, optBoolean, optBoolean2, optJSONObject, null, -520347904, 1145, null);
        JSONObject optJSONObject2 = productJson.optJSONObject("category");
        if (optJSONObject2 != null) {
            Category category = new Category(optJSONObject2.optLong("id"), optJSONObject2.optString("name"), 0, false, 12, null);
            product = product2;
            product.F(category);
        } else {
            product = product2;
        }
        i iVar = i.f104869a;
        productJson.put("coupon_price_yuan", iVar.b(product.getCouponPrice()));
        productJson.put("commission_yuan", iVar.b(product.getCommission()));
        JSONObject optJSONObject3 = productJson.optJSONObject("price_range");
        if (optJSONObject3 != null) {
            productJson.put("price_yuan_min", iVar.b(optJSONObject3.optLong("lower", 0L)));
            productJson.put("price_yuan_max", iVar.b(optJSONObject3.optLong("upper", 0L)));
        }
        JSONObject optJSONObject4 = productJson.optJSONObject("commission_range");
        if (optJSONObject4 != null) {
            productJson.put("commission_yuan_min", iVar.b(optJSONObject4.optLong("lower", 0L)));
            productJson.put("commission_yuan_max", iVar.b(optJSONObject4.optLong("upper", 0L)));
        }
        product.O(shopExt);
        product.S(a(product, isNight));
        JSONArray optJSONArray = productJson.optJSONArray("cdn_main_pics");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String string = optJSONArray.getString(i3);
                ng0.a.f420126b.a(string);
                arrayList.add(string);
            }
            product.G(arrayList);
        }
        return product;
    }

    public static /* synthetic */ Product d(c cVar, JSONObject jSONObject, boolean z16, boolean z17, boolean z18, boolean z19, ECShopExt eCShopExt, int i3, Object obj) {
        return cVar.c(jSONObject, (i3 & 2) != 0 ? false : z16, (i3 & 4) != 0 ? false : z17, z18, (i3 & 16) != 0 ? false : z19, (i3 & 32) != 0 ? null : eCShopExt);
    }
}
