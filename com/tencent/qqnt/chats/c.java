package com.tencent.qqnt.chats;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tR\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/chats/c;", "", "Lmw3/a;", "eventTrigger", "", "a", "(Lmw3/a;)V", "c", "()V", "Lcom/tencent/qqnt/chats/core/uievent/b;", "event", "", "b", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "<init>", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f354431a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<mw3.a> eventTrigger;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30333);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f354431a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@Nullable mw3.a eventTrigger2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) eventTrigger2);
            return;
        }
        QLog.d("RecentContactCenter", 1, "registerTrigger: " + eventTrigger2);
        eventTrigger = new WeakReference<>(eventTrigger2);
    }

    public final boolean b(@NotNull com.tencent.qqnt.chats.core.uievent.b event) {
        mw3.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        WeakReference<mw3.a> weakReference = eventTrigger;
        if (weakReference != null) {
            aVar = weakReference.get();
        } else {
            aVar = null;
        }
        if (aVar == null) {
            QLog.d("RecentContactCenter", 1, "sendEventToChat but trigger is null, event is: " + event);
            return false;
        }
        aVar.sendEventToChat(event);
        return true;
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            QLog.d("RecentContactCenter", 1, "unRegisterTrigger");
            eventTrigger = null;
        }
    }
}
