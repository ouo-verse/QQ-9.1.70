package com.tencent.mobileqq.qqlive.sail.ui.definition;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.sail.model.audience.StreamDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/definition/DefinitionBeginSwitchEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "roomId", "", "definition", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamDefinition;", "(JLcom/tencent/mobileqq/qqlive/sail/model/audience/StreamDefinition;)V", "getDefinition", "()Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamDefinition;", "getRoomId", "()J", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class DefinitionBeginSwitchEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @NotNull
    private final StreamDefinition definition;
    private final long roomId;

    public DefinitionBeginSwitchEvent(long j3, @NotNull StreamDefinition definition) {
        Intrinsics.checkNotNullParameter(definition, "definition");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), definition);
        } else {
            this.roomId = j3;
            this.definition = definition;
        }
    }

    @NotNull
    public final StreamDefinition getDefinition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (StreamDefinition) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.definition;
    }

    public final long getRoomId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.roomId;
    }
}
