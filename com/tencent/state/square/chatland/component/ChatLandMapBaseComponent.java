package com.tencent.state.square.chatland.component;

import android.view.View;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.square.MoveItem;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.chatland.ChatLandFragment;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.chatland.data.ChatLandTableItem;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.resource.IResourceCallback;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.SeatButtonState;
import com.tencent.state.template.data.User;
import com.tencent.state.template.fragment.TemplateBaseComponent;
import com.tencent.state.template.map.component.ITemplateMapEvent;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0006\u0010\u0015\u001a\u00020\u0004J\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J*\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'H\u0016J<\u0010(\u001a\u00020\u001c2\u000e\u0010)\u001a\n\u0012\u0002\b\u00030*j\u0002`+2\u0006\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010,\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J2\u0010/\u001a\u00020\u001c2\u000e\u0010)\u001a\n\u0012\u0002\b\u00030*j\u0002`+2\u0006\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010,\u001a\u00020\u0004H\u0016J\u001c\u00100\u001a\u00020\u001c2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u0019H\u0016J\b\u00103\u001a\u00020\u001cH\u0016J\u0010\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u000206H\u0016J\u0016\u00107\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002080\u0013H\u0016J\u0016\u00109\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0016J\u0010\u0010:\u001a\u00020\u001c2\u0006\u0010;\u001a\u00020<H\u0016J\u001a\u0010=\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J*\u0010B\u001a\u00020\u001c2\u000e\u0010)\u001a\n\u0012\u0002\b\u00030*j\u0002`+2\u0006\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006C"}, d2 = {"Lcom/tencent/state/square/chatland/component/ChatLandMapBaseComponent;", "Lcom/tencent/state/template/fragment/TemplateBaseComponent;", "Lcom/tencent/state/template/map/component/ITemplateMapEvent;", "appId", "", "(I)V", "getAppId", "()I", "setAppId", "mapView", "Lcom/tencent/state/square/SquareView;", "getMapView", "()Lcom/tencent/state/square/SquareView;", "findAvatarItemByUin", "Lcom/tencent/state/square/chatland/data/ChatLandAvatarItem;", "uin", "", "findAvatarItemByUinInLands", "getCurrentAvailableTable", "", "Lcom/tencent/state/square/chatland/data/ChatLandTableItem;", "getCurrentUserCount", "getMeAvatarItem", "getMeAvatarItemInLands", "isMeSeated", "", "isMeSeatedInLands", "onBeforeMeEndFocus", "", "onCalendarButtonClicked", "onCenterScaled", "isScaleToCenter", "view", "Landroid/view/View;", "index", "data", "Lcom/tencent/state/map/MapItem;", "onEnterRoom", "info", "Lcom/tencent/state/template/data/EnterRoomInfo;", "onItemClicked", "vh", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "viewId", "extra", "", "onItemLongClick", "onItemRecordCover", "onMapZoom", "isZoomIn", "onMeFocusEnd", "onMeFocusStart", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "onRoleAdded", "Lcom/tencent/state/square/MoveItem;", "onRoleRemoved", "onSeatButtonClicked", "state", "Lcom/tencent/state/template/data/SeatButtonState;", "onStartRecord", "resource", "Lcom/tencent/state/square/data/Resource;", "callback", "Lcom/tencent/state/square/resource/IResourceCallback;", "onZoomOverOut", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public class ChatLandMapBaseComponent extends TemplateBaseComponent implements ITemplateMapEvent {
    private int appId;

    public ChatLandMapBaseComponent(int i3) {
        this.appId = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ChatLandAvatarItem findAvatarItemByUinInLands(final String uin) {
        MapAdapter adapter;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        SquareView mapView = getMapView();
        if (mapView != null && (adapter = mapView.getAdapter()) != null) {
            adapter.forEachItemData(new Function2<Integer, MapItem, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandMapBaseComponent$findAvatarItemByUinInLands$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, MapItem mapItem) {
                    invoke(num.intValue(), mapItem);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r3v1, types: [T, com.tencent.state.square.chatland.data.ChatLandAvatarItem] */
                public final void invoke(int i3, MapItem mapItem) {
                    ChatLandAvatarItem chatLandAvatarItem = (ChatLandAvatarItem) (!(mapItem instanceof ChatLandAvatarItem) ? null : mapItem);
                    if (chatLandAvatarItem == null || !Intrinsics.areEqual(chatLandAvatarItem.getUin(), uin)) {
                        return;
                    }
                    objectRef.element = (ChatLandAvatarItem) mapItem;
                }
            });
        }
        return (ChatLandAvatarItem) objectRef.element;
    }

    public final ChatLandAvatarItem findAvatarItemByUin(String uin) {
        MapAdapter adapter;
        int indexOf;
        MapAdapter adapter2;
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareView mapView = getMapView();
        if (mapView == null || (adapter = mapView.getAdapter()) == null || (indexOf = adapter.indexOf(uin, 10, getAppId())) == -1) {
            return null;
        }
        SquareView mapView2 = getMapView();
        MapItem itemData = (mapView2 == null || (adapter2 = mapView2.getAdapter()) == null) ? null : adapter2.getItemData(indexOf);
        return (ChatLandAvatarItem) (itemData instanceof ChatLandAvatarItem ? itemData : null);
    }

    @Override // com.tencent.state.template.fragment.TemplateBaseComponent
    public int getAppId() {
        return this.appId;
    }

    public final List<ChatLandTableItem> getCurrentAvailableTable() {
        MapAdapter adapter;
        final ArrayList arrayList = new ArrayList();
        SquareView mapView = getMapView();
        if (mapView != null && (adapter = mapView.getAdapter()) != null) {
            adapter.forEachItemData(new Function2<Integer, MapItem, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandMapBaseComponent$getCurrentAvailableTable$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, MapItem mapItem) {
                    invoke(num.intValue(), mapItem);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, MapItem mapItem) {
                    if (!(mapItem instanceof ChatLandTableItem)) {
                        mapItem = null;
                    }
                    ChatLandTableItem chatLandTableItem = (ChatLandTableItem) mapItem;
                    if (chatLandTableItem != null && chatLandTableItem.getAppId() == ChatLandMapBaseComponent.this.getAppId() && chatLandTableItem.getTable().isEmpty()) {
                        arrayList.add(chatLandTableItem);
                    }
                }
            });
        }
        return arrayList;
    }

    public final int getCurrentUserCount() {
        MapAdapter adapter;
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 0;
        SquareView mapView = getMapView();
        if (mapView != null && (adapter = mapView.getAdapter()) != null) {
            adapter.forEachItemData(new Function2<Integer, MapItem, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandMapBaseComponent$getCurrentUserCount$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, MapItem mapItem) {
                    invoke(num.intValue(), mapItem);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, MapItem mapItem) {
                    if (!(mapItem instanceof ChatLandAvatarItem)) {
                        mapItem = null;
                    }
                    ChatLandAvatarItem chatLandAvatarItem = (ChatLandAvatarItem) mapItem;
                    if (chatLandAvatarItem == null || chatLandAvatarItem.getAppId() != ChatLandMapBaseComponent.this.getAppId()) {
                        return;
                    }
                    intRef.element++;
                }
            });
        }
        return intRef.element;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SquareView getMapView() {
        VasBaseFragment fragment = getFragment();
        if (!(fragment instanceof SquareFragment)) {
            fragment = null;
        }
        SquareFragment squareFragment = (SquareFragment) fragment;
        SquareView mapView = squareFragment != null ? squareFragment.getMapView() : null;
        if (mapView != null) {
            return mapView;
        }
        VasBaseFragment fragment2 = getFragment();
        if (!(fragment2 instanceof ChatLandFragment)) {
            fragment2 = null;
        }
        ChatLandFragment chatLandFragment = (ChatLandFragment) fragment2;
        return chatLandFragment != null ? chatLandFragment.getMapView() : null;
    }

    public final ChatLandAvatarItem getMeAvatarItem() {
        return findAvatarItemByUin(SquareBaseKt.getSquareCommon().getCurrentAccountUin());
    }

    public final ChatLandAvatarItem getMeAvatarItemInLands() {
        return findAvatarItemByUinInLands(SquareBaseKt.getSquareCommon().getCurrentAccountUin());
    }

    public final boolean isMeSeated() {
        return getMeAvatarItem() != null;
    }

    public final boolean isMeSeatedInLands() {
        return getMeAvatarItemInLands() != null;
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

    @Override // com.tencent.state.template.map.component.ITemplateMapEvent
    public void onEnterRoom(EnterRoomInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onInVisible(MapViewHolder<?> vh5, int i3, MapItem mapItem) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        ITemplateMapEvent.DefaultImpls.onInVisible(this, vh5, i3, mapItem);
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemBind(MapViewHolder<?> vh5, int i3, MapItem mapItem) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        ITemplateMapEvent.DefaultImpls.onItemBind(this, vh5, i3, mapItem);
    }

    @Override // com.tencent.state.map.IMapViewListener
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

    @Override // com.tencent.state.template.map.component.ITemplateMapEvent
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

    public void setAppId(int i3) {
        this.appId = i3;
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemBind(MapViewHolder<?> vh5, int i3, MapItem mapItem, int i16) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        ITemplateMapEvent.DefaultImpls.onItemBind(this, vh5, i3, mapItem, i16);
    }

    public void onBeforeMeEndFocus() {
    }

    @Override // com.tencent.state.template.map.component.ITemplateMapEvent
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
