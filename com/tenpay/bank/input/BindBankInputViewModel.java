package com.tenpay.bank.input;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.type.DeviceType;
import com.huawei.hms.adapter.internal.CommonCode;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.QwLog;
import com.tenpay.bank.BankConstants;
import com.tenpay.ndk.CertUtil;
import com.tenpay.sdk.activity.DepositStartActivity;
import com.tenpay.sdk.activity.WithdrawActivity;
import com.tenpay.sdk.net.NetParams;
import com.tenpay.sdk.util.AESUtils;
import com.tenpay.sdk.util.WalletGateData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\b\u0018\u0000 w2\u00020\u00012\u00020\u0002:\u0001wB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J&\u0010b\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r0cj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r`dJ.\u0010e\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r0cj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r`d2\u0006\u0010f\u001a\u00020\rJ&\u0010g\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r0cj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r`dJ\u0010\u0010h\u001a\u0004\u0018\u00010\u00132\u0006\u0010i\u001a\u00020\rJ\u0012\u0010h\u001a\u0004\u0018\u00010\u00132\u0006\u0010j\u001a\u00020\u0013H\u0002J\u000e\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\u0013J\u001e\u0010n\u001a\u00020l2\u0014\u0010o\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r0pH\u0002J,\u0010q\u001a\u00020l2\u0006\u0010r\u001a\u00020\r2\b\b\u0002\u0010s\u001a\u00020\r2\b\b\u0002\u0010t\u001a\u00020\r2\b\b\u0002\u0010u\u001a\u00020\rJ\u000e\u0010v\u001a\u00020l2\u0006\u0010m\u001a\u00020\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\u001c\u0010!\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001a\u0010$\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011R\u001e\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00130(j\b\u0012\u0004\u0012\u00020\u0013`)X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00130(j\b\u0012\u0004\u0012\u00020\u0013`)X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00130(j\b\u0012\u0004\u0012\u00020\u0013`)X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010,\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u000fR\u001a\u0010.\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000f\"\u0004\b0\u0010\u0011R\u001a\u00101\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u000f\"\u0004\b3\u0010\u0011R\u0011\u00104\u001a\u00020\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001bR\u0011\u00106\u001a\u000207\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010:\u001a\u000207\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u00109R\u0011\u0010<\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010\u000fR\u0011\u0010>\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010\u000fR\u001a\u0010@\u001a\u00020AX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u000f\"\u0004\bH\u0010\u0011R\u001a\u0010I\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u000f\"\u0004\bK\u0010\u0011R\u001a\u0010L\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u001b\"\u0004\bN\u0010\u001dR\u0011\u0010O\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u0010\u000fR\u001a\u0010Q\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u001b\"\u0004\bS\u0010\u001dR\u001a\u0010T\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u000f\"\u0004\bV\u0010\u0011R\u001c\u0010W\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u000f\"\u0004\bY\u0010\u0011R\u0011\u0010Z\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b[\u0010\u000fR\u000e\u0010\\\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010_\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u000f\"\u0004\ba\u0010\u0011\u00a8\u0006x"}, d2 = {"Lcom/tenpay/bank/input/BindBankInputViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "stateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Landroidx/lifecycle/SavedStateHandle;)V", "bankBinJson", "Lorg/json/JSONArray;", "getBankBinJson", "()Lorg/json/JSONArray;", "setBankBinJson", "(Lorg/json/JSONArray;)V", "bankCardId", "", "getBankCardId", "()Ljava/lang/String;", "setBankCardId", "(Ljava/lang/String;)V", "bankData", "Lorg/json/JSONObject;", "getBankData", "()Lorg/json/JSONObject;", "setBankData", "(Lorg/json/JSONObject;)V", "binLength", "", "getBinLength", "()I", "setBinLength", "(I)V", "bindCardPreObj", "getBindCardPreObj", "setBindCardPreObj", "currentBankData", "getCurrentBankData", "setCurrentBankData", "cvvContent", "getCvvContent", "setCvvContent", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "fastCreditBankList", "fastDebitBankList", "mAppInfo", "getMAppInfo", "mCardID", "getMCardID", "setMCardID", "mCardType", "getMCardType", "setMCardType", "mComeFrom", "getMComeFrom", "mIsFromDeposit", "", "getMIsFromDeposit", "()Z", "mIsFromWithdraw", "getMIsFromWithdraw", "mPromotionFlag", "getMPromotionFlag", "mPromotionId", "getMPromotionId", "mTimestamp", "", "getMTimestamp", "()J", "setMTimestamp", "(J)V", "mTrueName", "getMTrueName", "setMTrueName", "mUin", "getMUin", "setMUin", "mUserAttr", "getMUserAttr", "setMUserAttr", "mWithdrawCount", "getMWithdrawCount", "passFlagInt", "getPassFlagInt", "setPassFlagInt", NotificationActivity.PASSWORD, "getPassword", "setPassword", "phoneNum", "getPhoneNum", "setPhoneNum", "prefillUserInfo", "getPrefillUserInfo", "queryType", "scene", "sendSmsNum", "thruContent", "getThruContent", "setThruContent", "createItgAuthenRequest", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "createItgVerifyRequest", "verifyCode", "createWalBankQueryRequest", "findBankData", "bankCardInput", "bankInfo", "onWalBankQuerySuccess", "", "data", "personInfoEnc", "obj", "", "reportTo644", "actionName", "r2", "r4", "r5", "setQwalletData", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class BindBankInputViewModel extends ViewModel implements LifecycleObserver {

    @NotNull
    private static final String TAG = "BindBankInputViewModel";

    @Nullable
    private JSONArray bankBinJson;

    @Nullable
    private String bankCardId;

    @Nullable
    private JSONObject bankData;
    private int binLength;

    @Nullable
    private JSONObject bindCardPreObj;

    @Nullable
    private JSONObject currentBankData;

    @NotNull
    private String cvvContent;

    @NotNull
    private final ArrayList<JSONObject> dataList;

    @NotNull
    private final ArrayList<JSONObject> fastCreditBankList;

    @NotNull
    private final ArrayList<JSONObject> fastDebitBankList;

    @NotNull
    private final String mAppInfo;

    @NotNull
    private String mCardID;

    @NotNull
    private String mCardType;
    private final int mComeFrom;
    private final boolean mIsFromDeposit;
    private final boolean mIsFromWithdraw;

    @NotNull
    private final String mPromotionFlag;

    @NotNull
    private final String mPromotionId;
    private long mTimestamp;

    @NotNull
    private String mTrueName;

    @NotNull
    private String mUin;
    private int mUserAttr;

    @NotNull
    private final String mWithdrawCount;
    private int passFlagInt;

    @NotNull
    private String password;

    @Nullable
    private String phoneNum;

    @NotNull
    private final String prefillUserInfo;

    @NotNull
    private final String queryType;
    private final int scene;
    private int sendSmsNum;

    @NotNull
    private String thruContent;

    public BindBankInputViewModel(@NotNull SavedStateHandle stateHandle) {
        int intValue;
        int intValue2;
        long longValue;
        int intValue3;
        boolean z16;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter(stateHandle, "stateHandle");
        Integer num = (Integer) stateHandle.get("come_from");
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        this.mComeFrom = intValue;
        String str = (String) stateHandle.get(com.tencent.mobileqq.msf.core.c0.j.T0);
        this.mAppInfo = str == null ? "" : str;
        String str2 = (String) stateHandle.get("promotionflag");
        this.mPromotionFlag = str2 == null ? "" : str2;
        String str3 = (String) stateHandle.get("promotionid");
        this.mPromotionId = str3 == null ? "" : str3;
        Integer num2 = (Integer) stateHandle.get("user_attr");
        if (num2 == null) {
            intValue2 = 0;
        } else {
            intValue2 = num2.intValue();
        }
        this.mUserAttr = intValue2;
        String str4 = (String) stateHandle.get("true_name");
        this.mTrueName = str4 == null ? "" : str4;
        String str5 = (String) stateHandle.get("card_type");
        this.mCardType = str5 == null ? "" : str5;
        Long l3 = (Long) stateHandle.get("time_stamp");
        if (l3 == null) {
            longValue = 0;
        } else {
            longValue = l3.longValue();
        }
        this.mTimestamp = longValue;
        String str6 = (String) stateHandle.get("card_id");
        this.mCardID = str6 == null ? "" : str6;
        String str7 = (String) stateHandle.get("uin");
        this.mUin = str7 == null ? com.tencent.mobileqq.base.a.c() : str7;
        String str8 = (String) stateHandle.get("query_type");
        this.queryType = str8 == null ? "" : str8;
        Integer num3 = (Integer) stateHandle.get(BankConstants.EXTRA_KEY_BIND_SCENE_TYPE);
        if (num3 == null) {
            intValue3 = 3;
        } else {
            intValue3 = num3.intValue();
        }
        this.scene = intValue3;
        String str9 = (String) stateHandle.get("prefillUserInfo");
        this.prefillUserInfo = str9 == null ? "" : str9;
        this.passFlagInt = -1;
        Object obj = stateHandle.get("pass_flag");
        if (obj instanceof Integer) {
            this.passFlagInt = ((Number) obj).intValue();
        } else if (obj instanceof String) {
            if (((CharSequence) obj).length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                try {
                    this.passFlagInt = Integer.parseInt((String) obj);
                } catch (NumberFormatException e16) {
                    QwLog.e("pass_flag parseInt error:" + e16);
                }
            }
        }
        Boolean bool = (Boolean) stateHandle.get(WithdrawActivity.FROM_WITHDRAW);
        if (bool == null) {
            booleanValue = false;
        } else {
            booleanValue = bool.booleanValue();
        }
        this.mIsFromWithdraw = booleanValue;
        String str10 = (String) stateHandle.get(WithdrawActivity.WITHDRAW_COUNT);
        this.mWithdrawCount = str10 == null ? "" : str10;
        Boolean bool2 = (Boolean) stateHandle.get(DepositStartActivity.FROM_DESPOSIT);
        this.mIsFromDeposit = bool2 != null ? bool2.booleanValue() : false;
        this.fastCreditBankList = new ArrayList<>();
        this.fastDebitBankList = new ArrayList<>();
        this.dataList = new ArrayList<>();
        this.thruContent = "";
        this.cvvContent = "";
        this.password = "";
    }

    private final void personInfoEnc(Map<String, String> obj) {
        HashMap hashMap = new HashMap();
        hashMap.put("creditcard_id", this.mCardID);
        String str = this.bankCardId;
        if (str == null) {
            str = "";
        }
        hashMap.put("bank_card_id", str);
        AESUtils.encryptInfoIfRsa2048(MobileQQ.sMobileQQ, obj, hashMap);
    }

    public static /* synthetic */ void reportTo644$default(BindBankInputViewModel bindBankInputViewModel, String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        if ((i3 & 4) != 0) {
            str3 = "";
        }
        if ((i3 & 8) != 0) {
            str4 = "";
        }
        bindBankInputViewModel.reportTo644(str, str2, str3, str4);
    }

    @NotNull
    public final HashMap<String, String> createItgAuthenRequest() {
        String str;
        JSONObject jSONObject = this.currentBankData;
        if (jSONObject == null) {
            return new HashMap<>();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("valid_thru", this.thruContent);
        hashMap.put("cvc", this.cvvContent);
        hashMap.put("bank_type", jSONObject.optString("code"));
        hashMap.put("true_name", this.mTrueName);
        hashMap.put("creditcard_type", this.mCardType);
        String str2 = this.phoneNum;
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put(DeviceType.DeviceCategory.MOBILE, str2);
        if (this.sendSmsNum > 1) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("is_reentry", str);
        hashMap.put("come_from", String.valueOf(this.mComeFrom));
        hashMap.put(com.tencent.mobileqq.msf.core.c0.j.T0, this.mAppInfo);
        try {
            personInfoEnc(hashMap);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
        this.sendSmsNum++;
        return hashMap;
    }

    @NotNull
    public final HashMap<String, String> createItgVerifyRequest(@NotNull String verifyCode) {
        String str;
        Intrinsics.checkNotNullParameter(verifyCode, "verifyCode");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("is_ydt", "0");
        JSONObject jSONObject = this.currentBankData;
        if (jSONObject != null) {
            str = jSONObject.optString("code");
        } else {
            str = null;
        }
        String str2 = "";
        if (str == null) {
            str = "";
        }
        hashMap.put("bank_type", str);
        hashMap.put("verify_code", verifyCode);
        hashMap.put("purchaser_id", this.mUin);
        String str3 = this.phoneNum;
        if (str3 != null) {
            str2 = str3;
        }
        hashMap.put(DeviceType.DeviceCategory.MOBILE, str2);
        JSONObject jSONObject2 = this.bindCardPreObj;
        if (jSONObject2 != null) {
            hashMap.put("token", jSONObject2.optString("token"));
            hashMap.put(CommonCode.MapKey.TRANSACTION_ID, jSONObject2.optString(CommonCode.MapKey.TRANSACTION_ID));
            hashMap.put("business_type", jSONObject2.optString("business_type"));
            hashMap.put("auth_params", jSONObject2.optString("auth_params"));
        }
        hashMap.put("timestamp", String.valueOf(this.mTimestamp));
        hashMap.put("p", this.password);
        hashMap.put("reset_pwd_flag", "0");
        hashMap.put("qpay_cert_cn", CertUtil.getCid(MobileQQ.sMobileQQ, com.tencent.mobileqq.base.a.c()));
        int i3 = this.mComeFrom;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        hashMap.put("come_from", sb5.toString());
        hashMap.put(com.tencent.mobileqq.msf.core.c0.j.T0, this.mAppInfo);
        return hashMap;
    }

    @NotNull
    public final HashMap<String, String> createWalBankQueryRequest() {
        String str;
        boolean z16;
        HashMap<String, String> hashMap = new HashMap<>();
        if (Intrinsics.areEqual(this.mPromotionFlag, "1")) {
            hashMap.put("promotion_id", this.mPromotionId);
        }
        hashMap.put("user_info", "1");
        if (this.mIsFromWithdraw) {
            str = "QUICKPAY_DRAW";
        } else if (this.mIsFromDeposit) {
            str = "CHARGE";
        } else {
            str = this.queryType;
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str = "PAY";
            }
        }
        hashMap.put("query_type", str);
        hashMap.put("scene", String.valueOf(this.scene));
        hashMap.put("unbind_flag", "1");
        return hashMap;
    }

    @Nullable
    public final JSONObject findBankData(@NotNull String bankCardInput) {
        List split$default;
        Intrinsics.checkNotNullParameter(bankCardInput, "bankCardInput");
        JSONArray jSONArray = this.bankBinJson;
        if (jSONArray != null) {
            for (int i3 = 10; 2 < i3; i3--) {
                String substring = bankCardInput.substring(0, i3);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                int length = jSONArray.length();
                for (int i16 = 0; i16 < length; i16++) {
                    JSONObject bankInfo = jSONArray.optJSONObject(i16);
                    String optString = bankInfo.optString("bin");
                    Intrinsics.checkNotNullExpressionValue(optString, "bankInfo.optString(\"bin\")");
                    split$default = StringsKt__StringsKt.split$default((CharSequence) optString, new String[]{"|"}, false, 0, 6, (Object) null);
                    if (split$default.contains(substring)) {
                        this.binLength = bankInfo.optInt(com.tencent.luggage.wxa.c8.c.E, -1);
                        if (bankInfo.optInt("type") == 2) {
                            if (this.mIsFromWithdraw) {
                                MobileQQ mobileQQ = MobileQQ.sMobileQQ;
                                QQToast.makeText(mobileQQ, 1, mobileQQ.getString(R.string.e9n), 0).show();
                                return null;
                            }
                            if (this.mIsFromDeposit) {
                                MobileQQ mobileQQ2 = MobileQQ.sMobileQQ;
                                QQToast.makeText(mobileQQ2, 1, mobileQQ2.getString(R.string.e9m), 0).show();
                                return null;
                            }
                        }
                        Intrinsics.checkNotNullExpressionValue(bankInfo, "bankInfo");
                        return findBankData(bankInfo);
                    }
                }
            }
        }
        return null;
    }

    @Nullable
    public final JSONArray getBankBinJson() {
        return this.bankBinJson;
    }

    @Nullable
    public final String getBankCardId() {
        return this.bankCardId;
    }

    @Nullable
    public final JSONObject getBankData() {
        return this.bankData;
    }

    public final int getBinLength() {
        return this.binLength;
    }

    @Nullable
    public final JSONObject getBindCardPreObj() {
        return this.bindCardPreObj;
    }

    @Nullable
    public final JSONObject getCurrentBankData() {
        return this.currentBankData;
    }

    @NotNull
    public final String getCvvContent() {
        return this.cvvContent;
    }

    @NotNull
    public final String getMAppInfo() {
        return this.mAppInfo;
    }

    @NotNull
    public final String getMCardID() {
        return this.mCardID;
    }

    @NotNull
    public final String getMCardType() {
        return this.mCardType;
    }

    public final int getMComeFrom() {
        return this.mComeFrom;
    }

    public final boolean getMIsFromDeposit() {
        return this.mIsFromDeposit;
    }

    public final boolean getMIsFromWithdraw() {
        return this.mIsFromWithdraw;
    }

    @NotNull
    public final String getMPromotionFlag() {
        return this.mPromotionFlag;
    }

    @NotNull
    public final String getMPromotionId() {
        return this.mPromotionId;
    }

    public final long getMTimestamp() {
        return this.mTimestamp;
    }

    @NotNull
    public final String getMTrueName() {
        return this.mTrueName;
    }

    @NotNull
    public final String getMUin() {
        return this.mUin;
    }

    public final int getMUserAttr() {
        return this.mUserAttr;
    }

    @NotNull
    public final String getMWithdrawCount() {
        return this.mWithdrawCount;
    }

    public final int getPassFlagInt() {
        return this.passFlagInt;
    }

    @NotNull
    public final String getPassword() {
        return this.password;
    }

    @Nullable
    public final String getPhoneNum() {
        return this.phoneNum;
    }

    @NotNull
    public final String getPrefillUserInfo() {
        return this.prefillUserInfo;
    }

    @NotNull
    public final String getThruContent() {
        return this.thruContent;
    }

    public final void onWalBankQuerySuccess(@NotNull JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.bankData = data;
        JSONArray optJSONArray = data.optJSONArray("banklist");
        if (optJSONArray == null) {
            return;
        }
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            String optString = optJSONObject.optString("type");
            if (!Intrinsics.areEqual(NetParams.DEBIT_FAST, optString) && !Intrinsics.areEqual(NetParams.CREDIT_FAST, optString) && !Intrinsics.areEqual("DEBIT", optString) && !Intrinsics.areEqual("CREDIT", optString)) {
                if (Intrinsics.areEqual(NetParams.DEBIT_UNBIND, optJSONObject.optString("type"))) {
                    this.fastDebitBankList.add(optJSONObject);
                } else {
                    this.fastCreditBankList.add(optJSONObject);
                }
            } else {
                this.dataList.add(optJSONObject);
            }
        }
        this.passFlagInt = data.optInt("pass_flag");
    }

    public final void reportTo644(@NotNull String actionName, @NotNull String r26, @NotNull String r46, @NotNull String r56) {
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        Intrinsics.checkNotNullParameter(r26, "r2");
        Intrinsics.checkNotNullParameter(r46, "r4");
        Intrinsics.checkNotNullParameter(r56, "r5");
        com.tencent.mobileqq.qwallet.c.e(actionName, r26, "", r46, r56);
    }

    public final void setBankBinJson(@Nullable JSONArray jSONArray) {
        this.bankBinJson = jSONArray;
    }

    public final void setBankCardId(@Nullable String str) {
        this.bankCardId = str;
    }

    public final void setBankData(@Nullable JSONObject jSONObject) {
        this.bankData = jSONObject;
    }

    public final void setBinLength(int i3) {
        this.binLength = i3;
    }

    public final void setBindCardPreObj(@Nullable JSONObject jSONObject) {
        this.bindCardPreObj = jSONObject;
    }

    public final void setCurrentBankData(@Nullable JSONObject jSONObject) {
        this.currentBankData = jSONObject;
    }

    public final void setCvvContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cvvContent = str;
    }

    public final void setMCardID(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mCardID = str;
    }

    public final void setMCardType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mCardType = str;
    }

    public final void setMTimestamp(long j3) {
        this.mTimestamp = j3;
    }

    public final void setMTrueName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mTrueName = str;
    }

    public final void setMUin(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mUin = str;
    }

    public final void setMUserAttr(int i3) {
        this.mUserAttr = i3;
    }

    public final void setPassFlagInt(int i3) {
        this.passFlagInt = i3;
    }

    public final void setPassword(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.password = str;
    }

    public final void setPhoneNum(@Nullable String str) {
        this.phoneNum = str;
    }

    public final void setQwalletData(@NotNull JSONObject data) {
        boolean z16;
        Intrinsics.checkNotNullParameter(data, "data");
        WalletGateData.getInstance().setData(com.tencent.mobileqq.base.a.c(), data, System.currentTimeMillis());
        String optString = data.optString("time_stamp");
        Intrinsics.checkNotNullExpressionValue(optString, "data.optString(\"time_stamp\")");
        this.mTimestamp = Long.parseLong(optString) - (System.currentTimeMillis() / 1000);
        String optString2 = data.optString("creditcard_id");
        Intrinsics.checkNotNullExpressionValue(optString2, "data.optString(\"creditcard_id\")");
        this.mCardID = optString2;
        String optString3 = data.optString("purchaser_true_name");
        Intrinsics.checkNotNullExpressionValue(optString3, "data.optString(\"purchaser_true_name\")");
        this.mTrueName = optString3;
        this.mUserAttr = data.optInt("user_attr");
        String creType = data.optString("creditcard_type");
        Intrinsics.checkNotNullExpressionValue(creType, "creType");
        if (creType.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mCardType = creType;
        }
    }

    public final void setThruContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.thruContent = str;
    }

    private final JSONObject findBankData(JSONObject bankInfo) {
        String optString = bankInfo.optString("sname");
        Intrinsics.checkNotNullExpressionValue(optString, "bankInfo.optString(\"sname\")");
        String upperCase = optString.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
        boolean z16 = bankInfo.optInt("type") == 2;
        if (z16) {
            Iterator<JSONObject> it = this.fastCreditBankList.iterator();
            while (it.hasNext()) {
                JSONObject next = it.next();
                if (Intrinsics.areEqual(next.optString("sname"), upperCase)) {
                    return next;
                }
            }
        } else {
            Iterator<JSONObject> it5 = this.fastDebitBankList.iterator();
            while (it5.hasNext()) {
                JSONObject next2 = it5.next();
                if (Intrinsics.areEqual(next2.optString("sname"), upperCase)) {
                    return next2;
                }
            }
        }
        Iterator<JSONObject> it6 = this.dataList.iterator();
        while (it6.hasNext()) {
            JSONObject next3 = it6.next();
            String optString2 = next3.optString("type");
            if ((Intrinsics.areEqual(NetParams.DEBIT_FAST, optString2) && !z16) || (Intrinsics.areEqual(NetParams.CREDIT_FAST, optString2) && z16)) {
                if (Intrinsics.areEqual(next3.optString("sname"), upperCase)) {
                    return next3;
                }
            }
        }
        return null;
    }
}
