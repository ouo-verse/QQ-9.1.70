package com.tencent.mobileqq.qqlive.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes17.dex */
public class PageData<T> {
    static IPatchRedirector $redirector_;
    public boolean isEnd;
    public List<T> list;

    public PageData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isEnd = false;
            this.list = new ArrayList();
        }
    }
}
