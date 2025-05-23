package com.tencent.ams.adcore.mma.bean;

import android.text.TextUtils;
import com.tencent.ams.adcore.mma.util.CommonUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SDK {
    static IPatchRedirector $redirector_;
    public List<Company> companies;
    private String description;
    public OfflineCache offlineCache;

    public SDK() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String getDomain(String str) {
        List<Company> list;
        Domain domain;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(str) && (list = this.companies) != null && list.size() != 0) {
            String hostURL = CommonUtil.getHostURL(str);
            if (TextUtils.isEmpty(hostURL)) {
                return "UNKNOWN";
            }
            for (Company company : this.companies) {
                if (company != null && (domain = company.domain) != null && !TextUtils.isEmpty(domain.url) && hostURL.endsWith(company.domain.url)) {
                    return company.domain.url;
                }
            }
        }
        return "UNKNOWN";
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String str = this.description;
        if (str != null) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder();
        if (this.offlineCache != null) {
            sb5.append("offlineCache[");
            sb5.append("len=");
            sb5.append(this.offlineCache.length);
            sb5.append(",");
            sb5.append("timeout=");
            sb5.append(this.offlineCache.timeout);
            sb5.append(",");
            sb5.append("expiration=");
            sb5.append(this.offlineCache.queueExpirationSecs);
            sb5.append("]");
        }
        List<Company> list = this.companies;
        if (list != null && list.size() > 0) {
            sb5.append("companies{");
            for (Company company : this.companies) {
                if (company != null) {
                    sb5.append("[");
                    sb5.append(company.name);
                    if (company.domain != null) {
                        sb5.append("--");
                        sb5.append(company.domain.url);
                    }
                    sb5.append("]");
                }
            }
            sb5.append("}");
        }
        String sb6 = sb5.toString();
        this.description = sb6;
        return sb6;
    }
}
