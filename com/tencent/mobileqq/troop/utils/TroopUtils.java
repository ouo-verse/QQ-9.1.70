package com.tencent.mobileqq.troop.utils;

import NearbyGroup.GroupInfo;
import NearbyGroup.GroupLabel;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.fragment.app.Fragment;
import com.tencent.biz.JoinGroupTransitActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopShareApi;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.file.api.ITroopFileApi;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi;
import com.tencent.mobileqq.troop.troopcard.api.IVisitorTroopCardApi;
import com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingFragmentV2;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingApi;
import com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troopshare.e;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.vas.IConfigProxy;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import cooperation.qzone.QZoneHelper;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_common$GroupInfo;
import tencent.im.msg.im_common$User;
import tencent.im.msg.im_imagent$ImAgentHead;
import tencent.im.msg.im_imagent$ImAgentPackage;
import tencent.im.msg.im_imagent$Signature;
import tencent.im.msg.im_msg$ContentHead;
import tencent.im.msg.im_msg$Group;
import tencent.im.msg.im_msg$Msg;
import tencent.im.msg.im_msg$MsgHead;
import tencent.im.msg.im_msg$MsgSendReq;
import tencent.im.msg.im_msg$RoutingHead;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$GeneralFlags;
import tencent.im.msg.im_msg_body$MsgBody;
import tencent.im.msg.im_msg_body$RichText;
import tencent.im.msg.im_msg_body$Text;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected static String f301977a;

    /* renamed from: b, reason: collision with root package name */
    protected static String f301978b;

    /* renamed from: c, reason: collision with root package name */
    private static int f301979c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f301980d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile Boolean f301981e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements e.InterfaceC8850e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TroopInfoData f301987a;

        a(TroopInfoData troopInfoData) {
            this.f301987a = troopInfoData;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopInfoData);
            }
        }

        @Override // com.tencent.mobileqq.troopshare.e.InterfaceC8850e
        public void a(int i3, boolean z16) {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            if (this.f301987a.isMember) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 9) {
                            if (i3 != 10) {
                                str = "";
                            } else {
                                str = "share_circle";
                            }
                        } else {
                            str = "share_wechat";
                        }
                    } else {
                        str = "share_qzone";
                    }
                } else {
                    str = "share_qq";
                }
                String str3 = str;
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                String[] strArr = new String[3];
                TroopInfoData troopInfoData = this.f301987a;
                strArr[0] = troopInfoData.troopUin;
                strArr[1] = eu.c(troopInfoData);
                if (z16) {
                    str2 = "0";
                } else {
                    str2 = "1";
                }
                strArr[2] = str2;
                eu.g("Grp_share", "grpData_admin", str3, 0, 0, strArr);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76804);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f301977a = "https://qun.qq.com/qqweb/m/qunopen/appstore/index.html?_wv=1031&_bid=2195&sonic=1&gc=";
        f301978b = "https://qqweb.qq.com/m/qunactivity/index.html?_wv=3&_bid=244&from=aio&groupuin=";
        f301979c = (int) (System.currentTimeMillis() & (-1));
        f301980d = true;
    }

    public static boolean A(QQAppInterface qQAppInterface, MessageRecord messageRecord, String str) {
        TroopInfo k3;
        if (messageRecord.istroop != 1 || TextUtils.equals(messageRecord.senderuin, str) || (k3 = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k(messageRecord.frienduin)) == null) {
            return false;
        }
        if (k3.isTroopOwner(str)) {
            return true;
        }
        if (!k3.isTroopAdmin(str) || k3.isTroopOwner(messageRecord.senderuin) || k3.isTroopAdmin(messageRecord.senderuin)) {
            return false;
        }
        return true;
    }

    public static boolean B(AppRuntime appRuntime, String str, String str2) {
        return com.tencent.mobileqq.troop.util.a.b(appRuntime, str, str2);
    }

    public static boolean C(QQAppInterface qQAppInterface, String str, String str2) {
        TroopInfo k3 = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k(str);
        if (k3 == null) {
            return false;
        }
        if (!k3.isTroopOwner(str2) && !k3.isTroopAdmin(str2)) {
            return false;
        }
        return true;
    }

    public static void D(Context context, RecommendTroopItem recommendTroopItem, int i3) {
        String J2 = JoinGroupTransitActivity.J2(recommendTroopItem.uin, i3, recommendTroopItem.authSig);
        Intent intent = new Intent(context, (Class<?>) JoinGroupTransitActivity.class);
        intent.putExtra("source_scheme", J2);
        context.startActivity(intent);
    }

    public static void E(Context context, Object obj, int i3) {
        D(context, (RecommendTroopItem) obj, i3);
    }

    public static void F(Context context, String str, int i3, String str2, String str3) {
        String J2 = JoinGroupTransitActivity.J2(str, i3, str2);
        Intent intent = new Intent(context, (Class<?>) JoinGroupTransitActivity.class);
        intent.putExtra("source_scheme", J2);
        if (!TextUtils.isEmpty(str3)) {
            intent.putExtra("param_scene_target_id", str3);
        }
        context.startActivity(intent);
    }

    public static void G(Context context, RecommendTroopItem recommendTroopItem, int i3, int i16) {
        GroupInfo groupInfo = new GroupInfo();
        try {
            groupInfo.lCode = Long.valueOf(recommendTroopItem.uin).longValue();
            groupInfo.strName = recommendTroopItem.name;
            if (TextUtils.isEmpty(recommendTroopItem.recommendReason)) {
                groupInfo.strIntro = recommendTroopItem.intro;
            } else {
                groupInfo.strIntro = recommendTroopItem.recommendReason;
            }
            groupInfo.iMemberCnt = recommendTroopItem.memberNum;
            ArrayList<GroupLabel> c16 = com.tencent.biz.addContactTroopView.b.c(recommendTroopItem);
            if (c16 != null) {
                groupInfo.labels = c16;
            }
            groupInfo.strJoinSig = recommendTroopItem.authSig;
            I(context, k(i3, groupInfo, i16, false), 2);
        } catch (Exception unused) {
            QLog.d("TroopMemberUtil", 1, "cast string2long error");
        }
    }

    public static void H(Context context, Object obj, int i3, int i16) {
        G(context, (RecommendTroopItem) obj, i3, i16);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004f A[Catch: Exception -> 0x00a1, TryCatch #0 {Exception -> 0x00a1, blocks: (B:5:0x0006, B:7:0x0012, B:8:0x0017, B:10:0x001f, B:12:0x0031, B:15:0x0043, B:17:0x004f, B:19:0x0055, B:22:0x0080, B:24:0x0086), top: B:4:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0086 A[Catch: Exception -> 0x00a1, TRY_LEAVE, TryCatch #0 {Exception -> 0x00a1, blocks: (B:5:0x0006, B:7:0x0012, B:8:0x0017, B:10:0x001f, B:12:0x0031, B:15:0x0043, B:17:0x004f, B:19:0x0055, B:22:0x0080, B:24:0x0086), top: B:4:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void I(Context context, Bundle bundle, int i3) {
        boolean z16;
        TroopManager troopManager;
        if (context != null) {
            try {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                boolean z17 = bundle.getBoolean("troop_info_from_troopsetting", false);
                if (i3 == -1 && (troopManager = (TroopManager) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.TROOP_MANAGER)) != null) {
                    if (troopManager.k(bundle.getString("troop_uin")) != null) {
                        i3 = 1;
                        z16 = true;
                        intent.putExtra(ITroopUtilsApi.VISTOR_TYPE, i3);
                        if (!v(i3, z16, z17)) {
                            if (AppSetting.t(context)) {
                                com.tencent.mobileqq.pad.i.e(context, intent.getExtras(), ((ITroopSettingApi) QRoute.api(ITroopSettingApi.class)).getTroopSettingFragmentClass(), new com.tencent.mobileqq.pad.b().e(false).g(false).h(LaunchMode.standard).a());
                                return;
                            } else {
                                QPublicFragmentActivity.start(context, intent, TroopSettingFragmentV2.class);
                                return;
                            }
                        }
                        QPublicFragmentActivity.start(context, intent, ((IVisitorTroopCardApi) QRoute.api(IVisitorTroopCardApi.class)).getVisitorTroopCardFragmentClass(bundle.getInt(AppConstants.Key.TROOP_INFO_FROM, -1), bundle.getBoolean("troop_info_from_troopsetting", false)));
                        return;
                    }
                    i3 = 2;
                }
                z16 = false;
                intent.putExtra(ITroopUtilsApi.VISTOR_TYPE, i3);
                if (!v(i3, z16, z17)) {
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopMemberUtil", 2, e16.toString());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004f A[Catch: Exception -> 0x00a9, TryCatch #0 {Exception -> 0x00a9, blocks: (B:5:0x0006, B:7:0x0012, B:8:0x0017, B:10:0x001f, B:12:0x0031, B:15:0x0043, B:17:0x004f, B:19:0x0055, B:21:0x0059, B:24:0x0084, B:26:0x008c), top: B:4:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008c A[Catch: Exception -> 0x00a9, TRY_LEAVE, TryCatch #0 {Exception -> 0x00a9, blocks: (B:5:0x0006, B:7:0x0012, B:8:0x0017, B:10:0x001f, B:12:0x0031, B:15:0x0043, B:17:0x004f, B:19:0x0055, B:21:0x0059, B:24:0x0084, B:26:0x008c), top: B:4:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void J(Context context, Bundle bundle, int i3, int i16) {
        boolean z16;
        TroopManager troopManager;
        if (context != null) {
            try {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                boolean z17 = bundle.getBoolean("troop_info_from_troopsetting", false);
                if (i3 == -1 && (troopManager = (TroopManager) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.TROOP_MANAGER)) != null) {
                    if (troopManager.k(bundle.getString("troop_uin")) != null) {
                        i3 = 1;
                        z16 = true;
                        intent.putExtra(ITroopUtilsApi.VISTOR_TYPE, i3);
                        if (!v(i3, z16, z17)) {
                            if (AppSetting.t(context) && (context instanceof com.tencent.mobileqq.pad.l)) {
                                com.tencent.mobileqq.pad.i.e(context, intent.getExtras(), ((ITroopSettingApi) QRoute.api(ITroopSettingApi.class)).getTroopSettingFragmentClass(), new com.tencent.mobileqq.pad.b().e(false).g(false).h(LaunchMode.standard).a());
                                return;
                            } else {
                                QPublicFragmentActivity.b.f(context, intent, QPublicFragmentActivity.class, TroopSettingFragmentV2.class, i16);
                                return;
                            }
                        }
                        QPublicFragmentActivity.startForResult((Activity) context, intent, ((IVisitorTroopCardApi) QRoute.api(IVisitorTroopCardApi.class)).getVisitorTroopCardFragmentClass(bundle.getInt(AppConstants.Key.TROOP_INFO_FROM, -1), bundle.getBoolean("troop_info_from_troopsetting", false)), i16);
                        return;
                    }
                    i3 = 2;
                }
                z16 = false;
                intent.putExtra(ITroopUtilsApi.VISTOR_TYPE, i3);
                if (!v(i3, z16, z17)) {
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopMemberUtil", 2, e16.toString());
                }
            }
        }
    }

    public static void K(QQAppInterface qQAppInterface, Context context, String str) {
        TroopInfo k3;
        if (QLog.isColorLevel()) {
            QLog.i("TroopMemberUtil", 2, "openTroopInfoActivityFromAIO." + str);
        }
        if (context == null) {
            return;
        }
        TroopInfoData troopInfoData = new TroopInfoData();
        troopInfoData.troopUin = str;
        TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null && (k3 = troopManager.k(str)) != null) {
            if (k3.isOwnerOrAdmin()) {
                troopInfoData.updateForTroopChatSetting(k3, context.getResources(), qQAppInterface.getCurrentAccountUin());
                troopInfoData.isMember = true;
                Bundle c16 = aq.c(str, 115, troopInfoData.troopLat, troopInfoData.troopLon, troopInfoData.cityId, troopInfoData.troopLocation);
                c16.putInt(AppConstants.Key.TROOP_INFO_TROOP_TYPE_EX, troopInfoData.troopTypeExt);
                c16.putInt("PARAM_EXIT_ANIMATION", 2);
                ((ITroopInfoActivityApi) QRoute.api(ITroopInfoActivityApi.class)).openTroopProfile(context, c16);
                return;
            }
            ThreadManager.getUIHandler().post(new Runnable(context) { // from class: com.tencent.mobileqq.troop.utils.TroopUtils.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Context f301985d;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.troop.utils.TroopUtils$3$a */
                /* loaded from: classes19.dex */
                class a implements DialogInterface.OnClickListener {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
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

                {
                    this.f301985d = context;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        Context context2 = this.f301985d;
                        DialogUtil.createCustomDialog(context2, 230, (String) null, context2.getString(R.string.vzl), this.f301985d.getString(R.string.f171151ok), (String) null, (DialogInterface.OnClickListener) null, new a()).show();
                    }
                }
            });
        }
    }

    public static void L(QQAppInterface qQAppInterface, Context context, String str, String str2) {
        if (qQAppInterface != null && str != null && context != null) {
            Intent intent = new Intent();
            intent.putExtra("troop_uin", str);
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("focusItem", str2);
            }
            TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(str);
            if (troopInfoFromCache != null && troopInfoFromCache.hadJoinTroop()) {
                J(context, intent.getExtras(), 1, 2000);
            }
        }
    }

    @WorkerThread
    public static void M(QQAppInterface qQAppInterface, String str, String str2) {
        if (qQAppInterface == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !s()) {
            return;
        }
        com.tencent.mobileqq.app.n nVar = (com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        if (nVar.h(str2) == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberUtil", 2, "handleDiscussToTroopOp has handle troopUin = " + str + ", discUin = " + str2);
                return;
            }
            return;
        }
        RecentUserProxy recentUserProxy = qQAppInterface.getRecentUserProxy();
        RecentUser findRecentUser = recentUserProxy.findRecentUser(str2, 3000);
        nVar.H(str, str2);
        nVar.d(str2);
        RecentUser findRecentUserByUin = recentUserProxy.findRecentUserByUin(str, 1);
        if (findRecentUser != null) {
            findRecentUserByUin.lastmsgtime = Math.max(findRecentUser.lastmsgtime, findRecentUserByUin.lastmsgtime);
            findRecentUserByUin.showUpTime = findRecentUser.showUpTime;
            U(qQAppInterface, str, str2, findRecentUserByUin);
            recentUserProxy.saveRecentUser(findRecentUserByUin);
            if (findRecentUser.showUpTime > 0) {
                ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).requestSetTroopTop(null, str, true, false, null);
            }
            QLog.d("TroopMemberUtil", 1, "realHandleDiscussToTroopOp, troopUin = " + str + ", discRu=[lastmsgtime:" + findRecentUser.lastmsgtime + ", lastmsgdrafttime:" + findRecentUser.lastmsgdrafttime + ", opTime:" + findRecentUser.opTime + ", showUpTime:" + findRecentUser.showUpTime + ", displayName:" + findRecentUser.displayName + "], troopRu=[lastmsgtime=" + findRecentUserByUin.lastmsgtime + "]");
        }
        if (findRecentUser != null) {
            recentUserProxy.delRecentUser(findRecentUser, true);
        }
        qQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_ONLINE_PUSH_HANDLER).notifyUI(com.tencent.mobileqq.troop.onlinepush.api.b.TYPE_TROOP_DISCUSS_TO_TROOP_CHANGED, true, new String[]{str, str2});
    }

    @WorkerThread
    public static void N(QQAppInterface qQAppInterface, String str, String str2, long j3, long j16) {
        long j17;
        if (qQAppInterface == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !s()) {
            return;
        }
        int i3 = QQManagerFactory.DISCUSSION_MANAGER;
        if (((com.tencent.mobileqq.app.n) qQAppInterface.getManager(i3)).h(str2) == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberUtil", 1, "handleDiscussToTroopOp cache data : has handle troopUin = " + StringUtil.getSimpleUinForPrint(str) + ", discUin = " + StringUtil.getSimpleUinForPrint(str2));
                return;
            }
            return;
        }
        com.tencent.mobileqq.app.n nVar = (com.tencent.mobileqq.app.n) qQAppInterface.getManager(i3);
        nVar.H(str, str2);
        if (j16 > 0) {
            if (qQAppInterface.getRecentUserProxy().findRecentUser(str2, 3000) == null) {
                j17 = -j16;
            } else {
                j17 = j16;
            }
            nVar.G(str2, j17);
        }
        TroopInfo findTroopInfo = ((ITroopInfoService) qQAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str);
        if (findTroopInfo == null) {
            findTroopInfo = new TroopInfo(str);
        }
        if (TextUtils.isEmpty(findTroopInfo.troopcode)) {
            findTroopInfo.troopcode = str;
        }
        findTroopInfo.discussUin = str2;
        if (j3 > 0) {
            findTroopInfo.discussMaxSeq = j3;
        }
        ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).saveTroopInCache(findTroopInfo);
        q(qQAppInterface, str, str2);
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberUtil", 2, "recordDiscussToTroopOp cache data : troopUin = " + StringUtil.getSimpleUinForPrint(str) + ", discUin = " + StringUtil.getSimpleUinForPrint(str2) + ", toTroopTime = " + j16);
        }
    }

    public static void O(QQAppInterface qQAppInterface, Context context, String str) {
        TroopInfo k3;
        if (QLog.isColorLevel()) {
            QLog.i("TroopMemberUtil", 2, "shareGroup:" + str);
        }
        TroopInfoData troopInfoData = new TroopInfoData();
        troopInfoData.troopUin = str;
        TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null && (k3 = troopManager.k(str)) != null) {
            troopInfoData.updateForTroopChatSetting(k3, context.getResources(), qQAppInterface.getCurrentAccountUin());
            troopInfoData.isMember = true;
            Activity V = V(context);
            if (V instanceof QBaseActivity) {
                QBaseActivity qBaseActivity = (QBaseActivity) V;
                com.tencent.mobileqq.troopshare.e eVar = new com.tencent.mobileqq.troopshare.e(qBaseActivity, troopInfoData);
                eVar.R(true);
                ThreadManagerV2.checkAndRunOnUIThread(new Runnable(troopInfoData, eVar) { // from class: com.tencent.mobileqq.troop.utils.TroopUtils.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ TroopInfoData f301983e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ com.tencent.mobileqq.troopshare.e f301984f;

                    {
                        this.f301983e = troopInfoData;
                        this.f301984f = eVar;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, QBaseActivity.this, troopInfoData, eVar);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else if (((ITroopShareApi) QRoute.api(ITroopShareApi.class)).useNewSharePanel("group_idcard")) {
                            ((ITroopShareUtility) QRoute.api(ITroopShareUtility.class)).showTroopIDCardSharePanel(QBaseActivity.this, this.f301983e);
                        } else {
                            this.f301984f.H(this.f301983e, Boolean.FALSE);
                        }
                    }
                });
            }
        }
    }

    public static com.tencent.mobileqq.troopshare.e P(QBaseActivity qBaseActivity, Fragment fragment, TroopInfoData troopInfoData, QQAppInterface qQAppInterface, Bundle bundle, Boolean bool) {
        if (qBaseActivity != null && !qBaseActivity.isFinishing() && troopInfoData != null && qQAppInterface != null) {
            com.tencent.mobileqq.troopshare.e eVar = new com.tencent.mobileqq.troopshare.e(qBaseActivity, troopInfoData, new a(troopInfoData), fragment, bundle);
            eVar.H(troopInfoData, bool);
            ReportController.o(qQAppInterface, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "Clk_share", 0, 0, troopInfoData.troopUin, "", "", "");
            if (troopInfoData.isMember) {
                eu.g("Grp_set_new", "grpData_admin", "clk_share", 0, 0, troopInfoData.troopUin, eu.c(troopInfoData));
            }
            return eVar;
        }
        return null;
    }

    public static com.tencent.mobileqq.troopshare.e Q(QBaseActivity qBaseActivity, TroopInfoData troopInfoData, QQAppInterface qQAppInterface, Boolean bool) {
        return P(qBaseActivity, null, troopInfoData, qQAppInterface, null, bool);
    }

    public static void R(Activity activity, QQAppInterface qQAppInterface, String str, int i3) {
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
        IConfigProxy iConfigProxy = VasLongToggle.VAS_BGSHOP_KRCONFIG;
        if (iConfigProxy.isEnable(false)) {
            String stringData = iConfigProxy.getStringData("");
            if (!TextUtils.isEmpty(stringData)) {
                HashMap hashMap = new HashMap();
                hashMap.put("frienduin", str);
                hashMap.put("uintype", String.valueOf(1));
                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openKuiklySchema(activity, stringData, hashMap);
                return;
            }
        }
        Intent intent = new Intent();
        intent.putExtra(VasWebviewConstants.KEY_VAS_USE_PREWEBVIEW, true);
        intent.putExtra("chatbg_intent_frinedUin", str);
        intent.putExtra("uintype", 1);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("bg_replace_entrance", 62);
        intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
        intent.putExtra("show_right_close_button", false);
        intent.putExtra("individuation_url_type", VasWebviewConstants.REPORT_FROM_AIO_BACKGROUND_SETTING);
        VasWebviewUtil.openQQBrowserWithoutAD(activity, VasWebviewUtil.addEntryParamToUrl(IndividuationUrlHelper.getMarketUrl(activity, "background", ""), 46), 33554432L, intent, true, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void S(QQAppInterface qQAppInterface, Activity activity, String str, String str2) {
        String str3;
        int i3;
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        ITroopAppService iTroopAppService = (ITroopAppService) qQAppInterface.getRuntimeService(ITroopAppService.class, "all");
        if (iTroopAppService != null) {
            if (((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).B(str).isHomeworkTroop()) {
                i3 = 32;
            } else {
                i3 = 0;
            }
            TroopAIOAppInfo appInfo = iTroopAppService.getAppInfo(1104864064, i3);
            if (appInfo != null && !TextUtils.isEmpty(appInfo.url)) {
                str3 = appInfo.url.replace("$GCODE$", str);
                if (str3 == null) {
                    str3 = f301977a + str;
                }
                intent.putExtra("url", str3);
                activity.startActivityForResult(intent, 12001);
                ReportController.o(qQAppInterface, "P_CliOper", "Grp_set", "", "Grp_app", "Clk_grpapp", 0, 0, str, "", "", "");
            }
        }
        str3 = null;
        if (str3 == null) {
        }
        intent.putExtra("url", str3);
        activity.startActivityForResult(intent, 12001);
        ReportController.o(qQAppInterface, "P_CliOper", "Grp_set", "", "Grp_app", "Clk_grpapp", 0, 0, str, "", "", "");
    }

    public static void T(QQAppInterface qQAppInterface, Activity activity, String str) {
        boolean z16;
        if (((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).groupGroupNewsInfo(qQAppInterface.getCurrentAccountUin(), ITroopSPUtilApi.KEY_FILE_NEW, str) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).setGroupGroupNewsInfo(qQAppInterface.getCurrentAccountUin(), ITroopSPUtilApi.KEY_FILE_NEW, str, 0);
        }
        Intent intent = new Intent();
        intent.putExtra(QZoneHelper.Constants.KEY_QUN_ID, str);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 3000);
        ((ITroopFileApi) QRoute.api(ITroopFileApi.class)).openTroopFileMainPage(activity, intent, 14);
        ReportController.o(qQAppInterface, "P_CliOper", "Grp_set", "", "Grp", "Clk_grpinfo_files", 0, 0, str, "0", "", "");
        if (QLog.isDevelopLevel()) {
            QLog.d("Clk_grpinfo_files", 4, "troopUin :" + str);
        }
        qx.a.j(qQAppInterface, 67);
    }

    public static Activity V(Context context) {
        Activity activity;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            return activity;
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            return qBaseActivity;
        }
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null && !topActivity.isFinishing() && !topActivity.isDestroyed()) {
            return topActivity;
        }
        Activity resumeActivity = BaseApplicationImpl.getApplication().getResumeActivity();
        if (resumeActivity != null && !resumeActivity.isFinishing() && !resumeActivity.isDestroyed()) {
            return resumeActivity;
        }
        List<WeakReference<Activity>> resumedActivity = Foreground.getResumedActivity();
        for (int size = resumedActivity.size() - 1; size >= 0; size--) {
            Activity activity2 = resumedActivity.get(size).get();
            if (activity2 != null && !activity2.isFinishing() && !activity2.isDestroyed()) {
                return activity2;
            }
        }
        return null;
    }

    public static void W(QQAppInterface qQAppInterface, String str) {
        if (qQAppInterface == null || TextUtils.isEmpty(str) || !s()) {
            return;
        }
        String j3 = ((com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).j(str);
        if (!TextUtils.isEmpty(j3)) {
            M(qQAppInterface, str, j3);
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberUtil", 2, "tryHandleDiscussToTroopOpAfterGetMsg, troopUin = " + str + ", discussUin = " + j3);
            }
        }
    }

    public static void X(View view, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, boolean z16, String str, String str2, LongClickCopyAction.ICopyListener iCopyListener) {
        LongClickCopyAction attachCopyAction;
        TextView textView = (TextView) view.findViewById(R.id.abv);
        TextView textView2 = (TextView) view.findViewById(R.id.i_f);
        textView2.getLayoutParams().height = ViewUtils.dpToPx(22.0f);
        textView2.setGravity(16);
        if (TextUtils.isEmpty(charSequence)) {
            if (TextUtils.isEmpty(charSequence3)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(charSequence3);
            }
        } else {
            textView2.setVisibility(0);
            textView2.setText(charSequence, TextView.BufferType.SPANNABLE);
            if (z16 && (attachCopyAction = LongClickCopyAction.attachCopyAction(textView2, str2, str)) != null) {
                attachCopyAction.setCopyListener(iCopyListener);
            }
        }
        if (TextUtils.isEmpty(charSequence2)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(charSequence2);
        }
    }

    public static boolean a(QQAppInterface qQAppInterface, long j3, String str) {
        if (qQAppInterface == null || j3 == 0 || str == null) {
            return false;
        }
        TroopInfo k3 = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k(j3 + "");
        if (k3 == null || !k3.isOwnerOrAdmin()) {
            return false;
        }
        return true;
    }

    public static byte[] b(QQAppInterface qQAppInterface, String str, long j3, long j16) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
        if (!TextUtils.isEmpty(str)) {
            im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
            im_msg_body$Text im_msg_body_text = new im_msg_body$Text();
            im_msg_body_text.str.set(ByteStringMicro.copyFromUtf8(str));
            im_msg_body_elem.text.set(im_msg_body_text);
            im_msg_body_richtext.elems.add(im_msg_body_elem);
            im_msg_body$Elem im_msg_body_elem2 = new im_msg_body$Elem();
            im_msg_body$GeneralFlags im_msg_body_generalflags = new im_msg_body$GeneralFlags();
            generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
            generalflags_resvattr.uint32_troop_pobing_template.set(2000);
            generalflags_resvattr.uint32_is_ice_break_msg.set(1);
            im_msg_body_generalflags.bytes_pb_reserve.set(ByteStringMicro.copyFrom(generalflags_resvattr.toByteArray()));
            im_msg_body_elem2.general_flags.set(im_msg_body_generalflags);
            im_msg_body_richtext.elems.add(im_msg_body_elem2);
        }
        im_msg_body$MsgBody im_msg_body_msgbody = new im_msg_body$MsgBody();
        im_msg_body_msgbody.rich_text.set(im_msg_body_richtext);
        im_msg$Msg im_msg_msg = new im_msg$Msg();
        im_msg_msg.body.set(im_msg_body_msgbody);
        im_msg$Group im_msg_group = new im_msg$Group();
        im_common$User im_common_user = new im_common$User();
        im_common_user.uin.set(j3);
        im_common_user.app_id.set(1001);
        im_common_user.instance_id.set(1);
        im_common_user.client_ip.set((int) com.dataline.util.d.a());
        im_common_user.platform_id.set(109);
        im_common_user.version.set(AppSetting.f());
        im_msg_group.sender.set(im_common_user);
        im_msg_group.sender.uin.set(j3);
        im_msg_group.group_info.set(new im_common$GroupInfo());
        im_msg_group.group_info.group_id.set(j16);
        im_msg_group.group_info.group_type.set(1);
        im_msg$RoutingHead im_msg_routinghead = new im_msg$RoutingHead();
        im_msg_routinghead.group.set(im_msg_group);
        im_msg$ContentHead im_msg_contenthead = new im_msg$ContentHead();
        PBUInt32Field pBUInt32Field = im_msg_contenthead.seq;
        int i3 = f301979c;
        f301979c = i3 + 1;
        pBUInt32Field.set(i3);
        im_msg$MsgHead im_msg_msghead = new im_msg$MsgHead();
        im_msg_msghead.content_head.set(im_msg_contenthead);
        im_msg_msghead.routing_head.set(im_msg_routinghead);
        im_msg_msg.head.set(im_msg_msghead);
        im_imagent$Signature im_imagent_signature = new im_imagent$Signature();
        im_imagent_signature.key_type.set(1);
        im_imagent_signature.session_app_id.set(256);
        im_imagent$ImAgentHead im_imagent_imagenthead = new im_imagent$ImAgentHead();
        im_imagent_imagenthead.command.set(3);
        im_imagent_imagenthead.signature.set(im_imagent_signature);
        im_imagent_imagenthead.req_user.set(im_common_user);
        PBUInt32Field pBUInt32Field2 = im_imagent_imagenthead.seq;
        int i16 = f301979c;
        f301979c = i16 + 1;
        pBUInt32Field2.set(i16);
        im_msg$MsgSendReq im_msg_msgsendreq = new im_msg$MsgSendReq();
        im_msg_msgsendreq.f435953msg.set(im_msg_msg);
        im_imagent$ImAgentPackage im_imagent_imagentpackage = new im_imagent$ImAgentPackage();
        im_imagent_imagentpackage.head.set(im_imagent_imagenthead);
        im_imagent_imagentpackage.msg_send_req.set(im_msg_msgsendreq);
        byte[] byteArray = im_imagent_imagentpackage.toByteArray();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(byteArray.length + 8);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            try {
                dataOutputStream.writeInt(byteArray.length + 8);
                dataOutputStream.write(123);
                dataOutputStream.write(123);
                dataOutputStream.write(byteArray);
                dataOutputStream.write(125);
                dataOutputStream.write(125);
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    dataOutputStream.close();
                } catch (Exception unused) {
                }
                return byteArray2;
            } catch (Throwable th5) {
                try {
                    byteArrayOutputStream.close();
                    dataOutputStream.close();
                } catch (Exception unused2) {
                }
                throw th5;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            try {
                byteArrayOutputStream.close();
                dataOutputStream.close();
            } catch (Exception unused3) {
            }
            return null;
        }
    }

    public static final int c(QQAppInterface qQAppInterface, String str) {
        TroopInfo B;
        if (qQAppInterface == null || TextUtils.isEmpty(str) || (B = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).B(str)) == null) {
            return 2;
        }
        if (B.isTroopOwner(qQAppInterface.getCurrentUin())) {
            return 0;
        }
        if (!B.isTroopAdmin(qQAppInterface.getCurrentUin())) {
            return 2;
        }
        return 1;
    }

    public static String d(QQAppInterface qQAppInterface, Card card) {
        String str;
        String str2;
        short s16 = card.shGender;
        String str3 = "";
        if (s16 == 0) {
            str = qQAppInterface.getApp().getString(R.string.c7_);
        } else if (s16 != 1) {
            str = "";
        } else {
            str = qQAppInterface.getApp().getString(R.string.b5e);
        }
        String str4 = card.strProvince;
        String str5 = card.strCity;
        int i3 = card.constellation;
        String b16 = NearbyProfileUtil.b(i3);
        boolean isEmpty = TextUtils.isEmpty(str4);
        if (!TextUtils.isEmpty(str5)) {
            str3 = str5;
        }
        if (isEmpty && i3 == 0 && s16 == -1) {
            str2 = HardCodeUtil.qqStr(R.string.uhh);
        } else if (isEmpty && i3 == 0) {
            str2 = HardCodeUtil.qqStr(R.string.uhr);
        } else if (isEmpty && s16 == -1) {
            str2 = HardCodeUtil.qqStr(R.string.uhu);
        } else if (i3 == 0 && s16 == -1) {
            str2 = HardCodeUtil.qqStr(R.string.uhv) + str4 + str3;
        } else if (i3 == 0) {
            str2 = HardCodeUtil.qqStr(R.string.uho) + str4 + str3;
        } else if (s16 == -1) {
            str2 = HardCodeUtil.qqStr(R.string.uhn) + str4 + str3 + HardCodeUtil.qqStr(R.string.uhk) + b16 + HardCodeUtil.qqStr(R.string.uhl);
        } else if (isEmpty) {
            str2 = b16 + str + HardCodeUtil.qqStr(R.string.uht);
        } else {
            str2 = HardCodeUtil.qqStr(R.string.uhf) + str4 + str3 + HardCodeUtil.qqStr(R.string.uhs) + b16 + str + HardCodeUtil.qqStr(R.string.uhi);
        }
        return str2 + "~";
    }

    public static void e(Context context, String str, boolean z16) {
        if (context == null) {
            context = BaseApplication.getContext();
        }
        String g06 = com.tencent.mobileqq.utils.ac.g0((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), str, false);
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(context), null);
        m3.putExtra("uin", str);
        m3.putExtra("uintype", 1);
        m3.putExtra("uinname", g06);
        m3.putExtra("isBack2Root", true);
        m3.putExtra("KEY_SHOULD_SHOW_KEYBOARD", z16);
        context.startActivity(m3);
    }

    public static QQAppInterface f() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) peekAppRuntime;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
    
        if (r3.f280709i == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
    
        if (r3.E == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
    
        if (r3.G == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0019, code lost:
    
        if (r3.f280705d == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001c, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001d, code lost:
    
        r2 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean g(QQAppInterface qQAppInterface, String str) {
        com.tencent.mobileqq.relationx.batchAdd.c o16 = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).o();
        boolean z16 = true;
        boolean z17 = false;
        if (!"newJoin".equals(str)) {
            if (!"activeUser".equals(str)) {
                if (!"newMember".equals(str)) {
                    if ("atMeOrReplyMe".equals(str)) {
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberUtil", 2, "checkSwitch scene = " + str + ",result = " + z17 + ",config.switchOn = " + o16.switchOn + ",config.au_switchOn = " + o16.au_switchOn + ",config.nm_switchOn = " + o16.nm_switchOn + ",config.aor_switchOn = " + o16.aor_switchOn);
        }
        return z17;
    }

    public static int h(String str) {
        if (StringUtil.isEmpty(str)) {
            return 0;
        }
        int i3 = 5381;
        for (int i16 = 0; i16 < str.length(); i16++) {
            i3 += (i3 << 5) + str.charAt(i16);
        }
        return Integer.MAX_VALUE & i3;
    }

    public static Pair<String, ArrayList<AtTroopMemberInfo>> i(Editable editable) {
        short s16;
        int i3;
        ArrayList arrayList = new ArrayList();
        String c16 = com.tencent.mobileqq.troop.text.a.c(editable, arrayList);
        if (!arrayList.isEmpty()) {
            AtTroopMemberInfo atTroopMemberInfo = (AtTroopMemberInfo) arrayList.get(0);
            AtTroopMemberInfo atTroopMemberInfo2 = (AtTroopMemberInfo) arrayList.get(arrayList.size() - 1);
            if (atTroopMemberInfo != null && atTroopMemberInfo2 != null) {
                s16 = atTroopMemberInfo.startPos;
                i3 = atTroopMemberInfo2.startPos + atTroopMemberInfo2.textLen;
            } else {
                s16 = -1;
                i3 = -1;
            }
            if (s16 >= 0 && i3 >= 0 && s16 < i3) {
                c16 = c16.substring(s16, i3);
            }
        }
        return new Pair<>(c16, arrayList);
    }

    public static int j(QQAppInterface qQAppInterface, String str) {
        TroopInfo troopInfoFromCache;
        if (qQAppInterface == null || TextUtils.isEmpty(str) || (troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(str)) == null || !troopInfoFromCache.hadJoinTroop()) {
            return 3;
        }
        if (troopInfoFromCache.isOwner()) {
            return 0;
        }
        if (troopInfoFromCache.isAdmin()) {
            return 1;
        }
        return 2;
    }

    public static Bundle k(int i3, GroupInfo groupInfo, int i16, boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putInt(AppConstants.Key.TROOP_INFO_FROM, i3);
        bundle.putString("troop_uin", String.valueOf(groupInfo.lCode));
        bundle.putString(AppConstants.Key.TROOP_CODE, String.valueOf(groupInfo.lUin));
        bundle.putString(AppConstants.Key.TROOP_INFO_NAME, groupInfo.strName);
        bundle.putShort(AppConstants.Key.TROOP_INFO_FACEID, (short) groupInfo.iFaceId);
        bundle.putString(AppConstants.Key.TROOP_INFO_FINGERMEMO, groupInfo.strIntro);
        bundle.putString(AppConstants.Key.TROOP_INFO_LOCA, groupInfo.strLocation);
        bundle.putBoolean(AppConstants.Key.TROOP_INFO_IS_MEMBER, z16);
        bundle.putLong(AppConstants.Key.TROOP_INFO_FLAG_EXT, groupInfo.dwGroupFlagExt);
        bundle.putLong(AppConstants.Key.TROOP_INFO_AUTH_TYPE, groupInfo.dwCertType);
        bundle.putInt(AppConstants.Key.TROOP_INFO_MEMBER_NUM, groupInfo.iMemberCnt);
        bundle.putInt(AppConstants.Key.TROOP_INFO_TROOP_GRADE, (int) groupInfo.dwGroupActiveGrade);
        bundle.putInt(AppConstants.Key.TROOP_INFO_FROM_EX, i16);
        bundle.putString("authSig", groupInfo.strJoinSig);
        if (!TextUtils.isEmpty(groupInfo.strJoinAuth)) {
            bundle.putString("authKey", groupInfo.strJoinAuth);
        }
        return bundle;
    }

    public static void l(QQAppInterface qQAppInterface, Activity activity, String str, String str2, int i3) {
        boolean z16;
        if (i3 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        userInfo.qzone_uin = qQAppInterface.getCurrentAccountUin();
        userInfo.nickname = qQAppInterface.getCurrentNickname();
        com.tencent.mobileqq.troop.troopphoto.api.a aVar = (com.tencent.mobileqq.troop.troopphoto.api.a) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_PHOTO_HANDLER);
        if (!TextUtils.isEmpty(str)) {
            aVar.t(str, true);
        }
        if (((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).groupGroupNewsInfo(qQAppInterface.getCurrentAccountUin(), ITroopSPUtilApi.KEY_ALBUM_MESSAGE, str) > 0) {
            QZoneHelper.forwardToQunPassiveFeed(activity, userInfo, str, 7);
        } else {
            QZoneHelper.forwardToQunFeed(activity, userInfo, str, str2, z16, 7);
        }
        ReportController.o(qQAppInterface, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "Clk_album", 0, 0, str, "", "", "");
        qx.a.j(qQAppInterface, 66);
    }

    public static boolean m() {
        List<TroopInfo> joinedTroopInfoFromCache;
        if (((TroopManager) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.TROOP_MANAGER)) == null || (joinedTroopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getJoinedTroopInfoFromCache()) == null) {
            return false;
        }
        Iterator<TroopInfo> it = joinedTroopInfoFromCache.iterator();
        while (it.hasNext()) {
            if (it.next().isOwnerOrAdmin()) {
                return true;
            }
        }
        return false;
    }

    public static boolean n(String str) {
        return o(str, false);
    }

    public static boolean o(String str, boolean z16) {
        TroopInfo m3 = ((TroopManager) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.TROOP_MANAGER)).m(str, true, z16);
        if (m3 != null && m3.hadJoinTroop()) {
            return m3.hasSetTroopHead();
        }
        if (((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).isTroopListCacheAllInited()) {
            return true;
        }
        boolean checkTroopHasAvatarFromMMKV = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).checkTroopHasAvatarFromMMKV(str);
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberUtil", 2, "hasSetTroopHeadFromDb: check has avatar from mmkv uin=" + str + ", result=" + checkTroopHasAvatarFromMMKV);
        }
        return checkTroopHasAvatarFromMMKV;
    }

    public static Bitmap p(Drawable drawable) {
        Bitmap.Config config;
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberUtil", 2, "drawable width or height is 0, and use default drawable");
            }
            drawable = FaceDrawable.getDefaultDrawable(1, 3);
            int intrinsicWidth2 = drawable.getIntrinsicWidth();
            int intrinsicHeight2 = drawable.getIntrinsicHeight();
            if (intrinsicWidth2 > 0 && intrinsicHeight2 > 0) {
                intrinsicWidth = intrinsicWidth2;
                intrinsicHeight = intrinsicHeight2;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopMemberUtil", 2, "the default drawable width or height is 0");
                }
                return null;
            }
        }
        if (drawable.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    public static void q(QQAppInterface qQAppInterface, @NonNull String str, String str2) {
        if (!TextUtils.isEmpty(str2) && w(qQAppInterface, str)) {
            qQAppInterface.getMessageProxy(1).n0(str, 1);
        }
    }

    public static boolean r(List<?> list) {
        if (list == null || list.size() < 1) {
            return true;
        }
        return false;
    }

    public static boolean s() {
        boolean z16;
        if (f301981e != null) {
            return f301981e.booleanValue();
        }
        IFeatureServiceProxy iFeatureServiceProxy = (IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class);
        if (!iFeatureServiceProxy.isAppRuntimeNull() && !iFeatureServiceProxy.isFeatureSwitchOn("is_disc_to_troop_enabled")) {
            z16 = false;
        } else {
            z16 = true;
        }
        f301981e = Boolean.valueOf(z16);
        QLog.d("TroopMemberUtil", 1, "isDiscToTroopEnabled: app is null ? " + iFeatureServiceProxy.isAppRuntimeNull() + ", switch = " + f301981e);
        return f301981e.booleanValue();
    }

    public static boolean t(String str, int i3, long j3) {
        if (TextUtils.isEmpty(str) || i3 != 1 || !s() || !(MobileQQ.sMobileQQ.peekAppRuntime() instanceof QQAppInterface)) {
            return false;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        TroopInfo troopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getTroopInfoFromCache(str);
        if (troopInfoFromCache != null && troopInfoFromCache.isTop) {
            return false;
        }
        com.tencent.mobileqq.app.n nVar = (com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        long s16 = nVar.s(nVar.j(str));
        if ((s16 >= 0 || (-s16) < j3) && s16 < j3) {
            return false;
        }
        RecentBaseData b16 = com.tencent.mobileqq.activity.recent.g.c().b(com.tencent.mobileqq.activity.recent.g.d(str, 1));
        if (b16 == null || TextUtils.isEmpty(b16.mTitleName) || TextUtils.isEmpty(b16.mShowTime)) {
            return false;
        }
        return true;
    }

    @WorkerThread
    public static boolean u(AppRuntime appRuntime, String str, long j3, long j16) {
        if (appRuntime == null || TextUtils.isEmpty(str) || !s()) {
            return false;
        }
        if (j3 != 0 && j16 > j3) {
            return false;
        }
        return true;
    }

    private static boolean v(int i3, boolean z16, boolean z17) {
        if (i3 == 1) {
            return true;
        }
        if (z16 && !z17) {
            return true;
        }
        return false;
    }

    @WorkerThread
    public static boolean w(QQAppInterface qQAppInterface, String str) {
        String j3;
        if (qQAppInterface == null || TextUtils.isEmpty(str) || !s()) {
            return false;
        }
        TroopInfo k3 = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k(str);
        if (k3 != null && !TextUtils.isEmpty(k3.discussUin)) {
            j3 = k3.discussUin;
        } else {
            j3 = ((com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).j(str);
            if (TextUtils.isEmpty(j3)) {
                return false;
            }
        }
        if (qQAppInterface.getMsgCache().M0(str, 1) <= 0 && QLog.isColorLevel()) {
            QLog.d("TroopMemberUtil", 2, "isShowDiscToTroopTip try to check isShow. troopUin = " + StringUtil.getSimpleUinForPrint(str) + ", discUin = " + StringUtil.getSimpleUinForPrint(j3) + ", list.size = 0");
        }
        return false;
    }

    public static boolean x(QQAppInterface qQAppInterface, AIOMsgItem aIOMsgItem, String str) {
        boolean z16;
        if (aIOMsgItem.getMsgRecord().getChatType() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        return y(qQAppInterface, z16, String.valueOf(aIOMsgItem.getMsgRecord().getSenderUin()), String.valueOf(aIOMsgItem.getMsgRecord().getPeerUin()), str);
    }

    private static boolean y(QQAppInterface qQAppInterface, boolean z16, String str, String str2, String str3) {
        if (z16) {
            if (TextUtils.equals(str, str3)) {
                return true;
            }
            TroopInfo k3 = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k(str2);
            if (k3 == null) {
                return false;
            }
            if (k3.isTroopOwner(str3)) {
                return true;
            }
            if (k3.isTroopAdmin(str3) && !k3.isTroopOwner(str) && !k3.isTroopAdmin(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean z(QQAppInterface qQAppInterface, AIOMsgItem aIOMsgItem, String str) {
        TroopInfo k3;
        if (aIOMsgItem.v().getChatType() == 2) {
            String l3 = Long.toString(aIOMsgItem.getMsgRecord().getSenderUin());
            String l16 = Long.toString(aIOMsgItem.getMsgRecord().getPeerUin());
            if (TextUtils.equals(l3, str) || (k3 = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k(l16)) == null) {
                return false;
            }
            if (k3.isTroopOwner(str)) {
                return true;
            }
            if (k3.isTroopAdmin(str) && !k3.isTroopOwner(l3) && !k3.isTroopAdmin(l3)) {
                return true;
            }
        }
        return false;
    }

    private static void U(QQAppInterface qQAppInterface, String str, String str2, RecentUser recentUser) {
    }
}
