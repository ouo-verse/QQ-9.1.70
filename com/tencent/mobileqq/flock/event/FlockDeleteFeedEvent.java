package com.tencent.mobileqq.flock.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import y45.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/flock/event/FlockDeleteFeedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Ly45/b;", "feed", "Ly45/b;", "getFeed", "()Ly45/b;", "<init>", "(Ly45/b;)V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockDeleteFeedEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @NotNull
    private final b feed;

    public FlockDeleteFeedEvent(@NotNull b feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) feed);
        } else {
            this.feed = feed;
        }
    }

    @NotNull
    public final b getFeed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.feed;
    }
}
