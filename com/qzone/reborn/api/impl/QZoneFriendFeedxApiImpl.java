package com.qzone.reborn.api.impl;

import com.qzone.reborn.api.IQZoneFriendFeedxApi;
import kotlin.Metadata;
import lg.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/api/impl/QZoneFriendFeedxApiImpl;", "Lcom/qzone/reborn/api/IQZoneFriendFeedxApi;", "()V", "saveLeaveTime", "", "timeMills", "", "shouldRefresh", "", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneFriendFeedxApiImpl implements IQZoneFriendFeedxApi {
    @Override // com.qzone.reborn.api.IQZoneFriendFeedxApi
    public /* bridge */ /* synthetic */ void saveLeaveTime(Long l3) {
        saveLeaveTime(l3.longValue());
    }

    @Override // com.qzone.reborn.api.IQZoneFriendFeedxApi
    public boolean shouldRefresh() {
        return g.f414459a.o();
    }

    public void saveLeaveTime(long timeMills) {
        g.f414459a.k(timeMills);
    }
}
