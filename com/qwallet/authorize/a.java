package com.qwallet.authorize;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qwallet.pb.QWalletAuthorize$PhoneNo;
import com.tencent.mobileqq.qwallet.pb.QWalletAuthorize$RenewPhoneReq;
import com.tencent.mobileqq.qwallet.pb.QWalletAuthorize$RenewPhoneRsp;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.net.gateway.QWalletGatewayServlet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J.\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J>\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00070\u0006J>\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/qwallet/authorize/a;", "", "Lcom/qwallet/authorize/AuthorizePhoneData;", "phoneData", "Lcom/tencent/mobileqq/qwallet/pb/QWalletAuthorize$RenewPhoneReq;", "req", "Lkotlin/Function1;", "", "callback", "b", "", "appId", "", "sessionId", "gatewayToken", "remotePhoneData", "a", "verifyCode", "c", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f41406a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/qwallet/authorize/a$a", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/QWalletAuthorize$RenewPhoneRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qwallet.authorize.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0303a implements o<QWalletAuthorize$RenewPhoneRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AuthorizePhoneData f41407a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<AuthorizePhoneData, Unit> f41408b;

        /* JADX WARN: Multi-variable type inference failed */
        C0303a(AuthorizePhoneData authorizePhoneData, Function1<? super AuthorizePhoneData, Unit> function1) {
            this.f41407a = authorizePhoneData;
            this.f41408b = function1;
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull QWalletAuthorize$RenewPhoneRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            QWalletAuthorize$PhoneNo qWalletAuthorize$PhoneNo = rsp.phone.get();
            String str = qWalletAuthorize$PhoneNo.mask_no.get();
            Intrinsics.checkNotNullExpressionValue(str, "phoneNo.mask_no.get()");
            String str2 = qWalletAuthorize$PhoneNo.f278700no.get();
            Intrinsics.checkNotNullExpressionValue(str2, "phoneNo.no.get()");
            String str3 = qWalletAuthorize$PhoneNo.token.get();
            Intrinsics.checkNotNullExpressionValue(str3, "phoneNo.token.get()");
            int i3 = qWalletAuthorize$PhoneNo.source.get();
            String str4 = qWalletAuthorize$PhoneNo.source_tag.get();
            Intrinsics.checkNotNullExpressionValue(str4, "phoneNo.source_tag.get()");
            this.f41408b.invoke(new AuthorizePhoneData(str, str2, str3, i3, str4, qWalletAuthorize$PhoneNo.carrier_type.get(), qWalletAuthorize$PhoneNo.state.get(), this.f41407a.getHasSavePhone()));
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.d("AuthorizeService", 1, "requestAddPhone onFail errCode=" + errCode + " errMsg=" + errMsg);
            this.f41408b.invoke(null);
        }
    }

    a() {
    }

    private final void b(AuthorizePhoneData phoneData, QWalletAuthorize$RenewPhoneReq req, Function1<? super AuthorizePhoneData, Unit> callback) {
        C0303a c0303a = new C0303a(phoneData, callback);
        QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
        Object newInstance = QWalletAuthorize$RenewPhoneRsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        qWalletGatewayServlet.sendRequest("trpc.qwallet.phonesdk.PhoneSDK", "RenewPhone", req, (MessageMicro) newInstance, false, false, false, null, c0303a);
    }

    public final void a(long appId, @Nullable String sessionId, @NotNull String gatewayToken, @NotNull AuthorizePhoneData remotePhoneData, @NotNull Function1<? super AuthorizePhoneData, Unit> callback) {
        Intrinsics.checkNotNullParameter(gatewayToken, "gatewayToken");
        Intrinsics.checkNotNullParameter(remotePhoneData, "remotePhoneData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QWalletAuthorize$RenewPhoneReq qWalletAuthorize$RenewPhoneReq = new QWalletAuthorize$RenewPhoneReq();
        qWalletAuthorize$RenewPhoneReq.appid.set(appId);
        if (sessionId != null) {
            qWalletAuthorize$RenewPhoneReq.msg_no.set(sessionId);
        }
        qWalletAuthorize$RenewPhoneReq.check_type.set(2);
        qWalletAuthorize$RenewPhoneReq.qpay_token.set(remotePhoneData.getToken());
        qWalletAuthorize$RenewPhoneReq.mobile_gateway_tokens.set(gatewayToken);
        b(remotePhoneData, qWalletAuthorize$RenewPhoneReq, callback);
    }

    public final void c(long appId, @Nullable String sessionId, @NotNull String verifyCode, @NotNull AuthorizePhoneData remotePhoneData, @NotNull Function1<? super AuthorizePhoneData, Unit> callback) {
        Intrinsics.checkNotNullParameter(verifyCode, "verifyCode");
        Intrinsics.checkNotNullParameter(remotePhoneData, "remotePhoneData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QWalletAuthorize$RenewPhoneReq qWalletAuthorize$RenewPhoneReq = new QWalletAuthorize$RenewPhoneReq();
        qWalletAuthorize$RenewPhoneReq.appid.set(appId);
        if (sessionId != null) {
            qWalletAuthorize$RenewPhoneReq.msg_no.set(sessionId);
        }
        qWalletAuthorize$RenewPhoneReq.check_type.set(1);
        qWalletAuthorize$RenewPhoneReq.qpay_token.set(remotePhoneData.getToken());
        qWalletAuthorize$RenewPhoneReq.verify_code.set(verifyCode);
        b(remotePhoneData, qWalletAuthorize$RenewPhoneReq, callback);
    }
}
