package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RecentRecommendTroopItemView extends RelativeLayout {
    static IPatchRedirector $redirector_;

    public RecentRecommendTroopItemView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            a();
        }
    }

    private void a() {
    }
}
