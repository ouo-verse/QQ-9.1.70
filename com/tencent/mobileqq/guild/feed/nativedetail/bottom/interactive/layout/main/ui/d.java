package com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui;

import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wk1.j;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\r\u001a\u00020\u00042\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/ui/d;", "Lwk1/j;", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "init", "a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "speakPermission", "e", "Lqj1/b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IBottomInteractDisplayable;", "bottomInteractData", "b", "", "enable", "u1", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface d extends wk1.j {
    void a();

    void b(@NotNull qj1.b bottomInteractData);

    void e(@NotNull SpeakPermissionType speakPermission);

    void init(@NotNull ViewGroup rootView);

    void u1(boolean enable);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static void a(@NotNull d dVar, @NotNull String action, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(action, "action");
            j.a.a(dVar, action, obj);
        }

        @Nullable
        public static Object b(@NotNull d dVar, @NotNull String action, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(action, "action");
            return j.a.b(dVar, action, obj);
        }

        public static void c(@NotNull d dVar, @NotNull qj1.b bottomInteractData) {
            Intrinsics.checkNotNullParameter(bottomInteractData, "bottomInteractData");
        }

        public static void e(@NotNull d dVar, @NotNull SpeakPermissionType speakPermission) {
            Intrinsics.checkNotNullParameter(speakPermission, "speakPermission");
        }

        public static void d(@NotNull d dVar) {
        }

        public static void f(@NotNull d dVar, boolean z16) {
        }
    }
}
