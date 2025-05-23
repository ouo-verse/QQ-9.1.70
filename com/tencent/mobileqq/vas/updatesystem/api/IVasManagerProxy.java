package com.tencent.mobileqq.vas.updatesystem.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import sw4.c;
import sw4.d;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/updatesystem/api/IVasManagerProxy;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lsw4/d;", "getHttpDownloader", "Lsw4/c;", "getDbManager", "vas_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasManagerProxy extends QRouteApi {
    @Nullable
    c getDbManager();

    @Nullable
    d getHttpDownloader();
}
