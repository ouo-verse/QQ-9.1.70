package com.tencent.image;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class ArgumentsRunnable<T> implements Runnable {
    static IPatchRedirector $redirector_;
    private ArrayList<T> args;

    public ArgumentsRunnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.args = null;
        }
    }

    private final synchronized List<T> getArguments() {
        ArrayList<T> arrayList;
        arrayList = this.args;
        this.args = null;
        return arrayList;
    }

    public final synchronized void add(T... tArr) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) tArr);
            return;
        }
        if (this.args == null) {
            this.args = new ArrayList<>();
            z16 = false;
        } else {
            z16 = true;
        }
        Collections.addAll(this.args, tArr);
        if (!z16) {
            submit();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            run(getArguments());
        }
    }

    protected abstract void run(List<T> list);

    protected abstract void submit();
}
