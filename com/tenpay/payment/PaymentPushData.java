package com.tenpay.payment;

import com.google.gson.GsonBuilder;
import com.tencent.qmethod.pandoraex.monitor.AutoStartMonitor;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000  *\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001 B-\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00018\u0000H\u00c6\u0003\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003JD\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J!\u0010\u001b\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0001\u0010\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00010\u001d\u00a2\u0006\u0002\u0010\u001eJ\t\u0010\u001f\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n\u00a8\u0006!"}, d2 = {"Lcom/tenpay/payment/PaymentPushData;", "T", "", "extend", "extendRow", "", "action", "type", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getExtend", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getExtendRow", "getType", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/tenpay/payment/PaymentPushData;", "equals", "", "other", "hashCode", "", "parseExtend", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "toString", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class PaymentPushData<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_ACTION = "action";

    @NotNull
    private static final String KEY_EXTEND = "extend";

    @NotNull
    private static final String KEY_TYPE = "type";

    @Nullable
    private final String action;

    @Nullable
    private final T extend;

    @Nullable
    private final String extendRow;

    @Nullable
    private final String type;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J*\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\b\"\u0004\b\u0001\u0010\t2\u0006\u0010\n\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tenpay/payment/PaymentPushData$Companion;", "", "()V", AutoStartMonitor.AutoStartBean.KEY_ACTION, "", "KEY_EXTEND", "KEY_TYPE", "fromJson", "Lcom/tenpay/payment/PaymentPushData;", "T", "jsonData", "clazz", "Ljava/lang/Class;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final <T> PaymentPushData<T> fromJson(@NotNull String jsonData, @NotNull Class<T> clazz) {
            Intrinsics.checkNotNullParameter(jsonData, "jsonData");
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            try {
                JSONObject jSONObject = new JSONObject(jsonData);
                JSONObject optJSONObject = jSONObject.optJSONObject("extend");
                if (optJSONObject == null) {
                    return null;
                }
                return new PaymentPushData<>(new GsonBuilder().create().fromJson(optJSONObject.toString(), (Class) clazz), optJSONObject.toString(), jSONObject.optString("action"), optJSONObject.optString("type"));
            } catch (Exception e16) {
                QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "parse push error: " + jsonData, e16);
                return null;
            }
        }

        Companion() {
        }
    }

    public PaymentPushData(@Nullable T t16, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.extend = t16;
        this.extendRow = str;
        this.action = str2;
        this.type = str3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PaymentPushData copy$default(PaymentPushData paymentPushData, Object obj, String str, String str2, String str3, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            obj = paymentPushData.extend;
        }
        if ((i3 & 2) != 0) {
            str = paymentPushData.extendRow;
        }
        if ((i3 & 4) != 0) {
            str2 = paymentPushData.action;
        }
        if ((i3 & 8) != 0) {
            str3 = paymentPushData.type;
        }
        return paymentPushData.copy(obj, str, str2, str3);
    }

    @Nullable
    public final T component1() {
        return this.extend;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getExtendRow() {
        return this.extendRow;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final PaymentPushData<T> copy(@Nullable T extend, @Nullable String extendRow, @Nullable String action, @Nullable String type) {
        return new PaymentPushData<>(extend, extendRow, action, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentPushData)) {
            return false;
        }
        PaymentPushData paymentPushData = (PaymentPushData) other;
        if (Intrinsics.areEqual(this.extend, paymentPushData.extend) && Intrinsics.areEqual(this.extendRow, paymentPushData.extendRow) && Intrinsics.areEqual(this.action, paymentPushData.action) && Intrinsics.areEqual(this.type, paymentPushData.type)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getAction() {
        return this.action;
    }

    @Nullable
    public final T getExtend() {
        return this.extend;
    }

    @Nullable
    public final String getExtendRow() {
        return this.extendRow;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        T t16 = this.extend;
        int i3 = 0;
        if (t16 == null) {
            hashCode = 0;
        } else {
            hashCode = t16.hashCode();
        }
        int i16 = hashCode * 31;
        String str = this.extendRow;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str2 = this.action;
        if (str2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str2.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str3 = this.type;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return i18 + i3;
    }

    @Nullable
    public final <T> T parseExtend(@NotNull Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        try {
            return (T) new GsonBuilder().create().fromJson(String.valueOf(this.extendRow), (Class) clazz);
        } catch (Exception e16) {
            QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "parseExtend error: " + this.extendRow, e16);
            return null;
        }
    }

    @NotNull
    public String toString() {
        return "PaymentPushData(extend=" + this.extend + ", extendRow=" + this.extendRow + ", action=" + this.action + ", type=" + this.type + ")";
    }
}
