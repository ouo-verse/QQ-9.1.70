package com.tencent.qzonehub.api.impl;

import android.text.TextUtils;
import com.tencent.qzonehub.api.IQZoneIpConfigApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qzonehub/api/impl/QZoneIpConfigApiImpl;", "Lcom/tencent/qzonehub/api/IQZoneIpConfigApi;", "()V", "getVideoIpDirectConfigString", "", "hostname", "isHttps", "", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class QZoneIpConfigApiImpl implements IQZoneIpConfigApi {
    @Override // com.tencent.qzonehub.api.IQZoneIpConfigApi
    public String getVideoIpDirectConfigString(String hostname, boolean isHttps) {
        if (TextUtils.isEmpty(hostname)) {
            return null;
        }
        com.tencent.mobileqq.qzone.picload.b bVar = com.tencent.mobileqq.qzone.picload.b.f279315a;
        Intrinsics.checkNotNull(hostname);
        return bVar.c(hostname, isHttps);
    }
}
