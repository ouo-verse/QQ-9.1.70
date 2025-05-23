package com.tencent.mobileqq.ark.api.notify;

import a61.c;
import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ad.tangram.views.feedback.AdFeedbackParams;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.gdtad.api.interstitial.IGdtInterstitialAPI;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.module.g;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.utils.impl.ArkPubicEventWrapImpl;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Vector;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GdtNotify implements g {

    /* renamed from: d, reason: collision with root package name */
    GdtAdLoader.Listener f199083d;

    /* renamed from: e, reason: collision with root package name */
    private List<AdFeedbackDialogFragment.Listener> f199084e = new Vector();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ark.api.notify.GdtNotify$3, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f199091d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WeakReference f199092e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f199093f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f199094h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ WeakReference f199095i;

        AnonymousClass3(String str, WeakReference weakReference, boolean z16, String str2, WeakReference weakReference2) {
            this.f199091d = str;
            this.f199092e = weakReference;
            this.f199093f = z16;
            this.f199094h = str2;
            this.f199095i = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                GdtNotify.this.f199083d = new GdtAdLoader.Listener() { // from class: com.tencent.mobileqq.ark.api.notify.GdtNotify.3.1
                    @Override // com.tencent.gdtad.aditem.GdtAdLoader.Listener
                    public void onResponse(final GdtAdLoader gdtAdLoader) {
                        ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(AnonymousClass3.this.f199091d, new Runnable() { // from class: com.tencent.mobileqq.ark.api.notify.GdtNotify.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Context context;
                                Object pbToJson = GdtJsonPbUtil.pbToJson(gdtAdLoader.getSession().response);
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("rsp", pbToJson);
                                } catch (JSONException e16) {
                                    e16.printStackTrace();
                                }
                                GdtNotify.d(AnonymousClass3.this.f199091d, "ad_req_callback", jSONObject.toString());
                                WeakReference weakReference = AnonymousClass3.this.f199092e;
                                if (weakReference != null) {
                                    context = (Context) weakReference.get();
                                } else {
                                    context = null;
                                }
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                AdAnalysisHelperForUtil.reportForARKSendNotification(context, anonymousClass3.f199093f, "ad_req_callback", anonymousClass3.f199091d, null);
                            }
                        });
                    }
                };
                GdtAdLoader.Session session = new GdtAdLoader.Session();
                session.request = (qq_ad_get.QQAdGet) qq_ad_get.QQAdGet.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGet(), new JSONObject(this.f199094h)));
                new GdtAdLoader(session, new WeakReference(GdtNotify.this.f199083d)).load(this.f199095i);
            } catch (Throwable th5) {
                QLog.e("GdtNotify", 1, "ark.notify error!", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements AdFeedbackDialogFragment.Listener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f199114a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WeakReference f199115b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ qq_ad_get.QQAdGetRsp.AdInfo f199116c;

        a(String str, WeakReference weakReference, qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
            this.f199114a = str;
            this.f199115b = weakReference;
            this.f199116c = adInfo;
        }

        @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
        public void onResult(AdFeedbackDialogFragment.Result result) {
            if (result != null && result.result != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!result.result.isSuccess()) {
                        jSONObject.put("error_code", result.result.getErrorCode());
                        GdtNotify.h(this.f199114a, this.f199115b, "ad_show_feedback_callback", jSONObject, false);
                    } else {
                        jSONObject.put("action_type", result.action);
                        jSONObject.put("error_code", result.result.getErrorCode());
                        GdtNotify.h(this.f199114a, this.f199115b, "ad_feedback_action_callback", jSONObject, false);
                        if (this.f199116c != null && result.action == 3) {
                            ((IGdtInterstitialAPI) QRoute.api(IGdtInterstitialAPI.class)).closeAd(this.f199116c);
                        }
                    }
                } catch (Throwable th5) {
                    GdtLog.e("GdtNotify", "GdtNotify[onResult]", th5);
                }
                GdtNotify.this.f199084e.remove(this);
                return;
            }
            AdLog.e("GdtNotify", "[onResult] error, params are null");
        }
    }

    static void d(String str, String str2, String str3) {
        ((IArkAPIService) QRoute.api(IArkAPIService.class)).postArkNotify(str, "", str2, str3);
    }

    private static void e(String str) {
        QQAppInterface g16 = g();
        boolean z16 = true;
        if (g16 == null) {
            QLog.e("GdtNotify", 1, "ark callbackMuteStatus error: not instanceof QQAppInterface");
            return;
        }
        try {
            try {
                if (((AudioManager) g16.getApplication().getApplicationContext().getSystemService("audio")).getRingerMode() == 2) {
                    z16 = false;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("is_muted", z16);
                if (QLog.isColorLevel()) {
                    QLog.i("GdtNotify", 2, "ad_query_mute: " + jSONObject.toString());
                }
                d(str, ArkPubicEventWrapImpl.APP_POST_MUTE, jSONObject.toString());
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } catch (Throwable unused) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("is_muted", false);
            d(str, ArkPubicEventWrapImpl.APP_POST_MUTE, jSONObject2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ChatMessage f(List<ChatMessage> list, String str) {
        ArkAppMessage arkAppMessage;
        JSONObject optJSONObject;
        if (list != null && !list.isEmpty() && !StringUtil.isEmpty(str)) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                ChatMessage chatMessage = list.get(i3);
                if ((chatMessage instanceof MessageForArkApp) && (arkAppMessage = ((MessageForArkApp) chatMessage).ark_app_message) != null) {
                    String str2 = arkAppMessage.metaList;
                    if (StringUtil.isEmpty(str2)) {
                        continue;
                    } else {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(str2).optJSONObject("gdt");
                            String str3 = "";
                            if (optJSONObject2.optJSONObject("adInfo") != null) {
                                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("adInfo").optJSONObject(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO);
                                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("trace_info")) != null) {
                                    str3 = optJSONObject.optString("traceid");
                                }
                            } else {
                                str3 = optJSONObject2.optString("traceid");
                            }
                            if (str.equals(str3)) {
                                return chatMessage;
                            }
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }

    protected static QQAppInterface g() {
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        if (runtime instanceof QQAppInterface) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(final String str, final WeakReference<Activity> weakReference, final String str2, final JSONObject jSONObject, final boolean z16) {
        ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(str, new Runnable() { // from class: com.tencent.mobileqq.ark.api.notify.GdtNotify.8
            @Override // java.lang.Runnable
            public void run() {
                GdtNotify.d(str, str2, jSONObject.toString());
                AdAnalysisHelperForUtil.reportForARKSendNotification((Context) weakReference.get(), z16, str2, str, null);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [tencent.gdt.qq_ad_get$QQAdGetRsp$AdInfo] */
    /* JADX WARN: Type inference failed for: r12v8, types: [tencent.gdt.qq_ad_get$QQAdGetRsp$AdInfo] */
    private void i(String str, String str2) {
        JSONObject jSONObject;
        final int i3;
        final boolean z16;
        ?? r122;
        int i16;
        final WeakReference weakReference = new WeakReference(Foreground.getTopActivity());
        JSONObject jSONObject2 = null;
        boolean z17 = false;
        try {
            JSONObject jSONObject3 = new JSONObject(str2);
            ?? r123 = (qq_ad_get.QQAdGetRsp.AdInfo) GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), jSONObject3.getJSONObject("adInfo"));
            try {
                jSONObject2 = jSONObject3.optJSONObject("options");
                if (!AdJSONUtil.isJSONObjectNull(jSONObject2)) {
                    i16 = jSONObject2.optInt("orientation", 0);
                } else {
                    i16 = 0;
                }
                try {
                    if (!AdJSONUtil.isJSONObjectNull(jSONObject2)) {
                        if (jSONObject2.optBoolean("isDarkMode", false)) {
                            z17 = true;
                        }
                    }
                    z16 = z17;
                    i3 = i16;
                    r122 = r123;
                } catch (Throwable th5) {
                    jSONObject2 = r123;
                    jSONObject = jSONObject2;
                    i3 = i16;
                    th = th5;
                    AdLog.e("GdtNotify", "error occurs while parsing input data", th);
                    JSONObject jSONObject4 = new JSONObject();
                    try {
                        jSONObject4.put("error_code", 4);
                    } catch (JSONException unused) {
                    }
                    h(str, weakReference, "ad_show_feedback_callback", jSONObject4, false);
                    z16 = false;
                    JSONObject jSONObject5 = jSONObject2;
                    jSONObject2 = jSONObject;
                    r122 = jSONObject5;
                    final a aVar = new a(str, weakReference, r122);
                    final GdtAd gdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo) r122);
                    final boolean optBoolean = AdJSONUtil.optBoolean(jSONObject2, "shouldShowToast", true);
                    ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.notify.GdtNotify.7
                        @Override // java.lang.Runnable
                        public void run() {
                            AdFeedbackParams adFeedbackParams = new AdFeedbackParams();
                            adFeedbackParams.activity = weakReference;
                            adFeedbackParams.listener = new WeakReference<>(aVar);
                            adFeedbackParams.f61346ad = gdtAd;
                            adFeedbackParams.styleId = i3;
                            adFeedbackParams.isDarkMode = z16;
                            adFeedbackParams.shouldShowToast = optBoolean;
                            try {
                                ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).showFeedbackDialogFragment(adFeedbackParams);
                            } catch (Throwable th6) {
                                QLog.e("GdtNotify", 1, "showFeedbackFragment", th6);
                            }
                            GdtNotify.this.f199084e.add(aVar);
                        }
                    });
                }
            } catch (Throwable th6) {
                th = th6;
                i3 = 0;
                JSONObject jSONObject6 = jSONObject2;
                jSONObject2 = r123;
                jSONObject = jSONObject6;
            }
        } catch (Throwable th7) {
            th = th7;
            jSONObject = null;
            i3 = 0;
        }
        final AdFeedbackDialogFragment.Listener aVar2 = new a(str, weakReference, r122);
        final GdtAd gdtAd2 = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo) r122);
        final boolean optBoolean2 = AdJSONUtil.optBoolean(jSONObject2, "shouldShowToast", true);
        ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.notify.GdtNotify.7
            @Override // java.lang.Runnable
            public void run() {
                AdFeedbackParams adFeedbackParams = new AdFeedbackParams();
                adFeedbackParams.activity = weakReference;
                adFeedbackParams.listener = new WeakReference<>(aVar2);
                adFeedbackParams.f61346ad = gdtAd2;
                adFeedbackParams.styleId = i3;
                adFeedbackParams.isDarkMode = z16;
                adFeedbackParams.shouldShowToast = optBoolean2;
                try {
                    ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).showFeedbackDialogFragment(adFeedbackParams);
                } catch (Throwable th62) {
                    QLog.e("GdtNotify", 1, "showFeedbackFragment", th62);
                }
                GdtNotify.this.f199084e.add(aVar2);
            }
        });
    }

    @Override // com.tencent.mobileqq.ark.module.g
    public boolean notify(final String str, String str2, final String str3) {
        if (str2.equals(ArkPubicEventWrapImpl.ARK_QUERY_MUTE)) {
            e(str);
            return true;
        }
        if (str3 == null) {
            return false;
        }
        QLog.d("GdtNotify", 1, "appname : " + str + "eventName : " + str2 + " params : " + str3, (Throwable) null);
        if (str2.equals("ad_c2s_report")) {
            try {
                JSONObject jSONObject = new JSONObject(str3);
                com.tencent.gdtad.statistics.a.b(jSONObject.getInt("op"), 0, (qq_ad_get.QQAdGetRsp.AdInfo) qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), jSONObject.getJSONObject("adInfo"))));
                QLog.d("GdtNotify", 1, "report c2s end", (Throwable) null);
                return true;
            } catch (JSONException e16) {
                QLog.d("GdtNotify", 1, e16, new Object[0]);
                return false;
            }
        }
        if (QBaseActivity.sTopActivity == null) {
            QLog.d("GdtNotify", 1, "top activity is null");
            return false;
        }
        final JSONObject jSONObject2 = new JSONObject();
        if (str2.equals("ad_query_cell_rect")) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.ark.api.notify.GdtNotify.1
                @Override // java.lang.Runnable
                public void run() {
                    List<ChatMessage> list;
                    ChatXListView chatXListView;
                    try {
                        BaseActivity baseActivity = BaseActivity.sTopActivity;
                        if (baseActivity != null && baseActivity.getChatFragment() != null) {
                            ChatFragment chatFragment = baseActivity.getChatFragment();
                            c cVar = chatFragment.C;
                            if (cVar != null) {
                                ChatXListView chatXListView2 = cVar.f25584i;
                                JSONArray jSONArray = new JSONArray();
                                jSONObject2.put(ForwardMiniChooseFriendOption.RESULT_LIST, jSONArray);
                                List<ChatMessage> a16 = chatFragment.C.f25585j.a();
                                JSONArray optJSONArray = new JSONObject(str3).optJSONArray("traceids");
                                int i3 = 0;
                                while (i3 < optJSONArray.length()) {
                                    String optString = optJSONArray.optString(i3);
                                    ChatMessage f16 = GdtNotify.f(a16, optString);
                                    if (f16 == null) {
                                        list = a16;
                                        chatXListView = chatXListView2;
                                    } else {
                                        JSONObject jSONObject3 = new JSONObject();
                                        jSONArray.mo162put(jSONObject3);
                                        JSONObject jSONObject4 = new JSONObject();
                                        jSONObject3.put("traceid", optString);
                                        jSONObject3.put(CanvasView.ACTION_RECT, jSONObject4);
                                        View a17 = a91.c.a(f16, chatXListView2);
                                        if (a17 != null) {
                                            ArkAppView arkAppView = (ArkAppView) a17.findViewById(R.id.y_);
                                            if (arkAppView != null) {
                                                if (a91.c.b(arkAppView) != null) {
                                                    list = a16;
                                                    chatXListView = chatXListView2;
                                                    jSONObject4.put("left", UIUtils.o(arkAppView.getContext(), r10.left));
                                                    jSONObject4.put("top", UIUtils.o(arkAppView.getContext(), r10.top));
                                                    jSONObject4.put("right", UIUtils.o(arkAppView.getContext(), r10.right));
                                                    jSONObject4.put("bottom", UIUtils.o(arkAppView.getContext(), r10.bottom));
                                                } else {
                                                    list = a16;
                                                    chatXListView = chatXListView2;
                                                    jSONObject4.put("left", 0);
                                                    jSONObject4.put("top", 0);
                                                    jSONObject4.put("right", 0);
                                                    jSONObject4.put("bottom", 0);
                                                }
                                            } else {
                                                list = a16;
                                                chatXListView = chatXListView2;
                                                jSONObject4.put("left", 0);
                                                jSONObject4.put("top", 0);
                                                jSONObject4.put("right", 0);
                                                jSONObject4.put("bottom", 0);
                                            }
                                        } else {
                                            list = a16;
                                            chatXListView = chatXListView2;
                                            jSONObject4.put("left", 0);
                                            jSONObject4.put("top", 0);
                                            jSONObject4.put("right", 0);
                                            jSONObject4.put("bottom", 0);
                                        }
                                        i3++;
                                        chatXListView2 = chatXListView;
                                        a16 = list;
                                    }
                                    i3++;
                                    chatXListView2 = chatXListView;
                                    a16 = list;
                                }
                            } else {
                                QLog.d("GdtNotify", 2, "resultJson 0: " + jSONObject2.toString());
                                GdtNotify.d(str, "ad_query_cell_rect_callback", jSONObject2.toString());
                            }
                        } else {
                            QLog.d("GdtNotify", 2, "resultJson 1: " + jSONObject2.toString());
                            GdtNotify.d(str, "ad_query_cell_rect_callback", jSONObject2.toString());
                        }
                        QLog.d("GdtNotify", 2, "resultJson 2: " + jSONObject2.toString());
                        GdtNotify.d(str, "ad_query_cell_rect_callback", jSONObject2.toString());
                    } catch (Exception unused) {
                        QLog.d("GdtNotify", 2, "resultJson 3: " + jSONObject2.toString());
                        GdtNotify.d(str, "ad_query_cell_rect_callback", jSONObject2.toString());
                    }
                }
            });
            return true;
        }
        final WeakReference weakReference = new WeakReference(QBaseActivity.sTopActivity);
        final WeakReference weakReference2 = new WeakReference(QBaseActivity.sTopActivity);
        if (str2.equals("ad_click")) {
            AdAnalysisHelperForUtil.reportForARKReceiveNotification((Context) weakReference.get(), false, str2, str, null);
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.notify.GdtNotify.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject jSONObject3 = new JSONObject(str3);
                        JSONObject jSONObject4 = jSONObject3.getJSONObject("options");
                        boolean z16 = jSONObject4.getBoolean("reportForClick");
                        boolean z17 = jSONObject4.getBoolean("appAutoDownload");
                        boolean optBoolean = jSONObject4.optBoolean("videoCeilingSupported", false);
                        int optInt = jSONObject4.optInt("clickScene");
                        int optInt2 = jSONObject4.optInt("clickPosition");
                        String optString = jSONObject4.optString("gdtRefsid");
                        qq_ad_get.QQAdGetRsp.AdInfo adInfo = (qq_ad_get.QQAdGetRsp.AdInfo) qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), jSONObject3.getJSONObject("adInfo")));
                        GdtHandler.Params params = new GdtHandler.Params();
                        params.processId = 7;
                        params.activity = weakReference;
                        params.f108486ad = new GdtAd(adInfo);
                        params.reportForClick = z16;
                        params.appAutoDownload = z17;
                        params.videoCeilingSupportedIfNotInstalled = optBoolean;
                        params.sceneID = optInt;
                        params.componentID = optInt2;
                        if (!TextUtils.isEmpty(optString)) {
                            Bundle bundle = new Bundle();
                            params.extra = bundle;
                            bundle.putString(LaunchParam.KEY_REF_ID, optString);
                        } else if (!TextUtils.isEmpty(str) && str.equals("com.tencent.yundong")) {
                            Bundle bundle2 = new Bundle();
                            params.extra = bundle2;
                            bundle2.putString(LaunchParam.KEY_REF_ID, ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getSourceId(IPublicAccountUtil.UIN_FOR_HEALTH));
                        }
                        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
                    } catch (Exception e17) {
                        QLog.e("GdtNotify", 1, "ark.notify error!", e17);
                    }
                }
            });
            d(str, "ad_click_callback", str3);
            AdAnalysisHelperForUtil.reportForARKSendNotification((Context) weakReference.get(), false, "ad_click_callback", str, null);
        } else if (str2.equals("ad_request")) {
            boolean z16 = !"com.tencent.yundong".equals(str);
            AdAnalysisHelperForUtil.reportForARKReceiveNotification((Context) weakReference.get(), z16, str2, str, null);
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToMainThread(new AnonymousClass3(str, weakReference, z16, str3, weakReference2));
        } else if (str2.equals("get_device_info")) {
            QLog.d("GdtNotify", 1, "ark get_device_info", (Throwable) null);
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(str, new Runnable() { // from class: com.tencent.mobileqq.ark.api.notify.GdtNotify.4
                @Override // java.lang.Runnable
                public void run() {
                    qq_ad_get.QQAdGet.DeviceInfo deviceInfo;
                    WeakReference weakReference3 = weakReference2;
                    if (weakReference3 != null && weakReference3.get() != null && !TextUtils.isEmpty(str3)) {
                        GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create((Context) weakReference2.get(), new GdtDeviceInfoHelper.Params());
                        if (create != null && (deviceInfo = create.deviceInfo) != null) {
                            Object pbToJson = GdtJsonPbUtil.pbToJson(deviceInfo);
                            if (pbToJson instanceof JSONObject) {
                                ((IArkAPIService) QRoute.api(IArkAPIService.class)).postArkNotify(str, "", "get_device_info_callback", pbToJson.toString());
                                QLog.d("GdtNotify", 1, "ark get_device_info_callback", (Throwable) null);
                                return;
                            }
                            return;
                        }
                        QLog.e("GdtNotify", 1, "ark get_device_info error", (Throwable) null);
                        return;
                    }
                    QLog.e("GdtNotify", 1, "ark get_device_info error", (Throwable) null);
                }
            });
        } else if (str2.equals("ad_preload_after_ad_loaded")) {
            QLog.d("GdtNotify", 1, "ark ad_preload_after_ad_loaded", (Throwable) null);
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.notify.GdtNotify.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (TextUtils.isEmpty(str3)) {
                            QLog.e("GdtNotify", 1, "ark ad_preload_after_ad_loaded params invalid", (Throwable) null);
                            return;
                        }
                        GdtAd gdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo) qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(str3).getJSONObject("adInfo"))));
                        QLog.d("GdtNotify", 1, "ark ad_preload_after_ad_loaded start", (Throwable) null);
                        GdtPreLoader.c().h(gdtAd);
                    } catch (Throwable th5) {
                        QLog.e("GdtNotify", 1, "ark ad_preload_after_ad_loaded error", th5);
                    }
                }
            });
        } else if (str2.equals(ArkPubicEventWrapImpl.ARK_REVERSE_FEEDBACK)) {
            ((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).handleGcArkDeleteMsg(str3);
        } else if (str2.equals("show_feedback_view")) {
            i(str, str3);
        }
        return true;
    }
}
