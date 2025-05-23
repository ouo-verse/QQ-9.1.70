package com.tencent.state.map;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a8\u0006\u0006"}, d2 = {"getRelativeLocation", "Lcom/tencent/state/map/Location;", "root", "Landroid/view/ViewGroup;", "child", "Landroid/view/View;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class MapPlayableViewHolderKt {
    public static final Location getRelativeLocation(ViewGroup root, View view) {
        Intrinsics.checkNotNullParameter(root, "root");
        if (view == null) {
            return new Location(0, 0, 0, 0, 0, 0, 48, null);
        }
        if (Intrinsics.areEqual(view, root)) {
            return new Location(0, 0, view.getWidth(), view.getHeight(), 0, 0, 48, null);
        }
        if (Intrinsics.areEqual(view.getParent(), root)) {
            return new Location((int) view.getX(), (int) view.getY(), view.getWidth(), view.getHeight(), 0, 0, 48, null);
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        Location relativeLocation = getRelativeLocation(root, (ViewGroup) parent);
        return new Location(((int) view.getX()) + relativeLocation.getX(), relativeLocation.getY() + ((int) view.getY()), view.getWidth(), view.getHeight(), 0, 0, 48, null);
    }
}
