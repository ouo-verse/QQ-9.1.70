package com.tencent.mobileqq.troop.jointype.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/jointype/event/TroopManageAutoApprovalEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "groupId", "", "isAutoApprovalOpen", "", "(Ljava/lang/String;Z)V", "getGroupId", "()Ljava/lang/String;", "()Z", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopManageAutoApprovalEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String groupId;
    private final boolean isAutoApprovalOpen;

    public TroopManageAutoApprovalEvent(@NotNull String groupId, boolean z16) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, groupId, Boolean.valueOf(z16));
        } else {
            this.groupId = groupId;
            this.isAutoApprovalOpen = z16;
        }
    }

    @NotNull
    public final String getGroupId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.groupId;
    }

    public final boolean isAutoApprovalOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isAutoApprovalOpen;
    }
}
