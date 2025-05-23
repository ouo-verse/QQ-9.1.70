package cooperation.qzone.webviewplugin.personalize;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.tencent.ads.data.AdParam;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.af;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.peak.PeakConstants;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import cooperation.qzone.model.Size;
import cooperation.qzone.util.QZonePermission;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin;
import cooperation.vip.manager.MonitorManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QZoneCoverStoreJsPlugin extends WebViewPlugin {
    public static final String ACTION_OPEN_VIP_INFO_SUCC = "openVipInfo";
    public static final String ACTION_VIDEO_COVER_SETTING = "com.tencent.mobileqq.action.ACTION_VIDEO_COVER_SETTING";
    public static final String FORWARD_VIDEO_COVER = "forwardSelectVideoCover";
    public static final String GET_WIDGET_ENABLE = "getWidgetEnable";
    public static final String INIT_PLUGIN = "Init";
    public static final String LAUNCH_CUSTOM = "goToUserDefine";
    public static final String LAUNCH_PHOTOWALL = "goToPhotoWall";
    public static final String LEFT_BUTTON_CLICK = "leftButtonClick";
    private static final String MTA_TRANSFORM_PHOTO_TO_BASE_64 = "Qzone.EventTransformPhotoBase64";
    private static final int NOTIFY_H5_VIDEO_TYPE_ALBUM_PIC = 1;
    private static final int NOTIFY_H5_VIDEO_TYPE_BASE64_PIC = 0;
    public static final int OPEN_WHAT_MOBILE_ALUBM = 0;
    public static final int OPEN_WHAT_QZONE_ALBUM = 1;
    public static final int OPEN_WHAT_QZONE_VIDEO = 5;
    public static final int OPEN_WHAT_SET_COVER = 4;
    public static final int OPEN_WHAT_SET_LOCAL_COVER = 6;
    public static final int OPEN_WHAT_SET_WIDGET_ENABLE = 3;
    public static final int OPEN_WHAT_SET_WIDGET_ID = 2;
    public static final String OPEN_YELLOW_DIAMOND = "openYellowDiamond";
    public static final String PERMISSION = "com.tencent.msg.permission.pushnotify";
    public static final String PKG_NAME = "QzCover";
    public static final String SET_ACTIVITY_NAME = "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity";
    public static final String SET_COVER = "setCover";
    public static final String SET_LOCAL_COVER = "setLocalCover";
    public static final String SET_WIDGET = "setWidget";
    public static final String SET_WIDGET_ENABLE = "setWidgetEnable";
    public static final String SHOW_RIGHT_VIEW = "showStoreButton";
    public static final String TAG = "CoverStore";
    public static final int VIDEO_COVER_SOURCE_QZONE_VIDEO = 1;
    public static final int VIDEO_COVER_SOURCE_RECORD_VIDEO = 2;
    public int mSource = 0;
    public int mFrom = 4;
    public String mAid = "";
    String type = "";
    public int mVipType = 0;
    public int mOpenMouth = 0;
    private int mVideoCoverFrom = 0;
    private volatile boolean mReceiverRegistered = false;
    BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            QZoneCoverStoreJsPlugin.this.notifyH5(intent);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void forwardInstallAndStartUpVideoActivity(final int i3) {
        QZoneVideoCommonUtils.forwardInstallAndStartUpVideoActivity(this.mRuntime.b().getLongAccountUin(), this.mRuntime.a(), QZoneVideoCommonUtils.REFER_SHORT_VIDEO_FOR_VIDEO_COVER, new QZoneVideoCommonUtils.onForwardVideoActivityFailedListener() { // from class: cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin.3
            @Override // cooperation.qzone.QZoneVideoCommonUtils.onForwardVideoActivityFailedListener
            public void onFail(Activity activity, String str) {
                QQToast.makeText(activity, str, 0).show(i3);
            }
        });
    }

    private int generateRequestCode(int i3) {
        WebViewPlugin.b bVar = this.mRuntime;
        y d16 = bVar.d(bVar.a());
        return d16 instanceof af ? ((af) d16).switchRequestCode(this, (byte) i3) : i3;
    }

    private String getAid() {
        int i3 = this.mFrom;
        if (i3 == 1) {
            return "jhan-cover1";
        }
        if (i3 == 2) {
            return "jhan-cover2";
        }
        if (i3 == 3) {
            return "jhan-ziliaocover";
        }
        if (i3 == 5) {
            return "jhan-cover1b";
        }
        if (i3 == 6) {
            return "jhan-cover2b";
        }
        if (i3 != 7) {
            return "jhan-cover1";
        }
        return "jhan-ziliaocoverb";
    }

    private void lauchVideoCover(int i3) {
        if (this.mRuntime.b() == null || this.mRuntime.a() == null) {
            return;
        }
        final int dimensionPixelSize = this.mRuntime.a().getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        if (!QZoneHelper.isBestPerformanceDevice()) {
            QQToast.makeText(this.mRuntime.a(), R.string.gpg, 0).show(dimensionPixelSize);
            return;
        }
        registerBroadcast();
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            QLog.i("CoverStore", 1, "VIDEO_COVER click select record video.");
            if (QZonePermission.requestStoragePermission(this.mRuntime.a(), new QQPermission.BasePermissionsListener() { // from class: cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin.2
                @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                public void onAllGranted() {
                    super.onAllGranted();
                    QZoneCoverStoreJsPlugin.this.forwardInstallAndStartUpVideoActivity(dimensionPixelSize);
                }
            }, QQPermissionConstants.Business.SCENE.QQ_QZONE_JS_OPEN_CAMERA)) {
                forwardInstallAndStartUpVideoActivity(dimensionPixelSize);
                return;
            }
            return;
        }
        QLog.i("CoverStore", 1, "VIDEO_COVER click select qzone video.");
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        userInfo.qzone_uin = this.mRuntime.b().getCurrentAccountUin();
        BaseBusinessAlbumInfo baseBusinessAlbumInfo = new BaseBusinessAlbumInfo();
        baseBusinessAlbumInfo.mAlbumId = userInfo.qzone_uin;
        baseBusinessAlbumInfo.mUin = this.mRuntime.b().getLongAccountUin();
        baseBusinessAlbumInfo.mAlbumType = 10;
        baseBusinessAlbumInfo.mAnonymity = 10;
        baseBusinessAlbumInfo.mTitle = this.mRuntime.a().getString(R.string.gcu);
        QZoneHelper.forwardToPersonalAlbumVideoList(this.mRuntime.a(), userInfo, baseBusinessAlbumInfo, -1, QZoneVideoCommonUtils.REFER_SHORT_VIDEO_FOR_VIDEO_COVER);
    }

    private void launchCustom(String str) {
        if ("MobileAlbum".equals(str)) {
            if (this.mRuntime.b() == null || this.mRuntime.a() == null) {
                return;
            }
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(this.mRuntime.a(), IPhotoLogicFactory.PHOTO_LIST_ACTIVITY_URI);
            Bundle bundle = new Bundle();
            bundle.putInt("PhotoConst.MAXUM_SELECTED_NUM", 1);
            bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", QQBrowserActivity.class.getName());
            bundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
            bundle.putBoolean("PhotoConst.IS_SINGLE_MODE", true);
            bundle.putBoolean("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
            activityURIRequest.extra().putBoolean(PeakConstants.IS_WAIT_DEST_RESULT, true);
            bundle.putBoolean(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
            bundle.putInt(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 1);
            bundle.putInt("uintype", 0);
            QZoneHelper.addSource(activityURIRequest);
            activityURIRequest.extra().putAll(bundle);
            ((AbsBaseWebViewActivity) this.mRuntime.a()).gotoSelectPicture(this, activityURIRequest, (byte) 2);
            return;
        }
        if (!"QzoneAlbum".equals(str) || this.mRuntime.b() == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("key_personal_album_enter_model", 2);
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        userInfo.qzone_uin = this.mRuntime.b().getAccount();
        bundle2.putString("keyAction", "actionSelectPicture");
        bundle2.putBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_NEED_CHANGE_TO_JPG, false);
        QZoneHelper.forwardToPersonalAlbumSelect(this.mRuntime.a(), userInfo, bundle2, generateRequestCode(3));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0050 A[Catch: JSONException -> 0x0072, TryCatch #0 {JSONException -> 0x0072, blocks: (B:3:0x0006, B:5:0x001b, B:8:0x0025, B:9:0x002a, B:11:0x0050, B:12:0x0068, B:16:0x0054, B:18:0x005a, B:19:0x005d, B:21:0x0066, B:22:0x0028), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0054 A[Catch: JSONException -> 0x0072, TryCatch #0 {JSONException -> 0x0072, blocks: (B:3:0x0006, B:5:0x001b, B:8:0x0025, B:9:0x002a, B:11:0x0050, B:12:0x0068, B:16:0x0054, B:18:0x005a, B:19:0x005d, B:21:0x0066, B:22:0x0028), top: B:2:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseSourceAndFrom(String str) {
        String optString;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("from");
            if (!string.equals("qzone") && !string.equals(QzoneCoverConst.REFER_USERHOME)) {
                this.mSource = 1;
                this.mFrom = Integer.parseInt(jSONObject.getString("page"));
                this.mAid = jSONObject.getString("aid");
                optString = jSONObject.optString("viptype", "COMMON_VIP");
                if (!"STAR_VIP".equals(optString)) {
                    this.mVipType = 3;
                } else if ("COMMON_VIP".equals(optString)) {
                    this.mVipType = 1;
                } else if ("NOBLE_VIP".equals(optString)) {
                    this.mVipType = 2;
                }
                this.mOpenMouth = jSONObject.optInt("openmonth", 0);
            }
            this.mSource = 0;
            this.mFrom = Integer.parseInt(jSONObject.getString("page"));
            this.mAid = jSONObject.getString("aid");
            optString = jSONObject.optString("viptype", "COMMON_VIP");
            if (!"STAR_VIP".equals(optString)) {
            }
            this.mOpenMouth = jSONObject.optInt("openmonth", 0);
        } catch (JSONException e16) {
            MonitorManager.f().h(1, 4, " parse json error " + e16, false);
            QLog.e("CoverStore", 2, " handle exception " + e16);
        }
    }

    private String parseUserDefineType(String str) {
        JSONObject jSONObject;
        String string;
        String str2 = "";
        try {
            jSONObject = new JSONObject(str);
            str2 = jSONObject.getString("type");
            string = jSONObject.getString("from");
        } catch (JSONException e16) {
            QLog.e("CoverStore", 2, " handle exception " + e16);
        }
        if (!string.equals("qzone") && !string.equals(QzoneCoverConst.REFER_USERHOME)) {
            this.mSource = 1;
            this.mFrom = Integer.parseInt(jSONObject.getString("page"));
            return str2;
        }
        this.mSource = 0;
        this.mFrom = Integer.parseInt(jSONObject.getString("page"));
        return str2;
    }

    private boolean parseWidgetEnable(String str) {
        try {
            return new JSONObject(str).getBoolean("enable");
        } catch (JSONException e16) {
            MonitorManager.f().h(2, 4, " parse json error " + e16, false);
            QLog.e("CoverStore", 2, " handle exception " + e16);
            return false;
        }
    }

    private int parseWidgetId(String str) {
        try {
            return new JSONObject(str).getInt("widgetId");
        } catch (JSONException e16) {
            MonitorManager.f().h(2, 4, " parse json error " + e16, false);
            QLog.e("CoverStore", 2, " handle exception " + e16);
            return 0;
        }
    }

    private void registerBroadcast() {
        Activity a16;
        if (this.mReceiverRegistered) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CoverStore", 2, "video cover registerBroadcast start");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.action.ACTION_VIDEO_COVER_SETTING");
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || (a16 = bVar.a()) == null || this.mReceiverRegistered) {
            return;
        }
        try {
            a16.registerReceiver(this.mReceiver, intentFilter, "com.tencent.msg.permission.pushnotify", null);
            this.mReceiverRegistered = true;
        } catch (Exception e16) {
            QLog.e("CoverStore", 2, "regist receiver error:" + e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return PKG_NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        registerBroadcast();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        Activity a16 = this.mRuntime.a();
        if (a16 != null && this.mReceiverRegistered) {
            try {
                a16.unregisterReceiver(this.mReceiver);
                this.mReceiverRegistered = false;
            } catch (Exception e16) {
                QLog.e("CoverStore", 2, e16, "unregisterReceiver exception");
            }
        }
        super.onDestroy();
    }

    private void parseVideoCoverData(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            this.mVideoCoverFrom = new JSONObject(str).optInt("source", 0);
        } catch (JSONException e16) {
            MonitorManager.f().h(2, 4, " parse json error " + e16, false);
            QLog.e("CoverStore", 2, " handle exception " + e16);
        }
    }

    private void toBase64(ArrayList<String> arrayList) {
        Size bitmapSize;
        boolean z16;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String str = arrayList.get(i3);
                if (!TextUtils.isEmpty(str) && (bitmapSize = QzoneDynamicAlbumPlugin.getBitmapSize(str)) != null) {
                    double ratio = QzoneDynamicAlbumPlugin.getRatio(bitmapSize);
                    if (ratio > 0.0d) {
                        bitmapSize.width = (int) (bitmapSize.width / ratio);
                        bitmapSize.height = (int) (bitmapSize.height / ratio);
                    }
                    String encodeBase64File = QzoneDynamicAlbumPlugin.encodeBase64File(str, bitmapSize.width, bitmapSize.height);
                    if (!TextUtils.isEmpty(encodeBase64File)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("type", this.type);
                        jSONObject.put("data", "data:image/jpg;base64," + encodeBase64File);
                        callJs("window.QZImagePickerJSInterface.onReceive(" + jSONObject.toString() + ")");
                        z16 = true;
                    } else {
                        QLog.e("CoverStore", 1, "toBase64 fail. path:" + str);
                        z16 = false;
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("isSucc", Integer.valueOf(z16 ? 1 : 0));
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, MTA_TRANSFORM_PHOTO_TO_BASE_64, z16, currentTimeMillis2, 0L, hashMap, null);
                }
            } catch (Exception e16) {
                QLog.e("CoverStore", 1, "toBase64: " + e16);
                return;
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        CustomWebView e16;
        if (i3 == -1) {
            if (b16 == 2) {
                callJs("window.QZImagePickerJSInterface.doSelectPhoto");
                ArrayList<String> arrayList = new ArrayList<>();
                String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
                if (!TextUtils.isEmpty(stringExtra)) {
                    arrayList.add(stringExtra);
                }
                toBase64(arrayList);
                return;
            }
            if (b16 == 3) {
                callJs("window.QZImagePickerJSInterface.doSelectPhoto");
                toBase64(intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
                return;
            }
            if (b16 != 4) {
                if (b16 != 7) {
                    if (b16 == 8 && intent != null && intent.getBooleanExtra("needJump", false) && this.mRuntime.a() != null) {
                        this.mRuntime.a().finish();
                        return;
                    }
                    return;
                }
                if (intent == null || !intent.getBooleanExtra("need_jump", false) || this.mRuntime.a() == null) {
                    return;
                }
                this.mRuntime.a().finish();
                return;
            }
            if (i3 != -1 || (e16 = this.mRuntime.e()) == null) {
                return;
            }
            e16.callJs("window.QzCoverJSInterface.onReceive({type:\"YellowInfo\",data:{vipType:\"normalVip\"}});");
            if (intent != null) {
                try {
                    String string = intent.getExtras().getString(QZoneHelper.QZONE_VIP_OPEN_SUCC_STR);
                    if (TextUtils.isEmpty(string)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(string);
                    dispatchJsEvent("openVipInfo", jSONObject, jSONObject);
                } catch (Exception e17) {
                    QLog.e("CoverStore", 2, e17.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        TextView textView;
        if (!PKG_NAME.equals(str2)) {
            return false;
        }
        if (str3.equals(LAUNCH_PHOTOWALL)) {
            return true;
        }
        if (str3.equals(SHOW_RIGHT_VIEW)) {
            if (this.mRuntime.a() != null && (textView = (TextView) this.mRuntime.a().findViewById(R.id.ivTitleBtnRightText)) != null) {
                textView.setVisibility(0);
                textView.setTextColor(-1);
                textView.setText(HardCodeUtil.qqStr(R.string.rpp));
                textView.setOnClickListener(new View.OnClickListener() { // from class: cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        if (QZoneCoverStoreJsPlugin.this.mRuntime.b() != null && QZoneCoverStoreJsPlugin.this.mRuntime.e() != null) {
                            QZoneCoverStoreJsPlugin.this.mRuntime.e().loadUrl(QZoneHelper.QZoneCoverConstants.getCoverStoreUrl("qzone", String.valueOf(1), QZoneCoverStoreJsPlugin.this.mRuntime.b().getAccount(), QZoneCoverStoreJsPlugin.this.mRuntime.b().getAccount()));
                        }
                        EventCollector.getInstance().onViewClicked(view);
                    }
                });
            }
        } else {
            if (str3.equals(LAUNCH_CUSTOM)) {
                String parseUserDefineType = parseUserDefineType(strArr[0]);
                this.type = parseUserDefineType;
                launchCustom(parseUserDefineType);
                return true;
            }
            if (FORWARD_VIDEO_COVER.equals(str3)) {
                if (strArr != null && strArr.length > 0) {
                    parseVideoCoverData(strArr[0]);
                }
                lauchVideoCover(this.mVideoCoverFrom);
                return true;
            }
            if (str3.equals(SET_WIDGET_ENABLE)) {
                boolean parseWidgetEnable = parseWidgetEnable(strArr[0]);
                Intent intent = new Intent();
                QzonePluginProxyActivity.setActivityNameToIntent(intent, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
                intent.putExtra("open_what", 3);
                intent.putExtra("widgetEnable", parseWidgetEnable);
                if (this.mRuntime.a() != null && this.mRuntime.b() != null) {
                    QzonePluginProxyActivity.launchPluingActivityForResult(this.mRuntime.a(), this.mRuntime.b().getAccount(), intent, generateRequestCode(6));
                }
            } else if (str3.equals(SET_WIDGET)) {
                int parseWidgetId = parseWidgetId(strArr[0]);
                Intent intent2 = new Intent();
                QzonePluginProxyActivity.setActivityNameToIntent(intent2, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
                intent2.putExtra("open_what", 2);
                intent2.putExtra("widgetId", parseWidgetId);
                if (this.mRuntime.a() != null && this.mRuntime.b() != null) {
                    QzonePluginProxyActivity.launchPluingActivityForResult(this.mRuntime.a(), this.mRuntime.b().getAccount(), intent2, generateRequestCode(5));
                }
            } else if (str3.equals(OPEN_YELLOW_DIAMOND)) {
                if (strArr != null && strArr.length > 0) {
                    parseSourceAndFrom(strArr[0]);
                }
                if (this.mRuntime.b() == null || this.mRuntime.a() == null) {
                    return false;
                }
                String account = this.mRuntime.b().getAccount();
                Intent intent3 = new Intent();
                String qqStr = HardCodeUtil.qqStr(R.string.rpn);
                QzonePluginProxyActivity.setActivityNameToIntent(intent3, QZoneHelper.OPEN_VIP);
                if (TextUtils.isEmpty(this.mAid)) {
                    this.mAid = getAid();
                }
                intent3.putExtra("aid", this.mAid);
                intent3.putExtra("success_tips", qqStr);
                intent3.putExtra("direct_go", true);
                intent3.putExtra("viptype", this.mVipType);
                intent3.putExtra("month", this.mOpenMouth);
                QzonePluginProxyActivity.launchPluingActivityForResult(this.mRuntime.a(), account, intent3, generateRequestCode(4), null, false, null, true);
            } else {
                if (str3.equals("setCover")) {
                    if (strArr != null && !TextUtils.isEmpty(strArr[0])) {
                        try {
                            if (QzoneCoverConst.CoverStringType.COVER_TYPE_PHOTOWALL.equals(new JSONObject(strArr[0]).getString("coverType")) && this.mRuntime.a() != null) {
                                if (this.mRuntime.b() != null) {
                                    return true;
                                }
                            }
                        } catch (JSONException e16) {
                            QLog.e("CoverStore", 2, " handle exception " + e16);
                            MonitorManager.f().h(2, 4, "set cover data exception " + e16, false);
                        }
                        Intent intent4 = new Intent();
                        QzonePluginProxyActivity.setActivityNameToIntent(intent4, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
                        intent4.putExtra("open_what", 4);
                        intent4.putExtra("cover", strArr[0]);
                        if (this.mRuntime.a() != null && this.mRuntime.b() != null) {
                            QzonePluginProxyActivity.launchPluingActivityForResult(this.mRuntime.a(), this.mRuntime.b().getAccount(), intent4, generateRequestCode(7));
                        }
                    }
                    return true;
                }
                if (!SET_LOCAL_COVER.equals(str3) && !QZoneJsConstants.METHOD_REFRESH_FEEDS.equals(str3)) {
                    if (str3.equals(GET_WIDGET_ENABLE)) {
                        if (this.mRuntime.b() == null || this.mRuntime.a() == null) {
                            return false;
                        }
                        jsBridgeListener.c(Boolean.valueOf(this.mRuntime.a().getSharedPreferences(LocalMultiProcConfig.WIDGET_CONFIG_PREFIX + this.mRuntime.b().getCurrentAccountUin(), 4).getBoolean("WidgetShow", true)));
                        return true;
                    }
                    if (str3.equals(LEFT_BUTTON_CLICK)) {
                        if (this.mRuntime.a() == null) {
                            return false;
                        }
                        ((TextView) this.mRuntime.a().findViewById(R.id.ivTitleBtnLeft)).performClick();
                        return true;
                    }
                    if (INIT_PLUGIN.equals(str3)) {
                        QLog.i("CoverStore", 2, "QzCover.Init called.");
                        return true;
                    }
                } else {
                    if (strArr != null && !TextUtils.isEmpty(strArr[0])) {
                        Intent intent5 = new Intent();
                        QzonePluginProxyActivity.setActivityNameToIntent(intent5, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
                        intent5.putExtra("open_what", 6);
                        intent5.putExtra("cover", strArr[0]);
                        if (this.mRuntime.a() != null && this.mRuntime.b() != null) {
                            QzonePluginProxyActivity.launchPluingActivityForResult(this.mRuntime.a(), this.mRuntime.b().getAccount(), intent5, generateRequestCode(8));
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyH5(Intent intent) {
        String str;
        if (intent == null) {
            return;
        }
        String str2 = "CoverStore";
        if (QLog.isColorLevel()) {
            QLog.i("CoverStore", 2, "video cover setting start,notify to h5");
        }
        try {
            int intExtra = intent.getIntExtra(PeakConstants.INTENT_COVER_SETTING_TYPE, 0);
            if (intExtra != 0) {
                if (intExtra == 2) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(AdParam.COVERID, intent.getStringExtra(PeakConstants.COVER_ID));
                    String str3 = "window.QZVideoCoverJSInterface.CancelVideoCover(" + jSONObject.toString() + ")";
                    callJs(str3);
                    if (QLog.isColorLevel()) {
                        QLog.i("CoverStore", 2, "video cover notify h5:" + str3);
                        return;
                    }
                    return;
                }
                if (intExtra == 1) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(AdParam.COVERID, intent.getStringExtra(PeakConstants.COVER_ID));
                    String str4 = "window.QZVideoCoverJSInterface.onSetVideoCover(" + jSONObject2.toString() + ")";
                    callJs(str4);
                    if (QLog.isColorLevel()) {
                        QLog.i("CoverStore", 2, "video cover notify h5:" + str4);
                        return;
                    }
                    return;
                }
                return;
            }
            int intExtra2 = intent.getIntExtra(PeakConstants.VIDEO_TYPE, -1);
            String stringExtra = intent.getStringExtra(PeakConstants.VIDEO_THUMBNAIL_PATH);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (intExtra2 == 2) {
                jSONObject3.put("type", 1);
                jSONObject3.put("picurl", stringExtra);
                jSONObject3.put("videoid", intent.getStringExtra(PeakConstants.QZONE_ALBUM_VIDEO_ID));
                jSONObject3.put("videowidth", intent.getIntExtra(PeakConstants.VIDEO_THUMBNAIL_WIDTH, 0));
                jSONObject3.put("videoheight", intent.getIntExtra(PeakConstants.VIDEO_THUMBNAIL_HEIGHT, 0));
                jSONObject3.put("videourl", intent.getStringExtra("file_send_path"));
            } else {
                if (intExtra2 != 0 && 1 != intExtra2) {
                    QLog.w("CoverStore", 1, "unknown video type");
                    return;
                }
                Size bitmapSize = QzoneDynamicAlbumPlugin.getBitmapSize(stringExtra);
                if (bitmapSize == null) {
                    return;
                }
                double ratio = QzoneDynamicAlbumPlugin.getRatio(bitmapSize);
                if (ratio > 0.0d) {
                    str = "CoverStore";
                    try {
                        bitmapSize.width = (int) (bitmapSize.width / ratio);
                        bitmapSize.height = (int) (bitmapSize.height / ratio);
                    } catch (Exception e16) {
                        e = e16;
                        str2 = str;
                        MonitorManager.f().h(2, 5, " exception notify H5 " + e, false);
                        QLog.e(str2, 2, " handle exception " + e);
                        return;
                    }
                } else {
                    str = "CoverStore";
                }
                String encodeBase64File = QzoneDynamicAlbumPlugin.encodeBase64File(stringExtra, bitmapSize.width, bitmapSize.height);
                if (TextUtils.isEmpty(encodeBase64File)) {
                    QLog.w(str, 1, "video cover pic not exist,imageBase64 empty. path=" + stringExtra);
                    return;
                }
                str2 = str;
                jSONObject3.put("type", 0);
                jSONObject3.put("data", "data:image/jpg;base64," + encodeBase64File);
                jSONObject3.put("videowidth", intent.getIntExtra(PeakConstants.VIDEO_THUMBNAIL_WIDTH, 0));
                jSONObject3.put("videoheight", intent.getIntExtra(PeakConstants.VIDEO_THUMBNAIL_HEIGHT, 0));
            }
            String str5 = "window.QZVideoCoverJSInterface.onSetCover(" + jSONObject3.toString() + ")";
            if (QLog.isColorLevel()) {
                QLog.i(str2, 2, "video cover notify h5:" + str5);
            }
            callJs(str5);
        } catch (Exception e17) {
            e = e17;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (j3 == 8589934600L) {
            int intValue = Integer.valueOf(String.valueOf(map.get("requestCode"))).intValue();
            Intent intent = (Intent) map.get("data");
            int intValue2 = Integer.valueOf(String.valueOf(map.get(QzoneIPCModule.RESULT_CODE))).intValue();
            if (intValue == generateRequestCode(2) || intValue == generateRequestCode(3)) {
                if (intValue2 != -1) {
                    return true;
                }
                callJs("window.QZImagePickerJSInterface.doSelectPhoto");
                ArrayList<String> arrayList = new ArrayList<>();
                String stringExtra = intent.getStringExtra(QZoneHelper.QZoneAlbumConstants.KEY_COVER_SELECTED_IMG_PATH);
                if (TextUtils.isEmpty(stringExtra)) {
                    return true;
                }
                arrayList.add(stringExtra);
                toBase64(arrayList);
                return true;
            }
        }
        return super.handleEvent(str, j3, map);
    }
}
