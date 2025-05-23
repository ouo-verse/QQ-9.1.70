package com.tencent.mobileqq.addfriend.ui.fornt.check.part;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.handler.NTAddFriendHandler;
import com.tencent.mobileqq.addfriend.ui.fornt.AddFriendForNtLauncher;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.qqnt.troopmemberlist.g;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.relation.common.utils.j;

/* loaded from: classes10.dex */
public class AddFriendCheckLogicPart extends com.tencent.mobileqq.addfriend.ui.fornt.check.part.a {
    static IPatchRedirector $redirector_;
    protected Handler K;
    protected boolean L;
    protected QQCustomDialog M;
    com.tencent.mobileqq.addfriend.observer.a N;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a implements g {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendCheckLogicPart.this);
            }
        }

        @Override // com.tencent.qqnt.troopmemberlist.g
        public void a(@Nullable TroopMemberInfo troopMemberInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberInfo);
            } else if (troopMemberInfo != null) {
                AddFriendCheckLogicPart.this.C9().putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, troopMemberInfo.friendnick);
            }
        }
    }

    /* loaded from: classes10.dex */
    class b extends com.tencent.mobileqq.addfriend.observer.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendCheckLogicPart.this);
            }
        }

        @Override // com.tencent.mobileqq.addfriend.observer.a
        protected void h(boolean z16, boolean z17, boolean z18, String str, Bundle bundle) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, bundle);
                return;
            }
            if (AddFriendCheckLogicPart.this.G9()) {
                return;
            }
            AddFriendCheckLogicPart addFriendCheckLogicPart = AddFriendCheckLogicPart.this;
            if (addFriendCheckLogicPart.C == 3024 && addFriendCheckLogicPart.D == 0) {
                BaseApplication context = BaseApplication.getContext();
                if (z16) {
                    i3 = R.string.heo;
                } else {
                    i3 = R.string.f173065h22;
                }
                QQToast.makeText(context, i3, 0).show(AddFriendCheckLogicPart.this.D9().getTitleBarHeight());
                AddFriendCheckLogicPart.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class c implements yc1.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendCheckLogicPart.this);
            }
        }

        @Override // yc1.a
        public void a(boolean z16, OpenID openID) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), openID);
                return;
            }
            if (!AddFriendCheckLogicPart.this.G9()) {
                AddFriendCheckLogicPart addFriendCheckLogicPart = AddFriendCheckLogicPart.this;
                if (!addFriendCheckLogicPart.L) {
                    Handler handler = addFriendCheckLogicPart.K;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                    if (z16 && openID != null && openID.openID != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("AddFriendCheckLogicPart", 2, "openIdObserver success");
                        }
                        if (!openID.openID.equals(AddFriendForNtLauncher.ph())) {
                            AddFriendCheckLogicPart.this.x9(true);
                            AddFriendCheckLogicPart.this.Q9();
                            return;
                        } else {
                            AddFriendCheckLogicPart.this.A9();
                            return;
                        }
                    }
                    AddFriendCheckLogicPart.this.A9();
                    if (QLog.isColorLevel()) {
                        QLog.d("AddFriendCheckLogicPart", 2, "openIdObserver fail");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendCheckLogicPart.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (i3 == 1) {
                Intent intent = new Intent();
                intent.putExtra("is_change_account", true);
                intent.putExtra("if_check_account_same", true);
                intent.putExtras(AddFriendCheckLogicPart.this.C9().getExtras());
                intent.putExtra("appid", AddFriendCheckLogicPart.this.f187479m);
                intent.putExtra("openid", AddFriendForNtLauncher.ph());
                intent.putExtra("key_action", "key_sdk_add_friend");
                intent.addFlags(268435456);
                intent.addFlags(67108864);
                AddFriendCheckLogicPart.this.M.cancel();
                RouteUtils.startActivity(AddFriendCheckLogicPart.this.getActivity(), intent, RouterConstants.UI_ROUTER_LOGIN);
                AddFriendCheckLogicPart.this.getActivity().finish();
                return;
            }
            if (i3 == 0) {
                Activity activity = AddFriendCheckLogicPart.this.getActivity();
                AddFriendCheckLogicPart.this.getActivity();
                activity.setResult(0);
                AddFriendCheckLogicPart.this.getActivity().finish();
            }
        }
    }

    public AddFriendCheckLogicPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.M = null;
            this.N = new b();
        }
    }

    private boolean J9() {
        if (G9() || !N9(this.f187477h, this.f187478i)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendCheckLogicPart", 2, QQFriendJsPlugin.API_ADD_FRIEND);
        }
        String stringExtra = C9().getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
        if (this.C == 3004 && stringExtra == null && !TextUtils.isEmpty(this.f187479m)) {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfo(this.f187479m, this.f187478i, false, getHostFragment(), "AddFriendCheckLogicPart-addFriend", new a());
        }
        K9();
        if (this.f187477h == 1) {
            if (QLog.isColorLevel()) {
                QLog.i("AddFriendCheckLogicPart", 2, "queryUinSafetyFlag");
            }
            z9();
            NTAddFriendHandler nTAddFriendHandler = this.f187474d;
            if (nTAddFriendHandler != null) {
                nTAddFriendHandler.O2(this.f187475e, j.b("AddFriendCheckLogicPart", this.f187478i));
            }
        } else {
            int i3 = this.C;
            if (i3 != 3024 && i3 != 3094) {
                if (!TextUtils.isEmpty(AddFriendForNtLauncher.ph())) {
                    L9();
                } else {
                    A9();
                }
            } else {
                A9();
                return true;
            }
        }
        return true;
    }

    private void K9() {
        AppInterface B9 = B9();
        if (B9 == null) {
            return;
        }
        B9.addObserver(this.N);
    }

    private void L9() {
        OpenID d16;
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendCheckLogicPart", 2, "checkAccountDiff");
        }
        if (!TextUtils.isEmpty(AddFriendForNtLauncher.ph())) {
            if (this.f187479m == null) {
                d16 = null;
            } else {
                d16 = com.tencent.mobileqq.addfriend.helper.b.b().d(this.f187479m);
            }
            if (d16 != null && !TextUtils.isEmpty(d16.openID)) {
                if (!AddFriendForNtLauncher.ph().equals(d16.openID)) {
                    Q9();
                    return;
                } else {
                    A9();
                    return;
                }
            }
            z9();
            Handler handler = new Handler();
            this.K = handler;
            handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.check.part.AddFriendCheckLogicPart.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendCheckLogicPart.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        if (AddFriendCheckLogicPart.this.G9()) {
                            return;
                        }
                        AddFriendCheckLogicPart addFriendCheckLogicPart = AddFriendCheckLogicPart.this;
                        addFriendCheckLogicPart.L = true;
                        addFriendCheckLogicPart.A9();
                    }
                }
            }, 3000L);
            if (this.f187479m != null) {
                com.tencent.mobileqq.addfriend.helper.b.b().c(this.f187479m, new c());
            }
        }
    }

    private void M9(Activity activity) {
        if (G9()) {
            return;
        }
        String str = this.f187478i;
        if (str != null && str.length() >= 5) {
            if (this.f187477h == 4) {
                QLog.e("AddFriendCheckLogicPart", 1, "AddFriendCheckFragmentForNT call error");
                return;
            } else {
                J9();
                return;
            }
        }
        int i3 = this.C;
        if (i3 != 3078 && i3 != 3079) {
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendCheckLogicPart", 2, "uin should not be null, activity finish");
            }
            getActivity().finish();
            return;
        }
        P9();
    }

    private boolean N9(int i3, String str) {
        if (G9()) {
            return false;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    getActivity().finish();
                    return false;
                }
                if (this.C == 3999) {
                    this.C = 3016;
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.CONTACTS, 2, "openId source id is default!");
                    }
                }
            } else if (this.C == 3999) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.CONTACTS, 2, "mobile source id is default!");
                }
                this.C = 3006;
            }
        } else {
            try {
                Long.parseLong(str);
                AppInterface B9 = B9();
                if (B9 != null && ((IFriendDataService) B9.getRuntimeService(IFriendDataService.class, "")).isFriend(str)) {
                    QQToast.makeText(getContext().getApplicationContext(), R.string.f170332ml, 0).show(D9().getTitleBarHeight());
                    getActivity().finish();
                    return false;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        if (NetworkUtil.isNetSupport(getActivity())) {
            return true;
        }
        QQToast.makeText(getContext().getApplicationContext(), R.string.f171139ci4, 0).show(D9().getTitleBarHeight());
        getActivity().finish();
        return false;
    }

    private boolean P9() {
        if (G9()) {
            return false;
        }
        if (!NetworkUtil.isNetSupport(getActivity())) {
            QQToast.makeText(BaseApplication.getContext(), R.string.f171139ci4, 0).show(O9(getActivity()));
            getActivity().finish();
            return false;
        }
        Intent intent = new Intent();
        intent.putExtras(C9());
        intent.putExtra("param_mode", 0);
        intent.putExtra("contact_bothway", true);
        I9(intent);
        return true;
    }

    public int O9(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity)).intValue();
        }
        if (activity != null) {
            if (activity instanceof QBaseActivity) {
                return ((QBaseActivity) activity).getTitleBarHeight();
            }
            return activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        }
        return 0;
    }

    protected void Q9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (G9()) {
            return;
        }
        QQCustomDialog qQCustomDialog = this.M;
        if (qQCustomDialog != null && !qQCustomDialog.isShowing() && !getActivity().isFinishing()) {
            this.M.show();
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 230);
        this.M = createCustomDialog;
        createCustomDialog.setMessage(R.string.d65);
        this.M.setTitle(R.string.b1v);
        d dVar = new d();
        this.M.setNegativeButton(R.string.cancel, dVar);
        this.M.setPositiveButton(R.string.d5b, dVar);
        if (!getActivity().isFinishing()) {
            this.M.show();
        }
    }

    @Override // com.tencent.mobileqq.addfriend.ui.fornt.check.part.a, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
        } else {
            super.onPartCreate(activity, bundle);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        AppInterface B9;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        if (this.N != null && (B9 = B9()) != null) {
            B9.removeObserver(this.N);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            M9(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, (Object) bundle);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        }
    }
}
