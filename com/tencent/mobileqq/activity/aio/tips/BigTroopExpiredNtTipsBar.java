package com.tencent.mobileqq.activity.aio.tips;

import GROUP.MessageRemindRsp;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.aio.notification.AIONotificationBusiId;
import com.tencent.mobileqq.aio.notification.IAIONotificationUIModel;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.x.q;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BigTroopExpiredNtTipsBar extends com.tencent.qqnt.aio.toptips.a implements View.OnClickListener, com.tencent.mobileqq.aio.notification.e {
    private static final Boolean D = Boolean.TRUE;
    public static String E = "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/client/group/release/index.html?_bid=199&groupId=%s&from=%s";
    private static final UnitedProxy F = ar.a("shouyouye", "2024-04-10", "vas_troop_upgrade_url_config");
    public static int G;
    SVIPObserver C = new h(this);

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.qqnt.aio.toptips.c f180022d;

    /* renamed from: e, reason: collision with root package name */
    private String f180023e;

    /* renamed from: f, reason: collision with root package name */
    private SpannableString f180024f;

    /* renamed from: h, reason: collision with root package name */
    private int f180025h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f180026i;

    /* renamed from: m, reason: collision with root package name */
    private int f180027m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public enum ExpiredType {
        SVIP,
        GROUP,
        LIANG
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TroopManager f180063d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f180064e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f180065f;

        a(TroopManager troopManager, String str, QQAppInterface qQAppInterface) {
            this.f180063d = troopManager;
            this.f180064e = str;
            this.f180065f = qQAppInterface;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f180063d.l0(this.f180064e, Boolean.FALSE);
            ReportController.o(this.f180065f, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A57E", 2, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f180066a;

        static {
            int[] iArr = new int[ExpiredType.values().length];
            f180066a = iArr;
            try {
                iArr[ExpiredType.SVIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f180066a[ExpiredType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f180066a[ExpiredType.LIANG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class f implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TroopManager f180067d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f180068e;

        f(TroopManager troopManager, String str) {
            this.f180067d = troopManager;
            this.f180068e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f180067d.l0(this.f180068e, Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class g implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TroopManager f180069d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f180070e;

        g(TroopManager troopManager, String str) {
            this.f180069d = troopManager;
            this.f180070e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f180069d.l0(this.f180070e, Boolean.FALSE);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private static class h extends SVIPObserver {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<BigTroopExpiredNtTipsBar> f180071d;

        h(BigTroopExpiredNtTipsBar bigTroopExpiredNtTipsBar) {
            this.f180071d = new WeakReference<>(bigTroopExpiredNtTipsBar);
        }

        @Override // com.tencent.mobileqq.app.SVIPObserver
        public void onGetBigTroopExpiredInfo(boolean z16, Object obj) {
            BigTroopExpiredNtTipsBar bigTroopExpiredNtTipsBar = this.f180071d.get();
            if (bigTroopExpiredNtTipsBar == null) {
                return;
            }
            if (z16 && (obj instanceof MessageRemindRsp)) {
                MessageRemindRsp messageRemindRsp = (MessageRemindRsp) obj;
                if (QLog.isColorLevel()) {
                    QLog.e("vip_pretty.BigTroopExpiredNtTipsBar", 2, "SVIPObserver.onGetBigTroopExpiredInfo, troopUin: " + bigTroopExpiredNtTipsBar.f180023e + " iFreezedType=" + messageRemindRsp.iFreezedType + " iLhGroupExpiredTime=" + messageRemindRsp.iLhGroupExpiredTime + " iGroupType=" + messageRemindRsp.iGroupType);
                }
                ((TroopManager) bigTroopExpiredNtTipsBar.z().getManager(QQManagerFactory.TROOP_MANAGER)).q0(bigTroopExpiredNtTipsBar.f180023e, messageRemindRsp);
                bigTroopExpiredNtTipsBar.I(messageRemindRsp, bigTroopExpiredNtTipsBar.f180023e);
            } else {
                QLog.e("vip_pretty.BigTroopExpiredNtTipsBar", 2, String.format("SVIPObserver.onGetBigTroopExpiredInfo, troopUin: %s, isSuccess: false", bigTroopExpiredNtTipsBar.f180023e));
            }
            bigTroopExpiredNtTipsBar.Q();
        }
    }

    public static String A() {
        String H = H("expired_dialog_upgrade_url", "");
        if (TextUtils.isEmpty(H)) {
            return D();
        }
        return H;
    }

    public static String B() {
        return H("expired_dialog_pay_url", "mqqapi://kuikly/open?aid=mvip.pt.android.groups_kaitong&bundle_name=vas_qqvip_pay&business_type=svip%2Cvip&kr_turbo_display=1&page_name=vas_qqvip_pay&pay_type=svip&policy_id=&qqmc_config=vas_kuikly_config&src_type=web&trace_detail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoiMTA0In0%253D&version=1&month=12");
    }

    public static String C() {
        return H("expired_tip_about_to_pay_url", "mqqapi://kuikly/open?aid=mvip.pt.android.groups_kaitong&bundle_name=vas_qqvip_pay&business_type=svip%2Cvip&kr_turbo_display=1&page_name=vas_qqvip_pay&pay_type=svip&policy_id=&qqmc_config=vas_kuikly_config&src_type=web&trace_detail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoiMTA1In0%253D&version=1&month=12");
    }

    public static String D() {
        return H("troop_expired_url", E);
    }

    public static String E() {
        return H("expired_tip_overdue_pay_url", "mqqapi://kuikly/open?aid=mvip.pt.android.groups_kaitong&bundle_name=vas_qqvip_pay&business_type=svip%2Cvip&kr_turbo_display=1&page_name=vas_qqvip_pay&pay_type=svip&policy_id=&qqmc_config=vas_kuikly_config&src_type=web&trace_detail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoiMTA2In0%253D&version=1&month=12");
    }

    protected static int F(ExpiredType expiredType, MessageRemindRsp messageRemindRsp) {
        long j3;
        int i3 = e.f180066a[expiredType.ordinal()];
        if (i3 != 2) {
            if (i3 != 3) {
                j3 = messageRemindRsp.iSVIPExpiredTime;
            } else {
                return messageRemindRsp.iLhGroupExpiredTime;
            }
        } else {
            j3 = messageRemindRsp.iGroupExpiredTime;
        }
        return (int) j3;
    }

    private static ExpiredType G(MessageRemindRsp messageRemindRsp) {
        ExpiredType expiredType = ExpiredType.SVIP;
        long j3 = messageRemindRsp.iGroupExpiredTime;
        if (j3 != 0 && j3 < messageRemindRsp.iSVIPExpiredTime) {
            expiredType = ExpiredType.GROUP;
        }
        int i3 = messageRemindRsp.iLhGroupExpiredTime;
        if (i3 != 0) {
            if (j3 == 0 || i3 < j3) {
                long j16 = messageRemindRsp.iSVIPExpiredTime;
                if (j16 == 0 || i3 < j16) {
                    return ExpiredType.LIANG;
                }
                return expiredType;
            }
            return expiredType;
        }
        return expiredType;
    }

    private static String H(String str, String str2) {
        String str3;
        try {
            str3 = F.getJson().optString(str, str2);
        } catch (Exception e16) {
            QLog.e("BigTroopExpiredNtTipsBar", 1, "getJumpUrl failed", e16);
            str3 = "";
        }
        if (!TextUtils.isEmpty(str3)) {
            str2 = str3;
        }
        QLog.i("BigTroopExpiredNtTipsBar", 1, "getUrl key: " + str + " result" + str2);
        return str2;
    }

    protected static void K(ExpiredType expiredType, QQAppInterface qQAppInterface, String str, MessageRemindRsp messageRemindRsp) {
        int i3;
        Boolean bool = D;
        if (bool.booleanValue()) {
            QLog.d("BigTroopExpiredNtTipsBar", 1, "handleFreezed_showExpiredDialog_by_notiType start notiType = " + expiredType);
        }
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            if (bool.booleanValue()) {
                QLog.d("BigTroopExpiredNtTipsBar", 1, "handleFreezed_showExpiredDialog_by_notiType context == null");
                return;
            }
            return;
        }
        TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        int i16 = e.f180066a[expiredType.ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 == 3) {
                    if (TroopManager.g.c(messageRemindRsp.iGroupType)) {
                        i3 = 13;
                    } else {
                        i3 = 14;
                    }
                    ff.b0(topActivity, str, ff.j(0, i3).toString(), HardCodeUtil.qqStr(R.string.uiw), new a(troopManager, str, qQAppInterface), "0X800A57E", 1, true);
                    ReportController.o(qQAppInterface, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A57D", 0, 0, "", "", "", "");
                    return;
                }
                return;
            }
            ff.a0(topActivity, str, ff.j((int) messageRemindRsp.iGroupExpiredTime, 6).toString(), HardCodeUtil.qqStr(R.string.ukb), new g(troopManager, str), "0X8009E36", 1);
            ReportController.o(qQAppInterface, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X8009E35", 1, 0, "", "", "", "");
            return;
        }
        G = 1;
        ff.c0(topActivity, str, ff.j((int) messageRemindRsp.iSVIPExpiredTime, 7).toString(), HardCodeUtil.qqStr(R.string.ujc), new f(troopManager, str), "0X8009E36", 2, false, "expired_tips_bar");
        ReportController.o(qQAppInterface, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X8009E35", 2, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit N(IAIONotificationUIModel iAIONotificationUIModel, Integer num) {
        if (num.intValue() == 1) {
            y(Foreground.getTopActivity());
            return null;
        }
        if (num.intValue() == 2) {
            R();
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void O(TroopManager troopManager, String str, MessageRemindRsp messageRemindRsp, int i3, QVipBigTroopExpiredConfig qVipBigTroopExpiredConfig, int i16, int i17, ExpiredType expiredType) {
        if (D.booleanValue()) {
            QLog.d("BigTroopExpiredNtTipsBar", 1, "notifyExpiredDialog notiType = " + expiredType);
        }
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            return;
        }
        int i18 = e.f180066a[expiredType.ordinal()];
        if (i18 != 1) {
            if (i18 != 2) {
                if (i18 == 3) {
                    int i19 = ff.i(i3, messageRemindRsp.iLhGroupExpiredTime);
                    if ((i19 <= qVipBigTroopExpiredConfig.mNotifyDialogMaxDay && i19 >= qVipBigTroopExpiredConfig.mNotifyDialogMinDay) || i19 == 0) {
                        ff.b0(topActivity, str, ff.j(messageRemindRsp.iLhGroupExpiredTime, 17).toString(), HardCodeUtil.qqStr(R.string.j6l), new d(), "0X8009E36", 1, true);
                        troopManager.r0(str, i16 + 1);
                        troopManager.t0(str, i3);
                        troopManager.u0(str, i17 + 1);
                        ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X8009E35", 1, 0, "", "", "", "");
                        return;
                    }
                    return;
                }
                return;
            }
            int i26 = ff.i(i3, (int) messageRemindRsp.iGroupExpiredTime);
            if ((i26 <= qVipBigTroopExpiredConfig.mNotifyDialogMaxDay && i26 >= qVipBigTroopExpiredConfig.mNotifyDialogMinDay) || i26 == 0) {
                ff.a0(topActivity, str, ff.j((int) messageRemindRsp.iGroupExpiredTime, 4).toString(), HardCodeUtil.qqStr(R.string.j6l), new c(), "0X8009E36", 1);
                troopManager.r0(str, i16 + 1);
                troopManager.t0(str, i3);
                troopManager.u0(str, i17 + 1);
                ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X8009E35", 1, 0, "", "", "", "");
                return;
            }
            return;
        }
        int i27 = ff.i(i3, (int) messageRemindRsp.iSVIPExpiredTime);
        if ((i27 <= qVipBigTroopExpiredConfig.mNotifyDialogMaxDay && i27 >= qVipBigTroopExpiredConfig.mNotifyDialogMinDay) || i27 == 0) {
            G = 2;
            ff.c0(topActivity, str, ff.j((int) messageRemindRsp.iSVIPExpiredTime, 5).toString(), HardCodeUtil.qqStr(R.string.j6l), new b(), "0X8009E36", 1, false, "expired_tips_bar");
            troopManager.r0(str, i16 + 1);
            troopManager.t0(str, i3);
            troopManager.u0(str, i17 + 1);
            ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X8009E35", 1, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(QQAppInterface qQAppInterface, TroopManager troopManager, String str, MessageRemindRsp messageRemindRsp, int i3, QVipBigTroopExpiredConfig qVipBigTroopExpiredConfig, int i16, int i17, ExpiredType expiredType) {
        int i18;
        if (D.booleanValue()) {
            QLog.d("BigTroopExpiredNtTipsBar", 1, "notifyExpiredTips notiType = " + expiredType);
        }
        int i19 = e.f180066a[expiredType.ordinal()];
        if (i19 != 1) {
            if (i19 != 2) {
                if (i19 == 3 && (i18 = ff.i(i3, messageRemindRsp.iLhGroupExpiredTime)) <= qVipBigTroopExpiredConfig.mNotifyTipsMaxDay && i18 >= qVipBigTroopExpiredConfig.mNotifyTipsMinDay) {
                    S(ff.j(messageRemindRsp.iLhGroupExpiredTime, 10), 0, 3);
                    this.f180022d.e(this);
                    troopManager.y0(str, i17 + 1);
                    ReportController.o(qQAppInterface, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A579", 0, 0, "", "", "", "");
                    return;
                }
                return;
            }
            int i26 = ff.i(i3, (int) messageRemindRsp.iGroupExpiredTime);
            if (i26 <= qVipBigTroopExpiredConfig.mNotifyTipsMaxDay && i26 >= qVipBigTroopExpiredConfig.mNotifyTipsMinDay) {
                S(ff.j((int) messageRemindRsp.iGroupExpiredTime, 0), 0, 1);
                this.f180022d.e(this);
                troopManager.y0(str, i17 + 1);
                ReportController.o(qQAppInterface, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X8009E33", 1, 0, "", "", "", "");
                return;
            }
            return;
        }
        int i27 = ff.i(i3, (int) messageRemindRsp.iSVIPExpiredTime);
        if (i27 <= qVipBigTroopExpiredConfig.mNotifyTipsMaxDay && i27 >= qVipBigTroopExpiredConfig.mNotifyTipsMinDay) {
            G = 2;
            S(ff.j((int) messageRemindRsp.iSVIPExpiredTime, 1), 0, 2);
            this.f180022d.e(this);
            troopManager.y0(str, i17 + 1);
            ReportController.o(qQAppInterface, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X8009E33", 2, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        z().removeObserver(this.C);
    }

    private void R() {
        String str;
        TroopManager troopManager = (TroopManager) z().getManager(QQManagerFactory.TROOP_MANAGER);
        troopManager.v0(this.f180023e, troopManager.y(this.f180023e) + 1);
        this.f180022d.h(this);
        if (this.f180026i) {
            QQAppInterface z16 = z();
            if (this.f180027m == 3) {
                str = "0X800A57A";
            } else {
                str = "0X800A57C";
            }
            ReportController.o(z16, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, str, 2, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(SpannableString spannableString, int i3, int i16) {
        boolean z16;
        this.f180024f = spannableString;
        this.f180025h = i3;
        this.f180027m = i16;
        if (i16 != 3 && i16 != 4) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.f180026i = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(TroopInfo troopInfo, long j3, TroopManager troopManager) {
        boolean z16;
        if (troopInfo != null && troopInfo.isTroopOwner(z().getCurrentAccountUin())) {
            if (QVipBigTroopExpiredProcessor.getConfig().mIsEnable) {
                Boolean bool = D;
                if (bool.booleanValue()) {
                    QLog.d("BigTroopExpiredNtTipsBar", 1, "start handle!");
                }
                if (troopManager.S(this.f180023e)) {
                    z().addObserver(this.C);
                    try {
                        ((ISVIPHandler) z().getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).getBigTroopExpiredInfo(Long.parseLong(this.f180023e));
                    } catch (NumberFormatException e16) {
                        QLog.w("BigTroopExpiredNtTipsBar", 1, "exception:" + e16);
                    }
                } else {
                    if (bool.booleanValue()) {
                        QLog.d("BigTroopExpiredNtTipsBar", 1, "get the troop expired info from local");
                    }
                    I(TroopManager.t(z(), this.f180023e), this.f180023e);
                }
            }
            QLog.i("BigTroopExpiredNtTipsBar", 1, "cost time1:" + (System.currentTimeMillis() - j3));
            return;
        }
        if (D.booleanValue()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("troopInfo is Null? isTroopOwner = ");
            if (troopInfo != null && troopInfo.isTroopOwner(z().getCurrentAccountUin())) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.i("BigTroopExpiredNtTipsBar", 1, sb5.toString());
        }
    }

    private void y(Context context) {
        String str;
        String C;
        if (context == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BigTroopExpiredNtTipsBar", 2, "click tips, jump");
        }
        if (!this.f180026i) {
            int i3 = G;
            if (i3 > 0) {
                if (i3 == 1) {
                    C = E();
                } else {
                    C = C();
                }
                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(context, C);
            } else {
                String D2 = D();
                try {
                    if (D2.contains("groupId=%s")) {
                        D2 = D2.replace("groupId=%s", "groupId=" + this.f180023e);
                    }
                    if (D2.contains("from=%s")) {
                        D2 = D2.replace("from=%s", "from=group_aio_tip");
                    }
                } catch (Exception e16) {
                    QLog.e("BigTroopExpiredNtTipsBar", 1, "contentClick format exception", e16);
                }
                if (!D2.startsWith("http") && !D2.startsWith(q.f250389u)) {
                    ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(context, D2);
                } else {
                    Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", D2);
                    intent.putExtra("hide_operation_bar", true);
                    if (context instanceof Application) {
                        intent.setFlags(268435456);
                    }
                    context.startActivity(intent);
                }
            }
            ReportController.o(z(), "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X8009E34", this.f180027m, 0, "", "", "", "");
        } else {
            TroopManager.g.d(context, this.f180023e, "group_aio_tip");
            QQAppInterface z16 = z();
            if (this.f180027m == 3) {
                str = "0X800A57A";
            } else {
                str = "0X800A57C";
            }
            ReportController.o(z16, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, str, 1, 0, "", "", "", "");
        }
        this.f180022d.h(this);
        ((TroopManager) z().getManager(QQManagerFactory.TROOP_MANAGER)).m0(this.f180023e, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QQAppInterface z() {
        return (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    public void I(MessageRemindRsp messageRemindRsp, String str) {
        if (messageRemindRsp == null) {
            if (D.booleanValue()) {
                QLog.d("BigTroopExpiredNtTipsBar", 1, "expiredInfo is Null!");
                return;
            }
            return;
        }
        QVipBigTroopExpiredConfig config = QVipBigTroopExpiredProcessor.getConfig();
        if (!config.mIsEnable) {
            if (D.booleanValue()) {
                QLog.d("BigTroopExpiredNtTipsBar", 1, "config.mIsEnable is False!");
                return;
            }
            return;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        ExpiredType G2 = G(messageRemindRsp);
        QLog.i("BigTroopExpiredNtTipsBar", 1, "isFreezed: " + messageRemindRsp.isFreezed + " remindLevel: " + messageRemindRsp.eRemindLevel + " lhGroupType: " + messageRemindRsp.iGroupType + " freezedType: " + messageRemindRsp.iFreezedType + " svipExpiredTime: " + messageRemindRsp.iSVIPExpiredTime + " lhExpiredTime: " + messageRemindRsp.iLhGroupExpiredTime + " groupExpiredTime: " + messageRemindRsp.iGroupExpiredTime + " nowLevel: " + messageRemindRsp.eNowLevel + " nextReqTime: " + messageRemindRsp.iNextReqTime + " userRole: " + messageRemindRsp.iUserRole + " curTime:" + System.currentTimeMillis() + " mTroopUin:" + this.f180023e);
        if (messageRemindRsp.isFreezed) {
            if (D.booleanValue()) {
                QLog.d("BigTroopExpiredNtTipsBar", 1, "isFreezed is True!");
            }
            J(z(), str, currentTimeMillis, config, messageRemindRsp, G2);
            return;
        }
        if (messageRemindRsp.eRemindLevel >= 3) {
            int F2 = F(G2, messageRemindRsp);
            if (ff.i(currentTimeMillis, F2) > config.mNotifyTipsMaxDay) {
                ((TroopManager) z().getManager(QQManagerFactory.TROOP_MANAGER)).i(str);
                if (D.booleanValue()) {
                    QLog.d("BigTroopExpiredNtTipsBar", 1, "expiredDay > config.mNotifyTipsMaxDay");
                    return;
                }
                return;
            }
            M(z(), str, currentTimeMillis, config, F2, messageRemindRsp, G2);
            return;
        }
        if (D.booleanValue()) {
            QLog.d("BigTroopExpiredNtTipsBar", 1, "expiredInfo.eRemindLevel = " + messageRemindRsp.eRemindLevel + " isLiangGroup = " + TroopManager.g.b(messageRemindRsp.iGroupType));
        }
    }

    protected void J(final QQAppInterface qQAppInterface, final String str, final int i3, QVipBigTroopExpiredConfig qVipBigTroopExpiredConfig, final MessageRemindRsp messageRemindRsp, final ExpiredType expiredType) {
        final TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager.y(str) >= qVipBigTroopExpiredConfig.mNotifyTipsMaxCloseCount) {
            if (D.booleanValue()) {
                QLog.d("BigTroopExpiredNtTipsBar", 1, "handleFreezed getTroopExpiredNotifyTipsCloseCount");
            }
        } else {
            if (D.booleanValue()) {
                QLog.d("BigTroopExpiredNtTipsBar", 1, "handleFreezed else");
            }
            L(expiredType, qQAppInterface, messageRemindRsp);
        }
        if (troopManager.W(str)) {
            Boolean bool = D;
            if (bool.booleanValue()) {
                QLog.d("BigTroopExpiredNtTipsBar", 1, "handleFreezed isShowTroopExpiredNotifyDialog");
            }
            if (ff.i(troopManager.v(str), i3) >= qVipBigTroopExpiredConfig.mNotifyDialogExpiredIntervalDay) {
                if (bool.booleanValue()) {
                    QLog.d("BigTroopExpiredNtTipsBar", 1, "handleFreezed getDaysBetween");
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.tips.BigTroopExpiredNtTipsBar.2
                    @Override // java.lang.Runnable
                    public void run() {
                        BigTroopExpiredNtTipsBar.K(expiredType, qQAppInterface, str, messageRemindRsp);
                        troopManager.s0(str, i3);
                    }
                });
            }
        }
    }

    protected void L(final ExpiredType expiredType, final QQAppInterface qQAppInterface, final MessageRemindRsp messageRemindRsp) {
        if (D.booleanValue()) {
            QLog.d("BigTroopExpiredNtTipsBar", 1, "handleFreezed_showTipsBar_by_notiType notiType = " + expiredType);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.tips.BigTroopExpiredNtTipsBar.7
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                int i16 = e.f180066a[expiredType.ordinal()];
                if (i16 != 1) {
                    if (i16 == 2) {
                        BigTroopExpiredNtTipsBar.this.S(ff.j((int) messageRemindRsp.iGroupExpiredTime, 2), 1, 1);
                        BigTroopExpiredNtTipsBar.this.f180022d.e(BigTroopExpiredNtTipsBar.this);
                        ReportController.o(qQAppInterface, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X8009E33", 1, 0, "", "", "", "");
                        return;
                    } else {
                        if (i16 == 3) {
                            BigTroopExpiredNtTipsBar bigTroopExpiredNtTipsBar = BigTroopExpiredNtTipsBar.this;
                            MessageRemindRsp messageRemindRsp2 = messageRemindRsp;
                            int i17 = messageRemindRsp2.iLhGroupExpiredTime;
                            if (TroopManager.g.c(messageRemindRsp2.iGroupType)) {
                                i3 = 11;
                            } else {
                                i3 = 12;
                            }
                            bigTroopExpiredNtTipsBar.S(ff.j(i17, i3), 1, 4);
                            BigTroopExpiredNtTipsBar.this.f180022d.e(BigTroopExpiredNtTipsBar.this);
                            ReportController.o(qQAppInterface, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A57B", 0, 0, "", "", "", "");
                            return;
                        }
                        return;
                    }
                }
                BigTroopExpiredNtTipsBar.G = 1;
                BigTroopExpiredNtTipsBar.this.S(ff.j((int) messageRemindRsp.iSVIPExpiredTime, 3), 1, 2);
                BigTroopExpiredNtTipsBar.this.f180022d.e(BigTroopExpiredNtTipsBar.this);
                ReportController.o(qQAppInterface, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X8009E33", 2, 0, "", "", "", "");
            }
        });
    }

    protected void M(final QQAppInterface qQAppInterface, final String str, final int i3, final QVipBigTroopExpiredConfig qVipBigTroopExpiredConfig, int i16, final MessageRemindRsp messageRemindRsp, final ExpiredType expiredType) {
        final TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        final int z16 = troopManager.z(str);
        if (z16 < qVipBigTroopExpiredConfig.mNotifyTipsMaxCount) {
            Boolean bool = D;
            if (bool.booleanValue()) {
                QLog.d("BigTroopExpiredNtTipsBar", 1, "notifyCount < config.mNotifyTipsMaxCount");
            }
            if (!ff.G(troopManager.A(str), i3)) {
                final int i17 = 0;
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.tips.BigTroopExpiredNtTipsBar.3
                    @Override // java.lang.Runnable
                    public void run() {
                        BigTroopExpiredNtTipsBar.this.P(qQAppInterface, troopManager, str, messageRemindRsp, i3, qVipBigTroopExpiredConfig, z16, i17, expiredType);
                    }
                });
                if (bool.booleanValue()) {
                    QLog.d("BigTroopExpiredNtTipsBar", 1, "notifyCount < config.mNotifyTipsMaxCount");
                }
            }
        }
        final int u16 = troopManager.u(str);
        int w3 = troopManager.w(str);
        if (ff.G(i3, i16) && !ff.G(w3, i3)) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.tips.BigTroopExpiredNtTipsBar.4
                @Override // java.lang.Runnable
                public void run() {
                    BigTroopExpiredNtTipsBar.O(troopManager, str, messageRemindRsp, i3, qVipBigTroopExpiredConfig, u16, 0, expiredType);
                }
            });
            return;
        }
        if (u16 < qVipBigTroopExpiredConfig.mNotifyDialogMaxCount) {
            if (!ff.G(w3, i3)) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.tips.BigTroopExpiredNtTipsBar.5
                    @Override // java.lang.Runnable
                    public void run() {
                        BigTroopExpiredNtTipsBar.O(troopManager, str, messageRemindRsp, i3, qVipBigTroopExpiredConfig, u16, 0, expiredType);
                    }
                });
                return;
            }
            final int x16 = troopManager.x(str);
            if (x16 < qVipBigTroopExpiredConfig.mNotifyDialogPerDay) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.tips.BigTroopExpiredNtTipsBar.6
                    @Override // java.lang.Runnable
                    public void run() {
                        BigTroopExpiredNtTipsBar.O(troopManager, str, messageRemindRsp, i3, qVipBigTroopExpiredConfig, u16, x16, expiredType);
                    }
                });
            }
        }
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    @Nullable
    public View a(@NonNull Object... objArr) {
        View inflate = LayoutInflater.from(BaseApplication.context).inflate(R.layout.f167636ch, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.f164227nv);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.f164237o5);
        ((TextView) inflate.findViewById(R.id.f164238o6)).setText(this.f180024f);
        if (this.f180025h == 0) {
            imageView.setImageResource(R.drawable.ciq);
            inflate.setBackgroundResource(R.drawable.common_tips_bg_white);
            imageView2.setImageResource(R.drawable.skin_icon_arrow_right_normal);
        } else {
            imageView.setImageResource(R.drawable.e8t);
            inflate.setBackgroundResource(R.drawable.f162109ao2);
            imageView2.setImageResource(R.drawable.f161614a92);
            imageView2.setOnClickListener(this);
        }
        inflate.setOnClickListener(this);
        return inflate;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    @Nullable
    public int[] b() {
        return new int[0];
    }

    @Override // com.tencent.mobileqq.aio.notification.e
    @NonNull
    public IAIONotificationUIModel e() {
        IAIONotificationUIModel.ActionIcon actionIcon;
        if (this.f180025h == 0) {
            actionIcon = IAIONotificationUIModel.ActionIcon.ARROW;
        } else {
            actionIcon = IAIONotificationUIModel.ActionIcon.CLOSE;
        }
        return new IAIONotificationUIModel.b(AIONotificationBusiId.UPGRADE_BIG_TROOP_EXPIRED, this.f180024f, actionIcon, "", 0, new Function2() { // from class: com.tencent.mobileqq.activity.aio.tips.a
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit N;
                N = BigTroopExpiredNtTipsBar.this.N((IAIONotificationUIModel) obj, (Integer) obj2);
                return N;
            }
        });
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public void g(@NonNull final com.tencent.qqnt.aio.toptips.c cVar, int i3, @NonNull Object... objArr) {
        if (i3 == 1005) {
            G = 0;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.tips.BigTroopExpiredNtTipsBar.1
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    QLog.i("BigTroopExpiredNtTipsBar", 1, "start create!");
                    BigTroopExpiredNtTipsBar.this.f180022d = cVar;
                    BigTroopExpiredNtTipsBar.this.f180023e = cVar.a().g().r().c().j();
                    if (TextUtils.isEmpty(BigTroopExpiredNtTipsBar.this.f180023e)) {
                        if (BigTroopExpiredNtTipsBar.D.booleanValue()) {
                            QLog.i("BigTroopExpiredNtTipsBar", 1, "mTroopUin is Empty!");
                            return;
                        }
                        return;
                    }
                    TroopManager troopManager = (TroopManager) BigTroopExpiredNtTipsBar.this.z().getManager(QQManagerFactory.TROOP_MANAGER);
                    if (troopManager == null) {
                        if (BigTroopExpiredNtTipsBar.D.booleanValue()) {
                            QLog.i("BigTroopExpiredNtTipsBar", 1, "mTroopManager isEmpty!");
                        }
                    } else {
                        BigTroopExpiredNtTipsBar.this.T(troopManager.k(BigTroopExpiredNtTipsBar.this.f180023e), currentTimeMillis, troopManager);
                    }
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int getType() {
        return 112;
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    @NonNull
    public List<AIONotificationBusiId> h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(AIONotificationBusiId.UPGRADE_BIG_TROOP_EXPIRED);
        return arrayList;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int j() {
        return 14;
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    public void m(@NonNull com.tencent.mobileqq.aio.notification.c cVar, int i3, @NonNull Object... objArr) {
        g((com.tencent.qqnt.aio.toptips.c) cVar, i3, objArr);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        TroopManager troopManager = (TroopManager) z().getManager(QQManagerFactory.TROOP_MANAGER);
        troopManager.x0(this.f180023e, (int) (System.currentTimeMillis() / 1000));
        troopManager.w0(this.f180023e, troopManager.z(this.f180023e) + 1);
        int id5 = view.getId();
        if (id5 == R.id.f164226nu) {
            y(view.getContext());
        } else if (id5 == R.id.f164237o5) {
            R();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
