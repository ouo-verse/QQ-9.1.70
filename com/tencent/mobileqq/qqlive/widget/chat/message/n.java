package com.tencent.mobileqq.qqlive.widget.chat.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/message/n;", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/f;", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/i;", "getHeader", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$SpeakerInfo;", "d", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$SpeakerInfo;", "b", "()Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$SpeakerInfo;", "speakerInfo", "e", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/i;", "msgHeader", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class n implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveMessageData.SpeakerInfo speakerInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i msgHeader;

    @NotNull
    public final LiveMessageData.SpeakerInfo b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveMessageData.SpeakerInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.speakerInfo;
    }

    @Override // com.tencent.mobileqq.qqlive.widget.chat.message.f
    @NotNull
    public i getHeader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (i) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.msgHeader;
    }
}
