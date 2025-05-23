package com.tencent.tdf.module;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tdf.annotation.TDFMethod;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TDFBaseModule {
    static IPatchRedirector $redirector_;
    private Map<String, TDFMethodInfo> mMethods;
    private TDFModuleContext moduleContext;

    public TDFBaseModule(TDFModuleContext tDFModuleContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tDFModuleContext);
        } else {
            this.moduleContext = tDFModuleContext;
        }
    }

    private void initMethods() {
        if (this.mMethods != null) {
            return;
        }
        synchronized (this) {
            if (this.mMethods != null) {
                return;
            }
            this.mMethods = new ConcurrentHashMap();
            for (Method method : getClass().getMethods()) {
                TDFMethod tDFMethod = (TDFMethod) method.getAnnotation(TDFMethod.class);
                if (tDFMethod != null) {
                    String name = tDFMethod.name();
                    if (name == null || name.length() == 0) {
                        name = method.getName();
                    }
                    if (!this.mMethods.containsKey(name)) {
                        this.mMethods.put(name, new TDFMethodInfo(method, tDFMethod.isSync()));
                    }
                }
            }
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    public TDFMethodInfo getMethod(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TDFMethodInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if (str == null) {
            return null;
        }
        return this.mMethods.get(str);
    }

    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            initMethods();
        }
    }

    public Object invoke(String str, List<Object> list, TDFModulePromise tDFModulePromise) throws Exception {
        TDFMethodInfo tDFMethodInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, str, list, tDFModulePromise);
        }
        if (str == null || (tDFMethodInfo = this.mMethods.get(str)) == null) {
            return null;
        }
        return tDFMethodInfo.invoke(this, list, tDFModulePromise);
    }
}
