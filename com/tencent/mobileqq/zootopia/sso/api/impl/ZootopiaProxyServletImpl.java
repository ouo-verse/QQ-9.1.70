package com.tencent.mobileqq.zootopia.sso.api.impl;

import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zootopia.sso.ZootopiaBusinessHandler;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.mobileqq.zootopia.sso.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J^\u0010\u0013\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0002J\u0016\u0010\u0016\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014H\u0002JV\u0010\u0013\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016JV\u0010\u0017\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zootopia/sso/api/impl/ZootopiaProxyServletImpl;", "Lcom/tencent/mobileqq/zootopia/sso/api/IZootopiaProxyServlet;", "Lcom/tencent/common/app/AppInterface;", "app", "", "service", "method", "", "reqData", "", "extData", "Ltd3/a;", "observer", "", "source", "", "isJsonRequest", "timeout", "", "sendZootopiaProxyRequest", "Lkotlin/Function0;", "callback", "ensureMainThread", "sendZootopiaProxyJsonRequest", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaProxyServletImpl implements IZootopiaProxyServlet {
    public static final String TAG = "ZootopiaProxyServletImpl";

    private final void ensureMainThread(final Function0<Unit> callback) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            callback.invoke();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.sso.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    ZootopiaProxyServletImpl.ensureMainThread$lambda$0(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ensureMainThread$lambda$0(Function0 callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke();
    }

    @Override // com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet
    public void sendZootopiaProxyJsonRequest(AppInterface app, String service, String method, byte[] reqData, Map<String, String> extData, td3.a observer, int source, int timeout) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(reqData, "reqData");
        Intrinsics.checkNotNullParameter(extData, "extData");
        Intrinsics.checkNotNullParameter(observer, "observer");
        sendZootopiaProxyRequest(app, service, method, reqData, extData, observer, source, true, timeout);
    }

    @Override // com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet
    public void sendZootopiaProxyRequest(AppInterface app, String service, String method, byte[] reqData, Map<String, String> extData, td3.a observer, int source, int timeout) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(reqData, "reqData");
        Intrinsics.checkNotNullParameter(extData, "extData");
        Intrinsics.checkNotNullParameter(observer, "observer");
        sendZootopiaProxyRequest(app, service, method, reqData, extData, observer, source, false, timeout);
    }

    private final void sendZootopiaProxyRequest(AppInterface app, String service, String method, byte[] reqData, Map<String, String> extData, final td3.a observer, int source, boolean isJsonRequest, int timeout) {
        if (app == null) {
            QLog.e(TAG, 1, "getAppInterface null, service= " + service + ", method= " + method + ", extData= " + extData + ", source= " + source + ", isJsonRequest= " + isJsonRequest);
            ensureMainThread(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.sso.api.impl.ZootopiaProxyServletImpl$sendZootopiaProxyRequest$1
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
                    td3.a.this.a(-12, "");
                }
            });
            return;
        }
        if (!app.isLogin()) {
            QLog.e(TAG, 1, "!!!isLogin false! service= " + service + ", method= " + method + ", extData= " + extData + ", source= " + source + ", isJsonRequest= " + isJsonRequest + ", app= " + app);
            ensureMainThread(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.sso.api.impl.ZootopiaProxyServletImpl$sendZootopiaProxyRequest$2
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
                    td3.a.this.a(-16, "");
                }
            });
            return;
        }
        BusinessHandler businessHandler = app.getBusinessHandler(ZootopiaBusinessHandler.INSTANCE.b());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.zootopia.sso.ZootopiaBusinessHandler");
        ((ZootopiaBusinessHandler) businessHandler).H2(service, method, reqData, timeout, extData, source, isJsonRequest, new b(observer));
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/sso/api/impl/ZootopiaProxyServletImpl$b", "Lcom/tencent/mobileqq/zootopia/sso/b;", "", "type", "", "isSuccess", "Lcom/tencent/mobileqq/zootopia/sso/d;", "data", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends com.tencent.mobileqq.zootopia.sso.b {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ td3.a f329286e;

        b(td3.a aVar) {
            this.f329286e = aVar;
        }

        @Override // com.tencent.mobileqq.zootopia.sso.b
        public void a(int type, boolean isSuccess, d data) {
            FromServiceMsg res;
            FromServiceMsg res2;
            if (isSuccess) {
                boolean z16 = false;
                if (data != null && data.getRetCode() == 0) {
                    z16 = true;
                }
                if (z16) {
                    this.f329286e.onReceive(data.getData());
                    return;
                } else {
                    this.f329286e.a(data != null ? Integer.valueOf(data.getRetCode()) : null, data != null ? data.getErrMsg() : null);
                    return;
                }
            }
            td3.a aVar = this.f329286e;
            Integer valueOf = (data == null || (res2 = data.getRes()) == null) ? null : Integer.valueOf(res2.getBusinessFailCode());
            if (data != null && (res = data.getRes()) != null) {
                r2 = res.getBusinessFailMsg();
            }
            aVar.a(valueOf, r2);
        }
    }
}
