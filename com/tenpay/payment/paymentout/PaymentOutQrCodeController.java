package com.tenpay.payment.paymentout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.browser.BrowserPlugin;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.widget.ActionSheet;
import com.tenpay.ErrorCode;
import com.tenpay.api.QFuncProxy;
import com.tenpay.api.TTSUtil;
import com.tenpay.bank.BindBankModule;
import com.tenpay.ndk.CertUtil;
import com.tenpay.payment.PaymentUtils;
import com.tenpay.payment.QWalletPaymentExtKt;
import com.tenpay.payment.QWalletWearPayBean;
import com.tenpay.payment.paymentout.PaymentOutPayTypeController;
import com.tenpay.proxy.ASProxy;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.realname.RealNameSource;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.activity.PassVerifyActivity;
import com.tenpay.sdk.activity.WearPaySettingActivity;
import com.tenpay.sdk.net.NetUtil;
import com.tenpay.sdk.util.QRCodeUtils;
import com.tenpay.sdk.util.QrcodePaySetting;
import com.tenpay.sdk.util.WalletGateData;
import com.tenpay.sdk.view.MyTextView;
import com.tenpay.util.Utils;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import sk2.WalletConstantsConfig;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 R2\u00020\u0001:\u0003RSTB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0012\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0018H\u0002J\u0006\u0010(\u001a\u00020&J\n\u0010)\u001a\u0004\u0018\u00010\u0018H\u0002J\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00180+J\b\u0010,\u001a\u00020\u0018H\u0002J\b\u0010-\u001a\u00020&H\u0002J\b\u0010.\u001a\u00020&H\u0002J\u000e\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020\u0012J\b\u00101\u001a\u00020&H\u0002J\u0010\u00102\u001a\u00020&2\u0006\u00100\u001a\u00020\u0012H\u0002J\b\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020&H\u0002J \u00106\u001a\u00020&2\u0006\u00107\u001a\u00020#2\u0006\u00108\u001a\u00020#2\b\u00109\u001a\u0004\u0018\u00010\u0014J\u0012\u0010:\u001a\u00020&2\b\u00109\u001a\u0004\u0018\u00010;H\u0002J\u0012\u0010<\u001a\u00020&2\b\u00109\u001a\u0004\u0018\u00010;H\u0002J\u001a\u0010=\u001a\u00020&2\b\u0010>\u001a\u0004\u0018\u00010\u00182\b\u00109\u001a\u0004\u0018\u00010;J\u0012\u0010?\u001a\u00020&2\b\u00109\u001a\u0004\u0018\u00010;H\u0002J\u0012\u0010@\u001a\u00020&2\b\u00109\u001a\u0004\u0018\u00010;H\u0002J\u001a\u0010A\u001a\u00020&2\u0006\u00108\u001a\u00020#2\b\u00109\u001a\u0004\u0018\u00010\u0014H\u0002J\u0006\u0010B\u001a\u00020&J\u0012\u0010C\u001a\u00020&2\b\u00109\u001a\u0004\u0018\u00010;H\u0002J\b\u0010D\u001a\u00020&H\u0016J\u0010\u0010E\u001a\u00020&2\u0006\u0010F\u001a\u000204H\u0002J\u0006\u0010G\u001a\u00020&J\u001a\u0010H\u001a\u00020&2\b\u0010>\u001a\u0004\u0018\u00010\u00182\b\u00109\u001a\u0004\u0018\u00010;J\u000e\u0010I\u001a\u00020&2\u0006\u0010J\u001a\u00020;J\u0006\u0010K\u001a\u00020&J\u0006\u0010L\u001a\u00020&J\u0006\u0010M\u001a\u00020&J\b\u0010N\u001a\u00020&H\u0002J\b\u0010O\u001a\u00020&H\u0002J\b\u0010P\u001a\u00020&H\u0002J\b\u0010Q\u001a\u00020&H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010$\u00a8\u0006U"}, d2 = {"Lcom/tenpay/payment/paymentout/PaymentOutQrCodeController;", "Lcom/tenpay/payment/paymentout/PaymentOutPayTypeController$IPayTypeChangeCallback;", "fragment", "Lcom/tenpay/payment/paymentout/PaymentOutFragment;", "callback", "Lcom/tenpay/payment/paymentout/PaymentOutQrCodeController$IQrCodeStateChangeCallback;", "fullScreenController", "Lcom/tenpay/payment/paymentout/PaymentOutFullScreenController;", "(Lcom/tenpay/payment/paymentout/PaymentOutFragment;Lcom/tenpay/payment/paymentout/PaymentOutQrCodeController$IQrCodeStateChangeCallback;Lcom/tenpay/payment/paymentout/PaymentOutFullScreenController;)V", "barCodeImgView", "Landroid/widget/ImageView;", "barCodeNum1", "Lcom/tenpay/sdk/view/MyTextView;", "barCodeNum2", "barCodeNum3", "barCodeNum4", "barCodeNum5", "barCodeNumContainer", "Landroid/view/View;", "idVerifyResult", "Landroid/content/Intent;", "mainContentRoot", "Landroid/view/ViewGroup;", "passFlag", "", "payTypeController", "Lcom/tenpay/payment/paymentout/PaymentOutPayTypeController;", "getPayTypeController", "()Lcom/tenpay/payment/paymentout/PaymentOutPayTypeController;", "qrCodeImgView", "qrCodePayBean", "Lcom/tenpay/payment/paymentout/PaymentOutQrCodeController$QrCodePayBean;", "refreshQrCodeTimer", "Ljava/util/Timer;", "userAttr", "", "Ljava/lang/Integer;", "applyOpenCodePay", "", "pwd", "closeQrPay", "createPayCode", "getSpecialErrorCode", "", "getTimeStamp", "gotoCheckPwd", "guideToIdVerify", "init", "view", "initQrCode", "initView", "isExistWearDev", "", "markPayCodeUsed", "onActivityResult", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "onApplyCodePayError", "Lorg/json/JSONObject;", "onApplyCodePaySuccess", "onBlError", BrowserPlugin.KEY_REQUEST_URL, "onGenCodePayError", "onGenCodePaySuccess", "onIdVerifySuccess", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onPayCodeCheckSuccess", "onPayTypeChange", "onQrCodeVisibleChange", "isQrCodeShow", "onResume", "onSuccess", "onWalletGateInited", "walletGateData", "openQrCode", "requestPayCodeGen", "showCodeView", "showMoreSheet", "startTimer", "stopQrcodePay", "stopTimer", "Companion", "IQrCodeStateChangeCallback", "QrCodePayBean", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PaymentOutQrCodeController implements PaymentOutPayTypeController.IPayTypeChangeCallback {

    @NotNull
    private static final String RET_CODE_PAY_APPLY_ERROR_130231006 = "130231006";

    @NotNull
    private static final String RET_CODE_PAY_APPLY_ERROR_130231030 = "130231030";

    @NotNull
    private static final String RET_CODE_PAY_APPLY_ERROR_130231031 = "130231031";

    @NotNull
    private static final String RET_CODE_PAY_APPLY_ERROR_130231032 = "130231032";

    @NotNull
    private static final String RET_CODE_PAY_APPLY_ERROR_131721031 = "131721031";
    private static final long TIMER_SCHEDULE_INTERVAL_MS = 60000;
    private ImageView barCodeImgView;
    private MyTextView barCodeNum1;
    private MyTextView barCodeNum2;
    private MyTextView barCodeNum3;
    private MyTextView barCodeNum4;
    private MyTextView barCodeNum5;
    private View barCodeNumContainer;

    @NotNull
    private final IQrCodeStateChangeCallback callback;

    @NotNull
    private final PaymentOutFragment fragment;

    @NotNull
    private final PaymentOutFullScreenController fullScreenController;

    @Nullable
    private Intent idVerifyResult;
    private ViewGroup mainContentRoot;

    @Nullable
    private String passFlag;

    @NotNull
    private final PaymentOutPayTypeController payTypeController;
    private ImageView qrCodeImgView;

    @NotNull
    private final QrCodePayBean qrCodePayBean;

    @Nullable
    private Timer refreshQrCodeTimer;

    @Nullable
    private Integer userAttr;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tenpay/payment/paymentout/PaymentOutQrCodeController$IQrCodeStateChangeCallback;", "", "onStateChange", "", "isQrCodeShow", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public interface IQrCodeStateChangeCallback {
        void onStateChange(boolean isQrCodeShow);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\tH\u00c6\u0003J\t\u0010'\u001a\u00020\u000bH\u00c6\u0003JO\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020\u000bH\u00d6\u0001J\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u000bJ\t\u00100\u001a\u00020\u0003H\u00d6\u0001J\u000e\u00101\u001a\u00020-2\u0006\u00102\u001a\u00020\u0003R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014\u00a8\u00063"}, d2 = {"Lcom/tenpay/payment/paymentout/PaymentOutQrCodeController$QrCodePayBean;", "", "cid", "", "tokenMd5", "payTypes", "qrPayType", "qrCodePrefix", "bindCardFlag", "", "payTypeIndex", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V", "getBindCardFlag", "()Z", "setBindCardFlag", "(Z)V", "getCid", "()Ljava/lang/String;", "setCid", "(Ljava/lang/String;)V", "getPayTypeIndex", "()I", "setPayTypeIndex", "(I)V", "getPayTypes", "setPayTypes", "getQrCodePrefix", "setQrCodePrefix", "getQrPayType", "setQrPayType", "getTokenMd5", "setTokenMd5", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "loadQrPayConstant", "", "saveQrPayConstant", "forbidWatch", "toString", "updateQrPayCid", "newCid", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class QrCodePayBean {
        private boolean bindCardFlag;

        @NotNull
        private String cid;
        private int payTypeIndex;

        @NotNull
        private String payTypes;

        @NotNull
        private String qrCodePrefix;

        @NotNull
        private String qrPayType;

        @NotNull
        private String tokenMd5;

        public QrCodePayBean() {
            this(null, null, null, null, null, false, 0, 127, null);
        }

        public static /* synthetic */ QrCodePayBean copy$default(QrCodePayBean qrCodePayBean, String str, String str2, String str3, String str4, String str5, boolean z16, int i3, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                str = qrCodePayBean.cid;
            }
            if ((i16 & 2) != 0) {
                str2 = qrCodePayBean.tokenMd5;
            }
            String str6 = str2;
            if ((i16 & 4) != 0) {
                str3 = qrCodePayBean.payTypes;
            }
            String str7 = str3;
            if ((i16 & 8) != 0) {
                str4 = qrCodePayBean.qrPayType;
            }
            String str8 = str4;
            if ((i16 & 16) != 0) {
                str5 = qrCodePayBean.qrCodePrefix;
            }
            String str9 = str5;
            if ((i16 & 32) != 0) {
                z16 = qrCodePayBean.bindCardFlag;
            }
            boolean z17 = z16;
            if ((i16 & 64) != 0) {
                i3 = qrCodePayBean.payTypeIndex;
            }
            return qrCodePayBean.copy(str, str6, str7, str8, str9, z17, i3);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getCid() {
            return this.cid;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getTokenMd5() {
            return this.tokenMd5;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getPayTypes() {
            return this.payTypes;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final String getQrPayType() {
            return this.qrPayType;
        }

        @NotNull
        /* renamed from: component5, reason: from getter */
        public final String getQrCodePrefix() {
            return this.qrCodePrefix;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getBindCardFlag() {
            return this.bindCardFlag;
        }

        /* renamed from: component7, reason: from getter */
        public final int getPayTypeIndex() {
            return this.payTypeIndex;
        }

        @NotNull
        public final QrCodePayBean copy(@NotNull String cid, @NotNull String tokenMd5, @NotNull String payTypes, @NotNull String qrPayType, @NotNull String qrCodePrefix, boolean bindCardFlag, int payTypeIndex) {
            Intrinsics.checkNotNullParameter(cid, "cid");
            Intrinsics.checkNotNullParameter(tokenMd5, "tokenMd5");
            Intrinsics.checkNotNullParameter(payTypes, "payTypes");
            Intrinsics.checkNotNullParameter(qrPayType, "qrPayType");
            Intrinsics.checkNotNullParameter(qrCodePrefix, "qrCodePrefix");
            return new QrCodePayBean(cid, tokenMd5, payTypes, qrPayType, qrCodePrefix, bindCardFlag, payTypeIndex);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QrCodePayBean)) {
                return false;
            }
            QrCodePayBean qrCodePayBean = (QrCodePayBean) other;
            if (Intrinsics.areEqual(this.cid, qrCodePayBean.cid) && Intrinsics.areEqual(this.tokenMd5, qrCodePayBean.tokenMd5) && Intrinsics.areEqual(this.payTypes, qrCodePayBean.payTypes) && Intrinsics.areEqual(this.qrPayType, qrCodePayBean.qrPayType) && Intrinsics.areEqual(this.qrCodePrefix, qrCodePayBean.qrCodePrefix) && this.bindCardFlag == qrCodePayBean.bindCardFlag && this.payTypeIndex == qrCodePayBean.payTypeIndex) {
                return true;
            }
            return false;
        }

        public final boolean getBindCardFlag() {
            return this.bindCardFlag;
        }

        @NotNull
        public final String getCid() {
            return this.cid;
        }

        public final int getPayTypeIndex() {
            return this.payTypeIndex;
        }

        @NotNull
        public final String getPayTypes() {
            return this.payTypes;
        }

        @NotNull
        public final String getQrCodePrefix() {
            return this.qrCodePrefix;
        }

        @NotNull
        public final String getQrPayType() {
            return this.qrPayType;
        }

        @NotNull
        public final String getTokenMd5() {
            return this.tokenMd5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((((((this.cid.hashCode() * 31) + this.tokenMd5.hashCode()) * 31) + this.payTypes.hashCode()) * 31) + this.qrPayType.hashCode()) * 31) + this.qrCodePrefix.hashCode()) * 31;
            boolean z16 = this.bindCardFlag;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((hashCode + i3) * 31) + this.payTypeIndex;
        }

        public final void loadQrPayConstant() {
            QrcodePaySetting.prepare(BaseApplication.context, com.tencent.mobileqq.base.a.c());
            String string = QrcodePaySetting.getString("qrcode_pay_cid", "");
            Intrinsics.checkNotNullExpressionValue(string, "getString(\"qrcode_pay_cid\", \"\")");
            this.cid = string;
            String string2 = QrcodePaySetting.getString("qrcode_pay_tokenmd5", "");
            Intrinsics.checkNotNullExpressionValue(string2, "getString(\"qrcode_pay_tokenmd5\", \"\")");
            this.tokenMd5 = string2;
            String string3 = QrcodePaySetting.getString("qrcode_pay_types", "");
            Intrinsics.checkNotNullExpressionValue(string3, "getString(\"qrcode_pay_types\", \"\")");
            this.payTypes = string3;
            String string4 = QrcodePaySetting.getString("qrcode_last_pay", "");
            Intrinsics.checkNotNullExpressionValue(string4, "getString(\"qrcode_last_pay\", \"\")");
            this.qrPayType = string4;
            String string5 = QrcodePaySetting.getString("qrcode_code_prefix", "50");
            Intrinsics.checkNotNullExpressionValue(string5, "getString(\"qrcode_code_prefix\", \"50\")");
            this.qrCodePrefix = string5;
            this.bindCardFlag = QrcodePaySetting.getBoolean("qrcode_bindcard_refresh", false);
        }

        public final void saveQrPayConstant(int forbidWatch) {
            QrcodePaySetting.prepare(BaseApplication.context, com.tencent.mobileqq.base.a.c());
            QrcodePaySetting.putBoolean("qrcode_bindcard_refresh", false);
            QrcodePaySetting.putString("qrcode_pay_tokenmd5", this.tokenMd5);
            QrcodePaySetting.putString("qrcode_pay_types", this.payTypes);
            QrcodePaySetting.putString("qrcode_code_prefix", this.qrCodePrefix);
            QrcodePaySetting.putInt("forbid_watch", forbidWatch);
            QrcodePaySetting.commit();
            QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "saveQrPayConstant, " + this.tokenMd5 + " " + this.payTypes);
        }

        public final void setBindCardFlag(boolean z16) {
            this.bindCardFlag = z16;
        }

        public final void setCid(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.cid = str;
        }

        public final void setPayTypeIndex(int i3) {
            this.payTypeIndex = i3;
        }

        public final void setPayTypes(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.payTypes = str;
        }

        public final void setQrCodePrefix(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.qrCodePrefix = str;
        }

        public final void setQrPayType(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.qrPayType = str;
        }

        public final void setTokenMd5(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.tokenMd5 = str;
        }

        @NotNull
        public String toString() {
            return "QrCodePayBean(cid=" + this.cid + ", tokenMd5=" + this.tokenMd5 + ", payTypes=" + this.payTypes + ", qrPayType=" + this.qrPayType + ", qrCodePrefix=" + this.qrCodePrefix + ", bindCardFlag=" + this.bindCardFlag + ", payTypeIndex=" + this.payTypeIndex + ")";
        }

        public final void updateQrPayCid(@NotNull String newCid) {
            Intrinsics.checkNotNullParameter(newCid, "newCid");
            this.cid = newCid;
            QrcodePaySetting.prepare(BaseApplication.context, com.tencent.mobileqq.base.a.c());
            QrcodePaySetting.putString("qrcode_pay_cid", newCid);
            QrcodePaySetting.commit();
            QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "updateQrPayCid, " + newCid);
        }

        public QrCodePayBean(@NotNull String cid, @NotNull String tokenMd5, @NotNull String payTypes, @NotNull String qrPayType, @NotNull String qrCodePrefix, boolean z16, int i3) {
            Intrinsics.checkNotNullParameter(cid, "cid");
            Intrinsics.checkNotNullParameter(tokenMd5, "tokenMd5");
            Intrinsics.checkNotNullParameter(payTypes, "payTypes");
            Intrinsics.checkNotNullParameter(qrPayType, "qrPayType");
            Intrinsics.checkNotNullParameter(qrCodePrefix, "qrCodePrefix");
            this.cid = cid;
            this.tokenMd5 = tokenMd5;
            this.payTypes = payTypes;
            this.qrPayType = qrPayType;
            this.qrCodePrefix = qrCodePrefix;
            this.bindCardFlag = z16;
            this.payTypeIndex = i3;
        }

        public /* synthetic */ QrCodePayBean(String str, String str2, String str3, String str4, String str5, boolean z16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? "" : str3, (i16 & 8) != 0 ? "" : str4, (i16 & 16) == 0 ? str5 : "", (i16 & 32) != 0 ? false : z16, (i16 & 64) != 0 ? -1 : i3);
        }
    }

    public PaymentOutQrCodeController(@NotNull PaymentOutFragment fragment, @NotNull IQrCodeStateChangeCallback callback, @NotNull PaymentOutFullScreenController fullScreenController) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(fullScreenController, "fullScreenController");
        this.fragment = fragment;
        this.callback = callback;
        this.fullScreenController = fullScreenController;
        QrCodePayBean qrCodePayBean = new QrCodePayBean(null, null, null, null, null, false, 0, 127, null);
        this.qrCodePayBean = qrCodePayBean;
        this.payTypeController = new PaymentOutPayTypeController(fragment, this, qrCodePayBean);
    }

    private final void applyOpenCodePay(String pwd) {
        if (pwd == null) {
            return;
        }
        PaymentUtils.INSTANCE.saveQrcodeLastPayType(null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("uin", com.tencent.mobileqq.base.a.c());
        linkedHashMap.put("p", pwd);
        String deviceId = QFuncProxy.getDeviceId(this.fragment.getContext());
        Intrinsics.checkNotNullExpressionValue(deviceId, "getDeviceId(fragment.context)");
        linkedHashMap.put("device_id", deviceId);
        String deviceType = NetUtil.getDeviceType(this.fragment.getContext());
        Intrinsics.checkNotNullExpressionValue(deviceType, "getDeviceType(fragment.context)");
        linkedHashMap.put("device_type", deviceType);
        String deviceName = NetUtil.getDeviceName(this.fragment.getContext());
        Intrinsics.checkNotNullExpressionValue(deviceName, "getDeviceName(fragment.context)");
        linkedHashMap.put("device_name", deviceName);
        linkedHashMap.put("app_version", "");
        linkedHashMap.put("guid", com.tencent.mobileqq.base.b.d());
        linkedHashMap.put("timestamp", getTimeStamp());
        String certApplyCSR = CertUtil.getInstance(this.fragment.getContext()).getCertApplyCSR(com.tencent.mobileqq.base.a.c());
        Intrinsics.checkNotNullExpressionValue(certApplyCSR, "getInstance(fragment.con\u2026ccountUtils.currentUin())");
        linkedHashMap.put("csr", certApplyCSR);
        linkedHashMap.put("csr_type", "1");
        this.fragment.httpRequest(Cgi.URI_CODE_PAY_APPLY, linkedHashMap);
    }

    private final String createPayCode() {
        try {
            String token = CertUtil.getInstance(this.fragment.getContext()).getToken(this.qrCodePayBean.getCid());
            if (token == null) {
                return null;
            }
            String valueOf = String.valueOf(Long.parseLong(token) + (this.qrCodePayBean.getPayTypeIndex() << 49));
            StringBuffer stringBuffer = new StringBuffer(this.qrCodePayBean.getQrCodePrefix());
            int length = 16 - valueOf.length();
            for (int i3 = 0; i3 < length; i3++) {
                stringBuffer.append(0);
            }
            stringBuffer.append(valueOf);
            return stringBuffer.toString();
        } catch (Exception e16) {
            QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "createPayCode error:", e16);
            return null;
        }
    }

    private final String getTimeStamp() {
        return String.valueOf((NetConnInfoCenter.getServerTimeMillis() - System.currentTimeMillis()) / 1000);
    }

    private final void gotoCheckPwd() {
        Intent intent = new Intent();
        intent.putExtra(PassVerifyActivity.KEY_IN_CUSTOM_TITLE, "");
        intent.putExtra(PassVerifyActivity.KEY_IN_NOT_VERIFY_MODE, true);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("nav_type", 1);
        Unit unit = Unit.INSTANCE;
        intent.putExtra("extra_data", jSONObject.toString());
        intent.putExtra("pass_flag", this.passFlag);
        intent.putExtra("user_attr", this.userAttr);
        this.fragment.launchFragmentForResult(intent, PassVerifyActivity.class, 1001);
    }

    private final void guideToIdVerify() {
        QUIProxy.createCustomDialog(this.fragment.getContext(), 230, null, this.fragment.getString(R.string.f2180962s), this.fragment.getString(R.string.e2i), this.fragment.getString(R.string.f2180862r), new DialogInterface.OnClickListener() { // from class: com.tenpay.payment.paymentout.ab
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                PaymentOutQrCodeController.guideToIdVerify$lambda$16(PaymentOutQrCodeController.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tenpay.payment.paymentout.ac
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                PaymentOutQrCodeController.guideToIdVerify$lambda$17(dialogInterface, i3);
            }
        });
        com.tencent.mobileqq.qwallet.c.f("paycode.non-card.show", null, null, null, null, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void guideToIdVerify$lambda$16(PaymentOutQrCodeController this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.qwallet.c.f("paycode.non-card.addcard", null, null, null, null, 30, null);
        Intent intent = new Intent();
        intent.putExtra("IsShiMing", true);
        intent.putExtra("from_qrcodepay", true);
        intent.putExtra(RealNameSource.EXTRA_KEY_SOURCE, new RealNameSource("2"));
        BindBankModule.INSTANCE.startWithSwitchForResult(this$0.fragment, intent, 1002, 8);
    }

    private final void initQrCode() {
        if (!PaymentUtils.INSTANCE.isQrCodeOpen()) {
            onQrCodeVisibleChange(false);
            return;
        }
        onQrCodeVisibleChange(true);
        this.payTypeController.initPayBank();
        ViewGroup viewGroup = this.mainContentRoot;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContentRoot");
            viewGroup = null;
        }
        viewGroup.post(new Runnable() { // from class: com.tenpay.payment.paymentout.z
            @Override // java.lang.Runnable
            public final void run() {
                PaymentOutQrCodeController.initQrCode$lambda$10(PaymentOutQrCodeController.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initQrCode$lambda$10(PaymentOutQrCodeController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showCodeView();
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.f2334066);
        ViewGroup viewGroup = (ViewGroup) findViewById;
        viewGroup.setVisibility(8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<ViewGr\u2026ity = View.GONE\n        }");
        this.mainContentRoot = viewGroup;
        ol2.b.f(view.findViewById(R.id.f2336068), 20, false, 4, null);
        view.findViewById(R.id.f2335067).setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.paymentout.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PaymentOutQrCodeController.initView$lambda$3$lambda$2(PaymentOutQrCodeController.this, view2);
            }
        });
        ol2.b.f(view.findViewById(R.id.f233806_), 0, false, 6, null);
        View findViewById2 = view.findViewById(R.id.f232605y);
        final ImageView imageView = (ImageView) findViewById2;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.paymentout.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PaymentOutQrCodeController.initView$lambda$7$lambda$6(imageView, this, view2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById<ImageV\u2026)\n            }\n        }");
        this.barCodeImgView = imageView;
        View findViewById3 = view.findViewById(R.id.f2332064);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.p\u2026_out_bar_code_num_layout)");
        this.barCodeNumContainer = findViewById3;
        View findViewById4 = view.findViewById(R.id.f232705z);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.payment_out_bar_code_num_1)");
        this.barCodeNum1 = (MyTextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.f2328060);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.payment_out_bar_code_num_2)");
        this.barCodeNum2 = (MyTextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.f2329061);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.payment_out_bar_code_num_3)");
        this.barCodeNum3 = (MyTextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.f2330062);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.payment_out_bar_code_num_4)");
        this.barCodeNum4 = (MyTextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.f2331063);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.payment_out_bar_code_num_5)");
        this.barCodeNum5 = (MyTextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.f2337069);
        ImageView imageView2 = (ImageView) findViewById9;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.paymentout.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PaymentOutQrCodeController.initView$lambda$9$lambda$8(PaymentOutQrCodeController.this, view2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById<ImageV\u2026)\n            }\n        }");
        this.qrCodeImgView = imageView2;
        this.payTypeController.initView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$2(PaymentOutQrCodeController this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showMoreSheet();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7$lambda$6(ImageView imageView, final PaymentOutQrCodeController this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUIProxy.createCustomDialog(imageView.getContext(), 230, null, imageView.getResources().getString(R.string.f2181162u), null, imageView.getResources().getString(R.string.ead), new DialogInterface.OnClickListener() { // from class: com.tenpay.payment.paymentout.y
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                PaymentOutQrCodeController.initView$lambda$7$lambda$6$lambda$5(PaymentOutQrCodeController.this, dialogInterface, i3);
            }
        }, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7$lambda$6$lambda$5(PaymentOutQrCodeController this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.fullScreenController.showBarCodeFullScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9$lambda$8(PaymentOutQrCodeController this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.fullScreenController.showQrCodeFullScreen();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean isExistWearDev() {
        String str = null;
        QWalletWearPayBean qWalletWearPayBean = (QWalletWearPayBean) com.tencent.mobileqq.qwallet.utils.g.h("qwallet_pay_code_wear_pay_bean_" + com.tencent.mobileqq.base.a.c(), QWalletWearPayBean.class, null);
        if (qWalletWearPayBean != null) {
            str = qWalletWearPayBean.getAuth();
        }
        return !TextUtils.isEmpty(str);
    }

    private final void markPayCodeUsed() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("uin", com.tencent.mobileqq.base.a.c());
        linkedHashMap.put("device_id", QFuncProxy.getDeviceId(this.fragment.getContext()));
        linkedHashMap.put("device_type", NetUtil.getDeviceType(this.fragment.getContext()));
        linkedHashMap.put("device_name", NetUtil.getDeviceName(this.fragment.getContext()));
        linkedHashMap.put("timestamp", getTimeStamp());
        linkedHashMap.put("guid", com.tencent.mobileqq.base.b.d());
        linkedHashMap.put("token_md5", this.qrCodePayBean.getTokenMd5());
        linkedHashMap.put("reserve", String.valueOf(CertUtil.getInstance(this.fragment.getContext()).getTokenCount(this.qrCodePayBean.getCid())));
        this.fragment.httpRequest(Cgi.URI_CODE_PAY_CODE_MARK, linkedHashMap, false);
    }

    private final void onApplyCodePayError(JSONObject data) {
        String optString;
        if (data != null && (optString = data.optString("retcode")) != null) {
            int hashCode = optString.hashCode();
            if (hashCode != -1816614617) {
                if (hashCode != 1448626676) {
                    switch (hashCode) {
                        case 1448626763:
                            if (!optString.equals(RET_CODE_PAY_APPLY_ERROR_130231030)) {
                                return;
                            }
                            break;
                        case 1448626764:
                            if (!optString.equals(RET_CODE_PAY_APPLY_ERROR_130231031)) {
                                return;
                            }
                            break;
                        case 1448626765:
                            if (!optString.equals(RET_CODE_PAY_APPLY_ERROR_130231032)) {
                                return;
                            }
                            break;
                        default:
                            return;
                    }
                } else if (!optString.equals(RET_CODE_PAY_APPLY_ERROR_130231006)) {
                    return;
                }
            } else if (!optString.equals(RET_CODE_PAY_APPLY_ERROR_131721031)) {
                return;
            }
            QUIProxy.createCustomDialog(this.fragment.getContext(), 230, null, "\u4f60\u9700\u8981\u91cd\u65b0\u5f00\u901a\u4ed8\u6b3e\u7801", this.fragment.getString(R.string.e2i), this.fragment.getString(R.string.f21821634), new DialogInterface.OnClickListener() { // from class: com.tenpay.payment.paymentout.t
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    PaymentOutQrCodeController.onApplyCodePayError$lambda$20(PaymentOutQrCodeController.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tenpay.payment.paymentout.u
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    PaymentOutQrCodeController.onApplyCodePayError$lambda$21(PaymentOutQrCodeController.this, dialogInterface, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onApplyCodePayError$lambda$20(PaymentOutQrCodeController this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.qrCodePayBean.updateQrPayCid("");
        this$0.stopTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onApplyCodePayError$lambda$21(PaymentOutQrCodeController this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.qrCodePayBean.updateQrPayCid("");
        this$0.closeQrPay();
    }

    private final void onApplyCodePaySuccess(JSONObject data) {
        if (data == null) {
            return;
        }
        String optString = data.optString("cn");
        Intrinsics.checkNotNullExpressionValue(optString, "data.optString(\"cn\")");
        String optString2 = data.optString("crt");
        Intrinsics.checkNotNullExpressionValue(optString2, "data.optString(\"crt\")");
        if (!CertUtil.getInstance(this.fragment.getContext()).importCert(optString, optString2)) {
            return;
        }
        onQrCodeVisibleChange(true);
        this.qrCodePayBean.updateQrPayCid(optString);
        requestPayCodeGen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBlError$lambda$12(PaymentOutQrCodeController this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.closeQrPay();
    }

    private final void onGenCodePayError(JSONObject data) {
        String str;
        if (data != null) {
            str = data.optString("retcode");
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        if (Intrinsics.areEqual(str, "-1") || Intrinsics.areEqual(str, ErrorCode.ERR_NET)) {
            QUIProxy.createCustomDialog(this.fragment.getContext(), 230, null, this.fragment.getString(R.string.e_t), this.fragment.getString(R.string.e5j), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.payment.paymentout.x
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                }
            });
        }
        closeQrPay();
    }

    private final void onGenCodePaySuccess(JSONObject data) {
        if (data == null) {
            return;
        }
        this.qrCodePayBean.setBindCardFlag(false);
        QrCodePayBean qrCodePayBean = this.qrCodePayBean;
        String optString = data.optString("token_md5");
        Intrinsics.checkNotNullExpressionValue(optString, "data.optString(\"token_md5\")");
        qrCodePayBean.setTokenMd5(optString);
        QrCodePayBean qrCodePayBean2 = this.qrCodePayBean;
        String optString2 = data.optString("pay_desc");
        Intrinsics.checkNotNullExpressionValue(optString2, "data.optString(\"pay_desc\")");
        qrCodePayBean2.setPayTypes(optString2);
        QrCodePayBean qrCodePayBean3 = this.qrCodePayBean;
        String optString3 = data.optString("code_prefix");
        Intrinsics.checkNotNullExpressionValue(optString3, "data.optString(\"code_prefix\")");
        qrCodePayBean3.setQrCodePrefix(optString3);
        this.qrCodePayBean.saveQrPayConstant(data.optInt("forbid_watch"));
        CertUtil.getInstance(this.fragment.getContext()).setTokens(this.qrCodePayBean.getCid(), data.optString("token"));
        this.qrCodePayBean.setPayTypeIndex(-1);
        this.payTypeController.initPayBank();
        showCodeView();
    }

    private final void onIdVerifySuccess(int resultCode, Intent data) {
        String str;
        boolean z16;
        if (resultCode != -1) {
            return;
        }
        if (data != null) {
            str = data.getStringExtra(NotificationActivity.PASSWORD);
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (PaymentUtils.INSTANCE.isQrCodeOpen()) {
                requestPayCodeGen();
                return;
            } else {
                gotoCheckPwd();
                return;
            }
        }
        this.idVerifyResult = data;
        PaymentOutFragment paymentOutFragment = this.fragment;
        String str2 = Cgi.URL_WALLET_GATE;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("uin", com.tencent.mobileqq.base.a.c());
        Unit unit = Unit.INSTANCE;
        paymentOutFragment.httpRequest(str2, linkedHashMap);
    }

    private final void onPayCodeCheckSuccess(JSONObject data) {
        Integer num;
        Integer num2 = null;
        if (data != null) {
            num = Integer.valueOf(data.optInt("open_flag"));
        } else {
            num = null;
        }
        if (data != null) {
            num2 = Integer.valueOf(data.optInt("reason_type"));
        }
        if (num != null && num.intValue() == 0) {
            if ((num2 != null && num2.intValue() == 1) || ((num2 != null && num2.intValue() == 2) || (num2 != null && num2.intValue() == 3))) {
                guideToIdVerify();
                return;
            }
            return;
        }
        gotoCheckPwd();
    }

    private final void onQrCodeVisibleChange(boolean isQrCodeShow) {
        ViewGroup viewGroup = null;
        if (isQrCodeShow) {
            ViewGroup viewGroup2 = this.mainContentRoot;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainContentRoot");
            } else {
                viewGroup = viewGroup2;
            }
            viewGroup.setVisibility(0);
        } else {
            ViewGroup viewGroup3 = this.mainContentRoot;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainContentRoot");
            } else {
                viewGroup = viewGroup3;
            }
            viewGroup.setVisibility(8);
        }
        this.callback.onStateChange(isQrCodeShow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSuccess$lambda$11(PaymentOutQrCodeController this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.closeQrPay();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, android.app.Dialog] */
    private final void showMoreSheet() {
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (isExistWearDev()) {
            linkedHashMap.put("\u8bbe\u5907\u6388\u6743", 5);
        }
        final String payInstructionUrl = ((WalletConstantsConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_COMMON_CONSTANT, new WalletConstantsConfig(null, 1, null))).getContent().getPayInstructionUrl();
        if (!TextUtils.isEmpty(payInstructionUrl)) {
            linkedHashMap.put("\u4f7f\u7528\u8bf4\u660e", 0);
        }
        linkedHashMap.put("\u6682\u505c\u4f7f\u7528\u4ed8\u6b3e\u7801", 3);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? createActionSheet = ASProxy.createActionSheet(this.fragment.getContext(), this.fragment.getString(R.string.e5h), linkedHashMap, new ActionSheet.OnButtonClickListener() { // from class: com.tenpay.payment.paymentout.ad
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                PaymentOutQrCodeController.showMoreSheet$lambda$27(Ref.ObjectRef.this, linkedHashMap, this, payInstructionUrl, view, i3);
            }
        }, null);
        objectRef.element = createActionSheet;
        createActionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showMoreSheet$lambda$27(Ref.ObjectRef mDialog, LinkedHashMap buttonMaps, PaymentOutQrCodeController this$0, String instructionUrl, View view, int i3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(mDialog, "$mDialog");
        Intrinsics.checkNotNullParameter(buttonMaps, "$buttonMaps");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(instructionUrl, "$instructionUrl");
        Dialog dialog = (Dialog) mDialog.element;
        if (dialog != null) {
            dialog.dismiss();
        }
        int size = buttonMaps.size();
        if (i3 == size - 1) {
            this$0.stopQrcodePay();
            return;
        }
        if (i3 == size - 2) {
            if (instructionUrl.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                com.tencent.mobileqq.qwallet.utils.k.h(this$0.fragment.getContext(), instructionUrl);
                return;
            } else {
                this$0.fragment.launchFragment(new Intent(), WearPaySettingActivity.class);
                return;
            }
        }
        if (i3 == size - 3) {
            this$0.fragment.launchFragment(new Intent(), WearPaySettingActivity.class);
        }
    }

    private final void startTimer() {
        QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "startTimer");
        Timer timer = this.refreshQrCodeTimer;
        if (timer == null) {
            timer = new BaseTimer();
        }
        timer.schedule(new PaymentOutQrCodeController$startTimer$1(this), 60000L);
        this.refreshQrCodeTimer = timer;
    }

    private final void stopQrcodePay() {
        QUIProxy.createCustomDialog(this.fragment.getContext(), 230, null, "\u786e\u5b9a\u6682\u505c\u4f7f\u7528\u4ed8\u6b3e\u7801\uff1f", this.fragment.getString(R.string.e2i), this.fragment.getString(R.string.f2181262v), new DialogInterface.OnClickListener() { // from class: com.tenpay.payment.paymentout.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                PaymentOutQrCodeController.stopQrcodePay$lambda$28(PaymentOutQrCodeController.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tenpay.payment.paymentout.w
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                PaymentOutQrCodeController.stopQrcodePay$lambda$29(dialogInterface, i3);
            }
        });
        com.tencent.mobileqq.qwallet.c.f("paycode.showpaycode.stop", null, null, null, null, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stopQrcodePay$lambda$28(PaymentOutQrCodeController this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap hashMap = new HashMap();
        hashMap.put("uin", com.tencent.mobileqq.base.a.c());
        String deviceId = QFuncProxy.getDeviceId(this$0.fragment.getContext());
        Intrinsics.checkNotNullExpressionValue(deviceId, "getDeviceId(fragment.context)");
        hashMap.put("device_id", deviceId);
        String deviceType = NetUtil.getDeviceType(this$0.fragment.getContext());
        Intrinsics.checkNotNullExpressionValue(deviceType, "getDeviceType(fragment.context)");
        hashMap.put("device_type", deviceType);
        String deviceName = NetUtil.getDeviceName(this$0.fragment.getContext());
        Intrinsics.checkNotNullExpressionValue(deviceName, "getDeviceName(fragment.context)");
        hashMap.put("device_name", deviceName);
        hashMap.put("timestamp", this$0.getTimeStamp());
        hashMap.put("guid", com.tencent.mobileqq.base.b.d());
        hashMap.put("cn", this$0.qrCodePayBean.getCid());
        hashMap.put(QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, String.valueOf(new Random(System.currentTimeMillis()).nextInt()));
        this$0.fragment.httpRequest(Cgi.URI_CODE_PAY_CANCEL, hashMap);
    }

    private final void stopTimer() {
        QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "stopTimer");
        Timer timer = this.refreshQrCodeTimer;
        if (timer != null) {
            timer.cancel();
            timer.purge();
        }
        this.refreshQrCodeTimer = null;
    }

    public final void closeQrPay() {
        stopTimer();
        this.refreshQrCodeTimer = null;
        this.qrCodePayBean.updateQrPayCid("");
        onQrCodeVisibleChange(false);
    }

    @NotNull
    public final PaymentOutPayTypeController getPayTypeController() {
        return this.payTypeController;
    }

    @NotNull
    public final List<String> getSpecialErrorCode() {
        List<String> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(RET_CODE_PAY_APPLY_ERROR_130231030, RET_CODE_PAY_APPLY_ERROR_130231031, RET_CODE_PAY_APPLY_ERROR_130231006, RET_CODE_PAY_APPLY_ERROR_130231032, RET_CODE_PAY_APPLY_ERROR_131721031);
        return mutableListOf;
    }

    public final void init(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.qrCodePayBean.loadQrPayConstant();
        QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "load qrCodePayBean: " + this.qrCodePayBean);
        initView(view);
    }

    public final void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String stringExtra;
        if (requestCode != 1001) {
            if (requestCode == 1002) {
                onIdVerifySuccess(resultCode, data);
            }
        } else if (resultCode == -1 && data != null && (stringExtra = data.getStringExtra(PassVerifyActivity.KEY_OUT_ENTER_PWD)) != null) {
            applyOpenCodePay(stringExtra);
        }
    }

    public final void onBlError(@Nullable String requestUrl, @Nullable JSONObject data) {
        if (Intrinsics.areEqual(requestUrl, Cgi.URI_CODE_PAY_APPLY)) {
            onApplyCodePayError(data);
            return;
        }
        if (!Intrinsics.areEqual(requestUrl, Cgi.URI_CODE_PAY_CODE_MARK)) {
            if (Intrinsics.areEqual(requestUrl, Cgi.URI_CODE_PAY_CODE_GEN)) {
                onGenCodePayError(data);
            } else if (Intrinsics.areEqual(requestUrl, Cgi.URI_CODE_PAY_CANCEL)) {
                CertUtil.getInstance(this.fragment.getContext()).clearCert(this.qrCodePayBean.getCid());
                PaymentOutFragment paymentOutFragment = this.fragment;
                paymentOutFragment.showOkTips(paymentOutFragment.getString(R.string.f2181362w), new DialogInterface.OnDismissListener() { // from class: com.tenpay.payment.paymentout.aa
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        PaymentOutQrCodeController.onBlError$lambda$12(PaymentOutQrCodeController.this, dialogInterface);
                    }
                });
            }
        }
    }

    public final void onPause() {
        stopTimer();
    }

    @Override // com.tenpay.payment.paymentout.PaymentOutPayTypeController.IPayTypeChangeCallback
    public void onPayTypeChange() {
        if (CertUtil.getInstance(this.fragment.getContext()).getTokenCount(this.qrCodePayBean.getCid()) > 0) {
            showCodeView();
        } else {
            requestPayCodeGen();
        }
    }

    public final void onResume() {
        if (PaymentUtils.INSTANCE.isQrCodeOpen()) {
            startTimer();
        }
    }

    public final void onSuccess(@Nullable String requestUrl, @Nullable JSONObject data) {
        String str;
        boolean z16;
        if (Intrinsics.areEqual(requestUrl, Cgi.URI_CODE_PAY_CODE_CHECK)) {
            onPayCodeCheckSuccess(data);
            return;
        }
        if (Intrinsics.areEqual(requestUrl, Cgi.URI_CODE_PAY_APPLY)) {
            onApplyCodePaySuccess(data);
            return;
        }
        if (Intrinsics.areEqual(requestUrl, Cgi.URI_CODE_PAY_CODE_GEN)) {
            onGenCodePaySuccess(data);
            return;
        }
        if (Intrinsics.areEqual(requestUrl, Cgi.URI_CODE_PAY_CANCEL)) {
            CertUtil.getInstance(this.fragment.getContext()).clearCert(this.qrCodePayBean.getCid());
            PaymentOutFragment paymentOutFragment = this.fragment;
            paymentOutFragment.showOkTips(paymentOutFragment.getString(R.string.f2181362w), new DialogInterface.OnDismissListener() { // from class: com.tenpay.payment.paymentout.v
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    PaymentOutQrCodeController.onSuccess$lambda$11(PaymentOutQrCodeController.this, dialogInterface);
                }
            });
        } else if (Intrinsics.areEqual(requestUrl, Cgi.URL_WALLET_GATE)) {
            Intent intent = this.idVerifyResult;
            if (intent != null) {
                str = intent.getStringExtra(NotificationActivity.PASSWORD);
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                applyOpenCodePay(str);
                this.idVerifyResult = null;
            }
        }
    }

    public final void onWalletGateInited(@NotNull JSONObject walletGateData) {
        Intrinsics.checkNotNullParameter(walletGateData, "walletGateData");
        this.passFlag = walletGateData.optString("pass_flag");
        this.userAttr = Integer.valueOf(walletGateData.optInt("user_attr"));
        QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "initWalletGateData: " + this.passFlag + " " + this.userAttr);
        this.payTypeController.onWalletGateInited(walletGateData);
        initQrCode();
    }

    public final void openQrCode() {
        if (WalletGateData.getInstance().hasRealName()) {
            PaymentOutFragment paymentOutFragment = this.fragment;
            String str = Cgi.URI_CODE_PAY_CODE_CHECK;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("uin", com.tencent.mobileqq.base.a.c());
            Unit unit = Unit.INSTANCE;
            paymentOutFragment.httpRequest(str, linkedHashMap);
            return;
        }
        guideToIdVerify();
    }

    public final void requestPayCodeGen() {
        ImageView imageView = this.barCodeImgView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barCodeImgView");
            imageView = null;
        }
        imageView.setBackground(null);
        View view = this.barCodeNumContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barCodeNumContainer");
            view = null;
        }
        view.setVisibility(4);
        ImageView imageView2 = this.qrCodeImgView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qrCodeImgView");
            imageView2 = null;
        }
        imageView2.setBackground(null);
        stopTimer();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("uin", com.tencent.mobileqq.base.a.c());
        String deviceId = QFuncProxy.getDeviceId(this.fragment.getContext());
        Intrinsics.checkNotNullExpressionValue(deviceId, "getDeviceId(fragment.context)");
        linkedHashMap.put("device_id", deviceId);
        String deviceType = NetUtil.getDeviceType(this.fragment.getContext());
        Intrinsics.checkNotNullExpressionValue(deviceType, "getDeviceType(fragment.context)");
        linkedHashMap.put("device_type", deviceType);
        String deviceName = NetUtil.getDeviceName(this.fragment.getContext());
        Intrinsics.checkNotNullExpressionValue(deviceName, "getDeviceName(fragment.context)");
        linkedHashMap.put("device_name", deviceName);
        linkedHashMap.put("timestamp", getTimeStamp());
        linkedHashMap.put("guid", com.tencent.mobileqq.base.b.d());
        linkedHashMap.put("cn", this.qrCodePayBean.getCid());
        linkedHashMap.put("token_md5", this.qrCodePayBean.getTokenMd5());
        linkedHashMap.put(QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, String.valueOf(new Random(System.currentTimeMillis()).nextInt()));
        if (this.qrCodePayBean.getBindCardFlag()) {
            this.fragment.httpRequestNoLoading(Cgi.URI_CODE_PAY_CODE_GEN, linkedHashMap);
        } else {
            this.fragment.httpRequest(Cgi.URI_CODE_PAY_CODE_GEN, linkedHashMap);
        }
    }

    public final void showCodeView() {
        int i3;
        String str;
        if (this.fragment.isFinishing()) {
            return;
        }
        ImageView imageView = null;
        try {
            i3 = CertUtil.getInstance(this.fragment.getContext()).getTokenCount(this.qrCodePayBean.getCid());
            try {
                str = createPayCode();
            } catch (Exception e16) {
                e = e16;
                QLog.e(QWalletPaymentExtKt.getPaymentTag(this), 1, "showCodeView error:", e);
                str = null;
                QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "showCodeView: count=" + i3 + " code=" + str);
                if (i3 <= 0) {
                }
                CertUtil.getInstance(this.fragment.getContext()).clearToken(this.qrCodePayBean.getCid());
                requestPayCodeGen();
            }
        } catch (Exception e17) {
            e = e17;
            i3 = 0;
        }
        QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "showCodeView: count=" + i3 + " code=" + str);
        if (i3 <= 0 && str != null) {
            markPayCodeUsed();
            ImageView imageView2 = this.barCodeImgView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("barCodeImgView");
                imageView2 = null;
            }
            int width = imageView2.getWidth();
            ImageView imageView3 = this.barCodeImgView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("barCodeImgView");
                imageView3 = null;
            }
            Bitmap barCode = Utils.getBarCode(str, -16777216, width, imageView3.getHeight());
            if (barCode != null) {
                ImageView imageView4 = this.barCodeImgView;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("barCodeImgView");
                    imageView4 = null;
                }
                imageView4.setBackground(new BitmapDrawable(this.fragment.getResources(), barCode));
            }
            MyTextView myTextView = this.barCodeNum1;
            if (myTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("barCodeNum1");
                myTextView = null;
            }
            String substring = str.substring(0, 4);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            myTextView.setText((CharSequence) substring);
            MyTextView myTextView2 = this.barCodeNum2;
            if (myTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("barCodeNum2");
                myTextView2 = null;
            }
            String substring2 = str.substring(4, 8);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            myTextView2.setText((CharSequence) substring2);
            MyTextView myTextView3 = this.barCodeNum3;
            if (myTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("barCodeNum3");
                myTextView3 = null;
            }
            String substring3 = str.substring(8, 12);
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            myTextView3.setText((CharSequence) substring3);
            MyTextView myTextView4 = this.barCodeNum4;
            if (myTextView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("barCodeNum4");
                myTextView4 = null;
            }
            String substring4 = str.substring(12, 16);
            Intrinsics.checkNotNullExpressionValue(substring4, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            myTextView4.setText((CharSequence) substring4);
            MyTextView myTextView5 = this.barCodeNum5;
            if (myTextView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("barCodeNum5");
                myTextView5 = null;
            }
            String substring5 = str.substring(16, 18);
            Intrinsics.checkNotNullExpressionValue(substring5, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            myTextView5.setText((CharSequence) substring5);
            Bitmap roundBitmap = Utils.toRoundBitmap(BitmapFactory.decodeResource(this.fragment.getResources(), R.drawable.nwb), 0, 0);
            ImageView imageView5 = this.qrCodeImgView;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qrCodeImgView");
                imageView5 = null;
            }
            Bitmap qRCode = QRCodeUtils.getQRCode(str, roundBitmap, imageView5.getWidth(), -16777216, -1);
            if (qRCode != null) {
                ImageView imageView6 = this.qrCodeImgView;
                if (imageView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("qrCodeImgView");
                    imageView6 = null;
                }
                imageView6.setBackground(new BitmapDrawable(this.fragment.getResources(), qRCode));
            }
            this.fullScreenController.updateFullScreen();
            ImageView imageView7 = this.barCodeImgView;
            if (imageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("barCodeImgView");
            } else {
                imageView = imageView7;
            }
            TTSUtil.setViewContentDescription(imageView, "\u6761\u5f62\u7801");
            startTimer();
            return;
        }
        CertUtil.getInstance(this.fragment.getContext()).clearToken(this.qrCodePayBean.getCid());
        requestPayCodeGen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void guideToIdVerify$lambda$17(DialogInterface dialogInterface, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stopQrcodePay$lambda$29(DialogInterface dialogInterface, int i3) {
    }
}
