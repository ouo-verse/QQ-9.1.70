package com.tencent.tdf.module;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tdf.annotation.TDFModule;

/* compiled from: P */
/* loaded from: classes26.dex */
class TDFModuleInfo {
    static IPatchRedirector $redirector_;
    private final TDFModuleContext mContext;
    private volatile boolean mInit;
    private TDFBaseModule mInstance;
    private String mName;
    private String[] mNames;
    private final TDFModuleProvider mProvider;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TDFModuleInfo(TDFModuleContext tDFModuleContext, Class<? extends TDFBaseModule> cls, TDFModuleProvider tDFModuleProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, tDFModuleContext, cls, tDFModuleProvider);
            return;
        }
        this.mInit = false;
        this.mContext = tDFModuleContext;
        this.mProvider = tDFModuleProvider;
        TDFModule tDFModule = (TDFModule) cls.getAnnotation(TDFModule.class);
        if (tDFModule != null) {
            this.mName = tDFModule.name();
            this.mNames = tDFModule.names();
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        TDFBaseModule tDFBaseModule = this.mInstance;
        if (tDFBaseModule != null) {
            tDFBaseModule.destroy();
        }
    }

    public TDFBaseModule getInstance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TDFBaseModule) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.mInit) {
            return this.mInstance;
        }
        synchronized (this) {
            if (!this.mInit) {
                TDFBaseModule tDFBaseModule = this.mProvider.get(this.mContext);
                this.mInstance = tDFBaseModule;
                tDFBaseModule.init();
                this.mInit = true;
            }
        }
        return this.mInstance;
    }

    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mName;
    }

    public String[] getNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mNames;
    }
}
