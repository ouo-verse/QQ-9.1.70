package com.tencent.mobileqq.adapter;

import android.view.View;
import com.tencent.mobileqq.adapter.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
class BaseWhatASmoothAdapter$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ View f187002d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Object f187003e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Object f187004f;
    final /* synthetic */ d this$0;

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Object tag = this.f187002d.getTag();
        if (this.f187003e != null && (obj = this.f187004f) != null) {
            if (!obj.equals(tag)) {
                if (tag == null) {
                    throw null;
                }
            } else {
                throw null;
            }
        }
        d.a.a(null, null);
    }
}
