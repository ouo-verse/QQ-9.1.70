package com.tencent.qqnt.notification.inject;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/notification/inject/b;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "d", "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "msgRecord", "e", "", "chatType", "", "l", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface b {
    @NotNull
    Intent d(@Nullable Context context);

    @Nullable
    Intent e(@Nullable RecentContactInfo msgRecord, @Nullable Intent intent);

    @NotNull
    Intent k(@NotNull Intent intent);

    boolean l(int chatType);

    @NotNull
    Intent m(@NotNull Intent intent);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class a {
        public static boolean a(@NotNull b bVar, int i3) {
            return false;
        }

        @NotNull
        public static Intent b(@NotNull b bVar, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return intent;
        }

        @NotNull
        public static Intent c(@NotNull b bVar, @Nullable Context context) {
            Intent intent = new Intent();
            Intrinsics.checkNotNull(context);
            intent.setComponent(new ComponentName(context, "com.tencent.qqnt.SplashActivity"));
            return intent;
        }

        @NotNull
        public static Intent d(@NotNull b bVar, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            intent.putExtra("tab_index", 0);
            return intent;
        }

        @Nullable
        public static Intent e(@NotNull b bVar, @Nullable RecentContactInfo recentContactInfo, @Nullable Intent intent) {
            return intent;
        }
    }
}
