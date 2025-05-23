package com.tencent.mobileqq.qqexpand.chat;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qqexpand.bean.profile.ExpandUserInfo;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExtendFriendSendMsgHelper {

    /* renamed from: e, reason: collision with root package name */
    private static volatile ExtendFriendSendMsgHelper f263497e;

    /* renamed from: a, reason: collision with root package name */
    private long f263498a;

    /* renamed from: b, reason: collision with root package name */
    private BaseQQAppInterface f263499b;

    /* renamed from: c, reason: collision with root package name */
    private e f263500c;

    /* renamed from: d, reason: collision with root package name */
    ExpandObserver f263501d;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f263505d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f263506e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f263507f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f263508h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f263509i;

        c(boolean z16, QBaseActivity qBaseActivity, int i3, String str, String str2) {
            this.f263505d = z16;
            this.f263506e = qBaseActivity;
            this.f263507f = i3;
            this.f263508h = str;
            this.f263509i = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (this.f263505d) {
                CampusHelper.e(this.f263506e, this.f263507f, this.f263508h, this.f263509i);
            } else {
                CampusHelper.f(this.f263506e, this.f263508h);
            }
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    ExtendFriendSendMsgHelper(BaseQQAppInterface baseQQAppInterface) {
        a aVar = new a();
        this.f263501d = aVar;
        if (baseQQAppInterface != null) {
            this.f263499b = baseQQAppInterface;
            baseQQAppInterface.removeObserver(aVar);
            this.f263499b.addObserver(this.f263501d);
        }
    }

    public static ExtendFriendSendMsgHelper e(BaseQQAppInterface baseQQAppInterface) {
        if (f263497e == null) {
            synchronized (ExtendFriendSendMsgHelper.class) {
                if (f263497e == null) {
                    f263497e = new ExtendFriendSendMsgHelper(baseQQAppInterface);
                }
            }
        }
        return f263497e;
    }

    public static void f(BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3) {
        ((com.tencent.mobileqq.qqexpand.manager.e) baseQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).H(str, str2, i3);
    }

    public static void g(BaseQQAppInterface baseQQAppInterface, int i3, vg2.d dVar) {
        ((ILimitChatUtils) QRoute.api(ILimitChatUtils.class)).resetMatchChatAIOData(baseQQAppInterface, dVar.f441607c);
        ((ILimitChatUtils) QRoute.api(ILimitChatUtils.class)).addTopicMessage(baseQQAppInterface, dVar, dVar.f441609e, 2, i3);
        if (i3 == 1045) {
            ((ILimitChatUtils) QRoute.api(ILimitChatUtils.class)).addExtendFriendUserInfo(baseQQAppInterface, dVar.f441607c, dVar.f441613i, dVar.f441614j, !TextUtils.isEmpty(dVar.f441608d), 1);
        } else {
            ((ILimitChatUtils) QRoute.api(ILimitChatUtils.class)).addExtendFriendUserInfo(baseQQAppInterface, dVar.f441607c, dVar.f441613i, dVar.f441614j, !TextUtils.isEmpty(dVar.f441608d), 3);
        }
        if (dVar.f441613i >= 2) {
            IceBreakingMng iceBreakingMng = (IceBreakingMng) baseQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
            iceBreakingMng.i(dVar.f441607c);
            iceBreakingMng.e0();
        }
    }

    public void c() {
        BaseQQAppInterface baseQQAppInterface = this.f263499b;
        if (baseQQAppInterface != null) {
            baseQQAppInterface.removeObserver(this.f263501d);
            this.f263499b = null;
        }
        this.f263500c = null;
        f263497e = null;
        this.f263501d = null;
    }

    public void i(BaseQQAppInterface baseQQAppInterface, final String str, String str2, byte[] bArr, final int i3, e eVar) {
        if (baseQQAppInterface == null || eVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendSendMsgHelper", 2, "sendMsg appInterface = " + baseQQAppInterface + " sendMsgInterface = " + eVar);
                return;
            }
            return;
        }
        if (System.currentTimeMillis() - this.f263498a < 1000) {
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendSendMsgHelper", 2, "sendMsg is fast Click");
            }
        } else {
            this.f263498a = System.currentTimeMillis();
            this.f263500c = eVar;
            ((com.tencent.mobileqq.qqexpand.network.e) baseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).H0(baseQQAppInterface.getCurrentAccountUin(), str, str2, bArr);
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.chat.ExtendFriendSendMsgHelper.9
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqexpand.manager.e eVar2 = (com.tencent.mobileqq.qqexpand.manager.e) ExtendFriendSendMsgHelper.this.f263499b.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
                    Bundle bundle = new Bundle();
                    bundle.putInt(IProfileCardConst.KEY_FROM_TYPE, i3);
                    eVar2.D(str, bundle);
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a extends ExpandObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void g(boolean z16, Object obj) {
            if (obj == null) {
                return;
            }
            Object[] objArr = (Object[]) obj;
            String str = (String) objArr[0];
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendSendMsgHelper", 2, String.format("onGetSigBy0xb4cCode success=%s", Boolean.valueOf(z16)));
            }
            if (z16) {
                String str2 = (String) objArr[1];
                if (ExtendFriendSendMsgHelper.this.f263500c != null) {
                    ExtendFriendSendMsgHelper.this.f263500c.enterAio(str, str2);
                    return;
                }
                return;
            }
            int intValue = ((Integer) objArr[1]).intValue();
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendSendMsgHelper", 2, String.format("onGetSigBy0xb4cCode resetCode=%s", Integer.valueOf(intValue)));
            }
            if (intValue == 20) {
                if (ExtendFriendSendMsgHelper.this.f263500c != null) {
                    ExtendFriendSendMsgHelper.this.f263500c.showMatchCountDialog();
                }
            } else if (intValue == 21) {
                if (ExtendFriendSendMsgHelper.this.f263500c != null) {
                    ExtendFriendSendMsgHelper.this.f263500c.showToast(R.string.f199014o_);
                }
            } else if (ExtendFriendSendMsgHelper.this.f263500c != null) {
                ExtendFriendSendMsgHelper.this.f263500c.showToast(R.string.huv);
            }
        }
    }

    public void h(BaseQQAppInterface baseQQAppInterface, AllInOne allInOne, e eVar) {
        if (allInOne != null) {
            String str = allInOne.uin;
            String str2 = allInOne.nickname;
            byte[] bArr = allInOne.extendFriendVoiceCode;
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendSendMsgHelper", 2, String.format("sendMsg uin=%s nickName=%s voiceCode=%s", str, str2, bArr));
            }
            i(baseQQAppInterface, str, str2, bArr, ExpandUserInfo.subIDToFromType(allInOne.subSourceId), eVar);
            int e16 = ExtendFriendReport.e();
            if (e16 == 1 || e16 == 2) {
                ExtendFriendReport.a().n(e16 == 1 ? 2 : 4, str, "", ExtendFriendReport.c(), ExtendFriendReport.b(), ExtendFriendReport.d());
            }
        }
    }

    public static void d(Context context, String str, String str2) {
        if (context == null) {
            QLog.d("ExtendFriendSendMsgHelper", 1, "enterAio() context is null just return");
            return;
        }
        Intent intent = new Intent(context, (Class<?>) ChatActivity.class);
        intent.putExtra("uin", str);
        intent.putExtra("uinname", str2);
        intent.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 23);
        intent.putExtra("uintype", 1045);
        intent.putExtra(ILimitChatUtils.EXT_KEY_LIMIT_CHAT_ENTER_TYPE, 2);
        intent.putExtras(new Bundle());
        context.startActivity(intent);
    }

    public static void j(QBaseActivity qBaseActivity, boolean z16, int i3, String str, String str2) {
        if (qBaseActivity == null) {
            QLog.d("ExtendFriendSendMsgHelper", 1, "showCampusVerifyDialog() activity is null just return");
        } else {
            DialogUtil.createCustomDialog(qBaseActivity, 230).setMessage(qBaseActivity.getString(R.string.f198894ny)).setNegativeButton(qBaseActivity.getString(R.string.f198874nw), new d()).setPositiveButton(qBaseActivity.getString(R.string.f198884nx), new c(z16, qBaseActivity, i3, str, str2)).show();
        }
    }

    public static void k(Activity activity) {
        if (activity == null) {
            QLog.d("ExtendFriendSendMsgHelper", 1, "showMatchCountDialog() activity is null just return");
        } else {
            DialogUtil.createCustomDialog(activity, 230).setMessage(activity.getString(R.string.f198914o0)).setPositiveButton(activity.getString(R.string.f198904nz), new b()).show();
        }
    }

    public static void l(QBaseActivity qBaseActivity, String str) {
        if (qBaseActivity == null) {
            QLog.d("ExtendFriendSendMsgHelper", 1, "showToast() activity is null just return");
        } else {
            QQToast.makeText(qBaseActivity, str, 0).show(qBaseActivity.getTitleBarHeight());
        }
    }
}
