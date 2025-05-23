package com.tenpay.pay;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import androidx.fragment.app.Fragment;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.ErrorCode;
import com.tenpay.pay.friendpay.FriendPayProxyFragment;
import com.tenpay.pay.model.PayChannelBean;
import com.tenpay.sdk.activity.SuperFriendPayActivity;
import com.tenpay.sdk.apilogic.ApiUtil;
import com.tenpay.util.Utils;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003\f\r\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tenpay/pay/FriendPayController;", "", "()V", "callbackStrongRef", "Lcom/tenpay/pay/FriendPayController$IFriendPayCallback;", "startPay", "", "fragment", "Landroidx/fragment/app/Fragment;", "data", "Lcom/tenpay/pay/model/PayChannelBean$FriendPay;", "callback", "ChooseFriendReceiver", "FriendPayResult", "IFriendPayCallback", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class FriendPayController {

    @Nullable
    private IFriendPayCallback callbackStrongRef;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u001a\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00070\u00070\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00030\u00030\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tenpay/pay/FriendPayController$ChooseFriendReceiver;", "Landroid/os/ResultReceiver;", "fragment", "Landroidx/fragment/app/Fragment;", "data", "Lcom/tenpay/pay/model/PayChannelBean$FriendPay;", "callback", "Lcom/tenpay/pay/FriendPayController$IFriendPayCallback;", "(Landroidx/fragment/app/Fragment;Lcom/tenpay/pay/model/PayChannelBean$FriendPay;Lcom/tenpay/pay/FriendPayController$IFriendPayCallback;)V", "callbackRef", "Lmqq/util/WeakReference;", "kotlin.jvm.PlatformType", "getData", "()Lcom/tenpay/pay/model/PayChannelBean$FriendPay;", "fragmentRef", "callbackError", "", "onReceiveResult", QzoneIPCModule.RESULT_CODE, "", "resultData", "Landroid/os/Bundle;", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class ChooseFriendReceiver extends ResultReceiver {

        @NotNull
        private static final String TAG = "CFT-sdk-FriendPayController";

        @NotNull
        private final WeakReference<IFriendPayCallback> callbackRef;

        @NotNull
        private final PayChannelBean.FriendPay data;

        @NotNull
        private final WeakReference<Fragment> fragmentRef;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChooseFriendReceiver(@NotNull Fragment fragment, @NotNull PayChannelBean.FriendPay data, @NotNull IFriendPayCallback callback) {
            super(ThreadManagerV2.getUIHandlerV2());
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.data = data;
            this.fragmentRef = new WeakReference<>(fragment);
            this.callbackRef = new WeakReference<>(callback);
        }

        private final void callbackError(Fragment fragment, IFriendPayCallback callback) {
            if (callback == null) {
                QLog.w(TAG, 1, "callbackError, currentCallback is null");
            } else {
                callback.onPayFinish(new FriendPayResult(-1, fragment.getString(R.string.e_t)));
            }
        }

        @NotNull
        public final PayChannelBean.FriendPay getData() {
            return this.data;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0070 A[Catch: Exception -> 0x00ba, TryCatch #0 {Exception -> 0x00ba, blocks: (B:15:0x005a, B:17:0x0064, B:22:0x0070, B:24:0x0074), top: B:14:0x005a }] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0074 A[Catch: Exception -> 0x00ba, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ba, blocks: (B:15:0x005a, B:17:0x0064, B:22:0x0070, B:24:0x0074), top: B:14:0x005a }] */
        @Override // android.os.ResultReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
            Boolean bool;
            boolean z16;
            super.onReceiveResult(resultCode, resultData);
            QLog.i(TAG, 1, "onReceiveResult, resultCode=" + resultCode);
            Fragment fragment = this.fragmentRef.get();
            if (fragment != null && !fragment.isRemoving()) {
                IFriendPayCallback iFriendPayCallback = this.callbackRef.get();
                QLog.i(TAG, 1, "onReceiveResult currentCallback = " + iFriendPayCallback);
                if (resultCode != 0) {
                    if (resultCode != 1) {
                        if (resultCode == 2) {
                            if (resultData == null) {
                                callbackError(fragment, iFriendPayCallback);
                                return;
                            }
                            try {
                                ArrayList<String> stringArrayList = resultData.getStringArrayList("choose_friend_uins");
                                if (stringArrayList != null && !stringArrayList.isEmpty()) {
                                    z16 = false;
                                    if (!z16) {
                                        callbackError(fragment, iFriendPayCallback);
                                        return;
                                    }
                                    ResultReceiver resultReceiver = (ResultReceiver) resultData.getParcelable("callback");
                                    Intent intent = new Intent();
                                    intent.putExtra("pay_gate", this.data.getQpayGateString());
                                    intent.putExtra("process_flag", this.data.getProcessFlag());
                                    intent.putExtra("payer_uin", stringArrayList.get(0));
                                    intent.putExtra("choose_friend_callback", resultReceiver);
                                    com.tencent.mobileqq.base.c.f(fragment.getContext(), intent, SuperFriendPayActivity.class, false, 8, null);
                                    return;
                                }
                                z16 = true;
                                if (!z16) {
                                }
                            } catch (Exception e16) {
                                QLog.e(TAG, 1, "onReceiveResult:", e16);
                            }
                        }
                    } else {
                        FriendPayResult friendPayResult = new FriendPayResult(ErrorCode.ERR_FRIENDPAY_SUCCESS, fragment.getString(R.string.f171340e71));
                        if (iFriendPayCallback != null) {
                            iFriendPayCallback.onPayFinish(friendPayResult);
                        }
                    }
                } else if (resultData == null) {
                    callbackError(fragment, iFriendPayCallback);
                } else {
                    FriendPayProxyFragment.INSTANCE.start(this.data, resultData);
                }
            } else {
                if (fragment != null) {
                    bool = Boolean.valueOf(fragment.isRemoving());
                } else {
                    bool = null;
                }
                QLog.w(TAG, 1, "onReceiveResult but activity finish! isRemoving=" + bool);
            }
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\t\u0010\u000e\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0005H\u00d6\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u001a"}, d2 = {"Lcom/tenpay/pay/FriendPayController$FriendPayResult;", "Landroid/os/Parcelable;", "retCode", "", "retMsg", "", "(ILjava/lang/String;)V", "getRetCode", "()I", "getRetMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class FriendPayResult implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<FriendPayResult> CREATOR = new Creator();
        private final int retCode;

        @Nullable
        private final String retMsg;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Creator implements Parcelable.Creator<FriendPayResult> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final FriendPayResult createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new FriendPayResult(parcel.readInt(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final FriendPayResult[] newArray(int i3) {
                return new FriendPayResult[i3];
            }
        }

        public FriendPayResult(int i3, @Nullable String str) {
            this.retCode = i3;
            this.retMsg = str;
        }

        public static /* synthetic */ FriendPayResult copy$default(FriendPayResult friendPayResult, int i3, String str, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = friendPayResult.retCode;
            }
            if ((i16 & 2) != 0) {
                str = friendPayResult.retMsg;
            }
            return friendPayResult.copy(i3, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getRetCode() {
            return this.retCode;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getRetMsg() {
            return this.retMsg;
        }

        @NotNull
        public final FriendPayResult copy(int retCode, @Nullable String retMsg) {
            return new FriendPayResult(retCode, retMsg);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FriendPayResult)) {
                return false;
            }
            FriendPayResult friendPayResult = (FriendPayResult) other;
            if (this.retCode == friendPayResult.retCode && Intrinsics.areEqual(this.retMsg, friendPayResult.retMsg)) {
                return true;
            }
            return false;
        }

        public final int getRetCode() {
            return this.retCode;
        }

        @Nullable
        public final String getRetMsg() {
            return this.retMsg;
        }

        public int hashCode() {
            int hashCode;
            int i3 = this.retCode * 31;
            String str = this.retMsg;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return i3 + hashCode;
        }

        @NotNull
        public String toString() {
            return "FriendPayResult(retCode=" + this.retCode + ", retMsg=" + this.retMsg + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.retCode);
            parcel.writeString(this.retMsg);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tenpay/pay/FriendPayController$IFriendPayCallback;", "", "onPayFinish", "", "result", "Lcom/tenpay/pay/FriendPayController$FriendPayResult;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public interface IFriendPayCallback {
        void onPayFinish(@Nullable FriendPayResult result);
    }

    public final void startPay(@NotNull Fragment fragment, @NotNull PayChannelBean.FriendPay data, @NotNull IFriendPayCallback callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callbackStrongRef = callback;
        Integer allowMultiCounts = data.getAllowMultiCounts();
        Integer allowMultiFlag = data.getAllowMultiFlag();
        int i3 = 1;
        if (allowMultiFlag != null && allowMultiFlag.intValue() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            allowMultiCounts = null;
        }
        if (allowMultiCounts != null) {
            i3 = allowMultiCounts.intValue();
        }
        ApiUtil.chooseFriends(fragment.getActivity(), fragment.getResources().getString(R.string.e6r), Utils.transformToMoney(String.valueOf(data.getTotalFee()), 0), data.getDesc(), String.valueOf(data.getTotalFee()), data.getIPayFrom(), i3, new ChooseFriendReceiver(fragment, data, callback));
    }
}
