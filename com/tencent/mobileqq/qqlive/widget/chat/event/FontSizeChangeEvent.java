package com.tencent.mobileqq.qqlive.widget.chat.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.widget.chat.font.FontSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/event/FontSizeChangeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "fontSize", "Lcom/tencent/mobileqq/qqlive/widget/chat/font/FontSize;", "(Lcom/tencent/mobileqq/qqlive/widget/chat/font/FontSize;)V", "getFontSize", "()Lcom/tencent/mobileqq/qqlive/widget/chat/font/FontSize;", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class FontSizeChangeEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @NotNull
    private final FontSize fontSize;

    public FontSizeChangeEvent(@NotNull FontSize fontSize) {
        Intrinsics.checkNotNullParameter(fontSize, "fontSize");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fontSize);
        } else {
            this.fontSize = fontSize;
        }
    }

    @NotNull
    public final FontSize getFontSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FontSize) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.fontSize;
    }
}
