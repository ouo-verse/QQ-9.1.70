package com.tencent.mobileqq.troop.selecttroopmember.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.deletemember.TroopDeleteMemberFragment;
import com.tencent.mobileqq.troop.selecttroopmember.ISelectTroopMemberStarter;

/* compiled from: P */
/* loaded from: classes19.dex */
public class SelectTroopMemberStarterImpl implements ISelectTroopMemberStarter {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SelectTroopMemberStarte";

    public SelectTroopMemberStarterImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Class<? extends QPublicBaseFragment> getDeleteTroopMemberPage() {
        return TroopDeleteMemberFragment.class;
    }

    protected static Intent getIntent(Bundle bundle, String str) {
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean("hide_title_left_arrow", true);
        bundle.putString("troopUin", str);
        intent.putExtras(bundle);
        return intent;
    }

    @Override // com.tencent.mobileqq.troop.selecttroopmember.ISelectTroopMemberStarter
    public void start(Activity activity, boolean z16, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, Boolean.valueOf(z16), Integer.valueOf(i3), str);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(ISelectTroopMemberStarter.INTENT_PARAM_ONLYLOADLOCALDATA, z16);
        bundle.putInt("from", i3);
        QPublicFragmentActivity.start(activity, getIntent(bundle, str), getDeleteTroopMemberPage());
    }

    @Override // com.tencent.mobileqq.troop.selecttroopmember.ISelectTroopMemberStarter
    public void startForResult(Activity activity, boolean z16, int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, Boolean.valueOf(z16), Integer.valueOf(i3), str, Integer.valueOf(i16));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(ISelectTroopMemberStarter.INTENT_PARAM_ONLYLOADLOCALDATA, z16);
        bundle.putInt("from", i3);
        QPublicFragmentActivity.startForResult(activity, getIntent(bundle, str), getDeleteTroopMemberPage(), i16);
    }
}
