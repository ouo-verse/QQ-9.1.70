package com.tencent.mobileqq.troop.api.config;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.MemberExtInfo;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class m {
    static IPatchRedirector $redirector_;

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(@NonNull AppInterface appInterface, @NonNull Bundle bundle, @NonNull Map<String, String> map, List<MemberExtInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, bundle, map, list);
        }
    }
}
