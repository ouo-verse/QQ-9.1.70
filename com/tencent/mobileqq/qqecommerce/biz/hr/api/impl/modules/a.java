package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.biz.m;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.richtext.annotation.JSMethod;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.hippy.qq.module.HippyQQHttpModule;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.WebSsoBody$WebSsoRequestBody;
import com.tencent.mobileqq.WebSsoBody$WebSsoResponseBody;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.l;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.viewmodel.PictureShowActionEvent;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vas.treasurecard.VasFtCard;
import com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a extends gk0.a implements com.tencent.mobileqq.qqecommerce.biz.hr.api.c {

    /* renamed from: p, reason: collision with root package name */
    private static boolean f262662p = true;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.b f262664b;

    /* renamed from: c, reason: collision with root package name */
    private ActionSheetHelper f262665c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, Object> f262666d;

    /* renamed from: i, reason: collision with root package name */
    private WadlProxyServiceCallBackInterface f262671i;

    /* renamed from: k, reason: collision with root package name */
    private INetInfoHandler f262673k;

    /* renamed from: n, reason: collision with root package name */
    private final SimpleEventReceiver f262676n;

    /* renamed from: o, reason: collision with root package name */
    private int f262677o;

    /* renamed from: a, reason: collision with root package name */
    private String f262663a = null;

    /* renamed from: e, reason: collision with root package name */
    public String f262667e = "";

    /* renamed from: f, reason: collision with root package name */
    public int f262668f = 0;

    /* renamed from: g, reason: collision with root package name */
    public String f262669g = "";

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.b f262670h = new com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.b(this);

    /* renamed from: j, reason: collision with root package name */
    private g f262672j = new C8303a();

    /* renamed from: l, reason: collision with root package name */
    private int f262674l = -100;

    /* renamed from: m, reason: collision with root package name */
    protected ShareActionSheetBuilder f262675m = null;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f262679d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f262680e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f262681f;

        b(String str, String str2, QQAppInterface qQAppInterface) {
            this.f262679d = str;
            this.f262680e = str2;
            this.f262681f = qQAppInterface;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            try {
                if (z16) {
                    byte[] byteArray = bundle.getByteArray("data");
                    if (byteArray != null) {
                        WebSsoBody$WebSsoResponseBody webSsoBody$WebSsoResponseBody = new WebSsoBody$WebSsoResponseBody();
                        webSsoBody$WebSsoResponseBody.mergeFrom(byteArray);
                        QLog.d("BridgeModule", 2, "receive response cmd:" + this.f262679d);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("data", webSsoBody$WebSsoResponseBody.data.get());
                        jSONObject.put("retcode", webSsoBody$WebSsoResponseBody.ret.get());
                        jSONObject.put("cret", 0);
                        a.this.T(this.f262680e, jSONObject);
                        if (QLog.isColorLevel()) {
                            BridgeModuleHelper.C(webSsoBody$WebSsoResponseBody, bundle);
                        }
                    } else {
                        QLog.e("BridgeModule", 1, "request web sso success, but byte data is null, cmd: " + this.f262679d);
                    }
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("cret", 1);
                    jSONObject2.put("cret_msg", "\u8bf7\u6c42\u5931\u8d25");
                    a.this.T(this.f262680e, jSONObject2);
                    BridgeModuleHelper.D(bundle);
                }
            } catch (Exception e16) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("cret", 2);
                    jSONObject3.put("cret_msg", "json \u89e3\u6790\u5931\u8d25\uff1a" + e16.getMessage());
                } catch (JSONException e17) {
                    e17.printStackTrace();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class c implements SimpleEventReceiver<PictureShowActionEvent> {
        c() {
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public ArrayList<Class<PictureShowActionEvent>> getEventClass() {
            ArrayList<Class<PictureShowActionEvent>> arrayList = new ArrayList<>();
            arrayList.add(PictureShowActionEvent.class);
            return arrayList;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
            if (simpleBaseEvent instanceof PictureShowActionEvent) {
                PictureShowActionEvent pictureShowActionEvent = (PictureShowActionEvent) simpleBaseEvent;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("retCode", 0);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE, pictureShowActionEvent.getType());
                    jSONObject2.put("liked", pictureShowActionEvent.isLiked());
                    jSONObject.put("data", jSONObject2);
                    a.this.T(pictureShowActionEvent.getCallbackId(), jSONObject);
                    return;
                } catch (JSONException e16) {
                    QLog.e("BridgeModule", 1, e16, "showPictureActionReceiver onReceiveEvent");
                    return;
                }
            }
            QLog.e("BridgeModule", 1, "showPictureActionReceiver, errorEvent, eventClass=" + simpleBaseEvent.getClass().getName());
        }
    }

    public a() {
        c cVar = new c();
        this.f262676n = cVar;
        this.f262677o = -1;
        this.f262666d = new ArrayMap();
        SimpleEventBus.getInstance().registerReceiver(cVar);
    }

    private void r() {
        if (this.f262664b == null) {
            this.f262664b = new com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.b(this);
        }
    }

    public static AppRuntime x() {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null) {
            return application.getRuntime();
        }
        return null;
    }

    public void A(String str) {
        BridgeModuleHelper.k(this, str, v());
    }

    @JSMethod
    public void A0(String str, JSONObject jSONObject) {
        BridgeModuleHelper.K(str, jSONObject);
    }

    public void B0(JSONObject jSONObject, String str) {
        BridgeModuleHelper.L(this, jSONObject, str);
    }

    public void C(JSONObject jSONObject, String str) {
        T(str, new JSONObject());
    }

    public void C0(JSONObject jSONObject, String str) {
        if (jSONObject.optBoolean("showSocialBottomBar", false)) {
            BridgeModuleHelper.M(this, jSONObject, str);
        } else {
            BridgeModuleHelper.N(this, jSONObject, str);
        }
    }

    public void D(String str, boolean z16) {
        BridgeModuleHelper.m(this, str, z16);
    }

    public void D0(JSONObject jSONObject, String str) {
        BridgeModuleHelper.O(this, jSONObject, str);
    }

    public void E(JSONObject jSONObject, String str) {
        BridgeModuleHelper.n(this, jSONObject, str);
    }

    @JSMethod
    public void G(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            IVasFTManager vasFtManager = VasUtil.getService().getVasFtManager();
            int obtainCardState = vasFtManager.obtainCardState("016a");
            VasFtCard obtainCardInfo = vasFtManager.obtainCardInfo("016a");
            jSONObject.put(WadlProxyConsts.KEY_JUMP_URL, obtainCardInfo.getOrderUrl());
            jSONObject.put("iconUrl", obtainCardInfo.getImageUrl());
            jSONObject.put("title", obtainCardInfo.getMessage());
            jSONObject.put("cardType", obtainCardState);
        } catch (Exception unused) {
        }
        V(str, jSONObject);
    }

    public void G0(JSONObject jSONObject, String str) {
        BridgeModuleHelper.P(this, jSONObject, str);
    }

    public void I(String str, JSONObject jSONObject, boolean z16) {
        BridgeModuleHelper.o(this, str, jSONObject, z16);
    }

    public void I0() {
        if (this.f262671i != null) {
            WadlProxyServiceUtil.getProxyService().unRegisterWadlServiceCallBack(this.f262671i);
            this.f262671i = null;
        }
    }

    public void J(String str) {
        BridgeModuleHelper.p(this, str);
    }

    public void J0(JSONObject jSONObject, String str) {
        BridgeModuleHelper.T(this, jSONObject, str);
    }

    @JSMethod
    public void K(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("muted", f262662p);
        } catch (JSONException e16) {
            QLog.w("BridgeModule", 4, e16.getMessage());
        }
        T(str, jSONObject);
    }

    public void K0(JSONObject jSONObject, String str) {
        BridgeModuleHelper.U(this, jSONObject, str);
    }

    public void L0(JSONObject jSONObject, String str) {
        BridgeModuleHelper.V(this, jSONObject, str);
    }

    public void M(String str, boolean z16) {
        BridgeModuleHelper.s(this, str, z16);
    }

    public void O(String str, boolean z16) {
        BridgeModuleHelper.w(this, str, z16);
    }

    @Deprecated
    public void P(String str) {
        BridgeModuleHelper.x(this, str);
    }

    @JSMethod
    public void Q(String str) {
        boolean t16 = StudyModeManager.t();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("youthMode", t16);
        } catch (JSONException e16) {
            QLog.e("BridgeModule", 1, "[getYouthMode] e = " + e16);
        }
        if (QLog.isColorLevel()) {
            QLog.i("BridgeModule", 1, "[getYouthMode] result = " + jSONObject);
        }
        T(str, jSONObject);
    }

    public void R(String str, String str2, boolean z16) {
        BridgeModuleHelper.y(this, str, str2, z16, v());
    }

    public final void T(String str, Object obj) {
        g gVar = this.f262672j;
        if (gVar != null) {
            gVar.invokeCallJS(str, obj);
        }
    }

    public final void U(String str, String str2) {
        g gVar = this.f262672j;
        if (gVar != null) {
            gVar.invokeErrorCallJS(str, str2);
        }
    }

    public final void V(String str, JSONObject jSONObject) {
        g gVar = this.f262672j;
        if (gVar != null) {
            gVar.invokeJS(str, jSONObject);
        }
    }

    public void W(String str) {
        T(str, new JSONObject());
    }

    public void X(String str) {
        BridgeModuleHelper.z(this, str);
    }

    public void Y(String str) {
        BridgeModuleHelper.A(this, str);
    }

    public void a0(JSONObject jSONObject, String str) {
        Activity activity = QBaseActivity.sTopActivity;
        fk0.c violaInstance = getViolaInstance();
        int i3 = 1;
        boolean z16 = violaInstance != null && activity == violaInstance.a();
        JSONObject jSONObject2 = new JSONObject();
        if (!z16) {
            i3 = 0;
        }
        try {
            jSONObject2.put("value", i3);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        T(str, jSONObject2);
    }

    @JSMethod
    public void b0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean isWezoneJoy = ((IQCircleConfigApi) QRoute.api(IQCircleConfigApi.class)).isWezoneJoy();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", isWezoneJoy ? 1 : 0);
            T(str, jSONObject);
        } catch (JSONException e16) {
            QLog.e("BridgeModule", 1, "[isWezoneJoyUser]: " + e16);
        }
    }

    @JSMethod
    public void c(JSONObject jSONObject, String str) {
        try {
            T(str, new JSONObject());
        } catch (Throwable th5) {
            QLog.e("BridgeModule", 1, th5.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    @JSMethod
    public void c2sReport(JSONObject jSONObject) {
        BridgeModuleHelper.b(jSONObject);
    }

    @JSMethod
    public void d(JSONObject jSONObject, String str) {
        try {
            T(str, new JSONObject());
        } catch (Throwable th5) {
            QLog.e("BridgeModule", 1, th5.getMessage());
        }
    }

    public void d0(JSONObject jSONObject, String str) {
        BridgeModuleHelper.E(this, jSONObject, str);
    }

    public void destroy() {
        com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.b bVar = this.f262664b;
        if (bVar != null) {
            bVar.j();
            this.f262664b = null;
        }
        INetInfoHandler iNetInfoHandler = this.f262673k;
        if (iNetInfoHandler != null) {
            AppNetConnInfo.unregisterNetInfoHandler(iNetInfoHandler);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this.f262676n);
        I0();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    @JSMethod
    public void dwellTimeMillisReport(JSONObject jSONObject) {
        BridgeModuleHelper.g(jSONObject);
    }

    @JSMethod
    public void e(String str) {
        try {
            T(str, new JSONObject());
        } catch (Throwable th5) {
            QLog.e("BridgeModule", 1, th5.getMessage());
        }
    }

    @JSMethod
    public void e0(String str, JSONObject jSONObject) {
        BridgeModuleHelper.F(this, str, jSONObject, v());
    }

    @JSMethod
    public void f(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", new JSONArray());
            T(str, jSONObject);
        } catch (Throwable th5) {
            QLog.e("BridgeModule", 1, th5.getMessage());
        }
    }

    @JSMethod
    public void g(JSONObject jSONObject, String str) {
        try {
            T(str, new JSONObject());
        } catch (Throwable th5) {
            QLog.e("BridgeModule", 1, th5.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public JSONObject getDeviceInfo() {
        return BridgeModuleHelper.l();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public JSONObject getFailInvokeObj(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", -1);
            jSONObject.put(HippyQQHttpModule.HTPP_ERROR_TEXT, str);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    @JSMethod
    public void getMotiveAd(String str, JSONObject jSONObject) {
        BridgeModuleHelper.q(this, str, jSONObject);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public JSONObject getSuccInvokeObj(Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", 0);
            jSONObject.put(HippyQQHttpModule.HTPP_ERROR_TEXT, "");
            if (obj != null) {
                jSONObject.put("data", obj);
            } else {
                jSONObject.put("data", new JSONObject());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public JSONObject getUserInfo() {
        return BridgeModuleHelper.v();
    }

    public void h(JSONObject jSONObject, String str) {
        r();
        this.f262664b.a(jSONObject, str);
    }

    public void h0() {
        try {
            l.f182354a.get(0).newInstance().d();
        } catch (Exception e16) {
            QLog.e("BridgeModule", 1, "TabDataUtil init e:" + e16);
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    @JSMethod
    public void handleClick(JSONObject jSONObject) {
        Activity v3 = v();
        try {
            GdtLog.i("BridgeModule", jSONObject.toString());
            JSONObject jSONObject2 = jSONObject.getJSONObject("options");
            boolean z16 = jSONObject2.getBoolean("reportForClick");
            boolean z17 = jSONObject2.getBoolean("appAutoDownload");
            boolean optBoolean = jSONObject2.optBoolean("videoCeilingSupported", false);
            boolean optBoolean2 = jSONObject2.optBoolean("videoCeilingSupportedIfInstalled", false);
            int optInt = jSONObject2.optInt("clickPosition", 0);
            long optLong = jSONObject2.optLong("videoStartPositionMillis", 0L);
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = (qq_ad_get.QQAdGetRsp.AdInfo) GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), jSONObject.getJSONObject("adInfo"));
            GdtHandler.Params params = new GdtHandler.Params();
            params.processId = 7;
            params.activity = new WeakReference<>(v3);
            params.f108486ad = new GdtAd(adInfo);
            params.reportForClick = z16;
            params.appAutoDownload = z17;
            params.videoCeilingSupportedIfNotInstalled = optBoolean;
            params.videoCeilingSupportedIfInstalled = optBoolean2;
            params.componentID = optInt;
            Bundle bundle = new Bundle();
            params.extra = bundle;
            bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_feeds_kandian");
            boolean optBoolean3 = jSONObject2.optBoolean("videoPlayForced", false);
            params.videoStartPositionMillis = optLong;
            params.directPlay = optBoolean3;
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
        } catch (Throwable th5) {
            GdtLog.e("BridgeModule", "handleJsCallRequest error", th5);
        }
    }

    @JSMethod
    public void j0(String str, JSONObject jSONObject) {
        try {
            GdtLog.d("BridgeModule", jSONObject.toString());
            GdtPreLoader.c().h(new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo) GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), jSONObject.getJSONObject("adInfo"))));
            T(str, "sucess");
        } catch (Exception e16) {
            GdtLog.e("BridgeModule", "handleJsCallRequest", e16);
            T(str, "error");
        }
    }

    public void k0() {
        WadlProxyServiceUtil.getProxyService().doQueryAllTask();
    }

    public void l(JSONObject jSONObject, String str) {
        r();
        this.f262664b.c(jSONObject, str);
    }

    public void l0() {
        if (this.f262671i == null) {
            this.f262671i = new d();
        }
        WadlProxyServiceUtil.getProxyService().registerWadlServiceCallBack(this.f262671i);
    }

    public void m0(JSONObject jSONObject, String str) {
        r();
        this.f262664b.o(jSONObject, str);
    }

    public void n(JSONObject jSONObject) {
        BridgeModuleHelper.c(jSONObject);
    }

    public void o(JSONObject jSONObject) {
        BridgeModuleHelper.d(jSONObject);
    }

    @Override // gk0.a
    public boolean onActivityBack() {
        return false;
    }

    @Override // gk0.a
    public void onActivityDestroy() {
        destroy();
    }

    @Override // gk0.a
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
    }

    @Override // gk0.a
    public void onActivityResume() {
        super.onActivityResume();
        AbstractGifImage.resumeAll();
        Activity v3 = v();
        if (v3 == null || v3.getIntent() == null || this.f262677o == -1) {
            return;
        }
        if (v3.getIntent().getBundleExtra("bundle") == null) {
            v3.getIntent().putExtra("bundle", new Bundle());
        }
        v3.getIntent().getBundleExtra("bundle").putInt("seq", this.f262677o);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    @JSMethod(uiThread = true)
    public void openLevelDialog(JSONObject jSONObject, String str) {
        fk0.c violaInstance = getViolaInstance();
        if ((violaInstance != null ? violaInstance.a() : null) == null) {
            v();
        }
    }

    public void p(JSONObject jSONObject) {
        BridgeModuleHelper.e(jSONObject);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c, com.tencent.mobileqq.qqecommerce.biz.hr.api.g
    public void popBack(String str) {
        g gVar = this.f262672j;
        if (gVar != null) {
            gVar.popBack(str);
        }
    }

    public void q(JSONObject jSONObject) {
        BridgeModuleHelper.f(jSONObject);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void sendRequest(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return;
        }
        try {
            String string = jSONObject.getString("host");
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            String string2 = jSONObject.getString("cmd");
            QQAppInterface qQAppInterface = (QQAppInterface) x();
            if (jSONObject2 != null && !TextUtils.isEmpty(string) && qQAppInterface != null && !TextUtils.isEmpty(string2)) {
                String jSONObject3 = jSONObject2.toString();
                String[] split = string.split("\\.");
                String str2 = "";
                for (int length = split.length - 1; length >= 0; length--) {
                    str2 = str2 + split[length];
                    if (length != 0) {
                        str2 = str2 + "_";
                    }
                }
                NewIntent newIntent = new NewIntent(qQAppInterface.getApplication(), m.class);
                newIntent.putExtra("cmd", "MQUpdateSvc_" + str2 + ".web." + string2);
                WebSsoBody$WebSsoRequestBody webSsoBody$WebSsoRequestBody = new WebSsoBody$WebSsoRequestBody();
                webSsoBody$WebSsoRequestBody.type.set(0);
                webSsoBody$WebSsoRequestBody.data.set(jSONObject3);
                newIntent.putExtra("data", webSsoBody$WebSsoRequestBody.toByteArray());
                if (string2.equals("JsOidbProxy.oidb_0x6cf_4")) {
                    QLog.isColorLevel();
                }
                QLog.d("BridgeModule", 2, "start request cmd:" + string2);
                newIntent.setObserver(new b(string2, str, qQAppInterface));
                qQAppInterface.startServlet(newIntent);
            }
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("BridgeModule", 2, "send request error!");
            }
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void setInvokeCallJSCallback(g gVar) {
        this.f262672j = gVar;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    @JSMethod
    public void startImagePreDownload(JSONObject jSONObject) {
        BridgeModuleHelper.R(jSONObject);
    }

    public void t0(JSONObject jSONObject, String str) {
        BridgeModuleHelper.I(this, jSONObject, str);
    }

    public void u0(JSONObject jSONObject, String str) {
        if (this.f262665c == null) {
            this.f262665c = new ActionSheetHelper(this);
        }
        this.f262665c.e(jSONObject, str, v());
    }

    public Activity v() {
        Activity a16;
        fk0.c violaInstance = getViolaInstance();
        if (violaInstance != null && (a16 = violaInstance.a()) != null) {
            return a16;
        }
        Activity topActivity = Foreground.getTopActivity();
        return topActivity != null ? topActivity : QBaseActivity.sTopActivity;
    }

    @JSMethod
    public void w(String str, JSONObject jSONObject) {
        BridgeModuleHelper.i(this, str);
    }

    public void x0(JSONObject jSONObject, String str) {
        BridgeModuleHelper.J(this, jSONObject, str, v());
    }

    public void z(String str) {
        BridgeModuleHelper.j(this, str);
    }

    @JSMethod(uiThread = false)
    public void H(String str, JSONObject jSONObject) {
        I(str, jSONObject, true);
    }

    public void Z(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("isNowElderMode", SimpleUIUtil.isNowElderMode() ? 1 : 0);
            jSONObject2.put("maxLargeFontScale", FontSettingManager.getFontLevel() / 16.0f);
            T(str, jSONObject2);
        } catch (JSONException e16) {
            QLog.e("BridgeModule", 1, QLog.getStackTraceString(e16));
        }
    }

    public void c0(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        BridgeModuleHelper.B(jSONObject.optString("appID"), jSONObject.optString("paramsStr"), jSONObject.optString("packageName"), jSONObject.optString(WadlProxyConsts.FLAGS), jSONObject.optString("type"), jSONObject.optString("subappid"));
    }

    @JSMethod
    public void i0(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(v(), optString);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    @JSMethod
    public void invoke(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("ns");
        String optString2 = jSONObject.optString("method");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            QLog.d("BridgeModule", 1, "ns: " + optString + " method: " + optString2 + " params: " + jSONObject.toString());
            if (this.f262670h.a(optString, optString2, jSONObject, str)) {
                return;
            }
            U(str, "ns:" + optString + HardCodeUtil.qqStr(R.string.k3h) + optString2 + HardCodeUtil.qqStr(R.string.k3c));
            return;
        }
        U(str, HardCodeUtil.qqStr(R.string.k3l));
        QLog.d("BridgeModule", 1, "ns or method not exists");
    }

    public void m(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        WadlParams wadlParams = new WadlParams(jSONObject.toString());
        wadlParams.from = 0;
        WadlProxyServiceUtil.getProxyService().dispatchAction(wadlParams);
        QLog.i("BridgeModule", 1, "doDownloadAction jsonParams=" + jSONObject);
    }

    public void n0(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        GameCenterUtil.requestFloatingScreenPermission(jSONObject.toString());
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    @JSMethod
    public void performLikeAnimation(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.tencent.ecommerce.richtext.ui.dom.style.g.b(jSONObject.opt("pageX"), 750);
        com.tencent.ecommerce.richtext.ui.dom.style.g.b(jSONObject.opt("pageY"), 750);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void cancelVideoPreDownload() {
    }

    public void g0() {
    }

    @JSMethod
    public void j() {
    }

    public void k() {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void resetSatusBarBlackStyle() {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void resetSatusBarWhiteStyle() {
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a$a, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    class C8303a implements g {
        C8303a() {
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.g
        public void invokeCallJS(String str, Object obj) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            invokeJS(str, a.this.getSuccInvokeObj(obj));
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.g
        public void invokeErrorCallJS(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            invokeJS(str, a.this.getFailInvokeObj(str2));
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.g
        public void invokeJS(String str, JSONObject jSONObject) {
            a.this.getViolaInstance();
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.g
        public void popBack(String str) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class d implements WadlProxyServiceCallBackInterface {
        d() {
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
        public void onQueryCallback(ArrayList<WadlResult> arrayList) {
            JSONArray jSONArray = new JSONArray();
            Iterator<WadlResult> it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(GameCenterUtil.toJSONObject(it.next()));
            }
            try {
                new JSONObject().put("data", jSONArray);
            } catch (JSONException unused) {
            }
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
        public void onQueryCallbackVia(ArrayList<WadlResult> arrayList) {
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
        public void onWadlTaskStatusChanged(WadlResult wadlResult) {
        }
    }

    @JSMethod
    public void F(String str) {
    }

    public void H0(String str) {
    }

    public void N(String str) {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    @JSMethod
    public void addFavorite(JSONObject jSONObject) {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void hideTopicVideoComment(JSONObject jSONObject) {
    }

    public void o0(String str) {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void openApp(String str) {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    @JSMethod
    public void openVideo(JSONObject jSONObject) {
    }

    public void s(JSONObject jSONObject) {
    }

    public void s0(String str) {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void startVideoPreDownload(JSONObject jSONObject) {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    @JSMethod(uiThread = true)
    public void updateIndepentTabState(JSONObject jSONObject) {
    }

    public void B(JSONObject jSONObject, String str) {
    }

    public void E0(JSONObject jSONObject, String str) {
    }

    public void F0(JSONObject jSONObject, String str) {
    }

    public void L(String str, boolean z16) {
    }

    @JSMethod
    public void S(JSONObject jSONObject, String str) {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    @JSMethod
    public void cancelUploadingVideo(JSONObject jSONObject, String str) {
    }

    public void f0(JSONObject jSONObject, String str) {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    @JSMethod
    public void getUploadVideoPermission(JSONObject jSONObject, String str) {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    @JSMethod
    public void getUploadingVideoInfo(JSONObject jSONObject, String str) {
    }

    public void i(JSONObject jSONObject, String str) {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    @JSMethod
    public void openAddVideoView(JSONObject jSONObject, String str) {
    }

    public void p0(JSONObject jSONObject, String str) {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    @JSMethod
    public void pauseUploadingVideo(JSONObject jSONObject, String str) {
    }

    public void q0(JSONObject jSONObject, String str) {
    }

    @JSMethod
    public void r0(JSONObject jSONObject, String str) {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    @JSMethod
    public void resumeUploadingVideo(JSONObject jSONObject, String str) {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void setTitle(JSONObject jSONObject, String str) {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void shareVideoWithFriend(JSONObject jSONObject, String str) {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void shareVideoWithGPro(JSONObject jSONObject, String str) {
    }

    public void t(JSONObject jSONObject, String str) {
    }

    @JSMethod(uiThread = false)
    public void u(JSONObject jSONObject, String str) {
    }

    public void v0(JSONObject jSONObject, String str) {
    }

    public void w0(JSONObject jSONObject, String str) {
    }

    public void y(JSONObject jSONObject, String str) {
    }

    @JSMethod
    public void y0(JSONObject jSONObject, String str) {
    }

    @JSMethod
    public void z0(JSONObject jSONObject, String str) {
    }
}
