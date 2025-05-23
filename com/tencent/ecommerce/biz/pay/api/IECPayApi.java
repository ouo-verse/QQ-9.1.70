package com.tencent.ecommerce.biz.pay.api;

import android.content.Context;
import androidx.annotation.UiThread;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H'J4\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/pay/api/IECPayApi;", "", "Landroid/content/Context;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "isReleaseEnv", "loggable", "", "init", "", "goodsTokenUrl", "", "from", "payTypeId", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$ECPayCallback;", "payCallBack", OpenConstants.ApiName.PAY, "ECPayCallback", "b", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECPayApi {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$ECPayCallback;", "", "", "onPayNeedLogin", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$b;", "payResult", "onPayResult", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public interface ECPayCallback {
        void onPayNeedLogin();

        void onPayResult(@NotNull PayResult payResult);
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ void a(IECPayApi iECPayApi, Context context, String str, int i3, int i16, ECPayCallback eCPayCallback, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 4) != 0) {
                    i3 = 0;
                }
                int i18 = i3;
                if ((i17 & 8) != 0) {
                    i16 = 2;
                }
                iECPayApi.pay(context, str, i18, i16, eCPayCallback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pay");
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\u000bR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0012\u001a\u0004\b\r\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "code", "b", "d", "payState", "c", "payChannel", "Ljava/lang/String;", "()Ljava/lang/String;", "msg", "<init>", "(IIILjava/lang/String;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.pay.api.IECPayApi$b, reason: from toString */
    /* loaded from: classes5.dex */
    public static final /* data */ class PayResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int code;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int payState;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int payChannel;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String msg;

        public PayResult(int i3, int i16, int i17, @NotNull String str) {
            this.code = i3;
            this.payState = i16;
            this.payChannel = i17;
            this.msg = str;
        }

        /* renamed from: a, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        /* renamed from: c, reason: from getter */
        public final int getPayChannel() {
            return this.payChannel;
        }

        /* renamed from: d, reason: from getter */
        public final int getPayState() {
            return this.payState;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof PayResult) {
                    PayResult payResult = (PayResult) other;
                    if (this.code != payResult.code || this.payState != payResult.payState || this.payChannel != payResult.payChannel || !Intrinsics.areEqual(this.msg, payResult.msg)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i3;
            int i16 = ((((this.code * 31) + this.payState) * 31) + this.payChannel) * 31;
            String str = this.msg;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "PayResult(code=" + this.code + ", payState=" + this.payState + ", payChannel=" + this.payChannel + ", msg=" + this.msg + ")";
        }
    }

    @UiThread
    void init(@NotNull Context activity, boolean isReleaseEnv, boolean loggable);

    void pay(@NotNull Context activity, @NotNull String goodsTokenUrl, int from, int payTypeId, @NotNull ECPayCallback payCallBack);
}
