package com.tencent.qqmini.minigame.manager;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqmini.minigame.action.OperateFloatDragAd;
import com.tencent.qqmini.minigame.ui.MiniGameAdBannerPopup;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.FloatDragAdInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class FloatDragAdDataManager {
    private static final int AD_COUNT = 1;
    private static final String AD_JUMP_URL = "url";
    private static final String AD_PICTURE_URL = "pic";
    private static final int AD_POS_ID = 473;
    private static final String AD_SEXT1 = "sext1";
    private static final String AD_SEXT2 = "sext2";
    private static final String AD_SEXT3 = "sext3";
    private static final String AD_TAN_CHUANG = "tanchuang";
    private static final String AD_TYPE = "type";
    public static final String TAG = "FloatDragAdDataManager";
    private static boolean adBannerPopupHasShowed = false;
    private static String floatDragTanChuangId = "";
    private static boolean isFloatDragShow = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class a implements AsyncResult {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f346510a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f346511b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IMiniAppContext f346512c;

        a(String str, int i3, IMiniAppContext iMiniAppContext) {
            this.f346510a = str;
            this.f346511b = i3;
            this.f346512c = iMiniAppContext;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public void onReceiveResult(boolean z16, JSONObject jSONObject) {
            FloatDragAdInfo floatDragAdInfo;
            if (z16) {
                floatDragAdInfo = FloatDragAdDataManager.handleTianShuResponse(this.f346510a, this.f346511b, jSONObject);
            } else {
                QMLog.e(FloatDragAdDataManager.TAG, "TianShuResponse response fail");
                floatDragAdInfo = null;
            }
            if (floatDragAdInfo != null) {
                if (!TextUtils.isEmpty(floatDragAdInfo.getTanChuang())) {
                    String unused = FloatDragAdDataManager.floatDragTanChuangId = floatDragAdInfo.getTanChuang();
                }
                OperateFloatDragAd.obtain(this.f346512c).show(floatDragAdInfo);
                return;
            }
            OperateFloatDragAd.obtain(this.f346512c).remove();
        }
    }

    private static void checkFloatDragConnectAdBannerPopup(final Context context, final IMiniAppContext iMiniAppContext, final String str, final int i3) {
        MiniGameAdBannerPopup.reqAdItemAdIds(context, str, i3, new AsyncResult() { // from class: com.tencent.qqmini.minigame.manager.FloatDragAdDataManager.2
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                int i16;
                TianShuAccess.RspEntry rspEntry;
                TianShuAccess.AdItem adItem;
                ArrayList arrayList = new ArrayList();
                if (!z16) {
                    return;
                }
                try {
                    TianShuAccess.GetAdsRsp getAdsRsp = (TianShuAccess.GetAdsRsp) jSONObject.get("response");
                    QMLog.d(FloatDragAdDataManager.TAG, "onGetAdvs() called with: result = [" + jSONObject + "], getAdsRsp = [" + getAdsRsp + "]");
                    if (context != null && getAdsRsp != null) {
                        for (int i17 = 0; i17 < getAdsRsp.mapAds.size() && (rspEntry = getAdsRsp.mapAds.get(i17)) != null; i17++) {
                            TianShuAccess.AdPlacementInfo adPlacementInfo = rspEntry.value;
                            if (adPlacementInfo != null && !adPlacementInfo.lst.isEmpty() && (adItem = rspEntry.value.lst.get(0)) != null) {
                                arrayList.add(String.valueOf(adItem.iAdId.get()));
                            }
                        }
                    }
                } catch (Exception e16) {
                    QMLog.e(FloatDragAdDataManager.TAG, "tianshuRequestAdv onReceiveResult", e16);
                }
                if (!TextUtils.isEmpty(FloatDragAdDataManager.floatDragTanChuangId)) {
                    i16 = arrayList.indexOf(FloatDragAdDataManager.floatDragTanChuangId);
                } else {
                    i16 = 0;
                }
                if (i16 >= 0) {
                    MiniGameAdBannerPopup.checkShouldShow(context, str, i3, i16);
                } else {
                    MiniGameAdBannerPopup.checkShouldShow(context, str, i3, 0);
                    OperateFloatDragAd.obtain(iMiniAppContext).remove();
                }
            }
        });
    }

    private static FloatDragAdInfo getFloatDragAdInfo(String str, int i3, TianShuAccess.AdItem adItem) {
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        for (TianShuAccess.MapEntry mapEntry : adItem.argList.get()) {
            if ("type".equals(mapEntry.key.get())) {
                str2 = mapEntry.value.get();
            } else if ("url".equals(mapEntry.key.get())) {
                str3 = mapEntry.value.get();
            } else if ("pic".equals(mapEntry.key.get())) {
                str4 = mapEntry.value.get();
            } else if (AD_TAN_CHUANG.equals(mapEntry.key.get())) {
                str5 = mapEntry.value.get();
            } else if (AD_SEXT1.equals(mapEntry.key.get())) {
                str6 = mapEntry.value.get();
            } else if (AD_SEXT2.equals(mapEntry.key.get())) {
                str7 = mapEntry.value.get();
            } else if (AD_SEXT3.equals(mapEntry.key.get())) {
                str8 = mapEntry.value.get();
            }
        }
        QMLog.i(TAG, "handleTianShuResponse type:" + str2 + ", jumpUrl:" + str3 + ", pictureUrl:" + str4 + ", tanChuang:" + str5);
        return new FloatDragAdInfo.Builder().adItem(adItem).type(str2).pictureUrl(str4).jumpUrl(str3).appId(str).scene(i3).tanChuang(str5).sext1(str6).sext2(str7).sext3(str8).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FloatDragAdInfo handleTianShuResponse(String str, int i3, JSONObject jSONObject) {
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField;
        PBRepeatMessageField<TianShuAccess.MapEntry> pBRepeatMessageField2;
        try {
            TianShuAccess.GetAdsRsp getAdsRsp = (TianShuAccess.GetAdsRsp) jSONObject.get("response");
            if (getAdsRsp != null && !getAdsRsp.mapAds.isEmpty()) {
                TianShuAccess.RspEntry rspEntry = getAdsRsp.mapAds.get(0);
                if (rspEntry != null && (adPlacementInfo = rspEntry.value) != null && (pBRepeatMessageField = adPlacementInfo.lst) != null && !pBRepeatMessageField.isEmpty()) {
                    TianShuAccess.AdItem adItem = rspEntry.value.lst.get(0);
                    if (adItem != null && (pBRepeatMessageField2 = adItem.argList) != null && !pBRepeatMessageField2.isEmpty()) {
                        return getFloatDragAdInfo(str, i3, adItem);
                    }
                    QMLog.e(TAG, "handleTianShuResponse adItem is empty");
                    return null;
                }
                QMLog.e(TAG, "handleTianShuResponse rspEntry is empty");
                return null;
            }
            QMLog.e(TAG, "handleTianShuResponse mapAds is empty");
            return null;
        } catch (JSONException e16) {
            QMLog.e(TAG, "parse Ad Data Exception ", e16);
            return null;
        }
    }

    public static void requestAd(final Activity activity, final IMiniAppContext iMiniAppContext, final String str, final int i3) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.FloatDragAdDataManager.1
            @Override // java.lang.Runnable
            public void run() {
                FloatDragAdDataManager.requestAdRun(activity, iMiniAppContext, str, i3);
            }
        });
    }

    public static void requestAdRun(Activity activity, IMiniAppContext iMiniAppContext, String str, int i3) {
        requestTianShu(activity, iMiniAppContext, str, i3);
        if (adBannerPopupHasShowed) {
            return;
        }
        checkFloatDragConnectAdBannerPopup(activity, iMiniAppContext, str, i3);
        adBannerPopupHasShowed = true;
    }

    private static void requestTianShu(Context context, IMiniAppContext iMiniAppContext, String str, int i3) {
        if (str == null) {
            return;
        }
        QMLog.i(TAG, "requestTianShu with appId=" + str + " scene=" + i3);
        if (!((ChannelProxy) ProxyManager.get(ChannelProxy.class)).tianshuRequestAdv(context, str, i3, 473, 1, new a(str, i3, iMiniAppContext))) {
            QMLog.e(TAG, "requestTianShu isImpl=false");
        }
    }
}
