package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private r f288591a;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f288591a = new r();
        }
    }

    @Override // com.tencent.mobileqq.soload.api.impl.f
    public void a(LoadParam loadParam, OnLoadListener onLoadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) loadParam, (Object) onLoadListener);
            return;
        }
        if (loadParam == null) {
            if (onLoadListener != null) {
                onLoadListener.onLoadResult(6, new LoadExtResult());
                return;
            }
            return;
        }
        ClassLoader classLoader = loadParam.mClassLoader;
        if (!(classLoader instanceof DexClassLoader)) {
            r rVar = this.f288591a;
            if (rVar != null) {
                rVar.m(loadParam, onLoadListener);
                return;
            }
            return;
        }
        if (this.f288591a != null) {
            Iterator<File> it = com.tencent.mobileqq.soload.util.f.l(classLoader).iterator();
            while (it.hasNext()) {
                try {
                    com.tencent.mobileqq.soload.util.b.c(getClass().getClassLoader(), it.next());
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
            this.f288591a.m(loadParam, onLoadListener);
        }
    }

    @Override // com.tencent.mobileqq.soload.api.impl.f
    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        r rVar = this.f288591a;
        if (rVar != null) {
            rVar.r(str);
        }
    }

    @Override // com.tencent.mobileqq.soload.api.impl.f
    public LoadExtResult c(LoadParam loadParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LoadExtResult) iPatchRedirector.redirect((short) 5, (Object) this, (Object) loadParam);
        }
        if (loadParam == null) {
            return null;
        }
        ClassLoader classLoader = loadParam.mClassLoader;
        if (!(classLoader instanceof DexClassLoader)) {
            r rVar = this.f288591a;
            if (rVar != null) {
                return rVar.q(loadParam);
            }
        } else {
            Iterator<File> it = com.tencent.mobileqq.soload.util.f.l(classLoader).iterator();
            while (it.hasNext()) {
                try {
                    com.tencent.mobileqq.soload.util.b.c(getClass().getClassLoader(), it.next());
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
            r rVar2 = this.f288591a;
            if (rVar2 != null) {
                return rVar2.q(loadParam);
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.soload.api.impl.f
    public boolean d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        r rVar = this.f288591a;
        if (rVar != null && rVar.j(str)) {
            return true;
        }
        return false;
    }
}
