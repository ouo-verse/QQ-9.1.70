package com.tencent.mobileqq.notification.modularize.business;

import android.content.Intent;
import com.tencent.mobileqq.notification.modularize.BaseJumpScheme;
import com.tencent.mobileqq.notification.modularize.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.settings.message.NotifyPushSettingFragment;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/notification/modularize/business/e;", "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "Lcom/tencent/mobileqq/notification/modularize/f;", "pushComponent", "Landroid/content/Intent;", "b", "k", "", "j", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class e extends BaseJumpScheme {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.notification.modularize.BaseJumpScheme
    @NotNull
    protected Intent b(@NotNull f pushComponent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Intent) iPatchRedirector.redirect((short) 2, (Object) this, (Object) pushComponent);
        }
        Intrinsics.checkNotNullParameter(pushComponent, "pushComponent");
        return k(pushComponent);
    }

    @Override // com.tencent.mobileqq.notification.modularize.BaseJumpScheme
    protected boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    @NotNull
    public final Intent k(@NotNull f pushComponent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Intent) iPatchRedirector.redirect((short) 3, (Object) this, (Object) pushComponent);
        }
        Intrinsics.checkNotNullParameter(pushComponent, "pushComponent");
        Intent intent = new Intent(BaseApplication.context, (Class<?>) NotifyPushSettingFragment.class);
        intent.addFlags(268435456);
        return intent;
    }
}
