package cooperation.qwallet.midas;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.report.ReportField;
import com.tencent.mobileqq.qwallet.report.beacon.IQWalletCommonReport;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u0005\u001fB%\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bB\u0011\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\t\u00a2\u0006\u0004\b\u001a\u0010\u001dJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcooperation/qwallet/midas/MidasPayResultReceiver;", "Landroid/os/ResultReceiver;", "Landroid/os/Bundle;", "resultData", "", "a", "", QzoneIPCModule.RESULT_CODE, "onReceiveResult", "Landroid/os/Parcel;", "out", WadlProxyConsts.FLAGS, "writeToParcel", "describeContents", "d", "Landroid/os/ResultReceiver;", "innerReceiver", "e", "Landroid/os/Bundle;", "requestBundle", "", "f", "Ljava/lang/String;", "TAG", "Landroid/os/Handler;", "handler", "<init>", "(Landroid/os/ResultReceiver;Landroid/os/Bundle;Landroid/os/Handler;)V", "parcel", "(Landroid/os/Parcel;)V", "CREATOR", "b", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class MidasPayResultReceiver extends ResultReceiver {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ResultReceiver innerReceiver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Bundle requestBundle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcooperation/qwallet/midas/MidasPayResultReceiver$a;", "Landroid/os/Parcelable$Creator;", "Lcooperation/qwallet/midas/MidasPayResultReceiver;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcooperation/qwallet/midas/MidasPayResultReceiver;", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: cooperation.qwallet.midas.MidasPayResultReceiver$a, reason: from kotlin metadata */
    /* loaded from: classes28.dex */
    public static final class Companion implements Parcelable.Creator<MidasPayResultReceiver> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MidasPayResultReceiver createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MidasPayResultReceiver(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MidasPayResultReceiver[] newArray(int size) {
            return new MidasPayResultReceiver[size];
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011R\u001c\u0010 \u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019\u00a8\u0006#"}, d2 = {"Lcooperation/qwallet/midas/MidasPayResultReceiver$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getInvokeId", "()I", "invokeId", "b", "Ljava/lang/String;", "getOfferId", "()Ljava/lang/String;", "offerId", "c", "getH5Url", "h5Url", "d", "Ljava/lang/Integer;", "getRetCode", "()Ljava/lang/Integer;", "retCode", "e", "getRetMsg", "retMsg", "f", "getRetInnerCode", "retInnerCode", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: cooperation.qwallet.midas.MidasPayResultReceiver$b, reason: from toString */
    /* loaded from: classes28.dex */
    public static final /* data */ class MidasPayResultReportInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "invoke_id")
        private final int invokeId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "offer_id")
        @Nullable
        private final String offerId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "h5_url")
        @Nullable
        private final String h5Url;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "ret_code")
        @Nullable
        private final Integer retCode;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "ret_msg")
        @Nullable
        private final String retMsg;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "inner_code")
        @Nullable
        private final Integer retInnerCode;

        public MidasPayResultReportInfo(int i3, @Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable Integer num2) {
            this.invokeId = i3;
            this.offerId = str;
            this.h5Url = str2;
            this.retCode = num;
            this.retMsg = str3;
            this.retInnerCode = num2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MidasPayResultReportInfo)) {
                return false;
            }
            MidasPayResultReportInfo midasPayResultReportInfo = (MidasPayResultReportInfo) other;
            if (this.invokeId == midasPayResultReportInfo.invokeId && Intrinsics.areEqual(this.offerId, midasPayResultReportInfo.offerId) && Intrinsics.areEqual(this.h5Url, midasPayResultReportInfo.h5Url) && Intrinsics.areEqual(this.retCode, midasPayResultReportInfo.retCode) && Intrinsics.areEqual(this.retMsg, midasPayResultReportInfo.retMsg) && Intrinsics.areEqual(this.retInnerCode, midasPayResultReportInfo.retInnerCode)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int i3 = this.invokeId * 31;
            String str = this.offerId;
            int i16 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i17 = (i3 + hashCode) * 31;
            String str2 = this.h5Url;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i18 = (i17 + hashCode2) * 31;
            Integer num = this.retCode;
            if (num == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = num.hashCode();
            }
            int i19 = (i18 + hashCode3) * 31;
            String str3 = this.retMsg;
            if (str3 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str3.hashCode();
            }
            int i26 = (i19 + hashCode4) * 31;
            Integer num2 = this.retInnerCode;
            if (num2 != null) {
                i16 = num2.hashCode();
            }
            return i26 + i16;
        }

        @NotNull
        public String toString() {
            return "MidasPayResultReportInfo(invokeId=" + this.invokeId + ", offerId=" + this.offerId + ", h5Url=" + this.h5Url + ", retCode=" + this.retCode + ", retMsg=" + this.retMsg + ", retInnerCode=" + this.retInnerCode + ')';
        }
    }

    public MidasPayResultReceiver(@Nullable ResultReceiver resultReceiver, @Nullable Bundle bundle, @Nullable Handler handler) {
        super(handler);
        this.innerReceiver = resultReceiver;
        this.requestBundle = bundle;
        this.TAG = "Midas_PayResultReceiverProxy";
    }

    private final void a(Bundle resultData) {
        Integer num;
        String str;
        Bundle bundle = this.requestBundle;
        String str2 = null;
        if (bundle != null) {
            num = Integer.valueOf(bundle.getInt(QWalletPayBridge.Key.PAY_INVOKER_ID));
        } else {
            num = null;
        }
        if (num != null && QWalletPayBridge.isMidasInvokerId(num.intValue()) && resultData != null) {
            String string = resultData.getString("result");
            if (string == null && (string = resultData.getString("retData")) == null) {
                string = "";
            }
            try {
                JSONObject jSONObject = new JSONObject(string);
                int optInt = jSONObject.optInt(QzoneIPCModule.RESULT_CODE);
                int optInt2 = jSONObject.optInt("retInnerCode");
                String optString = jSONObject.optString("resultMsg");
                if (optInt != 0) {
                    QLog.w(this.TAG, 1, "midas pay finish. retCode=" + optInt + " innerCode=" + optInt2 + " retMsg=" + optString + TokenParser.SP + this.requestBundle);
                }
                Bundle bundle2 = this.requestBundle;
                if (bundle2 != null) {
                    str = bundle2.getString("offerId");
                } else {
                    str = null;
                }
                Bundle bundle3 = this.requestBundle;
                if (bundle3 != null) {
                    str2 = bundle3.getString("payparmas_h5_url");
                }
                MidasPayResultReportInfo midasPayResultReportInfo = new MidasPayResultReportInfo(num.intValue(), str, str2, Integer.valueOf(optInt), optString, Integer.valueOf(optInt2));
                ((IQWalletCommonReport) QRoute.api(IQWalletCommonReport.class)).report("e_midas_result_monitor", midasPayResultReportInfo);
                QLog.i(this.TAG, 1, "report " + midasPayResultReportInfo);
                return;
            } catch (JSONException e16) {
                QLog.w(this.TAG, 1, "doReport fail, result format error: " + string, e16);
                return;
            }
        }
        QLog.w(this.TAG, 1, "doReport ignored: invokeId = " + num);
    }

    @Override // android.os.ResultReceiver, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
        super.onReceiveResult(resultCode, resultData);
        QLog.w(this.TAG, 1, "onReceiveResult: resultCode=" + resultCode + " innerReceiver=" + this.innerReceiver);
        ResultReceiver resultReceiver = this.innerReceiver;
        if (resultReceiver != null) {
            resultReceiver.send(resultCode, resultData);
        }
        a(resultData);
    }

    @Override // android.os.ResultReceiver, android.os.Parcelable
    public void writeToParcel(@Nullable Parcel out, int flags) {
        super.writeToParcel(out, flags);
        ResultReceiver resultReceiver = this.innerReceiver;
        if (resultReceiver != null) {
            resultReceiver.writeToParcel(out, flags);
        }
        Bundle bundle = this.requestBundle;
        if (bundle != null) {
            bundle.writeToParcel(out, flags);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MidasPayResultReceiver(@NotNull Parcel parcel) {
        this((ResultReceiver) parcel.readParcelable(ResultReceiver.class.getClassLoader()), parcel.readBundle(Bundle.class.getClassLoader()), new Handler(MobileQQ.sMobileQQ.getMainLooper()));
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
