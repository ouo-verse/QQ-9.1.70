package com.tencent.qqmini.minigame.webrtc;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.triton.engine.GameLaunchCallback;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.minigame.GamePage;
import com.tencent.qqmini.minigame.dynamic.DynamicCore;
import com.tencent.qqmini.minigame.yungame.GameLoadingStatus;
import com.tencent.qqmini.minigame.yungame.d;
import com.tencent.qqmini.minigame.yungame.va.MenuButtonRect;
import com.tencent.qqmini.minigame.yungame.va.VAFloatingViewControl;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebRtcProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.YunGameProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.tav.core.AssetExtension;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0001'B\u001f\u0012\u0006\u0010R\u001a\u00020O\u0012\u0006\u0010V\u001a\u00020S\u0012\u0006\u0010Z\u001a\u00020W\u00a2\u0006\u0004\b[\u0010\\J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J[\u0010\u0014\u001a\u00020\t2S\u0010\b\u001aO\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bj\u0004\u0018\u0001`\u0013J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016J\u0016\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fJ\u001e\u0010 \u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0011J\u0006\u0010!\u001a\u00020\tJ\u0006\u0010\"\u001a\u00020\tJ\u0006\u0010#\u001a\u00020\tJ\u0006\u0010$\u001a\u00020\tJ\u0010\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020\tH\u0016J\b\u0010)\u001a\u00020\tH\u0016J\b\u0010*\u001a\u00020\tH\u0016J\u0012\u0010-\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u0010\u00100\u001a\u00020\t2\u0006\u0010/\u001a\u00020.H\u0016J\u0010\u00101\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u00102\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u00103\u001a\u00020\u0011H\u0002R\u0018\u00106\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u00105R\u0014\u00109\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00108R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010:R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010;Ri\u0010?\u001aW\u0012\u0004\u0012\u00020\u001c\u0012M\u0012K\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\t0\u000bj\u0002`\u00130<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010;R\u0018\u0010J\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010Y\u00a8\u0006^"}, d2 = {"Lcom/tencent/qqmini/minigame/webrtc/YunGameWebRtcPage;", "Lcom/tencent/qqmini/minigame/dynamic/a;", "Lcom/tencent/qqmini/minigame/yungame/b;", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", MiniChatConstants.MINI_APP_LANDSCAPE, "Lcom/tencent/mobileqq/triton/engine/GameLaunchCallback;", "callback", "", "d", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isSuccess", "Lorg/json/JSONObject;", "data", "", "msg", "Lcom/tencent/qqmini/minigame/yungame/YunGameCallback;", "t", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "req", "y", HippyTKDListViewAdapter.X, "callJsName", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "callbackId", "errCode", "errMsg", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "v", "u", "w", "B", "Lcom/tencent/qqmini/minigame/dynamic/b;", AssetExtension.SCENE_EXPORT, "a", "doOnResume", "doOnPause", "doOnDestroy", "Landroid/content/Intent;", "intent", "c", "Lcom/tencent/qqmini/minigame/yungame/d;", "listener", "b", ReportConstant.COSTREPORT_PREFIX, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqmini/minigame/dynamic/DynamicCore;", "Lcom/tencent/qqmini/minigame/dynamic/DynamicCore;", "webrtcPlugin", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/WebRtcProxy;", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/WebRtcProxy;", "webrtcProxy", "Landroid/view/ViewGroup;", "Z", "Ljava/util/concurrent/ConcurrentHashMap;", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "callbackMap", "f", "I", "Lcom/tencent/qqmini/minigame/yungame/va/VAFloatingViewControl;", "g", "Lcom/tencent/qqmini/minigame/yungame/va/VAFloatingViewControl;", "vaFloatingViewControl", h.F, "isFirstReport", "i", "Lcom/tencent/qqmini/minigame/yungame/d;", "yunGameListen", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/YunGameProxy;", "j", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/YunGameProxy;", "yunGameProxy", "Landroid/app/Activity;", "k", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "l", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "miniAppInfo", "Lcom/tencent/qqmini/sdk/launcher/core/BaseRuntime;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqmini/sdk/launcher/core/BaseRuntime;", "runtime", "<init>", "(Landroid/app/Activity;Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;Lcom/tencent/qqmini/sdk/launcher/core/BaseRuntime;)V", DomainData.DOMAIN_NAME, "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class YunGameWebRtcPage implements com.tencent.qqmini.minigame.dynamic.a, com.tencent.qqmini.minigame.yungame.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private DynamicCore webrtcPlugin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final WebRtcProxy webrtcProxy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ViewGroup rootView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isLandscape;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<Integer, Function3<Boolean, JSONObject, String, Unit>> callbackMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int callbackId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private VAFloatingViewControl vaFloatingViewControl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstReport;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private d yunGameListen;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final YunGameProxy yunGameProxy;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final MiniAppInfo miniAppInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final BaseRuntime runtime;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "isSuccess", "", "result", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "onReceiveResult"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    static final class b implements AsyncResult {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function3 f346855b;

        b(Function3 function3) {
            this.f346855b = function3;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public final void onReceiveResult(boolean z16, JSONObject jSONObject) {
            Map mapOf;
            QMLog.i("YunGameWebRtcPage", "getDynamicPath path:" + jSONObject);
            if (z16 && jSONObject != null) {
                String path = jSONObject.optString("path");
                YunGameWebRtcPage.this.webrtcPlugin = new DynamicCore(YunGameWebRtcPage.this);
                DynamicCore dynamicCore = YunGameWebRtcPage.this.webrtcPlugin;
                if (dynamicCore == null) {
                    Intrinsics.throwNpe();
                }
                Activity activity = YunGameWebRtcPage.this.activity;
                Intrinsics.checkExpressionValueIsNotNull(path, "path");
                dynamicCore.j(activity, path, "WebRtcPlugin", new HashMap());
                if (this.f346855b != null) {
                    YunGameWebRtcPage.this.callbackMap.put(Integer.valueOf(YunGameWebRtcPage.this.callbackId), this.f346855b);
                }
                DynamicCore dynamicCore2 = YunGameWebRtcPage.this.webrtcPlugin;
                if (dynamicCore2 == null) {
                    Intrinsics.throwNpe();
                }
                Activity activity2 = YunGameWebRtcPage.this.activity;
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("miniAppInfo", YunGameWebRtcPage.this.miniAppInfo), TuplesKt.to("callbackId", Integer.valueOf(YunGameWebRtcPage.this.callbackId)), TuplesKt.to("runtime", YunGameWebRtcPage.this.runtime), TuplesKt.to(MosaicConstants$JsProperty.PROP_ROOT_VIEW, YunGameWebRtcPage.i(YunGameWebRtcPage.this)), TuplesKt.to(MiniChatConstants.MINI_APP_LANDSCAPE, Boolean.valueOf(YunGameWebRtcPage.this.isLandscape)));
                dynamicCore2.g("initWebRtc", activity2, mapOf);
                YunGameWebRtcPage.this.callbackId++;
            }
        }
    }

    public YunGameWebRtcPage(@NotNull Activity activity, @NotNull MiniAppInfo miniAppInfo, @NotNull BaseRuntime runtime) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(miniAppInfo, "miniAppInfo");
        Intrinsics.checkParameterIsNotNull(runtime, "runtime");
        this.activity = activity;
        this.miniAppInfo = miniAppInfo;
        this.runtime = runtime;
        Object obj = ProxyManager.get(WebRtcProxy.class);
        Intrinsics.checkExpressionValueIsNotNull(obj, "ProxyManager.get(WebRtcProxy::class.java)");
        this.webrtcProxy = (WebRtcProxy) obj;
        this.isLandscape = true;
        this.callbackMap = new ConcurrentHashMap<>();
        this.callbackId = 1;
        this.isFirstReport = true;
        Object obj2 = ProxyManager.get(YunGameProxy.class);
        Intrinsics.checkExpressionValueIsNotNull(obj2, "ProxyManager.get(YunGameProxy::class.java)");
        YunGameProxy yunGameProxy = (YunGameProxy) obj2;
        this.yunGameProxy = yunGameProxy;
        yunGameProxy.init();
    }

    public static final /* synthetic */ ViewGroup i(YunGameWebRtcPage yunGameWebRtcPage) {
        ViewGroup viewGroup = yunGameWebRtcPage.rootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        }
        return viewGroup;
    }

    private final String q() {
        boolean z16 = this.isFirstReport;
        this.isFirstReport = false;
        if (z16) {
            return "1";
        }
        return "2";
    }

    private final void r(JSONObject data) {
        String optString;
        JSONObject optJSONObject;
        try {
            String optString2 = data.optString("eventType");
            if (optString2.equals("sendGameEvent")) {
                JSONObject optJSONObject2 = data.optJSONObject("eventData");
                if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("data")) != null) {
                    String optString3 = optJSONObject.optString("event");
                    JSONObject jSONObject = new JSONObject(optString3);
                    String name = jSONObject.optString("EventName");
                    int optInt = jSONObject.optInt("Progress");
                    if (TextUtils.isEmpty(name)) {
                        return;
                    }
                    QMLog.i("YunGameWebRtcPage", "handleGameLoadingEvent name:" + optString3 + " progress:" + optInt);
                    GameLoadingStatus.Companion companion = GameLoadingStatus.INSTANCE;
                    Intrinsics.checkExpressionValueIsNotNull(name, "name");
                    final GameLoadingStatus a16 = companion.a(name);
                    if (a16 != null) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.webrtc.YunGameWebRtcPage$handleGameMessage$1
                            @Override // java.lang.Runnable
                            public final void run() {
                                VAFloatingViewControl vAFloatingViewControl;
                                vAFloatingViewControl = YunGameWebRtcPage.this.vaFloatingViewControl;
                                if (vAFloatingViewControl != null) {
                                    vAFloatingViewControl.F(a16);
                                }
                            }
                        });
                    }
                }
            } else if (optString2.equals("sendLoadingEvent")) {
                JSONObject optJSONObject3 = data.optJSONObject("eventData");
                if (optJSONObject3 != null && (optString = optJSONObject3.optString(AdMetricTag.EVENT_NAME)) != null) {
                    QMLog.i("YunGameWebRtcPage", "handleSendLoadingEvent eventData:" + optJSONObject3);
                    int hashCode = optString.hashCode();
                    if (hashCode != -1349867671) {
                        if (hashCode != -1338708366) {
                            if (hashCode == -546228930 && optString.equals("onLoadingEnd")) {
                                v();
                            }
                        } else if (optString.equals("onQueue")) {
                            w();
                        }
                    } else if (optString.equals("onError")) {
                        u();
                    }
                }
            }
        } catch (Exception e16) {
            QMLog.e("YunGameWebRtcPage", "handleGameLoadingEvent", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(ViewGroup rootView) {
        String a16;
        FrameLayout frameLayout = new FrameLayout(rootView.getContext());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        if (rootView.getChildCount() > 0) {
            rootView.addView(frameLayout, 1, layoutParams);
        } else {
            rootView.addView(frameLayout, layoutParams);
        }
        this.vaFloatingViewControl = new VAFloatingViewControl(frameLayout, this.miniAppInfo);
        try {
            d dVar = this.yunGameListen;
            if (dVar != null && (a16 = dVar.a()) != null) {
                JSONObject jSONObject = new JSONObject(a16);
                VAFloatingViewControl vAFloatingViewControl = this.vaFloatingViewControl;
                if (vAFloatingViewControl != null) {
                    vAFloatingViewControl.P(new MenuButtonRect(jSONObject.optInt("width"), jSONObject.optInt("height"), jSONObject.optInt("top"), jSONObject.optInt("right"), jSONObject.optInt("bottom"), jSONObject.optInt("left")));
                }
            }
        } catch (Exception e16) {
            QMLog.e("YunGameWebRtcPage", "e:" + e16);
        }
    }

    public final void A(int callbackId, int errCode, @NotNull String errMsg) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(errMsg, "errMsg");
        Function3<Boolean, JSONObject, String, Unit> function3 = this.callbackMap.get(Integer.valueOf(callbackId));
        if (function3 != null) {
            boolean z17 = true;
            if (errCode == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Boolean valueOf = Boolean.valueOf(z16);
            JSONObject jSONObject = new JSONObject();
            if ((this.miniAppInfo.launchParam.forceReload & 4) <= 0) {
                z17 = false;
            }
            JSONObject put = jSONObject.put("isRestart", z17);
            Intrinsics.checkExpressionValueIsNotNull(put, "JSONObject().run {\n     \u2026START) > 0)\n            }");
            function3.invoke(valueOf, put, errMsg);
        }
    }

    public final void B() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.webrtc.YunGameWebRtcPage$showVAFloatDownloadTips$1
            @Override // java.lang.Runnable
            public final void run() {
                VAFloatingViewControl vAFloatingViewControl;
                vAFloatingViewControl = YunGameWebRtcPage.this.vaFloatingViewControl;
                if (vAFloatingViewControl != null) {
                    vAFloatingViewControl.K();
                }
            }
        });
    }

    public final void C(@NotNull final JSONObject data) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.webrtc.YunGameWebRtcPage$updateWebRTCRendererView$1
            @Override // java.lang.Runnable
            public final void run() {
                Map<String, ? extends Object> mapOf;
                IPage page = YunGameWebRtcPage.this.runtime.getPage();
                if (page instanceof GamePage) {
                    ((GamePage) page).setUnderGameView(true);
                }
                DynamicCore dynamicCore = YunGameWebRtcPage.this.webrtcPlugin;
                if (dynamicCore != null) {
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("data", data));
                    dynamicCore.h(com.tencent.luggage.wxa.jh.d.NAME, mapOf);
                }
            }
        });
    }

    @Override // com.tencent.qqmini.minigame.dynamic.a
    public void a(@NotNull com.tencent.qqmini.minigame.dynamic.b export) {
        Intrinsics.checkParameterIsNotNull(export, "export");
        export.a(new Function0<a>() { // from class: com.tencent.qqmini.minigame.webrtc.YunGameWebRtcPage$clientModuleExport$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(YunGameWebRtcPage.this);
            }
        });
    }

    @Override // com.tencent.qqmini.minigame.yungame.b
    public void b(@NotNull d listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.yunGameListen = listener;
    }

    @Override // com.tencent.qqmini.minigame.yungame.b
    public void c(@Nullable Intent intent) {
        VAFloatingViewControl vAFloatingViewControl = this.vaFloatingViewControl;
        if (vAFloatingViewControl != null) {
            vAFloatingViewControl.H(intent);
        }
    }

    @Override // com.tencent.qqmini.minigame.yungame.b
    public void d(@NotNull final ViewGroup rootView, boolean isLandscape, @Nullable GameLaunchCallback callback) {
        Intrinsics.checkParameterIsNotNull(rootView, "rootView");
        this.rootView = rootView;
        this.isLandscape = isLandscape;
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.webrtc.YunGameWebRtcPage$init$1
            @Override // java.lang.Runnable
            public final void run() {
                YunGameWebRtcPage.this.s(rootView);
            }
        });
    }

    @Override // com.tencent.qqmini.minigame.yungame.b
    public void doOnDestroy() {
        DynamicCore dynamicCore = this.webrtcPlugin;
        if (dynamicCore != null) {
            dynamicCore.k();
        }
        VAFloatingViewControl vAFloatingViewControl = this.vaFloatingViewControl;
        if (vAFloatingViewControl != null) {
            vAFloatingViewControl.E();
        }
        this.yunGameListen = null;
        this.yunGameProxy.unInit();
    }

    @Override // com.tencent.qqmini.minigame.yungame.b
    public void doOnPause() {
        DynamicCore dynamicCore = this.webrtcPlugin;
        if (dynamicCore != null) {
            dynamicCore.l();
        }
    }

    @Override // com.tencent.qqmini.minigame.yungame.b
    public void doOnResume() {
        DynamicCore dynamicCore = this.webrtcPlugin;
        if (dynamicCore != null) {
            dynamicCore.m();
        }
    }

    public final void t(@Nullable Function3<? super Boolean, ? super JSONObject, ? super String, Unit> callback) {
        this.webrtcProxy.getWebRTCDynamicPath(this.activity, new b(callback));
    }

    public final void u() {
        Map mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("ext29", q()), TuplesKt.to("ext7", "1"), TuplesKt.to("ext6", "2"));
        com.tencent.qqmini.minigame.yungame.va.d.b("929241", "8", null, mutableMapOf);
    }

    public final void v() {
        Map mutableMapOf;
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.webrtc.YunGameWebRtcPage$onGameScreenReady$1
            @Override // java.lang.Runnable
            public final void run() {
                VAFloatingViewControl vAFloatingViewControl;
                vAFloatingViewControl = YunGameWebRtcPage.this.vaFloatingViewControl;
                if (vAFloatingViewControl != null) {
                    vAFloatingViewControl.G();
                }
            }
        });
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("ext29", q()), TuplesKt.to("ext7", "0"), TuplesKt.to("ext6", "2"));
        com.tencent.qqmini.minigame.yungame.va.d.b("929241", "8", null, mutableMapOf);
    }

    public final void w() {
        Map mapOf;
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.webrtc.YunGameWebRtcPage$onQueue$1
            @Override // java.lang.Runnable
            public final void run() {
                VAFloatingViewControl vAFloatingViewControl;
                vAFloatingViewControl = YunGameWebRtcPage.this.vaFloatingViewControl;
                if (vAFloatingViewControl != null) {
                    vAFloatingViewControl.I();
                }
            }
        });
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("ext2", this.miniAppInfo.appId), TuplesKt.to("ext6", "2"));
        com.tencent.qqmini.minigame.yungame.va.d.b("989318", "8", null, mapOf);
    }

    public final void x(@NotNull RequestEvent req) {
        Map<String, ? extends Object> mapOf;
        Intrinsics.checkParameterIsNotNull(req, "req");
        try {
            String str = req.jsonParams;
            if (str == null) {
                str = "{}";
            }
            JSONObject jSONObject = new JSONObject(str);
            DynamicCore dynamicCore = this.webrtcPlugin;
            if (dynamicCore != null) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("data", jSONObject));
                dynamicCore.h("onReceiveGameMessage", mapOf);
            }
            r(jSONObject);
        } catch (Exception unused) {
            req.fail();
        }
    }

    @Nullable
    public final String y(@NotNull RequestEvent req) {
        String str;
        boolean z16;
        Object obj;
        Map mapOf;
        Map mapOf2;
        String str2 = "{}";
        Intrinsics.checkParameterIsNotNull(req, "req");
        try {
            String str3 = req.jsonParams;
            if (str3 == null) {
                str3 = "{}";
            }
            JSONObject jSONObject = new JSONObject(str3);
            DynamicCore dynamicCore = this.webrtcPlugin;
            if (dynamicCore != null) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("data", jSONObject));
                mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("req", req));
                obj = dynamicCore.g("operateWebRtc", mapOf, mapOf2);
            } else {
                obj = null;
            }
            str = (String) obj;
        } catch (Exception e16) {
            QMLog.e("YunGameWebRtcPage", "operateWebRtc:" + e16);
            req.fail();
            str = null;
        }
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            str2 = str;
        }
        return str2;
    }

    public final void z(@NotNull String callJsName, @NotNull JSONObject data) {
        Intrinsics.checkParameterIsNotNull(callJsName, "callJsName");
        Intrinsics.checkParameterIsNotNull(data, "data");
        try {
            data.put("state", "message");
            BaseRuntime baseRuntime = this.runtime;
            String jSONObject = data.toString();
            PageAction obtain = PageAction.obtain(this.runtime);
            Intrinsics.checkExpressionValueIsNotNull(obtain, "PageAction.obtain(runtime)");
            baseRuntime.performAction(ServiceSubscribeEvent.obtain(callJsName, jSONObject, obtain.getPageId()));
        } catch (Exception e16) {
            QMLog.e("YunGameWebRtcPage", "receiveNativeMessage error.", e16);
        }
    }
}
