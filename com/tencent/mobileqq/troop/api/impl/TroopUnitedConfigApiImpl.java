package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ITroopUnitedConfigApi;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/api/impl/TroopUnitedConfigApiImpl;", "Lcom/tencent/mobileqq/troop/api/ITroopUnitedConfigApi;", "()V", "getBoolean", "", "configId", "", "key", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getInt", "", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopUnitedConfigApiImpl implements ITroopUnitedConfigApi {
    static IPatchRedirector $redirector_;

    public TroopUnitedConfigApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUnitedConfigApi
    public boolean getBoolean(@NotNull String configId, @NotNull String key, boolean defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, configId, key, Boolean.valueOf(defaultValue))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(configId, "configId");
        Intrinsics.checkNotNullParameter(key, "key");
        return com.tencent.mobileqq.troop.config.b.f294691a.b(configId, key, defaultValue);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUnitedConfigApi
    public int getInt(@NotNull String configId, @NotNull String key, int defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, configId, key, Integer.valueOf(defaultValue))).intValue();
        }
        Intrinsics.checkNotNullParameter(configId, "configId");
        Intrinsics.checkNotNullParameter(key, "key");
        return com.tencent.mobileqq.troop.config.b.f294691a.d(configId, key, defaultValue);
    }
}
