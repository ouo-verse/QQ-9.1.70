package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.IPermissionManagerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.Permissions;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@ProxyService(proxy = IPermissionManagerProxy.class)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J'\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J-\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0015J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/au;", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/IPermissionManagerProxy;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqmini/sdk/launcher/core/proxy/Permissions;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "a", "", "", "b", "(Landroid/app/Activity;[Ljava/lang/String;)Lcom/tencent/mobileqq/qqpermission/QQPermission;", "d", "c", "", "isPermissionGranted", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/RequestPermissionCallback;", "callbacks", "", "requestForPermission", "permissionStr", "(Landroid/app/Activity;[Ljava/lang/String;Lcom/tencent/qqmini/sdk/launcher/core/proxy/RequestPermissionCallback;)V", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class au implements IPermissionManagerProxy {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f347830a;

        static {
            int[] iArr = new int[Permissions.values().length];
            try {
                iArr[Permissions.WRITE_EXTERNAL_STORAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Permissions.ACCESS_FINE_LOCATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Permissions.ACCESS_COARSE_LOCATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Permissions.READ_EXTERNAL_STORAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Permissions.CAMERA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Permissions.RECORD_AUDIO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f347830a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J(\u0010\u000b\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/qqmini/proxyimpl/au$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "uncertainPermission", "onUncertain", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestPermissionCallback f347831a;

        c(RequestPermissionCallback requestPermissionCallback) {
            this.f347831a = requestPermissionCallback;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            this.f347831a.onSuccess();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> results) {
            this.f347831a.onFail();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onUncertain(String uncertainPermission) {
            this.f347831a.onFail();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J(\u0010\u000b\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/qqmini/proxyimpl/au$d", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "uncertainPermission", "onUncertain", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestPermissionCallback f347832a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQPermission f347833b;

        d(RequestPermissionCallback requestPermissionCallback, QQPermission qQPermission) {
            this.f347832a = requestPermissionCallback;
            this.f347833b = qQPermission;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            this.f347832a.onSuccess();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> results) {
            if (this.f347833b.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                QLog.d("PermissionManagerImpl", 1, "onDenied but grant ACCESS_COARSE_LOCATION");
                this.f347832a.onPartialGrant();
            } else {
                this.f347832a.onFail();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onUncertain(String uncertainPermission) {
            this.f347832a.onFail();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J(\u0010\u000b\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/qqmini/proxyimpl/au$e", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "uncertainPermission", "onUncertain", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestPermissionCallback f347834a;

        e(RequestPermissionCallback requestPermissionCallback) {
            this.f347834a = requestPermissionCallback;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            this.f347834a.onSuccess();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> results) {
            this.f347834a.onFail();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onUncertain(String uncertainPermission) {
            this.f347834a.onFail();
        }
    }

    private final QQPermission a(Activity activity, Permissions permission) {
        return QQPermissionFactory.getQQPermission(activity, new BusinessConfig(c(permission), d(permission)));
    }

    private final QQPermission b(Activity activity, String[] permission) {
        return QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_MINIAPP_MYSITE, QQPermissionConstants.Business.SCENE.MOVE_TO_MAP_LOCATION));
    }

    private final String c(Permissions permission) {
        switch (b.f347830a[permission.ordinal()]) {
            case 1:
                return QQPermissionConstants.Business.ID.QQ_MINIAPP_SAVE;
            case 2:
            case 3:
                return QQPermissionConstants.Business.ID.QQ_MINIAPP_MYSITE;
            case 4:
                return QQPermissionConstants.Business.ID.QQ_PUBLIC_MINI_PERMISSION_READ_EXTERNAL_STORAGE;
            case 5:
                return QQPermissionConstants.Business.ID.QQ_PUBLIC_MINI_PERMISSION_CAMERA;
            case 6:
                return QQPermissionConstants.Business.ID.QQ_PUBLIC_MINI_PERMISSION_RECORD_AUDIO;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final String d(Permissions permission) {
        switch (b.f347830a[permission.ordinal()]) {
            case 1:
                return QQPermissionConstants.Business.SCENE.SAVE_PIC_TO_ALBUM;
            case 2:
            case 3:
                return QQPermissionConstants.Business.SCENE.MOVE_TO_MAP_LOCATION;
            case 4:
                return QQPermissionConstants.Business.SCENE.READ_EXTERNAL_STORAGE;
            case 5:
                return "camera";
            case 6:
                return QQPermissionConstants.Business.SCENE.RECORD_AUDIO;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IPermissionManagerProxy
    public boolean isPermissionGranted(Activity activity, Permissions permission) {
        String b16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permission, "permission");
        b16 = av.b(permission);
        QQPermission a16 = a(activity, permission);
        return a16 != null && a16.hasPermission(b16) == 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IPermissionManagerProxy
    public void requestForPermission(Activity activity, Permissions permission, RequestPermissionCallback callbacks) {
        String b16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        QQPermission a16 = a(activity, permission);
        if (a16 != null) {
            b16 = av.b(permission);
            a16.requestPermissions(new String[]{b16}, 2, new c(callbacks));
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IPermissionManagerProxy
    public void requestForPermission(Activity activity, String[] permissionStr, RequestPermissionCallback callbacks) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissionStr, "permissionStr");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        QLog.d("PermissionManagerImpl", 1, "requestForPermission");
        QQPermission b16 = b(activity, permissionStr);
        if (b16 != null) {
            b16.requestPermissions(permissionStr, 2, new d(callbacks, b16));
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IPermissionManagerProxy
    public void requestForPermission(Activity activity, String permissionStr, RequestPermissionCallback callbacks) {
        int lastIndexOf$default;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissionStr, "permissionStr");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        if (TextUtils.isEmpty(permissionStr)) {
            return;
        }
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) permissionStr, ".", 0, false, 6, (Object) null);
        QLog.i(AppLoaderFactory.TAG, 1, "requestForPermission permissionStr : " + permissionStr);
        String substring = permissionStr.substring(lastIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        QQPermission a16 = a(activity, Permissions.valueOf(substring));
        if (a16 != null) {
            a16.requestPermissions(new String[]{permissionStr}, 2, new e(callbacks));
        }
    }
}
