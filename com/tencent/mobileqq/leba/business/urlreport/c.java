package com.tencent.mobileqq.leba.business.urlreport;

import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f240321a;

    /* renamed from: b, reason: collision with root package name */
    private List<String> f240322b;

    public c(boolean z16, BusinessInfoCheckUpdate.AppInfo appInfo) {
        PBRepeatField<String> pBRepeatField;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), appInfo);
            return;
        }
        this.f240321a = z16;
        if (appInfo != null && (pBRepeatField = appInfo.missions) != null) {
            this.f240322b = pBRepeatField.get();
        }
    }

    @Override // com.tencent.mobileqq.leba.business.urlreport.b
    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (str != null && str.contains("need_fill_red_point_info=1")) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.leba.business.urlreport.b
    public String b() {
        List<String> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String format = String.format("&hasRedDot=%b", Boolean.valueOf(this.f240321a));
        if (this.f240321a && (list = this.f240322b) != null && !list.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            Iterator<String> it = this.f240322b.iterator();
            while (it.hasNext()) {
                sb5.append(it.next());
                sb5.append("_");
            }
            sb5.deleteCharAt(sb5.length() - 1);
            return format + String.format("&missions=%s", sb5.toString());
        }
        return format;
    }
}
