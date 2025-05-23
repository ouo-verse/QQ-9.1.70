package com.tencent.mobileqq.qwallet.kuikly;

import android.app.Activity;
import android.content.Context;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.net.gateway.QWalletGatewayBaseServlet;
import i01.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.a;
import pl2.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00112\u00020\u0001:\u0003\f\u0012\u0013B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002JI\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qwallet/kuikly/b;", "Li01/e;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "a", "method", "call", "<init>", "()V", "d", "b", "c", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b extends e {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qwallet/kuikly/b$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "service", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "method", "a", "requestBytesBase64", "c", "needEncrypt", "Z", "b", "()Z", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.kuikly.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class RequestBean {

        @SerializedName("method")
        @NotNull
        private final String method;

        @SerializedName("needEncrypt")
        private final boolean needEncrypt;

        @SerializedName(Const.BUNDLE_KEY_REQUEST)
        @NotNull
        private final String requestBytesBase64;

        @SerializedName("service")
        @NotNull
        private final String service;

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getMethod() {
            return this.method;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getNeedEncrypt() {
            return this.needEncrypt;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getRequestBytesBase64() {
            return this.requestBytesBase64;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getService() {
            return this.service;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RequestBean)) {
                return false;
            }
            RequestBean requestBean = (RequestBean) other;
            if (Intrinsics.areEqual(this.service, requestBean.service) && Intrinsics.areEqual(this.method, requestBean.method) && Intrinsics.areEqual(this.requestBytesBase64, requestBean.requestBytesBase64) && this.needEncrypt == requestBean.needEncrypt) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((this.service.hashCode() * 31) + this.method.hashCode()) * 31) + this.requestBytesBase64.hashCode()) * 31;
            boolean z16 = this.needEncrypt;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            return "RequestBean(service=" + this.service + ", method=" + this.method + ", requestBytesBase64=" + this.requestBytesBase64 + ", needEncrypt=" + this.needEncrypt + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qwallet/kuikly/b$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "retCode", "Ljava/lang/Integer;", "getRetCode", "()Ljava/lang/Integer;", "retMsg", "Ljava/lang/String;", "getRetMsg", "()Ljava/lang/String;", "responseBytesBase64", "getResponseBytesBase64", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.kuikly.b$c, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class ResponseBean {

        @SerializedName("response")
        @Nullable
        private final String responseBytesBase64;

        @SerializedName("ret_code")
        @Nullable
        private final Integer retCode;

        @SerializedName("ret_msg")
        @Nullable
        private final String retMsg;

        public ResponseBean() {
            this(null, null, null, 7, null);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResponseBean)) {
                return false;
            }
            ResponseBean responseBean = (ResponseBean) other;
            if (Intrinsics.areEqual(this.retCode, responseBean.retCode) && Intrinsics.areEqual(this.retMsg, responseBean.retMsg) && Intrinsics.areEqual(this.responseBytesBase64, responseBean.responseBytesBase64)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            Integer num = this.retCode;
            int i3 = 0;
            if (num == null) {
                hashCode = 0;
            } else {
                hashCode = num.hashCode();
            }
            int i16 = hashCode * 31;
            String str = this.retMsg;
            if (str == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str2 = this.responseBytesBase64;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "ResponseBean(retCode=" + this.retCode + ", retMsg=" + this.retMsg + ", responseBytesBase64=" + this.responseBytesBase64 + ")";
        }

        public ResponseBean(@Nullable Integer num, @Nullable String str, @Nullable String str2) {
            this.retCode = num;
            this.retMsg = str;
            this.responseBytesBase64 = str2;
        }

        public /* synthetic */ ResponseBean(Integer num, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qwallet/kuikly/b$d", "Lpl2/k;", "", "Lpl2/a;", "rsp", "", "c", "", "errCode", "", "errMsg", "onFail", "Landroid/app/Activity;", "getActivity", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d implements k<byte[]>, pl2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f278601a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f278602b;

        d(Function1<Object, Unit> function1, b bVar) {
            this.f278601a = function1;
            this.f278602b = bVar;
        }

        @Override // pl2.k
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull byte[] rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            ResponseBean responseBean = new ResponseBean(0, null, PluginBaseInfoHelper.Base64Helper.encodeToString(rsp, 2));
            QLog.i("QWalletGatewaySSOModule", 1, "onSuccess: " + responseBean);
            Function1<Object, Unit> function1 = this.f278601a;
            if (function1 != null) {
                function1.invoke(new GsonBuilder().create().toJson(responseBean));
            }
        }

        @Override // pl2.a
        @Nullable
        public Activity getActivity() {
            return this.f278602b.getActivity();
        }

        @Override // pl2.b
        @Nullable
        public Context getContext() {
            return a.C11026a.a(this);
        }

        @Override // pl2.b
        public boolean isAlive() {
            return a.C11026a.b(this);
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            ResponseBean responseBean = new ResponseBean(Integer.valueOf(errCode), errMsg, null, 4, null);
            QLog.i("QWalletGatewaySSOModule", 1, "onFail: " + errCode + " " + errMsg);
            Function1<Object, Unit> function1 = this.f278601a;
            if (function1 != null) {
                function1.invoke(new GsonBuilder().create().toJson(responseBean));
            }
        }
    }

    private final void a(String params, Function1<Object, Unit> callback) {
        RequestBean requestBean = (RequestBean) new GsonBuilder().create().fromJson(params, RequestBean.class);
        d dVar = new d(callback, this);
        QWalletGatewayBaseServlet qWalletGatewayBaseServlet = QWalletGatewayBaseServlet.INSTANCE;
        String service = requestBean.getService();
        String method = requestBean.getMethod();
        byte[] decode = PluginBaseInfoHelper.Base64Helper.decode(requestBean.getRequestBytesBase64(), 2);
        Intrinsics.checkNotNullExpressionValue(decode, "decode(requestBean.reque\u2026se64, Base64Util.NO_WRAP)");
        QWalletGatewayBaseServlet.sendRequest$default(qWalletGatewayBaseServlet, service, method, decode, requestBean.getNeedEncrypt(), false, false, null, dVar, 112, null);
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "sendGatewayRequest")) {
            a(params, callback);
            return Unit.INSTANCE;
        }
        QLog.w("QWalletGatewaySSOModule", 1, "unknown method: " + method);
        return super.call(method, params, callback);
    }
}
