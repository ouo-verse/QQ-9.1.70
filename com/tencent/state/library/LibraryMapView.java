package com.tencent.state.library;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.map.IMapLocator;
import com.tencent.state.map.IMapLocatorKt;
import com.tencent.state.map.IMapPlayManager;
import com.tencent.state.map.IMapViewListener;
import com.tencent.state.map.IMapViewUpdater;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewConfig;
import com.tencent.state.square.avatar.PlayerSourceHelper;
import com.tencent.state.square.filamentmap.IFilamentMapController;
import com.tencent.state.square.filamentmap.SquareFilamentMapView;
import com.tencent.state.square.filamentmap.SquareFilamentViewController;
import com.tencent.state.template.map.TemplateMapView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ&\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u001e\u0010\u0017\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\u001e\u0010\u001b\u001a\u00020\u001a2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\"\u001a\u00020\u000bH\u0014\u00a8\u0006#"}, d2 = {"Lcom/tencent/state/library/LibraryMapView;", "Lcom/tencent/state/template/map/TemplateMapView;", "Lcom/tencent/state/library/LibraryMapAdapter;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initialize", "", "dataList", "", "Lcom/tencent/state/map/MapItem;", DownloadInfo.spKey_Config, "Lcom/tencent/state/map/MapViewConfig;", "listener", "Lcom/tencent/state/map/IMapViewListener;", "onCreateFilamentMapViewUpdater", "Lcom/tencent/state/square/filamentmap/IFilamentMapController;", "filamentMap", "Lcom/tencent/state/square/filamentmap/SquareFilamentMapView;", "onCreateMapAdapter", "", "locator", "Lcom/tencent/state/map/IMapLocator;", "onCreateMapLocator", "onCreateMapViewUpdater", "Lcom/tencent/state/map/IMapViewUpdater;", "adapter", "Lcom/tencent/state/map/MapAdapter;", "rpm", "Lcom/tencent/state/map/IMapPlayManager;", "onMapSizeInitReadyAction", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryMapView extends TemplateMapView<LibraryMapAdapter> {
    public LibraryMapView(Context context) {
        this(context, null, 0, 6, null);
    }

    @Override // com.tencent.state.map.BaseMapView
    public void initialize(List<? extends MapItem> dataList, MapViewConfig config, IMapViewListener listener) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        super.initialize(dataList, config, listener);
        getContainer().setScaleX(0.8f);
        getContainer().setScaleY(0.8f);
        getScaleState().setCurrentZoomRatio(0.8f);
        IMapLocator locator = getLocator();
        if (locator != null) {
            IMapLocatorKt.updateViewPort(locator, 0.8f);
        }
    }

    @Override // com.tencent.state.map.BaseMapView
    public /* bridge */ /* synthetic */ MapAdapter onCreateMapAdapter(List list, IMapLocator iMapLocator) {
        return onCreateMapAdapter((List<MapItem>) list, iMapLocator);
    }

    @Override // com.tencent.state.map.BaseMapView
    protected IMapLocator onCreateMapLocator(List<MapItem> dataList, MapViewConfig config) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(config, "config");
        return new LibraryServerLocator(config, dataList);
    }

    @Override // com.tencent.state.map.BaseMapView
    protected IMapViewUpdater onCreateMapViewUpdater(MapAdapter adapter, IMapPlayManager rpm, IMapLocator locator) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(rpm, "rpm");
        Intrinsics.checkNotNullParameter(locator, "locator");
        return new LibraryViewUpdater(adapter, rpm);
    }

    @Override // com.tencent.state.map.BaseMapView
    protected void onMapSizeInitReadyAction() {
        PlayerSourceHelper.INSTANCE.setMapZoomLevel(3);
    }

    public LibraryMapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    @Override // com.tencent.state.map.BaseMapView
    protected LibraryMapAdapter onCreateMapAdapter(List<MapItem> dataList, IMapLocator locator) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(locator, "locator");
        return new LibraryMapAdapter(dataList);
    }

    public /* synthetic */ LibraryMapView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryMapView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.state.map.BaseMapView
    protected IFilamentMapController onCreateFilamentMapViewUpdater(SquareFilamentMapView filamentMap) {
        Function1 function1 = null;
        byte b16 = 0;
        if (filamentMap != null) {
            return new SquareFilamentViewController(filamentMap, function1, 2, b16 == true ? 1 : 0);
        }
        return null;
    }
}
