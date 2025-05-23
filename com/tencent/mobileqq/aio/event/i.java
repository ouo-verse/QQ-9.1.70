package com.tencent.mobileqq.aio.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\t\u0010\nR#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/event/i;", "", "Lkotlin/Pair;", "", "a", "Lkotlin/Pair;", "getPos", "()Lkotlin/Pair;", com.tencent.luggage.wxa.c8.c.G, "<init>", "(Lkotlin/Pair;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class i implements com.tencent.mvi.base.route.k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Pair<Integer, Integer> pos;

    public i(@NotNull Pair<Integer, Integer> pos) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pos);
        } else {
            this.pos = pos;
        }
    }
}
