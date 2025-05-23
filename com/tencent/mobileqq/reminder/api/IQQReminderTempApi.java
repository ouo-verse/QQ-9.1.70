package com.tencent.mobileqq.reminder.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.reminder.push.a;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/reminder/api/IQQReminderTempApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "Lcom/tencent/mobileqq/reminder/push/a;", "get0x210PushProcessor", "qqreminder-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IQQReminderTempApi extends QRouteApi {
    @NotNull
    List<a> get0x210PushProcessor();
}
