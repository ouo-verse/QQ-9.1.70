package com.tencent.qqnt.aio.activity;

import androidx.annotation.MainThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.MsgIntent;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007R<\u0010\u000f\u001a*\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f0\nj\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/activity/h;", "", "Lcom/tencent/qqnt/aio/activity/AIODelegate;", "aio", "", "b", "a", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "c", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mAIODelegateMap", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f348481a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, WeakReference<AIODelegate>> mAIODelegateMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39550);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f348481a = new h();
            mAIODelegateMap = new HashMap<>();
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @MainThread
    public final void a(@NotNull AIODelegate aio) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aio);
            return;
        }
        Intrinsics.checkNotNullParameter(aio, "aio");
        int hashCode = aio.hashCode();
        HashMap<Integer, WeakReference<AIODelegate>> hashMap = mAIODelegateMap;
        if (!hashMap.containsKey(Integer.valueOf(hashCode))) {
            return;
        }
        hashMap.remove(Integer.valueOf(hashCode));
    }

    @MainThread
    public final void b(@NotNull AIODelegate aio) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aio);
            return;
        }
        Intrinsics.checkNotNullParameter(aio, "aio");
        int hashCode = aio.hashCode();
        HashMap<Integer, WeakReference<AIODelegate>> hashMap = mAIODelegateMap;
        if (hashMap.containsKey(Integer.valueOf(hashCode))) {
            return;
        }
        hashMap.put(Integer.valueOf(hashCode), new WeakReference<>(aio));
    }

    @MainThread
    public final void c(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        Iterator<Map.Entry<Integer, WeakReference<AIODelegate>>> it = mAIODelegateMap.entrySet().iterator();
        while (it.hasNext()) {
            AIODelegate aIODelegate = it.next().getValue().get();
            if (aIODelegate != null) {
                aIODelegate.a(intent);
            }
        }
    }
}
