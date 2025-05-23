package cooperation.qwallet.open.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ads.data.AdParam;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.VasUserData;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.vivo.push.PushClientConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

@Parcelize
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\b\u00100\u001a\u0004\u0018\u00010,\u0012\b\u00103\u001a\u0004\u0018\u00010\u0003\u0012\b\u00106\u001a\u0004\u0018\u00010\u0003\u0012\b\u00109\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010B\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010E\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010J\u001a\u00020F\u0012\u0006\u0010P\u001a\u00020K\u00a2\u0006\u0004\bQ\u0010RJ\u001e\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\nJ\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\nJ\u0006\u0010\r\u001a\u00020\u0003J\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\u0003J\b\u0010\u0010\u001a\u00020\u0003H\u0007J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0012H\u00d6\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0012H\u00d6\u0001J\u0019\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0012H\u00d6\u0001R\u0017\u0010 \u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\"\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b!\u0010\u001fR\u0019\u0010%\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001fR\u0019\u0010(\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u001d\u001a\u0004\b'\u0010\u001fR\u0019\u0010+\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u001d\u001a\u0004\b*\u0010\u001fR\u0019\u00100\u001a\u0004\u0018\u00010,8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010-\u001a\u0004\b.\u0010/R\u0019\u00103\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b1\u0010\u001d\u001a\u0004\b2\u0010\u001fR\u0019\u00106\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b4\u0010\u001d\u001a\u0004\b5\u0010\u001fR\u0019\u00109\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b7\u0010\u001d\u001a\u0004\b8\u0010\u001fR\u0019\u0010<\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b:\u0010\u001d\u001a\u0004\b;\u0010\u001fR\u0019\u0010?\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b=\u0010\u001d\u001a\u0004\b>\u0010\u001fR\u0019\u0010B\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b@\u0010\u001d\u001a\u0004\bA\u0010\u001fR\u0019\u0010E\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\bC\u0010\u001d\u001a\u0004\bD\u0010\u001fR\u0017\u0010J\u001a\u00020F8\u0006\u00a2\u0006\f\n\u0004\bG\u0010H\u001a\u0004\b#\u0010IR\u0017\u0010P\u001a\u00020K8\u0006\u00a2\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\u00a8\u0006S"}, d2 = {"Lcooperation/qwallet/open/data/PayInfo;", "Landroid/os/Parcelable;", "Lorg/json/JSONObject;", "", "key", "param", "", "p", "", "o", "", "t", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "toString", "", "hashCode", "", "other", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "writeToParcel", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "apiName", "e", "appId", "f", "k", "partnerId", h.F, "l", "prepayId", "i", "getNonceStr", PayProxy.Source.PAY_REQUEST_NONCE_STR_KEY, "", "Ljava/lang/Long;", "getTimeStamp", "()Ljava/lang/Long;", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, BdhLogUtil.LogTag.Tag_Conn, "getPackageValue", "packageValue", "D", "getSign", "sign", "E", "getSignType", PayProxy.Source.PAY_REQUEST_SIGN_TYPE_KEY, UserInfo.SEX_FEMALE, "getTradeType", "tradeType", "G", "j", "extData", "H", DomainData.DOMAIN_NAME, "transaction", "I", "g", "callbackScheme", "Lcooperation/qwallet/open/data/PayInfoBase;", "J", "Lcooperation/qwallet/open/data/PayInfoBase;", "()Lcooperation/qwallet/open/data/PayInfoBase;", PM.BASE, "Lcooperation/qwallet/open/data/AppPayExt;", "K", "Lcooperation/qwallet/open/data/AppPayExt;", "c", "()Lcooperation/qwallet/open/data/AppPayExt;", "app", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcooperation/qwallet/open/data/PayInfoBase;Lcooperation/qwallet/open/data/AppPayExt;)V", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final /* data */ class PayInfo implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<PayInfo> CREATOR = new a();

    /* renamed from: C, reason: from kotlin metadata and from toString */
    @Nullable
    private final String packageValue;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    @Nullable
    private final String sign;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    @Nullable
    private final String signType;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    @Nullable
    private final String tradeType;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    @Nullable
    private final String extData;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    @Nullable
    private final String transaction;

    /* renamed from: I, reason: from kotlin metadata and from toString */
    @Nullable
    private final String callbackScheme;

    /* renamed from: J, reason: from kotlin metadata and from toString */
    @NotNull
    private final PayInfoBase base;

    /* renamed from: K, reason: from kotlin metadata and from toString */
    @NotNull
    private final AppPayExt app;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String apiName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String appId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String partnerId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String prepayId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String nonceStr;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Long timeStamp;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class a implements Parcelable.Creator<PayInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PayInfo createFromParcel(@NotNull Parcel parcel) {
            Long valueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(parcel.readLong());
            }
            return new PayInfo(readString, readString2, readString3, readString4, readString5, valueOf, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), PayInfoBase.CREATOR.createFromParcel(parcel), AppPayExt.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PayInfo[] newArray(int i3) {
            return new PayInfo[i3];
        }
    }

    public PayInfo(@NotNull String apiName, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Long l3, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @NotNull PayInfoBase base, @NotNull AppPayExt app) {
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(app, "app");
        this.apiName = apiName;
        this.appId = str;
        this.partnerId = str2;
        this.prepayId = str3;
        this.nonceStr = str4;
        this.timeStamp = l3;
        this.packageValue = str5;
        this.sign = str6;
        this.signType = str7;
        this.tradeType = str8;
        this.extData = str9;
        this.transaction = str10;
        this.callbackScheme = str11;
        this.base = base;
        this.app = app;
    }

    private final void p(JSONObject jSONObject, String str, String str2) {
        boolean z16;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        jSONObject.put(str, str2);
    }

    public final boolean a() {
        Long l3;
        if (TextUtils.isEmpty(this.appId) || TextUtils.isEmpty(this.prepayId) || TextUtils.isEmpty(this.partnerId) || TextUtils.isEmpty(this.nonceStr) || TextUtils.isEmpty(this.sign) || (l3 = this.timeStamp) == null || l3.longValue() < 0) {
            return false;
        }
        return !TextUtils.isEmpty(this.transaction);
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getApiName() {
        return this.apiName;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final AppPayExt getApp() {
        return this.app;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PayInfo)) {
            return false;
        }
        PayInfo payInfo = (PayInfo) other;
        if (Intrinsics.areEqual(this.apiName, payInfo.apiName) && Intrinsics.areEqual(this.appId, payInfo.appId) && Intrinsics.areEqual(this.partnerId, payInfo.partnerId) && Intrinsics.areEqual(this.prepayId, payInfo.prepayId) && Intrinsics.areEqual(this.nonceStr, payInfo.nonceStr) && Intrinsics.areEqual(this.timeStamp, payInfo.timeStamp) && Intrinsics.areEqual(this.packageValue, payInfo.packageValue) && Intrinsics.areEqual(this.sign, payInfo.sign) && Intrinsics.areEqual(this.signType, payInfo.signType) && Intrinsics.areEqual(this.tradeType, payInfo.tradeType) && Intrinsics.areEqual(this.extData, payInfo.extData) && Intrinsics.areEqual(this.transaction, payInfo.transaction) && Intrinsics.areEqual(this.callbackScheme, payInfo.callbackScheme) && Intrinsics.areEqual(this.base, payInfo.base) && Intrinsics.areEqual(this.app, payInfo.app)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final PayInfoBase getBase() {
        return this.base;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final String getCallbackScheme() {
        return this.callbackScheme;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        int hashCode10;
        int hashCode11;
        int hashCode12 = this.apiName.hashCode() * 31;
        String str = this.appId;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode12 + hashCode) * 31;
        String str2 = this.partnerId;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.prepayId;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str4 = this.nonceStr;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        Long l3 = this.timeStamp;
        if (l3 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = l3.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        String str5 = this.packageValue;
        if (str5 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str5.hashCode();
        }
        int i27 = (i26 + hashCode6) * 31;
        String str6 = this.sign;
        if (str6 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = str6.hashCode();
        }
        int i28 = (i27 + hashCode7) * 31;
        String str7 = this.signType;
        if (str7 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = str7.hashCode();
        }
        int i29 = (i28 + hashCode8) * 31;
        String str8 = this.tradeType;
        if (str8 == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = str8.hashCode();
        }
        int i36 = (i29 + hashCode9) * 31;
        String str9 = this.extData;
        if (str9 == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = str9.hashCode();
        }
        int i37 = (i36 + hashCode10) * 31;
        String str10 = this.transaction;
        if (str10 == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = str10.hashCode();
        }
        int i38 = (i37 + hashCode11) * 31;
        String str11 = this.callbackScheme;
        if (str11 != null) {
            i3 = str11.hashCode();
        }
        return ((((i38 + i3) * 31) + this.base.hashCode()) * 31) + this.app.hashCode();
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final String getExtData() {
        return this.extData;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final String getPartnerId() {
        return this.partnerId;
    }

    @Nullable
    /* renamed from: l, reason: from getter */
    public final String getPrepayId() {
        return this.prepayId;
    }

    @NotNull
    public final String m() {
        try {
            JSONObject jSONObject = new JSONObject();
            p(jSONObject, "appId", this.appId);
            p(jSONObject, "bargainorId", this.partnerId);
            p(jSONObject, "nonce", this.nonceStr);
            jSONObject.put(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, this.timeStamp);
            p(jSONObject, PreloadTRTCPlayerParams.KEY_SIG, this.sign);
            p(jSONObject, "sigType", this.signType);
            p(jSONObject, VasUserData.Key.QQ_VER, this.base.getQVersion());
            p(jSONObject, "uin", this.base.getUin());
            p(jSONObject, AdParam.APPVER, this.app.getApkVersion());
            p(jSONObject, "pkgSha1Sig", this.app.getApkFingerPrint());
            p(jSONObject, PushClientConstants.TAG_PKG_NAME, this.app.getHostPackageName());
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026\n            }.toString()");
            return jSONObject2;
        } catch (JSONException unused) {
            return "";
        }
    }

    @Nullable
    /* renamed from: n, reason: from getter */
    public final String getTransaction() {
        return this.transaction;
    }

    public final boolean o() {
        return TextUtils.equals(this.apiName, OpenConstants.ApiName.PAY_V2);
    }

    @Deprecated(message = "V1\u7684\u652f\u4ed8\u65b9\u5f0f\u624d\u4f1a\u7528\u5230")
    @NotNull
    public final String q() {
        return "appid#" + this.appId + "|bargainor_id#" + this.partnerId + "|channel#thirdpartapp";
    }

    @NotNull
    public final String r() {
        String str = "ai=" + this.appId + "&ue=" + this.nonceStr + "&ts=" + this.timeStamp + "&sg=" + this.sign + "&st=" + this.signType + "&ti=" + this.prepayId + "&bi=" + this.partnerId + "&pn=" + this.app.getHostPackageName() + "&ipn=" + this.app.getInPackageName();
        Intrinsics.checkNotNullExpressionValue(str, "sBuilder.toString()");
        return str;
    }

    @NotNull
    public final Map<String, String> s() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("token_id", this.prepayId);
        linkedHashMap.put(j.T0, q());
        linkedHashMap.put("sdk_data", m());
        return linkedHashMap;
    }

    @NotNull
    public final Map<String, String> t() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = new JSONObject();
        p(jSONObject, "appid", this.appId);
        p(jSONObject, "partnerid", this.partnerId);
        p(jSONObject, "prepayid", this.prepayId);
        p(jSONObject, "noncestr", this.nonceStr);
        jSONObject.put("timestamp", this.timeStamp);
        p(jSONObject, "package", this.packageValue);
        p(jSONObject, "sign", this.sign);
        p(jSONObject, "sign_type", this.signType);
        Unit unit = Unit.INSTANCE;
        linkedHashMap.put("pay_auth_info", jSONObject.toString());
        JSONObject jSONObject2 = new JSONObject();
        p(jSONObject2, "qqSign", this.app.getQqSign());
        p(jSONObject2, "qqSignType", this.app.getQqSignType());
        p(jSONObject2, "sign", this.sign);
        p(jSONObject2, "appId", this.appId);
        p(jSONObject2, PushClientConstants.TAG_PKG_NAME, this.app.getInPackageName());
        p(jSONObject2, ZPlanPublishSource.FROM_SCHEME, this.callbackScheme);
        linkedHashMap.put("pay_sdk_data", jSONObject2.toString());
        linkedHashMap.put("route_version", "wx");
        return linkedHashMap;
    }

    @NotNull
    public String toString() {
        return "PayInfo(apiName=" + this.apiName + ", appId=" + this.appId + ", partnerId=" + this.partnerId + ", prepayId=" + this.prepayId + ", nonceStr=" + this.nonceStr + ", timeStamp=" + this.timeStamp + ", packageValue=" + this.packageValue + ", sign=" + this.sign + ", signType=" + this.signType + ", tradeType=" + this.tradeType + ", extData=" + this.extData + ", transaction=" + this.transaction + ", callbackScheme=" + this.callbackScheme + ", base=" + this.base + ", app=" + this.app + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.apiName);
        parcel.writeString(this.appId);
        parcel.writeString(this.partnerId);
        parcel.writeString(this.prepayId);
        parcel.writeString(this.nonceStr);
        Long l3 = this.timeStamp;
        if (l3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l3.longValue());
        }
        parcel.writeString(this.packageValue);
        parcel.writeString(this.sign);
        parcel.writeString(this.signType);
        parcel.writeString(this.tradeType);
        parcel.writeString(this.extData);
        parcel.writeString(this.transaction);
        parcel.writeString(this.callbackScheme);
        this.base.writeToParcel(parcel, flags);
        this.app.writeToParcel(parcel, flags);
    }

    public /* synthetic */ PayInfo(String str, String str2, String str3, String str4, String str5, Long l3, String str6, String str7, String str8, String str9, String str10, String str11, String str12, PayInfoBase payInfoBase, AppPayExt appPayExt, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, l3, str6, str7, str8, (i3 & 512) != 0 ? null : str9, (i3 & 1024) != 0 ? null : str10, str11, str12, payInfoBase, appPayExt);
    }
}
