package com.tencent.biz.pubaccount.util.api.impl;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountH5ManagerImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.share.api.IShareReport;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoWebPreDownloadFactory;
import com.tencent.mobileqq.mp.mobileqq_mp$JSApiWebServerRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$JSApiWebServerResponse;
import com.tencent.mobileqq.mp.mobileqq_mp$RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.ao;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.InnerWebView;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import f62.d;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class PublicAccountH5AbilityPluginImpl extends WebViewPlugin implements IPublicAccountH5AbilityPlugin {
    public static final int CODE_QRCODE = 1;
    public static final String FILEPATH = "filepath";
    public static final String FROM_PUBH5 = "from_pub5";
    public static final String KEY_VIDEO_DIR = "video_dir";
    public static final String KEY_VIDEO_DURATION = "video_duration";
    public static final byte OPENCAMERA = 112;
    public static final byte OPENIMG = 111;
    public static final int PHOTO_CLIP_BANNER_H = 200;
    public static final int PHOTO_CLIP_BANNER_W = 360;
    public static final int PHOTO_CLIP_HEAD_SIZE = 360;
    public static final int PHOTO_CLIP_SIZE = 640;
    public static final int PHOTO_TAGGET_BANNER_W = 750;
    public static final int PHOTO_TARGET_BANNER_H = 416;
    public static final int PHOTO_TARGET_HEAD_SIZE = 160;
    static final int REFUSE_EVENT = 1000;
    static final String TAG = "PublicAccountH5AbilityPlugin";
    public static String appIdStr = null;
    static Map<String, ArrayList<String>> authorizedLists = null;
    static final boolean isAllowedToRecorder = false;
    static HashMap<String, String> localIdMap;
    static HashMap<Integer, String> map;
    static Map<String, ArrayList<String>> needAuthorizedLists;
    public static String playEndCallback;
    public static String playStartCallback;
    public static String recordStartCallback;
    public static String recordStopCallback;
    public static String selectAndTopicPicCallback;
    public static String selectAndUploadAvatarCallback;
    public static String voicePlayEndCallback;
    public static String voiceRecorderEndCallback;
    AppInterface app;
    String authCallback;
    String callback;
    ProgressDialog mPd;
    ActionSheet paActionSheet;
    PublicAccountH5AbilityPttImpl ptt;
    String uin;
    public int CMD_FOR_MEDIAID = 1281;
    public int CMD_FOR_UUID = 1282;
    int needResult = -1;
    int scanType = -1;
    com.tencent.biz.troop.b mClient = null;
    f62.d mVideoWebPreDownload = null;
    public int RET_CODE_FOR_READINJOY_VIDEO_SUCCESS = 0;
    public int RET_CODE_FOR_READINJOY_VIDEO_CANCEL = 1;
    public int RET_CODE_FOR_READINJOY_VIDEO_ERROR = -1;
    AtomicBoolean mInited = new AtomicBoolean(false);
    boolean refuseConfig = false;
    String pUin = "";
    private Handler mHandler = new f(Looper.getMainLooper());
    ArrayList<n> uploadBeensList = new ArrayList<>();
    ArrayList<m> downloadBeensList = new ArrayList<>();
    String cameraPath = "";
    String cameraCallback = "";
    String cameraUUid = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PublicAccountH5AbilityPluginImpl.this.paActionSheet.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements ITroopMemberApiClientApi.a {
        c() {
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            if (PublicAccountH5AbilityPluginImpl.this.getActivity() != null) {
                PublicAccountH5AbilityPluginImpl.this.showProgressDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e implements ITroopMemberApiClientApi.a {
        e() {
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            if (PublicAccountH5AbilityPluginImpl.this.getActivity() != null) {
                PublicAccountH5AbilityPluginImpl.this.showProgressDialog();
            }
        }
    }

    /* loaded from: classes32.dex */
    class f extends Handler {
        f(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1000) {
                return;
            }
            PublicAccountH5AbilityPluginImpl.this.refuseConfig = false;
        }
    }

    /* loaded from: classes32.dex */
    class g implements d.a {
        g() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class h implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f80230d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f80231e;

        h(boolean z16, String str) {
            this.f80230d = z16;
            this.f80231e = str;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            String optString;
            if (z16) {
                byte[] byteArray = bundle.getByteArray("data");
                if (byteArray != null) {
                    mobileqq_mp$JSApiWebServerResponse mobileqq_mp_jsapiwebserverresponse = new mobileqq_mp$JSApiWebServerResponse();
                    try {
                        try {
                            mobileqq_mp_jsapiwebserverresponse.mergeFrom(byteArray);
                            mobileqq_mp$RetInfo mobileqq_mp_retinfo = mobileqq_mp_jsapiwebserverresponse.ret_info.get();
                            String str = mobileqq_mp_jsapiwebserverresponse.body.get();
                            int i16 = mobileqq_mp_retinfo.ret_code.get();
                            String str2 = mobileqq_mp_retinfo.err_info.get();
                            new JSONObject();
                            if (i16 == 0) {
                                JSONObject jSONObject = new JSONObject(str);
                                int optInt = jSONObject.optInt("ret");
                                String optString2 = jSONObject.optString("msg");
                                if (optInt == 0) {
                                    String optString3 = jSONObject.optString("mediaid");
                                    int optInt2 = jSONObject.optInt("subcmd");
                                    int optInt3 = jSONObject.optInt("type");
                                    if (optInt3 == 2) {
                                        optString = jSONObject.optString("url");
                                    } else {
                                        optString = optInt3 == 4 ? jSONObject.optString(ShortVideoConstants.FILE_UUID) : "";
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.i(PublicAccountH5AbilityPluginImpl.TAG, 2, "sendUuidForMediaIdRequest mediaId = " + optString3 + " type=" + i3 + " serverId:" + optString + " subCom=" + optInt2);
                                    }
                                    JSONObject jSONObject2 = new JSONObject();
                                    try {
                                        if ("".equals(optString3)) {
                                            jSONObject2.put("retCode", -1);
                                            jSONObject2.put("msg", "uuid for mediaid error");
                                            if (this.f80230d) {
                                                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D27", "0X8005D27", 0, -1, "1", "", "", "", false);
                                            } else {
                                                ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D30", "0X8005D30", 0, -1, "1", "", "", "");
                                            }
                                        } else {
                                            jSONObject2.put("retCode", 0);
                                            jSONObject2.put("msg", HardCodeUtil.qqStr(R.string.f172330pm1) + optString3);
                                            if (this.f80230d) {
                                                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D27", "0X8005D27", 0, 0, "1", "", "", "", false);
                                            } else {
                                                ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D30", "0X8005D30", 0, 0, "1", "", "", "");
                                            }
                                        }
                                        jSONObject2.put("serverId", optString3);
                                    } catch (JSONException e16) {
                                        e16.printStackTrace();
                                    }
                                    PublicAccountH5AbilityPluginImpl.this.callJs(this.f80231e, jSONObject2.toString());
                                    return;
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.i(PublicAccountH5AbilityPluginImpl.TAG, 2, "sendUuidForMediaIdRequest errorMsg = " + optString2);
                                }
                                JSONObject jSONObject3 = new JSONObject();
                                try {
                                    jSONObject3.put("retCode", -1);
                                    jSONObject3.put("msg", "uuid for mediaid error");
                                } catch (JSONException e17) {
                                    e17.printStackTrace();
                                }
                                PublicAccountH5AbilityPluginImpl.this.callJs(this.f80231e, jSONObject3.toString());
                                if (this.f80230d) {
                                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D27", "0X8005D27", 0, -1, "1", "", "", "", false);
                                    return;
                                } else {
                                    ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D30", "0X8005D30", 0, -1, "1", "", "", "");
                                    return;
                                }
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i(PublicAccountH5AbilityPluginImpl.TAG, 2, "sendUuidForMediaIdRequest errorMsg = " + str2);
                            }
                            JSONObject jSONObject4 = new JSONObject();
                            try {
                                jSONObject4.put("retCode", -1);
                                jSONObject4.put("msg", "uuid for mediaid error");
                            } catch (JSONException e18) {
                                e18.printStackTrace();
                            }
                            PublicAccountH5AbilityPluginImpl.this.callJs(this.f80231e, jSONObject4.toString());
                            if (this.f80230d) {
                                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D27", "0X8005D27", 0, -1, "1", "", "", "", false);
                                return;
                            } else {
                                ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D30", "0X8005D30", 0, -1, "1", "", "", "");
                                return;
                            }
                        } catch (InvalidProtocolBufferMicroException e19) {
                            e19.printStackTrace();
                            return;
                        }
                    } catch (JSONException e26) {
                        e26.printStackTrace();
                        return;
                    }
                }
                return;
            }
            try {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("retCode", -1);
                jSONObject5.put("msg", "uuid for mediaid error");
                PublicAccountH5AbilityPluginImpl.this.callJs(this.f80231e, jSONObject5.toString());
                if (this.f80230d) {
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D27", "0X8005D27", 0, -1, "1", "", "", "", false);
                } else {
                    ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D30", "0X8005D30", 0, -1, "1", "", "", "");
                }
            } catch (JSONException e27) {
                e27.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class k implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f80240d;

        k(String str) {
            this.f80240d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PublicAccountH5AbilityPluginImpl.this.takePicture();
            PublicAccountH5AbilityPluginImpl publicAccountH5AbilityPluginImpl = PublicAccountH5AbilityPluginImpl.this;
            publicAccountH5AbilityPluginImpl.cameraCallback = this.f80240d;
            publicAccountH5AbilityPluginImpl.paActionSheet.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class l implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f80242d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f80243e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f80244f;

        l(int i3, int i16, String str) {
            this.f80242d = i3;
            this.f80243e = i16;
            this.f80244f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PublicAccountH5AbilityPluginImpl.this.choosePicture(this.f80242d, this.f80243e);
            PublicAccountH5AbilityPluginImpl publicAccountH5AbilityPluginImpl = PublicAccountH5AbilityPluginImpl.this;
            publicAccountH5AbilityPluginImpl.cameraCallback = this.f80244f;
            publicAccountH5AbilityPluginImpl.paActionSheet.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public static class m {

        /* renamed from: a, reason: collision with root package name */
        String f80246a;

        /* renamed from: b, reason: collision with root package name */
        String f80247b;

        /* renamed from: c, reason: collision with root package name */
        int f80248c;

        m() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public static class n {

        /* renamed from: a, reason: collision with root package name */
        String f80249a;

        /* renamed from: b, reason: collision with root package name */
        String f80250b;

        /* renamed from: c, reason: collision with root package name */
        int f80251c;

        n() {
        }
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        map = hashMap;
        hashMap.put(0, "publicAccountNew.getPicture");
        map.put(1, "troopNotice.showPicture");
        map.put(2, "qbizApi.getNetworkType");
        map.put(3, "ui.closeWebViews");
        map.put(4, "ui.setOnShareQQFriendHandler");
        map.put(5, "ui.setOnShareQZoneHandler");
        map.put(6, "ui.setOnShareWXFriendHandler");
        map.put(7, "ui.setOnShareWXTimelineHandler");
        map.put(8, "publicAccount.getLocation");
        map.put(10, "publicAccountNew.hideMenuItems");
        map.put(11, "publicAccountNew.showMenuItems");
        map.put(12, "publicAccountNew.hideAllNonBaseMenuItem");
        map.put(13, "publicAccountNew.showAllNonBaseMenuItem");
        map.put(14, "publicAccountNew.showWebPanel");
        map.put(15, "publicAccountNew.scanQRCode");
        map.put(16, "publicAccountNew.setRightButtonState");
        map.put(17, "publicAccountNew.uploadImage");
        map.put(18, "publicAccountNew.downloadImage");
        map.put(20, "publicAccountNew.hideWebToolbar");
        map.put(21, "publicAccountNew.showWebToolbar");
        map.put(30, "wallet.publicPay");
        map.put(40, "publicAccountNew.startRecord");
        map.put(41, "publicAccountNew.stopRecord");
        map.put(42, "publicAccountNew.playVoice");
        map.put(43, "publicAccountNew.pauseVoice");
        map.put(44, "publicAccountNew.stopVoice");
        map.put(45, "publicAccountNew.uploadVoice");
        map.put(46, "publicAccountNew.downloadVoice");
        map.put(47, "publicAccountNew.onVoiceRecordEnd");
        map.put(48, "publicAccountNew.onVoicePlayEnd");
        map.put(49, "publicAccountNew.selectAndUploadAvatar");
        map.put(50, "publicAccountNew.addPreDownloadVideo");
        map.put(51, "publicAccountNew.stopPreDownloadVideo");
        authorizedLists = new HashMap();
        needAuthorizedLists = new HashMap();
        localIdMap = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getActivity() {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null) {
            return null;
        }
        return bVar.a();
    }

    private Context getContext() {
        Activity activity = getActivity();
        return activity == null ? MobileQQ.sMobileQQ.getApplicationContext() : activity;
    }

    private void sharePictureToWeChat(final String str) {
        final Bundle bundle = new Bundle();
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        String cookie = cookieManager.getCookie(str);
        if (cookie != null) {
            bundle.putString("Cookie", cookie);
        }
        if (!NetworkUtil.isNetworkAvailable(this.mRuntime.a())) {
            com.tencent.biz.qrcode.util.h.T(1, R.string.bqf);
            return;
        }
        final QQProgressDialog qQProgressDialog = new QQProgressDialog(this.mRuntime.a());
        qQProgressDialog.setMessage(R.string.c7z);
        qQProgressDialog.show();
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.15
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                String e16 = com.tencent.biz.common.util.e.e(PublicAccountH5AbilityPluginImpl.this.mRuntime.a(), str, bundle);
                QQProgressDialog qQProgressDialog2 = qQProgressDialog;
                if (qQProgressDialog2 != null && qQProgressDialog2.isShowing()) {
                    PublicAccountH5AbilityPluginImpl.this.mHandler.post(new Runnable() { // from class: com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            qQProgressDialog.dismiss();
                        }
                    });
                    if (!TextUtils.isEmpty(e16)) {
                        try {
                            Bitmap decodeFile = BitmapFactory.decodeFile(e16);
                            if (WXShareHelper.b0().e0()) {
                                i3 = !WXShareHelper.b0().f0() ? R.string.f173258ih2 : -1;
                            } else {
                                i3 = R.string.f173257ih1;
                            }
                            if (i3 != -1) {
                                com.tencent.biz.qrcode.util.h.T(0, i3);
                                Intent intent = new Intent(PublicAccountH5AbilityPluginImpl.this.mRuntime.a(), (Class<?>) PublicAccountBrowserImpl.class);
                                intent.putExtra("url", "https://weixin.qq.com/download");
                                PublicAccountH5AbilityPluginImpl.this.mRuntime.a().startActivity(intent);
                                return;
                            }
                            WXShareHelper.b0().w0(e16, decodeFile, 1, true);
                            return;
                        } catch (OutOfMemoryError e17) {
                            e17.printStackTrace();
                            return;
                        }
                    }
                    com.tencent.biz.qrcode.util.h.T(1, R.string.d6u);
                }
            }
        });
    }

    private void showPicture(String str) {
        PublicAccountShowPictureReport publicAccountShowPictureReport;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("imageIDs");
            int optInt = jSONObject.optInt("index");
            String optString = jSONObject.optString("srcID");
            boolean optBoolean = jSONObject.optBoolean("isNotShowIndex", true);
            boolean optBoolean2 = jSONObject.optBoolean("showTitle", false);
            String str2 = new String(PluginBaseInfoHelper.Base64Helper.decode(jSONObject.optString("title", ""), 0));
            String optString2 = jSONObject.optString("articleUrl", "");
            Boolean valueOf = Boolean.valueOf(jSONObject.optBoolean("isReport", false));
            long optLong = jSONObject.optLong("touin");
            long optLong2 = jSONObject.optLong("feeds_id");
            jSONObject.optInt("feeds_type");
            long optLong3 = jSONObject.optLong("articleId");
            jSONObject.optInt("source");
            if (optJSONArray != null) {
                optJSONArray.length();
            }
            if (valueOf.booleanValue()) {
                publicAccountShowPictureReport = new PublicAccountShowPictureReport();
                publicAccountShowPictureReport.parse(jSONObject);
            } else {
                publicAccountShowPictureReport = null;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "KANDIAN Grid Image title: ", str2, ", articleUrl: ", optString2, ", showTitle: ", Boolean.valueOf(optBoolean2));
            }
            if (optJSONArray != null && optJSONArray.length() != 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    arrayList.add(optJSONArray.get(i3).toString());
                }
                Activity activity = getActivity();
                if (activity != null) {
                    Intent intent = new Intent(activity, (Class<?>) TroopAvatarWallPreviewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("index", optInt);
                    bundle.putStringArrayList(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, arrayList);
                    bundle.putBoolean("needBottomBar", false);
                    bundle.putBoolean("IS_EDIT", false);
                    bundle.putBoolean("is_use_path", true);
                    bundle.putBoolean("is_show_action", true);
                    bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_IS_NOT_SHOW_INDEX, optBoolean);
                    bundle.putBoolean("is_grid_image_report", true);
                    bundle.putString("to_uin", Long.toString(optLong));
                    bundle.putString("feeds_id", Long.toString(optLong2));
                    bundle.putString(AppConstants.Key.SHARE_REQ_ARTICLE_ID, Long.toString(optLong3));
                    bundle.putString("scroll_image_r5", "");
                    bundle.putString("read_article_r5", "");
                    if (!TextUtils.isEmpty(optString)) {
                        bundle.putString("src_id", optString);
                    }
                    if (optBoolean2 && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(optString2)) {
                        bundle.putBoolean("is_show_content_url", true);
                        bundle.putString("article_url", optString2);
                        bundle.putString("article_title", str2);
                    }
                    if (publicAccountShowPictureReport != null && publicAccountShowPictureReport.isReport) {
                        bundle.putString("PublicAccountShowPictureReport", publicAccountShowPictureReport.toString());
                    }
                    intent.putExtras(bundle);
                    activity.startActivityForResult(intent, 100);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "imageList is null or length is 0");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void cancleAllUploadAndDownloadTask() {
        com.tencent.biz.troop.b bVar = this.mClient;
        if (bVar != null) {
            bVar.j();
        }
        this.uploadBeensList.clear();
        this.downloadBeensList.clear();
        this.cameraPath = "";
        this.cameraCallback = "";
        this.cameraUUid = "";
    }

    void cancleProgressDailog() {
        ProgressDialog progressDialog = this.mPd;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.mPd.cancel();
    }

    public void choosePicture(int i3, int i16) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(getContext(), IPhotoLogicFactory.PHOTO_LIST_ACTIVITY_URI);
        activityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", i3);
        activityURIRequest.extra().putString(QAlbumConstants.CUSTOM_SENDBTN_TEXT, HardCodeUtil.qqStr(R.string.ket));
        if (i16 == 1) {
            activityURIRequest.extra().putInt(QAlbumConstants.CURRENT_QUALITY_TYPE, 2);
        } else if (i16 == 2) {
            activityURIRequest.extra().putInt(QAlbumConstants.CURRENT_QUALITY_TYPE, 0);
        }
        if (i16 == 0) {
            activityURIRequest.extra().putBoolean(PeakConstants.ALBUM_SHOW_ORI_BUTTON, true);
            activityURIRequest.extra().putBoolean(PeakConstants.IS_SHOW_QUALITY_COUNT_TV, true);
        } else {
            activityURIRequest.extra().putBoolean(PeakConstants.ALBUM_SHOW_ORI_BUTTON, false);
            activityURIRequest.extra().putBoolean(PeakConstants.IS_SHOW_QUALITY_COUNT_TV, false);
        }
        activityURIRequest.extra().putBoolean(PeakConstants.IS_FINISH_RESTART_INIT_ACTIVITY, true);
        Activity activity = getActivity();
        if (activity != null) {
            activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", activity.getClass().getName());
        }
        activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        activityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_MODE", false);
        if (this.mRuntime.f() != null) {
            ao.d(this, activityURIRequest, OPENIMG, this.mRuntime.f());
        }
    }

    void cleanConfig(String str) {
        this.pUin = "";
        if (str != null) {
            authorizedLists.remove(str);
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin
    public void downloadShortVideoFilterSo() {
        if (this.mClient == null) {
            this.mClient = com.tencent.biz.troop.b.A();
        }
        this.mClient.r();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return IPublicAccountH5AbilityPlugin.PACKAGE_NAME;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin
    public WebViewPlugin.b getRuntime() {
        return this.mRuntime;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin
    public String getUserInfoFailStr(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("retCode", -1);
            jSONObject.putOpt("retMsg", str);
        } catch (JSONException e16) {
            QLog.d(TAG, 1, e16.getMessage());
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:327:0x074d  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x074f A[Catch: JSONException -> 0x0782, TryCatch #2 {JSONException -> 0x0782, blocks: (B:311:0x06e7, B:315:0x0702, B:317:0x0712, B:319:0x0719, B:323:0x0738, B:325:0x073f, B:328:0x075c, B:331:0x074f, B:335:0x0729), top: B:310:0x06e7 }] */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewProvider f16;
        ElasticHorScrView elasticHorScrView;
        AppInterface appInterface;
        String optString;
        int i3;
        int i16;
        String optString2;
        if (!IPublicAccountH5AbilityPlugin.PACKAGE_NAME.endsWith(str2)) {
            return false;
        }
        if ("openLocation".endsWith(str3)) {
            if (strArr != null && strArr.length > 0) {
                try {
                    String optString3 = new JSONObject(strArr[0]).optString("callback");
                    if (!TextUtils.isEmpty(optString3)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("retCode", 0);
                        jSONObject.put("msg", "Success");
                        callJs(optString3, jSONObject.toString());
                    }
                    openLocation();
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005869", "0X8005869", 0, 0, "", "", "", "");
            return true;
        }
        if ("showOfficialAccountProfile".endsWith(str3)) {
            if (strArr != null && strArr.length > 0) {
                try {
                    String optString4 = new JSONObject(strArr[0]).optString("uin");
                    if (!"".equals(optString4)) {
                        showOfficialAccountProfile(optString4);
                    }
                } catch (JSONException e17) {
                    e17.printStackTrace();
                }
            }
            return true;
        }
        if ("showWebPanel".endsWith(str3)) {
            if (strArr != null && strArr.length > 0) {
                try {
                    String optString5 = new JSONObject(strArr[0]).optString("callback");
                    if (!TextUtils.isEmpty(optString5)) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("retCode", 0);
                        jSONObject2.put("msg", "Success");
                        callJs(optString5, jSONObject2.toString());
                    }
                    showWebPanel();
                } catch (JSONException e18) {
                    e18.printStackTrace();
                }
            }
            return true;
        }
        if ("setRightButtonState".endsWith(str3)) {
            if (strArr != null && strArr.length > 0) {
                try {
                    JSONObject jSONObject3 = new JSONObject(strArr[0]);
                    boolean optBoolean = jSONObject3.optBoolean("hidden");
                    String optString6 = jSONObject3.optString("callback");
                    if (!TextUtils.isEmpty(optString6)) {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("retCode", 0);
                        jSONObject4.put("msg", "Success");
                        callJs(optString6, jSONObject4.toString());
                    }
                    setRightButtonState(optBoolean);
                } catch (JSONException e19) {
                    e19.printStackTrace();
                }
            }
            return true;
        }
        if (InnerWebView.API_HIDE_MENU_ITEMS.endsWith(str3)) {
            if (strArr != null && strArr.length > 0) {
                try {
                    JSONObject jSONObject5 = new JSONObject(strArr[0]);
                    String optString7 = jSONObject5.optString("callback");
                    JSONArray optJSONArray = jSONObject5.optJSONArray("menuList");
                    ArrayList<String> arrayList = new ArrayList<>();
                    if (optJSONArray != null) {
                        for (int i17 = 0; i17 < optJSONArray.length(); i17++) {
                            arrayList.add(optJSONArray.optString(i17));
                        }
                    }
                    if (!TextUtils.isEmpty(optString7)) {
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject6.put("retCode", 0);
                        jSONObject6.put("msg", "Success");
                        callJs(optString7, jSONObject6.toString());
                    }
                    hideMenuItems(arrayList);
                } catch (JSONException e26) {
                    e26.printStackTrace();
                }
            }
            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X800586E", "0X800586E", 0, 0, "", "", "", "");
            return true;
        }
        if (InnerWebView.API_SHOW_MENU_ITEMS.endsWith(str3)) {
            if (strArr != null && strArr.length > 0) {
                try {
                    JSONObject jSONObject7 = new JSONObject(strArr[0]);
                    String optString8 = jSONObject7.optString("callback");
                    JSONArray optJSONArray2 = jSONObject7.optJSONArray("menuList");
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    if (optJSONArray2 != null) {
                        for (int i18 = 0; i18 < optJSONArray2.length(); i18++) {
                            arrayList2.add(optJSONArray2.optString(i18));
                        }
                    }
                    if (!TextUtils.isEmpty(optString8)) {
                        JSONObject jSONObject8 = new JSONObject();
                        jSONObject8.put("retCode", 0);
                        jSONObject8.put("msg", "Success");
                        callJs(optString8, jSONObject8.toString());
                    }
                    showMenuItems(arrayList2);
                } catch (JSONException e27) {
                    e27.printStackTrace();
                }
            }
            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X800586F", "0X800586F", 0, 0, "", "", "", "");
            return true;
        }
        if (InnerWebView.API_HIDE_ALL_NONBASE_MENU_ITEM.endsWith(str3)) {
            if (strArr != null && strArr.length > 0) {
                try {
                    String optString9 = new JSONObject(strArr[0]).optString("callback");
                    if (!TextUtils.isEmpty(optString9)) {
                        JSONObject jSONObject9 = new JSONObject();
                        jSONObject9.put("retCode", 0);
                        jSONObject9.put("msg", "Success");
                        callJs(optString9, jSONObject9.toString());
                    }
                    hideAllNonBaseMenuItem();
                } catch (JSONException e28) {
                    e28.printStackTrace();
                }
            }
            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005870", "0X8005870", 0, 0, "", "", "", "");
            return true;
        }
        if (InnerWebView.API_SHOW_ALL_NONBASE_MENU_ITEM.endsWith(str3)) {
            if (strArr != null && strArr.length > 0) {
                try {
                    String optString10 = new JSONObject(strArr[0]).optString("callback");
                    if (!TextUtils.isEmpty(optString10)) {
                        JSONObject jSONObject10 = new JSONObject();
                        jSONObject10.put("retCode", 0);
                        jSONObject10.put("msg", "Success");
                        callJs(optString10, jSONObject10.toString());
                    }
                    showAllNonBaseMenuItem();
                } catch (JSONException e29) {
                    e29.printStackTrace();
                }
            }
            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005871", "0X8005871", 0, 0, "", "", "", "");
            return true;
        }
        if ("showWebToolbar".endsWith(str3)) {
            if (strArr != null && strArr.length > 0) {
                try {
                    String optString11 = new JSONObject(strArr[0]).optString("callback");
                    if (!TextUtils.isEmpty(optString11)) {
                        JSONObject jSONObject11 = new JSONObject();
                        jSONObject11.put("retCode", 0);
                        jSONObject11.put("msg", "Success");
                        callJs(optString11, jSONObject11.toString());
                    }
                    showWebToolbar();
                } catch (JSONException e36) {
                    e36.printStackTrace();
                }
            }
            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005898", "0X8005898", 0, 0, "", "", "", "");
            return true;
        }
        if ("hideWebToolbar".endsWith(str3)) {
            if (strArr != null && strArr.length > 0) {
                try {
                    String optString12 = new JSONObject(strArr[0]).optString("callback");
                    if (!TextUtils.isEmpty(optString12)) {
                        JSONObject jSONObject12 = new JSONObject();
                        jSONObject12.put("retCode", 0);
                        jSONObject12.put("msg", "Success");
                        callJs(optString12, jSONObject12.toString());
                    }
                    hideWebToolbar();
                } catch (JSONException e37) {
                    e37.printStackTrace();
                }
            }
            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005897", "0X8005897", 0, 0, "", "", "", "");
            return true;
        }
        if (InnerWebView.API_UPLOAD_IMAGE.endsWith(str3)) {
            if (strArr != null && strArr.length > 0) {
                try {
                    JSONObject jSONObject13 = new JSONObject(strArr[0]);
                    String optString13 = jSONObject13.optString("callback");
                    String optString14 = jSONObject13.optString("localId");
                    int optInt = jSONObject13.optInt("isShowProgressTips", 1);
                    String str4 = localIdMap.get(optString14);
                    File file = new File(str4);
                    if (!file.exists()) {
                        QQToast.makeText(getContext(), HardCodeUtil.qqStr(R.string.f172333pm4) + str4, 0).show();
                        return true;
                    }
                    if (file.length() > 2097152) {
                        QQToast.makeText(getContext(), "\u8bf7\u9009\u62e9\u5c0f\u4e8e2M\u6587\u4ef6" + str4, 0).show();
                        return true;
                    }
                    Iterator<n> it = this.uploadBeensList.iterator();
                    while (it.hasNext()) {
                        n next = it.next();
                        if (optString14 != null && optString14.equals(next.f80250b)) {
                            QQToast.makeText(getContext(), HardCodeUtil.qqStr(R.string.pmm), 0).show();
                            return true;
                        }
                    }
                    n nVar = new n();
                    nVar.f80249a = optString13;
                    nVar.f80250b = optString14;
                    nVar.f80251c = optInt;
                    this.uploadBeensList.add(nVar);
                    if (this.uploadBeensList.size() != 1) {
                        return true;
                    }
                    startUpload(optInt, str4, true, optString13);
                } catch (JSONException e38) {
                    e38.printStackTrace();
                }
            }
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D27", "0X8005D27", 0, 2, "1", "", "", "", false);
            return true;
        }
        if (InnerWebView.API_DOWNLOAD_IMAGE.endsWith(str3)) {
            if (strArr != null && strArr.length > 0) {
                try {
                    JSONObject jSONObject14 = new JSONObject(strArr[0]);
                    String optString15 = jSONObject14.optString("callback");
                    String optString16 = jSONObject14.optString("serverId");
                    int optInt2 = jSONObject14.optInt("isShowProgressTips", 1);
                    if (!"".equals(optString15) && !"".equals(optString16)) {
                        Iterator<m> it5 = this.downloadBeensList.iterator();
                        while (it5.hasNext()) {
                            m next2 = it5.next();
                            if (optString16 != null && optString16.equals(next2.f80247b)) {
                                QQToast.makeText(getContext(), HardCodeUtil.qqStr(R.string.plu), 0).show();
                                return true;
                            }
                        }
                        m mVar = new m();
                        mVar.f80246a = optString15;
                        mVar.f80247b = optString16;
                        mVar.f80248c = optInt2;
                        this.downloadBeensList.add(mVar);
                        if (this.downloadBeensList.size() != 1) {
                            return true;
                        }
                        sendMediaIdForUuidRequest(optString16, optInt2, true, optString15);
                    }
                    QQToast.makeText(getContext(), "callback or mediaId is null", 0).show();
                    return true;
                } catch (JSONException e39) {
                    e39.printStackTrace();
                }
            }
            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D28", "0X8005D28", 0, 2, "1", "", "", "");
            return true;
        }
        if (InnerWebView.API_UPLOAD_VOICE.endsWith(str3)) {
            if (strArr == null || strArr.length <= 0) {
                return true;
            }
            try {
                JSONObject jSONObject15 = new JSONObject(strArr[0]);
                String optString17 = jSONObject15.optString("callback");
                String optString18 = jSONObject15.optString("localId");
                int optInt3 = jSONObject15.optInt("isShowProgressTips", 1);
                if (TextUtils.isEmpty(optString18)) {
                    try {
                        JSONObject jSONObject16 = new JSONObject();
                        jSONObject16.put("retCode", -1);
                        jSONObject16.put("msg", "file not exists");
                        callJs(optString17, jSONObject16.toString());
                    } catch (JSONException e46) {
                        e46.printStackTrace();
                    }
                    ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D30", "0X8005D30", 0, 2, "1", "", "", "");
                    return true;
                }
                if (this.ptt == null) {
                    this.ptt = new PublicAccountH5AbilityPttImpl(this.uin, this.mRuntime);
                }
                String localPathFromIdForPtt = this.ptt.getLocalPathFromIdForPtt(optString18);
                File file2 = new File(localPathFromIdForPtt);
                if (!file2.exists()) {
                    JSONObject jSONObject17 = new JSONObject();
                    try {
                        jSONObject17.put("retCode", -1);
                        jSONObject17.put("msg", "file not exists");
                        callJs(optString17, jSONObject17.toString());
                    } catch (JSONException e47) {
                        e47.printStackTrace();
                    }
                    ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D30", "0X8005D30", 0, 2, "1", "", "", "");
                    return true;
                }
                if (file2.length() > 5242880) {
                    JSONObject jSONObject18 = new JSONObject();
                    try {
                        jSONObject18.put("retCode", -1);
                        jSONObject18.put("msg", "\u8bf7\u4e0a\u4f205MB\u4ee5\u5185\u7684\u97f3\u9891");
                    } catch (JSONException e48) {
                        e48.printStackTrace();
                    }
                    callJs(optString17, jSONObject18.toString());
                } else {
                    startUpload(optInt3, localPathFromIdForPtt, false, optString17);
                }
                ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D30", "0X8005D30", 0, 2, "1", "", "", "");
                return true;
            } catch (JSONException e49) {
                e49.printStackTrace();
                return true;
            }
            e49.printStackTrace();
            return true;
        }
        if (InnerWebView.API_DOWNLOAD_VOICE.endsWith(str3)) {
            if (strArr == null || strArr.length <= 0) {
                return true;
            }
            try {
                JSONObject jSONObject19 = new JSONObject(strArr[0]);
                String optString19 = jSONObject19.optString("callback");
                String optString20 = jSONObject19.optString("serverId");
                int optInt4 = jSONObject19.optInt("isShowProgressTips", 1);
                if (TextUtils.isEmpty(optString20)) {
                    try {
                        JSONObject jSONObject20 = new JSONObject();
                        jSONObject20.put("retCode", -1);
                        jSONObject20.put("msg", "invalid serverId");
                        callJs(optString19, jSONObject20.toString());
                    } catch (JSONException e56) {
                        e56.printStackTrace();
                    }
                } else {
                    sendMediaIdForUuidRequest(optString20, optInt4, false, optString19);
                }
                ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D31", "0X8005D31", 0, 2, "1", "", "", "");
                return true;
            } catch (JSONException e57) {
                e57.printStackTrace();
                return true;
            }
        }
        if (QZoneJsConstants.METHOD_QZONE_SELECT_GET_PICTURE.endsWith(str3)) {
            if (strArr == null || strArr.length <= 0) {
                return true;
            }
            try {
                JSONObject jSONObject21 = new JSONObject(strArr[0]);
                String optString21 = jSONObject21.optString("callback");
                int optInt5 = jSONObject21.optInt("count");
                if (optInt5 > 9 || optInt5 < 1) {
                    optInt5 = 9;
                }
                JSONArray optJSONArray3 = jSONObject21.optJSONArray("sizeType");
                JSONArray optJSONArray4 = jSONObject21.optJSONArray("sourceType");
                if (optJSONArray4 != null && optJSONArray4.length() == 1) {
                    String optString22 = optJSONArray4.optString(0);
                    if ("camera".equalsIgnoreCase(optString22)) {
                        i3 = 1;
                    } else if ("album".equalsIgnoreCase(optString22)) {
                        i3 = 2;
                    }
                    if (optJSONArray3 != null && optJSONArray3.length() == 1) {
                        optString2 = optJSONArray3.optString(0);
                        if (!"original".equalsIgnoreCase(optString2)) {
                            i16 = 1;
                        } else if ("compressed".equalsIgnoreCase(optString2)) {
                            i16 = 2;
                        }
                        showPAactionSheet(i3, i16, optString21, optInt5);
                        ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005895", "0X8005895", 0, 2, "1", "", "", "");
                        return true;
                    }
                    i16 = 0;
                    showPAactionSheet(i3, i16, optString21, optInt5);
                    ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005895", "0X8005895", 0, 2, "1", "", "", "");
                    return true;
                }
                i3 = 0;
                if (optJSONArray3 != null) {
                    optString2 = optJSONArray3.optString(0);
                    if (!"original".equalsIgnoreCase(optString2)) {
                    }
                    showPAactionSheet(i3, i16, optString21, optInt5);
                    ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005895", "0X8005895", 0, 2, "1", "", "", "");
                    return true;
                }
                i16 = 0;
                showPAactionSheet(i3, i16, optString21, optInt5);
                ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005895", "0X8005895", 0, 2, "1", "", "", "");
                return true;
            } catch (JSONException e58) {
                e58.printStackTrace();
                return true;
            }
        }
        if ("startRecord".endsWith(str3)) {
            if (strArr == null || strArr.length <= 0) {
                return true;
            }
            try {
                String optString23 = new JSONObject(strArr[0]).optString("callback");
                recordStartCallback = optString23;
                if (!TextUtils.isEmpty(optString23)) {
                    if (this.ptt == null) {
                        this.ptt = new PublicAccountH5AbilityPttImpl(this.uin, this.mRuntime);
                    }
                    this.ptt.startRecord();
                }
                ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D29", "0X8005D29", 0, 2, "1", "", "", "");
                return true;
            } catch (JSONException e59) {
                e59.printStackTrace();
                return true;
            }
        }
        if ("stopRecord".endsWith(str3)) {
            if (strArr == null || strArr.length <= 0) {
                return true;
            }
            try {
                recordStopCallback = new JSONObject(strArr[0]).optString("callback");
                PublicAccountH5AbilityPttImpl publicAccountH5AbilityPttImpl = this.ptt;
                if (publicAccountH5AbilityPttImpl != null && publicAccountH5AbilityPttImpl.isRecorderRecording()) {
                    this.ptt.stopRecord();
                } else {
                    try {
                        JSONObject jSONObject22 = new JSONObject();
                        jSONObject22.put("retCode", -1);
                        jSONObject22.put("msg", "fail");
                        callJs(recordStopCallback, jSONObject22.toString());
                    } catch (JSONException e65) {
                        e65.printStackTrace();
                    }
                }
                ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D2A", "0X8005D2A", 0, 2, "1", "", "", "");
                return true;
            } catch (JSONException e66) {
                e66.printStackTrace();
                return true;
            }
        }
        if ("playVoice".endsWith(str3)) {
            if (strArr == null || strArr.length <= 0) {
                return true;
            }
            try {
                JSONObject jSONObject23 = new JSONObject(strArr[0]);
                playStartCallback = jSONObject23.optString("callback");
                optString = jSONObject23.optString("localId");
            } catch (JSONException e67) {
                e67.printStackTrace();
                return true;
            }
            if (!TextUtils.isEmpty(playStartCallback)) {
                if (!TextUtils.isEmpty(optString)) {
                    PublicAccountH5AbilityPttImpl publicAccountH5AbilityPttImpl2 = this.ptt;
                    if (publicAccountH5AbilityPttImpl2 != null && publicAccountH5AbilityPttImpl2.isPlaying()) {
                        return true;
                    }
                    if (this.ptt == null) {
                        this.ptt = new PublicAccountH5AbilityPttImpl(this.uin, this.mRuntime);
                    }
                    String localPathFromIdForPtt2 = this.ptt.getLocalPathFromIdForPtt(optString);
                    JSONObject jSONObject24 = new JSONObject();
                    if (new File(localPathFromIdForPtt2).exists()) {
                        this.ptt.playVoice(localPathFromIdForPtt2);
                        try {
                            jSONObject24.put("retCode", 0);
                            jSONObject24.put("msg", "success");
                        } catch (JSONException e68) {
                            e68.printStackTrace();
                        }
                        ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D2C", "0X8005D2C", 0, 0, "1", "", "", "");
                        callJs(playStartCallback, jSONObject24.toString());
                    } else {
                        try {
                            jSONObject24.put("retCode", -1);
                            jSONObject24.put("msg", "file not exists");
                        } catch (JSONException e69) {
                            e69.printStackTrace();
                        }
                        ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D2C", "0X8005D2C", 0, -1, "1", "", "", "");
                        callJs(playStartCallback, jSONObject24.toString());
                    }
                } else {
                    JSONObject jSONObject25 = new JSONObject();
                    try {
                        jSONObject25.put("retCode", -1);
                        jSONObject25.put("msg", "missing arguments");
                        callJs(playStartCallback, jSONObject25.toString());
                    } catch (JSONException e75) {
                        e75.printStackTrace();
                    }
                }
                e67.printStackTrace();
                return true;
            }
            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D2C", "0X8005D2C", 0, 2, "1", "", "", "");
            return true;
        }
        if ("pauseVoice".endsWith(str3)) {
            if (strArr == null || strArr.length <= 0) {
                return true;
            }
            try {
                JSONObject jSONObject26 = new JSONObject(strArr[0]);
                String optString24 = jSONObject26.optString("callback");
                String optString25 = jSONObject26.optString("localId");
                if (!TextUtils.isEmpty(optString25)) {
                    if (this.ptt == null) {
                        this.ptt = new PublicAccountH5AbilityPttImpl(this.uin, this.mRuntime);
                    }
                    this.ptt.getLocalPathFromIdForPtt(optString25);
                    if (this.ptt.isPlaying()) {
                        this.ptt.pauseVoice();
                        JSONObject jSONObject27 = new JSONObject();
                        try {
                            jSONObject27.put("retCode", 0);
                            jSONObject27.put("msg", "success");
                            callJs(optString24, jSONObject27.toString());
                        } catch (JSONException e76) {
                            e76.printStackTrace();
                        }
                        ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D2D", "0X8005D2D", 0, 0, "1", "", "", "");
                    }
                }
                ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D2D", "0X8005D2D", 0, 2, "1", "", "", "");
                return true;
            } catch (JSONException e77) {
                e77.printStackTrace();
                return true;
            }
        }
        if ("stopVoice".endsWith(str3)) {
            if (strArr == null || strArr.length <= 0) {
                return true;
            }
            try {
                JSONObject jSONObject28 = new JSONObject(strArr[0]);
                playEndCallback = jSONObject28.optString("callback");
                String optString26 = jSONObject28.optString("localId");
                if (!TextUtils.isEmpty(optString26)) {
                    if (this.ptt == null) {
                        this.ptt = new PublicAccountH5AbilityPttImpl(this.uin, this.mRuntime);
                    }
                    this.ptt.getLocalPathFromIdForPtt(optString26);
                    this.ptt.stopVoice();
                    ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D2E", "0X8005D2E", 0, 0, "1", "", "", "");
                }
                ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D2E", "0X8005D2E", 0, 2, "1", "", "", "");
                return true;
            } catch (JSONException e78) {
                e78.printStackTrace();
                return true;
            }
        }
        if ("onVoiceRecordEnd".endsWith(str3)) {
            if (strArr == null || strArr.length <= 0) {
                return true;
            }
            try {
                voiceRecorderEndCallback = new JSONObject(strArr[0]).optString("callback");
                return true;
            } catch (JSONException e79) {
                e79.printStackTrace();
                return true;
            }
        }
        if ("onVoicePlayEnd".endsWith(str3)) {
            if (strArr == null || strArr.length <= 0) {
                return true;
            }
            try {
                voicePlayEndCallback = new JSONObject(strArr[0]).optString("callback");
                return true;
            } catch (JSONException e85) {
                e85.printStackTrace();
                return true;
            }
        }
        if ("selectAndUploadAvatar".endsWith(str3) || "uploadTopicPic".endsWith(str3)) {
            return true;
        }
        if (DownloadInfo.spKey_Config.endsWith(str3)) {
            if (this.refuseConfig) {
                return true;
            }
            if (strArr != null && strArr.length > 0) {
                try {
                    JSONObject jSONObject29 = new JSONObject(strArr[0]);
                    appIdStr = jSONObject29.optString("appId");
                    jSONObject29.put("appver", AppSetting.f99551k);
                    CustomWebView e86 = this.mRuntime.e();
                    String url = e86 != null ? e86.getUrl() : null;
                    jSONObject29.put("url", url);
                    String jSONObject30 = jSONObject29.toString();
                    this.authCallback = jSONObject29.optString("callback");
                    JSONArray optJSONArray5 = jSONObject29.optJSONArray("jsApiList");
                    ArrayList<String> arrayList3 = new ArrayList<>();
                    if (optJSONArray5 != null) {
                        arrayList3.clear();
                        for (int i19 = 0; i19 < optJSONArray5.length(); i19++) {
                            arrayList3.add(optJSONArray5.optString(i19));
                        }
                    }
                    authorizedLists.remove(url);
                    needAuthorizedLists.put(url, arrayList3);
                    if (url == null) {
                        return true;
                    }
                    sendAuthRequest(url, jSONObject30);
                    return true;
                } catch (JSONException e87) {
                    e87.printStackTrace();
                }
            }
        } else if ("isEnabledRightButton".endsWith(str3)) {
            try {
                JSONObject jSONObject31 = new JSONObject(strArr[0]);
                String optString27 = jSONObject31.optString("callback");
                int optInt6 = jSONObject31.optInt("status");
                WebViewFragment webViewFragment = (WebViewFragment) this.mRuntime.f();
                if (webViewFragment != null && webViewFragment.getUIStyleHandler() != null && webViewFragment.getUIStyleHandler().C != null) {
                    webViewFragment.getUIStyleHandler().C.K(optInt6);
                }
                JSONObject jSONObject32 = new JSONObject();
                jSONObject32.put("retCode", 0);
                callJs(optString27, jSONObject32.toString());
            } catch (JSONException e88) {
                e88.printStackTrace();
            }
        } else {
            if ("reportpreloaddata".endsWith(str3)) {
                if (strArr == null || strArr.length <= 0) {
                    return true;
                }
                try {
                    JSONObject jSONObject33 = new JSONObject(strArr[0]);
                    String optString28 = jSONObject33.optString("callback");
                    String optString29 = jSONObject33.optString("url");
                    if (TextUtils.isEmpty(optString28) || TextUtils.isEmpty(optString29)) {
                        return true;
                    }
                    JSONObject jSONObject34 = new JSONObject();
                    jSONObject34.put("retCode", 0);
                    jSONObject34.put("msg", "Success");
                    String q16 = PreloadManager.q(optString29);
                    jSONObject34.put("hit", q16 != null && new File(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD, q16).exists());
                    AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                    if (runtime == null || (appInterface = (AppInterface) runtime.getAppRuntime("modular_web")) == null) {
                        return true;
                    }
                    SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + appInterface.getCurrentAccountUin(), 4);
                    if (sharedPreferences == null) {
                        return true;
                    }
                    boolean z16 = sharedPreferences.getBoolean("kandian_feeds_preload", false);
                    boolean z17 = sharedPreferences.getBoolean("kandian_feeds_preload_wifi", false);
                    boolean z18 = sharedPreferences.getBoolean("kandian_feeds_preload_4G", false);
                    boolean z19 = sharedPreferences.getBoolean("kandian_feeds_preload_3G", false);
                    boolean z26 = sharedPreferences.getBoolean("kandian_feeds_preload_2G", false);
                    jSONObject34.put("readInJoyPreload", z16);
                    jSONObject34.put("readInJoyPreloadWifi", z17);
                    jSONObject34.put("readInJoyPreload4G", z18);
                    jSONObject34.put("readInJoyPreload3G", z19);
                    jSONObject34.put("readInJoyPreload2G", z26);
                    callJs(optString28, jSONObject34.toString());
                    if (!QLog.isColorLevel()) {
                        return true;
                    }
                    QLog.i(TAG, 2, "reportpreloaddata" + jSONObject34.toString());
                    return true;
                } catch (JSONException e89) {
                    e89.printStackTrace();
                    return true;
                }
            }
            if ("showOnlyShareMenu".endsWith(str3)) {
                SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) super.getBrowserComponent(4);
                if (swiftBrowserShareMenuHandler != null && (f16 = this.mRuntime.f()) != null) {
                    f16.showActionSheet();
                    ShareActionSheetBuilder shareActionSheetBuilder = swiftBrowserShareMenuHandler.C;
                    if (shareActionSheetBuilder != null && (elasticHorScrView = shareActionSheetBuilder.f307291m) != null) {
                        elasticHorScrView.setVisibility(8);
                    }
                }
                if (!QLog.isColorLevel()) {
                    return true;
                }
                QLog.i(TAG, 2, "showOnlyShareMenu");
                return true;
            }
            if ("showUGCVideoUploadPage".equals(str3)) {
                try {
                    JSONObject jSONObject35 = new JSONObject(strArr[0]);
                    if (QLog.isColorLevel()) {
                        QLog.i(LogTag.TAG_PUBLIC_ACCOUNT_VIDEO_CAMERA, 2, "showUGCVideoUploadPage() param json:" + jSONObject35.toString());
                    }
                } catch (Exception e95) {
                    if (QLog.isColorLevel()) {
                        QLog.i(LogTag.TAG_PUBLIC_ACCOUNT_VIDEO_CAMERA, 2, "showUGCVideoUploadPage() Exception=" + e95.getMessage());
                    }
                }
            } else if (!"showUGCVideoRecordPage".equals(str3)) {
                if ("sharePicToWeChatCircle".equals(str3)) {
                    try {
                        String string = new JSONObject(strArr[0]).getString("pictureUrl");
                        if (TextUtils.isEmpty(string)) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "url is null");
                            }
                        } else {
                            sharePictureToWeChat(string);
                        }
                    } catch (JSONException e96) {
                        e96.printStackTrace();
                    }
                } else if ("updateTopicCardFollowInfo".equals(str3)) {
                    try {
                        JSONObject jSONObject36 = new JSONObject(strArr[0]);
                        int i26 = jSONObject36.getInt("topicId");
                        int i27 = jSONObject36.getInt("followInfo");
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "topic id = " + i26 + "\t follow info =" + i27);
                        }
                        this.mClient.E0(i26, i27);
                    } catch (JSONException e97) {
                        e97.printStackTrace();
                    }
                } else {
                    if ("showPicture".equals(str3)) {
                        showPicture(strArr[0]);
                        return false;
                    }
                    if ("preloadNativeAdResource".equals(str3)) {
                        String str5 = null;
                        try {
                            JSONObject jSONObject37 = new JSONObject(strArr[0]);
                            str5 = jSONObject37.optString("callback");
                            JSONArray optJSONArray6 = jSONObject37.optJSONArray("resourceList");
                            ArrayList<String> arrayList4 = new ArrayList<>();
                            for (int i28 = 0; i28 < optJSONArray6.length(); i28++) {
                                arrayList4.add(optJSONArray6.getJSONObject(i28).optString("url"));
                            }
                            this.mClient.e(arrayList4);
                            callJs(str5, new JSONObject().put("retCode", 0).toString());
                        } catch (Exception e98) {
                            e98.printStackTrace();
                            callJs(str5, "{\"retCode\":-1}");
                        }
                    } else if ("getLocalCache".equals(str3)) {
                        try {
                            JSONObject jSONObject38 = new JSONObject(strArr[0]);
                            String optString30 = jSONObject38.optString("callback");
                            if (jSONObject38.has("localkey")) {
                                jSONObject38.optString("localkey", "");
                            }
                            String optString31 = jSONObject38.has("scene") ? jSONObject38.optString("scene", "") : "";
                            if ("messageBox".equals(optString31)) {
                                String string2 = new Bundle().getString("VALUE_UNREAD_MESSAGE_BOX_DATA", "");
                                if (!"".equals(string2)) {
                                    try {
                                        callJs(optString30, new JSONObject().put("retData", new JSONObject(string2)).toString());
                                    } catch (JSONException e99) {
                                        e99.printStackTrace();
                                    }
                                }
                            } else if ("commentPage".equals(optString31)) {
                                String string3 = new Bundle().getString("VALUE_CLICK_COMMENT_ACTICLEINFO", "");
                                if (!"".equals(string3)) {
                                    try {
                                        callJs(optString30, new JSONObject().put("retData", new JSONObject(string3)).toString());
                                    } catch (JSONException e100) {
                                        e100.printStackTrace();
                                    }
                                }
                            }
                        } catch (JSONException e101) {
                            e101.printStackTrace();
                        }
                        e101.printStackTrace();
                    } else if ("updateAccountCardFollowInfo".equals(str3)) {
                        try {
                            JSONObject jSONObject39 = new JSONObject(strArr[0]);
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "updateAccountCardFollowInfo jsonObject = " + jSONObject39);
                            }
                            long j3 = jSONObject39.getLong("followUin");
                            int i29 = jSONObject39.getInt("followInfo");
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "topic id = " + j3 + "\t follow info =" + i29);
                            }
                            this.mClient.D0(j3, i29);
                            this.mRuntime.a().setResult(-1, new Intent().putExtra("followInfo", i29));
                        } catch (JSONException e102) {
                            if (QLog.isColorLevel()) {
                                QLog.e(TAG, 2, "updateAccountCardFollowInfo e = " + e102);
                            }
                            e102.printStackTrace();
                        }
                    } else if (!"selectAndInviteFriend".equals(str3)) {
                        if ("addPreDownloadVideo".equals(str3)) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "WebVideoPredownload addPreDownloadVideo");
                            }
                            if (this.mVideoWebPreDownload == null) {
                                this.mVideoWebPreDownload = ((IVideoWebPreDownloadFactory) QRoute.api(IVideoWebPreDownloadFactory.class)).create();
                            }
                            f62.d dVar = this.mVideoWebPreDownload;
                            try {
                                dVar.d(new g());
                                JSONObject jSONObject40 = new JSONObject(strArr[0]);
                                String optString32 = jSONObject40.optString("callback");
                                String optString33 = jSONObject40.optString("video_vid");
                                int optInt7 = jSONObject40.optInt("busitype", -1);
                                int optInt8 = jSONObject40.optInt("video_duration", 0);
                                int optInt9 = jSONObject40.optInt("cache_duration", 0);
                                String optString34 = jSONObject40.optString("video_url");
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 2, "WebVideoPredownload addPreDownloadVideo , content = " + jSONObject40.toString());
                                }
                                dVar.b(optString33, optInt7, optInt8, optInt9, optString34, optString32);
                            } catch (JSONException e103) {
                                e103.printStackTrace();
                            }
                        } else if ("stopPreDownloadVideo".equals(str3)) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "WebVideoPredownload stopPreDownloadVideo");
                            }
                            f62.d dVar2 = this.mVideoWebPreDownload;
                            if (dVar2 != null) {
                                dVar2.c();
                            }
                        } else if ("openViola".equals(str3)) {
                            Bundle bundle = new Bundle();
                            try {
                                JSONObject jSONObject41 = new JSONObject(strArr[0]);
                                String string4 = jSONObject41.getString("url");
                                String optString35 = jSONObject41.optString("webUrl", "");
                                bundle.putString("url", string4);
                                bundle.putString("webUrl", optString35);
                            } catch (JSONException unused) {
                            }
                        } else {
                            if ("accountEditPageCompleted".equals(str3)) {
                                return true;
                            }
                            if ("reportT".equals(str3)) {
                                reportT(strArr);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin
    public boolean hasConfig(String str) {
        return authorizedLists.containsKey(str);
    }

    public void hideAllNonBaseMenuItem() {
        getMenuHideNameList().clear();
        getMenuHideNameList().add(IPublicAccountH5AbilityPlugin.SHARE_QQ);
        getMenuHideNameList().add(IPublicAccountH5AbilityPlugin.SHARE_CHANNEL);
        getMenuHideNameList().add(IPublicAccountH5AbilityPlugin.SHARE_QZONE);
        getMenuHideNameList().add(IPublicAccountH5AbilityPlugin.SHARE_WX_FRIEND);
        getMenuHideNameList().add(IPublicAccountH5AbilityPlugin.SHARE_WX_FRIEND_LINE);
        getMenuHideNameList().add(IPublicAccountH5AbilityPlugin.OPEN_QQ_BROWSER);
        getMenuHideNameList().add(IPublicAccountH5AbilityPlugin.OPEN_SYS_BROWSER);
        getMenuHideNameList().add(IPublicAccountH5AbilityPlugin.FAVORITE);
        getMenuHideNameList().add(IPublicAccountH5AbilityPlugin.COPY_URL);
        getMenuHideNameList().add(IPublicAccountH5AbilityPlugin.EXPORT_TENCENT_DOCS);
    }

    public void hideMenuItems(ArrayList<String> arrayList) {
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!contains(getMenuHideNameList(), next)) {
                getMenuHideNameList().add(next);
            }
        }
    }

    void init() {
        if (this.mInited.compareAndSet(false, true)) {
            com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
            this.mClient = A;
            A.p();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        super.onActivityResult(intent, b16, i3);
        if (b16 == 1) {
            if (intent != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("retCode", 0);
                    jSONObject.put("msg", "Success");
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                String stringExtra = intent.getStringExtra("scanResult");
                if (this.needResult == 1) {
                    try {
                        jSONObject.put("scanResult", stringExtra);
                    } catch (JSONException e17) {
                        e17.printStackTrace();
                    }
                    ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005872", "0X8005872", 0, 0, "1", "", "", "");
                }
                if (!TextUtils.isEmpty(this.callback)) {
                    callJs(this.callback, jSONObject.toString());
                }
            }
            this.needResult = -1;
            this.scanType = -1;
            return;
        }
        String str = "";
        if (b16 == 112) {
            File file = new File(this.cameraPath);
            final JSONObject jSONObject2 = new JSONObject();
            final JSONArray jSONArray = new JSONArray();
            try {
                if (file.exists()) {
                    ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.2
                        @Override // java.lang.Runnable
                        public void run() {
                            CompressInfo compressInfo = new CompressInfo(PublicAccountH5AbilityPluginImpl.this.cameraPath, 0);
                            compressInfo.K = 0;
                            ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
                            if (!StringUtil.isEmpty(compressInfo.H)) {
                                String str2 = IPublicAccountH5AbilityPlugin.LOCALID_HEAD + PublicAccountH5AbilityPluginImpl.this.cameraUUid;
                                PublicAccountH5AbilityPluginImpl.localIdMap.put(str2, compressInfo.H);
                                try {
                                    jSONArray.put(0, str2);
                                    jSONObject2.put("value", jSONArray);
                                    jSONObject2.put("retCode", 0);
                                    jSONObject2.put("msg", "Success");
                                    jSONObject2.put("sourceType", "camera");
                                    PublicAccountH5AbilityPluginImpl publicAccountH5AbilityPluginImpl = PublicAccountH5AbilityPluginImpl.this;
                                    publicAccountH5AbilityPluginImpl.callJs(publicAccountH5AbilityPluginImpl.cameraCallback, jSONObject2.toString());
                                    ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005895", "0X8005895", 0, 0, "1", "", "", "");
                                } catch (JSONException e18) {
                                    e18.printStackTrace();
                                }
                            } else {
                                try {
                                    jSONObject2.put("retCode", -1);
                                    jSONObject2.put("msg", "compress fail");
                                    jSONObject2.put("sourceType", "camera");
                                    PublicAccountH5AbilityPluginImpl publicAccountH5AbilityPluginImpl2 = PublicAccountH5AbilityPluginImpl.this;
                                    publicAccountH5AbilityPluginImpl2.callJs(publicAccountH5AbilityPluginImpl2.cameraCallback, jSONObject2.toString());
                                    ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005895", "0X8005895", 0, -1, "1", "", "", "");
                                } catch (JSONException e19) {
                                    e19.printStackTrace();
                                }
                            }
                            PublicAccountH5AbilityPluginImpl publicAccountH5AbilityPluginImpl3 = PublicAccountH5AbilityPluginImpl.this;
                            publicAccountH5AbilityPluginImpl3.cameraPath = "";
                            publicAccountH5AbilityPluginImpl3.cameraCallback = "";
                            publicAccountH5AbilityPluginImpl3.cameraUUid = "";
                        }
                    });
                } else {
                    jSONObject2.put("retCode", 1);
                    jSONObject2.put("msg", "cancel");
                    jSONObject2.put("sourceType", "camera");
                    callJs(this.cameraCallback, jSONObject2.toString());
                    this.cameraPath = "";
                    this.cameraCallback = "";
                    this.cameraUUid = "";
                }
                return;
            } catch (JSONException e18) {
                e18.printStackTrace();
                return;
            }
        }
        if (b16 == 111) {
            final JSONObject jSONObject3 = new JSONObject();
            final JSONArray jSONArray2 = new JSONArray();
            final ArrayList<String> stringArrayListExtra = intent != null ? intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS") : null;
            if (stringArrayListExtra != null) {
                try {
                    if (stringArrayListExtra.size() != 0) {
                        if (intent.getIntExtra(PeakConstants.SEND_SIZE_SPEC, 0) == 0) {
                            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    for (int i16 = 0; i16 < stringArrayListExtra.size(); i16++) {
                                        try {
                                            String str2 = IPublicAccountH5AbilityPlugin.LOCALID_HEAD + UUID.randomUUID().toString();
                                            jSONArray2.put(i16, str2);
                                            CompressInfo compressInfo = new CompressInfo((String) stringArrayListExtra.get(i16), 0);
                                            compressInfo.K = 0;
                                            ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
                                            if (!StringUtil.isEmpty(compressInfo.H)) {
                                                PublicAccountH5AbilityPluginImpl.localIdMap.put(str2, compressInfo.H);
                                            } else {
                                                PublicAccountH5AbilityPluginImpl.localIdMap.put(str2, (String) stringArrayListExtra.get(i16));
                                            }
                                        } catch (JSONException e19) {
                                            e19.printStackTrace();
                                            return;
                                        }
                                    }
                                    jSONObject3.put("value", jSONArray2);
                                    jSONObject3.put("retCode", 0);
                                    jSONObject3.put("msg", "Success");
                                    jSONObject3.put("sourceType", "album");
                                    PublicAccountH5AbilityPluginImpl publicAccountH5AbilityPluginImpl = PublicAccountH5AbilityPluginImpl.this;
                                    publicAccountH5AbilityPluginImpl.callJs(publicAccountH5AbilityPluginImpl.cameraCallback, jSONObject3.toString());
                                    PublicAccountH5AbilityPluginImpl.this.cameraCallback = "";
                                    ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005895", "0X8005895", 0, 0, "1", "", "", "");
                                }
                            });
                            return;
                        }
                        for (int i16 = 0; i16 < stringArrayListExtra.size(); i16++) {
                            String str2 = IPublicAccountH5AbilityPlugin.LOCALID_HEAD + UUID.randomUUID().toString();
                            jSONArray2.put(i16, str2);
                            localIdMap.put(str2, stringArrayListExtra.get(i16));
                        }
                        jSONObject3.put("value", jSONArray2);
                        jSONObject3.put("retCode", 0);
                        jSONObject3.put("msg", "Success");
                        jSONObject3.put("sourceType", "album");
                        callJs(this.cameraCallback, jSONObject3.toString());
                        this.cameraCallback = "";
                        ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005895", "0X8005895", 0, 0, "1", "", "", "");
                        return;
                    }
                } catch (JSONException e19) {
                    e19.printStackTrace();
                    return;
                }
            }
            jSONObject3.put("retCode", 1);
            jSONObject3.put("msg", "");
            jSONObject3.put("sourceType", "album");
            callJs(this.cameraCallback, jSONObject3.toString());
            this.cameraCallback = "";
            return;
        }
        if (b16 == 113) {
            int i17 = i3 == -1 ? 0 : -1;
            if (intent == null) {
                return;
            }
            String stringExtra2 = intent.getStringExtra("result_js_callback");
            String stringExtra3 = intent.getStringExtra("feed_id");
            int intExtra = intent.getIntExtra("feedsType", 1);
            if (stringExtra2 != null && stringExtra3 != null) {
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put("feedsId", stringExtra3);
                    jSONObject4.put("retCode", i17);
                    jSONObject4.put("feedsType", intExtra);
                    callJs(stringExtra2, jSONObject4.toString());
                } catch (Exception unused) {
                }
            }
            ((IShareReport) QRoute.api(IShareReport.class)).reportResult(i3 == -1);
            return;
        }
        if (b16 == 114 || b16 == 115 || b16 == 116 || b16 == 122) {
            if (intent == null) {
                return;
            }
            String stringExtra4 = intent.getStringExtra("arg_callback");
            if (TextUtils.isEmpty(stringExtra4)) {
                return;
            }
            if (b16 != 122) {
                switch (b16) {
                    case 114:
                        str = "showUGCEditPage";
                        break;
                    case 115:
                        str = "showUGCVideoUploadPage";
                        break;
                    case 116:
                        str = "showUGCVideoRecordPage";
                        break;
                }
            } else {
                str = "showQAAskEditor";
            }
            try {
                if (i3 == -1) {
                    String stringExtra5 = intent.getStringExtra("arg_result_json");
                    if (stringExtra5 != null) {
                        JSONObject jSONObject5 = new JSONObject(stringExtra5);
                        jSONObject5.put("retCode", 0);
                        callJs(stringExtra4, jSONObject5.toString());
                        return;
                    }
                    return;
                }
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("retCode", -1);
                String jSONObject7 = jSONObject6.toString();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, str + " result:" + jSONObject7);
                }
                callJs(stringExtra4, jSONObject7);
                return;
            } catch (Exception unused2) {
                return;
            }
        }
        if (b16 == 118 || b16 == 121) {
            if (b16 == 118) {
                str = selectAndUploadAvatarCallback;
            } else if (b16 == 121) {
                str = selectAndTopicPicCallback;
            }
            if (intent == null) {
                if (i3 == 0) {
                    try {
                        JSONObject jSONObject8 = new JSONObject();
                        jSONObject8.put("retCode", 1);
                        jSONObject8.put("msg", HardCodeUtil.qqStr(R.string.pmw));
                        callJs(str, jSONObject8.toString());
                        return;
                    } catch (Exception e26) {
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, QLog.getStackTraceString(e26));
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (i3 == -1) {
                Bundle bundleExtra = intent.getBundleExtra("Bundle");
                if (bundleExtra != null) {
                    int i18 = bundleExtra.getInt("retCode");
                    String string = bundleExtra.getString("url");
                    String string2 = bundleExtra.getString("msg");
                    try {
                        JSONObject jSONObject9 = new JSONObject();
                        jSONObject9.put("retCode", i18);
                        jSONObject9.put("url", string);
                        jSONObject9.put("msg", string2);
                        callJs(str, jSONObject9.toString());
                        return;
                    } catch (Exception e27) {
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, QLog.getStackTraceString(e27));
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            try {
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put("retCode", -1);
                String jSONObject11 = jSONObject10.toString();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, " selectAndUploadAvatar result:" + jSONObject11);
                }
                callJs(this.callback, jSONObject11);
            } catch (Exception e28) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, QLog.getStackTraceString(e28));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null) {
            AppInterface b16 = bVar.b();
            this.app = b16;
            this.uin = b16.getAccount();
        }
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        CustomWebView e16;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && (e16 = bVar.e()) != null) {
            cleanConfig(e16.getUrl());
        }
        super.onDestroy();
        if (this.mInited.get()) {
            cancleAllUploadAndDownloadTask();
            com.tencent.biz.troop.b bVar2 = this.mClient;
            if (bVar2 != null) {
                bVar2.q();
            }
            getMenuHideNameList().clear();
            PublicAccountH5AbilityPttImpl publicAccountH5AbilityPttImpl = this.ptt;
            if (publicAccountH5AbilityPttImpl != null) {
                publicAccountH5AbilityPttImpl.cancelPttRecorderAndPlayTask();
            }
        }
        f62.d dVar = this.mVideoWebPreDownload;
        if (dVar != null) {
            dVar.destory();
            this.mVideoWebPreDownload = null;
        }
    }

    protected void onPause() {
        PublicAccountH5AbilityPttImpl publicAccountH5AbilityPttImpl = this.ptt;
        if (publicAccountH5AbilityPttImpl != null) {
            publicAccountH5AbilityPttImpl.cancelPttRecorderAndPlayTask();
        }
    }

    public void openLocation() {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.startActivity(new Intent(activity, (Class<?>) PoiMapActivity.class).putExtra("uin", this.uin));
        this.mClient.j0();
    }

    void sendAuthRequest(String str, String str2) {
        NewIntent newIntent = new NewIntent(getContext(), PublicAccountServletImpl.class);
        newIntent.putExtra("cmd", "jsapi");
        mobileqq_mp$JSApiWebServerRequest mobileqq_mp_jsapiwebserverrequest = new mobileqq_mp$JSApiWebServerRequest();
        mobileqq_mp_jsapiwebserverrequest.versionInfo.set(AppSetting.f99551k + ",3,0");
        mobileqq_mp_jsapiwebserverrequest.cmd.set(1);
        mobileqq_mp_jsapiwebserverrequest.body.set(str2);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "\u9274\u6743body\u4e3a:  " + str2);
        }
        newIntent.setObserver(new j(str));
        newIntent.putExtra("data", mobileqq_mp_jsapiwebserverrequest.toByteArray());
        this.app.startServlet(newIntent);
    }

    void sendMediaIdForUuidRequest(String str, int i3, boolean z16, String str2) {
        NewIntent newIntent = new NewIntent(getContext(), PublicAccountServletImpl.class);
        newIntent.putExtra("cmd", "jsapi");
        mobileqq_mp$JSApiWebServerRequest mobileqq_mp_jsapiwebserverrequest = new mobileqq_mp$JSApiWebServerRequest();
        mobileqq_mp_jsapiwebserverrequest.versionInfo.set(AppSetting.f99551k + ",3,0");
        mobileqq_mp_jsapiwebserverrequest.cmd.set(this.CMD_FOR_UUID);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IPublicAccountBrowser.KEY_PUB_UIN, this.pUin);
            jSONObject.put("mediaid", str);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        mobileqq_mp_jsapiwebserverrequest.body.set(jSONObject.toString());
        newIntent.setObserver(new i(str2, i3, z16, str));
        newIntent.putExtra("data", mobileqq_mp_jsapiwebserverrequest.toByteArray());
        this.app.startServlet(newIntent);
    }

    void sendUuidForMediaIdRequest(String str, boolean z16, String str2) {
        NewIntent newIntent = new NewIntent(getContext(), PublicAccountServletImpl.class);
        newIntent.putExtra("cmd", "jsapi");
        mobileqq_mp$JSApiWebServerRequest mobileqq_mp_jsapiwebserverrequest = new mobileqq_mp$JSApiWebServerRequest();
        mobileqq_mp_jsapiwebserverrequest.versionInfo.set(AppSetting.f99551k + ",3,0");
        mobileqq_mp_jsapiwebserverrequest.cmd.set(this.CMD_FOR_MEDIAID);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IPublicAccountBrowser.KEY_PUB_UIN, this.pUin);
            if (z16) {
                jSONObject.put("url", str);
                jSONObject.put("type", "2");
            } else {
                jSONObject.put("type", "4");
                if (this.ptt == null) {
                    this.ptt = new PublicAccountH5AbilityPttImpl(this.uin, this.mRuntime);
                }
                this.ptt.checkFileInfo();
                jSONObject.put(ShortVideoConstants.FILE_UUID, str);
                jSONObject.put("file_md5", PublicAccountH5AbilityPttImpl.getMd5ForPtt());
                jSONObject.put("file_name", PublicAccountH5AbilityPttImpl.getFileNameForPtt());
                jSONObject.put("file_size", PublicAccountH5AbilityPttImpl.getFileSizeForPtt());
                jSONObject.put("file_time", PublicAccountH5AbilityPttImpl.getTimeForPtt());
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "sendUuidForMediaIdRequest file_uuid = " + str + " file_md5=" + PublicAccountH5AbilityPttImpl.getMd5ForPtt() + " file_name:" + PublicAccountH5AbilityPttImpl.getFileNameForPtt() + " file_size=" + PublicAccountH5AbilityPttImpl.getFileSizeForPtt() + " file_time=" + PublicAccountH5AbilityPttImpl.getTimeForPtt());
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        mobileqq_mp_jsapiwebserverrequest.body.set(jSONObject.toString());
        newIntent.setObserver(new h(z16, str2));
        newIntent.putExtra("data", mobileqq_mp_jsapiwebserverrequest.toByteArray());
        this.app.startServlet(newIntent);
    }

    public void showAllNonBaseMenuItem() {
        getMenuHideNameList().clear();
    }

    public void showMenuItems(ArrayList<String> arrayList) {
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            remove(getMenuHideNameList(), it.next());
        }
    }

    public void showOfficialAccountProfile(String str) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(activity, IPublicAccountDetailActivity.ROUTE_NAME);
        activityURIRequest.extra().putString("uin", str);
        activityURIRequest.extra().putBoolean(PublicAccountDetailActivityImpl.FROM_BROWSER, true);
        QRoute.startUri(activityURIRequest, (o) null);
    }

    public void showPAactionSheet(int i3, int i16, String str, int i17) {
        Activity activity = getActivity();
        if (activity == null) {
            QLog.e(TAG, 1, "showPAactionSheet failed! Activity is released!");
            return;
        }
        if (this.paActionSheet == null) {
            this.paActionSheet = (ActionSheet) ActionSheetHelper.createDialog(activity, null);
        }
        View inflate = LayoutInflater.from(activity).inflate(R.layout.az_, (ViewGroup) null);
        this.paActionSheet.setActionContentView(inflate, null);
        TextView textView = (TextView) inflate.findViewById(R.id.cdg);
        TextView textView2 = (TextView) inflate.findViewById(R.id.cde);
        TextView textView3 = (TextView) inflate.findViewById(R.id.cfp);
        if (i3 == 1) {
            textView3.setVisibility(8);
            textView2.setVisibility(8);
        } else if (i3 == 2) {
            textView3.setVisibility(8);
            textView.setVisibility(8);
        }
        if (!this.paActionSheet.isShowing()) {
            this.paActionSheet.show();
        }
        textView.setOnClickListener(new k(str));
        textView2.setOnClickListener(new l(i17, i16, str));
        textView3.setOnClickListener(new a());
    }

    void showProgressDialog() {
        try {
            if (this.mPd != null) {
                cancleProgressDailog();
            } else {
                Activity activity = getActivity();
                if (activity == null) {
                    QLog.e(TAG, 1, "showProgressDialog failed! activity null!");
                    return;
                }
                ProgressDialog progressDialog = new ProgressDialog(activity, R.style.qZoneInputDialog);
                this.mPd = progressDialog;
                progressDialog.setCancelable(true);
                this.mPd.show();
                this.mPd.setContentView(R.layout.f168383uh);
                ((TextView) this.mPd.findViewById(R.id.photo_prievew_progress_dialog_text)).setText(HardCodeUtil.qqStr(R.string.pnh));
            }
            if (this.mPd.isShowing()) {
                return;
            }
            this.mPd.show();
        } catch (Throwable unused) {
        }
    }

    public void showWebPanel() {
        if (this.mRuntime.f() != null) {
            this.mRuntime.f().showActionSheet();
        }
    }

    void startDownload(int i3, String str, String str2, boolean z16, String str3) {
        String str4;
        String str5 = this.pUin;
        if (str5 == null || "".equals(str5)) {
            str5 = "12345678";
        }
        try {
            Long.parseLong(str5);
            str4 = str5;
        } catch (Exception unused) {
            str4 = "12345678";
        }
        if (this.mClient == null || "".equals(str)) {
            return;
        }
        this.mClient.s(str, i3, str4, z16, new d(z16, str3, str2), new e());
    }

    void startNextUploadTask(Bundle bundle) {
        String string = bundle.getString(IPublicAccountH5AbilityPlugin.PICLOCALPATH);
        if (string != null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : localIdMap.entrySet()) {
                if (string.equals(entry.getValue())) {
                    arrayList.add(entry.getKey());
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Iterator<n> it5 = this.uploadBeensList.iterator();
                while (it5.hasNext()) {
                    n next = it5.next();
                    if (str.equals(next.f80250b)) {
                        arrayList2.add(next);
                    }
                }
            }
            this.uploadBeensList.removeAll(arrayList2);
            if (this.uploadBeensList.size() > 0) {
                n nVar = this.uploadBeensList.get(0);
                startUpload(nVar.f80251c, localIdMap.get(nVar.f80250b), true, nVar.f80249a);
            }
        }
    }

    void startUpload(int i3, String str, boolean z16, String str2) {
        String str3;
        String str4 = this.pUin;
        if (str4 == null || "".equals(str4)) {
            str4 = "12345678";
        }
        try {
            Long.parseLong(str4);
            str3 = str4;
        } catch (Exception unused) {
            str3 = "12345678";
        }
        if (this.mClient == null || "".equals(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(PublicAccountH5ManagerImpl.TAG, 2, "HttpUtil.getNetWorkType()" + HttpUtil.getNetWorkType());
        }
        if (HttpUtil.getNetWorkType() != 1) {
            File file = new File(str);
            if (QLog.isColorLevel()) {
                QLog.d(PublicAccountH5ManagerImpl.TAG, 2, "size" + file.length());
            }
            if (file.length() > 204800) {
                QQToast.makeText(getContext(), "\u4f60\u5df2\u79bb\u5f00wifi\u73af\u5883", 0).show();
            }
        }
        this.mClient.S0(str, i3, str3, z16, new b(str2, z16), new c());
    }

    public void takePicture() {
        String str = AppConstants.SDCARD_PATH + PublicAccountH5ManagerImpl.C2B_FIRE_CAMERC_DIR;
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("retCode", "-1");
                jSONObject.put("msg", "no sdcard");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            callJs(this.cameraCallback, jSONObject.toString());
            return;
        }
        this.cameraUUid = UUID.randomUUID().toString();
        this.cameraPath = str + this.cameraUUid + ".jpg";
        Intent intent = new Intent();
        FileProvider7Helper.setSystemCapture(getContext(), new File(this.cameraPath), intent);
        try {
            startActivityForResult(intent, OPENCAMERA);
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class j implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f80238d;

        j(String str) {
            this.f80238d = str;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            byte[] byteArray;
            int optInt;
            if (!z16 || (byteArray = bundle.getByteArray("data")) == null) {
                return;
            }
            mobileqq_mp$JSApiWebServerResponse mobileqq_mp_jsapiwebserverresponse = new mobileqq_mp$JSApiWebServerResponse();
            try {
                mobileqq_mp_jsapiwebserverresponse.mergeFrom(byteArray);
                mobileqq_mp$RetInfo mobileqq_mp_retinfo = mobileqq_mp_jsapiwebserverresponse.ret_info.get();
                String str = mobileqq_mp_jsapiwebserverresponse.body.get();
                int i16 = mobileqq_mp_retinfo.ret_code.get();
                String str2 = mobileqq_mp_retinfo.err_info.get();
                JSONObject jSONObject = new JSONObject();
                if (i16 == 0) {
                    JSONObject jSONObject2 = new JSONObject(str);
                    i16 = jSONObject2.optInt("ret");
                    String optString = jSONObject2.optString("msg");
                    PublicAccountH5AbilityPluginImpl.this.pUin = jSONObject2.optString(IPublicAccountBrowser.KEY_PUB_UIN);
                    if (i16 == -1 && (optInt = jSONObject2.optInt("refuseSec")) > 0) {
                        PublicAccountH5AbilityPluginImpl publicAccountH5AbilityPluginImpl = PublicAccountH5AbilityPluginImpl.this;
                        publicAccountH5AbilityPluginImpl.refuseConfig = true;
                        publicAccountH5AbilityPluginImpl.mHandler.sendEmptyMessageDelayed(1000, optInt * 1000);
                    }
                    JSONArray optJSONArray = jSONObject2.optJSONArray(MimeHelper.IMAGE_SUBTYPE_BITMAP);
                    ArrayList arrayList = new ArrayList();
                    if (optJSONArray != null) {
                        for (int i17 = 0; i17 < optJSONArray.length(); i17++) {
                            arrayList.add(Integer.valueOf(optJSONArray.getInt(i17)));
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        for (int i18 : PublicAccountH5AbilityPluginImpl.intToCharArray(((Integer) it.next()).intValue())) {
                            arrayList2.add(Integer.valueOf(i18));
                        }
                    }
                    ArrayList<String> arrayList3 = new ArrayList<>();
                    ArrayList<String> arrayList4 = PublicAccountH5AbilityPluginImpl.needAuthorizedLists.get(this.f80238d);
                    for (int i19 = 0; i19 < arrayList2.size(); i19++) {
                        String str3 = PublicAccountH5AbilityPluginImpl.map.get(Integer.valueOf(i19));
                        if (str3 != null && ((Integer) arrayList2.get(i19)).intValue() == 1 && PublicAccountH5AbilityPluginImpl.this.contains(arrayList4, str3)) {
                            arrayList3.add(str3);
                        }
                    }
                    PublicAccountH5AbilityPluginImpl.authorizedLists.put(this.f80238d, arrayList3);
                    PublicAccountH5AbilityPluginImpl.needAuthorizedLists.remove(this.f80238d);
                    ArrayList arrayList5 = new ArrayList();
                    if (arrayList4 != null) {
                        for (int i26 = 0; i26 < arrayList4.size(); i26++) {
                            if (!PublicAccountH5AbilityPluginImpl.this.contains(arrayList3, arrayList4.get(i26))) {
                                arrayList5.add(Integer.valueOf(i26));
                            }
                        }
                    }
                    jSONObject.put("forbidden", new JSONArray((Collection) arrayList5));
                    str2 = optString;
                }
                jSONObject.put("msg", str2);
                jSONObject.put("retCode", i16);
                String jSONObject3 = jSONObject.toString();
                PublicAccountH5AbilityPluginImpl publicAccountH5AbilityPluginImpl2 = PublicAccountH5AbilityPluginImpl.this;
                String str4 = publicAccountH5AbilityPluginImpl2.authCallback;
                if (str4 != null) {
                    publicAccountH5AbilityPluginImpl2.callJs(str4, jSONObject3);
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
    }

    public ArrayList<String> getMenuHideNameList() {
        SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) super.getBrowserComponent(4);
        if (swiftBrowserShareMenuHandler != null) {
            return swiftBrowserShareMenuHandler.D;
        }
        return null;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin
    public Object getWebResponse(String str) {
        InputStream d16;
        try {
            String str2 = localIdMap.get(str);
            if (str2 == null || (d16 = CrmUtils.d(SafeBitmapFactory.decodeFile(str2))) == null) {
                return null;
            }
            return new WebResourceResponse("image/png", "UTF-8", d16);
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }

    public static int[] intToCharArray(int i3) {
        int[] iArr = new int[32];
        for (int i16 = 0; i16 < 32; i16++) {
            iArr[31 - i16] = (i3 >> i16) & 1;
        }
        return iArr;
    }

    public static void reportT(String... strArr) {
        String str = "";
        QLog.i(TAG, 1, "[reportT]");
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            String optString = jSONObject.optString("code");
            JSONObject optJSONObject = jSONObject.optJSONObject("params");
            if (TextUtils.isEmpty(optString) || optJSONObject == null) {
                return;
            }
            String optString2 = optJSONObject.optString("r2", "");
            String optString3 = optJSONObject.optString("r3", "");
            String optString4 = optJSONObject.optString("r4", "");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("r5");
            IPublicAccountReportUtils iPublicAccountReportUtils = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
            if (optJSONObject2 != null) {
                str = optJSONObject2.toString();
            }
            iPublicAccountReportUtils.publicAccountReportClickEvent(null, null, optString, optString, 0, 0, optString2, optString3, optString4, str, false);
            QLog.i(TAG, 1, "[reportT], code = " + optString + ", r5 = " + optJSONObject2);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "[reportT] json e = " + e16);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[reportT] t = " + th5);
        }
    }

    void startNextDownloadTask(String str) {
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<m> it = this.downloadBeensList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (str.equals(next.f80247b)) {
                    arrayList.add(next);
                }
            }
            this.downloadBeensList.removeAll(arrayList);
        }
        if (this.downloadBeensList.size() > 0) {
            m mVar = this.downloadBeensList.get(0);
            sendMediaIdForUuidRequest(mVar.f80247b, mVar.f80248c, true, mVar.f80246a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class i implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f80233d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f80234e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f80235f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f80236h;

        i(String str, int i3, boolean z16, String str2) {
            this.f80233d = str;
            this.f80234e = i3;
            this.f80235f = z16;
            this.f80236h = str2;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x014b A[Catch: JSONException -> 0x0288, InvalidProtocolBufferMicroException -> 0x028d, TryCatch #1 {JSONException -> 0x0288, blocks: (B:7:0x0014, B:10:0x004b, B:12:0x0064, B:15:0x0073, B:17:0x0084, B:20:0x0094, B:22:0x0145, B:24:0x014b, B:30:0x0091, B:31:0x00cc, B:34:0x00e1, B:36:0x00ee, B:39:0x00fe, B:42:0x00fb, B:43:0x0131, B:44:0x0176, B:46:0x017c, B:47:0x018e, B:50:0x019e, B:52:0x01b1, B:54:0x01db, B:58:0x019b, B:59:0x0200, B:61:0x0206, B:62:0x0218, B:65:0x0228, B:67:0x023b, B:69:0x0264, B:73:0x0225), top: B:6:0x0014 }] */
        /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        @Override // mqq.observer.BusinessObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            byte[] byteArray;
            String optString;
            if (!z16 || (byteArray = bundle.getByteArray("data")) == null) {
                return;
            }
            mobileqq_mp$JSApiWebServerResponse mobileqq_mp_jsapiwebserverresponse = new mobileqq_mp$JSApiWebServerResponse();
            try {
                try {
                    mobileqq_mp_jsapiwebserverresponse.mergeFrom(byteArray);
                    mobileqq_mp$RetInfo mobileqq_mp_retinfo = mobileqq_mp_jsapiwebserverresponse.ret_info.get();
                    String str = mobileqq_mp_jsapiwebserverresponse.body.get();
                    int i16 = mobileqq_mp_retinfo.ret_code.get();
                    String str2 = mobileqq_mp_retinfo.err_info.get();
                    new JSONObject();
                    if (i16 == 0) {
                        JSONObject jSONObject = new JSONObject(str);
                        int optInt = jSONObject.optInt("ret");
                        String optString2 = jSONObject.optString("msg");
                        int optInt2 = jSONObject.optInt("subcmd");
                        if (optInt == 0) {
                            int optInt3 = jSONObject.optInt("type");
                            String str3 = "";
                            if (optInt3 == 2) {
                                optString = jSONObject.optString("url");
                                String optString3 = jSONObject.optString("mediaid");
                                if (optString.equals("")) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    try {
                                        jSONObject2.put("retCode", -1);
                                        jSONObject2.put("msg", "mediaId for serverId error");
                                    } catch (JSONException e16) {
                                        e16.printStackTrace();
                                    }
                                    PublicAccountH5AbilityPluginImpl.this.callJs(this.f80233d, jSONObject2.toString());
                                    PublicAccountH5AbilityPluginImpl.this.startNextDownloadTask(optString3);
                                    ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D28", "0X8005D28", 0, -1, "1", "", "", "");
                                } else {
                                    PublicAccountH5AbilityPluginImpl.this.startDownload(this.f80234e, optString, optString3, true, this.f80233d);
                                }
                            } else {
                                if (optInt3 == 4) {
                                    optString = jSONObject.optString(ShortVideoConstants.FILE_UUID);
                                    if (optString.equals("")) {
                                        JSONObject jSONObject3 = new JSONObject();
                                        try {
                                            jSONObject3.put("retCode", -1);
                                            jSONObject3.put("msg", "mediaId for serverId error");
                                        } catch (JSONException e17) {
                                            e17.printStackTrace();
                                        }
                                        PublicAccountH5AbilityPluginImpl.this.callJs(this.f80233d, jSONObject3.toString());
                                        ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D31", "0X8005D31", 0, -1, "1", "", "", "");
                                    } else {
                                        PublicAccountH5AbilityPluginImpl.this.startDownload(this.f80234e, optString, jSONObject.optString("mediaid"), false, this.f80233d);
                                    }
                                }
                                if (QLog.isColorLevel()) {
                                    return;
                                }
                                QLog.i(PublicAccountH5AbilityPluginImpl.TAG, 2, "sendMediaIdForUuidRequest serverId = " + str3 + "  type = " + i3 + " subCom=" + optInt2);
                                return;
                            }
                            str3 = optString;
                            if (QLog.isColorLevel()) {
                            }
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.i(PublicAccountH5AbilityPluginImpl.TAG, 2, "sendMediaIdForUuidRequest errorMsg = " + optString2);
                            }
                            JSONObject jSONObject4 = new JSONObject();
                            try {
                                jSONObject4.put("retCode", -1);
                                jSONObject4.put("msg", "mediaId for serverId error");
                            } catch (JSONException e18) {
                                e18.printStackTrace();
                            }
                            PublicAccountH5AbilityPluginImpl.this.callJs(this.f80233d, jSONObject4.toString());
                            if (this.f80235f) {
                                PublicAccountH5AbilityPluginImpl.this.startNextDownloadTask(this.f80236h);
                                ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D28", "0X8005D28", 0, -1, "1", "", "", "");
                            } else {
                                ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D31", "0X8005D31", 0, -1, "1", "", "", "");
                            }
                        }
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.i(PublicAccountH5AbilityPluginImpl.TAG, 2, "sendMediaIdForUuidRequest errorMsg = " + str2);
                        }
                        JSONObject jSONObject5 = new JSONObject();
                        try {
                            jSONObject5.put("retCode", -1);
                            jSONObject5.put("msg", "mediaId for serverId error");
                        } catch (JSONException e19) {
                            e19.printStackTrace();
                        }
                        PublicAccountH5AbilityPluginImpl.this.callJs(this.f80233d, jSONObject5.toString());
                        if (this.f80235f) {
                            PublicAccountH5AbilityPluginImpl.this.startNextDownloadTask(this.f80236h);
                            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D28", "0X8005D28", 0, -1, "1", "", "", "");
                        } else {
                            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D31", "0X8005D31", 0, -1, "1", "", "", "");
                        }
                    }
                } catch (InvalidProtocolBufferMicroException e26) {
                    e26.printStackTrace();
                }
            } catch (JSONException e27) {
                e27.printStackTrace();
            }
        }
    }

    public static void remove(ArrayList<String> arrayList, String str) {
        if (arrayList == null) {
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (arrayList.get(i3).equals(str)) {
                arrayList.remove(i3);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements ITroopMemberApiClientApi.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f80219d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f80220e;

        b(String str, boolean z16) {
            this.f80219d = str;
            this.f80220e = z16;
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            if (bundle != null) {
                if (PublicAccountH5AbilityPluginImpl.this.getActivity() != null) {
                    PublicAccountH5AbilityPluginImpl.this.cancleProgressDailog();
                }
                String string = bundle.getString(IPublicAccountH5AbilityPlugin.PICSERVERID);
                PublicAccountH5AbilityPluginImpl.this.startNextUploadTask(bundle);
                if ("-1".equals(string)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("retCode", -1);
                        jSONObject.put("msg", "fail");
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                    PublicAccountH5AbilityPluginImpl.this.callJs(this.f80219d, jSONObject.toString());
                    if (this.f80220e) {
                        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D27", "0X8005D27", 0, -1, "1", "", "", "", false);
                        return;
                    } else {
                        ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D30", "0X8005D30", 0, -1, "1", "", "", "");
                        return;
                    }
                }
                PublicAccountH5AbilityPluginImpl.this.sendUuidForMediaIdRequest(string, this.f80220e, this.f80219d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements ITroopMemberApiClientApi.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f80223d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f80224e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f80225f;

        d(boolean z16, String str, String str2) {
            this.f80223d = z16;
            this.f80224e = str;
            this.f80225f = str2;
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            if (bundle != null) {
                if (PublicAccountH5AbilityPluginImpl.this.getActivity() != null) {
                    PublicAccountH5AbilityPluginImpl.this.cancleProgressDailog();
                }
                String string = bundle.getString(IPublicAccountH5AbilityPlugin.PICLOCALID);
                JSONObject jSONObject = new JSONObject();
                try {
                    if ("-1".equals(string)) {
                        jSONObject.put("retCode", -1);
                        jSONObject.put("msg", "fail");
                        if (this.f80223d) {
                            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D28", "0X8005D28", 0, -1, "1", "", "", "");
                        } else {
                            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D31", "0X8005D31", 0, -1, "1", "", "", "");
                        }
                    } else {
                        if (this.f80223d) {
                            string = IPublicAccountH5AbilityPlugin.LOCALID_HEAD + string;
                        }
                        PublicAccountH5AbilityPluginImpl.localIdMap.put(string, bundle.getString(IPublicAccountH5AbilityPlugin.PICLOCALPATH));
                        jSONObject.put("retCode", 0);
                        jSONObject.put("msg", HardCodeUtil.qqStr(R.string.pmf) + string);
                        if (QLog.isColorLevel()) {
                            QLog.i(PublicAccountH5AbilityPluginImpl.TAG, 2, "\u4e0b\u8f7d\u6210\u529f\uff0clocalld\u4e3a  " + string);
                        }
                        if (this.f80223d) {
                            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D28", "0X8005D28", 0, 0, "1", "", "", "");
                        } else {
                            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D31", "0X8005D31", 0, 0, "1", "", "", "");
                        }
                    }
                    jSONObject.put("localId", string);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                PublicAccountH5AbilityPluginImpl.this.callJs(this.f80224e, jSONObject.toString());
                if (this.f80223d) {
                    PublicAccountH5AbilityPluginImpl.this.startNextDownloadTask(this.f80225f);
                }
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin
    public boolean contains(ArrayList<String> arrayList, String str) {
        if (arrayList == null) {
            return false;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (arrayList.get(i3).equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin
    public boolean hasRight(String str, String str2) {
        if (!authorizedLists.containsKey(str)) {
            return false;
        }
        ArrayList<String> arrayList = authorizedLists.get(str);
        if ("QQApi.shareMsg".equals(str2)) {
            return contains(arrayList, "ui.setOnShareQQFriendHandler") || contains(arrayList, "ui.ui.setOnShareQZoneHandler") || contains(arrayList, "ui.ui.setOnShareWXFriendHandler") || contains(arrayList, "ui.setOnShareWXTimelineHandler");
        }
        if (!contains(arrayList, str2)) {
            return false;
        }
        if ("qbizApi.getNetworkType".equals(str2)) {
            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005868", "0X8005868", 0, 0, "", "", "", "");
        } else if ("publicAccount.getLocation".equals(str2)) {
            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X800586A", "0X800586A", 0, 0, "", "", "", "");
        } else if ("ui.closeWebViews".equals(str2)) {
            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X800586D", "0X800586D", 0, 0, "", "", "", "");
        } else if ("troopNotice.showPicture".equals(str2)) {
            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005896", "0X8005896", 0, 0, "1", "", "", "");
        }
        return true;
    }

    public void setRightButtonState(boolean z16) {
        if (z16) {
            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X800586B", "0X800586B", 0, 0, "", "", "", "");
        } else {
            ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X800586C", "0X800586C", 0, 0, "", "", "", "");
        }
        if (this.mRuntime.f() != null) {
            this.mRuntime.f().getWebTitleBarInterface().setRightButton(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map2) {
        if (j3 != 8589934600L) {
            if (j3 != 8589934597L) {
                return false;
            }
            onPause();
            return false;
        }
        if (map2 == null) {
            return false;
        }
        int intValue = ((Integer) map2.get("requestCode")).intValue();
        if (intValue != 1 && intValue != 113 && intValue != 114 && intValue != 115 && intValue != 116 && intValue != 117 && intValue != 118 && intValue != 119 && intValue != 122) {
            return false;
        }
        onActivityResult((Intent) map2.get("data"), (byte) intValue, ((Integer) map2.get(QzoneIPCModule.RESULT_CODE)).intValue());
        return true;
    }

    private void innerOpenCameraCaptureActivity(String str, String str2, int i3, int i16, String str3, String str4, String str5, String str6, String str7, String str8) {
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin
    public WebViewPlugin getWebViewPlugin() {
        return this;
    }

    public void hideWebToolbar() {
    }

    public void showWebToolbar() {
    }
}
