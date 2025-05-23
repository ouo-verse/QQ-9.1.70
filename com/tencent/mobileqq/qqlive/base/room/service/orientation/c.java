package com.tencent.mobileqq.qqlive.base.room.service.orientation;

import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.base.room.service.event.d;
import com.tencent.mobileqq.qqlive.framework.page.Page;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/room/service/orientation/c;", "", "Lcom/tencent/mobileqq/qqlive/base/room/service/orientation/b;", "", MiniChatConstants.MINI_APP_LANDSCAPE, "", "a", "Lcom/tencent/mobileqq/qqlive/framework/page/Page;", "Lcom/tencent/mobileqq/qqlive/framework/page/Page;", "trigger", "b", "Z", "<init>", "(Lcom/tencent/mobileqq/qqlive/framework/page/Page;)V", "qq-live-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Page trigger;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isLandscape;

    public c(@NotNull Page trigger) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) trigger);
        } else {
            this.trigger = trigger;
        }
    }

    public void a(boolean isLandscape) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, isLandscape);
        } else {
            this.isLandscape = isLandscape;
            this.trigger.a(new d(isLandscape));
        }
    }
}
