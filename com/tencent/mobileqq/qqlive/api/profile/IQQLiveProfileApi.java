package com.tencent.mobileqq.qqlive.api.profile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"tool"})
/* loaded from: classes17.dex */
public interface IQQLiveProfileApi extends QRouteApi {
    @Nullable
    QQProfile getQQProfile(@NonNull String str);
}
