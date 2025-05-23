package com.tencent.mobileqq.qqgamepub.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.hippy.qq.view.scroll.HippyHeaderScrollViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static LruCache<String, List<String>> f264706a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27495);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f264706a = new LruCache<>(10);
        }
    }

    public static void a(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp, c cVar) {
        List<TianShuAccess.RspEntry> list;
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField;
        GamePubAccountHelper.R(NetConnInfoCenter.getServerTimeMillis());
        if (z16 && getAdsRsp != null) {
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
                            JSONObject b16 = b(list2.get(0));
                            GamePubAccountHelper.z(GamePubAccountHelper.s()).setOperModule("770").setModuleType("77002").setOperId("209300").setExt(2, b16.optString("notice_id")).setExt(4, "18").report();
                            cVar.a(b16);
                            return;
                        }
                        QLog.i("QQGamePub_GameCenterUtils", 1, "no ads item~");
                        cVar.b();
                        return;
                    }
                    QLog.i("QQGamePub_GameCenterUtils", 1, "ads resp param is error.");
                    cVar.b();
                    return;
                }
                cVar.b();
                return;
            } catch (Throwable th5) {
                cVar.b();
                QLog.e("QQGamePub_GameCenterUtils", 1, "[handleGetAdvCallback], error happens! " + th5.getMessage());
                return;
            }
        }
        QLog.i("QQGamePub_GameCenterUtils", 1, "response has exception");
        cVar.b();
    }

    public static JSONObject b(TianShuAccess.AdItem adItem) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        for (TianShuAccess.MapEntry mapEntry : adItem.argList.get()) {
            hashMap.put(mapEntry.key.get(), mapEntry.value.get());
        }
        QLog.i("QQGamePub_GameCenterUtils", 1, "before\u3010covertTianShuItemToJson\u3011: " + hashMap);
        JSONObject jSONObject2 = new JSONObject();
        String str = (String) hashMap.get("out_text");
        jSONObject2.put("text", str);
        jSONObject2.put("display", !StringUtil.isEmpty(str) ? 1 : 0);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("icon", hashMap.get("icon"));
        jSONObject3.put("text", hashMap.get("text"));
        jSONObject3.put("jump_type", hashMap.get("jump_type"));
        jSONObject3.put("jump_url", hashMap.get("jump_url"));
        jSONObject.put("notice_id", hashMap.get("id"));
        jSONObject.put("outer", jSONObject2);
        jSONObject.put("inner", jSONObject3);
        jSONObject.put("ts", NetConnInfoCenter.getServerTime());
        jSONObject.put("attach", hashMap.get("attach"));
        QLog.i("QQGamePub_GameCenterUtils", 1, "after\u3010covertTianShuItemToJson\u3011: " + jSONObject);
        jSONObject.put("adId", adItem.iAdId.get());
        jSONObject.put(MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, adItem.traceinfo.get());
        return jSONObject;
    }

    @NonNull
    @WorkerThread
    private static JSONObject c(Activity activity, @NonNull com.tencent.mobileqq.qqgamepub.data.d dVar) throws JSONException {
        int i3;
        List list = dVar.f264504a;
        if (list == null) {
            list = new ArrayList();
        }
        int i16 = dVar.f264506c;
        long j3 = dVar.f264505b;
        if (j3 == -1) {
            j3 = ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).getGamePubLastReadTime();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("gameData", GamePubAccountHelper.o(list, j3, i16, null));
        jSONObject.put(HippyHeaderScrollViewController.HEADER_HEIGHT, com.tencent.luggage.wxa.se.c.CTRL_INDEX);
        jSONObject.put("messageHeight", 0);
        jSONObject.put("msgNum", i16);
        jSONObject.put("gameMsgNum", d());
        jSONObject.put("navigationBarHeight", f());
        if (i16 == 0) {
            String x16 = GamePubAccountHelper.x(((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface());
            i3 = 0;
            while (i3 < list.size()) {
                String str = ((QQGameMsgInfo) list.get(i3)).paMsgid;
                if (str != null && str.equals(x16)) {
                    break;
                }
                i3++;
            }
        }
        i3 = 0;
        jSONObject.put("index", i3);
        jSONObject.put("socialMsgData", GamePubAccountHelper.q());
        try {
            if (activity instanceof QBaseActivity) {
                jSONObject.put("selectIndex", h((QBaseActivity) activity));
            }
        } catch (JSONException e16) {
            QLog.e("QQGamePub_GameCenterUtils", 1, e16, new Object[0]);
        }
        return jSONObject;
    }

    public static int d() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            int unreadCnt4MsgTab = ((IGameMsgManagerService) peekAppRuntime.getRuntimeService(IGameMsgManagerService.class, "")).getUnreadCnt4MsgTab();
            if (QLog.isColorLevel()) {
                QLog.d("QQGamePub_GameCenterUtils", 4, "GameMsgUnreadCnt =" + unreadCnt4MsgTab);
                return unreadCnt4MsgTab;
            }
            return unreadCnt4MsgTab;
        }
        return 0;
    }

    public static JSONObject e(Activity activity, @NonNull com.tencent.mobileqq.qqgamepub.data.d dVar) {
        try {
            JSONObject c16 = c(activity, dVar);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("GpInitData", c16);
            if (QLog.isColorLevel()) {
                QLog.d("QQGamePub_GameCenterUtils", 1, "feedEventJson=" + c16);
            }
            return jSONObject;
        } catch (JSONException e16) {
            QLog.e("QQGamePub_GameCenterUtils", 1, e16, new Object[0]);
            return null;
        }
    }

    private static float f() {
        Resources resources = MobileQQ.sMobileQQ.getResources();
        return g.b(resources.getDimensionPixelSize(R.dimen.title_bar_height) + resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android")), resources);
    }

    public static List<TianShuAdPosItemData> g(int i3) {
        ArrayList arrayList = new ArrayList();
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mNeedCnt = 1;
        tianShuAdPosItemData.mPosId = i3;
        arrayList.add(tianShuAdPosItemData);
        return arrayList;
    }

    private static int h(QBaseActivity qBaseActivity) {
        Intent intent;
        if (qBaseActivity == null || (intent = qBaseActivity.getIntent()) == null || !intent.hasExtra("selectIndex")) {
            return 1;
        }
        return intent.getIntExtra("selectIndex", 1);
    }

    public static void i(Activity activity, String str) {
        if (!TextUtils.isEmpty(str) && !activity.isFinishing()) {
            Intent intent = new Intent();
            if (HttpUtil.isValidUrl(str)) {
                intent.putExtra("url", str);
                RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTE_BROWSER);
                return;
            }
            try {
                intent.setData(Uri.parse(str));
                RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTER_JUMP);
                return;
            } catch (Exception e16) {
                QLog.e("QQGamePub_GameCenterUtils", 1, e16, new Object[0]);
                return;
            }
        }
        QLog.e("QQGamePub_GameCenterUtils", 1, "[jumpUrlOrSchema] url is empty or activity isFinishing");
    }

    public static void j(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, Map<Integer, String> map) {
        if (QLog.isColorLevel()) {
            QLog.i("QQGamePub_GameCenterUtils", 2, "reportDC00087New: operId=" + str + ", retId=" + i3 + ",adId= " + str7 + ",extsMap=" + map);
        }
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule(str5).setOperId(str).setRetId(i3).setExt(1, str6).setExt(4, str2).setExt(11, str3).setExt(12, str4).setExt(41, str7);
        if (map != null && map.keySet().size() > 0) {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                wadlReportBuilder.setExt(entry.getKey().intValue(), entry.getValue());
            }
        }
        wadlReportBuilder.report();
    }

    public static void k(String str, String str2, String str3, String str4, String str5, String str6, String str7, Map<Integer, String> map) {
        if (QLog.isColorLevel()) {
            QLog.i("QQGamePub_GameCenterUtils", 2, "reportDC00087New: operId=" + str + ",adId= " + str7 + ",extsMap=" + map);
        }
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule(str5).setOperId(str).setExt(1, str6).setExt(4, str2).setExt(11, str3).setExt(12, str4).setExt(41, str7);
        if (map != null && map.keySet().size() > 0) {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                wadlReportBuilder.setExt(entry.getKey().intValue(), entry.getValue());
            }
        }
        wadlReportBuilder.report();
    }

    public static void l(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, String str6, Map<Integer, String> map) {
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule(str).setOperId(str2).setGameAppId(str3).setExt(1, str4).setExt(11, str5).setExt(12, str6);
        if (map != null && map.keySet().size() > 0) {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                wadlReportBuilder.setExt(entry.getKey().intValue(), entry.getValue());
            }
        }
        wadlReportBuilder.report();
    }
}
