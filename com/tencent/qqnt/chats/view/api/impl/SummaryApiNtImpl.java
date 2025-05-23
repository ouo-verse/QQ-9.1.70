package com.tencent.qqnt.chats.view.api.impl;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.view.api.ISummaryApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/chats/view/api/impl/SummaryApiNtImpl;", "Lcom/tencent/qqnt/chats/view/api/ISummaryApi;", "()V", "isSupportSummaryNickEmojiAnimation", "", "()Z", "getSummartContentTextView", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "getSummaryNick", "", "nick", "chats_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class SummaryApiNtImpl implements ISummaryApi {
    static IPatchRedirector $redirector_;

    public SummaryApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.view.api.ISummaryApi
    @NotNull
    public TextView getSummartContentTextView(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TextView) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return new TextView(context);
    }

    @Override // com.tencent.qqnt.chats.view.api.ISummaryApi
    @NotNull
    public CharSequence getSummaryNick(@NotNull CharSequence nick) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CharSequence) iPatchRedirector.redirect((short) 4, (Object) this, (Object) nick);
        }
        Intrinsics.checkNotNullParameter(nick, "nick");
        return nick;
    }

    @Override // com.tencent.qqnt.chats.view.api.ISummaryApi
    public boolean isSupportSummaryNickEmojiAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }
}
