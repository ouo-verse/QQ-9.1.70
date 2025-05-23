package com.tencent.qq.minibox.proxy;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import com.tencent.minibox.proxy.PermissionProxy;
import com.tencent.minibox.proxy.PermissionRequestCallback;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IGamePermissionManagerService;
import com.vivo.push.PushClientConstants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\u0018\u0000 \t2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b'\u0010(J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J8\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\"\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J7\u0010!\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016\u00a2\u0006\u0004\b!\u0010\"J \u0010#\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0016R\u0018\u0010&\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/qq/minibox/proxy/q;", "Lcom/tencent/minibox/proxy/PermissionProxy;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", QCircleDaTongConstant.ElementParamValue.PERMISSION, "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "c", "Lcom/tencent/qq/minibox/api/IGamePermissionManagerService;", "b", PushClientConstants.TAG_PKG_NAME, "", "clearPermissionRecord", "", "isPermissionAvailable", "isPermissionGranted", "isPermissionNeedUserGranted", "isPermissionProxyEnabled", "appName", "Landroid/graphics/drawable/Drawable;", "appIcon", "Lcom/tencent/minibox/proxy/PermissionRequestCallback;", "callback", "requestMiniBoxPermissionGranted", "", "requestSystemPermission", "qqPermission", "", "requestCode", "", "permissions", "", "grantResults", "onRequestSystemPermissionResult", "(Ljava/lang/Object;I[Ljava/lang/String;[I)V", "showPermissionSettingPage", "a", "Lcom/tencent/qq/minibox/api/IGamePermissionManagerService;", "mPermissionMgr", "<init>", "()V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class q implements PermissionProxy {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGamePermissionManagerService mPermissionMgr;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qq/minibox/proxy/q$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PermissionRequestCallback f344623a;

        b(PermissionRequestCallback permissionRequestCallback) {
            this.f344623a = permissionRequestCallback;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            this.f344623a.onResult(true);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            super.onDenied(permissions, results);
            this.f344623a.onResult(false);
        }
    }

    private final IGamePermissionManagerService b() {
        IGamePermissionManagerService iGamePermissionManagerService = this.mPermissionMgr;
        if (iGamePermissionManagerService != null) {
            return iGamePermissionManagerService;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("PermissionProxyImpl", 1, "getPermissionMgr: appRuntime get null.");
            return null;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IGamePermissionManagerService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026essConstant.ALL\n        )");
        IGamePermissionManagerService iGamePermissionManagerService2 = (IGamePermissionManagerService) runtimeService;
        this.mPermissionMgr = iGamePermissionManagerService2;
        return iGamePermissionManagerService2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0042, code lost:
    
        if (r7.equals("android.permission.ACCESS_COARSE_LOCATION") == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
    
        r7 = com.tencent.mobileqq.qqpermission.QQPermissionConstants.Business.ID.QQ_MINIAPP_MYSITE;
        r0 = com.tencent.mobileqq.qqpermission.QQPermissionConstants.Business.SCENE.MINIBOX_APP_LOCATION;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005d, code lost:
    
        if (r7.equals("android.permission.ACCESS_FINE_LOCATION") == false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final QQPermission c(Activity activity, String permission) {
        String str;
        String str2;
        boolean z16;
        switch (permission.hashCode()) {
            case -1888586689:
                break;
            case -406040016:
                if (permission.equals(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE)) {
                    str = QQPermissionConstants.Business.ID.QQ_PUBLIC_MINI_PERMISSION_READ_EXTERNAL_STORAGE;
                    str2 = QQPermissionConstants.Business.SCENE.MINIBOX_APP_READ_EXTERNAL;
                    break;
                }
                str = null;
                str2 = null;
                break;
            case -63024214:
                break;
            case 463403621:
                if (permission.equals(QQPermissionConstants.Permission.CAMERA)) {
                    str = QQPermissionConstants.Business.ID.QQ_PUBLIC_MINI_PERMISSION_CAMERA;
                    str2 = QQPermissionConstants.Business.SCENE.MINIBOX_APP_CAMERA;
                    break;
                }
                str = null;
                str2 = null;
                break;
            case 1365911975:
                if (permission.equals(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE)) {
                    str = QQPermissionConstants.Business.ID.QQ_MINIAPP_SAVE;
                    str2 = QQPermissionConstants.Business.SCENE.MINIBOX_APP_WRITE_EXTERNAL;
                    break;
                }
                str = null;
                str2 = null;
                break;
            case 1831139720:
                if (permission.equals(QQPermissionConstants.Permission.RECORD_AUDIO)) {
                    str = QQPermissionConstants.Business.ID.QQ_PUBLIC_MINI_PERMISSION_RECORD_AUDIO;
                    str2 = QQPermissionConstants.Business.SCENE.MINIBOX_APP_RECORD_AUDIO;
                    break;
                }
                str = null;
                str2 = null;
                break;
            default:
                str = null;
                str2 = null;
                break;
        }
        boolean z17 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (str2 == null || str2.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                return QQPermissionFactory.getQQPermission(activity, new BusinessConfig(str, str2));
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(PermissionRequestCallback callback, boolean z16) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.onResult(z16);
    }

    @Override // com.tencent.minibox.proxy.PermissionProxy
    public void clearPermissionRecord(@NotNull String pkgName) {
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        IGamePermissionManagerService b16 = b();
        if (b16 != null) {
            b16.clearPermissionStatusAsyn(pkgName);
        }
    }

    @Override // com.tencent.minibox.proxy.PermissionProxy
    public boolean isPermissionAvailable(@NotNull String pkgName, @NotNull String permission) {
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(permission, "permission");
        IGamePermissionManagerService b16 = b();
        if (b16 != null) {
            return b16.isPermissionDefined(permission);
        }
        return true;
    }

    @Override // com.tencent.minibox.proxy.PermissionProxy
    public boolean isPermissionGranted(@NotNull String pkgName, @NotNull String permission) {
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(permission, "permission");
        IGamePermissionManagerService b16 = b();
        if (b16 == null || b16.queryPermissionStatus(pkgName, permission) != 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.minibox.proxy.PermissionProxy
    public boolean isPermissionNeedUserGranted(@NotNull String pkgName, @NotNull String permission) {
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(permission, "permission");
        IGamePermissionManagerService b16 = b();
        if (b16 == null || b16.queryPermissionStatus(pkgName, permission) != 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.minibox.proxy.PermissionProxy
    public boolean isPermissionProxyEnabled() {
        return true;
    }

    @Override // com.tencent.minibox.proxy.PermissionProxy
    public void onRequestSystemPermissionResult(@Nullable Object qqPermission, int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (qqPermission != null && (qqPermission instanceof QQPermission)) {
            ((QQPermission) qqPermission).onRequestPermissionResult(requestCode, permissions, grantResults);
        }
    }

    @Override // com.tencent.minibox.proxy.PermissionProxy
    public void requestMiniBoxPermissionGranted(@NotNull Activity activity, @NotNull String pkgName, @NotNull String appName, @NotNull Drawable appIcon, @NotNull String permission, @NotNull final PermissionRequestCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(appIcon, "appIcon");
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IGamePermissionManagerService b16 = b();
        if (b16 != null) {
            b16.showPermissionConfirmDialog(activity, appIcon, pkgName, appName, permission, new bs3.a() { // from class: com.tencent.qq.minibox.proxy.p
                @Override // bs3.a
                public final void onConfirmResult(boolean z16) {
                    q.d(PermissionRequestCallback.this, z16);
                }
            });
        }
    }

    @Override // com.tencent.minibox.proxy.PermissionProxy
    @Nullable
    public Object requestSystemPermission(@NotNull Activity activity, @NotNull String permission, @NotNull PermissionRequestCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QQPermission c16 = c(activity, permission);
        if (c16 == null) {
            callback.onResult(false);
        } else {
            c16.requestPermissions(new String[]{permission}, 2, new b(callback));
        }
        return c16;
    }

    @Override // com.tencent.minibox.proxy.PermissionProxy
    public void showPermissionSettingPage(@NotNull Activity activity, @NotNull String pkgName, @NotNull String appName) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intent intent = new Intent();
        intent.putExtra(IGamePermissionManagerService.INTENT_KEY_GAME_ID, pkgName);
        intent.putExtra(IGamePermissionManagerService.INTENT_KEY_GAME_NAME, appName);
        IGamePermissionManagerService b16 = b();
        if (b16 != null) {
            b16.startPermissionSettingFragment(activity, intent);
        }
    }
}
