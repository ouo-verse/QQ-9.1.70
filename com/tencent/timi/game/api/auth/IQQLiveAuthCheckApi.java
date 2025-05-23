package com.tencent.timi.game.api.auth;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes26.dex */
public interface IQQLiveAuthCheckApi extends QRouteApi {
    void checkAuth(@NonNull a aVar);

    void fetchAndCacheAuthState();

    void forceCheckAuth(@NonNull a aVar);
}
