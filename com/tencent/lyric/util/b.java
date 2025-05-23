package com.tencent.lyric.util;

import android.os.Handler;
import android.os.Looper;
import com.tencent.lyric.common.TimerTaskManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final h<Handler, Void> f147089a;

    /* renamed from: b, reason: collision with root package name */
    private static h<TimerTaskManager, Void> f147090b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class a extends h<Handler, Void> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.lyric.util.h
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Handler a(Void r46) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Handler) iPatchRedirector.redirect((short) 2, (Object) this, (Object) r46);
            }
            return new Handler(Looper.getMainLooper());
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.lyric.util.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class C7008b extends h<TimerTaskManager, Void> {
        static IPatchRedirector $redirector_;

        C7008b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.lyric.util.h
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public TimerTaskManager a(Void r46) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TimerTaskManager) iPatchRedirector.redirect((short) 2, (Object) this, (Object) r46);
            }
            return new TimerTaskManager();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13831);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f147089a = new a();
            f147090b = new C7008b();
        }
    }

    public static Handler a() {
        return f147089a.b(null);
    }

    public static TimerTaskManager b() {
        return f147090b.b(null);
    }
}
