package com.tencent.qqnt.notification.api.impl;

import com.tencent.mobileqq.app.ForegroundNotifyManager;
import com.tencent.qqnt.notification.api.INotificationApi;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/notification/api/impl/NotificationApiImpl;", "Lcom/tencent/qqnt/notification/api/INotificationApi;", "()V", "isCurrentInAIO", "", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class NotificationApiImpl implements INotificationApi {
    @Override // com.tencent.qqnt.notification.api.INotificationApi
    public boolean isCurrentInAIO() {
        return ForegroundNotifyManager.k();
    }
}
