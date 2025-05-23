package com.tencent.ecommerce.biz.detail.repo.saas;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.network.api.IECResponse;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b*\n\u0002\u0010\b\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bc\u0010dJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010!\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010-\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010$\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R$\u00101\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\b\u001a\u0004\b/\u0010\n\"\u0004\b0\u0010\fR$\u00105\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010$\u001a\u0004\b3\u0010&\"\u0004\b4\u0010(R$\u00109\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010$\u001a\u0004\b7\u0010&\"\u0004\b8\u0010(R$\u0010=\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010$\u001a\u0004\b;\u0010&\"\u0004\b<\u0010(R$\u0010A\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010\b\u001a\u0004\b?\u0010\n\"\u0004\b@\u0010\fR$\u0010H\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010L\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010$\u001a\u0004\bJ\u0010&\"\u0004\bK\u0010(R$\u0010T\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010X\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010O\u001a\u0004\bV\u0010Q\"\u0004\bW\u0010SR$\u0010Z\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010C\u001a\u0004\bZ\u0010E\"\u0004\b[\u0010GR$\u0010b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010a\u00a8\u0006e"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/saas/c;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONObject;", "data", "", "decodeData", "", "d", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "title", "e", "getSource", "setSource", "source", "f", "getDesc", "setDesc", "desc", "Lorg/json/JSONArray;", h.F, "Lorg/json/JSONArray;", "b", "()Lorg/json/JSONArray;", "setMainPics", "(Lorg/json/JSONArray;)V", "mainPics", "i", "getDetailPics", "setDetailPics", "detailPics", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Long;", "getInventory", "()Ljava/lang/Long;", "setInventory", "(Ljava/lang/Long;)V", "inventory", BdhLogUtil.LogTag.Tag_Conn, "getSales", "setSales", "sales", "D", "getUrl", "setUrl", "url", "E", "getPrice", "setPrice", "price", UserInfo.SEX_FEMALE, "getOriginPrice", "setOriginPrice", "originPrice", "G", "getCommission", "setCommission", "commission", "H", "getCommissionRate", "setCommissionRate", "commissionRate", "I", "Ljava/lang/Boolean;", "getHasCoupon", "()Ljava/lang/Boolean;", "setHasCoupon", "(Ljava/lang/Boolean;)V", "hasCoupon", "J", "getComments", "setComments", "comments", "", "K", "Ljava/lang/Integer;", "getFavourableRate", "()Ljava/lang/Integer;", "setFavourableRate", "(Ljava/lang/Integer;)V", "favourableRate", "L", "getMonthOrderCount", "setMonthOrderCount", "monthOrderCount", "M", "isAdded", "setAdded", "N", "Lorg/json/JSONObject;", "a", "()Lorg/json/JSONObject;", "setDataJson", "(Lorg/json/JSONObject;)V", "dataJson", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class c implements IECResponse {

    /* renamed from: C, reason: from kotlin metadata */
    private Long sales;

    /* renamed from: D, reason: from kotlin metadata */
    private String url;

    /* renamed from: E, reason: from kotlin metadata */
    private Long price;

    /* renamed from: F, reason: from kotlin metadata */
    private Long originPrice;

    /* renamed from: G, reason: from kotlin metadata */
    private Long commission;

    /* renamed from: H, reason: from kotlin metadata */
    private String commissionRate;

    /* renamed from: I, reason: from kotlin metadata */
    private Boolean hasCoupon;

    /* renamed from: J, reason: from kotlin metadata */
    private Long comments;

    /* renamed from: K, reason: from kotlin metadata */
    private Integer favourableRate;

    /* renamed from: L, reason: from kotlin metadata */
    private Integer monthOrderCount;

    /* renamed from: M, reason: from kotlin metadata */
    private Boolean isAdded;

    /* renamed from: N, reason: from kotlin metadata */
    private JSONObject dataJson;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String title;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String source;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String desc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private JSONArray mainPics;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private JSONArray detailPics;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Long inventory;

    /* renamed from: a, reason: from getter */
    public final JSONObject getDataJson() {
        return this.dataJson;
    }

    /* renamed from: b, reason: from getter */
    public final JSONArray getMainPics() {
        return this.mainPics;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(JSONObject data) {
        if (data == null) {
            return false;
        }
        this.dataJson = data;
        JSONObject optJSONObject = data.optJSONObject("product");
        if (optJSONObject != null) {
            this.title = optJSONObject.optString("title", "");
            this.source = optJSONObject.optString("source", "");
            this.desc = optJSONObject.optString("desc");
            JSONArray optJSONArray = optJSONObject.optJSONArray("main_pics");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            this.mainPics = optJSONArray;
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("detail_pics");
            if (optJSONArray2 == null) {
                optJSONArray2 = new JSONArray();
            }
            this.detailPics = optJSONArray2;
            this.inventory = Long.valueOf(optJSONObject.optLong("inventory", 0L));
            this.sales = Long.valueOf(optJSONObject.optLong("sales", 0L));
        }
        this.url = data.optString("url", "");
        this.price = Long.valueOf(data.optLong("price", 0L));
        this.originPrice = Long.valueOf(data.optLong("origin_price", 0L));
        this.commission = Long.valueOf(data.optLong("commission", 0L));
        this.commissionRate = data.optString("commission_rate", "");
        this.hasCoupon = Boolean.valueOf(data.optBoolean("has_coupon", false));
        this.comments = Long.valueOf(data.optLong("comments", 0L));
        this.favourableRate = Integer.valueOf(data.optInt("favorable_rate", 0));
        this.monthOrderCount = Integer.valueOf(data.optInt("month_order_count", 0));
        this.isAdded = Boolean.valueOf(data.optBoolean("is_add", false));
        return true;
    }
}
