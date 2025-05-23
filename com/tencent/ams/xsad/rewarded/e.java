package com.tencent.ams.xsad.rewarded;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public final /* synthetic */ class e {
    public static void a(RewardedAdListener rewardedAdListener) {
        IPatchRedirector iPatchRedirector = RewardedAdListener.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) rewardedAdListener);
        }
    }

    public static void b(RewardedAdListener rewardedAdListener, com.tencent.ams.xsad.rewarded.view.a aVar, JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = RewardedAdListener.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) rewardedAdListener, (Object) aVar, (Object) jSONObject);
        }
    }
}
