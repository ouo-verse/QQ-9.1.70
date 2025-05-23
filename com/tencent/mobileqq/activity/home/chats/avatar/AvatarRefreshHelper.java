package com.tencent.mobileqq.activity.home.chats.avatar;

import androidx.annotation.UiThread;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.bus.api.IBusManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u001b\u0010\u0013\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\n\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/avatar/AvatarRefreshHelper;", "", "", "d", "", "uin", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "cacheUinSet", "", "Z", "isWaitingNotify", "Ljava/lang/Runnable;", "Lkotlin/Lazy;", "()Ljava/lang/Runnable;", "lastRunnable", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AvatarRefreshHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AvatarRefreshHelper f182873a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Long, Integer> cacheUinSet;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isWaitingNotify;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy lastRunnable;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50672);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f182873a = new AvatarRefreshHelper();
        cacheUinSet = new ConcurrentHashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(AvatarRefreshHelper$lastRunnable$2.INSTANCE);
        lastRunnable = lazy;
    }

    AvatarRefreshHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Runnable b() {
        return (Runnable) lastRunnable.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        ConcurrentHashMap<Long, Integer> concurrentHashMap = cacheUinSet;
        Enumeration<Long> keys = concurrentHashMap.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "cacheUinSet.keys()");
        ArrayList list = Collections.list(keys);
        Intrinsics.checkNotNullExpressionValue(list, "list(this)");
        concurrentHashMap.clear();
        ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new com.tencent.qqnt.bus.event.a(list));
        isWaitingNotify = false;
    }

    @UiThread
    public final void c(@NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) uin);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        cacheUinSet.put(Long.valueOf(Long.parseLong(uin)), 1);
        if (!isWaitingNotify) {
            isWaitingNotify = true;
            ThreadManagerV2.getUIHandlerV2().postDelayed(b(), 300L);
        }
    }
}
