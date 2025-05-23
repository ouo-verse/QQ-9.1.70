package com.tencent.mobileqq.qcircle.api.hybird;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.google.gson.reflect.TypeToken;
import com.qzone.album.protocol.QZoneOptAlbumRequest;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.aelight.camera.music.api.IAEMusicClipDialog;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.bean.QFSPushBoxBean;
import com.tencent.biz.qqcircle.beans.QCircleAlbumDetailBean;
import com.tencent.biz.qqcircle.events.QCircleAlbumEvent;
import com.tencent.biz.qqcircle.events.QFSClearDecorateRedPointEvent;
import com.tencent.biz.qqcircle.events.QFSGrowthCenterTaskOperationEvent;
import com.tencent.biz.qqcircle.events.QFSJsChangeHalfScreenState;
import com.tencent.biz.qqcircle.events.QFSJsGetCurrentHalfPannelStatusEvent;
import com.tencent.biz.qqcircle.events.QFSJsNeedCollapseEvent;
import com.tencent.biz.qqcircle.events.QFSJsSupportHalfToFullScreenEvent;
import com.tencent.biz.qqcircle.events.QFSRocketNumUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSUpdateClockStateEvent;
import com.tencent.biz.qqcircle.events.QFSUpdateSuspendBoxCountEvent;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSPersonalQrcodeChangeEvent;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.request.QFSOpenAllPushBoxRequest;
import com.tencent.biz.qqcircle.request.QFSOpenPushBoxRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil;
import com.tencent.mobileqq.qcircle.api.IQCircleIPCApi;
import com.tencent.mobileqq.qcircle.api.IQFSPushOpenBoxPopWindowApi;
import com.tencent.mobileqq.qcircle.api.IToastUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSRefreshTabEvent;
import com.tencent.mobileqq.qcircle.api.global.QFSPushOpenBoxInfo;
import com.tencent.mobileqq.qcircle.api.qqvideo.event.QCircleFeedJSPermissionChangeEvent;
import com.tencent.mobileqq.qcircle.api.requests.QCircleSetCircleSwitchRequest;
import com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI;
import com.tencent.mobileqq.wink.api.IQQWinkLaucher;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.event.WinkUpdatePublishDeclarationEvent;
import com.tencent.mobileqq.wink.model.DeclarationParams;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.report.capability.spatialaudio.TVKDeviceSpatialAudioCapabilityReportConstant;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.remote.ServiceConst;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StWebCommJsonRsp;
import feedcloud.FeedCloudMeta$PushBoxViewInfo;
import feedcloud.FeedCloudMeta$StPushList;
import feedcloud.FeedCloudWrite$PushBoxBasic;
import feedcloud.FeedCloudWrite$PushBoxBasicDrawInfo;
import feedcloud.FeedCloudWrite$PushBoxDrawAllRsp;
import feedcloud.FeedCloudWrite$PushBoxDrawRocketRsp;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCircleSwitch$SetCircleSwitchRsp;

/* loaded from: classes16.dex */
public class QCircleJsPlugin extends WebViewPlugin {
    private static final byte CODE_OPEN_COLLECTION_PICKER = 1;
    private static final int DEFAULT_MAX_LEN = 1280;
    private static final int DEFAULT_MIN_LEN = 1;
    private static final String KEY_BASE64 = "base64";
    private static final String KEY_CALLBACK = "callback";
    private static final String KEY_CMD_NAME = "cmd_name";
    private static final String KEY_INDEX = "index";
    private static final String KEY_REQ_PARAMS = "req_params";
    private static final String KEY_RET_CODE = "retCode";
    private static final String KEY_SCHEMA = "schema";
    private static final String KEY_TEXT = "text";
    public static final String PLUGIN_NAMESPACE = "qcircle";
    private static final String TAG = "QCircleJsPlugin";
    private static volatile QCircleJsPlugin sQCircleJsPlugin;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleSwitch$SetCircleSwitchRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f261678a;

        a(String str) {
            this.f261678a = str;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSwitch$SetCircleSwitchRsp qQCircleSwitch$SetCircleSwitchRsp) {
            if (z16 && j3 == 0) {
                uq3.c.h7("qqcircle", "qqcircle_push_rocket_game_enable", "1");
            }
            QCircleJsPlugin.this.handleEnableJoinPushBoxCallback(this.f261678a, z16, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$PushBoxDrawAllRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f261680a;

        b(String str) {
            this.f261680a = str;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$PushBoxDrawAllRsp feedCloudWrite$PushBoxDrawAllRsp) {
            int i3;
            QLog.d("handleOpenAllPushBox", 1, "onResponse, isSuccess:" + z16 + ", retCode: " + j3 + ", errMsg: " + str);
            QCircleJsPlugin.this.handlePushBoxRps(z16, j3, str, feedCloudWrite$PushBoxDrawAllRsp, this.f261680a);
            try {
                JSONObject jSONObject = new JSONObject();
                if (z16 && j3 == 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                jSONObject.put("openAllPushBox", i3);
                QCircleJsPlugin.this.callJs(this.f261680a, jSONObject.toString());
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class c implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$PushBoxDrawRocketRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f261682a;

        c(String str) {
            this.f261682a = str;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$PushBoxDrawRocketRsp feedCloudWrite$PushBoxDrawRocketRsp) {
            int i3;
            QLog.d("handleOpenPushBox", 1, "onResponse, isSuccess:" + z16 + ", retCode: " + j3 + ", errMsg: " + str);
            QCircleJsPlugin.this.handlePushBoxRps(z16, j3, str, feedCloudWrite$PushBoxDrawRocketRsp, this.f261682a);
            try {
                JSONObject jSONObject = new JSONObject();
                if (z16 && j3 == 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                jSONObject.put("openPushBox", i3);
                QCircleJsPlugin.this.callJs(this.f261682a, jSONObject.toString());
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class d extends TypeToken<ArrayList<QFSPushBoxBean>> {
        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f261685d;

        e(String str) {
            this.f261685d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QCircleJsPlugin.this.sendOpenAllPushBoxRequest(this.f261685d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class f implements VSDispatchObserver.OnVSRspCallBack<FeedCloudCommon$StWebCommJsonRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f261687a;

        f(String str) {
            this.f261687a = str;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudCommon$StWebCommJsonRsp feedCloudCommon$StWebCommJsonRsp) {
            QLog.d("handleSsoRequest", 1, "onResponse, isSuccess:" + z16 + ", retCode: " + j3 + ", errMsg: " + str);
            QCircleJsPlugin.this.invokeCallbackJs(this.f261687a, QCircleJsPlugin.this.buildSsoRequestCallbackResult(j3, str, feedCloudCommon$StWebCommJsonRsp));
        }
    }

    /* loaded from: classes16.dex */
    public class h extends JSONObject {
        public h(String str) throws JSONException {
            super(str);
        }

        @Override // org.json.JSONObject
        public int getInt(String str) throws JSONException {
            if (!has(str)) {
                return 0;
            }
            return super.getInt(str);
        }

        @Override // org.json.JSONObject
        public String getString(String str) throws JSONException {
            if (!has(str)) {
                return "";
            }
            return super.getString(str);
        }
    }

    private void broadcastShowQCircleCustomToast(String str) {
        Intent intent = new Intent();
        intent.setAction("action_show_qcircle_custom_toast");
        intent.putExtra("text", str);
        BaseApplicationImpl.getApplication().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String buildSsoRequestCallbackResult(long j3, String str, FeedCloudCommon$StWebCommJsonRsp feedCloudCommon$StWebCommJsonRsp) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("retCode", j3);
            jSONObject2.put("errMsg", str);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "buildSsoRequestCallbackResult error: ", e16);
        }
        if (feedCloudCommon$StWebCommJsonRsp != null && feedCloudCommon$StWebCommJsonRsp.data.get() != null && !feedCloudCommon$StWebCommJsonRsp.data.get().isEmpty()) {
            jSONObject = new JSONObject(feedCloudCommon$StWebCommJsonRsp.data.get().toStringUtf8());
            jSONObject2.put("busiBuff", jSONObject);
            return jSONObject2.toString();
        }
        QLog.d(TAG, 1, "handleSsoRequest... rsp is empty");
        jSONObject = new JSONObject();
        jSONObject2.put("busiBuff", jSONObject);
        return jSONObject2.toString();
    }

    private boolean checkArgsValid(String[] strArr) {
        if (strArr != null && strArr.length >= 1) {
            return true;
        }
        QLog.e(TAG, 2, "args is null");
        return false;
    }

    private String cutHeadIfNeeded(String str) {
        int indexOf;
        int i3;
        if (str == null) {
            return null;
        }
        if (str.startsWith("data:image") && (indexOf = str.indexOf("base64,")) >= 0 && (i3 = indexOf + 7) < str.length()) {
            return str.substring(i3);
        }
        return str;
    }

    private String getAlbumFeedJsonString(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        JSONArray jSONArray = jSONObject.getJSONArray("vecFeed");
        int length = jSONArray.length() - 12;
        if (length > 0) {
            int length2 = jSONArray.length() - 1;
            for (int i3 = length2; i3 > length2 - length; i3--) {
                jSONArray.remove(i3);
            }
            jSONObject.put("vecFeed", jSONArray);
        }
        return jSONObject.toString();
    }

    private void getDisableRightInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "getDisableRightInfo callback is null");
            return;
        }
        Bundle bundleExtra = this.mRuntime.a().getIntent().getBundleExtra(FSPublishConstants.DISABLE_RIGHT_INFO);
        String string = bundleExtra.getString(FSPublishConstants.DISABLE_UIN_ID);
        String string2 = bundleExtra.getString(FSPublishConstants.DISABLE_GROUP_ID);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_UIN_LIST, string);
            jSONObject.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, string2);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        QLog.i(TAG, 1, "getDisableRightInfo  jsonObject = " + jSONObject);
        callJs(str, jSONObject.toString());
    }

    private void getGpsInfo(String str) {
        Intent intent;
        Bundle extras;
        Activity a16 = this.mRuntime.a();
        if (a16 == null || a16.isFinishing() || TextUtils.isEmpty(str) || (intent = a16.getIntent()) == null || (extras = intent.getExtras()) == null) {
            return;
        }
        LbsDataV2.GpsInfo gpsInfo = (LbsDataV2.GpsInfo) extras.getParcelable(((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).keyGpsInfo());
        if (gpsInfo == null) {
            gpsInfo = new LbsDataV2.GpsInfo();
            gpsInfo.lat = 0;
            gpsInfo.lon = 0;
            gpsInfo.alt = 0;
            gpsInfo.gpsType = 0;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(QCircleSchemeAttr.Polymerize.LAT, gpsInfo.lat);
            jSONObject2.put("lon", gpsInfo.lon);
            jSONObject2.put(QCircleSchemeAttr.Polymerize.ALT, gpsInfo.alt);
            jSONObject.put("gpsInfo", jSONObject2);
        } catch (Exception unused) {
        }
        callJs(str, jSONObject.toString());
    }

    private void getLabel(String str) {
        Bundle extras;
        Activity a16 = this.mRuntime.a();
        if (a16 != null && !a16.isFinishing() && !TextUtils.isEmpty(str)) {
            Intent intent = a16.getIntent();
            if (intent == null || (extras = intent.getExtras()) == null) {
                return;
            }
            callJs(str, ((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).labelToJson(extras));
            return;
        }
        QLog.e(TAG, 1, "getLabel activity is null");
    }

    private QCircleHybirdFragment getQCircleHybirdFragment() {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && (bVar.f() instanceof QCircleHybirdFragment)) {
            return (QCircleHybirdFragment) this.mRuntime.f();
        }
        return null;
    }

    private void getTongSessionId(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "getTongSessionId callback is null");
            return;
        }
        String session = QCircleNativeSessionManager.g().getSession();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServiceConst.PARA_SESSION_ID, session);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        QLog.i(TAG, 1, "getTongSessionId  session_id = " + session);
        callJs(str, jSONObject.toString());
    }

    private void handleAlbumEdit(String str) throws JSONException {
        sendAlbumBroadcast("action_fake_write_album_detail_edit", str);
        JSONObject jSONObject = new JSONObject(str);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleAlbumEvent(2, Long.parseLong(jSONObject.getString("id")), jSONObject.getString("title"), jSONObject.getString("description"), jSONObject.getString("cover_url"), jSONObject.optLong("item_count")), true);
    }

