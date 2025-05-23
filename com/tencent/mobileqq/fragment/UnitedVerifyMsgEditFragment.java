package com.tencent.mobileqq.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes12.dex */
public class UnitedVerifyMsgEditFragment extends IphoneTitleBarFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    BaseActivity C;
    int D;
    EditText E;
    TextView F;
    AddFriendVerifyActivity.r G;

    public UnitedVerifyMsgEditFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.D = 100;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void sh(String str, String str2) {
        this.E.setText(str);
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.E.setSelection(str.lastIndexOf(str2), str.length());
            } else if (!TextUtils.isEmpty(str)) {
                this.E.setSelection(str.length());
            }
        } catch (Throwable unused) {
        }
        this.C.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void th(String str, TroopMemberInfo troopMemberInfo) {
        String troopDisplayName;
        final String F;
        final String format;
        TroopInfo k3 = ((TroopManager) this.C.app.getManager(QQManagerFactory.TROOP_MANAGER)).k(str);
        if (k3 == null) {
            troopDisplayName = "";
        } else {
            troopDisplayName = k3.getTroopDisplayName();
        }
        if (troopMemberInfo == null) {
            QQAppInterface qQAppInterface = this.C.app;
            F = com.tencent.mobileqq.utils.ac.F(qQAppInterface, qQAppInterface.getAccount());
        } else if (!TextUtils.isEmpty(troopMemberInfo.troopnick)) {
            F = troopMemberInfo.troopnick;
        } else if (!TextUtils.isEmpty(troopMemberInfo.autoremark)) {
            F = troopMemberInfo.autoremark;
        } else if (!TextUtils.isEmpty(troopMemberInfo.friendnick)) {
            F = troopMemberInfo.friendnick;
        } else {
            QQAppInterface qQAppInterface2 = this.C.app;
            F = com.tencent.mobileqq.utils.ac.F(qQAppInterface2, qQAppInterface2.getAccount());
        }
        if (TextUtils.isEmpty(troopDisplayName)) {
            format = String.format(Locale.getDefault(), HardCodeUtil.qqStr(R.string.f172864uu4), F);
        } else {
            format = String.format(Locale.getDefault(), HardCodeUtil.qqStr(R.string.uu5), troopDisplayName, F);
        }
        this.C.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.fragment.ah
            @Override // java.lang.Runnable
            public final void run() {
                UnitedVerifyMsgEditFragment.this.sh(format, F);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        this.D = arguments.getInt("VERIFY_MSG_BYTES_LIMIT", 100);
        setTitle(getString(R.string.f170048dx));
        setLeftButton(R.string.cancel, (View.OnClickListener) null);
        setRightButton(R.string.a1p, this);
        this.E = (EditText) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f166785i82);
        this.F = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f166786i83);
        AddFriendVerifyActivity.r rVar = new AddFriendVerifyActivity.r(this.D, this.E);
        this.G = rVar;
        this.E.addTextChangedListener(rVar);
        final String string = arguments.getString("TROOP_UIN", "");
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfo(string, this.C.app.getAccount(), false, this, "IphoneTitleBarFragment", new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.mobileqq.fragment.ag
            @Override // com.tencent.qqnt.troopmemberlist.g
            public final void a(TroopMemberInfo troopMemberInfo) {
                UnitedVerifyMsgEditFragment.this.th(string, troopMemberInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.b4h;
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        this.C.setResult(0);
        boolean onBackEvent = super.onBackEvent();
        this.C.overridePendingTransition(R.anim.f154442w, R.anim.f154458a7);
        return onBackEvent;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else if (view == this.rightViewText) {
            String obj = this.E.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("VERIFY_MSG", obj);
            this.C.setResult(-1, intent);
            this.C.finish();
            this.C.overridePendingTransition(R.anim.f154442w, R.anim.f154458a7);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
            this.C = getBaseActivity();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.E.removeTextChangedListener(this.G);
            super.onDestroyView();
        }
    }
}
