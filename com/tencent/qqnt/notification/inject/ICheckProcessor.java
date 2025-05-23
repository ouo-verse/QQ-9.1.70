package com.tencent.qqnt.notification.inject;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.global.settings.api.IGlobalSettingsApi;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.notification.trace.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J*\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\bH\u0016J*\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/notification/inject/ICheckProcessor;", "", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "msgRecord", "Lcom/tencent/qqnt/notification/trace/a;", "trackerConfig", "", "f", "a", "", "i", h.F, "g", "withPreview", "d", "b", "e", "showNotification", "c", "isAppForeground", "", "uin", "isRobotUin", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface ICheckProcessor {
    boolean a(@NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord, @Nullable com.tencent.qqnt.notification.trace.a trackerConfig);

    void b();

    boolean c(@NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord, boolean showNotification, @Nullable com.tencent.qqnt.notification.trace.a trackerConfig);

    boolean d(@NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord, boolean withPreview, @Nullable com.tencent.qqnt.notification.trace.a trackerConfig);

    void e(@NotNull AppRuntime app, boolean withPreview);

    boolean f(@NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord, @Nullable com.tencent.qqnt.notification.trace.a trackerConfig);

    void g(@NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord);

    boolean h(@NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord, @Nullable com.tencent.qqnt.notification.trace.a trackerConfig);

    void i(@NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord);

    boolean isAppForeground();

    boolean isRobotUin(@NotNull String uin);

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class DefaultImpls {
        public static boolean a(@NotNull ICheckProcessor iCheckProcessor, @NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord, @Nullable com.tencent.qqnt.notification.trace.a aVar) {
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            return true;
        }

        public static boolean b(@NotNull ICheckProcessor iCheckProcessor, @NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord, @Nullable com.tencent.qqnt.notification.trace.a aVar) {
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            return true;
        }

        public static boolean c(@NotNull ICheckProcessor iCheckProcessor, @NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord, @Nullable com.tencent.qqnt.notification.trace.a aVar) {
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            if (!((IGlobalSettingsApi) QRoute.api(IGlobalSettingsApi.class)).isNewMessageNotificationShow()) {
                com.tencent.qqnt.notification.util.a.f359909a.b("Notification.Check", ICheckProcessor$highPriorityCheck$1.INSTANCE);
                if (aVar != null) {
                    aVar.c(new a.b.C9665a(false));
                }
                return false;
            }
            return true;
        }

        public static boolean d(@NotNull ICheckProcessor iCheckProcessor) {
            return true;
        }

        public static boolean e(@NotNull ICheckProcessor iCheckProcessor, @NotNull String uin) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            return false;
        }

        public static boolean f(@NotNull ICheckProcessor iCheckProcessor, @NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord, boolean z16, @Nullable com.tencent.qqnt.notification.trace.a aVar) {
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            return true;
        }

        public static boolean g(@NotNull ICheckProcessor iCheckProcessor, @NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord, boolean z16, @Nullable com.tencent.qqnt.notification.trace.a aVar) {
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            return true;
        }

        public static void h(@NotNull ICheckProcessor iCheckProcessor, @NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord) {
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        }

        public static void i(@NotNull ICheckProcessor iCheckProcessor, @NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord) {
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        }

        public static void k(@NotNull ICheckProcessor iCheckProcessor, @NotNull AppRuntime app, boolean z16) {
            Intrinsics.checkNotNullParameter(app, "app");
        }

        public static void j(@NotNull ICheckProcessor iCheckProcessor) {
        }
    }
}
