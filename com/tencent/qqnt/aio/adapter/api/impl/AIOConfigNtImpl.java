package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IAIOConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOConfigNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOConfig;", "()V", "canSwipeReplyVibrate", "", "context", "Landroid/content/Context;", "isFeatureSwitchOn", "switchId", "", "default", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class AIOConfigNtImpl implements IAIOConfig {
    static IPatchRedirector $redirector_;

    public AIOConfigNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOConfig
    public boolean canSwipeReplyVibrate(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Object systemService = context.getSystemService("audio");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            if (((AudioManager) systemService).getRingerMode() == 0) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOConfig
    public boolean isFeatureSwitchOn(@NotNull String switchId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) switchId)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(switchId, "switchId");
        return isFeatureSwitchOn(switchId, true);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOConfig
    public boolean isFeatureSwitchOn(@NotNull String switchId, boolean r75) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, switchId, Boolean.valueOf(r75))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(switchId, "switchId");
        return !Intrinsics.areEqual(IAIOConfig.FEATURE_PHOTO_PANEL_BLUR, switchId);
    }
}
