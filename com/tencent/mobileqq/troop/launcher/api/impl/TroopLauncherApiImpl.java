package com.tencent.mobileqq.troop.launcher.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.activity.editinfo.EditInfoActivity;
import com.tencent.mobileqq.troop.launcher.api.ITroopLauncherApi;
import com.tencent.mobileqq.troop.livesync.TroopLiveSyncFragment;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopLauncherApiImpl implements ITroopLauncherApi {
    static IPatchRedirector $redirector_;

    public TroopLauncherApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.launcher.api.ITroopLauncherApi
    public Class getEditInfoActivityClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return EditInfoActivity.class;
    }

    @Override // com.tencent.mobileqq.troop.launcher.api.ITroopLauncherApi
    public boolean startActivity(Context context, Intent intent, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, context, intent, str)).booleanValue();
        }
        if (context == null || str == null || str.isEmpty() || !str.equals("TroopLiveSyncFloating")) {
            return false;
        }
        intent.addFlags(268435456);
        intent.putExtra("public_fragment_window_feature", 1);
        QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, TroopLiveSyncFragment.class);
        return true;
    }
}
