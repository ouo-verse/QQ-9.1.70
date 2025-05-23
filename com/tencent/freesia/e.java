package com.tencent.freesia;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.freesia.UnitedConfigBridge;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes6.dex */
public final /* synthetic */ class e {
    @Nullable
    public static UnitedConfigBridge a(@Nullable UpperBridges upperBridges, @NonNull ArrayList<String> arrayList, @NonNull CommandType commandType, @NonNull Extend extend, @NonNull ExtraInitInfo extraInitInfo) {
        IPatchRedirector iPatchRedirector = UnitedConfigBridge.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (UnitedConfigBridge) iPatchRedirector.redirect((short) 1, upperBridges, arrayList, commandType, extend, extraInitInfo);
        }
        return UnitedConfigBridge.CppProxy.create(upperBridges, arrayList, commandType, extend, extraInitInfo);
    }

    @Nullable
    public static UnitedConfigBridge b() {
        IPatchRedirector iPatchRedirector = UnitedConfigBridge.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (UnitedConfigBridge) iPatchRedirector.redirect((short) 2);
        }
        return UnitedConfigBridge.CppProxy.getInstance();
    }
}
