package com.tencent.mobileqq.util;

import KQQ.ReqItem;
import KQQ.RespItem;
import KQQ.UserBitFlagReq;
import KQQ.UserBitFlagRes;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.LinearLayout;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qqsettingme.QQSettingMe;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.stt.ISttManagerApi;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.mobileqq.vas.quickupdate.QQLevelIconBusiness;
import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IGameCardManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.proxy.dlg.location.QbAddrData;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQSettingUtil {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements IGameCardManager.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f306447a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IGameCardManager.a f306448b;

        a(View view, IGameCardManager.a aVar) {
            this.f306447a = view;
            this.f306448b = aVar;
        }

        @Override // com.tencent.mobileqq.vip.IGameCardManager.b
        public void a(URLDrawable uRLDrawable) {
            View view = this.f306447a;
            if (view != null) {
                view.setVisibility(8);
            }
        }

        @Override // com.tencent.mobileqq.vip.IGameCardManager.b
        public void b(URLDrawable uRLDrawable) {
            View view = this.f306447a;
            if (view != null) {
                view.setVisibility(8);
            }
        }

        @Override // com.tencent.mobileqq.vip.IGameCardManager.b
        public void c(URLDrawable uRLDrawable) {
            String str;
            if (this.f306447a != null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(47.0f), ViewUtils.dip2px(15.0f));
                layoutParams.rightMargin = ViewUtils.dip2px(5.0f);
                layoutParams.gravity = 16;
                this.f306447a.setLayoutParams(layoutParams);
                this.f306447a.setVisibility(0);
                if (VasUtil.getService().getGameCardManager().isSelf(this.f306448b.f312734b)) {
                    str = "owner";
                } else {
                    str = IGameCardManager.VISITOR;
                }
                ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(String.valueOf(this.f306448b.f312738f), "4", SearchConstants.PLATFORM, IGameCardManager.DRAWER, str, 101, 1, System.currentTimeMillis());
            }
        }

        @Override // com.tencent.mobileqq.vip.IGameCardManager.b
        public void d(URLDrawable uRLDrawable) {
            uRLDrawable.restartDownload();
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b implements com.tencent.mobileqq.service.profile.a {

        /* renamed from: d, reason: collision with root package name */
        private QQAppInterface f306449d;

        public b(QQAppInterface qQAppInterface) {
            this.f306449d = qQAppInterface;
        }

        @Override // com.tencent.mobileqq.service.profile.a
        public ReqItem d2(int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("QQSetting", 2, "getCheckUpdateItemData");
            }
            ReqItem reqItem = new ReqItem();
            reqItem.cOperType = (byte) 1;
            reqItem.eServiceID = 106;
            UserBitFlagReq userBitFlagReq = new UserBitFlagReq();
            userBitFlagReq.cEmotionMall = (byte) 0;
            userBitFlagReq.cMyWallet = (byte) QQSettingUtil.e(this.f306449d);
            userBitFlagReq.cPtt2Text = (byte) 0;
            userBitFlagReq.cAccout2Dis = (byte) 0;
            reqItem.vecParam = userBitFlagReq.toByteArray();
            return reqItem;
        }

        @Override // com.tencent.mobileqq.service.profile.a
        public void l2(RespItem respItem) {
            if (QLog.isColorLevel()) {
                QLog.d("QQSetting", 2, "handleCheckUpdateItemData");
            }
            if (respItem.eServiceID == 106) {
                UserBitFlagRes userBitFlagRes = new UserBitFlagRes();
                userBitFlagRes.readFrom(new JceInputStream(respItem.vecUpdate));
                byte b16 = userBitFlagRes.cEmotionMall;
                byte b17 = userBitFlagRes.cMyWallet;
                byte b18 = userBitFlagRes.cAccout2Dis;
                if (QLog.isColorLevel()) {
                    QLog.d("QQSetting", 2, "vEmotion=" + ((int) b16) + ",cMyWallet=" + ((int) b17) + ",cPtt2Text=" + ((int) userBitFlagRes.cPtt2Text) + " ,cAccout2Dis=" + ((int) b18));
                }
                QQAppInterface qQAppInterface = this.f306449d;
                if (qQAppInterface != null) {
                    boolean z16 = false;
                    qQAppInterface.getApp().getApplicationContext().getSharedPreferences(this.f306449d.getCurrentAccountUin(), 0).edit().putInt(AppConstants.Preferences.MYWALLET_FLAG, b17).putInt(AppConstants.Preferences.SELECT_MEMBER_CONTACTS_FLAG, b18).commit();
                    ISttManagerApi iSttManagerApi = (ISttManagerApi) QRoute.api(ISttManagerApi.class);
                    QQAppInterface qQAppInterface2 = this.f306449d;
                    if (userBitFlagRes.cPtt2Text == 1) {
                        z16 = true;
                    }
                    iSttManagerApi.setSttAbility(qQAppInterface2, z16);
                }
            }
        }

        @Override // com.tencent.mobileqq.service.profile.a
        public int w0() {
            return 1;
        }
    }

    public static void a(final QQAppInterface qQAppInterface) {
        qQAppInterface.execute(new Runnable() { // from class: com.tencent.mobileqq.util.QQSettingUtil.1
            @Override // java.lang.Runnable
            public void run() {
                QQSettingUtil.b(QQAppInterface.this);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12, types: [int] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18, types: [int] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25, types: [int] */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v3, types: [int] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [int] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v79 */
    /* JADX WARN: Type inference failed for: r1v80 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [int] */
    static void b(QQAppInterface qQAppInterface) {
        int i3;
        int i16;
        int i17;
        ?? r112;
        ?? r113;
        ?? r114;
        ?? r115;
        String str;
        String str2;
        ?? r75;
        ?? r116;
        int i18;
        ?? r117;
        HashMap hashMap = new HashMap();
        BaseApplication app = qQAppInterface.getApp();
        boolean readValue = SettingCloneUtil.readValue((Context) app, (String) null, app.getString(R.string.czu), AppConstants.QQSETTING_AUTO_RECEIVE_PIC_KEY, true);
        hashMap.put("Clk_auto_receive_pic", Integer.valueOf(readValue ? 1 : 0));
        StatusManager statusManager = (StatusManager) qQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER);
        ?? r16 = readValue;
        if (statusManager != null) {
            r16 = statusManager.S();
        }
        hashMap.put("Clk_signature_qzone", Integer.valueOf((int) r16));
        boolean z16 = false;
        hashMap.put("Download_new", Integer.valueOf(ConfigHandler.g3(qQAppInterface, false) ? 1 : 0));
        hashMap.put("System_icon", Integer.valueOf(SettingCloneUtil.readValue((Context) app, (String) null, app.getString(R.string.hhh), AppConstants.QQSETTING_NOTIFY_ICON_KEY, false) ? 1 : 0));
        hashMap.put("Enter_sendmsg", Integer.valueOf(SettingCloneUtil.readValue((Context) app, (String) null, qQAppInterface.getApp().getString(R.string.cyo), AppConstants.QQSETTING_ENTER_SENDMSG_KEY, false) ? 1 : 0));
        hashMap.put("Mobile_pc_online", Integer.valueOf(SettingCloneUtil.readValue((Context) app, qQAppInterface.getCurrentAccountUin(), AppConstants.Preferences.LOGIN_ACCOUNTS, AppConstants.QQSETTING_BOTHONLINE_KEY, true) ? 1 : 0));
        hashMap.put("Visible_same", Integer.valueOf(qQAppInterface.getLocVisibilityForStatus() ? 1 : 0));
        hashMap.put("Same_likeme", Integer.valueOf(qQAppInterface.getLocZanAllowedForStatus() ? 1 : 0));
        hashMap.put("Search_number", Integer.valueOf(qQAppInterface.isPhoneNumSearchable(true) ? 1 : 0));
        hashMap.put("Visible_nearby", Integer.valueOf(((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getLocVisiblityForPeople(qQAppInterface.getAccount()) ? 1 : 0));
        hashMap.put("Nearby_likeme", Integer.valueOf(qQAppInterface.getLocZanAllowedForPeople() ? 1 : 0));
        if (qQAppInterface.getC2CRoamingSetting() == 0) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        hashMap.put("Latest_chatlog_syn", Integer.valueOf(i3));
        int i19 = 2;
        if (BaseGesturePWDUtil.getGesturePWDState(app, qQAppInterface.getCurrentAccountUin()) == 2) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        hashMap.put("Gesture_password", Integer.valueOf(i16));
        hashMap.put("Security_check", Integer.valueOf(SettingCloneUtil.readValue((Context) qQAppInterface.getApp(), (String) null, AppConstants.Preferences.SECURITY_SCAN_KEY, AppConstants.QQSETTING_SECURITY_SCAN_KEY, false) ? 1 : 0));
        if (BaseGesturePWDUtil.getGesturePWDState(app, qQAppInterface.getCurrentAccountUin()) == 2) {
            i17 = 1;
        } else {
            i17 = 0;
        }
        hashMap.put("Setting_Gesture_password", Integer.valueOf(i17));
        hashMap.put("Clk_hide_grp_heper", 0);
        hashMap.put("Clk_grp_heper_top", 0);
        try {
            for (String str3 : hashMap.keySet()) {
                ReportController.o(qQAppInterface, "CliStatus", "", "", "Setting_tab", str3, 0, 0, String.valueOf(hashMap.get(str3)), "", "", "");
                z16 = z16;
                i19 = i19;
            }
            int i26 = i19;
            boolean z17 = z16;
            if (SettingCloneUtil.readValue(qQAppInterface.getApp(), (String) null, qQAppInterface.getApp().getString(R.string.cyv), AppConstants.QQSETTING_SCREENSHOT_KEY, z17)) {
                r112 = 1;
            } else {
                r112 = z17;
            }
            ReportController.o(qQAppInterface, "CliStatus", "", "", "Setting_tab", "Shake_screenshot_switch", 0, 0, String.valueOf((int) r112), "", "", "");
            if (qQAppInterface.getVisibilityForNetWorkStatus(z17)) {
                r113 = 1;
            } else {
                r113 = z17;
            }
            ReportController.o(qQAppInterface, "CliStatus", "", "", "0X80044D1", "0X80044D1", 0, 0, String.valueOf((int) r113), "", "", "");
            int i27 = QQManagerFactory.FRIENDS_MANAGER;
            Card r17 = ((FriendsManager) qQAppInterface.getManager(i27)).r(qQAppInterface.getCurrentAccountUin());
            if (r17 != null) {
                if (r17.allowPeopleSee) {
                    r117 = 1;
                } else {
                    r117 = z17;
                }
                ReportController.o(qQAppInterface, "CliStatus", "", "", "0X8004884", "0X8004884", 0, 0, String.valueOf((int) r117), "", "", "");
            }
            if (qQAppInterface.getNotAllowedSeeMyDongtai(z17)) {
                r114 = 1;
            } else {
                r114 = z17;
            }
            ReportController.o(qQAppInterface, "CliStatus", "", "", "0X8004C5C", "0X8004C5C", 0, 0, String.valueOf((int) r114), "", "", "");
            if (qQAppInterface.getShieldHisDongtai(z17)) {
                r115 = 1;
            } else {
                r115 = z17;
            }
            ReportController.o(qQAppInterface, "CliStatus", "", "", "0X8004C5D", "0X8004C5D", 0, 0, String.valueOf((int) r115), "", "", "");
            FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(i27);
            int L = friendsManager.L();
            if (L > 0) {
                str = "1";
            } else {
                str = "0";
            }
            if (L > 0) {
                str2 = String.valueOf(L);
            } else {
                str2 = "";
            }
            ReportController.o(qQAppInterface, "CliStatus", "", "", "0X8004C69", "0X8004C69", 0, 0, str, str2, String.valueOf(friendsManager.K()), "");
            if (((ActivateFriendsManager) qQAppInterface.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).t(z17)) {
                r75 = 1;
            } else {
                r75 = z17;
            }
            ReportController.o(qQAppInterface, "CliStatus", "", "", "0X8004E0C", "0X8004E0C", 0, r75, String.valueOf((int) r75), "", "", "");
            if (qQAppInterface.isCallTabShow) {
                r116 = 1;
            } else {
                r116 = z17;
            }
            ReportController.o(qQAppInterface, "CliStatus", "", "", "0X8004EDE", "0X8004EDE", 0, 0, String.valueOf((int) r116), "", "", "");
            List<com.tencent.mobileqq.activity.contacts.topentry.a> n3 = ((CTEntryMng) qQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG)).n();
            if (n3 != null && n3.size() > 0) {
                for (com.tencent.mobileqq.activity.contacts.topentry.a aVar : n3) {
                    int i28 = aVar.f181757a;
                    if (aVar.f181769m) {
                        i18 = i26;
                    } else {
                        i18 = 1;
                    }
                    ReportController.o(qQAppInterface, "CliStatus", "", "", "0X80097A1", "0X80097A1", i28, 0, String.valueOf(i18), "", "", "");
                }
            }
        } catch (Exception unused) {
        }
    }

    public static URLDrawable c(View view, IGameCardManager.a aVar) {
        IGameCardManager gameCardManager = VasUtil.getService().getGameCardManager();
        aVar.f312734b = VasUtil.getCurrentUin();
        if (view != null) {
            view.setVisibility(8);
        }
        return gameCardManager.getGameCardDrawable(false, aVar, new a(view, aVar));
    }

    public static int d(Context context, String str) {
        return context.getSharedPreferences("mobileQQ", 0).getInt("setting_quit_" + str, 0);
    }

    public static int e(QQAppInterface qQAppInterface) {
        return qQAppInterface.getApp().getApplicationContext().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).getInt(AppConstants.Preferences.MYWALLET_FLAG, 1);
    }

    public static boolean f() {
        return QQSettingMe.P;
    }

    public static SpannableString g(Resources resources, int i3, int i16, int i17, boolean z16) {
        String str;
        String str2;
        String str3;
        Drawable drawable;
        int i18;
        int i19;
        if (resources == null) {
            return new SpannableString("");
        }
        QQLevelIconBusiness qQLevelIconBusiness = (QQLevelIconBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(QQLevelIconBusiness.class);
        if (!qQLevelIconBusiness.isFileExists(i3)) {
            qQLevelIconBusiness.startDownload(i3);
        }
        if (i16 == 0) {
            SpannableString spannableString = new SpannableString("*");
            int dimension = (int) resources.getDimension(R.dimen.b7w);
            Drawable optimizedApngDrawable = VasApngUtil.getOptimizedApngDrawable(LevelUtil.getQQLevelIconPathByType(i3, LevelUtil.QQ_LEVEL_TYPE_HALF_STAR), resources.getDrawable(R.drawable.hax), VasApngUtil.VIP_APNG_TAGS, "halfStar", z16);
            optimizedApngDrawable.setBounds(0, 0, dimension, dimension);
            optimizedApngDrawable.setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            spannableString.setSpan(new ImageSpan(optimizedApngDrawable), 0, 1, 33);
            return spannableString;
        }
        int i26 = i16 / 64;
        int i27 = i16 % 64;
        int i28 = i27 / 16;
        int i29 = i27 % 16;
        int i36 = i29 / 4;
        int i37 = 4;
        int i38 = i29 % 4;
        String str4 = "";
        int i39 = 0;
        while (true) {
            String str5 = "%";
            str = "!";
            if (i39 >= i37) {
                break;
            }
            if (i39 == 0) {
                str5 = "!";
                i19 = i26;
            } else if (i39 == 1) {
                str5 = "@";
                i19 = i28;
            } else if (i39 == 2) {
                str5 = "#";
                i19 = i36;
            } else if (i39 != 3) {
                str5 = "";
                i19 = 0;
            } else {
                i19 = i38;
            }
            for (int i46 = 0; i46 < i19; i46++) {
                str4 = str4 + str5;
            }
            i39++;
            i37 = 4;
        }
        if (i17 > 1 && str4.length() > i17) {
            str4 = str4.substring(0, i17 - 1) + "$";
        }
        if (i17 <= 1) {
            str4 = "$";
        }
        SpannableString spannableString2 = new SpannableString(str4);
        int dimension2 = (int) resources.getDimension(R.dimen.b7w);
        if (i3 == 0) {
            dimension2 = Utils.n(18.0f, resources);
        }
        int i47 = 0;
        while (i47 < str4.length()) {
            int i48 = i47 + 1;
            String substring = str4.substring(i47, i48);
            if (str.equalsIgnoreCase(substring)) {
                str2 = str;
                str3 = str4;
                drawable = VasApngUtil.getOptimizedApngDrawable(LevelUtil.getQQLevelIconPathByType(i3, LevelUtil.QQ_LEVEL_TYPE_CROWN), resources.getDrawable(R.drawable.hav), VasApngUtil.VIP_APNG_TAGS, "crown", z16);
            } else {
                str2 = str;
                str3 = str4;
                if ("@".equalsIgnoreCase(substring)) {
                    drawable = VasApngUtil.getOptimizedApngDrawable(LevelUtil.getQQLevelIconPathByType(i3, LevelUtil.QQ_LEVEL_TYPE_SUN), resources.getDrawable(R.drawable.haz), VasApngUtil.VIP_APNG_TAGS, "sun", z16);
                } else if ("#".equalsIgnoreCase(substring)) {
                    drawable = VasApngUtil.getOptimizedApngDrawable(LevelUtil.getQQLevelIconPathByType(i3, LevelUtil.QQ_LEVEL_TYPE_MOON), resources.getDrawable(R.drawable.haw), VasApngUtil.VIP_APNG_TAGS, "moon", z16);
                } else if ("%".equalsIgnoreCase(substring)) {
                    drawable = VasApngUtil.getOptimizedApngDrawable(LevelUtil.getQQLevelIconPathByType(i3, LevelUtil.QQ_LEVEL_TYPE_STAR), resources.getDrawable(R.drawable.hay), VasApngUtil.VIP_APNG_TAGS, "star", z16);
                } else if ("$".equalsIgnoreCase(substring)) {
                    drawable = resources.getDrawable(R.drawable.b7g);
                } else {
                    drawable = null;
                }
            }
            if (drawable != null) {
                if (ContainerUtils.FIELD_DELIMITER.equalsIgnoreCase(substring)) {
                    i18 = 0;
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                } else {
                    i18 = 0;
                    drawable.setBounds(0, 0, dimension2, dimension2);
                }
                drawable.setColorFilter(i18, PorterDuff.Mode.SRC_ATOP);
                spannableString2.setSpan(new ImageSpan(drawable), i47, i48, 33);
            }
            i47 = i48;
            str = str2;
            str4 = str3;
        }
        String str6 = str4;
        if (QLog.isDevelopLevel()) {
            QLog.i("QQSettingMe", 4, "parseQQLevel, sLevel = " + str6 + ", span = " + ((Object) spannableString2));
        }
        return spannableString2;
    }

    public static void h(QQAppInterface qQAppInterface) {
        if (qQAppInterface != null) {
            StatisticCollector.getInstance(null).reportToPCliOper(qQAppInterface, "Vip_pay_mywallet" + QbAddrData.DATA_SPLITER + qQAppInterface.getCurrentAccountUin() + QbAddrData.DATA_SPLITER + "" + QbAddrData.DATA_SPLITER + QCircleDaTongConstant.ElementParamValue.WALLET + QbAddrData.DATA_SPLITER + "index" + QbAddrData.DATA_SPLITER + 0 + QbAddrData.DATA_SPLITER + 1 + QbAddrData.DATA_SPLITER + 0 + QbAddrData.DATA_SPLITER + "" + QbAddrData.DATA_SPLITER + "" + QbAddrData.DATA_SPLITER + "" + QbAddrData.DATA_SPLITER + "" + QbAddrData.DATA_SPLITER);
        }
    }

    public static void i(Context context, String str, int i3) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mobileQQ", 0).edit();
        edit.putInt("setting_quit_" + str, i3);
        edit.commit();
    }
}
