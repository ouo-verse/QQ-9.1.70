package com.tencent.state.square.components.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.rapier.b;
import com.tencent.state.SquareDebug;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapData;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapItemController;
import com.tencent.state.service.VasNoviceGuideService;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareGroupFragment;
import com.tencent.state.square.SquareMapViewModel;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.SquareViewModel;
import com.tencent.state.square.api.p015const.LauncherConst;
import com.tencent.state.square.components.SquareBlockDialogUtils;
import com.tencent.state.square.guide.GuideContext;
import com.tencent.state.square.guide.NoviceGuideStepManager;
import com.tencent.state.square.guide.SquareNoviceGuideConfig;
import com.tencent.state.square.guide.SquareNoviceGuideRecord;
import com.tencent.state.utils.VMUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u0018\u001a\u00020\rJ\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareNoviceGuideComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "delayByTransit", "", "fragmentVM", "Lcom/tencent/state/square/SquareMapViewModel;", "hasHandle", "squareGroupVM", "Lcom/tencent/state/square/SquareViewModel;", "stepManager", "Lcom/tencent/state/square/guide/NoviceGuideStepManager;", "cancel", "", "desc", "", "checkAndShowGuide", "checkAndShowGuideOnBackFromDetail", "checkAndShowGuideOnInit", "initGuideInfo", "initObserver", "initStepManager", DownloadInfo.spKey_Config, "Lcom/tencent/state/square/guide/SquareNoviceGuideConfig;", "initialize", "onBackFromDetail", "bundle", "Landroid/os/Bundle;", "onGoToDetail", "onMapDataReceived", "data", "Lcom/tencent/state/map/MapData;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareNoviceGuideComponent extends SquareBaseComponent {
    private static final String TAG = "SquareNoviceGuideComponent";
    private boolean delayByTransit;
    private SquareMapViewModel fragmentVM;
    private boolean hasHandle;
    private SquareViewModel squareGroupVM;
    private NoviceGuideStepManager stepManager;

    private final void checkAndShowGuide() {
        LiveData<Boolean> isScaleAnimDone;
        LiveData<SquareNoviceGuideConfig> noviceGuideConfig;
        LiveData<MapData> data;
        MapData value;
        SquareBaseKt.getSquareLog().d(TAG, "[NoviceGuide] checkAndShowGuide, " + this.hasHandle);
        if (this.hasHandle) {
            return;
        }
        SquareMapViewModel squareMapViewModel = this.fragmentVM;
        Boolean bool = null;
        List<MapItem> dataList = (squareMapViewModel == null || (data = squareMapViewModel.getData()) == null || (value = data.getValue()) == null) ? null : value.getDataList();
        SquareViewModel squareViewModel = this.squareGroupVM;
        SquareNoviceGuideConfig value2 = (squareViewModel == null || (noviceGuideConfig = squareViewModel.getNoviceGuideConfig()) == null) ? null : noviceGuideConfig.getValue();
        SquareViewModel squareViewModel2 = this.squareGroupVM;
        if (squareViewModel2 != null && (isScaleAnimDone = squareViewModel2.isScaleAnimDone()) != null) {
            bool = isScaleAnimDone.getValue();
        }
        if ((dataList == null || !dataList.isEmpty()) && value2 != null && !Intrinsics.areEqual(bool, Boolean.FALSE)) {
            this.hasHandle = true;
            initStepManager(value2);
        } else {
            SquareBaseKt.getSquareLog().d(TAG, "[NoviceGuide] checkAndShowGuide, not ready");
        }
    }

    private final void checkAndShowGuideOnBackFromDetail() {
        SquareBaseKt.getSquareLog().d(TAG, "[NoviceGuide] checkAndShowGuideOnBackFromDetail, " + this.hasHandle + ", " + this.delayByTransit);
        if (this.hasHandle || !this.delayByTransit) {
            return;
        }
        this.delayByTransit = false;
        checkAndShowGuide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void checkAndShowGuideOnInit() {
        boolean z16;
        boolean z17;
        String string;
        boolean isBlank;
        Intent intent;
        SquareBaseKt.getSquareLog().d(TAG, "[NoviceGuide] checkAndShowGuideOnInit, " + this.hasHandle + ", " + this.delayByTransit);
        if (this.hasHandle || this.delayByTransit) {
            return;
        }
        QBaseActivity activity = getActivity();
        Bundle extras = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras();
        if (extras != null && (string = extras.getString(LauncherConst.KEY_OPEN_DETAIL_UIN)) != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(string);
            if (!isBlank) {
                z16 = false;
                z17 = !z16;
                boolean z18 = extras != null ? extras.getBoolean(LauncherConst.KEY_OPEN_ME_DETAIL, false) : false;
                if (z17 && !z18) {
                    checkAndShowGuide();
                    return;
                } else {
                    SquareBaseKt.getSquareLog().i(TAG, "[NoviceGuide] delay by transit");
                    this.delayByTransit = true;
                }
            }
        }
        z16 = true;
        z17 = !z16;
        if (extras != null) {
        }
        if (z17) {
        }
        SquareBaseKt.getSquareLog().i(TAG, "[NoviceGuide] delay by transit");
        this.delayByTransit = true;
    }

    private final void initGuideInfo() {
        new VasNoviceGuideService().getGuidanceInfo(new b<SquareNoviceGuideConfig>() { // from class: com.tencent.state.square.components.fragment.SquareNoviceGuideComponent$initGuideInfo$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                MapAdapter adapter;
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareBaseKt.getSquareLog().d("SquareNoviceGuideComponent", "[NoviceGuide] failed, " + errorCode + ", " + errorMessage);
                SquareView mapView = SquareNoviceGuideComponent.this.getMapView();
                if (mapView == null || (adapter = mapView.getAdapter()) == null) {
                    return;
                }
                MapItemController controller = adapter.getController();
                if (controller != null) {
                    controller.setHasCheckRoleBornAnim(true);
                }
                int meIndex = adapter.getMeIndex();
                if (adapter.getMeIndex() >= 0) {
                    adapter.notifyItemChanged(meIndex, 24);
                }
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(SquareNoviceGuideConfig response) {
                SquareViewModel squareViewModel;
                Intrinsics.checkNotNullParameter(response, "response");
                SquareBaseKt.getSquareLog().d("SquareNoviceGuideComponent", "[NoviceGuide] success, " + response);
                squareViewModel = SquareNoviceGuideComponent.this.squareGroupVM;
                if (squareViewModel != null) {
                    SquareDebug squareDebug = SquareDebug.INSTANCE;
                    if (squareDebug.getMockNoviceGuide()) {
                        response = squareDebug.mockNoviceGuideConfig();
                    }
                    squareViewModel.updateNoviceGuideConfig(response);
                }
            }
        });
    }

    private final void initObserver() {
        SquareFragment squareFragment;
        VasBaseFragment parentFragment;
        LiveData<SquareNoviceGuideRecord> noviceGuideRecord;
        LiveData<SquareNoviceGuideConfig> noviceGuideConfig;
        LiveData<Boolean> isScaleAnimDone;
        if (getActivity() == null || (squareFragment = getSquareFragment()) == null || (parentFragment = getParentFragment()) == null) {
            return;
        }
        VMUtils vMUtils = VMUtils.INSTANCE;
        this.squareGroupVM = (SquareViewModel) vMUtils.safelyGet(parentFragment, SquareViewModel.class);
        this.fragmentVM = (SquareMapViewModel) vMUtils.safelyGet(squareFragment, SquareMapViewModel.class);
        SquareViewModel squareViewModel = this.squareGroupVM;
        if (squareViewModel != null && (isScaleAnimDone = squareViewModel.isScaleAnimDone()) != null) {
            isScaleAnimDone.observe(squareFragment, new Observer<Boolean>() { // from class: com.tencent.state.square.components.fragment.SquareNoviceGuideComponent$initObserver$1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Boolean bool) {
                    SquareNoviceGuideComponent.this.checkAndShowGuideOnInit();
                }
            });
        }
        SquareViewModel squareViewModel2 = this.squareGroupVM;
        if (squareViewModel2 != null && (noviceGuideConfig = squareViewModel2.getNoviceGuideConfig()) != null) {
            noviceGuideConfig.observe(squareFragment, new Observer<SquareNoviceGuideConfig>() { // from class: com.tencent.state.square.components.fragment.SquareNoviceGuideComponent$initObserver$2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(SquareNoviceGuideConfig squareNoviceGuideConfig) {
                    SquareNoviceGuideComponent.this.checkAndShowGuideOnInit();
                }
            });
        }
        SquareViewModel squareViewModel3 = this.squareGroupVM;
        if (squareViewModel3 == null || (noviceGuideRecord = squareViewModel3.getNoviceGuideRecord()) == null) {
            return;
        }
        noviceGuideRecord.observe(squareFragment, new Observer<SquareNoviceGuideRecord>() { // from class: com.tencent.state.square.components.fragment.SquareNoviceGuideComponent$initObserver$3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(SquareNoviceGuideRecord squareNoviceGuideRecord) {
                MapAdapter adapter;
                MapItemController controller;
                SquareBaseKt.getSquareLog().d("SquareNoviceGuideComponent", "[NoviceGuide] recordChange " + squareNoviceGuideRecord.getPlayingRoleBornAnim());
                SquareView mapView = SquareNoviceGuideComponent.this.getMapView();
                if (mapView == null || (adapter = mapView.getAdapter()) == null || (controller = adapter.getController()) == null) {
                    return;
                }
                if (squareNoviceGuideRecord.getPlayingRoleBornAnim()) {
                    controller.setBlockScale(true);
                    controller.setBlockScroll(true);
                    controller.setBlockClick(true);
                    squareNoviceGuideRecord.setBlockByMe(true);
                    return;
                }
                if (squareNoviceGuideRecord.getBlockByMe()) {
                    controller.setBlockScale(false);
                    controller.setBlockScroll(false);
                    controller.setBlockClick(false);
                    squareNoviceGuideRecord.setBlockByMe(false);
                }
            }
        });
    }

    private final void initStepManager(SquareNoviceGuideConfig config) {
        SquareFragment squareFragment;
        QBaseActivity activity = getActivity();
        if (activity == null || (squareFragment = getSquareFragment()) == null) {
            return;
        }
        VasBaseFragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof SquareGroupFragment)) {
            parentFragment = null;
        }
        SquareGroupFragment squareGroupFragment = (SquareGroupFragment) parentFragment;
        if (squareGroupFragment != null) {
            NoviceGuideStepManager noviceGuideStepManager = new NoviceGuideStepManager(new GuideContext(activity, squareFragment, squareGroupFragment, config), SquareBlockDialogUtils.INSTANCE.isBlockDialog(activity));
            NoviceGuideStepManager.start$default(noviceGuideStepManager, null, 1, null);
            Unit unit = Unit.INSTANCE;
            this.stepManager = noviceGuideStepManager;
        }
    }

    public final void cancel(String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        NoviceGuideStepManager noviceGuideStepManager = this.stepManager;
        if (noviceGuideStepManager != null) {
            noviceGuideStepManager.cancel(desc);
        }
    }

    public final void initialize() {
        initObserver();
        initGuideInfo();
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.square.components.fragment.ISquareEventListener
    public void onBackFromDetail(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        checkAndShowGuideOnBackFromDetail();
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.square.components.fragment.ISquareEventListener
    public void onGoToDetail() {
        cancel("onGotoDetail");
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.square.components.fragment.ISquareEventListener
    public void onMapDataReceived(MapData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getFromCache()) {
            return;
        }
        checkAndShowGuideOnInit();
    }
}
