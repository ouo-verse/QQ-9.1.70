package com.tencent.ams.dynamicwidget;

import com.tencent.ams.dynamicwidget.data.AdInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0006J\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ$\u0010\u0011\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ams/dynamicwidget/d;", "", "", "moduleId", "", "b", "", "state", "e", "failReason", "d", "c", "a", "Lcom/tencent/ams/dynamicwidget/data/AdInfo;", "ad", "g", "errorMsg", "f", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/ams/dynamicwidget/d$a;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "eventObservers", "<init>", "()V", "lib_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<a> eventObservers;

    /* renamed from: b, reason: collision with root package name */
    public static final d f70187b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0006H&J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0006H&J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J&\u0010\u0011\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ams/dynamicwidget/d$a;", "", "", "moduleId", "", "onEngineInitStart", "", "state", "c", "failReason", "e", "d", "f", "Lcom/tencent/ams/dynamicwidget/data/AdInfo;", "ad", "a", "errorMsg", "b", "lib_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public interface a {
        void a(@Nullable String moduleId, @Nullable AdInfo ad5);

        void b(@Nullable String moduleId, @Nullable AdInfo ad5, @Nullable String errorMsg);

        void c(@Nullable String moduleId, int state);

        void d(@Nullable String moduleId);

        void e(@Nullable String moduleId, int failReason);

        void f(@Nullable String moduleId, int failReason);

        void onEngineInitStart(@Nullable String moduleId);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15970);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            f70187b = new d();
            eventObservers = new CopyOnWriteArrayList<>();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        }
    }

    public final void a(@Nullable String moduleId, int failReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) moduleId, failReason);
            return;
        }
        Iterator<T> it = eventObservers.iterator();
        while (it.hasNext()) {
            ((a) it.next()).f(moduleId, failReason);
        }
    }

    public final void b(@Nullable String moduleId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) moduleId);
            return;
        }
        Iterator<T> it = eventObservers.iterator();
        while (it.hasNext()) {
            ((a) it.next()).onEngineInitStart(moduleId);
        }
    }

    public final void c(@Nullable String moduleId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) moduleId);
            return;
        }
        Iterator<T> it = eventObservers.iterator();
        while (it.hasNext()) {
            ((a) it.next()).d(moduleId);
        }
    }

    public final void d(@Nullable String moduleId, int failReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) moduleId, failReason);
            return;
        }
        Iterator<T> it = eventObservers.iterator();
        while (it.hasNext()) {
            ((a) it.next()).e(moduleId, failReason);
        }
    }

    public final void e(@Nullable String moduleId, int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) moduleId, state);
            return;
        }
        Iterator<T> it = eventObservers.iterator();
        while (it.hasNext()) {
            ((a) it.next()).c(moduleId, state);
        }
    }

    public final void f(@Nullable String moduleId, @Nullable AdInfo ad5, @Nullable String errorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, moduleId, ad5, errorMsg);
            return;
        }
        Iterator<T> it = eventObservers.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(moduleId, ad5, errorMsg);
        }
    }

    public final void g(@Nullable String moduleId, @Nullable AdInfo ad5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) moduleId, (Object) ad5);
            return;
        }
        Iterator<T> it = eventObservers.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(moduleId, ad5);
        }
    }
}
