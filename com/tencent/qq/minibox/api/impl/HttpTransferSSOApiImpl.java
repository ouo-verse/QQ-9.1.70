package com.tencent.qq.minibox.api.impl;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ark.ark;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IHttpTransferSSOApi;
import com.tencent.trpcprotocol.transfer.TransferPB$HTTPTransferRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qq/minibox/api/impl/HttpTransferSSOApiImpl;", "Lcom/tencent/qq/minibox/api/IHttpTransferSSOApi;", "Lorg/json/JSONObject;", "requestJson", "Lqs3/d;", "ssoResponse", "Lcom/tencent/qq/minibox/api/IHttpTransferSSOApi$a;", "listener", "", "handleRsp", "sendReq", "<init>", "()V", "Companion", "a", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class HttpTransferSSOApiImpl implements IHttpTransferSSOApi {

    @NotNull
    private static final String TAG = "HttpTransferSSOApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qq/minibox/api/impl/HttpTransferSSOApiImpl$b", "Lqs3/a;", "Lqs3/d;", "ssoResponse", "", "q7", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements qs3.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ JSONObject f344493e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ IHttpTransferSSOApi.a f344494f;

        b(JSONObject jSONObject, IHttpTransferSSOApi.a aVar) {
            this.f344493e = jSONObject;
            this.f344494f = aVar;
        }

        @Override // qs3.a
        public void q7(@NotNull qs3.d ssoResponse) {
            Intrinsics.checkNotNullParameter(ssoResponse, "ssoResponse");
            QLog.i(HttpTransferSSOApiImpl.TAG, 1, "ssoResponse.isSuccess:" + ssoResponse.c());
            if (ssoResponse.c() && ssoResponse.getData() != null) {
                try {
                    HttpTransferSSOApiImpl.this.handleRsp(this.f344493e, ssoResponse, this.f344494f);
                    return;
                } catch (Exception e16) {
                    QLog.e(HttpTransferSSOApiImpl.TAG, 1, e16, new Object[0]);
                }
            }
            this.f344494f.a(false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleRsp(JSONObject requestJson, qs3.d ssoResponse, IHttpTransferSSOApi.a listener) {
        TransferPB$HTTPTransferRsp transferPB$HTTPTransferRsp = new TransferPB$HTTPTransferRsp();
        transferPB$HTTPTransferRsp.mergeFrom(ssoResponse.getData());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, transferPB$HTTPTransferRsp.status_code.get());
        String stringUtf8 = transferPB$HTTPTransferRsp.body.get().toStringUtf8();
        if (Intrinsics.areEqual(ark.ARKMETADATA_JSON, requestJson.optString("dataType"))) {
            try {
                jSONObject.put("data", new JSONObject(stringUtf8));
            } catch (Exception unused) {
                jSONObject.put("data", stringUtf8);
            }
        } else {
            jSONObject.put("data", stringUtf8);
        }
        String str = transferPB$HTTPTransferRsp.header.get();
        try {
            jSONObject.put("header", new JSONObject(str));
        } catch (Exception unused2) {
            jSONObject.put("header", str);
        }
        listener.a(true, jSONObject);
    }

    @Override // com.tencent.qq.minibox.api.IHttpTransferSSOApi
    public void sendReq(@NotNull JSONObject requestJson, @NotNull IHttpTransferSSOApi.a listener) {
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
        Intrinsics.checkNotNullParameter(listener, "listener");
        qs3.c.f429464a.d(new rs3.g(requestJson), new b(requestJson, listener));
    }
}
