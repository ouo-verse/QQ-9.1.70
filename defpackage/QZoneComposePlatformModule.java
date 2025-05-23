package defpackage;

import com.qzone.common.account.LoginData;
import com.qzone.common.protocol.request.QZoneRequest;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import i01.e;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import vx.a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J?\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J\u0016\u0010\u000e\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0002JI\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0016\u00a8\u0006\u0016"}, d2 = {"LQZoneComposePlatformModule;", "Li01/e;", "", "businessId", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "c", "g", "Lkotlin/Function0;", "d", "", "method", "params", "call", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class QZoneComposePlatformModule extends e {

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016J\u0016\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\r"}, d2 = {"QZoneComposePlatformModule$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "deniedPermissions", "", "isShowGuide", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f25091a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<QQPermission> f25092b;

        b(Function0<Unit> function0, Ref.ObjectRef<QQPermission> objectRef) {
            this.f25091a = function0;
            this.f25092b = objectRef;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public boolean isShowGuide(List<String> deniedPermissions) {
            Intrinsics.checkNotNullParameter(deniedPermissions, "deniedPermissions");
            return false;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            this.f25091a.invoke();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> results) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(results, "results");
            super.onDenied(permissions, results);
            if (this.f25092b.element.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                this.f25091a.invoke();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"QZoneComposePlatformModule$c", "Lcom/tencent/mobileqq/soso/location/LbsManagerServiceOnLocationChangeListener;", "", "errCode", "Lcom/tencent/mobileqq/soso/location/data/SosoLbsInfo;", "info", "", "onLocationFinish", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class c extends LbsManagerServiceOnLocationChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f25093a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Object obj, Function1<Object, Unit> function1) {
            super((String) obj, false);
            this.f25093a = function1;
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int errCode, SosoLbsInfo info) {
            if (this.f25093a == null) {
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("error_code", Integer.valueOf(errCode));
            if ((info != null ? info.mLocation : null) != null) {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                SosoLocation sosoLocation = info.mLocation;
                double d16 = sosoLocation.mLat84;
                if (d16 == 0.0d) {
                    if (sosoLocation.mLon84 == 0.0d) {
                        linkedHashMap2.put("latitude", Double.valueOf(sosoLocation.mLat02));
                        linkedHashMap2.put("longitude", Double.valueOf(info.mLocation.mLon02));
                        linkedHashMap2.put("accuracy", Float.valueOf(info.mLocation.accuracy));
                        linkedHashMap2.put("altitude", Double.valueOf(info.mLocation.altitude));
                        linkedHashMap.put("lbs_data", linkedHashMap2);
                    }
                }
                linkedHashMap2.put("latitude", Double.valueOf(d16));
                linkedHashMap2.put("longitude", Double.valueOf(info.mLocation.mLon84));
                linkedHashMap2.put("accuracy", Float.valueOf(info.mLocation.accuracy));
                linkedHashMap2.put("altitude", Double.valueOf(info.mLocation.altitude));
                linkedHashMap.put("lbs_data", linkedHashMap2);
            }
            QLog.d("QZoneComposePlatformModule", 1, "startLocation finish in android, result: " + linkedHashMap);
            this.f25093a.invoke(linkedHashMap);
        }
    }

    private final void c(final Object businessId, final Function1<Object, Unit> callback) {
        d(new Function0<Unit>() { // from class: QZoneComposePlatformModule$checkAndLocation$1
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
                QZoneComposePlatformModule.this.g(businessId, callback);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.mobileqq.qqpermission.QQPermission, T] */
    private final void d(Function0<Unit> callback) {
        if (getActivity() == null) {
            return;
        }
        BusinessConfig businessConfig = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QZONE, QQPermissionConstants.Business.SCENE.QQ_QZONE_SELECT_LOCATION);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? qQPermission = QQPermissionFactory.getQQPermission(getActivity(), businessConfig);
        objectRef.element = qQPermission;
        if (!a.a(qQPermission)) {
            callback.invoke();
        } else {
            ((QQPermission) objectRef.element).requestPermissions(QQPermissionConstants.Permission.GROUP_LOCATION, 2, new b(callback, objectRef));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x002c. Please report as an issue. */
    @Override // i01.e, i01.a
    public Object call(String method, Object params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        QLog.d("QZoneComposePlatformModule", 1, "call method: " + method + ", params: " + params);
        switch (method.hashCode()) {
            case -2147329532:
                if (method.equals("getNickName")) {
                    return LoginData.getInstance().getNickName("");
                }
                return super.call(method, params, callback);
            case -1249352825:
                if (method.equals("getQUA")) {
                    return QUA.getQUA3();
                }
                return super.call(method, params, callback);
            case -1249348326:
                if (method.equals("getUid")) {
                    return LoginData.getInstance().getUid();
                }
                return super.call(method, params, callback);
            case -1249348316:
                if (method.equals("getUin")) {
                    return Long.valueOf(LoginData.getInstance().getUin());
                }
                return super.call(method, params, callback);
            case 730910445:
                if (method.equals("getPlatformDeviceInfo")) {
                    return QZoneRequest.getDeiviceInfoDetail(false);
                }
                return super.call(method, params, callback);
            case 2028160567:
                if (method.equals("startLocation")) {
                    c(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(Object businessId, Function1<Object, Unit> callback) {
        if (callback != null && businessId != null && (businessId instanceof String)) {
            QLog.d("QZoneComposePlatformModule", 1, "startLocation in android");
            ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new c(businessId, callback));
        } else {
            QLog.d("QZoneComposePlatformModule", 1, "startLocation error, businessId: " + businessId);
        }
    }
}
