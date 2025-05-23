package com.tencent.state.map;

import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.util.Size;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.common.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\u00072\u0006\u0010\f\u001a\u00020\u0001H\u0002\u001a\n\u0010\r\u001a\u00020\u000e*\u00020\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"ITEM_AVATAR_BUBBLE_MAX_HEIGHT", "", "ITEM_AVATAR_MIN_WIDTH", "ITEM_AVATAR_NAME_HEIGHT", "ITEM_AVATAR_NEW_INFO_HEIGHT", "ITEM_MARGIN", "relocation", "Lcom/tencent/state/map/Location;", "size", "Landroid/util/Size;", "toItemViewLocation", "Landroid/graphics/Rect;", "type", "toLogString", "", "square_base_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes4.dex */
public final class MapItemKt {
    public static final int ITEM_AVATAR_BUBBLE_MAX_HEIGHT = 225;
    public static final int ITEM_AVATAR_MIN_WIDTH = 330;
    public static final int ITEM_AVATAR_NAME_HEIGHT = 20;
    public static final int ITEM_AVATAR_NEW_INFO_HEIGHT = 18;
    public static final int ITEM_MARGIN = 0;

    @NotNull
    public static final Location relocation(@NotNull Location relocation, @NotNull Size size) {
        Intrinsics.checkNotNullParameter(relocation, "$this$relocation");
        Intrinsics.checkNotNullParameter(size, "size");
        return new Location((relocation.getX() + (relocation.getWidth() / 2)) - (size.getWidth() / 2), (relocation.getY() + (relocation.getHeight() / 2)) - (size.getHeight() / 2), size.getWidth(), size.getHeight(), relocation.getArea(), relocation.getRank());
    }

    public static final Rect toItemViewLocation(Location location, int i3) {
        Application app = SquareBase.INSTANCE.getApp();
        int max = Math.max(location.getWidth() + ViewExtensionsKt.calPx(app, 0), ViewExtensionsKt.calPx(app, ITEM_AVATAR_MIN_WIDTH));
        int height = location.getHeight() + ViewExtensionsKt.calPx(app, 225) + ViewExtensionsKt.dip((Context) app, 20) + ViewExtensionsKt.dip((Context) app, 18);
        int x16 = location.getX() - ((max / 2) - (location.getWidth() / 2));
        int y16 = location.getY() - ViewExtensionsKt.calPx(app, 225);
        return new Rect(x16, y16, max + x16, height + y16);
    }

    @NotNull
    public static final String toLogString(@NotNull Rect toLogString) {
        Intrinsics.checkNotNullParameter(toLogString, "$this$toLogString");
        return "Rect(x=" + toLogString.left + ", y=" + toLogString.top + ", w=" + toLogString.width() + ", h=" + toLogString.height() + ')';
    }
}
