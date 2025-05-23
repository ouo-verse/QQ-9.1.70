package com.tencent.aio.base.chat;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.dispatcher.AIODispatcherExecutor;
import kotlin.Metadata;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/aio/base/chat/a;", "Lcom/tencent/mvi/dispatcher/AIODispatcherExecutor;", "", "e", "I", "availableProcessors", "d", "()I", "maxPoolSize", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a extends AIODispatcherExecutor {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int availableProcessors;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.availableProcessors = Runtime.getRuntime().availableProcessors();
        }
    }

    @Override // com.tencent.mvi.dispatcher.AIODispatcherExecutor
    public int d() {
        int coerceAtLeast;
        int coerceAtMost;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.availableProcessors, 3);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, 6);
            return coerceAtMost;
        }
        return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
    }
}
