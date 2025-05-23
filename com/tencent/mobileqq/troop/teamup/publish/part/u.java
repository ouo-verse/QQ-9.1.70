package com.tencent.mobileqq.troop.teamup.publish.part;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0014\u0010\u0003\u001a\u00020\u00008\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0001\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"", "a", "Ljava/lang/String;", "TAG", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class u {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final String f299181a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56486);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f299181a = "TroopTeamUp.Publish";
        }
    }
}
