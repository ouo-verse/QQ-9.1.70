package com.tencent.mobileqq.troop.shortcut.action;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.troop.shortcut.action.processors.c;
import com.tencent.mobileqq.troop.shortcut.actions.TroopShortcutAction;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001c\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\"\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u0012J\u0006\u0010\u0016\u001a\u00020\tR\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001dR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/action/a;", "", "", "Lcom/tencent/mobileqq/troop/shortcut/actions/a;", "a", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "i", "g", "Lcom/tencent/mobileqq/troop/shortcut/actions/TroopShortcutAction;", "action", "", h.F, "f", "e", "Lkotlin/Function1;", "", "onFailure", "c", "b", "Lcom/tencent/mobileqq/troop/shortcut/actions/b;", "Lcom/tencent/mobileqq/troop/shortcut/actions/b;", "d", "()Lcom/tencent/mobileqq/troop/shortcut/actions/b;", "context", "Lcom/tencent/mobileqq/troop/shortcut/action/b;", "Lcom/tencent/mobileqq/troop/shortcut/action/b;", "preconditionChecker", "Ljava/util/List;", "processorList", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Troop/Inject_troop_shortcut_processor.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<com.tencent.mobileqq.troop.shortcut.actions.a>> f298435e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.shortcut.actions.b context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b preconditionChecker;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.troop.shortcut.actions.a> processorList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/action/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.shortcut.action.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55036);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        INSTANCE = new Companion(null);
        ArrayList<Class<com.tencent.mobileqq.troop.shortcut.actions.a>> arrayList = new ArrayList<>();
        f298435e = arrayList;
        arrayList.add(dt2.b.class);
        arrayList.add(com.tencent.mobileqq.troop.shortcut.action.processors.a.class);
        arrayList.add(com.tencent.mobileqq.troop.shortcut.action.processors.b.class);
        arrayList.add(c.class);
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.context = new com.tencent.mobileqq.troop.shortcut.actions.b();
        this.preconditionChecker = new b();
        this.processorList = a();
    }

    private final List<com.tencent.mobileqq.troop.shortcut.actions.a> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = f298435e.iterator();
        while (it.hasNext()) {
            Object newInstance = ((Class) it.next()).newInstance();
            Intrinsics.checkNotNullExpressionValue(newInstance, "clazz.newInstance()");
            arrayList.add(newInstance);
        }
        com.tencent.xaction.log.b.a("TroopShortcutActionExecutor", 2, "assembleProcessors for businessProcessorList:" + f298435e.size());
        return arrayList;
    }

    private final void g() {
        Iterator<T> it = this.processorList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.troop.shortcut.actions.a) it.next()).b(this.context);
        }
    }

    private final boolean h(TroopShortcutAction action) {
        int size = this.processorList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.processorList.get(i3).a(action, this.context)) {
                com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("TroopShortcutActionExecutor", "action processed by " + this.processorList.get(i3));
                return true;
            }
        }
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.c("TroopShortcutActionExecutor", "action is not processed, processorList.size:" + this.processorList.size() + ", actionType:" + action.f() + ", appId:" + action.a());
        return false;
    }

    private final void i(com.tencent.aio.api.runtime.a aioContext, Activity activity) {
        com.tencent.mobileqq.troop.shortcut.actions.b bVar = this.context;
        bVar.h(aioContext);
        bVar.g(activity);
        g();
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Iterator<com.tencent.mobileqq.troop.shortcut.actions.a> it = this.processorList.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }

    public final boolean c(@NotNull TroopShortcutAction action, @NotNull Function1<? super String, Unit> onFailure) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) action, (Object) onFailure)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        if (!this.preconditionChecker.a(action, onFailure)) {
            return false;
        }
        return h(action);
    }

    @NotNull
    public final com.tencent.mobileqq.troop.shortcut.actions.b d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.troop.shortcut.actions.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    public final void e(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
            i(null, activity);
        }
    }

    public final void f(@Nullable com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aioContext);
        } else {
            i(aioContext, null);
        }
    }
}
