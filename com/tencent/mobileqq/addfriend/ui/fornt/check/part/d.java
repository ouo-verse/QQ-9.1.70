package com.tencent.mobileqq.addfriend.ui.fornt.check.part;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d extends com.tencent.mobileqq.addfriend.ui.fornt.check.part.a {
    static IPatchRedirector $redirector_;
    private com.tencent.mobileqq.addfriend.part.b K;
    private QQCustomDialog L;
    com.tencent.mobileqq.addfriend.observer.a M;
    DialogInterface.OnClickListener N;
    DialogInterface.OnClickListener P;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends com.tencent.mobileqq.addfriend.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.mobileqq.addfriend.observer.a
        protected void g(boolean z16, long j3, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3));
                return;
            }
            if (d.this.G9()) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("AddFriendCheckUinSafeFlagPart", 2, String.format("onQueryUinSafetyFlag [uin:%s, mUin:%s, isSuc:%s, type:%s, status:%s]", Utils.U(String.valueOf(j3)), d.this.f187478i, Boolean.valueOf(z16), Integer.valueOf(d.this.f187477h), Integer.valueOf(i3)));
            }
            if (d.this.f187477h == 1 && String.valueOf(j3).equals(d.this.f187478i)) {
                if (z16 && i3 != 0) {
                    d.this.x9(false);
                    d.this.G = i3;
                    ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).checkUpdate(d.this.B9(), "SecWarningCfg");
                    try {
                        d dVar = d.this;
                        Activity activity = dVar.getActivity();
                        d dVar2 = d.this;
                        dVar.L = DialogUtil.createCustomDialog(activity, 230, "", "", dVar2.N, dVar2.P);
                        d.this.P9();
                        Window window = d.this.L.getWindow();
                        if (window != null) {
                            WindowManager.LayoutParams attributes = window.getAttributes();
                            if (QLog.isColorLevel() && attributes != null) {
                                QLog.i("AddFriendCheckUinSafeFlagPart", 2, String.format("onQueryUinSafetyFlag [%s, %s, %s]", Float.valueOf(attributes.dimAmount), Integer.valueOf(attributes.flags), Integer.valueOf(attributes.flags & 2)));
                            }
                            window.setDimAmount(0.5f);
                            window.addFlags(2);
                        }
                        d.this.L.show();
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "P_CliOper", "Safe_AntiFraud", MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), "AlertDialog", "Display", 0, d.this.G, "", "", "", "");
                    return;
                }
                d.this.A9();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (d.this.G9()) {
                return;
            }
            d dVar = d.this;
            if (dVar.G == 1) {
                dVar.getActivity().finish();
            } else {
                dVar.A9();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (!d.this.G9()) {
                d.this.O9(10001, "");
                ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "P_CliOper", "Safe_AntiFraud", MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), "AlertDialog", "UserClick", 0, d.this.G, "", "", "", "");
                d.this.getActivity().finish();
            }
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.K = (com.tencent.mobileqq.addfriend.part.b) getViewModel(com.tencent.mobileqq.addfriend.part.b.class);
        this.M = new a();
        this.N = new b();
        this.P = new c();
    }

    private void N9() {
        AppInterface B9 = B9();
        if (B9 == null) {
            return;
        }
        B9.addObserver(this.M);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O9(int i3, String str) {
        com.tencent.mobileqq.addfriend.part.b bVar = this.K;
        if (bVar != null) {
            bVar.L1(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P9() {
        String str;
        String str2;
        String str3;
        String str4;
        int i3;
        if (this.L != null && this.G != 0) {
            Bundle bundle = (Bundle) ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getValue("SecWarningCfg", "AlertTitle", 147, this.G);
            if (bundle != null) {
                str = bundle.getString("AlertTitle");
            } else {
                str = null;
            }
            Bundle bundle2 = (Bundle) ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getValue("SecWarningCfg", "AlertText", 147, this.G);
            if (bundle2 != null) {
                str2 = bundle2.getString("AlertText");
            } else {
                str2 = null;
            }
            Bundle bundle3 = (Bundle) ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getValue("SecWarningCfg", "AlertLeftBtnText", 147, this.G);
            if (bundle3 != null) {
                str3 = bundle3.getString("AlertLeftBtnText");
            } else {
                str3 = null;
            }
            Bundle bundle4 = (Bundle) ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getValue("SecWarningCfg", "AlertRightBtnText", 147, this.G);
            if (bundle4 != null) {
                str4 = bundle4.getString("AlertRightBtnText");
            } else {
                str4 = null;
            }
            if (str == null) {
                if (this.G == 1) {
                    i3 = R.string.ham;
                } else {
                    i3 = R.string.haq;
                }
                str = getString(i3);
            }
            if (str2 == null) {
                int i16 = this.G;
                if (i16 == 1) {
                    str2 = getString(R.string.han);
                } else if (i16 == 2) {
                    str2 = getString(R.string.hal);
                } else if (i16 == 3) {
                    str2 = getString(R.string.hap);
                } else if (i16 == 4) {
                    str2 = getString(R.string.hao);
                } else if (i16 == 5) {
                    str2 = getString(R.string.haj);
                } else {
                    str2 = getString(R.string.hak);
                }
            }
            if (str3 == null) {
                if (this.G == 1) {
                    this.N = null;
                } else {
                    str3 = getString(R.string.hai);
                }
            } else if (TextUtils.isEmpty(str3.trim())) {
                this.N = null;
            }
            if (str4 == null) {
                if (this.G == 1) {
                    str4 = getString(R.string.hah);
                } else {
                    str4 = getString(R.string.hag);
                }
            } else if (TextUtils.isEmpty(str4.trim())) {
                this.P = null;
            }
            this.L.setTitle(str);
            this.L.setMessage(str2);
            this.L.setNegativeButton(str3, this.N);
            this.L.setPositiveButton(str4, this.P);
            if (this.N == null || this.P == null) {
                this.L.findViewById(R.id.aet).setVisibility(8);
            }
        }
    }

    private void Q9() {
        this.K = (com.tencent.mobileqq.addfriend.part.b) getViewModel(com.tencent.mobileqq.addfriend.part.b.class);
    }

    @Override // com.tencent.mobileqq.addfriend.ui.fornt.check.part.a, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
            return;
        }
        super.onPartCreate(activity, bundle);
        Q9();
        N9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        AppInterface B9;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        if (this.M != null && (B9 = B9()) != null) {
            B9.removeObserver(this.M);
        }
    }
}
