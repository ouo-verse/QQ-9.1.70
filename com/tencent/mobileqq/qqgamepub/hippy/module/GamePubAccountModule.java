package com.tencent.mobileqq.qqgamepub.hippy.module;

import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.hippy.qq.fragment.BaseHippyFragment;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qqgamepub.api.IQQGameAdService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameResService;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyBaseFragment;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

@HippyNativeModule(name = GamePubAccountModule.TAG)
/* loaded from: classes16.dex */
public class GamePubAccountModule extends QQBaseModule {
    static final String TAG = "GamePubAccountModule";

    /* loaded from: classes16.dex */
    public static class a implements TianShuGetAdvCallback {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<GamePubAccountModule> f264541d;

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<Promise> f264542e;

        public a(GamePubAccountModule gamePubAccountModule, Promise promise) {
            this.f264541d = new WeakReference<>(gamePubAccountModule);
            this.f264542e = new WeakReference<>(promise);
        }

        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        public void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
            GamePubAccountModule gamePubAccountModule = this.f264541d.get();
            Promise promise = this.f264542e.get();
            if (gamePubAccountModule != null && promise != null) {
                gamePubAccountModule.doAfterGetAdvs(z16, getAdsRsp, promise);
                return;
            }
            QLog.e(GamePubAccountModule.TAG, 1, "[onGetAdvs] ref is null,module:" + gamePubAccountModule + ",promise:" + promise);
        }
    }

    public GamePubAccountModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAfterGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp, Promise promise) {
        HippyMap hippyMap = new HippyMap();
        if (z16 && getAdsRsp != null) {
            JSONObject handleTianShuRsp = handleTianShuRsp(getAdsRsp);
            QLog.i(TAG, 1, "[reqBubbleNoticeInfo] " + handleTianShuRsp);
            hippyMap.pushJSONObject(handleTianShuRsp);
        } else {
            QLog.i(TAG, 1, "[reqBubbleNoticeInfo] response has exception");
            GamePubAccountHelper.d();
        }
        doPromiseCallback(promise, hippyMap);
    }

    private void doPromiseCallback(Promise promise, Object obj) {
        if (promise != null && promise.isCallback() && obj != null) {
            promise.resolve(obj);
        }
    }

    private void doTianShuNoticeReport(String str, String str2, String str3, int i3) {
        com.tencent.mobileqq.qqgamepub.data.a aVar = new com.tencent.mobileqq.qqgamepub.data.a();
        aVar.f264496a = str3;
        aVar.f264499d = str;
        aVar.f264500e = str2;
        aVar.f264498c = i3;
        ((IQQGameAdService) QRoute.api(IQQGameAdService.class)).reportTianShu(aVar);
    }

    private JSONObject handleTianShuRsp(TianShuAccess.GetAdsRsp getAdsRsp) {
        List<TianShuAccess.RspEntry> list;
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField;
        try {
            if (getAdsRsp.mapAds.has()) {
                list = getAdsRsp.mapAds.get();
            } else {
                list = null;
            }
            if (list != null && list.size() != 0) {
                TianShuAccess.RspEntry rspEntry = list.get(0);
                if (rspEntry != null && (adPlacementInfo = rspEntry.value) != null && (pBRepeatMessageField = adPlacementInfo.lst) != null) {
                    List<TianShuAccess.AdItem> list2 = pBRepeatMessageField.get();
                    if (list2 != null && list2.size() != 0) {
                        JSONObject b16 = com.tencent.mobileqq.qqgamepub.utils.a.b(list2.get(0));
                        GamePubAccountHelper.z(GamePubAccountHelper.s()).setOperModule("770").setModuleType("77002").setOperId("209300").setExt(2, b16.optString("notice_id")).setExt(4, "18").report();
                        return b16;
                    }
                    QLog.i(TAG, 1, "[reqBubbleNoticeInfo] no ads item~");
                    GamePubAccountHelper.d();
                    return null;
                }
                QLog.i(TAG, 1, "[reqBubbleNoticeInfo] ads resp param is error.");
                GamePubAccountHelper.d();
                return null;
            }
            GamePubAccountHelper.d();
            return null;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[reqBubbleNoticeInfo] [handleGetAdvCallback], error happens! " + th5.getMessage());
            GamePubAccountHelper.d();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pageSwipperToIndex$0(String str) {
        int i3;
        QBaseFragment fragment = getFragment();
        if (fragment instanceof BaseHippyFragment) {
            boolean z16 = false;
            try {
                i3 = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                i3 = 0;
            }
            BaseHippyFragment baseHippyFragment = (BaseHippyFragment) fragment;
            if (!baseHippyFragment.isFragmentDestroyed()) {
                if (i3 == 0) {
                    z16 = true;
                }
                baseHippyFragment.enableRightFling(z16);
            }
        }
    }

    private void sendEvent(String str, HippyMap hippyMap) {
        ((EventDispatcher) this.mContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(str, hippyMap);
    }

    @HippyMethod(name = "changeMsgHelperUIStyle")
    public void changeMsgHelperUIStyle(Promise promise, int i3) {
        Intent intent = new Intent("action_qgame_theme_change");
        intent.putExtra("key_msg_helper_style", i3);
        intent.setPackage(MobileQQ.sMobileQQ.getPackageName());
        MobileQQ.sMobileQQ.sendBroadcast(intent);
        QLog.i(TAG, 1, "[changeMsgHelperStyle] style:" + i3);
    }

    @HippyMethod(name = "clearBubbleNoticeCache")
    public void clearBubbleNoticeCache(Promise promise) {
        GamePubAccountHelper.d();
        QLog.i(TAG, 1, "clearGameNoticeCache");
    }

    @Override // com.tencent.hippy.qq.module.QQBaseModule, com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        super.destroy();
    }

    @HippyMethod(name = "finishActivity")
    public void finishActivity(Promise promise) {
        QLog.d(TAG, 1, "hippy call finishActivity");
        final QBaseFragment fragment = getFragment();
        if (fragment instanceof GamePAHippyBaseFragment) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.module.GamePubAccountModule.3
                @Override // java.lang.Runnable
                public void run() {
                    ((GamePAHippyBaseFragment) fragment).finish();
                }
            });
        }
    }

    @HippyMethod(name = "getGameNoticeCache")
    public void getBubbleNoticeCache(Promise promise) {
        JSONObject q16 = GamePubAccountHelper.q();
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushJSONObject(q16);
        doPromiseCallback(promise, hippyMap);
        QLog.i(TAG, 1, "[getGameNoticeCache] " + q16);
    }

    @HippyMethod(name = "dsl_get_content")
    public void getDSLContent(HippyMap hippyMap, Promise promise) {
        StringBuilder sb5;
        long currentTimeMillis = System.currentTimeMillis();
        String str = "";
        try {
            try {
                str = ((IQQGameResService) QRoute.api(IQQGameResService.class)).getActivityDSL(hippyMap.toJSONObject().optString("dslId"), 0);
                doPromiseCallback(promise, str);
            } catch (Exception e16) {
                QLog.d(TAG, 1, "getDSLContent, Exception :" + e16);
                doPromiseCallback(promise, "");
                if (QLog.isColorLevel()) {
                    sb5 = new StringBuilder();
                } else {
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                sb5 = new StringBuilder();
                sb5.append("getDSLContent:");
                sb5.append(hippyMap);
                sb5.append(",cost:");
                sb5.append(System.currentTimeMillis() - currentTimeMillis);
                sb5.append(",promise:");
                sb5.append(promise);
                sb5.append(",dsl:");
                sb5.append(str);
                QLog.i(TAG, 2, sb5.toString());
            }
        } catch (Throwable th5) {
            doPromiseCallback(promise, "");
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getDSLContent:" + hippyMap + ",cost:" + (System.currentTimeMillis() - currentTimeMillis) + ",promise:" + promise + ",dsl:");
            }
            throw th5;
        }
    }

    @HippyMethod(name = "gc_hippy_notify_ark1111")
    public void notifyArk(String str, String str2, Promise promise) {
        try {
            QLog.d(TAG, 1, "hippy transfer data:" + str2 + ",appName:" + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ark.arkNotify(str, "", "gc_ark_rec_hippy", str2, ark.ARKMETADATA_JSON);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @HippyMethod(name = "onHippyFirstScreen")
    public void onHippyFirstScreen(Promise promise) {
        QLog.d(TAG, 1, "hippy call onHippyFirstScreen");
        QBaseFragment fragment = getFragment();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (fragment instanceof GamePAHippyBaseFragment) {
            ((GamePAHippyBaseFragment) fragment).uh(elapsedRealtime);
        }
    }

    @HippyMethod(name = "onHippyScrollBegin")
    public void onHippyScrollBegin(Promise promise) {
        QLog.d(TAG, 1, "hippy call onHippyScrollBegin");
        final QBaseFragment fragment = getFragment();
        if (fragment instanceof GamePAHippyBaseFragment) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.module.GamePubAccountModule.1
                @Override // java.lang.Runnable
                public void run() {
                    ((GamePAHippyBaseFragment) fragment).vh();
                }
            });
        }
    }

    @HippyMethod(name = "onHippyScrollEnd")
    public void onHippyScrollEnd(Promise promise) {
        QLog.d(TAG, 1, "hippy call onHippyScrollEnd");
        final QBaseFragment fragment = getFragment();
        if (fragment instanceof GamePAHippyBaseFragment) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.module.GamePubAccountModule.2
                @Override // java.lang.Runnable
                public void run() {
                    ((GamePAHippyBaseFragment) fragment).wh();
                }
            });
        }
    }

    @HippyMethod(name = "onHippyShow")
    public void onHippyShow(Promise promise) {
        QLog.d(TAG, 1, "hippy call onHippyShow");
        QBaseFragment fragment = getFragment();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (fragment instanceof GamePAHippyBaseFragment) {
            ((GamePAHippyBaseFragment) fragment).xh(elapsedRealtime);
        }
    }

    @HippyMethod(name = "openPubDetailPage")
    public void openPubDetailPage(Promise promise) {
        QBaseFragment fragment = getFragment();
        if (fragment != null && fragment.getActivity() != null) {
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(fragment.getActivity(), IPublicAccountDetailActivity.ROUTE_NAME);
            activityURIRequest.extra().putString("uin", "2747277822");
            activityURIRequest.extra().putBoolean("fromQGamePub", true);
            QRoute.startUri(activityURIRequest, (o) null);
        }
    }

    @HippyMethod(name = "pageSwipperToIndex")
    public void pageSwipperToIndex(final String str, Promise promise) {
        QLog.d(TAG, 1, String.format("hippy call pageSwipperToIndex: %1$s", str));
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.module.a
            @Override // java.lang.Runnable
            public final void run() {
                GamePubAccountModule.this.lambda$pageSwipperToIndex$0(str);
            }
        });
    }

    @HippyMethod(name = "pauseVideo")
    public void pauseVideo(Promise promise) {
        com.tencent.mobileqq.qqgamepub.utils.b.b(1);
    }

    @HippyMethod(name = "playVideo")
    public void playVideo(Promise promise) {
        com.tencent.mobileqq.qqgamepub.utils.b.b(2);
    }

    @HippyMethod(name = "queryMoreMsg")
    public void queryMoreMsg(Promise promise) {
        QBaseFragment fragment = getFragment();
        if (fragment != null && fragment.getActivity() != null) {
            ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).enterAIO(fragment.getActivity(), true);
        }
    }

    @HippyMethod(name = "report")
    public void report(String str, Promise promise) {
        if (!TextUtils.isEmpty(str)) {
            try {
                ((IQQGameReportService) QRoute.api(IQQGameReportService.class)).report(new JSONObject(str), 0);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    @HippyMethod(name = "reportBubbleNotice")
    public void reportBubbleNotice(Promise promise, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                doTianShuNoticeReport(jSONObject.optString("itemId"), jSONObject.optString(MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO), jSONObject.optString("appId"), jSONObject.optInt("action"));
                QLog.i(TAG, 1, "[reportBubbleNotice] reportJson:" + jSONObject);
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
        }
    }

    @HippyMethod(name = "reportTianshu")
    public void reportTianshu(String str, Promise promise) {
        if (!TextUtils.isEmpty(str)) {
            try {
                QLog.d(TAG, 1, "reportTianshu json =" + str);
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("itemdid");
                int optInt2 = jSONObject.optInt("position");
                String optString = jSONObject.optString("frienduin");
                int optInt3 = jSONObject.optInt("uniseq");
                String optString2 = jSONObject.optString("advid");
                String optString3 = jSONObject.optString("triggerInfo");
                String optString4 = jSONObject.optString("gameAppid");
                QQGameMsgInfo qQGameMsgInfo = new QQGameMsgInfo();
                qQGameMsgInfo.frienduin = optString;
                qQGameMsgInfo.uniseq = optInt3;
                qQGameMsgInfo.advId = optString2;
                qQGameMsgInfo.triggerInfo = optString3;
                qQGameMsgInfo.gameAppId = optString4;
                GamePubAccountHelper.G(optInt, qQGameMsgInfo, optInt2);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    @HippyMethod(name = "reqBubbleNoticeInfo")
    public void reqBubbleNoticeInfo(final Promise promise) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.module.GamePubAccountModule.4
            @Override // java.lang.Runnable
            public void run() {
                ((ITianshuManager) QRoute.api(ITianshuManager.class)).requestAdv(com.tencent.mobileqq.qqgamepub.utils.a.g(902), new a(GamePubAccountModule.this, promise));
            }
        }, 128, null, true);
    }

    @HippyMethod(name = "gc_hippy_notify_ark")
    public void notifyArk(HippyMap hippyMap, Promise promise) {
        if (hippyMap != null) {
            try {
                QLog.d(TAG, 1, "hippy transfer data:" + hippyMap);
                String string = hippyMap.getString("appName");
                String jSONObject = hippyMap.getMap("data").toJSONObject().toString();
                if (TextUtils.isEmpty(jSONObject)) {
                    jSONObject = "{}";
                }
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                ark.arkNotify(string, "", "gc_ark_rec_hippy", jSONObject, ark.ARKMETADATA_JSON);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }
}
