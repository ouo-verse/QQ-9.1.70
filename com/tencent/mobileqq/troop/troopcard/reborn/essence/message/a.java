package com.tencent.mobileqq.troop.troopcard.reborn.essence.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.EssenceMsgInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/message/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/EssenceMsgInfo;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/EssenceMsgInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/EssenceMsgInfo;", "c", "(Lcom/tencent/qqnt/kernel/nativeinterface/EssenceMsgInfo;)V", "essenceMsgInfo", "", "b", "Z", "()Z", "d", "(Z)V", "isLastMsg", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private EssenceMsgInfo essenceMsgInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isLastMsg;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.essenceMsgInfo = new EssenceMsgInfo();
        }
    }

    @NotNull
    public final EssenceMsgInfo a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EssenceMsgInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.essenceMsgInfo;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isLastMsg;
    }

    public final void c(@NotNull EssenceMsgInfo essenceMsgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) essenceMsgInfo);
        } else {
            Intrinsics.checkNotNullParameter(essenceMsgInfo, "<set-?>");
            this.essenceMsgInfo = essenceMsgInfo;
        }
    }

    public final void d(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.isLastMsg = z16;
        }
    }
}
