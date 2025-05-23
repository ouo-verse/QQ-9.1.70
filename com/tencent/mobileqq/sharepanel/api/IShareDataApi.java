package com.tencent.mobileqq.sharepanel.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.sharepanel.model.c;
import com.tencent.mobileqq.sharepanel.model.e;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J(\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006H&J(\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/api/IShareDataApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/sharepanel/model/c;", "reqData", "", "bizData", "Lcom/tencent/mobileqq/sharepanel/api/a;", "Lcom/tencent/mobileqq/sharepanel/model/a;", "callback", "", "requestShareArkData", "Lcom/tencent/mobileqq/sharepanel/model/e;", "requestShareURL", "requestShareURL4XHS", "qq-sharepanel-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IShareDataApi extends QRouteApi {
    void requestShareArkData(@NotNull c reqData, @Nullable byte[] bizData, @NotNull a<com.tencent.mobileqq.sharepanel.model.a> callback);

    void requestShareURL(@NotNull c reqData, @Nullable byte[] bizData, @NotNull a<e> callback);

    void requestShareURL4XHS(@NotNull c reqData, @Nullable byte[] bizData, @NotNull a<e> callback);
}
