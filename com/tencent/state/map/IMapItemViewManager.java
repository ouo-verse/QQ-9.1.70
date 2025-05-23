package com.tencent.state.map;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import com.tencent.state.map.IMapDataIndexer;
import com.tencent.state.square.filamentmap.IFilamentMapController;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0004H&J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u0004H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\b\u0010\u001b\u001a\u00020\u0004H&J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H&J\u001c\u0010\u001e\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010\u001fj\u0004\u0018\u0001` 2\u0006\u0010\u000f\u001a\u00020\u0004H&J\b\u0010!\u001a\u00020\u0013H&J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0004H&J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$H&J\u0018\u0010%\u001a\u00020\u00172\u000e\u0010&\u001a\n\u0012\u0002\b\u00030\u001fj\u0002` H&J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0004H&J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u0006\u00a8\u0006*"}, d2 = {"Lcom/tencent/state/map/IMapItemViewManager;", "Lcom/tencent/state/map/IMapDataIndexer;", "inScreenIndexSet", "", "", "getInScreenIndexSet", "()Ljava/util/Set;", "indexViewList", "Landroid/util/SparseArray;", "Landroid/view/View;", "getIndexViewList", "()Landroid/util/SparseArray;", "visibleIndexSet", "getVisibleIndexSet", "addView", "index", "data", "Lcom/tencent/state/map/MapItem;", "checkLocationInScreen", "", "location", "Landroid/graphics/Rect;", "checkRecycleAndFill", "", "getCurrentZoomLevel", "getFilamentMapController", "Lcom/tencent/state/square/filamentmap/IFilamentMapController;", "getMeIndex", "getTypeItemCount", "type", "getViewHolder", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "getWelcomeScaleAnimDone", "isMostInScreen", "uin", "", "recycleView", "holder", "setViewChangedListener", "listener", "Lcom/tencent/state/map/IMapItemViewChangedListener;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public interface IMapItemViewManager extends IMapDataIndexer {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class DefaultImpls {
        public static int indexOf(IMapItemViewManager iMapItemViewManager, MapItem data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return IMapDataIndexer.DefaultImpls.indexOf(iMapItemViewManager, data);
        }

        public static int indexOfUnitType(IMapItemViewManager iMapItemViewManager, String uin, int i3) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            return IMapDataIndexer.DefaultImpls.indexOfUnitType(iMapItemViewManager, uin, i3);
        }

        public static int indexOf(IMapItemViewManager iMapItemViewManager, String uin, int i3) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            return IMapDataIndexer.DefaultImpls.indexOf(iMapItemViewManager, uin, i3);
        }

        public static int indexOf(IMapItemViewManager iMapItemViewManager, String uin, int i3, int i16) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            return IMapDataIndexer.DefaultImpls.indexOf(iMapItemViewManager, uin, i3, i16);
        }
    }

    View addView(int index);

    View addView(int index, MapItem data);

    boolean checkLocationInScreen(Rect location);

    void checkRecycleAndFill();

    int getCurrentZoomLevel();

    IFilamentMapController getFilamentMapController();

    Set<Integer> getInScreenIndexSet();

    SparseArray<View> getIndexViewList();

    int getMeIndex();

    int getTypeItemCount(int type);

    MapViewHolder<?> getViewHolder(int index);

    Set<Integer> getVisibleIndexSet();

    boolean getWelcomeScaleAnimDone();

    boolean isMostInScreen(int index);

    boolean isMostInScreen(String uin);

    void recycleView(int index);

    void recycleView(MapViewHolder<?> holder);

    void setViewChangedListener(IMapItemViewChangedListener listener);
}
