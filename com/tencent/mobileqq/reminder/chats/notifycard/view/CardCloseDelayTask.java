package com.tencent.mobileqq.reminder.chats.notifycard.view;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\t\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/view/CardCloseDelayTask;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/reminder/chats/notifycard/view/a;", "kotlin.jvm.PlatformType", "d", "Lmqq/util/WeakReference;", "mCardRef", IndividuationUrlHelper.UrlId.CARD_HOME, "<init>", "(Lcom/tencent/mobileqq/reminder/chats/notifycard/view/a;)V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
final class CardCloseDelayTask implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<a> mCardRef;

    public CardCloseDelayTask(@NotNull a card) {
        Intrinsics.checkNotNullParameter(card, "card");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) card);
        } else {
            this.mCardRef = new WeakReference<>(card);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        a aVar = this.mCardRef.get();
        if (aVar == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("NotifyGuestCardView", 1, "CardCloseDelayTask run card is released: " + z16);
        if (aVar != null) {
            aVar.c(true);
        }
    }
}
