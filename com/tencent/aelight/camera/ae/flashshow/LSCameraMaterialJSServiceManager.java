package com.tencent.aelight.camera.ae.flashshow;

import camera.MOBILE_QQ_MATERIAL_INTERFACE.CameraPropertyAIRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.MediaInfo;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.aelight.camera.ae.config.CameraPeakPBServiceHandler;
import com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler;
import com.tencent.aelight.camera.ae.util.d;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qshadow.QShadowMaterialGeneralService$MaterialGeneralSrvRsp;
import qshadow.QShadowMaterialGeneralService$ParamEntry;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003<'/B\t\b\u0002\u00a2\u0006\u0004\b:\u0010;J0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0016\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0018J\u0016\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0018J\u0006\u0010\u001c\u001a\u00020\tJ\u0006\u0010\u001d\u001a\u00020\u0002J\u0016\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u001eJ\u001a\u0010#\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u00022\b\u0010\"\u001a\u0004\u0018\u00010!J\u001a\u0010%\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010\u00022\b\u0010\"\u001a\u0004\u0018\u00010!R\u0017\u0010+\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R3\u00103\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020-0,j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020-`.8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R \u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00105R\u0014\u00109\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u00108\u00a8\u0006="}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/LSCameraMaterialJSServiceManager;", "", "", "busiId", "Ljava/util/ArrayList;", "Lcamera/MOBILE_QQ_MATERIAL_INTERFACE/MediaInfo;", "Lkotlin/collections/ArrayList;", "mediaInfos", "extra", "", "t", WadlProxyConsts.PARAM_FILENAME, "g", "path", "i", "downloadUrl", "", "d", "jceReqFromJs", "Lcom/tencent/aelight/camera/ae/flashshow/LSCameraMaterialJSServiceManager$b;", "listener", "j", "k", "urlFromJs", "Lcom/tencent/aelight/camera/ae/flashshow/LSCameraMaterialJSServiceManager$c;", "l", "req", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ReportConstant.COSTREPORT_PREFIX, "f", "Lcom/tencent/aelight/camera/ae/flashshow/LSCameraMaterialJSServiceManager$a;", "o", "friendSelected", "Lcom/tencent/aelight/camera/ae/e;", "mMaterialViewModel", DomainData.DOMAIN_NAME, LocalPhotoFaceInfo.SCORE, "r", "Lcom/tencent/common/app/AppInterface;", "b", "Lcom/tencent/common/app/AppInterface;", "e", "()Lcom/tencent/common/app/AppInterface;", "appInterface", "Ljava/util/HashMap;", "Lcom/tencent/aelight/camera/ae/config/g;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", tl.h.F, "()Ljava/util/HashMap;", "observerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "urlMap", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", "<init>", "()V", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class LSCameraMaterialJSServiceManager {

    /* renamed from: a, reason: collision with root package name */
    public static final LSCameraMaterialJSServiceManager f63895a = new LSCameraMaterialJSServiceManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final AppInterface appInterface;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, com.tencent.aelight.camera.ae.config.g> observerMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, String> urlMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final CoroutineScope viewModelScope;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/LSCameraMaterialJSServiceManager$a;", "", "", "result", "", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public interface a {
        void a(String result);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/LSCameraMaterialJSServiceManager$b;", "", "", "rsp", "", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public interface b {
        void a(String rsp);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/LSCameraMaterialJSServiceManager$c;", "", "", "rsp", "", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public interface c {
        void a(String rsp);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/LSCameraMaterialJSServiceManager$d", "Lcom/tencent/aelight/camera/ae/config/g;", "", "isSuccess", "Lcamera/MOBILE_QQ_MATERIAL_INTERFACE/CameraPropertyAIRsp;", "rsp", "", "onUpdateCameraMaterialResponse", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class d extends com.tencent.aelight.camera.ae.config.g {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f63900d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f63901e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f63902f;

        d(String str, String str2, b bVar) {
            this.f63900d = str;
            this.f63901e = str2;
            this.f63902f = bVar;
        }

        @Override // com.tencent.aelight.camera.ae.config.g
        public void onUpdateCameraMaterialResponse(boolean isSuccess, CameraPropertyAIRsp rsp) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            if (rsp == null) {
                jSONObject2.put("Uuid", this.f63900d);
                jSONObject2.put("Ret", -1);
                jSONObject2.put(AECameraConstants.REQ_EXTRA, this.f63901e);
                jSONObject.put("lightCameraJCERsp", jSONObject2);
                ms.a.c("AECameraMaterialJSServiceManager", "onUpdateCameraPropertyAI rsp is null");
                b bVar = this.f63902f;
                if (bVar != null) {
                    String jSONObject3 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject3, "res.toString()");
                    bVar.a(jSONObject3);
                    return;
                }
                return;
            }
            try {
                jSONObject2.put("Uuid", this.f63900d);
                jSONObject2.put(AECameraConstants.REQ_EXTRA, rsp.Extra);
                JSONArray jSONArray = new JSONArray();
                Iterator<MediaInfo> it = rsp.MediaInfos.iterator();
                while (it.hasNext()) {
                    MediaInfo next = it.next();
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("MediaType", next.MediaType);
                    jSONObject4.put(Global.TRACKING_URL, next.URL);
                    jSONArray.mo162put(jSONObject4);
                }
                jSONObject2.put(AECameraConstants.REQ_MEDIA_INFOS, jSONArray);
                jSONObject2.put("Ret", rsp.Code);
                jSONObject.put("lightCameraJCERsp", jSONObject2);
            } catch (JSONException e16) {
                e16.printStackTrace();
                ms.a.c("AECameraMaterialJSServiceManager", "onUpdateCameraPropertyAI exception: " + e16.getMessage());
                jSONObject2.put("Uuid", this.f63900d);
                jSONObject2.put("Ret", -1);
                jSONObject.put("lightCameraJCERsp", jSONObject2);
            }
            b bVar2 = this.f63902f;
            if (bVar2 != null) {
                String jSONObject5 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject5, "res.toString()");
                bVar2.a(jSONObject5);
            }
            LSCameraMaterialJSServiceManager lSCameraMaterialJSServiceManager = LSCameraMaterialJSServiceManager.f63895a;
            lSCameraMaterialJSServiceManager.e().removeObserver(lSCameraMaterialJSServiceManager.h().get(this.f63900d));
            lSCameraMaterialJSServiceManager.h().remove(this.f63900d);
            ms.a.f("AECameraMaterialJSServiceManager", "handleCameraProertyAIJce receive: " + jSONObject);
        }
    }

    static {
        AppInterface a16 = QQStoryContext.a();
        Intrinsics.checkNotNullExpressionValue(a16, "getAppRuntime()");
        appInterface = a16;
        observerMap = new HashMap<>();
        urlMap = new ConcurrentHashMap<>();
        viewModelScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
    }

    LSCameraMaterialJSServiceManager() {
    }

    private final boolean d(String downloadUrl) {
        String str = urlMap.get(downloadUrl);
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            return new File(str).exists();
        } catch (Exception e16) {
            ms.a.c("AECameraMaterialJSServiceManager", "checkIsCacheExists check cache file failed: " + e16.getMessage());
            return false;
        }
    }

    private final String g(String fileName) {
        String str = u53.d.f438383c + File.separator;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str + System.nanoTime() + fileName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [qshadow.QShadowMaterialGeneralService$ParamEntry] */
    public static final void p(String requestName, final SoftReference softListener) {
        Intrinsics.checkNotNullParameter(requestName, "$requestName");
        Intrinsics.checkNotNullParameter(softListener, "$softListener");
        BusinessHandler businessHandler = appInterface.getBusinessHandler(PeakAppInterface.J);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.aelight.camera.ae.config.CameraPeakPBServiceHandler");
        CameraPeakPBServiceHandler cameraPeakPBServiceHandler = (CameraPeakPBServiceHandler) businessHandler;
        cameraPeakPBServiceHandler.A3(new CameraPeakPBServiceHandler.a() { // from class: com.tencent.aelight.camera.ae.flashshow.ak
            @Override // com.tencent.aelight.camera.ae.config.CameraPeakPBServiceHandler.a
            public final void a(String str, boolean z16, Object obj) {
                LSCameraMaterialJSServiceManager.q(softListener, str, z16, obj);
            }
        });
        cameraPeakPBServiceHandler.z3(requestName, new MessageMicro<QShadowMaterialGeneralService$ParamEntry>() { // from class: qshadow.QShadowMaterialGeneralService$ParamEntry
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"param_key", "param_value"}, new Object[]{"", ""}, QShadowMaterialGeneralService$ParamEntry.class);
            public final PBStringField param_key = PBField.initString("");
            public final PBStringField param_value = PBField.initString("");
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(SoftReference softListener, String str, boolean z16, Object obj) {
        a aVar;
        Intrinsics.checkNotNullParameter(softListener, "$softListener");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        QShadowMaterialGeneralService$MaterialGeneralSrvRsp qShadowMaterialGeneralService$MaterialGeneralSrvRsp = (QShadowMaterialGeneralService$MaterialGeneralSrvRsp) obj;
        if (qShadowMaterialGeneralService$MaterialGeneralSrvRsp != null) {
            jSONObject2.put("type", str);
            jSONObject2.put("data", qShadowMaterialGeneralService$MaterialGeneralSrvRsp.result.get());
            jSONObject.put(AECameraConstants.KEY_CAMERA_MATERIAL_JS_PB_RES, jSONObject2);
        }
        if (softListener.get() == null || (aVar = (a) softListener.get()) == null) {
            return;
        }
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "result.toString()");
        aVar.a(jSONObject3);
    }

    private final void t(String busiId, ArrayList<MediaInfo> mediaInfos, String extra) {
        AppInterface appInterface2 = appInterface;
        BusinessHandler businessHandler = appInterface2.getBusinessHandler(PeakAppInterface.I);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler");
        ToServiceMsg toServiceMsg = new ToServiceMsg("ShadowBackendSvc", appInterface2.getCurrentAccountUin(), AECameraConstants.CMD_CAMERA_PROPERTY_AI);
        toServiceMsg.addAttribute(AECameraConstants.REQ_BUSI_ID, busiId);
        toServiceMsg.addAttribute(AECameraConstants.REQ_MEDIA_INFOS, mediaInfos);
        toServiceMsg.addAttribute(AECameraConstants.REQ_EXTRA, extra);
        ((CameraPeakServiceHandler) businessHandler).send(toServiceMsg);
        ms.a.f("AECameraMaterialJSServiceManager", "requestCameraMaterialData send request");
    }

    public final AppInterface e() {
        return appInterface;
    }

    public final String f() {
        String PATH_CAMERA_MATERIAL_SERVICE_CACHE = u53.d.f438383c;
        Intrinsics.checkNotNullExpressionValue(PATH_CAMERA_MATERIAL_SERVICE_CACHE, "PATH_CAMERA_MATERIAL_SERVICE_CACHE");
        return PATH_CAMERA_MATERIAL_SERVICE_CACHE;
    }

    public final HashMap<String, com.tencent.aelight.camera.ae.config.g> h() {
        return observerMap;
    }

    public final void k(String jceReqFromJs, b listener) {
        Intrinsics.checkNotNullParameter(jceReqFromJs, "jceReqFromJs");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ms.a.f("AECameraMaterialJSServiceManager", "handleCameraMaterialJceRequest jceReqFromJs: " + jceReqFromJs);
        try {
            JSONObject jSONObject = new JSONObject(jceReqFromJs);
            Object obj = jSONObject.get("Uuid");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj;
            Object obj2 = jSONObject.get(AECameraConstants.REQ_BUSI_ID);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            String str2 = (String) obj2;
            Object obj3 = jSONObject.get(AECameraConstants.REQ_EXTRA);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
            String str3 = (String) obj3;
            Object obj4 = jSONObject.get(AECameraConstants.REQ_MEDIA_INFOS);
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type org.json.JSONArray");
            JSONArray jSONArray = (JSONArray) obj4;
            ArrayList<MediaInfo> arrayList = new ArrayList<>();
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                Object obj5 = jSONObject2.get("MediaType");
                Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Int");
                int intValue = ((Integer) obj5).intValue();
                Object obj6 = jSONObject2.get(Global.TRACKING_URL);
                Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.String");
                arrayList.add(new MediaInfo((String) obj6, null, intValue));
            }
            d dVar = new d(str, str3, listener);
            observerMap.put(str, dVar);
            AppInterface appInterface2 = appInterface;
            if (appInterface2 == null) {
                ms.a.c("AECameraMaterialJSServiceManager", "handleCameraProertyAIJce error:appInterface is null.");
            } else {
                appInterface2.addObserver(dVar);
                t(str2, arrayList, str3);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
            ms.a.c("AECameraMaterialJSServiceManager", "handleCameraProertyAIJce handle json error");
        }
    }

    public final void l(String urlFromJs, c listener) {
        Intrinsics.checkNotNullParameter(urlFromJs, "urlFromJs");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ms.a.f("AECameraMaterialJSServiceManager", "handleCameraMaterialResource urlFromJs: " + urlFromJs);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject(urlFromJs);
            Object obj = jSONObject3.get("Uuid");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj;
            Object obj2 = jSONObject3.get(Global.TRACKING_URL);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            String str2 = (String) obj2;
            Object obj3 = jSONObject3.get(AECameraConstants.REQ_EXTRA);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
            String str3 = (String) obj3;
            if (d(str2)) {
                ms.a.f("AECameraMaterialJSServiceManager", "handleCameraMaterialResource get cache exists");
                jSONObject2.put("Uuid", str);
                jSONObject2.put("LocalFilePath", urlMap.get(str2));
                jSONObject2.put(AECameraConstants.REQ_EXTRA, str3);
                jSONObject2.put("Ret", 0);
                jSONObject.put("lightCameraResDownloadRsp", jSONObject2);
                String jSONObject4 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject4, "res.toString()");
                listener.a(jSONObject4);
            } else {
                String g16 = g(i(str2));
                urlMap.put(str2, g16);
                com.tencent.aelight.camera.ae.util.d.b().a(str2, g16, new e(jSONObject2, str, jSONObject, listener, g16, str3));
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
            ms.a.c("AECameraMaterialJSServiceManager", "handleCameraMaterialResource handle json error");
        }
    }

    public final void o(String req, a listener) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(listener, "listener");
        try {
            Object obj = new JSONObject(req).get("requestName");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            final String str = (String) obj;
            final SoftReference softReference = new SoftReference(listener);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.aj
                @Override // java.lang.Runnable
                public final void run() {
                    LSCameraMaterialJSServiceManager.p(str, softReference);
                }
            }, 128, null, true);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public final void s() {
        HashMap<String, com.tencent.aelight.camera.ae.config.g> hashMap = observerMap;
        ms.a.f("AECameraMaterialJSServiceManager", "remove all observer, size is: " + hashMap.size());
        Iterator<Map.Entry<String, com.tencent.aelight.camera.ae.config.g>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            appInterface.removeObserver(it.next().getValue());
        }
        observerMap.clear();
    }

    public final void j(String jceReqFromJs, b listener) {
        Intrinsics.checkNotNullParameter(jceReqFromJs, "jceReqFromJs");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ms.a.f("AECameraMaterialJSServiceManager", "handleCameraAIGCMaterialJceRequest jceReqFromJs:");
        try {
            JSONObject jSONObject = new JSONObject(jceReqFromJs);
            Object obj = jSONObject.get("Uuid");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj;
            Object obj2 = jSONObject.get(AECameraConstants.REQ_EXTRA);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = jSONObject.get("Paths");
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type org.json.JSONArray");
            JSONArray jSONArray = (JSONArray) obj3;
            BuildersKt__Builders_commonKt.launch$default(viewModelScope, null, null, new LSCameraMaterialJSServiceManager$handleCameraAIGCMaterialJceRequest$1(jSONArray.length(), jSONArray, new ArrayList(), str, listener, null), 3, null);
        } catch (JSONException e16) {
            e16.printStackTrace();
            ms.a.c("AECameraMaterialJSServiceManager", "handleCameraAIGCMaterialJceRequest handle json error" + Unit.INSTANCE);
        }
    }

    public final void n(String friendSelected, com.tencent.aelight.camera.ae.e mMaterialViewModel) {
        if (friendSelected != null) {
            try {
                Object obj = new JSONObject(friendSelected).get("selectedList");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                JSONArray jSONArray = new JSONArray((String) obj);
                StringBuilder sb5 = new StringBuilder();
                if (jSONArray.length() > 0) {
                    int length = jSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                        String string = jSONObject.getString("uin");
                        String string2 = jSONObject.getString("nickname");
                        sb5.append("@{uin:");
                        sb5.append(string);
                        sb5.append(",nick:");
                        sb5.append(string2);
                        sb5.append("} ");
                    }
                }
                if (mMaterialViewModel != null) {
                    String sb6 = sb5.toString();
                    Intrinsics.checkNotNullExpressionValue(sb6, "contentBuilder.toString()");
                    mMaterialViewModel.Z1(sb6);
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    public final void m(String req, c listener) {
        LSCameraMaterialJSServiceManager lSCameraMaterialJSServiceManager = this;
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ms.a.f("AECameraMaterialJSServiceManager", "handleCameraMaterialResource req: " + req);
        try {
            JSONArray jSONArray = new JSONArray(new JSONObject(req).get("resourceList").toString());
            int length = jSONArray.length();
            ms.a.f("AECameraMaterialJSServiceManager", "handleCameraMaterialResource download size: " + length);
            AtomicInteger atomicInteger = new AtomicInteger(length);
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            int i3 = 0;
            while (i3 < length) {
                JSONObject jSONObject2 = new JSONObject(jSONArray.get(i3).toString());
                Object obj = jSONObject2.get("Uuid");
                Object obj2 = jSONObject2.get(Global.TRACKING_URL);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                String str = (String) obj2;
                String g16 = lSCameraMaterialJSServiceManager.g(lSCameraMaterialJSServiceManager.i(str));
                JSONArray jSONArray3 = jSONArray;
                int i16 = length;
                com.tencent.aelight.camera.ae.util.d.b().a(str, g16, new f(atomicInteger, obj, str, g16, jSONArray2, jSONObject, listener));
                i3++;
                lSCameraMaterialJSServiceManager = this;
                jSONArray = jSONArray3;
                length = i16;
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public final void r(String score, com.tencent.aelight.camera.ae.e mMaterialViewModel) {
        if (score == null || mMaterialViewModel == null) {
            return;
        }
        mMaterialViewModel.a2(score);
    }

    private final String i(String path) {
        int lastIndexOf$default;
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) path, '.', 0, false, 6, (Object) null);
        if (lastIndexOf$default > 0) {
            String substring = path.substring(lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        return "";
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/LSCameraMaterialJSServiceManager$e", "Lcom/tencent/aelight/camera/ae/util/d$a;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "a", "", "progress", "onProgressUpdate", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class e implements d.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f63903a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f63904b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ JSONObject f63905c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f63906d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f63907e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f63908f;

        e(JSONObject jSONObject, String str, JSONObject jSONObject2, c cVar, String str2, String str3) {
            this.f63903a = jSONObject;
            this.f63904b = str;
            this.f63905c = jSONObject2;
            this.f63906d = cVar;
            this.f63907e = str2;
            this.f63908f = str3;
        }

        @Override // com.tencent.aelight.camera.ae.util.d.a
        public void a(NetResp resp) {
            if (resp == null) {
                this.f63903a.put("Uuid", this.f63904b);
                this.f63903a.put("Ret", -1);
                this.f63905c.put("lightCameraResDownloadRsp", this.f63903a);
                ms.a.c("AECameraMaterialJSServiceManager", "onDownloadFinish download rsp is null");
                c cVar = this.f63906d;
                if (cVar != null) {
                    String jSONObject = this.f63905c.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "res.toString()");
                    cVar.a(jSONObject);
                    return;
                }
                return;
            }
            boolean z16 = resp.mResult == 0;
            if (!z16) {
                this.f63903a.put("Uuid", this.f63904b);
                this.f63903a.put("Ret", -1);
                this.f63905c.put("lightCameraResDownloadRsp", this.f63903a);
                ms.a.c("AECameraMaterialJSServiceManager", "onDownloadFinish isSuccess: " + z16);
                c cVar2 = this.f63906d;
                if (cVar2 != null) {
                    String jSONObject2 = this.f63905c.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "res.toString()");
                    cVar2.a(jSONObject2);
                    return;
                }
                return;
            }
            try {
                this.f63903a.put("Uuid", this.f63904b);
                this.f63903a.put("LocalFilePath", this.f63907e);
                this.f63903a.put(AECameraConstants.REQ_EXTRA, this.f63908f);
                this.f63903a.put("Ret", 0);
                this.f63905c.put("lightCameraResDownloadRsp", this.f63903a);
            } catch (JSONException e16) {
                e16.printStackTrace();
                ms.a.c("AECameraMaterialJSServiceManager", "onDownloadFinish exception: " + e16.getMessage());
                this.f63903a.put("Uuid", this.f63904b);
                this.f63903a.put("Ret", -1);
                this.f63905c.put("lightCameraResDownloadRsp", this.f63903a);
            }
            c cVar3 = this.f63906d;
            if (cVar3 != null) {
                String jSONObject3 = this.f63905c.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "res.toString()");
                cVar3.a(jSONObject3);
            }
            ms.a.f("AECameraMaterialJSServiceManager", "onDownloadFinish receive: " + this.f63905c);
        }

        @Override // com.tencent.aelight.camera.ae.util.d.a
        public void onProgressUpdate(int progress) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/LSCameraMaterialJSServiceManager$f", "Lcom/tencent/aelight/camera/ae/util/d$a;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "a", "", "progress", "onProgressUpdate", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class f implements d.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f63909a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f63910b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f63911c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f63912d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ JSONArray f63913e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ JSONObject f63914f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ c f63915g;

        f(AtomicInteger atomicInteger, Object obj, String str, String str2, JSONArray jSONArray, JSONObject jSONObject, c cVar) {
            this.f63909a = atomicInteger;
            this.f63910b = obj;
            this.f63911c = str;
            this.f63912d = str2;
            this.f63913e = jSONArray;
            this.f63914f = jSONObject;
            this.f63915g = cVar;
        }

        @Override // com.tencent.aelight.camera.ae.util.d.a
        public void a(NetResp resp) {
            int decrementAndGet = this.f63909a.decrementAndGet();
            JSONObject jSONObject = new JSONObject();
            if (resp == null) {
                jSONObject.put("Uuid", this.f63910b);
                jSONObject.put("LocalFilePath", "");
                ms.a.c("AECameraMaterialJSServiceManager", "handleCameraMaterialResourceList resp is null, uuid: " + this.f63910b);
                return;
            }
            if (!(resp.mResult == 0)) {
                jSONObject.put("Uuid", this.f63910b);
                jSONObject.put("LocalFilePath", "");
                ms.a.c("AECameraMaterialJSServiceManager", "handleCameraMaterialResourceList isSuccess is false, uuid: " + this.f63910b);
                return;
            }
            LSCameraMaterialJSServiceManager.urlMap.put(this.f63911c, this.f63912d);
            jSONObject.put("Uuid", this.f63910b);
            jSONObject.put("LocalFilePath", this.f63912d);
            this.f63913e.mo162put(jSONObject);
            ms.a.c("AECameraMaterialJSServiceManager", "handleCameraMaterialResourceList isSuccess is true, uuid: " + this.f63910b + ", path: " + this.f63912d);
            if (decrementAndGet == 0) {
                this.f63914f.put("lightCameraResListDownloadRsp", this.f63913e);
                c cVar = this.f63915g;
                if (cVar != null) {
                    String jSONObject2 = this.f63914f.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "resultJson.toString()");
                    cVar.a(jSONObject2);
                }
            }
        }

        @Override // com.tencent.aelight.camera.ae.util.d.a
        public void onProgressUpdate(int progress) {
        }
    }
}
