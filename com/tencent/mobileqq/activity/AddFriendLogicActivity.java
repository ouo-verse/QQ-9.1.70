package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.KplHelper;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
@Deprecated
/* loaded from: classes9.dex */
public class AddFriendLogicActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: u0, reason: collision with root package name */
    public static String f174689u0;

    /* renamed from: v0, reason: collision with root package name */
    public static boolean f174690v0;

    /* renamed from: a0, reason: collision with root package name */
    protected Handler f174691a0;

    /* renamed from: b0, reason: collision with root package name */
    protected boolean f174692b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f174693c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f174694d0;

    /* renamed from: e0, reason: collision with root package name */
    private String f174695e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f174696f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f174697g0;

    /* renamed from: h0, reason: collision with root package name */
    private String f174698h0;

    /* renamed from: i0, reason: collision with root package name */
    private String f174699i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f174700j0;

    /* renamed from: k0, reason: collision with root package name */
    private QQProgressDialog f174701k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f174702l0;

    /* renamed from: m0, reason: collision with root package name */
    com.tencent.mobileqq.friend.observer.a f174703m0;

    /* renamed from: n0, reason: collision with root package name */
    private QQCustomDialog f174704n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f174705o0;

    /* renamed from: p0, reason: collision with root package name */
    DialogInterface.OnClickListener f174706p0;

    /* renamed from: q0, reason: collision with root package name */
    DialogInterface.OnClickListener f174707q0;

    /* renamed from: r0, reason: collision with root package name */
    DialogInterface.OnDismissListener f174708r0;

    /* renamed from: s0, reason: collision with root package name */
    protected QQCustomDialog f174709s0;

    /* renamed from: t0, reason: collision with root package name */
    protected com.tencent.biz.common.util.i f174710t0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class AddFriendLogicActivityDestroyEvent extends SimpleBaseEvent {
        static IPatchRedirector $redirector_;

        public AddFriendLogicActivityDestroyEvent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements QQProgressDialog.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendLogicActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.QQProgressDialog.b
        public void onBackPressed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                AddFriendLogicActivity.this.onBackPressed();
                AddFriendLogicActivity.this.f174701k0.O(null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendLogicActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (AddFriendLogicActivity.this.f174705o0 != 1) {
                AddFriendLogicActivity.this.e3();
            } else {
                AddFriendLogicActivity.this.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendLogicActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            QQAppInterface qQAppInterface = AddFriendLogicActivity.this.app;
            ReportController.o(qQAppInterface, "P_CliOper", "Safe_AntiFraud", qQAppInterface.getCurrentAccountUin(), "AlertDialog", "UserClick", 0, AddFriendLogicActivity.this.f174705o0, "", "", "", "");
            AddFriendLogicActivity.this.finish();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendLogicActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                AddFriendLogicActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendLogicActivity.this);
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
                intent.putExtras(AddFriendLogicActivity.this.getIntent().getExtras());
                intent.putExtra("appid", AddFriendLogicActivity.this.f174699i0);
                intent.putExtra("openid", AddFriendLogicActivity.f174689u0);
                intent.putExtra("key_action", AddFriendLogicActivity.class.getSimpleName());
                intent.addFlags(268435456);
                intent.addFlags(67108864);
                AddFriendLogicActivity.this.f174709s0.cancel();
                RouteUtils.startActivity(AddFriendLogicActivity.this, intent, RouterConstants.UI_ROUTER_LOGIN);
                AddFriendLogicActivity.this.finish();
                return;
            }
            if (i3 == 0) {
                AddFriendLogicActivity.this.setResult(0);
                AddFriendLogicActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendLogicActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                AddFriendLogicActivity.this.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class g extends com.tencent.biz.common.util.i {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendLogicActivity.this);
            }
        }

        @Override // com.tencent.biz.common.util.i
        protected void a(boolean z16, OpenID openID) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), openID);
                return;
            }
            if (!AddFriendLogicActivity.this.isFinishing()) {
                AddFriendLogicActivity addFriendLogicActivity = AddFriendLogicActivity.this;
                if (!addFriendLogicActivity.f174692b0) {
                    Handler handler = addFriendLogicActivity.f174691a0;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                    if (!z16 || openID == null || openID.openID == null) {
                        AddFriendLogicActivity.this.e3();
                        if (QLog.isColorLevel()) {
                            QLog.d("AddFriendLogicActivity", 2, "openIdObserver fail");
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("AddFriendLogicActivity", 2, "openIdObserver success");
                    }
                    if (!openID.openID.equals(AddFriendLogicActivity.f174689u0)) {
                        AddFriendLogicActivity.this.c3(true);
                        AddFriendLogicActivity.this.j3();
                    } else {
                        AddFriendLogicActivity.this.e3();
                    }
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66560);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f174689u0 = "";
            f174690v0 = false;
        }
    }

    public AddFriendLogicActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f174696f0 = -1;
        this.f174702l0 = -1;
        this.f174703m0 = new com.tencent.mobileqq.friend.observer.a() { // from class: com.tencent.mobileqq.activity.AddFriendLogicActivity.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AddFriendLogicActivity.this);
                }
            }

            @Override // com.tencent.mobileqq.friend.observer.a
            protected void onQueryUinSafetyFlag(boolean z16, long j3, int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3));
                    return;
                }
                if (AddFriendLogicActivity.this.isFinishing()) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("addFriendTag", 2, String.format("onQueryUinSafetyFlag [uin:%s, isSuc:%s, type:%s, status:%s]", Utils.U(String.valueOf(j3)), Boolean.valueOf(z16), Integer.valueOf(AddFriendLogicActivity.this.f174697g0), Integer.valueOf(i3)));
                }
                if (AddFriendLogicActivity.this.f174697g0 == 1 && String.valueOf(j3).equals(AddFriendLogicActivity.this.f174698h0)) {
                    if (!z16 || i3 == 0) {
                        AddFriendLogicActivity.this.e3();
                        return;
                    }
                    AddFriendLogicActivity.this.c3(false);
                    AddFriendLogicActivity.this.f174705o0 = i3;
                    AntiFraudConfigFileUtil.n().f(AddFriendLogicActivity.this.app, "SecWarningCfg");
                    try {
                        AddFriendLogicActivity addFriendLogicActivity = AddFriendLogicActivity.this;
                        addFriendLogicActivity.f174704n0 = DialogUtil.createCustomDialog(addFriendLogicActivity, 230, "", "", addFriendLogicActivity.f174706p0, addFriendLogicActivity.f174707q0);
                        AddFriendLogicActivity.this.f3();
                        Window window = AddFriendLogicActivity.this.f174704n0.getWindow();
                        if (window != null) {
                            WindowManager.LayoutParams attributes = window.getAttributes();
                            if (QLog.isColorLevel() && attributes != null) {
                                QLog.i("addFriendTag", 2, String.format("onQueryUinSafetyFlag [%s, %s, %s]", Float.valueOf(attributes.dimAmount), Integer.valueOf(attributes.flags), Integer.valueOf(attributes.flags & 2)));
                            }
                            window.setDimAmount(0.5f);
                            window.addFlags(2);
                        }
                        AddFriendLogicActivity.this.f174704n0.setOnDismissListener(AddFriendLogicActivity.this.f174708r0);
                        AddFriendLogicActivity.this.f174704n0.show();
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    QQAppInterface qQAppInterface = AddFriendLogicActivity.this.app;
                    ReportController.o(qQAppInterface, "P_CliOper", "Safe_AntiFraud", qQAppInterface.getCurrentAccountUin(), "AlertDialog", "Display", 0, AddFriendLogicActivity.this.f174705o0, "", "", "", "");
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.friend.observer.a
            public void onUpdateAddFriend(boolean z16, boolean z17, boolean z18, String str, Bundle bundle) {
                int i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, bundle);
                    return;
                }
                if (AddFriendLogicActivity.this.f174700j0 == 3024 && AddFriendLogicActivity.this.f174702l0 == 0) {
                    MobileQQ application = AddFriendLogicActivity.this.app.getApplication();
                    if (z16) {
                        i3 = R.string.heo;
                    } else {
                        i3 = R.string.f173065h22;
                    }
                    QQToast.makeText(application, i3, 0).show(AddFriendLogicActivity.this.getTitleBarHeight());
                    AddFriendLogicActivity.this.finish();
                }
            }

            @Override // com.tencent.mobileqq.friend.observer.a
            protected void onUpdateAddFriendSetting(boolean z16, Bundle bundle) {
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, Boolean.valueOf(z16), bundle);
                    return;
                }
                String string = bundle.getString("uin");
                if (!AddFriendLogicActivity.this.f174698h0.equals(string)) {
                    return;
                }
                int i3 = bundle.getInt("random_key");
                if (i3 != 0 && i3 != AddFriendLogicActivity.this.f174693c0) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("addFriendTag", 2, String.format("onUpdateAddFriendSetting [uin:%s, key:%s, isSuc:%s]", Utils.U(string), Integer.valueOf(i3), Boolean.valueOf(z16)));
                }
                AddFriendLogicActivity.this.c3(false);
                if (!z16) {
                    AddFriendLogicActivity.this.d3(-1, HardCodeUtil.qqStr(R.string.j46));
                    QQToast.makeText(AddFriendLogicActivity.this.app.getApplication(), R.string.h1y, 0).show(AddFriendLogicActivity.this.getTitleBarHeight());
                    AddFriendLogicActivity.this.finish();
                    return;
                }
                int i16 = bundle.getInt("friend_setting");
                ArrayList<String> stringArrayList = bundle.getStringArrayList("user_question");
                Boolean valueOf = Boolean.valueOf(bundle.getBoolean("contact_bothway"));
                try {
                    str = Long.toString(bundle.getLong("query_friend_uin"));
                } catch (Exception unused) {
                    str = null;
                }
                if (valueOf.booleanValue() && i16 != 0) {
                    if (AddFriendLogicActivity.this.f174700j0 == 3006) {
                        AddFriendLogicActivity.this.getIntent().putExtra("sub_source_id", 2);
                    }
                    AddFriendLogicActivity.this.p3(i16, valueOf.booleanValue(), stringArrayList, AddFriendVerifyActivity.class, AddFriendLogicActivity.this.f174700j0);
                    return;
                }
                if (i16 != 0 && i16 != 1) {
                    if (i16 != 2) {
                        if (i16 != 3 && i16 != 4) {
                            if (i16 != 101) {
                                AddFriendLogicActivity.this.d3(-1, HardCodeUtil.qqStr(R.string.f171557j43));
                                QQToast.makeText(AddFriendLogicActivity.this.app.getApplication(), R.string.h1y, 0).show(AddFriendLogicActivity.this.getTitleBarHeight());
                                AddFriendLogicActivity.this.finish();
                                return;
                            }
                            if (AddFriendLogicActivity.this.f174697g0 == 1) {
                                ThreadManagerV2.post(new Runnable(string) { // from class: com.tencent.mobileqq.activity.AddFriendLogicActivity.3.1
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ String f174712d;

                                    {
                                        this.f174712d = string;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, (Object) string);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                        } else {
                                            ((FriendListHandler) AddFriendLogicActivity.this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).addFriendToFriendList(this.f174712d, 0, BuddySource.DEFAULT, "", true, false, -1L);
                                        }
                                    }
                                }, 8, null, true);
                            } else if (AddFriendLogicActivity.this.f174697g0 == 2) {
                                ((IPhoneContactService) AddFriendLogicActivity.this.app.getRuntimeService(IPhoneContactService.class)).onFriendListChanged();
                            }
                            if (AddFriendLogicActivity.this.getIntent().getBooleanExtra("webim_qd_ext", false) && !TextUtils.isEmpty(str)) {
                                AllInOne allInOne = new AllInOne(str, 1);
                                Intent intent = new Intent(AddFriendLogicActivity.this, (Class<?>) QidianProfileCardActivity.class);
                                intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne);
                                intent.addFlags(536870912);
                                AddFriendLogicActivity.this.startActivity(intent);
                                AddFriendLogicActivity.this.setResult(-1);
                                AddFriendLogicActivity.this.finish();
                                return;
                            }
                            if (TextUtils.isEmpty(str) || "0".equals(str)) {
                                AddFriendLogicActivity.this.d3(-1, HardCodeUtil.qqStr(R.string.f171556j42));
                                QQToast.makeText(AddFriendLogicActivity.this.app.getApplication(), HardCodeUtil.qqStr(R.string.j3z), 0).show(AddFriendLogicActivity.this.getTitleBarHeight());
                                AddFriendLogicActivity.this.setResult(-1);
                                AddFriendLogicActivity.this.finish();
                                return;
                            }
                            AllInOne allInOne2 = new AllInOne(str, 1);
                            allInOne2.profileEntryType = 115;
                            Intent intent2 = ProfileUtils.getIntent(AddFriendLogicActivity.this, allInOne2);
                            intent2.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne2);
                            intent2.putExtra("src_name", AddFriendLogicActivity.this.f174695e0);
                            intent2.putExtra("source_id", AddFriendLogicActivity.this.getIntent().getIntExtra("source_id", BuddySource.DEFAULT));
                            intent2.putExtra("extra", AddFriendLogicActivity.this.getIntent().getStringExtra("extra"));
                            intent2.addFlags(536870912);
                            intent2.addFlags(268435456);
                            AddFriendLogicActivity.f174690v0 = true;
                            AddFriendLogicActivity.this.startActivity(intent2);
                            AddFriendLogicActivity.this.setResult(-1);
                            AddFriendLogicActivity.this.finish();
                            return;
                        }
                    } else {
                        AddFriendLogicActivity addFriendLogicActivity = AddFriendLogicActivity.this;
                        addFriendLogicActivity.d3(-1, addFriendLogicActivity.getString(R.string.h0a));
                        AddFriendLogicActivity.this.l3();
                        return;
                    }
                }
                AddFriendLogicActivity.this.p3(i16, valueOf.booleanValue(), stringArrayList, AddFriendVerifyActivity.class, AddFriendLogicActivity.this.f174700j0);
            }
        };
        this.f174706p0 = new b();
        this.f174707q0 = new c();
        this.f174708r0 = new d();
        this.f174709s0 = null;
        this.f174710t0 = new g();
    }

    private boolean Y2() {
        TroopMemberInfo troopMemberInfoSync;
        Intent intent = getIntent();
        this.f174700j0 = intent.getIntExtra("source_id", BuddySource.DEFAULT);
        this.f174699i0 = intent.getStringExtra("extra");
        if (!b3(this.f174697g0, this.f174698h0)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendLogicActivity", 2, QQFriendJsPlugin.API_ADD_FRIEND);
        }
        String stringExtra = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
        if (this.f174700j0 == 3004 && stringExtra == null && !TextUtils.isEmpty(this.f174699i0) && (troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(this.f174699i0, this.f174698h0, this, "AddFriendLogicActivity-addFriend")) != null) {
            getIntent().putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, troopMemberInfoSync.friendnick);
        }
        addObserver(this.f174703m0);
        if (this.f174697g0 == 1) {
            if (QLog.isColorLevel()) {
                QLog.i("AddFriendLogicActivity", 2, "queryUinSafetyFlag");
            }
            showProgress();
            ((IFriendHandlerService) this.app.getRuntimeService(IFriendHandlerService.class)).requestUinSafetyFlag(Long.parseLong(this.f174698h0));
        } else {
            if (this.f174700j0 == 3024) {
                e3();
                return true;
            }
            if (!TextUtils.isEmpty(f174689u0)) {
                Z2();
            } else {
                e3();
            }
        }
        return true;
    }

    private void Z2() {
        OpenID b36;
        if (QLog.isColorLevel()) {
            QLog.i("addFriendTag", 2, "checkAccountDiff");
        }
        if (!TextUtils.isEmpty(f174689u0)) {
            if (this.f174699i0 == null) {
                b36 = null;
            } else {
                b36 = this.app.getMsgHandler().b3(this.f174699i0);
            }
            if (b36 != null && !TextUtils.isEmpty(b36.openID)) {
                if (!f174689u0.equals(b36.openID)) {
                    j3();
                    return;
                } else {
                    e3();
                    return;
                }
            }
            showProgress();
            Handler handler = new Handler();
            this.f174691a0 = handler;
            handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.AddFriendLogicActivity.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendLogicActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        if (AddFriendLogicActivity.this.isFinishing()) {
                            return;
                        }
                        AddFriendLogicActivity addFriendLogicActivity = AddFriendLogicActivity.this;
                        addFriendLogicActivity.f174692b0 = true;
                        addFriendLogicActivity.e3();
                    }
                }
            }, 3000L);
            this.app.addObserver(this.f174710t0);
            if (this.f174699i0 != null) {
                com.tencent.mobileqq.app.handler.a.a(this.app.getMsgHandler(), this.f174699i0);
            }
        }
    }

    private boolean b3(int i3, String str) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    finish();
                    return false;
                }
                if (this.f174700j0 == 3999) {
                    this.f174700j0 = 3016;
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.CONTACTS, 2, "openId source id is default!");
                    }
                }
            } else if (this.f174700j0 == 3999) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.CONTACTS, 2, "mobile source id is default!");
                }
                this.f174700j0 = 3006;
            }
        } else {
            try {
                Long.parseLong(str);
                if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "AddFriendLogicActivity")) {
                    QQToast.makeText(this.app.getApplication(), R.string.f170332ml, 0).show(getTitleBarHeight());
                    finish();
                    return false;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        if (NetworkUtil.isNetSupport(this)) {
            return true;
        }
        QQToast.makeText(this.app.getApplication(), R.string.f171139ci4, 0).show(getTitleBarHeight());
        finish();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c3(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendLogicActivity", 2, "dismissOrHideProgress hide: " + z16);
        }
        QQProgressDialog qQProgressDialog = this.f174701k0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            if (z16) {
                this.f174701k0.hide();
            } else {
                this.f174701k0.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d3(int i3, String str) {
        if (getIntent() != null) {
            if (getIntent().getIntExtra("source_id", BuddySource.DEFAULT) == 3090) {
                try {
                    ForwardSdkBaseOption.E(this, true, "action_game_make_friend", Long.valueOf(getIntent().getStringExtra("extra")).longValue(), i3, str);
                    return;
                } catch (Exception e16) {
                    QLog.e("AddFriendLogicActivity", 1, "feedBackToGameSDK error = " + e16);
                    return;
                }
            }
            return;
        }
        QLog.e("AddFriendLogicActivity", 1, "feedBackToGameSDK intent = null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e3() {
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendLogicActivity", 2, "getAddFriendSetting");
        }
        showProgress();
        ((IFriendHandlerService) this.app.getRuntimeService(IFriendHandlerService.class)).requestUserAddFriendSetting(this.f174698h0, this.f174700j0, getIntent().getIntExtra("sub_source_id", 0), this.f174699i0, this.f174693c0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f3() {
        String str;
        String str2;
        String str3;
        String str4;
        int i3;
        if (this.f174704n0 != null && this.f174705o0 != 0) {
            Bundle bundle = (Bundle) AntiFraudConfigFileUtil.n().p("SecWarningCfg", "AlertTitle", 147, this.f174705o0);
            if (bundle != null) {
                str = bundle.getString("AlertTitle");
            } else {
                str = null;
            }
            Bundle bundle2 = (Bundle) AntiFraudConfigFileUtil.n().p("SecWarningCfg", "AlertText", 147, this.f174705o0);
            if (bundle2 != null) {
                str2 = bundle2.getString("AlertText");
            } else {
                str2 = null;
            }
            Bundle bundle3 = (Bundle) AntiFraudConfigFileUtil.n().p("SecWarningCfg", "AlertLeftBtnText", 147, this.f174705o0);
            if (bundle3 != null) {
                str3 = bundle3.getString("AlertLeftBtnText");
            } else {
                str3 = null;
            }
            Bundle bundle4 = (Bundle) AntiFraudConfigFileUtil.n().p("SecWarningCfg", "AlertRightBtnText", 147, this.f174705o0);
            if (bundle4 != null) {
                str4 = bundle4.getString("AlertRightBtnText");
            } else {
                str4 = null;
            }
            if (str == null) {
                if (this.f174705o0 == 1) {
                    i3 = R.string.ham;
                } else {
                    i3 = R.string.haq;
                }
                str = getString(i3);
            }
            if (str2 == null) {
                int i16 = this.f174705o0;
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
                if (this.f174705o0 == 1) {
                    this.f174706p0 = null;
                } else {
                    str3 = getString(R.string.hai);
                }
            } else if (TextUtils.isEmpty(str3.trim())) {
                this.f174706p0 = null;
            }
            if (str4 == null) {
                if (this.f174705o0 == 1) {
                    str4 = getString(R.string.hah);
                } else {
                    str4 = getString(R.string.hag);
                }
            } else if (TextUtils.isEmpty(str4.trim())) {
                this.f174707q0 = null;
            }
            this.f174704n0.setTitle(str);
            this.f174704n0.setMessage(str2);
            this.f174704n0.setNegativeButton(str3, this.f174706p0);
            this.f174704n0.setPositiveButton(str4, this.f174707q0);
            if (this.f174706p0 == null || this.f174707q0 == null) {
                this.f174704n0.findViewById(R.id.aet).setVisibility(8);
            }
        }
    }

    private boolean g3() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("uin");
        short shortExtra = intent.getShortExtra("group_option", (short) 2);
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(stringExtra);
        if (troopInfoFromCache != null && troopInfoFromCache.isMember()) {
            QQToast.makeText(this.app.getApplication(), R.string.f170329mi, 0).show(getTitleBarHeight());
            finish();
            return false;
        }
        if (shortExtra == 3) {
            String stringExtra2 = getIntent().getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
            if (stringExtra2 == null || stringExtra2.length() == 0) {
                getString(R.string.f171053c05);
            }
            QQToast.makeText(this.app.getApplication(), R.string.i7i, 0).show(getTitleBarHeight());
            finish();
            return false;
        }
        Intent intent2 = new Intent();
        intent2.putExtras(getIntent());
        intent2.putExtra("friend_setting", 9);
        if (getIntent().getStringExtra("param_return_addr") != null) {
            intent2.putExtra("param_return_addr", getIntent().getStringExtra("param_return_addr"));
            i3(intent2, false);
            finish();
            return false;
        }
        i3(intent2, true);
        return true;
    }

    private boolean h3() {
        if (!NetworkUtil.isNetSupport(this)) {
            QQToast.makeText(this.app.getApplication(), R.string.f171139ci4, 0).show(getTitleBarHeight());
            finish();
            return false;
        }
        Intent intent = new Intent(this, (Class<?>) AddFriendVerifyActivity.class);
        intent.putExtras(getIntent());
        intent.putExtra("param_mode", 0);
        intent.putExtra("contact_bothway", true);
        if (getIntent().getStringExtra("param_return_addr") != null) {
            startActivity(intent);
            finish();
        } else {
            startActivityForResult(intent, 1);
        }
        return true;
    }

    private void i3(Intent intent, boolean z16) {
        QLog.i("AddFriendLogicActivity", 1, "[openJoinTroopPage] needResult:" + z16);
        if (!z16) {
            QPublicFragmentActivity.b.b(this, intent, QPublicFragmentActivity.class, JoinTroopVerifyFragment.class);
        } else {
            QPublicFragmentActivity.b.e(this, intent, QPublicFragmentActivity.class, JoinTroopVerifyFragment.class, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l3() {
        if (isFinishing()) {
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendLogicActivity", 2, "showRefuseAddFriendDialog is finishing return");
                return;
            }
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
        createCustomDialog.setTitle(getString(R.string.yke));
        createCustomDialog.setMessage(getString(R.string.h0a));
        createCustomDialog.setCancelable(false);
        createCustomDialog.setCanceledOnTouchOutside(false);
        Window window = createCustomDialog.getWindow();
        if (window != null) {
            window.setDimAmount(0.5f);
            window.addFlags(2);
        }
        createCustomDialog.setPositiveButton(R.string.f171151ok, new f()).setNegativeButton((String) null, (DialogInterface.OnClickListener) null).show();
    }

    public static Intent n3(Context context, String str, String str2, short s16, int i3, String str3, String str4, String str5, String str6, String str7) {
        return startJoinTroop(context, str, str2, s16, i3, str3, str4, str5, str6, null, str7, null);
    }

    private void showProgress() {
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendLogicActivity", 2, "showProgress");
        }
        if (this.f174701k0 == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
            this.f174701k0 = qQProgressDialog;
            qQProgressDialog.O(new a());
        }
        this.f174701k0.setMessage(R.string.bj_);
        if (!isFinishing()) {
            this.f174701k0.show();
        }
    }

    public static Intent startJoinTroop(Context context, String str, String str2, short s16, int i3, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Intent intent = new Intent(context, (Class<?>) AddFriendLogicActivity.class);
        intent.putExtra("uin", str);
        intent.putExtra("k_uin_type", 4);
        intent.putExtra("group_option", s16);
        intent.putExtra("troop_question", str3);
        intent.putExtra("troop_answer", str4);
        intent.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, str2);
        intent.putExtra(ProfileContants.CMD_PARAM_STAT_OPTION, i3);
        intent.putExtra("param_return_addr", str5);
        intent.putExtra("last_activity", str6);
        intent.putExtra("authKey", str7);
        intent.putExtra("authSig", str8);
        if (str9 != null) {
            intent.putExtra("key_param_homework_intro_str", str9);
        }
        return intent;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        Intent intent2 = getIntent();
        if (intent2 != null) {
            z16 = intent2.getBooleanExtra("need_result_uin", false);
        }
        if (z16) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra("uin", this.f174698h0);
        }
        setResult(i16, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        Intent intent = getIntent();
        this.f174697g0 = intent.getIntExtra("k_uin_type", 0);
        this.f174698h0 = intent.getStringExtra("uin");
        this.f174694d0 = intent.getStringExtra("last_activity");
        this.f174695e0 = intent.getStringExtra("src_name");
        this.f174696f0 = intent.getIntExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, -1);
        String str = this.f174698h0;
        if (str != null && str.length() >= 5) {
            this.f174693c0 = hashCode();
            if (bundle != null) {
                return true;
            }
            if (this.f174697g0 == 4) {
                return g3();
            }
            return Y2();
        }
        int intExtra = intent.getIntExtra("source_id", BuddySource.DEFAULT);
        this.f174700j0 = intExtra;
        if (intExtra != 3078 && intExtra != 3079) {
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendLogicActivity", 2, "uin should not be null, activity finish");
            }
            super.finish();
            return false;
        }
        return h3();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        c3(false);
        com.tencent.mobileqq.friend.observer.a aVar = this.f174703m0;
        if (aVar != null) {
            removeObserver(aVar);
        }
        com.tencent.biz.common.util.i iVar = this.f174710t0;
        if (iVar != null) {
            removeObserver(iVar);
        }
        super.doOnDestroy();
        SimpleEventBus.getInstance().dispatchEvent(new AddFriendLogicActivityDestroyEvent());
    }

    protected void j3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QQCustomDialog qQCustomDialog = this.f174709s0;
        if (qQCustomDialog != null && !qQCustomDialog.isShowing() && !isFinishing()) {
            this.f174709s0.show();
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
        this.f174709s0 = createCustomDialog;
        createCustomDialog.setMessage(R.string.d65);
        this.f174709s0.setTitle(R.string.b1v);
        e eVar = new e();
        this.f174709s0.setNegativeButton(R.string.cancel, eVar);
        this.f174709s0.setPositiveButton(R.string.d5b, eVar);
        if (!isFinishing()) {
            this.f174709s0.show();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    void p3(int i3, boolean z16, ArrayList<String> arrayList, Class<?> cls, int i16) {
        this.f174702l0 = i3;
        if (this.f174700j0 == 3024 && i3 == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendLogicActivity", 2, "startVerifyActivity() from applets add friend and friendSetting is 0 ");
            }
            if (NetworkUtil.isNetSupport(this)) {
                ((IFriendHandlerService) this.app.getRuntimeService(IFriendHandlerService.class)).requestAddFriend(this.f174698h0, this.f174699i0, i3, (byte) 0, "", this.f174700j0, getIntent().getIntExtra("sub_source_id", 0), false, null, false, null, this.f174695e0, getIntent().getBundleExtra("flc_extra_param"), false);
                return;
            } else {
                QQToast.makeText(this.app.getApplication(), R.string.f171139ci4, 0).show(getTitleBarHeight());
                return;
            }
        }
        Intent intent = new Intent(this, cls);
        intent.putExtras(getIntent());
        intent.putExtra("param_mode", 0);
        intent.putExtra("friend_setting", i3);
        intent.putExtra("contact_bothway", z16);
        intent.putExtra("user_question", arrayList);
        intent.putExtra("sort_id", this.f174700j0);
        intent.putExtra("extra", this.f174699i0);
        intent.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, this.f174696f0);
        if (this.f174700j0 == 3094) {
            intent.putExtra("sub_source_id", getIntent().getIntExtra("sub_source_id", 8));
        }
        if (!intent.hasExtra(IProfileCardConst.KEY_WZRY_DATA) && KplHelper.isKplSession(this.app, this, this.f174698h0, i16)) {
            String buildNickName = KplRoleInfo.WZRYUIinfo.buildNickName(getIntent().getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME), KplHelper.getGameNickByUin(this.app, this.f174698h0));
            KplRoleInfo.WZRYUIinfo createInfo = KplRoleInfo.WZRYUIinfo.createInfo(this.f174698h0, buildNickName, KplHelper.getKplVerifyMsg(this.app), 0, 0);
            if (createInfo != null) {
                intent.putExtra(IProfileCardConst.KEY_WZRY_DATA, createInfo);
                intent.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, buildNickName);
            }
        }
        if (getIntent().getStringExtra("param_return_addr") != null) {
            startActivity(intent);
            finish();
        } else {
            startActivityForResult(intent, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public String setLastActivityName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String str = this.f174694d0;
        if (str != null) {
            return str;
        }
        return super.setLastActivityName();
    }
}
