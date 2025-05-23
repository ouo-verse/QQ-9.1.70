package com.tencent.mobileqq.transfile;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* loaded from: classes19.dex */
public class TransProcessorHandler extends Handler {
    static IPatchRedirector $redirector_;
    private ArrayList<Class<?>> filterList;

    public TransProcessorHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ArrayList<Class<?>> arrayList = new ArrayList<>();
        this.filterList = arrayList;
        arrayList.clear();
    }

    public void addFilter(Class<?>... clsArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) clsArr);
            return;
        }
        for (Class<?> cls : clsArr) {
            this.filterList.add(cls);
        }
    }

    public void addFilterDistinct(Class<?>... clsArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) clsArr);
            return;
        }
        for (Class<?> cls : clsArr) {
            if (!this.filterList.contains(cls)) {
                this.filterList.add(cls);
            }
        }
    }

    public ArrayList<Class<?>> getFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.filterList;
    }

    public TransProcessorHandler(Looper looper) {
        super(looper);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) looper);
            return;
        }
        ArrayList<Class<?>> arrayList = new ArrayList<>();
        this.filterList = arrayList;
        arrayList.clear();
    }
}
