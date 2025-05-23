package com.tencent.qqnt.graytips.action;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/graytips/action/o;", "Lcom/tencent/qqnt/graytips/action/a;", "", "getActionType", "", "uid", "nick", "uin", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class o extends a {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@NotNull String uid, @NotNull String nick, @NotNull String uin) {
        super(uid, nick, uin);
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(uin, "uin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, uid, nick, uin);
        }
    }

    @Override // com.tencent.qqnt.graytips.action.f
    public int getActionType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 70;
    }
}
