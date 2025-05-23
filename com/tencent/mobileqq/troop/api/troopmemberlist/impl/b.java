package com.tencent.mobileqq.troop.api.troopmemberlist.impl;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.adapter.j;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.troopmemberlist.c;
import com.tencent.widget.ListView;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends j implements c {
    static IPatchRedirector $redirector_;
    private com.tencent.mobileqq.troop.api.troopmemberlist.b F;

    public b(com.tencent.mobileqq.troop.api.troopmemberlist.b bVar, Context context, QQAppInterface qQAppInterface, ListView listView, int i3, boolean z16) {
        super(context, qQAppInterface, listView, i3, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bVar, context, qQAppInterface, listView, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            this.F = bVar;
        }
    }

    @Override // com.tencent.mobileqq.adapter.j
    public Bitmap c(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
        }
        return super.c(i3, str);
    }

    @Override // com.tencent.mobileqq.adapter.j
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.destroy();
        }
    }
}
