package com.tencent.mobileqq.reminder.calendar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.MobileQQ;
import mqq.app.QQPermissionCallback;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    protected static final String[] f280941b;

    /* renamed from: a, reason: collision with root package name */
    private AppActivity f280942a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.reminder.calendar.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    class C8504a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQPermissionCallback f280943a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f280944b;

        C8504a(QQPermissionCallback qQPermissionCallback, int i3) {
            this.f280943a = qQPermissionCallback;
            this.f280944b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, qQPermissionCallback, Integer.valueOf(i3));
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
            QQPermissionCallback qQPermissionCallback = this.f280943a;
            if (qQPermissionCallback != null) {
                qQPermissionCallback.grant(this.f280944b, a.f280941b, new int[0]);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
                return;
            }
            super.onDenied(list, list2);
            if (this.f280943a != null) {
                String[] strArr = new String[list.size()];
                int[] iArr = new int[list2.size()];
                for (int i3 = 0; i3 < list.size(); i3++) {
                    strArr[i3] = list.get(i3);
                }
                for (int i16 = 0; i16 < list2.size(); i16++) {
                    iArr[i16] = list2.get(i16).intValue();
                }
                this.f280943a.deny(this.f280944b, strArr, iArr);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31735);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f280941b = new String[]{QQPermissionConstants.Permission.WRITE_CALENDAR};
        }
    }

    public a(AppActivity appActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appActivity);
        } else {
            this.f280942a = appActivity;
        }
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.f280942a.getPackageManager().checkPermission(f280941b[0], MobileQQ.PACKAGE_NAME) != 0) {
            return false;
        }
        return true;
    }

    public long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        long j3 = this.f280942a.getSharedPreferences(CalenderUtils.f280935d, 0).getLong("key_dialog_time", -1L);
        if (QLog.isColorLevel()) {
            QLog.d("QQReminder.CalenderUtils", 1, "last dialogTime:", Long.valueOf(j3));
        }
        return j3;
    }

    public void c(int i3, QQPermissionCallback qQPermissionCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) qQPermissionCallback);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (b() <= 0) {
            d(currentTimeMillis);
            QQPermissionFactory.getQQPermission(this.f280942a, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_REMINDER, QQPermissionConstants.Business.SCENE.READ_AND_WRITE_CALENDAR)).requestPermissions(f280941b, 2, new C8504a(qQPermissionCallback, i3));
        } else {
            qQPermissionCallback.deny(i3, f280941b, new int[]{0, 0});
        }
    }

    public void d(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQReminder.CalenderUtils", 1, "set last dialogTime:", Long.valueOf(j3));
        }
        this.f280942a.getSharedPreferences(CalenderUtils.f280935d, 0).edit().putLong("key_dialog_time", j3).apply();
    }
}
