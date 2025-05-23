package com.tencent.mobileqq.vas.pendant.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.pendant.api.IPendantResDownloadApi;
import com.tencent.mobileqq.vas.pendant.drawable.api.IPendantHelperApi;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vas/pendant/api/impl/PendantResDownloadApiImpl;", "Lcom/tencent/mobileqq/vas/pendant/api/IPendantResDownloadApi;", "()V", "notifyFontDownloadComplete", "", "key", "", "notifyPasterDownloadComplete", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class PendantResDownloadApiImpl implements IPendantResDownloadApi {
    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantResDownloadApi
    public void notifyFontDownloadComplete(@Nullable String key) {
        if (key != null) {
            ((IPendantHelperApi) QRoute.api(IPendantHelperApi.class)).getDiyPendantFetcher().notifyFontDownloadComplete(key);
        }
    }

    @Override // com.tencent.mobileqq.vas.pendant.api.IPendantResDownloadApi
    public void notifyPasterDownloadComplete(@Nullable String key) {
        if (key != null) {
            ((IPendantHelperApi) QRoute.api(IPendantHelperApi.class)).getDiyPendantFetcher().notifyPasterDownloadComplete(key);
        }
    }
}
