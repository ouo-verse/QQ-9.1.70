package com.tencent.trackrecordlib.d;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface c {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static c a() {
            return b.c();
        }
    }

    void a();

    void a(View view);

    void a(Collection<View> collection);

    boolean b(View view);

    void c(View view);

    Collection<View> d();
}
