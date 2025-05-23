package com.tencent.mobileqq.qqgamepub.api.impl;

import Wallet.AcsMsg;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qqgamepub.api.IQQGameAdService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService;
import com.tencent.mobileqq.qqgamepub.api.IQQGamePushMsgService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.api.impl.QQGameHelperImpl;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment;
import com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragmentV2;
import com.tencent.mobileqq.qqgamepub.manager.QQGameDirectJumpHandler;
import com.tencent.mobileqq.qqgamepub.nt.api.IGameMallNtApi;
import com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.view.GameArkView;
import com.tencent.mobileqq.qqgamepub.view.MoreMsgHeaderView;
import com.tencent.mobileqq.qqgamepub.view.NavBarQQGamePub;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.util.Pair;
import com.tencent.util.URLUtil;
import common.config.service.QzoneConfig;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGameHelperImpl implements IQQGameHelper {
    static IPatchRedirector $redirector_ = null;
    public static final int FROM_LOCK_SCREEN = 3;
    public static final int FROM_MSG_TAB = 1;
    public static final int FROM_NOTIFICATION = 4;
    public static final String HIPPY_PSKEY_DOMAIN = "gamecenter.qq.com";
    private static final String NOTICE_BUS_ID_GAME_CENTER = "d1ae64ada96b84457b5264d3ebf978f8";
    public static final String PROCESS_NAME_TOOL = "com.tencent.mobileqq:tool";
    private static final String TAG = "QQGamePub_QQGameHelper";
    private long mClickPubAioTime;
    private List<QQGameMsgInfo> mMsgList;
    private int mUnreadMsgCnt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqgamepub.api.impl.QQGameHelperImpl$2, reason: invalid class name */
    /* loaded from: classes16.dex */
    public class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f264412d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f264413e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f264414f;

        AnonymousClass2(int i3, int i16, boolean z16) {
            this.f264412d = i3;
            this.f264413e = i16;
            this.f264414f = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQGameHelperImpl.this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i3, boolean z16, int i16, ArrayList arrayList) {
            if (arrayList.size() > 0) {
                QQGameMsgInfo qQGameMsgInfo = (QQGameMsgInfo) arrayList.get(0);
                if (qQGameMsgInfo.isAdMsg && qQGameMsgInfo.adJson != null) {
                    ((IQQGameAdService) QRoute.api(IQQGameAdService.class)).reportGdt(qQGameMsgInfo, 2);
                }
                String str = "1";
                WadlReportBuilder retId = QQGameHelperImpl.this.getReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("771").setOperId("206612").setExt(1, "76918").setExt(11, "1").setExt(12, "160").setExt(13, ((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).getGamePaHippyModuleName()).setRetId(i3);
                if (!z16) {
                    str = "0";
                }
                retId.setExt(25, str).setExt(47, "open").setExt(48, i16 + "").report();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.f264412d == 2) {
                IQQGamePubMsgApi iQQGamePubMsgApi = (IQQGamePubMsgApi) QRoute.api(IQQGamePubMsgApi.class);
                final int i3 = this.f264413e;
                final boolean z16 = this.f264414f;
                final int i16 = this.f264412d;
                iQQGamePubMsgApi.getBusinessMsgList(1, 3, new IQQGamePubMsgApi.a() { // from class: com.tencent.mobileqq.qqgamepub.api.impl.i
                    @Override // com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi.a
                    public final void onSuccess(ArrayList arrayList) {
                        QQGameHelperImpl.AnonymousClass2.this.b(i3, z16, i16, arrayList);
                    }
                }, "report");
            }
        }
    }

    public QQGameHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void addAnimIntent(Intent intent) {
        intent.putExtra(QBaseActivity.KEY_SET_ACTIVITY_ANIMATION, true);
        intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_ENTER_ANIMATION, R.anim.f154445lb);
        intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_EXIT_ANIMATION, R.anim.f154449lf);
        intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_ENTER_ANIMATION, R.anim.f154435l2);
        intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_EXIT_ANIMATION, R.anim.f154436l4);
    }

    private void addBundleVersionReport(Map<Integer, String> map) {
        map.put(2, ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).getGamePaHippyModuleName()) + "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* renamed from: doEnterPubAccount, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void lambda$jumpToHippyOrKuiklyFragmemt$1(Context context, int i3, ArrayList<QQGameMsgInfo> arrayList, int i16, String str) {
        int i17;
        ArrayList<QQGameMsgInfo> arrayList2;
        QLog.i(TAG, 1, "doEnterPubAccount:" + i16);
        this.mUnreadMsgCnt = i16;
        if (((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isGamePubKuiklySwitch()) {
            IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGameMsgManagerService.class, "");
            if (iGameMsgManagerService != null) {
                iGameMsgManagerService.setUnshowedUnreadCnt(0);
            }
            ((IQQGamePubMsgApi) QRoute.api(IQQGamePubMsgApi.class)).setMsgRead();
            JSONObject configJsonObj = ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAME_PUB_ACCOUNT_ENTER_KUIKLY_CONFIG);
            try {
                String optString = configJsonObj.optString("pageName");
                Map<String, Object> m3 = KuiklyLaunchParams.INSTANCE.m(configJsonObj.optJSONObject(ISchemeApi.KEY_PAGE_DATA));
                m3.put("page_name", optString);
                i17 = 0;
                try {
                    m3.put("gameData", GamePubAccountHelper.n(arrayList, getGamePubLastReadTime(), i16, null));
                    m3.put("unreadNum", Integer.valueOf(i16));
                    m3.put(HippyQQConstants.STEP_NAME_OPEN_PAGE_START, Long.valueOf(System.currentTimeMillis()));
                    m3.put("gameExtra", str);
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 1, "[doEnterPubAccount] openKuikly:" + m3);
                    }
                    reportPubAccountClick(i3, true, i16, optString);
                    ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).launchKuiklyPage(context, nf2.a.b(m3));
                } catch (Exception e16) {
                    e = e16;
                    QLog.e(TAG, 1, e, new Object[i17]);
                    arrayList2 = arrayList;
                    if (arrayList.size() <= 0) {
                    }
                }
            } catch (Exception e17) {
                e = e17;
                i17 = 0;
            }
            arrayList2 = arrayList;
        } else {
            i17 = 0;
            String gamePaHippyModuleName = ((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).getGamePaHippyModuleName();
            Class<? extends QPublicBaseFragment> gameHippyFragment = getGameHippyFragment(gamePaHippyModuleName);
            if (gameHippyFragment == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "startQQGamePubAccount hippyFragment is null,moduleName=" + gamePaHippyModuleName);
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(OpenHippyInfo.EXTRA_KEY_IS_ANIMATED, true);
            bundle.putBoolean(OpenHippyInfo.EXTRA_KEY_IS_STATUSBAR_DARKFONT, !ThemeUtil.isNowThemeIsNight(null, false, null));
            bundle.putString("processName", "main");
            bundle.putString("bundleName", gamePaHippyModuleName);
            bundle.putString("domain", "gamecenter.qq.com");
            bundle.putBoolean(OpenHippyInfo.EXTRA_KEY_IS_CUSTOM_NIGHT_MODE, true);
            bundle.putLong(HippyQQConstants.STEP_NAME_OPEN_PAGE_START, System.currentTimeMillis());
            if (!TextUtils.isEmpty(str)) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("push_extra", str);
                SerializableMap serializableMap = new SerializableMap();
                serializableMap.wrapMap(hashMap);
                bundle.putSerializable(OpenHippyInfo.EXTRA_KEY_JS_PARAM_MAP, serializableMap);
            }
            Intent createQQGameIntent = createQQGameIntent(false);
            createQQGameIntent.putExtra("params", bundle);
            createQQGameIntent.putExtra("public_fragment_window_feature", 1);
            arrayList2 = arrayList;
            createQQGameIntent.putExtra(TabPreloadItem.TAB_NAME_MESSAGE, arrayList2);
            createQQGameIntent.putExtra("unreadNum", i16);
            addAnimIntent(createQQGameIntent);
            reportPubAccountClick(i3, false, i16, gamePaHippyModuleName);
            QPublicFragmentActivity.b.b(context, createQQGameIntent, QPublicTransFragmentActivity.class, gameHippyFragment);
        }
        if (arrayList.size() <= 0) {
            QQGameMsgInfo qQGameMsgInfo = arrayList2.get(i17);
            processDirectJump(context, qQGameMsgInfo, i16);
            updateGamePubReadTimeByLastMsg(qQGameMsgInfo.msgTime);
        }
    }

    public static AppRuntime getAppRuntime() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private Class<? extends QPublicBaseFragment> getGameHippyFragment(String str) {
        GamePubAccountHelper.T("6");
        return GamePAHippyFragmentV2.class;
    }

    @Nullable
    private String getPeerUidByUin(String str) {
        if (getAppRuntime() instanceof AppInterface) {
            String uid = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getUid((AppInterface) getAppRuntime(), str);
            if (((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).isValidUin(str) && !TextUtils.isEmpty(uid)) {
                ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).saveUidByUin(str, uid);
            }
            QLog.d(TAG, 2, "[getGamePubPeerUid] getUid:" + uid);
            return uid;
        }
        return null;
    }

    public static int getProcessPid(Context context, String str) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context != null && (activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)) != null && (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager)) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (str.compareTo(runningAppProcessInfo.processName) == 0) {
                    return runningAppProcessInfo.pid;
                }
            }
            return -1;
        }
        return -1;
    }

    private String getPushMsgId(Context context) {
        Intent intent;
        if (!(context instanceof Activity) || (intent = ((Activity) context).getIntent()) == null) {
            return null;
        }
        return intent.getStringExtra("game_push_msg_id");
    }

    private IQQGamePushMsgService getQQGamePushMsgService() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        return (IQQGamePushMsgService) peekAppRuntime.getRuntimeService(IQQGamePushMsgService.class, "all");
    }

    private void jumpToHippyOrKuiklyFragmemt(final Context context, final int i3, final ArrayList<QQGameMsgInfo> arrayList, int i16, final String str) {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject configJsonObj = ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAMEPLAT_GAME_PUB_HIPPY);
        QLog.i(TAG, 1, "[jumpToHippyOrKuiklyFragmemt] parse redDotCacheSwitch cost:" + (System.currentTimeMillis() - currentTimeMillis));
        if (i16 != -1 && configJsonObj.optInt("redDotCacheSwitch", 1) == 1) {
            lambda$jumpToHippyOrKuiklyFragmemt$1(context, i3, arrayList, i16, str);
        } else {
            ((IQQGamePubMsgApi) QRoute.api(IQQGamePubMsgApi.class)).getUnreadCnt(new IQQGamePubMsgApi.c() { // from class: com.tencent.mobileqq.qqgamepub.api.impl.e
                @Override // com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi.c
                public final void onSuccess(int i17) {
                    QQGameHelperImpl.this.lambda$jumpToHippyOrKuiklyFragmemt$1(context, i3, arrayList, str, i17);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$findGameMallRecentMessage$3(IQQGameHelper.a aVar, ArrayList arrayList) {
        aVar.onGetMsgInfo(GamePubAccountHelper.o(arrayList, System.currentTimeMillis(), 0L, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startQQGamePaH5$0(Intent intent, Activity activity, int i3) {
        intent.putExtra("unreadNum", i3);
        intent.putExtra("arkResPath", ArkEnvironmentManager.getInstance().getAppResPath(""));
        QPublicFragmentActivityForTool.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) QQGameFeedWebFragment.class, 10000);
        loadQGameHtmlOffline();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startQQGamePubAccount$2(Context context, int i3, int i16, String str, ArrayList arrayList) {
        this.mMsgList = arrayList;
        jumpToHippyOrKuiklyFragmemt(context, i3, arrayList, i16, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateGamePubReadTimeByLastMsg$4(long j3) {
        QMMKV.from(BaseApplication.getContext(), "vas_mmkv_configurations").encodeLong("sp_key_pub_account_read_time_" + MD5Utils.encodeHexStr(getAccount()), j3);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "updateConversationReadTime:" + j3);
        }
    }

    private void processDirectJump(Context context, QQGameMsgInfo qQGameMsgInfo, int i3) {
        QLog.i(TAG, 2, "[processDirectJump] unreadCnt:" + i3);
        if (i3 > 0 && (context instanceof Activity)) {
            try {
                QQGameDirectJumpHandler.INSTANCE.a().b((Activity) context, qQGameMsgInfo);
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
        }
    }

    private void report(int i3, int i16, String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "report from\uff1a" + i3 + " status: " + i16);
        }
        ThreadManagerV2.excute(new AnonymousClass2(i3, i16, ((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).isCanPreloadByTab(str)), 128, null, true);
    }

    private void reportPubAccountClick(int i3, boolean z16, int i16, String str) {
        Object obj;
        HashMap hashMap = new HashMap();
        String str2 = "2";
        String str3 = "0";
        if (i3 == 2) {
            obj = "1";
        } else if (i3 == 0) {
            obj = "2";
        } else {
            obj = "0";
        }
        hashMap.put(3, obj);
        if (!z16) {
            str2 = "1";
        }
        hashMap.put(2, str2);
        hashMap.put(29, str);
        if (i16 > 0) {
            str3 = "1";
        }
        hashMap.put(6, str3);
        com.tencent.mobileqq.qqgamepub.utils.a.k("989556", "20", "1", "160", "770", "77002", "", hashMap);
    }

    private void startQQGamePaH5(final Activity activity) {
        if (((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isPubFeedByWeb()) {
            GamePubAccountHelper.T("1");
            QLog.d(TAG, 1, "--->enter GamePubAccount to H5");
            final Intent createQQGameIntent = createQQGameIntent(true);
            addAnimIntent(createQQGameIntent);
            ((IQQGamePubMsgApi) QRoute.api(IQQGamePubMsgApi.class)).getUnreadCnt(new IQQGamePubMsgApi.c() { // from class: com.tencent.mobileqq.qqgamepub.api.impl.g
                @Override // com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi.c
                public final void onSuccess(int i3) {
                    QQGameHelperImpl.this.lambda$startQQGamePaH5$0(createQQGameIntent, activity, i3);
                }
            });
            return;
        }
        QLog.d(TAG, 1, "--->enter GamePubAccount to aio");
        enterAIO(activity);
    }

    private void updateGamePubReadTimeByLastMsg(final long j3) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.api.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                QQGameHelperImpl.this.lambda$updateGamePubReadTimeByLastMsg$4(j3);
            }
        }, 64, null, false);
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public Pair<String, JSONObject> addQQGameArkField(String str, String str2, String str3, JSONObject jSONObject) throws JSONException {
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (Pair) iPatchRedirector.redirect((short) 29, this, str, str2, str3, jSONObject);
        }
        Iterator keys = jSONObject.keys();
        String str5 = "";
        String str6 = "";
        while (true) {
            if (keys.hasNext()) {
                i3++;
                if (i3 != 1) {
                    break;
                }
                str6 = (String) keys.next();
            } else {
                str5 = str6;
                break;
            }
        }
        if (!TextUtils.isEmpty(str5)) {
            JSONObject optJSONObject = jSONObject.optJSONObject(str5);
            if (optJSONObject == null) {
                return null;
            }
            optJSONObject.put("nativeScene", "gamePubAccount");
            optJSONObject.put("arkViewId", str2);
            if ("6".equals(str3)) {
                str4 = "3";
            } else {
                str4 = str3;
            }
            optJSONObject.put("gamePubType", str4);
            optJSONObject.put("__clickTime", getClickAioTime());
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "QQGameMsgParserImpl arkViewId = " + str2 + ",gamePubType=" + str3 + ",__clicktime:" + getClickAioTime() + ",retPubType:" + str4);
            }
            ((IQQGamePreDownloadService) QRoute.api(IQQGamePreDownloadService.class)).setArkResNameToMeta(str, optJSONObject);
            jSONObject.put(str5, optJSONObject);
            return new Pair<>(str5, optJSONObject);
        }
        QLog.e(TAG, 1, "addQQGameArkField,metaData has more 2 key");
        return null;
    }

    public Intent createQQGameIntent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Intent) iPatchRedirector.redirect((short) 8, (Object) this, z16);
        }
        boolean z17 = true;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "createQQGameIntent isWithColdBoot =" + z16);
        }
        Intent intent = new Intent();
        intent.putExtra("settingInfo", "");
        intent.putExtra("big_brother_source_key", "biz_src_zf_games");
        intent.putExtra("moduleId", "cmshowgame_module");
        intent.putExtra("startTime", SystemClock.elapsedRealtime());
        intent.putExtra("clickTime", System.currentTimeMillis());
        intent.putExtra("lastReadTime", getGamePubLastReadTime());
        if (z16) {
            if (getProcessPid(MobileQQ.sMobileQQ, "com.tencent.mobileqq:tool") != -1) {
                z17 = false;
            }
            intent.putExtra("isColdBoot", z17);
        }
        return intent;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public void dispatchVideoEvent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
        } else {
            com.tencent.mobileqq.qqgamepub.utils.b.b(i3);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public void enterAIO(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            enterAIO(activity, false);
        } else {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) activity);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public void enterGameCenter(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
            return;
        }
        if (((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).canOpenHippyByModuleName(HippyQQConstants.ModuleName.QQ_GAME_CENTER) == 0) {
            ((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).openQQGameCenterByHippy(BaseApplication.getContext(), str, "publicplat");
            return;
        }
        if (URLUtil.isValidUrl(str)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            String str2 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
            if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                str2 = ContainerUtils.FIELD_DELIMITER;
            }
            sb5.append(str2);
            sb5.append("forceHtml=true");
            startGameCenterActivity(BaseApplication.getContext(), sb5.toString());
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public void findGameMallRecentMessage(int i3, final IQQGameHelper.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3, (Object) aVar);
            return;
        }
        if (i3 <= 0) {
            aVar.onGetMsgInfo(null);
            return;
        }
        if (MobileQQ.sProcessId != 1) {
            aVar.onGetMsgInfo(null);
            QLog.e(TAG, 1, "findGameMallRecentMessage not in main process");
        } else if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            aVar.onGetMsgInfo(null);
            QLog.e(TAG, 1, "findGameMallRecentMessage appRuntime is null");
        } else {
            ((IGameMallNtApi) QRoute.api(IGameMallNtApi.class)).getBusinessMsgList(i3, 15, new IGameMallNtApi.a() { // from class: com.tencent.mobileqq.qqgamepub.api.impl.f
                @Override // com.tencent.mobileqq.qqgamepub.nt.api.IGameMallNtApi.a
                public final void onSuccess(ArrayList arrayList) {
                    QQGameHelperImpl.lambda$findGameMallRecentMessage$3(IQQGameHelper.a.this, arrayList);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public ActivityURIRequest getAIOURIRequest(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (ActivityURIRequest) iPatchRedirector.redirect((short) 21, (Object) this, (Object) context);
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_CHAT_ACTVITY);
        BaseAIOUtils.n(activityURIRequest, new int[]{1});
        activityURIRequest.extra().putBoolean("open_chatfragment", true);
        ((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).initPublicAccountChatPieIntent(activityURIRequest);
        activityURIRequest.extra().putString("uin", "2747277822");
        activityURIRequest.extra().putString("key_peerId", getGamePubPeerUid());
        activityURIRequest.extra().putInt("uintype", 1008);
        activityURIRequest.extra().putInt(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 1);
        activityURIRequest.extra().putInt("aio_msg_source", 0);
        if (!(context instanceof Activity)) {
            activityURIRequest.setFlags(268435456);
        }
        return activityURIRequest;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public String getAccount() {
        String account;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (account = peekAppRuntime.getAccount()) == null) {
            return "0";
        }
        return account;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public long getClickAioTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Long) iPatchRedirector.redirect((short) 30, (Object) this)).longValue();
        }
        return this.mClickPubAioTime;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public List<QQGameMsgInfo> getCurrentMsgList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (List) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        return this.mMsgList;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public com.tencent.mobileqq.qqgamepub.view.a getGameArkView(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (com.tencent.mobileqq.qqgamepub.view.a) iPatchRedirector.redirect((short) 28, (Object) this, (Object) activity);
        }
        return new GameArkView(activity, null);
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public String getGameMallPeerUid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (String) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        String peerUidByUin = getPeerUidByUin("3593944551");
        if (TextUtils.isEmpty(peerUidByUin)) {
            return "u_BWXiWqJtbtbmrr2h5LELQg";
        }
        return peerUidByUin;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public long getGamePubLastReadTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        long decodeLong = QMMKV.from(BaseApplication.getContext(), "vas_mmkv_configurations").decodeLong("sp_key_pub_account_read_time_" + MD5Utils.encodeHexStr(getAccount()), 0L);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getGamePubLastReadTime:" + decodeLong);
        }
        return decodeLong;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public String getGamePubPeerUid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        String peerUidByUin = getPeerUidByUin("2747277822");
        if (TextUtils.isEmpty(peerUidByUin)) {
            return "u_-PBswiplK-7J7bmaQLA-mA";
        }
        return peerUidByUin;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public com.tencent.mobileqq.qqgamepub.view.a getMoreMsgHeaderView(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (com.tencent.mobileqq.qqgamepub.view.a) iPatchRedirector.redirect((short) 27, (Object) this, (Object) activity);
        }
        return new MoreMsgHeaderView(activity);
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public QIPCModule getQQGameIPCModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (QIPCModule) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return com.tencent.mobileqq.qqgamepub.ipc.b.d();
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public String getQQGameIPCModuleName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return "QQGameIPCModule";
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    @Deprecated
    public int getRedDotUnreadCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime instanceof BaseQQAppInterface) {
            return ((IConversationFacade) ((BaseQQAppInterface) appRuntime).getRuntimeService(IConversationFacade.class)).getUnreadCount("2747277822", 1008);
        }
        return 0;
    }

    protected WadlReportBuilder getReportBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (WadlReportBuilder) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return new WadlReportBuilder();
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public int getUnreadCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Integer) iPatchRedirector.redirect((short) 41, (Object) this)).intValue();
        }
        return this.mUnreadMsgCnt;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public void initClickAioTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        this.mClickPubAioTime = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "initClickAioTime:" + this.mClickPubAioTime);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public boolean isFollowPubAccount() {
        IPublicAccountDetail findAccountDetailInfoCache;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (findAccountDetailInfoCache = ((IPublicAccountDataManager) peekAppRuntime.getRuntimeService(IPublicAccountDataManager.class, "all")).findAccountDetailInfoCache("2747277822")) == null || findAccountDetailInfoCache.getFollowType() != 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public boolean isInValidGameAppId(String str) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str)).booleanValue();
        }
        try {
            j3 = Integer.parseInt(str);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            j3 = 0;
        }
        if (j3 != 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public boolean isNewPubStyle(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this, (Object) context, (Object) str)).booleanValue();
        }
        if (!isQQGamePubAccount(str) || !(context instanceof Activity)) {
            return false;
        }
        return ((Activity) context).getIntent().getBooleanExtra("game_pub_new_style_key", false);
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public boolean isQQGamePubAccount(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) str)).booleanValue();
        }
        return "2747277822".equals(str);
    }

    public void loadQGameHtmlOffline() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.api.impl.QQGameHelperImpl.1
                static IPatchRedirector $redirector_;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.qqgamepub.api.impl.QQGameHelperImpl$1$a */
                /* loaded from: classes16.dex */
                class a implements com.tencent.biz.common.offline.a {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // com.tencent.biz.common.offline.a
                    public void loaded(String str, int i3) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
                        } else if (QLog.isColorLevel()) {
                            QLog.d(QQGameHelperImpl.TAG, 2, "load 4235 html web resource finish code:" + i3);
                        }
                    }

                    @Override // com.tencent.biz.common.offline.a
                    public void progress(int i3) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this, i3);
                        }
                    }
                }

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQGameHelperImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        HtmlOffline.j("4235", MobileQQ.sMobileQQ.peekAppRuntime(), true, new a());
                    }
                }
            }, 128, null, true);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public void preDownloadDirectJumpRes(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) jSONObject);
        } else {
            QQGameDirectJumpHandler.INSTANCE.a().d(jSONObject);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public void publicAccountTianshuReport(int i3, QQGameMsgInfo qQGameMsgInfo, int i16) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), qQGameMsgInfo, Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "publicAccountTianshuReport---> action=" + i3, "   position=" + i16);
        }
        if (qQGameMsgInfo == null) {
            return;
        }
        if (i3 == 117) {
            ((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).publicAccountExposureReport(qQGameMsgInfo.frienduin, qQGameMsgInfo.uniseq);
        }
        if (TextUtils.isEmpty(qQGameMsgInfo.advId)) {
            str = "";
        } else {
            str = qQGameMsgInfo.advId;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).exePublicAccountTianshuReport(i3, i16, str, qQGameMsgInfo.triggerInfo);
        if (i3 == 117) {
            str2 = "207701";
        } else if (i3 == 118) {
            str2 = "207702";
        } else {
            return;
        }
        String str3 = str2;
        HashMap hashMap = new HashMap();
        hashMap.put(2, str);
        hashMap.put(6, i3 + "");
        hashMap.put(24, GamePubAccountHelper.s());
        com.tencent.mobileqq.qqgamepub.utils.a.l(((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", str3, qQGameMsgInfo.gameAppId, "76926", "1", "160", hashMap);
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public void reportAioListItemClick(String str, String str2, int i3, String str3, MsgRecord msgRecord) {
        String str4;
        String str5;
        String str6;
        String str7;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, str, str2, Integer.valueOf(i3), str3, msgRecord);
            return;
        }
        QQGameMsgInfo g16 = com.tencent.mobileqq.qqgamepub.nt.c.g(msgRecord);
        HashMap hashMap = new HashMap();
        if (i3 > 0) {
            str4 = "1";
        } else {
            str4 = "2";
        }
        hashMap.put(7, str4);
        if (g16 == null) {
            str5 = "";
        } else {
            str5 = g16.tianshuFootageid + "";
        }
        hashMap.put(8, str5);
        hashMap.put(49, i3 + "");
        if (g16 == null) {
            str6 = "";
        } else {
            str6 = g16.fid;
        }
        hashMap.put(50, str6);
        if (isQQGamePubAccount(str)) {
            addBundleVersionReport(hashMap);
        }
        if (g16 != null) {
            i16 = g16.retId;
        }
        int i17 = i16;
        if (g16 == null) {
            str7 = "";
        } else {
            str7 = g16.advId;
        }
        com.tencent.mobileqq.qqgamepub.utils.a.j(str2, "20", "1", str3, "9389", "938901", str7, i17, hashMap);
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public void reportAioListItemExposure(String str, int i3, MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), msgRecord);
            return;
        }
        QLog.i(TAG, 2, "reportAioListItemExposure, uin: " + str + ", unreadNum: " + i3);
        if (i3 <= 0) {
            return;
        }
        QQGameMsgInfo g16 = com.tencent.mobileqq.qqgamepub.nt.c.g(msgRecord);
        if (g16 == null) {
            QLog.i(TAG, 2, "reportAioListItemExposure qqGameMsgInfo is null");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(8, g16.tianshuFootageid + "");
        hashMap.put(49, i3 + "");
        hashMap.put(50, g16.fid);
        if (isQQGamePubAccount(str)) {
            addBundleVersionReport(hashMap);
            com.tencent.mobileqq.qqgamepub.utils.a.j("914162", "8", "1", "160", "9389", "938901", g16.advId, g16.retId, hashMap);
        } else if ("3593944551".equals(str)) {
            com.tencent.mobileqq.qqgamepub.utils.a.k("914164", "8", "1", "1033", "9389", "938901", g16.advId, hashMap);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public void reportNoticeToDc87(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, str, str2, str3, str4, str5, str6, str7, str8);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "reportNoticeToDc87: operId: " + str + ",ext4: " + str2 + ",noticeId: " + str7 + ", buissId: " + str8);
        }
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_ATTA_NOTICE).setOperModule(str5).setOperId(str).setExt(1, str6).setExt(4, str2).setExt(11, str3).setExt(12, str4).setExt(3, str7).setExt(6, str8);
        wadlReportBuilder.report();
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public void reportWangzheRedpacketEggs(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, str3, str4, str5, str6, str7, str8);
            return;
        }
        WadlReportBuilder reportBuilder = getReportBuilder();
        reportBuilder.setDcId(WadlProxyConsts.TAG_ATTA_157).setModuleType(str4).setPage(str2).setBusiness(str).setOperModule(str3).setOperId(str5).setLogicId(str8).setOpertype(str6).setExt(2, str7);
        ((IQQGameReportService) QRoute.api(IQQGameReportService.class)).report157(reportBuilder);
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public void showGameEnterCacheInfo(View view, GmpEnterInfoRsp gmpEnterInfoRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view, (Object) gmpEnterInfoRsp);
            return;
        }
        if (!(view instanceof NavBarQQGamePub)) {
            return;
        }
        NavBarQQGamePub navBarQQGamePub = (NavBarQQGamePub) view;
        if (!TextUtils.isEmpty(gmpEnterInfoRsp.url) && !TextUtils.isEmpty(gmpEnterInfoRsp.bubbleId)) {
            if (navBarQQGamePub != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 1, "show game enter cache icon");
                }
                navBarQQGamePub.setCurType(3);
                navBarQQGamePub.j(gmpEnterInfoRsp.url);
                navBarQQGamePub.setmBubbleid(gmpEnterInfoRsp.bubbleId);
                navBarQQGamePub.m(true);
                return;
            }
            return;
        }
        if (navBarQQGamePub != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "show game enter");
            }
            navBarQQGamePub.setCurType(1);
            navBarQQGamePub.m(false);
            navBarQQGamePub.setmBubbleid("");
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public void startGameCenterActivity(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) context, (Object) str);
        } else {
            if (context == null) {
                return;
            }
            GameCenterUtil.gotoGameCenterPage(str);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public boolean startGameMallPubAccount(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) context, i3)).booleanValue();
        }
        JSONObject configJsonObj = ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAMEPLAT_MALL_HIPPY);
        if (!configJsonObj.has("bundleName")) {
            QLog.e(TAG, 1, "startGameMallPubAccount no config");
            return false;
        }
        OpenHippyInfo openHippyInfo = new OpenHippyInfo(configJsonObj);
        if (openHippyInfo.checkData()) {
            openHippyInfo.openHippy(context);
            return true;
        }
        QLog.e(TAG, 1, "startGameMallPubAccount check data failed");
        return false;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public void startQQGamePubAccount(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            startQQGamePubAccount(context, i3, -1, null);
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, i3);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public void startQQGamePubFromRecent(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) context, i3);
        } else {
            startQQGamePubAccount(context, 2, i3, null);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public void enterAIO(Activity activity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, activity, Boolean.valueOf(z16));
            return;
        }
        if (activity == null || activity.isFinishing()) {
            return;
        }
        QLog.d(TAG, 1, "--->enter GamePubAccount by AIO,fromGamePub:" + z16);
        try {
            initClickAioTime();
            ActivityURIRequest aIOURIRequest = getAIOURIRequest(activity);
            aIOURIRequest.extra().putBoolean("key_is_from_game_pub", z16);
            aIOURIRequest.extra().putBoolean("game_pub_new_style_key", z16);
            aIOURIRequest.extra().putBoolean("game_pub_is_night_mode", ((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).isInNightMode());
            aIOURIRequest.extra().putString("uinname", activity.getString(z16 ? R.string.f1763230y : R.string.ivu));
            QRoute.startUri(aIOURIRequest, (o) null);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public void startQQGamePubAccount(Context context, int i3, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, context, Integer.valueOf(i3), hashMap);
            return;
        }
        String pushMsgId = getPushMsgId(context);
        IQQGamePushMsgService qQGamePushMsgService = getQQGamePushMsgService();
        if (!TextUtils.isEmpty(pushMsgId) && qQGamePushMsgService != null) {
            qQGamePushMsgService.reportPushMsgClicked(pushMsgId);
            if (!qQGamePushMsgService.isFollowPubAccount("2747277822")) {
                QLog.i(TAG, 1, "startQQGamePubAccount push msg, account not followed");
                return;
            }
        }
        startQQGamePubAccount(context, i3, -1, hashMap == null ? null : hashMap.get("game_extra"));
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
    public void reportNoticeToDc87(int i3, AcsMsg acsMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, i3, (Object) acsMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "reportNewTo87: " + i3 + ", acsMsg: " + acsMsg);
        }
        if (acsMsg == null) {
            return;
        }
        reportNoticeToDc87("914026", "8", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9377", "937701", acsMsg.msg_id, acsMsg.busi_id);
        if (i3 == 3) {
            reportNoticeToDc87("914029", "20", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9377", "937701", acsMsg.msg_id, acsMsg.busi_id);
        } else if (i3 == 1) {
            reportNoticeToDc87("914025", "20", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9377", "937701", acsMsg.msg_id, acsMsg.busi_id);
        } else if (i3 == 4) {
            reportNoticeToDc87("914031", "20", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9377", "937701", acsMsg.msg_id, acsMsg.busi_id);
        }
    }

    private void startQQGamePubAccount(final Context context, final int i3, final int i16, final String str) {
        initClickAioTime();
        String gamePaHippyModuleName = ((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).getGamePaHippyModuleName();
        int hippyReportState = ((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).getHippyReportState(gamePaHippyModuleName);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "startQQGamePubAccount reportState=" + hippyReportState + ",moduleName=" + gamePaHippyModuleName + MttLoader.QQBROWSER_PARAMS_FROME + i3);
        }
        report(i3, hippyReportState, gamePaHippyModuleName);
        if (!((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isGamePubHippySwitch() && !((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isGamePubKuiklySwitch()) {
            startQQGamePaH5((Activity) context);
        } else {
            ((IQQGamePubMsgApi) QRoute.api(IQQGamePubMsgApi.class)).getBusinessMsgList(10, 12, new IQQGamePubMsgApi.a() { // from class: com.tencent.mobileqq.qqgamepub.api.impl.h
                @Override // com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi.a
                public final void onSuccess(ArrayList arrayList) {
                    QQGameHelperImpl.this.lambda$startQQGamePubAccount$2(context, i3, i16, str, arrayList);
                }
            }, "startQQGamePubAccount");
        }
    }
}
