package com.tencent.mobileqq.activity.phone;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.PermissionPageUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.IReqPermissionRunnable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DenyRunnable implements IReqPermissionRunnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<Context> f183855d;

    /* renamed from: e, reason: collision with root package name */
    private long f183856e;

    /* renamed from: f, reason: collision with root package name */
    private b f183857f;

    /* renamed from: h, reason: collision with root package name */
    private int f183858h;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a implements b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<QQAppInterface> f183859a;

        /* renamed from: b, reason: collision with root package name */
        private int f183860b;

        public a(QQAppInterface qQAppInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            } else {
                this.f183860b = 2;
                this.f183859a = new WeakReference<>(qQAppInterface);
            }
        }

        @Override // com.tencent.mobileqq.activity.phone.DenyRunnable.b
        public void onCancel(Context context, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(z16));
                return;
            }
            if (!z16) {
                if (VersionUtils.isM()) {
                    QQAppInterface qQAppInterface = this.f183859a.get();
                    if (qQAppInterface != null) {
                        ((IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "")).markOrClearUserSettingFlag(true);
                    }
                    PermissionPageUtil permissionPageUtil = new PermissionPageUtil(context, context.getPackageName());
                    try {
                        permissionPageUtil.d();
                        return;
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                        permissionPageUtil.h();
                        return;
                    }
                }
                Intent intent = new Intent(context, (Class<?>) GuideBindPhoneActivity.class);
                intent.putExtra("fromKeyForContactBind", this.f183860b);
                context.startActivity(intent);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b {
        void onCancel(Context context, boolean z16);
    }

    public DenyRunnable(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
            return;
        }
        this.f183856e = 0L;
        this.f183857f = null;
        this.f183858h = 0;
        this.f183855d = new WeakReference<>(context);
        this.f183858h = i3;
    }

    @Override // com.tencent.mobileqq.phonecontact.permission.IReqPermissionRunnable
    public void Wf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f183856e = SystemClock.elapsedRealtime();
        if (QLog.isColorLevel()) {
            QLog.i("DenyRunnable", 2, "onReqPermission: " + this.f183856e);
        }
    }

    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        Context context = this.f183855d.get();
        if (QLog.isColorLevel()) {
            QLog.i("DenyRunnable", 2, String.format("defaultAction [%s, %s]", Boolean.valueOf(z16), context));
        }
        if (context != null && !z16) {
            Intent intent = new Intent(context, (Class<?>) GuideBindPhoneActivity.class);
            intent.putExtra("fromKeyForContactBind", this.f183858h);
            context.startActivity(intent);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = this.f183856e;
        long j16 = elapsedRealtime - j3;
        if (j3 != 0 && Math.abs(j16) >= 800) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("DenyRunnable", 2, String.format("run [%s, %s, %s]", Long.valueOf(this.f183856e), Long.valueOf(j16), Boolean.valueOf(z16)));
        }
        b bVar = this.f183857f;
        if (bVar != null) {
            bVar.onCancel(this.f183855d.get(), z16);
        } else {
            b(z16);
        }
    }

    public DenyRunnable(Context context, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) bVar);
            return;
        }
        this.f183856e = 0L;
        this.f183857f = null;
        this.f183858h = 0;
        this.f183855d = new WeakReference<>(context);
        this.f183857f = bVar;
    }
}
