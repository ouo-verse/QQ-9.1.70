package com.tencent.state.square.chatland.component.share;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.square.MoveItem;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.resource.IResourceCallback;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.SeatButtonState;
import com.tencent.state.template.data.User;
import com.tencent.state.template.map.component.ITemplateMapEvent;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J<\u0010\u0012\u001a\u00020\u00052\u000e\u0010\u0013\u001a\n\u0012\u0002\b\u00030\u0014j\u0002`\u00152\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J2\u0010\u0019\u001a\u00020\u00052\u000e\u0010\u0013\u001a\n\u0012\u0002\b\u00030\u0014j\u0002`\u00152\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u001c\u0010\u001a\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0016\u0010!\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J\u0016\u0010$\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020%0\"H\u0016J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(H\u0016J\u001a\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J*\u0010.\u001a\u00020\u00052\u000e\u0010\u0013\u001a\n\u0012\u0002\b\u00030\u0014j\u0002`\u00152\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006/"}, d2 = {"Lcom/tencent/state/square/chatland/component/share/ChatLandShareEventCopyComponent;", "Lcom/tencent/state/template/map/component/ITemplateMapEvent;", "Lcom/tencent/state/VasBaseFragmentComponent;", "()V", "onCalendarButtonClicked", "", "onCenterScaled", "isScaleToCenter", "", "view", "Landroid/view/View;", "index", "", "data", "Lcom/tencent/state/map/MapItem;", "onEnterRoom", "info", "Lcom/tencent/state/template/data/EnterRoomInfo;", "onItemClicked", "vh", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "viewId", "extra", "", "onItemLongClick", "onItemRecordCover", "onMapZoom", "isZoomIn", "onMeFocusEnd", "onMeFocusStart", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "onRoleAdded", "", "Lcom/tencent/state/square/MoveItem;", "onRoleRemoved", "", "onSeatButtonClicked", "state", "Lcom/tencent/state/template/data/SeatButtonState;", "onStartRecord", "resource", "Lcom/tencent/state/square/data/Resource;", "callback", "Lcom/tencent/state/square/resource/IResourceCallback;", "onZoomOverOut", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandShareEventCopyComponent extends VasBaseFragmentComponent implements ITemplateMapEvent {
    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public boolean onBackPressed(FragmentManager fragmentManager, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        return ITemplateMapEvent.DefaultImpls.onBackPressed(this, fragmentManager, f16);
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
    public void onEnterRoom(final EnterRoomInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        Function1<ChatLandShareBaseComponent, Unit> function1 = new Function1<ChatLandShareBaseComponent, Unit>() { // from class: com.tencent.state.square.chatland.component.share.ChatLandShareEventCopyComponent$onEnterRoom$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChatLandShareBaseComponent chatLandShareBaseComponent) {
                invoke2(chatLandShareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ChatLandShareBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onEnterRoom(EnterRoomInfo.this);
            }
        };
        VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
        if (vasBaseFragment != null) {
            vasBaseFragment.forEachComponent(ChatLandShareBaseComponent.class, null, null, function1);
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentActivityCreated(FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(f16, "f");
        ITemplateMapEvent.DefaultImpls.onFragmentActivityCreated(this, fragmentManager, f16, bundle);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentCreated(FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(f16, "f");
        ITemplateMapEvent.DefaultImpls.onFragmentCreated(this, fragmentManager, f16, bundle);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentPaused(FragmentManager fragmentManager, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        ITemplateMapEvent.DefaultImpls.onFragmentPaused(this, fragmentManager, f16);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentPreCreated(FragmentManager fragmentManager, Fragment f16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(f16, "f");
        ITemplateMapEvent.DefaultImpls.onFragmentPreCreated(this, fragmentManager, f16, bundle);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentResumed(FragmentManager fragmentManager, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        ITemplateMapEvent.DefaultImpls.onFragmentResumed(this, fragmentManager, f16);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentSaveInstanceState(FragmentManager fragmentManager, Fragment f16, Bundle outState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(outState, "outState");
        ITemplateMapEvent.DefaultImpls.onFragmentSaveInstanceState(this, fragmentManager, f16, outState);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentStarted(FragmentManager fragmentManager, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        ITemplateMapEvent.DefaultImpls.onFragmentStarted(this, fragmentManager, f16);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentStopped(FragmentManager fragmentManager, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        ITemplateMapEvent.DefaultImpls.onFragmentStopped(this, fragmentManager, f16);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment f16, View v3, Bundle bundle) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        ITemplateMapEvent.DefaultImpls.onFragmentViewCreated(this, fragmentManager, f16, v3, bundle);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        ITemplateMapEvent.DefaultImpls.onFragmentViewDestroyed(this, fragmentManager, f16);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentVisibilityChanged(FragmentManager fragmentManager, Fragment f16, boolean z16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        ITemplateMapEvent.DefaultImpls.onFragmentVisibilityChanged(this, fragmentManager, f16, z16);
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

    @Override // com.tencent.state.template.map.component.ITemplateMapEvent
    public void onMeFocusEnd() {
        ChatLandShareEventCopyComponent$onMeFocusEnd$1 chatLandShareEventCopyComponent$onMeFocusEnd$1 = new Function1<ChatLandShareBaseComponent, Unit>() { // from class: com.tencent.state.square.chatland.component.share.ChatLandShareEventCopyComponent$onMeFocusEnd$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChatLandShareBaseComponent chatLandShareBaseComponent) {
                invoke2(chatLandShareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ChatLandShareBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onMeFocusEnd();
            }
        };
        VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
        if (vasBaseFragment != null) {
            vasBaseFragment.forEachComponent(ChatLandShareBaseComponent.class, null, null, chatLandShareEventCopyComponent$onMeFocusEnd$1);
        }
    }

    @Override // com.tencent.state.template.map.component.ITemplateMapEvent
    public void onMeFocusStart(final User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        Function1<ChatLandShareBaseComponent, Unit> function1 = new Function1<ChatLandShareBaseComponent, Unit>() { // from class: com.tencent.state.square.chatland.component.share.ChatLandShareEventCopyComponent$onMeFocusStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChatLandShareBaseComponent chatLandShareBaseComponent) {
                invoke2(chatLandShareBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ChatLandShareBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onMeFocusStart(User.this);
            }
        };
        VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
        if (vasBaseFragment != null) {
            vasBaseFragment.forEachComponent(ChatLandShareBaseComponent.class, null, null, function1);
        }
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

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemBind(MapViewHolder<?> vh5, int i3, MapItem mapItem, int i16) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        ITemplateMapEvent.DefaultImpls.onItemBind(this, vh5, i3, mapItem, i16);
    }

    @Override // com.tencent.state.template.map.component.ITemplateMapEvent
    public void onCalendarButtonClicked() {
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onMapZoom(boolean isZoomIn) {
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemRecordCover(MapItem data, Object extra) {
    }
}
