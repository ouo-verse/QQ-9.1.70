package pb2;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.newnearby.impl.NearbyReportHelperImpl;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes34.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static SosoLbsInfo f425859a;

    /* renamed from: b, reason: collision with root package name */
    private static long f425860b;

    /* renamed from: c, reason: collision with root package name */
    private static long f425861c;

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Promise f425862a;

        a(Promise promise) {
            this.f425862a = promise;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            b.g(this.f425862a);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            this.f425862a.reject("user deny location permission");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: pb2.b$b, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    public class C10995b extends SosoInterfaceOnLocationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Promise f425863a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10995b(int i3, boolean z16, boolean z17, long j3, boolean z18, boolean z19, String str, Promise promise) {
            super(i3, z16, z17, j3, z18, z19, str);
            this.f425863a = promise;
        }

        @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            if (i3 == 0 && sosoLbsInfo != null) {
                b.f425859a = sosoLbsInfo;
                ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setNearbyLastLocation(b.c().getCurrentAccountUin(), sosoLbsInfo);
                if (b.f425859a.mLocation != null) {
                    ob2.a.a(this.f425863a, b.f425859a);
                    NearbyReportHelperImpl.reportRequestLocation(true, true);
                    return;
                } else {
                    QLog.d("NearbyLocationImpl", 2, "requestLBS: location info is null");
                    this.f425863a.reject("location info is null");
                    return;
                }
            }
            QLog.d("NearbyLocationImpl", 2, "ISosoInterfaceApi location fail");
            this.f425863a.reject("ISosoInterfaceApi location fail");
        }
    }

    static /* bridge */ /* synthetic */ AppInterface c() {
        return e();
    }

    private static AppInterface e() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (MobileQQ.sProcessId == 7 && waitAppRuntime != null) {
            waitAppRuntime = waitAppRuntime.getAppRuntime("modular_web");
        }
        if (waitAppRuntime instanceof AppInterface) {
            return (AppInterface) waitAppRuntime;
        }
        return null;
    }

    public static void f(QBaseActivity qBaseActivity, Promise promise) {
        SosoLocation sosoLocation;
        if (System.currentTimeMillis() - f425861c < 5000) {
            return;
        }
        f425861c = System.currentTimeMillis();
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(qBaseActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_NEARBY, QQPermissionConstants.Business.SCENE.NEARBY_ENTER_HOME_PAGE));
        if (qQPermission == null) {
            return;
        }
        if (qQPermission.hasPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            QLog.d("NearbyLocationImpl", 1, "ACCESS_COARSE_LOCATION permission not granted!");
            qQPermission.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 2, new a(promise));
            return;
        }
        if (System.currentTimeMillis() - f425860b > MiniBoxNoticeInfo.MIN_5) {
            g(promise);
            return;
        }
        SosoLbsInfo sosoLbsInfo = f425859a;
        if (sosoLbsInfo != null && sosoLbsInfo.mLocation != null) {
            NearbyReportHelperImpl.reportRequestLocation(true, false);
            ob2.a.a(promise, f425859a);
            return;
        }
        SosoLbsInfo nearbyLastLocation = ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getNearbyLastLocation(e().getCurrentAccountUin());
        if (nearbyLastLocation != null && (sosoLocation = nearbyLastLocation.mLocation) != null && sosoLocation.nation != null && sosoLocation.province != null && sosoLocation.city != null) {
            f425859a = nearbyLastLocation;
            ob2.a.a(promise, nearbyLastLocation);
            NearbyReportHelperImpl.reportRequestLocation(true, false);
        } else {
            QLog.d("NearbyLocationImpl", 2, "requestLBS: location info is null");
            g(promise);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Promise promise) {
        f425860b = System.currentTimeMillis();
        ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(new C10995b(3, true, false, MiniBoxNoticeInfo.MIN_5, true, false, "NearbyNowliveTab", promise));
    }
}
