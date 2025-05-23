package com.tencent.state.template.map;

import android.graphics.Rect;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapBaseLocator;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\"\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/template/map/TemplateMapViewLocator;", "Lcom/tencent/state/map/MapBaseLocator;", DownloadInfo.spKey_Config, "Lcom/tencent/state/map/MapViewConfig;", "dataList", "", "Lcom/tencent/state/map/MapItem;", "(Lcom/tencent/state/map/MapViewConfig;Ljava/util/List;)V", "getConfig", "()Lcom/tencent/state/map/MapViewConfig;", "getDataList", "()Ljava/util/List;", "findCenterIndex", "", "forEachLocation", "", "block", "Lkotlin/Function2;", "Landroid/graphics/Rect;", "getItemLocation", "Lcom/tencent/state/map/Location;", "index", "getItemPosition", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class TemplateMapViewLocator extends MapBaseLocator {
    private static final String TAG = "TemplateMapViewLocator";
    private final MapViewConfig config;
    private final List<MapItem> dataList;

    /* JADX WARN: Multi-variable type inference failed */
    public TemplateMapViewLocator(MapViewConfig config, List<? extends MapItem> dataList) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.config = config;
        this.dataList = dataList;
        setMCenterIndex(findCenterIndex(config));
        setMMapWidth(config.getMapWidth());
        setMMapHeight(config.getMapHeight());
        int mMapWidth = (getMMapWidth() - config.getViewPortWidth()) / 2;
        int mMapHeight = (getMMapHeight() - config.getViewPortHeight()) / 2;
        getViewPort().set(mMapWidth, mMapHeight, config.getViewPortWidth() + mMapWidth, config.getViewPortHeight() + mMapHeight);
    }

    private final int findCenterIndex(MapViewConfig config) {
        int coerceAtLeast;
        Object obj;
        Iterator<MapItem> it = this.dataList.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            if (it.next().getIsCenter()) {
                break;
            }
            i3++;
        }
        if (i3 < 0) {
            int mapWidth = config.getMapWidth() / 2;
            int mapHeight = config.getMapHeight() / 2;
            Iterator<T> it5 = this.dataList.iterator();
            if (it5.hasNext()) {
                Object next = it5.next();
                if (it5.hasNext()) {
                    MapItem mapItem = (MapItem) next;
                    int hypotenuse = ViewExtensionsKt.hypotenuse(mapItem.getLocation().getCenterX() - mapWidth, mapItem.getLocation().getCenterY() - mapHeight);
                    do {
                        Object next2 = it5.next();
                        MapItem mapItem2 = (MapItem) next2;
                        int hypotenuse2 = ViewExtensionsKt.hypotenuse(mapItem2.getLocation().getCenterX() - mapWidth, mapItem2.getLocation().getCenterY() - mapHeight);
                        if (hypotenuse > hypotenuse2) {
                            next = next2;
                            hypotenuse = hypotenuse2;
                        }
                    } while (it5.hasNext());
                }
                obj = next;
            } else {
                obj = null;
            }
            MapItem mapItem3 = (MapItem) obj;
            if (mapItem3 != null) {
                i3 = this.dataList.indexOf(mapItem3);
            }
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3, 0);
        return coerceAtLeast;
    }

    @Override // com.tencent.state.map.IMapLocator
    public void forEachLocation(Function2<? super Integer, ? super Rect, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int i3 = 0;
        for (Object obj : this.dataList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            block.invoke(Integer.valueOf(i3), ((MapItem) obj).getItemViewLocation());
            i3 = i16;
        }
    }

    protected final MapViewConfig getConfig() {
        return this.config;
    }

    protected final List<MapItem> getDataList() {
        return this.dataList;
    }

    @Override // com.tencent.state.map.IMapLocator
    public Location getItemLocation(int index) {
        Object orNull;
        Location location;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.dataList, index);
        MapItem mapItem = (MapItem) orNull;
        return (mapItem == null || (location = mapItem.getLocation()) == null) ? MapBaseLocator.INSTANCE.getDEFAULT_LOCATION() : location;
    }

    @Override // com.tencent.state.map.IMapLocator
    public Rect getItemPosition(int index) {
        Object orNull;
        Rect itemViewLocation;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.dataList, index);
        MapItem mapItem = (MapItem) orNull;
        return (mapItem == null || (itemViewLocation = mapItem.getItemViewLocation()) == null) ? MapBaseLocator.INSTANCE.getDEFAULT_POSITION() : itemViewLocation;
    }
}
