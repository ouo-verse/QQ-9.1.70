package com.tencent.mobileqq.search.util;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0012J\u001a\u0010\u0015\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00142\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/search/util/ae;", "", "Lcom/tencent/mobileqq/search/util/g;", "listener", "", "i", "", "e", "g", "Lcom/tencent/mobileqq/soso/location/data/SosoLbsInfo;", "info", "", "b", "str", "c", "Landroid/app/Activity;", "context", "f", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", tl.h.F, "Landroid/content/Context;", "d", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ae {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ae f284991a = new ae();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/search/util/ae$a", "Lcom/tencent/mobileqq/soso/location/LbsManagerServiceOnLocationChangeListener;", "", "errCode", "Lcom/tencent/mobileqq/soso/location/data/SosoLbsInfo;", "info", "", "onLocationFinish", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a extends LbsManagerServiceOnLocationChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f284992a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(g gVar) {
            super("QQSearch", true);
            this.f284992a = gVar;
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int errCode, @Nullable SosoLbsInfo info) {
            Unit unit;
            if (info != null) {
                g gVar = this.f284992a;
                String b16 = ae.f284991a.b(info);
                if (QLog.isColorLevel()) {
                    QLog.d("SearchLBSUtils", 2, "getLocationInfoAsync onLocationFinish " + errCode);
                }
                if (gVar != null) {
                    gVar.a(errCode, b16);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit != null) {
                    return;
                }
            }
            g gVar2 = this.f284992a;
            if (gVar2 != null) {
                gVar2.a(errCode, "");
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    ae() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String b(SosoLbsInfo info) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(QCircleSchemeAttr.Polymerize.LAT, info.mLocation.mLat02);
            jSONObject.put("lon", info.mLocation.mLon02);
            jSONObject.put("nation", c(info.mLocation.nation));
            jSONObject.put("province", c(info.mLocation.province));
            jSONObject.put("city", c(info.mLocation.city));
            jSONObject.put("adcode", c(info.mLocation.cityCode));
            jSONObject.put("district", c(info.mLocation.district));
            jSONObject.put("town", c(info.mLocation.town));
            jSONObject.put("village", c(info.mLocation.village));
            jSONObject.put("street", c(info.mLocation.street));
            jSONObject.put("streetNo", c(info.mLocation.streetNo));
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "{\n            json.put(\"\u2026json.toString()\n        }");
            return jSONObject2;
        } catch (Exception e16) {
            QLog.e("SearchLBSUtils", 1, "getLbsInfo Failed!", e16);
            return "";
        }
    }

    private final String c(String str) {
        if (str == null || Intrinsics.areEqual("Unknown", str)) {
            return "";
        }
        return str;
    }

    private final boolean e() {
        if (com.tencent.mobileqq.search.searchdetail.r.f284572a.a().getApplication().checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("SearchLBSUtils", 2, "hasLocationPermission no permission ");
                return false;
            }
            return false;
        }
        return true;
    }

    private final boolean g() {
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        Object systemService = context.getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        LocationManager locationManager = (LocationManager) systemService;
        boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
        boolean isProviderEnabled2 = locationManager.isProviderEnabled("network");
        if (!isProviderEnabled && !isProviderEnabled2) {
            return false;
        }
        return true;
    }

    private final void i(g listener) {
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new a(listener));
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0022, code lost:
    
        if (r2 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(@Nullable Context context, @Nullable g listener) {
        Unit unit;
        SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("QQSearch");
        if (cachedLbsInfo != null) {
            if (listener != null) {
                listener.a(0, f284991a.b(cachedLbsInfo));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
        }
        if (listener != null) {
            listener.a(0, "");
            Unit unit2 = Unit.INSTANCE;
        }
        QLog.d("SearchLBSUtils", 4, "getLocationInfoAsync cache ", cachedLbsInfo);
        ThreadManagerV2.getSubThread();
        ae aeVar = f284991a;
        if (aeVar.e() && aeVar.g()) {
            aeVar.i(null);
        }
    }

    public final boolean f(@NotNull Activity context) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        int hasPermission = QQPermissionFactory.getQQPermission(context, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_BIG_SEARCH, QQPermissionConstants.Business.SCENE.SCENE_BIG_SEARCH)).hasPermission(QQPermissionConstants.Business.ID.QQ_BUSINESS_BIG_SEARCH, "android.permission.ACCESS_COARSE_LOCATION");
        if (hasPermission == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("SearchLBSUtils", 4, "hasPermission " + z16);
        if (hasPermission == 0) {
            return true;
        }
        return false;
    }

    public final void h(@NotNull Activity context, @NotNull QQPermission.BasePermissionsListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        boolean j3 = ah.j();
        QLog.d("SearchLBSUtils", 4, "requestPermission hasShow=" + j3);
        if (j3) {
            return;
        }
        BusinessConfig businessConfig = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_BIG_SEARCH, QQPermissionConstants.Business.SCENE.SCENE_BIG_SEARCH);
        ah.n();
        QQPermissionFactory.getQQPermission(context, businessConfig).requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 2, listener);
    }
}
