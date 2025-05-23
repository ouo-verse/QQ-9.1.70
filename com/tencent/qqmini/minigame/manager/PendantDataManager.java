package com.tencent.qqmini.minigame.manager;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqmini.minigame.action.OperatePendantAd;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.URLUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.vip.pb.TianShuAccess;
import java.lang.ref.WeakReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes23.dex */
public class PendantDataManager {
    private static final String ACTION_CLK = "clk";
    private static final String ACTION_EXPO = "expo";
    private static final String AD_ABS_TIME_PENDANT_REMOVE = "pendant_duration_hr";
    private static final String AD_ABS_TIME_PENDANT_SHOW = "absTime_pendant_show";
    private static final String AD_ABS_TIME_WEBVIEW = "absTime_webview_popup";
    private static final String AD_ACTIVE_ID = "active_id";
    private static final String AD_AUTO_WEBVIEW = "autoPopup_webview";
    private static final String AD_AUTO_WEBVIEW_DELAY = "autoWebviewDelay";
    private static final int AD_COUNT = 1;
    private static final String AD_JUMP_URL = "url";
    private static final String AD_MAX_CONSUMPTION = "max_consumption";
    private static final String AD_PENDANT_SHOW = "should_pendant_show";
    private static final String AD_PENDANT_URL = "pendant";
    private static final String AD_PICTURE_URL = "pic";
    private static final int AD_POS_ID = 637;
    private static final String AD_STATIC_PENDANT_URL = "staticPendant";
    private static final String AD_TYPE = "type";
    public static final int ENTRANCE_DISAPPEAR = 2;
    private static final String EVENT_NAME = "xiaoyouxi_red_rain_icon";
    public static final int FAILURE = 1;
    public static int RESULT = 0;
    public static final int SHOW_GIF_ANIMATION = 0;
    public static final int SHOW_STATIC = 1;
    private static String SP_NAME = "pendantDataManager";
    public static final int SUCCESS = 0;
    public static final String TAG = "PendantDataManager";
    public static boolean TIME_EXTENSION_ENABLE = false;
    public static int entranceStrategy;
    public static int numTianshuRequest;
    private static Map<String, String> param = new HashMap();

