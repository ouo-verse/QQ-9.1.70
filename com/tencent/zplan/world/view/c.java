package com.tencent.zplan.world.view;

import android.view.Surface;
import android.view.View;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\t\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\u0002H&J\b\u0010\f\u001a\u00020\u000bH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u000fH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/zplan/world/view/c;", "", "", "worldID", "", "setWorldID", "Lcom/tencent/zplan/world/view/d;", "listener", "setRenderListener", "a", "b", "Landroid/view/View;", "getView", "Landroid/view/Surface;", "getSurface", "Lcom/tencent/zplan/world/view/b;", "setOnTouchEventListener", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface c {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a {
        @Deprecated(message = "\u529f\u80fd\u6682\u672a\u5f00\u542f\uff0c\u540e\u7eed\u4f7f\u7528")
        public static void a(@NotNull c cVar, @NotNull com.tencent.zplan.world.render.offscreen.a offscreenRender) {
            Intrinsics.checkNotNullParameter(offscreenRender, "offscreenRender");
        }
    }

    int a();

    int b();

    @Nullable
    Surface getSurface();

    @NotNull
    View getView();

    void setOnTouchEventListener(@NotNull b listener);

    void setRenderListener(@Nullable d listener);

    void setWorldID(int worldID);
}
