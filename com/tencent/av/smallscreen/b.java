package com.tencent.av.smallscreen;

import android.os.Bundle;
import android.view.WindowManager;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.BaseActivity;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: d, reason: collision with root package name */
    protected final BaseActivity f74591d;

    public b(BaseActivity baseActivity) {
        this.f74591d = baseActivity;
    }

    public abstract void a(Bundle bundle);

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public void f(String str, QQCustomDialog qQCustomDialog) {
        if (qQCustomDialog != null && !this.f74591d.isFinishing()) {
            boolean z16 = false;
            try {
                qQCustomDialog.show();
                z16 = true;
            } catch (WindowManager.BadTokenException e16) {
                QLog.w("DialogModelBase", 1, "showDialog BadTokenException, from[" + str + "]", e16);
            } catch (Throwable th5) {
                QLog.w("DialogModelBase", 1, "showDialog BadTokenException, from[" + str + "]", th5);
            }
            if (QLog.isColorLevel()) {
                QLog.w("DialogModelBase", 2, "showDialog, from[" + str + "], isShowSuc[" + z16 + "]");
            }
        }
    }
}
