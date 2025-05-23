package com.tencent.state.square.components.fragment;

import android.os.Bundle;
import android.view.View;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.map.MapData;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.square.MoveItem;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.chatland.ChatLandFragment;
import com.tencent.state.square.components.fragment.ISquareEventListener;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.resource.IResourceCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J*\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J2\u0010\u0019\u001a\u00020\r2\u000e\u0010\u001a\u001a\n\u0012\u0002\b\u00030\u001bj\u0002`\u001c2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001d\u001a\u00020\u0016H\u0016J\b\u0010\u001e\u001a\u00020\rH\u0016J<\u0010\u001f\u001a\u00020\r2\u000e\u0010\u001a\u001a\n\u0012\u0002\b\u00030\u001bj\u0002`\u001c2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001d\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J2\u0010\"\u001a\u00020\r2\u000e\u0010\u001a\u001a\n\u0012\u0002\b\u00030\u001bj\u0002`\u001c2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001d\u001a\u00020\u0016H\u0016J\u001c\u0010#\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010$\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\rH\u0016J\u0012\u0010'\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u0012H\u0016J\u0016\u0010*\u001a\u00020\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016J\u0016\u0010-\u001a\u00020\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020.0+H\u0016J\u001a\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0016J*\u00104\u001a\u00020\r2\u000e\u0010\u001a\u001a\n\u0012\u0002\b\u00030\u001bj\u0002`\u001c2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u00065"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "Lcom/tencent/state/VasBaseFragmentComponent;", "Lcom/tencent/state/square/components/fragment/ISquareEventListener;", "()V", "mapView", "Lcom/tencent/state/square/SquareView;", "getMapView", "()Lcom/tencent/state/square/SquareView;", "squareFragment", "Lcom/tencent/state/square/SquareFragment;", "getSquareFragment", "()Lcom/tencent/state/square/SquareFragment;", "onBackFromDetail", "", "bundle", "Landroid/os/Bundle;", "onCenterScaled", "isScaleToCenter", "", "view", "Landroid/view/View;", "index", "", "data", "Lcom/tencent/state/map/MapItem;", "onDoubleClick", "vh", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "viewId", "onGoToDetail", "onItemClicked", "extra", "", "onItemLongClick", "onItemRecordCover", "onMapDataReceived", "Lcom/tencent/state/map/MapData;", "onMapSizeInitReady", "onMapWelcomeScaleAnimEnd", "onMapZoom", "isZoomIn", "onRoleAdded", "", "Lcom/tencent/state/square/MoveItem;", "onRoleRemoved", "", "onStartRecord", "resource", "Lcom/tencent/state/square/data/Resource;", "callback", "Lcom/tencent/state/square/resource/IResourceCallback;", "onZoomOverOut", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class SquareBaseComponent extends VasBaseFragmentComponent implements ISquareEventListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public final SquareView getMapView() {
        if (getFragment() instanceof SquareFragment) {
            VasBaseFragment fragment = getFragment();
            if (!(fragment instanceof SquareFragment)) {
                fragment = null;
            }
            SquareFragment squareFragment = (SquareFragment) fragment;
            if (squareFragment != null) {
                return squareFragment.getMapView();
            }
            return null;
        }
        if (!(getFragment() instanceof ChatLandFragment)) {
            return null;
        }
        VasBaseFragment fragment2 = getFragment();
        if (!(fragment2 instanceof ChatLandFragment)) {
            fragment2 = null;
        }
        ChatLandFragment chatLandFragment = (ChatLandFragment) fragment2;
        if (chatLandFragment != null) {
            return chatLandFragment.getMapView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SquareFragment getSquareFragment() {
        VasBaseFragment fragment = getFragment();
        if (!(fragment instanceof SquareFragment)) {
            fragment = null;
        }
        return (SquareFragment) fragment;
    }

    public void onBackFromDetail(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }

    public void onCenterScaled(boolean isScaleToCenter, View view, int index, MapItem data) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onDoubleClick(MapViewHolder<?> vh5, int index, MapItem data, int viewId) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
    }

    public void onFriendStatusPanelClosed() {
        ISquareEventListener.DefaultImpls.onFriendStatusPanelClosed(this);
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onInVisible(MapViewHolder<?> vh5, int i3, MapItem mapItem) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        ISquareEventListener.DefaultImpls.onInVisible(this, vh5, i3, mapItem);
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemBind(MapViewHolder<?> vh5, int i3, MapItem mapItem) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        ISquareEventListener.DefaultImpls.onItemBind(this, vh5, i3, mapItem);
    }

    public void onItemClicked(MapViewHolder<?> vh5, int index, MapItem data, int viewId, Object extra) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
    }

    public void onItemLongClick(MapViewHolder<?> vh5, int index, MapItem data, int viewId) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemRecycled(MapViewHolder<?> vh5, int i3, MapItem mapItem) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        ISquareEventListener.DefaultImpls.onItemRecycled(this, vh5, i3, mapItem);
    }

    public void onMapDataReceived(MapData data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onMapZoomEnd(int i3, float f16, boolean z16) {
        ISquareEventListener.DefaultImpls.onMapZoomEnd(this, i3, f16, z16);
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onRoleAdded(List<MoveItem> data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onRoleRemoved(List<String> data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onStartRecord(Resource resource, IResourceCallback callback) {
        Intrinsics.checkNotNullParameter(resource, "resource");
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onVisible(MapViewHolder<?> vh5, int i3, MapItem mapItem) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        ISquareEventListener.DefaultImpls.onVisible(this, vh5, i3, mapItem);
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onZoomOverOut(MapViewHolder<?> vh5, int index, MapItem data) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemBind(MapViewHolder<?> vh5, int i3, MapItem mapItem, int i16) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        ISquareEventListener.DefaultImpls.onItemBind(this, vh5, i3, mapItem, i16);
    }

    @Override // com.tencent.state.square.components.fragment.ISquareEventListener
    public void onGoToDetail() {
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onMapSizeInitReady() {
    }

    public void onMapWelcomeScaleAnimEnd(MapData data) {
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onMapZoom(boolean isZoomIn) {
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemRecordCover(MapItem data, Object extra) {
    }
}
