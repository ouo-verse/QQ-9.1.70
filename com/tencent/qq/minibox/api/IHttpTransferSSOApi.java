package com.tencent.qq.minibox.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qq/minibox/api/IHttpTransferSSOApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lorg/json/JSONObject;", "requestJson", "Lcom/tencent/qq/minibox/api/IHttpTransferSSOApi$a;", "listener", "", "sendReq", "a", "minibox-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IHttpTransferSSOApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qq/minibox/api/IHttpTransferSSOApi$a;", "", "", "isSuccess", "Lorg/json/JSONObject;", "rspJson", "", "a", "minibox-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface a {
        void a(boolean isSuccess, @Nullable JSONObject rspJson);
    }

    void sendReq(@NotNull JSONObject requestJson, @NotNull a listener);
}
