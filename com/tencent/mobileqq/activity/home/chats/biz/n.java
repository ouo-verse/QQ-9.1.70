package com.tencent.mobileqq.activity.home.chats.biz;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.managers.MsgRefreshTipMgr;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statustitle.api.IBaseStatusTitleBarApi;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.Constants;

/* compiled from: P */
/* loaded from: classes10.dex */
public class n extends d {
    static IPatchRedirector $redirector_;
    Dialog C;
    private final com.tencent.mobileqq.app.h D;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends com.tencent.mobileqq.app.h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) n.this);
            }
        }

        @Override // com.tencent.mobileqq.app.h
        protected void e(Boolean bool, Boolean bool2, String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, bool, bool2, str, str2, str3);
                return;
            }
            if (!bool.booleanValue() && bool2.booleanValue() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                ReportController.o(n.this.X9(), "dc00898", "", "", "0X800C53C", "0X800C53C", 0, 0, "", "", "", "");
                if (!n.this.ha()) {
                    new b(str, str2, str3).b();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final String f182965a;

        /* renamed from: b, reason: collision with root package name */
        private final String f182966b;

        /* renamed from: c, reason: collision with root package name */
        private final String f182967c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes10.dex */
        public class a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                Dialog dialog;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    return;
                }
                AppRuntime X9 = n.this.X9();
                if (!(X9 instanceof QQAppInterface)) {
                    return;
                }
                QQAppInterface qQAppInterface = (QQAppInterface) X9;
                if (i3 != 0) {
                    if (i3 != 1) {
                        dialog = null;
                    } else {
                        if (b.this.f182967c.startsWith("http")) {
                            try {
                                Intent intent = new Intent(n.this.getActivity(), (Class<?>) QQBrowserActivity.class);
                                intent.putExtra("url", b.this.f182967c);
                                n.this.getActivity().startActivity(intent);
                            } catch (Exception e16) {
                                if (QLog.isDevelopLevel()) {
                                    e16.printStackTrace();
                                }
                            }
                        } else if (b.this.f182967c.startsWith("mqqapi:")) {
                            bi.c(qQAppInterface, n.this.getActivity(), b.this.f182967c).b();
                        }
                        ReportController.o(X9, "dc00898", "", "", "0X800C53D", "0X800C53D", 0, 0, "", "", "", "");
                        dialog = null;
                    }
                } else {
                    if (SettingCloneUtil.readValue((Context) X9.getApplication(), X9.getAccount(), (String) null, AppConstants.PCACTIVE_CONFIG, false)) {
                        X9.startPCActivePolling(X9.getAccount(), "logout");
                    }
                    n nVar = n.this;
                    nVar.ma(nVar.getActivity(), qQAppInterface);
                    dialog = null;
                    ReportController.o(X9, "dc00898", "", "", "0X800C53E", "0X800C53E", 0, 0, "", "", "", "");
                }
                try {
                    dialogInterface.dismiss();
                    n.this.C = dialog;
                } catch (Exception e17) {
                    QLog.d("ShowRealNamePart", 1, e17, new Object[0]);
                }
            }
        }

        public b(String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, n.this, str, str2, str3);
                return;
            }
            this.f182965a = str;
            this.f182966b = str2;
            this.f182967c = str3;
        }

        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            a aVar = new a();
            n nVar = n.this;
            nVar.C = DialogUtil.createCustomDialog(nVar.getActivity(), 230, this.f182965a, this.f182966b, HardCodeUtil.qqStr(R.string.l4h), HardCodeUtil.qqStr(R.string.l4l), aVar, aVar);
            n.this.C.setCancelable(false);
            n.this.C.show();
        }
    }

    public n(com.tencent.mobileqq.activity.home.chats.callbcak.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.D = new a();
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.qqnt.chats.biz.main.part.a
    public void A9(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        super.A9(appRuntime);
        if (!(appRuntime instanceof QQAppInterface)) {
            return;
        }
        ((QQAppInterface) appRuntime).addObserver(this.D, true);
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.qqnt.chats.biz.main.part.a
    public void R9(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
        } else {
            if (!(appRuntime instanceof QQAppInterface)) {
                return;
            }
            ((QQAppInterface) appRuntime).removeObserver(this.D);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d
    public String ea() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "ShowRealNamePart";
    }

    public void ma(Activity activity, QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity, (Object) qQAppInterface);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("logout_intent", true);
        intent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
        ThemeUiPlugin.destroy(qQAppInterface);
        ChatBackgroundManager.d();
        qQAppInterface.logout(true);
        ImageCacheHelper.f98636a.e();
        QQSettingUtil.i(activity, qQAppInterface.getCurrentAccountUin(), QQSettingUtil.d(activity, qQAppInterface.getCurrentAccountUin()) + 1);
        RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTER_LOGIN);
        if (QQPlayerService.s0()) {
            Intent intent2 = new Intent();
            intent2.setAction("qqplayer_exit_action");
            activity.sendBroadcast(intent2);
        }
        MsgRefreshTipMgr.f().e();
        ((IBaseStatusTitleBarApi) QRoute.api(IBaseStatusTitleBarApi.class)).notifyNetWorkState(10, null);
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a, mqq.app.IAccountCallback
    public void onLogout(Constants.LogoutReason logoutReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) logoutReason);
            return;
        }
        super.onLogout(logoutReason);
        Dialog dialog = this.C;
        if (dialog != null && dialog.isShowing()) {
            try {
                this.C.dismiss();
                this.C = null;
            } catch (Exception e16) {
                QLog.i("ShowRealNamePart", 1, "mRealNameDialog.dismiss", e16);
            }
        }
    }
}
