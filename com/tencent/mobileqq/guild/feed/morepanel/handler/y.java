package com.tencent.mobileqq.guild.feed.morepanel.handler;

import android.app.Activity;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007H\u0016J(\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/y;", "", "", "id", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "", "b", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface y {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static boolean a(@NotNull y yVar, @NotNull String id5, @NotNull PanelContext<Activity, vk1.b> panelContext) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            return false;
        }

        public static boolean b(@NotNull y yVar, @NotNull String id5, @NotNull PanelContext<Activity, vk1.b> panelContext) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            return false;
        }
    }

    boolean a(@NotNull String id5, @NotNull PanelContext<Activity, vk1.b> panelContext);

    boolean b(@NotNull String id5, @NotNull PanelContext<Activity, vk1.b> panelContext);
}
