package nu3;

import android.content.Context;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResDownload;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.q;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lnu3/i;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "", "f", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "req", "c", "Lorg/json/JSONObject;", "data", "d", "dataObj", "e", "Lnu3/a;", "eventBean", "b", "Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;", "miniAppContext", "onCreate", "dispatchEvent", "Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;", "Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager;", "Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager;", MosaicConstants$JsProperty.PROP_FILE_MANAGER, "<init>", "()V", "a", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class i extends BaseJsPlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private IMiniAppContext miniAppContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private IMiniAppFileManager fileManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"nu3/i$b", "Lcom/tencent/aelight/camera/download/api/a;", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "aeResInfo", "", "localFilePath", "", "downloaded", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "", "onAEDownloadFinish", "", "currentOffset", "totalLength", "onAEProgressUpdate", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements com.tencent.aelight.camera.download.api.a {
        b() {
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEDownloadFinish(AEResInfo aeResInfo, String localFilePath, boolean downloaded, int errorType) {
            Intrinsics.checkNotNullParameter(aeResInfo, "aeResInfo");
            Intrinsics.checkNotNullParameter(localFilePath, "localFilePath");
            ee4.b.a("WS_WeishiPlugin", "AE download complete");
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEProgressUpdate(AEResInfo aeResInfo, long currentOffset, long totalLength) {
            Intrinsics.checkNotNullParameter(aeResInfo, "aeResInfo");
            ee4.b.a("WS_WeishiPlugin", "AE downloading " + currentOffset);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"nu3/i$c", "Lcom/tencent/aelight/camera/download/api/a;", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "aeResInfo", "", "localFilePath", "", "downloaded", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "", "onAEDownloadFinish", "", "currentOffset", "totalLength", "onAEProgressUpdate", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements com.tencent.aelight.camera.download.api.a {
        c() {
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEDownloadFinish(AEResInfo aeResInfo, String localFilePath, boolean downloaded, int errorType) {
            Intrinsics.checkNotNullParameter(aeResInfo, "aeResInfo");
            Intrinsics.checkNotNullParameter(localFilePath, "localFilePath");
            ee4.b.a("WS_WeishiPlugin", "Light download complete");
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEProgressUpdate(AEResInfo aeResInfo, long currentOffset, long totalLength) {
            Intrinsics.checkNotNullParameter(aeResInfo, "aeResInfo");
            ee4.b.a("WS_WeishiPlugin", "Light downloading " + currentOffset);
        }
    }

    static {
        f.INSTANCE.a();
    }

    private final void b(RequestEvent req, a eventBean) {
        com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.a b16 = q.f347998a.b(eventBean.getCom.vivo.push.PushClientConstants.TAG_CLASS_NAME java.lang.String());
        if (b16 == null) {
            req.fail("getProxy(classKey) is Null " + eventBean);
            return;
        }
        b16.q(this.miniAppContext);
        b16.r(this.fileManager);
        try {
            b16.e(req, eventBean);
        } catch (Exception e16) {
            ee4.b.c("WS_WeishiPlugin", "dispatchProxy: ", e16);
            req.fail();
        }
    }

    private final void c(RequestEvent req) throws JSONException {
        a cVar;
        JSONObject data = new JSONObject(req.jsonParams).getJSONObject("data");
        String str = req.event;
        if (str != null) {
            switch (str.hashCode()) {
                case -334345512:
                    if (str.equals("tav_util")) {
                        Intrinsics.checkNotNullExpressionValue(data, "data");
                        d(req, data);
                        return;
                    }
                    break;
                case -169686000:
                    if (str.equals("tav_releaseObject")) {
                        Intrinsics.checkNotNullExpressionValue(data, "data");
                        e(req, data);
                        return;
                    }
                    break;
                case 885762097:
                    if (str.equals("tav_createObject")) {
                        Intrinsics.checkNotNullExpressionValue(data, "data");
                        cVar = new nu3.c(data);
                        b(req, cVar);
                        return;
                    }
                    break;
                case 1192724221:
                    if (str.equals("tav_sendMsgToObject")) {
                        Intrinsics.checkNotNullExpressionValue(data, "data");
                        cVar = new d(data);
                        b(req, cVar);
                        return;
                    }
                    break;
            }
        }
        req.fail("No match event");
    }

    private final void d(RequestEvent req, JSONObject data) throws JSONException {
        String string;
        if (!data.has("methodName") || (string = data.getString("methodName")) == null) {
            return;
        }
        h.f421343a.a(req, string);
    }

    private final void e(RequestEvent req, JSONObject dataObj) throws JSONException {
        ee4.b.i("WS_WeishiPlugin", "releaseObj() called with: req = [" + req + "], dataObj = [" + dataObj + "]");
        if (!dataObj.has("tavobject")) {
            req.fail("No tavobject");
            return;
        }
        JSONObject jSONObject = dataObj.getJSONObject("tavobject");
        if (!jSONObject.has(IECDtReport.ACTION_IDENTIFIER)) {
            req.fail("No identifier");
            return;
        }
        String identifier = jSONObject.getString(IECDtReport.ACTION_IDENTIFIER);
        g gVar = g.f421341a;
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier");
        gVar.e(identifier);
        req.ok();
    }

    private final void f() {
        ee4.b.a("WS_WeishiPlugin", "[startDownloadBaseResource] start download");
        ((IAEResDownload) QRoute.api(IAEResDownload.class)).requestDownload(AEResInfo.AE_RES_BASE_PACKAGE, new b(), false);
        ((IAEResDownload) QRoute.api(IAEResDownload.class)).requestDownload(AEResInfo.LIGHT_RES_BASE_PACKAGE, new c(), false);
    }

    @JsEvent({"tav_createObject", "tav_sendMsgToObject", "tav_releaseObject", "tav_util"})
    public final void dispatchEvent(RequestEvent req) {
        String dropLast;
        Intrinsics.checkNotNullParameter(req, "req");
        ee4.b.a("WS_WeishiPlugin", "dispatchEvent() called with: req = [" + req.jsonParams + "]");
        if (!od4.b.u()) {
            String aEKitBaseResUnzipFinalPath = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEKitBaseResUnzipFinalPath();
            Intrinsics.checkNotNullExpressionValue(aEKitBaseResUnzipFinalPath, "api(IAEResUtil::class.ja\u2026eKitBaseResUnzipFinalPath");
            dropLast = StringsKt___StringsKt.dropLast(aEKitBaseResUnzipFinalPath, 1);
            if (!e.e(dropLast)) {
                ee4.b.a("WS_WeishiPlugin", "initTavCut fail");
                req.fail("tavcut.init fail, retCode = -10001");
                return;
            }
            ee4.b.a("WS_WeishiPlugin", "initTavCut success");
        }
        try {
            c(req);
        } catch (Exception e16) {
            ee4.b.c("WS_WeishiPlugin", "sendMsgToObject: ", e16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext miniAppContext) {
        Intrinsics.checkNotNullParameter(miniAppContext, "miniAppContext");
        super.onCreate(miniAppContext);
        this.miniAppContext = miniAppContext;
        this.fileManager = (IMiniAppFileManager) miniAppContext.getManager(IMiniAppFileManager.class);
        Context context = miniAppContext.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "miniAppContext.context");
        od4.b.s(context, "", "lightsdk_qq", QQWinkConstants.ENTRY_QQ_OTHER);
        od4.a.f422504b.b(false);
        if (((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady()) {
            return;
        }
        f();
    }
}
