package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.aio.adapter.api.IAIOSharedPreference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOSharedPreferenceNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOSharedPreference;", "()V", "getSharedPreference", "Landroid/content/SharedPreferences;", "name", "", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class AIOSharedPreferenceNtImpl implements IAIOSharedPreference {
    static IPatchRedirector $redirector_;

    public AIOSharedPreferenceNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOSharedPreference
    @NotNull
    public SharedPreferences getSharedPreference(@NotNull String name) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 2, (Object) this, (Object) name);
        }
        Intrinsics.checkNotNullParameter(name, "name");
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(name, 4);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getContext().getSharedPr\u2026ntext.MODE_MULTI_PROCESS)");
        return sharedPreferences;
    }
}
