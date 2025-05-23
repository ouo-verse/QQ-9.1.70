package com.tencent.mobileqq.addfriend.ui.fornt.check.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.addfriend.handler.NTAddFriendHandler;
import com.tencent.mobileqq.addfriend.ui.fornt.AddFriendForNtLauncher;
import com.tencent.mobileqq.addfriend.ui.fornt.verify.AddFriendVerifyFragmentForNT;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.pad.e;
import com.tencent.mobileqq.pad.i;
import com.tencent.mobileqq.pad.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends Part {
    static IPatchRedirector $redirector_;
    protected int C;
    protected int D;
    protected String E;
    protected String F;
    protected int G;
    protected int H;
    protected byte[] I;
    protected int J;

    /* renamed from: d, reason: collision with root package name */
    protected NTAddFriendHandler f187474d;

    /* renamed from: e, reason: collision with root package name */
    protected String f187475e;

    /* renamed from: f, reason: collision with root package name */
    protected com.tencent.mobileqq.addfriend.ui.fornt.check.viewmodel.a f187476f;

    /* renamed from: h, reason: collision with root package name */
    protected int f187477h;

    /* renamed from: i, reason: collision with root package name */
    protected String f187478i;

    /* renamed from: m, reason: collision with root package name */
    protected String f187479m;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f187475e = "";
        this.D = -1;
        this.H = -1;
    }

    private void E9() {
        String stringExtra;
        AppInterface f16 = com.tencent.mobileqq.addfriend.utils.a.f();
        if (f16 == null) {
            return;
        }
        this.f187474d = (NTAddFriendHandler) f16.getBusinessHandler(NTAddFriendHandler.class.getName());
        if (C9().getStringExtra(IPublicAccountBrowser.KEY_CALL_FROM) == null) {
            stringExtra = getPartHost().getClass().getSimpleName();
        } else {
            stringExtra = C9().getStringExtra(IPublicAccountBrowser.KEY_CALL_FROM);
        }
        this.f187475e = stringExtra;
    }

    private void H9(Activity activity, Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("add_friend_intent", intent);
        i.e(activity, bundle, AddFriendVerifyFragmentForNT.class, new com.tencent.mobileqq.pad.b().e(false).g(false).h(LaunchMode.standard).a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (G9()) {
            return;
        }
        z9();
        int intExtra = C9().getIntExtra("sub_source_id", 0);
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendCheckBasePart", 2, "getAddFriendSetting, mUin = " + this.f187478i + " mFriendSource = " + this.C + " subSource = " + intExtra + " mExtUin = " + this.f187479m + " rankey = " + this.J + "mType = " + this.f187477h);
        }
        NTAddFriendHandler nTAddFriendHandler = this.f187474d;
        if (nTAddFriendHandler != null) {
            nTAddFriendHandler.P2(this.f187475e, this.f187478i, this.f187477h, this.C, intExtra, this.f187479m, this.J);
        }
    }

    public AppInterface B9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AppInterface) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return com.tencent.mobileqq.addfriend.utils.a.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Intent C9() {
        Bundle arguments;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Intent) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        Activity activity = getActivity();
        if (activity == null) {
            return new Intent();
        }
        if ((getPartHost() instanceof QBaseFragment) && (arguments = ((QBaseFragment) getPartHost()).getArguments()) != null) {
            Parcelable parcelable = arguments.getParcelable("add_friend_intent");
            if (parcelable instanceof Intent) {
                return (Intent) parcelable;
            }
        }
        Intent intent = activity.getIntent();
        if (intent == null) {
            return new Intent();
        }
        return intent;
    }

    public final QBaseActivity D9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (QBaseActivity) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return (QBaseActivity) getActivity();
    }

    protected void F9(Intent intent, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) activity);
            return;
        }
        if (intent == null) {
            if (QLog.isColorLevel()) {
                QLog.e("AddFriendCheckBasePart", 1, "intent is null");
                return;
            }
            return;
        }
        this.f187477h = intent.getIntExtra("k_uin_type", 0);
        this.f187478i = intent.getStringExtra("uin");
        this.E = intent.getStringExtra("last_activity");
        this.F = intent.getStringExtra("src_name");
        this.H = intent.getIntExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, -1);
        this.I = intent.getByteArrayExtra("flc_add_frd_token");
        this.C = intent.getIntExtra("source_id", BuddySource.DEFAULT);
        this.f187479m = intent.getStringExtra("extra");
        this.J = activity.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean G9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (getActivity() != null && !getActivity().isFinishing()) {
            return false;
        }
        return true;
    }

    public void I9(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) intent);
            return;
        }
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        intent.putExtra(IPublicAccountBrowser.KEY_CALL_FROM, this.f187475e);
        if (e.a() == SplitViewState.STATE_FLAT && !AddFriendForNtLauncher.qh(getContext(), intent)) {
            QLog.i("AddFriendCheckBasePart", 1, "startAddFriendVerifyFragment QFragmentContainerManager.currentSplitViewState() == SplitViewState.STATE_FLAT is true");
            m.b(getActivity());
            H9(activity, intent);
        } else {
            QLog.i("AddFriendCheckBasePart", 1, "startAddFriendVerifyFragment QFragmentContainerManager.currentSplitViewState() == SplitViewState.STATE_FLAT is false");
            if (C9().getStringExtra("param_return_addr") != null) {
                QPublicFragmentActivity.start(activity, intent, AddFriendVerifyFragmentForNT.class);
                activity.finish();
            } else {
                QPublicFragmentActivity.startForResult(getActivity(), intent, (Class<? extends QPublicBaseFragment>) AddFriendVerifyFragmentForNT.class, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getString(@StringRes int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        if (getActivity() != null) {
            return getActivity().getResources().getString(i3);
        }
        return "";
    }

    @Override // com.tencent.biz.richframework.part.Part
    @CallSuper
    public void onPartCreate(Activity activity, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
            return;
        }
        this.f187476f = (com.tencent.mobileqq.addfriend.ui.fornt.check.viewmodel.a) getViewModel(com.tencent.mobileqq.addfriend.ui.fornt.check.viewmodel.a.class);
        E9();
        F9(C9(), activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x9(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendCheckBasePart", 2, "dismissOrHideProgress hide: " + z16);
        }
        com.tencent.mobileqq.addfriend.ui.fornt.check.viewmodel.a aVar = this.f187476f;
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
            QLog.i("AddFriendCheckBasePart", 2, "mCheckProgressViewModel null: ");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (G9()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendCheckBasePart", 2, "showProgress");
        }
        com.tencent.mobileqq.addfriend.ui.fornt.check.viewmodel.a aVar = this.f187476f;
        if (aVar != null) {
            aVar.L1().postValue(1);
        } else if (QLog.isColorLevel()) {
            QLog.i("AddFriendCheckBasePart", 2, "mCheckProgressViewModel null");
        }
    }
}
