package com.tencent.mobileqq.loginregister.sms;

import android.content.Intent;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.loginregister.sms.impl.g;
import com.tencent.mobileqq.loginregister.sms.impl.l;
import com.tencent.mobileqq.loginregister.sms.impl.m;
import com.tencent.mobileqq.loginregister.sms.impl.n;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<Integer, b> f242921a;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        HashMap<Integer, b> hashMap = new HashMap<>();
        this.f242921a = hashMap;
        hashMap.put(1, new n());
        hashMap.put(2, new m());
        hashMap.put(3, new com.tencent.mobileqq.loginregister.sms.impl.a());
        hashMap.put(5, new g());
        hashMap.put(6, new l());
    }

    @Nullable
    private b i(QBaseActivity qBaseActivity) {
        Intent intent;
        if (qBaseActivity == null || (intent = qBaseActivity.getIntent()) == null) {
            return null;
        }
        return this.f242921a.get(Integer.valueOf(intent.getIntExtra("key_sms_verify_function_code", 0)));
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void a(QBaseActivity qBaseActivity, int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, qBaseActivity, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        b i17 = i(qBaseActivity);
        if (i17 != null) {
            i17.a(qBaseActivity, i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public boolean b(QBaseActivity qBaseActivity, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) qBaseActivity, (Object) cVar)).booleanValue();
        }
        b i3 = i(qBaseActivity);
        if (i3 != null) {
            return i3.b(qBaseActivity, cVar);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public boolean c(QBaseActivity qBaseActivity, c cVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, qBaseActivity, cVar, str)).booleanValue();
        }
        b i3 = i(qBaseActivity);
        if (i3 != null) {
            return i3.c(qBaseActivity, cVar, str);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void d(QBaseActivity qBaseActivity, long j3, com.tencent.mobileqq.loginregister.callback.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, qBaseActivity, Long.valueOf(j3), aVar);
            return;
        }
        b i3 = i(qBaseActivity);
        if (i3 != null) {
            i3.d(qBaseActivity, j3, aVar);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void e(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) qBaseActivity);
            return;
        }
        b i3 = i(qBaseActivity);
        if (i3 != null) {
            i3.e(qBaseActivity);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public boolean f(QBaseActivity qBaseActivity, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, qBaseActivity, Boolean.valueOf(z16), Long.valueOf(j3))).booleanValue();
        }
        b i3 = i(qBaseActivity);
        if (i3 == null) {
            return false;
        }
        return i3.f(qBaseActivity, z16, j3);
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public boolean g(QBaseActivity qBaseActivity, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) qBaseActivity, (Object) cVar)).booleanValue();
        }
        b i3 = i(qBaseActivity);
        if (i3 != null) {
            return i3.g(qBaseActivity, cVar);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void h(QBaseActivity qBaseActivity, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qBaseActivity, (Object) cVar);
            return;
        }
        b i3 = i(qBaseActivity);
        if (i3 != null) {
            i3.h(qBaseActivity, cVar);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void onActivityDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        b i3 = i(QBaseActivity.sTopActivity);
        if (i3 != null) {
            i3.onActivityDestroy();
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.b
    public void onActivityResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        b i3 = i(QBaseActivity.sTopActivity);
        if (i3 != null) {
            i3.onActivityResume();
        }
    }
}
