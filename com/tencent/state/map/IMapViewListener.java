package com.tencent.state.map;

import android.view.View;
import com.tencent.state.square.MoveItem;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.resource.IResourceCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J2\u0010\f\u001a\u00020\u00032\u000e\u0010\r\u001a\n\u0012\u0002\b\u00030\u000ej\u0002`\u000f2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\tH\u0016J*\u0010\u0011\u001a\u00020\u00032\u000e\u0010\r\u001a\n\u0012\u0002\b\u00030\u000ej\u0002`\u000f2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J*\u0010\u0012\u001a\u00020\u00032\u000e\u0010\r\u001a\n\u0012\u0002\b\u00030\u000ej\u0002`\u000f2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J2\u0010\u0012\u001a\u00020\u00032\u000e\u0010\r\u001a\n\u0012\u0002\b\u00030\u000ej\u0002`\u000f2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\tH\u0016J>\u0010\u0014\u001a\u00020\u00032\u000e\u0010\r\u001a\n\u0012\u0002\b\u00030\u000ej\u0002`\u000f2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0001H&J2\u0010\u0016\u001a\u00020\u00032\u000e\u0010\r\u001a\n\u0012\u0002\b\u00030\u000ej\u0002`\u000f2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\tH&J\u001e\u0010\u0017\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0001H&J*\u0010\u0018\u001a\u00020\u00032\u000e\u0010\r\u001a\n\u0012\u0002\b\u00030\u000ej\u0002`\u000f2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0005H&J \u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0016\u0010 \u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\"0!H&J\u0016\u0010#\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020$0!H&J\u001a\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H&J*\u0010*\u001a\u00020\u00032\u000e\u0010\r\u001a\n\u0012\u0002\b\u00030\u000ej\u0002`\u000f2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J*\u0010+\u001a\u00020\u00032\u000e\u0010\r\u001a\n\u0012\u0002\b\u00030\u000ej\u0002`\u000f2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&\u00a8\u0006,"}, d2 = {"Lcom/tencent/state/map/IMapViewListener;", "", "onCenterScaled", "", "isScaleToCenter", "", "view", "Landroid/view/View;", "index", "", "data", "Lcom/tencent/state/map/MapItem;", "onDoubleClick", "vh", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "viewId", "onInVisible", "onItemBind", "event", "onItemClicked", "extra", "onItemLongClick", "onItemRecordCover", "onItemRecycled", "onMapSizeInitReady", "onMapZoom", "isZoomIn", "onMapZoomEnd", "zoomLevel", "scale", "", "onRoleAdded", "", "Lcom/tencent/state/square/MoveItem;", "onRoleRemoved", "", "onStartRecord", "resource", "Lcom/tencent/state/square/data/Resource;", "callback", "Lcom/tencent/state/square/resource/IResourceCallback;", "onVisible", "onZoomOverOut", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public interface IMapViewListener {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class DefaultImpls {
        public static void onDoubleClick(IMapViewListener iMapViewListener, MapViewHolder<?> vh5, int i3, MapItem mapItem, int i16) {
            Intrinsics.checkNotNullParameter(vh5, "vh");
        }

        public static void onInVisible(IMapViewListener iMapViewListener, MapViewHolder<?> vh5, int i3, MapItem mapItem) {
            Intrinsics.checkNotNullParameter(vh5, "vh");
        }

        public static void onItemBind(IMapViewListener iMapViewListener, MapViewHolder<?> vh5, int i3, MapItem mapItem) {
            Intrinsics.checkNotNullParameter(vh5, "vh");
        }

        public static void onItemRecycled(IMapViewListener iMapViewListener, MapViewHolder<?> vh5, int i3, MapItem mapItem) {
            Intrinsics.checkNotNullParameter(vh5, "vh");
        }

        public static void onVisible(IMapViewListener iMapViewListener, MapViewHolder<?> vh5, int i3, MapItem mapItem) {
            Intrinsics.checkNotNullParameter(vh5, "vh");
        }

        public static void onItemBind(IMapViewListener iMapViewListener, MapViewHolder<?> vh5, int i3, MapItem mapItem, int i16) {
            Intrinsics.checkNotNullParameter(vh5, "vh");
        }

        public static /* synthetic */ void onItemRecordCover$default(IMapViewListener iMapViewListener, MapItem mapItem, Object obj, int i3, Object obj2) {
            if (obj2 == null) {
                if ((i3 & 2) != 0) {
                    obj = null;
                }
                iMapViewListener.onItemRecordCover(mapItem, obj);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onItemRecordCover");
        }

        public static /* synthetic */ void onItemClicked$default(IMapViewListener iMapViewListener, MapViewHolder mapViewHolder, int i3, MapItem mapItem, int i16, Object obj, int i17, Object obj2) {
            if (obj2 == null) {
                if ((i17 & 16) != 0) {
                    obj = null;
                }
                iMapViewListener.onItemClicked(mapViewHolder, i3, mapItem, i16, obj);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onItemClicked");
        }

        public static void onMapSizeInitReady(IMapViewListener iMapViewListener) {
        }

        public static void onMapZoomEnd(IMapViewListener iMapViewListener, int i3, float f16, boolean z16) {
        }
    }

    void onCenterScaled(boolean isScaleToCenter, View view, int index, MapItem data);

    void onDoubleClick(MapViewHolder<?> vh5, int index, MapItem data, int viewId);

    void onInVisible(MapViewHolder<?> vh5, int index, MapItem data);

    void onItemBind(MapViewHolder<?> vh5, int index, MapItem data);

    void onItemBind(MapViewHolder<?> vh5, int index, MapItem data, int event);

    void onItemClicked(MapViewHolder<?> vh5, int index, MapItem data, int viewId, Object extra);

    void onItemLongClick(MapViewHolder<?> vh5, int index, MapItem data, int viewId);

    void onItemRecordCover(MapItem data, Object extra);

    void onItemRecycled(MapViewHolder<?> vh5, int index, MapItem data);

    void onMapSizeInitReady();

    void onMapZoom(boolean isZoomIn);

    void onMapZoomEnd(int zoomLevel, float scale, boolean isZoomIn);

    void onRoleAdded(List<MoveItem> data);

    void onRoleRemoved(List<String> data);

    void onStartRecord(Resource resource, IResourceCallback callback);

    void onVisible(MapViewHolder<?> vh5, int index, MapItem data);

    void onZoomOverOut(MapViewHolder<?> vh5, int index, MapItem data);
}
