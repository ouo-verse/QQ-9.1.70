package com.tencent.mobileqq.aio.notification;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\u0007H&J\b\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/c;", "", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "uiModel", "", "c", "token", "", "j", "g", "k", "Lcom/tencent/aio/api/runtime/a;", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface c {
    @NotNull
    com.tencent.aio.api.runtime.a a();

    @NotNull
    String c(@NotNull IAIONotificationUIModel uiModel);

    void g(@NotNull String token);

    void j(@NotNull String token, @NotNull IAIONotificationUIModel uiModel);

    void k();
}
