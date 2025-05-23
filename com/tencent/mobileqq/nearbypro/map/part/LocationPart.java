package com.tencent.mobileqq.nearbypro.map.part;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import androidx.lifecycle.ViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.api.IMapNearbyDataService;
import com.tencent.mobileqq.nearbypro.api.map.SelfUserInfo;
import com.tencent.mobileqq.nearbypro.base.d;
import com.tencent.mobileqq.nearbypro.map.part.i;
import com.tencent.mobileqq.nearbypro.map.request.LogoutRequest;
import com.tencent.mobileqq.nearbypro.request.RspErrCode;
import com.tencent.mobileqq.nearbypro.request.RspStatus;
import com.tencent.mobileqq.nearbypro.request.RspStatusType;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.xweb.internal.ConstValue;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 52\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J.\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u001c\b\u0002\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011H\u0002J\u001c\u0010\u001a\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u001c\u0010\u001f\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\"\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010#\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u0016\u0010&\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00102\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010%\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/part/LocationPart;", "Lcom/tencent/mobileqq/nearbypro/part/e;", "", "R9", "V9", "X9", "Y9", "Lcom/tencent/mobileqq/nearbypro/request/d;", "rspStatus", "S9", "O9", "Lcom/tencent/mobileqq/soso/location/data/SosoLocation;", "location", "W9", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "latLng", "P9", "Lkotlin/Function2;", "", "Lcom/tencent/tencentmap/mapsdk/maps/CameraUpdate;", "block", "Q9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "", "action", "", "args", "handleBroadcastMessage", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartDestroy", "f", "Z", ConstValue.EXTEND_CONFIG_KEY_HAS_LOGIN, "Lcom/tencent/mobileqq/nearbypro/map/viewmodel/b;", tl.h.F, "Lcom/tencent/mobileqq/nearbypro/map/viewmodel/b;", "locationVM", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "i", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "initLocationJob", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "locTimeoutJob", BdhLogUtil.LogTag.Tag_Conn, "startLocationSuc", "<init>", "()V", "D", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LocationPart extends com.tencent.mobileqq.nearbypro.part.e {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean startLocationSuc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hasLogin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.nearbypro.map.viewmodel.b locationVM;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b initLocationJob;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b locTimeoutJob;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/nearbypro/map/part/LocationPart$b", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap$CancelableCallback;", "", "onFinish", "onCancel", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements TencentMap.CancelableCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, CameraUpdate, Unit> f253479a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CameraUpdate f253480b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super Boolean, ? super CameraUpdate, Unit> function2, CameraUpdate cameraUpdate) {
            this.f253479a = function2;
            this.f253480b = cameraUpdate;
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback
        public void onCancel() {
            com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.LocationPart", "moveCenterAndZoom camera animation canceled");
            Function2<Boolean, CameraUpdate, Unit> function2 = this.f253479a;
            if (function2 != null) {
                Boolean bool = Boolean.FALSE;
                CameraUpdate pos = this.f253480b;
                Intrinsics.checkNotNullExpressionValue(pos, "pos");
                function2.invoke(bool, pos);
            }
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback
        public void onFinish() {
            com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.LocationPart", "moveCenterAndZoom camera animation onFinish");
            Function2<Boolean, CameraUpdate, Unit> function2 = this.f253479a;
            if (function2 != null) {
                Boolean bool = Boolean.TRUE;
                CameraUpdate pos = this.f253480b;
                Intrinsics.checkNotNullExpressionValue(pos, "pos");
                function2.invoke(bool, pos);
            }
        }
    }

    public LocationPart() {
        ab2.c.f25771a.b();
    }

    private final void O9() {
        SelfUserInfo selfUserInfo;
        LatLng latLng;
        IMapNearbyDataService f16 = ab2.a.f25767a.f();
        if (f16 != null && (selfUserInfo = f16.getSelfUserInfo()) != null && (latLng = selfUserInfo.getLatLng()) != null) {
            com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.LocationPart", "initHistoryPos pos:" + latLng);
            P9(latLng);
        }
    }

    private final void P9(LatLng latLng) {
        CameraUpdate newCameraPosition = CameraUpdateFactory.newCameraPosition(new CameraPosition(new LatLng(latLng.latitude, latLng.longitude), ab2.a.f25767a.q(), 0.0f, 0.0f));
        TencentMap a16 = i.INSTANCE.a(this);
        if (a16 != null) {
            a16.moveCamera(newCameraPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(LatLng latLng, Function2<? super Boolean, ? super CameraUpdate, Unit> block) {
        com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.LocationPart", "moveCenterAndZoom latLng:" + latLng.latitude + "-" + latLng.longitude);
        i.Companion companion = i.INSTANCE;
        TencentMap a16 = companion.a(this);
        if (a16 != null) {
            a16.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        }
        CameraUpdate newLatLngZoom = CameraUpdateFactory.newLatLngZoom(latLng, ab2.a.f25767a.o());
        TencentMap a17 = companion.a(this);
        if (a17 != null) {
            a17.animateCamera(newLatLngZoom, 1000L, new b(block, newLatLngZoom));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9() {
        SelfUserInfo selfUserInfo;
        LatLng a16;
        TencentMap a17;
        ab2.a aVar = ab2.a.f25767a;
        IMapNearbyDataService f16 = aVar.f();
        if (f16 != null && (selfUserInfo = f16.getSelfUserInfo()) != null && (a16 = ab2.c.f25771a.a(selfUserInfo)) != null && (a17 = i.INSTANCE.a(this)) != null) {
            a17.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(a16.latitude, a16.longitude), aVar.o()), new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(RspStatus rspStatus) {
        if (rspStatus.getType() == RspStatusType.RPC_FUNC_ERROR && rspStatus.getCode() == RspErrCode.ERR_USER_IN_BLACKLIST.getCode()) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, getContext().getResources().getString(R.string.f170032jy), rspStatus.getMsg(), getContext().getResources().getString(R.string.f170022jx), "", (DialogInterface.OnClickListener) null, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.map.part.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    LocationPart.T9(dialogInterface, i3);
                }
            });
            createCustomDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.nearbypro.map.part.e
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    LocationPart.U9(LocationPart.this, dialogInterface);
                }
            });
            createCustomDialog.show();
            return;
        }
        QQToast.makeText(getContext(), getContext().getResources().getString(R.string.f170252kj), 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(DialogInterface dialogInterface, int i3) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(LocationPart this$0, DialogInterface dialogInterface) {
        Activity activity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity2 = this$0.getActivity();
        boolean z16 = false;
        if (activity2 != null && activity2.isFinishing()) {
            z16 = true;
        }
        if (!z16 && (activity = this$0.getActivity()) != null) {
            activity.finish();
        }
    }

    private final void V9() {
        Job f16;
        O9();
        X9();
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.initLocationJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        this.initLocationJob = CorountineFunKt.e(fa2.a.b(), "LocationPart", null, null, Boolean.TRUE, new LocationPart$onHasPermission$1(this, null), 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W9(SosoLocation location) {
        SelfUserInfo selfUserInfo;
        ab2.a aVar = ab2.a.f25767a;
        IMapNearbyDataService f16 = aVar.f();
        if (f16 != null && (selfUserInfo = f16.getSelfUserInfo()) != null) {
            boolean z16 = true;
            if (location != null) {
                this.startLocationSuc = true;
                ab2.c cVar = ab2.c.f25771a;
                LatLng latLng = new LatLng(location.mLat02, location.mLon02);
                String str = location.address;
                String str2 = "";
                if (str == null) {
                    str = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str, "it.address ?: \"\"");
                }
                String str3 = location.name;
                if (str3 != null) {
                    Intrinsics.checkNotNullExpressionValue(str3, "it.name ?: \"\"");
                    str2 = str3;
                }
                cVar.d(selfUserInfo, latLng, str, str2);
            }
            LatLng latLng2 = selfUserInfo.getLatLng();
            LatLng a16 = ab2.c.f25771a.a(selfUserInfo);
            ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
            if (location == null) {
                z16 = false;
            }
            Intrinsics.checkNotNull(latLng2);
            Intrinsics.checkNotNull(a16);
            c16.e("NBP.LocationPart", "onLocationResult isSucc:" + z16 + " pos:" + latLng2 + " vaguePos:" + a16 + " dis:" + aVar.b(latLng2, a16));
        }
    }

    private final void X9() {
        Y9();
        this.locTimeoutJob = CorountineFunKt.e(fa2.a.b(), "locTimeout", null, null, Boolean.TRUE, new LocationPart$startLocTimeout$1(this, null), 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y9() {
        Job f16;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.locTimeoutJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != -1707354252) {
                if (hashCode != 1823234338) {
                    if (hashCode == 2064951069 && action.equals("MSG_LOCATION_SELF_ACTION")) {
                        R9();
                        return;
                    }
                    return;
                }
                if (action.equals("MSG_LOCATION_ACTION")) {
                    if (args instanceof JSONObject) {
                        JSONObject jSONObject = (JSONObject) args;
                        args = new LatLng(jSONObject.optDouble("latitude", 0.0d), jSONObject.optDouble("longitude", 0.0d));
                    }
                    if (args instanceof LatLng) {
                        com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.LocationPart", "LOCATION_ACTION args=" + args);
                        TencentMap a16 = i.INSTANCE.a(this);
                        if (a16 != null) {
                            a16.animateCamera(CameraUpdateFactory.newLatLng((LatLng) args), 300L, null);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (action.equals("has_location_permission")) {
                ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
                Intrinsics.checkNotNull(args, "null cannot be cast to non-null type kotlin.Boolean");
                Boolean bool = (Boolean) args;
                c16.e("NBP.LocationPart", "permission change hasPermission:" + bool);
                if (bool.booleanValue()) {
                    V9();
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        final View findViewById;
        ViewStub viewStub;
        super.onInitView(rootView);
        if (rootView != null && (viewStub = (ViewStub) rootView.findViewById(R.id.f166183yx3)) != null) {
            view = viewStub.inflate();
        } else {
            view = null;
        }
        if (view != null && (findViewById = view.findViewById(R.id.egg)) != null) {
            final long j3 = 200;
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.map.part.LocationPart$onInitView$$inlined$setSingleClickListener$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View it) {
                    boolean z16;
                    EventCollector.getInstance().onViewClickedBefore(it);
                    findViewById.setClickable(false);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    z16 = this.startLocationSuc;
                    if (z16) {
                        this.R9();
                    } else {
                        CorountineFunKt.e(fa2.a.b(), "LocationPart", null, null, Boolean.TRUE, new LocationPart$onInitView$1$1(this, null), 6, null);
                    }
                    final View view2 = findViewById;
                    view2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.map.part.LocationPart$onInitView$$inlined$setSingleClickListener$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            view2.setClickable(true);
                        }
                    }, j3);
                    EventCollector.getInstance().onViewClicked(it);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        ViewModel viewModel = getViewModel(com.tencent.mobileqq.nearbypro.map.viewmodel.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(LocationVM::class.java)");
        this.locationVM = (com.tencent.mobileqq.nearbypro.map.viewmodel.b) viewModel;
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Job f16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.initLocationJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        Y9();
        com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.LocationPart", "onPartDestroy hasLogin:" + this.hasLogin);
        if (this.hasLogin) {
            d.a.a(com.tencent.mobileqq.nearbypro.base.j.e(), new LogoutRequest(), null, 2, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/nearbypro/map/part/LocationPart$c", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap$CancelableCallback;", "", "onFinish", "onCancel", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements TencentMap.CancelableCallback {
        c() {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback
        public void onFinish() {
            String str;
            bb2.d<?> dVar;
            List<Marker> screenMarkers;
            SelfUserInfo selfUserInfo;
            IMapNearbyDataService f16 = ab2.a.f25767a.f();
            if (f16 == null || (selfUserInfo = f16.getSelfUserInfo()) == null || (str = selfUserInfo.p()) == null) {
                str = "";
            }
            TencentMap a16 = i.INSTANCE.a(LocationPart.this);
            if (a16 != null && (screenMarkers = a16.getScreenMarkers()) != null) {
                dVar = com.tencent.mobileqq.nearbypro.utils.i.c(screenMarkers, str);
            } else {
                dVar = null;
            }
            if (dVar != null) {
                dVar.h();
            }
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback
        public void onCancel() {
        }
    }
}
