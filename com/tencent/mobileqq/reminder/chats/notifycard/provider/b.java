package com.tencent.mobileqq.reminder.chats.notifycard.provider;

import android.view.ViewGroup;
import com.tencent.mobileqq.cardcontainer.d;
import com.tencent.mobileqq.cardcontainer.data.CardType;
import com.tencent.mobileqq.cardcontainer.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.reminder.chats.notifycard.view.NotifyGuestCardView;
import com.tencent.mobileqq.reminder.chats.notifycard.view.NotifyMainCardView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/provider/b;", "Lcom/tencent/mobileqq/cardcontainer/f;", "Lcom/tencent/mobileqq/cardcontainer/data/CardType;", "cardType", "Landroid/view/ViewGroup;", "parentView", "Lcom/tencent/mobileqq/cardcontainer/d;", "a", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b implements f {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.f
    @NotNull
    public d a(@NotNull CardType cardType, @NotNull ViewGroup parentView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cardType, (Object) parentView);
        }
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        if (cardType == CardType.GroupMsgReminder) {
            return new NotifyGuestCardView(parentView);
        }
        return new NotifyMainCardView(parentView);
    }
}
