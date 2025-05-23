package com.tencent.qqnt.notification.inject;

import android.app.Notification;
import android.content.Intent;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J1\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/notification/inject/d;", "", "Landroid/app/Notification;", "notification", "", "id", "", "ignoreCancel", "unreadCnt", "", "b", "(Landroid/app/Notification;IZLjava/lang/Integer;)V", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "msgRecord", "c", "Landroid/content/Intent;", "intent", "a", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface d {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class a {
        public static void a(@NotNull d dVar, @NotNull Notification notification, int i3, boolean z16, @Nullable Integer num) {
            Intrinsics.checkNotNullParameter(notification, "notification");
        }

        public static void b(@NotNull d dVar, @NotNull RecentContactInfo msgRecord, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            Intrinsics.checkNotNullParameter(intent, "intent");
        }

        public static void c(@NotNull d dVar, @NotNull RecentContactInfo msgRecord) {
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        }
    }

    void a(@NotNull RecentContactInfo msgRecord, @NotNull Intent intent);

    void b(@NotNull Notification notification, int id5, boolean ignoreCancel, @Nullable Integer unreadCnt);

    void c(@NotNull RecentContactInfo msgRecord);
}
