package com.tencent.mobileqq.lyric.util;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final e<Handler, Void> f243167a;

    /* renamed from: b, reason: collision with root package name */
    private static e<TimerTaskManager, Void> f243168b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.lyric.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C7998a extends e<Handler, Void> {
        static IPatchRedirector $redirector_;

        C7998a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.lyric.util.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Handler create(Void r46) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Handler) iPatchRedirector.redirect((short) 2, (Object) this, (Object) r46);
            }
            return new Handler(Looper.getMainLooper());
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b extends e<TimerTaskManager, Void> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.lyric.util.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TimerTaskManager create(Void r46) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TimerTaskManager) iPatchRedirector.redirect((short) 2, (Object) this, (Object) r46);
            }
            return new TimerTaskManager();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72858);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f243167a = new C7998a();
            f243168b = new b();
        }
    }

    public static Handler a() {
        return f243167a.get(null);
    }

    public static TimerTaskManager b() {
        return f243168b.get(null);
    }
}
