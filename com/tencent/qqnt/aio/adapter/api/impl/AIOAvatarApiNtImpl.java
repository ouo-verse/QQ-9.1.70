package com.tencent.qqnt.aio.adapter.api.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IAIOAvatarApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J%\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\bH\u0016\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOAvatarApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOAvatarApi;", "()V", "getAvatar", "Landroid/graphics/Bitmap;", "uin", "", "getAvatars", "", "uins", "([Ljava/lang/String;)[Landroid/graphics/Bitmap;", "useCircleImageView", "", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class AIOAvatarApiNtImpl implements IAIOAvatarApi {
    static IPatchRedirector $redirector_;

    public AIOAvatarApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOAvatarApi
    public void clearAIOCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            IAIOAvatarApi.a.a(this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOAvatarApi
    @Nullable
    public Bitmap getAvatar(@Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uin);
        }
        return null;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOAvatarApi
    @NotNull
    public Bitmap[] getAvatars(@NotNull String[] uins) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) uins);
        }
        Intrinsics.checkNotNullParameter(uins, "uins");
        return new Bitmap[0];
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOAvatarApi
    public boolean isUseOldAvatarComponent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return IAIOAvatarApi.a.b(this);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOAvatarApi
    public boolean useCircleImageView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }
}
