package com.tencent.mobileqq.reminder.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/reminder/api/IQQReminderHelperApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "is0x118NtPushChannel", "", "is0x13aNtPushChannel", "launchNotifyCardDebugPage", "", "context", "Landroid/content/Context;", "qqreminder-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IQQReminderHelperApi extends QRouteApi {
    boolean is0x118NtPushChannel();

    boolean is0x13aNtPushChannel();

    void launchNotifyCardDebugPage(@NotNull Context context);
}
