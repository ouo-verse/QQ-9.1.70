package com.tenpay.fingerpay;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.soter.core.SoterCore;
import com.tencent.soter.core.model.SoterPubKeyModel;
import com.tencent.soter.core.model.SoterSignatureResult;
import com.tencent.soter.wrapper.SoterWrapperApi;
import com.tenpay.api.QFuncProxy;
import com.tenpay.fingerpay.soter.SoterInitCallback;
import com.tenpay.fingerpay.soter.SoterManager;
import com.tenpay.fingerpay.soter.SoterManagerCallback;
import com.tenpay.fingerpay.soter.SoterPrepareCallback;
import com.tenpay.fingerpay.type.PayTypeInfo;
import com.tenpay.sdk.FingerNet.GetSupportSoterNet;
import com.tenpay.sdk.helper.SharedHelper;
import com.tenpay.sdk.util.QWSoterConstans;
import com.tenpay.sdk.util.WalletGateData;
import com.tenpay.util.MD5;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 L2\u00020\u0001:\u0001LB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010,\u001a\u00020-J\b\u0010.\u001a\u0004\u0018\u00010/J*\u00100\u001a\u001e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)01j\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)`22\u0006\u00103\u001a\u00020)J*\u00104\u001a\u001e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)01j\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)`22\u0006\u00105\u001a\u00020)J\"\u00106\u001a\u001e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)01j\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)`2J\u0006\u00107\u001a\u00020-J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020\u001a09H\u0002J\u000e\u0010:\u001a\u00020-2\u0006\u0010;\u001a\u00020<J\u000e\u0010=\u001a\u00020-2\u0006\u0010>\u001a\u00020?J\u0006\u0010@\u001a\u00020-J\u000e\u0010A\u001a\u00020-2\u0006\u0010;\u001a\u00020BJ\u0006\u0010C\u001a\u00020-J\u000e\u0010D\u001a\u00020-2\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020-J\u0006\u0010H\u001a\u00020-J\u0018\u0010I\u001a\u00020-2\u0006\u0010J\u001a\u00020\n2\u0006\u0010K\u001a\u00020\u0004H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010(\u001a\u00020)8F\u00a2\u0006\u0006\u001a\u0004\b*\u0010+\u00a8\u0006M"}, d2 = {"Lcom/tenpay/fingerpay/FingerPaySettingViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "hasBindBank", "", "getHasBindBank", "()Z", "setHasBindBank", "(Z)V", "intentBusiType", "", "getIntentBusiType", "()I", "setIntentBusiType", "(I)V", "isClearAuthKeyByNotBindBank", "setClearAuthKeyByNotBindBank", "passFlag", "getPassFlag", "()Ljava/lang/Integer;", "setPassFlag", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "payTypeLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tenpay/fingerpay/type/PayTypeInfo;", "getPayTypeLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setPayTypeLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "soterManager", "Lcom/tenpay/fingerpay/soter/SoterManager;", "timestamp", "", "getTimestamp", "()Ljava/lang/Long;", "setTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "uin", "", "getUin", "()Ljava/lang/String;", "closeSoterPay", "", "getAuthKeyModel", "Lcom/tencent/soter/core/model/SoterPubKeyModel;", "getOpenRequestData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "passWd", "getPreOpenRequestData", "deviceID", "getWalletGateRequestData", "initFingerPaySetting", "initPayTypeList", "", "initSoter", "callback", "Lcom/tenpay/fingerpay/soter/SoterInitCallback;", "loadWalletGateData", "data", "Lorg/json/JSONObject;", "openSoterPay", "prepareAuthKeyAtSubThread", "Lcom/tenpay/fingerpay/soter/SoterPrepareCallback;", "releaseFp", "requestSoterAuthorize", "soterCallback", "Lcom/tenpay/fingerpay/soter/SoterManagerCallback;", "saveCloseSuccessResult", "saveOpenSuccessResult", "updatePayTypeList", "businessType", "isCloseBtn", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class FingerPaySettingViewModel extends ViewModel {
    public static final int ShiMing_RESULT_CODE = 1002;

    @NotNull
    public static final String TAG = "FingerPaySettingViewModel";
    private boolean hasBindBank;
    private boolean isClearAuthKeyByNotBindBank;

    @Nullable
    private Integer passFlag;

    @Nullable
    private Long timestamp;

    @NotNull
    private SoterManager soterManager = new SoterManager();
    private int intentBusiType = -1;

    @NotNull
    private MutableLiveData<List<PayTypeInfo>> payTypeLiveData = new MutableLiveData<>(initPayTypeList());

    private final List<PayTypeInfo> initPayTypeList() {
        List<Integer> list = GetSupportSoterNet.sSupportResCache.supportTypes;
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            for (Integer supportType : list) {
                Intrinsics.checkNotNullExpressionValue(supportType, "supportType");
                linkedList.add(new PayTypeInfo(false, supportType.intValue(), false));
            }
        }
        if (!linkedList.isEmpty()) {
            linkedList.add(new PayTypeInfo(true, -1, true));
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void prepareAuthKeyAtSubThread$lambda$0(FingerPaySettingViewModel this$0, SoterPrepareCallback callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.soterManager.prepareAuthKey(callback);
    }

    private final void updatePayTypeList(int businessType, boolean isCloseBtn) {
        boolean z16;
        if (!QWSoterConstans.isValidBusiType(businessType) && !isCloseBtn) {
            return;
        }
        List<PayTypeInfo> initPayTypeList = initPayTypeList();
        for (PayTypeInfo payTypeInfo : initPayTypeList) {
            if (isCloseBtn) {
                z16 = payTypeInfo.getIsCloseBtn();
            } else if (payTypeInfo.getBusiType() == businessType) {
                z16 = true;
            } else {
                z16 = false;
            }
            payTypeInfo.setChosen(z16);
        }
        this.payTypeLiveData.postValue(initPayTypeList);
    }

    public final void closeSoterPay() {
        updatePayTypeList(-1, true);
    }

    @Nullable
    public final SoterPubKeyModel getAuthKeyModel() {
        return this.soterManager.getAuthKeyModel();
    }

    public final boolean getHasBindBank() {
        return this.hasBindBank;
    }

    public final int getIntentBusiType() {
        return this.intentBusiType;
    }

    @NotNull
    public final HashMap<String, String> getOpenRequestData(@NotNull String passWd) {
        Intrinsics.checkNotNullParameter(passWd, "passWd");
        HashMap<String, String> hashMap = new HashMap<>();
        Long l3 = this.timestamp;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(l3);
        hashMap.put("timestamp", sb5.toString());
        hashMap.put("p", passWd);
        SoterPubKeyModel authKeyModel = this.soterManager.getAuthKeyModel();
        SoterPubKeyModel aSKModel = this.soterManager.getASKModel();
        SoterSignatureResult fingerAuthenResult = this.soterManager.getFingerAuthenResult();
        if (SoterWrapperApi.isSupportSoter() && authKeyModel != null && fingerAuthenResult != null && aSKModel != null) {
            String generateRemoteCheckRequestParam = SoterCore.generateRemoteCheckRequestParam();
            Intrinsics.checkNotNullExpressionValue(generateRemoteCheckRequestParam, "generateRemoteCheckRequestParam()");
            hashMap.put("model_xml", generateRemoteCheckRequestParam);
            String rawJson = aSKModel.getRawJson();
            Intrinsics.checkNotNullExpressionValue(rawJson, "model.rawJson");
            hashMap.put("ask_json", rawJson);
            String signature = aSKModel.getSignature();
            Intrinsics.checkNotNullExpressionValue(signature, "model.signature");
            hashMap.put("ask_signature", signature);
            String rawJson2 = authKeyModel.getRawJson();
            Intrinsics.checkNotNullExpressionValue(rawJson2, "authKeyModel.rawJson");
            hashMap.put("authkey_json", rawJson2);
            String signature2 = authKeyModel.getSignature();
            Intrinsics.checkNotNullExpressionValue(signature2, "authKeyModel.signature");
            hashMap.put("authkey_signature", signature2);
            String jsonValue = fingerAuthenResult.getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "fingerAuthenResult.jsonValue");
            hashMap.put("soter_auth_json", jsonValue);
            String signature3 = fingerAuthenResult.getSignature();
            Intrinsics.checkNotNullExpressionValue(signature3, "fingerAuthenResult.signature");
            hashMap.put("soter_auth_signature", signature3);
            String hexdigest = MD5.hexdigest(QFuncProxy.getDeviceId(MobileQQ.sMobileQQ));
            Intrinsics.checkNotNullExpressionValue(hexdigest, "hexdigest(QFuncProxy.get\u2026ceId(MobileQQ.sMobileQQ))");
            hashMap.put("device_id", hexdigest);
            int i3 = this.intentBusiType;
            StringBuilder sb6 = new StringBuilder();
            sb6.append(i3);
            hashMap.put(QWSoterConstans.CGI_KEY_BUSI_TYPE, sb6.toString());
        }
        return hashMap;
    }

    @Nullable
    public final Integer getPassFlag() {
        return this.passFlag;
    }

    @NotNull
    public final MutableLiveData<List<PayTypeInfo>> getPayTypeLiveData() {
        return this.payTypeLiveData;
    }

    @NotNull
    public final HashMap<String, String> getPreOpenRequestData(@NotNull String deviceID) {
        Intrinsics.checkNotNullParameter(deviceID, "deviceID");
        HashMap<String, String> hashMap = new HashMap<>();
        Long l3 = this.timestamp;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(l3);
        hashMap.put("timestamp", sb5.toString());
        hashMap.put("uin", getUin());
        int i3 = this.intentBusiType;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(i3);
        hashMap.put(QWSoterConstans.CGI_KEY_BUSI_TYPE, sb6.toString());
        String hexdigest = MD5.hexdigest(deviceID);
        Intrinsics.checkNotNullExpressionValue(hexdigest, "hexdigest(deviceID)");
        hashMap.put("device_id", hexdigest);
        return hashMap;
    }

    @Nullable
    public final Long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public final String getUin() {
        return com.tencent.mobileqq.base.a.c();
    }

    @NotNull
    public final HashMap<String, String> getWalletGateRequestData() {
        HashMap<String, String> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("uin", getUin()), TuplesKt.to("is_touchid", "1"));
        return hashMapOf;
    }

    public final void initFingerPaySetting() {
        List list;
        if (SharedHelper.soterOpen(getUin())) {
            String[] fingersLocal = SharedHelper.fingersLocal(getUin());
            Intrinsics.checkNotNullExpressionValue(fingersLocal, "fingersLocal(uin)");
            list = CollectionsKt__CollectionsKt.listOf(Arrays.copyOf(fingersLocal, fingersLocal.length));
        } else {
            list = null;
        }
        if (SoterManager.INSTANCE.isSupportSoter() && list != null) {
            int curSoterBusiType = SharedHelper.getCurSoterBusiType(getUin());
            this.intentBusiType = curSoterBusiType;
            updatePayTypeList(curSoterBusiType, false);
        }
    }

    public final void initSoter(@NotNull SoterInitCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SoterManager soterManager = this.soterManager;
        String uin = getUin();
        MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
        Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
        soterManager.initSoter(uin, sMobileQQ, callback);
    }

    /* renamed from: isClearAuthKeyByNotBindBank, reason: from getter */
    public final boolean getIsClearAuthKeyByNotBindBank() {
        return this.isClearAuthKeyByNotBindBank;
    }

    public final void loadWalletGateData(@NotNull JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        String optString = data.optString("time_stamp");
        Intrinsics.checkNotNullExpressionValue(optString, "data.optString(\"time_stamp\")");
        this.timestamp = Long.valueOf(Long.parseLong(optString) - (System.currentTimeMillis() / 1000));
        this.passFlag = Integer.valueOf(data.optInt("pass_flag"));
        WalletGateData.getInstance().setData(getUin(), data, System.currentTimeMillis());
    }

    public final void openSoterPay() {
        updatePayTypeList(this.intentBusiType, false);
    }

    public final void prepareAuthKeyAtSubThread(@NotNull final SoterPrepareCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_SOTER_PREPARE_AUTH, true)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.fingerpay.q
                @Override // java.lang.Runnable
                public final void run() {
                    FingerPaySettingViewModel.prepareAuthKeyAtSubThread$lambda$0(FingerPaySettingViewModel.this, callback);
                }
            }, 16, null, false);
        } else {
            this.soterManager.prepareAuthKey(callback);
        }
    }

    public final void releaseFp() {
        this.soterManager.releaseFp();
    }

    public final void requestSoterAuthorize(@NotNull SoterManagerCallback soterCallback) {
        Intrinsics.checkNotNullParameter(soterCallback, "soterCallback");
        SoterManager soterManager = this.soterManager;
        MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
        Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
        soterManager.requestSoterAuthorize(sMobileQQ, this.intentBusiType, getUin(), soterCallback);
    }

    public final void saveCloseSuccessResult() {
        SharedHelper.closeFinger(getUin());
    }

    public final void saveOpenSuccessResult() {
        String str;
        String uin = getUin();
        SoterSignatureResult fingerAuthenResult = this.soterManager.getFingerAuthenResult();
        if (fingerAuthenResult != null) {
            str = fingerAuthenResult.getFid();
        } else {
            str = null;
        }
        SharedHelper.openFinger(uin, str, this.intentBusiType);
    }

    public final void setClearAuthKeyByNotBindBank(boolean z16) {
        this.isClearAuthKeyByNotBindBank = z16;
    }

    public final void setHasBindBank(boolean z16) {
        this.hasBindBank = z16;
    }

    public final void setIntentBusiType(int i3) {
        this.intentBusiType = i3;
    }

    public final void setPassFlag(@Nullable Integer num) {
        this.passFlag = num;
    }

    public final void setPayTypeLiveData(@NotNull MutableLiveData<List<PayTypeInfo>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.payTypeLiveData = mutableLiveData;
    }

    public final void setTimestamp(@Nullable Long l3) {
        this.timestamp = l3;
    }
}
