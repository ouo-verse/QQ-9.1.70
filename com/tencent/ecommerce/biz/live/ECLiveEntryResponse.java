package com.tencent.ecommerce.biz.live;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.network.api.IECResponse;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.HashMap;
import kotlin.Metadata;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b7\b\u0007\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001 B\u0007\u00a2\u0006\u0004\bF\u0010GJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n`\u000bJ\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\u0019\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u00d6\u0001R\"\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010$\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010(\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\"\u0010/\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00103\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010*\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R\"\u00107\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010*\u001a\u0004\b5\u0010,\"\u0004\b6\u0010.R\"\u0010;\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010*\u001a\u0004\b9\u0010,\"\u0004\b:\u0010.R\"\u0010=\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010\u0015\u001a\u0004\b=\u0010\u0017\"\u0004\b>\u0010\u0019R\"\u0010@\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010\u0015\u001a\u0004\b@\u0010\u0017\"\u0004\bA\u0010\u0019R\"\u0010E\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010\u001f\u001a\u0004\bC\u0010!\"\u0004\bD\u0010#\u00a8\u0006I"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ECLiveEntryResponse;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Landroid/os/Parcelable;", "Lorg/json/JSONObject;", "data", "", "decodeData", "", "toString", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "b", "", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Z", "isXworldAuthenticated", "()Z", "setXworldAuthenticated", "(Z)V", "e", "c", "setEcomAuthenticated", "isEcomAuthenticated", "f", "I", "a", "()I", "setLiveGoodsNumber", "(I)V", "liveGoodsNumber", h.F, "getLiveWangZheGoodsNumber", "setLiveWangZheGoodsNumber", "liveWangZheGoodsNumber", "i", "Ljava/lang/String;", "getCargoCenterUrl", "()Ljava/lang/String;", "setCargoCenterUrl", "(Ljava/lang/String;)V", "cargoCenterUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getEcomRegisterUrl", "setEcomRegisterUrl", "ecomRegisterUrl", BdhLogUtil.LogTag.Tag_Conn, "getMyWindowUrl", "setMyWindowUrl", "myWindowUrl", "D", "getLiveWindowUrl", "setLiveWindowUrl", "liveWindowUrl", "E", "isWangZheWhiteListUser", "setWangZheWhiteListUser", UserInfo.SEX_FEMALE, "isXiaoDianListUser", "setXiaoDianListUser", "G", "getLiveXiaoDianGoodsNumber", "setLiveXiaoDianGoodsNumber", "liveXiaoDianGoodsNumber", "<init>", "()V", "H", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class ECLiveEntryResponse implements IECResponse, Parcelable {

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isWangZheWhiteListUser;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isXiaoDianListUser;

    /* renamed from: G, reason: from kotlin metadata */
    private int liveXiaoDianGoodsNumber;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isXworldAuthenticated;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isEcomAuthenticated;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int liveGoodsNumber;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int liveWangZheGoodsNumber;
    public static final Parcelable.Creator<ECLiveEntryResponse> CREATOR = new b();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String cargoCenterUrl = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String ecomRegisterUrl = "";

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String myWindowUrl = "";

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String liveWindowUrl = "";

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static class b implements Parcelable.Creator<ECLiveEntryResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ECLiveEntryResponse createFromParcel(@NotNull Parcel parcel) {
            if (parcel.readInt() != 0) {
                return new ECLiveEntryResponse();
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ECLiveEntryResponse[] newArray(int i3) {
            return new ECLiveEntryResponse[i3];
        }
    }

    /* renamed from: a, reason: from getter */
    public final int getLiveGoodsNumber() {
        return this.liveGoodsNumber;
    }

    @NotNull
    public final HashMap<String, Object> b() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("PARAM_XWORLD_AUTHENTICATED", Boolean.valueOf(this.isXworldAuthenticated));
        hashMap.put("PARAM_ECOM_AUTHENTICATED", Boolean.valueOf(this.isEcomAuthenticated));
        hashMap.put("PARAM_LIVE_GOODS_NUMBER", Integer.valueOf(this.liveGoodsNumber));
        hashMap.put("PARAM_LIVE_SHOP_GOODS_NUMBER", Integer.valueOf(this.liveXiaoDianGoodsNumber));
        hashMap.put("PARAM_WANGZHE_GOODS_NUMBER", Integer.valueOf(this.liveWangZheGoodsNumber));
        hashMap.put("PARAM_IS_WANGZHE_WHITE_LIST_USER", Boolean.valueOf(this.isWangZheWhiteListUser));
        hashMap.put("PARAM_IS_XIAODIAN_WHITE_LIST_USER", Boolean.valueOf(this.isXiaoDianListUser));
        return hashMap;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsEcomAuthenticated() {
        return this.isEcomAuthenticated;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(@Nullable JSONObject data) {
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getLogger().logInfo("ECQQLiveEntryResponse", "[decodeData] data = " + data);
        if (data == null) {
            return false;
        }
        this.isXworldAuthenticated = data.optBoolean("is_xworld_authenticated");
        this.isEcomAuthenticated = data.optBoolean("is_ecom_authenticated");
        this.liveGoodsNumber = data.optInt("live_goods_number", 0);
        this.cargoCenterUrl = data.optString("cargo_center_url", "");
        this.ecomRegisterUrl = data.optString("ecom_register_url", "");
        this.myWindowUrl = data.optString("my_window_url", "");
        this.liveWindowUrl = data.optString("live_window_url", "");
        JSONObject optJSONObject = data.optJSONObject("king_info");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        this.isWangZheWhiteListUser = optJSONObject.optBoolean("is_king_whitelist_user", false);
        this.liveWangZheGoodsNumber = optJSONObject.optInt("king_goods_number", 0);
        JSONObject optJSONObject2 = data.optJSONObject("shop_info");
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
        }
        this.isXiaoDianListUser = optJSONObject2.optBoolean("has_shop", false);
        this.liveXiaoDianGoodsNumber = optJSONObject2.optInt("goods_num", 0);
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public String toString() {
        return "isXworldAuthenticated:" + this.isXworldAuthenticated + ",isEcomAuthenticated:" + this.isEcomAuthenticated + ",liveGoodsNumber:" + this.liveGoodsNumber + ",cargoCenterUrl:" + this.cargoCenterUrl + ",ecomRegisterUrl:" + this.ecomRegisterUrl + ",myWindowUrl:" + this.myWindowUrl + ",liveWindowUrl:" + this.liveWindowUrl + ",isWangZheWhiteListUser:" + this.isWangZheWhiteListUser + ",isXiaoDianListUser:" + this.isXiaoDianListUser + ",liveXiaoDianGoodsNumber:" + this.liveXiaoDianGoodsNumber;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        parcel.writeInt(1);
    }
}
