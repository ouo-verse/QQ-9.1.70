package com.tencent.mobileqq.troop.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.ecommerce.base.QQECChannel;
import com.tencent.image.URLDrawable;
import com.tencent.luggage.wxa.xd.c0;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import com.tencent.mobileqq.guild.jump.model.GuildShareUrlParam;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.appscenter.api.ITroopAppsApi;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.troop.troopapps.a;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.utils.IQZoneGroupAlbumArkUtil;

/* compiled from: P */
/* loaded from: classes19.dex */
public class r {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    view.setAlpha(1.0f);
                    return false;
                }
                return false;
            }
            view.setAlpha(0.5f);
            return false;
        }
    }

    public static Drawable a(Context context, String str, float f16, float f17) {
        URLDrawable uRLDrawable;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = false;
        int dpToPx = ViewUtils.dpToPx(f16);
        obtain.mRequestHeight = dpToPx;
        obtain.mRequestWidth = dpToPx;
        obtain.mFailedDrawable = context.getResources().getDrawable(R.drawable.qb_troop_default_app);
        obtain.mLoadingDrawable = context.getResources().getDrawable(R.drawable.qb_troop_default_app);
        try {
            uRLDrawable = URLDrawable.getDrawable(str, obtain);
            if (f17 > 0.0f) {
                try {
                    uRLDrawable.setTag(com.tencent.mobileqq.urldrawable.a.c(dpToPx, dpToPx, ViewUtils.dpToPx(f17)));
                    uRLDrawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
                } catch (Exception e16) {
                    e = e16;
                    e.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.e("TroopAppShortcutUtils", 2, "getIcon url: " + str);
                    }
                    return uRLDrawable;
                }
            }
            if (uRLDrawable.getStatus() == 2) {
                uRLDrawable.restartDownload();
            }
        } catch (Exception e17) {
            e = e17;
            uRLDrawable = null;
        }
        return uRLDrawable;
    }

    public static void b(int i3, long j3, QQAppInterface qQAppInterface, Context context, Activity activity) {
        long j16;
        TroopInfo k3;
        if (h(qQAppInterface, j3)) {
            TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            int i16 = 0;
            if (troopManager != null && (k3 = troopManager.k(String.valueOf(j3))) != null) {
                j16 = k3.dwGroupClassExt;
                if (k3.isTroopOwner(qQAppInterface.getCurrentUin())) {
                    i16 = 1;
                } else if (k3.isTroopAdmin(qQAppInterface.getCurrentUin())) {
                    i16 = 2;
                }
            } else {
                j16 = 0;
            }
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", "https://qun.qq.com/slidepanel/manage?_wv=16777218&_cwv=9&_wwv=129&gc=$GCODE$&gid=$GID$&gtype=$GTYPE$&gfrom=$GFROM".replace("$GCODE$", Long.toString(j3)).replace("$GID$", Integer.toString(i16)).replace("$GTYPE$", Long.toString(j16)).replace("$GFROM", Integer.toString(i3)));
            intent.putExtra("webStyle", "noBottomBar");
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            activity.startActivityForResult(intent, 20006);
            if (i3 == 1) {
                ReportController.o(null, "dc00898", "", Long.toString(j3), "0X800AD0B", "0X800AD0B", 0, 0, String.valueOf(j16), "", "", "");
            } else if (i3 == 2) {
                ReportController.o(null, "dc00898", "", Long.toString(j3), "0X800AFC6", "0X800AFC6", 0, 0, String.valueOf(j16), "", "", "");
            }
        }
    }

    public static void c(long j3, QQAppInterface qQAppInterface, Context context, Activity activity) {
        long j16;
        TroopInfo k3;
        if (h(qQAppInterface, j3)) {
            TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            int i3 = 0;
            if (troopManager != null && (k3 = troopManager.k(String.valueOf(j3))) != null) {
                j16 = k3.dwGroupClassExt;
                if (k3.isTroopOwner(qQAppInterface.getCurrentUin())) {
                    i3 = 1;
                } else if (k3.isTroopAdmin(qQAppInterface.getCurrentUin())) {
                    i3 = 2;
                }
            } else {
                j16 = 0;
            }
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", "https://qun.qq.com/slidepanel/search?_wv=16777218&_cwv=9&_wwv=129&gc=$GCODE$&gid=$GID$&gtype=$GTYPE$".replace("$GCODE$", Long.toString(j3)).replace("$GID$", Integer.toString(i3)).replace("$GTYPE$", Long.toString(j16)));
            intent.putExtra("webStyle", "noBottomBar");
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            activity.startActivityForResult(intent, 20007);
        }
    }

    private static void d(String str, QQAppInterface qQAppInterface, Context context, Activity activity, String str2, long j3, TroopInfo troopInfo, boolean z16, int i3) {
        String k3 = k(qQAppInterface, str2, str, j3, troopInfo, z16, i3);
        com.tencent.mobileqq.utils.ax c16 = bi.c(qQAppInterface, context, k3);
        if (c16 != null) {
            QLog.i("TroopAppShortcutUtils", 1, "JumpAction, Action found, executing action");
            c16.b();
            return;
        }
        QLog.i("TroopAppShortcutUtils", 1, "JumpAction, No action found, starting JumpActivity");
        Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse(k3));
        if (activity != null) {
            activity.startActivity(intent);
        } else {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static void e(QQAppInterface qQAppInterface, Context context, Activity activity, String str, long j3, String str2, int i3, int i16, boolean z16) {
        f(qQAppInterface, context, activity, str, j3, str2, i3, i16, z16, false);
    }

    public static void f(QQAppInterface qQAppInterface, Context context, Activity activity, String str, long j3, String str2, int i3, int i16, boolean z16, boolean z17) {
        int i17;
        TroopInfo troopInfo;
        String str3;
        int i18;
        String str4;
        int i19;
        if (qQAppInterface != null && context != null && !TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopAppShortcutUtils", 2, "handlerAppAction, activity=" + activity + ",troopUin:" + str + ",appId:" + j3 + ", appUrl:" + str2 + ", from:" + i3 + ", redPoint:" + i16);
            }
            TroopInfo k3 = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k(str);
            if (k3 == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TroopAppShortcutUtils", 2, "OnClickListener. troopInfo is null.");
                    return;
                }
                return;
            }
            if (i16 != 0 || z17) {
                ((qt2.a) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).v2(str, (int) j3);
                ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).clearTroopShortCutBarAppRedPoint(qQAppInterface, str, j3);
            }
            if (j3 == 102075478) {
                ((IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class)).openNoticeListPage(activity, str);
                return;
            }
            if (j3 == 102083361) {
                ((IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class)).openClockInListPage(activity, str);
                return;
            }
            if (j3 == 101761547 && activity != null) {
                com.tencent.mobileqq.listentogether.g.b(qQAppInterface, activity, 1, str, 0);
                return;
            }
            if (j3 == 101817424) {
                g(qQAppInterface, context, k3, str);
                return;
            }
            if (j3 == 101847770) {
                Intent intent = new Intent();
                intent.putExtra("troop_uin", str);
                intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 19);
                intent.putExtra(AppConstants.Key.TROOP_INFO_MEMBER_NUM, k3.wMemberNum);
                RouteUtils.startActivity(context, intent, "/troop/memberlist/TroopMemberList");
                return;
            }
            if (((IQZoneGroupAlbumArkUtil) QRoute.api(IQZoneGroupAlbumArkUtil.class)).isFromShortcutUrl(j3)) {
                ((IQZoneGroupAlbumArkUtil) QRoute.api(IQZoneGroupAlbumArkUtil.class)).jumpToGroupAlbumEntry(context, str);
                return;
            }
            if (j3 == 101872203 && activity != null) {
                return;
            }
            if (j3 == 102061052) {
                i(context, k3, qQAppInterface.getCurrentUin());
                return;
            }
            int i26 = 8;
            if (j3 == 1109863013 && activity != null) {
                Intent intent2 = new Intent();
                intent2.putExtra("troop_uin", str);
                intent2.putExtra("is_from_app_item_clk", true);
                ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).openTroopManageForResult(activity, intent2, k3.isTroopOwner(qQAppInterface.getCurrentUin()), 8);
                return;
            }
            if (j3 == 101914115) {
                QQGameTroopManager.p(i3, str, false);
            }
            if (j3 == 1101236949 && QVipBigTroopExpiredProcessor.getConfig().mIsEnable && k3.mIsFreezed == 1 && (k3.isOwnerOrAdmin() || k3.isTroopOwner(qQAppInterface.getCurrentAccountUin()))) {
                boolean a16 = TroopManager.g.a(k3.groupFreezeReason);
                if (k3.isTroopOwner(qQAppInterface.getCurrentAccountUin())) {
                    if (a16) {
                        i26 = 15;
                    }
                    String spannableString = ff.j(0, i26).toString();
                    String qqStr = HardCodeUtil.qqStr(R.string.j6l);
                    a aVar = new a();
                    if (a16) {
                        str4 = "0X800A57F";
                    } else {
                        str4 = "0X8009E38";
                    }
                    String str5 = str4;
                    if (a16) {
                        i19 = 1;
                    } else {
                        i19 = 3;
                    }
                    i17 = 1;
                    troopInfo = k3;
                    str3 = "TroopAppShortcutUtils";
                    ff.b0(context, str, spannableString, qqStr, aVar, str5, i19, a16);
                } else {
                    i17 = 1;
                    troopInfo = k3;
                    str3 = "TroopAppShortcutUtils";
                    ff.d0(context, a16);
                }
            } else {
                i17 = 1;
                troopInfo = k3;
                str3 = "TroopAppShortcutUtils";
            }
            if (i3 == 0) {
                i18 = 4008;
            } else {
                i18 = 4007;
            }
            int i27 = i18;
            if (str2 == null) {
                QLog.e(str3, i17, "handlerAppAction: appUrl is null");
                return;
            }
            if (z16 && j3 == 10000) {
                ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).gotoGuild(context, new GuildShareUrlParam(str2));
                return;
            }
            if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str2)) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, k(qQAppInterface, str, str2, j3, troopInfo, true, i16), i27, ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).createEntryModel(troopInfo, str), null);
                return;
            }
            TroopInfo troopInfo2 = troopInfo;
            if (!str2.startsWith("http") && !str2.startsWith("https")) {
                if (!str2.startsWith("mqqapi://") && !str2.startsWith("qqfav://operation/") && !str2.startsWith("nowmqqapi://now/openroom") && !str2.startsWith("mqqguild://")) {
                    if (str2.startsWith("local")) {
                        ((ITroopAppsApi) QRoute.api(ITroopAppsApi.class)).openNewPage(context, String.valueOf(str), i17);
                        return;
                    }
                    return;
                } else {
                    if (j3 == 102438828) {
                        d(str2, qQAppInterface, context, activity, str, j3, troopInfo2, true, i16);
                        return;
                    }
                    String k16 = k(qQAppInterface, str, str2, j3, troopInfo2, true, i16);
                    Intent intent3 = new Intent(context, (Class<?>) JumpActivity.class);
                    intent3.setData(Uri.parse(k16));
                    if (activity != null) {
                        activity.startActivity(intent3);
                        return;
                    } else {
                        intent3.addFlags(268435456);
                        context.startActivity(intent3);
                        return;
                    }
                }
            }
            Intent intent4 = new Intent(context, (Class<?>) QQBrowserDelegationActivity.class);
            intent4.putExtra("url", k(qQAppInterface, str, str2, j3, troopInfo2, true, i16));
            intent4.putExtra("webStyle", "noBottomBar");
            intent4.putExtra("startOpenPageTime", System.currentTimeMillis());
            n(intent4, j3);
            if (activity != null) {
                activity.startActivity(intent4);
            } else {
                intent4.addFlags(268435456);
                context.startActivity(intent4);
            }
        }
    }

    public static void g(QQAppInterface qQAppInterface, Context context, TroopInfo troopInfo, String str) {
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        tr2.b bVar = (tr2.b) qQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
        boolean B = bVar.B(4, -1, str);
        Bundle e16 = tr2.g.e(B, troopInfo.isTroopOwner(currentAccountUin), troopInfo.isOwnerOrAdmin(), troopInfo.troopowneruin, str, 0);
        if (B) {
            bVar.D(context, str, 1, 4, 0, e16);
        } else {
            bVar.S(context, str, 1, 4, 0, e16);
        }
    }

    public static boolean h(QQAppInterface qQAppInterface, long j3) {
        if (!((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(qQAppInterface, Long.toString(j3), qQAppInterface.getCurrentUin()) && !TroopUtils.B(qQAppInterface, Long.toString(j3), qQAppInterface.getCurrentUin())) {
            return false;
        }
        return true;
    }

    public static void i(Context context, TroopInfo troopInfo, String str) {
        int id5 = QQECChannel.CHANNEL_QQ_GROUP.getId();
        String format = String.format("mqqapi://ecommerce/open?target=7&channel=%d&window_type=1&src_type=internal&version=1", Integer.valueOf(id5));
        if (!troopInfo.isTroopOwner(str)) {
            format = String.format("mqqapi://ecommerce/open?target=7&channel=%d&seller_uin=%s&window_type=1&src_type=internal&version=1", Integer.valueOf(id5), troopInfo.troopowneruin);
        }
        Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse(format));
        context.startActivity(intent);
    }

    public static void j(QQAppInterface qQAppInterface, a.C8785a c8785a, long j3) {
        com.tencent.mobileqq.troop.shortcutbar.e eVar;
        TroopManager troopManager;
        TroopInfo k3;
        boolean z16;
        if (c8785a == null || (eVar = (com.tencent.mobileqq.troop.shortcutbar.e) com.tencent.mobileqq.config.am.s().x(c0.CTRL_INDEX)) == null || (troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)) == null || (k3 = troopManager.k(String.valueOf(j3))) == null) {
            return;
        }
        c8785a.f299354c = eVar.b((int) k3.dwGroupClassExt);
        if (eVar.f298638c == com.tencent.mobileqq.troop.shortcutbar.e.f298635g) {
            z16 = true;
        } else {
            z16 = false;
        }
        c8785a.f299355d = z16;
        if (k3.isHomeworkTroop()) {
            c8785a.f299354c = false;
            c8785a.f299355d = false;
        }
    }

    private static String k(QQAppInterface qQAppInterface, String str, String str2, long j3, TroopInfo troopInfo, boolean z16, int i3) {
        String str3;
        String str4 = "1";
        if (troopInfo.isTroopOwner(qQAppInterface.getCurrentAccountUin())) {
            str3 = "0";
        } else if (troopInfo.isOwnerOrAdmin()) {
            str3 = "1";
        } else {
            str3 = "2";
        }
        String replace = str2.replace("$GCODE$", str).replace("$CLIENTVER$", "android" + AppSetting.f99551k).replace("$UIN$", qQAppInterface.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(j3)).replace("$ROLE$", str3);
        if (!z16) {
            str4 = "2";
        }
        String replace2 = replace.replace("$ENTERSOURCE$", str4).replace("$GUIN$", str).replace("$UNREADNUM$", String.valueOf(i3));
        if (!TextUtils.isEmpty(troopInfo.troopNameFromNT)) {
            return replace2.replace("$GNAME$", troopInfo.troopNameFromNT);
        }
        return replace2;
    }

    public static void l(Context context, ImageView imageView, String str, float f16, boolean z16) {
        if (context != null && imageView != null) {
            if (!TextUtils.isEmpty(str)) {
                float f17 = f16 / 10.0f;
                try {
                    imageView.setImageDrawable(a(context, str, f16, f17));
                    m(imageView, z16, f17);
                    return;
                } catch (Exception e16) {
                    QLog.e("TroopAppShortcutUtils", 1, "fetchDrawable: failed. ", e16);
                    imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.qb_troop_default_app));
                    m(imageView, false, 0.0f);
                    return;
                }
            }
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.qb_troop_default_app));
            m(imageView, false, 0.0f);
        }
    }

    public static void m(View view, boolean z16, float f16) {
        if (view == null) {
            return;
        }
        if (z16) {
            int dpToPx = ViewUtils.dpToPx(0.5f);
            view.setPadding(dpToPx, dpToPx, dpToPx, dpToPx);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(ViewUtils.dpToPx(f16));
            gradientDrawable.setStroke(ViewUtils.dpToPx(0.5f), Color.parseColor("#FFE5E5E5"));
            view.setBackground(gradientDrawable);
            return;
        }
        view.setPadding(0, 0, 0, 0);
        view.setBackground(null);
    }

    private static void n(Intent intent, long j3) {
        String str;
        if (intent == null) {
            return;
        }
        if (j3 == 101914115) {
            str = "biz_src_zf_games";
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("big_brother_source_key", str);
        }
    }

    public static void o(View view) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new b());
    }
}
