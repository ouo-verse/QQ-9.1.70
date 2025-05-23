package com.tencent.state.square.components.fragment;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.VasBaseGroupFragment;
import com.tencent.state.map.IMapItemViewManager;
import com.tencent.state.map.IMapViewManipulator;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapItemController;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.SquareViewModel;
import com.tencent.state.square.api.p015const.LauncherConst;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.filamentmap.IFilamentMapController;
import com.tencent.state.utils.VMUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001a\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareScaleAnimComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "squareVM", "Lcom/tencent/state/square/SquareViewModel;", "getSquareVM", "()Lcom/tencent/state/square/SquareViewModel;", "squareVM$delegate", "Lkotlin/Lazy;", "checkNewFlagAnim", "", "defaultEnterSquare", "", "index", "", "onFragmentDestroyed", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "onMapSizeInitReady", "updateScaleAnimState", "updateScaleAnimStateVm", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareScaleAnimComponent extends SquareBaseComponent {
    private static final long DELAY_TIME = 880;
    private static final long NO_DELAY_TIME = 200;
    private static final String TAG = "SquareScaleAnimComponent";

    /* renamed from: squareVM$delegate, reason: from kotlin metadata */
    private final Lazy squareVM;

    public SquareScaleAnimComponent() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SquareViewModel>() { // from class: com.tencent.state.square.components.fragment.SquareScaleAnimComponent$squareVM$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SquareViewModel invoke() {
                VasBaseGroupFragment groupFragment;
                SquareFragment squareFragment = SquareScaleAnimComponent.this.getSquareFragment();
                if (squareFragment == null || (groupFragment = squareFragment.getGroupFragment()) == null) {
                    return null;
                }
                return (SquareViewModel) VMUtils.INSTANCE.safelyGet(groupFragment, SquareViewModel.class);
            }
        });
        this.squareVM = lazy;
    }

    private final boolean checkNewFlagAnim() {
        MapAdapter adapter;
        SquareFragment squareFragment = getSquareFragment();
        SquareView mapView = squareFragment != null ? squareFragment.getMapView() : null;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        if (mapView != null && (adapter = mapView.getAdapter()) != null) {
            adapter.forEachItemData(new Function2<Integer, MapItem, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareScaleAnimComponent$checkNewFlagAnim$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, MapItem mapItem) {
                    invoke(num.intValue(), mapItem);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, MapItem mapItem) {
                    if ((mapItem instanceof SquareAvatarItem) && ((SquareAvatarItem) mapItem).hasNewFlag(1)) {
                        Ref.BooleanRef.this.element = true;
                        SquareBaseKt.getSquareLog().i("SquareScaleAnimComponent", "checkNewFlagAnim: uin:" + mapItem.getUin() + ", name=" + ((SquareAvatarItem) mapItem).getNickName() + ", type=" + mapItem.getType());
                    }
                }
            });
        }
        return booleanRef.element;
    }

    private final void defaultEnterSquare(final int index) {
        SquareView mapView = getMapView();
        if (mapView != null) {
            mapView.post(new Runnable() { // from class: com.tencent.state.square.components.fragment.SquareScaleAnimComponent$defaultEnterSquare$1
                @Override // java.lang.Runnable
                public final void run() {
                    IMapViewManipulator manipulator;
                    SquareView mapView2 = SquareScaleAnimComponent.this.getMapView();
                    if (mapView2 != null && (manipulator = mapView2.getManipulator()) != null) {
                        manipulator.locateTo(index, 0, (Function1<? super Boolean, Unit>) null);
                    }
                    SquareScaleAnimComponent.this.updateScaleAnimStateVm();
                }
            });
        }
    }

    private final SquareViewModel getSquareVM() {
        return (SquareViewModel) this.squareVM.getValue();
    }

    private final void updateScaleAnimState() {
        String str;
        QBaseActivity activity = getActivity();
        if (activity != null) {
            SquareView mapView = getMapView();
            MapAdapter adapter = mapView != null ? mapView.getAdapter() : null;
            Intent intent = activity.getIntent();
            if (intent == null || (str = intent.getStringExtra(LauncherConst.KEY_LOCATE_TO_UIN)) == null) {
                str = "";
            }
            final int indexOf = ((str.length() == 0) || adapter == null) ? 0 : adapter.indexOf(str, 1);
            boolean checkNewFlagAnim = checkNewFlagAnim();
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            Square square = Square.INSTANCE;
            sb5.append(square.getConfig().getNeedScaleAnimation());
            sb5.append(" and isDelay ");
            sb5.append(checkNewFlagAnim);
            sb5.append(", uin: ");
            sb5.append(str);
            sb5.append(", index: ");
            sb5.append(indexOf);
            sb5.append(", mapView is null: ");
            sb5.append(getMapView() == null);
            squareLog.i(TAG, sb5.toString());
            if (square.getConfig().getNeedScaleAnimation()) {
                long j3 = checkNewFlagAnim ? DELAY_TIME : NO_DELAY_TIME;
                SquareView mapView2 = getMapView();
                if (mapView2 != null) {
                    mapView2.postDelayed(new Runnable() { // from class: com.tencent.state.square.components.fragment.SquareScaleAnimComponent$updateScaleAnimState$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            IMapViewManipulator manipulator;
                            SquareView mapView3 = SquareScaleAnimComponent.this.getMapView();
                            if (mapView3 == null || (manipulator = mapView3.getManipulator()) == null) {
                                return;
                            }
                            manipulator.scaleToTarget(indexOf, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareScaleAnimComponent$updateScaleAnimState$1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                    invoke(bool.booleanValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(boolean z16) {
                                    MapAdapter adapter2;
                                    MapItem itemData;
                                    SquareView mapView4;
                                    IFilamentMapController filamentMapController;
                                    SquareScaleAnimComponent.this.updateScaleAnimStateVm();
                                    SquareView mapView5 = SquareScaleAnimComponent.this.getMapView();
                                    if (mapView5 == null || (adapter2 = mapView5.getAdapter()) == null || (itemData = adapter2.getItemData(indexOf)) == null || (mapView4 = SquareScaleAnimComponent.this.getMapView()) == null || (filamentMapController = mapView4.getFilamentMapController()) == null) {
                                        return;
                                    }
                                    filamentMapController.resetItemLocation(itemData);
                                }
                            });
                        }
                    }, j3);
                    return;
                } else {
                    defaultEnterSquare(indexOf);
                    return;
                }
            }
            defaultEnterSquare(indexOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateScaleAnimStateVm() {
        IMapItemViewManager itemViewManager;
        MapAdapter adapter;
        MapItemController controller;
        SquareView mapView = getMapView();
        if (mapView != null && (adapter = mapView.getAdapter()) != null && (controller = adapter.getController()) != null) {
            controller.setWelcomeScaleAnimDone(true);
        }
        SquareView mapView2 = getMapView();
        if (mapView2 != null && (itemViewManager = mapView2.getItemViewManager()) != null) {
            itemViewManager.checkRecycleAndFill();
        }
        SquareViewModel squareVM = getSquareVM();
        if (squareVM != null) {
            squareVM.updateScaleAnimState(true);
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onMapSizeInitReady() {
        SquareBaseKt.getSquareLog().i(TAG, "updateScaleAnimState");
        updateScaleAnimState();
    }
}
