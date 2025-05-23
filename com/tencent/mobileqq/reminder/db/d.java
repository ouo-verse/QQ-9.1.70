package com.tencent.mobileqq.reminder.db;

import com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lmqq/app/AppRuntime;", "Lcom/tencent/mobileqq/reminder/api/IQQReminderRecordFacadeApi;", "a", "qqreminder-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class d {
    @NotNull
    public static final IQQReminderRecordFacadeApi a(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "<this>");
        IRuntimeService runtimeService = appRuntime.getRuntimeService(IQQReminderRecordFacadeApi.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "this.getRuntimeService(I\u2026va, ProcessConstant.MAIN)");
        return (IQQReminderRecordFacadeApi) runtimeService;
    }
}
