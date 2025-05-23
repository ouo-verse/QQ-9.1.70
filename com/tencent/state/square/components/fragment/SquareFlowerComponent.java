package com.tencent.state.square.components.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.map.MapData;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.square.ISquareViewUpdater;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareMapViewModel;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.data.SquareAvatarExtra;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.flower.FlowerDisplayFragment;
import com.tencent.state.square.flower.FlowerGotEvent;
import com.tencent.state.square.flower.FlowerSyncEvent;
import com.tencent.state.square.flower.data.MedalData;
import com.tencent.state.utils.VMUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0004\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\u001e\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0002J,\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J<\u0010\u001a\u001a\u00020\f2\u000e\u0010\u001b\u001a\n\u0012\u0002\b\u00030\u001cj\u0002`\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\r\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005\u00a8\u0006%"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareFlowerComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "flowerEventReceiver", "com/tencent/state/square/components/fragment/SquareFlowerComponent$flowerEventReceiver$1", "Lcom/tencent/state/square/components/fragment/SquareFlowerComponent$flowerEventReceiver$1;", "getMeData", "Lcom/tencent/state/square/data/SquareAvatarItem;", "getUserData", "uin", "", "gotoFlowerDisplayPage", "", "data", "needPlayAnimate", "", "onFragmentViewCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "v", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFragmentViewDestroyed", "onItemClicked", "vh", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "index", "", "Lcom/tencent/state/map/MapItem;", "viewId", "extra", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareFlowerComponent extends SquareBaseComponent {
    private static final String TAG = "SquareFlowerComponent";
    private final SquareFlowerComponent$flowerEventReceiver$1 flowerEventReceiver = new SimpleEventReceiver<FlowerSyncEvent>() { // from class: com.tencent.state.square.components.fragment.SquareFlowerComponent$flowerEventReceiver$1
        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(SimpleBaseEvent event) {
            SquareAvatarItem userData;
            SquareAvatarItem userData2;
            SquareAvatarItem userData3;
            ISquareViewUpdater updater;
            SquareAvatarExtra extra;
            SquareAvatarExtra extra2;
            SquareAvatarExtra extra3;
            SquareAvatarItem userData4;
            SquareAvatarExtra extra4;
            SquareAvatarItem userData5;
            SquareAvatarItem userData6;
            ISquareViewUpdater updater2;
            SquareAvatarExtra extra5;
            SquareAvatarExtra extra6;
            SquareBaseKt.getSquareLog().i("SquareFlowerComponent", "[AvatarViewHolder] onReceive: " + event);
            if (event instanceof FlowerSyncEvent) {
                FlowerSyncEvent flowerSyncEvent = (FlowerSyncEvent) event;
                userData5 = SquareFlowerComponent.this.getUserData(flowerSyncEvent.getUin());
                if (userData5 != null && (extra6 = userData5.getExtra()) != null) {
                    extra6.setFlowerCount(flowerSyncEvent.getFlowerCount());
                }
                userData6 = SquareFlowerComponent.this.getUserData(flowerSyncEvent.getUin());
                if (userData6 != null && (extra5 = userData6.getExtra()) != null) {
                    extra5.setFlowerMedal(flowerSyncEvent.getFlowerMedal());
                }
                SquareView mapView = SquareFlowerComponent.this.getMapView();
                if (mapView == null || (updater2 = mapView.getUpdater()) == null) {
                    return;
                }
                updater2.updateFlowerInfo(flowerSyncEvent.getUin(), flowerSyncEvent.getFlowerCount(), flowerSyncEvent.getFlowerMedal());
                return;
            }
            if (event instanceof FlowerGotEvent) {
                FlowerGotEvent flowerGotEvent = (FlowerGotEvent) event;
                userData = SquareFlowerComponent.this.getUserData(flowerGotEvent.getUin());
                int i3 = 0;
                if (userData != null && (extra3 = userData.getExtra()) != null) {
                    userData4 = SquareFlowerComponent.this.getUserData(flowerGotEvent.getUin());
                    extra3.setFlowerCount(((userData4 == null || (extra4 = userData4.getExtra()) == null) ? 0 : extra4.getFlowerCount()) + flowerGotEvent.getCount());
                }
                userData2 = SquareFlowerComponent.this.getUserData(flowerGotEvent.getUin());
                if (userData2 != null && (extra2 = userData2.getExtra()) != null) {
                    i3 = extra2.getFlowerCount();
                }
                userData3 = SquareFlowerComponent.this.getUserData(flowerGotEvent.getUin());
                MedalData flowerMedal = (userData3 == null || (extra = userData3.getExtra()) == null) ? null : extra.getFlowerMedal();
                SquareView mapView2 = SquareFlowerComponent.this.getMapView();
                if (mapView2 == null || (updater = mapView2.getUpdater()) == null) {
                    return;
                }
                updater.updateFlowerInfo(flowerGotEvent.getUin(), i3, flowerMedal);
            }
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public ArrayList<Class<FlowerSyncEvent>> getEventClass() {
            ArrayList<Class<FlowerSyncEvent>> arrayListOf;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(FlowerSyncEvent.class);
            return arrayListOf;
        }
    };

    private final SquareAvatarItem getMeData() {
        SquareMapViewModel squareMapViewModel;
        MapItem mapItem;
        List<MapItem> dataList;
        Object obj;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (squareMapViewModel = (SquareMapViewModel) VMUtils.INSTANCE.safelyGet(fragment, SquareMapViewModel.class)) == null) {
            return null;
        }
        MapData value = squareMapViewModel.getData().getValue();
        if (value == null || (dataList = value.getDataList()) == null) {
            mapItem = null;
        } else {
            Iterator<T> it = dataList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                MapItem mapItem2 = (MapItem) obj;
                if ((mapItem2 instanceof SquareAvatarItem) && ((SquareAvatarItem) mapItem2).isMe()) {
                    break;
                }
            }
            mapItem = (MapItem) obj;
        }
        return (SquareAvatarItem) (mapItem instanceof SquareAvatarItem ? mapItem : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SquareAvatarItem getUserData(String uin) {
        SquareMapViewModel squareMapViewModel;
        MapItem mapItem;
        List<MapItem> dataList;
        Object obj;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (squareMapViewModel = (SquareMapViewModel) VMUtils.INSTANCE.safelyGet(fragment, SquareMapViewModel.class)) == null) {
            return null;
        }
        MapData value = squareMapViewModel.getData().getValue();
        if (value == null || (dataList = value.getDataList()) == null) {
            mapItem = null;
        } else {
            Iterator<T> it = dataList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                MapItem mapItem2 = (MapItem) obj;
                if ((mapItem2 instanceof SquareAvatarItem) && Intrinsics.areEqual(mapItem2.getUin(), uin)) {
                    break;
                }
            }
            mapItem = (MapItem) obj;
        }
        return (SquareAvatarItem) (mapItem instanceof SquareAvatarItem ? mapItem : null);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        SimpleEventBus.getInstance().registerReceiver(this.flowerEventReceiver);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        SimpleEventBus.getInstance().unRegisterReceiver(this.flowerEventReceiver);
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onItemClicked(MapViewHolder<?> vh5, int index, MapItem data, int viewId, Object extra) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        if (viewId != 14) {
            return;
        }
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) (!(data instanceof SquareAvatarItem) ? null : data);
        if (squareAvatarItem == null || !((SquareAvatarItem) data).isMe()) {
            return;
        }
        gotoFlowerDisplayPage$default(this, squareAvatarItem, false, 2, null);
    }

    private final void gotoFlowerDisplayPage(SquareAvatarItem data, boolean needPlayAnimate) {
        if (data == null) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "getMeData null", null, 4, null);
            return;
        }
        VasBaseFragment fragment = getFragment();
        if (fragment != null) {
            fragment.pushFragment(FlowerDisplayFragment.INSTANCE.newInstance(data.getExtra().getFlowerCount(), data.getPlayableSource(), 1));
        }
    }

    static /* synthetic */ void gotoFlowerDisplayPage$default(SquareFlowerComponent squareFlowerComponent, SquareAvatarItem squareAvatarItem, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            squareAvatarItem = squareFlowerComponent.getMeData();
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        squareFlowerComponent.gotoFlowerDisplayPage(squareAvatarItem, z16);
    }
}
