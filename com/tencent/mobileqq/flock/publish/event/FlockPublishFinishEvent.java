package com.tencent.mobileqq.flock.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import y45.b;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/event/FlockPublishFinishEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Ly45/b;", "feed", "Ly45/b;", "getFeed", "()Ly45/b;", "", "isModify", "Z", "()Z", "<init>", "(Ly45/b;Z)V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockPublishFinishEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @Nullable
    private final b feed;
    private final boolean isModify;

    public FlockPublishFinishEvent(@Nullable b bVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bVar, Boolean.valueOf(z16));
        } else {
            this.feed = bVar;
            this.isModify = z16;
        }
    }

    @Nullable
    public final b getFeed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.feed;
    }

    public final boolean isModify() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isModify;
    }
}
