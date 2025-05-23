package com.tencent.qidian.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qidian.proto.mobileqq_qidian$CompanyShowCaseInfo;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f342871a;

    /* renamed from: b, reason: collision with root package name */
    public String f342872b;

    /* renamed from: c, reason: collision with root package name */
    public String f342873c;

    public a(mobileqq_qidian$CompanyShowCaseInfo mobileqq_qidian_companyshowcaseinfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mobileqq_qidian_companyshowcaseinfo);
            return;
        }
        this.f342871a = "";
        this.f342872b = "";
        this.f342873c = "";
        a(mobileqq_qidian_companyshowcaseinfo);
    }

    public void a(mobileqq_qidian$CompanyShowCaseInfo mobileqq_qidian_companyshowcaseinfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) mobileqq_qidian_companyshowcaseinfo);
            return;
        }
        if (mobileqq_qidian_companyshowcaseinfo.string_show_case_title.has()) {
            this.f342871a = mobileqq_qidian_companyshowcaseinfo.string_show_case_title.get();
        }
        if (mobileqq_qidian_companyshowcaseinfo.string_show_case_link.has()) {
            this.f342872b = mobileqq_qidian_companyshowcaseinfo.string_show_case_link.get();
        }
        if (mobileqq_qidian_companyshowcaseinfo.string_show_case_image.has()) {
            this.f342873c = mobileqq_qidian_companyshowcaseinfo.string_show_case_image.get();
        }
    }

    public mobileqq_qidian$CompanyShowCaseInfo b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (mobileqq_qidian$CompanyShowCaseInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        mobileqq_qidian$CompanyShowCaseInfo mobileqq_qidian_companyshowcaseinfo = new mobileqq_qidian$CompanyShowCaseInfo();
        mobileqq_qidian_companyshowcaseinfo.string_show_case_title.set(this.f342871a);
        mobileqq_qidian_companyshowcaseinfo.string_show_case_link.set(this.f342872b);
        mobileqq_qidian_companyshowcaseinfo.string_show_case_image.set(this.f342873c);
        return mobileqq_qidian_companyshowcaseinfo;
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f342871a = "";
        this.f342872b = "";
        this.f342873c = "";
    }
}
