package com.tencent.mobileqq.qwallet.pay;

import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.adapter.internal.CommonCode;
import com.qwallet.data.PayPucAccManager;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tenpay.api.TenpayInterface;
import com.tenpay.sdk.SDKCallbackManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.im.qqwallet.PaySuccessAd$GetAdRsp;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 b2\u00020\u0001:\u0001cB\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b`\u0010aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0004J*\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u000eR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010!\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001dR\u0014\u0010#\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001bR\u0014\u0010%\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u0016R\u0014\u0010'\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\u001bR\u0014\u0010)\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010\u001bR\u0014\u0010+\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010\u001bR\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\n0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\n008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\"\u00108\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u0016\u001a\u0004\b5\u0010\u0018\"\u0004\b6\u00107R\"\u0010:\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010\u0016\u001a\u0004\b:\u0010\u0018\"\u0004\b;\u00107R\u001c\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010.R\u0014\u0010@\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010\u0016R\u0014\u0010B\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010\u0016R\u0014\u0010D\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010\u0016R\u0014\u0010F\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010\u001bR\u0014\u0010H\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010\u001bR\u0014\u0010J\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010\u0016R\u0017\u0010O\u001a\u00020K8\u0006\u00a2\u0006\f\n\u0004\bL\u0010-\u001a\u0004\bM\u0010NR\u0011\u0010Q\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\bP\u0010\u001dR\u0017\u0010U\u001a\b\u0012\u0004\u0012\u00020\n0R8F\u00a2\u0006\u0006\u001a\u0004\bS\u0010TR\u0019\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0R8F\u00a2\u0006\u0006\u001a\u0004\bV\u0010TR\u0013\u0010[\u001a\u0004\u0018\u00010X8F\u00a2\u0006\u0006\u001a\u0004\bY\u0010ZR\u0013\u0010_\u001a\u0004\u0018\u00010\\8F\u00a2\u0006\u0006\u001a\u0004\b]\u0010^\u00a8\u0006d"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pay/PaySuccessAdViewModel;", "Landroidx/lifecycle/ViewModel;", "", "S1", "", "initData", "g2", "P1", "d2", "c2", "", "opName", "ext3", "ext4", "", "opIn", SemanticAttributes.DbSystemValues.H2, "Landroidx/lifecycle/SavedStateHandle;", "i", "Landroidx/lifecycle/SavedStateHandle;", "stateHandle", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "e2", "()Z", "isShowSuccessPage", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "b2", "()Ljava/lang/String;", "successData", "D", "X1", "merchandiseTitle", "E", "totalFee", UserInfo.SEX_FEMALE, "isShowAd", "G", "bargainerId", "H", "businessId", "I", "subBargainerId", "Landroidx/lifecycle/MutableLiveData;", "J", "Landroidx/lifecycle/MutableLiveData;", "_paNamesLiveData", "", "K", "Ljava/util/List;", "unfollowedPuins", "L", "f2", "i2", "(Z)V", "isUnfollowedManually", "M", "isUserChecked", "j2", "Ltencent/im/qqwallet/PaySuccessAd$GetAdRsp;", "N", "_adRsp", "P", "isH5Success", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "isSuccessHide", BdhLogUtil.LogTag.Tag_Req, "isIvrSucc", ExifInterface.LATITUDE_SOUTH, "bargainorId", "T", "offerId", "U", "enableRequest", "", "V", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()J", "processId", "T1", "displayedFee", "Landroidx/lifecycle/LiveData;", "Z1", "()Landroidx/lifecycle/LiveData;", "paNamesLiveData", "R1", "adRsp", "Lcom/tencent/gdtad/aditem/GdtAd;", "W1", "()Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "Lcom/tencent/mobileqq/qwallet/pay/FinanceAdInfo;", "U1", "()Lcom/tencent/mobileqq/qwallet/pay/FinanceAdInfo;", "financeAd", "<init>", "(Landroidx/lifecycle/SavedStateHandle;)V", "W", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PaySuccessAdViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String successData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String merchandiseTitle;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String totalFee;

    /* renamed from: F, reason: from kotlin metadata */
    private final boolean isShowAd;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final String bargainerId;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final String businessId;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final String subBargainerId;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> _paNamesLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private List<String> unfollowedPuins;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isUnfollowedManually;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isUserChecked;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<PaySuccessAd$GetAdRsp> _adRsp;

    /* renamed from: P, reason: from kotlin metadata */
    private final boolean isH5Success;

    /* renamed from: Q, reason: from kotlin metadata */
    private final boolean isSuccessHide;

    /* renamed from: R, reason: from kotlin metadata */
    private final boolean isIvrSucc;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final String bargainorId;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final String offerId;

    /* renamed from: U, reason: from kotlin metadata */
    private final boolean enableRequest;

    /* renamed from: V, reason: from kotlin metadata */
    private final long processId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SavedStateHandle stateHandle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean isShowSuccessPage;

    public PaySuccessAdViewModel(@NotNull SavedStateHandle stateHandle) {
        boolean booleanValue;
        int intValue;
        boolean z16;
        boolean booleanValue2;
        boolean booleanValue3;
        boolean booleanValue4;
        long longValue;
        Intrinsics.checkNotNullParameter(stateHandle, "stateHandle");
        this.stateHandle = stateHandle;
        Boolean bool = (Boolean) stateHandle.get("show_native_paysucc");
        if (bool == null) {
            booleanValue = true;
        } else {
            booleanValue = bool.booleanValue();
        }
        this.isShowSuccessPage = booleanValue;
        String str = (String) stateHandle.get("success");
        str = str == null ? "{}" : str;
        this.successData = str;
        String str2 = (String) stateHandle.get("goods_name");
        this.merchandiseTitle = str2 == null ? "" : str2;
        String str3 = (String) stateHandle.get("total_fee");
        this.totalFee = str3 == null ? "0" : str3;
        Integer num = (Integer) stateHandle.get("ad_display");
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        if (intValue == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isShowAd = z16;
        String str4 = (String) stateHandle.get("bargainor_id");
        this.bargainerId = str4 == null ? "" : str4;
        this._paNamesLiveData = new MutableLiveData<>();
        this.unfollowedPuins = new ArrayList();
        this.isUserChecked = true;
        this._adRsp = new MutableLiveData<>();
        Boolean bool2 = (Boolean) stateHandle.get("h5_success");
        if (bool2 == null) {
            booleanValue2 = false;
        } else {
            booleanValue2 = bool2.booleanValue();
        }
        this.isH5Success = booleanValue2;
        Boolean bool3 = (Boolean) stateHandle.get("succ_hide");
        if (bool3 == null) {
            booleanValue3 = false;
        } else {
            booleanValue3 = bool3.booleanValue();
        }
        this.isSuccessHide = booleanValue3;
        String str5 = (String) stateHandle.get("bargainor_id");
        this.bargainorId = str5 == null ? "" : str5;
        String str6 = (String) stateHandle.get("offer_id");
        this.offerId = str6 != null ? str6 : "";
        Boolean bool4 = (Boolean) stateHandle.get("enableRequest");
        if (bool4 == null) {
            booleanValue4 = false;
        } else {
            booleanValue4 = bool4.booleanValue();
        }
        this.enableRequest = booleanValue4;
        Long l3 = (Long) stateHandle.get("prossesId");
        if (l3 == null) {
            longValue = 0;
        } else {
            longValue = l3.longValue();
        }
        this.processId = longValue;
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("business_id");
        Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"business_id\")");
        this.businessId = optString;
        String optString2 = jSONObject.optString("sub_mch_id");
        Intrinsics.checkNotNullExpressionValue(optString2, "it.optString(\"sub_mch_id\")");
        this.subBargainerId = optString2;
        boolean optBoolean = jSONObject.optBoolean("is_ivr_succ", false);
        this.isIvrSucc = optBoolean;
        QLog.d("PaySuccessAdViewModel", 1, "init : isH5Success " + booleanValue2 + ", isSuccessHide " + booleanValue3 + ", isIvrSucc " + optBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(PaySuccessAdViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        for (String str : this$0.unfollowedPuins) {
            try {
                ((INewQWalletApi) QRoute.apiIPCSync(INewQWalletApi.class)).ipcFollowUin(str, this$0.isUserChecked);
            } catch (Exception e16) {
                QLog.e("PaySuccessAdViewModel", 1, "followPuins: puin " + str + ", isFollow " + this$0.isUserChecked, e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean S1() {
        QLog.d("PaySuccessAdViewModel", 1, "getCacheAdInfoFromSSo: ");
        byte[] bArr = (byte[]) this.stateHandle.get("ad_rsp_bytes");
        if (bArr != null) {
            this._adRsp.setValue(new PaySuccessAd$GetAdRsp().mergeFrom(bArr));
            return true;
        }
        Pair<String, PaySuccessAd$GetAdRsp> b16 = h.f278657a.b(null);
        if (b16 != null && Intrinsics.areEqual(b16.getFirst(), this.bargainerId)) {
            this.stateHandle.set("ad_rsp_bytes", b16.getSecond().toByteArray());
            this._adRsp.setValue(b16.getSecond());
            return true;
        }
        this._adRsp.setValue(null);
        return false;
    }

    public final void P1() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.pay.g
            @Override // java.lang.Runnable
            public final void run() {
                PaySuccessAdViewModel.Q1(PaySuccessAdViewModel.this);
            }
        }, 16, null, true);
    }

    @NotNull
    public final LiveData<PaySuccessAd$GetAdRsp> R1() {
        return this._adRsp;
    }

    @NotNull
    public final String T1() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(Float.parseFloat(this.totalFee) / 100.0f)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @Nullable
    public final FinanceAdInfo U1() {
        PaySuccessAd$GetAdRsp value = this._adRsp.getValue();
        if (value != null) {
            return a.a(value);
        }
        return null;
    }

    @Nullable
    public final GdtAd W1() {
        PaySuccessAd$GetAdRsp value = this._adRsp.getValue();
        if (value != null) {
            return a.b(value);
        }
        return null;
    }

    @NotNull
    /* renamed from: X1, reason: from getter */
    public final String getMerchandiseTitle() {
        return this.merchandiseTitle;
    }

    @NotNull
    public final LiveData<String> Z1() {
        return this._paNamesLiveData;
    }

    /* renamed from: a2, reason: from getter */
    public final long getProcessId() {
        return this.processId;
    }

    @NotNull
    /* renamed from: b2, reason: from getter */
    public final String getSuccessData() {
        return this.successData;
    }

    public final void c2() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean booleanValue;
        int intValue;
        boolean z26;
        ResultReceiver resultReceiver = (ResultReceiver) this.stateHandle.get(SDKCallbackManager.SESSION_RECEIVER);
        if (resultReceiver == null) {
            QLog.d("PaySuccessAdViewModel", 1, "invokeSessionReceiver: no session receiver found in intent");
            return;
        }
        JSONObject jSONObject = new JSONObject(this.successData);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(CommonCode.MapKey.TRANSACTION_ID, jSONObject.optString(CommonCode.MapKey.TRANSACTION_ID));
        jSONObject2.put("pay_time", jSONObject.optString("pay_time"));
        jSONObject2.put("sp_data", jSONObject.optString("sp_data"));
        jSONObject2.put("callback_url", jSONObject.optString("callback_url"));
        String optString = jSONObject.optString("real_fee");
        if (optString.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            optString = this.totalFee;
        }
        jSONObject2.put("total_fee", optString);
        String str = (String) this.stateHandle.get("sdk_auth_data");
        String str2 = "";
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "stateHandle[\"sdk_auth_data\"] ?: \"\"");
        }
        if (str.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            jSONObject2.put("sdk_auth_data", str);
        }
        String str3 = (String) this.stateHandle.get("exec_code");
        if (str3 == null) {
            str3 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str3, "stateHandle[\"exec_code\"] ?: \"\"");
        }
        if (str3.length() > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            jSONObject2.put("exec_code", str3);
        }
        String str4 = (String) this.stateHandle.get("subscribe_info");
        if (str4 == null) {
            str4 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str4, "stateHandle[\"subscribe_info\"] ?: \"\"");
        }
        if (str4.length() > 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19) {
            jSONObject2.put("is_subscribe", this.isUserChecked);
            String str5 = (String) this.stateHandle.get("service_id");
            if (str5 == null) {
                str5 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str5, "stateHandle[\"service_id\"] ?: \"\"");
            }
            if (this.isUserChecked) {
                if (str5.length() > 0) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if (z26) {
                    jSONObject2.put("service_id", str5);
                }
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("retmsg", jSONObject2.toString());
        String str6 = (String) this.stateHandle.get("fromPage");
        if (str6 == null) {
            str6 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str6, "stateHandle[\"fromPage\"] ?: \"\"");
        }
        if (Intrinsics.areEqual(TenpayInterface.VIEWTAG_REQARDTRANSFER, str6)) {
            String str7 = (String) this.stateHandle.get("transfercallback_data");
            if (str7 != null) {
                str2 = str7;
            }
            bundle.putString("retdata", str2);
        }
        Boolean bool = (Boolean) this.stateHandle.get("is_midas");
        if (bool == null) {
            booleanValue = false;
        } else {
            Intrinsics.checkNotNullExpressionValue(bool, "stateHandle[\"is_midas\"] ?: false");
            booleanValue = bool.booleanValue();
        }
        if (booleanValue) {
            bundle.putInt(DefaultTVKDataProvider.KEY_PAY_TYPE, -1);
            Integer num = (Integer) this.stateHandle.get("midas_paytype");
            if (num == null) {
                intValue = 0;
            } else {
                Intrinsics.checkNotNullExpressionValue(num, "stateHandle[\"midas_paytype\"] ?: 0");
                intValue = num.intValue();
            }
            bundle.putInt("backfrom", intValue);
        }
        QLog.d("PaySuccessAdViewModel", 1, "invokeSessionReceiver: retCode 0, args " + bundle);
        resultReceiver.send(0, bundle);
    }

    public final boolean d2() {
        if ((!this.isIvrSucc && this.isH5Success) || this.isSuccessHide) {
            return true;
        }
        return false;
    }

    /* renamed from: e2, reason: from getter */
    public final boolean getIsShowSuccessPage() {
        return this.isShowSuccessPage;
    }

    /* renamed from: f2, reason: from getter */
    public final boolean getIsUnfollowedManually() {
        return this.isUnfollowedManually;
    }

    public final void g2() {
        ResultReceiver resultReceiver = new ResultReceiver() { // from class: com.tencent.mobileqq.qwallet.pay.PaySuccessAdViewModel$queryPublicAccountStatus$callback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(null);
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, @NotNull Bundle resultData) {
                ArrayList arrayList;
                List list;
                List list2;
                int collectionSizeOrDefault;
                Object first;
                boolean contains;
                String joinToString$default;
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(resultData, "resultData");
                QLog.d("PaySuccessAdViewModel", 1, "onReceiveResult: queryPublicAccountStatus resultCode " + resultCode);
                if (resultCode == 0) {
                    Serializable serializable = resultData.getSerializable("subItems");
                    if (serializable instanceof ArrayList) {
                        arrayList = (ArrayList) serializable;
                    } else {
                        arrayList = null;
                    }
                    if (arrayList != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj : arrayList) {
                            if (!((PayPucAccManager.PubAccItem) obj).isFollowed) {
                                arrayList2.add(obj);
                            }
                        }
                        if (!arrayList2.isEmpty()) {
                            list = PaySuccessAdViewModel.this.unfollowedPuins;
                            list.clear();
                            list2 = PaySuccessAdViewModel.this.unfollowedPuins;
                            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
                            Iterator it = arrayList2.iterator();
                            while (it.hasNext()) {
                                arrayList3.add(String.valueOf(((PayPucAccManager.PubAccItem) it.next()).puin));
                            }
                            list2.addAll(arrayList3);
                            PaySuccessAdViewModel paySuccessAdViewModel = PaySuccessAdViewModel.this;
                            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList2);
                            PayPucAccManager.PubAccItem pubAccItem = (PayPucAccManager.PubAccItem) first;
                            String[] strArr = pubAccItem.uinsCancelled;
                            Intrinsics.checkNotNullExpressionValue(strArr, "it.uinsCancelled");
                            contains = ArraysKt___ArraysKt.contains(strArr, String.valueOf(pubAccItem.puin));
                            paySuccessAdViewModel.i2(contains);
                            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList2, "/", "\u5173\u6ce8", "\u516c\u4f17\u53f7", 0, null, new Function1<PayPucAccManager.PubAccItem, CharSequence>() { // from class: com.tencent.mobileqq.qwallet.pay.PaySuccessAdViewModel$queryPublicAccountStatus$callback$1$onReceiveResult$names$1
                                @Override // kotlin.jvm.functions.Function1
                                @NotNull
                                public final CharSequence invoke(@NotNull PayPucAccManager.PubAccItem it5) {
                                    Intrinsics.checkNotNullParameter(it5, "it");
                                    String str = it5.name;
                                    Intrinsics.checkNotNullExpressionValue(str, "it.name");
                                    return str;
                                }
                            }, 24, null);
                            QLog.d("PaySuccessAdViewModel", 1, "onReceiveResult: names " + joinToString$default);
                            mutableLiveData = PaySuccessAdViewModel.this._paNamesLiveData;
                            mutableLiveData.postValue(joinToString$default);
                            return;
                        }
                        QLog.d("PaySuccessAdViewModel", 1, "onReceiveResult: notFollowedList is empty");
                        return;
                    }
                    QLog.d("PaySuccessAdViewModel", 1, "onReceiveResult: notFollowedList is null");
                }
            }
        };
        Bundle bundle = new Bundle();
        bundle.putString("bargainorId", this.bargainerId);
        bundle.putString("businessId", this.businessId);
        bundle.putString("subBargainorId", this.subBargainerId);
        bundle.putInt("payType", 1);
        bundle.putParcelable("callback", resultReceiver);
        PayPucAccManager.o(bundle);
    }

    public final void h2(@NotNull String opName, @Nullable String ext3, @Nullable String ext4, int opIn) {
        Intrinsics.checkNotNullParameter(opName, "opName");
        com.tencent.mobileqq.qwallet.c.d("", opName, QCircleDaTongConstant.ElementParamValue.WALLET, opIn, 0, "", "", ext3, ext4);
    }

    public final void i2(boolean z16) {
        this.isUnfollowedManually = z16;
    }

    public final void initData() {
        if (!S1() && this.enableRequest) {
            h.e(this.bargainorId, this.offerId, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.qwallet.pay.PaySuccessAdViewModel$initData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    PaySuccessAdViewModel.this.S1();
                }
            });
        }
    }

    public final void j2(boolean z16) {
        this.isUserChecked = z16;
    }
}
