package com.tencent.gdtad.api.wxmini;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.wechat.AdWXMINIProgram;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.api.wxmini.GdtWXMiniJumpController;
import com.tencent.gdtad.config.data.GdtWXMiniJumpConfig;
import com.tencent.gdtad.config.parser.GdtWXMiniJumpConfigParser;
import com.tencent.gdtad.wxmini.GdtWXMiniData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.mobileqq.wxmini.api.data.LaunchWxaErrorCode;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import hm0.WXMiniSessionData;
import java.net.URLEncoder;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J \u0010\u0019\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J0\u0010 \u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0018\u0010!\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010#\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010$\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010'\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010&\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020\u0017H\u0002J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010)\u001a\u00020%H\u0002J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010)\u001a\u00020%H\u0002R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/gdtad/api/wxmini/GdtWXMiniJumpController;", "", "Lcom/tencent/ad/tangram/wechat/AdWXMINIProgram$Params;", "params", "Lcom/tencent/ad/tangram/AdError;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/gdtad/wxmini/GdtWXMiniData;", "gdtWXMiniData", "", ReportConstant.COSTREPORT_PREFIX, "Lkotlin/Pair;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "adError", "extData", "t", "Lhm0/a;", "sessionData", "r", "Landroid/content/Context;", "context", "u", "o", "", "undertake", "w", "Lcom/tencent/mobileqq/wxmini/api/data/b;", "callback", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "channelAppID", "originId", "path", "B", BdhLogUtil.LogTag.Tag_Conn, "D", "l", "j", "", "errorCode", DomainData.DOMAIN_NAME, HippyTKDListViewAdapter.X, "code", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/gdtad/config/data/GdtWXMiniJumpConfig;", "b", "Lcom/tencent/gdtad/config/data/GdtWXMiniJumpConfig;", "mGdtWXMiniJumpConfig", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GdtWXMiniJumpController {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GdtWXMiniJumpController f108657a = new GdtWXMiniJumpController();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static GdtWXMiniJumpConfig mGdtWXMiniJumpConfig;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f108667a;

        static {
            int[] iArr = new int[GdtWXMiniJumpConfig.Companion.JumpType.values().length];
            try {
                iArr[GdtWXMiniJumpConfig.Companion.JumpType.AUTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GdtWXMiniJumpConfig.Companion.JumpType.INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f108667a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Leipc/EIPCResult;", "kotlin.jvm.PlatformType", "onCallback"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    static final class b implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        public static final b f108668d = new b();

        b() {
        }

        @Override // eipc.EIPCResultCallback
        public final void onCallback(EIPCResult eIPCResult) {
            if (QLog.isColorLevel()) {
                if (eIPCResult.isSuccess()) {
                    QLog.i("GdtWXMINIProgramJumpController", 1, "handleWXMiniJump ipc succeed!");
                    return;
                }
                QLog.i("GdtWXMINIProgramJumpController", 1, "handleWXMiniJump ipc failed, error code: " + eIPCResult.code);
            }
        }
    }

    GdtWXMiniJumpController() {
    }

    private final void A(WXMiniSessionData sessionData, com.tencent.mobileqq.wxmini.api.data.b callback) {
        HashMap<String, Object> hashMapOf;
        IWxMiniManager iWxMiniManager = (IWxMiniManager) QRoute.api(IWxMiniManager.class);
        String originId = sessionData.getOriginId();
        String path = sessionData.getPath();
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(StartupReportKey.SCENE_NOTE, URLEncoder.encode("{\"is_ad\": 1}")));
        iWxMiniManager.startWxMiniAppByUsernameWithCallback(originId, path, LaunchScene.LAUNCH_SCENE_WX_MINI_AD_SCHEME, hashMapOf, callback);
    }

    private final boolean B(Context context, String channelAppID, String originId, String path, String extData) {
        IWXAPI iwxapi;
        try {
            iwxapi = WXAPIFactory.createWXAPI(context, channelAppID);
        } catch (Throwable th5) {
            QLog.e("GdtWXMINIProgramJumpController", 1, "createWXAPI", th5);
            iwxapi = null;
        }
        boolean z16 = false;
        if (iwxapi == null) {
            QLog.e("GdtWXMINIProgramJumpController", 1, "createWXAPI error, api is null");
            return false;
        }
        try {
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = originId;
            req.path = path;
            req.extData = extData;
            req.miniprogramType = 0;
            z16 = iwxapi.sendReq(req);
        } catch (Throwable th6) {
            QLog.e("GdtWXMINIProgramJumpController", 1, "[showV2] sendReq", th6);
        }
        QLog.i("GdtWXMINIProgramJumpController", 1, "[showV2] sendReq:" + z16);
        return z16;
    }

    private final void C(AdWXMINIProgram.Params params, String extData) {
        String str;
        String str2 = params.channelAppID;
        if (str2 == null || (str = params.userName) == null) {
            return;
        }
        String str3 = params.path;
        if (str3 == null) {
            str3 = "";
        }
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        B(context, str2, str, str3, extData);
    }

    private final void D(final WXMiniSessionData sessionData) {
        ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).checkWxAuthed(new com.tencent.mobileqq.wxmini.api.data.b() { // from class: gm0.a
            @Override // com.tencent.mobileqq.wxmini.api.data.b
            public final void onCallback(boolean z16, Bundle bundle) {
                GdtWXMiniJumpController.E(WXMiniSessionData.this, z16, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(WXMiniSessionData sessionData, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(sessionData, "$sessionData");
        sessionData.s(z16);
        im0.a.f407983a.b(sessionData);
    }

    private final void j(final WXMiniSessionData sessionData) {
        ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).checkWxAuthed(new com.tencent.mobileqq.wxmini.api.data.b() { // from class: gm0.b
            @Override // com.tencent.mobileqq.wxmini.api.data.b
            public final void onCallback(boolean z16, Bundle bundle) {
                GdtWXMiniJumpController.k(WXMiniSessionData.this, z16, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(WXMiniSessionData sessionData, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(sessionData, "$sessionData");
        im0.b bVar = im0.b.f407984a;
        int i3 = 0;
        if (bundle != null) {
            i3 = bundle.getInt("errCode", 0);
        }
        bVar.d(z16, sessionData, i3);
    }

    private final void l(WXMiniSessionData sessionData) {
        im0.b.f407984a.f(((IWxMiniManager) QRoute.api(IWxMiniManager.class)).checkDynamicPackage(), sessionData);
    }

    private final Pair<AdError, String> m(AdWXMINIProgram.Params params) {
        Context context;
        String str = "";
        if (params != null && params.isValid()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pathType", 2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ad_trace_data", params.traceData);
                jSONObject2.put("token", params.token);
                jSONObject.put("invokeData", jSONObject2);
                String jSONObject3 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "json.toString()");
                str = jSONObject3;
            } catch (Throwable th5) {
                QLog.e("GdtWXMINIProgramJumpController", 1, "[launchWithOpenSDK] build extData", th5);
            }
            if (TextUtils.isEmpty(str)) {
                return new Pair<>(new AdError(4), str);
            }
            QLog.i("GdtWXMINIProgramJumpController", 1, "[launchWithOpenSDK] extData:" + str);
            Activity activity = params.weakActivity.get();
            if (activity != null) {
                context = activity.getApplicationContext();
            } else {
                context = null;
            }
            AdError checkWeChatApp = ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).checkWeChatApp(context, params.channelAppID, 621086464);
            Intrinsics.checkNotNullExpressionValue(checkWeChatApp, "api(IGdtAdAPI::class.jav\u2026PPORTED_SDK_INT\n        )");
            if (!checkWeChatApp.isSuccess()) {
                return new Pair<>(checkWeChatApp, str);
            }
            return new Pair<>(new AdError(0), str);
        }
        return new Pair<>(new AdError(4), "");
    }

    private final void n(final Context context, int errorCode) {
        String str;
        GdtWXMiniJumpConfig gdtWXMiniJumpConfig = null;
        if (y(errorCode)) {
            GdtWXMiniJumpConfig gdtWXMiniJumpConfig2 = mGdtWXMiniJumpConfig;
            if (gdtWXMiniJumpConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGdtWXMiniJumpConfig");
                gdtWXMiniJumpConfig2 = null;
            }
            str = gdtWXMiniJumpConfig2.getAuthRejectMsg();
        } else if (errorCode == LaunchWxaErrorCode.FailLoadDynamic.getCode()) {
            GdtWXMiniJumpConfig gdtWXMiniJumpConfig3 = mGdtWXMiniJumpConfig;
            if (gdtWXMiniJumpConfig3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGdtWXMiniJumpConfig");
                gdtWXMiniJumpConfig3 = null;
            }
            str = gdtWXMiniJumpConfig3.getLoadErrorMsg();
        } else if (errorCode == LaunchWxaErrorCode.FailTeenager.getCode()) {
            GdtWXMiniJumpConfig gdtWXMiniJumpConfig4 = mGdtWXMiniJumpConfig;
            if (gdtWXMiniJumpConfig4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGdtWXMiniJumpConfig");
                gdtWXMiniJumpConfig4 = null;
            }
            str = gdtWXMiniJumpConfig4.getTeenagerErrorMsg();
        } else if (errorCode == LaunchWxaErrorCode.FailAppInfo.getCode()) {
            GdtWXMiniJumpConfig gdtWXMiniJumpConfig5 = mGdtWXMiniJumpConfig;
            if (gdtWXMiniJumpConfig5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGdtWXMiniJumpConfig");
                gdtWXMiniJumpConfig5 = null;
            }
            str = gdtWXMiniJumpConfig5.getAppInfoErrorMsg();
        } else {
            str = null;
        }
        if (str != null) {
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                GdtWXMiniJumpConfig gdtWXMiniJumpConfig6 = mGdtWXMiniJumpConfig;
                if (gdtWXMiniJumpConfig6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mGdtWXMiniJumpConfig");
                } else {
                    gdtWXMiniJumpConfig = gdtWXMiniJumpConfig6;
                }
                QQToast.makeText(context, gdtWXMiniJumpConfig.getAuthRejectMsg(), 0).show();
                return;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.gdtad.api.wxmini.GdtWXMiniJumpController$handleErrorCodeToast$lambda$11$$inlined$runOnMainThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    Context context2 = context;
                    GdtWXMiniJumpConfig gdtWXMiniJumpConfig7 = GdtWXMiniJumpController.mGdtWXMiniJumpConfig;
                    if (gdtWXMiniJumpConfig7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mGdtWXMiniJumpConfig");
                        gdtWXMiniJumpConfig7 = null;
                    }
                    QQToast.makeText(context2, gdtWXMiniJumpConfig7.getAuthRejectMsg(), 0).show();
                }
            });
        }
    }

    private final void o(final Context context, final WXMiniSessionData sessionData) {
        sessionData.t(true);
        A(sessionData, new com.tencent.mobileqq.wxmini.api.data.b() { // from class: gm0.d
            @Override // com.tencent.mobileqq.wxmini.api.data.b
            public final void onCallback(boolean z16, Bundle bundle) {
                GdtWXMiniJumpController.p(context, sessionData, z16, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Context context, WXMiniSessionData sessionData, boolean z16, Bundle bundle) {
        int i3;
        boolean z17;
        int i16;
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(sessionData, "$sessionData");
        if (QLog.isColorLevel()) {
            QLog.i("GdtWXMINIProgramJumpController", 2, "success: " + z16 + ", data: " + bundle);
        }
        int i17 = 0;
        if (bundle != null) {
            i3 = bundle.getInt("errCode");
        } else {
            i3 = 0;
        }
        GdtWXMiniJumpController gdtWXMiniJumpController = f108657a;
        boolean y16 = gdtWXMiniJumpController.y(i3);
        boolean z18 = gdtWXMiniJumpController.z(i3);
        if (!z16 && !y16) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z16) {
            gdtWXMiniJumpController.n(context, i3);
            GdtWXMiniJumpConfig gdtWXMiniJumpConfig = mGdtWXMiniJumpConfig;
            if (gdtWXMiniJumpConfig == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGdtWXMiniJumpConfig");
                gdtWXMiniJumpConfig = null;
            }
            boolean b16 = gdtWXMiniJumpConfig.b(String.valueOf(i3));
            if (!y16 && !b16) {
                if (QLog.isColorLevel()) {
                    QLog.i("GdtWXMINIProgramJumpController", 2, "jump inside error, try to jump outside");
                }
                gdtWXMiniJumpController.w(context, sessionData, true);
            } else if (QLog.isColorLevel()) {
                QLog.e("GdtWXMINIProgramJumpController", 2, "authError: " + y16 + ", hitErrorBlackList: " + b16 + ", auth error or hit error black list, jump terminated...");
            }
        }
        if (!sessionData.getHasAuth()) {
            im0.b.f407984a.e(!y16, sessionData, i3);
        }
        im0.b bVar = im0.b.f407984a;
        boolean z19 = !z18;
        if (z18) {
            i16 = i3;
        } else {
            i16 = 0;
        }
        bVar.g(z19, sessionData, i16);
        if (z16) {
            i17 = i3;
        }
        bVar.j(z16, sessionData, i17);
        sessionData.u(z16);
        sessionData.v(z17);
        gdtWXMiniJumpController.D(sessionData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(WXMiniSessionData sessionData) {
        BaseApplication context = BaseApplication.context;
        GdtWXMiniJumpConfig gdtWXMiniJumpConfig = mGdtWXMiniJumpConfig;
        if (gdtWXMiniJumpConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtWXMiniJumpConfig");
            gdtWXMiniJumpConfig = null;
        }
        GdtWXMiniJumpConfig.Companion.JumpType g16 = gdtWXMiniJumpConfig.g(sessionData.getPosId(), sessionData.getOriginId(), sessionData.getJumpTypeAMS());
        sessionData.r(g16);
        im0.b.f407984a.k(sessionData);
        l(sessionData);
        j(sessionData);
        int i3 = a.f108667a[g16.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (QLog.isColorLevel()) {
                    QLog.i("GdtWXMINIProgramJumpController", 2, "jump to wx mini outside...");
                }
                Intrinsics.checkNotNullExpressionValue(context, "context");
                w(context, sessionData, false);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("GdtWXMINIProgramJumpController", 2, "jump to wx mini inside...");
            }
            Intrinsics.checkNotNullExpressionValue(context, "context");
            o(context, sessionData);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("GdtWXMINIProgramJumpController", 2, "jump to wx mini with auth...");
        }
        Intrinsics.checkNotNullExpressionValue(context, "context");
        u(context, sessionData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(AdWXMINIProgram.Params params, AdError adError, String extData) {
        im0.b bVar = im0.b.f407984a;
        bVar.l(params);
        if (adError.isSuccess()) {
            C(params, extData);
        }
        bVar.i(params, adError);
    }

    private final void u(final Context context, final WXMiniSessionData sessionData) {
        ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).checkWxAuthed(new com.tencent.mobileqq.wxmini.api.data.b() { // from class: gm0.c
            @Override // com.tencent.mobileqq.wxmini.api.data.b
            public final void onCallback(boolean z16, Bundle bundle) {
                GdtWXMiniJumpController.v(WXMiniSessionData.this, context, z16, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(WXMiniSessionData sessionData, Context context, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(sessionData, "$sessionData");
        Intrinsics.checkNotNullParameter(context, "$context");
        sessionData.s(z16);
        if (z16) {
            f108657a.o(context, sessionData);
        } else {
            f108657a.w(context, sessionData, false);
        }
    }

    private final void w(Context context, WXMiniSessionData sessionData, boolean undertake) {
        sessionData.t(false);
        if (sessionData.getAdErrorCode() == 0) {
            B(context, sessionData.getChannelAppID(), sessionData.getOriginId(), sessionData.getPath(), sessionData.getExtData());
        }
        im0.b.f407984a.h(sessionData, sessionData.getAdErrorCode());
        if (!undertake) {
            D(sessionData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean x() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    private final boolean y(int code) {
        boolean z16;
        int code2 = LaunchWxaErrorCode.WechatTdi_Auth_Err_UserCanceled.getCode();
        if (code <= LaunchWxaErrorCode.WechatTdi_Auth_Err_Dynamic_Pkg_Not_Loaded.getCode() && code2 <= code) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || code == LaunchWxaErrorCode.FailAuthCommon.getCode()) {
            return true;
        }
        return false;
    }

    private final boolean z(int code) {
        if (code != LaunchWxaErrorCode.FailLoadDynamic.getCode() && code != LaunchWxaErrorCode.FailDownloadSo.getCode()) {
            return false;
        }
        return true;
    }

    @NotNull
    public final AdError q(@Nullable final AdWXMINIProgram.Params params) {
        Long l3;
        String str;
        Pair<AdError, String> m3 = m(params);
        final AdError component1 = m3.component1();
        final String component2 = m3.component2();
        if (params == null) {
            return component1;
        }
        String str2 = null;
        if (GdtWXMiniJumpConfigParser.INSTANCE.c() == null) {
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                f108657a.t(params, component1, component2);
            } else {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.api.wxmini.GdtWXMiniJumpController$handleWXMiniJump$$inlined$runOnSubThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        GdtWXMiniJumpController.f108657a.t(AdWXMINIProgram.Params.this, component1, component2);
                    }
                }, 64, null, false);
            }
            return component1;
        }
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.api.wxmini.GdtWXMiniJumpController$handleWXMiniJump$$inlined$runOnSubThread$2
                @Override // java.lang.Runnable
                public final void run() {
                    Long l16;
                    String str3;
                    GdtWXMiniData gdtWXMiniData = new GdtWXMiniData(null, 0, null, null, null, null, null, null, null, null, null, false, 0, InitSkin.DRAWABLE_COUNT, null);
                    String str4 = AdWXMINIProgram.Params.this.channelAppID;
                    String str5 = "";
                    if (str4 == null) {
                        str4 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str4, "params.channelAppID ?: \"\"");
                    }
                    gdtWXMiniData.setChannelAppID(str4);
                    gdtWXMiniData.setOpenType(AdWXMINIProgram.Params.this.openType);
                    String str6 = AdWXMINIProgram.Params.this.token;
                    if (str6 == null) {
                        str6 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str6, "params.token ?: \"\"");
                    }
                    gdtWXMiniData.setToken(str6);
                    String str7 = AdWXMINIProgram.Params.this.appID;
                    if (str7 == null) {
                        str7 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str7, "params.appID ?: \"\"");
                    }
                    gdtWXMiniData.setAppID(str7);
                    String str8 = AdWXMINIProgram.Params.this.userName;
                    if (str8 == null) {
                        str8 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str8, "params.userName ?: \"\"");
                    }
                    gdtWXMiniData.setUserName(str8);
                    String str9 = AdWXMINIProgram.Params.this.path;
                    if (str9 == null) {
                        str9 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str9, "params.path ?: \"\"");
                    }
                    gdtWXMiniData.setPath(str9);
                    String str10 = AdWXMINIProgram.Params.this.traceData;
                    if (str10 == null) {
                        str10 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str10, "params.traceData ?: \"\"");
                    }
                    gdtWXMiniData.setTraceData(str10);
                    Ad ad5 = AdWXMINIProgram.Params.this.f61351ad;
                    String str11 = null;
                    if (ad5 != null) {
                        l16 = Long.valueOf(ad5.getAId());
                    } else {
                        l16 = null;
                    }
                    gdtWXMiniData.setAid(String.valueOf(l16));
                    Ad ad6 = AdWXMINIProgram.Params.this.f61351ad;
                    if (ad6 != null) {
                        str3 = ad6.getPosId();
                    } else {
                        str3 = null;
                    }
                    if (str3 == null) {
                        str3 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str3, "params.ad?.posId ?: \"\"");
                    }
                    gdtWXMiniData.setPosId(str3);
                    Ad ad7 = AdWXMINIProgram.Params.this.f61351ad;
                    if (ad7 != null) {
                        str11 = ad7.getTraceId();
                    }
                    if (str11 != null) {
                        Intrinsics.checkNotNullExpressionValue(str11, "params.ad?.traceId ?: \"\"");
                        str5 = str11;
                    }
                    gdtWXMiniData.setTraceId(str5);
                    gdtWXMiniData.setExtData(component2);
                    gdtWXMiniData.setReportForLink(AdWXMINIProgram.Params.this.reportForLinkEvent);
                    gdtWXMiniData.setAdErrorCode(component1.getErrorCode());
                    GdtWXMiniJumpController gdtWXMiniJumpController = GdtWXMiniJumpController.f108657a;
                    if (gdtWXMiniJumpController.x()) {
                        gdtWXMiniJumpController.s(gdtWXMiniData);
                        return;
                    }
                    QIPCClientHelper qIPCClientHelper = QIPCClientHelper.getInstance();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(GdtWXMiniData.IPC_DATA_NAME, gdtWXMiniData);
                    Unit unit = Unit.INSTANCE;
                    qIPCClientHelper.callServer("GdtWXMiniIPCModule", "handle_wxmini_jump", bundle, GdtWXMiniJumpController.b.f108668d);
                }
            }, 64, null, false);
        } else {
            GdtWXMiniData gdtWXMiniData = new GdtWXMiniData(null, 0, null, null, null, null, null, null, null, null, null, false, 0, InitSkin.DRAWABLE_COUNT, null);
            String str3 = params.channelAppID;
            String str4 = "";
            if (str3 == null) {
                str3 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str3, "params.channelAppID ?: \"\"");
            }
            gdtWXMiniData.setChannelAppID(str3);
            gdtWXMiniData.setOpenType(params.openType);
            String str5 = params.token;
            if (str5 == null) {
                str5 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str5, "params.token ?: \"\"");
            }
            gdtWXMiniData.setToken(str5);
            String str6 = params.appID;
            if (str6 == null) {
                str6 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str6, "params.appID ?: \"\"");
            }
            gdtWXMiniData.setAppID(str6);
            String str7 = params.userName;
            if (str7 == null) {
                str7 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str7, "params.userName ?: \"\"");
            }
            gdtWXMiniData.setUserName(str7);
            String str8 = params.path;
            if (str8 == null) {
                str8 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str8, "params.path ?: \"\"");
            }
            gdtWXMiniData.setPath(str8);
            String str9 = params.traceData;
            if (str9 == null) {
                str9 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str9, "params.traceData ?: \"\"");
            }
            gdtWXMiniData.setTraceData(str9);
            Ad ad5 = params.f61351ad;
            if (ad5 != null) {
                l3 = Long.valueOf(ad5.getAId());
            } else {
                l3 = null;
            }
            gdtWXMiniData.setAid(String.valueOf(l3));
            Ad ad6 = params.f61351ad;
            if (ad6 != null) {
                str = ad6.getPosId();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "params.ad?.posId ?: \"\"");
            }
            gdtWXMiniData.setPosId(str);
            Ad ad7 = params.f61351ad;
            if (ad7 != null) {
                str2 = ad7.getTraceId();
            }
            if (str2 != null) {
                Intrinsics.checkNotNullExpressionValue(str2, "params.ad?.traceId ?: \"\"");
                str4 = str2;
            }
            gdtWXMiniData.setTraceId(str4);
            gdtWXMiniData.setExtData(component2);
            gdtWXMiniData.setReportForLink(params.reportForLinkEvent);
            gdtWXMiniData.setAdErrorCode(component1.getErrorCode());
            GdtWXMiniJumpController gdtWXMiniJumpController = f108657a;
            if (gdtWXMiniJumpController.x()) {
                gdtWXMiniJumpController.s(gdtWXMiniData);
            } else {
                QIPCClientHelper qIPCClientHelper = QIPCClientHelper.getInstance();
                Bundle bundle = new Bundle();
                bundle.putParcelable(GdtWXMiniData.IPC_DATA_NAME, gdtWXMiniData);
                Unit unit = Unit.INSTANCE;
                qIPCClientHelper.callServer("GdtWXMiniIPCModule", "handle_wxmini_jump", bundle, b.f108668d);
            }
        }
        return new AdError(0);
    }

    public final void s(@NotNull final GdtWXMiniData gdtWXMiniData) {
        Intrinsics.checkNotNullParameter(gdtWXMiniData, "gdtWXMiniData");
        GdtWXMiniJumpConfig gdtWXMiniJumpConfig = null;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.api.wxmini.GdtWXMiniJumpController$handleWXMiniJumpNewRoute$$inlined$runOnSubThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    GdtWXMiniJumpConfig c16 = GdtWXMiniJumpConfigParser.INSTANCE.c();
                    if (c16 != null) {
                        GdtWXMiniJumpController.mGdtWXMiniJumpConfig = c16;
                        GdtWXMiniData gdtWXMiniData2 = GdtWXMiniData.this;
                        GdtWXMiniJumpConfig gdtWXMiniJumpConfig2 = GdtWXMiniJumpController.mGdtWXMiniJumpConfig;
                        if (gdtWXMiniJumpConfig2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mGdtWXMiniJumpConfig");
                            gdtWXMiniJumpConfig2 = null;
                        }
                        GdtWXMiniJumpController.f108657a.r(new WXMiniSessionData(gdtWXMiniData2, gdtWXMiniJumpConfig2));
                    }
                }
            }, 64, null, false);
            return;
        }
        GdtWXMiniJumpConfig c16 = GdtWXMiniJumpConfigParser.INSTANCE.c();
        if (c16 != null) {
            mGdtWXMiniJumpConfig = c16;
            GdtWXMiniJumpConfig gdtWXMiniJumpConfig2 = mGdtWXMiniJumpConfig;
            if (gdtWXMiniJumpConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGdtWXMiniJumpConfig");
            } else {
                gdtWXMiniJumpConfig = gdtWXMiniJumpConfig2;
            }
            f108657a.r(new WXMiniSessionData(gdtWXMiniData, gdtWXMiniJumpConfig));
        }
    }
}
