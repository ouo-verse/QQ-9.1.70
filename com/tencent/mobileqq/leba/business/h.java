package com.tencent.mobileqq.leba.business;

import android.content.Context;
import com.tencent.mobileqq.leba.business.redtouch.LebaSpecificRedTouchBiz;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQLebaImpl/Inject_LebaBusiness.yml", version = 1)
    public static ArrayList<Class<? extends d>> f240109b;

    /* renamed from: a, reason: collision with root package name */
    public List<d> f240110a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20539);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        ArrayList<Class<? extends d>> arrayList = new ArrayList<>();
        f240109b = arrayList;
        arrayList.add(LebaSpecificRedTouchBiz.class);
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f240110a = new ArrayList();
        }
    }

    public boolean a(AppRuntime appRuntime, Context context, long j3, RedTouch redTouch, String str, Map<Long, com.tencent.mobileqq.leba.entity.g> map, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, appRuntime, context, Long.valueOf(j3), redTouch, str, map, Integer.valueOf(i3), Boolean.valueOf(z16))).booleanValue();
        }
        Iterator<d> it = this.f240110a.iterator();
        while (it.hasNext()) {
            if (it.next().b(appRuntime, context, j3, redTouch, str, map, i3, z16)) {
                return true;
            }
        }
        return false;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f240110a.isEmpty()) {
            Iterator<Class<? extends d>> it = f240109b.iterator();
            while (it.hasNext()) {
                try {
                    this.f240110a.add(it.next().newInstance());
                } catch (Exception e16) {
                    QLog.e("LebaBizRedTouchProxy", 1, e16, new Object[0]);
                }
            }
            QLog.i("LebaBizRedTouchProxy", 1, "initBizList size = " + this.f240110a.size());
        }
    }
}
