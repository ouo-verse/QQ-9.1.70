package com.tencent.state.square.locator;

import android.graphics.Rect;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapBaseLocator;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewConfig;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.SquareAvatarItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\"\u0010\u0012\u001a\u00020\u000e2\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/square/locator/SquareAreaRankLocator;", "Lcom/tencent/state/map/MapBaseLocator;", DownloadInfo.spKey_Config, "Lcom/tencent/state/map/MapViewConfig;", "dataList", "", "Lcom/tencent/state/map/MapItem;", "(Lcom/tencent/state/map/MapViewConfig;Ljava/util/List;)V", "locationList", "", "Lcom/tencent/state/map/Location;", "positionList", "Landroid/graphics/Rect;", "addItemLocation", "", "index", "", "data", "forEachLocation", "block", "Lkotlin/Function2;", "getItemLocation", "getItemPosition", "setItemLocation", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareAreaRankLocator extends MapBaseLocator {
    private static final String TAG = "SquareAreaRankLocator";
    private final List<Location> locationList;
    private final List<Rect> positionList;

    public SquareAreaRankLocator(MapViewConfig config, List<? extends MapItem> dataList) {
        int coerceAtLeast;
        int collectionSizeOrDefault;
        List<Location> mutableList;
        int collectionSizeOrDefault2;
        List<Rect> mutableList2;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Iterator<? extends MapItem> it = dataList.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (it.next().getIsCenter()) {
                break;
            } else {
                i3++;
            }
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3, 0);
        setMCenterIndex(coerceAtLeast);
        setMMapWidth(config.getMapWidth());
        setMMapHeight(config.getMapHeight());
        int mMapWidth = (getMMapWidth() - config.getViewPortWidth()) / 2;
        int mMapHeight = (getMMapHeight() - config.getViewPortHeight()) / 2;
        getViewPort().set(mMapWidth, mMapHeight, config.getViewPortWidth() + mMapWidth, config.getViewPortHeight() + mMapHeight);
        List<? extends MapItem> list = dataList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it5 = list.iterator();
        while (it5.hasNext()) {
            arrayList.add(((MapItem) it5.next()).getLocation());
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        this.locationList = mutableList;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it6 = list.iterator();
        while (it6.hasNext()) {
            arrayList2.add(((MapItem) it6.next()).getItemViewLocation());
        }
        mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        this.positionList = mutableList2;
        SquareBaseKt.getSquareLog().d(TAG, "cI:" + getMCenterIndex() + ", mW:" + getMMapWidth() + ", mH:" + getMMapHeight() + ", vP:" + getViewPort() + ", vW:" + config.getViewPortWidth() + ", vH:" + config.getViewPortHeight());
    }

    @Override // com.tencent.state.map.MapBaseLocator, com.tencent.state.map.IMapLocator
    public void addItemLocation(int index, MapItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        SquareBaseKt.getSquareLog().i(TAG, "addItemLocation: index=" + index + ", location=" + data.getLocation());
        try {
            this.locationList.add(index, data.getLocation());
            this.positionList.add(index, data.getItemViewLocation());
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "addItemLocation throw:", th5);
        }
    }

    @Override // com.tencent.state.map.IMapLocator
    public void forEachLocation(Function2<? super Integer, ? super Rect, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int i3 = 0;
        for (Object obj : this.positionList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            block.invoke(Integer.valueOf(i3), (Rect) obj);
            i3 = i16;
        }
    }

    @Override // com.tencent.state.map.IMapLocator
    public Location getItemLocation(int index) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.locationList, index);
        Location location = (Location) orNull;
        return location != null ? location : MapBaseLocator.INSTANCE.getDEFAULT_LOCATION();
    }

    @Override // com.tencent.state.map.IMapLocator
    public Rect getItemPosition(int index) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.positionList, index);
        Rect rect = (Rect) orNull;
        return rect != null ? rect : MapBaseLocator.INSTANCE.getDEFAULT_POSITION();
    }

    @Override // com.tencent.state.map.MapBaseLocator, com.tencent.state.map.IMapLocator
    public void setItemLocation(int index, MapItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setItemLocation: index=");
        sb5.append(index);
        sb5.append(", data=");
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) (!(data instanceof SquareAvatarItem) ? null : data);
        sb5.append(squareAvatarItem != null ? squareAvatarItem.getNickName() : null);
        sb5.append(", location=");
        sb5.append(data.getLocation());
        squareLog.i(TAG, sb5.toString());
        int size = this.locationList.size();
        if (index >= 0 && size > index) {
            this.locationList.set(index, data.getLocation());
            this.positionList.set(index, data.getItemViewLocation());
        }
    }
}
