package com.tencent.tdf.embed;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class EmbeddedViewFactory {
    static IPatchRedirector $redirector_;

    public EmbeddedViewFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract EmbeddedView create(Context context, int i3, Map<String, String> map);
}
