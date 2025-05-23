package com.tencent.mobileqq.phonecontact.permission;

import android.app.Activity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.AppActivity;

/* loaded from: classes16.dex */
public class PermissionChecker {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static PermissionChecker f258485d;

    /* renamed from: a, reason: collision with root package name */
    private b f258486a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<com.tencent.mobileqq.phonecontact.permission.a> f258487b;

    /* renamed from: c, reason: collision with root package name */
    private Boolean f258488c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PermissionChecker.this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onAllGranted();
            QLog.d("IMCore.PhoneContact.PermissionChecker", 1, "CheckPermission user grant = ");
            PermissionChecker.this.j(true);
        }
    }

    PermissionChecker() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f258488c = null;
        }
    }

    private static int c() {
        if (VersionUtils.isM()) {
            BaseApplication.getContext();
            int i3 = 0;
            try {
                QQPermission qQPermission = QQPermissionFactory.getQQPermission(QBaseActivity.sTopActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_PHONECONTACT, QQPermissionConstants.Business.SCENE.PHONECONTACT_OPEN_PAGE));
                if (qQPermission == null) {
                    return 0;
                }
                if (qQPermission.hasPermission(QQPermissionConstants.Permission.READ_CONTACTS) == 0) {
                    i3 = 1;
                }
                if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_CONTACTS) == 0) {
                    return i3 | 2;
                }
                return i3;
            } catch (Throwable th5) {
                QLog.d("IMCore.PhoneContact.PermissionChecker", 2, "CheckPermission exception:" + th5.getMessage());
                return i3;
            }
        }
        return 7;
    }

    public static boolean d(String str) {
        QQPermission qQPermission;
        if (!VersionUtils.isM()) {
            return true;
        }
        try {
            qQPermission = QQPermissionFactory.getQQPermission(QBaseActivity.sTopActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_PHONECONTACT, QQPermissionConstants.Business.SCENE.PHONECONTACT_OPEN_PAGE));
        } catch (Throwable th5) {
            QLog.d("IMCore.PhoneContact.PermissionChecker", 2, "CheckPermission exception:" + th5.getMessage());
        }
        if (qQPermission == null) {
            return false;
        }
        if (qQPermission.hasPermission(str) == 0) {
            return true;
        }
        return false;
    }

    public static void e(Activity activity, Runnable runnable, Runnable runnable2) {
        if (activity == null) {
            if (QLog.isColorLevel()) {
                QLog.i("BindMsgConstant", 2, "checkReadContactPermission error");
                return;
            }
            return;
        }
        boolean f16 = h().f();
        if (QLog.isColorLevel()) {
            QLog.i("BindMsgConstant", 2, String.format("checkReadContactPermission [%s, %s]", Boolean.valueOf(f16), Boolean.valueOf(VersionUtils.isM())));
        }
        if (f16) {
            if (runnable != null) {
                runnable.run();
            }
        } else {
            if (VersionUtils.isM()) {
                if (runnable2 instanceof IReqPermissionRunnable) {
                    ((IReqPermissionRunnable) runnable2).Wf();
                }
                b bVar = new b();
                bVar.f258491b = runnable;
                bVar.f258492c = runnable2;
                bVar.f258493d = 1;
                h().k(activity, bVar, null, QQPermissionConstants.Permission.READ_CONTACTS, QQPermissionConstants.Permission.WRITE_CONTACTS);
                return;
            }
            if (runnable2 != null) {
                runnable2.run();
            }
        }
    }

    public static PermissionChecker h() {
        if (f258485d == null) {
            synchronized (PermissionChecker.class) {
                f258485d = new PermissionChecker();
            }
        }
        return f258485d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z16) {
        com.tencent.mobileqq.phonecontact.permission.a aVar;
        b bVar = this.f258486a;
        if (bVar != null) {
            bVar.f258494e = c();
            QLog.d("IMCore.PhoneContact.PermissionChecker", 1, "onPermissionResult = " + this.f258486a.f258494e);
            WeakReference<com.tencent.mobileqq.phonecontact.permission.a> weakReference = this.f258487b;
            if (weakReference == null) {
                aVar = null;
            } else {
                aVar = weakReference.get();
            }
            if (aVar != null) {
                aVar.a(z16, this.f258486a);
            } else {
                this.f258486a.b(z16);
            }
        }
        this.f258486a = null;
    }

    private void l(Activity activity, String[] strArr) {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_PHONECONTACT, QQPermissionConstants.Business.SCENE.PHONECONTACT_OPEN_PAGE));
        if (qQPermission == null) {
            return;
        }
        qQPermission.requestPermissions(strArr, 2, new a());
    }

    public boolean f() {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (VersionUtils.isM()) {
            z18 = d(QQPermissionConstants.Permission.READ_CONTACTS);
            z16 = z18;
            z17 = true;
        } else {
            z16 = false;
            z17 = false;
            z18 = true;
        }
        this.f258488c = Boolean.valueOf(z18);
        QLog.d("IMCore.PhoneContact.PermissionChecker", 1, String.format("hasReadContactPermission isM=%b ret=%b apiRet=%b", Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z16)));
        return z18;
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (VersionUtils.isM()) {
            this.f258488c = Boolean.valueOf(d(QQPermissionConstants.Permission.READ_CONTACTS));
        } else if (this.f258488c == null) {
            this.f258488c = Boolean.TRUE;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.phonecontact.permission.PermissionChecker.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PermissionChecker.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    PermissionChecker permissionChecker = PermissionChecker.this;
                    permissionChecker.f258488c = Boolean.valueOf(permissionChecker.f());
                }
            }
        }, 16, null, true);
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.PhoneContact.PermissionChecker", 2, String.format("hasReadContactPermissionForUI isM=%b has=%b", Boolean.valueOf(VersionUtils.isM()), this.f258488c));
        }
        return this.f258488c.booleanValue();
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f258486a = null;
        }
    }

    public void k(Activity activity, b bVar, com.tencent.mobileqq.phonecontact.permission.a aVar, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, bVar, aVar, strArr);
            return;
        }
        if (strArr != null && strArr.length != 0) {
            try {
                if (activity instanceof AppActivity) {
                    AppActivity appActivity = (AppActivity) activity;
                    if (bVar == null) {
                        bVar = new b();
                    }
                    StringBuilder sb5 = new StringBuilder(512);
                    ArrayList arrayList = new ArrayList();
                    for (String str : strArr) {
                        arrayList.add(str);
                        sb5.append(str);
                        sb5.append(",");
                    }
                    bVar.f258490a = arrayList;
                    this.f258486a = bVar;
                    this.f258487b = null;
                    if (aVar != null) {
                        this.f258487b = new WeakReference<>(aVar);
                    }
                    QLog.d("IMCore.PhoneContact.PermissionChecker", 1, "requestPermissions = " + sb5.toString());
                    l(appActivity, strArr);
                    return;
                }
                QLog.d("IMCore.PhoneContact.PermissionChecker", 1, "requestPermissions| activity is not AppActivity");
            } catch (Throwable th5) {
                QLog.d("IMCore.PhoneContact.PermissionChecker", 1, "requestPermissions exception:" + th5.getMessage(), th5);
            }
        }
    }
}
