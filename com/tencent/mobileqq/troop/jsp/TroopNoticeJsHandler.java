package com.tencent.mobileqq.troop.jsp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.flock.base.FlockBaseRequest;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.troopbatch.event.TroopBatchListEvent;
import com.tencent.mobileqq.troop.troopselector.TroopSelectorConfig;
import com.tencent.mobileqq.troop.troopselector.api.ITroopSelectorApi;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.smtt.sdk.WebView;
import common.config.service.QzoneConfig;
import cooperation.qzone.LargeIntentManager;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoUrl;
import cooperation.qzone.util.QZoneImageUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopNoticeJsHandler extends WebViewPlugin implements SimpleEventReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static int f297678h;

    /* renamed from: i, reason: collision with root package name */
    public static String f297679i;

    /* renamed from: m, reason: collision with root package name */
    public static String f297680m;

    /* renamed from: d, reason: collision with root package name */
    protected String f297681d;

    /* renamed from: e, reason: collision with root package name */
    protected String f297682e;

    /* renamed from: f, reason: collision with root package name */
    private BroadcastReceiver f297683f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNoticeJsHandler.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            String stringExtra = intent.getStringExtra("callback");
            QLog.d("TroopReceiver", 4, stringExtra);
            TroopNoticeJsHandler.this.t(stringExtra);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76485);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
            return;
        }
        f297678h = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QUN_ALBUM_SETTING, QzoneConfig.SECONDARY_QUN_SHOW_PICTURE_INTENT_LIMIT, 200);
        f297679i = "pic_up";
        f297680m = "pic";
    }

    public TroopNoticeJsHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void A(Activity activity, int i3, ArrayList<String> arrayList, boolean[] zArr, ArrayList<String> arrayList2, boolean z16, boolean z17, String str, int i16, PublicAccountShowPictureReport publicAccountShowPictureReport, String str2, String str3, String str4) {
        Intent intent = new Intent(activity, (Class<?>) TroopAvatarWallPreviewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("index", i3);
        bundle.putStringArrayList(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, arrayList);
        if (arrayList2 != null) {
            bundle.putStringArrayList("descs", arrayList2);
        }
        if (zArr != null) {
            bundle.putBooleanArray("likes", zArr);
        }
        if (publicAccountShowPictureReport != null && publicAccountShowPictureReport.isReport) {
            bundle.putString("PublicAccountShowPictureReport", publicAccountShowPictureReport.toString());
        }
        bundle.putBoolean("needBottomBar", z16);
        bundle.putBoolean("IS_EDIT", false);
        bundle.putBoolean("is_use_path", true);
        bundle.putBoolean("is_show_action", true);
        bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_IS_NOT_SHOW_INDEX, z17);
        bundle.putBoolean("is_show_content_url", true);
        bundle.putString("article_url", str2);
        bundle.putString("article_title", str3);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("src_id", str);
        }
        if (!TextUtils.isEmpty(str4)) {
            bundle.putString(TroopAvatarWallPreviewActivity.KEY_STR_DATA_EXTRA, str4);
        }
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, i16);
    }

    public static String B(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        try {
            CompressInfo compressInfo = new CompressInfo(str3, 0, 1006);
            compressInfo.S = 1;
            RichmediaService.A(compressInfo);
            String str9 = compressInfo.H;
            HashMap hashMap = new HashMap();
            hashMap.put("bkn", s(str6));
            if (!TextUtils.isEmpty(str4)) {
                try {
                    JSONObject jSONObject = new JSONObject(str4);
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str10 = (String) keys.next();
                        hashMap.put(str10, jSONObject.get(str10).toString());
                    }
                } catch (JSONException unused) {
                }
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put(str8, str9);
            int length = str.length();
            StringBuffer stringBuffer = new StringBuffer("o");
            int i3 = 10 - length;
            for (int i16 = 0; i16 < i3; i16++) {
                stringBuffer.append("0");
            }
            stringBuffer.append(str);
            HashMap hashMap3 = new HashMap();
            try {
                URL url = new URL(str2);
                hashMap3.put("Referer", url.getRef());
                if (url.getHost().startsWith("web.qun.qq.com") && url.getPath().startsWith("/cgi-bin/announce/upload_img") && !TextUtils.isEmpty(str7)) {
                    hashMap3.put("Cookie", "p_uin=" + stringBuffer.toString() + ";p_skey=" + str7 + ";uin=" + stringBuffer.toString() + ";skey=");
                }
                if (!TextUtils.isEmpty(str5)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str5);
                        Iterator keys2 = jSONObject2.keys();
                        while (keys2.hasNext()) {
                            String str11 = (String) keys2.next();
                            hashMap3.put(str11, jSONObject2.get(str11).toString());
                        }
                    } catch (JSONException unused2) {
                    }
                }
                return HttpUtil.uploadImage(str2, stringBuffer.toString(), hashMap, hashMap2, hashMap3);
            } catch (MalformedURLException e16) {
                e16.printStackTrace();
                return null;
            }
        } catch (Exception e17) {
            QLog.d("TroopNoticeJsHandler", 1, "uploadImageFile compress fail", e17);
            return null;
        }
    }

    private void r(String... strArr) {
        String str;
        QLog.i("TroopNoticeJsHandler", 1, "getBatchGroupList");
        if (strArr != null && strArr.length > 0) {
            try {
                Activity a16 = this.mRuntime.a();
                if (a16 == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(strArr[0]);
                int i3 = jSONObject.getInt("limitNum");
                JSONArray jSONArray = jSONObject.getJSONArray("groupCodes");
                this.f297682e = jSONObject.optString("callback");
                ArrayList arrayList = new ArrayList();
                for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                    String string = jSONArray.getString(i16);
                    TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(string);
                    if (troopInfoFromCache != null && !TextUtils.isEmpty(troopInfoFromCache.getTroopDisplayName())) {
                        str = troopInfoFromCache.getTroopDisplayName();
                    } else {
                        str = string;
                    }
                    arrayList.add(new ResultRecord(string, str, 1, "", ""));
                }
                ((ITroopSelectorApi) QRoute.api(ITroopSelectorApi.class)).openNewTroopSelector(a16, new Intent(), new TroopSelectorConfig(true, i3, true, false, false, arrayList, 5), 102);
            } catch (JSONException e16) {
                QLog.e("TroopNoticeJsHandler", 1, "getBatchGroupList json e = " + e16);
            } catch (Throwable th5) {
                QLog.e("TroopNoticeJsHandler", 1, "getBatchGroupList t = " + th5);
            }
        }
    }

    public static String s(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int length = str.length();
        int i3 = 5381;
        for (int i16 = 0; i16 < length; i16++) {
            i3 += (i3 << 5) + str.charAt(i16);
        }
        return Integer.toString(Integer.MAX_VALUE & i3);
    }

    public static void showOnePicture(Activity activity, String str) {
        if (activity != null && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            w(activity, 0, arrayList, true, "", 1000);
        }
    }

    public static void w(Activity activity, int i3, ArrayList<String> arrayList, boolean z16, String str, int i16) {
        x(activity, i3, arrayList, null, null, false, z16, str, i16, null, "");
    }

    public static void x(Activity activity, int i3, ArrayList<String> arrayList, boolean[] zArr, ArrayList<String> arrayList2, boolean z16, boolean z17, String str, int i16, PublicAccountShowPictureReport publicAccountShowPictureReport, String str2) {
        y(activity, i3, arrayList, zArr, arrayList2, z16, z17, str, i16, publicAccountShowPictureReport, null, null, str2, true);
    }

    public static void y(Activity activity, int i3, ArrayList<String> arrayList, boolean[] zArr, ArrayList<String> arrayList2, boolean z16, boolean z17, String str, int i16, PublicAccountShowPictureReport publicAccountShowPictureReport, ArrayList<String> arrayList3, ArrayList<String> arrayList4, String str2, boolean z18) {
        z(activity, i3, arrayList, zArr, arrayList2, z16, z17, str, i16, publicAccountShowPictureReport, null, null, str2, true, "", null);
    }

    public static void z(Activity activity, int i3, ArrayList<String> arrayList, boolean[] zArr, ArrayList<String> arrayList2, boolean z16, boolean z17, String str, int i16, PublicAccountShowPictureReport publicAccountShowPictureReport, ArrayList<String> arrayList3, ArrayList<String> arrayList4, String str2, boolean z18, String str3, HashMap<String, Object> hashMap) {
        ThreadManagerV2.post(new Runnable(activity, i3, arrayList, arrayList2, zArr, publicAccountShowPictureReport, arrayList3, arrayList4, str3, hashMap, z16, z17, z18, str, str2, i16) { // from class: com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ ArrayList C;
            final /* synthetic */ ArrayList D;
            final /* synthetic */ String E;
            final /* synthetic */ HashMap F;
            final /* synthetic */ boolean G;
            final /* synthetic */ boolean H;
            final /* synthetic */ boolean I;
            final /* synthetic */ String J;
            final /* synthetic */ String K;
            final /* synthetic */ int L;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Activity f297684d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f297685e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ ArrayList f297686f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ ArrayList f297687h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ boolean[] f297688i;

            /* renamed from: m, reason: collision with root package name */
            final /* synthetic */ PublicAccountShowPictureReport f297689m;

            {
                this.f297684d = activity;
                this.f297685e = i3;
                this.f297686f = arrayList;
                this.f297687h = arrayList2;
                this.f297688i = zArr;
                this.f297689m = publicAccountShowPictureReport;
                this.C = arrayList3;
                this.D = arrayList4;
                this.E = str3;
                this.F = hashMap;
                this.G = z16;
                this.H = z17;
                this.I = z18;
                this.J = str;
                this.K = str2;
                this.L = i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, this, activity, Integer.valueOf(i3), arrayList, arrayList2, zArr, publicAccountShowPictureReport, arrayList3, arrayList4, str3, hashMap, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, str2, Integer.valueOf(i16));
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Intent intent = new Intent(this.f297684d, (Class<?>) TroopAvatarWallPreviewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("index", this.f297685e);
                bundle.putStringArrayList(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, this.f297686f);
                ArrayList<String> arrayList5 = this.f297687h;
                if (arrayList5 != null) {
                    bundle.putStringArrayList("descs", arrayList5);
                }
                boolean[] zArr2 = this.f297688i;
                if (zArr2 != null) {
                    bundle.putBooleanArray("likes", zArr2);
                }
                PublicAccountShowPictureReport publicAccountShowPictureReport2 = this.f297689m;
                if (publicAccountShowPictureReport2 != null && publicAccountShowPictureReport2.isReport) {
                    bundle.putString("PublicAccountShowPictureReport", publicAccountShowPictureReport2.toString());
                }
                ArrayList<String> arrayList6 = this.C;
                if (arrayList6 != null) {
                    bundle.putStringArrayList(TroopAvatarWallPreviewActivity.KEY_ORIGIN_LIST, arrayList6);
                }
                ArrayList<String> arrayList7 = this.D;
                if (arrayList7 != null) {
                    bundle.putStringArrayList(TroopAvatarWallPreviewActivity.KEY_ORIGIN_SIZE_LIST, arrayList7);
                }
                if (!TextUtils.isEmpty(this.E)) {
                    bundle.putString(TroopAvatarWallPreviewActivity.KEY_DT_PG_ID, this.E);
                    HashMap hashMap2 = this.F;
                    if (hashMap2 != null) {
                        bundle.putSerializable(TroopAvatarWallPreviewActivity.KEY_DT_PG_PARAMS, hashMap2);
                    }
                }
                bundle.putBoolean("needBottomBar", this.G);
                bundle.putBoolean("IS_EDIT", false);
                bundle.putBoolean("is_use_path", true);
                bundle.putBoolean("is_show_action", true);
                bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_IS_NOT_SHOW_INDEX, this.H);
                bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_NEED_TO_AIO, this.I);
                if (!TextUtils.isEmpty(this.J)) {
                    bundle.putString("src_id", this.J);
                }
                if (!TextUtils.isEmpty(this.K)) {
                    bundle.putString(TroopAvatarWallPreviewActivity.KEY_STR_DATA_EXTRA, this.K);
                }
                intent.putExtras(bundle);
                ArrayList arrayList8 = this.f297686f;
                if (arrayList8 != null && arrayList8.size() > TroopNoticeJsHandler.f297678h) {
                    LargeIntentManager.saveIntent(intent, this.f297684d);
                    Intent intent2 = new Intent(this.f297684d, (Class<?>) TroopAvatarWallPreviewActivity.class);
                    intent2.putExtra(TroopAvatarWallPreviewActivity.KEY_SAVE_INTENT_TO_FILE, true);
                    this.f297684d.startActivityForResult(intent2, this.L);
                    return;
                }
                this.f297684d.startActivityForResult(intent, this.L);
            }
        }, 8, null, true);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ArrayList) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(TroopBatchListEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "troopNotice";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        if ("troopNotice".equals(str2)) {
            if ("showPicture".equals(str3) && strArr.length == 1) {
                showPicture(strArr[0]);
            } else if ("sendPicture".equals(str3) && strArr.length == 1) {
                v(strArr[0]);
            } else if ("sendBatchPicture".equals(str3) && strArr.length == 1) {
                u(strArr[0]);
            } else if ("showMedia".equals(str3) && strArr.length == 1) {
                QLog.d("WebViewPlugin", 4, "handleJsRequest, remove Method showMedia");
            } else if ("getBatchGroupList".equals(str3)) {
                r(strArr);
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        CustomWebView e16;
        ArrayList<String> stringArrayListExtra;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, intent, Byte.valueOf(b16), Integer.valueOf(i3));
            return;
        }
        if (b16 == 100 && (e16 = this.mRuntime.e()) != null && intent != null && intent.hasExtra("DeletedList") && (stringArrayListExtra = intent.getStringArrayListExtra("DeletedList")) != null && stringArrayListExtra.size() > 0) {
            e16.loadUrl("javascript: " + this.f297681d + "([])");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onCreate();
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        WebViewPlugin.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onDestroy();
        if (this.f297683f != null && (bVar = this.mRuntime) != null) {
            Activity a16 = bVar.a();
            if (a16 == null) {
                return;
            }
            if (a16 instanceof BasePluginActivity) {
                a16 = ((BasePluginActivity) a16).getOutActivity();
            }
            a16.unregisterReceiver(this.f297683f);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof TroopBatchListEvent) {
            QLog.i("TroopNoticeJsHandler", 1, "onReceiveEvent getBatchGroupList");
            JSONArray jSONArray = new JSONArray((Collection) ((TroopBatchListEvent) simpleBaseEvent).getTroopList());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("groupCodes", jSONArray);
            } catch (JSONException e16) {
                QLog.e("TroopNoticeJsHandler", 1, "parse TroopBatchListEvent err e: ", e16);
            }
            callJs(this.f297682e, jSONObject.toString());
        }
    }

    protected void q(String str) {
        AppInterface b16;
        Activity a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            CustomWebView e16 = this.mRuntime.e();
            if (e16 == null || (b16 = this.mRuntime.b()) == null || (a16 = this.mRuntime.a()) == null) {
                return;
            }
            String optString = jSONObject.optString("callback");
            String optString2 = jSONObject.optString("cgiURL");
            String optString3 = jSONObject.optString(QZoneImageUtils.KEY_IMAGE_ID);
            String optString4 = jSONObject.optString("headFields");
            String optString5 = jSONObject.optString("postParams");
            ((IPskeyManager) b16.getRuntimeService(IPskeyManager.class, "")).getPskey(new String[]{FlockBaseRequest.QUN_DOMAIN}, new sd2.a(FlockBaseRequest.QUN_DOMAIN, b16.getCurrentAccountUin(), optString2, optString3, optString5, optString4, a16, e16, optString) { // from class: com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler.4
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ String f297691a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ String f297692b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ String f297693c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f297694d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f297695e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f297696f;

                /* renamed from: g, reason: collision with root package name */
                final /* synthetic */ Activity f297697g;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ WebView f297698h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f297699i;

                {
                    this.f297691a = r6;
                    this.f297692b = r7;
                    this.f297693c = optString2;
                    this.f297694d = optString3;
                    this.f297695e = optString5;
                    this.f297696f = optString4;
                    this.f297697g = a16;
                    this.f297698h = e16;
                    this.f297699i = optString;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopNoticeJsHandler.this, r6, r7, optString2, optString3, optString5, optString4, a16, e16, optString);
                    }
                }

                @Override // sd2.a
                public void onFail(@NonNull String str2) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) str2);
                    } else if (QLog.isColorLevel()) {
                        QLog.d("TroopNoticeJsHandler", 2, "doSendPicture getPskey onFail, errMsg: " + str2);
                    }
                }

                @Override // sd2.a
                public void onSuccess(@NonNull Map<String, String> map) {
                    String str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) map);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopNoticeJsHandler", 2, "doSendPicture getPskey onSuccess");
                    }
                    String str3 = map.get(this.f297691a);
                    if (!StringUtil.isEmpty(str3) && str3.length() >= 10) {
                        str2 = str3.substring(0, 10);
                    } else {
                        str2 = "";
                    }
                    this.f297697g.runOnUiThread(new Runnable(TroopNoticeJsHandler.B(this.f297692b, this.f297693c, this.f297694d, this.f297695e, this.f297696f, str2, str3, TroopNoticeJsHandler.f297679i)) { // from class: com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler.4.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ String f297701d;

                        {
                            this.f297701d = r5;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this, (Object) r5);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            WebView webView = AnonymousClass4.this.f297698h;
                            if (webView != null) {
                                webView.loadUrl("javascript: " + AnonymousClass4.this.f297699i + "(" + this.f297701d + ")");
                            }
                        }
                    });
                }
            });
        } catch (OutOfMemoryError | JSONException | Exception unused) {
        }
    }

    protected void showPicture(String str) {
        String jSONObject;
        PublicAccountShowPictureReport publicAccountShowPictureReport;
        Activity a16;
        ArrayList arrayList;
        ArrayList arrayList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            String optString = jSONObject2.optString("bigurl");
            if (!TextUtils.isEmpty(optString)) {
                String optString2 = jSONObject2.optString("videoID");
                String optString3 = jSONObject2.optString("videoURL");
                jSONObject2.optString("originalVideoURL");
                int optInt = jSONObject2.optInt("videoWidth");
                int optInt2 = jSONObject2.optInt("videoHeight");
                jSONObject2.optBoolean("isLike");
                Activity a17 = this.mRuntime.a();
                if (a17 == null) {
                    return;
                }
                QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                Bundle bundle = new Bundle();
                ArrayList arrayList3 = new ArrayList();
                PhotoInfo photoInfo = new PhotoInfo();
                photoInfo.bigUrl = optString;
                photoInfo.videoflag = 1;
                VideoInfo videoInfo = new VideoInfo();
                photoInfo.videodata = videoInfo;
                videoInfo.videoId = optString2;
                PictureUrl pictureUrl = new PictureUrl();
                pictureUrl.url = optString;
                photoInfo.videodata.coverUrl = pictureUrl;
                VideoUrl videoUrl = new VideoUrl();
                videoUrl.url = optString3;
                VideoInfo videoInfo2 = photoInfo.videodata;
                videoInfo2.videoId = optString2;
                videoInfo2.actionUrl = optString3;
                videoInfo2.videoUrl = videoUrl;
                videoInfo2.width = optInt;
                videoInfo2.height = optInt2;
                videoInfo2.videoStatus = 5;
                arrayList3.add(photoInfo);
                bundle.putSerializable("picturelist", arrayList3);
                bundle.putInt("curindex", 0);
                bundle.putInt("mode", 3);
                bundle.putBoolean("need_clear_cache", true);
                QZoneHelper.forwardToPictureViewer(a17, userInfo, bundle, 6);
            }
            this.f297681d = jSONObject2.optString("callback");
            JSONArray optJSONArray = jSONObject2.optJSONArray("imageIDs");
            JSONArray optJSONArray2 = jSONObject2.optJSONArray("likes");
            JSONArray optJSONArray3 = jSONObject2.optJSONArray("descs");
            JSONArray optJSONArray4 = jSONObject2.optJSONArray("sourceIDs");
            JSONArray optJSONArray5 = jSONObject2.optJSONArray("sourceSize");
            boolean optBoolean = jSONObject2.optBoolean("needBottomBar");
            JSONObject optJSONObject = jSONObject2.optJSONObject("extra");
            if (optJSONObject == null) {
                jSONObject = "";
            } else {
                jSONObject = optJSONObject.toString();
            }
            int optInt3 = jSONObject2.optInt("index");
            String optString4 = jSONObject2.optString("srcID");
            if (Boolean.valueOf(jSONObject2.optBoolean("isReport")).booleanValue()) {
                PublicAccountShowPictureReport publicAccountShowPictureReport2 = new PublicAccountShowPictureReport();
                publicAccountShowPictureReport2.parse(jSONObject2);
                publicAccountShowPictureReport = publicAccountShowPictureReport2;
            } else {
                publicAccountShowPictureReport = null;
            }
            boolean optBoolean2 = jSONObject2.optBoolean("isNotShowIndex", true);
            if (optJSONArray == null || optJSONArray.length() == 0 || this.mRuntime.e() == null || this.mRuntime.b() == null || (a16 = this.mRuntime.a()) == null) {
                return;
            }
            if (a16 instanceof BasePluginActivity) {
                a16 = ((BasePluginActivity) a16).getOutActivity();
            }
            ArrayList arrayList4 = new ArrayList();
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                arrayList4.add(optJSONArray.get(i3).toString());
            }
            if (optJSONArray4 != null) {
                ArrayList arrayList5 = new ArrayList();
                int length2 = optJSONArray4.length();
                for (int i16 = 0; i16 < length2; i16++) {
                    arrayList5.add(optJSONArray4.get(i16).toString());
                }
                arrayList = arrayList5;
            } else {
                arrayList = null;
            }
            if (optJSONArray5 != null) {
                ArrayList arrayList6 = new ArrayList();
                int length3 = optJSONArray5.length();
                for (int i17 = 0; i17 < length3; i17++) {
                    arrayList6.add(optJSONArray5.get(i17).toString());
                }
                arrayList2 = arrayList6;
            } else {
                arrayList2 = null;
            }
            boolean optBoolean3 = jSONObject2.optBoolean("showTitle", false);
            String encodeToString = PluginBaseInfoHelper.Base64Helper.encodeToString(jSONObject2.optString("title", "").getBytes(), 0);
            String optString5 = jSONObject2.optString("articleUrl", "");
            if (QLog.isColorLevel()) {
                QLog.d("WebViewPlugin", 2, "KANDIAN Grid Image title: ", encodeToString, ", articleUrl: ", optString5, ", showTitle: ", Boolean.valueOf(optBoolean3));
            }
            if (optBoolean) {
                if (optJSONArray2 == null) {
                    return;
                }
                boolean[] zArr = new boolean[optJSONArray2.length()];
                for (int i18 = 0; i18 < optJSONArray2.length(); i18++) {
                    zArr[i18] = optJSONArray2.getBoolean(i18);
                }
                ArrayList arrayList7 = new ArrayList();
                if (optJSONArray3 != null && optJSONArray3.length() != 0) {
                    int length4 = optJSONArray3.length();
                    for (int i19 = 0; i19 < length4; i19++) {
                        arrayList7.add(optJSONArray3.get(i19).toString());
                    }
                }
                if (this.f297683f == null) {
                    this.f297683f = new a();
                    a16.registerReceiver(this.f297683f, new IntentFilter("android.intent.action.WEBJSCALL"));
                }
                if (optBoolean3 && !TextUtils.isEmpty(encodeToString) && !TextUtils.isEmpty(optString5)) {
                    A(a16, optInt3, arrayList4, zArr, arrayList7, optBoolean, optBoolean2, optString4, 100, publicAccountShowPictureReport, optString5, encodeToString, jSONObject);
                    return;
                } else {
                    y(a16, optInt3, arrayList4, zArr, arrayList7, optBoolean, optBoolean2, optString4, 100, publicAccountShowPictureReport, arrayList, arrayList2, jSONObject, true);
                    return;
                }
            }
            if (optBoolean3 && !TextUtils.isEmpty(encodeToString) && !TextUtils.isEmpty(optString5)) {
                A(a16, optInt3, arrayList4, null, null, false, optBoolean2, optString4, 100, publicAccountShowPictureReport, optString5, encodeToString, jSONObject);
            } else {
                x(a16, optInt3, arrayList4, null, null, false, optBoolean2, optString4, 100, publicAccountShowPictureReport, jSONObject);
            }
        } catch (JSONException unused) {
        }
    }

    public void t(String str) {
        CustomWebView e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        if (this.mRuntime == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f297681d) || (e16 = this.mRuntime.e()) == null) {
            return;
        }
        e16.loadUrl("javascript: " + this.f297681d + "(" + str + ")");
    }

    protected void u(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            ThreadManagerV2.post(new Runnable(str) { // from class: com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f297703d;

                {
                    this.f297703d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopNoticeJsHandler.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        JSONArray jSONArray = new JSONArray(this.f297703d);
                        int length = jSONArray.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            TroopNoticeJsHandler.this.q(jSONArray.get(i3).toString());
                        }
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }
            }, 5, null, false);
        }
    }

    protected void v(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            ThreadManagerV2.post(new Runnable(str) { // from class: com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f297690d;

                {
                    this.f297690d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopNoticeJsHandler.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        TroopNoticeJsHandler.this.q(this.f297690d);
                    }
                }
            }, 5, null, true);
        }
    }
}
