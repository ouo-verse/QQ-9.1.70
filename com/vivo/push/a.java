package com.vivo.push;

import com.vivo.push.listener.IPushQueryActionListener;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {
    public void deleteRegid(IPushActionListener iPushActionListener, String str, String str2) {
        com.vivo.push.restructure.a.a().h().a(iPushActionListener, str, str2);
    }

    public void getRegId(IPushQueryActionListener iPushQueryActionListener) {
        com.vivo.push.util.g.a().execute(new b(this, iPushQueryActionListener));
    }

    public void querySubscribeState(IPushActionListener iPushActionListener) {
        com.vivo.push.util.g.a().execute(new c(this, iPushActionListener));
    }
}
