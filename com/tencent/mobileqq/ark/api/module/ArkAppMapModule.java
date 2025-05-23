package com.tencent.mobileqq.ark.api.module;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ark;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.module.b;
import com.tencent.mobileqq.ark.module.e;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.mapview.QTextureMapView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes11.dex */
public class ArkAppMapModule extends b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ark.api.module.ArkAppMapModule$2, reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TencentMap f198944d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QTextureMapView f198945e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ViewGroup f198946f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f198947h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f198948i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f198949m;

        AnonymousClass2(TencentMap tencentMap, QTextureMapView qTextureMapView, ViewGroup viewGroup, long j3, String str, String str2) {
            this.f198944d = tencentMap;
            this.f198945e = qTextureMapView;
            this.f198946f = viewGroup;
            this.f198947h = j3;
            this.f198948i = str;
            this.f198949m = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f198944d.snapshot(new TencentMap.SnapshotReadyCallback() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppMapModule.2.1
                @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.SnapshotReadyCallback
                public void onSnapshotReady(final Bitmap bitmap) {
                    QLog.e("ark.map.module", 1, "Map.snapShot is onSnapshotReady");
                    QTextureMapView qTextureMapView = AnonymousClass2.this.f198945e;
                    if (qTextureMapView != null) {
                        qTextureMapView.onDestroy();
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        anonymousClass2.f198946f.removeView(anonymousClass2.f198945e);
                    }
                    if (bitmap == null) {
                        QLog.e("ark.map.module", 1, "Map.snapShot bitmap is null");
                        AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                        ArkAppMapModule.this.z(null, anonymousClass22.f198947h);
                        return;
                    }
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppMapModule.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2 anonymousClass23 = AnonymousClass2.this;
                            ArkAppMapModule.this.y(anonymousClass23.f198948i, bitmap);
                            AnonymousClass2 anonymousClass24 = AnonymousClass2.this;
                            ArkAppMapModule.this.z(anonymousClass24.f198949m, anonymousClass24.f198947h);
                        }
                    }, 16, null, true);
                }
            }, Bitmap.Config.ARGB_8888, 3000);
        }
    }

    public ArkAppMapModule(ark.Application application, int i3) {
        super(application, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(TencentMap tencentMap, Activity activity, LatLng latLng, boolean z16) {
        if (z16) {
            tencentMap.setMapType(1008);
        }
        tencentMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(activity.getLayoutInflater().inflate(R.layout.fgr, (ViewGroup) null))).position(latLng).snippet("")).showInfoWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(TencentMap tencentMap, String str, ViewGroup viewGroup, QTextureMapView qTextureMapView, long j3, String str2) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new AnonymousClass2(tencentMap, qTextureMapView, viewGroup, j3, str, str2), 1000L);
    }

    private void x(ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        if (variantWrapperArr != null && variantWrapperArr.length >= 4) {
            final long g16 = g(variantWrapperArr[3].Copy());
            QLog.i("ArkApp", 1, "Map.mapSnapShot :lat=" + variantWrapperArr[0].GetDouble() + " lng=" + variantWrapperArr[1].GetDouble());
            final double GetDouble = variantWrapperArr[0].GetDouble();
            final double GetDouble2 = variantWrapperArr[1].GetDouble();
            final boolean GetBool = variantWrapperArr[2].GetBool();
            ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppMapModule.1
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    String appResPath = ArkEnvironmentManager.getInstance().getAppResPath(((b) ArkAppMapModule.this).f199566b);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("map_");
                    sb5.append(GetDouble);
                    sb5.append("_");
                    sb5.append(GetDouble2);
                    sb5.append("_");
                    if (GetBool) {
                        str = "true";
                    } else {
                        str = "false";
                    }
                    sb5.append(str);
                    sb5.append(".jpg");
                    String sb6 = sb5.toString();
                    String str2 = appResPath + "/" + sb6;
                    String str3 = "res:" + sb6;
                    Activity f16 = b.f();
                    if (f16 != null && !f16.isFinishing()) {
                        double d16 = GetDouble;
                        if (d16 >= -90.0d && d16 <= 90.0d) {
                            double d17 = GetDouble2;
                            if (d17 >= -180.0d && d17 <= 180.0d) {
                                LatLng latLng = new LatLng(GetDouble, GetDouble2);
                                try {
                                    QTextureMapView qTextureMapView = new QTextureMapView(f16);
                                    ViewGroup viewGroup = (ViewGroup) f16.getWindow().getDecorView();
                                    viewGroup.addView(qTextureMapView, new ViewGroup.LayoutParams(ViewUtils.dpToPx(360.0f), ViewUtils.dpToPx(270.0f)));
                                    qTextureMapView.setAlpha(0.0f);
                                    qTextureMapView.setOpaque(false);
                                    TencentMap map = qTextureMapView.getMap();
                                    ArkAppMapModule.this.v(map, f16, latLng, GetBool);
                                    map.setOnCameraChangeListener(new a(map, str2, viewGroup, qTextureMapView, str3));
                                    map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                                    qTextureMapView.onStart();
                                    qTextureMapView.onResume();
                                    return;
                                } catch (Throwable th5) {
                                    QLog.e("ark.map.module", 1, "mapSnapShot error! " + QLog.getStackTraceString(th5));
                                    ArkAppMapModule.this.z(null, g16);
                                    return;
                                }
                            }
                        }
                        QLog.e("ark.map.module", 1, "Map.snapShot lat or lng is invalid!");
                        ArkAppMapModule.this.z(null, g16);
                        return;
                    }
                    QLog.e("ark.map.module", 1, "Map.snapShot top activity is null");
                    ArkAppMapModule.this.z(null, g16);
                }

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.ark.api.module.ArkAppMapModule$1$a */
                /* loaded from: classes11.dex */
                class a implements TencentMap.OnCameraChangeListener {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ TencentMap f198938d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f198939e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ ViewGroup f198940f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ QTextureMapView f198941h;

                    /* renamed from: i, reason: collision with root package name */
                    final /* synthetic */ String f198942i;

                    a(TencentMap tencentMap, String str, ViewGroup viewGroup, QTextureMapView qTextureMapView, String str2) {
                        this.f198938d = tencentMap;
                        this.f198939e = str;
                        this.f198940f = viewGroup;
                        this.f198941h = qTextureMapView;
                        this.f198942i = str2;
                    }

                    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
                    public void onCameraChangeFinished(CameraPosition cameraPosition) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        ArkAppMapModule.this.w(this.f198938d, this.f198939e, this.f198940f, this.f198941h, g16, this.f198942i);
                    }

                    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
                    public void onCameraChange(CameraPosition cameraPosition) {
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, Bitmap bitmap) {
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException unused) {
            QLog.e("ark.map.module", 1, "saveImage is error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final String str, final long j3) {
        ArkDispatchTask.getInstance().post(this.f199566b, new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppMapModule.3
            @Override // java.lang.Runnable
            public void run() {
                ark.VariantWrapper l3 = ArkAppMapModule.this.l(j3);
                if (l3 == null) {
                    QLog.e("ark.map.module", 1, "setSnapshotResult cb is null!");
                    return;
                }
                ark.VariantWrapper Create = l3.Create();
                Create.SetNull();
                ark.VariantWrapper Create2 = l3.Create();
                Create.SetString(str);
                l3.InvokeDefault(new ark.VariantWrapper[]{Create}, Create2);
                Create2.Reset();
                Create.Reset();
                l3.Reset();
                QLog.i("ark.map.module", 1, "Map.snapShot callback path is : " + str);
            }
        });
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public void Destruct() {
        super.Destruct();
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public String GetTypeName() {
        return "QQMap";
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean HasMethod(String str) {
        return str.equals("Snapshot");
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean Invoke(String str, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        if (str.equals("Snapshot")) {
            x(variantWrapperArr, variantWrapper);
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ark.map.module", 1, "Invoke method is error!");
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    protected e[] e() {
        return null;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    public boolean n() {
        return true;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    public boolean o() {
        return false;
    }
}
