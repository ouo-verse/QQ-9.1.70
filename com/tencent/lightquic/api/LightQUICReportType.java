package com.tencent.lightquic.api;

import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/lightquic/api/LightQUICReportType;", "", "()V", "SESSION", "", "STREAM", "LightQUIC_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class LightQUICReportType {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final LightQUICReportType INSTANCE;
    public static final int SESSION = 0;
    public static final int STREAM = 1;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(MessageHandlerConstants.NOTIFY_TYPE_MOVIE_TICKET_SEND_ERROR_RSP);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new LightQUICReportType();
        }
    }

    LightQUICReportType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
