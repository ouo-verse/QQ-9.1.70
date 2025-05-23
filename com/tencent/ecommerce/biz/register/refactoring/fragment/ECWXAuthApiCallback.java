package com.tencent.ecommerce.biz.register.refactoring.fragment;

import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.service.IECNetworkCallback;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.base.wx.api.IECWXAuthApiCallback;
import com.tencent.ecommerce.biz.register.refactoring.utils.ECWxAuthSuccessEvent;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.apache.httpcore.message.TokenParser;
import vi0.a;
import vi0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0002\t\u0010B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0002J$\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/fragment/ECWXAuthApiCallback;", "Lcom/tencent/ecommerce/base/wx/api/IECWXAuthApiCallback;", "", "authCode", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Lvi0/b;", "Lvi0/a;", "callback", "", "a", "", "errorCode", "errorMsg", "onAuthorizationResult", "<init>", "()V", "ECWxNickNameCallback", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECWXAuthApiCallback implements IECWXAuthApiCallback {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \n2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/fragment/ECWXAuthApiCallback$ECWxNickNameCallback;", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Lvi0/b;", "Lvi0/a;", "reqModel", "rspModelData", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class ECWxNickNameCallback implements IECNetworkCallback<b, a> {
        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(b reqModel, final ECRemoteResponse errorResponse) {
            cg0.a.b("ECWxNickNameCallback", "[ECWxNickNameCallback] onError errorCode = " + errorResponse.getCode() + ", msg = " + errorResponse.getMsg());
            ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECWXAuthApiCallback$ECWxNickNameCallback$onError$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    LifecycleEventBus.f100688b.f(new ECWxAuthSuccessEvent(false, null, 2, null));
                    i.f(i.f101155b, "\u6388\u6743\u5931\u8d25 " + ECRemoteResponse.this + TokenParser.SP, null, 1, 2, null);
                }
            });
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(b reqModel, final a rspModelData) {
            cg0.a.b("ECWxNickNameCallback", "[ECWxNickNameCallback] onSuccess nickName = " + rspModelData.getNickName());
            ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECWXAuthApiCallback$ECWxNickNameCallback$onSuccess$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    LifecycleEventBus.f100688b.f(new ECWxAuthSuccessEvent(true, a.this.getNickName()));
                    if (a.this.getToast().optInt("state") != 0) {
                        i.f(i.f101155b, a.this.getToast().optString("msg", ""), null, 1, 2, null);
                    }
                }
            });
        }
    }

    @Override // com.tencent.ecommerce.base.wx.api.IECWXAuthApiCallback
    public void onAuthorizationResult(int errorCode, String errorMsg, String authCode) {
        cg0.a.b("ECWXAuthApiCallback", "[ECWXAuthApiCallback] errorCode " + errorCode + " auth code : " + authCode);
        if (errorCode == 0) {
            a(authCode, new ECWxNickNameCallback());
        } else {
            ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECWXAuthApiCallback$onAuthorizationResult$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    LifecycleEventBus.f100688b.f(new ECWxAuthSuccessEvent(false, null, 2, null));
                    i.f(i.f101155b, "\u83b7\u53d6\u5fae\u4fe1\u6388\u6743\u7801authCode\u5931\u8d25", null, 1, 2, null);
                }
            });
        }
    }

    private final void a(String authCode, IECNetworkCallback<b, a> callback) {
        if (authCode == null) {
            cg0.a.a("ECWXAuthApiCallback", "fetchUserNickname", "authCode is null");
        } else {
            com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.register_svr.RegisterSvr", "/trpc.ecom.register_svr.RegisterSvr/ModifyWechatInfo", new b(authCode), new a(), callback);
        }
    }
}
