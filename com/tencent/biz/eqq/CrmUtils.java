package com.tencent.biz.eqq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.av.core.f;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.biz.m;
import com.tencent.biz.pubaccount.accountdetail.api.IEqqAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.z;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.mp.mobileqq_mp$FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp$GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp$GetEqqDetailInfoRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.widget.ActionSheet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.regex.Pattern;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes2.dex */
public class CrmUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f78488a = Pattern.compile("QQ\u8bed\u97f3");

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f78489b = w();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f78492d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f78493e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QQProgressDialog f78494f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ SessionInfo f78495h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f78496i;

        a(Context context, QQAppInterface qQAppInterface, QQProgressDialog qQProgressDialog, SessionInfo sessionInfo, String str) {
            this.f78492d = context;
            this.f78493e = qQAppInterface;
            this.f78494f = qQProgressDialog;
            this.f78495h = sessionInfo;
            this.f78496i = str;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d("CrmUtils", 2, "success:" + String.valueOf(z16));
            }
            if (z16) {
                byte[] byteArray = bundle.getByteArray("data");
                if (byteArray != null) {
                    mobileqq_mp$GetEqqAccountDetailInfoResponse mobileqq_mp_geteqqaccountdetailinforesponse = new mobileqq_mp$GetEqqAccountDetailInfoResponse();
                    try {
                        mobileqq_mp_geteqqaccountdetailinforesponse.mergeFrom(byteArray);
                        if (mobileqq_mp_geteqqaccountdetailinforesponse.ret_info.get().ret_code.get() == 0) {
                            EqqDetail eqqDetail = new EqqDetail(mobileqq_mp_geteqqaccountdetailinforesponse);
                            CrmUtils.B(this.f78493e, eqqDetail);
                            CrmUtils.A(this.f78494f);
                            if (QLog.isDevelopLevel()) {
                                QLog.d("IVR_TS_CrmUtils", 4, "<<<end getDetail, ts=" + System.currentTimeMillis());
                            }
                            CrmUtils.x(this.f78493e, this.f78492d, this.f78495h, null, eqqDetail, this.f78496i);
                        } else {
                            CrmUtils.h(this.f78492d, R.string.d6b);
                            ReportController.o(this.f78493e, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
                        }
                    } catch (InvalidProtocolBufferMicroException unused) {
                        CrmUtils.h(this.f78492d, R.string.d6b);
                        ReportController.o(this.f78493e, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
                        CrmUtils.A(this.f78494f);
                        return;
                    }
                } else {
                    CrmUtils.h(this.f78492d, R.string.d6b);
                    ReportController.o(this.f78493e, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
                }
            } else {
                CrmUtils.h(this.f78492d, R.string.d6b);
                ReportController.o(this.f78493e, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
            }
            CrmUtils.A(this.f78494f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f78497d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f78498e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QQProgressDialog f78499f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ EqqDetail f78500h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ SessionInfo f78501i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f78502m;

        b(Context context, QQAppInterface qQAppInterface, QQProgressDialog qQProgressDialog, EqqDetail eqqDetail, SessionInfo sessionInfo, String str) {
            this.f78497d = context;
            this.f78498e = qQAppInterface;
            this.f78499f = qQProgressDialog;
            this.f78500h = eqqDetail;
            this.f78501i = sessionInfo;
            this.f78502m = str;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d("CrmUtils", 2, "success:" + String.valueOf(z16));
            }
            if (z16) {
                byte[] byteArray = bundle.getByteArray("data");
                if (byteArray != null) {
                    mobileqq_mp$FollowResponse mobileqq_mp_followresponse = new mobileqq_mp$FollowResponse();
                    try {
                        mobileqq_mp_followresponse.mergeFrom(byteArray);
                        int i16 = mobileqq_mp_followresponse.ret_info.get().ret_code.get();
                        if (i16 == 0) {
                            EqqDetail eqqDetail = this.f78500h;
                            eqqDetail.followType = 1;
                            CrmUtils.B(this.f78498e, eqqDetail);
                            IPublicAccountHandler iPublicAccountHandler = (IPublicAccountHandler) this.f78498e.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
                            if (iPublicAccountHandler != null) {
                                iPublicAccountHandler.onFollowPublicAccount(this.f78500h);
                            }
                            if (QLog.isDevelopLevel()) {
                                QLog.d("IVR_TS_CrmUtils", 4, "<<<end follow, ts=" + System.currentTimeMillis());
                            }
                            CrmUtils.G(this.f78498e, this.f78497d, this.f78501i, this.f78502m);
                            EnterpriseQQManager.j(this.f78498e).k(this.f78498e, this.f78500h.uin, true);
                        } else if (i16 == 58) {
                            CrmUtils.h(this.f78497d, R.string.d69);
                            ReportController.o(this.f78498e, "CliOper", "", "", "0X80049DF", "PublicAccount_max_limit_false", 0, 0, "", "", "", "");
                        } else if (i16 == 65) {
                            CrmUtils.h(this.f78497d, R.string.d5i);
                        } else if (i16 == 20) {
                            CrmUtils.h(this.f78497d, R.string.d5j);
                        } else {
                            CrmUtils.h(this.f78497d, R.string.d6b);
                            ReportController.o(this.f78498e, "CliOper", "", "", "0X80049DF", "AutoFollowFalse", 0, 0, "", "", "", "");
                        }
                    } catch (InvalidProtocolBufferMicroException unused) {
                        CrmUtils.h(this.f78497d, R.string.d6b);
                        ReportController.o(this.f78498e, "CliOper", "", "", "0X80049DF", "AutoFollowFalse", 0, 0, "", "", "", "");
                        CrmUtils.A(this.f78499f);
                        return;
                    }
                } else {
                    CrmUtils.h(this.f78497d, R.string.d6b);
                    ReportController.o(this.f78498e, "CliOper", "", "", "0X80049DF", "AutoFollowFalse", 0, 0, "", "", "", "");
                }
            } else {
                CrmUtils.h(this.f78497d, R.string.d6b);
                ReportController.o(this.f78498e, "CliOper", "", "", "0X80049DF", "AutoFollowFalse", 0, 0, "", "", "", "");
            }
            CrmUtils.A(this.f78499f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f78503d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f78504e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f78505f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ SessionInfo f78506h;

        c(ActionSheet actionSheet, QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo) {
            this.f78503d = actionSheet;
            this.f78504e = qQAppInterface;
            this.f78505f = context;
            this.f78506h = sessionInfo;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            this.f78503d.dismiss();
            if (i3 == 0) {
                ReportController.o(this.f78504e, "CliOper", "", "", "0X8004655", "0X8004655", 0, 0, "", "", "", "");
                try {
                    CrmUtils.y(this.f78504e, this.f78505f, this.f78506h, "IvrAIOMessageEngineFalse");
                } catch (Exception e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.e("CrmUtils", 2, "Start ivr audio error", e16);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void A(QQProgressDialog qQProgressDialog) {
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            qQProgressDialog.dismiss();
        }
    }

    public static void B(final QQAppInterface qQAppInterface, final EqqDetail eqqDetail) {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.biz.eqq.CrmUtils.1
            @Override // java.lang.Runnable
            public void run() {
                CrmUtils.C(QQAppInterface.this, eqqDetail);
            }
        });
    }

    public static void C(QQAppInterface qQAppInterface, EqqDetail eqqDetail) {
        IPublicAccountDataManager iPublicAccountDataManager;
        if (QLog.isColorLevel()) {
            QLog.d("CrmUtils", 2, "saveCache");
        }
        z zVar = (z) qQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
        if (zVar != null) {
            zVar.d(eqqDetail);
        }
        if (eqqDetail != null && eqqDetail.followType == 1 && (iPublicAccountDataManager = (IPublicAccountDataManager) qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")) != null) {
            iPublicAccountDataManager.savePublicAccountInfo(PublicAccountInfo.createPublicAccount(eqqDetail, 0L));
        }
        if (QLog.isColorLevel()) {
            QLog.d("CrmUtils", 2, "saveCache exit");
        }
    }

    public static void D(QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo) {
        if (!f78489b) {
            if (QLog.isDevelopLevel()) {
                QLog.d("IVR_TS_CrmUtils", 4, "Don't support sharp");
            }
        } else {
            if (AVCoreSystemInfo.isSupportSharpAudio()) {
                ActionSheet create = ActionSheet.create(context);
                create.addButton(R.string.i3u);
                create.addCancelButton(R.string.cancel);
                create.setOnButtonClickListener(new c(create, qQAppInterface, context, sessionInfo));
                create.show();
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("CrmUtils", 2, String.format("We needn't show video action sheet, because Sharp Audio is not supported", new Object[0]));
            }
        }
    }

    public static void E(QQAppInterface qQAppInterface, Context context, String str, String str2) {
        if (!f78489b) {
            if (QLog.isDevelopLevel()) {
                QLog.d("IVR_TS_CrmUtils", 4, "Don't support sharp");
            }
        } else {
            SessionInfo sessionInfo = new SessionInfo();
            sessionInfo.f179555d = 1024;
            sessionInfo.f179563i = str2;
            sessionInfo.f179557e = str;
            D(qQAppInterface, context, sessionInfo);
        }
    }

    private static void F(int i3, QQProgressDialog qQProgressDialog) {
        if (qQProgressDialog != null) {
            qQProgressDialog.setMessage(i3);
            qQProgressDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo, String str) {
        boolean z16;
        if (QLog.isDevelopLevel()) {
            QLog.d("IVR_TS_CrmUtils", 4, ">>>startVideo(), ts=" + System.currentTimeMillis());
        }
        String str2 = sessionInfo.f179557e;
        if (qQAppInterface.isVideoChatting() && str2 != null && str2.equals(qQAppInterface.getAVNotifyCenter().F())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X8004628", "0X8004628", 0, 0, "", "", "", "");
        }
        if (sessionInfo.f179555d != 1008) {
            sessionInfo.f179555d = 1024;
        }
        PlusPanelUtils.h(qQAppInterface, context, sessionInfo, true, str, null);
    }

    public static void H(QQAppInterface qQAppInterface, Context context, String str, int i3, BusinessObserver businessObserver) {
        if (!q(qQAppInterface, str, i3)) {
            NewIntent newIntent = new NewIntent(context.getApplicationContext(), m.class);
            newIntent.putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
            mobileqq_mp$GetEqqDetailInfoRequest mobileqq_mp_geteqqdetailinforequest = new mobileqq_mp$GetEqqDetailInfoRequest();
            mobileqq_mp_geteqqdetailinforequest.version.set(2);
            mobileqq_mp_geteqqdetailinforequest.seqno.set(0);
            try {
                mobileqq_mp_geteqqdetailinforequest.eqq_id.set((int) Long.parseLong(str));
            } catch (Exception unused) {
            }
            newIntent.putExtra("data", mobileqq_mp_geteqqdetailinforequest.toByteArray());
            newIntent.setObserver(businessObserver);
            qQAppInterface.startServlet(newIntent);
        }
    }

    public static InputStream d(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    public static int e(String str) {
        int i3 = 0;
        try {
            String[] split = str.split("\\.");
            int i16 = 0;
            while (i3 < split.length) {
                try {
                    i16 = (int) (i16 + (((3 - i3) * Long.parseLong(split[i3])) ^ 10));
                    i3++;
                } catch (Exception e16) {
                    e = e16;
                    i3 = i16;
                    e.printStackTrace();
                    return i3;
                }
            }
            return i16;
        } catch (Exception e17) {
            e = e17;
        }
    }

    private static void f(int i3, QQProgressDialog qQProgressDialog) {
        F(i3, qQProgressDialog);
    }

    public static void g(Context context, String str) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str + "_customer_transfer_sharepreference", 0).edit();
            edit.clear();
            edit.commit();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void h(Context context, int i3) {
        QQToast.makeText(context, i3, 0).show();
    }

    public static void i(QQAppInterface qQAppInterface, Context context, String str, String str2) {
        String stweb;
        TicketManager ticketManager = (TicketManager) qQAppInterface.getManager(2);
        if (ticketManager == null) {
            stweb = null;
        } else {
            stweb = ticketManager.getStweb(qQAppInterface.getCurrentAccountUin());
        }
        if (stweb != null && stweb.length() != 0) {
            String format = String.format("https://ptlogin2.qq.com/qidian_client?pt_clientver=5428&pt_src=1&clientuin=%s&clientkey=%s&keyindex=19&jump=30&kfuin=%s&kfext=%s&buildver=1.0.0.0&inter=1&_wv=1027", qQAppInterface.getCurrentAccountUin(), stweb, str, str2);
            if (QLog.isColorLevel()) {
                QLog.d("CrmUtils", 2, "enterLightTalk() url = " + format);
            }
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("uin", qQAppInterface.getCurrentAccountUin());
            intent.putExtra("url", format);
            intent.putExtra("hide_more_button", true);
            context.startActivity(intent);
            return;
        }
        new QQToastNotifier(context).notifyUser(R.string.bui, context.getResources().getDimensionPixelSize(R.dimen.title_bar_height), 0, 1);
    }

    public static String j(QQAppInterface qQAppInterface, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (QidianManager.P(qQAppInterface, str)) {
                Friends u16 = ((FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).u(str);
                if (u16 == null) {
                    return "";
                }
                return u16.getFriendName();
            }
            IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
            if (iPublicAccountDataManager != null) {
                PublicAccountInfo publicAccountInfo = (PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfoCache(str);
                if (publicAccountInfo != null) {
                    return publicAccountInfo.name;
                }
                Manager manager = qQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
                if (manager != null) {
                    EqqDetail b16 = ((z) manager).b(str);
                    if (b16 != null) {
                        return b16.name;
                    }
                    if (!QLog.isColorLevel()) {
                        return "";
                    }
                    QLog.d("CrmUtils", 2, String.format("We can't find %s from EqqCache", str));
                    return "";
                }
                if (!QLog.isColorLevel()) {
                    return "";
                }
                QLog.e("CrmUtils", 2, "Get EqqDetailDataManager error");
                return "";
            }
            if (!QLog.isColorLevel()) {
                return "";
            }
            QLog.e("CrmUtils", 2, "Get PublicAccountDataManager error");
            return "";
        }
        if (!QLog.isColorLevel()) {
            return "";
        }
        QLog.d("CrmUtils", 2, "We can't get name, because uin is null");
        return "";
    }

    public static void k(QQAppInterface qQAppInterface, Context context, String str, String str2) {
        if (!((FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).c0(str2)) {
            return;
        }
        try {
            if (!context.getSharedPreferences(str + "_customer_transfer_sharepreference", 0).getBoolean(str + "_" + str2, false)) {
                ((QidianHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).K2(Long.valueOf(str).longValue(), Long.valueOf(str2).longValue());
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static String l(QQAppInterface qQAppInterface, String str) {
        EqqDetail b16;
        if (!TextUtils.isEmpty(str)) {
            if (QidianManager.P(qQAppInterface, str)) {
                return QidianManager.v(qQAppInterface, str);
            }
            IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
            if (iPublicAccountDataManager != null) {
                PublicAccountInfo publicAccountInfo = (PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfoCache(str);
                if (publicAccountInfo != null) {
                    if (publicAccountInfo.extendType == 2) {
                        return publicAccountInfo.name;
                    }
                    return str;
                }
                Manager manager = qQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
                if (manager != null && (b16 = ((z) manager).b(str)) != null) {
                    return b16.name;
                }
                return str;
            }
            return str;
        }
        return str;
    }

    public static int m(QQAppInterface qQAppInterface, String str) {
        if (qQAppInterface != null && nx.a.f(str) && nx.a.d(str)) {
            FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
            if (friendsManager != null && friendsManager.c0(str)) {
                return 0;
            }
            return 1025;
        }
        return 1024;
    }

    public static Intent n(Context context, Intent intent, String str, boolean z16, int i3, boolean z17, int i16) {
        Intent intent2 = intent;
        boolean z18 = false;
        try {
            z18 = ((QidianManager) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.QIDIAN_MANAGER)).S(str, false);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        QLog.i("CrmUtils", 1, "gotoCrmMainProfile isMaster[" + str + "] : " + z18);
        if (z18) {
            if (intent2 == null) {
                intent2 = new Intent(context, (Class<?>) QidianProfileCardActivity.class);
            } else {
                intent.setClassName(context, QidianProfileCardActivity.class.getName());
            }
        } else if (intent2 == null) {
            intent2 = new Intent(context, (Class<?>) ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplClass(IEqqAccountDetailActivity.class));
        } else {
            intent.setClassName(context, ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplName(IEqqAccountDetailActivity.class));
        }
        Intent intent3 = intent2;
        if (!TextUtils.isEmpty(str)) {
            intent3.putExtra("uin", str);
        }
        intent3.putExtra("gotoCrmMainProfileIntent", true);
        intent3.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, new AllInOne(str, 104));
        intent3.putExtra(IPublicAccountUtil.NEED_FINISH, z16);
        intent3.putExtra("uintype", 1024);
        intent3.addFlags(67108864);
        intent3.addFlags(268435456);
        if (i3 != -1) {
            intent3.putExtra("source", i3);
            try {
                AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().getRuntime();
                if (i3 == 1) {
                    ((IPublicAccountHandler) QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(appInterface, str, IPublicAccountHandler.MAIN_ACTION, "mp_msg_sys_2", "detail");
                }
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
        if (z17) {
            if (i16 == -1) {
                context.startActivity(intent3);
            } else if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent3, i16);
            }
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(R.anim.activity_new, R.anim.activity_out);
            }
        }
        return intent3;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean o(QQAppInterface qQAppInterface, String str, int i3) {
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isDevelopLevel()) {
            QLog.d("IVR_TS_CrmUtils", 4, ">>>hasIvrAbility(), ts=" + currentTimeMillis);
        }
        if (qQAppInterface != null && !TextUtils.isEmpty(str)) {
            if (i3 == 1024) {
                IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
                if (iPublicAccountDataManager != null) {
                    PublicAccountInfo publicAccountInfo = (PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfoCache(str);
                    if (publicAccountInfo != null) {
                        z16 = publicAccountInfo.hasIvrAbility();
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d("CrmUtils", 2, String.format("We cant find %s in public account cache", str));
                        }
                        Manager manager = qQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
                        if (manager != null) {
                            EqqDetail b16 = ((z) manager).b(str);
                            if (b16 != null) {
                                z16 = b16.hasIvrAbility();
                            } else if (QLog.isColorLevel()) {
                                QLog.d("CrmUtils", 2, String.format("We can't find %s from EqqCache", str));
                            }
                        } else if (QLog.isColorLevel()) {
                            QLog.e("CrmUtils", 2, "Get EqqDetailDataManager error");
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("CrmUtils", 2, String.format("Check %s hasIvrAbility end, the result is %b", str, Boolean.valueOf(z16)));
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (QLog.isDevelopLevel()) {
                        QLog.d("IVR_TS_CrmUtils", 4, "<<<hasIvrAbility(), ts=" + currentTimeMillis2);
                        QLog.d("IVR_TS_CrmUtils", 4, String.format("hasIvrAbility(), cost=%dms", Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                    }
                    return z16;
                }
                if (QLog.isColorLevel()) {
                    QLog.e("CrmUtils", 2, "Get PublicAccountDataManager error");
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("CrmUtils", 2, String.format("uin %s isn't crmqq or now session type isn't crm", str));
            }
            z16 = false;
            if (QLog.isColorLevel()) {
            }
            long currentTimeMillis22 = System.currentTimeMillis();
            if (QLog.isDevelopLevel()) {
            }
            return z16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CrmUtils", 2, "app is null or uin is empty");
        }
        return false;
    }

    public static int p(QQAppInterface qQAppInterface, String str) {
        EqqDetail b16;
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        if (iPublicAccountDataManager == null) {
            return 0;
        }
        PublicAccountInfo publicAccountInfo = (PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfoCache(str);
        if (publicAccountInfo == null) {
            z zVar = (z) qQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
            if (zVar == null || (b16 = zVar.b(str)) == null || b16.certifiedGrade <= 0) {
                return 0;
            }
        } else if (publicAccountInfo.certifiedGrade <= 0) {
            return 0;
        }
        return R.drawable.br7;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean q(QQAppInterface qQAppInterface, String str, int i3) {
        boolean z16;
        if (qQAppInterface != null && !TextUtils.isEmpty(str)) {
            if (i3 == 1024) {
                IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
                if (iPublicAccountDataManager != null) {
                    if (((PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfoCache(str)) == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("CrmUtils", 2, String.format("We cant find %s in public account cache", str));
                        }
                        Manager manager = qQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
                        if (manager != null) {
                            if (((z) manager).b(str) == null) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("CrmUtils", 2, String.format("We can't find %s from EqqCache", str));
                                }
                            }
                        } else if (QLog.isColorLevel()) {
                            QLog.e("CrmUtils", 2, "Get EqqDetailDataManager error");
                        }
                    }
                    z16 = true;
                    if (QLog.isColorLevel()) {
                        QLog.d("CrmUtils", 2, String.format("Check %s isContainUinInfo end, the result is %b", str, Boolean.valueOf(z16)));
                    }
                    return z16;
                }
                if (QLog.isColorLevel()) {
                    QLog.e("CrmUtils", 2, "Get PublicAccountDataManager error");
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("CrmUtils", 2, String.format("uin %s isn't crmqq or now session type isn't crm", str));
            }
            z16 = false;
            if (QLog.isColorLevel()) {
            }
            return z16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CrmUtils", 2, "app is null or uin is empty");
        }
        return false;
    }

    public static boolean r(BaseQQAppInterface baseQQAppInterface, String str) {
        d friendsSimpleInfoWithUid;
        byte b16 = 0;
        if (!nx.a.f(str)) {
            return false;
        }
        String uidFromUin = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getUidFromUin(str);
        if (TextUtils.isEmpty(uidFromUin) || (friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "CrmUtils")) == null) {
            return false;
        }
        if (friendsSimpleInfoWithUid.e() != null) {
            b16 = friendsSimpleInfoWithUid.e().byteValue();
        }
        return s(b16);
    }

    public static boolean s(int i3) {
        if (i3 < 0) {
            QLog.i("CrmUtils", 1, "isCrmMaster meet error!!");
            return false;
        }
        if ((i3 & 1) == 0) {
            return false;
        }
        return true;
    }

    public static boolean t(QQAppInterface qQAppInterface, String str) {
        PublicAccountInfo publicAccountInfo;
        if (qQAppInterface != null && str != null) {
            IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
            if (iPublicAccountDataManager != null && (publicAccountInfo = (PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfoCache(str)) != null && publicAccountInfo.extendType == 2) {
                return true;
            }
            z zVar = (z) qQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
            if (zVar != null && zVar.b(str) != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean u(QQAppInterface qQAppInterface, String str) {
        IPublicAccountDataManager iPublicAccountDataManager;
        PublicAccountInfo publicAccountInfo;
        if (qQAppInterface == null || str == null || (iPublicAccountDataManager = (IPublicAccountDataManager) qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")) == null || (publicAccountInfo = (PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfoCache(str)) == null || publicAccountInfo.extendType != 2) {
            return false;
        }
        return true;
    }

    public static boolean v(BaseQQAppInterface baseQQAppInterface, String str, int i3) {
        boolean z16;
        IPublicAccountDataManager iPublicAccountDataManager;
        boolean z17 = false;
        if (i3 != 0 && i3 != 1024) {
            if (QLog.isColorLevel()) {
                QLog.d("CrmUtils", 2, "isQiye not friend and not crm tmp");
            }
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            if (baseQQAppInterface != null && (iPublicAccountDataManager = (IPublicAccountDataManager) baseQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")) != null) {
                PublicAccountInfo publicAccountInfo = (PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfoCache(str);
                if (publicAccountInfo != null) {
                    if (publicAccountInfo.extendType == 2) {
                        if (QLog.isColorLevel()) {
                            QLog.d("CrmUtils", 2, "isQiye PublicAccountInfo is eqq");
                        }
                        z16 = true;
                    }
                } else {
                    Manager manager = baseQQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
                    if (manager != null && ((z) manager).b(str) != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("CrmUtils", 2, "isQiye EqqDetail has data");
                        }
                        z16 = true;
                    }
                }
                if (z16 && i3 == 0) {
                    boolean r16 = r(baseQQAppInterface, str);
                    if (QidianManager.P(baseQQAppInterface, str)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("CrmUtils", 2, "isQiye uin is qidianmaster");
                        }
                    } else {
                        z17 = r16;
                    }
                } else {
                    z17 = z16;
                }
            }
            z16 = false;
            if (z16) {
            }
            z17 = z16;
        }
        if (z17) {
            QLog.i("CrmUtils", 1, "isQiye is true finally");
        }
        return z17;
    }

    public static boolean w() {
        new f();
        AVCoreSystemInfo.getCpuInfo();
        int cpuArchitecture = AVCoreSystemInfo.getCpuArchitecture();
        long maxCpuFreq = AVCoreSystemInfo.getMaxCpuFreq();
        if (cpuArchitecture >= 3 && maxCpuFreq / 1000 >= 800) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CrmUtils", 2, "User don't support sharp!");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void x(QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo, PublicAccountInfo publicAccountInfo, EqqDetail eqqDetail, String str) {
        boolean hasIvrAbility;
        boolean z16;
        QQProgressDialog qQProgressDialog;
        if (QLog.isDevelopLevel()) {
            QLog.d("IVR_TS_CrmUtils", 4, ">>>ivrAudio3(), ts=" + System.currentTimeMillis());
        }
        if (publicAccountInfo != null) {
            hasIvrAbility = publicAccountInfo.hasIvrAbility();
        } else if (eqqDetail != null) {
            hasIvrAbility = eqqDetail.hasIvrAbility();
            if (eqqDetail.followType == 0) {
                z16 = false;
                if (!hasIvrAbility) {
                    if (!z16) {
                        if (QLog.isDevelopLevel()) {
                            QLog.d("IVR_TS_CrmUtils", 4, ">>>begin follow, ts=" + System.currentTimeMillis());
                        }
                        if (context instanceof Activity) {
                            qQProgressDialog = new QQProgressDialog(context, context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                        } else {
                            qQProgressDialog = null;
                        }
                        QQProgressDialog qQProgressDialog2 = qQProgressDialog;
                        if (qQProgressDialog2 != null) {
                            qQProgressDialog2.setCanceledOnTouchOutside(true);
                        }
                        NewIntent newIntent = new NewIntent(context.getApplicationContext(), ((IPublicAccountServlet) QRoute.api(IPublicAccountServlet.class)).getServletClass());
                        newIntent.putExtra("cmd", "follow");
                        mobileqq_mp$FollowRequest mobileqq_mp_followrequest = new mobileqq_mp$FollowRequest();
                        mobileqq_mp_followrequest.uin.set((int) Long.parseLong(eqqDetail.uin));
                        mobileqq_mp_followrequest.account_type.set(2);
                        newIntent.putExtra("data", mobileqq_mp_followrequest.toByteArray());
                        newIntent.setObserver(new b(context, qQAppInterface, qQProgressDialog2, eqqDetail, sessionInfo, str));
                        qQAppInterface.startServlet(newIntent);
                        try {
                            if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                                f(R.string.d7n, qQProgressDialog2);
                            }
                        } catch (Exception unused) {
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("CrmUtils", 2, "follow exit");
                            return;
                        }
                        return;
                    }
                    G(qQAppInterface, context, sessionInfo, str);
                    return;
                }
                return;
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.w("CrmUtils", 2, "Both PublicAccountInfo and EqqDetail is NULL!");
                return;
            }
            return;
        }
        z16 = true;
        if (!hasIvrAbility) {
        }
    }

    public static void y(QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo, String str) {
        QQProgressDialog qQProgressDialog;
        if (QLog.isDevelopLevel()) {
            QLog.d("IVR_TS_CrmUtils", 4, ">>>ivrAudio2(), ts=" + System.currentTimeMillis());
        }
        if (QidianManager.P(qQAppInterface, sessionInfo.f179557e)) {
            G(qQAppInterface, context, sessionInfo, str);
            return;
        }
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        if (iPublicAccountDataManager != null) {
            PublicAccountInfo publicAccountInfo = (PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfoCache(sessionInfo.f179557e);
            if (publicAccountInfo == null) {
                z zVar = (z) qQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
                if (zVar != null) {
                    EqqDetail b16 = zVar.b(sessionInfo.f179557e);
                    if (b16 == null) {
                        if (QLog.isDevelopLevel()) {
                            QLog.d("IVR_TS_CrmUtils", 4, ">>>begin getDetail, ts=" + System.currentTimeMillis());
                        }
                        if (context instanceof Activity) {
                            qQProgressDialog = new QQProgressDialog(context, context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                        } else {
                            qQProgressDialog = null;
                        }
                        QQProgressDialog qQProgressDialog2 = qQProgressDialog;
                        if (qQProgressDialog2 != null) {
                            qQProgressDialog2.setCanceledOnTouchOutside(true);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("CrmUtils", 2, "sendDetailInfoRequest");
                        }
                        NewIntent newIntent = new NewIntent(context.getApplicationContext(), m.class);
                        newIntent.putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
                        mobileqq_mp$GetEqqDetailInfoRequest mobileqq_mp_geteqqdetailinforequest = new mobileqq_mp$GetEqqDetailInfoRequest();
                        mobileqq_mp_geteqqdetailinforequest.version.set(2);
                        mobileqq_mp_geteqqdetailinforequest.seqno.set(0);
                        try {
                            mobileqq_mp_geteqqdetailinforequest.eqq_id.set((int) Long.parseLong(sessionInfo.f179557e));
                        } catch (Exception unused) {
                        }
                        newIntent.putExtra("data", mobileqq_mp_geteqqdetailinforequest.toByteArray());
                        newIntent.setObserver(new a(context, qQAppInterface, qQProgressDialog2, sessionInfo, str));
                        qQAppInterface.startServlet(newIntent);
                        try {
                            if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                                f(R.string.d7n, qQProgressDialog2);
                                return;
                            }
                            return;
                        } catch (Exception unused2) {
                            return;
                        }
                    }
                    x(qQAppInterface, context, sessionInfo, null, b16, str);
                    return;
                }
                h(context, R.string.d6b);
                ReportController.o(qQAppInterface, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
                return;
            }
            x(qQAppInterface, context, sessionInfo, publicAccountInfo, null, str);
            return;
        }
        h(context, R.string.d6b);
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
    }

    public static void z(QQAppInterface qQAppInterface, Context context, String str, String str2, String str3) {
        if (QLog.isDevelopLevel()) {
            QLog.d("IVR_TS_CrmUtils", 4, ">>>ivrAudio1(), ts=" + System.currentTimeMillis());
        }
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = 1024;
        sessionInfo.f179563i = str;
        sessionInfo.f179557e = str2;
        y(qQAppInterface, context, sessionInfo, str3);
    }
}
