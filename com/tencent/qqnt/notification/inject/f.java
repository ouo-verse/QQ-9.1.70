package com.tencent.qqnt.notification.inject;

import android.graphics.Bitmap;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u000e\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/notification/inject/f;", "", "", h.F, "", "notifyId", "g", "Landroid/graphics/Bitmap;", "bmp", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "msgRecord", "c", "", "from", "a", "b", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface f {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class a {
        public static boolean a(@NotNull f fVar) {
            return false;
        }

        @NotNull
        public static String b(@NotNull f fVar, @Nullable String str, @Nullable RecentContactInfo recentContactInfo) {
            return "QQ";
        }

        @Nullable
        public static Bitmap c(@NotNull f fVar, @Nullable Bitmap bitmap, @Nullable RecentContactInfo recentContactInfo) {
            return null;
        }

        public static boolean d(@NotNull f fVar) {
            return true;
        }

        public static boolean e(@NotNull f fVar, int i3) {
            return false;
        }
    }

    @NotNull
    String a(@Nullable String from, @Nullable RecentContactInfo msgRecord);

    boolean b();

    @Nullable
    Bitmap c(@Nullable Bitmap bmp, @Nullable RecentContactInfo msgRecord);

    boolean g(int notifyId);

    boolean h();
}
