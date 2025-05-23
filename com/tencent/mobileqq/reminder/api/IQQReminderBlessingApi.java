package com.tencent.mobileqq.reminder.api;

import cm2.b;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\tH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/reminder/api/IQQReminderBlessingApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "", "uins", "", "source", "Lcm2/b;", "callback", "", "sendBlessingTimedMessage", "key", "", "removeCallback", "qqreminder-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IQQReminderBlessingApi extends QRouteApi {
    void removeCallback(@NotNull String key);

    @Nullable
    String sendBlessingTimedMessage(@NotNull List<Long> uins, int source, @Nullable b callback);
}
