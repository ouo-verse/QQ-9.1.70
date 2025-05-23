package com.tencent.tmdownloader.internal.notification;

import android.app.PendingIntent;
import android.content.Intent;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmdownloader.TMAssistantDownloadService;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {
    public static PendingIntent a(NotifyParam notifyParam) {
        Intent intent = new Intent(GlobalUtil.getInstance().getContext(), (Class<?>) TMAssistantDownloadService.class);
        intent.putExtra("notification_id", notifyParam.notificationTypeId);
        intent.putExtra("notifyParam", notifyParam);
        return PendingIntent.getService(GlobalUtil.getInstance().getContext(), (int) (System.currentTimeMillis() & 268435455), intent, 201326592);
    }
}
