package com.tencent.state.square.components.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.map.IMapItemViewManager;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapData;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.square.ISquareViewUpdater;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareMapViewModel;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.SquareViewModel;
import com.tencent.state.square.avatar.PlayerSourceHelper;
import com.tencent.state.square.chatland.component.ChatLandComponent;
import com.tencent.state.square.data.SquareAvatarExtra;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareEntranceItem;
import com.tencent.state.square.data.SquareTroopItem;
import com.tencent.state.utils.VMUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\u000b\u001a\u00020\bJ,\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareHomeScreenComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "squareGroupVM", "Lcom/tencent/state/square/SquareViewModel;", "vm", "Lcom/tencent/state/square/SquareMapViewModel;", "bindLastView", "", "from", "", "initialize", "onFragmentViewCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "v", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onMapDataReceived", "data", "Lcom/tencent/state/map/MapData;", "onMapZoomEnd", "zoomLevel", "", "scale", "", "isZoomIn", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareHomeScreenComponent extends SquareBaseComponent {
    private static final String TAG = "SquareHomeScreenComponent";
    private SquareViewModel squareGroupVM;
    private SquareMapViewModel vm;

    /* JADX INFO: Access modifiers changed from: private */
    public final void bindLastView(String from) {
        IMapItemViewManager screenViewManager;
        Set<Integer> inScreenIndexSet;
        MapAdapter adapter;
        MapItem itemData;
        SquareView mapView;
        MapViewHolder<?> viewHolder;
        LiveData<Boolean> isScaleAnimDone;
        SquareMapViewModel squareMapViewModel = this.vm;
        if (squareMapViewModel != null && !squareMapViewModel.checkCacheSceneNetworkData()) {
            SquareBaseKt.getSquareLog().i(TAG, "bindLastView fail, checkCacheSceneNetworkData = false, from=" + from);
            return;
        }
        SquareViewModel squareViewModel = this.squareGroupVM;
        if (Intrinsics.areEqual((squareViewModel == null || (isScaleAnimDone = squareViewModel.isScaleAnimDone()) == null) ? null : isScaleAnimDone.getValue(), Boolean.FALSE)) {
            SquareBaseKt.getSquareLog().i(TAG, "bindLastView fail, isScaleAnimDone = false, from=" + from);
            return;
        }
        VasBaseFragment fragment = getFragment();
        SquareFragment squareFragment = (SquareFragment) (fragment instanceof SquareFragment ? fragment : null);
        if (squareFragment != null && (screenViewManager = squareFragment.getScreenViewManager()) != null && (inScreenIndexSet = screenViewManager.getInScreenIndexSet()) != null) {
            Iterator<T> it = inScreenIndexSet.iterator();
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                SquareView mapView2 = getMapView();
                if (mapView2 != null && (adapter = mapView2.getAdapter()) != null && (itemData = adapter.getItemData(intValue)) != null && (mapView = getMapView()) != null && (viewHolder = mapView.getViewHolder(intValue)) != null) {
                    viewHolder.onFirstScreenCompleted(itemData, intValue);
                }
            }
        }
        SquareBaseKt.getSquareLog().i(TAG, "bindLastView, from=" + from);
    }

    public final void initialize() {
        LiveData<MapData> newData;
        LiveData<Boolean> isScaleAnimDone;
        VasBaseFragment fragment = getFragment();
        if (fragment != null) {
            SquareViewModel squareViewModel = this.squareGroupVM;
            if (squareViewModel != null && (isScaleAnimDone = squareViewModel.isScaleAnimDone()) != null) {
                isScaleAnimDone.observe(fragment, new Observer<Boolean>() { // from class: com.tencent.state.square.components.fragment.SquareHomeScreenComponent$initialize$1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Boolean isDone) {
                        SquareBaseKt.getSquareLog().i("SquareHomeScreenComponent", "isScaleAnimDone " + isDone);
                        Intrinsics.checkNotNullExpressionValue(isDone, "isDone");
                        if (isDone.booleanValue()) {
                            SquareHomeScreenComponent.this.bindLastView("isScaleAnimDone");
                            SquareHomeScreenComponent squareHomeScreenComponent = SquareHomeScreenComponent.this;
                            AnonymousClass1 anonymousClass1 = new Function1<ChatLandComponent<SquareView, SquareMapViewModel>, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareHomeScreenComponent$initialize$1.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(ChatLandComponent<SquareView, SquareMapViewModel> chatLandComponent) {
                                    invoke2(chatLandComponent);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(ChatLandComponent<SquareView, SquareMapViewModel> it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    it.initialize();
                                }
                            };
                            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) squareHomeScreenComponent).fragment;
                            if (vasBaseFragment != null) {
                                vasBaseFragment.forEachComponent(ChatLandComponent.class, null, null, anonymousClass1);
                            }
                            SquareHomeScreenComponent squareHomeScreenComponent2 = SquareHomeScreenComponent.this;
                            Function1<ISquareEventListener, Unit> function1 = new Function1<ISquareEventListener, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareHomeScreenComponent$initialize$1.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(ISquareEventListener iSquareEventListener) {
                                    invoke2(iSquareEventListener);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(ISquareEventListener it) {
                                    SquareMapViewModel squareMapViewModel;
                                    LiveData<MapData> data;
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    squareMapViewModel = SquareHomeScreenComponent.this.vm;
                                    it.onMapWelcomeScaleAnimEnd((squareMapViewModel == null || (data = squareMapViewModel.getData()) == null) ? null : data.getValue());
                                }
                            };
                            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) squareHomeScreenComponent2).fragment;
                            if (vasBaseFragment2 != null) {
                                vasBaseFragment2.forEachComponent(ISquareEventListener.class, null, null, function1);
                            }
                        }
                    }
                });
            }
            SquareMapViewModel squareMapViewModel = this.vm;
            if (squareMapViewModel == null || (newData = squareMapViewModel.getNewData()) == null) {
                return;
            }
            newData.observe(fragment, new Observer<MapData>() { // from class: com.tencent.state.square.components.fragment.SquareHomeScreenComponent$initialize$2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(final MapData mapData) {
                    MapAdapter adapter;
                    MapItem itemData;
                    MapAdapter adapter2;
                    MapAdapter adapter3;
                    SquareBaseKt.getSquareLog().i("SquareHomeScreenComponent", "newData success");
                    SquareView mapView = SquareHomeScreenComponent.this.getMapView();
                    final ISquareViewUpdater updater = mapView != null ? mapView.getUpdater() : null;
                    SquareView mapView2 = SquareHomeScreenComponent.this.getMapView();
                    if (mapView2 != null && (adapter3 = mapView2.getAdapter()) != null) {
                        adapter3.forEachItemData(new Function2<Integer, MapItem, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareHomeScreenComponent$initialize$2.1
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
                                boolean z16;
                                ISquareViewUpdater iSquareViewUpdater;
                                SquareAvatarExtra extra;
                                boolean z17 = mapItem instanceof SquareAvatarItem;
                                if (z17 || (mapItem instanceof SquareTroopItem) || (mapItem instanceof SquareEntranceItem)) {
                                    String uin = mapItem.getUin();
                                    int type = mapItem.getType();
                                    List<MapItem> dataList = MapData.this.getDataList();
                                    if (!(dataList instanceof Collection) || !dataList.isEmpty()) {
                                        for (MapItem mapItem2 : dataList) {
                                            if (Intrinsics.areEqual(mapItem2.getUin(), uin) && mapItem2.getType() == type) {
                                                z16 = false;
                                                break;
                                            }
                                        }
                                    }
                                    z16 = true;
                                    if (z16 && (iSquareViewUpdater = updater) != null) {
                                        iSquareViewUpdater.hide(uin, type, true);
                                    }
                                }
                                SquareAvatarItem squareAvatarItem = (SquareAvatarItem) (!z17 ? null : mapItem);
                                if (squareAvatarItem != null && (extra = squareAvatarItem.getExtra()) != null) {
                                    extra.setNeedIntimateAnim(true);
                                }
                                if (mapItem != null) {
                                    mapItem.setFromCache(false);
                                }
                            }
                        });
                    }
                    for (MapItem mapItem : mapData.getDataList()) {
                        if ((mapItem instanceof SquareAvatarItem) || (mapItem instanceof SquareTroopItem) || (mapItem instanceof SquareEntranceItem)) {
                            SquareView mapView3 = SquareHomeScreenComponent.this.getMapView();
                            int indexOf = (mapView3 == null || (adapter2 = mapView3.getAdapter()) == null) ? -1 : adapter2.indexOf(mapItem.getUin(), mapItem.getType());
                            if (indexOf != -1) {
                                SquareView mapView4 = SquareHomeScreenComponent.this.getMapView();
                                if (mapView4 != null && (adapter = mapView4.getAdapter()) != null && (itemData = adapter.getItemData(indexOf)) != null && itemData.canUpdate(mapItem) && updater != null) {
                                    updater.updateItem(indexOf, mapItem);
                                }
                            } else if (updater != null) {
                                updater.appendItem(mapItem);
                            }
                        }
                    }
                    SquareHomeScreenComponent squareHomeScreenComponent = SquareHomeScreenComponent.this;
                    Function1<ISquareEventListener, Unit> function1 = new Function1<ISquareEventListener, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareHomeScreenComponent$initialize$2.3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ISquareEventListener iSquareEventListener) {
                            invoke2(iSquareEventListener);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ISquareEventListener it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            MapData newData2 = MapData.this;
                            Intrinsics.checkNotNullExpressionValue(newData2, "newData");
                            it.onMapDataReceived(newData2);
                        }
                    };
                    VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) squareHomeScreenComponent).fragment;
                    if (vasBaseFragment != null) {
                        vasBaseFragment.forEachComponent(ISquareEventListener.class, null, null, function1);
                    }
                }
            });
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        super.onFragmentViewCreated(fm5, f16, v3, savedInstanceState);
        VasBaseFragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            VMUtils vMUtils = VMUtils.INSTANCE;
            this.squareGroupVM = (SquareViewModel) vMUtils.safelyGet(parentFragment, SquareViewModel.class);
            this.vm = (SquareMapViewModel) vMUtils.safelyGet(f16, SquareMapViewModel.class);
            initialize();
        }
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.square.components.fragment.ISquareEventListener
    public void onMapDataReceived(MapData data) {
        LiveData<Boolean> isScaleAnimDone;
        Intrinsics.checkNotNullParameter(data, "data");
        SquareViewModel squareViewModel = this.squareGroupVM;
        if (Intrinsics.areEqual((squareViewModel == null || (isScaleAnimDone = squareViewModel.isScaleAnimDone()) == null) ? null : isScaleAnimDone.getValue(), Boolean.FALSE) || data.getIsReenter()) {
            return;
        }
        bindLastView("onMapDataReceived");
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onMapZoomEnd(int zoomLevel, float scale, boolean isZoomIn) {
        IMapItemViewManager screenViewManager;
        Set<Integer> inScreenIndexSet;
        MapViewHolder<?> viewHolder;
        LiveData<Boolean> isScaleAnimDone;
        PlayerSourceHelper.INSTANCE.setMapZoomLevel(zoomLevel);
        SquareViewModel squareViewModel = this.squareGroupVM;
        Boolean value = (squareViewModel == null || (isScaleAnimDone = squareViewModel.isScaleAnimDone()) == null) ? null : isScaleAnimDone.getValue();
        Boolean bool = Boolean.FALSE;
        if (Intrinsics.areEqual(value, bool)) {
            return;
        }
        if (isZoomIn && zoomLevel == 0) {
            bool = Boolean.TRUE;
        } else if (isZoomIn || zoomLevel != 1) {
            bool = null;
        }
        VasBaseFragment fragment = getFragment();
        SquareFragment squareFragment = (SquareFragment) (fragment instanceof SquareFragment ? fragment : null);
        if (squareFragment != null && (screenViewManager = squareFragment.getScreenViewManager()) != null && (inScreenIndexSet = screenViewManager.getInScreenIndexSet()) != null) {
            Iterator<T> it = inScreenIndexSet.iterator();
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                SquareView mapView = getMapView();
                if (mapView != null && (viewHolder = mapView.getViewHolder(intValue)) != null) {
                    viewHolder.onMapZoomEnd(zoomLevel, scale, isZoomIn, bool);
                }
            }
        }
        SquareBaseKt.getSquareLog().i(TAG, "onMapZoomEnd\uff1a zoomLevel: " + zoomLevel + ", isZoomIn: " + isZoomIn);
    }
}
