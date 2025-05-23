package com.tencent.qqmini.minigame.plugins;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqmini.minigame.model.BlockAdInfo;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.AdUtil;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class BlockAdPlugin extends BaseJsPlugin {
    private static final HashMap<Integer, String> AD_ERROR_MSG = MiniSDKConst.AdConst.CODE_MSG_MAP;
    public static final String API_AD_CREATE_BLOCK_AD = "createBlockAd";
    public static final String API_AD_OPERATE_BLOCK_AD = "operateBlockAd";
    public static final String API_AD_UPDATE_BLOCK_AD = "updateBlockAdSize";
    public static final String EVENT_BLOCK_AD_SHOW_DONE = "onBlockAdShowDone";
    public static final String EVENT_BLOCK_AD_STATE_CHANGE = "onBlockAdStateChange";
    private static final String ORIENTATION_LANDSCAPE = "landscape";
    private static final String ORIENTATION_VERTICAL = "vertical";
    private static final String TAG = "BlockAdPlugin";
    private HashMap<Integer, AdProxy.AbsBlockAdView> mBlockAdViewMap = new HashMap<>();
    private HashMap<Integer, BlockAdInfo> mBlockAdInfoMap = new HashMap<>();
    private float mGameDensity = -1.0f;

    /* JADX INFO: Access modifiers changed from: private */
    public void blockErrorStateCallbackDelay(final RequestEvent requestEvent, final int i3, final String str, final int i16, int i17) {
        AppBrandTask.runTaskOnUiThreadDelay(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.BlockAdPlugin.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("state", "error");
                    jSONObject.put("compId", i16);
                    jSONObject.put("errMsg", str);
                    jSONObject.put("errCode", i3);
                    BlockAdPlugin.this.informJs(requestEvent, jSONObject, BlockAdPlugin.EVENT_BLOCK_AD_STATE_CHANGE);
                } catch (JSONException e16) {
                    QMLog.e(BlockAdPlugin.TAG, "bannerErrorStateCallback error", e16);
                }
            }
        }, i17);
    }

    private void callbackUpdateSuccess(final RequestEvent requestEvent, final int i3, final BlockAdInfo blockAdInfo) {
        AppBrandTask.runTaskOnUiThreadDelay(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.BlockAdPlugin.6
            @Override // java.lang.Runnable
            public void run() {
                if (BlockAdPlugin.this.updateBlockAd(i3)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("state", "resize");
                        jSONObject.put("compId", blockAdInfo.getCompId());
                        jSONObject.put("width", blockAdInfo.getRealWidth());
                        jSONObject.put("height", blockAdInfo.getRealHeight());
                        BlockAdPlugin.this.informJs(requestEvent, jSONObject, BlockAdPlugin.EVENT_BLOCK_AD_STATE_CHANGE);
                    } catch (JSONException e16) {
                        QMLog.e(BlockAdPlugin.TAG, "updateBannerAd informJs error", e16);
                    }
                }
            }
        }, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAdBlockView(final BlockAdInfo blockAdInfo, String str, final RequestEvent requestEvent, Bundle bundle) {
        if (((AdProxy) ProxyManager.get(AdProxy.class)) != null && blockAdInfo != null) {
            AdProxy.AbsBlockAdView createBlockAdView = ((AdProxy) ProxyManager.get(AdProxy.class)).createBlockAdView(this.mMiniAppContext.getAttachActivity(), str, blockAdInfo.getAdUnitId(), blockAdInfo.getLeft(), blockAdInfo.getTop(), blockAdInfo.getSize(), blockAdInfo.getOri(), blockAdInfo.getCompId(), new AdProxy.IBlockAdListener() { // from class: com.tencent.qqmini.minigame.plugins.BlockAdPlugin.2
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBlockAdListener
                public void onADClicked() {
                    QMLog.i(BlockAdPlugin.TAG, "onADClicked");
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBlockAdListener
                public void onADClosed() {
                    QMLog.i(BlockAdPlugin.TAG, "onADClosed");
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBlockAdListener
                public void onADExposure() {
                    QMLog.i(BlockAdPlugin.TAG, "onADExposure");
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBlockAdListener
                public void onADReceive(int i3, int i16, int i17) {
                    QMLog.i(BlockAdPlugin.TAG, "onADReceive");
                    BlockAdInfo blockAdInfo2 = blockAdInfo;
                    if (blockAdInfo2 == null) {
                        return;
                    }
                    blockAdInfo2.setRealWidth(i16);
                    blockAdInfo.setRealHeight(i17);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("state", "load");
                        jSONObject.put("adUnitId", blockAdInfo.getAdUnitId());
                        jSONObject.put("compId", blockAdInfo.getCompId());
                        jSONObject.put("realAdNum", i3);
                        jSONObject.put("realWidth", blockAdInfo.getRealWidth());
                        jSONObject.put("realHeight", blockAdInfo.getRealHeight());
                        BlockAdPlugin.this.informJs(requestEvent, jSONObject, BlockAdPlugin.EVENT_BLOCK_AD_STATE_CHANGE);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("state", "resize");
                        jSONObject2.put("compId", blockAdInfo.getCompId());
                        jSONObject2.put("width", i16);
                        jSONObject2.put("height", i17);
                        BlockAdPlugin.this.informJs(requestEvent, jSONObject2, BlockAdPlugin.EVENT_BLOCK_AD_STATE_CHANGE);
                    } catch (JSONException e16) {
                        QMLog.e(BlockAdPlugin.TAG, "informJs success", e16);
                    }
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBlockAdListener
                public void onNoAD(int i3, String str2) {
                    QMLog.i(BlockAdPlugin.TAG, "onNoAD, errCode = " + i3 + ", errMsg = " + str2);
                    BlockAdPlugin.this.blockErrorStateCallbackDelay(requestEvent, i3, str2, blockAdInfo.getCompId(), 0);
                }
            }, bundle);
            if (createBlockAdView != null) {
                try {
                    createBlockAdView.loadAD();
                    this.mBlockAdViewMap.put(Integer.valueOf(blockAdInfo.getCompId()), createBlockAdView);
                    this.mBlockAdInfoMap.put(Integer.valueOf(blockAdInfo.getCompId()), blockAdInfo);
                    return;
                } catch (Throwable th5) {
                    QMLog.i(TAG, "loadAd error", th5);
                    return;
                }
            }
            return;
        }
        QMLog.i(TAG, "start create, null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void destroyBlockAd(int i3) {
        HashMap<Integer, AdProxy.AbsBlockAdView> hashMap = this.mBlockAdViewMap;
        if (hashMap != null && hashMap.get(Integer.valueOf(i3)) != null && this.mBlockAdViewMap.get(Integer.valueOf(i3)).getView() != null) {
            HashMap<Integer, BlockAdInfo> hashMap2 = this.mBlockAdInfoMap;
            if (hashMap2 != null && hashMap2.get(Integer.valueOf(i3)) != null) {
                if (this.mMiniAppContext.getAttachActivity() != null && this.mMiniAppContext.getAttachActivity().getWindow() != null) {
                    AdProxy.AbsBlockAdView absBlockAdView = this.mBlockAdViewMap.get(Integer.valueOf(i3));
                    ViewGroup viewGroup = (ViewGroup) this.mMiniAppContext.getAttachActivity().getWindow().getDecorView();
                    if (viewGroup == null) {
                        QMLog.e(TAG, "showBlockAd, root view is null");
                        return;
                    }
                    viewGroup.removeView(absBlockAdView.getView());
                    this.mBlockAdInfoMap.remove(Integer.valueOf(i3));
                    this.mBlockAdViewMap.remove(Integer.valueOf(i3));
                    absBlockAdView.clearBlockAdAnimation(absBlockAdView);
                    return;
                }
                QMLog.e(TAG, "showBlockAd, activity or window is null");
                return;
            }
            QMLog.e(TAG, "showBannerAd error, data is null");
            return;
        }
        QMLog.e(TAG, "showBannerAd error, view is null");
    }

    private int gameDpTopx(float f16) {
        return Math.round(f16 * this.mGameDensity);
    }

    private boolean handleBlockAdType(int i3, int i16, BlockAdInfo blockAdInfo, boolean z16) {
        if (i3 != 1) {
            if (i3 == 2) {
                if (blockAdInfo.getTop() != i16) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    blockAdInfo.setTop(i16);
                }
            }
        } else {
            if (blockAdInfo.getLeft() != i16) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                blockAdInfo.setLeft(i16);
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void informJs(RequestEvent requestEvent, JSONObject jSONObject, String str) {
        requestEvent.jsService.evaluateSubscribeJS(str, jSONObject.toString(), 0);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:5|(8:6|7|9|10|12|13|15|16)|(1:18)(2:34|(1:36)(5:37|20|21|22|(1:30)(2:28|29)))|19|20|21|22|(0)|30) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0063, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0099 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private BlockAdInfo parseBlockAdInfoFromJson(String str) {
        int i3;
        int i16;
        int i17;
        int i18;
        String str2;
        JSONObject jSONObject;
        String optString;
        int i19;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str3 = "";
        int i26 = -1;
        try {
            jSONObject = new JSONObject(str);
            str3 = jSONObject.getString("adUnitId");
            i16 = jSONObject.getJSONObject("style").getInt("left");
            try {
                i3 = jSONObject.getJSONObject("style").getInt("top");
                try {
                    i17 = jSONObject.optInt("size", 1);
                    try {
                        optString = jSONObject.optString("orientation", "landscape");
                    } catch (Exception e16) {
                        e = e16;
                        i18 = -1;
                    }
                } catch (Exception e17) {
                    e = e17;
                    i17 = -1;
                    i18 = i17;
                    QMLog.i(TAG, "parseBannerAdPosInfoFromJson error " + str, e);
                    int i27 = i3;
                    str2 = str3;
                    int i28 = i26;
                    int i29 = i16;
                    int i36 = i17;
                    int i37 = i18;
                    if (!TextUtils.isEmpty(str2)) {
                    }
                    return null;
                }
            } catch (Exception e18) {
                e = e18;
                i3 = -1;
                i17 = -1;
            }
        } catch (Exception e19) {
            e = e19;
            i3 = -1;
            i16 = -1;
            i17 = -1;
        }
        if ("landscape".equals(optString)) {
            i19 = 90;
        } else if ("vertical".equals(optString)) {
            i19 = 0;
        } else {
            i18 = -1;
            i26 = jSONObject.getInt("compId");
            int i272 = i3;
            str2 = str3;
            int i282 = i26;
            int i292 = i16;
            int i362 = i17;
            int i372 = i18;
            if (!TextUtils.isEmpty(str2) || i292 < 0 || i272 < 0 || i282 < 0 || i372 < 0) {
                return null;
            }
            return new BlockAdInfo(str2, i292, i272, i362, i372, i282);
        }
        i18 = i19;
        i26 = jSONObject.getInt("compId");
        int i2722 = i3;
        str2 = str3;
        int i2822 = i26;
        int i2922 = i16;
        int i3622 = i17;
        int i3722 = i18;
        if (!TextUtils.isEmpty(str2)) {
        }
        return null;
    }

    private void reportBlockAd(final String str) {
        QMLog.i(TAG, "reportBlockAd reportUrl = " + str);
        if (!TextUtils.isEmpty(str) && URLUtil.isNetworkUrl(str)) {
            ThreadManager.executeOnNetworkIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.BlockAdPlugin.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(10000);
                        httpURLConnection.setReadTimeout(10000);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setInstanceFollowRedirects(true);
                        httpURLConnection.connect();
                        QMLog.i(BlockAdPlugin.TAG, "reportBlockAd rspCode" + httpURLConnection.getResponseCode());
                    } catch (Throwable th5) {
                        QMLog.i(BlockAdPlugin.TAG, "reportBlockAd error, url = " + str, th5);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean showBlockAd(int i3) {
        HashMap<Integer, AdProxy.AbsBlockAdView> hashMap = this.mBlockAdViewMap;
        if (hashMap != null && hashMap.get(Integer.valueOf(i3)) != null && this.mBlockAdViewMap.get(Integer.valueOf(i3)).getView() != null) {
            HashMap<Integer, BlockAdInfo> hashMap2 = this.mBlockAdInfoMap;
            if (hashMap2 != null && hashMap2.get(Integer.valueOf(i3)) != null) {
                AdProxy.AbsBlockAdView absBlockAdView = this.mBlockAdViewMap.get(Integer.valueOf(i3));
                BlockAdInfo blockAdInfo = this.mBlockAdInfoMap.get(Integer.valueOf(i3));
                View view = absBlockAdView.getView();
                if (view == null) {
                    return false;
                }
                view.setVisibility(0);
                if (view.getParent() != null) {
                    return true;
                }
                if (this.mMiniAppContext.getAttachActivity() == null) {
                    return false;
                }
                ViewGroup viewGroup = (ViewGroup) this.mMiniAppContext.getAttachActivity().getWindow().getDecorView();
                if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = gameDpTopx(blockAdInfo.getLeft());
                    layoutParams.topMargin = gameDpTopx(blockAdInfo.getTop());
                    viewGroup.addView(view, layoutParams);
                } else if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.leftMargin = gameDpTopx(blockAdInfo.getLeft());
                    layoutParams2.topMargin = gameDpTopx(blockAdInfo.getTop());
                    viewGroup.addView(view, layoutParams2);
                }
                absBlockAdView.showBlockAdAnimation(absBlockAdView);
                ArrayList<String> reportUrl = this.mBlockAdViewMap.get(Integer.valueOf(i3)).getReportUrl();
                if (reportUrl != null && reportUrl.size() > 0) {
                    Iterator<String> it = reportUrl.iterator();
                    while (it.hasNext()) {
                        reportBlockAd(it.next());
                    }
                }
                return true;
            }
            QMLog.e(TAG, "showBannerAd error, data is null");
            return false;
        }
        QMLog.e(TAG, "showBannerAd error, view is null");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean updateBlockAd(int i3) {
        HashMap<Integer, AdProxy.AbsBlockAdView> hashMap = this.mBlockAdViewMap;
        if (hashMap != null && hashMap.get(Integer.valueOf(i3)) != null && this.mBlockAdViewMap.get(Integer.valueOf(i3)).getView() != null) {
            HashMap<Integer, BlockAdInfo> hashMap2 = this.mBlockAdInfoMap;
            if (hashMap2 != null && hashMap2.get(Integer.valueOf(i3)) != null) {
                IMiniAppContext iMiniAppContext = this.mMiniAppContext;
                if (iMiniAppContext != null && iMiniAppContext.getAttachActivity() != null && this.mMiniAppContext.getAttachActivity().getWindow() != null) {
                    if (((ViewGroup) this.mMiniAppContext.getAttachActivity().getWindow().getDecorView()) == null) {
                        QMLog.e(TAG, "showBlockAd, root view is null");
                        return false;
                    }
                    BlockAdInfo blockAdInfo = this.mBlockAdInfoMap.get(Integer.valueOf(i3));
                    if (blockAdInfo == null) {
                        return false;
                    }
                    AdProxy.AbsBlockAdView absBlockAdView = this.mBlockAdViewMap.get(Integer.valueOf(i3));
                    View updateAdInfo = absBlockAdView.updateAdInfo(blockAdInfo.getLeft(), blockAdInfo.getTop());
                    if (updateAdInfo == null) {
                        return false;
                    }
                    absBlockAdView.showBlockAdAnimation(absBlockAdView);
                    if (updateAdInfo.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) updateAdInfo.getLayoutParams();
                        layoutParams.leftMargin = gameDpTopx(blockAdInfo.getLeft());
                        layoutParams.topMargin = gameDpTopx(blockAdInfo.getTop());
                        updateAdInfo.setLayoutParams(layoutParams);
                    } else if (updateAdInfo.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) updateAdInfo.getLayoutParams();
                        layoutParams2.leftMargin = gameDpTopx(blockAdInfo.getLeft());
                        layoutParams2.topMargin = gameDpTopx(blockAdInfo.getTop());
                        updateAdInfo.setLayoutParams(layoutParams2);
                    }
                    return true;
                }
                QMLog.e(TAG, "showBlockAd, activity or window is null");
                return false;
            }
            QMLog.e(TAG, "showBannerAd error, data is null");
            return false;
        }
        QMLog.e(TAG, "showBannerAd error, view is null");
        return false;
    }

    @JsEvent({API_AD_CREATE_BLOCK_AD})
    public String createBlockAd(final RequestEvent requestEvent) {
        int i3;
        String str;
        String str2;
        String str3;
        String str4;
        int i16;
        int i17;
        LaunchParam launchParam;
        QMLog.i(TAG, "receive createBlockAd event");
        if (requestEvent == null) {
            QMLog.i(TAG, "handle createBlockAd event, req == null");
            return "";
        }
        try {
            i3 = new JSONObject(requestEvent.jsonParams).getInt("compId");
        } catch (JSONException e16) {
            QMLog.i(TAG, "handle createBlockAd,", e16);
            i3 = -1;
        }
        int i18 = i3;
        final BlockAdInfo parseBlockAdInfoFromJson = parseBlockAdInfoFromJson(requestEvent.jsonParams);
        if (parseBlockAdInfoFromJson == null) {
            blockErrorStateCallbackDelay(requestEvent, 1001, AD_ERROR_MSG.get(1001), i18, 300);
            return "";
        }
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo == null || (launchParam = miniAppInfo.launchParam) == null) {
            str = "";
            str2 = str;
            str3 = str2;
        } else {
            str2 = launchParam.entryPath;
            if (str2 == null) {
                str2 = "";
            }
            if (launchParam == null) {
                str3 = "";
            } else {
                str3 = launchParam.reportData;
            }
            str = String.valueOf(launchParam.scene);
        }
        if (miniAppInfo == null || (str4 = miniAppInfo.via) == null) {
            str4 = "";
        }
        final String str5 = this.mApkgInfo.appId;
        Activity attachActivity = this.mMiniAppContext.getAttachActivity();
        if (attachActivity != null) {
            i16 = MiniAppEnv.g().getContext().getResources().getConfiguration().orientation;
            initActivitySize(attachActivity);
        } else {
            i16 = 1;
        }
        String account = LoginManager.getInstance().getAccount();
        String spAdGdtCookie = AdUtil.getSpAdGdtCookie(13);
        final Bundle bundle = new Bundle();
        bundle.putString(AdProxy.KEY_ACCOUNT, account);
        bundle.putInt(AdProxy.KEY_AD_TYPE, 13);
        String str6 = AdProxy.KEY_ORIENTATION;
        if (i16 == 2) {
            i17 = 90;
        } else {
            i17 = 0;
        }
        bundle.putInt(str6, i17);
        bundle.putString(AdProxy.KEY_GDT_COOKIE, spAdGdtCookie);
        bundle.putString(AdProxy.KEY_ENTRY_PATH, str2);
        bundle.putString(AdProxy.KEY_REPORT_DATA, str3);
        bundle.putString(AdProxy.KEY_REFER, str);
        bundle.putString(AdProxy.KEY_VIA, str4);
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.BlockAdPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                BlockAdPlugin.this.createAdBlockView(parseBlockAdInfoFromJson, str5, requestEvent, bundle);
            }
        });
        return "";
    }

    public synchronized boolean hideBlockAd(int i3) {
        HashMap<Integer, AdProxy.AbsBlockAdView> hashMap = this.mBlockAdViewMap;
        if (hashMap != null && hashMap.get(Integer.valueOf(i3)) != null && this.mBlockAdViewMap.get(Integer.valueOf(i3)).getView() != null) {
            HashMap<Integer, BlockAdInfo> hashMap2 = this.mBlockAdInfoMap;
            if (hashMap2 != null && hashMap2.get(Integer.valueOf(i3)) != null) {
                AdProxy.AbsBlockAdView absBlockAdView = this.mBlockAdViewMap.get(Integer.valueOf(i3));
                View view = absBlockAdView.getView();
                if (view == null) {
                    return false;
                }
                view.setVisibility(8);
                absBlockAdView.clearBlockAdAnimation(absBlockAdView);
                return true;
            }
            QMLog.e(TAG, "showBannerAd error, data is null");
            return false;
        }
        QMLog.e(TAG, "showBannerAd error, view is null");
        return false;
    }

    public void initActivitySize(Activity activity) {
        if (this.mGameDensity > 0.0f) {
            return;
        }
        activity.getResources().getDisplayMetrics();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        this.mGameDensity = displayMetrics.density;
        QMLog.i(TAG, "density = " + displayMetrics.density + ", ViewUtils.density = " + ViewUtils.getDensity());
        if (this.mGameDensity == -1.0f) {
            this.mGameDensity = ViewUtils.getDensity();
        }
    }

    @JsEvent({API_AD_OPERATE_BLOCK_AD})
    public String operateBlockAd(final RequestEvent requestEvent) {
        QMLog.i(TAG, "receive operateBlockAd event");
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String string = jSONObject.getString("type");
            final int i3 = jSONObject.getInt("compId");
            QMLog.i(TAG, "handle operateBlockAd type = " + string);
            if ("show".equals(string)) {
                AppBrandTask.runTaskOnUiThreadDelay(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.BlockAdPlugin.3
                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        boolean showBlockAd = BlockAdPlugin.this.showBlockAd(i3);
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("state", "show");
                            if (showBlockAd) {
                                str = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
                            } else {
                                str = "error";
                            }
                            jSONObject2.put("status", str);
                            jSONObject2.put("compId", i3);
                            BlockAdPlugin.this.informJs(requestEvent, jSONObject2, BlockAdPlugin.EVENT_BLOCK_AD_SHOW_DONE);
                        } catch (JSONException e16) {
                            BlockAdPlugin.this.blockErrorStateCallbackDelay(requestEvent, 1003, (String) BlockAdPlugin.AD_ERROR_MSG.get(1003), i3, 0);
                            QMLog.i(BlockAdPlugin.TAG, "handle operateBannerAd show error", e16);
                        }
                        QMLog.i(BlockAdPlugin.TAG, "showBlockAd " + showBlockAd);
                    }
                }, 300L);
            } else if ("hide".equals(string)) {
                AppBrandTask.runTaskOnUiThreadDelay(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.BlockAdPlugin.4
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean hideBlockAd = BlockAdPlugin.this.hideBlockAd(i3);
                        if (QMLog.isColorLevel()) {
                            QMLog.i(BlockAdPlugin.TAG, "hideBlockAd " + hideBlockAd);
                        }
                    }
                }, 300L);
            } else if ("destroy".equals(string)) {
                AppBrandTask.runTaskOnUiThreadDelay(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.BlockAdPlugin.5
                    @Override // java.lang.Runnable
                    public void run() {
                        BlockAdPlugin.this.destroyBlockAd(i3);
                    }
                }, 300L);
            } else {
                QMLog.i(TAG, "handle operateBlockAd not define type = " + string);
            }
            return "";
        } catch (JSONException e16) {
            QMLog.i(TAG, "handle operateBlockAd parse json error", e16);
            return "";
        }
    }

    @JsEvent({API_AD_UPDATE_BLOCK_AD})
    public String updateBlockAdSize(RequestEvent requestEvent) {
        int i3;
        int i16;
        BlockAdInfo blockAdInfo;
        QMLog.i(TAG, "receive updateBlockAdSize event");
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            int i17 = jSONObject.getInt("compId");
            if (jSONObject.has("left")) {
                i3 = jSONObject.getInt("left");
                i16 = 1;
            } else if (jSONObject.has("top")) {
                i3 = jSONObject.getInt("top");
                i16 = 2;
            } else {
                i3 = -1;
                i16 = -1;
            }
            if (i16 != -1 && (blockAdInfo = this.mBlockAdInfoMap.get(Integer.valueOf(i17))) != null) {
                if (!handleBlockAdType(i16, i3, blockAdInfo, true)) {
                    QMLog.e(TAG, "updateBlockAd no need to resize");
                    return "";
                }
                callbackUpdateSuccess(requestEvent, i17, blockAdInfo);
            }
        } catch (JSONException e16) {
            QMLog.i(TAG, "handle updateBlockAdSize parse json error", e16);
        }
        return "";
    }
}
