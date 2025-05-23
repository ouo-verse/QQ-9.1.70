package com.tencent.mobileqq.troop.jointype.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\nR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/jointype/event/TroopManageSetJoinTypeResultEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "seq", "", "processName", "", "multiGroupOption", "isSetSuccess", "", "troopUinList", "(ILjava/lang/String;IZLjava/lang/String;)V", "()Z", "getMultiGroupOption", "()I", "getProcessName", "()Ljava/lang/String;", "getSeq", "getTroopUinList", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopManageSetJoinTypeResultEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;
    private final boolean isSetSuccess;
    private final int multiGroupOption;

    @NotNull
    private final String processName;
    private final int seq;

    @NotNull
    private final String troopUinList;

    public TroopManageSetJoinTypeResultEvent(int i3, @NotNull String processName, int i16, boolean z16, @NotNull String troopUinList) {
        Intrinsics.checkNotNullParameter(processName, "processName");
        Intrinsics.checkNotNullParameter(troopUinList, "troopUinList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), processName, Integer.valueOf(i16), Boolean.valueOf(z16), troopUinList);
            return;
        }
        this.seq = i3;
        this.processName = processName;
        this.multiGroupOption = i16;
        this.isSetSuccess = z16;
        this.troopUinList = troopUinList;
    }

    public final int getMultiGroupOption() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.multiGroupOption;
    }

    @NotNull
    public final String getProcessName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.processName;
    }

    public final int getSeq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.seq;
    }

    @NotNull
    public final String getTroopUinList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.troopUinList;
    }

    public final boolean isSetSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isSetSuccess;
    }
}
