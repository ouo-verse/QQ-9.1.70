package com.tencent.state.template.map.component;

import android.view.View;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.square.MoveItem;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.resource.IResourceCallback;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.SeatButtonState;
import com.tencent.state.template.data.User;
import com.tencent.state.template.fragment.TemplateBaseComponent;
import com.tencent.state.template.map.TemplateMapFragment;
import com.tencent.state.template.map.TemplateMapView;
import com.tencent.state.template.map.component.ITemplateMapEvent;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J*\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J<\u0010\u001a\u001a\u00020\r2\u000e\u0010\u001b\u001a\n\u0012\u0002\b\u00030\u001cj\u0002`\u001d2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001e\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J2\u0010!\u001a\u00020\r2\u000e\u0010\u001b\u001a\n\u0012\u0002\b\u00030\u001cj\u0002`\u001d2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001e\u001a\u00020\u0014H\u0016J\u001c\u0010\"\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0010H\u0016J\b\u0010%\u001a\u00020\rH\u0016J\u0010\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020(H\u0016J\u0016\u0010)\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020+0*H\u0016J\u0016\u0010,\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020-0*H\u0016J\u0010\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u000200H\u0016J\u001a\u00101\u001a\u00020\r2\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105H\u0016J*\u00106\u001a\u00020\r2\u000e\u0010\u001b\u001a\n\u0012\u0002\b\u00030\u001cj\u0002`\u001d2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00058DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\t8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u00067"}, d2 = {"Lcom/tencent/state/template/map/component/TemplateMapBaseComponent;", "Lcom/tencent/state/template/fragment/TemplateBaseComponent;", "Lcom/tencent/state/template/map/component/ITemplateMapEvent;", "()V", "mapView", "Lcom/tencent/state/template/map/TemplateMapView;", "getMapView", "()Lcom/tencent/state/template/map/TemplateMapView;", "templateFragment", "Lcom/tencent/state/template/map/TemplateMapFragment;", "getTemplateFragment", "()Lcom/tencent/state/template/map/TemplateMapFragment;", "onCalendarButtonClicked", "", "onCenterScaled", "isScaleToCenter", "", "view", "Landroid/view/View;", "index", "", "data", "Lcom/tencent/state/map/MapItem;", "onEnterRoom", "info", "Lcom/tencent/state/template/data/EnterRoomInfo;", "onItemClicked", "vh", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "viewId", "extra", "", "onItemLongClick", "onItemRecordCover", "onMapZoom", "isZoomIn", "onMeFocusEnd", "onMeFocusStart", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "onRoleAdded", "", "Lcom/tencent/state/square/MoveItem;", "onRoleRemoved", "", "onSeatButtonClicked", "state", "Lcom/tencent/state/template/data/SeatButtonState;", "onStartRecord", "resource", "Lcom/tencent/state/square/data/Resource;", "callback", "Lcom/tencent/state/square/resource/IResourceCallback;", "onZoomOverOut", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class TemplateMapBaseComponent extends TemplateBaseComponent implements ITemplateMapEvent {
    /* JADX INFO: Access modifiers changed from: protected */
    public final TemplateMapView<?> getMapView() {
        TemplateMapFragment<?, ?> templateFragment = getTemplateFragment();
        Object mapView = templateFragment != null ? templateFragment.getMapView() : null;
        return (TemplateMapView) (mapView instanceof TemplateMapView ? mapView : null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TemplateMapFragment<?, ?> getTemplateFragment() {
        VasBaseFragment fragment = getFragment();
        if (!(fragment instanceof TemplateMapFragment)) {
            fragment = null;
        }
        return (TemplateMapFragment) fragment;
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onCenterScaled(boolean isScaleToCenter, View view, int index, MapItem data) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onDoubleClick(MapViewHolder<?> vh5, int i3, MapItem mapItem, int i16) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        ITemplateMapEvent.DefaultImpls.onDoubleClick(this, vh5, i3, mapItem, i16);
    }

    public void onEnterRoom(EnterRoomInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onInVisible(MapViewHolder<?> vh5, int i3, MapItem mapItem) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        ITemplateMapEvent.DefaultImpls.onInVisible(this, vh5, i3, mapItem);
    }

    public void onItemBind(MapViewHolder<?> vh5, int i3, MapItem mapItem) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        ITemplateMapEvent.DefaultImpls.onItemBind(this, vh5, i3, mapItem);
    }

    public void onItemClicked(MapViewHolder<?> vh5, int index, MapItem data, int viewId, Object extra) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemLongClick(MapViewHolder<?> vh5, int index, MapItem data, int viewId) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemRecycled(MapViewHolder<?> vh5, int i3, MapItem mapItem) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        ITemplateMapEvent.DefaultImpls.onItemRecycled(this, vh5, i3, mapItem);
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onMapSizeInitReady() {
        ITemplateMapEvent.DefaultImpls.onMapSizeInitReady(this);
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onMapZoomEnd(int i3, float f16, boolean z16) {
        ITemplateMapEvent.DefaultImpls.onMapZoomEnd(this, i3, f16, z16);
    }

    public void onMeFocusStart(User user) {
        Intrinsics.checkNotNullParameter(user, "user");
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onRoleAdded(List<MoveItem> data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onRoleRemoved(List<String> data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public void onSeatButtonClicked(SeatButtonState state) {
        Intrinsics.checkNotNullParameter(state, "state");
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onStartRecord(Resource resource, IResourceCallback callback) {
        Intrinsics.checkNotNullParameter(resource, "resource");
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onVisible(MapViewHolder<?> vh5, int i3, MapItem mapItem) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        ITemplateMapEvent.DefaultImpls.onVisible(this, vh5, i3, mapItem);
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onZoomOverOut(MapViewHolder<?> vh5, int index, MapItem data) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemBind(MapViewHolder<?> vh5, int i3, MapItem mapItem, int i16) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        ITemplateMapEvent.DefaultImpls.onItemBind(this, vh5, i3, mapItem, i16);
    }

    public void onCalendarButtonClicked() {
    }

    public void onMeFocusEnd() {
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onMapZoom(boolean isZoomIn) {
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemRecordCover(MapItem data, Object extra) {
    }
}
