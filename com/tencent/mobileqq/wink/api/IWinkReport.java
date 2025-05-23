package com.tencent.mobileqq.wink.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IWinkReport extends QRouteApi {
    void reportBugly(@NonNull String str, @Nullable String str2);

    void reportDengTa(@NonNull String str, @NonNull Map<String, String> map);
}
