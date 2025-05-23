package com.tenpay.payment.qrcodehb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.gson.annotations.SerializedName;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.payment.PaymentPushData;
import com.tenpay.payment.QWalletPaymentExtKt;
import com.tenpay.sdk.Cgi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\u001c\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00030\u00030\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tenpay/payment/qrcodehb/QrCodeHbPushController;", "Landroid/content/BroadcastReceiver;", "fragment", "Lcom/tenpay/payment/qrcodehb/QrCodeHbFragment;", "codeController", "Lcom/tenpay/payment/qrcodehb/QrCodeHbCodeController;", "(Lcom/tenpay/payment/qrcodehb/QrCodeHbFragment;Lcom/tenpay/payment/qrcodehb/QrCodeHbCodeController;)V", "fragmentRef", "Lmqq/util/WeakReference;", "kotlin.jvm.PlatformType", "onDestroyView", "", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Companion", "QrCodeHbPushExtend", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class QrCodeHbPushController extends BroadcastReceiver {

    @NotNull
    private static final String ACTION_GRAB_QR_HB = "1";

    @NotNull
    private static final String TYPE_GRAB_QR_HB = "hb_qr_grab";

    @NotNull
    private final QrCodeHbCodeController codeController;

    @NotNull
    private final WeakReference<QrCodeHbFragment> fragmentRef;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\t\u0010\u001c\u001a\u00020\u0005H\u00d6\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001d"}, d2 = {"Lcom/tenpay/payment/qrcodehb/QrCodeHbPushController$QrCodeHbPushExtend;", "", "totalNum", "", "receiveNumStr", "", "receiveUin", "sendListId", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getReceiveNumStr", "()Ljava/lang/String;", "getReceiveUin", "getSendListId", "getTotalNum", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/tenpay/payment/qrcodehb/QrCodeHbPushController$QrCodeHbPushExtend;", "equals", "", "other", "hashCode", "toQrCodeHbInfo", "Lcom/tenpay/payment/qrcodehb/QrCodeHbInfo;", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class QrCodeHbPushExtend {

        @SerializedName("recv_num")
        @Nullable
        private final String receiveNumStr;

        @SerializedName("recv_uin")
        @Nullable
        private final String receiveUin;

        @SerializedName("send_listid")
        @Nullable
        private final String sendListId;

        @SerializedName("total_num")
        @Nullable
        private final Integer totalNum;

        public QrCodeHbPushExtend(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.totalNum = num;
            this.receiveNumStr = str;
            this.receiveUin = str2;
            this.sendListId = str3;
        }

        public static /* synthetic */ QrCodeHbPushExtend copy$default(QrCodeHbPushExtend qrCodeHbPushExtend, Integer num, String str, String str2, String str3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                num = qrCodeHbPushExtend.totalNum;
            }
            if ((i3 & 2) != 0) {
                str = qrCodeHbPushExtend.receiveNumStr;
            }
            if ((i3 & 4) != 0) {
                str2 = qrCodeHbPushExtend.receiveUin;
            }
            if ((i3 & 8) != 0) {
                str3 = qrCodeHbPushExtend.sendListId;
            }
            return qrCodeHbPushExtend.copy(num, str, str2, str3);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final Integer getTotalNum() {
            return this.totalNum;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getReceiveNumStr() {
            return this.receiveNumStr;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final String getReceiveUin() {
            return this.receiveUin;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final String getSendListId() {
            return this.sendListId;
        }

        @NotNull
        public final QrCodeHbPushExtend copy(@Nullable Integer totalNum, @Nullable String receiveNumStr, @Nullable String receiveUin, @Nullable String sendListId) {
            return new QrCodeHbPushExtend(totalNum, receiveNumStr, receiveUin, sendListId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QrCodeHbPushExtend)) {
                return false;
            }
            QrCodeHbPushExtend qrCodeHbPushExtend = (QrCodeHbPushExtend) other;
            if (Intrinsics.areEqual(this.totalNum, qrCodeHbPushExtend.totalNum) && Intrinsics.areEqual(this.receiveNumStr, qrCodeHbPushExtend.receiveNumStr) && Intrinsics.areEqual(this.receiveUin, qrCodeHbPushExtend.receiveUin) && Intrinsics.areEqual(this.sendListId, qrCodeHbPushExtend.sendListId)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final String getReceiveNumStr() {
            return this.receiveNumStr;
        }

        @Nullable
        public final String getReceiveUin() {
            return this.receiveUin;
        }

        @Nullable
        public final String getSendListId() {
            return this.sendListId;
        }

        @Nullable
        public final Integer getTotalNum() {
            return this.totalNum;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            Integer num = this.totalNum;
            int i3 = 0;
            if (num == null) {
                hashCode = 0;
            } else {
                hashCode = num.hashCode();
            }
            int i16 = hashCode * 31;
            String str = this.receiveNumStr;
            if (str == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str2 = this.receiveUin;
            if (str2 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str2.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            String str3 = this.sendListId;
            if (str3 != null) {
                i3 = str3.hashCode();
            }
            return i18 + i3;
        }

        @NotNull
        public final QrCodeHbInfo toQrCodeHbInfo() {
            boolean z16;
            String str = this.receiveNumStr;
            int i3 = 0;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                i3 = Integer.parseInt(str);
            }
            return new QrCodeHbInfo(null, this.totalNum, Integer.valueOf(i3), null, this.sendListId);
        }

        @NotNull
        public String toString() {
            return "QrCodeHbPushExtend(totalNum=" + this.totalNum + ", receiveNumStr=" + this.receiveNumStr + ", receiveUin=" + this.receiveUin + ", sendListId=" + this.sendListId + ")";
        }
    }

    public QrCodeHbPushController(@NotNull QrCodeHbFragment fragment, @NotNull QrCodeHbCodeController codeController) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(codeController, "codeController");
        this.codeController = codeController;
        this.fragmentRef = new WeakReference<>(fragment);
    }

    public final void onDestroyView() {
        QrCodeHbFragment qrCodeHbFragment = this.fragmentRef.get();
        if (qrCodeHbFragment != null) {
            qrCodeHbFragment.unregisterReceiver(this);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        String stringExtra;
        PaymentPushData paymentPushData;
        if (intent != null && (stringExtra = intent.getStringExtra("extra_data")) != null) {
            QrCodeHbPushExtend qrCodeHbPushExtend = null;
            boolean z16 = true;
            try {
                paymentPushData = PaymentPushData.INSTANCE.fromJson(stringExtra, QrCodeHbPushExtend.class);
            } catch (Exception e16) {
                QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "paymentOutPushReceiver receive error", e16);
                paymentPushData = null;
            }
            QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "receive push: " + paymentPushData);
            if (paymentPushData != null) {
                qrCodeHbPushExtend = (QrCodeHbPushExtend) paymentPushData.getExtend();
            }
            if (paymentPushData != null && qrCodeHbPushExtend != null) {
                if (Intrinsics.areEqual(paymentPushData.getAction(), "1") && Intrinsics.areEqual(paymentPushData.getType(), TYPE_GRAB_QR_HB)) {
                    QrCodeHbInfo qrCodeHbInfo = qrCodeHbPushExtend.toQrCodeHbInfo();
                    String sendListId = qrCodeHbInfo.getSendListId();
                    if (sendListId != null && sendListId.length() != 0) {
                        z16 = false;
                    }
                    if (z16) {
                        return;
                    }
                    this.codeController.updateReceiveNum(qrCodeHbInfo.getSendListId(), qrCodeHbInfo.getReceiveNum());
                    return;
                }
                return;
            }
            QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "paymentOutPushReceiver error, paymentPushData invalid");
        }
    }

    public final void onViewCreated() {
        QrCodeHbFragment qrCodeHbFragment = this.fragmentRef.get();
        if (qrCodeHbFragment != null) {
            qrCodeHbFragment.registerReceiver(this, new IntentFilter(Cgi.BROADCAST_INTENT_ACTION_PUSH));
        }
    }
}
