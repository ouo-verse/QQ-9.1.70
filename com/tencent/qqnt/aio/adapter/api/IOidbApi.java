package com.tencent.qqnt.aio.adapter.api;

import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\u000fJ:\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IOidbApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lmqq/app/AppRuntime;", "app", "", "data", "", "cmd", "", "ssoCommand", "serviceType", "Lcom/tencent/qqnt/aio/adapter/api/IOidbApi$a;", "observer", "", "sendOIDBRequest", "a", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IOidbApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IOidbApi$a;", "", "", "errorCode", "", "data", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "", "a", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public interface a {
        void a(int errorCode, @Nullable byte[] data, @Nullable Bundle extraData);
    }

    void sendOIDBRequest(@NotNull AppRuntime app, @NotNull byte[] data, @NotNull String cmd, int ssoCommand, int serviceType, @Nullable a observer);
}
