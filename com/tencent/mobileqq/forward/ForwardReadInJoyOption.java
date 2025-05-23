package com.tencent.mobileqq.forward;

import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/forward/ForwardReadInJoyOption;", "Lcom/tencent/mobileqq/forward/ForwardTextOption;", "i", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class ForwardReadInJoyOption extends ForwardTextOption {
    static IPatchRedirector $redirector_;

    public ForwardReadInJoyOption(@Nullable Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        } else {
            this.mSurpportTroopDiscussionTmpConv = false;
        }
    }
}
