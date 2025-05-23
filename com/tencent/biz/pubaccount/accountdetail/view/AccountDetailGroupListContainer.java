package com.tencent.biz.pubaccount.accountdetail.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.accountdetail.jce.GetRecvMsgStateReq;
import com.tencent.biz.pubaccount.accountdetail.jce.SetRecvMsgStateRsp;
import com.tencent.biz.pubaccount.accountdetail.model.AccountDetailBaseInfoModel;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountObserverImpl;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.applets.c;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.e;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ad;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import ff0.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x487.oidb_0x487$GroupList;
import tencent.im.oidb.cmd0x487.oidb_0x487$ReqBody;
import tencent.im.oidb.cmd0x487.oidb_0x487$RspBody;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AccountDetailGroupListContainer {

    /* renamed from: a, reason: collision with root package name */
    WeakReference<BaseActivity> f79155a;

    /* renamed from: b, reason: collision with root package name */
    QQAppInterface f79156b;

    /* renamed from: c, reason: collision with root package name */
    View f79157c;

    /* renamed from: d, reason: collision with root package name */
    View f79158d;

    /* renamed from: e, reason: collision with root package name */
    LinearLayout f79159e;

    /* renamed from: f, reason: collision with root package name */
    PublicAccountDetailImpl f79160f;

    /* renamed from: g, reason: collision with root package name */
    String f79161g;

    /* renamed from: h, reason: collision with root package name */
    boolean f79162h;

    /* renamed from: k, reason: collision with root package name */
    TextView f79165k;

    /* renamed from: l, reason: collision with root package name */
    TextView f79166l;

    /* renamed from: n, reason: collision with root package name */
    float f79168n;

    /* renamed from: t, reason: collision with root package name */
    protected PublicAccountObserverImpl f79174t;

    /* renamed from: w, reason: collision with root package name */
    protected MqqHandler f79177w;

    /* renamed from: i, reason: collision with root package name */
    boolean f79163i = true;

    /* renamed from: j, reason: collision with root package name */
    int f79164j = -1;

    /* renamed from: m, reason: collision with root package name */
    IPublicAccountConfigAttr.a f79167m = null;

    /* renamed from: o, reason: collision with root package name */
    boolean f79169o = true;

    /* renamed from: p, reason: collision with root package name */
    protected ArrayList<String> f79170p = new ArrayList<>();

    /* renamed from: q, reason: collision with root package name */
    protected boolean f79171q = false;

    /* renamed from: r, reason: collision with root package name */
    protected boolean f79172r = false;

    /* renamed from: s, reason: collision with root package name */
    protected ViewGroup f79173s = null;

    /* renamed from: u, reason: collision with root package name */
    protected com.tencent.mobileqq.applets.c f79175u = null;

    /* renamed from: v, reason: collision with root package name */
    SharedPreferences f79176v = null;

    /* renamed from: x, reason: collision with root package name */
    PhotoWallViewForAccountDetail.c f79178x = new a();

    /* renamed from: y, reason: collision with root package name */
    boolean f79179y = false;

    /* renamed from: z, reason: collision with root package name */
    protected com.tencent.mobileqq.avatar.observer.a f79180z = new l();
    protected Handler.Callback A = new r();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer$14, reason: invalid class name */
    /* loaded from: classes32.dex */
    public class AnonymousClass14 implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IPublicAccountConfigAttr.a f79181d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f79182e;

        AnonymousClass14(IPublicAccountConfigAttr.a aVar, ActionSheet actionSheet) {
            this.f79181d = aVar;
            this.f79182e = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            AccountDetailGroupListContainer accountDetailGroupListContainer = AccountDetailGroupListContainer.this;
            if (accountDetailGroupListContainer.f79179y) {
                return;
            }
            final int i16 = 1;
            accountDetailGroupListContainer.f79179y = true;
            if (i3 + 1 == 1) {
                if (AppConstants.KANDIAN_DAILY_UIN.equals(accountDetailGroupListContainer.f79161g)) {
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009947", "0X8009947", 0, 0, "", "", "", "", false);
                }
            } else {
                if (AppConstants.KANDIAN_DAILY_UIN.equals(accountDetailGroupListContainer.f79161g)) {
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009943", "0X8009943", 0, 0, "", "", "", "", false);
                }
                i16 = 3;
            }
            AccountDetailGroupListContainer accountDetailGroupListContainer2 = AccountDetailGroupListContainer.this;
            accountDetailGroupListContainer2.f79156b.removeObserver(accountDetailGroupListContainer2.f79175u);
            AccountDetailGroupListContainer.this.f79175u = new com.tencent.mobileqq.applets.c(new c.a() { // from class: com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.14.1
                @Override // com.tencent.mobileqq.applets.c.a
                public void b(boolean z16, Object obj) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AccountDetailGroupListContainer", 2, "success:" + z16);
                    }
                }

                @Override // com.tencent.mobileqq.applets.c.a
                public void c(Object obj) {
                    AccountDetailGroupListContainer.this.J(R.string.d6b);
                }

                @Override // com.tencent.mobileqq.applets.c.a
                public void d(Object obj) {
                    if (obj instanceof ArrayList) {
                        Iterator it = ((ArrayList) obj).iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof AppletItem) && ((AppletItem) next).f().equals(AccountDetailGroupListContainer.this.f79161g)) {
                                AnonymousClass14 anonymousClass14 = AnonymousClass14.this;
                                anonymousClass14.f79181d.f79334f = i16;
                                IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) AccountDetailGroupListContainer.this.f79156b.getRuntimeService(IPublicAccountDataManager.class, "all");
                                final PublicAccountDetailImpl publicAccountDetailImpl = iPublicAccountDataManager != null ? (PublicAccountDetailImpl) iPublicAccountDataManager.findAccountDetailInfo(AccountDetailGroupListContainer.this.f79161g) : null;
                                if (publicAccountDetailImpl != null) {
                                    IPublicAccountConfigAttr.a aVar = AnonymousClass14.this.f79181d;
                                    int i17 = aVar.f79335g;
                                    if (i17 == 6) {
                                        int i18 = i16;
                                        if (i18 == 1) {
                                            publicAccountDetailImpl.mShowMsgFlag = i18;
                                        }
                                    } else if (i17 == 3) {
                                        publicAccountDetailImpl.isSyncLbs = true;
                                        publicAccountDetailImpl.isAgreeSyncLbs = aVar.f79334f == 1;
                                    }
                                    ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.14.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (QLog.isColorLevel()) {
                                                QLog.d("AccountDetailGroupListContainer", 2, "saveAccountDetailInSubThread");
                                            }
                                            AccountDetailBaseInfoModel.a(AccountDetailGroupListContainer.this.f79156b, publicAccountDetailImpl);
                                        }
                                    }, 10L);
                                    AnonymousClass14 anonymousClass142 = AnonymousClass14.this;
                                    AccountDetailGroupListContainer.this.Z(anonymousClass142.f79181d);
                                    IPublicAccountUtil iPublicAccountUtil = (IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class);
                                    QQAppInterface qQAppInterface = AccountDetailGroupListContainer.this.f79156b;
                                    iPublicAccountUtil.sendDetailInfoRequest(qQAppInterface, qQAppInterface.getApplication(), AccountDetailGroupListContainer.this.f79161g);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    c(obj);
                }

                @Override // com.tencent.mobileqq.applets.c.a
                public int e() {
                    return 7;
                }

                @Override // com.tencent.mobileqq.applets.c.a
                public void a(boolean z16, Object obj) {
                }
            });
            AccountDetailGroupListContainer accountDetailGroupListContainer3 = AccountDetailGroupListContainer.this;
            accountDetailGroupListContainer3.f79156b.addObserver(accountDetailGroupListContainer3.f79175u);
            AccountDetailGroupListContainer accountDetailGroupListContainer4 = AccountDetailGroupListContainer.this;
            QQAppInterface qQAppInterface = accountDetailGroupListContainer4.f79156b;
            PublicAccountDetailImpl publicAccountDetailImpl = accountDetailGroupListContainer4.f79160f;
            com.tencent.mobileqq.applets.e.e(qQAppInterface, publicAccountDetailImpl.uin, publicAccountDetailImpl.name, i3);
            this.f79182e.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private class aa extends IPublicAccountObserver.c {

        /* renamed from: a, reason: collision with root package name */
        private AccountDetailGroupListContainer f79189a;

        public aa(AccountDetailGroupListContainer accountDetailGroupListContainer) {
            this.f79189a = accountDetailGroupListContainer;
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onSetRecvMsgState(boolean z16, Object obj) {
            SetRecvMsgStateRsp setRecvMsgStateRsp = (SetRecvMsgStateRsp) obj;
            if (QLog.isColorLevel()) {
                QLog.d("AccountDetailGroupListContainer", 2, "onGetRecvMsgState isSuccess = " + z16);
            }
            if (z16 && setRecvMsgStateRsp.result == 0) {
                AccountDetailGroupListContainer accountDetailGroupListContainer = AccountDetailGroupListContainer.this;
                accountDetailGroupListContainer.a0(accountDetailGroupListContainer.f79164j);
                SharedPreferences sharedPreferences = AccountDetailGroupListContainer.this.f79176v;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt(PublicAccountHandlerImpl.KEY_SETTING_STATUS_PRE + AccountDetailGroupListContainer.this.f79160f.uin + "_" + AccountDetailGroupListContainer.this.f79156b.getCurrentAccountUin(), AccountDetailGroupListContainer.this.f79164j).commit();
                }
            }
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onDestroy() {
            this.f79189a = null;
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onUpdateFunctionFlag(boolean z16, IPublicAccountConfigAttr.a aVar) {
            AccountDetailGroupListContainer accountDetailGroupListContainer;
            if (z16 && aVar != null) {
                int i3 = aVar.f79335g;
                if (i3 != 3 && i3 == 6 && (accountDetailGroupListContainer = this.f79189a) != null) {
                    accountDetailGroupListContainer.Z(aVar);
                }
                IPublicAccountUtil iPublicAccountUtil = (IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class);
                QQAppInterface qQAppInterface = AccountDetailGroupListContainer.this.f79156b;
                iPublicAccountUtil.sendDetailInfoRequest(qQAppInterface, qQAppInterface.getApplication(), AccountDetailGroupListContainer.this.f79161g);
                return;
            }
            AccountDetailGroupListContainer accountDetailGroupListContainer2 = this.f79189a;
            if (accountDetailGroupListContainer2 != null) {
                accountDetailGroupListContainer2.J(R.string.d6b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccountDetailGroupListContainer accountDetailGroupListContainer = AccountDetailGroupListContainer.this;
            accountDetailGroupListContainer.d0(accountDetailGroupListContainer.f79164j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccountDetailGroupListContainer accountDetailGroupListContainer = AccountDetailGroupListContainer.this;
            IPublicAccountConfigAttr.a aVar = accountDetailGroupListContainer.f79167m;
            accountDetailGroupListContainer.e0(aVar, aVar.f79334f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d implements DialogInterface.OnDismissListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            AccountDetailGroupListContainer.this.f79179y = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e implements DialogInterface.OnDismissListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            AccountDetailGroupListContainer.this.f79179y = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class g implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IPublicAccountConfigAttr.a f79198d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Switch f79199e;

        g(IPublicAccountConfigAttr.a aVar, Switch r36) {
            this.f79198d = aVar;
            this.f79199e = r36;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            AccountDetailGroupListContainer accountDetailGroupListContainer = AccountDetailGroupListContainer.this;
            if (!accountDetailGroupListContainer.f79169o) {
                accountDetailGroupListContainer.f79169o = true;
                return;
            }
            IPublicAccountConfigAttr.a aVar = this.f79198d;
            int i3 = aVar.f79337i;
            if (i3 == 1) {
                accountDetailGroupListContainer.h0(aVar, z16);
            } else if (i3 == 2) {
                if (z16) {
                    accountDetailGroupListContainer.c0(aVar, this.f79199e, z16);
                } else {
                    accountDetailGroupListContainer.h0(aVar, z16);
                }
            } else if (i3 != 3) {
                accountDetailGroupListContainer.h0(aVar, z16);
            } else if (!z16) {
                accountDetailGroupListContainer.c0(aVar, this.f79199e, z16);
            } else {
                accountDetailGroupListContainer.h0(aVar, z16);
            }
            AccountDetailGroupListContainer.this.U(this.f79198d.f79330b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class h implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f79201d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IPublicAccountConfigAttr.a f79202e;

        h(String str, IPublicAccountConfigAttr.a aVar) {
            this.f79201d = str;
            this.f79202e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccountDetailGroupListContainer.this.R(this.f79201d);
            AccountDetailGroupListContainer.this.U(this.f79202e.f79330b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class i implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f79204d;

        i(int i3) {
            this.f79204d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            AccountDetailGroupListContainer accountDetailGroupListContainer = AccountDetailGroupListContainer.this;
            if (accountDetailGroupListContainer.f79171q) {
                accountDetailGroupListContainer.f79172r = true;
                if (this.f79204d == 0) {
                    ReportController.o(accountDetailGroupListContainer.f79156b, "P_CliOper", "Grp_public", "", UploadQualityReportBuilder.STATE_CONNECT, "Clk_num", 0, 0, "", "", "", accountDetailGroupListContainer.f79160f.uin);
                    str = "https://qun.qq.com/qqweb/m/qun/qun_pub_bind/qun2pub.html?_wv=1027&scode=" + AccountDetailGroupListContainer.this.f79161g;
                } else {
                    ReportController.o(accountDetailGroupListContainer.f79156b, "P_CliOper", "Grp_public", "", UploadQualityReportBuilder.STATE_CONNECT, "Clk_grp", 0, 0, "", "", "", accountDetailGroupListContainer.f79160f.uin);
                    str = "https://qun.qq.com/qqweb/m/qun/qun_pub_bind/qunlist.html?_wv=1027&power=1&scode=" + AccountDetailGroupListContainer.this.f79161g;
                }
            } else {
                ReportController.o(accountDetailGroupListContainer.f79156b, "P_CliOper", "Grp_public", "", UploadQualityReportBuilder.STATE_CONNECT, "Clk_grp", 0, 0, "", "", "", accountDetailGroupListContainer.f79160f.uin);
                str = "https://qun.qq.com/qqweb/m/qun/qun_pub_bind/qunlist.html?_wv=1027&scode=" + AccountDetailGroupListContainer.this.f79161g;
            }
            if (QLog.isColorLevel()) {
                QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "jumpTo:" + str);
            }
            AccountDetailGroupListContainer.this.R(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class j implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IPublicAccountConfigAttr.a f79206d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f79207e;

        j(IPublicAccountConfigAttr.a aVar, String str) {
            this.f79206d = aVar;
            this.f79207e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(AccountDetailGroupListContainer.this.f79155a.get(), (Class<?>) QQMapActivity.class);
            intent.putExtra(QCircleSchemeAttr.Polymerize.LAT, this.f79206d.f79341m);
            intent.putExtra("lon", this.f79206d.f79340l);
            if (!TextUtils.isEmpty(this.f79207e)) {
                intent.putExtra("loc", this.f79207e);
            }
            AccountDetailGroupListContainer.this.f79155a.get().startActivity(intent);
            AccountDetailGroupListContainer accountDetailGroupListContainer = AccountDetailGroupListContainer.this;
            ReportController.o(accountDetailGroupListContainer.f79156b, "CliOper", "", "", "Biz_card", "Biz_card_map", 0, 0, accountDetailGroupListContainer.f79161g, "", "", "");
            AccountDetailGroupListContainer.this.U(this.f79206d.f79330b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class k extends ProtoUtils.TroopProtocolObserver {
        k() {
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            int i16;
            List<oidb_0x487$GroupList> list;
            if (QLog.isColorLevel()) {
                QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "onResult, errorCode=" + i3);
            }
            if (i3 == -1 || bArr == null) {
                return;
            }
            try {
                oidb_0x487$RspBody oidb_0x487_rspbody = new oidb_0x487$RspBody();
                oidb_0x487_rspbody.mergeFrom(bArr);
                int i17 = oidb_0x487_rspbody.uint32_result.get();
                String str = "";
                int i18 = 0;
                if (i17 == 0) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    if (!oidb_0x487_rspbody.msg_groups.has() || (list = oidb_0x487_rspbody.msg_groups.get()) == null) {
                        i16 = 0;
                    } else {
                        i16 = list.size();
                        for (int i19 = 0; i19 < i16; i19++) {
                            String str2 = list.get(i19).uint64_groupcode.get() + "";
                            list.get(i19).bytes_group_name.get().toStringUtf8();
                            arrayList.add(str2);
                            if (arrayList.size() >= 3) {
                                break;
                            }
                        }
                    }
                    AccountDetailGroupListContainer.this.f79170p.clear();
                    AccountDetailGroupListContainer.this.f79170p.addAll(arrayList);
                    if (oidb_0x487_rspbody.uint32_privilege_flag.has()) {
                        AccountDetailGroupListContainer.this.f79171q = oidb_0x487_rspbody.uint32_privilege_flag.get() == 1;
                    }
                    com.tencent.mobileqq.troop.utils.z zVar = (com.tencent.mobileqq.troop.utils.z) AccountDetailGroupListContainer.this.f79156b.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("mIsAbleBindTroop", AccountDetailGroupListContainer.this.f79171q);
                    bundle2.putStringArrayList("mBindedTroopUins", arrayList);
                    zVar.i(AccountDetailGroupListContainer.this.f79161g, bundle2);
                    AccountDetailGroupListContainer.this.i0();
                    i18 = i16;
                }
                if (QLog.isColorLevel()) {
                    if (oidb_0x487_rspbody.bytes_errmsg.has()) {
                        str = oidb_0x487_rspbody.bytes_errmsg.get().toStringUtf8();
                    }
                    QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "onResult, ret=" + i17 + "," + i18 + "," + str + "," + AccountDetailGroupListContainer.this.f79171q);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("PubAccountMoreInfoActivity.bindTroop", 2, "getBindedTroops, exception=" + e16.toString());
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class l extends com.tencent.mobileqq.avatar.observer.a {
        l() {
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onUpdateTroopHead(boolean z16, String str) {
            ViewGroup viewGroup = AccountDetailGroupListContainer.this.f79173s;
            if (viewGroup == null) {
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = AccountDetailGroupListContainer.this.f79173s.getChildAt(i3);
                if ((childAt.getTag() instanceof String) && (childAt instanceof ImageView) && ((String) childAt.getTag()).equals(str)) {
                    ((ImageView) childAt).setImageDrawable(AccountDetailGroupListContainer.this.f79156b.getTroopFaceDrawable(str));
                    if (QLog.isColorLevel()) {
                        QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "onUpdateTroopHead:" + str);
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class m implements e.a {
        m() {
        }

        @Override // com.tencent.mobileqq.troop.utils.e.a
        public void rg(JSONObject jSONObject, int i3, Bundle bundle) {
            AccountDetailGroupListContainer.this.T(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class n implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Dialog f79212d;

        n(Dialog dialog) {
            this.f79212d = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Dialog dialog = this.f79212d;
            if (dialog == null || !dialog.isShowing() || this.f79212d.getWindow() == null) {
                return;
            }
            this.f79212d.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class o implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f79214d;

        o(String str) {
            this.f79214d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccountDetailGroupListContainer.this.f79155a.get().startActivity(new Intent("android.intent.action.CALL", Uri.parse(WebView.SCHEME_TEL + this.f79214d)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class p implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IPublicAccountConfigAttr.a f79216d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Switch f79217e;

        p(IPublicAccountConfigAttr.a aVar, Switch r36) {
            this.f79216d = aVar;
            this.f79217e = r36;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            AccountDetailGroupListContainer.this.W(this.f79216d, this.f79217e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class r implements Handler.Callback {

        /* compiled from: P */
        /* loaded from: classes32.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AccountDetailGroupListContainer accountDetailGroupListContainer = AccountDetailGroupListContainer.this;
                accountDetailGroupListContainer.d0(accountDetailGroupListContainer.f79164j);
            }
        }

        r() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            AccountDetailGroupListContainer accountDetailGroupListContainer;
            int i3;
            if (message.what != 1000) {
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.i("AccountDetailGroupListContainer", 2, "refresh recent list, from_handle");
            }
            AccountDetailGroupListContainer accountDetailGroupListContainer2 = AccountDetailGroupListContainer.this;
            if (accountDetailGroupListContainer2.f79163i && accountDetailGroupListContainer2.f79157c != null) {
                accountDetailGroupListContainer2.f79176v = accountDetailGroupListContainer2.f79156b.getApp().getSharedPreferences(PublicAccountHandlerImpl.PREF_KEY_SETTING_STATUS_PREFIX, 0);
                SharedPreferences sharedPreferences = AccountDetailGroupListContainer.this.f79176v;
                int i16 = -10000;
                if (sharedPreferences != null) {
                    i16 = sharedPreferences.getInt(PublicAccountHandlerImpl.KEY_SETTING_RESULT_PRE + AccountDetailGroupListContainer.this.f79160f.uin + "_" + AccountDetailGroupListContainer.this.f79156b.getCurrentAccountUin(), -10000);
                    AccountDetailGroupListContainer accountDetailGroupListContainer3 = AccountDetailGroupListContainer.this;
                    accountDetailGroupListContainer3.f79164j = accountDetailGroupListContainer3.f79176v.getInt(PublicAccountHandlerImpl.KEY_SETTING_STATUS_PRE + AccountDetailGroupListContainer.this.f79160f.uin + "_" + AccountDetailGroupListContainer.this.f79156b.getCurrentAccountUin(), -1);
                }
                if (i16 == 0 && (i3 = (accountDetailGroupListContainer = AccountDetailGroupListContainer.this).f79164j) > -1) {
                    accountDetailGroupListContainer.a0(i3);
                    AccountDetailGroupListContainer.this.f79157c.setOnClickListener(new a());
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class s implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f79225d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IPublicAccountConfigAttr.a f79226e;

        s(String str, IPublicAccountConfigAttr.a aVar) {
            this.f79225d = str;
            this.f79226e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccountDetailGroupListContainer.this.f0(this.f79225d);
            AccountDetailGroupListContainer.this.U(this.f79226e.f79330b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class t implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f79228d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IPublicAccountConfigAttr.a f79229e;

        t(String str, IPublicAccountConfigAttr.a aVar) {
            this.f79228d = str;
            this.f79229e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccountDetailGroupListContainer.this.R(this.f79228d);
            AccountDetailGroupListContainer accountDetailGroupListContainer = AccountDetailGroupListContainer.this;
            PublicAccountHandlerImpl.reportClickPublicAccountEventInner(accountDetailGroupListContainer.f79156b, accountDetailGroupListContainer.f79161g, "Grp_tribe", "interest_data", "Clk_msg");
            AccountDetailGroupListContainer.this.U(this.f79229e.f79330b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class u implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IPublicAccountConfigAttr.a f79231d;

        u(IPublicAccountConfigAttr.a aVar) {
            this.f79231d = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("from", AccountDetailGroupListContainer.this.f79155a.getClass().getName());
            RouteUtils.startActivity(AccountDetailGroupListContainer.this.f79155a.get(), intent, "/qrscan/scanner");
            AccountDetailGroupListContainer.this.U(this.f79231d.f79330b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class v implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IPublicAccountConfigAttr.a f79233d;

        v(IPublicAccountConfigAttr.a aVar) {
            this.f79233d = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccountDetailGroupListContainer.this.b0();
            AccountDetailGroupListContainer.this.U(this.f79233d.f79330b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class w implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IPublicAccountConfigAttr.a f79235d;

        w(IPublicAccountConfigAttr.a aVar) {
            this.f79235d = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseActivity baseActivity = AccountDetailGroupListContainer.this.f79155a.get();
            AccountDetailGroupListContainer accountDetailGroupListContainer = AccountDetailGroupListContainer.this;
            String str = accountDetailGroupListContainer.f79161g;
            PublicAccountDetailImpl publicAccountDetailImpl = accountDetailGroupListContainer.f79160f;
            ff0.a.d(baseActivity, new a.b(str, publicAccountDetailImpl.name, publicAccountDetailImpl.summary), 1, AccountDetailGroupListContainer.this.N());
            AccountDetailGroupListContainer.this.U(this.f79235d.f79330b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class x implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IPublicAccountConfigAttr.a f79237d;

        x(IPublicAccountConfigAttr.a aVar) {
            this.f79237d = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseActivity baseActivity = AccountDetailGroupListContainer.this.f79155a.get();
            AccountDetailGroupListContainer accountDetailGroupListContainer = AccountDetailGroupListContainer.this;
            String str = accountDetailGroupListContainer.f79161g;
            PublicAccountDetailImpl publicAccountDetailImpl = accountDetailGroupListContainer.f79160f;
            ff0.a.f(baseActivity, new a.b(str, publicAccountDetailImpl.name, publicAccountDetailImpl.summary), 1, AccountDetailGroupListContainer.this.N());
            AccountDetailGroupListContainer.this.U(this.f79237d.f79330b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class y implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f79239d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IPublicAccountConfigAttr.a f79240e;

        y(int i3, IPublicAccountConfigAttr.a aVar) {
            this.f79239d = i3;
            this.f79240e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseActivity baseActivity = AccountDetailGroupListContainer.this.f79155a.get();
            AccountDetailGroupListContainer accountDetailGroupListContainer = AccountDetailGroupListContainer.this;
            String str = accountDetailGroupListContainer.f79161g;
            PublicAccountDetailImpl publicAccountDetailImpl = accountDetailGroupListContainer.f79160f;
            ff0.a.h(baseActivity, new a.b(str, publicAccountDetailImpl.name, publicAccountDetailImpl.summary), 1, AccountDetailGroupListContainer.this.N(), this.f79239d);
            AccountDetailGroupListContainer.this.U(this.f79240e.f79330b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class z implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f79242d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IPublicAccountConfigAttr.a f79243e;

        z(String str, IPublicAccountConfigAttr.a aVar) {
            this.f79242d = str;
            this.f79243e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccountDetailGroupListContainer.this.R(this.f79242d);
            AccountDetailGroupListContainer.this.U(this.f79243e.f79330b);
        }
    }

    public AccountDetailGroupListContainer(QQAppInterface qQAppInterface, Context context, String str, PublicAccountDetailImpl publicAccountDetailImpl, boolean z16) {
        this.f79162h = false;
        this.f79156b = qQAppInterface;
        this.f79161g = str;
        this.f79155a = new WeakReference<>((BaseActivity) context);
        this.f79160f = publicAccountDetailImpl;
        this.f79162h = z16;
        H();
        PublicAccountObserverImpl publicAccountObserverImpl = new PublicAccountObserverImpl();
        this.f79174t = publicAccountObserverImpl;
        publicAccountObserverImpl.setOnCallback(new aa(this));
        qQAppInterface.addObserver(this.f79174t);
        qQAppInterface.addObserver(this.f79180z);
        PublicAccountDetailImpl publicAccountDetailImpl2 = this.f79160f;
        if (publicAccountDetailImpl2 != null && !TextUtils.isEmpty(publicAccountDetailImpl2.uin) && !TextUtils.isEmpty(qQAppInterface.getCurrentUin())) {
            V(Long.parseLong(this.f79160f.uin), Long.parseLong(qQAppInterface.getCurrentUin()));
        }
        P();
        this.f79177w = new ad(Looper.getMainLooper(), this.A);
        qQAppInterface.setHandler(getClass(), this.f79177w);
    }

    private View A(IPublicAccountConfigAttr.a aVar) {
        View inflate = this.f79155a.get().getLayoutInflater().inflate(R.layout.c4q, (ViewGroup) null);
        Y(inflate, aVar.f79345q);
        ((TextView) inflate.findViewById(R.id.title)).setText(aVar.f79330b);
        ((TextView) inflate.findViewById(R.id.content)).setText(aVar.f79331c);
        inflate.setOnClickListener(new w(aVar));
        return inflate;
    }

    private View B(IPublicAccountConfigAttr.a aVar) {
        View inflate = this.f79155a.get().getLayoutInflater().inflate(R.layout.c4q, (ViewGroup) null);
        Y(inflate, aVar.f79345q);
        ((TextView) inflate.findViewById(R.id.title)).setText(aVar.f79330b);
        ((TextView) inflate.findViewById(R.id.content)).setText(aVar.f79331c);
        inflate.setOnClickListener(new x(aVar));
        return inflate;
    }

    private View C(IPublicAccountConfigAttr.a aVar, int i3) {
        View inflate = this.f79155a.get().getLayoutInflater().inflate(R.layout.c4q, (ViewGroup) null);
        Y(inflate, aVar.f79345q);
        ((TextView) inflate.findViewById(R.id.title)).setText(aVar.f79330b);
        ((TextView) inflate.findViewById(R.id.content)).setText(aVar.f79331c);
        inflate.setOnClickListener(new y(i3, aVar));
        return inflate;
    }

    private View D(IPublicAccountConfigAttr.a aVar) {
        View inflate = this.f79155a.get().getLayoutInflater().inflate(R.layout.c5k, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.content)).setText(aVar.f79331c);
        ((TextView) inflate.findViewById(R.id.title)).setText(aVar.f79330b);
        return inflate;
    }

    private View E(IPublicAccountConfigAttr.a aVar) {
        View inflate = this.f79155a.get().getLayoutInflater().inflate(R.layout.c5j, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.title)).setText(aVar.f79330b);
        Switch r16 = (Switch) inflate.findViewById(R.id.j1r);
        if (aVar.f79334f == 1) {
            r16.setChecked(true);
        } else {
            r16.setChecked(false);
        }
        r16.setOnCheckedChangeListener(new g(aVar, r16));
        return inflate;
    }

    private View F(IPublicAccountConfigAttr.a aVar) {
        if (this.f79162h && aVar.f79330b.contains(HardCodeUtil.qqStr(R.string.f171542j15))) {
            return null;
        }
        View inflate = this.f79155a.get().getLayoutInflater().inflate(R.layout.c4q, (ViewGroup) null);
        Y(inflate, aVar.f79345q);
        String str = aVar.f79336h;
        ((TextView) inflate.findViewById(R.id.title)).setText(aVar.f79330b);
        ((TextView) inflate.findViewById(R.id.content)).setText(aVar.f79331c);
        inflate.setOnClickListener(new h(str, aVar));
        return inflate;
    }

    private ViewGroup G() {
        if (QLog.isColorLevel()) {
            QLog.d("AccountDetailGroupListContainer", 2, "createGroupLayout");
        }
        LinearLayout linearLayout = new LinearLayout(this.f79155a.get());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(int i3) {
        WeakReference<BaseActivity> weakReference = this.f79155a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        Toast.makeText(this.f79155a.get().getApplicationContext(), i3, 0).show();
    }

    private a.b M() {
        if (this.f79160f == null) {
            return null;
        }
        String str = this.f79161g;
        PublicAccountDetailImpl publicAccountDetailImpl = this.f79160f;
        return new a.b(str, publicAccountDetailImpl.name, publicAccountDetailImpl.summary);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String N() {
        int accountType = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getAccountType(this.f79160f.accountFlag);
        if (accountType != -2 && accountType != -5) {
            return "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.f79161g;
        }
        return "https://share.mp.qq.com/cgi/share.php?uin=" + this.f79161g + "&account_flag=" + this.f79160f.accountFlag + "&jumptype=1&card_type=public_account";
    }

    private boolean Q(IPublicAccountConfigAttr.a aVar) {
        int i3;
        if ((aVar.f79329a == 3 && ((i3 = aVar.f79333e) == 3 || i3 == 16 || i3 == 21 || i3 == 13)) || aVar.f79335g == 5) {
            return true;
        }
        return aVar.f79332d == 1 && this.f79160f.followType != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent(this.f79155a.get(), (Class<?>) PublicAccountBrowserImpl.class);
        if (this.f79156b == null || TextUtils.isEmpty(this.f79161g) || TextUtils.isEmpty(this.f79156b.getAccount())) {
            return;
        }
        String replace = str.replace("${puin}", this.f79161g).replace("${uin}", this.f79156b.getAccount());
        intent.putExtra("uin", this.f79156b.getCurrentAccountUin());
        intent.putExtra("url", replace);
        if (QLog.isColorLevel()) {
            QLog.d("AccountDetailGroupListContainer", 2, "jumpWebView url=" + replace);
        }
        intent.putExtra(IPublicAccountBrowser.KEY_PUB_UIN, this.f79161g);
        intent.putExtra("big_brother_source_key", ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getSourceId(this.f79161g));
        String str2 = this.f79160f.name;
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("source_name", str2);
        }
        this.f79155a.get().startActivity(intent);
    }

    private void V(long j3, long j16) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f79156b.getCurrentAccountUin(), IPublicAccountManager.CMD_GET_RECVMSG_STATE);
        GetRecvMsgStateReq getRecvMsgStateReq = new GetRecvMsgStateReq();
        getRecvMsgStateReq.puin = j3;
        getRecvMsgStateReq.uin = j16;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("GetRecvMsgStateReq", getRecvMsgStateReq);
        toServiceMsg.setAttributes(hashMap);
        NewIntent newIntent = new NewIntent(this.f79156b.getApplication(), ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountServlet.class));
        newIntent.putExtra("cmd", IPublicAccountManager.CMD_GET_RECVMSG_STATE);
        newIntent.putExtra("uin", j3);
        newIntent.putExtra(ToServiceMsg.class.getName(), toServiceMsg);
        ((IPublicAccountServlet) QRoute.api(IPublicAccountServlet.class)).configNeedHandler(newIntent);
        this.f79156b.startServlet(newIntent);
    }

    private void Y(View view, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.f165861dq1);
        imageView.setImageDrawable(URLDrawable.getDrawable(str));
        imageView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(IPublicAccountConfigAttr.a aVar) {
        TextView textView = this.f79165k;
        if (textView != null) {
            int i3 = aVar.f79334f;
            if (i3 != 1 && i3 != 2) {
                textView.setText(R.string.f171062c20);
            } else {
                textView.setText(R.string.c1z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(int i3) {
        TextView textView = this.f79165k;
        if (textView == null || this.f79166l == null) {
            return;
        }
        if (i3 == 0) {
            textView.setText(R.string.c1z);
            this.f79166l.setVisibility(8);
        } else if (i3 == 1) {
            textView.setText(R.string.f171063c21);
            this.f79166l.setText(R.string.f171064c22);
            this.f79166l.setVisibility(0);
        } else if (i3 == 2) {
            textView.setText(R.string.c1y);
            this.f79166l.setText(R.string.f171065c23);
            this.f79166l.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        if (this.f79160f == null) {
            return;
        }
        new ff0.a(this.f79156b, this.f79155a.get(), M(), 1, N()).i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(String str) {
        Dialog dialog = new Dialog(this.f79155a.get(), R.style.qZoneInputDialog);
        dialog.setContentView(R.layout.atf);
        ((TextView) dialog.findViewById(R.id.bkh)).setVisibility(8);
        TextView textView = (TextView) dialog.findViewById(R.id.bk8);
        TextView textView2 = (TextView) dialog.findViewById(R.id.bk5);
        TextView textView3 = (TextView) dialog.findViewById(R.id.bka);
        textView.setText(str);
        textView.setGravity(3);
        textView2.setText(R.string.cancel);
        textView3.setText(R.string.ano);
        dialog.setCanceledOnTouchOutside(false);
        textView2.setOnClickListener(new n(dialog));
        textView3.setOnClickListener(new o(str));
        try {
            dialog.show();
        } catch (Exception unused) {
        }
    }

    private void g0(boolean z16, LinearLayout linearLayout, JSONArray jSONArray) {
        int i3;
        int length = jSONArray.length();
        if (length <= 0) {
            return;
        }
        int i16 = 0;
        while (i16 < 3 && (i3 = i16 + 1) <= length) {
            float f16 = this.f79168n;
            int i17 = (int) (6.0f * f16);
            int i18 = (int) (f16 * 32.0f);
            ImageView imageView = new ImageView(this.f79155a.get());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i18, i18);
            if (i16 == 2) {
                i17 = 0;
            }
            layoutParams.setMargins(0, 0, i17, 0);
            imageView.setLayoutParams(layoutParams);
            try {
                if (TextUtils.isEmpty(jSONArray.getString(i16))) {
                    imageView.setImageResource(R.drawable.b9s);
                } else {
                    imageView.setImageDrawable(URLDrawable.getDrawable(jSONArray.getString(i16)));
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            linearLayout.addView(imageView);
            i16 = i3;
        }
    }

    private void k() {
        String str;
        PublicAccountDetailImpl publicAccountDetailImpl = this.f79160f;
        if (publicAccountDetailImpl == null || TextUtils.isEmpty(publicAccountDetailImpl.certifiedEnterprise)) {
            return;
        }
        l(this.f79159e);
        View inflate = this.f79155a.get().getLayoutInflater().inflate(R.layout.f168403v5, (ViewGroup) null);
        if (!TextUtils.isEmpty(this.f79160f.certifiedWeixin)) {
            str = this.f79160f.certifiedWeixin + "\n";
        } else {
            str = "";
        }
        ((TextView) inflate.findViewById(R.id.asw)).setText(str + this.f79160f.certifiedEnterprise);
        this.f79159e.addView(inflate);
    }

    private void l(ViewGroup viewGroup) {
        View view = new View(this.f79155a.get());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (this.f79168n * 0.7d)));
        view.setBackgroundColor(Color.parseColor("#dedfe0"));
        viewGroup.addView(view);
    }

    private void n(ViewGroup viewGroup, List<IPublicAccountConfigAttr.a> list) {
        PhotoWallViewForAccountDetail photoWallViewForAccountDetail = new PhotoWallViewForAccountDetail(this.f79155a.get());
        photoWallViewForAccountDetail.setPhotoWallCallback(this.f79178x);
        photoWallViewForAccountDetail.a(this.f79155a.get(), list);
        photoWallViewForAccountDetail.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        viewGroup.addView(photoWallViewForAccountDetail);
    }

    private boolean p(IPublicAccountConfigAttr iPublicAccountConfigAttr, int i3, int i16, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("AccountDetailGroupListContainer", 2, "addPublicAccountGroup start");
        }
        List<IPublicAccountConfigAttr.a> configs = iPublicAccountConfigAttr.getConfigs();
        if (configs == null) {
            return false;
        }
        ViewGroup G = G();
        if (iPublicAccountConfigAttr.getType() == 1) {
            Iterator<IPublicAccountConfigAttr.a> it = iPublicAccountConfigAttr.getConfigs().iterator();
            while (it.hasNext()) {
                IPublicAccountConfigAttr.a next = it.next();
                if (TextUtils.isEmpty(next.f79339k)) {
                    it.remove();
                } else if (next.f79332d == 1 && this.f79160f.followType != 1) {
                    it.remove();
                }
            }
            if (iPublicAccountConfigAttr.getConfigs().size() < 3) {
                return false;
            }
            n(G, iPublicAccountConfigAttr.getConfigs());
            this.f79159e.addView(G);
            l(this.f79159e);
            return false;
        }
        int size = configs.size();
        if (size <= 0) {
            return true;
        }
        if (i3 > 0 && size > 0 && z16) {
            View view = new View(this.f79155a.get());
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (this.f79168n * 9.0f)));
            view.setBackgroundColor(Color.parseColor("#f0f0f0"));
            G.addView(view);
        }
        int i17 = 0;
        while (i17 < size) {
            o(G, configs.get(i17), size > 1 ? i17 == 0 ? 1 : i17 == size + (-1) ? 2 : 3 : 0);
            i17++;
        }
        this.f79159e.addView(G);
        if (QLog.isColorLevel()) {
            QLog.d("AccountDetailGroupListContainer", 2, "addPublicAccountGroup exit");
        }
        return true;
    }

    private void q() {
        PublicAccountDetailImpl publicAccountDetailImpl = this.f79160f;
        if (publicAccountDetailImpl == null || TextUtils.isEmpty(publicAccountDetailImpl.summary)) {
            return;
        }
        View inflate = this.f79155a.get().getLayoutInflater().inflate(R.layout.f168403v5, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.asw)).setText(this.f79160f.summary);
        ((ImageView) inflate.findViewById(R.id.f165861dq1)).setVisibility(8);
        ((TextView) inflate.findViewById(R.id.title)).setText(R.string.d7h);
        this.f79159e.addView(inflate);
    }

    private View r() {
        return this.f79155a.get().getLayoutInflater().inflate(R.layout.c4p, (ViewGroup) null);
    }

    private View s(IPublicAccountConfigAttr.a aVar) {
        if (!TextUtils.isEmpty(aVar.f79341m) && !TextUtils.isEmpty(aVar.f79340l)) {
            View inflate = this.f79155a.get().getLayoutInflater().inflate(R.layout.c4q, (ViewGroup) null);
            Y(inflate, aVar.f79345q);
            TextView textView = (TextView) inflate.findViewById(R.id.title);
            String str = aVar.f79330b;
            String str2 = aVar.f79331c;
            if (!TextUtils.isEmpty(str)) {
                textView.setText(str);
                inflate.setOnClickListener(new j(aVar, str2));
                return inflate;
            }
        }
        return null;
    }

    private View t(IPublicAccountConfigAttr.a aVar) {
        int i3;
        this.f79167m = aVar;
        if (aVar.f79335g != 6) {
            if (QLog.isColorLevel()) {
                QLog.d("AccountDetailGroupListContainer", 2, "Unhandled ConfigInfo(" + aVar.f79329a + ", " + aVar.f79333e + ", " + aVar.f79335g + ")");
            }
            return null;
        }
        View inflate = this.f79155a.get().getLayoutInflater().inflate(R.layout.c5g, (ViewGroup) null);
        this.f79165k = (TextView) inflate.findViewById(R.id.j1x);
        this.f79166l = (TextView) inflate.findViewById(R.id.j29);
        ((TextView) inflate.findViewById(R.id.title)).setText(this.f79167m.f79330b);
        SharedPreferences sharedPreferences = this.f79156b.getApp().getSharedPreferences(PublicAccountHandlerImpl.PREF_KEY_SETTING_STATUS_PREFIX, 0);
        this.f79176v = sharedPreferences;
        int i16 = -10000;
        if (sharedPreferences != null) {
            i16 = sharedPreferences.getInt(PublicAccountHandlerImpl.KEY_SETTING_RESULT_PRE + this.f79160f.uin + "_" + this.f79156b.getCurrentAccountUin(), -10000);
            this.f79164j = this.f79176v.getInt(PublicAccountHandlerImpl.KEY_SETTING_STATUS_PRE + this.f79160f.uin + "_" + this.f79156b.getCurrentAccountUin(), -1);
        }
        if (i16 == 0 && (i3 = this.f79164j) > -1) {
            this.f79163i = false;
            a0(i3);
            inflate.setOnClickListener(new b());
        } else {
            Z(this.f79167m);
            inflate.setOnClickListener(new c());
        }
        return inflate;
    }

    private View u(IPublicAccountConfigAttr.a aVar) {
        View inflate = this.f79155a.get().getLayoutInflater().inflate(R.layout.c4q, (ViewGroup) null);
        Y(inflate, aVar.f79345q);
        String str = aVar.f79342n;
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (!Pattern.compile("[\\d-]+?").matcher(trim).matches()) {
            return null;
        }
        ((TextView) inflate.findViewById(R.id.title)).setText(aVar.f79330b);
        inflate.setOnClickListener(new s(trim, aVar));
        return inflate;
    }

    private View v(IPublicAccountConfigAttr.a aVar) {
        View inflate = this.f79155a.get().getLayoutInflater().inflate(R.layout.c4q, (ViewGroup) null);
        Y(inflate, aVar.f79345q);
        String str = aVar.f79336h;
        ((TextView) inflate.findViewById(R.id.title)).setText(aVar.f79330b);
        ((TextView) inflate.findViewById(R.id.content)).setText(aVar.f79331c);
        inflate.setOnClickListener(new z(str, aVar));
        return inflate;
    }

    private View w(IPublicAccountConfigAttr.a aVar) {
        if (aVar.f79330b.contains(HardCodeUtil.qqStr(R.string.f171540j13)) && this.f79162h) {
            return null;
        }
        View inflate = this.f79155a.get().getLayoutInflater().inflate(R.layout.c4x, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.title)).setText(aVar.f79330b);
        String str = aVar.f79336h;
        boolean z16 = false;
        if (!TextUtils.isEmpty(str)) {
            inflate.findViewById(R.id.f165985e00).setVisibility(0);
            inflate.setOnClickListener(new t(str, aVar));
            z16 = true;
        } else {
            inflate.findViewById(R.id.f165985e00).setVisibility(8);
        }
        try {
            g0(z16, (LinearLayout) inflate.findViewById(R.id.di7), new JSONArray(aVar.f79339k));
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("AccountDetailGroupListContainer", 2, "RICH_PIC_TEXT:pic json error!");
            }
            e16.printStackTrace();
        }
        return inflate;
    }

    private View x(IPublicAccountConfigAttr.a aVar) {
        View inflate = this.f79155a.get().getLayoutInflater().inflate(R.layout.c4p, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.content)).setText(aVar.f79331c);
        ((TextView) inflate.findViewById(R.id.title)).setText(aVar.f79330b);
        return inflate;
    }

    private View y(IPublicAccountConfigAttr.a aVar) {
        View inflate = this.f79155a.get().getLayoutInflater().inflate(R.layout.c4q, (ViewGroup) null);
        Y(inflate, aVar.f79345q);
        ((TextView) inflate.findViewById(R.id.title)).setText(aVar.f79330b);
        ((TextView) inflate.findViewById(R.id.content)).setText(aVar.f79331c);
        inflate.setOnClickListener(new u(aVar));
        return inflate;
    }

    private View z(IPublicAccountConfigAttr.a aVar) {
        View inflate = this.f79155a.get().getLayoutInflater().inflate(R.layout.c4q, (ViewGroup) null);
        Y(inflate, aVar.f79345q);
        ((TextView) inflate.findViewById(R.id.title)).setText(aVar.f79330b);
        ((TextView) inflate.findViewById(R.id.content)).setText(aVar.f79331c);
        inflate.setOnClickListener(new v(aVar));
        return inflate;
    }

    void H() {
        LinearLayout linearLayout = new LinearLayout(this.f79155a.get().getBaseContext());
        this.f79159e = linearLayout;
        linearLayout.setOrientation(1);
        this.f79159e.setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.f79168n = this.f79155a.get().getResources().getDisplayMetrics().density;
        i0();
    }

    public void I() {
        PublicAccountObserverImpl publicAccountObserverImpl = this.f79174t;
        if (publicAccountObserverImpl != null) {
            publicAccountObserverImpl.onDestroy();
            this.f79156b.removeObserver(this.f79174t);
        }
        this.f79156b.removeObserver(this.f79175u);
        this.f79156b.removeObserver(this.f79180z);
    }

    void K() {
        Bundle c16;
        if (!S() || (c16 = ((com.tencent.mobileqq.troop.utils.z) this.f79156b.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).c(this.f79161g)) == null) {
            return;
        }
        this.f79171q = c16.getBoolean("mIsAbleBindTroop", false);
        ArrayList<String> stringArrayList = c16.getStringArrayList("mBindedTroopUins");
        if (stringArrayList != null && stringArrayList.size() > 0) {
            this.f79170p.clear();
            this.f79170p.addAll(stringArrayList);
        }
        if (QLog.isColorLevel()) {
            QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "loadCache, hit cache");
        }
    }

    public View L() {
        return this.f79159e;
    }

    public void O() {
        if (!S() || this.f79160f == null) {
            return;
        }
        String currentAccountUin = this.f79156b.getCurrentAccountUin();
        String str = this.f79160f.name;
        if (str != null && str.endsWith(HardCodeUtil.qqStr(R.string.j17))) {
            str = str.substring(0, str.length() - 3);
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        Bundle bundle = new Bundle();
        bundle.putString("bid", "0");
        bundle.putString("keyword", str);
        bundle.putString("ver", "1");
        bundle.putString("from", "1");
        bundle.putString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "0");
        bundle.putString(IPublicAccountBrowser.KEY_PUB_UIN, this.f79160f.uin);
        bundle.putString("Cookie", "uin=" + currentAccountUin);
        bundle.putString("Referer", "https://buluo.qq.com/");
        hashMap.put("BUNDLE", bundle);
        hashMap.put("CONTEXT", this.f79156b.getApp().getApplicationContext());
        new com.tencent.mobileqq.troop.utils.f("https://buluo.qq.com/cgi-bin/bar/qunlist_all", "POST", new m(), 1000, null).b(hashMap);
        ReportController.o(this.f79156b, "dc00899", "Grp_tribe", "", "exp_tribechat_data", "exp_tribechat_aio", 0, 0, this.f79161g, this.f79160f.uin, "", "");
    }

    void P() {
        if (S()) {
            Bundle c16 = ((com.tencent.mobileqq.troop.utils.z) this.f79156b.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).c(this.f79161g);
            if (c16 != null) {
                this.f79171q = c16.getBoolean("mIsAbleBindTroop", false);
                ArrayList<String> stringArrayList = c16.getStringArrayList("mBindedTroopUins");
                if (stringArrayList != null && stringArrayList.size() > 0) {
                    this.f79170p.clear();
                    this.f79170p.addAll(stringArrayList);
                }
            }
            X();
            O();
        }
    }

    protected boolean S() {
        boolean z16 = this.f79160f == null || ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getAccountType(this.f79160f.accountFlag) == -2;
        if (QLog.isColorLevel()) {
            QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "needShowBindTroopItem:" + z16);
        }
        return z16;
    }

    void W(IPublicAccountConfigAttr.a aVar, Switch r46) {
        boolean z16 = aVar.f79334f == 1;
        this.f79169o = false;
        r46.setChecked(z16);
    }

    public void X() {
        long j3;
        if (S()) {
            try {
                j3 = Long.parseLong(this.f79161g);
            } catch (Exception unused) {
                j3 = -1;
            }
            if (QLog.isColorLevel()) {
                QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "getBindedTroops:" + j3);
            }
            if (j3 == -1) {
                return;
            }
            oidb_0x487$ReqBody oidb_0x487_reqbody = new oidb_0x487$ReqBody();
            oidb_0x487_reqbody.uint32_channel.set(1);
            oidb_0x487_reqbody.uint64_subscribe_code.set(j3);
            ProtoUtils.j(this.f79156b, new k(), oidb_0x487_reqbody.toByteArray(), "OidbSvc.0x487_0", 1159, 0);
        }
    }

    void c0(IPublicAccountConfigAttr.a aVar, Switch r85, boolean z16) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.f79155a.get(), 0);
        createCustomDialog.setCanceledOnTouchOutside(false);
        String qqStr = HardCodeUtil.qqStr(R.string.f171538j11);
        String str = aVar.f79338j;
        if (3 == aVar.f79335g) {
            str = String.format(this.f79155a.get().getString(R.string.b0h), this.f79160f.name);
        }
        createCustomDialog.setTitle(qqStr);
        createCustomDialog.setMessage(str);
        createCustomDialog.setOnCancelListener(new p(aVar, r85));
        q qVar = new q(aVar, z16, r85);
        createCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), qVar);
        createCustomDialog.setPositiveButton(HardCodeUtil.qqStr(R.string.ket), qVar);
        try {
            createCustomDialog.show();
        } catch (Exception unused) {
        }
    }

    void d0(int i3) {
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createFullScreenDialog(this.f79155a.get(), null);
        actionSheet.addRadioButton(R.string.c1z, 5, false);
        actionSheet.addRadioButton(R.string.c1y, 5, false);
        actionSheet.addRadioButton(R.string.f171063c21, 5, false);
        if (i3 == 0) {
            actionSheet.setRadioButtonChecked(0);
        } else if (i3 == 1) {
            actionSheet.setRadioButtonChecked(2);
        } else if (i3 == 2) {
            actionSheet.setRadioButtonChecked(1);
        }
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnDismissListener(new e());
        actionSheet.setOnButtonClickListener(new f(actionSheet));
        if (actionSheet.isShowing()) {
            return;
        }
        this.f79179y = false;
        actionSheet.show();
    }

    void e0(IPublicAccountConfigAttr.a aVar, int i3) {
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createFullScreenDialog(this.f79155a.get(), null);
        actionSheet.addRadioButton(R.string.c1z, 5, false);
        actionSheet.addRadioButton(R.string.f171062c20, 5, false);
        if (i3 != 1 && i3 != 2) {
            actionSheet.setRadioButtonChecked(1);
        } else {
            actionSheet.setRadioButtonChecked(0);
        }
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnDismissListener(new d());
        actionSheet.setOnButtonClickListener(new AnonymousClass14(aVar, actionSheet));
        if (actionSheet.isShowing()) {
            return;
        }
        this.f79179y = false;
        actionSheet.show();
    }

    public void i0() {
        List<IPublicAccountConfigAttr> list;
        this.f79159e.removeAllViews();
        PublicAccountDetailImpl publicAccountDetailImpl = this.f79160f;
        if (publicAccountDetailImpl != null) {
            list = publicAccountDetailImpl.paConfigAttrs;
            if (list == null) {
                list = ((IPublicAccountConfigAttr) QRoute.api(IPublicAccountConfigAttr.class)).castToPaConfigAttrs(this.f79160f.newGroupInfoList);
            }
        } else {
            list = null;
        }
        if (list != null) {
            int size = list.size();
            boolean z16 = false;
            for (int i3 = 0; i3 < size; i3++) {
                if (list.get(i3).getType() == 0 || list.get(i3).getType() == 1) {
                    z16 = p(list.get(i3), i3, size, z16);
                }
            }
        }
        m();
    }

    void m() {
        j(this.f79159e);
        q();
        k();
    }

    void o(ViewGroup viewGroup, IPublicAccountConfigAttr.a aVar, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AccountDetailGroupListContainer", 2, "addPublicAccountDetailItem");
        }
        if (Q(aVar)) {
            return;
        }
        int i16 = aVar.f79329a;
        if (i16 == 3) {
            int i17 = aVar.f79333e;
            if (i17 == 10) {
                View t16 = t(aVar);
                this.f79157c = t16;
                this.f79158d = t16;
            } else if (i17 == 7) {
                this.f79157c = s(aVar);
            } else if (i17 == 8) {
                this.f79157c = u(aVar);
            } else if (i17 == 11) {
                this.f79157c = y(aVar);
            } else if (i17 == 20) {
                this.f79157c = z(aVar);
            } else if (i17 == 2) {
                this.f79157c = A(aVar);
            } else if (i17 == 17) {
                this.f79157c = B(aVar);
            } else if (i17 == 19) {
                this.f79157c = C(aVar, 9);
            } else if (i17 == 18) {
                this.f79157c = C(aVar, 10);
            } else if (i17 == 22) {
                this.f79157c = v(aVar);
            } else if (i17 == 24) {
                this.f79157c = D(aVar);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("AccountDetailGroupListContainer", 2, "unhandled event_id: " + aVar.f79333e);
                    return;
                }
                return;
            }
        } else if (i16 == 1) {
            this.f79157c = F(aVar);
        } else if (i16 == 2) {
            this.f79157c = E(aVar);
        } else if (i16 == 4) {
            this.f79157c = x(aVar);
        } else if (i16 == 5) {
            this.f79157c = w(aVar);
        } else {
            this.f79157c = r();
        }
        if (this.f79157c == null) {
            return;
        }
        this.f79157c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f79157c.setBackgroundResource(R.drawable.f160021f);
        float f16 = this.f79168n;
        int i18 = (int) (16.0f * f16);
        int i19 = (int) (f16 * 12.0f);
        int i26 = aVar.f79329a;
        if (i26 == 4) {
            this.f79157c.setPadding(i18, i19, i18, i19);
        } else if (i26 != 2 && (i26 != 5 || aVar.f79339k.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI))) {
            this.f79157c.setPadding(i18, i19, i18, i19);
        } else {
            this.f79157c.setPadding(i18, 0, i18, 0);
        }
        viewGroup.addView(this.f79157c);
        l(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_TROOP_REWARD, 2, "parseTribeTroopJsonObject jsonObject is null");
                return;
            }
            return;
        }
        int optInt = jSONObject.has("retcode") ? jSONObject.optInt("retcode") : -1;
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_TROOP_REWARD, 2, "parseTribeTroopJsonObject errorCode is " + optInt);
        }
        if (optInt != 0 || (optJSONObject = jSONObject.optJSONObject("result").optJSONObject("group_bar")) == null) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        JSONArray optJSONArray = optJSONObject.optJSONArray("group_list");
        int length = optJSONArray.length();
        if (length > 3) {
            length = 3;
        }
        for (int i3 = 0; i3 < length; i3++) {
            arrayList.add(optJSONArray.optJSONObject(i3).optString("code"));
        }
        this.f79170p.clear();
        this.f79170p.addAll(arrayList);
        com.tencent.mobileqq.troop.utils.z zVar = (com.tencent.mobileqq.troop.utils.z) this.f79156b.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
        Bundle bundle = new Bundle();
        bundle.putBoolean("mIsAbleBindTroop", this.f79171q);
        bundle.putStringArrayList("mBindedTroopUins", arrayList);
        zVar.i(this.f79161g, bundle);
        i0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class q implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IPublicAccountConfigAttr.a f79219d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f79220e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Switch f79221f;

        q(IPublicAccountConfigAttr.a aVar, boolean z16, Switch r46) {
            this.f79219d = aVar;
            this.f79220e = z16;
            this.f79221f = r46;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 != 0) {
                if (i3 == 1) {
                    AccountDetailGroupListContainer.this.h0(this.f79219d, this.f79220e);
                }
            } else {
                IPublicAccountConfigAttr.a aVar = this.f79219d;
                if (3 == aVar.f79335g && aVar.f79334f == 0) {
                    AccountDetailGroupListContainer.this.h0(aVar, true ^ this.f79220e);
                }
                AccountDetailGroupListContainer.this.W(this.f79219d, this.f79221f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(String str) {
        if (str == null) {
            str = "";
        }
        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.f79156b, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, this.f79161g, "0X8005A27", "0X8005A27", 0, 0, str, "", "", "", false);
    }

    void j(ViewGroup viewGroup) {
        if (S()) {
            K();
            int size = this.f79170p.size();
            if (QLog.isColorLevel()) {
                QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "addBindedTroopItem:" + size + "," + this.f79171q);
            }
            if (size != 0 || this.f79171q) {
                View inflate = LayoutInflater.from(this.f79155a.get()).inflate(R.layout.f168550c52, viewGroup, false);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.di7);
                View findViewById = inflate.findViewById(R.id.content);
                this.f79173s = linearLayout;
                if (size == 0) {
                    PublicAccountDetailImpl publicAccountDetailImpl = this.f79160f;
                    if (publicAccountDetailImpl != null) {
                        ReportController.o(this.f79156b, "P_CliOper", "Grp_public", "", UploadQualityReportBuilder.STATE_CONNECT, "exp_num", 0, 0, "", "", "", publicAccountDetailImpl.uin);
                    }
                    findViewById.setVisibility(0);
                    linearLayout.setVisibility(8);
                } else {
                    PublicAccountDetailImpl publicAccountDetailImpl2 = this.f79160f;
                    if (publicAccountDetailImpl2 != null) {
                        ReportController.o(this.f79156b, "P_CliOper", "Grp_public", "", UploadQualityReportBuilder.STATE_CONNECT, "exp_grp", 0, 0, "", "", "", publicAccountDetailImpl2.uin);
                    }
                    linearLayout.setVisibility(0);
                    findViewById.setVisibility(8);
                }
                for (int i3 = 0; i3 < size; i3++) {
                    ImageView imageView = new ImageView(this.f79155a.get());
                    int i16 = (int) (this.f79168n * 32.0f);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i16, i16);
                    layoutParams.leftMargin = (int) (this.f79168n * 6.0f);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setImageDrawable(this.f79156b.getTroopFaceDrawable(this.f79170p.get(i3)));
                    imageView.setTag(this.f79170p.get(i3));
                    linearLayout.addView(imageView);
                }
                inflate.setOnClickListener(new i(size));
                viewGroup.addView(inflate);
                l(viewGroup);
            }
        }
    }

    void h0(IPublicAccountConfigAttr.a aVar, boolean z16) {
        AccountDetailBaseInfoModel.b(this.f79156b, this.f79161g, aVar, z16 ? 1 : 2);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements PhotoWallViewForAccountDetail.c {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail.c
        public void a(IPublicAccountConfigAttr.a aVar) {
            if (aVar == null) {
                return;
            }
            String str = aVar.f79336h;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            IPublicAccountReportUtils iPublicAccountReportUtils = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
            AccountDetailGroupListContainer accountDetailGroupListContainer = AccountDetailGroupListContainer.this;
            iPublicAccountReportUtils.publicAccountReportClickEventForMigrate(accountDetailGroupListContainer.f79156b, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, accountDetailGroupListContainer.f79161g, "0X8005A28", "0X8005A28", 0, 0, str2, "", "", "", false);
            int i3 = aVar.f79329a;
            if (i3 != 3) {
                if (i3 == 1) {
                    AccountDetailGroupListContainer.this.R(aVar.f79336h);
                    return;
                }
                return;
            }
            int i16 = aVar.f79333e;
            if (i16 == 7) {
                if (TextUtils.isEmpty(aVar.f79341m) || TextUtils.isEmpty(aVar.f79340l) || TextUtils.isEmpty(aVar.f79331c)) {
                    return;
                }
                Intent intent = new Intent(AccountDetailGroupListContainer.this.f79155a.get(), (Class<?>) QQMapActivity.class);
                intent.putExtra(QCircleSchemeAttr.Polymerize.LAT, aVar.f79341m);
                intent.putExtra("lon", aVar.f79340l);
                intent.putExtra("loc", aVar.f79331c);
                AccountDetailGroupListContainer.this.f79155a.get().startActivity(intent);
                return;
            }
            if (i16 == 8) {
                String str3 = aVar.f79342n;
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                String trim = str3.trim();
                if (Pattern.compile("[\\d-]+?").matcher(trim).matches()) {
                    AccountDetailGroupListContainer.this.f0(trim);
                    return;
                }
                return;
            }
            if (i16 == 13) {
                return;
            }
            if (i16 == 11) {
                Intent intent2 = new Intent();
                intent2.putExtra("from", AccountDetailGroupListContainer.this.f79155a.getClass().getName());
                RouteUtils.startActivity(AccountDetailGroupListContainer.this.f79155a.get(), intent2, "/qrscan/scanner");
                return;
            }
            if (i16 == 16) {
                return;
            }
            if (i16 == 20) {
                AccountDetailGroupListContainer.this.b0();
                return;
            }
            if (i16 == 2) {
                BaseActivity baseActivity = AccountDetailGroupListContainer.this.f79155a.get();
                AccountDetailGroupListContainer accountDetailGroupListContainer2 = AccountDetailGroupListContainer.this;
                String str4 = accountDetailGroupListContainer2.f79161g;
                PublicAccountDetailImpl publicAccountDetailImpl = accountDetailGroupListContainer2.f79160f;
                ff0.a.d(baseActivity, new a.b(str4, publicAccountDetailImpl.name, publicAccountDetailImpl.summary), 1, AccountDetailGroupListContainer.this.N());
                return;
            }
            if (i16 == 17) {
                BaseActivity baseActivity2 = AccountDetailGroupListContainer.this.f79155a.get();
                AccountDetailGroupListContainer accountDetailGroupListContainer3 = AccountDetailGroupListContainer.this;
                String str5 = accountDetailGroupListContainer3.f79161g;
                PublicAccountDetailImpl publicAccountDetailImpl2 = accountDetailGroupListContainer3.f79160f;
                ff0.a.f(baseActivity2, new a.b(str5, publicAccountDetailImpl2.name, publicAccountDetailImpl2.summary), 1, AccountDetailGroupListContainer.this.N());
                return;
            }
            if (i16 == 19) {
                BaseActivity baseActivity3 = AccountDetailGroupListContainer.this.f79155a.get();
                AccountDetailGroupListContainer accountDetailGroupListContainer4 = AccountDetailGroupListContainer.this;
                String str6 = accountDetailGroupListContainer4.f79161g;
                PublicAccountDetailImpl publicAccountDetailImpl3 = accountDetailGroupListContainer4.f79160f;
                ff0.a.h(baseActivity3, new a.b(str6, publicAccountDetailImpl3.name, publicAccountDetailImpl3.summary), 1, AccountDetailGroupListContainer.this.N(), 9);
                return;
            }
            if (i16 == 18) {
                BaseActivity baseActivity4 = AccountDetailGroupListContainer.this.f79155a.get();
                AccountDetailGroupListContainer accountDetailGroupListContainer5 = AccountDetailGroupListContainer.this;
                String str7 = accountDetailGroupListContainer5.f79161g;
                PublicAccountDetailImpl publicAccountDetailImpl4 = accountDetailGroupListContainer5.f79160f;
                ff0.a.h(baseActivity4, new a.b(str7, publicAccountDetailImpl4.name, publicAccountDetailImpl4.summary), 1, AccountDetailGroupListContainer.this.N(), 10);
                return;
            }
            if (i16 == 21) {
                return;
            }
            if (i16 == 22) {
                AccountDetailGroupListContainer.this.R(aVar.f79336h);
            } else if (QLog.isColorLevel()) {
                QLog.d("AccountDetailGroupListContainer", 2, "unhandled event_id: " + aVar.f79333e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f79195d;

        f(ActionSheet actionSheet) {
            this.f79195d = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            AccountDetailGroupListContainer accountDetailGroupListContainer = AccountDetailGroupListContainer.this;
            if (accountDetailGroupListContainer.f79179y) {
                return;
            }
            accountDetailGroupListContainer.f79179y = true;
            if (i3 == 0) {
                accountDetailGroupListContainer.f79164j = 0;
            } else if (i3 == 1) {
                accountDetailGroupListContainer.f79164j = 2;
            } else if (i3 == 2) {
                accountDetailGroupListContainer.f79164j = 1;
            }
            accountDetailGroupListContainer.f79156b.removeObserver(accountDetailGroupListContainer.f79175u);
            AccountDetailGroupListContainer.this.f79175u = new com.tencent.mobileqq.applets.c(new a());
            AccountDetailGroupListContainer accountDetailGroupListContainer2 = AccountDetailGroupListContainer.this;
            accountDetailGroupListContainer2.f79156b.addObserver(accountDetailGroupListContainer2.f79175u);
            AccountDetailGroupListContainer accountDetailGroupListContainer3 = AccountDetailGroupListContainer.this;
            QQAppInterface qQAppInterface = accountDetailGroupListContainer3.f79156b;
            PublicAccountDetailImpl publicAccountDetailImpl = accountDetailGroupListContainer3.f79160f;
            com.tencent.mobileqq.applets.e.e(qQAppInterface, publicAccountDetailImpl.uin, publicAccountDetailImpl.name, accountDetailGroupListContainer3.f79164j);
            this.f79195d.dismiss();
        }

        /* compiled from: P */
        /* loaded from: classes32.dex */
        class a extends c.a {
            a() {
            }

            @Override // com.tencent.mobileqq.applets.c.a
            public void b(boolean z16, Object obj) {
                if (QLog.isColorLevel()) {
                    QLog.d("AccountDetailGroupListContainer", 2, "New 0xc76 onGetRecvMsgState isSuccess = " + z16);
                }
            }

            @Override // com.tencent.mobileqq.applets.c.a
            public void d(Object obj) {
                AccountDetailGroupListContainer accountDetailGroupListContainer = AccountDetailGroupListContainer.this;
                accountDetailGroupListContainer.a0(accountDetailGroupListContainer.f79164j);
                SharedPreferences sharedPreferences = AccountDetailGroupListContainer.this.f79176v;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt(PublicAccountHandlerImpl.KEY_SETTING_STATUS_PRE + AccountDetailGroupListContainer.this.f79160f.uin + "_" + AccountDetailGroupListContainer.this.f79156b.getCurrentAccountUin(), AccountDetailGroupListContainer.this.f79164j).apply();
                }
            }

            @Override // com.tencent.mobileqq.applets.c.a
            public int e() {
                return 7;
            }

            @Override // com.tencent.mobileqq.applets.c.a
            public void c(Object obj) {
            }

            @Override // com.tencent.mobileqq.applets.c.a
            public void a(boolean z16, Object obj) {
            }
        }
    }
}
