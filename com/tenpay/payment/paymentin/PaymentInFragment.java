package com.tenpay.payment.paymentin;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.qwallet.utils.QWalletUtils;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.common.QWalletNickNameServer;
import com.tencent.mobileqq.search.model.ac;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QWalletAvatarLoader;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.browser.BrowserPlugin;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.widget.ActionSheet;
import com.tenpay.payment.PaymentUtils;
import com.tenpay.payment.QWalletPaymentExtKt;
import com.tenpay.proxy.ASProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.activity.NetBaseActivity;
import com.tenpay.sdk.activity.QrcodeSettingActivity;
import com.tenpay.sdk.util.ConfigUtil;
import com.tenpay.sdk.util.QRCodeUtils;
import com.tenpay.sdk.util.UIUtils;
import com.tenpay.util.Utils;
import cooperation.qzone.QzoneIPCModule;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import qk2.QrcodeConfig;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001RB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u0014\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010&\u001a\u00020!H\u0002J\b\u0010'\u001a\u00020!H\u0003J\u0010\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u0006H\u0002J\u0010\u0010*\u001a\u00020!2\u0006\u0010)\u001a\u00020\u0006H\u0002J\"\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020!H\u0002J\b\u00102\u001a\u00020!H\u0002J&\u00103\u001a\u0004\u0018\u00010\u00062\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020!H\u0016J\b\u0010;\u001a\u00020!H\u0016J\u0012\u0010<\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u00010=H\u0002J\b\u0010>\u001a\u00020!H\u0016J\u001a\u0010?\u001a\u00020!2\u0006\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u001c\u0010@\u001a\u00020!2\b\u0010A\u001a\u0004\u0018\u00010\b2\b\u0010/\u001a\u0004\u0018\u00010=H\u0016J\u001a\u0010B\u001a\u00020!2\u0006\u0010)\u001a\u00020\u00062\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010C\u001a\u00020!2\u0006\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020!H\u0002J\b\u0010G\u001a\u00020!H\u0002J\u0012\u0010H\u001a\u00020!2\b\u0010I\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010J\u001a\u00020!2\b\u0010K\u001a\u0004\u0018\u00010$H\u0002J&\u0010L\u001a\u00020!2\b\u0010M\u001a\u0004\u0018\u00010\b2\b\u0010N\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010O\u001a\u00020PH\u0002J\u0012\u0010Q\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006S"}, d2 = {"Lcom/tenpay/payment/paymentin/PaymentInFragment;", "Lcom/tenpay/sdk/activity/NetBaseActivity;", "()V", "avatarLoader", "Lcom/tencent/mobileqq/widget/QWalletAvatarLoader;", "contentRoot", "Landroid/view/View;", "customMoneyDesc", "", "customMoneyInt", "", "Ljava/lang/Float;", "editMoneyBtn", "Landroid/widget/TextView;", "errorTipsBtn", "Landroid/widget/Button;", "errorTipsContainer", "errorTipsSubTitle", "errorTipsTitle", "moneyDescView", "moneyView", "moneyViewContainer", "nickNameView", "pushController", "Lcom/tenpay/payment/paymentin/PaymentInPushController;", "qrCodeLogo", "Landroid/widget/ImageView;", "qrCodeView", "saveQrCodeBtn", "scanTipsView", "usageActionSheet", "Lcom/tencent/widget/ActionSheet;", "checkAndSaveQrCode", "", "codeTransGen", "generateQrcodeBitmap", "Landroid/graphics/drawable/BitmapDrawable;", "authCode", "initData", "initNickName", "initTitleBar", "view", "initView", "onActivityResult", "requestCode", "", QzoneIPCModule.RESULT_CODE, "data", "Landroid/content/Intent;", "onClickSaveQrCode", "onClickSetMoney", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onDestroyView", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onRequestCodeGenSuccess", "Lorg/json/JSONObject;", "onResume", "onSetMoneyCallback", "onSuccess", BrowserPlugin.KEY_REQUEST_URL, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "operateWindow", "window", "Landroid/view/Window;", "pullTransCodeScanHint", "refreshCustomMoney", "requestPayInCodeFromNet", "usage", "saveQrcodePayToPhone", "qrBitmap", "showErrorTips", "title", QQWinkConstants.TAB_SUBTITLE, "showBtn", "", "showQrCode", "CodeTransGenRsp", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PaymentInFragment extends NetBaseActivity {

    @NotNull
    private final QWalletAvatarLoader avatarLoader;
    private View contentRoot;

    @Nullable
    private String customMoneyDesc;

    @Nullable
    private Float customMoneyInt;
    private TextView editMoneyBtn;
    private Button errorTipsBtn;
    private View errorTipsContainer;
    private TextView errorTipsSubTitle;
    private TextView errorTipsTitle;
    private TextView moneyDescView;
    private TextView moneyView;
    private View moneyViewContainer;
    private TextView nickNameView;

    @NotNull
    private final PaymentInPushController pushController;
    private ImageView qrCodeLogo;
    private ImageView qrCodeView;
    private TextView saveQrCodeBtn;
    private TextView scanTipsView;

    @Nullable
    private ActionSheet usageActionSheet;

    @Keep
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u001c"}, d2 = {"Lcom/tenpay/payment/paymentin/PaymentInFragment$CodeTransGenRsp;", "", WadlProxyConsts.CHANNEL, "", "authCode", "expireTime", "", "reflushTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getAuthCode", "()Ljava/lang/String;", "getChannel", "getExpireTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getReflushTime", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lcom/tenpay/payment/paymentin/PaymentInFragment$CodeTransGenRsp;", "equals", "", "other", "hashCode", "", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class CodeTransGenRsp {

        @SerializedName("auth_code")
        @Nullable
        private final String authCode;

        @SerializedName(WadlProxyConsts.CHANNEL)
        @Nullable
        private final String channel;

        @SerializedName(VasQQSettingMeImpl.EXPIRE_TIME)
        @Nullable
        private final Long expireTime;

        @SerializedName("reflush_time")
        @Nullable
        private final Long reflushTime;

        public CodeTransGenRsp(@Nullable String str, @Nullable String str2, @Nullable Long l3, @Nullable Long l16) {
            this.channel = str;
            this.authCode = str2;
            this.expireTime = l3;
            this.reflushTime = l16;
        }

        public static /* synthetic */ CodeTransGenRsp copy$default(CodeTransGenRsp codeTransGenRsp, String str, String str2, Long l3, Long l16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = codeTransGenRsp.channel;
            }
            if ((i3 & 2) != 0) {
                str2 = codeTransGenRsp.authCode;
            }
            if ((i3 & 4) != 0) {
                l3 = codeTransGenRsp.expireTime;
            }
            if ((i3 & 8) != 0) {
                l16 = codeTransGenRsp.reflushTime;
            }
            return codeTransGenRsp.copy(str, str2, l3, l16);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final String getChannel() {
            return this.channel;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getAuthCode() {
            return this.authCode;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final Long getExpireTime() {
            return this.expireTime;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final Long getReflushTime() {
            return this.reflushTime;
        }

        @NotNull
        public final CodeTransGenRsp copy(@Nullable String channel, @Nullable String authCode, @Nullable Long expireTime, @Nullable Long reflushTime) {
            return new CodeTransGenRsp(channel, authCode, expireTime, reflushTime);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CodeTransGenRsp)) {
                return false;
            }
            CodeTransGenRsp codeTransGenRsp = (CodeTransGenRsp) other;
            if (Intrinsics.areEqual(this.channel, codeTransGenRsp.channel) && Intrinsics.areEqual(this.authCode, codeTransGenRsp.authCode) && Intrinsics.areEqual(this.expireTime, codeTransGenRsp.expireTime) && Intrinsics.areEqual(this.reflushTime, codeTransGenRsp.reflushTime)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final String getAuthCode() {
            return this.authCode;
        }

        @Nullable
        public final String getChannel() {
            return this.channel;
        }

        @Nullable
        public final Long getExpireTime() {
            return this.expireTime;
        }

        @Nullable
        public final Long getReflushTime() {
            return this.reflushTime;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            String str = this.channel;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.authCode;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            Long l3 = this.expireTime;
            if (l3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = l3.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            Long l16 = this.reflushTime;
            if (l16 != null) {
                i3 = l16.hashCode();
            }
            return i18 + i3;
        }

        @NotNull
        public String toString() {
            return "CodeTransGenRsp(channel=" + this.channel + ", authCode=" + this.authCode + ", expireTime=" + this.expireTime + ", reflushTime=" + this.reflushTime + ")";
        }
    }

    public PaymentInFragment() {
        QWalletAvatarLoader qWalletAvatarLoader = new QWalletAvatarLoader(this);
        this.avatarLoader = qWalletAvatarLoader;
        this.pushController = new PaymentInPushController(this, qWalletAvatarLoader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkAndSaveQrCode() {
        boolean z16;
        String readQRCodeConfig = ConfigUtil.readQRCodeConfig(this.mUin);
        QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "checkAndSaveQrCode " + readQRCodeConfig);
        if (!TextUtils.isEmpty(readQRCodeConfig)) {
            try {
                JSONObject jSONObject = new JSONObject(readQRCodeConfig);
                if (jSONObject.optInt("download_flag", 1) == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("usages");
                if (!z16) {
                    showErrorTips$default(this, getString(R.string.f21826639), getString(R.string.f21825638), false, 4, null);
                    return;
                }
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        String optString = optJSONArray.optJSONObject(i3).optString(String.valueOf(i3));
                        Intrinsics.checkNotNullExpressionValue(optString, "usage.optString(i.toString())");
                        linkedHashMap.put(optString, Boolean.FALSE);
                    }
                    Dialog createActionSheetWithCheck = ASProxy.createActionSheetWithCheck(getContext(), getString(R.string.e5h), getString(R.string.f2182763_), linkedHashMap, new ActionSheet.OnButtonClickListener() { // from class: com.tenpay.payment.paymentin.c
                        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                        public final void onClick(View view, int i16) {
                            PaymentInFragment.checkAndSaveQrCode$lambda$11(PaymentInFragment.this, view, i16);
                        }
                    }, null);
                    Intrinsics.checkNotNull(createActionSheetWithCheck, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
                    ActionSheet actionSheet = (ActionSheet) createActionSheetWithCheck;
                    this.usageActionSheet = actionSheet;
                    if (actionSheet != null) {
                        actionSheet.show();
                        return;
                    }
                    return;
                }
            } catch (Exception e16) {
                QLog.e(QWalletPaymentExtKt.getPaymentTag(this), 1, "", e16);
            }
        }
        saveQrcodePayToPhone(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkAndSaveQrCode$lambda$11(PaymentInFragment this$0, View view, int i3) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActionSheet actionSheet = this$0.usageActionSheet;
        if (actionSheet != null) {
            actionSheet.setRadioButtonChecked(i3);
        }
        ActionSheet actionSheet2 = this$0.usageActionSheet;
        if (actionSheet2 != null) {
            str = actionSheet2.getContent(i3);
        } else {
            str = null;
        }
        this$0.requestPayInCodeFromNet(str);
        ActionSheet actionSheet3 = this$0.usageActionSheet;
        if (actionSheet3 != null) {
            actionSheet3.dismiss();
        }
    }

    private final void codeTransGen() {
        boolean z16;
        long optLong;
        String optString;
        if (this.customMoneyInt != null) {
            requestPayInCodeFromNet(null);
            return;
        }
        String readQRCodeConfig = ConfigUtil.readQRCodeConfig(com.tencent.mobileqq.base.a.c());
        QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "codeTransGen strQrCode=" + readQRCodeConfig);
        if (readQRCodeConfig != null && readQRCodeConfig.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            requestPayInCodeFromNet(null);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(readQRCodeConfig);
            optLong = jSONObject.optLong(VasQQSettingMeImpl.EXPIRE_TIME);
            optString = jSONObject.optString("auth_code");
        } catch (Exception e16) {
            QLog.e(QWalletPaymentExtKt.getPaymentTag(this), 1, "qrcodeJSon error", e16);
        }
        if (System.currentTimeMillis() < optLong) {
            showQrCode(optString);
            return;
        }
        QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "codeTransGen expireTime: " + optLong);
        requestPayInCodeFromNet(null);
    }

    private final BitmapDrawable generateQrcodeBitmap(String authCode) {
        if (authCode == null) {
            return null;
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("a", "1");
            linkedHashMap.put("u", com.tencent.mobileqq.base.a.c());
            String encode = URLEncoder.encode(com.tencent.mobileqq.base.a.b());
            Intrinsics.checkNotNullExpressionValue(encode, "encode(QWalletAccountUtils.currentNickName())");
            linkedHashMap.put(DomainData.DOMAIN_NAME, encode);
            String encode2 = URLEncoder.encode(authCode);
            Intrinsics.checkNotNullExpressionValue(encode2, "encode(authCode)");
            linkedHashMap.put(ac.f283467k0, encode2);
            return new BitmapDrawable(QRCodeUtils.getQRCode(ConfigUtil.getQrcodeUrl(linkedHashMap), null, Utils.dp2Px(getContext(), 165.0f), -16777216, -1));
        } catch (Exception e16) {
            QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "generateQrcodeBitmap error", e16);
            return null;
        }
    }

    private final void initData() {
        initNickName();
        pullTransCodeScanHint();
        codeTransGen();
    }

    @SuppressLint({"SetTextI18n"})
    private final void initNickName() {
        TextView textView = this.nickNameView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nickNameView");
            textView = null;
        }
        textView.setText(com.tencent.mobileqq.base.a.b());
        QWalletNickNameServer.b(null, com.tencent.mobileqq.base.a.c(), new PaymentInFragment$initNickName$1(this));
    }

    private final void initTitleBar(View view) {
        TextView textView = (TextView) view.findViewById(R.id.ivTitleName);
        textView.setText(getString(R.string.f2180362m));
        textView.setTextColor(-1);
        TextView textView2 = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ap5, 0, 0, 0);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.paymentin.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PaymentInFragment.initTitleBar$lambda$2$lambda$1(PaymentInFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTitleBar$lambda$2$lambda$1(PaymentInFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.doOnBackPressed();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.f231105j);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.p\u2026ent_in_content_container)");
        this.contentRoot = findViewById;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentRoot");
            findViewById = null;
        }
        ol2.b.a(findViewById, 20, true);
        View view2 = this.contentRoot;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentRoot");
            view2 = null;
        }
        QWalletUtils.v(view2, 8.0f);
        View findViewById2 = view.findViewById(R.id.f231005i);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.payment_in_code_owner_nick)");
        this.nickNameView = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.fj7);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.pay_amount)");
        this.moneyView = (TextView) findViewById3;
        View view3 = this.contentRoot;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentRoot");
            view3 = null;
        }
        ol2.b.f(view3, 30, false, 4, null);
        View findViewById4 = view.findViewById(R.id.fje);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.pay_describe_text)");
        this.moneyDescView = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.f164309rr);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.amount_layout)");
        this.moneyViewContainer = findViewById5;
        View findViewById6 = view.findViewById(R.id.jv_);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.trans_qrimg)");
        this.qrCodeView = (ImageView) findViewById6;
        View findViewById7 = view.findViewById(R.id.f115576we);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.user_logo)");
        this.qrCodeLogo = (ImageView) findViewById7;
        View findViewById8 = view.findViewById(R.id.f166859ip4);
        TextView textView = (TextView) findViewById8;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.paymentin.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                PaymentInFragment.initView$lambda$4$lambda$3(PaymentInFragment.this, view4);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById<TextVi\u2026ickSetMoney() }\n        }");
        this.editMoneyBtn = textView;
        View findViewById9 = view.findViewById(R.id.ifw);
        TextView textView2 = (TextView) findViewById9;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.paymentin.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                PaymentInFragment.initView$lambda$6$lambda$5(PaymentInFragment.this, view4);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById<TextVi\u2026kSaveQrCode() }\n        }");
        this.saveQrCodeBtn = textView2;
        View findViewById10 = view.findViewById(R.id.igt);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.scan_pay_text)");
        this.scanTipsView = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.f231605o);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.payment_in_hint_container)");
        this.errorTipsContainer = findViewById11;
        View findViewById12 = view.findViewById(R.id.f231905r);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "view.findViewById(R.id.payment_in_hint_title)");
        this.errorTipsTitle = (TextView) findViewById12;
        View findViewById13 = view.findViewById(R.id.f231805q);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "view.findViewById(R.id.payment_in_hint_sub_title)");
        this.errorTipsSubTitle = (TextView) findViewById13;
        View findViewById14 = view.findViewById(R.id.f231505n);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "view.findViewById(R.id.payment_in_hint_button)");
        this.errorTipsBtn = (Button) findViewById14;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4$lambda$3(PaymentInFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onClickSetMoney();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6$lambda$5(PaymentInFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onClickSaveQrCode();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void onClickSaveQrCode() {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QWALLET, QQPermissionConstants.Business.SCENE.QWALLET_SAVE_PAY_CODE));
        Intrinsics.checkNotNullExpressionValue(qQPermission, "getQQPermission(this, config)");
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            checkAndSaveQrCode();
        } else {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new QQPermission.BasePermissionsListener() { // from class: com.tenpay.payment.paymentin.PaymentInFragment$onClickSaveQrCode$1
                @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                public void onAllGranted() {
                    super.onAllGranted();
                    PaymentInFragment.this.checkAndSaveQrCode();
                }
            });
        }
    }

    private final void onClickSetMoney() {
        if (this.customMoneyInt == null) {
            int qRTransQuota = ConfigUtil.getQRTransQuota(QrcodeSettingActivity.MAX_ACCOUNT_LIMIT_FEN);
            Intent intent = new Intent();
            intent.putExtra("amount", qRTransQuota);
            launchFragmentForResult(intent, QrcodeSettingActivity.class, QrcodeSettingActivity.REQUEST_CODE);
            return;
        }
        this.customMoneyInt = null;
        this.customMoneyDesc = null;
        codeTransGen();
        refreshCustomMoney();
    }

    private final void onRequestCodeGenSuccess(final JSONObject data) {
        if (data == null) {
            return;
        }
        try {
            Object fromJson = new GsonBuilder().create().fromJson(data.toString(), (Class<Object>) CodeTransGenRsp.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "GsonBuilder().create().f\u2026eTransGenRsp::class.java)");
            CodeTransGenRsp codeTransGenRsp = (CodeTransGenRsp) fromJson;
            if (Intrinsics.areEqual(codeTransGenRsp.getChannel(), "1")) {
                QLog.d(QWalletPaymentExtKt.getPaymentTag(this), 1, "qr_code_generate success and download qrcode");
                saveQrcodePayToPhone(generateQrcodeBitmap(codeTransGenRsp.getAuthCode()));
            } else {
                showQrCode(codeTransGenRsp.getAuthCode());
                if (this.customMoneyInt != null) {
                    return;
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.payment.paymentin.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        PaymentInFragment.onRequestCodeGenSuccess$lambda$8(JSONObject.this);
                    }
                }, 64, null, false);
            }
        } catch (Exception e16) {
            QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "parse CodeTransGenRsp fail", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRequestCodeGenSuccess$lambda$8(JSONObject jSONObject) {
        ConfigUtil.saveQRCodeConfig(jSONObject, com.tencent.mobileqq.base.a.c());
    }

    private final void onSetMoneyCallback(int resultCode, Intent data) {
        Float valueOf;
        if (data == null) {
            return;
        }
        String stringExtra = data.getStringExtra("amount");
        if (stringExtra != null) {
            try {
                valueOf = Float.valueOf(Float.parseFloat(stringExtra));
            } catch (NumberFormatException unused) {
                QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "onSetMoneyCallback fail: " + stringExtra);
            }
        } else {
            valueOf = null;
        }
        this.customMoneyInt = valueOf;
        this.customMoneyDesc = data.getStringExtra("desc");
        if (!data.getBooleanExtra("isCancel", true)) {
            codeTransGen();
            refreshCustomMoney();
        }
    }

    private final void pullTransCodeScanHint() {
        String str;
        TextView textView = null;
        QrcodeConfig qrcodeConfig = (QrcodeConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig("qwallet_qrcode_config", new QrcodeConfig(null, null, null, null, null, 31, null));
        String tips = qrcodeConfig.getTips();
        String wechatTips = qrcodeConfig.getWechatTips();
        Intent intent = getIntent();
        if (intent != null) {
            str = intent.getStringExtra("entry");
        } else {
            str = null;
        }
        boolean z16 = false;
        if (Intrinsics.areEqual(str, "4")) {
            if (wechatTips == null || wechatTips.length() == 0) {
                z16 = true;
            }
            if (z16) {
                tips = "\u6253\u5f00\u5fae\u4fe1\u626b\u4e00\u626b\uff0c\u5373\u53ef\u8f6c\u8d26\u81f3QQ";
            } else {
                tips = wechatTips;
            }
        } else {
            if (tips == null || tips.length() == 0) {
                z16 = true;
            }
            if (z16) {
                tips = "\u65e0\u9700\u52a0\u597d\u53cb\uff0c\u626b\u4e00\u626b\u5411\u6211\u4ed8\u94b1";
            }
        }
        TextView textView2 = this.scanTipsView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanTipsView");
        } else {
            textView = textView2;
        }
        textView.setText(tips);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [android.view.View] */
    private final void refreshCustomMoney() {
        TextView textView = null;
        if (this.customMoneyInt == null) {
            TextView textView2 = this.editMoneyBtn;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editMoneyBtn");
                textView2 = null;
            }
            textView2.setText(getString(R.string.f2180262l));
            ?? r06 = this.moneyViewContainer;
            if (r06 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("moneyViewContainer");
            } else {
                textView = r06;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView3 = this.editMoneyBtn;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editMoneyBtn");
            textView3 = null;
        }
        textView3.setText(getString(R.string.f2180462n));
        View view = this.moneyViewContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moneyViewContainer");
            view = null;
        }
        view.setVisibility(0);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        boolean z16 = true;
        String format = String.format("%.2f", Arrays.copyOf(new Object[]{this.customMoneyInt}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        StringBuffer stringBuffer = new StringBuffer(format);
        TextView textView4 = this.moneyView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moneyView");
            textView4 = null;
        }
        textView4.setText(stringBuffer);
        String str = this.customMoneyDesc;
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            TextView textView5 = this.moneyDescView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("moneyDescView");
            } else {
                textView = textView5;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView6 = this.moneyDescView;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moneyDescView");
            textView6 = null;
        }
        textView6.setVisibility(0);
        TextView textView7 = this.moneyDescView;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moneyDescView");
        } else {
            textView = textView7;
        }
        textView.setText(this.customMoneyDesc);
    }

    private final void requestPayInCodeFromNet(String usage) {
        boolean z16;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("uin", com.tencent.mobileqq.base.a.c());
        linkedHashMap.put("type", "1");
        Float f16 = this.customMoneyInt;
        if (f16 != null) {
            String yuan2Fen = Utils.yuan2Fen(String.valueOf(f16));
            Intrinsics.checkNotNullExpressionValue(yuan2Fen, "yuan2Fen(customMoneyInt.toString())");
            linkedHashMap.put("trans_fee", yuan2Fen);
        }
        String str = this.customMoneyDesc;
        boolean z17 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            linkedHashMap.put(QFSEdgeItem.KEY_EXTEND, "explain=" + this.customMoneyDesc);
        }
        if (usage == null || usage.length() == 0) {
            z17 = true;
        }
        if (!z17) {
            linkedHashMap.put("usage", usage);
            linkedHashMap.put(WadlProxyConsts.CHANNEL, "1");
        }
        httpRequest(Cgi.URI_CODE_TRANS_GEN, linkedHashMap);
    }

    private final void saveQrcodePayToPhone(BitmapDrawable qrBitmap) {
        QWalletAvatarLoader.FaceDrawable faceDrawable;
        Bitmap bitmap;
        ViewGroup viewGroup;
        BitmapDrawable bitmapDrawable;
        String str = null;
        if (qrBitmap == null) {
            ImageView imageView = this.qrCodeView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qrCodeView");
                imageView = null;
            }
            Drawable background = imageView.getBackground();
            if (background instanceof BitmapDrawable) {
                bitmapDrawable = (BitmapDrawable) background;
            } else {
                bitmapDrawable = null;
            }
            if (bitmapDrawable == null) {
                QQToast.makeText(getContext(), "\u8bf7\u7a0d\u5019...", 0).show();
                return;
            } else {
                Intrinsics.checkNotNullExpressionValue(background, "background");
                qrBitmap = (BitmapDrawable) background;
            }
        }
        ImageView imageView2 = this.qrCodeLogo;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qrCodeLogo");
            imageView2 = null;
        }
        Drawable drawable = imageView2.getDrawable();
        if (drawable instanceof QWalletAvatarLoader.FaceDrawable) {
            faceDrawable = (QWalletAvatarLoader.FaceDrawable) drawable;
        } else {
            faceDrawable = null;
        }
        if (faceDrawable != null) {
            bitmap = faceDrawable.getLoadedBitmap();
        } else {
            bitmap = null;
        }
        FragmentActivity outActivity = getOutActivity();
        LayoutInflater layoutInflater = getLayoutInflater();
        View view = getView();
        if (view instanceof ViewGroup) {
            viewGroup = (ViewGroup) view;
        } else {
            viewGroup = null;
        }
        Bitmap bitmap2 = qrBitmap.getBitmap();
        Float f16 = this.customMoneyInt;
        if (f16 != null) {
            str = f16.toString();
        }
        UIUtils.saveFace2FaceCode(outActivity, layoutInflater, viewGroup, bitmap2, bitmap, str, this.customMoneyDesc, this.mHandler);
    }

    private final void showErrorTips(String title, String subTitle, boolean showBtn) {
        View view = this.errorTipsContainer;
        Button button = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorTipsContainer");
            view = null;
        }
        view.setVisibility(0);
        TextView textView = this.errorTipsTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorTipsTitle");
            textView = null;
        }
        textView.setText(title);
        TextView textView2 = this.errorTipsSubTitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorTipsSubTitle");
            textView2 = null;
        }
        textView2.setText(subTitle);
        if (!showBtn) {
            Button button2 = this.errorTipsBtn;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorTipsBtn");
                button2 = null;
            }
            button2.setVisibility(0);
            Button button3 = this.errorTipsBtn;
            if (button3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorTipsBtn");
            } else {
                button = button3;
            }
            button.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.paymentin.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PaymentInFragment.showErrorTips$lambda$12(PaymentInFragment.this, view2);
                }
            });
            return;
        }
        Button button4 = this.errorTipsBtn;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorTipsBtn");
        } else {
            button = button4;
        }
        button.setVisibility(8);
    }

    static /* synthetic */ void showErrorTips$default(PaymentInFragment paymentInFragment, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        paymentInFragment.showErrorTips(str, str2, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showErrorTips$lambda$12(PaymentInFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view2 = this$0.errorTipsContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorTipsContainer");
            view2 = null;
        }
        view2.setVisibility(8);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void showQrCode(String authCode) {
        if (authCode == null) {
            QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "showQrCode fail, authCode is null");
            return;
        }
        ImageView imageView = this.qrCodeLogo;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qrCodeLogo");
            imageView = null;
        }
        Drawable drawable = ContextCompat.getDrawable(imageView.getContext(), R.drawable.dxx);
        ImageView imageView3 = this.qrCodeLogo;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qrCodeLogo");
            imageView3 = null;
        }
        imageView3.setImageDrawable(new QWalletAvatarLoader.FaceDrawable(com.tencent.mobileqq.base.a.c(), drawable, drawable, this.avatarLoader));
        BitmapDrawable generateQrcodeBitmap = generateQrcodeBitmap(authCode);
        if (generateQrcodeBitmap != null) {
            ImageView imageView4 = this.qrCodeView;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qrCodeView");
            } else {
                imageView2 = imageView4;
            }
            imageView2.setBackground(generateQrcodeBitmap);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "onActivityResult " + requestCode + " " + resultCode);
        if (requestCode == QrcodeSettingActivity.REQUEST_CODE) {
            onSetMoneyCallback(resultCode, data);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f168584fz0, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.pushController.onDestroyView();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        PaymentUtils.INSTANCE.setScreenBrightness(this, false);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        PaymentUtils.INSTANCE.setScreenBrightness(this, true);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(@Nullable String requestUrl, @Nullable JSONObject data) {
        super.onSuccess(requestUrl, data);
        if (!isFinishing() && Intrinsics.areEqual(requestUrl, Cgi.URI_CODE_TRANS_GEN)) {
            onRequestCodeGenSuccess(data);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initTitleBar(view);
        initView(view);
        initData();
        refreshCustomMoney();
        this.pushController.onViewCreated(view);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    public void operateWindow(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        super.operateWindow(window);
        window.addFlags(8192);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
