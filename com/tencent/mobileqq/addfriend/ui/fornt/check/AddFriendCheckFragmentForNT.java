package com.tencent.mobileqq.addfriend.ui.fornt.check;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.part.OpenAddFriendPart;
import com.tencent.mobileqq.addfriend.ui.fornt.AddFriendForNtLauncher;
import com.tencent.mobileqq.addfriend.ui.fornt.check.part.AddFriendCheckLogicPart;
import com.tencent.mobileqq.addfriend.ui.fornt.check.part.AddFriendCheckProcessDialogPart;
import com.tencent.mobileqq.addfriend.ui.fornt.check.part.AddFriendSettingPart;
import com.tencent.mobileqq.addfriend.ui.fornt.check.part.d;
import com.tencent.mobileqq.addfriend.ui.fornt.check.viewmodel.a;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AddFriendCheckFragmentForNT extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;
    private OpenAddFriendPart C;
    private a D;

    public AddFriendCheckFragmentForNT() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void ph(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendCheckFragmentForNT", 2, "dismissOrHideProgress hide: " + z16);
        }
        a aVar = this.D;
        if (aVar != null) {
            if (z16) {
                aVar.L1().postValue(2);
                return;
            } else {
                aVar.L1().postValue(0);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendCheckFragmentForNT", 2, "mCheckProgressViewModel null: ");
        }
    }

    private Intent qh() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            return new Intent();
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            Parcelable parcelable = arguments.getParcelable("add_friend_intent");
            if (parcelable instanceof Intent) {
                return (Intent) parcelable;
            }
        }
        Intent intent = qBaseActivity.getIntent();
        if (intent == null) {
            return new Intent();
        }
        return intent;
    }

    private boolean rh() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendCheckFragmentForNT", 2, "assembleParts");
        }
        ArrayList arrayList = new ArrayList();
        OpenAddFriendPart openAddFriendPart = new OpenAddFriendPart();
        this.C = openAddFriendPart;
        openAddFriendPart.setIntent(qh());
        arrayList.add(this.C);
        arrayList.add(new AddFriendCheckProcessDialogPart());
        arrayList.add(new AddFriendSettingPart());
        arrayList.add(new d());
        arrayList.add(new AddFriendCheckLogicPart());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.gz8;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (rh()) {
            return;
        }
        Intent qh5 = qh();
        if (qh5 != null) {
            z16 = qh5.getBooleanExtra("need_result_uin", false);
        }
        if (z16) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra("uin", qh().getStringExtra("uin"));
        }
        getActivity().setResult(i16, intent);
        getActivity().finish();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendCheckFragmentForNT", 2, "onCreate");
        }
        super.onCreate(bundle);
        this.D = (a) getViewModel(a.class);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ph(false);
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("add_friend_openid_opt", false);
        QLog.i("AddFriendCheckFragmentForNT", 1, "onDestroy add_friend_openid_opt switch: " + isSwitchOn);
        if (isSwitchOn) {
            AddFriendForNtLauncher.vh("");
        }
        super.onDestroy();
    }
}
