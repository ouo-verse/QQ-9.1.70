package com.tencent.mobileqq.qqlive.widget.chat.floating;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatGiftMsgItemView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wi2.c;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ChatGiftMsgFloatingItemView extends ChatGiftMsgItemView {
    static IPatchRedirector $redirector_;

    public ChatGiftMsgFloatingItemView(@NotNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatBaseText
    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return c.b(14);
    }

    @Override // com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatBaseText
    public void setSelfPadding() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            setPadding(c.b(7), c.b(2), c.b(7), c.b(2));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatGiftMsgItemView
    public void z(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            setBackgroundDrawable(null);
        }
    }

    public ChatGiftMsgFloatingItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3));
    }
}
