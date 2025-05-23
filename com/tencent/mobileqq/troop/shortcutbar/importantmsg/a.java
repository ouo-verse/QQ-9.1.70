package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class a implements com.tencent.mobileqq.troop.shortcutbar.b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract boolean a();

    public abstract void b();

    public abstract void e(ArrayList<ShortcutBarInfo> arrayList);
}
