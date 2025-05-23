package com.tencent.mobileqq.gamecenter.api.impl;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.heytap.databaseengine.utils.DateUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.minigame.leba.IMiniGameLebaController;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.vip.pb.TianShuAccess;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* loaded from: classes12.dex */
public class GameCenterRedPointConfigApiImpl implements IGameCenterRedPointConfigApi {
    public static final String ADS_TYPE_BANNER = "20";
    public static final String ADS_TYPE_DYNAMIC_IMG = "19";
    private static final short GAME_CENTER_RED_POINT_POS_ID = 66;
    private static final String GAME_RED_REPORT_AD_KEY = "red_report_key_";
    private static final int MIN_TIME_INTERVAL = 4000;
    private static final String PARAM_RED_POINT_JUMP = "directJump";
    private static final String PRE_KEY_ = "qqgame_red_point_key_";
    private static final int RED_INFO_TYPE_AD_TEXT = 28;
    private static final int RED_INFO_TYPE_BUTTON_TEXT = 34;
    private static final int RED_INFO_TYPE_CONTENT_TEXT = 4;
    private static final int RED_INFO_TYPE_FLIP_ICON_URL = 3;
    private static final int RED_INFO_TYPE_ICON_URL = 15;
    private static final String TAG = "SimpleDynamic.GameCenterRedPointConfigApiImpl";
    private static final int TYPE_BANNER_BUBBLE_RED = 15;
    private static final int TYPE_FLIP_ICON_RED1 = 0;
    private static final int TYPE_FLIP_ICON_RED2 = 3;
    private static final int TYPE_FLIP_ICON_RED3 = 28;
    private int mChildIndex;
    private WeakReference<ViewGroup> mContainer;
    private com.tencent.mobileqq.gamecenter.data.d mLastStyleInfo;
    private WeakReference<com.tencent.mobileqq.gamecenter.api.c> mPluginView;
    private com.tencent.mobileqq.gamecenter.ui.v mPromotionView;
    private com.tencent.mobileqq.gamecenter.data.d mStyleInfo;
    private long mLastStartTime = 0;
    private int mRedPointType = 0;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.DATE_FORMAT_8);
    private TianShuGetAdvCallback mAdvCallback = new a();

    /* loaded from: classes12.dex */
    class a implements TianShuGetAdvCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        public void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
            QLog.i(GameCenterRedPointConfigApiImpl.TAG, 1, "[onGetAdvs], result:" + z16);
            if (z16 && getAdsRsp != null) {
                GameCenterRedPointConfigApiImpl.this.handleGetAdvCallback(getAdsRsp);
            } else {
                QLog.i(GameCenterRedPointConfigApiImpl.TAG, 1, "param is error.");
            }
        }
    }

    private boolean checkDataValid(com.tencent.mobileqq.gamecenter.data.d dVar) {
        if (dVar == null) {
            return false;
        }
        int i3 = dVar.f211992a;
        if (i3 == 3) {
            if (TextUtils.isEmpty(dVar.f212001j) || TextUtils.isEmpty(dVar.f212002k) || TextUtils.isEmpty(dVar.f212003l)) {
                return false;
            }
            return true;
        }
        if (i3 != 4 || TextUtils.isEmpty(dVar.f212004m) || TextUtils.isEmpty(dVar.f212005n)) {
            return false;
        }
        return true;
    }

    private boolean checkIfReportSameDay(String str, String str2) {
        String uniqueAdKey = getUniqueAdKey(str, str2);
        long decodeLong = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeLong(uniqueAdKey, 0L);
        if (decodeLong > 0 && GameCenterUtil.isSameDay(decodeLong, NetConnInfoCenter.getServerTimeMillis(), TimeZone.getDefault())) {
            return true;
        }
        QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeLong(uniqueAdKey, NetConnInfoCenter.getServerTimeMillis());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.mobileqq.gamecenter.ui.v createPromotionView(int i3) {
        WeakReference<com.tencent.mobileqq.gamecenter.api.c> weakReference;
        WeakReference<ViewGroup> weakReference2 = this.mContainer;
        if (weakReference2 == null || (weakReference = this.mPluginView) == null) {
            return null;
        }
        if (1 == i3) {
            return new com.tencent.mobileqq.gamecenter.ui.m(this.mChildIndex, weakReference2.get(), this.mPluginView.get());
        }
        if (2 == i3) {
            return new com.tencent.mobileqq.gamecenter.ui.n(weakReference.get());
        }
        if (3 == i3) {
            return new com.tencent.mobileqq.gamecenter.ui.q(this.mChildIndex, weakReference2.get(), this.mPluginView.get());
        }
        if (4 != i3) {
            return null;
        }
        return new com.tencent.mobileqq.gamecenter.ui.n(weakReference.get());
    }

    private com.tencent.mobileqq.gamecenter.data.d createStyleInfo(TianShuAccess.AdItem adItem) {
        if (adItem == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (TianShuAccess.MapEntry mapEntry : adItem.argList.get()) {
            hashMap.put(mapEntry.key.get(), mapEntry.value.get());
        }
        com.tencent.mobileqq.gamecenter.data.d dVar = new com.tencent.mobileqq.gamecenter.data.d();
        String str = (String) hashMap.get("type");
        dVar.f211993b = str;
        dVar.f211994c = String.valueOf(adItem.iAdId.get());
        QLog.i(TAG, 1, "type:" + str);
        if ("20".equals(str)) {
            dVar.f211992a = 1;
            dVar.f211996e = (String) hashMap.get("buffer");
            dVar.f211998g = (String) hashMap.get("apngUrl");
            dVar.f211999h = (String) hashMap.get("arrowUrl");
        } else if ("19".equals(str)) {
            dVar.f211992a = 2;
            dVar.f211996e = (String) hashMap.get("pic");
        }
        dVar.f211997f = (String) hashMap.get("writing");
        QLog.i(TAG, 1, "type:" + str + ",pic:" + dVar.f211996e + ",wording:" + dVar.f211997f + ",apngUrl:" + dVar.f211998g + ",arrowUrl:" + dVar.f211999h);
        return dVar;
    }

    private void fetchPromotionInfo() {
        QLog.i(TAG, 1, "[fetchRedPointStyleInfo]");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.GameCenterRedPointConfigApiImpl.2
            @Override // java.lang.Runnable
            public void run() {
                ((ITianshuManager) QRoute.api(ITianshuManager.class)).requestAdv(GameCenterRedPointConfigApiImpl.this.getRequestList(), GameCenterRedPointConfigApiImpl.this.mAdvCallback);
            }
        }, 128, null, true);
    }

    private String getAdId(String str) {
        if (!StringUtil.isEmpty(str)) {
            try {
                return new JSONObject(str).optString("ad_id");
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "getAdId: " + th5);
            }
        }
        return "";
    }

    private List<TianShuAccess.AdItem> getAdItems(TianShuAccess.GetAdsRsp getAdsRsp) {
        List<TianShuAccess.RspEntry> list;
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField;
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
                    return list2;
                }
                QLog.i(TAG, 1, "no ads item~");
                addPromotionView();
                return null;
            }
            QLog.i(TAG, 1, "ads resp param is error.");
        }
        return null;
    }

    private String getAdTag(String str, String str2) {
        String str3 = "";
        if (!StringUtil.isEmpty(str)) {
            try {
                str3 = queryParams(URLDecoder.decode(new JSONObject(str).optJSONObject("msg").optJSONObject(str2).optString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK)).replace("\\u0026", ContainerUtils.FIELD_DELIMITER)).getString("ADTAG");
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "getAdTag adTag: " + str3);
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "getAdTag: " + th5);
            }
        }
        return str3;
    }

    public static Map<String, String> getArguments(String str) {
        String substring = str.substring(str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1);
        HashMap hashMap = new HashMap();
        try {
            for (String str2 : substring.split(ContainerUtils.FIELD_DELIMITER)) {
                String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split != null && split.length == 2) {
                    hashMap.put(split[0], URLDecoder.decode(split[1]));
                }
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    private String getFeedId(String str) {
        Bundle queryParams;
        if (StringUtil.isEmpty(str)) {
            return "";
        }
        try {
            String replace = URLDecoder.decode(new JSONObject(str).optString(QFSEdgeItem.KEY_EXTEND)).replace("\\u0026", ContainerUtils.FIELD_DELIMITER);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getFeedId extendStr: " + replace);
            }
            if (!replace.contains(ContainerUtils.FIELD_DELIMITER) || (queryParams = queryParams(replace)) == null) {
                return "";
            }
            return queryParams.getString("feedID");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getTianShuFootageID: " + th5);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getFid(String str, String str2, String str3) {
        String string;
        if (!StringUtil.isEmpty(str)) {
            try {
                string = queryParams(URLDecoder.decode(new JSONObject(str).optString(QFSEdgeItem.KEY_EXTEND), "UTF-8").replace("\\u0026", ContainerUtils.FIELD_DELIMITER)).getString(Utils.KEY_BUSINESS_ID, "");
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "getFid by extend: " + th5);
            }
            if (TextUtils.isEmpty(string)) {
                return string;
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    string = queryParams(URLDecoder.decode(new JSONObject(str2).optJSONObject("msg").optJSONObject(str3).optString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK)).replace("\\u0026", ContainerUtils.FIELD_DELIMITER)).getString(Utils.KEY_BUSINESS_ID, "");
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "getFid by buffer, fid: " + string);
                    }
                } catch (Throwable th6) {
                    QLog.e(TAG, 1, "getFid by buffer: " + th6);
                }
            }
            return string;
        }
        string = "";
        if (TextUtils.isEmpty(string)) {
        }
    }

    private String getRedPointId(String str, String str2) {
        return PRE_KEY_ + str + "_" + str2;
    }

    private int getRedPointType(boolean z16, int i3) {
        if (z16) {
            String valueOf = String.valueOf(this.mRedPointType);
            if ("20".equals(valueOf) || "19".equals(valueOf)) {
                return this.mRedPointType;
            }
        } else {
            String valueOf2 = String.valueOf(i3);
            if ("20".equals(valueOf2) || "19".equals(valueOf2)) {
                return 3;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<TianShuAdPosItemData> getRequestList() {
        ArrayList arrayList = new ArrayList();
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mNeedCnt = 1;
        tianShuAdPosItemData.mPosId = 66;
        arrayList.add(tianShuAdPosItemData);
        return arrayList;
    }

    private int getTianShuFootageID(String str) {
        if (StringUtil.isEmpty(str)) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getTianShuFootageID json: " + jSONObject.toString());
            }
            return jSONObject.optInt("tianshu_footageid");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getTianShuFootageID: " + th5);
            return 0;
        }
    }

    private String getUniqueAdKey(String str, String str2) {
        return GAME_RED_REPORT_AD_KEY + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin() + "_" + str + "_" + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGetAdvCallback(TianShuAccess.GetAdsRsp getAdsRsp) {
        try {
            List<TianShuAccess.AdItem> adItems = getAdItems(getAdsRsp);
            if (adItems == null) {
                return;
            }
            handleSingleAdItem(adItems.get(0));
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[handleGetAdvCallback], error happens! " + th5.getMessage());
        }
    }

    private void handleSingleAdItem(TianShuAccess.AdItem adItem) {
        try {
            QLog.i(TAG, 1, "[handleSingleAdItem]");
            this.mStyleInfo = createStyleInfo(adItem);
            addPromotionView();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5.getMessage());
        }
    }

    private boolean isJumpByRedPoint(String str) {
        try {
            return "1".equals(Uri.parse(str).getQueryParameter(PARAM_RED_POINT_JUMP));
        } catch (UnsupportedOperationException e16) {
            QLog.e(TAG, 1, "isJumpByRedPoint error:", e16);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportRedTouchArrivedInSubThread$0(BusinessInfoCheckUpdate.AppInfo appInfo) {
        String str;
        QLog.i(TAG, 2, "[reportRedTouchArrived]type:" + appInfo.type.get() + ",iNewFlag:" + appInfo.iNewFlag.get() + ",path:" + appInfo.path.get() + ",max:" + appInfo.exposure_max.get());
        List<String> list = appInfo.missions.get();
        if (list == null || list.size() <= 0) {
            str = "";
        } else {
            str = list.get(0);
        }
        String fid = getFid(appInfo.extend.get(), appInfo.buffer.get(), str);
        if (checkIfReportSameDay(str, fid)) {
            QLog.i(TAG, 1, "[reportRedTouchArrivedInSubThread] hashReportSameDay,adId:" + str);
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext8", getTianShuFootageID(appInfo.extend.get()) + "");
        hashMap.put("ext41", str);
        hashMap.put("ext49", getFeedId(appInfo.extend.get()));
        hashMap.put("ext50", fid);
        hashMap.put(WadlReportBuilder.TableElem.GAMECENTER_SRC, getAdTag(appInfo.buffer.get(), str));
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9390", "77002", "914233", "", hashMap);
    }

    private String parseLinkUrlFromRedPoint(BusinessInfoCheckUpdate.AppInfo appInfo) {
        JSONObject k3;
        if (appInfo != null && (k3 = com.tencent.mobileqq.gamecenter.utils.c.k(appInfo)) != null) {
            return k3.optString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
        }
        return null;
    }

    private static Bundle queryParams(String str) {
        String[] split;
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            String[] split2 = str.split("\\?");
            if (split2.length == 2) {
                split = split2[1].split(ContainerUtils.FIELD_DELIMITER);
            } else {
                split = str.split(ContainerUtils.FIELD_DELIMITER);
            }
            for (String str2 : split) {
                String[] split3 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split3.length == 2) {
                    try {
                        bundle.putString(split3[0], URLDecoder.decode(split3[1], "UTF-8"));
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, e16, new Object[0]);
                    }
                }
            }
        }
        return bundle;
    }

    private void removePromotionView() {
        try {
            com.tencent.mobileqq.gamecenter.ui.v vVar = this.mPromotionView;
            if (vVar != null) {
                vVar.a();
                this.mPromotionView = null;
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    private void reportRedTouchArrivedInSubThread(final BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo != null && appInfo.type.get() >= 0 && appInfo.iNewFlag.get() == 1 && appInfo.exposure_max.get() > 0) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.t
                @Override // java.lang.Runnable
                public final void run() {
                    GameCenterRedPointConfigApiImpl.this.lambda$reportRedTouchArrivedInSubThread$0(appInfo);
                }
            }, 128, null, false);
        }
    }

    public void addPromotionView() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.GameCenterRedPointConfigApiImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (GameCenterRedPointConfigApiImpl.this.mStyleInfo == null) {
                        QLog.w(GameCenterRedPointConfigApiImpl.TAG, 1, "[addPromotionView] params error, mStyleInfo is null");
                        return;
                    }
                    if (!TextUtils.isEmpty(GameCenterRedPointConfigApiImpl.this.mStyleInfo.f212006o) && GameCenterRedPointConfigApiImpl.this.mLastStyleInfo != null && GameCenterRedPointConfigApiImpl.this.mStyleInfo.f212006o.equals(GameCenterRedPointConfigApiImpl.this.mLastStyleInfo.f212006o)) {
                        return;
                    }
                    if (GameCenterRedPointConfigApiImpl.this.mPromotionView != null) {
                        GameCenterRedPointConfigApiImpl.this.mPromotionView.a();
                    }
                    GameCenterRedPointConfigApiImpl gameCenterRedPointConfigApiImpl = GameCenterRedPointConfigApiImpl.this;
                    gameCenterRedPointConfigApiImpl.mPromotionView = gameCenterRedPointConfigApiImpl.createPromotionView(gameCenterRedPointConfigApiImpl.mStyleInfo.f211992a);
                    QLog.w(GameCenterRedPointConfigApiImpl.TAG, 1, "[addPromotionView] mPromotionView=" + GameCenterRedPointConfigApiImpl.this.mPromotionView + ",mStyleInfo=" + GameCenterRedPointConfigApiImpl.this.mStyleInfo);
                    if (GameCenterRedPointConfigApiImpl.this.mPromotionView != null) {
                        GameCenterRedPointConfigApiImpl.this.mPromotionView.b(GameCenterRedPointConfigApiImpl.this.mStyleInfo);
                        GameCenterRedPointConfigApiImpl gameCenterRedPointConfigApiImpl2 = GameCenterRedPointConfigApiImpl.this;
                        gameCenterRedPointConfigApiImpl2.mLastStyleInfo = gameCenterRedPointConfigApiImpl2.mStyleInfo;
                    }
                } catch (Throwable th5) {
                    QLog.e(GameCenterRedPointConfigApiImpl.TAG, 1, th5, new Object[0]);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi
    public void addSepcialRedPointShowCnt() {
        String str = this.mStyleInfo.f212006o;
        String format = this.simpleDateFormat.format(new Date(NetConnInfoCenter.getServerTimeMillis()));
        QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").putString(str, format, 86400);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[addSepcialRedPointShowCnt] redId:" + str + ", currDate:" + format);
        }
    }

    public boolean canShowSpecialRedPoint(String str) {
        boolean z16 = true;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (serverTimeMillis - this.mLastStartTime < 4000) {
            return true;
        }
        String string = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").getString(str, "");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[canShowSpecialRedPoint] redId:" + str + ", lastShowDate:" + string);
        }
        if (!TextUtils.isEmpty(string)) {
            String format = this.simpleDateFormat.format(new Date(serverTimeMillis));
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[canShowSpecialRedPoint] redId:" + str + ", currDate:" + format);
            }
            if (string.equals(format)) {
                z16 = false;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[canShowSpecialRedPoint] redId:" + str + ", canShow:" + z16);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi
    public boolean jumpGameCenterByRedPoint(Context context, boolean z16) {
        if (!z16) {
            return false;
        }
        String parseLinkUrlFromRedPoint = parseLinkUrlFromRedPoint(com.tencent.mobileqq.gamecenter.utils.c.f(IGameCenterRedPointConfigApi.GAME_CENTER_RES_ID));
        if (TextUtils.isEmpty(parseLinkUrlFromRedPoint)) {
            return false;
        }
        if (com.tencent.mobileqq.gamecenter.utils.c.n(parseLinkUrlFromRedPoint)) {
            if (isJumpByRedPoint(parseLinkUrlFromRedPoint)) {
                com.tencent.mobileqq.gamecenter.utils.c.r(context, parseLinkUrlFromRedPoint);
                return true;
            }
        } else if (com.tencent.mobileqq.gamecenter.utils.c.m(parseLinkUrlFromRedPoint) && isJumpByRedPoint(URLDecoder.decode(parseLinkUrlFromRedPoint))) {
            com.tencent.mobileqq.gamecenter.utils.c.q(context, parseLinkUrlFromRedPoint);
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi
    public void onDestory() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onDestory.....");
        }
        removePromotionView();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi
    public void onItemClick(long j3) {
        if (!IGameCenterRedPointConfigApi.GAME_CENTER_RES_ID.equals(String.valueOf(j3))) {
            return;
        }
        removePromotionView();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi
    public void reportClickForCommonVersion(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16, int i3) {
        PBUInt32Field pBUInt32Field;
        PBUInt32Field pBUInt32Field2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (appInfo == null || (pBUInt32Field = appInfo.type) == null || pBUInt32Field.get() < 0 || (pBUInt32Field2 = appInfo.uiAppId) == null || !IGameCenterRedPointConfigApi.GAME_CENTER_RES_ID.equals(String.valueOf(pBUInt32Field2.get()))) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 1, "[reportExposureForCommonVersion], isTableModel:" + z16 + ",mode:" + i3 + ",type:" + appInfo.type.get());
        }
        PBRepeatField<String> pBRepeatField = appInfo.missions;
        if (pBRepeatField == null || pBRepeatField.get() == null || appInfo.missions.get().size() <= 0) {
            str = "";
        } else {
            str = appInfo.missions.get().get(0);
        }
        String str6 = "1";
        if (i3 == 0) {
            str2 = "0";
        } else if (i3 == 2) {
            str2 = "1";
        } else {
            str2 = "2";
        }
        int redPointType = getRedPointType(z16, appInfo.type.get());
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext2", str);
        hashMap.put("ext3", str2);
        hashMap.put("ext4", "20");
        hashMap.put("ext5", String.valueOf(redPointType));
        if (!z16) {
            str3 = "1";
        } else {
            str3 = "2";
        }
        hashMap.put("ext6", str3);
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", "978", "9067", "906702", "907310", "", hashMap);
        if (i3 == 0) {
            str4 = "1";
        } else if (i3 == 2) {
            str4 = "2";
        } else {
            str4 = "3";
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("ext3", str4);
        hashMap2.put("ext4", "20");
        if (!z16) {
            str5 = "1";
        } else {
            str5 = "2";
        }
        hashMap2.put("ext6", str5);
        if (!RedTouch.hasRedTouch(appInfo)) {
            str6 = "2";
        }
        hashMap2.put("ext7", str6);
        if (RedTouch.hasRedTouch(appInfo)) {
            hashMap2.put("ext8", getTianShuFootageID(appInfo.extend.get()) + "");
            hashMap2.put("ext49", getFeedId(appInfo.extend.get()));
        }
        hashMap2.put("ext41", str);
        hashMap2.put("ext50", getFid(appInfo.extend.get(), appInfo.buffer.get(), str));
        hashMap2.put(WadlReportBuilder.TableElem.GAMECENTER_SRC, getAdTag(appInfo.buffer.get(), str));
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9390", "77002", "914167", "", hashMap2);
        this.mRedPointType = 0;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi
    public void reportExposureForCommonVersion(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16, int i3) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (appInfo == null || appInfo.uiAppId == null || appInfo.type.get() < 0 || appInfo.type == null || !IGameCenterRedPointConfigApi.GAME_CENTER_RES_ID.equals(String.valueOf(appInfo.uiAppId.get()))) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 1, "[reportExposureForCommonVersion], isTableModel:" + z16 + ",mode:" + i3 + ",type:" + appInfo.type.get());
        }
        PBRepeatField<String> pBRepeatField = appInfo.missions;
        if (pBRepeatField == null || pBRepeatField.get() == null || appInfo.missions.get().size() <= 0) {
            str = "";
        } else {
            str = appInfo.missions.get().get(0);
        }
        String str6 = "1";
        if (i3 == 0) {
            str2 = "0";
        } else if (i3 == 2) {
            str2 = "1";
        } else {
            str2 = "2";
        }
        int redPointType = getRedPointType(z16, appInfo.type.get());
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext2", str);
        hashMap.put("ext3", str2);
        hashMap.put("ext4", "8");
        hashMap.put("ext5", String.valueOf(redPointType));
        if (!z16) {
            str3 = "1";
        } else {
            str3 = "2";
        }
        hashMap.put("ext6", str3);
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", "978", "9067", "906702", "907309", "", hashMap);
        if (i3 == 0) {
            str4 = "1";
        } else if (i3 == 2) {
            str4 = "2";
        } else {
            str4 = "3";
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("ext3", str4);
        hashMap2.put("ext4", "8");
        if (!z16) {
            str5 = "1";
        } else {
            str5 = "2";
        }
        hashMap2.put("ext6", str5);
        if (!RedTouch.hasRedTouch(appInfo)) {
            str6 = "2";
        }
        hashMap2.put("ext7", str6);
        if (RedTouch.hasRedTouch(appInfo)) {
            hashMap2.put("ext8", getTianShuFootageID(appInfo.extend.get()) + "");
            hashMap2.put("ext49", getFeedId(appInfo.extend.get()));
        }
        hashMap2.put("ext41", str);
        hashMap2.put("ext50", getFid(appInfo.extend.get(), appInfo.buffer.get(), str));
        hashMap2.put(WadlReportBuilder.TableElem.GAMECENTER_SRC, getAdTag(appInfo.buffer.get(), str));
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9390", "77002", "914166", "", hashMap2);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00b7 A[Catch: all -> 0x00df, TryCatch #0 {all -> 0x00df, blocks: (B:24:0x0006, B:26:0x000e, B:28:0x001a, B:4:0x0028, B:7:0x0042, B:10:0x004f, B:11:0x007e, B:12:0x00a4, B:14:0x00b7, B:15:0x00bd), top: B:23:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004d  */
    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void reportGameDynamicClick(BusinessInfoCheckUpdate.AppInfo appInfo, String str, boolean z16) {
        String str2;
        String str3;
        String str4;
        if (appInfo != null) {
            try {
                if (appInfo.missions.get() != null && appInfo.missions.get().size() > 0) {
                    str2 = appInfo.missions.get().get(0);
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("ext4", "20");
                    if (!z16) {
                        str3 = "1";
                    } else {
                        str3 = "2";
                    }
                    hashMap.put("ext7", str3);
                    hashMap.put("ext41", str2);
                    if (appInfo != null) {
                        if (z16) {
                            hashMap.put("ext8", getTianShuFootageID(appInfo.extend.get()) + "");
                            hashMap.put("ext49", getFeedId(appInfo.extend.get()));
                        }
                        hashMap.put("ext50", getFid(appInfo.extend.get(), appInfo.buffer.get(), str2));
                        hashMap.put(WadlReportBuilder.TableElem.GAMECENTER_SRC, getAdTag(appInfo.buffer.get(), str2));
                    }
                    str4 = getArguments(str).get("missions");
                    if (!TextUtils.isEmpty(str4)) {
                        hashMap.put("ext42", str4);
                    }
                    ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "4", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9067", "11904", "928844", "", hashMap);
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
                return;
            }
        }
        str2 = "";
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("ext4", "20");
        if (!z16) {
        }
        hashMap2.put("ext7", str3);
        hashMap2.put("ext41", str2);
        if (appInfo != null) {
        }
        str4 = getArguments(str).get("missions");
        if (!TextUtils.isEmpty(str4)) {
        }
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "4", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9067", "11904", "928844", "", hashMap2);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi
    public void reportRedTouchArrived() {
        reportRedTouchArrivedInSubThread(com.tencent.mobileqq.gamecenter.utils.c.f(IGameCenterRedPointConfigApi.GAME_CENTER_RES_ID));
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi
    public void setBannerContainer(int i3, ViewGroup viewGroup) {
        this.mChildIndex = i3;
        this.mContainer = new WeakReference<>(viewGroup);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi
    public void setGameViewContainer(com.tencent.mobileqq.gamecenter.api.c cVar) {
        this.mPluginView = new WeakReference<>(cVar);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi
    public void showOrHideBanner(String str, boolean z16, BusinessInfoCheckUpdate.AppInfo appInfo) {
        PBUInt32Field pBUInt32Field;
        PBRepeatMessageField<BusinessInfoCheckUpdate.RedTypeInfo> pBRepeatMessageField;
        if (IMiniGameLebaController.MINI_GAME_RES_ID.equals(str)) {
            try {
                ((IMiniGameLebaController) QRoute.api(IMiniGameLebaController.class)).showGridAnimation(z16, appInfo);
                return;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "showOrHideBanner showMiniGameGridAnimation exception:", e16);
                return;
            }
        }
        if (!IGameCenterRedPointConfigApi.GAME_CENTER_RES_ID.equals(str)) {
            return;
        }
        if (!z16) {
            removePromotionView();
            return;
        }
        if (appInfo != null && (pBUInt32Field = appInfo.type) != null) {
            int i3 = pBUInt32Field.get();
            String valueOf = String.valueOf(appInfo.type.get());
            if (!"20".equals(valueOf) && !"19".equals(valueOf)) {
                BusinessInfoCheckUpdate.RedDisplayInfo redDisplayInfo = appInfo.red_display_info;
                if (redDisplayInfo != null && redDisplayInfo.get() != null && (pBRepeatMessageField = appInfo.red_display_info.grid_red_info) != null && pBRepeatMessageField.get() != null) {
                    List<BusinessInfoCheckUpdate.RedTypeInfo> list = appInfo.red_display_info.grid_red_info.get();
                    if (list.size() > 0) {
                        this.mStyleInfo = new com.tencent.mobileqq.gamecenter.data.d();
                        String adId = getAdId(appInfo.buffer.get());
                        if (TextUtils.isEmpty(adId) && appInfo.missions.size() > 0) {
                            adId = appInfo.missions.get(0);
                        }
                        this.mStyleInfo.f212006o = getRedPointId(adId, getFid(appInfo.extend.get(), appInfo.buffer.get(), adId));
                        if (!canShowSpecialRedPoint(this.mStyleInfo.f212006o)) {
                            appInfo.type.set(0);
                            removePromotionView();
                            return;
                        }
                        if (i3 == 15) {
                            this.mStyleInfo.f211992a = 3;
                            for (BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo : list) {
                                if (redTypeInfo.red_type.get() == 15) {
                                    this.mStyleInfo.f212001j = redTypeInfo.red_content.get();
                                } else if (redTypeInfo.red_type.get() == 4) {
                                    this.mStyleInfo.f212002k = redTypeInfo.red_content.get();
                                } else if (redTypeInfo.red_type.get() == 34) {
                                    this.mStyleInfo.f212003l = redTypeInfo.red_content.get();
                                }
                            }
                        } else if (i3 == 0 || i3 == 3 || i3 == 28) {
                            this.mStyleInfo.f211992a = 4;
                            for (BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo2 : list) {
                                if (redTypeInfo2.red_type.get() == 3) {
                                    this.mStyleInfo.f212004m = redTypeInfo2.red_content.get();
                                } else if (redTypeInfo2.red_type.get() == 4 || redTypeInfo2.red_type.get() == 28) {
                                    this.mStyleInfo.f212005n = redTypeInfo2.red_content.get();
                                }
                            }
                        }
                        if (!checkDataValid(this.mStyleInfo)) {
                            QLog.w(TAG, 2, "[showOrHideBanner] data invalid, styleInfo: " + this.mStyleInfo);
                            return;
                        }
                        this.mLastStartTime = NetConnInfoCenter.getServerTimeMillis();
                        addPromotionView();
                        return;
                    }
                    return;
                }
                QLog.d(TAG, 1, "[showOrHideBanner] no grid red info, return");
                return;
            }
            fetchPromotionInfo();
            this.mRedPointType = i3;
            return;
        }
        QLog.i(TAG, 1, "[showOrHideBanner] appInfo or type is null, return");
    }
}
