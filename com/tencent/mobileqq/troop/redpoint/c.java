package com.tencent.mobileqq.troop.redpoint;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c implements a {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(Object obj) {
        if (obj != null) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 4) {
                Object obj2 = objArr[0];
                if (obj2 instanceof String) {
                    Object obj3 = objArr[1];
                    if (obj3 instanceof String) {
                        Object obj4 = objArr[2];
                        if (obj4 instanceof b) {
                            Object obj5 = objArr[3];
                            if (obj5 instanceof HashSet) {
                                d((String) obj2, (String) obj3, (b) obj4, (HashSet) obj5);
                            }
                        }
                    }
                }
            }
        }
    }

    private void c(Object obj) {
        if (obj != null) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 3) {
                Object obj2 = objArr[0];
                if (obj2 instanceof String) {
                    Object obj3 = objArr[1];
                    if (obj3 instanceof String) {
                        Object obj4 = objArr[2];
                        if (obj4 instanceof View) {
                            e((String) obj2, (String) obj3, (View) obj4);
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.redpoint.a
    public void a(int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, obj);
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    c(obj);
                    return;
                }
                return;
            }
            b(obj);
        }
    }

    protected void d(String str, String str2, b bVar, HashSet<Integer> hashSet) {
        throw null;
    }

    protected void e(String str, String str2, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, view);
        }
    }
}
