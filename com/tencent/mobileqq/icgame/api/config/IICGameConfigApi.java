package com.tencent.mobileqq.icgame.api.config;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IICGameConfigApi extends QRouteApi {
    @NonNull
    <T> T getConfigBean(@NonNull String str, @NonNull Class<T> cls, @NonNull T t16);

    @NonNull
    String getRawConfig(@NonNull String str, @NonNull String str2);

    @NonNull
    SinglePrimaryData getSinglePrimaryData(@NonNull String str, @NonNull String str2);

    boolean isSwitchOn(@NonNull String str, boolean z16);
}
