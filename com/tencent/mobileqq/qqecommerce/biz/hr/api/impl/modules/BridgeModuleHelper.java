package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.qqstory.utils.l;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.api.GdtAdError;
import com.tencent.gdtad.api.GdtAdListener;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.WebSsoBody$WebSsoResponseBody;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.adapter.ui.ComponentAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.e;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import fk0.d;
import java.io.File;
import java.util.ArrayList;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes35.dex */
public class BridgeModuleHelper {

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f262654d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a f262655e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f262656f;

        a(JSONObject jSONObject, com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, String str) {
            this.f262654d = jSONObject;
            this.f262655e = aVar;
            this.f262656f = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("button", 1);
                jSONObject.put("buttonText", this.f262654d.optString("okBtnText", ""));
                com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar = this.f262655e;
                if (aVar != null) {
                    aVar.T(this.f262656f, jSONObject);
                }
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("BridgeModuleHelper", 2, "showDialog error" + e16.getMessage());
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f262657d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a f262658e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f262659f;

        b(JSONObject jSONObject, com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, String str) {
            this.f262657d = jSONObject;
            this.f262658e = aVar;
            this.f262659f = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("button", 0);
                jSONObject.put("buttonText", this.f262657d.optString("cancelBtnText", ""));
                com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar = this.f262658e;
                if (aVar != null) {
                    aVar.T(this.f262659f, jSONObject);
                }
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("BridgeModuleHelper", 2, "showDialog error" + e16.getMessage());
                }
            }
        }
    }

    public static void A(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiniGamePAHippyBaseFragment.KEY_THEME, ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null) ? 1 : 0);
            aVar.T(str, jSONObject);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0099, code lost:
    
        if (com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor.queryIntentActivities(r6, r9, 0).size() > 0) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void B(String str, String str2, String str3, String str4, String str5, String str6) {
        if (QLog.isColorLevel()) {
            QLog.d("BridgeModuleHelper", 2, "launchAppWithTokens " + str3);
        }
        eq2.a aVar = new eq2.a();
        AppInterface appInterface = HippyUtils.getAppInterface();
        if (appInterface == null) {
            return;
        }
        boolean z16 = true;
        try {
            int parseInt = Integer.parseInt(str4);
            r6 = (parseInt & 67108864) == 67108864 ? 335544320 : 268435456;
            if ((parseInt & 536870912) == 536870912) {
                r6 |= 536870912;
            }
            if ((parseInt & 4194304) == 4194304) {
                r6 |= 4194304;
            }
        } catch (Exception e16) {
            QLog.e("BridgeModuleHelper", 1, e16, new Object[0]);
        }
        int i3 = r6;
        String str7 = "tencentwtlogin" + str + QzoneWebViewOfflinePlugin.STR_DEVIDER;
        if (util.FILE_DIR.equals(str5)) {
            PackageManager packageManager = h().getPackageManager();
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.setData(Uri.parse(str7));
            if (packageManager != null) {
            }
        }
        z16 = false;
        if (z16) {
            aVar.f(str7, h(), "", appInterface, str, str3, i3, str6);
        } else {
            aVar.d(appInterface, h(), str, str2, str3, i3);
        }
    }

    public static void E(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, JSONObject jSONObject, String str) {
        Activity a16 = aVar.getViolaInstance().a();
        try {
            if (jSONObject != null && a16 != null) {
                long j3 = jSONObject.getLong(IPublicAccountBrowser.KEY_PUB_UIN);
                ActivityURIRequest activityURIRequest = new ActivityURIRequest(a16, IPublicAccountDetailActivity.ROUTE_NAME);
                activityURIRequest.extra().putString("uin", "" + j3);
                activityURIRequest.extra().putBoolean(IPublicAccountDetailActivity.FROM_JS, true);
                QRoute.startUri(activityURIRequest, (o) null);
                aVar.T(str, null);
            } else {
                aVar.U(str, QWalletMixJsPlugin.ERROR_MSG_PARAM_ERROR);
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("BridgeModuleHelper", 2, "openAccountPageMore->error:" + e16);
            }
        }
    }

    public static void F(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, String str, JSONObject jSONObject, Activity activity) {
        if (activity == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("res", 1);
            if (((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(activity, jSONObject.optString("miniAppUrl"), 2103, null)) {
                jSONObject2.put("res", 0);
                aVar.T(str, jSONObject2);
            } else {
                aVar.T(str, jSONObject2);
            }
        } catch (Exception unused) {
            aVar.T(str, jSONObject2);
        }
    }

    public static void G(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, String str) {
        Activity a16 = aVar.getViolaInstance().a();
        if (a16 == null || a16.isFinishing()) {
            return;
        }
        if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a.x().getApplication(), 1, HardCodeUtil.qqStr(R.string.k3j), 0).show();
            return;
        }
        File file = new File(AbsDownloader.getFilePath(str));
        if (file.exists()) {
            H(aVar, file);
        } else {
            Q(aVar, str, file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void H(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, File file) {
        Activity a16 = aVar.getViolaInstance().a();
        if (a16 == null || a16.isFinishing()) {
            return;
        }
        String absolutePath = file.getAbsolutePath();
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, absolutePath);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, absolutePath);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, absolutePath);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        ForwardBaseOption.startForwardActivityForResult(a16, intent, 18);
    }

    public static void M(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, JSONObject jSONObject, String str) {
        if (QLog.isColorLevel()) {
            QLog.i("BridgeModuleHelper", 2, "showPictureWithRowKey, json=" + jSONObject + ", callbackId=" + str);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("imageIDs");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                String optString = optJSONArray.optString(i3, "");
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(optString);
                }
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, arrayList);
            bundle.putString("src_id", jSONObject.optString("srcID"));
            bundle.putInt("index", jSONObject.optInt("index"));
            bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_IS_NOT_SHOW_INDEX, true);
            bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_SHOW_TITLE_BAR, jSONObject.optBoolean("showTitleBar", true));
            bundle.putString(TroopAvatarWallPreviewActivity.KEY_ACTICLE_INFO_ROWKEY, jSONObject.optString("rowkey"));
            bundle.putString(TroopAvatarWallPreviewActivity.KEY_CALLBACK_SEQ, str);
            bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_SHOW_SOCIAL_BOTTOM_BAR, true);
            bundle.putString(TroopAvatarWallPreviewActivity.KEY_SHOW_SOCIAL_BOTTOM_BAR_DATA, jSONObject.optJSONObject("socialBottomBar").toString());
            bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_NEED_TO_AIO, false);
            S(aVar, bundle);
            return;
        }
        QLog.e("BridgeModuleHelper", 1, "showPictureWithRowKey imageJSONArray is Empty");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        if (r7 != 6) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void O(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, JSONObject jSONObject, String str) {
        QQAppInterface qQAppInterface = (QQAppInterface) com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a.x();
        if (qQAppInterface == null) {
            return;
        }
        MobileQQ application = qQAppInterface.getApplication();
        String optString = jSONObject.optString("text");
        int i3 = 2;
        int optInt = jSONObject.optInt("iconMode", 2);
        if (!TextUtils.isEmpty(optString)) {
            if (optInt != 0) {
                if (optInt != 1) {
                    if (optInt == 2) {
                        i3 = 1;
                    } else if (optInt == 3) {
                        i3 = 6;
                    }
                }
                QQToast.makeText(application, i3, optString, 0).show(application.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                aVar.T(str, new JSONObject());
                return;
            }
            i3 = 0;
            QQToast.makeText(application, i3, optString, 0).show(application.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            aVar.T(str, new JSONObject());
            return;
        }
        aVar.U(str, "text\u4e3anull!!");
    }

    private static void Q(final com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, final String str, File file) {
        Bundle bundle = new Bundle();
        g gVar = new g(str, file);
        gVar.A = 60L;
        ((DownloaderFactory) com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a.x().getManager(QQManagerFactory.DOWNLOADER_FACTORY)).u(1).startDownload(gVar, new f() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.BridgeModuleHelper.3
            @Override // com.tencent.mobileqq.vip.f
            public void onDone(g gVar2) {
                Activity a16 = com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a.this.getViolaInstance().a();
                if (a16 == null || a16.isFinishing()) {
                    return;
                }
                if (gVar2.f313006d == 0) {
                    final File file2 = new File(AbsDownloader.getFilePath(str));
                    if (file2.exists()) {
                        if (QLog.isColorLevel()) {
                            QLog.d("BridgeModuleHelper", 2, "shareImageToAIO->downloadFile success: " + str);
                        }
                        a16.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.BridgeModuleHelper.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BridgeModuleHelper.H(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a.this, file2);
                            }
                        });
                        return;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("BridgeModuleHelper", 2, "shareImageToAIO->downloadFile failed: " + str);
                }
                a16.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.BridgeModuleHelper.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToast.makeText(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a.x().getApplication(), 1, HardCodeUtil.qqStr(R.string.k38), 0).show();
                    }
                });
            }
        }, bundle);
    }

    public static void R(JSONObject jSONObject) {
        if (TextUtils.isEmpty(jSONObject.optString("url", ""))) {
            return;
        }
        String optString = jSONObject.optString("url", "");
        boolean optBoolean = jSONObject.optBoolean(NodeProps.CUSTOM_PROP_ISGIF, false);
        float b16 = jSONObject.has("width") ? com.tencent.ecommerce.richtext.ui.dom.style.g.b(jSONObject.opt("width"), 750) : 100.0f;
        float b17 = jSONObject.has("height") ? com.tencent.ecommerce.richtext.ui.dom.style.g.b(jSONObject.opt("height"), 750) : 100.0f;
        URLDrawable drawable = URLDrawable.getDrawable(optString, ComponentAdapter.s(optBoolean, (int) b16, (int) b17));
        QLog.d("BridgeModuleHelper", 2, "preload image, ur: " + optString + ".isGif:" + optBoolean + ",reqWidth:" + b16 + ",reqHeight:" + b17);
        drawable.startDownload();
    }

    protected static void S(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, Bundle bundle) {
        Activity a16 = aVar.getViolaInstance().a();
        if (a16 != null) {
            Intent intent = new Intent(a16, (Class<?>) TroopAvatarWallPreviewActivity.class);
            intent.putExtras(bundle);
            a16.startActivity(intent);
            return;
        }
        QLog.e("BridgeModuleHelper", 1, "showPictureWithSocialBottomBar error, activity == null");
    }

    public static void V(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, JSONObject jSONObject, String str) {
        if (TextUtils.isEmpty(jSONObject.optString("path"))) {
            aVar.U(str, "path is null");
        }
    }

    public static void b(JSONObject jSONObject) {
        try {
            GdtLog.d("BridgeModuleHelper", jSONObject.toString());
            com.tencent.gdtad.statistics.a.b(jSONObject.optInt("operationType"), jSONObject.optInt("businessType"), (qq_ad_get.QQAdGetRsp.AdInfo) GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), jSONObject.getJSONObject("adInfo")));
        } catch (Exception e16) {
            GdtLog.e("BridgeModuleHelper", "handleJsCallRequest", e16);
        }
    }

    public static Activity h() {
        if (Foreground.getTopActivity() != null) {
            return Foreground.getTopActivity();
        }
        return QBaseActivity.sTopActivity;
    }

    public static void i(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, String str) {
        int i3 = SimpleUIUtil.isNowElderMode() ? 4 : 0;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adMode", i3);
        } catch (JSONException e16) {
            QLog.e("BridgeModuleHelper", 1, "adMode e", e16);
        }
        aVar.T(str, jSONObject);
    }

    public static void j(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", e.a());
            aVar.T(str, jSONObject);
        } catch (Exception e16) {
            QLog.e("BridgeModuleHelper", 1, "getCUKingStatus error e = ", e16);
        }
    }

    public static JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, com.tencent.mobileqq.statistics.o.b());
            jSONObject.put("qua", QZoneHelper.getQUA());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    public static void m(final com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, final String str, final boolean z16) {
        d.c().d(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.BridgeModuleHelper.4
            @Override // java.lang.Runnable
            public void run() {
                JSONObject l3 = BridgeModuleHelper.l();
                if (z16) {
                    aVar.T(str, l3);
                }
            }
        });
    }

    public static void p(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, String str) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.BridgeModuleHelper.6
            @Override // java.lang.Runnable
            public void run() {
            }
        }, 8, null, true);
    }

    public static void q(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, String str, JSONObject jSONObject) {
        Activity h16 = h();
        c cVar = new c(aVar, str);
        if (h16 == null) {
            cVar.onAdFailedToLoad(null, new GdtAdError(5));
        }
    }

    public static JSONObject r() {
        int netWorkType = HttpUtil.getNetWorkType();
        String netWorkTypeByStr = HttpUtil.getNetWorkTypeByStr();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", netWorkType);
            jSONObject.put("radio", netWorkTypeByStr);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    public static void s(final com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, final String str, boolean z16) {
        d.c().d(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.BridgeModuleHelper.5
            @Override // java.lang.Runnable
            public void run() {
                JSONObject r16 = BridgeModuleHelper.r();
                com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar2 = com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a.this;
                if (aVar2 != null) {
                    aVar2.T(str, r16);
                }
            }
        });
    }

    private static String t(QQAppInterface qQAppInterface, String str) {
        IPublicAccountDataManager iPublicAccountDataManager;
        PublicAccountInfo publicAccountInfo;
        String currentNickname = qQAppInterface.getCurrentNickname();
        return (TextUtils.isEmpty(str) || (iPublicAccountDataManager = (IPublicAccountDataManager) qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")) == null || (publicAccountInfo = (PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfoCache(str)) == null) ? currentNickname : publicAccountInfo.name;
    }

    public static String u(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        if (jSONObject == null) {
            str = "";
        } else {
            str = com.tencent.ecommerce.richtext.utils.e.p(jSONObject.opt("toUin"), "");
        }
        return (!TextUtils.isEmpty(str) || jSONObject2 == null) ? str : com.tencent.ecommerce.richtext.utils.e.p(jSONObject2.opt("toUin"), "");
    }

    public static JSONObject v() {
        JSONObject jSONObject = new JSONObject();
        QQAppInterface qQAppInterface = (QQAppInterface) com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a.x();
        if (qQAppInterface != null) {
            String account = qQAppInterface.getAccount();
            String t16 = t(qQAppInterface, account);
            try {
                jSONObject.put("uin", account);
                jSONObject.put("nick", t16);
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("BridgeModuleHelper", 2, "getReportInfo() JSONException" + e16.getMessage());
                }
            }
        }
        return jSONObject;
    }

    public static void w(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject v3 = v();
        if (z16) {
            aVar.T(str, v3);
        }
    }

    @Deprecated
    public static void x(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        QQAppInterface qQAppInterface = (QQAppInterface) com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a.x();
        if (qQAppInterface != null) {
            String account = qQAppInterface.getAccount();
            String a16 = HttpBaseUtil.a(account);
            try {
                jSONObject.put("uin", account);
                jSONObject.put(IPublicAccountBrowser.KEY_PUB_UIN, a16);
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("BridgeModuleHelper", 2, "getUserLoginInfo() JSONException" + e16.getMessage());
                }
            }
        }
        aVar.T(str, jSONObject);
    }

    public static void z(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", true);
        } catch (JSONException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("BridgeModuleHelper", 2, "Error in isMobileQQ");
            }
        }
        aVar.T(str, jSONObject);
    }

    public static void I(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, JSONObject jSONObject, String str) {
        try {
            String optString = jSONObject.optString("imageUrl");
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(optString)) {
                G(aVar, optString);
                jSONObject2.put("retCode", 0);
                aVar.T(str, jSONObject2);
            } else {
                jSONObject2.put("retCode", 1);
                aVar.T(str, jSONObject2);
                QQToast.makeText(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a.x().getApplication(), 1, HardCodeUtil.qqStr(R.string.k3n), 0).show();
            }
        } catch (Exception e16) {
            QLog.e("BridgeModuleHelper", 1, "sharePicMessage exception e = ", e16);
        }
    }

    public static void U(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, JSONObject jSONObject, String str) {
        try {
            if (jSONObject != null) {
                int i3 = jSONObject.getInt("topicId");
                int i16 = jSONObject.getInt("followInfo");
                if (QLog.isColorLevel()) {
                    QLog.d("BridgeModuleHelper", 2, "topic id = " + i3 + "\t follow info =" + i16);
                }
                aVar.T(str, null);
                return;
            }
            aVar.U(str, QWalletMixJsPlugin.ERROR_MSG_PARAM_ERROR);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("BridgeModuleHelper", 2, "openAccountPageMore->error:" + e16);
            }
        }
    }

    public static void o(final com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, final String str, JSONObject jSONObject, final boolean z16) {
        QLog.d("BridgeModuleHelper", 2, "getGdtDeviceInfo callback before");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.BridgeModuleHelper.7
            @Override // java.lang.Runnable
            public void run() {
                qq_ad_get.QQAdGet.DeviceInfo deviceInfo;
                Object pbToJson;
                if (BridgeModuleHelper.h() == null) {
                    return;
                }
                QLog.d("BridgeModuleHelper", 2, "getGdtDeviceInfo callback result");
                Context applicationContext = BridgeModuleHelper.h().getApplicationContext();
                JSONObject jSONObject2 = new JSONObject();
                GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(applicationContext, new GdtDeviceInfoHelper.Params());
                JSONObject jSONObject3 = (create == null || (deviceInfo = create.deviceInfo) == null || (pbToJson = GdtJsonPbUtil.pbToJson(deviceInfo)) == null || !(pbToJson instanceof JSONObject)) ? null : (JSONObject) pbToJson;
                if (jSONObject3 != null && jSONObject3 != JSONObject.NULL) {
                    try {
                        jSONObject2.put("deviceInfo", jSONObject3);
                    } catch (JSONException e16) {
                        GdtLog.e("BridgeModuleHelper", "handleJsCallRequest", e16);
                    }
                } else {
                    GdtLog.e("BridgeModuleHelper", "handleJsCallRequest error");
                }
                if (z16) {
                    aVar.T(str, jSONObject2);
                }
            }
        }, 128, null, true);
    }

    public static void P(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, JSONObject jSONObject, String str) {
        try {
            if (jSONObject != null) {
                jSONObject.getString("feeds_id");
                jSONObject.optString("feeds_type", "1");
                aVar.T(str, null);
            } else {
                aVar.U(str, QWalletMixJsPlugin.ERROR_MSG_PARAM_ERROR);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("BridgeModuleHelper", 2, "openAccountPageMore->error:" + e16);
            }
        }
    }

    public static void T(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, JSONObject jSONObject, String str) {
        try {
            if (jSONObject != null) {
                jSONObject.getLong("followUin");
                jSONObject.getInt("followInfo");
                aVar.T(str, null);
            } else {
                aVar.U(str, QWalletMixJsPlugin.ERROR_MSG_PARAM_ERROR);
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("BridgeModuleHelper", 2, "openAccountPageMore -> error:" + e16);
            }
        }
    }

    public static void c(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.optString("apkUrl") == null || jSONObject.optInt("action", -1) == -1) {
            return;
        }
        int optInt = jSONObject.optInt("action", -1);
        if (optInt == 1) {
            e(jSONObject);
        } else if (optInt == 2) {
            f(jSONObject);
        } else if (optInt == 3) {
            d(jSONObject);
        }
    }

    public static void d(JSONObject jSONObject) {
        if (jSONObject == null || TextUtils.isEmpty(jSONObject.optString("apkUrl"))) {
            return;
        }
        DownloadManagerV2.V().G(jSONObject.optString("apkUrl"), true);
    }

    public static void e(JSONObject jSONObject) {
        if (jSONObject == null || TextUtils.isEmpty(jSONObject.optString("apkUrl"))) {
            return;
        }
        DownloadManagerV2.V().o0(jSONObject.optString("apkUrl"));
    }

    public static void f(JSONObject jSONObject) {
        if (jSONObject == null || TextUtils.isEmpty(jSONObject.optString("apkUrl"))) {
            return;
        }
        String optString = jSONObject.optString("apkUrl");
        DownloadInfo downloadInfo = new DownloadInfo();
        downloadInfo.f341186f = optString;
        downloadInfo.M = "biz_src_feeds_kandianads";
        downloadInfo.m();
        DownloadManagerV2.V().z0(downloadInfo);
    }

    public static void n(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, JSONObject jSONObject, String str) {
        int i3;
        int i16;
        if (jSONObject == null || TextUtils.isEmpty(jSONObject.optString("apkUrl"))) {
            return;
        }
        DownloadInfo S = DownloadManagerV2.V().S(jSONObject.optString("apkUrl"));
        if (S != null) {
            i3 = S.f();
            i16 = S.Q;
        } else {
            i3 = -1;
            i16 = 0;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("state", i3);
            jSONObject2.put("data", i16);
            aVar.T(str, jSONObject2);
        } catch (Exception unused) {
        }
    }

    public static void D(Bundle bundle) {
        String str;
        if (bundle == null) {
            return;
        }
        String str2 = "";
        if (!bundle.containsKey("cmd")) {
            str = "";
        } else {
            str = bundle.getString("cmd");
        }
        if (bundle.containsKey("data_error_msg")) {
            str2 = bundle.getString("data_error_msg");
        }
        QLog.e("BridgeModuleHelper", 1, "request web sso error, cmd: " + str + ", failMsg: " + str2 + ", errorCode: " + (bundle.containsKey("data_error_code") ? bundle.getInt("data_error_code") : -1));
    }

    public static void k(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, String str, Activity activity) {
        if (activity == null) {
            return;
        }
        String Q = ah.Q(activity);
        String P = ah.P();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("qqVersion", P);
            jSONObject.put("qqBuild", Q);
            aVar.T(str, jSONObject);
        } catch (JSONException e16) {
            QLog.e("BridgeModuleHelper", 1, "[getClientInfo]: " + e16.getMessage());
        }
    }

    public static void y(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, String str, String str2, boolean z16, Activity activity) {
        boolean c16;
        if (activity == null) {
            return;
        }
        if (!"weishi://feed".equals(str) && !"weishi".equals(str)) {
            c16 = PackageUtil.isAppInstalled(activity, str);
        } else {
            c16 = l.c(activity);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", c16 ? 1 : 0);
            if (z16) {
                aVar.T(str2, jSONObject);
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("BridgeModuleHelper", 2, "hasApp error" + e16.getMessage());
            }
        }
    }

    public static void C(WebSsoBody$WebSsoResponseBody webSsoBody$WebSsoResponseBody, Bundle bundle) {
        String str;
        if (webSsoBody$WebSsoResponseBody == null || bundle == null) {
            return;
        }
        String str2 = "";
        if (!bundle.containsKey("cmd")) {
            str = "";
        } else {
            str = bundle.getString("cmd");
        }
        PBStringField pBStringField = webSsoBody$WebSsoResponseBody.data;
        if (pBStringField != null) {
            str2 = pBStringField.get();
        }
        PBUInt32Field pBUInt32Field = webSsoBody$WebSsoResponseBody.ret;
        QLog.d("BridgeModuleHelper", 2, "request web sso success, cmd: " + str + ", ret: " + (pBUInt32Field != null ? pBUInt32Field.get() : -1) + ", data: " + str2);
    }

    public static QQCustomDialog J(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, JSONObject jSONObject, String str, Activity activity) {
        QQCustomDialog qQCustomDialog = null;
        if (jSONObject != null) {
            if (activity == null) {
                return null;
            }
            qQCustomDialog = new QQCustomDialog(activity, R.style.qZoneInputDialog);
            qQCustomDialog.setContentView(R.layout.custom_dialog);
            qQCustomDialog.getMessageTextView().setMovementMethod(new ScrollingMovementMethod());
            qQCustomDialog.getMessageTextView().setMaxHeight(x.c(activity, 200.0f));
            qQCustomDialog.setTitle(jSONObject.optString("title"));
            qQCustomDialog.setMessage(jSONObject.optString("text"));
            qQCustomDialog.setCanceledOnTouchOutside(false);
            if (jSONObject.optBoolean("needOkBtn", true)) {
                qQCustomDialog.setPositiveButton(jSONObject.optString("okBtnText", HardCodeUtil.qqStr(R.string.ket)), new a(jSONObject, aVar, str));
            }
            if (jSONObject.optBoolean("needCancelBtn", true)) {
                qQCustomDialog.setNegativeButton(jSONObject.optString("cancelBtnText", HardCodeUtil.qqStr(R.string.j6l)), new b(jSONObject, aVar, str));
            }
            qQCustomDialog.show();
        }
        return qQCustomDialog;
    }

    public static void L(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, JSONObject jSONObject, String str) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("imageIDs");
            int optInt = jSONObject.optInt("index");
            String optString = jSONObject.optString("srcID", "1");
            String str2 = "1".equals(optString) ? "4" : optString;
            boolean optBoolean = jSONObject.optBoolean("isNotShowIndex", true);
            if (optJSONArray != null && optJSONArray.length() != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    arrayList.add(optJSONArray.get(i3).toString());
                }
                jSONObject.optBoolean("isHost", false);
                jSONObject.optString("headDecoration", "0");
                jSONObject.optBoolean("isFromProfile", false);
                Activity a16 = aVar.getViolaInstance().a();
                if (a16 != null) {
                    TroopNoticeJsHandler.y(a16, optInt, arrayList, null, null, false, optBoolean, str2, 100, null, null, null, "", true);
                    aVar.T(str, null);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BridgeModuleHelper", 2, "imageList is null or length is 0");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("BridgeModuleHelper", 2, "showPicture error" + e16.getMessage());
                aVar.U(str, null);
            }
        }
    }

    public static void N(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, JSONObject jSONObject, String str) {
        PublicAccountShowPictureReport publicAccountShowPictureReport;
        try {
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
                QLog.d("BridgeModuleHelper", 2, "KANDIAN Grid Image title: ", str2, ", articleUrl: ", optString2, ", showTitle: ", Boolean.valueOf(optBoolean2));
            }
            if (optJSONArray != null && optJSONArray.length() != 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    arrayList.add(optJSONArray.get(i3).toString());
                }
                Activity a16 = aVar.getViolaInstance().a();
                if (a16 != null) {
                    Intent intent = new Intent(a16, (Class<?>) TroopAvatarWallPreviewActivity.class);
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
                    a16.startActivityForResult(intent, 100);
                    aVar.T(str, null);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BridgeModuleHelper", 2, "imageList is null or length is 0");
            }
            aVar.U(str, "imageList is null or length is 0");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class c implements GdtAdListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a f262660a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f262661b;

        c(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar, String str) {
            this.f262660a = aVar;
            this.f262661b = str;
        }

        @Override // com.tencent.gdtad.api.GdtAdListener
        public void onAdFailedToLoad(GdtAd gdtAd, GdtAdError gdtAdError) {
            this.f262660a.U(this.f262661b, gdtAdError.getErrorMessage());
        }

        @Override // com.tencent.gdtad.api.GdtAdListener
        public void onAdClicked(GdtAd gdtAd) {
        }

        @Override // com.tencent.gdtad.api.GdtAdListener
        public void onAdClosed(GdtAd gdtAd) {
        }

        @Override // com.tencent.gdtad.api.GdtAdListener
        public void onAdImpression(GdtAd gdtAd) {
        }

        @Override // com.tencent.gdtad.api.GdtAdListener
        public void onAdLoaded(GdtAd gdtAd) {
        }
    }

    public static void g(JSONObject jSONObject) {
    }

    public static void K(String str, JSONObject jSONObject) {
    }
}
