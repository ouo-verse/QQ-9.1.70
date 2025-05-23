package com.tencent.mobileqq.vas.sso.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.vas.sso.ZplanVasBusinessHandler;
import com.tencent.mobileqq.vas.sso.api.IZplanVasProxyServlet;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import d33.c;
import d33.d;
import e33.RspErrorData;
import e33.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012JN\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/sso/api/impl/ZplanVasProxyServletImpl;", "Lcom/tencent/mobileqq/vas/sso/api/IZplanVasProxyServlet;", "Lcom/tencent/common/app/AppInterface;", "app", "", "service", "method", "", "reqData", "", "extData", "Le33/a;", "observerVas", "", "source", "", "sendVasProxyRequest", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanVasProxyServletImpl implements IZplanVasProxyServlet {
    public static final String TAG = "ZplanVasProxyServletImpl";
    public static final int TIMEOUT = 15000;

    @Override // com.tencent.mobileqq.vas.sso.api.IZplanVasProxyServlet
    public void sendVasProxyRequest(AppInterface app, String service, String method, byte[] reqData, Map<String, String> extData, a observerVas, int source) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(reqData, "reqData");
        Intrinsics.checkNotNullParameter(extData, "extData");
        Intrinsics.checkNotNullParameter(observerVas, "observerVas");
        if (app == null) {
            QLog.e(TAG, 1, "getAppInterface null");
            observerVas.b(new RspErrorData(-1, "get app is null", null));
        } else {
            BusinessHandler businessHandler = app.getBusinessHandler(ZplanVasBusinessHandler.INSTANCE.a());
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.vas.sso.ZplanVasBusinessHandler");
            ((ZplanVasBusinessHandler) businessHandler).H2(service, method, reqData, 15000, extData, source, new b(observerVas));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/vas/sso/api/impl/ZplanVasProxyServletImpl$b", "Ld33/c;", "", "type", "", "isSuccess", "Ld33/d;", "data", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends c {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f310874e;

        b(a aVar) {
            this.f310874e = aVar;
        }

        @Override // d33.c
        public void a(int type, boolean isSuccess, d data) {
            FromServiceMsg res;
            FromServiceMsg res2;
            if (isSuccess) {
                boolean z16 = false;
                if (data != null && data.getRetCode() == 0) {
                    z16 = true;
                }
                if (z16) {
                    this.f310874e.onReceive(data.getData());
                    return;
                } else {
                    this.f310874e.b(new RspErrorData(data != null ? Integer.valueOf(data.getRetCode()) : null, data != null ? data.getErrMsg() : null, data != null ? data.getPrompt() : null));
                    return;
                }
            }
            this.f310874e.b(new RspErrorData((data == null || (res2 = data.getRes()) == null) ? null : Integer.valueOf(res2.getBusinessFailCode()), (data == null || (res = data.getRes()) == null) ? null : res.getBusinessFailMsg(), data != null ? data.getPrompt() : null));
        }
    }
}