    private static void addMoreTimeForReward(int i3, IMiniAppContext iMiniAppContext, Date date, Date date2) {
        final WeakReference weakReference = new WeakReference(iMiniAppContext);
        Handler handler = PendantManager.REMOVE_HANDLER;
        handler.postDelayed(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.PendantDataManager.7
            @Override // java.lang.Runnable
            public void run() {
                if (PendantDataManager.entranceStrategy == 1 && PendantDataManager.TIME_EXTENSION_ENABLE) {
                    QMLog.d(PendantDataManager.TAG, "\u8fd8\u6709\u4e94\u5206\u949f\u6302\u4ef6\u6d88\u5931");
                    return;
                }
                QMLog.d(PendantDataManager.TAG, "\u6302\u4ef6\u8d85\u51fa\u6295\u653e\u65f6\u95f4\uff0c\u6302\u4ef6\u6d88\u5931");
                IMiniAppContext iMiniAppContext2 = (IMiniAppContext) weakReference.get();
                if (iMiniAppContext2 != null) {
                    OperatePendantAd.obtain(iMiniAppContext2).remove();
                }
            }
        }, date.getTime() - date2.getTime());
        handler.postDelayed(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.PendantDataManager.8
            @Override // java.lang.Runnable
            public void run() {
                QMLog.d(PendantDataManager.TAG, "\u6d88\u9664\u6302\u4ef6");
                IMiniAppContext iMiniAppContext2 = (IMiniAppContext) weakReference.get();
                if (iMiniAppContext2 != null) {
                    OperatePendantAd.obtain(iMiniAppContext2).remove();
                }
            }
        }, (date.getTime() - date2.getTime()) + MiniBoxNoticeInfo.MIN_5);
    }

    private static void delayForWebviewPopup(final PendantAdInfo pendantAdInfo, IMiniAppContext iMiniAppContext, int i3, final MiniAppProxy miniAppProxy, Context context) {
        long j3;
        final WeakReference weakReference = new WeakReference(iMiniAppContext);
        final WeakReference weakReference2 = new WeakReference(context);
        Handler handler = PendantManager.AUTO_WEBVIEW_DELAY_HANDLER;
        Runnable runnable = new Runnable() { // from class: com.tencent.qqmini.minigame.manager.PendantDataManager.5
            @Override // java.lang.Runnable
            public void run() {
                if (PendantAdInfo.this.isSchema()) {
                    String jumpUrl = PendantAdInfo.this.getJumpUrl();
                    Context context2 = (Context) weakReference2.get();
                    if (context2 != null) {
                        miniAppProxy.openSchema(context2, jumpUrl, 1037, null);
                        return;
                    }
                    return;
                }
                String jumpUrl2 = PendantAdInfo.this.getJumpUrl();
                PendantDataManager.reportExposure("3");
                IMiniAppContext iMiniAppContext2 = (IMiniAppContext) weakReference.get();
                Context context3 = (Context) weakReference2.get();
                if (iMiniAppContext2 != null && (context3 instanceof Activity)) {
                    PendantManager.startRedPacketBrowserActivity((Activity) context3, jumpUrl2, null, PendantAdInfo.this, iMiniAppContext2);
                }
            }
        };
        if (i3 > 0) {
            j3 = i3 * 1000;
        } else {
            j3 = 0;
        }
        handler.postDelayed(runnable, j3);
    }

    @NotNull
    private static AsyncResult getCallback(final Context context, IMiniAppContext iMiniAppContext, final String str, final int i3, final ChannelProxy channelProxy, final MiniAppProxy miniAppProxy) {
        final WeakReference weakReference = new WeakReference(iMiniAppContext);
        return new AsyncResult() { // from class: com.tencent.qqmini.minigame.manager.PendantDataManager.2
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                PendantAdInfo pendantAdInfo;
                if (z16) {
                    pendantAdInfo = PendantDataManager.handleTianShuResponse(str, i3, jSONObject);
                } else {
                    QMLog.e(PendantDataManager.TAG, "TianShuResponse response fail");
                    PendantDataManager.printErrCode(jSONObject);
                    pendantAdInfo = null;
                }
                PendantAdInfo pendantAdInfo2 = pendantAdInfo;
                IMiniAppContext iMiniAppContext2 = (IMiniAppContext) weakReference.get();
                if (iMiniAppContext2 == null) {
                    return;
                }
                if (PendantDataManager.isPendantConfigCorrect(pendantAdInfo2)) {
                    PendantDataManager.preloadDrawables(context, pendantAdInfo2);
                    PendantDataManager.wirteTianshuCache(pendantAdInfo2);
                    PendantDataManager.handleCorrectTianshuOperation(context, iMiniAppContext2, str, i3, channelProxy, miniAppProxy, pendantAdInfo2);
                } else {
                    if (PendantDataManager.requestTianshuCache(str, context, iMiniAppContext2, i3, channelProxy, miniAppProxy)) {
                        QMLog.i(PendantDataManager.TAG, "restoring pendantAd from disk");
                        return;
                    }
                    QMLog.d(PendantDataManager.TAG, "\u6ca1\u6709\u6302\u4ef6\u6d3b\u52a8(\u5305\u542b\u5929\u67a2\u914d\u7f6e\u51fa\u9519) \u6216\u8005 \u5df2\u7ecf\u9886\u5b8c\u5956\u52b1\uff0c\u7ea2\u5305\u6302\u4ef6\u6d88\u5931");
                    if (PendantDataManager.getSp().contains("curDay")) {
                        PendantDataManager.entranceStrategy = 2;
                        OperatePendantAd.obtain(iMiniAppContext2).remove();
                        PendantDataManager.getSp().edit().clear().commit();
                        return;
                    }
                    PendantDataManager.requestTianshuAgain(pendantAdInfo2, context, iMiniAppContext2, str, i3);
                }
            }
        };
    }

    public static SharedPreferences getSp() {
        return AppLoaderFactory.g().getContext().getSharedPreferences(SP_NAME, 0);
    }

    private static TianShuAccess.AdItem getTianshuItem(JSONObject jSONObject) {
        TianShuAccess.GetAdsRsp getAdsRsp;
        try {
            getAdsRsp = (TianShuAccess.GetAdsRsp) jSONObject.get("response");
        } catch (JSONException e16) {
            QMLog.e(TAG, "parse Ad Data Exception ", e16);
            getAdsRsp = null;
        }
        if (isAdResponseValid(getAdsRsp)) {
            QMLog.e(TAG, "handleTianShuResponse mapAds is empty");
            return null;
        }
        TianShuAccess.RspEntry rspEntry = getAdsRsp.mapAds.get(0);
        if (isRspEntryValid(rspEntry)) {
            QMLog.e(TAG, "handleTianShuResponse rspEntry is empty");
            return null;
        }
        TianShuAccess.AdItem adItem = rspEntry.value.lst.get(0);
        if (isAdItemValid(adItem)) {
            QMLog.e(TAG, "handleTianShuResponse adItem is empty");
            return null;
        }
        return adItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleCorrectTianshuOperation(Context context, IMiniAppContext iMiniAppContext, String str, int i3, ChannelProxy channelProxy, MiniAppProxy miniAppProxy, PendantAdInfo pendantAdInfo) {
        param.put("app_id", str);
        param.put(AD_ACTIVE_ID, getSp().getString("activeId", "0"));
        param.put("ext1", "2");
        param.put("ext2", getSp().getString("AdId", "0"));
        ArrayList<Date> handleTianshuDateParsing = handleTianshuDateParsing(new Date(channelProxy.getServerTime()), pendantAdInfo);
        if (handleTianshuDateParsing == null) {
            return;
        }
        Date date = handleTianshuDateParsing.get(0);
        Date date2 = handleTianshuDateParsing.get(1);
        Date date3 = handleTianshuDateParsing.get(2);
        Date date4 = handleTianshuDateParsing.get(3);
        pendantStateChange(pendantAdInfo, date, date2, date3, date4, iMiniAppContext, miniAppProxy, context, str, i3);
        addMoreTimeForReward(5, iMiniAppContext, date4, date);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PendantAdInfo handleTianShuResponse(String str, int i3, JSONObject jSONObject) {
        TianShuAccess.AdItem tianshuItem = getTianshuItem(jSONObject);
        if (tianshuItem == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", "");
        hashMap.put("url", "");
        hashMap.put("pic", "");
        hashMap.put("pendant", "");
        hashMap.put(AD_STATIC_PENDANT_URL, "");
        hashMap.put(AD_AUTO_WEBVIEW, "");
        hashMap.put(AD_ABS_TIME_WEBVIEW, "");
        hashMap.put(AD_AUTO_WEBVIEW_DELAY, "");
        hashMap.put(AD_PENDANT_SHOW, "");
        hashMap.put(AD_ABS_TIME_PENDANT_SHOW, "");
        hashMap.put(AD_ABS_TIME_PENDANT_REMOVE, "");
        hashMap.put(AD_MAX_CONSUMPTION, "");
        hashMap.put(AD_ACTIVE_ID, "");
        Iterator<TianShuAccess.MapEntry> it = tianshuItem.argList.get().iterator();
        while (it.hasNext()) {
            Iterator<TianShuAccess.MapEntry> it5 = it;
            TianShuAccess.MapEntry next = it.next();
            hashMap.put(next.key.get(), next.value.get());
            it = it5;
            tianshuItem = tianshuItem;
        }
        TianShuAccess.AdItem adItem = tianshuItem;
        String str2 = (String) hashMap.get("type");
        String str3 = (String) hashMap.get("pic");
        String str4 = (String) hashMap.get("pendant");
        String str5 = (String) hashMap.get(AD_STATIC_PENDANT_URL);
        String str6 = (String) hashMap.get(AD_AUTO_WEBVIEW);
        String str7 = (String) hashMap.get(AD_ABS_TIME_WEBVIEW);
        String str8 = (String) hashMap.get(AD_AUTO_WEBVIEW_DELAY);
        String str9 = (String) hashMap.get(AD_PENDANT_SHOW);
        String str10 = (String) hashMap.get(AD_ABS_TIME_PENDANT_SHOW);
        String str11 = (String) hashMap.get(AD_ABS_TIME_PENDANT_REMOVE);
        String str12 = (String) hashMap.get(AD_MAX_CONSUMPTION);
        String str13 = (String) hashMap.get(AD_ACTIVE_ID);
        String processUrlFromTianShu = processUrlFromTianShu((String) hashMap.get("url"), str, adItem);
        QMLog.i(TAG, "handleTianShuResponse type:" + str2 + ", jumpUrl:" + processUrlFromTianShu + ", pictureUrl:" + str3 + ", pendantUrl:" + str4 + ", staticPendantUrl:" + str5 + ", autoWebview:" + str6 + ", absTimeWebview:" + str7 + "autoWebviewDelay:" + str8 + ", shouldShowPendant:" + str9 + ", absTimeShowPendant:" + str10 + ", absTimeRemovePendant:" + str11 + ", numMaxConsumption:" + str12 + ", activeId:" + str13);
        return new PendantAdInfo.Builder().adItem(adItem).type(str2).pictureUrl(str3).pendantUrl(str4).staticPendantUrl(str5).jumpUrl(processUrlFromTianShu).appId(str).scene(i3).autoPopUpWebview(str6).popUpTime(str7).autoWebviewDelay(str8).showPendant(str9).absTimeShowPendant(str10).absTimeRemovePendant(str11).numMaxConsumption(str12).activeId(str13).build();
    }

    public static ArrayList<Date> handleTianshuDateParsing(Date date, PendantAdInfo pendantAdInfo) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR);
        try {
            Date parse = simpleDateFormat.parse(simpleDateFormat.format(date));
            Date parse2 = simpleDateFormat.parse(pendantAdInfo.getPopUpTime());
            Date parse3 = simpleDateFormat.parse(pendantAdInfo.getAbsTimeShowPendant());
            Date parse4 = simpleDateFormat.parse(pendantAdInfo.getAbsTimeRemovePendant());
            QMLog.d(TAG, "getPopUpTime:" + parse2 + ", getAbsTimeShowPendant:" + parse3 + ", getAbsTimeRemovePendant" + parse4 + ", curTime:" + parse);
            ArrayList<Date> arrayList = new ArrayList<>();
            arrayList.add(parse);
            arrayList.add(parse2);
            arrayList.add(parse3);
            arrayList.add(parse4);
            return arrayList;
        } catch (ParseException e16) {
            e16.printStackTrace();
            QMLog.e(TAG, "date parsing error");
            return null;
        }
    }

    private static boolean isAdItemValid(TianShuAccess.AdItem adItem) {
        PBRepeatMessageField<TianShuAccess.MapEntry> pBRepeatMessageField;
        if (adItem != null && (pBRepeatMessageField = adItem.argList) != null && !pBRepeatMessageField.isEmpty()) {
            return false;
        }
        return true;
    }

    private static boolean isAdResponseValid(TianShuAccess.GetAdsRsp getAdsRsp) {
        if (getAdsRsp != null && !getAdsRsp.mapAds.isEmpty()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isPendantConfigCorrect(PendantAdInfo pendantAdInfo) {
        if (pendantAdInfo != null && URLUtil.isValidUrl(pendantAdInfo.getPictureUrl()) && URLUtil.isValidUrl(pendantAdInfo.getPendantUrl()) && URLUtil.isValidUrl(pendantAdInfo.getJumpUrl()) && (!getSp().contains("appid") || getSp().getString("appid", "0").equals(pendantAdInfo.getAppId()))) {
            return true;
        }
        return false;
    }

    private static boolean isRspEntryValid(TianShuAccess.RspEntry rspEntry) {
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField;
        if (rspEntry != null && (adPlacementInfo = rspEntry.value) != null && (pBRepeatMessageField = adPlacementInfo.lst) != null && !pBRepeatMessageField.isEmpty()) {
            return false;
        }
        return true;
    }

    private static void pendantStateChange(PendantAdInfo pendantAdInfo, Date date, Date date2, Date date3, Date date4, IMiniAppContext iMiniAppContext, MiniAppProxy miniAppProxy, Context context, String str, int i3) {
        QMLog.d(TAG, "entranceStrategy=" + entranceStrategy);
        int i16 = entranceStrategy;
        if (i16 == 0) {
            if (shouldLaunchWebviewImmediately(pendantAdInfo, date, date2, date4)) {
                QMLog.d(TAG, "\u5df2\u5230\u6d3b\u52a8\u6295\u653e\u65f6\u95f4\uff0c \u76f4\u63a5\u6253\u5f00webview");
                entranceStrategy = 2;
                delayForWebviewPopup(pendantAdInfo, iMiniAppContext, Integer.parseInt(pendantAdInfo.getAutoWebviewDelay()), miniAppProxy, context);
                return;
            } else if (shouldWaitForPendantShowUp(pendantAdInfo, date, date3, date4)) {
                QMLog.d(TAG, "\u65f6\u95f4\u6ca1\u5230\u6d3b\u52a8\u65f6\u95f4\uff0c\u5012\u8ba1\u65f6\u7b49\u5f85\u7ea2\u5305\u6302\u4ef6\u51fa\u73b0");
                waitForPendantShowUp(pendantAdInfo, iMiniAppContext, date2, date);
                return;
            } else {
                QMLog.e(TAG, "\u5224\u5b9a\u62c9\u5230\u7684\u5929\u67a2\u8d85\u51fa\u6d3b\u52a8\u65f6\u95f4\uff0c\u5e94\u5f53\u6d88\u8017\u6389");
                performReport(pendantAdInfo.getAdItem(), pendantAdInfo.getType(), 101);
                getSp().edit().putString("numMaxConsumption", Integer.toString(Integer.parseInt(pendantAdInfo.getNumMaxConsumption()) - 1)).commit();
                requestAd((Activity) context, iMiniAppContext, str, i3);
                return;
            }
        }
        if (i16 == 1) {
            QMLog.d(TAG, "\u7ea2\u5305\u7ffb\u500d\uff0c\u9759\u6001\u7ea2\u5305\u6302\u4ef6\u51fa\u73b0");
            OperatePendantAd.obtain(iMiniAppContext).show(pendantAdInfo);
        } else if (i16 == 2) {
            QMLog.d(TAG, "\u7ea2\u5305\u6302\u4ef6\u6d88\u5931");
            OperatePendantAd.obtain(iMiniAppContext).remove();
        }
    }

    private static boolean performReport(final TianShuAccess.AdItem adItem, final String str, final int i3) {
        if (adItem == null) {
            return false;
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.PendantDataManager.4
            @Override // java.lang.Runnable
            public void run() {
                ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
                if (channelProxy != null) {
                    channelProxy.tianshuReport(TianShuAccess.AdItem.this, str, i3);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean preloadDrawables(Context context, PendantAdInfo pendantAdInfo) {
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        miniAppProxy.getDrawable(context, pendantAdInfo.getPictureUrl(), 0, 0, null);
        miniAppProxy.getDrawable(context, pendantAdInfo.getPendantUrl(), 0, 0, null);
        miniAppProxy.getDrawable(context, pendantAdInfo.getStaticPendantUrl(), 0, 0, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void printErrCode(JSONObject jSONObject) {
        try {
            TianShuAccess.GetAdsRsp getAdsRsp = (TianShuAccess.GetAdsRsp) jSONObject.get("response");
            QMLog.e(TAG, "err code: " + String.valueOf(getAdsRsp.code.get()) + ", err msg: " + String.valueOf(getAdsRsp.errmsg.get()));
        } catch (JSONException e16) {
            QMLog.e(TAG, "parse err code Exception ", e16);
        }
    }

    private static String processUrlFromTianShu(String str, String str2, TianShuAccess.AdItem adItem) {
        String str3;
        PBUInt32Field pBUInt32Field;
        QMLog.w(TAG, "url from tianshu : " + str);
        String str4 = "";
        if (str2 == null) {
            str2 = "";
        }
        if (adItem == null || (pBUInt32Field = adItem.iAdId) == null) {
            str3 = "";
        } else {
            str4 = String.valueOf(pBUInt32Field.get());
            str3 = String.valueOf(adItem.traceinfo);
            QMLog.d(TAG, "\u5e7f\u544aid:" + str4);
        }
        if (str != null) {
            String str5 = str + "&appid=" + str2 + "&item_id=" + str4 + "&trigger_info=" + str3;
            QMLog.w(TAG, "url with data : " + str5);
            return str5;
        }
        return str;
    }

    public static void reportClick(final String str) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.PendantDataManager.10
            @Override // java.lang.Runnable
            public void run() {
                PendantDataManager.param.put("ext3", str);
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).springHbReport(PendantDataManager.EVENT_NAME, 0, PendantDataManager.RESULT, PendantDataManager.param, PendantDataManager.ACTION_CLK);
            }
        });
    }

    public static void reportExposure(final String str) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.PendantDataManager.9
            @Override // java.lang.Runnable
            public void run() {
                PendantDataManager.param.put("ext3", str);
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).springHbReport(PendantDataManager.EVENT_NAME, 0, PendantDataManager.RESULT, PendantDataManager.param, "expo");
            }
        });
    }

    public static void requestAd(final Activity activity, IMiniAppContext iMiniAppContext, final String str, final int i3) {
        final WeakReference weakReference = new WeakReference(iMiniAppContext);
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.PendantDataManager.1
            @Override // java.lang.Runnable
            public void run() {
                IMiniAppContext iMiniAppContext2 = (IMiniAppContext) weakReference.get();
                if (iMiniAppContext2 != null) {
                    PendantDataManager.requestTianShu(activity, iMiniAppContext2, str, i3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void requestTianShu(Context context, IMiniAppContext iMiniAppContext, String str, int i3) {
        if (str == null) {
            return;
        }
        QMLog.i(TAG, "requestTianShu with appId=" + str + " scene=" + i3);
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (channelProxy != null && !channelProxy.tianshuRequestAdv(context, str, i3, 637, 1, getCallback(context, iMiniAppContext, str, i3, channelProxy, (MiniAppProxy) ProxyManager.get(MiniAppProxy.class)))) {
            QMLog.e(TAG, "requestTianShu isImpl=false");
        }
    }

    public static void requestTianshuAgain(PendantAdInfo pendantAdInfo, Context context, IMiniAppContext iMiniAppContext, final String str, final int i3) {
        if (pendantAdInfo == null && numTianshuRequest == 0) {
            QMLog.d(TAG, "\u91cd\u65b0\u62c9\u53d6\u5929\u67a2");
            numTianshuRequest++;
            final WeakReference weakReference = new WeakReference(context);
            final WeakReference weakReference2 = new WeakReference(iMiniAppContext);
            PendantManager.SHOW_HANDLER.postDelayed(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.PendantDataManager.3
                @Override // java.lang.Runnable
                public void run() {
                    QMLog.d(PendantDataManager.TAG, "\u5012\u8ba1\u65f6\u7ed3\u675f");
                    Context context2 = (Context) weakReference.get();
                    IMiniAppContext iMiniAppContext2 = (IMiniAppContext) weakReference2.get();
                    if (context2 != null && iMiniAppContext2 != null) {
                        PendantDataManager.requestTianShu(context2, iMiniAppContext2, str, i3);
                    }
                }
            }, 180000L);
        }
    }

    public static boolean requestTianshuCache(String str, Context context, IMiniAppContext iMiniAppContext, int i3, ChannelProxy channelProxy, MiniAppProxy miniAppProxy) {
        String format = new SimpleDateFormat("yyyy_MM_dd").format(new Date(System.currentTimeMillis()));
        if (!getSp().contains("curDay")) {
            QMLog.i(TAG, "no record from disk");
            return false;
        }
        if (!getSp().getString("numMaxConsumption", "0").equals("0") && getSp().getString("curDay", "").equals(format)) {
            if (!getSp().getString("appid", "").equals(str)) {
                QMLog.i(TAG, "not in the same app");
                return false;
            }
            if (entranceStrategy == 2) {
                entranceStrategy = 0;
            }
            PendantAdInfo build = new PendantAdInfo.Builder().adItem(null).type(getSp().getString("type", "1")).pictureUrl(getSp().getString("pictureUrl", "")).pendantUrl(getSp().getString("pendantUrl", "")).staticPendantUrl(getSp().getString("staticPendantUrl", "")).jumpUrl(getSp().getString(WadlProxyConsts.KEY_JUMP_URL, "")).appId(getSp().getString("appid", "0")).scene(i3).autoPopUpWebview(getSp().getString("autoPopUpWebview", "1")).popUpTime(getSp().getString("popUpTime", "0")).autoWebviewDelay(getSp().getString(AD_AUTO_WEBVIEW_DELAY, "0")).showPendant(getSp().getString("showPendant", "1")).absTimeShowPendant(getSp().getString("absTimeShowPendant", "0")).absTimeRemovePendant(getSp().getString("absTimeRemovePendant", "0")).numMaxConsumption(getSp().getString("numMaxConsumption", "0")).activeId(getSp().getString("activeId", "0")).build();
            QMLog.i(TAG, "\u4ecesp\u4e2d\u6062\u590d\u5929\u67a2");
            QMLog.i(TAG, "jumpURL = " + build.getJumpUrl());
            handleCorrectTianshuOperation(context, iMiniAppContext, str, i3, channelProxy, miniAppProxy, build);
            return true;
        }
        QMLog.i(TAG, "outdated pendant ad, cleaning");
        return false;
    }

    private static boolean shouldLaunchWebviewImmediately(PendantAdInfo pendantAdInfo, Date date, Date date2, Date date3) {
        if (pendantAdInfo.shouldWebviewAutoPopup() && date.compareTo(date2) >= 0 && date.compareTo(date3) < 0) {
            return true;
        }
        return false;
    }

    private static boolean shouldWaitForPendantShowUp(PendantAdInfo pendantAdInfo, Date date, Date date2, Date date3) {
        if (pendantAdInfo.shouldPendantShow() && date.compareTo(date2) < 0 && date.compareTo(date3) < 0) {
            return true;
        }
        return false;
    }

    private static void waitForPendantShowUp(final PendantAdInfo pendantAdInfo, IMiniAppContext iMiniAppContext, Date date, Date date2) {
        final WeakReference weakReference = new WeakReference(iMiniAppContext);
        PendantManager.SHOW_HANDLER.postDelayed(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.PendantDataManager.6
            @Override // java.lang.Runnable
            public void run() {
                QMLog.d(PendantDataManager.TAG, "\u5012\u8ba1\u65f6\u7ed3\u675f");
                IMiniAppContext iMiniAppContext2 = (IMiniAppContext) weakReference.get();
                if (iMiniAppContext2 != null) {
                    OperatePendantAd.obtain(iMiniAppContext2).show(pendantAdInfo);
                }
            }
        }, date.getTime() - date2.getTime());
    }

    public static void wirteTianshuCache(PendantAdInfo pendantAdInfo) {
        String format = new SimpleDateFormat("yyyy_MM_dd").format(new Date(System.currentTimeMillis()));
        if (getSp().contains("curDay") && !getSp().getString("curDay", "").equals(format)) {
            getSp().edit().clear().putString("curDay", format).commit();
        } else if (!getSp().contains("curDay")) {
            QMLog.i(TAG, "creating a new record...");
            getSp().edit().putString("curDay", format).commit();
        } else if (Integer.parseInt(pendantAdInfo.getNumMaxConsumption()) > 0) {
            QMLog.i(TAG, "updating an existing record...");
        } else {
            getSp().edit().clear();
            return;
        }
        getSp().edit().putString("AdId", String.valueOf(pendantAdInfo.getAdItem().iAdId.get())).commit();
        getSp().edit().putString("type", pendantAdInfo.getType()).commit();
        getSp().edit().putString("pictureUrl", pendantAdInfo.getPictureUrl()).commit();
        getSp().edit().putString("pendantUrl", pendantAdInfo.getPendantUrl()).commit();
        getSp().edit().putString("staticPendantUrl", pendantAdInfo.getStaticPendantUrl()).commit();
        getSp().edit().putString(WadlProxyConsts.KEY_JUMP_URL, pendantAdInfo.getJumpUrl()).commit();
        getSp().edit().putString("appid", pendantAdInfo.getAppId()).commit();
        getSp().edit().putInt("scene", pendantAdInfo.getScene()).commit();
        getSp().edit().putString("autoPopUpWebview", pendantAdInfo.getAutoPopUpWebview()).commit();
        getSp().edit().putString("popUpTime", pendantAdInfo.getPopUpTime()).commit();
        getSp().edit().putString(AD_AUTO_WEBVIEW_DELAY, pendantAdInfo.getAutoWebviewDelay()).commit();
        getSp().edit().putString("showPendant", pendantAdInfo.getShowPendant()).commit();
        getSp().edit().putString("absTimeShowPendant", pendantAdInfo.getAbsTimeShowPendant()).commit();
        getSp().edit().putString("absTimeRemovePendant", pendantAdInfo.getAbsTimeRemovePendant()).commit();
        getSp().edit().putString("numMaxConsumption", pendantAdInfo.getNumMaxConsumption()).commit();
        getSp().edit().putString("activeId", pendantAdInfo.getActiveId()).commit();
    }
}
