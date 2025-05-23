package com.tencent.mobileqq.activity.qqsettingme;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class al extends q {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    public MutableLiveData<Boolean> f184816i;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Observer<Boolean> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqsettingme.a f184817d;

        a(com.tencent.mobileqq.qqsettingme.a aVar) {
            this.f184817d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) al.this, (Object) aVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
            } else {
                this.f184817d.w(bool.booleanValue());
            }
        }
    }

    public al() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f184816i = new MutableLiveData<>();
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q, com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void d(com.tencent.mobileqq.qqsettingme.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.f184816i.observe(this.f259743d, new a(aVar));
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q, com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void j(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, appInfo, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onResume();
            this.f184816i.setValue(Boolean.valueOf(uq3.c.v6()));
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void preload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f184816i.setValue(Boolean.valueOf(uq3.c.v6()));
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q
    public void q(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("uin", MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin());
        hashMap.put("key_jump_from", "9");
        com.tencent.mobileqq.activity.qcircle.utils.c.g().enterBySchemeAction(BaseApplication.context, QCircleScheme.Q_CIRCLE_ACTION_OPEN_CIRCLE_MAIN_PAGE, hashMap);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "d_smallworld";
    }
}
