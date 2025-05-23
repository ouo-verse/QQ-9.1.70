package com.tencent.luan.ioc.index;

import com.tencent.luan.core.Utility;
import com.tencent.luan.ioc.InjectAnalysisService;
import com.tencent.luan.ioc.InjectConstructor;
import com.tencent.luan.ioc.InjectMethod;
import com.tencent.luan.ioc.ProvideMethod;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class IndexInjectAnalysisService implements InjectAnalysisService {
    static IPatchRedirector $redirector_;
    private final List<IndexInjectInfoService> indexInfos;

    public IndexInjectAnalysisService(List<IndexInjectInfoService> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
        } else {
            Utility.makeSureNotNull(list, "indexInfos");
            this.indexInfos = list;
        }
    }

    public List<IndexInjectInfoService> getIndexInfos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new LinkedList(this.indexInfos);
    }

    @Override // com.tencent.luan.ioc.InjectAnalysisService
    public InjectConstructor<?> getInjectConstructor(Class<?> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (InjectConstructor) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cls);
        }
        Iterator<IndexInjectInfoService> it = this.indexInfos.iterator();
        InjectConstructor<?> injectConstructor = null;
        while (it.hasNext() && (injectConstructor = it.next().getDeclareInjectConstructor(cls)) == null) {
        }
        return injectConstructor;
    }

    @Override // com.tencent.luan.ioc.InjectAnalysisService
    public List<InjectMethod> getInjectMethods(Class<?> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
        }
        Iterator<IndexInjectInfoService> it = this.indexInfos.iterator();
        while (it.hasNext()) {
            InjectMethod allInjectMethods = it.next().getAllInjectMethods(cls);
            if (allInjectMethods != null) {
                return Collections.singletonList(allInjectMethods);
            }
        }
        return null;
    }

    @Override // com.tencent.luan.ioc.InjectAnalysisService
    public List<ProvideMethod<?>> getProvideMethods(Class<?> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) cls);
        }
        Iterator<IndexInjectInfoService> it = this.indexInfos.iterator();
        while (it.hasNext()) {
            List<ProvideMethod<?>> allDeclareProvideMethods = it.next().getAllDeclareProvideMethods(cls);
            if (allDeclareProvideMethods != null) {
                return Collections.unmodifiableList(allDeclareProvideMethods);
            }
        }
        return null;
    }

    @Override // com.tencent.luan.ioc.InjectAnalysisService
    public boolean isValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.indexInfos.size() > 0) {
            return true;
        }
        return false;
    }
}
