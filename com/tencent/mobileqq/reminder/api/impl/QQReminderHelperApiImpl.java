package com.tencent.mobileqq.reminder.api.impl;

import android.content.Context;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.reminder.api.IQQReminderHelperApi;
import com.tencent.mobileqq.reminder.debug.NotifyCardDebugFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/reminder/api/impl/QQReminderHelperApiImpl;", "Lcom/tencent/mobileqq/reminder/api/IQQReminderHelperApi;", "()V", "is0x118NtPushChannel", "", "is0x13aNtPushChannel", "launchNotifyCardDebugPage", "", "context", "Landroid/content/Context;", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class QQReminderHelperApiImpl implements IQQReminderHelperApi {
    static IPatchRedirector $redirector_;

    public QQReminderHelperApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderHelperApi
    public boolean is0x118NtPushChannel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return com.tencent.mobileqq.reminder.config.b.f281031a.b("105529", true);
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderHelperApi
    public boolean is0x13aNtPushChannel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return com.tencent.mobileqq.reminder.config.b.f281031a.b("105583", false);
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderHelperApi
    public void launchNotifyCardDebugPage(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            QPublicFragmentActivity.start(context, NotifyCardDebugFragment.class);
        }
    }
}
