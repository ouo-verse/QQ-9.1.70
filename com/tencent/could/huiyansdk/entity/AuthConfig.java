package com.tencent.could.huiyansdk.entity;

import android.content.Context;
import com.tencent.could.huiyansdk.enums.PageColorStyle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AuthConfig {
    static IPatchRedirector $redirector_;
    private String authLicense;
    private long authTimeOutMs;
    private WeakReference<Context> contextWeakReference;
    private CustomerConfig customerConfig;
    private boolean isOpenLog;
    private boolean isUseEncrypt;
    private String languageCode;
    private LanguageStyle languageStyle;
    private boolean openFullLog;
    private PageColorStyle pageColorStyle;
    private String useCustomerModelPath;

    public AuthConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.pageColorStyle = PageColorStyle.Light;
        this.authLicense = "";
        this.authTimeOutMs = 30000L;
        this.useCustomerModelPath = "";
        this.languageStyle = LanguageStyle.SIMPLIFIED_CHINESE;
        this.languageCode = "";
        this.isOpenLog = true;
        this.openFullLog = false;
        this.isUseEncrypt = false;
    }

    public String getAuthLicense() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.authLicense;
    }

    public long getAuthTimeOutMs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.authTimeOutMs;
    }

    public CustomerConfig getCustomerConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CustomerConfig) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.customerConfig;
    }

    public String getLanguageCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.languageCode;
    }

    public LanguageStyle getLanguageStyle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (LanguageStyle) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.languageStyle;
    }

    public PageColorStyle getPageColorStyle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (PageColorStyle) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.pageColorStyle;
    }

    public Context getStartActivityContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Context) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        WeakReference<Context> weakReference = this.contextWeakReference;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public String getUseCustomerModelPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.useCustomerModelPath;
    }

    public boolean isOpenFullLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return this.openFullLog;
    }

    public boolean isOpenLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.isOpenLog;
    }

    public boolean isUseEncrypt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.isUseEncrypt;
    }

    public void setAuthLicense(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.authLicense = str;
        }
    }

    public void setAuthTimeOutMs(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            this.authTimeOutMs = j3;
        }
    }

    public void setCustomerConfig(CustomerConfig customerConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) customerConfig);
        } else {
            this.customerConfig = customerConfig;
        }
    }

    public void setLanguageCode(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else {
            this.languageCode = str;
        }
    }

    public void setLanguageStyle(LanguageStyle languageStyle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) languageStyle);
        } else {
            this.languageStyle = languageStyle;
        }
    }

    public void setOpenFullLog(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        } else {
            this.openFullLog = z16;
        }
    }

    public void setOpenLog(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.isOpenLog = z16;
        }
    }

    public void setPageColorStyle(PageColorStyle pageColorStyle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) pageColorStyle);
        } else {
            this.pageColorStyle = pageColorStyle;
        }
    }

    public void setStartActivityContext(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) context);
        } else {
            this.contextWeakReference = new WeakReference<>(context);
        }
    }

    public void setUseCustomerModelPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            this.useCustomerModelPath = str;
        }
    }

    public void setUseEncrypt(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            this.isUseEncrypt = z16;
        }
    }
}
