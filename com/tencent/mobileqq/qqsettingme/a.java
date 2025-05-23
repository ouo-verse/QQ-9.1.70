package com.tencent.mobileqq.qqsettingme;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Argus;
import com.tencent.mobileqq.activity.qqsettingme.bean.c;
import com.tencent.mobileqq.activity.qqsettingme.bean.e;
import com.tencent.mobileqq.activity.qqsettingme.bean.f;
import com.tencent.mobileqq.activity.qqsettingme.bean.g;
import com.tencent.mobileqq.activity.qqsettingme.bean.h;
import com.tencent.mobileqq.activity.qqsettingme.bean.i;
import com.tencent.mobileqq.activity.qqsettingme.bean.j;
import com.tencent.mobileqq.activity.qqsettingme.bean.l;
import com.tencent.mobileqq.activity.qqsettingme.bean.m;
import com.tencent.mobileqq.activity.qqsettingme.bean.n;
import com.tencent.mobileqq.activity.qqsettingme.bean.o;
import com.tencent.mobileqq.activity.qqsettingme.bean.p;
import com.tencent.mobileqq.activity.qqsettingme.bean.q;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.api.IDrawerApi;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqsettingme.argus.b;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchTextView;
import com.tencent.mobileqq.tianshu.api.IRedPointReportManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class a {
    static IPatchRedirector $redirector_;
    protected static final HashMap<String, QQSettingMeBizBean> C;

    /* renamed from: i, reason: collision with root package name */
    public static int f274434i;

    /* renamed from: m, reason: collision with root package name */
    protected static volatile boolean f274435m;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f274436d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f274437e;

    /* renamed from: f, reason: collision with root package name */
    protected final QBaseActivity f274438f;

    /* renamed from: h, reason: collision with root package name */
    public ViewGroup f274439h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42701);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 33)) {
            redirector.redirect((short) 33);
            return;
        }
        f274434i = 0;
        C = new HashMap<>();
        Argus.INSTANCE.addBlockCreator(new b());
    }

    public a(@NonNull QBaseActivity qBaseActivity, @NonNull ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity, (Object) viewGroup);
            return;
        }
        this.f274436d = false;
        this.f274437e = true;
        this.f274438f = qBaseActivity;
        this.f274439h = viewGroup;
    }

    @Nullable
    @Deprecated
    public static QQSettingMeBizBean c(String str) {
        QQSettingMeBizBean qQSettingMeBizBean = C.get(str);
        if (qQSettingMeBizBean != null && qQSettingMeBizBean.k() != null) {
            return qQSettingMeBizBean;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BaseQQSettingMeView", 2, "getBizBean, bizId:", str, ", return null");
            return null;
        }
        return null;
    }

    public static HashMap<String, QQSettingMeBizBean> d() {
        return C;
    }

    public static TianshuRedTouch e(String str) {
        QQSettingMeBizBean c16 = c(str);
        if (c16 != null && c16.k() != null) {
            return c16.k().a();
        }
        if (QLog.isColorLevel()) {
            QLog.d("BaseQQSettingMeView", 2, "getItemRedBadgeText, bizId:", str, ", return null");
            return null;
        }
        return null;
    }

    public static RedTouchTextView f(String str) {
        QQSettingMeBizBean c16 = c(str);
        if (c16 != null && c16.k() != null) {
            return c16.k().b();
        }
        if (QLog.isColorLevel()) {
            QLog.d("BaseQQSettingMeView", 2, "getItemRedText, bizId:", str, ", return null");
            return null;
        }
        return null;
    }

    public static RedTouch g(String str) {
        QQSettingMeBizBean qQSettingMeBizBean = C.get(str);
        if (qQSettingMeBizBean != null && qQSettingMeBizBean.k() != null) {
            return qQSettingMeBizBean.k().c();
        }
        return null;
    }

    @Nullable
    @Deprecated
    public static View h(String str) {
        return i(str, Boolean.TRUE);
    }

    @Nullable
    @Deprecated
    public static View i(String str, Boolean bool) {
        if (!bool.booleanValue() && ((IDrawerApi) QRoute.api(IDrawerApi.class)).currentIsV3()) {
            QLog.d("BaseQQSettingMeView", 1, "getItemView  is null, because current In V3");
            return null;
        }
        QQSettingMeBizBean qQSettingMeBizBean = C.get(str);
        if (qQSettingMeBizBean != null && qQSettingMeBizBean.k() != null) {
            return qQSettingMeBizBean.k().d();
        }
        if (QLog.isColorLevel()) {
            QLog.d("BaseQQSettingMeView", 2, "getItemView, bizId:", str, ", return null");
        }
        return null;
    }

    public static boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (QQSettingMeBizBean qQSettingMeBizBean : C.values()) {
            if (qQSettingMeBizBean != null) {
                if (!str.equals(qQSettingMeBizBean.o())) {
                    if (str.equals(qQSettingMeBizBean.o() + ".0")) {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
        return str.equals(String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_SETTING));
    }

    private void t() {
        if (!TianshuRedTouch.INSTANCE.j()) {
            return;
        }
        for (QQSettingMeBizBean qQSettingMeBizBean : C.values()) {
            if (!qQSettingMeBizBean.o().isEmpty()) {
                TianshuRedTouch.INSTANCE.l(qQSettingMeBizBean.o());
            }
        }
    }

    private void u() {
        String o16;
        if (!TianshuRedTouch.INSTANCE.j()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (QQSettingMeBizBean qQSettingMeBizBean : C.values()) {
            if (!qQSettingMeBizBean.o().isEmpty() && (o16 = qQSettingMeBizBean.o()) != null) {
                arrayList.add(o16);
                arrayList.add(o16 + ".0");
            }
        }
        ((IRedPointReportManager) QRoute.api(IRedPointReportManager.class)).resetExposuresDeduplicate(arrayList);
    }

    public void A(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) cVar);
        }
    }

    public void B(BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) appInfo);
        }
    }

    public void C(BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) appInfo);
        }
    }

    public void D(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) gVar);
        }
    }

    public abstract void E(e eVar);

    public abstract void F(f fVar);

    public void G(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) gVar);
        }
    }

    public void H(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
        }
    }

    public void I(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) hVar);
        }
    }

    public void J(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
        }
    }

    public void K(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3);
        }
    }

    public void L(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) iVar);
        }
    }

    public void M(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) jVar);
        }
    }

    public void N(BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) appInfo);
        }
    }

    public void O(m mVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) mVar);
        }
    }

    public void P(BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) appInfo);
        }
    }

    public void Q(l lVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) lVar);
        }
    }

    public void R(o oVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) oVar);
        }
    }

    public void S(p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) pVar);
        }
    }

    public void T(p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) pVar);
        }
    }

    public void U(q qVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) qVar);
        }
    }

    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        }
    }

    public void b(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime);
        } else if (QLog.isColorLevel()) {
            QLog.d("BaseQQSettingMeView", 2, "-->fillData, isInit:" + this.f274436d);
        }
    }

    public View j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return null;
    }

    public abstract QQSettingMeViewModel k();

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        }
    }

    public abstract boolean n();

    public abstract void o(Configuration configuration);

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            f274435m = false;
            u();
        }
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!f274435m) {
            t();
        }
        f274435m = true;
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    public void s(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) nVar);
        }
    }

    public void v(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        }
    }

    public abstract void w(boolean z16);

    public void x(com.tencent.mobileqq.activity.qqsettingme.bean.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) aVar);
        }
    }

    public void y(String str, BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) appInfo);
        }
    }

    public void z(com.tencent.mobileqq.activity.qqsettingme.bean.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bVar);
        }
    }
}
