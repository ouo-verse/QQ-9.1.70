package com.tencent.mobileqq.addfriend.ui.fornt.check.part;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.selectmember.api.IForwardApi;
import com.tencent.mobileqq.addfriend.config.AddFriendOpenSdkConfigParser;
import com.tencent.mobileqq.addfriend.handler.NTAddFriendHandler;
import com.tencent.mobileqq.addfriend.ui.fornt.AddFriendForNtLauncher;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.pad.m;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.QQToastUtil;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.MobileQQ;

/* loaded from: classes10.dex */
public class AddFriendSettingPart extends com.tencent.mobileqq.addfriend.ui.fornt.check.part.a {
    static IPatchRedirector $redirector_;
    private com.tencent.mobileqq.addfriend.part.b K;
    private ArrayList<com.tencent.mobileqq.addfriend.processor.a> L;
    com.tencent.mobileqq.addfriend.observer.a M;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a implements uc1.b<Friends> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f187471a;

        a(String str) {
            this.f187471a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendSettingPart.this, (Object) str);
            }
        }

        @Override // uc1.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Friends friends) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) friends);
                return;
            }
            Context context = AddFriendSettingPart.this.getContext();
            if (context != null && friends != null) {
                long parseLong = Long.parseLong(this.f187471a);
                String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f187471a);
                QLog.i("AddFriendSettingPart", 1, "jumpToFriendChat uid: " + uidFromUin);
                if (!TextUtils.isEmpty(uidFromUin)) {
                    if (TextUtils.isEmpty(friends.name)) {
                        str = "";
                    } else {
                        str = friends.name;
                    }
                    ((IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class)).navigateToAIOActivity(context, 1, uidFromUin, str, parseLong, new Bundle());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendSettingPart.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                AddFriendSettingPart.this.O9(10001);
            }
        }
    }

    public AddFriendSettingPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.M = new com.tencent.mobileqq.addfriend.observer.a() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.check.part.AddFriendSettingPart.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AddFriendSettingPart.this);
                    }
                }

                private void k(String str, String str2) {
                    com.tencent.relation.common.report.a.c("relation_addfriend_page_showtime", System.currentTimeMillis() - AddFriendSettingPart.this.C9().getLongExtra("startAddFriendCheckFragment", 0L), false, l("101"));
                    AddFriendSettingPart addFriendSettingPart = AddFriendSettingPart.this;
                    int i3 = addFriendSettingPart.f187477h;
                    if (i3 == 1) {
                        if (addFriendSettingPart.B9() != null) {
                            ThreadManagerV2.post(new Runnable(str2) { // from class: com.tencent.mobileqq.addfriend.ui.fornt.check.part.AddFriendSettingPart.1.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ String f187469d;

                                {
                                    this.f187469d = str2;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) str2);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                    } else {
                                        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).addFriendToFriendList(AddFriendSettingPart.this.B9(), this.f187469d, 0, BuddySource.DEFAULT, "", true, false, -1L);
                                    }
                                }
                            }, 8, null, true);
                        }
                    } else if (i3 == 2) {
                        ((IPhoneContactService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IPhoneContactService.class, "")).onFriendListChanged();
                    }
                    if (AddFriendSettingPart.this.C9().getBooleanExtra("webim_qd_ext", false) && !TextUtils.isEmpty(str)) {
                        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).jumpToQidianProfile(str, AddFriendSettingPart.this.getActivity());
                        AddFriendSettingPart.this.getActivity().setResult(-1);
                        AddFriendSettingPart.this.getActivity().finish();
                    } else {
                        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                            AddFriendSettingPart.this.Q9(str);
                            return;
                        }
                        AddFriendSettingPart addFriendSettingPart2 = AddFriendSettingPart.this;
                        addFriendSettingPart2.P9(-1, addFriendSettingPart2.getString(R.string.f170332ml));
                        QQToast.makeText(BaseApplication.getContext(), AddFriendSettingPart.this.getString(R.string.f170332ml), 0).show(AddFriendSettingPart.this.D9().getTitleBarHeight());
                        AddFriendSettingPart.this.getActivity().setResult(-1);
                        AddFriendSettingPart.this.O9(10003);
                    }
                }

                private HashMap<String, String> l(String str) {
                    return new HashMap<String, String>(str, AddFriendSettingPart.this.C9().getIntExtra("source_id", BuddySource.DEFAULT), AddFriendSettingPart.this.C9().getIntExtra("sub_source_id", 0)) { // from class: com.tencent.mobileqq.addfriend.ui.fornt.check.part.AddFriendSettingPart.1.2
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
                                iPatchRedirector2.redirect((short) 1, this, AnonymousClass1.this, str, Integer.valueOf(r7), Integer.valueOf(r8));
                                return;
                            }
                            put("errorCode", str);
                            put("sourceid", String.valueOf(r7));
                            put("subsourceid", String.valueOf(r8));
                        }
                    };
                }

                @Override // com.tencent.mobileqq.addfriend.observer.a
                protected void i(boolean z16, Bundle bundle) {
                    String str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                        return;
                    }
                    if (AddFriendSettingPart.this.G9()) {
                        return;
                    }
                    String string = bundle.getString("uin");
                    if (!AddFriendSettingPart.this.f187478i.equals(string)) {
                        return;
                    }
                    int i3 = bundle.getInt("random_key");
                    if (i3 != 0 && i3 != AddFriendSettingPart.this.J) {
                        QLog.i("AddFriendSettingPart", 1, String.format("onUpdateAddFriendSetting [uin:%s, key:%s, ranKey:%s, isSuc:%s]", string, Integer.valueOf(i3), Integer.valueOf(AddFriendSettingPart.this.J), Boolean.valueOf(z16)));
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("AddFriendSettingPart", 2, String.format("onUpdateAddFriendSetting [uin:%s, key:%s, isSuc:%s]", Utils.U(string), Integer.valueOf(i3), Boolean.valueOf(z16)));
                    }
                    AddFriendSettingPart.this.x9(false);
                    if (!z16) {
                        AddFriendSettingPart.this.P9(-1, HardCodeUtil.qqStr(R.string.h1y));
                        com.tencent.relation.common.report.a.c("relation_addfriend_page_showtime", System.currentTimeMillis() - AddFriendSettingPart.this.C9().getLongExtra("startAddFriendCheckFragment", 0L), false, l("-1"));
                        QQToast.makeText(BaseApplication.getContext(), R.string.h1y, 0).show(AddFriendSettingPart.this.D9().getTitleBarHeight());
                        AddFriendSettingPart.this.getActivity().finish();
                        return;
                    }
                    int i16 = bundle.getInt("friend_setting");
                    ArrayList<String> stringArrayList = bundle.getStringArrayList("user_question");
                    Boolean valueOf = Boolean.valueOf(bundle.getBoolean("contact_bothway"));
                    try {
                        str = Long.toString(bundle.getLong("query_friend_uin"));
                    } catch (Exception unused) {
                        QLog.i("AddFriendSettingPart", 1, "uin parse error");
                        str = null;
                    }
                    if (valueOf.booleanValue() && i16 != 0) {
                        AddFriendSettingPart addFriendSettingPart = AddFriendSettingPart.this;
                        if (addFriendSettingPart.C == 3006) {
                            addFriendSettingPart.C9().putExtra("sub_source_id", 2);
                        }
                        AddFriendSettingPart.this.W9(i16, valueOf.booleanValue(), stringArrayList, AddFriendSettingPart.this.C);
                        return;
                    }
                    if (i16 != 0 && i16 != 1) {
                        if (i16 != 2) {
                            if (i16 != 3 && i16 != 4) {
                                if (i16 != 101) {
                                    AddFriendSettingPart.this.P9(-1, HardCodeUtil.qqStr(R.string.h1y));
                                    QQToast.makeText(BaseApplication.getContext(), R.string.h1y, 0).show(AddFriendSettingPart.this.D9().getTitleBarHeight());
                                    com.tencent.relation.common.report.a.c("relation_addfriend_page_showtime", System.currentTimeMillis() - AddFriendSettingPart.this.C9().getLongExtra("startAddFriendCheckFragment", 0L), false, l("-1"));
                                    AddFriendSettingPart.this.getActivity().finish();
                                    return;
                                }
                                k(str, string);
                                return;
                            }
                        } else {
                            com.tencent.relation.common.report.a.c("relation_addfriend_page_showtime", System.currentTimeMillis() - AddFriendSettingPart.this.C9().getLongExtra("startAddFriendCheckFragment", 0L), false, l("2"));
                            AddFriendSettingPart addFriendSettingPart2 = AddFriendSettingPart.this;
                            addFriendSettingPart2.P9(-1, addFriendSettingPart2.getString(R.string.h0a));
                            if (!AddFriendOpenSdkConfigParser.c(AddFriendSettingPart.this.C)) {
                                AddFriendSettingPart.this.V9();
                                return;
                            } else {
                                QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.h0a));
                                return;
                            }
                        }
                    }
                    AddFriendSettingPart.this.W9(i16, valueOf.booleanValue(), stringArrayList, AddFriendSettingPart.this.C);
                }
            };
        }
    }

    private void M9() {
        AppInterface B9 = B9();
        if (B9 == null) {
            return;
        }
        B9.addObserver(this.M);
    }

    private void N9(int i3, String str) {
        com.tencent.mobileqq.addfriend.part.b bVar = this.K;
        if (bVar != null) {
            bVar.L1(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P9(int i3, String str) {
        if (G9()) {
            return;
        }
        N9(10001, str);
        if (C9() != null) {
            if (C9().getIntExtra("source_id", BuddySource.DEFAULT) == 3090) {
                try {
                    ((IForwardApi) QRoute.api(IForwardApi.class)).startGameSdkCallback(getActivity(), true, "action_game_make_friend", Long.parseLong(C9().getStringExtra("extra")), i3, str);
                    return;
                } catch (Exception e16) {
                    QLog.e("AddFriendSettingPart", 1, "feedBackToGameSDK error = " + e16);
                    return;
                }
            }
            return;
        }
        QLog.e("AddFriendSettingPart", 1, "feedBackToGameSDK intent = null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q9(String str) {
        if (AddFriendOpenSdkConfigParser.c(this.C)) {
            S9(str);
        } else {
            T9(str, this.F, getActivity());
        }
        AddFriendForNtLauncher.uh(true);
        getActivity().setResult(-1);
        getActivity().finish();
    }

    private void R9() {
        this.K = (com.tencent.mobileqq.addfriend.part.b) getViewModel(com.tencent.mobileqq.addfriend.part.b.class);
    }

    private void S9(String str) {
        try {
            ((IFriendDataService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFriendDataService.class, "")).getFriend(str, new a(str));
        } catch (NumberFormatException e16) {
            QLog.e("AddFriendSettingPart", 1, e16, new Object[0]);
        }
        QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.f197554kb));
    }

    private boolean U9(String str, int i3, String str2, String str3) {
        if ("app".equals(str)) {
            if ((3016 == i3 || 3103 == i3) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V9() {
        if (G9()) {
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendSettingPart", 2, "showRefuseAddFriendDialog is finishing return");
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
        createCustomDialog.setPositiveButton(R.string.f171151ok, new b()).setNegativeButton((String) null, (DialogInterface.OnClickListener) null).show();
    }

    void O9(int i3) {
        com.tencent.mobileqq.addfriend.part.b bVar = this.K;
        if (bVar != null) {
            bVar.L1(i3, "");
        }
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            if (AppSetting.t(activity)) {
                Activity activity2 = getActivity();
                if (activity2 != null) {
                    m.e(activity2);
                    return;
                }
                return;
            }
            activity.finish();
            return;
        }
        QLog.e("AddFriendSettingPart", 1, "executeFinish is error! activity is invalid!");
    }

    public void T9(String str, String str2, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, activity);
            return;
        }
        if (activity != null && C9() != null) {
            AllInOne allInOne = new AllInOne(str, 1);
            allInOne.profileEntryType = 115;
            String stringExtra = C9().getStringExtra("src_name");
            int intExtra = C9().getIntExtra("source_id", BuddySource.DEFAULT);
            String stringExtra2 = C9().getStringExtra(ISchemeApi.KEY_IOS_SRC_TYPE);
            String stringExtra3 = C9().getStringExtra("extra");
            String stringExtra4 = C9().getStringExtra("pkg_name");
            Intent intent = ProfileUtils.getIntent(activity, allInOne);
            intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne);
            intent.putExtra("src_name", stringExtra);
            intent.putExtra("source_id", intExtra);
            intent.putExtra("extra", stringExtra3);
            intent.putExtra("pkg_name", stringExtra4);
            intent.addFlags(536870912);
            if (U9(stringExtra2, intExtra, str2, stringExtra3)) {
                intent.putExtra(IProfileCardConst.KEY_FROM_APP_SHOW_DIALOG, true);
            }
            intent.addFlags(268435456);
            activity.startActivity(intent);
        }
    }

    void W9(int i3, boolean z16, ArrayList<String> arrayList, int i16) {
        if (G9()) {
            return;
        }
        this.D = i3;
        if (this.C == 3024 && i3 == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendSettingPart", 2, "startVerifyActivity() from applets add friend and friendSetting is 0 ");
            }
            if (NetworkUtil.isNetSupport(getActivity())) {
                int intExtra = C9().getIntExtra("sub_source_id", 0);
                NTAddFriendHandler nTAddFriendHandler = this.f187474d;
                if (nTAddFriendHandler != null) {
                    nTAddFriendHandler.I2(this.f187475e, this.f187478i, this.f187479m, i3, 0, "", this.C, intExtra, false, null, false, null, this.F, C9().getBundleExtra("flc_extra_param"), false);
                    return;
                }
                return;
            }
            QQToast.makeText(getContext().getApplicationContext(), R.string.f171139ci4, 0).show(D9().getTitleBarHeight());
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(C9());
        intent.putExtra("param_mode", 0);
        intent.putExtra("friend_setting", i3);
        intent.putExtra("contact_bothway", z16);
        intent.putExtra("user_question", arrayList);
        intent.putExtra("sort_id", this.C);
        intent.putExtra("extra", this.f187479m);
        intent.putExtra("flc_add_frd_token", this.I);
        intent.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, this.H);
        ArrayList<com.tencent.mobileqq.addfriend.processor.a> arrayList2 = this.L;
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<com.tencent.mobileqq.addfriend.processor.a> it = this.L.iterator();
            while (it.hasNext()) {
                it.next().a(intent, getActivity(), this.f187478i, i16);
            }
        }
        I9(intent);
    }

    @Override // com.tencent.mobileqq.addfriend.ui.fornt.check.part.a, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
            return;
        }
        super.onPartCreate(activity, bundle);
        R9();
        M9();
        this.L = new com.tencent.mobileqq.addfriend.helper.a().a(com.tencent.mobileqq.addfriend.utils.a.f());
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        AppInterface B9;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        if (this.M != null && (B9 = B9()) != null) {
            B9.removeObserver(this.M);
        }
    }
}
