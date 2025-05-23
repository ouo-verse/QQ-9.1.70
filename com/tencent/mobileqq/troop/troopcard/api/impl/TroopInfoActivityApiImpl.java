package com.tencent.mobileqq.troop.troopcard.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.edittroopinfo.EditTroopInfoFragment;
import com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi;
import com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity;
import com.tencent.mobileqq.troop.troopcard.utils.e;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopInfoActivityApiImpl implements ITroopInfoActivityApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TroopInfoActivityApiImpl";

    public TroopInfoActivityApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean useNewEditTroopInfoPage() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106077", false);
        QLog.i(TAG, 1, "[useNewEditTroopInfoPage] userOldPage:" + isSwitchOn);
        return !isSwitchOn;
    }

    @Override // com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi
    public Class<?> getParserClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return e.class;
    }

    @Override // com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi
    public void openTroopProfile(Context context, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) bundle);
            return;
        }
        if (context != null) {
            try {
                if (useNewEditTroopInfoPage()) {
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    QPublicFragmentActivity.start(context, intent, EditTroopInfoFragment.class);
                } else {
                    Intent intent2 = new Intent(context, (Class<?>) TroopInfoActivity.class);
                    intent2.putExtras(bundle);
                    if (!(context instanceof Activity)) {
                        intent2.addFlags(268435456);
                    }
                    context.startActivity(intent2);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, e16.toString());
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi
    public void openTroopProfileForResult(Activity activity, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, bundle, Integer.valueOf(i3));
            return;
        }
        if (activity != null) {
            try {
                if (useNewEditTroopInfoPage()) {
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) EditTroopInfoFragment.class, i3);
                } else {
                    Intent intent2 = new Intent(activity, (Class<?>) TroopInfoActivity.class);
                    intent2.putExtras(bundle);
                    activity.startActivityForResult(intent2, i3);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, e16.toString());
                }
            }
        }
    }
}
