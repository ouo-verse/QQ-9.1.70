package com.tencent.state.square.data;

import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItemKt;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.common.ViewExtensionsKt;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"ITEM_TROOP_BUBBLE_MAX_HEIGHT", "", "toTroopViewLocation", "Landroid/graphics/Rect;", "Lcom/tencent/state/map/Location;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareTroopItemKt {
    public static final int ITEM_TROOP_BUBBLE_MAX_HEIGHT = 100;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect toTroopViewLocation(Location location) {
        Application app = SquareBase.INSTANCE.getApp();
        int dip = ViewExtensionsKt.dip((Context) app, 100);
        int max = Math.max(location.getWidth() + ViewExtensionsKt.calPx(app, 0), ViewExtensionsKt.calPx(app, MapItemKt.ITEM_AVATAR_MIN_WIDTH));
        int height = location.getHeight() + ViewExtensionsKt.calPx(app, dip) + ViewExtensionsKt.dip((Context) app, 20);
        int x16 = location.getX() - ((max / 2) - (location.getWidth() / 2));
        int y16 = location.getY() - ViewExtensionsKt.calPx(app, dip);
        return new Rect(x16, y16, max + x16, height + y16);
    }
}
