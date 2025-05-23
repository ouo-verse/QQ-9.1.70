package com.tencent.mobileqq.addfriend.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.selectmember.api.IForwardApi;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.addfriend.config.AddFriendOpenSdkConfigParser;
import com.tencent.mobileqq.addfriend.part.OpenAddFriendPart;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.pad.i;
import com.tencent.mobileqq.pad.m;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.utils.j;
import com.tencent.util.QQToastUtil;
import common.config.service.QzoneConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AddFriendCheckFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private static String f187367a0;

    /* renamed from: b0, reason: collision with root package name */
    private static boolean f187368b0;
    private AppInterface C;
    protected Handler D;
    protected boolean E;
    private int F;
    private int G;
    private String H;
    private String I;
    private int J;
    private QQProgressDialog K;
    private int L;
    private String M;
    private String N;
    private QQCustomDialog P;
    private int Q;
    private int R;
    private ArrayList<com.tencent.mobileqq.addfriend.processor.a> S;
    private String T;
    private byte[] U;
    private OpenAddFriendPart V;
    protected QQCustomDialog W;
    DialogInterface.OnClickListener X;
    DialogInterface.OnClickListener Y;
    com.tencent.mobileqq.friend.observer.a Z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements com.tencent.qqnt.troopmemberlist.g {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendCheckFragment.this);
            }
        }

        @Override // com.tencent.qqnt.troopmemberlist.g
        public void a(@Nullable TroopMemberInfo troopMemberInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberInfo);
            } else if (troopMemberInfo != null) {
                AddFriendCheckFragment.this.Rh().putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, troopMemberInfo.friendnick);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements QQProgressDialog.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendCheckFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.QQProgressDialog.b
        public void onBackPressed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AddFriendCheckFragment.this.doCallback(4, "");
                AddFriendCheckFragment.this.getActivity().onBackPressed();
                AddFriendCheckFragment.this.K.O(null);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements yc1.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendCheckFragment.this);
            }
        }

        @Override // yc1.a
        public void a(boolean z16, OpenID openID) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), openID);
                return;
            }
            if (!AddFriendCheckFragment.this.Wh()) {
                AddFriendCheckFragment addFriendCheckFragment = AddFriendCheckFragment.this;
                if (!addFriendCheckFragment.E) {
                    Handler handler = addFriendCheckFragment.D;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                    if (!z16 || openID == null || openID.openID == null) {
                        AddFriendCheckFragment.this.Qh();
                        if (QLog.isColorLevel()) {
                            QLog.d("AddFriendCheckFragment", 2, "openIdObserver fail");
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("AddFriendCheckFragment", 2, "openIdObserver success");
                    }
                    if (!openID.openID.equals(AddFriendCheckFragment.Sh())) {
                        AddFriendCheckFragment.this.Nh(true);
                        AddFriendCheckFragment.this.ii();
                    } else {
                        AddFriendCheckFragment.this.Qh();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendCheckFragment.this);
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
                intent.putExtras(AddFriendCheckFragment.this.Rh().getExtras());
                intent.putExtra("appid", AddFriendCheckFragment.this.I);
                intent.putExtra("openid", AddFriendCheckFragment.Sh());
                intent.putExtra("key_action", "key_sdk_add_friend");
                intent.addFlags(268435456);
                intent.addFlags(67108864);
                AddFriendCheckFragment.this.W.cancel();
                RouteUtils.startActivity(AddFriendCheckFragment.this.getActivity(), intent, RouterConstants.UI_ROUTER_LOGIN);
                AddFriendCheckFragment.this.getActivity().finish();
                return;
            }
            if (i3 == 0) {
                FragmentActivity activity = AddFriendCheckFragment.this.getActivity();
                AddFriendCheckFragment.this.getActivity();
                activity.setResult(0);
                AddFriendCheckFragment.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendCheckFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                AddFriendCheckFragment.this.Oh();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class f implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendCheckFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                if (AddFriendCheckFragment.this.Wh()) {
                    return;
                }
                if (AddFriendCheckFragment.this.Q != 1) {
                    AddFriendCheckFragment.this.Qh();
                } else {
                    AddFriendCheckFragment.this.getActivity().finish();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class g implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendCheckFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (!AddFriendCheckFragment.this.Wh()) {
                AddFriendCheckFragment.this.doCallback(10001, "");
                ReportController.o(AddFriendCheckFragment.this.C, "P_CliOper", "Safe_AntiFraud", AddFriendCheckFragment.this.C.getCurrentAccountUin(), "AlertDialog", "UserClick", 0, AddFriendCheckFragment.this.Q, "", "", "", "");
                AddFriendCheckFragment.this.getActivity().finish();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25725);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f187367a0 = "";
            f187368b0 = false;
        }
    }

    public AddFriendCheckFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.L = -1;
        this.R = -1;
        this.W = null;
        this.X = new f();
        this.Y = new g();
        this.Z = new com.tencent.mobileqq.friend.observer.a() { // from class: com.tencent.mobileqq.addfriend.ui.AddFriendCheckFragment.9
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AddFriendCheckFragment.this);
                }
            }

            private HashMap<String, String> a(String str) {
                return new HashMap<String, String>(str, AddFriendCheckFragment.this.Rh().getIntExtra("source_id", BuddySource.DEFAULT), AddFriendCheckFragment.this.Rh().getIntExtra("sub_source_id", 0)) { // from class: com.tencent.mobileqq.addfriend.ui.AddFriendCheckFragment.9.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String val$errorCode;
                    final /* synthetic */ int val$sourceId;
                    final /* synthetic */ int val$subSourceId;

                    {
                        this.val$errorCode = str;
                        this.val$sourceId = r7;
                        this.val$subSourceId = r8;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AnonymousClass9.this, str, Integer.valueOf(r7), Integer.valueOf(r8));
                            return;
                        }
                        put("errorCode", str);
                        put("sourceid", String.valueOf(r7));
                        put("subsourceid", String.valueOf(r8));
                    }
                };
            }

            @Override // com.tencent.mobileqq.friend.observer.a
            protected void onQueryUinSafetyFlag(boolean z16, long j3, int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3));
                    return;
                }
                if (AddFriendCheckFragment.this.Wh()) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("addFriendTag", 2, String.format("onQueryUinSafetyFlag [uin:%s, isSuc:%s, type:%s, status:%s]", Utils.U(String.valueOf(j3)), Boolean.valueOf(z16), Integer.valueOf(AddFriendCheckFragment.this.G), Integer.valueOf(i3)));
                }
                if (AddFriendCheckFragment.this.G == 1 && String.valueOf(j3).equals(AddFriendCheckFragment.this.H)) {
                    if (!z16 || i3 == 0) {
                        AddFriendCheckFragment.this.Qh();
                        return;
                    }
                    AddFriendCheckFragment.this.Nh(false);
                    AddFriendCheckFragment.this.Q = i3;
                    ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).checkUpdate(AddFriendCheckFragment.this.C, "SecWarningCfg");
                    try {
                        AddFriendCheckFragment addFriendCheckFragment = AddFriendCheckFragment.this;
                        FragmentActivity activity = addFriendCheckFragment.getActivity();
                        AddFriendCheckFragment addFriendCheckFragment2 = AddFriendCheckFragment.this;
                        addFriendCheckFragment.P = DialogUtil.createCustomDialog(activity, 230, "", "", addFriendCheckFragment2.X, addFriendCheckFragment2.Y);
                        AddFriendCheckFragment.this.Vh();
                        Window window = AddFriendCheckFragment.this.P.getWindow();
                        if (window != null) {
                            WindowManager.LayoutParams attributes = window.getAttributes();
                            if (QLog.isColorLevel() && attributes != null) {
                                QLog.i("addFriendTag", 2, String.format("onQueryUinSafetyFlag [%s, %s, %s]", Float.valueOf(attributes.dimAmount), Integer.valueOf(attributes.flags), Integer.valueOf(attributes.flags & 2)));
                            }
                            window.setDimAmount(0.5f);
                            window.addFlags(2);
                        }
                        AddFriendCheckFragment.this.P.show();
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    ReportController.o(AddFriendCheckFragment.this.C, "P_CliOper", "Safe_AntiFraud", AddFriendCheckFragment.this.C.getCurrentAccountUin(), "AlertDialog", "Display", 0, AddFriendCheckFragment.this.Q, "", "", "", "");
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.friend.observer.a
            public void onUpdateAddFriend(boolean z16, boolean z17, boolean z18, String str, Bundle bundle) {
                int i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, bundle);
                    return;
                }
                if (!AddFriendCheckFragment.this.Wh() && AddFriendCheckFragment.this.J == 3024 && AddFriendCheckFragment.this.L == 0) {
                    BaseApplication context = BaseApplication.getContext();
                    if (z16) {
                        i3 = R.string.heo;
                    } else {
                        i3 = R.string.f173065h22;
                    }
                    QQToast.makeText(context, i3, 0).show(AddFriendCheckFragment.this.getQBaseActivity().getTitleBarHeight());
                    AddFriendCheckFragment.this.getActivity().finish();
                }
            }

            @Override // com.tencent.mobileqq.friend.observer.a
            protected void onUpdateAddFriendSetting(boolean z16, Bundle bundle) {
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                    return;
                }
                if (AddFriendCheckFragment.this.Wh()) {
                    return;
                }
                String string = bundle.getString("uin");
                if (!AddFriendCheckFragment.this.H.equals(string)) {
                    return;
                }
                int i3 = bundle.getInt("random_key");
                if (i3 != 0 && i3 != AddFriendCheckFragment.this.F) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("addFriendTag", 2, String.format("onUpdateAddFriendSetting [uin:%s, key:%s, isSuc:%s]", Utils.U(string), Integer.valueOf(i3), Boolean.valueOf(z16)));
                }
                AddFriendCheckFragment.this.Nh(false);
                if (!z16) {
                    AddFriendCheckFragment.this.Ph(-1, HardCodeUtil.qqStr(R.string.h1y));
                    com.tencent.relation.common.report.a.c("relation_addfriend_page_showtime", System.currentTimeMillis() - AddFriendCheckFragment.this.Rh().getLongExtra("startAddFriendCheckFragment", 0L), false, a("-1"));
                    QQToast.makeText(BaseApplication.getContext(), R.string.h1y, 0).show(AddFriendCheckFragment.this.getQBaseActivity().getTitleBarHeight());
                    AddFriendCheckFragment.this.getActivity().finish();
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
                    if (AddFriendCheckFragment.this.J == 3006) {
                        AddFriendCheckFragment.this.Rh().putExtra("sub_source_id", 2);
                    }
                    AddFriendCheckFragment.this.oi(i16, valueOf.booleanValue(), stringArrayList, AddFriendCheckFragment.this.J);
                    return;
                }
                if (i16 != 0 && i16 != 1) {
                    if (i16 != 2) {
                        if (i16 != 3 && i16 != 4) {
                            if (i16 != 101) {
                                AddFriendCheckFragment.this.Ph(-1, HardCodeUtil.qqStr(R.string.h1y));
                                QQToast.makeText(BaseApplication.getContext(), R.string.h1y, 0).show(AddFriendCheckFragment.this.getQBaseActivity().getTitleBarHeight());
                                com.tencent.relation.common.report.a.c("relation_addfriend_page_showtime", System.currentTimeMillis() - AddFriendCheckFragment.this.Rh().getLongExtra("startAddFriendCheckFragment", 0L), false, a("-1"));
                                AddFriendCheckFragment.this.getActivity().finish();
                                return;
                            }
                            com.tencent.relation.common.report.a.c("relation_addfriend_page_showtime", System.currentTimeMillis() - AddFriendCheckFragment.this.Rh().getLongExtra("startAddFriendCheckFragment", 0L), false, a("101"));
                            if (AddFriendCheckFragment.this.G == 1) {
                                ThreadManagerV2.post(new Runnable(string) { // from class: com.tencent.mobileqq.addfriend.ui.AddFriendCheckFragment.9.1
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ String f187370d;

                                    {
                                        this.f187370d = string;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass9.this, (Object) string);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                        } else {
                                            ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).addFriendToFriendList(AddFriendCheckFragment.this.C, this.f187370d, 0, BuddySource.DEFAULT, "", true, false, -1L);
                                        }
                                    }
                                }, 8, null, true);
                            } else if (AddFriendCheckFragment.this.G == 2) {
                                ((IPhoneContactService) AddFriendCheckFragment.this.C.getRuntimeService(IPhoneContactService.class, "")).onFriendListChanged();
                            }
                            if (AddFriendCheckFragment.this.Rh().getBooleanExtra("webim_qd_ext", false) && !TextUtils.isEmpty(str)) {
                                ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).jumpToQidianProfile(str, AddFriendCheckFragment.this.getActivity());
                                AddFriendCheckFragment.this.getActivity().setResult(-1);
                                AddFriendCheckFragment.this.getActivity().finish();
                                return;
                            } else {
                                if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                                    AddFriendCheckFragment.this.Th(str);
                                    return;
                                }
                                AddFriendCheckFragment addFriendCheckFragment = AddFriendCheckFragment.this;
                                addFriendCheckFragment.Ph(-1, addFriendCheckFragment.getString(R.string.f170332ml));
                                QQToast.makeText(BaseApplication.getContext(), AddFriendCheckFragment.this.getString(R.string.f170332ml), 0).show(AddFriendCheckFragment.this.getQBaseActivity().getTitleBarHeight());
                                AddFriendCheckFragment.this.getActivity().setResult(-1);
                                AddFriendCheckFragment.this.getActivity().finish();
                                return;
                            }
                        }
                    } else {
                        com.tencent.relation.common.report.a.c("relation_addfriend_page_showtime", System.currentTimeMillis() - AddFriendCheckFragment.this.Rh().getLongExtra("startAddFriendCheckFragment", 0L), false, a("2"));
                        AddFriendCheckFragment addFriendCheckFragment2 = AddFriendCheckFragment.this;
                        addFriendCheckFragment2.Ph(-1, addFriendCheckFragment2.getString(R.string.h0a));
                        if (!AddFriendOpenSdkConfigParser.c(AddFriendCheckFragment.this.J)) {
                            AddFriendCheckFragment.this.ji();
                            return;
                        } else {
                            QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.h0a));
                            return;
                        }
                    }
                }
                AddFriendCheckFragment.this.oi(i16, valueOf.booleanValue(), stringArrayList, AddFriendCheckFragment.this.J);
            }
        };
    }

    private boolean Kh() {
        if (Wh()) {
            return false;
        }
        Intent Rh = Rh();
        this.J = Rh.getIntExtra("source_id", BuddySource.DEFAULT);
        Rh.getIntExtra("sub_source_id", 0);
        Rh.getByteArrayExtra("third_source_id");
        this.I = Rh.getStringExtra("extra");
        if (!Mh(this.G, this.H)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendCheckFragment", 2, QQFriendJsPlugin.API_ADD_FRIEND);
        }
        String stringExtra = Rh.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
        if (this.J == 3004 && stringExtra == null && !TextUtils.isEmpty(this.I)) {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfo(this.I, this.H, false, this, "AddFriendCheckFragment-addFriend", new a());
        }
        this.C.addObserver(this.Z);
        if (this.G == 1) {
            if (QLog.isColorLevel()) {
                QLog.i("AddFriendCheckFragment", 2, "queryUinSafetyFlag");
            }
            showProgress();
            ((IFriendHandlerService) this.C.getRuntimeService(IFriendHandlerService.class, "")).requestUinSafetyFlag(j.b("AddFriendCheckFragment", this.H));
        } else {
            int i3 = this.J;
            if (i3 != 3024 && i3 != 3094) {
                if (!TextUtils.isEmpty(Sh())) {
                    Lh();
                } else {
                    Qh();
                }
            } else {
                Qh();
                return true;
            }
        }
        return true;
    }

    private void Lh() {
        OpenID d16;
        if (QLog.isColorLevel()) {
            QLog.i("addFriendTag", 2, "checkAccountDiff");
        }
        if (!TextUtils.isEmpty(Sh())) {
            if (this.I == null) {
                d16 = null;
            } else {
                d16 = com.tencent.mobileqq.addfriend.helper.b.b().d(this.I);
            }
            if (d16 != null && !TextUtils.isEmpty(d16.openID)) {
                if (!Sh().equals(d16.openID)) {
                    ii();
                    return;
                } else {
                    Qh();
                    return;
                }
            }
            showProgress();
            Handler handler = new Handler();
            this.D = handler;
            handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.addfriend.ui.AddFriendCheckFragment.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendCheckFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        if (AddFriendCheckFragment.this.Wh()) {
                            return;
                        }
                        AddFriendCheckFragment addFriendCheckFragment = AddFriendCheckFragment.this;
                        addFriendCheckFragment.E = true;
                        addFriendCheckFragment.Qh();
                    }
                }
            }, 3000L);
            if (this.I != null) {
                com.tencent.mobileqq.addfriend.helper.b.b().c(this.I, new c());
            }
        }
    }

    private boolean Mh(int i3, String str) {
        if (Wh()) {
            return false;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    getActivity().finish();
                    return false;
                }
                if (this.J == 3999) {
                    this.J = 3016;
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.CONTACTS, 2, "openId source id is default!");
                    }
                }
            } else if (this.J == 3999) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.CONTACTS, 2, "mobile source id is default!");
                }
                this.J = 3006;
            }
        } else {
            try {
                Long.parseLong(str);
                if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "AddFriendCheckFragment")) {
                    QQToast.makeText(this.C.getApplication(), R.string.f170332ml, 0).show(getQBaseActivity().getTitleBarHeight());
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
        QQToast.makeText(this.C.getApplication(), R.string.f171139ci4, 0).show(getQBaseActivity().getTitleBarHeight());
        getActivity().finish();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nh(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendCheckFragment", 2, "dismissOrHideProgress hide: " + z16);
        }
        QQProgressDialog qQProgressDialog = this.K;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            if (z16) {
                this.K.hide();
            } else {
                this.K.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ph(int i3, String str) {
        if (Wh()) {
            return;
        }
        doCallback(10001, str);
        if (Rh() != null) {
            if (Rh().getIntExtra("source_id", BuddySource.DEFAULT) == 3090) {
                try {
                    ((IForwardApi) QRoute.api(IForwardApi.class)).startGameSdkCallback(getActivity(), true, "action_game_make_friend", Long.parseLong(Rh().getStringExtra("extra")), i3, str);
                    return;
                } catch (Exception e16) {
                    QLog.e("AddFriendCheckFragment", 1, "feedBackToGameSDK error = " + e16);
                    return;
                }
            }
            return;
        }
        QLog.e("AddFriendCheckFragment", 1, "feedBackToGameSDK intent = null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qh() {
        if (Wh()) {
            return;
        }
        showProgress();
        int intExtra = Rh().getIntExtra("sub_source_id", 0);
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendCheckFragment", 2, "getAddFriendSetting, mUin = " + this.H + " mFriendSource = " + this.J + " subSource = " + intExtra + " mExtUin = " + this.I + " rankey = " + this.F);
        }
        ((IFriendHandlerService) this.C.getRuntimeService(IFriendHandlerService.class, "")).requestUserAddFriendSetting(this.H, this.J, intExtra, this.I, this.F);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent Rh() {
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

    public static String Sh() {
        return f187367a0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Th(String str) {
        if (AddFriendOpenSdkConfigParser.c(this.J)) {
            Zh(str);
        } else {
            ai(str, this.N, getActivity());
        }
        fi(true);
        getActivity().setResult(-1);
        getActivity().finish();
    }

    private void Uh() {
        OpenAddFriendPart openAddFriendPart = new OpenAddFriendPart();
        this.V = openAddFriendPart;
        openAddFriendPart.setIntent(Rh());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vh() {
        String str;
        String str2;
        String str3;
        String str4;
        int i3;
        if (this.P != null && this.Q != 0) {
            Bundle bundle = (Bundle) ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getValue("SecWarningCfg", "AlertTitle", 147, this.Q);
            if (bundle != null) {
                str = bundle.getString("AlertTitle");
            } else {
                str = null;
            }
            Bundle bundle2 = (Bundle) ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getValue("SecWarningCfg", "AlertText", 147, this.Q);
            if (bundle2 != null) {
                str2 = bundle2.getString("AlertText");
            } else {
                str2 = null;
            }
            Bundle bundle3 = (Bundle) ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getValue("SecWarningCfg", "AlertLeftBtnText", 147, this.Q);
            if (bundle3 != null) {
                str3 = bundle3.getString("AlertLeftBtnText");
            } else {
                str3 = null;
            }
            Bundle bundle4 = (Bundle) ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getValue("SecWarningCfg", "AlertRightBtnText", 147, this.Q);
            if (bundle4 != null) {
                str4 = bundle4.getString("AlertRightBtnText");
            } else {
                str4 = null;
            }
            if (str == null) {
                if (this.Q == 1) {
                    i3 = R.string.ham;
                } else {
                    i3 = R.string.haq;
                }
                str = getString(i3);
            }
            if (str2 == null) {
                int i16 = this.Q;
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
                if (this.Q == 1) {
                    this.X = null;
                } else {
                    str3 = getString(R.string.hai);
                }
            } else if (TextUtils.isEmpty(str3.trim())) {
                this.X = null;
            }
            if (str4 == null) {
                if (this.Q == 1) {
                    str4 = getString(R.string.hah);
                } else {
                    str4 = getString(R.string.hag);
                }
            } else if (TextUtils.isEmpty(str4.trim())) {
                this.Y = null;
            }
            this.P.setTitle(str);
            this.P.setMessage(str2);
            this.P.setNegativeButton(str3, this.X);
            this.P.setPositiveButton(str4, this.Y);
            if (this.X == null || this.Y == null) {
                this.P.findViewById(R.id.aet).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Wh() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            return false;
        }
        return true;
    }

    private static boolean Xh(Context context, Intent intent) {
        boolean isInMultiWindowMode;
        boolean z16 = false;
        if (intent == null || intent.getIntExtra("param_return_profilecard_pa", -1) != 104 || Build.VERSION.SDK_INT < 24) {
            return false;
        }
        if (context instanceof Activity) {
            isInMultiWindowMode = ((Activity) context).isInMultiWindowMode();
            if (isInMultiWindowMode) {
                z16 = true;
            }
        }
        return !z16;
    }

    public static boolean Yh() {
        return f187368b0;
    }

    private void Zh(String str) {
        try {
            long parseLong = Long.parseLong(str);
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
            String nickWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getNickWithUid(uidFromUin, "AddFriendCheckFragment");
            Context context = getContext();
            QLog.i("AddFriendCheckFragment", 1, "jumpToFriendChat uid: " + uidFromUin);
            if (!TextUtils.isEmpty(uidFromUin)) {
                if (TextUtils.isEmpty(nickWithUid)) {
                    nickWithUid = "";
                }
                ((IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class)).navigateToAIOActivity(context, 1, uidFromUin, nickWithUid, parseLong, new Bundle());
            }
        } catch (NumberFormatException e16) {
            QLog.e("AddFriendCheckFragment", 1, e16, new Object[0]);
        }
        QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.f197554kb));
    }

    public static void bi(Context context, Intent intent) {
        intent.putExtra("startAddFriendCheckFragment", System.currentTimeMillis());
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("public_fragment_window_feature", 1);
        if (com.tencent.mobileqq.pad.e.a() == SplitViewState.STATE_FLAT && !Xh(context, intent)) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("add_friend_intent", intent);
            i.e(context, bundle, AddFriendCheckFragment.class, new com.tencent.mobileqq.pad.b().e(false).g(true).h(LaunchMode.standard).a());
            return;
        }
        QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, AddFriendCheckFragment.class);
    }

    public static void ci(Activity activity, Intent intent, int i3) {
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("startAddFriendCheckFragment", System.currentTimeMillis());
        QPublicFragmentActivity.b.e(activity, intent, QPublicTransFragmentActivity.class, AddFriendCheckFragment.class, i3);
    }

    private boolean di() {
        if (Wh()) {
            return false;
        }
        if (!NetworkUtil.isNetSupport(getActivity())) {
            QQToast.makeText(BaseApplication.getContext(), R.string.f171139ci4, 0).show(getQBaseActivity().getTitleBarHeight());
            getActivity().finish();
            return false;
        }
        Intent intent = new Intent();
        intent.putExtras(Rh());
        intent.putExtra("param_mode", 0);
        intent.putExtra("contact_bothway", true);
        mi(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCallback(int i3, String str) {
        OpenAddFriendPart openAddFriendPart = this.V;
        if (openAddFriendPart == null) {
            return;
        }
        openAddFriendPart.z9(i3, str);
    }

    private void ei(Activity activity, Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("add_friend_intent", intent);
        i.e(activity, bundle, AddFriendVerifyFragment.class, new com.tencent.mobileqq.pad.b().e(false).g(true).h(LaunchMode.standard).a());
    }

    public static void fi(boolean z16) {
        f187368b0 = z16;
    }

    public static void gi(String str) {
        f187367a0 = str;
    }

    private boolean hi(String str, int i3, String str2, String str3) {
        if ("app".equals(str)) {
            if ((3016 == i3 || 3103 == i3) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ji() {
        if (Wh()) {
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendCheckFragment", 2, "showRefuseAddFriendDialog is finishing return");
                return;
            }
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 230);
        createCustomDialog.setTitle(getString(R.string.yke));
        createCustomDialog.setMessage(getString(R.string.h0a));
        createCustomDialog.setCancelable(false);
        createCustomDialog.setCanceledOnTouchOutside(false);
        Window window = createCustomDialog.getWindow();
        if (window != null) {
            window.setDimAmount(0.5f);
            window.addFlags(2);
        }
        createCustomDialog.setPositiveButton(R.string.f171151ok, new e()).setNegativeButton((String) null, (DialogInterface.OnClickListener) null).show();
    }

    public static Intent ki(Context context, int i3, String str, String str2, int i16, int i17, String str3, String str4, String str5, String str6, String str7) {
        return li(context, i3, str, str2, i16, i17, null, str3, str4, str5, str6, str7, null);
    }

    public static Intent li(Context context, int i3, String str, String str2, int i16, int i17, byte[] bArr, String str3, String str4, String str5, String str6, String str7, byte[] bArr2) {
        Intent intent;
        String str8 = str4;
        if (QLog.isColorLevel()) {
            QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "AddFriendCheckFragment.startAddFriend [type:%s, uin: %s, extUin: %s, source:%s, subSource:%s]", Integer.valueOf(i3), Utils.U(str), str2, Integer.valueOf(i16), Integer.valueOf(i17)));
        }
        Intent intent2 = new Intent();
        intent2.putExtra("startAddFriendCheckFragment", System.currentTimeMillis());
        intent2.putExtra("uin", str);
        intent2.putExtra("k_uin_type", i3);
        intent2.putExtra("extra", str2);
        intent2.putExtra("source_id", i16);
        intent2.putExtra("sub_source_id", i17);
        if (bArr != null) {
            intent2.putExtra("third_source_id", bArr);
        }
        intent2.putExtra("is_from_game", ax.N);
        ax.N = null;
        intent2.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, !TextUtils.isEmpty(str3) ? ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).getRemark(str3) : str3);
        if (str8 != null && str4.length() > 30) {
            str8 = str8.substring(0, 28);
        }
        intent2.putExtra("msg", str8);
        intent2.putExtra("param_return_addr", str5);
        intent2.putExtra("last_activity", str6);
        intent2.putExtra("src_name", str7);
        if (bArr2 != null) {
            intent2.putExtra("flc_add_frd_token", bArr2);
        }
        if (i16 == 3999) {
            HashMap<String, String> hashMap = new HashMap<>(4);
            hashMap.put(EventKey.ACT, context.getClass().getSimpleName());
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            hashMap.put("top", qBaseActivity == null ? "null" : qBaseActivity.toString());
            if ((context instanceof Activity) && (intent = ((Activity) context).getIntent()) != null) {
                hashMap.put("intent", intent.toString());
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    hashMap.put("extra", extras.toString());
                }
            }
            StatisticCollector.getInstance(context).collectPerformance(null, "addFriendSource", true, 0L, 0L, hashMap, null);
        }
        if (QLog.isColorLevel()) {
            QLog.d("AddFriendCheckFragment", 2, "startAddFriend Extras = " + intent2.getExtras().toString());
        }
        if (QLog.isDebugVersion()) {
            QLog.d("addfriend", 2, "source =  " + i16 + "subSource= " + i17);
        }
        return intent2;
    }

    private void mi(Intent intent) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (com.tencent.mobileqq.pad.e.a() == SplitViewState.STATE_FLAT && !Xh(activity, intent)) {
            QLog.i("AddFriendCheckFragment", 1, "startAddFriendVerifyFragment QFragmentContainerManager.currentSplitViewState() == SplitViewState.STATE_FLAT is true");
            ei(activity, intent);
            return;
        }
        QLog.i("AddFriendCheckFragment", 1, "startAddFriendVerifyFragment QFragmentContainerManager.currentSplitViewState() == SplitViewState.STATE_FLAT is false");
        if (Rh().getStringExtra("param_return_addr") != null) {
            QPublicFragmentActivity.start(getActivity(), intent, AddFriendVerifyFragment.class);
            activity.finish();
        } else {
            QPublicFragmentActivity.startForResult(getActivity(), intent, (Class<? extends QPublicBaseFragment>) AddFriendVerifyFragment.class, 1);
        }
    }

    public static Intent ni(Context context, List<PhoneContact> list, int i3, String str, String str2, String str3, int i16) {
        Intent intent = new Intent();
        intent.putExtra("k_uin_type", 2);
        intent.putExtra("contacts", (Serializable) list);
        intent.putExtra("source_id", i3);
        if (str != null && str.length() > 30) {
            str = str.substring(0, 28);
        }
        intent.putExtra("msg", str);
        intent.putExtra("last_activity", str2);
        intent.putExtra("src_name", str3);
        intent.putExtra("contact_from_type", i16);
        if (QLog.isColorLevel()) {
            QLog.d("AddFriendCheckFragment", 2, "startMultiAddFriend Extras = " + intent.getExtras().toString());
        }
        return intent;
    }

    private void showProgress() {
        if (Wh()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendCheckFragment", 2, "showProgress");
        }
        if (!getActivity().isFinishing()) {
            if (this.K == null) {
                QQProgressDialog qQProgressDialog = new QQProgressDialog(getActivity(), getQBaseActivity().getTitleBarHeight());
                this.K = qQProgressDialog;
                qQProgressDialog.O(new b());
            }
            this.K.setMessage(R.string.bj_);
            this.K.getWindow().setDimAmount(0.0f);
            this.K.show();
        }
    }

    void Oh() {
        doCallback(10001, "");
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            if (AppSetting.t(activity)) {
                QBaseActivity qBaseActivity = getQBaseActivity();
                if (qBaseActivity != null) {
                    m.e(qBaseActivity);
                    return;
                }
                return;
            }
            activity.finish();
            return;
        }
        QLog.e("AddFriendCheckFragment", 1, "executeFinish is error! activity is invalid!");
    }

    public void ai(String str, String str2, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, activity);
            return;
        }
        if (activity != null && Rh() != null) {
            AllInOne allInOne = new AllInOne(str, 1);
            allInOne.profileEntryType = 115;
            String stringExtra = Rh().getStringExtra("src_name");
            int intExtra = Rh().getIntExtra("source_id", BuddySource.DEFAULT);
            String stringExtra2 = Rh().getStringExtra(ISchemeApi.KEY_IOS_SRC_TYPE);
            String stringExtra3 = Rh().getStringExtra("extra");
            String stringExtra4 = Rh().getStringExtra("pkg_name");
            Intent intent = ProfileUtils.getIntent(activity, allInOne);
            intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne);
            intent.putExtra("src_name", stringExtra);
            intent.putExtra("source_id", intExtra);
            intent.putExtra("extra", stringExtra3);
            intent.putExtra("pkg_name", stringExtra4);
            intent.addFlags(536870912);
            if (hi(stringExtra2, intExtra, str2, stringExtra3)) {
                intent.putExtra(IProfileCardConst.KEY_FROM_APP_SHOW_DIALOG, true);
            }
            intent.addFlags(268435456);
            activity.startActivity(intent);
        }
    }

    protected void ii() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (Wh()) {
            return;
        }
        QQCustomDialog qQCustomDialog = this.W;
        if (qQCustomDialog != null && !qQCustomDialog.isShowing() && !getActivity().isFinishing()) {
            this.W.show();
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 230);
        this.W = createCustomDialog;
        createCustomDialog.setMessage(R.string.d65);
        this.W.setTitle(R.string.b1v);
        d dVar = new d();
        this.W.setNegativeButton(R.string.cancel, dVar);
        this.W.setPositiveButton(R.string.d5b, dVar);
        if (!getActivity().isFinishing()) {
            this.W.show();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    void oi(int i3, boolean z16, ArrayList<String> arrayList, int i16) {
        if (Wh()) {
            return;
        }
        this.L = i3;
        if (this.J == 3024 && i3 == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendCheckFragment", 2, "startVerifyActivity() from applets add friend and friendSetting is 0 ");
            }
            if (NetworkUtil.isNetSupport(getActivity())) {
                ((IFriendHandlerService) this.C.getRuntimeService(IFriendHandlerService.class, "")).requestAddFriend(this.H, this.I, i3, (byte) 0, "", this.J, Rh().getIntExtra("sub_source_id", 0), false, null, false, null, this.N, Rh().getBundleExtra("flc_extra_param"), false);
                return;
            } else {
                QQToast.makeText(this.C.getApplication(), R.string.f171139ci4, 0).show(getQBaseActivity().getTitleBarHeight());
                return;
            }
        }
        Intent intent = new Intent();
        intent.putExtras(Rh());
        intent.putExtra("param_mode", 0);
        intent.putExtra("friend_setting", i3);
        intent.putExtra("contact_bothway", z16);
        intent.putExtra("user_question", arrayList);
        intent.putExtra("sort_id", this.J);
        intent.putExtra("extra", this.I);
        intent.putExtra("flc_add_frd_token", this.U);
        intent.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, this.R);
        ArrayList<com.tencent.mobileqq.addfriend.processor.a> arrayList2 = this.S;
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<com.tencent.mobileqq.addfriend.processor.a> it = this.S.iterator();
            while (it.hasNext()) {
                it.next().a(intent, getActivity(), this.H, i16);
            }
        }
        mi(intent);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (Wh()) {
            return;
        }
        Intent Rh = Rh();
        if (Rh != null) {
            z16 = Rh.getBooleanExtra("need_result_uin", false);
        }
        if (z16) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra("uin", this.H);
        }
        getActivity().setResult(i16, intent);
        getActivity().finish();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        Uh();
        this.C = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        this.S = new com.tencent.mobileqq.addfriend.helper.a().a(this.C);
        if (Wh()) {
            return;
        }
        this.T = this.C.getCurrentUin();
        Intent Rh = Rh();
        this.G = Rh.getIntExtra("k_uin_type", 0);
        this.H = Rh.getStringExtra("uin");
        this.M = Rh.getStringExtra("last_activity");
        this.N = Rh.getStringExtra("src_name");
        this.R = Rh.getIntExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, -1);
        this.U = Rh.getByteArrayExtra("flc_add_frd_token");
        String str = this.H;
        if (str != null && str.length() >= 5) {
            this.F = hashCode();
            if (this.G == 4) {
                QLog.e("AddFriendCheckFragment", 1, "AddFriendCheckFragment call error");
                return;
            } else {
                Kh();
                return;
            }
        }
        int intExtra = Rh.getIntExtra("source_id", BuddySource.DEFAULT);
        this.J = intExtra;
        if (intExtra != 3078 && intExtra != 3079) {
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendCheckFragment", 2, "uin should not be null, activity finish");
            }
            getActivity().finish();
            return;
        }
        di();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Nh(false);
        com.tencent.mobileqq.friend.observer.a aVar = this.Z;
        if (aVar != null) {
            this.C.removeObserver(aVar);
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("add_friend_openid_opt", false);
        QLog.i("AddFriendCheckFragment", 1, "onDestroy add_friend_openid_opt switch: " + isSwitchOn);
        if (isSwitchOn) {
            gi("");
        }
        super.onDestroy();
    }
}
