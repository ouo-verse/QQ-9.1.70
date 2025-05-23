package com.tencent.mobileqq.groupvideo.bridgeengine;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.launcher.api.ITroopLauncherApi;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/bridgeengine/GroupVideoLauncherService;", "Lcom/tencent/mobileqq/groupvideo/bridgeengine/IGroupVideoLauncherService;", "()V", "startActivity", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "clsName", "", "group-video-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GroupVideoLauncherService implements IGroupVideoLauncherService {
    static IPatchRedirector $redirector_;

    public GroupVideoLauncherService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IGroupVideoLauncherService
    public void startActivity(@Nullable Context context, @Nullable Intent intent, @Nullable String clsName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, intent, clsName);
        } else {
            ((ITroopLauncherApi) QRoute.api(ITroopLauncherApi.class)).startActivity(context, intent, clsName);
        }
    }
}
