package com.tencent.mobileqq.matchfriend.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.matchfriend.aio.sign.QQStrangerAIOSigUtil;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr;
import com.tencent.mobileqq.matchfriend.bean.QQStrangerUserInfo;
import com.tencent.mobileqq.matchfriend.reborn.activity.QQStrangerPublicFragmentActivity;
import com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchingChatFragment;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.QQStrangerMsgSettingsFragment;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.QQStrangerSignalPublishFragment;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.square.QQStrangerSignalSquareFragment;
import com.tencent.mobileqq.matchfriend.reborn.utils.l;
import com.tencent.mobileqq.matchfriend.request.MatchFriendRequest;
import com.tencent.mobileqq.matchfriend.voicechat.RoomInfo;
import com.tencent.mobileqq.matchfriend.voicechat.api.IVoiceChatApi;
import com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter;
import com.tencent.mobileqq.nearbypro.api.router.NBPArticleFeedDetailPageSource;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MatchFriendEntryApiImpl implements IMatchFriendEntryApi {
    private static final String ACTION_ID = "0X800C3D7";
    private static final int DT_REPORT_ID_MATCH_FRIEND = 102;
    private static final int DT_REPORT_ID_MATCH_FRIEND_C = 111;
    private static final int DT_REPORT_ID_MATCH_FRIEND_D = 112;
    private static final String ENTRY_TITLE_KEY = "titles";
    private static final int PRELOAD_INTERVAL_TIME = 120000;
    private static final int REQUEST_ENTER_MATCH_FRIEND_CHAT_PIE = 101;
    private static final String TAG = "MatchFriendEntryApiImpl";
    private static long lastPreloadTime;
    public static long sEnterProfileStartTime;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class c implements Function1<Boolean, Unit> {
        c() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool) {
            QLog.i(MatchFriendEntryApiImpl.TAG, 1, "checkEntranceInner preLoad MarkConfig = " + bool);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class d implements Function1<Boolean, Unit> {
        d() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool) {
            QLog.i(MatchFriendEntryApiImpl.TAG, 1, "checkEntranceInner preLoad config = " + bool);
            if (!bool.booleanValue()) {
                return null;
            }
            com.tencent.mobileqq.matchfriend.reborn.config.c.g();
            return null;
        }
    }

    private void checkCanEdit(AppInterface appInterface, Context context, String str) {
        if (!NetworkUtil.isNetworkAvailable()) {
            showToast(1, HardCodeUtil.qqStr(R.string.x0f));
        } else {
            MatchFriendRequest.u(appInterface, new a(context, str));
        }
    }

    private boolean checkEntranceInner(AppInterface appInterface, SharedPreferences sharedPreferences) {
        boolean z16 = sharedPreferences.getBoolean("key_match_friend_entrance", false);
        if (z16) {
            com.tencent.mobileqq.matchfriend.reborn.mark.config.b.f245190a.f(new c());
            com.tencent.mobileqq.matchfriend.reborn.config.c.f244198a.d(new d());
        }
        QLog.i(TAG, 1, "getMatchFriendEntrance checkEntranceInner, switchFromServer=" + z16);
        return z16;
    }

    private boolean isNetworkAvailable() {
        if (NetworkUtil.isNetworkAvailable()) {
            return true;
        }
        showToast(3, HardCodeUtil.qqStr(R.string.x0e));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToEditFragment(Context context, String str) {
        l.b(context, str);
    }

    private void launchAddFriendReal(AppInterface appInterface, Context context, String str, String str2, int i3, String str3) {
        Intent startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(context, 3, str, "101980455", 3094, com.tencent.mobileqq.matchfriend.utils.e.a(i3), str2, null, null, null, null);
        startAddFriend.putExtra("recom_trace", str3);
        ReportController.o(appInterface, "dc00898", "", str, ACTION_ID, ACTION_ID, com.tencent.mobileqq.matchfriend.utils.e.a(i3), 0, "", "", "", "");
        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(context, startAddFriend);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(final int i3, final String str) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.api.impl.MatchFriendEntryApiImpl.1
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                String str3;
                if (com.tencent.relation.common.utils.f.a()) {
                    BaseApplication context = BaseApplication.getContext();
                    int i16 = i3;
                    if (TextUtils.isEmpty(str)) {
                        str3 = HardCodeUtil.qqStr(R.string.x0x);
                    } else {
                        str3 = str;
                    }
                    QQToast.makeText(context, i16, str3, 0, 1002).show();
                    return;
                }
                BaseApplication context2 = BaseApplication.getContext();
                int i17 = i3;
                if (TextUtils.isEmpty(str)) {
                    str2 = HardCodeUtil.qqStr(R.string.x0x);
                } else {
                    str2 = str;
                }
                QQToast.makeText(context2, i17, str2, 0).show();
            }
        });
    }

    private void startEnterAIOInner(Context context, long j3, int i3, Bundle bundle) {
        Intent intent = new Intent(context, (Class<?>) ChatActivity.class);
        intent.putExtra("uin", String.valueOf(j3));
        intent.putExtra("uintype", 1046);
        intent.putExtra("key_match_friend_source", i3);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.addFlags(268435456);
        intent.addFlags(67108864);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.startActivityForResult(intent, 101);
            activity.overridePendingTransition(R.anim.f154340au, R.anim.f154341fw);
            return;
        }
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void enterChatSetting(Context context, AppInterface appInterface) {
        QQStrangerPublicFragmentActivity.startActivity(context, new Intent(), QQStrangerMsgSettingsFragment.class);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void enterFeedDetail(Context context, int i3, String str, String str2, int i16, int i17) {
        NBPArticleFeedDetailPageSource nBPArticleFeedDetailPageSource = null;
        for (NBPArticleFeedDetailPageSource nBPArticleFeedDetailPageSource2 : NBPArticleFeedDetailPageSource.values()) {
            if (nBPArticleFeedDetailPageSource2.getValue() == i17) {
                nBPArticleFeedDetailPageSource = nBPArticleFeedDetailPageSource2;
            }
        }
        if (nBPArticleFeedDetailPageSource == null) {
            nBPArticleFeedDetailPageSource = NBPArticleFeedDetailPageSource.SQUARE_FEED;
        }
        ((INearbyProPageRouter) QRoute.api(INearbyProPageRouter.class)).launchArticleFeedDetailPage(context, nBPArticleFeedDetailPageSource, new com.tencent.mobileqq.nearbypro.api.router.a(i3, str2, i16, str, null, null, null, null));
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void enterLittleAssistantAIO(Context context) {
        enterMatchFriendAIO(context, Long.parseLong("144115227025205148"), "", 7);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void enterMatchFriendAIO(Context context, long j3, String str, int i3) {
        enterAIOInner(context, j3, str, i3, null);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void enterMatchPage(Context context, AppRuntime appRuntime, com.tencent.mobileqq.matchfriend.data.a aVar) {
        l.c(context, aVar);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void enterMatchingFriend(Context context) {
        QQStrangerPublicFragmentActivity.startActivity(context, new Intent(), QQStrangerMatchingChatFragment.class);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void enterMsgListPage(Context context, AppInterface appInterface, int i3, int i16) {
        l.d(context, i3, i16);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void enterProfileCard(AppInterface appInterface, Context context, long j3, int i3) {
        enterProfileCard(appInterface, context, j3, i3, 0);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void enterProfileEdit(Context context, String str) {
        String name;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            checkCanEdit((AppInterface) peekAppRuntime, context, str);
            return;
        }
        if (peekAppRuntime == null) {
            name = "null";
        } else {
            name = peekAppRuntime.getClass().getName();
        }
        QLog.e(TAG, 1, "enterProfileEditBySourceId app is:" + name);
        showErrorToast();
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void enterSignalSquare(Context context) {
        QQStrangerPublicFragmentActivity.startActivity(context, new Intent(), QQStrangerSignalSquareFragment.class);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public int getAddContactEntryDTID() {
        if (com.tencent.relation.common.abtest.a.d("exp_search_people_jieban_entrance", "exp_search_people_jieban_entrance_C")) {
            return 111;
        }
        return com.tencent.relation.common.abtest.a.d("exp_search_people_jieban_entrance", "exp_search_people_jieban_entrance_D") ? 112 : 102;
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public String getAddContactsMatchFriendEntryTitle(AppInterface appInterface) {
        String str;
        Map<String, String> tabParams = com.tencent.relation.common.abtest.a.b("exp_search_people_jieban_entrance").getTabParams();
        if (tabParams != null && tabParams.size() != 0) {
            str = tabParams.get(ENTRY_TITLE_KEY);
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                return str;
            }
            String currentUin = appInterface.getCurrentUin();
            return jSONArray.getString((currentUin.charAt(currentUin.length() - 1) - '0') % jSONArray.length());
        } catch (ArithmeticException | JSONException unused) {
            QLog.e(TAG, 1, "getAddContactsMatchFriendEntryTitle is error!");
            return str;
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void launchAddFriend(Context context, long j3) {
        launchAddFriend(context, j3, "");
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void openSignalPublisher(Context context, boolean z16) {
        openSignalPublisher(context, z16, -1L, -1L);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public boolean showAddContactsMatchFriendEntry(AppInterface appInterface) {
        boolean showMatchFriendEntry = showMatchFriendEntry(appInterface);
        boolean z16 = com.tencent.relation.common.abtest.a.d("exp_search_people_jieban_entrance", "exp_search_people_jieban_entrance_B") || com.tencent.relation.common.abtest.a.d("exp_search_people_jieban_entrance", "exp_search_people_jieban_entrance_C") || com.tencent.relation.common.abtest.a.d("exp_search_people_jieban_entrance", "exp_search_people_jieban_entrance_D");
        QLog.d(TAG, 1, "showAddContactsMatchFriendEntry showMatchFriendEntry=" + showMatchFriendEntry + "expResult=" + z16);
        return showMatchFriendEntry & z16;
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public boolean showMatchFriendEntry(AppInterface appInterface) {
        return (!getMatchFriendEntrance(appInterface) || ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() || SimpleUIUtil.isNowElderMode() || AppSetting.f99565y) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class b implements Function1<QQStrangerUserInfo, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f244010d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f244011e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Bundle f244012f;

        b(Context context, int i3, Bundle bundle) {
            this.f244010d = context;
            this.f244011e = i3;
            this.f244012f = bundle;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(QQStrangerUserInfo qQStrangerUserInfo) {
            if (qQStrangerUserInfo == null) {
                return null;
            }
            MatchFriendEntryApiImpl.this.enterAIOInner(this.f244010d, qQStrangerUserInfo.tinyId, qQStrangerUserInfo.nick, this.f244011e, this.f244012f);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterAIOInner(Context context, long j3, String str, int i3, Bundle bundle) {
        QQStrangerUserInfo userInfo;
        if (context == null) {
            QLog.e(TAG, 1, "enterAIOInner context is null");
            return;
        }
        if ("256111111111111111".equals(String.valueOf(j3))) {
            enterOfficialAccount(context);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.e(TAG, 1, "enterOfficialAccount appRuntime is invalid");
            return;
        }
        QQStrangerAIOSigUtil.f(j3);
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        bundle2.putString("key_page_id", "pg_kl_new_chat_page");
        if (TextUtils.isEmpty(str) && (userInfo = ((IQQStrangerUserInfoMgr) ((QQAppInterface) peekAppRuntime).getRuntimeService(IQQStrangerUserInfoMgr.class, "all")).getUserInfo(new com.tencent.mobileqq.matchfriend.bean.c(104, j3, ""))) != null) {
            str = userInfo.nick;
        }
        if (!TextUtils.isEmpty(str)) {
            bundle2.putString("uinname", str);
        }
        startEnterAIOInner(context, j3, i3, bundle2);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void enterMatchFriendAIO(Context context, long j3, String str, int i3, Bundle bundle) {
        enterAIOInner(context, j3, str, i3, bundle);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void enterOfficialAccount(Context context) {
        if (context == null) {
            QLog.e(TAG, 1, "enterOfficialAccount context is null");
            return;
        }
        if (!(MobileQQ.sMobileQQ.peekAppRuntime() instanceof QQAppInterface)) {
            QLog.e(TAG, 1, "enterOfficialAccount appRuntime is invalid");
            return;
        }
        QQStrangerAIOSigUtil.f(Long.parseLong("256111111111111111"));
        Intent intent = new Intent(context, (Class<?>) ChatActivity.class);
        intent.putExtra("uin", "256111111111111111");
        intent.putExtra("uintype", 1046);
        intent.putExtra("uinname", HardCodeUtil.qqStr(R.string.f201064tt));
        intent.setFlags(268435456);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.startActivityForResult(intent, 101);
            activity.overridePendingTransition(R.anim.f154340au, R.anim.f154341fw);
            return;
        }
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void enterProfileCard(AppInterface appInterface, final Context context, long j3, final int i3, final int i16) {
        IQQStrangerUserInfoMgr iQQStrangerUserInfoMgr = (IQQStrangerUserInfoMgr) appInterface.getRuntimeService(IQQStrangerUserInfoMgr.class, "all");
        com.tencent.mobileqq.matchfriend.bean.c cVar = new com.tencent.mobileqq.matchfriend.bean.c(104, j3, "");
        QQStrangerUserInfo userInfo = iQQStrangerUserInfoMgr.getUserInfo(cVar);
        if (userInfo != null && !TextUtils.isEmpty(userInfo.openId)) {
            enterProfileCard(context, userInfo.openId, i3, i16);
        } else {
            iQQStrangerUserInfoMgr.reqUserInfo(cVar, new Function1() { // from class: com.tencent.mobileqq.matchfriend.api.impl.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$enterProfileCard$0;
                    lambda$enterProfileCard$0 = MatchFriendEntryApiImpl.this.lambda$enterProfileCard$0(context, i3, i16, (QQStrangerUserInfo) obj);
                    return lambda$enterProfileCard$0;
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void enterSignalSquare(Context context, long j3) {
        Intent intent = new Intent();
        intent.putExtra("param_partner_id", j3);
        QQStrangerPublicFragmentActivity.startActivity(context, intent, QQStrangerSignalSquareFragment.class);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public boolean getMatchFriendEntrance(AppInterface appInterface) {
        if (appInterface == null) {
            QLog.e(TAG, 1, "getMatchFriendEntrance app is null");
            return false;
        }
        String currentUin = appInterface.getCurrentUin();
        if (TextUtils.isEmpty(currentUin)) {
            QLog.e(TAG, 1, "getMatchFriendEntrance uin is null");
            return false;
        }
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_for_match_friend_" + currentUin, 0);
        if (sharedPreferences == null) {
            QLog.e(TAG, 1, "getMatchFriendEntrance sp is null");
            return false;
        }
        return checkEntranceInner(appInterface, sharedPreferences);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void launchAddFriend(final Context context, long j3, final String str) {
        final AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface == null) {
            QQToastUtil.showQQToastInUiThread(1, HardCodeUtil.qqStr(R.string.x0x));
            QLog.e(TAG, 1, "launchAddFriend is error! app is null!");
        } else {
            IQQStrangerUserInfoMgr iQQStrangerUserInfoMgr = (IQQStrangerUserInfoMgr) appInterface.getRuntimeService(IQQStrangerUserInfoMgr.class, "all");
            com.tencent.mobileqq.matchfriend.bean.c cVar = new com.tencent.mobileqq.matchfriend.bean.c(104, j3, "");
            final String str2 = iQQStrangerUserInfoMgr.getSelfUserInfo() != null ? iQQStrangerUserInfoMgr.getSelfUserInfo().nick : "";
            iQQStrangerUserInfoMgr.reqUserInfo(cVar, new Function1() { // from class: com.tencent.mobileqq.matchfriend.api.impl.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$launchAddFriend$2;
                    lambda$launchAddFriend$2 = MatchFriendEntryApiImpl.this.lambda$launchAddFriend$2(appInterface, context, str2, str, (QQStrangerUserInfo) obj);
                    return lambda$launchAddFriend$2;
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void openSignalPublisher(Context context, boolean z16, long j3, long j16) {
        Intent intent = new Intent();
        intent.putExtra("key_notify_refresh_signal_square_after_publish", z16);
        intent.putExtra("key_partner_id", j3);
        intent.putExtra("key_partner_adj_id", j16);
        QQStrangerPublicFragmentActivity.startActivity(context, intent, QQStrangerSignalPublishFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$enterProfileCard$0(Context context, int i3, int i16, QQStrangerUserInfo qQStrangerUserInfo) {
        if (qQStrangerUserInfo == null) {
            return null;
        }
        enterProfileCard(context, qQStrangerUserInfo.openId, i3, i16);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$enterProfileCard$1(Context context, Intent intent, QQStrangerUserInfo qQStrangerUserInfo) {
        if (qQStrangerUserInfo == null) {
            return null;
        }
        enterProfileCard(context, qQStrangerUserInfo.openId, intent);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$launchAddFriend$2(AppInterface appInterface, Context context, String str, String str2, QQStrangerUserInfo qQStrangerUserInfo) {
        if (qQStrangerUserInfo != null) {
            launchAddFriendReal(appInterface, context, qQStrangerUserInfo.openId, str, qQStrangerUserInfo.matchSource, str2);
            return null;
        }
        QQToastUtil.showQQToastInUiThread(1, HardCodeUtil.qqStr(R.string.x0x));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$launchAddFriend$3(AppInterface appInterface, Context context, String str, int i3, String str2, QQStrangerUserInfo qQStrangerUserInfo) {
        if (qQStrangerUserInfo != null) {
            int i16 = qQStrangerUserInfo.matchSource;
            launchAddFriendReal(appInterface, context, qQStrangerUserInfo.openId, str, com.tencent.mobileqq.matchfriend.utils.e.b(i16) ? i16 : i3, str2);
            return null;
        }
        QQToastUtil.showQQToastInUiThread(1, HardCodeUtil.qqStr(R.string.x0x));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorToast() {
        showToast(1, null);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void enterMatchFriendAIO(AppInterface appInterface, Context context, String str, int i3) {
        enterMatchFriendAIO(appInterface, context, str, i3, (Bundle) null);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void enterMatchFriendAIO(AppInterface appInterface, Context context, String str, int i3, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            QLog.d(TAG, 1, "enterMatchFriendAIO openId is null or empty!");
            return;
        }
        IQQStrangerUserInfoMgr iQQStrangerUserInfoMgr = (IQQStrangerUserInfoMgr) appInterface.getRuntimeService(IQQStrangerUserInfoMgr.class, "all");
        com.tencent.mobileqq.matchfriend.bean.c cVar = new com.tencent.mobileqq.matchfriend.bean.c(104, 0L, str);
        QQStrangerUserInfo userInfo = iQQStrangerUserInfoMgr.getUserInfo(cVar);
        if (userInfo != null) {
            long j3 = userInfo.tinyId;
            if (j3 != 0) {
                enterAIOInner(context, j3, userInfo.nick, i3, bundle);
                return;
            }
        }
        iQQStrangerUserInfoMgr.reqUserInfo(cVar, new b(context, i3, bundle));
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void enterVoiceChat(Context context, RoomInfo roomInfo) {
        if (roomInfo == null) {
            return;
        }
        ((IVoiceChatApi) QRoute.api(IVoiceChatApi.class)).enterVoiceMatchOnlinePage(context, roomInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements com.tencent.relation.common.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f244007d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f244008e;

        a(Context context, String str) {
            this.f244007d = context;
            this.f244008e = str;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (!z16 || obj == null) {
                MatchFriendEntryApiImpl.this.showErrorToast();
                return;
            }
            Object[] objArr = (Object[]) obj;
            boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
            String str = (String) objArr[1];
            if (!booleanValue) {
                MatchFriendEntryApiImpl.this.jumpToEditFragment(this.f244007d, this.f244008e);
                return;
            }
            QLog.i(MatchFriendEntryApiImpl.TAG, 1, "checkCanEdit is error: " + str);
            MatchFriendEntryApiImpl.this.showToast(0, str);
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void enterProfileCard(Context context, String str, int i3) {
        enterProfileCard(context, str, i3, 0);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void enterProfileCard(Context context, String str, int i3, int i16) {
        enterProfileCard(context, str, i3, i16, (String) null);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void enterProfileCard(Context context, String str, int i3, int i16, String str2) {
        sEnterProfileStartTime = System.currentTimeMillis();
        if (hf0.a.a(TAG)) {
            return;
        }
        if (!isNetworkAvailable()) {
            sEnterProfileStartTime = 0L;
            return;
        }
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("key_uin_type", 0);
            intent.putExtra("key_open_id", str);
            l.e(context, str, i3, i16, str2);
        } else {
            sEnterProfileStartTime = 0L;
            QLog.e(TAG, 1, "enterProfileCard openId is null");
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void launchAddFriend(Context context, String str, String str2, int i3) {
        launchAddFriend(context, str, str2, i3, "");
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void launchAddFriend(final Context context, String str, final String str2, final int i3, final String str3) {
        final AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface == null) {
            QQToastUtil.showQQToastInUiThread(1, HardCodeUtil.qqStr(R.string.x0x));
            QLog.e(TAG, 1, "launchAddFriend is error! app is null!");
        } else {
            ((IQQStrangerUserInfoMgr) appInterface.getRuntimeService(IQQStrangerUserInfoMgr.class, "all")).reqUserInfo(new com.tencent.mobileqq.matchfriend.bean.c(104, 0L, str), new Function1() { // from class: com.tencent.mobileqq.matchfriend.api.impl.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$launchAddFriend$3;
                    lambda$launchAddFriend$3 = MatchFriendEntryApiImpl.this.lambda$launchAddFriend$3(appInterface, context, str2, i3, str3, (QQStrangerUserInfo) obj);
                    return lambda$launchAddFriend$3;
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void enterProfileCard(AppInterface appInterface, final Context context, long j3, final Intent intent) {
        IQQStrangerUserInfoMgr iQQStrangerUserInfoMgr = (IQQStrangerUserInfoMgr) appInterface.getRuntimeService(IQQStrangerUserInfoMgr.class, "all");
        com.tencent.mobileqq.matchfriend.bean.c cVar = new com.tencent.mobileqq.matchfriend.bean.c(104, j3, "");
        QQStrangerUserInfo userInfo = iQQStrangerUserInfoMgr.getUserInfo(cVar);
        if (userInfo != null && !TextUtils.isEmpty(userInfo.openId)) {
            enterProfileCard(context, userInfo.openId, intent);
        } else {
            iQQStrangerUserInfoMgr.reqUserInfo(cVar, new Function1() { // from class: com.tencent.mobileqq.matchfriend.api.impl.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$enterProfileCard$1;
                    lambda$enterProfileCard$1 = MatchFriendEntryApiImpl.this.lambda$enterProfileCard$1(context, intent, (QQStrangerUserInfo) obj);
                    return lambda$enterProfileCard$1;
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void enterProfileCard(Context context, String str, Intent intent) {
        if (isNetworkAvailable()) {
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("key_uin_type", 0);
                intent.putExtra("key_open_id", str);
                intent.putExtra("key_match_friend_source", 4);
                intent.putExtra("key_match_enter_from", 5);
                intent.addFlags(268435456);
                l.f(context, str, intent);
                return;
            }
            QLog.e(TAG, 1, "enterProfileCard openId is null");
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi
    public void launchAgeSelectFragment(Context context) {
    }
}
