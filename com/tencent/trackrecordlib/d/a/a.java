package com.tencent.trackrecordlib.d.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final b f381086a;

    /* renamed from: b, reason: collision with root package name */
    private static final b f381087b;

    /* compiled from: P */
    /* renamed from: com.tencent.trackrecordlib.d.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    private static class C10019a implements b {
        static IPatchRedirector $redirector_;

        C10019a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.trackrecordlib.d.a.a.b
        @Nullable
        public com.tencent.trackrecordlib.d.a.b a(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? f.a(obj) : (com.tencent.trackrecordlib.d.a.b) iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        /* synthetic */ C10019a(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) anonymousClass1);
        }

        @Override // com.tencent.trackrecordlib.d.a.a.b
        public void a(Object obj, com.tencent.trackrecordlib.d.a.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                f.a(obj, bVar);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface b {
        @Nullable
        com.tencent.trackrecordlib.d.a.b a(Object obj);

        void a(Object obj, com.tencent.trackrecordlib.d.a.b bVar);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static class c implements b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.trackrecordlib.d.a.a.b
        @Nullable
        public com.tencent.trackrecordlib.d.a.b a(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? (com.tencent.trackrecordlib.d.a.b) ((View) obj).getTag(R.dimen.bfp) : (com.tencent.trackrecordlib.d.a.b) iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) anonymousClass1);
        }

        @Override // com.tencent.trackrecordlib.d.a.a.b
        public void a(Object obj, com.tencent.trackrecordlib.d.a.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                ((View) obj).setTag(R.dimen.bfp, bVar);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) bVar);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11403);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        AnonymousClass1 anonymousClass1 = null;
        f381086a = new c(anonymousClass1);
        f381087b = new C10019a(anonymousClass1);
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public static com.tencent.trackrecordlib.d.a.b a(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        return b(obj).a(obj);
    }

    @NonNull
    private static b b(Object obj) {
        if (obj instanceof View) {
            return f381086a;
        }
        return f381087b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@Nullable Object obj, @Nullable com.tencent.trackrecordlib.d.a.b bVar) {
        if (obj == null) {
            return;
        }
        b(obj).a(obj, bVar);
    }
}
