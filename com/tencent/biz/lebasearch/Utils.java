package com.tencent.biz.lebasearch;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.pubaccount.weishi.api.IWSManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.home.chats.api.IChatApi;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.fileassistant.util.h;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.al;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.vivo.push.PushClientConstants;
import common.config.service.QzoneConfig;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.api.ProcessConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Utils {
    public static final int BUSINESS_ID_TEMP_GAME_MSG = 123;
    public static final int BUSINESS_ID_TEMP_MSG_BOC = 111;
    public static final int BUSINNESS_ID_ALBUM = 5;
    public static final int BUSINNESS_ID_ANIME = 18;
    public static final int BUSINNESS_ID_CITY_SERVICE = 22;
    public static final int BUSINNESS_ID_CM_SHOW = 11;
    public static final int BUSINNESS_ID_CONFESS = 59;
    public static final int BUSINNESS_ID_EAT_AND_DRINK = 21;
    public static final int BUSINNESS_ID_FACE_TO_FACE_SEND = 30;
    public static final int BUSINNESS_ID_FACE_TO_FACE_WALLET = 33;
    public static final int BUSINNESS_ID_GAMES = 13;
    public static final int BUSINNESS_ID_INTERESTED_TRIBES = 12;
    public static final int BUSINNESS_ID_JINGDONG = 16;
    public static final int BUSINNESS_ID_MUSIC = 19;
    public static final int BUSINNESS_ID_MY_COMPUTER = 28;
    public static final int BUSINNESS_ID_MY_FAVORITES = 4;
    public static final int BUSINNESS_ID_MY_FILE = 6;
    public static final int BUSINNESS_ID_MY_OTHER_ACCOUNT = 40;
    public static final int BUSINNESS_ID_NEARBY = 10;
    public static final int BUSINNESS_ID_NEW_FRIEND = 41;
    public static final int BUSINNESS_ID_NOW_LIVE = 20;
    public static final int BUSINNESS_ID_ONE_GREETING = 44;
    public static final int BUSINNESS_ID_PAY = 32;
    public static final int BUSINNESS_ID_PENGUIN_COUNSELING = 26;
    public static final int BUSINNESS_ID_PERSONALITY_DRESS_UP = 3;
    public static final int BUSINNESS_ID_PHONE_CONTACTS = 8;
    public static final int BUSINNESS_ID_PUBLIC_ACCOUNT = 27;
    public static final int BUSINNESS_ID_QQ_DAREN = 7;
    public static final int BUSINNESS_ID_QQ_KANDIAN = 15;
    public static final int BUSINNESS_ID_QQ_MEMBER = 1;
    public static final int BUSINNESS_ID_QQ_PHONE = 29;
    public static final int BUSINNESS_ID_QQ_RED_ENVELOPES = 39;
    public static final int BUSINNESS_ID_QQ_STORY = 14;
    public static final int BUSINNESS_ID_QQ_WALLET = 2;
    public static final int BUSINNESS_ID_QQ_ZONE = 9;
    public static final int BUSINNESS_ID_READ = 17;
    public static final int BUSINNESS_ID_SAY_HELLO = 42;
    public static final int BUSINNESS_ID_SCAN = 31;
    public static final int BUSINNESS_ID_SERVER_ACCOUNT = 43;
    public static final int BUSINNESS_ID_SHOOT = 34;
    public static final int BUSINNESS_ID_SHOPPING_ACCOUNT = 36;
    public static final int BUSINNESS_ID_SPORTS = 24;
    public static final int BUSINNESS_ID_TENCENT_CLASSROOM = 25;
    public static final int BUSINNESS_ID_TENCENT_NEWS = 23;
    public static final int BUSINNESS_ID_TROOP_ASSITANT = 35;
    public static final int BUSINNESS_ID_TROOP_NOTIFACATION = 37;
    public static final int BUSINNESS_ID_YINGYONGBAO = 38;
    public static final String KEY_BUSINESS_ID = "fid";
    public static final String KEY_BUSINESS_URL = "funurl";
    public static final String KEY_ICON = "icurl";
    public static final String KEY_NEW_TASK = "newtask";
    public static final String TAG = "lebasearch.Utils";
    public static final int TYPE_SET_CLOSE = 2;
    public static final int TYPE_SET_OPEN = 1;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f78623d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ BusinessObserver f78624e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f78625f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.troop.b f78626h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f78627i;

        a(int i3, BusinessObserver businessObserver, Context context, com.tencent.biz.troop.b bVar, long j3) {
            this.f78623d = i3;
            this.f78624e = businessObserver;
            this.f78625f = context;
            this.f78626h = bVar;
            this.f78627i = j3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 != 0) {
                if (i3 == 1) {
                    if (this.f78623d == 1) {
                        this.f78624e.onUpdate(17, false, null);
                        dialogInterface.dismiss();
                        return;
                    } else {
                        Utils.sendPluginSetMessage(this.f78625f, this.f78626h, this.f78624e, this.f78627i, false);
                        return;
                    }
                }
                return;
            }
            if (this.f78623d == 1) {
                Utils.sendPluginSetMessage(this.f78625f, this.f78626h, this.f78624e, this.f78627i, true);
            } else {
                this.f78624e.onUpdate(17, false, null);
                dialogInterface.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f78628d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ILebaHelperService f78629e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f78630f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f78631h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Handler f78632i;

        b(int i3, ILebaHelperService iLebaHelperService, QQAppInterface qQAppInterface, long j3, Handler handler) {
            this.f78628d = i3;
            this.f78629e = iLebaHelperService;
            this.f78630f = qQAppInterface;
            this.f78631h = j3;
            this.f78632i = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (this.f78628d == 1) {
                ILebaHelperService iLebaHelperService = this.f78629e;
                if (iLebaHelperService != null) {
                    iLebaHelperService.updateAppSetting(this.f78630f, this.f78631h, true, NetConnInfoCenter.getServerTimeMillis(), Long.MIN_VALUE);
                }
                this.f78632i.sendEmptyMessage(0);
                ((ILebaHelperService) this.f78630f.getRuntimeService(ILebaHelperService.class, ProcessConstant.MULTI)).netSetPluginState(String.valueOf(this.f78631h), true, NetConnInfoCenter.getServerTimeMillis());
                return;
            }
            ILebaHelperService iLebaHelperService2 = this.f78629e;
            if (iLebaHelperService2 != null) {
                iLebaHelperService2.updateAppSetting(this.f78630f, this.f78631h, false, NetConnInfoCenter.getServerTimeMillis(), Long.MIN_VALUE);
            }
            this.f78632i.sendEmptyMessage(1);
            ((ILebaHelperService) this.f78630f.getRuntimeService(ILebaHelperService.class, ProcessConstant.MULTI)).netSetPluginState(String.valueOf(this.f78631h), false, NetConnInfoCenter.getServerTimeMillis());
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Handler f78633d;

        c(Handler handler) {
            this.f78633d = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            this.f78633d.sendEmptyMessage(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class d implements o {
        d() {
        }

        @Override // com.tencent.mobileqq.qroute.route.o
        public void onError(int i3) {
            QLog.i(Utils.TAG, 2, "start QrcodeHbGuiderActivity onError");
        }

        @Override // com.tencent.mobileqq.qroute.route.o
        public void onSuccess() {
            QLog.i(Utils.TAG, 2, "start QrcodeHbGuiderActivity onSuccess");
        }
    }

    public static QQCustomDialog createPluginSetDialogForMain(QQAppInterface qQAppInterface, Context context, int i3, long j3, String str, String str2, Handler handler) {
        String string;
        int i16;
        int i17;
        ILebaHelperService iLebaHelperService = (ILebaHelperService) qQAppInterface.getRuntimeService(ILebaHelperService.class, "");
        if (iLebaHelperService == null) {
            QLog.d(TAG, 1, "createPluginSetDialogForMain lebaHelperService == null");
        }
        b bVar = new b(i3, iLebaHelperService, qQAppInterface, j3, handler);
        c cVar = new c(handler);
        if (!TextUtils.isEmpty(str2)) {
            string = str2;
        } else if (i3 == 1) {
            string = context.getResources().getString(R.string.dnd, str);
        } else {
            string = context.getString(R.string.dn_, str);
        }
        if (i3 == 1) {
            i16 = R.string.dn6;
        } else {
            i16 = R.string.dn8;
        }
        if (i3 == 1) {
            i17 = R.string.dna;
        } else {
            i17 = R.string.dn9;
        }
        return DialogUtil.createNoTitleDialog((BaseActivity) context, string, i16, i17, bVar, cVar);
    }

    public static QQCustomDialog createPluginSetDialogForWeb(Context context, com.tencent.biz.troop.b bVar, BusinessObserver businessObserver, int i3, long j3, String str, String str2) {
        String string;
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230);
        a aVar = new a(i3, businessObserver, context, bVar, j3);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView.setTextSize(14.0f);
        textView.setTextColor(context.getResources().getColor(R.color.f156931fl));
        textView.setGravity(1);
        textView.setPadding((int) al.a(context, 15.0f), (int) al.a(context, 30.0f), (int) al.a(context, 15.0f), (int) al.a(context, 15.0f));
        if (i3 == 1) {
            createCustomDialog.setPositiveButton(R.string.dn6, aVar);
            createCustomDialog.setNegativeButton(R.string.dna, aVar);
            if (str2 != null) {
                string = str2;
            } else {
                string = context.getResources().getString(R.string.dnd, str);
            }
        } else {
            if (str2 != null) {
                string = str2;
            } else {
                string = context.getString(R.string.dn_, str);
            }
            createCustomDialog.setNegativeButton(R.string.dn9, aVar);
            createCustomDialog.setPositiveButton(R.string.dn8, aVar);
        }
        textView.setText(string);
        createCustomDialog.addView(textView);
        return createCustomDialog;
    }

    public static boolean gotoF2fRedPacket(Context context, HashMap<String, Object> hashMap) {
        QQAppInterface qQAppInterface;
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, "/qwallet/redpacket/qrcodeHb");
        activityURIRequest.extra().putString("appInfo", "");
        activityURIRequest.setFlags(276824064);
        QRoute.startUri(activityURIRequest, new d());
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && (runtime instanceof QQAppInterface)) {
            qQAppInterface = (QQAppInterface) runtime;
        } else {
            qQAppInterface = null;
        }
        ReportController.o(qQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "jiahao.hongbao.click", 0, 0, "", "", "", "");
        return true;
    }

    public static boolean gotoFaceToFaceSend(Context context, HashMap<String, Object> hashMap) {
        QQProxyForQlink.P(context, 14, null);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean gotoFunctionActivity(Context context, HashMap<String, Object> hashMap) {
        boolean z16;
        EcShopAssistantManager ecShopAssistantManager;
        int i3 = 0;
        if (hashMap != null) {
            if (hashMap.get(PushClientConstants.TAG_CLASS_NAME) instanceof String) {
            }
            if (hashMap.get(KEY_BUSINESS_ID) instanceof Integer) {
                i3 = ((Integer) hashMap.get(KEY_BUSINESS_ID)).intValue();
            }
            if (hashMap.get(KEY_NEW_TASK) instanceof Boolean) {
                z16 = ((Boolean) hashMap.get(KEY_NEW_TASK)).booleanValue();
                Intent intent = new Intent();
                if (i3 == 2) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                if (i3 != 8) {
                                    if (i3 != 9) {
                                        if (i3 != 14) {
                                            if (i3 != 15 && i3 != 27) {
                                                if (i3 != 28) {
                                                    switch (i3) {
                                                        case 31:
                                                            gotoScan(context, null);
                                                            return true;
                                                        case 32:
                                                            gotoPay(context, null);
                                                            return true;
                                                        case 33:
                                                            gotoF2fRedPacket(context, null);
                                                            return true;
                                                        default:
                                                            switch (i3) {
                                                                case 35:
                                                                    ((IChatApi) QRoute.api(IChatApi.class)).jumpToTroopHelperFragment(context);
                                                                    return true;
                                                                case 36:
                                                                    intent.setClass(context, EcshopWebActivity.class);
                                                                    intent.putExtra("from_search", true);
                                                                    intent.setFlags(67108864);
                                                                    AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                                                                    if (runtime != null && (runtime instanceof QQAppInterface) && (ecShopAssistantManager = (EcShopAssistantManager) ((QQAppInterface) runtime).getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)) != null) {
                                                                        ecShopAssistantManager.b(intent, context, -1);
                                                                    }
                                                                    String config = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_MINI_APP_ECSHOP_URL, "");
                                                                    if (!TextUtils.isEmpty(config)) {
                                                                        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, config, 4003, null);
                                                                        ((IMiniAppService) QRoute.api(IMiniAppService.class)).report4239Async("shopping_folder", "click", "search", "", "", "");
                                                                        return true;
                                                                    }
                                                                    break;
                                                                case 37:
                                                                    intent = new Intent(context, (Class<?>) QPublicFragmentActivity.class);
                                                                    intent.putExtra("public_fragment_class", ((ILaunchTroopSysMsgUIUtilApi) QRoute.api(ILaunchTroopSysMsgUIUtilApi.class)).getFragmentNameForLaunch());
                                                                    break;
                                                                case 38:
                                                                    intent.setClass(context, QZoneAppListActivity.class);
                                                                    break;
                                                            }
                                                    }
                                                } else if (h.o()) {
                                                    h.t(context, null);
                                                } else {
                                                    QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "onClick enter DATALINE_PC from search");
                                                    ((IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class)).navigateToAIOActivity(context, 8, PeerUid.DATALINE_PC_UID, context.getResources().getString(R.string.c5f), 0L, new Bundle());
                                                    RecentUtil.f185176a = true;
                                                    RecentUtil.k0(intent);
                                                }
                                            } else {
                                                intent = new Intent(context, (Class<?>) LebaSearchTransparentJumpActivity.class);
                                                intent.putExtra("key_business", 6);
                                            }
                                        } else {
                                            ((IWSManager) QRoute.api(IWSManager.class)).enterTrendsTabWs(context, "from_search_trends_ws", false, null, null);
                                            return true;
                                        }
                                    } else {
                                        intent = new Intent(context, (Class<?>) LebaSearchTransparentJumpActivity.class);
                                        intent.putExtra("key_business", 3);
                                    }
                                } else {
                                    intent = new Intent(context, (Class<?>) LebaSearchTransparentJumpActivity.class);
                                    intent.putExtra("key_business", 7);
                                }
                            } else {
                                ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).openFileAssistant(context, z16);
                            }
                        } else {
                            intent = new Intent(context, (Class<?>) LebaSearchTransparentJumpActivity.class);
                            intent.putExtra("key_business", 5);
                        }
                    } else {
                        intent = new Intent(context, (Class<?>) LebaSearchTransparentJumpActivity.class);
                        intent.putExtra("key_business", 4);
                    }
                } else {
                    intent = new Intent(context, (Class<?>) LebaSearchTransparentJumpActivity.class);
                    intent.putExtra("key_business", 2);
                }
                if (i3 != 18) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("newInstance", true);
                    } catch (Exception unused) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "BUSINESS_ID_ANIME put newInstance is error");
                        }
                    }
                    ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTER_VIPCOMIC);
                    activityURIRequest.extra().putString("options", jSONObject.toString());
                    if (z16) {
                        activityURIRequest.setFlags(276824064);
                    }
                    QRoute.startUri(activityURIRequest, (o) null);
                } else {
                    if (z16) {
                        intent.setFlags(276824064);
                    }
                    context.startActivity(intent);
                }
                return true;
            }
        }
        z16 = true;
        Intent intent2 = new Intent();
        if (i3 == 2) {
        }
        if (i3 != 18) {
        }
        return true;
    }

    public static boolean gotoPay(Context context, HashMap<String, Object> hashMap) {
        Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=8&entry=2"));
        intent.setFlags(276824064);
        context.startActivity(intent);
        return true;
    }

    public static boolean gotoScan(Context context, HashMap<String, Object> hashMap) {
        if (QavCameraUsage.a(BaseApplication.getContext())) {
            QLog.e(TAG, 2, "gotoScan method. QavCameraUsage.checkAVCameraUsed false.");
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("from", "Conversation");
        intent.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, context.getString(R.string.button_back));
        intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, context.getString(R.string.button_back));
        intent.setFlags(67108864);
        intent.setFlags(276824064);
        RouteUtils.startActivity(context, intent, "/qrscan/scanner");
        return true;
    }

    public static boolean gotoWebView(Context context, HashMap<String, Object> hashMap) {
        String str;
        String str2;
        Intent intent = null;
        if (hashMap != null) {
            if (hashMap.get("url") instanceof String) {
                str2 = (String) hashMap.get("url");
            } else {
                str2 = null;
            }
            if (hashMap.get("url_model") instanceof String) {
                str = (String) hashMap.get("url_model");
            } else {
                str = null;
            }
        } else {
            str = null;
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        } else if (str.equals("gameCenter")) {
            intent = new Intent(context, (Class<?>) GameCenterActivity.class);
            intent.putExtra("big_brother_source_key", "biz_src_zf_games");
        }
        if (intent == null) {
            return false;
        }
        intent.putExtra("url", str2);
        intent.setFlags(276824064);
        context.startActivity(intent);
        return true;
    }

    public static void sendPluginSetMessage(Context context, final com.tencent.biz.troop.b bVar, final BusinessObserver businessObserver, long j3, boolean z16) {
        Handler handler = new Handler(context.getMainLooper());
        final Bundle bundle = new Bundle();
        bundle.putLong("uiResId", j3);
        bundle.putBoolean("isChecked", z16);
        handler.post(new Runnable() { // from class: com.tencent.biz.lebasearch.Utils.2
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.biz.troop.b.this.z0(17, bundle, businessObserver);
            }
        });
    }
}
