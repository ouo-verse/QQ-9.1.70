package com.tencent.aelight.camera.ae.flashshow.util;

import android.app.Activity;
import com.tencent.aelight.camera.aebase.QIMCameraCaptureActivity;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.QQPermissionCallback;

/* compiled from: P */
/* loaded from: classes32.dex */
public class m implements QQPermissionCallback {

    /* renamed from: d, reason: collision with root package name */
    private Activity f65120d;

    /* renamed from: e, reason: collision with root package name */
    private c f65121e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQPermission f65122a;

        a(QQPermission qQPermission) {
            this.f65122a = qQPermission;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            if (m.this.f65121e != null) {
                m.this.f65121e.onGetLocation();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            if (this.f65122a.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                QLog.d("LocationPermissionHelper", 2, "requestLocation onDenied but coarse granted:");
                if (m.this.f65121e != null) {
                    m.this.f65121e.onGetLocation();
                }
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            super.onDialogShow(permissionRequestDialog, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQPermission f65124a;

        b(QQPermission qQPermission) {
            this.f65124a = qQPermission;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            if (m.this.f65121e != null) {
                m.this.f65121e.onGetLocation();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            if (this.f65124a.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                QLog.d("LocationPermissionHelper", 2, "requestFineLocation onDenied but coarse granted:");
                if (m.this.f65121e != null) {
                    m.this.f65121e.onGetLocation();
                }
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            super.onDialogShow(permissionRequestDialog, list);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface c {
        void onGetLocation();
    }

    public m(Activity activity, c cVar) {
        this.f65120d = activity;
        this.f65121e = cVar;
    }

    public void b() {
        QQPermission qQPermission;
        Activity activity = this.f65120d;
        if (activity == null) {
            return;
        }
        boolean z16 = activity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
        QLog.d("LocationPermissionHelper", 2, "requestFineLocationPermission:" + z16);
        if (!z16) {
            Activity activity2 = this.f65120d;
            if (activity2 instanceof QIMCameraCaptureActivity) {
                qQPermission = ((QIMCameraCaptureActivity) activity2).z0();
            } else {
                qQPermission = QQPermissionFactory.getQQPermission(activity2, new BusinessConfig(QQPermissionConstants.Business.ID.GY_FLASH_SHOW_UNIT, QQPermissionConstants.Business.SCENE.GY_FLASH_SHOW_UNIT));
            }
            qQPermission.requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 2, new b(qQPermission));
            return;
        }
        c cVar = this.f65121e;
        if (cVar != null) {
            cVar.onGetLocation();
        }
    }

    public void c() {
        QQPermission qQPermission;
        Activity activity = this.f65120d;
        if (activity == null) {
            return;
        }
        boolean z16 = activity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || this.f65120d.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
        QLog.d("LocationPermissionHelper", 2, "requestLocationPermission:" + z16);
        if (!z16) {
            Activity activity2 = this.f65120d;
            if (activity2 instanceof QIMCameraCaptureActivity) {
                qQPermission = ((QIMCameraCaptureActivity) activity2).z0();
            } else {
                qQPermission = QQPermissionFactory.getQQPermission(activity2, new BusinessConfig(QQPermissionConstants.Business.ID.GY_FLASH_SHOW_UNIT, QQPermissionConstants.Business.SCENE.GY_FLASH_SHOW_UNIT));
            }
            qQPermission.requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 2, new a(qQPermission));
            return;
        }
        c cVar = this.f65121e;
        if (cVar != null) {
            cVar.onGetLocation();
        }
    }

    @Override // mqq.app.QQPermissionCallback
    public void deny(int i3, String[] strArr, int[] iArr) {
        DialogUtil.showPermissionSettingDialog2(this.f65120d, strArr, iArr);
    }

    @Override // mqq.app.QQPermissionCallback
    public void grant(int i3, String[] strArr, int[] iArr) {
        c cVar = this.f65121e;
        if (cVar != null) {
            cVar.onGetLocation();
        }
    }
}
