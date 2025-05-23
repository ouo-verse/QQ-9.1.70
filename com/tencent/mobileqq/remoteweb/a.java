package com.tencent.mobileqq.remoteweb;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J \u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\nH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/a;", "", "", "webPageId", "", "code", "msg", "", "onFailed", "onServiceConnected", "", "durationMs", "onServiceDisconnected", "Lcom/tencent/mobileqq/remoteweb/RemoteWebViewEvent;", "event", "onWebViewEvent", "Landroid/os/Bundle;", "extras", "Lcom/tencent/mobileqq/remoteweb/RemoteWebTimeCost;", "type", "startTime", "onReportTimeCost", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface a {
    void onFailed(@NotNull String webPageId, int code, @Nullable String msg2);

    void onReportTimeCost(@NotNull String webPageId, @NotNull RemoteWebTimeCost type, long startTime);

    void onServiceConnected();

    void onServiceDisconnected(long durationMs);

    void onWebViewEvent(@NotNull String webPageId, @NotNull RemoteWebViewEvent event);

    void onWebViewEvent(@NotNull String webPageId, @NotNull RemoteWebViewEvent event, @NotNull Bundle extras);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.remoteweb.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class C8510a {
        public static void a(@NotNull a aVar, @NotNull String webPageId, int i3, @Nullable String str) {
            Intrinsics.checkNotNullParameter(webPageId, "webPageId");
        }

        public static void b(@NotNull a aVar, @NotNull String webPageId, @NotNull RemoteWebTimeCost type, long j3) {
            Intrinsics.checkNotNullParameter(webPageId, "webPageId");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        public static void e(@NotNull a aVar, @NotNull String webPageId, @NotNull RemoteWebViewEvent event) {
            Intrinsics.checkNotNullParameter(webPageId, "webPageId");
            Intrinsics.checkNotNullParameter(event, "event");
        }

        public static void f(@NotNull a aVar, @NotNull String webPageId, @NotNull RemoteWebViewEvent event, @NotNull Bundle extras) {
            Intrinsics.checkNotNullParameter(webPageId, "webPageId");
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(extras, "extras");
        }

        public static void c(@NotNull a aVar) {
        }

        public static void d(@NotNull a aVar, long j3) {
        }
    }
}
