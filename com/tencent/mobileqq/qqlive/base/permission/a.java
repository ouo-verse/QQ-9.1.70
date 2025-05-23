package com.tencent.mobileqq.qqlive.base.permission;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private QQPermission f271031a;

    /* renamed from: b, reason: collision with root package name */
    BusinessConfig f271032b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqlive.base.permission.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public class C8357a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQPermission.BasePermissionsListener f271033a;

        C8357a(QQPermission.BasePermissionsListener basePermissionsListener) {
            this.f271033a = basePermissionsListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) basePermissionsListener);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                this.f271033a.onAllGranted();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
            } else {
                super.onDenied(list, list2);
                this.f271033a.onDenied(list, list2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class b extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQPermission.BasePermissionsListener f271035a;

        b(QQPermission.BasePermissionsListener basePermissionsListener) {
            this.f271035a = basePermissionsListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) basePermissionsListener);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                this.f271035a.onAllGranted();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
            } else {
                super.onDenied(list, list2);
                this.f271035a.onDenied(list, list2);
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f271031a = null;
            this.f271032b = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_LIVE, QQPermissionConstants.Business.SCENE.QQ_LIVE_GAME);
        }
    }

    public static boolean c(Activity activity) {
        if (((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(MobileQQ.sMobileQQ)) {
            QLog.d("PermissionManager", 1, "the floating ball permission is granted");
            return true;
        }
        QLog.i("PermissionManager", 1, "show the permission dialog");
        if (activity != null) {
            ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).enterPermissionRequestDialog(activity);
            return false;
        }
        QLog.i("PermissionManager", 1, "activity is null");
        return false;
    }

    private void e(Activity activity, String[] strArr, QQPermission.BasePermissionsListener basePermissionsListener) {
        if (this.f271031a == null) {
            this.f271031a = QQPermissionFactory.getQQPermission(activity, this.f271032b);
        }
        if (strArr != null && strArr.length != 0) {
            this.f271031a.requestPermissions(strArr, 2, new b(basePermissionsListener));
        } else {
            QLog.d("PermissionManager", 1, "the permission is empty");
        }
    }

    private void f(Fragment fragment, String[] strArr, QQPermission.BasePermissionsListener basePermissionsListener) {
        if (this.f271031a == null) {
            this.f271031a = QQPermissionFactory.getQQPermission(fragment, this.f271032b);
        }
        if (strArr != null && strArr.length != 0) {
            this.f271031a.requestPermissions(strArr, 2, new C8357a(basePermissionsListener));
        } else {
            QLog.d("PermissionManager", 1, "the permission is empty");
        }
    }

    public void a(Fragment fragment, QQPermission.BasePermissionsListener basePermissionsListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fragment, (Object) basePermissionsListener);
            return;
        }
        String[] strArr = {QQPermissionConstants.Permission.RECORD_AUDIO};
        if (this.f271031a == null) {
            this.f271031a = QQPermissionFactory.getQQPermission(fragment, this.f271032b);
        }
        QQPermission qQPermission = this.f271031a;
        if (qQPermission == null) {
            QLog.d("PermissionManager", 1, "mQQPermission is null");
        } else if (qQPermission.hasPermission(QQPermissionConstants.Permission.RECORD_AUDIO) != 0) {
            f(fragment, strArr, basePermissionsListener);
        } else {
            basePermissionsListener.onAllGranted();
        }
    }

    public void b(Fragment fragment, QQPermission.BasePermissionsListener basePermissionsListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fragment, (Object) basePermissionsListener);
            return;
        }
        String[] strArr = {QQPermissionConstants.Permission.CAMERA};
        if (this.f271031a == null) {
            this.f271031a = QQPermissionFactory.getQQPermission(fragment, this.f271032b);
        }
        QQPermission qQPermission = this.f271031a;
        if (qQPermission == null) {
            QLog.d("PermissionManager", 1, "mQQPermission is null");
        } else if (qQPermission.hasPermission(QQPermissionConstants.Permission.CAMERA) != 0) {
            f(fragment, strArr, basePermissionsListener);
        } else {
            basePermissionsListener.onAllGranted();
        }
    }

    public void d(Fragment fragment, QQPermission.BasePermissionsListener basePermissionsListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) fragment, (Object) basePermissionsListener);
            return;
        }
        String[] strArr = {QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.RECORD_AUDIO};
        if (this.f271031a == null) {
            this.f271031a = QQPermissionFactory.getQQPermission(fragment, this.f271032b);
        }
        QQPermission qQPermission = this.f271031a;
        if (qQPermission == null) {
            QLog.d("PermissionManager", 1, "mQQPermission is null");
        } else if (qQPermission.hasPermission(QQPermissionConstants.Permission.CAMERA) == 0 && this.f271031a.hasPermission(QQPermissionConstants.Permission.RECORD_AUDIO) == 0) {
            basePermissionsListener.onAllGranted();
        } else {
            f(fragment, strArr, basePermissionsListener);
        }
    }

    public void g(Activity activity, QQPermission.BasePermissionsListener basePermissionsListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, (Object) basePermissionsListener);
            return;
        }
        String[] strArr = {QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE};
        if (this.f271031a == null) {
            this.f271031a = QQPermissionFactory.getQQPermission(activity, this.f271032b);
        }
        QQPermission qQPermission = this.f271031a;
        if (qQPermission == null) {
            QLog.d("PermissionManager", 1, "mQQPermission is null");
        } else if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0 && this.f271031a.hasPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0) {
            basePermissionsListener.onAllGranted();
        } else {
            e(activity, strArr, basePermissionsListener);
        }
    }

    public void h(Fragment fragment, QQPermission.BasePermissionsListener basePermissionsListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) fragment, (Object) basePermissionsListener);
            return;
        }
        String[] strArr = {QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE};
        if (this.f271031a == null) {
            this.f271031a = QQPermissionFactory.getQQPermission(fragment, this.f271032b);
        }
        QQPermission qQPermission = this.f271031a;
        if (qQPermission == null) {
            QLog.d("PermissionManager", 1, "mQQPermission is null");
        } else if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0 && this.f271031a.hasPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0) {
            basePermissionsListener.onAllGranted();
        } else {
            f(fragment, strArr, basePermissionsListener);
        }
    }

    public boolean i(Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) fragment)).booleanValue();
        }
        if (this.f271031a == null) {
            this.f271031a = QQPermissionFactory.getQQPermission(fragment, this.f271032b);
        }
        QQPermission qQPermission = this.f271031a;
        if (qQPermission == null) {
            QLog.d("PermissionManager", 1, "mQQPermission is null");
            return false;
        }
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.RECORD_AUDIO) != 0) {
            return false;
        }
        return true;
    }

    public boolean j(Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) fragment)).booleanValue();
        }
        if (this.f271031a == null) {
            this.f271031a = QQPermissionFactory.getQQPermission(fragment, this.f271032b);
        }
        QQPermission qQPermission = this.f271031a;
        if (qQPermission == null) {
            QLog.d("PermissionManager", 1, "mQQPermission is null");
            return false;
        }
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.CAMERA) != 0) {
            return false;
        }
        return true;
    }
}
