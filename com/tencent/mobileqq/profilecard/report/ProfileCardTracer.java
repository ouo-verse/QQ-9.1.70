package com.tencent.mobileqq.profilecard.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.trace.r;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/profilecard/report/ProfileCardTracer;", "", "()V", "isEnd", "", "isStart", "tag", "", "tagNode", "", "nodeName", "profilecard-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ProfileCardTracer {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final ProfileCardTracer INSTANCE;
    private static volatile boolean isEnd = false;
    private static volatile boolean isStart = false;

    @NotNull
    private static final String tag = "ProfileCardTracer";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18611);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new ProfileCardTracer();
        }
    }

    ProfileCardTracer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void tagNode(@NotNull String nodeName) {
        Intrinsics.checkNotNullParameter(nodeName, "nodeName");
        synchronized (INSTANCE) {
            if (Intrinsics.areEqual("ITEM_CLICK", nodeName)) {
                isStart = true;
                isEnd = false;
            } else {
                if (!isEnd && isStart) {
                    if (Intrinsics.areEqual("refresh_ui_time", nodeName)) {
                        isEnd = true;
                        isStart = false;
                    }
                }
                return;
            }
            QLog.i(tag, 1, nodeName);
            r.f362387a.findStream("PROFILE_PAGE").tagNode(nodeName);
            Unit unit = Unit.INSTANCE;
        }
    }
}
