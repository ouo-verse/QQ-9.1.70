package com.tencent.mobileqq.equipmentlock;

import android.content.Context;
import android.content.DialogInterface;
import android.text.format.Time;
import com.tencent.ims.devlock_mobile_phone$status;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static int f205355c;

    /* renamed from: d, reason: collision with root package name */
    public static int f205356d;

    /* renamed from: e, reason: collision with root package name */
    public static int f205357e;

    /* renamed from: f, reason: collision with root package name */
    public static int f205358f;

    /* renamed from: g, reason: collision with root package name */
    public static int f205359g;

    /* renamed from: h, reason: collision with root package name */
    private static a f205360h;

    /* renamed from: a, reason: collision with root package name */
    private int f205361a;

    /* renamed from: b, reason: collision with root package name */
    private long f205362b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.equipmentlock.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class DialogInterfaceOnClickListenerC7507a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        DialogInterfaceOnClickListenerC7507a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27288);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f205355c = -1;
        f205356d = 0;
        f205357e = 1;
        f205358f = 2;
        f205359g = 3;
        f205360h = null;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f205361a = -1;
            this.f205362b = 0L;
        }
    }

    public static a b() {
        if (f205360h == null) {
            f205360h = new a();
        }
        return f205360h;
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f205361a;
    }

    public void c(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
        } else {
            this.f205362b = j3;
        }
    }

    public void d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DevlockPhoneStatus", 2, "pre:" + this.f205361a + " now:" + i3);
        }
        this.f205361a = i3;
    }

    public void e(Context context, String str) {
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) str);
            return;
        }
        DialogInterfaceOnClickListenerC7507a dialogInterfaceOnClickListenerC7507a = new DialogInterfaceOnClickListenerC7507a();
        String string2 = context.getString(R.string.azt);
        String string3 = context.getString(R.string.azg);
        long j3 = this.f205362b * 1000;
        if (j3 > 0) {
            Time time = new Time();
            time.set(j3);
            string = String.format(context.getString(R.string.azr), Integer.valueOf(time.year), Integer.valueOf(time.month + 1), Integer.valueOf(time.monthDay), Integer.valueOf(time.hour), Integer.valueOf(time.minute));
        } else {
            string = context.getString(R.string.azs);
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, string2, String.format(context.getString(R.string.azq), str, string), null, dialogInterfaceOnClickListenerC7507a);
        if (createCustomDialog != null) {
            createCustomDialog.setNegativeButton(string3, dialogInterfaceOnClickListenerC7507a);
            createCustomDialog.show();
        }
    }

    public void f(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bArr);
            return;
        }
        this.f205361a = f205355c;
        this.f205362b = 0L;
        if (bArr == null) {
            if (QLog.isColorLevel()) {
                QLog.d("DevlockPhoneStatus", 2, "info is null");
                return;
            }
            return;
        }
        try {
            devlock_mobile_phone$status devlock_mobile_phone_status = new devlock_mobile_phone$status();
            devlock_mobile_phone_status.mergeFrom(bArr);
            if (devlock_mobile_phone_status.u32_mb_mobile_state.has()) {
                this.f205361a = devlock_mobile_phone_status.u32_mb_mobile_state.get();
            }
            if (devlock_mobile_phone_status.u32_audit_time.has()) {
                this.f205362b = devlock_mobile_phone_status.u32_audit_time.get();
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("DevlockPhoneStatus", 2, "exception occurs");
            }
            th5.printStackTrace();
        }
    }
}
