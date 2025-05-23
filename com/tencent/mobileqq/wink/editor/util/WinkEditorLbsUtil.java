package com.tencent.mobileqq.wink.editor.util;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.event.QcircleLbsEvent;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.editor.util.ActivityResultFragment;
import com.tencent.mobileqq.wink.editor.util.WinkEditorLbsUtil;
import com.tencent.mobileqq.wink.utils.aj;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoErrorCode;
import com.tencent.qzonehub.api.IQzoneLbsServiceApi;
import com.tencent.qzonehub.api.IQzonePluginProxyActivity;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.model.LocalImageShootInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0004\u001a\u00020\u0003H\u0002J4\u0010\r\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J,\u0010\u000e\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J2\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007JZ\u0010\u001e\u001a\u00020\n2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00032:\u0010\u001d\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u001b\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\n0\u0016J\u0012\u0010 \u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0014\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\"0!H\u0016J\u0006\u0010$\u001a\u00020\nRL\u0010&\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u001b\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\n\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/util/WinkEditorLbsUtil;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/qcircle/api/event/QcircleLbsEvent;", "", "f", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "Landroidx/fragment/app/Fragment;", "fragment", "Lkotlin/Function0;", "", "onGranted", "onDenied", "k", "g", "l", "Lcom/tencent/mobileqq/wink/editor/util/WinkEditorLbsUtil$LocationSelector;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Lcooperation/qzone/model/GpsInfo4LocalImage;", "gpsInfos", "withLocation", "Lkotlin/Function2;", "Lcooperation/qzone/LbsDataV2$PoiList;", "Lkotlin/ParameterName;", "name", "result", "", "t", "onResult", "e", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "j", "Lkotlin/jvm/functions/Function2;", "poiCallback", "<init>", "()V", "LocationSelector", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorLbsUtil implements SimpleEventReceiver<QcircleLbsEvent> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final WinkEditorLbsUtil f322604d = new WinkEditorLbsUtil();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Function2<? super LbsDataV2.PoiList, ? super Throwable, Unit> poiCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/util/WinkEditorLbsUtil$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f322613a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f322614b;

        a(Function0<Unit> function0, Function0<Unit> function02) {
            this.f322613a = function0;
            this.f322614b = function02;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            this.f322613a.invoke();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@NotNull List<String> permissions, @NotNull List<Integer> results) {
            Object orNull;
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(results, "results");
            orNull = CollectionsKt___CollectionsKt.getOrNull(results, 0);
            Integer num = (Integer) orNull;
            if (num != null && num.intValue() == 3) {
                com.tencent.mobileqq.wink.editor.sticker.f.u(WinkDaTongReportConstant.ElementId.EM_XSJ_UNABLE_TO_LOCATE_WINDOWS, new String[0]);
            }
            super.onDenied(permissions, results);
            this.f322614b.invoke();
        }
    }

    WinkEditorLbsUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f() {
        Object systemService = com.tencent.mobileqq.wink.b.c().getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        return ((LocationManager) systemService).isProviderEnabled("gps");
    }

    private final void g(final Fragment fragment, final Function0<Unit> onGranted, final Function0<Unit> onDenied) {
        com.tencent.mobileqq.wink.view.o N = com.tencent.mobileqq.wink.view.o.N(fragment.getActivity(), uq3.c.b1(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "secondary_qcircle_no_gps_title", "\u65e0\u6cd5\u5b9a\u4f4d"), uq3.c.b1(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "secondary_qcircle_no_gps_content", "\u65e0\u6cd5\u83b7\u53d6\u5230\u4f60\u7684\u4f4d\u7f6e\u4fe1\u606f\uff0c\u8bf7\u6253\u5f00\u5b9a\u4f4d\u670d\u52a1\u3002"), R.string.cancel, R.string.f171000bk1, null, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.util.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorLbsUtil.h(Function0.this, dialogInterface, i3);
            }
        });
        N.R(R.string.f171000bk1, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.util.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorLbsUtil.i(Fragment.this, onGranted, onDenied, dialogInterface, i3);
            }
        }, false);
        try {
            N.show();
        } catch (Exception e16) {
            QLog.e("WinkEditorLbsUtil", 1, "Exception:", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function0 onDenied, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(onDenied, "$onDenied");
        onDenied.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(final Fragment fragment, final Function0 onGranted, final Function0 onDenied, final DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(fragment, "$fragment");
        Intrinsics.checkNotNullParameter(onGranted, "$onGranted");
        Intrinsics.checkNotNullParameter(onDenied, "$onDenied");
        fragment.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 0);
        fragment.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.wink.editor.util.WinkEditorLbsUtil$openGPSDialog$1$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                boolean f16;
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                w53.b.a("WinkEditorLbsUtil", "onStateChanged: " + event + " " + Fragment.this.getLifecycle().getCurrentState());
                if (Lifecycle.Event.ON_START == event && Fragment.this.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) {
                    Fragment.this.getLifecycle().removeObserver(this);
                    dialogInterface.dismiss();
                    f16 = WinkEditorLbsUtil.f322604d.f();
                    if (f16) {
                        onGranted.invoke();
                        return;
                    } else {
                        onDenied.invoke();
                        return;
                    }
                }
                if (Lifecycle.Event.ON_DESTROY == event) {
                    Fragment.this.getLifecycle().removeObserver(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(QQPermission qqPermission, Fragment fragment, Function0<Unit> onGranted, Function0<Unit> onDenied) {
        if (qqPermission.hasPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
            com.tencent.mobileqq.wink.editor.sticker.f.u(WinkDaTongReportConstant.ElementId.EM_XSJ_LOCATION_RIGHT_WINDOWS, new String[0]);
            qqPermission.requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 2, new a(onGranted, onDenied));
        } else {
            onGranted.invoke();
        }
    }

    public final void e(@Nullable List<? extends GpsInfo4LocalImage> gpsInfos, boolean withLocation, @NotNull Function2<? super LbsDataV2.PoiList, ? super Throwable, Unit> onResult) {
        ArrayList<GpsInfo4LocalImage> arrayList;
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        if (gpsInfos == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>(gpsInfos);
        }
        if (withLocation) {
            ((IQzoneLbsServiceApi) QRoute.api(IQzoneLbsServiceApi.class)).getBatchPoiFromServer(arrayList, true);
        } else {
            ((IQzoneLbsServiceApi) QRoute.api(IQzoneLbsServiceApi.class)).getBatchPoiFromServerWithoutLocation(arrayList);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        SimpleEventBus.getInstance().registerReceiver(this);
        poiCallback = onResult;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<QcircleLbsEvent>> getEventClass() {
        ArrayList<Class<QcircleLbsEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QcircleLbsEvent.class);
        return arrayListOf;
    }

    public final void j() {
        poiCallback = null;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    public final void l(@NotNull final QQPermission qqPermission, @NotNull final Fragment fragment, @NotNull final Function0<Unit> onGranted, @NotNull final Function0<Unit> onDenied) {
        Intrinsics.checkNotNullParameter(qqPermission, "qqPermission");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(onGranted, "onGranted");
        Intrinsics.checkNotNullParameter(onDenied, "onDenied");
        if (!f()) {
            g(fragment, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.util.WinkEditorLbsUtil$requestPermission$1
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
                    WinkEditorLbsUtil.f322604d.k(QQPermission.this, fragment, onGranted, onDenied);
                }
            }, onDenied);
        } else {
            k(qqPermission, fragment, onGranted, onDenied);
        }
    }

    @NotNull
    public final LocationSelector m(@NotNull QQPermission qqPermission, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(qqPermission, "qqPermission");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return new LocationSelector(qqPermission, fragment, null, null, null, 28, null);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent e16) {
        QcircleLbsEvent qcircleLbsEvent;
        LbsDataV2.PoiList poiList;
        if (e16 instanceof QcircleLbsEvent) {
            qcircleLbsEvent = (QcircleLbsEvent) e16;
        } else {
            qcircleLbsEvent = null;
        }
        if (qcircleLbsEvent != null) {
            poiList = qcircleLbsEvent.mPoiList;
        } else {
            poiList = null;
        }
        w53.b.a("WinkEditorLbsUtil", "onReceiveEvent poiList:" + poiList);
        ThreadManagerV2.getUIHandlerV2();
        if (poiList != null && poiList.poiInfos.size() != 0) {
            Function2<? super LbsDataV2.PoiList, ? super Throwable, Unit> function2 = poiCallback;
            if (function2 != null) {
                function2.invoke(poiList, null);
            }
        } else {
            Function2<? super LbsDataV2.PoiList, ? super Throwable, Unit> function22 = poiCallback;
            if (function22 != null) {
                function22.invoke(null, new IllegalStateException("empty poi list"));
            }
        }
        poiCallback = null;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001e\u001a\u00020\u001a\u0012\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b/\u00100JD\u0010\u000b\u001a\u00020\t2:\u0010\n\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0002H\u0002JB\u0010\f\u001a\u00020\t2:\u0010\n\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0002J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001dR(\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010+\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010.\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010&\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/util/WinkEditorLbsUtil$LocationSelector;", "", "Lkotlin/Function2;", "Lcooperation/qzone/LbsDataV2$PoiInfo;", "Lkotlin/ParameterName;", "name", "result", "", "t", "", "onResult", "d", "c", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "a", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "getQqPermission", "()Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "Landroidx/fragment/app/Fragment;", "b", "Landroidx/fragment/app/Fragment;", "()Landroidx/fragment/app/Fragment;", "fragment", "", "Ljava/util/List;", "getCurrentPoiInfos", "()Ljava/util/List;", "e", "(Ljava/util/List;)V", "currentPoiInfos", "Lcooperation/qzone/LbsDataV2$PoiInfo;", "getSelectPoiInfo", "()Lcooperation/qzone/LbsDataV2$PoiInfo;", "g", "(Lcooperation/qzone/LbsDataV2$PoiInfo;)V", "selectPoiInfo", "getMediaOriginPoiInfo", "f", "mediaOriginPoiInfo", "<init>", "(Lcom/tencent/mobileqq/qqpermission/QQPermission;Landroidx/fragment/app/Fragment;Ljava/util/List;Lcooperation/qzone/LbsDataV2$PoiInfo;Lcooperation/qzone/LbsDataV2$PoiInfo;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final /* data */ class LocationSelector {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final QQPermission qqPermission;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Fragment fragment;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private List<? extends LbsDataV2.PoiInfo> currentPoiInfos;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private LbsDataV2.PoiInfo selectPoiInfo;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private LbsDataV2.PoiInfo mediaOriginPoiInfo;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u0014\u0010\u0003\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/editor/util/WinkEditorLbsUtil$LocationSelector$a", "Lcom/tencent/mobileqq/wink/editor/util/ActivityResultFragment$b;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "a", "getRequestCode", "()I", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes21.dex */
        public static final class a implements ActivityResultFragment.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Function2<LbsDataV2.PoiInfo, Throwable, Unit> f322611a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ LocationSelector f322612b;

            /* JADX WARN: Multi-variable type inference failed */
            a(Function2<? super LbsDataV2.PoiInfo, ? super Throwable, Unit> function2, LocationSelector locationSelector) {
                this.f322611a = function2;
                this.f322612b = locationSelector;
            }

            @Override // com.tencent.mobileqq.wink.editor.util.ActivityResultFragment.b
            public void a(int requestCode, int resultCode, @Nullable Intent data) {
                LbsDataV2.PoiInfo poiInfo;
                Bundle extras;
                ActivityResultFragment activityResultFragment = null;
                if (data != null && (extras = data.getExtras()) != null) {
                    poiInfo = (LbsDataV2.PoiInfo) extras.getParcelable(QZoneHelper.INDEX_MOOD_SELECT_LOCATION_ITEM_SELECT_POI);
                } else {
                    poiInfo = null;
                }
                if (poiInfo != null) {
                    this.f322611a.invoke(poiInfo, null);
                } else {
                    this.f322611a.invoke(null, new IllegalStateException("empty select poi"));
                }
                Fragment findFragmentByTag = this.f322612b.getFragment().getChildFragmentManager().findFragmentByTag("ActivityResultFragment");
                if (findFragmentByTag instanceof ActivityResultFragment) {
                    activityResultFragment = (ActivityResultFragment) findFragmentByTag;
                }
                if (activityResultFragment != null) {
                    activityResultFragment.qh(this);
                }
            }

            @Override // com.tencent.mobileqq.wink.editor.util.ActivityResultFragment.b
            public int getRequestCode() {
                return 6456;
            }
        }

        public LocationSelector(@NotNull QQPermission qqPermission, @NotNull Fragment fragment, @NotNull List<? extends LbsDataV2.PoiInfo> currentPoiInfos, @Nullable LbsDataV2.PoiInfo poiInfo, @Nullable LbsDataV2.PoiInfo poiInfo2) {
            Intrinsics.checkNotNullParameter(qqPermission, "qqPermission");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(currentPoiInfos, "currentPoiInfos");
            this.qqPermission = qqPermission;
            this.fragment = fragment;
            this.currentPoiInfos = currentPoiInfos;
            this.selectPoiInfo = poiInfo;
            this.mediaOriginPoiInfo = poiInfo2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(Function2<? super LbsDataV2.PoiInfo, ? super Throwable, Unit> onResult) {
            LbsDataV2.GpsInfo gpsInfo;
            int i3;
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("key_current_poi_list_infos", new ArrayList<>(this.currentPoiInfos));
            LbsDataV2.PoiInfo poiInfo = this.mediaOriginPoiInfo;
            ActivityResultFragment activityResultFragment = null;
            if (poiInfo != null) {
                gpsInfo = poiInfo.gpsInfo;
            } else {
                gpsInfo = null;
            }
            if (gpsInfo != null) {
                LocalImageShootInfo localImageShootInfo = new LocalImageShootInfo();
                localImageShootInfo.gpsInfo = new GpsInfo4LocalImage(gpsInfo.lat / 1000000.0f, gpsInfo.lon / 1000000.0f);
                Unit unit = Unit.INSTANCE;
                bundle.putParcelable("key_current_img_shoot_info", localImageShootInfo);
            }
            LbsDataV2.PoiInfo poiInfo2 = this.selectPoiInfo;
            bundle.putParcelable("key_current_poi", poiInfo2);
            bundle.putBoolean("key_sync_weishi", false);
            bundle.putBoolean("key_show_local_geo", false);
            bundle.putInt("key_app_id", WiFiPhotoErrorCode.ERR_FILEBRIDGE_NOT_FOLDER);
            if (poiInfo2 == null) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            bundle.putInt("key_lbs_state", i3);
            bundle.putBoolean("key_is_from_circle", true);
            bundle.putBoolean("key_is_wink_editor_style", true);
            bundle.putBoolean("key_is_test_case", true);
            bundle.putInt("key_show_first_line", 0);
            a aVar = new a(onResult, this);
            Fragment findFragmentByTag = this.fragment.getChildFragmentManager().findFragmentByTag("ActivityResultFragment");
            if (findFragmentByTag instanceof ActivityResultFragment) {
                activityResultFragment = (ActivityResultFragment) findFragmentByTag;
            }
            if (activityResultFragment != null) {
                activityResultFragment.ph(aVar);
            }
            Intent intent = new Intent();
            intent.putExtras(bundle);
            ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, QZoneHelper.MOOD_SELECT_LOCATION);
            ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(this.fragment.requireActivity(), aj.b(), intent, 6456);
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final Fragment getFragment() {
            return this.fragment;
        }

        public final void c(@NotNull final Function2<? super LbsDataV2.PoiInfo, ? super Throwable, Unit> onResult) {
            Intrinsics.checkNotNullParameter(onResult, "onResult");
            WinkEditorLbsUtil.f322604d.l(this.qqPermission, this.fragment, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.util.WinkEditorLbsUtil$LocationSelector$gotoSelect$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    WinkEditorLbsUtil.LocationSelector.this.d(onResult);
                }
            }, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.util.WinkEditorLbsUtil$LocationSelector$gotoSelect$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    onResult.invoke(null, new IllegalStateException("permission deny"));
                }
            });
        }

        public final void e(@NotNull List<? extends LbsDataV2.PoiInfo> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.currentPoiInfos = list;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LocationSelector)) {
                return false;
            }
            LocationSelector locationSelector = (LocationSelector) other;
            if (Intrinsics.areEqual(this.qqPermission, locationSelector.qqPermission) && Intrinsics.areEqual(this.fragment, locationSelector.fragment) && Intrinsics.areEqual(this.currentPoiInfos, locationSelector.currentPoiInfos) && Intrinsics.areEqual(this.selectPoiInfo, locationSelector.selectPoiInfo) && Intrinsics.areEqual(this.mediaOriginPoiInfo, locationSelector.mediaOriginPoiInfo)) {
                return true;
            }
            return false;
        }

        public final void f(@Nullable LbsDataV2.PoiInfo poiInfo) {
            this.mediaOriginPoiInfo = poiInfo;
        }

        public final void g(@Nullable LbsDataV2.PoiInfo poiInfo) {
            this.selectPoiInfo = poiInfo;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((((this.qqPermission.hashCode() * 31) + this.fragment.hashCode()) * 31) + this.currentPoiInfos.hashCode()) * 31;
            LbsDataV2.PoiInfo poiInfo = this.selectPoiInfo;
            int i3 = 0;
            if (poiInfo == null) {
                hashCode = 0;
            } else {
                hashCode = poiInfo.hashCode();
            }
            int i16 = (hashCode2 + hashCode) * 31;
            LbsDataV2.PoiInfo poiInfo2 = this.mediaOriginPoiInfo;
            if (poiInfo2 != null) {
                i3 = poiInfo2.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "LocationSelector(qqPermission=" + this.qqPermission + ", fragment=" + this.fragment + ", currentPoiInfos=" + this.currentPoiInfos + ", selectPoiInfo=" + this.selectPoiInfo + ", mediaOriginPoiInfo=" + this.mediaOriginPoiInfo + ")";
        }

        public /* synthetic */ LocationSelector(QQPermission qQPermission, Fragment fragment, List list, LbsDataV2.PoiInfo poiInfo, LbsDataV2.PoiInfo poiInfo2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(qQPermission, fragment, (i3 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 8) != 0 ? null : poiInfo, (i3 & 16) != 0 ? null : poiInfo2);
        }
    }
}
