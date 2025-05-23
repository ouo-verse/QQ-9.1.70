package com.tencent.state.map;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\u00072\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u000eH&J\b\u0010\u000f\u001a\u00020\tH&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\u0013\u001a\u00020\tH&J\b\u0010\u0014\u001a\u00020\tH&J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/map/IMapLocator;", "", "viewPort", "Landroid/graphics/Rect;", "getViewPort", "()Landroid/graphics/Rect;", "addItemLocation", "", "index", "", "data", "Lcom/tencent/state/map/MapItem;", "forEachLocation", "block", "Lkotlin/Function2;", "getCenterIndex", "getItemLocation", "Lcom/tencent/state/map/Location;", "getItemPosition", "getMapHeight", "getMapWidth", "setItemLocation", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public interface IMapLocator {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class DefaultImpls {
        public static void addItemLocation(IMapLocator iMapLocator, int i3, MapItem data) {
            Intrinsics.checkNotNullParameter(data, "data");
        }

        public static void setItemLocation(IMapLocator iMapLocator, int i3, MapItem data) {
            Intrinsics.checkNotNullParameter(data, "data");
        }
    }

    void addItemLocation(int index, MapItem data);

    void forEachLocation(Function2<? super Integer, ? super Rect, Unit> block);

    int getCenterIndex();

    Location getItemLocation(int index);

    Rect getItemPosition(int index);

    int getMapHeight();

    int getMapWidth();

    Rect getViewPort();

    void setItemLocation(int index, MapItem data);
}
