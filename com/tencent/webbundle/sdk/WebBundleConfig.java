package com.tencent.webbundle.sdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WebBundleConfig {
    static IPatchRedirector $redirector_;
    private Class carrierActivityClass;
    private WebBundleLogListener logListener;
    private boolean logPrintEnabled;
    private WebBundleH5OptionListner optionListener;
    private long preloadTimeoutLimit;
    private ArrayList<String> preloadUrlList;
    private long preloadWebViewCount;

    public WebBundleConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.preloadUrlList = new ArrayList<>();
        this.preloadTimeoutLimit = 15000L;
        this.preloadWebViewCount = 2L;
        this.logPrintEnabled = false;
    }

    public WebBundleConfig enableLogPrint(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (WebBundleConfig) iPatchRedirector.redirect((short) 7, (Object) this, z16);
        }
        this.logPrintEnabled = z16;
        return this;
    }

    public Class getCarrierActivityClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Class) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.carrierActivityClass;
    }

    public WebBundleLogListener getLogListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (WebBundleLogListener) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.logListener;
    }

    public WebBundleH5OptionListner getOptionListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (WebBundleH5OptionListner) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.optionListener;
    }

    public long getPreloadTimeoutLimit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return this.preloadTimeoutLimit;
    }

    public ArrayList<String> getPreloadUrlList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ArrayList) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.preloadUrlList;
    }

    public long getPreloadWebViewCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        return this.preloadWebViewCount;
    }

    public boolean isLogPrintEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.logPrintEnabled;
    }

    public final boolean isValidate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (this.carrierActivityClass != null && this.preloadUrlList.size() > 0) {
            return true;
        }
        return false;
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        this.carrierActivityClass = null;
        this.preloadUrlList.clear();
        this.preloadTimeoutLimit = 15000L;
        this.preloadWebViewCount = 2L;
        this.logPrintEnabled = false;
        this.logListener = null;
        this.optionListener = null;
    }

    public WebBundleConfig setCarrierActivityClass(Class cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (WebBundleConfig) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
        }
        this.carrierActivityClass = cls;
        return this;
    }

    public WebBundleConfig setLogListener(WebBundleLogListener webBundleLogListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (WebBundleConfig) iPatchRedirector.redirect((short) 8, (Object) this, (Object) webBundleLogListener);
        }
        this.logListener = webBundleLogListener;
        return this;
    }

    public WebBundleConfig setOptionListener(WebBundleH5OptionListner webBundleH5OptionListner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (WebBundleConfig) iPatchRedirector.redirect((short) 9, (Object) this, (Object) webBundleH5OptionListner);
        }
        this.optionListener = webBundleH5OptionListner;
        return this;
    }

    public WebBundleConfig setPreloadTimeoutLimit(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (WebBundleConfig) iPatchRedirector.redirect((short) 5, (Object) this, j3);
        }
        this.preloadTimeoutLimit = j3;
        return this;
    }

    public WebBundleConfig setPreloadUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (WebBundleConfig) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        this.preloadUrlList.clear();
        this.preloadUrlList.add(str);
        return this;
    }

    public WebBundleConfig setPreloadUrlList(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (WebBundleConfig) iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList);
        }
        this.preloadUrlList.clear();
        this.preloadUrlList.addAll(arrayList);
        return this;
    }

    public WebBundleConfig setPreloadWebViewCount(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (WebBundleConfig) iPatchRedirector.redirect((short) 6, (Object) this, j3);
        }
        this.preloadWebViewCount = j3;
        return this;
    }
}
