package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountProtocService;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountProtocServiceImpl;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountServiceImpl;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.api.IContactUtils;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
@RoutePage(desc = "\u5c0f\u53f7\u52a9\u624b\u7ed1\u5b9aActivity", path = RouterConstants.UI_ROUTER_SUBACCOUNT_BIND)
/* loaded from: classes9.dex */
public class SubAccountBindActivity extends SubAccountBaseActivity {
    static IPatchRedirector $redirector_ = null;
    public static final int ERROR_ACCOUNT_BLACK = 1233;
    public static final int ERROR_ACCOUNT_FREEDOM = 1232;
    public static final int ERROR_ACCOUNT_LH_EXPIRED = 1241;
    public static final int ERROR_ACCOUNT_LOCK = 1242;
    public static final int ERROR_ACCOUNT_LOGIN_FAILED = 1240;
    public static final int ERROR_ACCOUNT_NOT_EXIST = 1218;
    public static final int SUBACCOUNTBINDACTIVITY_CLOSE_DIALOG = 1990;
    public static final int SUBACCOUNTBINDACTIVITY_FINISH = 1981;
    private static final String TAG = "Q.subaccount.SubAccountBindActivity";
    private List<SimpleAccount> accountList;
    com.tencent.mobileqq.loginregister.a accountListChangeObserver;
    private LinearLayout accountListLinearLayout;
    com.tencent.mobileqq.avatar.observer.a avatarObserver;
    BusinessObserver fob;
    private boolean isGetBindFromThis;
    MqqHandler mHandler;
    View.OnClickListener onAddAccountClick;
    View.OnClickListener onSelectAccountClick;
    com.tencent.mobileqq.app.dc sabo;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.SubAccountBindActivity$3, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass3 implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        AnonymousClass3() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubAccountBindActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                View findViewById = view.findViewById(R.id.check);
                if (findViewById == null || findViewById.getVisibility() != 0) {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    SimpleAccount simpleAccount = (SimpleAccount) SubAccountBindActivity.this.accountList.get(((Integer) view.getTag()).intValue());
                    int intExtra = SubAccountBindActivity.this.getIntent().getIntExtra("fromWhereExactly", 0);
                    QLog.d(SubAccountBindActivity.TAG, 2, "selectAccountClick fromWhereExactly = " + intExtra);
                    ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800C48A", "0X800C48A", 0, 0, simpleAccount.getUin(), "", "", "");
                    SubAccountServiceImpl subAccountServiceImpl = (SubAccountServiceImpl) peekAppRuntime.getRuntimeService(ISubAccountService.class, "");
                    if (subAccountServiceImpl.isSubAccountUin(simpleAccount.getUin())) {
                        SubAccountBindActivity subAccountBindActivity = SubAccountBindActivity.this;
                        subAccountBindActivity.showQQToastSuccess(subAccountBindActivity.getString(R.string.hry));
                        ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800BDE9", "0X800BDE9", intExtra, 0, "", "", "", "");
                        com.tencent.mobileqq.subaccount.f.d(peekAppRuntime);
                        SubAccountBindActivity.this.setTitle("");
                        Intent intent = new Intent();
                        intent.putExtra(((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getTabIndex(), com.tencent.mobileqq.activity.home.impl.a.f183038a);
                        intent.setFlags(67108864);
                        RouteUtils.startActivity(SubAccountBindActivity.this, intent, RouterConstants.UI_ROUTER_SPLASH);
                        SubAccountBindActivity.this.startActivity(intent);
                        SubAccountBindActivity.this.finish();
                    } else if (subAccountServiceImpl.getBindedNumber() >= 2) {
                        com.tencent.mobileqq.subaccount.h.O(peekAppRuntime, SubAccountBindActivity.this);
                    } else if (!simpleAccount.isLogined()) {
                        if (QLog.isColorLevel()) {
                            QLog.d(SubAccountBindActivity.TAG, 2, "onSelectAccountClick.onClick:add account");
                        }
                        SubAccountBindActivity.this.jumpSubLoginPage(simpleAccount.getUin());
                    } else if (SubAccountBindActivity.this.isNetConnToast()) {
                        String a26 = subAccountServiceImpl.getA2(simpleAccount.getUin());
                        SubAccountBindActivity.this.showJuhua(R.string.f173175hs0);
                        if (TextUtils.isEmpty(a26)) {
                            ((ILoginServletService) SubAccountBindActivity.this.getAppRuntime().getRuntimeService(ILoginServletService.class, "all")).getSubAccountKey(peekAppRuntime.getAccount(), simpleAccount.getUin(), new com.tencent.mobileqq.loginregister.servlet.g(peekAppRuntime, simpleAccount) { // from class: com.tencent.mobileqq.activity.SubAccountBindActivity.3.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ AppRuntime f177151d;

                                /* renamed from: e, reason: collision with root package name */
                                final /* synthetic */ SimpleAccount f177152e;

                                {
                                    this.f177151d = peekAppRuntime;
                                    this.f177152e = simpleAccount;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, this, AnonymousClass3.this, peekAppRuntime, simpleAccount);
                                    }
                                }

                                @Override // com.tencent.mobileqq.loginregister.servlet.g
                                protected void a(String str, String str2, String str3) {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, this, str, str2, str3);
                                        return;
                                    }
                                    if (TextUtils.isEmpty(str3)) {
                                        HashMap<String, String> hashMap = new HashMap<>();
                                        hashMap.put("param_FailCode", "12005");
                                        hashMap.put(ISubAccountControlService.FAIL_STEP, "getKeyEmpty");
                                        hashMap.put(ISubAccountControlService.FAIL_LOCATION, "SubBind");
                                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f177151d.getCurrentAccountUin(), "actSBDLoginGetkey", false, 0L, 0L, hashMap, "");
                                        if (QLog.isColorLevel()) {
                                            QLog.d(SubAccountBindActivity.TAG, 2, "onGetKeyBack: key is empty");
                                        }
                                        SubAccountBindActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.SubAccountBindActivity.3.1.1
                                            static IPatchRedirector $redirector_;

                                            {
                                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                                }
                                            }

                                            @Override // java.lang.Runnable
                                            public void run() {
                                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                                    return;
                                                }
                                                SubAccountBindActivity.this.hideJuhua();
                                                SubAccountBindActivity subAccountBindActivity2 = SubAccountBindActivity.this;
                                                subAccountBindActivity2.showQQToast(subAccountBindActivity2.getString(R.string.hti));
                                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                                SubAccountBindActivity.this.jumpSubLoginPage(anonymousClass1.f177152e.getUin());
                                            }
                                        });
                                        return;
                                    }
                                    HashMap<String, String> hashMap2 = new HashMap<>();
                                    hashMap2.put("param_FailCode", "12006");
                                    hashMap2.put(ISubAccountControlService.FAIL_STEP, "getKeyNotEmpty");
                                    hashMap2.put(ISubAccountControlService.FAIL_LOCATION, "SubBind");
                                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f177151d.getCurrentAccountUin(), "actSBDLoginGetkey", true, 0L, 0L, hashMap2, "");
                                    SubAccountProtocServiceImpl subAccountProtocServiceImpl = (SubAccountProtocServiceImpl) this.f177151d.getRuntimeService(ISubAccountProtocService.class, "");
                                    if (subAccountProtocServiceImpl != null) {
                                        subAccountProtocServiceImpl.bindAccount(this.f177152e.getUin(), str3, SubAccountBindActivity.this.fromWhere);
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.d(SubAccountBindActivity.TAG, 2, "onGetKeyBack:getA2 subAccount = " + str2 + ".....subA2 = " + str3);
                                    }
                                }
                            });
                            ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800BDE9", "0X800BDE9", intExtra, 0, "", "", "", "");
                        } else {
                            SubAccountProtocServiceImpl subAccountProtocServiceImpl = (SubAccountProtocServiceImpl) peekAppRuntime.getRuntimeService(ISubAccountProtocService.class, "");
                            if (subAccountProtocServiceImpl != null) {
                                subAccountProtocServiceImpl.bindAccount(simpleAccount.getUin(), a26, SubAccountBindActivity.this.fromWhere);
                            }
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends MqqHandler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubAccountBindActivity.this);
            }
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 1981) {
                if (i3 == 1990) {
                    SubAccountBindActivity.this.dimissDialog();
                    return;
                }
                return;
            }
            SubAccountBindActivity.this.finish();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b extends com.tencent.mobileqq.app.dc {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.subaccount.logic.a f177161d;

            a(com.tencent.mobileqq.subaccount.logic.a aVar) {
                this.f177161d = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) aVar);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else if (i3 == 1 && !TextUtils.isEmpty(this.f177161d.f291124d)) {
                    SubAccountBindActivity.this.jumpSubLoginPage(this.f177161d.f291124d);
                }
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubAccountBindActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.dc
        protected void a(boolean z16, com.tencent.mobileqq.subaccount.logic.a aVar) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), aVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "SubAccountBindActivity.onBindSubAccount() isSucc=" + z16);
                if (aVar != null) {
                    QLog.d("SUB_ACCOUNT", 2, "SubAccountBindActivity.onBindSubAccount() mainAccount=" + aVar.f291123c + " subAccount=" + aVar.f291124d + " errType=" + aVar.f291121a + " errMsg=" + aVar.f291122b);
                }
            }
            SubAccountBindActivity.this.hideJuhua();
            if (Foreground.getTopActivity() != SubAccountBindActivity.this) {
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (z16) {
                SubAccountBindActivity subAccountBindActivity = SubAccountBindActivity.this;
                subAccountBindActivity.showQQToastSuccess(subAccountBindActivity.getString(R.string.hry));
                com.tencent.mobileqq.subaccount.f.d(peekAppRuntime);
                SubAccountBindActivity.this.getActivity().setTitle("");
                SubAccountBindActivity.this.finish();
            } else {
                if (aVar == null) {
                    return;
                }
                int i3 = aVar.f291121a;
                if (i3 != 1011) {
                    switch (i3) {
                        case 1002:
                            com.tencent.mobileqq.subaccount.h.O(peekAppRuntime, SubAccountBindActivity.this);
                            break;
                        case 1003:
                            SubAccountBindActivity subAccountBindActivity2 = SubAccountBindActivity.this;
                            subAccountBindActivity2.showQQToast(subAccountBindActivity2.getString(R.string.hro));
                            break;
                        case 1004:
                            int i16 = aVar.f291129i;
                            if (i16 != 1200) {
                                if (i16 != 1218) {
                                    if (i16 != 1214 && i16 != 1215) {
                                        if (i16 != 1232) {
                                            if (i16 != 1233) {
                                                switch (i16) {
                                                    case SubAccountBindActivity.ERROR_ACCOUNT_LOGIN_FAILED /* 1240 */:
                                                        String str2 = aVar.f291122b;
                                                        if (TextUtils.isEmpty(str2)) {
                                                            str2 = peekAppRuntime.getApp().getResources().getString(R.string.hru);
                                                        }
                                                        SubAccountBindActivity.this.showQQToast(str2);
                                                        break;
                                                    case SubAccountBindActivity.ERROR_ACCOUNT_LH_EXPIRED /* 1241 */:
                                                        String str3 = aVar.f291122b;
                                                        if (TextUtils.isEmpty(str3)) {
                                                            str3 = peekAppRuntime.getApp().getResources().getString(R.string.hrg);
                                                        }
                                                        SubAccountBindActivity.this.showQQToast(str3);
                                                        break;
                                                    case SubAccountBindActivity.ERROR_ACCOUNT_LOCK /* 1242 */:
                                                        String str4 = aVar.f291122b;
                                                        if (TextUtils.isEmpty(str4)) {
                                                            str4 = peekAppRuntime.getApp().getResources().getString(R.string.hrw);
                                                        }
                                                        SubAccountBindActivity.this.showQQToast(str4);
                                                        break;
                                                    default:
                                                        String str5 = aVar.f291122b;
                                                        if (TextUtils.isEmpty(str5)) {
                                                            if (QLog.isColorLevel()) {
                                                                QLog.d(SubAccountBindActivity.TAG, 2, "onBindSubAccount:bind error happen but msg is null");
                                                            }
                                                            str5 = SubAccountBindActivity.this.getString(R.string.hrn);
                                                        }
                                                        SubAccountBindActivity.this.showQQToast(str5);
                                                        break;
                                                }
                                            } else {
                                                String str6 = aVar.f291122b;
                                                if (TextUtils.isEmpty(str6)) {
                                                    str6 = peekAppRuntime.getApp().getResources().getString(R.string.hrh);
                                                }
                                                SubAccountBindActivity.this.showQQToast(str6);
                                                break;
                                            }
                                        } else {
                                            String str7 = aVar.f291122b;
                                            if (TextUtils.isEmpty(str7)) {
                                                str7 = peekAppRuntime.getApp().getResources().getString(R.string.hrr);
                                            }
                                            SubAccountBindActivity.this.showQQToast(str7);
                                            break;
                                        }
                                    }
                                } else {
                                    String str8 = aVar.f291122b;
                                    if (TextUtils.isEmpty(str8)) {
                                        str8 = peekAppRuntime.getApp().getResources().getString(R.string.f173081h55);
                                    }
                                    SubAccountBindActivity.this.showQQToast(str8);
                                    break;
                                }
                            }
                            SubAccountBindActivity.this.showQQCustomDialog(SubAccountBindActivity.this.getString(R.string.f173180ht0), SubAccountBindActivity.this.getString(R.string.hrq), new a(aVar));
                            break;
                        default:
                            String string = SubAccountBindActivity.this.getString(R.string.hrn);
                            if (!TextUtils.isEmpty(aVar.f291122b)) {
                                string = aVar.f291122b;
                            }
                            SubAccountBindActivity.this.showQQToast(string);
                            break;
                    }
                } else {
                    String string2 = SubAccountBindActivity.this.getString(R.string.hrn);
                    if (!TextUtils.isEmpty(aVar.f291122b)) {
                        string2 = aVar.f291122b;
                    }
                    SubAccountBindActivity.this.showQQToast(string2);
                    SubAccountBindActivity.this.jumpSubLoginPage(aVar.f291124d);
                }
            }
            if (QLog.isColorLevel() && aVar != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onBindSubAccount:");
                if (z16) {
                    str = "..success";
                } else {
                    str = "...failed..";
                }
                sb5.append(str);
                sb5.append(" ...errorMsg = ");
                sb5.append(aVar.f291122b);
                sb5.append("...errorType = ");
                sb5.append(aVar.f291121a);
                QLog.d("SUB_ACCOUNT", 2, sb5.toString());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubAccountBindActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(SubAccountBindActivity.TAG, 2, "onAddAccountClick.onClick:add account");
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                ReportController.y(peekAppRuntime, "0X800C48B");
                SubAccountServiceImpl subAccountServiceImpl = (SubAccountServiceImpl) peekAppRuntime.getRuntimeService(ISubAccountService.class, "");
                if (subAccountServiceImpl != null) {
                    i3 = subAccountServiceImpl.getBindedNumber();
                } else {
                    i3 = 0;
                }
                if (Utils.F()) {
                    ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).showDeleteAccountDialog(SubAccountBindActivity.this);
                } else if (i3 < 2) {
                    SubAccountBindActivity.this.jumpSubLoginPage("");
                } else {
                    com.tencent.mobileqq.subaccount.h.O(peekAppRuntime, SubAccountBindActivity.this);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d implements ISubAccountApi.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubAccountBindActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi.b
        public void a(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
                return;
            }
            if (!z16 || str == null || SubAccountBindActivity.this.accountListLinearLayout == null) {
                return;
            }
            int childCount = SubAccountBindActivity.this.accountListLinearLayout.getChildCount();
            for (int i3 = 0; i3 < SubAccountBindActivity.this.accountList.size(); i3++) {
                if (childCount > i3 && SubAccountBindActivity.this.accountList.get(i3) != null && str.equals(((SimpleAccount) SubAccountBindActivity.this.accountList.get(i3)).getUin())) {
                    TextView textView = (TextView) SubAccountBindActivity.this.accountListLinearLayout.getChildAt(i3).findViewById(R.id.f5e);
                    TextView textView2 = (TextView) SubAccountBindActivity.this.accountListLinearLayout.getChildAt(i3).findViewById(R.id.account);
                    textView.setText(((IContactUtils) QRoute.api(IContactUtils.class)).getAccountNickName((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), str));
                    textView2.setText(str);
                    return;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class e extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubAccountBindActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
                return;
            }
            if (z16 && str != null) {
                if (SubAccountBindActivity.this.accountListLinearLayout != null) {
                    i3 = SubAccountBindActivity.this.accountListLinearLayout.getChildCount();
                } else {
                    i3 = 0;
                }
                for (int i16 = 0; i16 < SubAccountBindActivity.this.accountList.size(); i16++) {
                    if (i3 > i16 && SubAccountBindActivity.this.accountList.get(i16) != null && str.equals(((SimpleAccount) SubAccountBindActivity.this.accountList.get(i16)).getUin())) {
                        SubAccountBindActivity.this.updateFace(str, i16);
                        return;
                    }
                }
            }
        }
    }

    public SubAccountBindActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isGetBindFromThis = false;
        this.mHandler = new a();
        this.accountListChangeObserver = new com.tencent.mobileqq.loginregister.a() { // from class: com.tencent.mobileqq.activity.fi
            @Override // com.tencent.mobileqq.loginregister.a
            public final void accountChange() {
                SubAccountBindActivity.this.lambda$new$0();
            }
        };
        this.sabo = new b();
        this.onSelectAccountClick = new AnonymousClass3();
        this.onAddAccountClick = new c();
        this.fob = ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).getFriendListObserver(new d());
        this.avatarObserver = new e();
    }

    private SimpleAccount findSimpleAccountByUin(String str) {
        for (SimpleAccount simpleAccount : this.accountList) {
            if (str.equals(simpleAccount.getUin())) {
                return simpleAccount;
            }
        }
        return null;
    }

    private void initAccountList() {
        List<SimpleAccount> list = this.accountList;
        if (list == null) {
            this.accountList = new ArrayList();
        } else {
            list.clear();
        }
        List<SimpleAccount> allAccounts = getAppRuntime().getApplication().getAllAccounts();
        if (allAccounts != null) {
            this.accountList.addAll(allAccounts);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            this.accountList.remove(findSimpleAccountByUin(peekAppRuntime.getAccount()));
            ArrayList<String> allSubUin = ((SubAccountServiceImpl) peekAppRuntime.getRuntimeService(ISubAccountService.class, "")).getAllSubUin();
            if (allSubUin != null) {
                int size = allSubUin.size();
                for (int i3 = 0; i3 < size; i3++) {
                    this.accountList.remove(findSimpleAccountByUin(allSubUin.get(i3)));
                }
            }
        }
        List<SimpleAccount> list2 = this.accountList;
        if (list2 != null) {
            list2.add(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpSubLoginPage(String str) {
        Intent intent = new Intent();
        intent.putExtra("is_sub_account_login", true);
        intent.putExtra("loginFragmentType", 5);
        intent.putExtra("key_login_page_entrance", 2);
        intent.putExtra("key_login_page_title", getString(R.string.hrx));
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("uin", str);
        }
        intent.putExtra("sub_login_bind", true);
        intent.putExtra("sub_login_from_where", this.fromWhere);
        RouteUtils.startActivity(this, intent, RouterConstants.UI_ROUTER_LOGIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        refreshAccountList(false);
    }

    private void updateAccountListView() {
        LinearLayout linearLayout = this.accountListLinearLayout;
        if (linearLayout != null && linearLayout.getChildCount() > 0) {
            int childCount = this.accountListLinearLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.accountListLinearLayout.getChildAt(i3);
                Object tag = childAt.getTag();
                if (tag == null) {
                    VideoReport.setElementId(childAt, "em_bas_add_other_accounts");
                    VideoReport.setElementEndExposePolicy(childAt, EndExposurePolicy.REPORT_ALL);
                    return;
                }
                SimpleAccount simpleAccount = this.accountList.get(((Integer) tag).intValue());
                if (simpleAccount == null) {
                    return;
                }
                QQProAvatarView qQProAvatarView = (QQProAvatarView) childAt.findViewById(R.id.icon);
                TextView textView = (TextView) childAt.findViewById(R.id.f5e);
                TextView textView2 = (TextView) childAt.findViewById(R.id.account);
                AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                String accountNickName = ((IContactUtils) QRoute.api(IContactUtils.class)).getAccountNickName(appInterface, simpleAccount.getUin());
                if (simpleAccount.isLogined() && (TextUtils.isEmpty(accountNickName) || accountNickName.equals(simpleAccount.getUin()))) {
                    accountNickName = ((IContactUtils) QRoute.api(IContactUtils.class)).getFriendNickName(appInterface, simpleAccount.getUin());
                }
                if (TextUtils.isEmpty(accountNickName)) {
                    accountNickName = simpleAccount.getUin();
                }
                textView.setText(accountNickName);
                textView2.setText(simpleAccount.getUin());
                qQProAvatarView.w(1, simpleAccount.getUin());
                VideoReport.setElementId(childAt, "em_bas_logined_account");
                VideoReport.setElementEndExposePolicy(childAt, EndExposurePolicy.REPORT_ALL);
                VideoReport.setElementParam(childAt, "em_bas_selected_uin", simpleAccount.getUin());
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.SubAccountBaseActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.SubAccountBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        super.setContentView(R.layout.f169099c00);
        setTitle(R.string.hs5);
        setContentBackgroundResource(R.drawable.bg_texture);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ReportController.y(peekAppRuntime, "0X800C489");
        this.accountListLinearLayout = (LinearLayout) findViewById(R.id.accountLinearlayout);
        if (!refreshAccountList(true)) {
            return false;
        }
        ((AppInterface) peekAppRuntime).setHandler(getClass(), this.mHandler);
        addObserver(this.fob);
        addObserver(this.sabo);
        VideoReport.addToDetectionWhitelist(this);
        VideoReport.setPageId(this.titleRoot, "pg_bas_add_QQ_account");
        HashMap hashMap = new HashMap();
        hashMap.put("muin", peekAppRuntime.getCurrentAccountUin());
        hashMap.put("add_page_source", getIntent().getStringExtra("fromWhereForDt"));
        VideoReport.setPageParams(this.titleRoot, new PageParams(hashMap));
        ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).registerAccountListChangeObserver(this.accountListChangeObserver);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.SubAccountBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        removeObserver(this.sabo);
        removeObserver(this.fob);
        ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).removeAccountListChangeObserver(this.accountListChangeObserver);
        ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).removeHandler(getClass());
        super.doOnDestroy();
    }

    @Override // com.tencent.mobileqq.activity.SubAccountBaseActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    protected boolean refreshAccountList(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, z16)).booleanValue();
        }
        initAccountList();
        if (z16 && this.accountList.size() == 1 && this.accountList.get(0) == null) {
            jumpSubLoginPage("");
            finish();
            return false;
        }
        this.accountListLinearLayout.removeAllViews();
        for (int i3 = 0; i3 < this.accountList.size(); i3++) {
            if (this.accountList.get(i3) == null) {
                View inflate = getLayoutInflater().inflate(R.layout.f167521l, (ViewGroup) this.accountListLinearLayout, false);
                ((TextView) inflate.findViewById(R.id.new_account)).setText(R.string.hrv);
                inflate.setOnClickListener(this.onAddAccountClick);
                inflate.setTag(null);
                this.accountListLinearLayout.addView(inflate);
                if (inflate instanceof FormItemRelativeLayout) {
                    ((FormItemRelativeLayout) inflate).setBGType(3);
                }
            } else {
                View inflate2 = getLayoutInflater().inflate(R.layout.f167522m, (ViewGroup) this.accountListLinearLayout, false);
                if (inflate2 instanceof FormItemRelativeLayout) {
                    FormItemRelativeLayout formItemRelativeLayout = (FormItemRelativeLayout) inflate2;
                    formItemRelativeLayout.setNeedFocusBg(true);
                    if (i3 == 0) {
                        formItemRelativeLayout.setBGType(1);
                    } else {
                        formItemRelativeLayout.setBGType(2);
                    }
                }
                inflate2.setTag(Integer.valueOf(i3));
                inflate2.setOnClickListener(this.onSelectAccountClick);
                this.accountListLinearLayout.addView(inflate2);
            }
        }
        updateAccountListView();
        return true;
    }

    void updateFace(String str, int i3) {
        ThreadManager.getFileThreadHandler().post(new Runnable(str, i3) { // from class: com.tencent.mobileqq.activity.SubAccountBindActivity.7
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f177155d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f177156e;

            {
                this.f177155d = str;
                this.f177156e = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, SubAccountBindActivity.this, str, Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    SubAccountBindActivity.this.runOnUiThread(new Runnable(FaceDrawable.getFaceDrawable((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), 1, this.f177155d)) { // from class: com.tencent.mobileqq.activity.SubAccountBindActivity.7.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ Drawable f177157d;

                        {
                            this.f177157d = r5;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this, (Object) r5);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                ((ImageView) SubAccountBindActivity.this.accountListLinearLayout.getChildAt(AnonymousClass7.this.f177156e).findViewById(R.id.icon)).setImageDrawable(this.f177157d);
                            }
                        }
                    });
                }
            }
        });
    }
}
