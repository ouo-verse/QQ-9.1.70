package com.tencent.state.map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.state.SquareRuntime;
import com.tencent.state.VasBaseActivity;
import com.tencent.state.VasBaseSubFragment;
import com.tencent.state.data.Image;
import com.tencent.state.map.BaseMapView;
import com.tencent.state.map.IMapViewListener;
import com.tencent.state.map.IMapViewManipulator;
import com.tencent.state.map.IMapViewUpdater;
import com.tencent.state.map.MapViewModel;
import com.tencent.state.perf.PerfMonitor;
import com.tencent.state.report.PerformanceReportConst;
import com.tencent.state.square.MoveItem;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.IDressKeyChangeListener;
import com.tencent.state.square.api.p015const.LauncherConst;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.record.SquareRecordManager;
import com.tencent.state.square.resource.IResourceCallback;
import com.tencent.state.square.resource.MeResourceRecorder;
import com.tencent.state.square.resource.MeResourceRecorderKt;
import com.tencent.state.square.resource.RecordRequest;
import com.tencent.state.utils.SquareSwitchUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import ne0.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 K*\u0010\b\u0000\u0010\u0001*\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003*\b\b\u0001\u0010\u0004*\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0001KB\u0005\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0004J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0015J\b\u0010 \u001a\u00020\u0019H\u0002J\u001e\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u001d2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0014J\b\u0010&\u001a\u00020\u001bH\u0014J\u001c\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u001bH\u0016J*\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010%H\u0017J\b\u00104\u001a\u00020\u0019H\u0016J\b\u00105\u001a\u00020\u0019H\u0016J\u0010\u00106\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u00107\u001a\u00020\u0019H\u0016J\b\u00108\u001a\u00020\u0019H\u0016J\u0016\u00109\u001a\u00020\u00192\f\u00103\u001a\b\u0012\u0004\u0012\u00020:0$H\u0016J\u0016\u0010;\u001a\u00020\u00192\f\u00103\u001a\b\u0012\u0004\u0012\u00020)0$H\u0016J\u001a\u0010<\u001a\u00020\u00192\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u001a\u0010A\u001a\u00020\u00192\u0006\u0010/\u001a\u0002002\b\u0010B\u001a\u0004\u0018\u00010+H\u0016J\u0018\u0010C\u001a\u00020\u00192\u0006\u0010D\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020)H\u0015J\u0006\u0010F\u001a\u00020\u0019J\b\u0010G\u001a\u00020\u0019H\u0002J\u0010\u0010H\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u001bH$J\u001e\u0010J\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u001d2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0014R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00018\u0000X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u0004\u0018\u00018\u0001X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006L"}, d2 = {"Lcom/tencent/state/map/MapFragment;", "V", "Lcom/tencent/state/map/BaseMapView;", "Lcom/tencent/state/map/MapView;", "VM", "Lcom/tencent/state/map/MapViewModel;", "Lcom/tencent/state/VasBaseSubFragment;", "Lcom/tencent/state/map/IMapViewListener;", "Lcom/tencent/state/square/api/IDressKeyChangeListener;", "()V", "binding", "Landroidx/viewbinding/ViewBinding;", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "mapView", "getMapView", "()Lcom/tencent/state/map/BaseMapView;", "recorder", "Lcom/tencent/state/square/resource/MeResourceRecorder;", "getRecorder", "()Lcom/tencent/state/square/resource/MeResourceRecorder;", "vm", "getVm", "()Lcom/tencent/state/map/MapViewModel;", "doOnDressKeyChange", "", "isMale", "", "getMapViewConfig", "Lcom/tencent/state/map/MapViewConfig;", "mapBackground", "Lcom/tencent/state/data/Image;", "handleLocateCommand", "initMapView", DownloadInfo.spKey_Config, "dataList", "", "Lcom/tencent/state/map/MapItem;", "isZoomEnabled", "locateFailOnTryScaleToDetail", "uin", "", "bundle", "Landroid/os/Bundle;", "onBackPressed", "onCenterScaled", "isScaleToCenter", "view", "Landroid/view/View;", "index", "", "data", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onDestroyView", "onDressKeyChange", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "onRoleAdded", "Lcom/tencent/state/square/MoveItem;", "onRoleRemoved", "onStartRecord", "resource", "Lcom/tencent/state/square/data/Resource;", "callback", "Lcom/tencent/state/square/resource/IResourceCallback;", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, Constants.FILE_INSTANCE_STATE, "onVisibilityChanged", "isVisible", "from", "refreshMapDataList", "removeNearbyObservers", "sendMapDataRequest", "isRefresh", "updateMapView", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public abstract class MapFragment<V extends BaseMapView<?>, VM extends MapViewModel> extends VasBaseSubFragment implements IMapViewListener, IDressKeyChangeListener {
    private static final String TAG = "MapFragment";
    private final MeResourceRecorder recorder = new MeResourceRecorder();

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleLocateCommand() {
        Intent intent;
        Intent intent2;
        Intent intent3;
        FragmentActivity activity = getActivity();
        String str = null;
        final String stringExtra = (activity == null || (intent3 = activity.getIntent()) == null) ? null : intent3.getStringExtra(LauncherConst.KEY_LOCATE_TO_UIN);
        if (stringExtra != null) {
            SquareBaseKt.getSquareThread().postOnUiDelayed(100L, new Function0<Unit>() { // from class: com.tencent.state.map.MapFragment$handleLocateCommand$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IMapViewManipulator manipulator;
                    BaseMapView mapView = this.getMapView();
                    if (mapView == null || (manipulator = mapView.getManipulator()) == null) {
                        return;
                    }
                    IMapViewManipulator.DefaultImpls.locateTo$default(manipulator, stringExtra, null, 2, null);
                }
            });
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent2 = activity2.getIntent()) != null) {
            str = intent2.getStringExtra(LauncherConst.KEY_OPEN_DETAIL_UIN);
        }
        FragmentActivity activity3 = getActivity();
        boolean z16 = false;
        if (activity3 != null && (intent = activity3.getIntent()) != null) {
            z16 = intent.getBooleanExtra(LauncherConst.KEY_OPEN_ME_DETAIL, false);
        }
        if (Intrinsics.areEqual(str, "0")) {
            z16 = true;
        }
        if (z16) {
            SquareBaseKt.getSquareThread().postOnUiDelayed(100L, new MapFragment$handleLocateCommand$2(this));
        } else if (str != null) {
            SquareBaseKt.getSquareThread().postOnUiDelayed(100L, new MapFragment$handleLocateCommand$3(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeNearbyObservers() {
        VM vm5;
        LiveData<MapData> data;
        if (!SquareRuntime.INSTANCE.hasNearbyMark() || (vm5 = getVm()) == null || (data = vm5.getData()) == null) {
            return;
        }
        data.removeObservers(getViewLifecycleOwner());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void doOnDressKeyChange(boolean isMale) {
        final IMapViewUpdater iMapViewUpdater;
        SquareBaseKt.getSquareLog().i(TAG, "onDressKeyChange isMale:" + isMale);
        V mapView = getMapView();
        if (mapView == null || (iMapViewUpdater = (IMapViewUpdater) mapView.getComponent(IMapViewUpdater.class)) == null) {
            return;
        }
        iMapViewUpdater.updateAvatarGender(isMale);
        SquareRecordManager squareRecordManager = SquareRecordManager.INSTANCE;
        iMapViewUpdater.updateAvatarDressKey(squareRecordManager.getDressKey());
        MapPlayableItem resetMeActions = iMapViewUpdater.resetMeActions();
        if (resetMeActions != null) {
            SquareBaseKt.getSquareLog().i(TAG, "onDressKeyChange avatarItem:" + resetMeActions + " dressKey:" + squareRecordManager.getDressKey());
            Resource userResource = resetMeActions.getUserResource();
            if (userResource != null) {
                onStartRecord(userResource, new IResourceCallback() { // from class: com.tencent.state.map.MapFragment$doOnDressKeyChange$1
                    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                    public void onFirstFrame() {
                        IResourceCallback.DefaultImpls.onFirstFrame(this);
                    }

                    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                    public void onPlayEnd() {
                        IResourceCallback.DefaultImpls.onPlayEnd(this);
                    }

                    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                    public void onPlayError(int i3) {
                        IResourceCallback.DefaultImpls.onPlayError(this, i3);
                    }

                    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                    public void onPlayStart() {
                        IResourceCallback.DefaultImpls.onPlayStart(this);
                    }

                    @Override // com.tencent.state.square.resource.IResourceCallback
                    public void onRecordError(int i3, RecordRequest request, int i16) {
                        Intrinsics.checkNotNullParameter(request, "request");
                        IResourceCallback.DefaultImpls.onRecordError(this, i3, request, i16);
                    }

                    @Override // com.tencent.state.square.resource.IResourceCallback
                    public void onRecordStart(Resource resource, boolean z16) {
                        Intrinsics.checkNotNullParameter(resource, "resource");
                        IResourceCallback.DefaultImpls.onRecordStart(this, resource, z16);
                    }

                    @Override // com.tencent.state.square.resource.IResourceCallback
                    public void onRecordSuccess(RecordRequest request) {
                        Intrinsics.checkNotNullParameter(request, "request");
                        IResourceCallback.DefaultImpls.onRecordSuccess(this, request);
                        Resource resource = request.getResource();
                        if (resource != null) {
                            IMapViewUpdater.DefaultImpls.updateMeResource$default(IMapViewUpdater.this, resource, false, 2, null);
                        }
                    }

                    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                    public void onRemovedListener() {
                        IResourceCallback.DefaultImpls.onRemovedListener(this);
                    }

                    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                    public void onStaticFailed() {
                        IResourceCallback.DefaultImpls.onStaticFailed(this);
                    }

                    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
                    public void onStaticSuccess() {
                        IResourceCallback.DefaultImpls.onStaticSuccess(this);
                    }
                });
            }
        }
    }

    public abstract ViewBinding getBinding();

    public abstract V getMapView();

    /* JADX INFO: Access modifiers changed from: protected */
    public MapViewConfig getMapViewConfig(Image mapBackground) {
        Intrinsics.checkNotNullParameter(mapBackground, "mapBackground");
        MapViewConfig defaultMapConfig = MapViewConfigKt.defaultMapConfig();
        defaultMapConfig.setMapBackground(mapBackground.getUrl());
        defaultMapConfig.setMapWidth(mapBackground.getSize().getWidth());
        defaultMapConfig.setMapHeight(mapBackground.getSize().getHeight());
        defaultMapConfig.setZoomEnabled(isZoomEnabled());
        return defaultMapConfig;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MeResourceRecorder getRecorder() {
        return this.recorder;
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    protected abstract VM getVm();

    /* JADX INFO: Access modifiers changed from: protected */
    public void initMapView(MapViewConfig config, List<? extends MapItem> dataList) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        V mapView = getMapView();
        if (mapView != null) {
            mapView.initialize(dataList, config, this);
        }
    }

    protected boolean isZoomEnabled() {
        return true;
    }

    public void locateFailOnTryScaleToDetail(String uin, Bundle bundle) {
        Intrinsics.checkNotNullParameter(uin, "uin");
    }

    @Override // com.tencent.state.VasBaseFragment
    public boolean onBackPressed() {
        if (super.onBackPressed()) {
            return false;
        }
        if (getActivity() instanceof VasBaseActivity) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        } else {
            popFragment(this);
        }
        return true;
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onCenterScaled(boolean isScaleToCenter, View view, int index, MapItem data) {
        Intrinsics.checkNotNullParameter(view, "view");
        onVisibilityChanged(!isScaleToCenter, "onCenterScaled");
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        V mapView = getMapView();
        if (mapView != null) {
            mapView.destroy();
        }
        this.recorder.onDestroy();
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        SquareRecordManager.INSTANCE.removeDressKeyChangeListener(this);
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onDoubleClick(MapViewHolder<?> vh5, int i3, MapItem mapItem, int i16) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        IMapViewListener.DefaultImpls.onDoubleClick(this, vh5, i3, mapItem, i16);
    }

    @Override // com.tencent.state.square.api.IDressKeyChangeListener
    public void onDressKeyChange(boolean isMale) {
        doOnDressKeyChange(isMale);
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onInVisible(MapViewHolder<?> vh5, int i3, MapItem mapItem) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        IMapViewListener.DefaultImpls.onInVisible(this, vh5, i3, mapItem);
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemBind(MapViewHolder<?> vh5, int i3, MapItem mapItem) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        IMapViewListener.DefaultImpls.onItemBind(this, vh5, i3, mapItem);
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemRecycled(MapViewHolder<?> vh5, int i3, MapItem mapItem) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        IMapViewListener.DefaultImpls.onItemRecycled(this, vh5, i3, mapItem);
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onMapSizeInitReady() {
        IMapViewListener.DefaultImpls.onMapSizeInitReady(this);
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onMapZoomEnd(int i3, float f16, boolean z16) {
        IMapViewListener.DefaultImpls.onMapZoomEnd(this, i3, f16, z16);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        V mapView = getMapView();
        if (mapView != null) {
            mapView.onVisibilityChanged(false);
        }
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        V mapView = getMapView();
        if (mapView != null) {
            mapView.onVisibilityChanged(true);
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

    @Override // com.tencent.state.map.IMapViewListener
    public void onStartRecord(Resource resource, IResourceCallback callback) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        MeResourceRecorder.startRecord$default(this.recorder, MeResourceRecorderKt.toRecordRequest$default(resource, null, 0, 3, null), (String) null, (List) null, callback, 6, (Object) null);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        LiveData<MapData> data;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        PerfMonitor perfMonitor = (PerfMonitor) getComponent(PerfMonitor.class, null, null);
        if (perfMonitor != null) {
            perfMonitor.exposureStep(PerformanceReportConst.Key.KEY_PERFORMANCE_FIRST_EXPOSURE_BASE_LOAD);
        }
        sendMapDataRequest(false);
        SquareRecordManager.INSTANCE.setDressKeyChangeListener(this);
        SquareSwitchUtils.INSTANCE.initialize();
        final WeakReference weakReference = new WeakReference(this);
        VM vm5 = getVm();
        if (vm5 == null || (data = vm5.getData()) == null) {
            return;
        }
        data.observe(getViewLifecycleOwner(), new Observer<MapData>() { // from class: com.tencent.state.map.MapFragment$onViewCreated$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(MapData mapData) {
                if (mapData.getIsReenter()) {
                    MapFragment mapFragment = MapFragment.this;
                    mapFragment.updateMapView(mapFragment.getMapViewConfig(mapData.getBackground()), mapData.getDataList());
                } else {
                    MapFragment mapFragment2 = MapFragment.this;
                    mapFragment2.initMapView(mapFragment2.getMapViewConfig(mapData.getBackground()), mapData.getDataList());
                    MapFragment.this.handleLocateCommand();
                }
                MapFragment mapFragment3 = (MapFragment) weakReference.get();
                if (mapFragment3 != null) {
                    mapFragment3.removeNearbyObservers();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.VasBaseLifecycleFragment
    public void onVisibilityChanged(boolean isVisible, String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        super.onVisibilityChanged(isVisible, from);
        V mapView = getMapView();
        if (mapView != null) {
            mapView.onVisibilityChanged(isVisible);
        }
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onVisible(MapViewHolder<?> vh5, int i3, MapItem mapItem) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        IMapViewListener.DefaultImpls.onVisible(this, vh5, i3, mapItem);
    }

    protected abstract void sendMapDataRequest(boolean isRefresh);

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateMapView(MapViewConfig config, List<? extends MapItem> dataList) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        V mapView = getMapView();
        if (mapView != null) {
            mapView.reset(dataList, config, this);
        }
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }

    @Override // com.tencent.state.map.IMapViewListener
    public void onItemBind(MapViewHolder<?> vh5, int i3, MapItem mapItem, int i16) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        IMapViewListener.DefaultImpls.onItemBind(this, vh5, i3, mapItem, i16);
    }

    public final void refreshMapDataList() {
        sendMapDataRequest(true);
    }

    public static /* synthetic */ void locateFailOnTryScaleToDetail$default(MapFragment mapFragment, String str, Bundle bundle, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                bundle = null;
            }
            mapFragment.locateFailOnTryScaleToDetail(str, bundle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: locateFailOnTryScaleToDetail");
    }
}