    private void handleAlbumWorksAdd(String str) throws JSONException {
        sendAlbumBroadcast("action_fake_write_album_works_add", getAlbumFeedJsonString(str));
    }

    private void handleAlbumWorksEdit(String str) throws JSONException {
        sendAlbumBroadcast("action_fake_write_album_works_edit", getAlbumFeedJsonString(str));
    }

    private void handleBase64ToPics(String str) throws JSONException {
        h hVar = new h(str);
        String string = hVar.getString("callback");
        JSONArray optJSONArray = hVar.optJSONArray("images");
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            String string2 = optJSONArray.getJSONObject(i3).getString("image");
            if (!TextUtils.isEmpty(string2)) {
                byte[] a16 = com.tencent.mobileqq.musicpendant.a.a(string2.split(",")[1]);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(a16, 0, a16.length);
                JSONObject jSONObject = new JSONObject();
                if (decodeByteArray != null) {
                    String str2 = System.currentTimeMillis() + ".jpeg";
                    String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE);
                    File file = new File(sDKPrivatePath);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String str3 = sDKPrivatePath + str2;
                    if (ae2.a.a(decodeByteArray, str3, Bitmap.CompressFormat.JPEG, 100, true)) {
                        jSONObject.put("path", str3);
                        jSONArray.mo162put(jSONObject);
                        QLog.i(TAG, 1, "handleBase64ToPics... file save success:" + str3);
                    } else {
                        QLog.e(TAG, 1, "handleBase64ToPics... file save failed:" + str3);
                    }
                }
            }
        }
        QLog.i(TAG, 1, "handleBase64ToPics... list:" + jSONArray.toString());
        callJs("window." + string + "({result:" + jSONArray.toString() + "})");
    }

    private void handleCacheMusicEvent(String str) throws JSONException {
        if (this.mRuntime != null) {
            Intent intent = new Intent();
            h hVar = new h(str);
            intent.setAction(QQWinkConstants.QQWinkBroadcast.ACTION_DISPATCH_MUSIC_EVENT);
            intent.putExtra("event", QQWinkConstants.JS_PLUGIN_EVENT_CACHE_MUSIC);
            intent.putExtra("data", hVar.toString());
            BaseApplicationImpl.getApplication().sendBroadcast(intent);
        }
    }

    private void handleChangeHalfScreenState(String str) throws JSONException {
        CustomWebView customWebView;
        int i3;
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "[handleChangeHalfScreenState] args is empty");
            return;
        }
        String optString = new h(str).optString("state");
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null) {
            customWebView = bVar.e();
        } else {
            customWebView = null;
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        if (customWebView != null) {
            i3 = customWebView.hashCode();
        } else {
            i3 = 0;
        }
        simpleEventBus.dispatchEvent(new QFSJsChangeHalfScreenState(str, i3, optString));
    }

    private void handleChargePushRocket(String str) throws JSONException {
        String optString = new h(new h(str).getString("p")).optString("rocket_count");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        int t16 = com.tencent.biz.qqcircle.f.v().t();
        try {
            t16 = Integer.parseInt(optString);
        } catch (Exception e16) {
            QLog.d(TAG, 1, "fuel count error " + e16);
        }
        com.tencent.biz.qqcircle.f.v().R(t16);
        SimpleEventBus.getInstance().dispatchEvent(new QFSRocketNumUpdateEvent(t16), true);
    }

    private void handleChargeStatus(String str) throws JSONException {
        h hVar = new h(str);
        String string = hVar.getString("status");
        int i3 = hVar.getInt("balance");
        String string2 = hVar.getString("uin");
        if ("success".equals(string)) {
            ((IToastUtil) QRoute.api(IToastUtil.class)).determineShowByCode(1L, BaseApplication.getContext(), 2, "\u5145\u503c\u6210\u529f", 0);
            Intent intent = new Intent();
            intent.setAction("action_update_native_balance");
            intent.putExtra("balance", i3);
            intent.putExtra("uin", string2);
            BaseApplicationImpl.getApplication().sendBroadcast(intent);
        }
    }

    private void handleClearDecorateRedPoint() {
        SimpleEventBus.getInstance().dispatchEvent(new QFSClearDecorateRedPointEvent(), true);
    }

    private void handleClipMusicEvent(String str) throws JSONException {
        if (this.mRuntime != null) {
            ((IAEMusicClipDialog) QRoute.api(IAEMusicClipDialog.class)).showMusicClipDialogOnWebView(new h(str), this.mRuntime.a());
        }
    }

    private void handleCollectMusicEvent(String str) throws JSONException {
        if (this.mRuntime != null) {
            Intent intent = new Intent();
            h hVar = new h(str);
            intent.setAction(QQWinkConstants.QQWinkBroadcast.ACTION_DISPATCH_MUSIC_EVENT);
            intent.putExtra("event", QQWinkConstants.JS_PLUGIN_EVENT_COLLECT_MUSIC);
            intent.putExtra("data", hVar.toString());
            BaseApplicationImpl.getApplication().sendBroadcast(intent);
        }
    }

    private void handleConfirmSchoolName(String str) throws JSONException {
        String string = new h(str).getString("schoolName");
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null) {
            if ((bVar.f() instanceof QCircleHybirdFragment) || (this.mRuntime.f() instanceof QQTranslucentBrowserActivity.QQTranslucentBrowserFragment)) {
                Intent intent = new Intent();
                intent.setAction("action_confirm_school_name");
                intent.putExtra("schoolName", string);
                BaseApplicationImpl.getApplication().sendBroadcast(intent);
                if (this.mRuntime.a() != null) {
                    this.mRuntime.a().finish();
                }
            }
        }
    }

    private void handleDecodeAiPaintReq(String str) {
        ((IQQWinkEditorResAPI) QRoute.api(IQQWinkEditorResAPI.class)).decodeAiPaintReq(str, new IQQWinkEditorResAPI.AiPaintResponseListener() { // from class: com.tencent.mobileqq.qcircle.api.hybird.e
            @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI.AiPaintResponseListener
            public final void onResponse(String str2, String str3) {
                QCircleJsPlugin.lambda$handleDecodeAiPaintReq$2(QCircleJsPlugin.this, str2, str3);
            }
        });
    }

    private void handleDidFinishLoading(String str) throws JSONException {
        String str2;
        h hVar = new h(str);
        String optString = hVar.optString("timestamp");
        String optString2 = hVar.optString("callback");
        if (!TextUtils.isEmpty(optString)) {
            long currentTimeMillis = System.currentTimeMillis();
            WebViewPlugin.b bVar = this.mRuntime;
            long j3 = 0;
            if (bVar == null || bVar.a() == null) {
                str2 = "";
            } else {
                Intent intent = this.mRuntime.a().getIntent();
                j3 = 0 + intent.getLongExtra(QCirclePublishQualityReporter.KEY_CLICK_WEB_TIME, 0L);
                str2 = "" + intent.getExtras().get(QCirclePublishQualityReporter.KEY_H5_TYPE);
            }
            if (!TextUtils.isEmpty(optString2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("clickStartTime", j3);
                jSONObject.put("loadFinishTime", currentTimeMillis);
                callJs(optString2, jSONObject.toString());
            }
            QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_DID_LOADING, (List<FeedCloudCommon$Entry>) Arrays.asList(QCircleReportHelper.newEntry("traceid", ""), QCircleReportHelper.newEntry("ext1", "loadfinish"), QCircleReportHelper.newEntry("ext2", optString), QCircleReportHelper.newEntry("ext3", currentTimeMillis + ""), QCircleReportHelper.newEntry("ext4", j3 + ""), QCircleReportHelper.newEntry("ext5", str2), QCircleReportHelper.newEntry("ext6", (currentTimeMillis - j3) + "")));
        }
    }

    private void handleDisableSetRightInfo(String str) throws JSONException {
        h hVar = new h(str);
        String optString = hVar.optString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_UIN_LIST);
        String optString2 = hVar.optString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID);
        String optString3 = hVar.optString("nickname");
        String optString4 = hVar.optString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_NAME);
        String optString5 = hVar.optString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_UIN_NUMBER);
        Bundle bundle = new Bundle();
        bundle.putString(FSPublishConstants.DISABLE_NICK_NAME, optString3);
        bundle.putString(FSPublishConstants.DISABLE_GROUP_NAME, optString4);
        bundle.putString(FSPublishConstants.DISABLE_UIN_ID, optString);
        bundle.putString(FSPublishConstants.DISABLE_GROUP_ID, optString2);
        bundle.putString(FSPublishConstants.DISABLE_UIN_NUMBER, optString5);
        Intent intent = new Intent();
        intent.putExtra(FSPublishConstants.DISABLE_RIGHT_INFO, bundle);
        intent.setAction(FSPublishConstants.FSPublishBroadcast.ACTION_USER_PUBLISH_DISABLE_INFO);
        BaseApplicationImpl.getApplication().sendBroadcast(intent);
        if (this.mRuntime.a() != null) {
            this.mRuntime.a().finish();
        }
    }

    private void handleDownloadMedia(String str) {
        try {
            h hVar = new h(str);
            final String string = hVar.getString("callback");
            String string2 = hVar.getString("url");
            if (string2.startsWith("https://qqcircle_aipainting_native_export.qq.com/local_files")) {
                final String defaultSavePath = RFWDownloaderFactory.getDownloader(vq3.a.a()).getDefaultSavePath(string2);
                if (RFWDownloaderFactory.getDownloader(vq3.a.a()).isFileDownLoaded(string2)) {
                    callJs("window." + string + "({result:\"" + defaultSavePath + "\"})");
                    return;
                }
                ((IQQWinkEditorResAPI) QRoute.api(IQQWinkEditorResAPI.class)).downloadAiPaintVideo(string2, defaultSavePath, new IQQWinkEditorResAPI.DownloadAiPaintVideoListener() { // from class: com.tencent.mobileqq.qcircle.api.hybird.d
                    @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI.DownloadAiPaintVideoListener
                    public final void onDownloaded(int i3, String str2) {
                        QCircleJsPlugin.this.lambda$handleDownloadMedia$0(string, defaultSavePath, i3, str2);
                    }
                });
                return;
            }
            if (RFWDownloaderFactory.getDownloader(vq3.a.a()).isFileDownLoading(string2)) {
                QLog.e(TAG, 1, "handleDownloadMedia is downloading... url:" + string2);
                return;
            }
            if (RFWDownloaderFactory.getDownloader(vq3.a.a()).isFileDownLoaded(string2)) {
                callJs("window." + string + "({result:\"" + RFWDownloaderFactory.getDownloader(vq3.a.a()).getDefaultSavePath(string2) + "\"})");
                return;
            }
            RFWDownloaderFactory.getDownloader(vq3.a.a()).download(string2, new g(string));
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "handleDownloadMedia failed:", e16);
            if (!TextUtils.isEmpty("")) {
                callJs("window.({result:\"\"})");
                return;
            }
            QLog.d(TAG, 1, "handleDownloadMedia... callback is empty");
        }
    }

    private void handleEnableJoinPushBox(String str) {
        try {
            VSNetworkHelper.getInstance().sendRequest(new QCircleSetCircleSwitchRequest("qqcircle", "qqcircle_push_rocket_game_enable", "1"), new a(new h(str).optString("callback")));
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "handleEnableJoinPushBox failed:", e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleEnableJoinPushBoxCallback(String str, boolean z16, long j3) {
        int i3;
        try {
            JSONObject jSONObject = new JSONObject();
            if (z16 && j3 == 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            jSONObject.put("enableJoinPushBox", i3);
            callJs(str, jSONObject.toString());
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "handleEnableJoinPushBox callback failed:", e16.getMessage());
        }
    }

    private void handleExportAiPaintVideoAsync(String str) {
        ((IQQWinkEditorResAPI) QRoute.api(IQQWinkEditorResAPI.class)).exportAiPaintVideoAsync(str);
    }

    private void handleGetCurrentHalfPannelStatus(String str) throws JSONException {
        CustomWebView customWebView;
        int i3;
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "[handleGetCurrentHalfPannelStatus] args is empty");
            return;
        }
        String optString = new h(str).optString("callback");
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null) {
            customWebView = bVar.e();
        } else {
            customWebView = null;
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        if (customWebView != null) {
            i3 = customWebView.hashCode();
        } else {
            i3 = 0;
        }
        simpleEventBus.dispatchEvent(new QFSJsGetCurrentHalfPannelStatusEvent(optString, str, i3));
    }

    private void handleGetExportAiPaintVideoResult(String str) {
        ((IQQWinkEditorResAPI) QRoute.api(IQQWinkEditorResAPI.class)).getExportAiPaintVideoResult(str, new IQQWinkEditorResAPI.AiPaintResponseListener() { // from class: com.tencent.mobileqq.qcircle.api.hybird.c
            @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI.AiPaintResponseListener
            public final void onResponse(String str2, String str3) {
                QCircleJsPlugin.lambda$handleGetExportAiPaintVideoResult$3(QCircleJsPlugin.this, str2, str3);
            }
        });
    }

    private void handleGetPublishResult(String str) {
        try {
            h hVar = new h(str);
            String optString = hVar.optString(QCircleScheme.AttrQQPublish.PUBLISH_TASKID);
            callJs(hVar.optString("callback"), QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).decodeString(QQWinkConstants.FISSION_KEY + optString, ""));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "handleGetPublishResult failed:", e16.getMessage());
        }
    }

    private void handleGoToAlbumDetailPage(String str) throws JSONException {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && (bVar.f() instanceof QCircleHybirdFragment)) {
            JSONObject jSONObject = new JSONObject(str);
            long parseLong = Long.parseLong(jSONObject.getString("id"));
            String string = jSONObject.getString("title");
            String string2 = jSONObject.getString("cover_url");
            String string3 = jSONObject.getString("description");
            long optLong = jSONObject.optLong("item_count");
            QLog.d(TAG, 1, "open album detail page , album id:" + parseLong);
            QCircleAlbumDetailBean qCircleAlbumDetailBean = new QCircleAlbumDetailBean(parseLong);
            if (this.mRuntime.a() != null) {
                this.mRuntime.a().finish();
            }
            SimpleEventBus.getInstance().dispatchEvent(new QCircleAlbumEvent(3, parseLong, string, string3, string2, optLong), true);
            com.tencent.biz.qqcircle.launcher.c.Z(QCircleApplication.getAPP().getApplicationContext(), qCircleAlbumDetailBean);
        }
    }

    private void handleIsLightResReady(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String string = new h(str).getString("callback");
        jSONObject.put("retCode", !((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady() ? 1 : 0);
        callJs(string, jSONObject.toString());
    }

    private void handleNeedCollapse(String str) throws JSONException {
        CustomWebView customWebView;
        int i3;
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "[handleNeedCollapse] args is empty");
            return;
        }
        int optInt = new h(str).optInt("need");
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null) {
            customWebView = bVar.e();
        } else {
            customWebView = null;
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        if (customWebView != null) {
            i3 = customWebView.hashCode();
        } else {
            i3 = 0;
        }
        simpleEventBus.dispatchEvent(new QFSJsNeedCollapseEvent(optInt, str, i3));
    }

    private void handleOpenAllPushBox(final String str) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.qcircle.api.hybird.QCircleJsPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    QCircleJsPlugin.this.sendOpenAllPushBoxRequest(new h(str).optString("callback"));
                } catch (Exception e16) {
                    QLog.e(QCircleJsPlugin.TAG, 1, "handleOpenAllPushBox failed:", e16.getMessage());
                }
            }
        });
    }

    private void handleOpenCollectionPicker(String str) throws JSONException {
        boolean z16;
        String optString = new JSONObject(str).optString("callback");
        QLog.d(TAG, 1, "on picker clicked " + optString);
        Bundle bundle = new Bundle();
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        bundle.putString("app_key", "00000QG6YX3X0LZH");
        bundle.putSerializable(QQWinkConstants.SPECIFIC_WINK_HOME_CLASS_TYPE, IQQWinkLaucher.WinkHomePageType.TYPE_COLLECTION_PICKER);
        bundle.putString("callback", optString);
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && bVar.f() != null) {
            bundle.putInt(QQWinkConstants.ACTIVITY_REQUEST_CODE, this.mRuntime.f().switchRequestCode(this, (byte) 1));
            ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToQQWinkHome(this.mRuntime.a(), bundle);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("jump fail: ");
        if (this.mRuntime == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.d(TAG, 1, sb5.toString());
    }

    private void handleOpenGroupProfile(String str) throws JSONException {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && bVar.a() != null) {
            Activity a16 = this.mRuntime.a();
            h hVar = new h(str);
            ((IQCircleChatUtilApi) QRoute.api(IQCircleChatUtilApi.class)).enterQQGroupDetail(a16, hVar.optString("groupUin"), hVar.optString("groupAuth"), QCircleScheme.AttrQQGroupDetail.PERSONAL);
        }
    }

    private void handleOpenPushBox(final String str) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.qcircle.api.hybird.QCircleJsPlugin.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h hVar = new h(str);
                    String optString = hVar.optString("callback");
                    FeedCloudWrite$PushBoxBasic feedCloudWrite$PushBoxBasic = new FeedCloudWrite$PushBoxBasic();
                    String optString2 = hVar.optString("feed_id");
                    String optString3 = hVar.optString("auth_uin");
                    feedCloudWrite$PushBoxBasic.feed_id.set(optString2);
                    feedCloudWrite$PushBoxBasic.auth_uin.set(optString3);
                    JSONArray optJSONArray = hVar.optJSONArray("drawBoxInfo");
                    ArrayList arrayList = new ArrayList();
                    if (optJSONArray == null) {
                        return;
                    }
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        int optInt = optJSONArray.optJSONObject(i3).optInt("box_type");
                        FeedCloudWrite$PushBoxBasicDrawInfo feedCloudWrite$PushBoxBasicDrawInfo = new FeedCloudWrite$PushBoxBasicDrawInfo();
                        feedCloudWrite$PushBoxBasicDrawInfo.box_type.set(optInt);
                        arrayList.add(feedCloudWrite$PushBoxBasicDrawInfo);
                    }
                    feedCloudWrite$PushBoxBasic.drawBoxInfo.set(arrayList);
                    QCircleJsPlugin.this.sendOpenPushBoxRequest(feedCloudWrite$PushBoxBasic, optString);
                } catch (Exception e16) {
                    QLog.e(QCircleJsPlugin.TAG, 1, "handleOpenPushBox failed:", e16.getMessage());
                }
            }
        });
    }

    private void handlePreloadAiPaintRes(String str) {
        ((IQQWinkEditorResAPI) QRoute.api(IQQWinkEditorResAPI.class)).preloadAiPaintRes(str);
    }

    private void handlePublishAiPaintVideo(String str) {
        ((IQQWinkEditorResAPI) QRoute.api(IQQWinkEditorResAPI.class)).publishAiPaintVideo(str, new IQQWinkEditorResAPI.AiPaintResponseListener() { // from class: com.tencent.mobileqq.qcircle.api.hybird.b
            @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI.AiPaintResponseListener
            public final void onResponse(String str2, String str3) {
                QCircleJsPlugin.lambda$handlePublishAiPaintVideo$1(QCircleJsPlugin.this, str2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePushBoxRps(boolean z16, long j3, String str, Object obj, String str2) {
        if (z16 && j3 == 0 && obj != null) {
            ArrayList<FeedCloudWrite$PushBoxBasic> arrayList = new ArrayList();
            if (obj instanceof FeedCloudWrite$PushBoxDrawRocketRsp) {
                arrayList.add(((FeedCloudWrite$PushBoxDrawRocketRsp) obj).drawBoxResult.get());
                SimpleEventBus.getInstance().dispatchEvent(new QFSUpdateSuspendBoxCountEvent(false));
            } else if (obj instanceof FeedCloudWrite$PushBoxDrawAllRsp) {
                arrayList.addAll(((FeedCloudWrite$PushBoxDrawAllRsp) obj).drawBoxResult.get());
                SimpleEventBus.getInstance().dispatchEvent(new QFSUpdateSuspendBoxCountEvent(true));
            }
            com.tencent.biz.qqcircle.f.v().b(arrayList);
            ArrayList arrayList2 = new ArrayList();
            for (FeedCloudWrite$PushBoxBasic feedCloudWrite$PushBoxBasic : arrayList) {
                if (feedCloudWrite$PushBoxBasic != null) {
                    String str3 = feedCloudWrite$PushBoxBasic.feed_id.get();
                    FeedCloudMeta$PushBoxViewInfo feedCloudMeta$PushBoxViewInfo = feedCloudWrite$PushBoxBasic.pushBoxViewInfo.get();
                    FeedCloudMeta$StPushList f16 = QCirclePushInfoManager.e().f(str3);
                    if (f16 != null) {
                        f16.pushBoxViewInfo.set(feedCloudMeta$PushBoxViewInfo);
                        QCirclePushInfoManager.e().p(str3, f16);
                    }
                    arrayList2.add(new QFSPushBoxBean(feedCloudWrite$PushBoxBasic));
                }
            }
            WebViewPlugin.b bVar = this.mRuntime;
            if (bVar == null) {
                return;
            }
            if ((bVar.f() instanceof QCircleHybirdFragment) || (this.mRuntime.f() instanceof QQTranslucentBrowserActivity.QQTranslucentBrowserFragment)) {
                Intent intent = new Intent();
                intent.setAction("action_open_push_box");
                intent.putExtra("push_box_json", com.tencent.biz.pubaccount.util.d.b().d(arrayList2, new d().getType()));
                BaseApplicationImpl.getApplication().sendBroadcast(intent);
            }
            openBoxResultPopWindow(obj, str2);
            return;
        }
        RFWLog.i(TAG, RFWLog.USR, "handlePushBoxRps errMsg = " + str);
    }

    private void handleRefreshAvatar(String str) {
        try {
            uq3.c.d7(new h(str).getString("iconUrl"));
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "handleRefreshAvatar failed:", e16.getMessage());
        }
    }

    private void handleRefreshFeedList(String str) throws JSONException {
        String string = new h(str).getString("page");
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && (bVar.f() instanceof QCircleHybirdFragment)) {
            ((QCircleHybirdFragment) this.mRuntime.f()).xh(string);
        }
    }

    private void handleRefreshIconDecorate(String str) {
        QLog.d(TAG, 1, "QCircleRefreshIconDecorate handleRefreshIconDecorate arg:" + str);
        try {
            WebViewPlugin.b bVar = this.mRuntime;
            if (bVar != null && (bVar.f() instanceof QCircleHybirdFragment)) {
                ((QCircleHybirdFragment) this.mRuntime.f()).uh(str);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "handleRefreshIconDecorate error: ", e16);
        }
    }

    private void handleRefreshPushEffect(String str) {
        QLog.d(TAG, 1, "QCircleRefreshPushEffect handleRefreshPushEffect arg:" + str);
        try {
            WebViewPlugin.b bVar = this.mRuntime;
            if (bVar != null && (bVar.f() instanceof QCircleHybirdFragment)) {
                ((QCircleHybirdFragment) this.mRuntime.f()).vh(str);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "QCircleRefreshPushEffect error: ", e16);
        }
    }

    private void handleRefreshQrcode(String str) {
        try {
            SimpleEventBus.getInstance().dispatchEvent(new QFSPersonalQrcodeChangeEvent(new h(str).getString("qrcode")), true);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "handleRefreshQrcode failed:", e16.getMessage());
        }
    }

    private void handleReloadMainPage(String str) throws JSONException {
        String string = new h(new h(str).getString("p")).getString("uin");
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null) {
            if ((bVar.f() instanceof QCircleHybirdFragment) || (this.mRuntime.f() instanceof QQTranslucentBrowserActivity.QQTranslucentBrowserFragment)) {
                Intent intent = new Intent();
                intent.setAction("action_reload_get_main_page");
                intent.putExtra("uin", string);
                BaseApplicationImpl.getApplication().sendBroadcast(intent);
            }
        }
    }

    private void handleSelectGoodsEvent(String str) throws JSONException {
        if (this.mRuntime != null) {
            Intent intent = new Intent();
            h hVar = new h(str);
            intent.setAction("action_dispatch_goods_event");
            intent.putExtra("event", "setShoppingGoods");
            intent.putExtra("data", hVar.toString());
            BaseApplicationImpl.getApplication().sendBroadcast(intent);
            callJs((String) hVar.get("callback"), "{\"result\":\"ok\"}");
        }
    }

    private void handleSelectMusicEvent(String str) throws JSONException {
        if (this.mRuntime != null) {
            ((IAEMusicClipDialog) QRoute.api(IAEMusicClipDialog.class)).showMusicSelectLoadingOnWebView(new h(str), this.mRuntime.a());
        }
    }

    private void handleSelectedHobbyLabel() {
        SimpleEventBus.getInstance().dispatchEvent(new QFSRefreshTabEvent(6, true), true);
        broadcastShowQCircleCustomToast("\u5df2\u4e3a\u4f60\u4f18\u5316\u5185\u5bb9\u63a8\u8350");
    }

    private void handleSetFeedPermission(String str) throws JSONException {
        h hVar = new h(str);
        String optString = hVar.optString("feedId");
        String optString2 = hVar.optString(AppConstants.Key.KEY_QZONE_UGCKEY);
        int optInt = hVar.optInt("type");
        int optInt2 = hVar.optInt("downLoadOper", -1);
        int optInt3 = hVar.optInt("qzoneType", -1);
        QLog.d(TAG, 1, "handleSetFeedPermission: jsonObject=" + hVar.toString() + ", feedId=" + optString + ", ugcKey=" + optString2 + ", rightFlag=" + optInt + ", downLoadOper=" + optInt2 + ", qzoneType=" + optInt3);
        if (!TextUtils.isEmpty(optString)) {
            SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedJSPermissionChangeEvent(optInt, optString, optString2, optInt2, optInt3), true);
        }
    }

    private void handleSetUserWearingMedal(String str) throws JSONException {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && (bVar.f() instanceof QCircleHybirdFragment)) {
            Intent intent = new Intent();
            intent.setAction("action_user_wearing_medal_update");
            intent.putExtra(ark.ARKMETADATA_JSON, str);
            ((QCircleHybirdFragment) this.mRuntime.f()).Ch(intent);
        }
    }

    private void handleSetupBottomTabMode() {
        QIPCClientHelper.getInstance().getClient().callServer(IQCircleIPCApi.MODULE_NAME, IQCircleIPCApi.ACTION_SETUP_QCIRCLE_BOTTOM_TAB_MODE, null, null);
    }

    private void handleSharePicToQCircle(String str) {
        int i3;
        try {
            h hVar = new h(str);
            String optString = hVar.optString(KEY_BASE64);
            String optString2 = hVar.optString("schema");
            String optString3 = hVar.optString("callback");
            try {
                byte[] b16 = com.tencent.mobileqq.musicpendant.a.b(cutHeadIfNeeded(optString).getBytes());
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(b16, 0, b16.length);
                if (decodeByteArray != null) {
                    String str2 = System.currentTimeMillis() + ".jpeg";
                    String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE);
                    File file = new File(sDKPrivatePath);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String str3 = sDKPrivatePath + str2;
                    boolean a16 = ae2.a.a(decodeByteArray, str3, Bitmap.CompressFormat.JPEG, 100, true);
                    if (a16) {
                        QLog.i(TAG, 1, "handleBase64ToPics... file save success:" + str3);
                        com.tencent.biz.qqcircle.launcher.c.g(QCircleApplication.getAPP().getApplicationContext(), optString2 + "&mediaPath=" + str3);
                    } else {
                        QLog.e(TAG, 1, "handleBase64ToPics... file save failed:" + str3);
                    }
                    JSONObject jSONObject = new JSONObject();
                    if (a16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    jSONObject.put("sharePictureToQCircle", i3);
                    callJs(optString3, jSONObject.toString());
                }
            } catch (Exception e16) {
                QLog.w(TAG, 1, "Base64.decode Exception: " + e16.toString());
            }
        } catch (JSONException e17) {
            QLog.e(TAG, 1, "handleSharePicToQCircle failed:", e17.getMessage());
        }
    }

    private void handleShowQCircleCustomToast(String str) {
        try {
            broadcastShowQCircleCustomToast(new h(str).getString("text"));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "handleShowQCircleCustomToast failed:", e16);
        }
    }

    private void handleSsoRequest(String str) {
        String str2;
        h hVar;
        try {
            hVar = new h(str);
            str2 = hVar.getString("callback");
        } catch (Exception e16) {
            e = e16;
            str2 = "";
        }
        try {
            VSNetworkHelper.getInstance().sendRequest(new WebCommonSsoRequest(hVar.getString(KEY_CMD_NAME), hVar.getString(KEY_REQ_PARAMS)), new f(str2));
        } catch (Exception e17) {
            e = e17;
            QLog.e(TAG, 1, "handleSsoRequest failed:", e);
            invokeCallbackJs(str2, "");
        }
    }

    private void handleSupportHalfToFullScreen(String str) throws JSONException {
        CustomWebView customWebView;
        int i3;
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "[handleSupportHalfToFullScreen] args is empty");
            return;
        }
        int optInt = new h(str).optInt(TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT);
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null) {
            customWebView = bVar.e();
        } else {
            customWebView = null;
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        if (customWebView != null) {
            i3 = customWebView.hashCode();
        } else {
            i3 = 0;
        }
        simpleEventBus.dispatchEvent(new QFSJsSupportHalfToFullScreenEvent(optInt, str, i3));
    }

    private void handleSwitchBottomTab(String str) {
        QLog.d(TAG, 1, "handleSwitchBottomTab arg:" + str);
        try {
            int i3 = new h(str).getInt("index");
            if (i3 >= 0) {
                QCircleFrameEvent qCircleFrameEvent = new QCircleFrameEvent();
                qCircleFrameEvent.mSwitchTab = i3;
                SimpleEventBus.getInstance().dispatchEvent(qCircleFrameEvent, true);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "handleSwitchBottomTab error: ", e16);
        }
    }

    private void handleSwitchChange(String str) {
        QLog.d(TAG, 1, "handleSwitchChange arg:" + str);
        Intent intent = new Intent();
        intent.setAction("action_switch_change_event");
        intent.putExtra("params", str);
        BaseApplicationImpl.getApplication().sendBroadcast(intent);
    }

    private void handleTitleBarStyle(String str) throws JSONException {
        SwiftIphoneTitleBarUI swiftIphoneTitleBarUI;
        h hVar = new h(str);
        if (hVar.has("titleTextColor")) {
            int colorFromJSON = ((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).getColorFromJSON(hVar, "titleTextColor");
            v vVar = (v) super.getBrowserComponent(2);
            if (vVar != null && (swiftIphoneTitleBarUI = vVar.C) != null) {
                if (colorFromJSON == -1) {
                    swiftIphoneTitleBarUI.w();
                } else {
                    swiftIphoneTitleBarUI.W(colorFromJSON | (-16777216));
                }
            }
        }
    }

    private void handleUpdateAuthInfo(String str) throws JSONException {
        h hVar = new h(str);
        int optInt = hVar.optInt("tagtype");
        int optInt2 = hVar.optInt("status");
        String optString = hVar.optString("tagname");
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && (bVar.f() instanceof QCircleHybirdFragment)) {
            ((QCircleHybirdFragment) this.mRuntime.f()).zh(optInt, optInt2, optString);
        }
    }

    private void handleUpdateClockInfo(String str) {
        try {
            h hVar = new h(str);
            SimpleEventBus.getInstance().dispatchEvent(new QFSUpdateClockStateEvent(hVar.optInt("daysCount"), hVar.optBoolean("isAllComplete")), true);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "handleUpdateClockInfo failed:", e16.getMessage());
        }
    }

    private void handleUpdateNativeTagFollowState(String str) throws JSONException {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && (bVar.f() instanceof QCircleHybirdFragment)) {
            ((QCircleHybirdFragment) this.mRuntime.f()).Ah();
        }
    }

    private void handleUpdateNativeUserFollowState(String str) throws JSONException {
        h hVar = new h(str);
        String string = hVar.getString("uin");
        int i3 = hVar.getInt("type");
        int optInt = hVar.optInt("isDoubly");
        String optString = hVar.optString("nick");
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && (bVar.f() instanceof QCircleHybirdFragment)) {
            ((QCircleHybirdFragment) this.mRuntime.f()).Bh(string, i3, optInt, optString);
        }
    }

    private void handleUpdatePublishDeclaration(String str) throws JSONException {
        SimpleEventBus.getInstance().dispatchEvent(new WinkUpdatePublishDeclarationEvent(parcelableToByteArray(new DeclarationParams(new h(str).optString("id"), "", null, null))), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeCallbackJs(String str, String str2) {
        QLog.d(TAG, 1, "invokeCallbackJs, callback:" + str + ", result: " + str2);
        if (!TextUtils.isEmpty(str)) {
            callJs(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleDecodeAiPaintReq$2(QCircleJsPlugin qCircleJsPlugin, String str, String str2) {
        qCircleJsPlugin.callJs(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleDownloadMedia$0(String str, String str2, int i3, String str3) {
        if (i3 == 0) {
            callJs("window." + str + "({result:\"" + str2 + "\"})");
            return;
        }
        callJs("window." + str + "({result:\"\"})");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleGetExportAiPaintVideoResult$3(QCircleJsPlugin qCircleJsPlugin, String str, String str2) {
        qCircleJsPlugin.callJs(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handlePublishAiPaintVideo$1(QCircleJsPlugin qCircleJsPlugin, String str, String str2) {
        qCircleJsPlugin.callJs(str, str2);
    }

    private void openBoxResultPopWindow(Object obj, String str) {
        if (this.mRuntime != null && obj != null) {
            if (obj instanceof FeedCloudWrite$PushBoxDrawRocketRsp) {
                QFSPushOpenBoxInfo convertToOpenSingleBoxInfo = QFSPushOpenBoxInfo.convertToOpenSingleBoxInfo((FeedCloudWrite$PushBoxDrawRocketRsp) obj);
                convertToOpenSingleBoxInfo.setSource(QCircleDaTongConstant.ElementId.EM_XSJ_ROCKET_RESULT_PAGE_SOURCE_OTHER);
                showBoxResultWindow(convertToOpenSingleBoxInfo, null);
            } else if (obj instanceof FeedCloudWrite$PushBoxDrawAllRsp) {
                QFSPushOpenBoxInfo convertToOpenMultiBoxInfo = QFSPushOpenBoxInfo.convertToOpenMultiBoxInfo((FeedCloudWrite$PushBoxDrawAllRsp) obj);
                convertToOpenMultiBoxInfo.setSource(QCircleDaTongConstant.ElementId.EM_XSJ_ROCKET_PAGE_OPENALL_BUTTON);
                showBoxResultWindow(convertToOpenMultiBoxInfo, new e(str));
            }
        }
    }

    private void parseJsBridge(String str, String[] strArr) throws JSONException {
        if ("getLabel".equals(str) && checkArgsValid(strArr)) {
            getLabel(new JSONObject(strArr[0]).optString("callback"));
            return;
        }
        if ("setLabel".equals(str) && checkArgsValid(strArr)) {
            setLabel(strArr[0], new JSONObject(strArr[0]).optString("callback"));
            return;
        }
        if ("getGpsInfo".equals(str) && checkArgsValid(strArr)) {
            getGpsInfo(new JSONObject(strArr[0]).optString("callback"));
            return;
        }
        if ("reloadhomepage".equals(str) && checkArgsValid(strArr)) {
            handleReloadMainPage(strArr[0]);
            return;
        }
        if ("refreshAvatar".equals(str) && checkArgsValid(strArr)) {
            handleRefreshAvatar(strArr[0]);
            return;
        }
        if ("openPushBox".equals(str) && checkArgsValid(strArr)) {
            handleOpenPushBox(strArr[0]);
            return;
        }
        if ("openAllPushBox".equals(str) && checkArgsValid(strArr)) {
            handleOpenAllPushBox(strArr[0]);
            return;
        }
        if ("chargePushRocket".equals(str) && checkArgsValid(strArr)) {
            handleChargePushRocket(strArr[0]);
            return;
        }
        if (!"reportReadMessage".equals(str) || !checkArgsValid(strArr)) {
            if (!"isQCircleActive".equals(str) || !checkArgsValid(strArr)) {
                if ("updateUserFollowState".equals(str) && checkArgsValid(strArr)) {
                    handleUpdateNativeUserFollowState(strArr[0]);
                    return;
                }
                if ("updateTagFollowState".equals(str) && checkArgsValid(strArr)) {
                    handleUpdateNativeTagFollowState(strArr[0]);
                    return;
                }
                if ("authrefreshpage".equals(str) && checkArgsValid(strArr)) {
                    handleUpdateAuthInfo(strArr[0]);
                    return;
                }
                if ("refreshFeedList".equals(str) && checkArgsValid(strArr)) {
                    handleRefreshFeedList(strArr[0]);
                    return;
                }
                if ("saveimage".equals(str) && checkArgsValid(strArr)) {
                    handleBase64ToPics(strArr[0]);
                    return;
                }
                if ("setTitleBarStyle".equals(str) && checkArgsValid(strArr)) {
                    handleTitleBarStyle(strArr[0]);
                    return;
                }
                if ("chargeStatusCallback".equals(str) && checkArgsValid(strArr)) {
                    handleChargeStatus(strArr[0]);
                    return;
                }
                if ("getQCircleSessionID".equals(str) && checkArgsValid(strArr)) {
                    getTongSessionId(new JSONObject(strArr[0]).optString("callback"));
                    return;
                }
                if ("setUserWearingMedal".equals(str) && checkArgsValid(strArr)) {
                    handleSetUserWearingMedal(strArr[0]);
                    return;
                }
                if ("confirmSchoolName".equals(str) && checkArgsValid(strArr)) {
                    handleConfirmSchoolName(strArr[0]);
                    return;
                }
                if (QQWinkConstants.JS_PLUGIN_EVENT_SELECT_MUSIC.equals(str) && checkArgsValid(strArr)) {
                    handleSelectMusicEvent(strArr[0]);
                    return;
                }
                if (QQWinkConstants.JS_PLUGIN_EVENT_CLIP_MUSIC.equals(str) && checkArgsValid(strArr)) {
                    handleClipMusicEvent(strArr[0]);
                    return;
                }
                if (QQWinkConstants.JS_PLUGIN_EVENT_CACHE_MUSIC.equals(str) && checkArgsValid(strArr)) {
                    handleCacheMusicEvent(strArr[0]);
                    return;
                }
                if (QQWinkConstants.JS_PLUGIN_EVENT_COLLECT_MUSIC.equals(str) && checkArgsValid(strArr)) {
                    handleCollectMusicEvent(strArr[0]);
                    return;
                }
                if ("setShoppingGoods".equals(str) && checkArgsValid(strArr)) {
                    handleSelectGoodsEvent(strArr[0]);
                    return;
                }
                if (FSPublishConstants.FSPublishJsBridge.JS_PLUGIN_ACTION_GET_RIGHT_INFO.equals(str) && checkArgsValid(strArr)) {
                    getDisableRightInfo(new JSONObject(strArr[0]).optString("callback"));
                    return;
                }
                if (FSPublishConstants.FSPublishJsBridge.JS_PLUGIN_ACTION_SET_RIGHT_INFO.equals(str) && checkArgsValid(strArr)) {
                    handleDisableSetRightInfo(strArr[0]);
                    return;
                }
                if ("downloadMedia".equals(str) && checkArgsValid(strArr)) {
                    handleDownloadMedia(strArr[0]);
                    return;
                }
                if ("switchBottomTab".equals(str) && checkArgsValid(strArr)) {
                    handleSwitchBottomTab(strArr[0]);
                    return;
                }
                if ("refreshIconDecorate".equals(str) && checkArgsValid(strArr)) {
                    handleRefreshIconDecorate(strArr[0]);
                    return;
                }
                if ("refreshPushEffect".equals(str) && checkArgsValid(strArr)) {
                    handleRefreshPushEffect(strArr[0]);
                    return;
                }
                if ("commonSsoRequest".equals(str) && checkArgsValid(strArr)) {
                    handleSsoRequest(strArr[0]);
                    return;
                }
                if ("notifySwitchChange".equals(str) && checkArgsValid(strArr)) {
                    handleSwitchChange(strArr[0]);
                    return;
                }
                if ("setupQCircleBottomTabMode".equals(str)) {
                    handleSetupBottomTabMode();
                    return;
                }
                if ("showQCircleCustomTips".equals(str) && checkArgsValid(strArr)) {
                    handleShowQCircleCustomToast(strArr[0]);
                    return;
                }
                if (QZoneOptAlbumRequest.FIELD_CMD_CREATE.equals(str) && checkArgsValid(strArr)) {
                    handleGoToAlbumDetailPage(strArr[0]);
                    return;
                }
                if (QZoneOptAlbumRequest.FIELD_CMD_EDIT.equals(str) && checkArgsValid(strArr)) {
                    handleAlbumEdit(strArr[0]);
                    return;
                }
                if ("albumWorksAdd".equals(str) && checkArgsValid(strArr)) {
                    handleAlbumWorksAdd(strArr[0]);
                    return;
                }
                if ("albumWorksEdit".equals(str) && checkArgsValid(strArr)) {
                    handleAlbumWorksEdit(strArr[0]);
                    return;
                }
                if ("onRewardsGained".equals(str) && checkArgsValid(strArr)) {
                    SimpleEventBus.getInstance().dispatchEvent(new QFSGrowthCenterTaskOperationEvent(new JSONObject(strArr[0]).optBoolean("allRewardsGained")), true);
                    QLog.d(TAG, 1, "rewards gained: " + strArr[0]);
                    return;
                }
                if ("updateCreatorCenterRedDot".equals(str) && checkArgsValid(strArr)) {
                    SimpleEventBus.getInstance().dispatchEvent(new QFSGrowthCenterTaskOperationEvent(true), true);
                    QLog.d(TAG, 1, "updateCreatorCenterRedDot");
                    return;
                }
                if (QZoneJsConstants.METHOD_QZONE_SELECT_GET_PICTURE.equals(str) && checkArgsValid(strArr)) {
                    handleOpenCollectionPicker(strArr[0]);
                    return;
                }
                if ("openGroupProfile".equals(str) && checkArgsValid(strArr)) {
                    handleOpenGroupProfile(strArr[0]);
                    return;
                }
                if ("enableJoinPushBox".equals(str) && checkArgsValid(strArr)) {
                    handleEnableJoinPushBox(strArr[0]);
                    return;
                }
                if ("didFinishLoad".equals(str) && checkArgsValid(strArr)) {
                    handleDidFinishLoading(strArr[0]);
                    return;
                }
                if ("clearDecorateRedPoint".equals(str)) {
                    handleClearDecorateRedPoint();
                    return;
                }
                if ("sharePictureToQCircle".equals(str) && checkArgsValid(strArr)) {
                    handleSharePicToQCircle(strArr[0]);
                    return;
                }
                if ("dailyClockInInfoChange".equals(str) && checkArgsValid(strArr)) {
                    handleUpdateClockInfo(strArr[0]);
                    return;
                }
                if ("requestPublishResult".equals(str) && checkArgsValid(strArr)) {
                    handleGetPublishResult(strArr[0]);
                    return;
                }
                if ("selectedHobbyLabel".equals(str)) {
                    handleSelectedHobbyLabel();
                    return;
                }
                if ("exportAiPaintVideoAsync".equals(str) && checkArgsValid(strArr)) {
                    handleExportAiPaintVideoAsync(strArr[0]);
                    return;
                }
                if ("publishVideo".equals(str) && checkArgsValid(strArr)) {
                    handlePublishAiPaintVideo(strArr[0]);
                    return;
                }
                if ("preloadAiPaintRes".equals(str) && checkArgsValid(strArr)) {
                    handlePreloadAiPaintRes(strArr[0]);
                    return;
                }
                if ("isLightResReady".equals(str) && checkArgsValid(strArr)) {
                    handleIsLightResReady(strArr[0]);
                    return;
                }
                if ("decodeAiPaintReq".equals(str) && checkArgsValid(strArr)) {
                    handleDecodeAiPaintReq(strArr[0]);
                    return;
                }
                if ("getExportAiPaintVideoResult".equals(str) && checkArgsValid(strArr)) {
                    handleGetExportAiPaintVideoResult(strArr[0]);
                    return;
                }
                if ("changeMainpageQRCode".equals(str) && checkArgsValid(strArr)) {
                    handleRefreshQrcode(strArr[0]);
                    return;
                }
                if ("updatePublishDeclaration".equals(str) && checkArgsValid(strArr)) {
                    handleUpdatePublishDeclaration(strArr[0]);
                    return;
                }
                if ("setViewingPermission".equals(str) && checkArgsValid(strArr)) {
                    handleSetFeedPermission(strArr[0]);
                    return;
                }
                if ("needCollapse".equals(str) && checkArgsValid(strArr)) {
                    handleNeedCollapse(strArr[0]);
                    return;
                }
                if ("supportHalfToFullScreen".equals(str) && checkArgsValid(strArr)) {
                    handleSupportHalfToFullScreen(strArr[0]);
                    return;
                }
                if ("currentHalfPannelStatus".equals(str) && checkArgsValid(strArr)) {
                    handleGetCurrentHalfPannelStatus(strArr[0]);
                } else if ("changeHalfScreenState".equals(str) && checkArgsValid(strArr)) {
                    handleChangeHalfScreenState(strArr[0]);
                }
            }
        }
    }

    private void reportReadMessage(String str) throws JSONException {
        int i3 = new h(str).getInt(WadlProxyConsts.CREATE_TIME);
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && (bVar.f() instanceof QCircleHybirdFragment)) {
            QLog.d(TAG, 1, "reportReadMessage createTime" + i3);
            ((QCircleHybirdFragment) this.mRuntime.f()).Dh(i3);
        }
    }

    private void sendAlbumBroadcast(String str, String str2) {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && (bVar.f() instanceof QCircleHybirdFragment)) {
            Intent intent = new Intent();
            intent.setAction(str);
            intent.putExtra("params", str2);
            BaseApplicationImpl.getApplication().sendBroadcast(intent);
            QLog.d(TAG, 4, "album json:" + str2);
            if (this.mRuntime.a() != null) {
                this.mRuntime.a().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendOpenAllPushBoxRequest(String str) {
        VSNetworkHelper.getInstance().sendRequest(new QFSOpenAllPushBoxRequest(), new b(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendOpenPushBoxRequest(FeedCloudWrite$PushBoxBasic feedCloudWrite$PushBoxBasic, String str) {
        if (feedCloudWrite$PushBoxBasic == null) {
            return;
        }
        VSNetworkHelper.getInstance().sendRequest(new QFSOpenPushBoxRequest(feedCloudWrite$PushBoxBasic), new c(str));
    }

    private void setLabel(String str, String str2) {
        String str3;
        Activity a16 = this.mRuntime.a();
        if (a16 != null && !a16.isFinishing()) {
            Intent intent = new Intent();
            intent.putExtras(((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).jsonToLabel(intent.getExtras(), str));
            a16.setResult(-1, intent);
            if (!TextUtils.isEmpty(str2)) {
                String stringExtra = intent.getStringExtra(((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).keyParseDataErrorMsg());
                if (!TextUtils.isEmpty(stringExtra)) {
                    str3 = "{\"ret\":-1, \"msg\":\"" + stringExtra + "\"}";
                } else {
                    str3 = "{\"ret\":0, \"msg\":\"sucess\"}";
                }
                callJs(str2, str3);
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "setLabel activity is null");
    }

    private WebResourceResponse shouldInterceptRequest(String str) {
        if (str.startsWith("https://qqcircle_aipainting_native_export.qq.com/local_files")) {
            try {
                WebResourceResponse webResourceResponse = new WebResourceResponse("video/mp4", "utf-8", new FileInputStream(new File(str.replace("https://qqcircle_aipainting_native_export.qq.com/local_files", ""))));
                Map<String, String> responseHeaders = webResourceResponse.getResponseHeaders();
                if (responseHeaders == null) {
                    responseHeaders = new HashMap<>();
                }
                responseHeaders.put("Access-Control-Allow-Origin", "*");
                webResourceResponse.setResponseHeaders(responseHeaders);
                return webResourceResponse;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "shouldInterceptRequest failed:", e16.getMessage());
            }
        }
        return null;
    }

    private void showBoxResultWindow(QFSPushOpenBoxInfo qFSPushOpenBoxInfo, View.OnClickListener onClickListener) {
        ((IQFSPushOpenBoxPopWindowApi) QRoute.api(IQFSPushOpenBoxPopWindowApi.class)).showPushOpenBoxWindow(this.mRuntime.e().getContext(), qFSPushOpenBoxInfo, onClickListener, this.mRuntime.e());
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "qcircle";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 8L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public Object handleEvent(String str, long j3) {
        if (j3 == 8) {
            return shouldInterceptRequest(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if ("qcircle".equals(str2)) {
            QLog.i(TAG, 2, "handleJsRequest:" + str);
            try {
                parseJsBridge(str3, strArr);
            } catch (Exception e16) {
                QLog.d(TAG, 1, e16, new Object[0]);
            }
            return true;
        }
        return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        super.onActivityResult(intent, b16, i3);
        if (b16 == 1 && i3 == -1) {
            try {
                JSONArray jSONArray = new JSONArray();
                jSONArray.mo162put(MediaApiPlugin.P(intent.getStringExtra(QQWinkConstants.PICK_MEDIA_FRAME_PATH), 1, 1, 1280, 1280));
                callJs(intent.getStringExtra("callback"), "0", jSONArray.toString());
            } catch (Exception e16) {
                QLog.e(TAG, 1, "pack image object error: " + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        ((IQQWinkEditorResAPI) QRoute.api(IQQWinkEditorResAPI.class)).clearAiPaintVideoCacheFiles();
        super.onDestroy();
    }

    public byte[] parcelableToByteArray(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        return marshall;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class g implements RFWDownloader.RFWDownloadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f261689d;

        g(String str) {
            this.f261689d = str;
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callEnd(Call call) {
            com.tencent.biz.richframework.download.v.a(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callFailed(Call call, IOException iOException) {
            com.tencent.biz.richframework.download.v.b(this, call, iOException);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callStart(Call call) {
            com.tencent.biz.richframework.download.v.c(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2) {
            com.tencent.biz.richframework.download.v.d(this, call, inetSocketAddress, proxy, protocol2);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2, IOException iOException) {
            com.tencent.biz.richframework.download.v.e(this, call, inetSocketAddress, proxy, protocol2, iOException);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
            com.tencent.biz.richframework.download.v.f(this, call, inetSocketAddress, proxy);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectionAcquired(Call call, Connection connection) {
            com.tencent.biz.richframework.download.v.g(this, call, connection);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectionReleased(Call call, Connection connection) {
            com.tencent.biz.richframework.download.v.h(this, call, connection);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void dnsEnd(Call call, String str, List list) {
            com.tencent.biz.richframework.download.v.i(this, call, str, list);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void dnsStart(Call call, String str) {
            com.tencent.biz.richframework.download.v.j(this, call, str);
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
        public void onRspCallback(boolean z16, String str) {
            if (z16) {
                QCircleJsPlugin.this.callJs("window." + this.f261689d + "({result:\"" + str + "\"})");
                return;
            }
            QCircleJsPlugin.this.callJs("window." + this.f261689d + "({result:\"\"})");
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestBodyEnd(Call call, long j3) {
            com.tencent.biz.richframework.download.v.k(this, call, j3);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestBodyStart(Call call) {
            com.tencent.biz.richframework.download.v.l(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestHeadersEnd(Call call, Request request) {
            com.tencent.biz.richframework.download.v.m(this, call, request);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestHeadersStart(Call call) {
            com.tencent.biz.richframework.download.v.n(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseBodyEnd(Call call, long j3) {
            com.tencent.biz.richframework.download.v.o(this, call, j3);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseBodyStart(Call call) {
            com.tencent.biz.richframework.download.v.p(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseHeadersEnd(Call call, Response response) {
            com.tencent.biz.richframework.download.v.q(this, call, response);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseHeadersStart(Call call) {
            com.tencent.biz.richframework.download.v.r(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void secureConnectEnd(Call call, Handshake handshake) {
            com.tencent.biz.richframework.download.v.s(this, call, handshake);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void secureConnectStart(Call call) {
            com.tencent.biz.richframework.download.v.t(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
        public void onDownloadProgress(float f16, long j3, long j16) {
        }
    }
}
