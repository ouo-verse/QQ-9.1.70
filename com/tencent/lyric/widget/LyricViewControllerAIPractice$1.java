package com.tencent.lyric.widget;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes9.dex */
class LyricViewControllerAIPractice$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f147145d;
    final /* synthetic */ e this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Log.i("LyricViewControllerAIPractice", "seek -> run :" + this.f147145d);
        throw null;
    }
}
