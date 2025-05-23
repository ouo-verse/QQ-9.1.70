package com.tencent.mobileqq.pad;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes16.dex */
public class h implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @ConfigInject(configPath = "AutoInjectYml/Foundation/QFragment/Inject_qfragment.yml", version = 1)
    public static ArrayList<Class<? extends a>> f257092b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile h f257093c;

    /* renamed from: a, reason: collision with root package name */
    private a f257094a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44418);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        ArrayList<Class<? extends a>> arrayList = new ArrayList<>();
        f257092b = arrayList;
        arrayList.add(com.tencent.mobileqq.qfragment.a.class);
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f257094a = null;
        if (f257092b.size() == 0) {
            return;
        }
        try {
            this.f257094a = f257092b.get(0).newInstance();
        } catch (IllegalAccessException | InstantiationException e16) {
            QLog.e("QFragmentInjectManager", 1, "IQFragmentInject new instance fail: ", e16);
        }
    }

    public static h b() {
        if (f257093c == null) {
            synchronized (h.class) {
                if (f257093c == null) {
                    f257093c = new h();
                }
            }
        }
        return f257093c;
    }

    @Override // com.tencent.mobileqq.pad.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            QLog.d("QFragmentInjectManager", 1, "updateCurrentFragmentToMain");
            this.f257094a.a();
        }
    }
}
