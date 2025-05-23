package com.tencent.mobileqq.activity.qqsettingmev3;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.activity.qqsettingme.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.api.IQZoneIntimateSpaceApi;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d extends q {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.e> f185084i;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Observer<com.tencent.mobileqq.activity.qqsettingme.bean.e> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqsettingme.a f185085d;

        a(com.tencent.mobileqq.qqsettingme.a aVar) {
            this.f185085d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) aVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.activity.qqsettingme.bean.e eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
            } else {
                this.f185085d.E(eVar);
            }
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f185084i = new MutableLiveData<>();
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.a();
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q, com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void d(com.tencent.mobileqq.qqsettingme.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            super.d(aVar);
            this.f185084i.observe(this.f259743d, new a(aVar));
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onPostThemeChanged();
            e();
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onResume();
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.qqsettingme.q
    public void q(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
            return;
        }
        if (view == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder(QZoneConfigHelper.p0());
        int i3 = 1;
        if (TextUtils.isEmpty(sb5)) {
            QLog.e("QQSettingMeIntimateSpaceProcessor", 1, "[onBizClick] jumpUrl is empty");
            return;
        }
        sb5.append("&from=");
        sb5.append("7");
        ((IQZoneIntimateSpaceApi) QRoute.api(IQZoneIntimateSpaceApi.class)).handleScheme(sb5.toString(), view.getContext(), null);
        RedTouch g16 = com.tencent.mobileqq.qqsettingme.a.g(this.f259746g);
        if (g16 == null || !g16.hasRedTouch()) {
            i3 = 0;
        }
        VideoReport.setElementParam(view, "is_red_tips_em", Integer.valueOf(i3));
        VideoReport.reportEvent("clck", view, null);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "d_intimate_space";
    }
}
