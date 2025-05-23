package com.tencent.qqnt.aio.api.impl;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qqnt.aio.api.IAIOUniteConfigApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J#\u0010\n\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOUniteConfigApiNtImpl;", "Lcom/tencent/qqnt/aio/api/IAIOUniteConfigApi;", "Lcom/tencent/freesia/IConfigData;", "T", "", VipFunCallConstants.KEY_GROUP, "Lcom/tencent/qqnt/aio/api/a;", "callback", "", "loadLargeConfigAsync", "loadConfig", "(Ljava/lang/String;)Lcom/tencent/freesia/IConfigData;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOUniteConfigApiNtImpl implements IAIOUniteConfigApi {
    static IPatchRedirector $redirector_;

    public AIOUniteConfigApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IAIOUniteConfigApi
    @Nullable
    public <T extends IConfigData> T loadConfig(@NotNull String group) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this, (Object) group);
        }
        Intrinsics.checkNotNullParameter(group, "group");
        return null;
    }

    @Override // com.tencent.qqnt.aio.api.IAIOUniteConfigApi
    public <T extends IConfigData> void loadLargeConfigAsync(@NotNull String group, @NotNull com.tencent.qqnt.aio.api.a<T> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) group, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(group, "group");
            Intrinsics.checkNotNullParameter(callback, "callback");
        }
    }
}
