package com.tencent.tdf.module;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TDFModuleManager {
    static IPatchRedirector $redirector_;
    private final TDFModuleContext mContext;
    private final ConcurrentHashMap<String, TDFModuleInfo> mModuleInfo;

    public TDFModuleManager(TDFModuleContext tDFModuleContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tDFModuleContext);
        } else {
            this.mContext = tDFModuleContext;
            this.mModuleInfo = new ConcurrentHashMap<>();
        }
    }

    public void addModule(Class<? extends TDFBaseModule> cls, TDFModuleProvider tDFModuleProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls, (Object) tDFModuleProvider);
            return;
        }
        if (tDFModuleProvider == null) {
            return;
        }
        TDFModuleInfo tDFModuleInfo = new TDFModuleInfo(this.mContext, cls, tDFModuleProvider);
        String[] names = tDFModuleInfo.getNames();
        if (names != null) {
            for (String str : names) {
                if (!this.mModuleInfo.containsKey(str)) {
                    this.mModuleInfo.put(str, tDFModuleInfo);
                }
            }
        }
        String name = tDFModuleInfo.getName();
        if (name != null && !this.mModuleInfo.containsKey(name)) {
            this.mModuleInfo.put(name, tDFModuleInfo);
        }
    }

    public void destroy() {
        TDFModuleInfo value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        for (Map.Entry<String, TDFModuleInfo> entry : this.mModuleInfo.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.destroy();
            }
        }
        this.mModuleInfo.clear();
    }

    public TDFBaseModule getModule(String str) {
        TDFModuleInfo tDFModuleInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TDFBaseModule) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (str == null || str.length() == 0 || (tDFModuleInfo = this.mModuleInfo.get(str)) == null) {
            return null;
        }
        return tDFModuleInfo.getInstance();
    }
}
