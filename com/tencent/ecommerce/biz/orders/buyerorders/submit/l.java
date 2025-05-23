package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/l;", "", "<init>", "()V", "a", "b", "c", "d", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/l$b;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/l$c;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/l$a;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/l$d;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class l {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/l$a;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/l;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "code", "b", "Ljava/lang/String;", "msg", "<init>", "(ILjava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.l$a, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class ErrorCommonEvent extends l {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final int code;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String msg;

        public int hashCode() {
            int i3 = this.code * 31;
            String str = this.msg;
            return i3 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "ErrorCommonEvent(code=" + this.code + ", msg=" + this.msg + ")";
        }

        public ErrorCommonEvent(int i3, String str) {
            super(null);
            this.code = i3;
            this.msg = str;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ErrorCommonEvent)) {
                return false;
            }
            ErrorCommonEvent errorCommonEvent = (ErrorCommonEvent) other;
            return this.code == errorCommonEvent.code && Intrinsics.areEqual(this.msg, errorCommonEvent.msg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/l$b;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/l;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "msg", "<init>", "(Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.l$b, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class ErrorToastWithMsgEvent extends l {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String msg;

        public int hashCode() {
            String str = this.msg;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "ErrorToastWithMsgEvent(msg=" + this.msg + ")";
        }

        public ErrorToastWithMsgEvent(String str) {
            super(null);
            this.msg = str;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ErrorToastWithMsgEvent) && Intrinsics.areEqual(this.msg, ((ErrorToastWithMsgEvent) other).msg);
            }
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0004\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/l$c;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/l;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "msgResId", "<init>", "(I)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.l$c, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class ErrorToastWithMsgResIdEvent extends l {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final int msgResId;

        /* renamed from: hashCode, reason: from getter */
        public int getMsgResId() {
            return this.msgResId;
        }

        public String toString() {
            return "ErrorToastWithMsgResIdEvent(msgResId=" + this.msgResId + ")";
        }

        public ErrorToastWithMsgResIdEvent(int i3) {
            super(null);
            this.msgResId = i3;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ErrorToastWithMsgResIdEvent) && this.msgResId == ((ErrorToastWithMsgResIdEvent) other).msgResId;
            }
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/l$d;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/l;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "b", "code", "c", "Ljava/lang/String;", "msg", "<init>", "(IILjava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.l$d, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class ErrorWithSpecificType extends l {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final int errorType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final int code;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final String msg;

        public int hashCode() {
            int i3 = ((this.errorType * 31) + this.code) * 31;
            String str = this.msg;
            return i3 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "ErrorWithSpecificType(errorType=" + this.errorType + ", code=" + this.code + ", msg=" + this.msg + ")";
        }

        public ErrorWithSpecificType(int i3, int i16, String str) {
            super(null);
            this.errorType = i3;
            this.code = i16;
            this.msg = str;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ErrorWithSpecificType)) {
                return false;
            }
            ErrorWithSpecificType errorWithSpecificType = (ErrorWithSpecificType) other;
            return this.errorType == errorWithSpecificType.errorType && this.code == errorWithSpecificType.code && Intrinsics.areEqual(this.msg, errorWithSpecificType.msg);
        }
    }

    l() {
    }

    public /* synthetic */ l(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
