package com.tencent.mobileqq.troop.shortcutbar.troopapp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class e implements com.tencent.mobileqq.troop.shortcutbar.b {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void a(String str, long j3);

    public abstract boolean b();

    public abstract void e();

    public abstract void f(ArrayList<ShortcutBarInfo> arrayList, boolean z16);
}
