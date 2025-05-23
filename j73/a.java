package j73;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.wink.utils.ah;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightAsset;
import org.light.LightConstants;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\u0007J\u0010\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0007J\u0016\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019R+\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00190\u00190\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001e\u001a\u0004\b\u001f\u0010 R \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010#\u00a8\u0006'"}, d2 = {"Lj73/a;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "a", "", "", "f", "dirPath", "g", "fileFolder", "", "i", "Lorg/light/LightAsset;", "lightAsset", "j", "agentType", "d", "k", "path", "e", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "callBack", "b", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "aeResInfo", "c", "", "kotlin.jvm.PlatformType", "Ljava/util/Map;", h.F, "()Ljava/util/Map;", "aiResInfo", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "aiMaterialCache", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f409615a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, AEResInfo> aiResInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, Boolean> aiMaterialCache;

    static {
        Map<String, AEResInfo> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("FACE_AGENT", AEResInfo.LIGHT_RES_BUNDLE_FACE), TuplesKt.to("HAND_AGENT", AEResInfo.LIGHT_RES_BUNDLE_HAND), TuplesKt.to("BODY_AGENT", AEResInfo.LIGHT_RES_BUNDLE_BODY), TuplesKt.to("CAT_AGENT", AEResInfo.LIGHT_RES_BUNDLE_CAT), TuplesKt.to("SMILE_AGENT", AEResInfo.LIGHT_RES_SMILE_AGENT), TuplesKt.to("EMOTION_AGENT", AEResInfo.LIGHT_RES_BUNDLE_EMOTION), TuplesKt.to("BG_SEG_AGENT", AEResInfo.LIGHT_RES_BUNDLE_BG_SEG), TuplesKt.to("HEAD_SEG_AGENT", AEResInfo.LIGHT_RES_BUNDLE_SEG_HEAD), TuplesKt.to("HAIR_SEG_AGENT", AEResInfo.LIGHT_RES_BUNDLE_SEG_HAIR), TuplesKt.to("DEPTH_AGENT", AEResInfo.LIGHT_RES_BUNDLE_DEPTH), TuplesKt.to(LightConstants.AgentType.DEPTH_RELATIVE_AGENT, AEResInfo.LIGHT_RES_DEPTH_RELATIVE_AGENT), TuplesKt.to(LightConstants.AgentType.FACE_CLASSIFY_AGENT, AEResInfo.LIGHT_RES_BUNDLE_FACE_CLASSIFY), TuplesKt.to("SKY_SEG_AGENT", AEResInfo.LIGHT_RES_BUNDLE_SEG_SKY), TuplesKt.to("k3D_MM_AGENT", AEResInfo.LIGHT_RES_BUNDLE_3DMM), TuplesKt.to("k3D_MM_AGENT_V2", AEResInfo.LIGHT_RES_FACE_3D_MM_AGENT_V2_AGENT), TuplesKt.to("Ace_3d_Engine", AEResInfo.LIGHT_RES_BUNDLE_ACE3D), TuplesKt.to("BODY3D_POINT_AGENT", AEResInfo.LIGHT_RES_BUNDLE_BODY_3D), TuplesKt.to(LightConstants.AgentType.PIC_ENHANCE_AGENT, AEResInfo.LIGHT_RES_BUNDLE_PIC_ENHANCE), TuplesKt.to(LightConstants.AgentType.REALTIME_PIC_ENHANCE_AGENT, AEResInfo.LIGHT_RES_BUNDLE_PIC_ENHANCE_REALTIME), TuplesKt.to(LightConstants.AgentType.EMOTION_SCOER_AGENT, AEResInfo.LIGHT_RES_EMOTION_SCORE_AGENT), TuplesKt.to("MEDIA_PRECHECK", AEResInfo.LIGHT_RES_BUNDLE_PIC_QUALITY), TuplesKt.to("SCENE_CLASSIFY", AEResInfo.LIGHT_RES_BUNDLE_SCENE), TuplesKt.to(LightConstants.AgentType.FACE_STATIC_FEATURE_AGENT, AEResInfo.LIGHT_RES_BUNDLE_FACE_STATIC_FEATURE), TuplesKt.to("TRACK_AGENT", AEResInfo.LIGHT_RES_BUNDLE_TRACK_AGENT), TuplesKt.to(LightConstants.AgentType.QNN_HTP_BUNDLE, AEResInfo.LIGHT_RES_QNN_HTP_BUNDLE));
        aiResInfo = mapOf;
        aiMaterialCache = new ConcurrentHashMap<>();
    }

    a() {
    }

    public final void a(@NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        List<String> f16 = f(material);
        w53.b.a("WinkAIUtils", "checkAndRegisterAI list " + f16);
        Iterator<T> it = f16.iterator();
        while (it.hasNext()) {
            f409615a.d((String) it.next());
        }
    }

    public final void b(@NotNull MetaMaterial material, @NotNull ResDownLoadListener callBack) {
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        List<String> f16 = f(material);
        Ref.IntRef intRef = new Ref.IntRef();
        int size = f16.size();
        intRef.element = size;
        if (size == 0) {
            callBack.onDownloadFinish(true);
        }
        for (String str : f16) {
            AEResInfo aEResInfo = aiResInfo.get(str);
            if (aEResInfo == null) {
                callBack.onDownloadFinish(false);
                w53.b.c("WinkAIUtils", str + "\u4e0d\u5728\u5df2\u7ecf\u652f\u6301\u7684AI\u80fd\u529b\u5217\u8868");
                return;
            }
            if (!((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(aEResInfo)) {
                ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(aEResInfo.agentType, new C10574a(intRef, callBack, str));
            } else {
                ah.f326668a.e(aEResInfo);
                int i3 = intRef.element - 1;
                intRef.element = i3;
                if (i3 == 0) {
                    callBack.onDownloadFinish(true);
                }
            }
        }
    }

    public final void c(@NotNull AEResInfo aeResInfo) {
        Intrinsics.checkNotNullParameter(aeResInfo, "aeResInfo");
        if (!((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(aeResInfo)) {
            ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(aeResInfo.agentType, new b());
        } else {
            ah.f326668a.e(aeResInfo);
        }
    }

    public final void d(@NotNull String agentType) {
        Intrinsics.checkNotNullParameter(agentType, "agentType");
        AEResInfo aEResInfo = aiResInfo.get(agentType);
        if (aEResInfo == null) {
            return;
        }
        c(aEResInfo);
    }

    public final void e(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        Iterator<String> it = g(path).iterator();
        while (it.hasNext()) {
            AEResInfo aEResInfo = aiResInfo.get(it.next());
            if (aEResInfo != null) {
                ah.f326668a.e(aEResInfo);
            }
        }
    }

    @NotNull
    public final List<String> f(@NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        String m3 = WinkEditorResourceManager.a1().m(material);
        Intrinsics.checkNotNullExpressionValue(m3, "getInstance().getDownloadFolder(material)");
        return g(m3);
    }

    @NotNull
    public final List<String> g(@NotNull String dirPath) {
        List<String> emptyList;
        List<String> list;
        Intrinsics.checkNotNullParameter(dirPath, "dirPath");
        l73.a aVar = l73.a.f413927a;
        if (aVar.k(dirPath)) {
            String f16 = aVar.f(dirPath);
            boolean z16 = false;
            String[] renderAgentTypes = LightAsset.Load(f16, 0).getRenderAgentTypes();
            if (renderAgentTypes != null) {
                if (renderAgentTypes.length == 0) {
                    z16 = true;
                }
                if (!z16) {
                    list = ArraysKt___ArraysKt.toList(renderAgentTypes);
                    return list;
                }
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @NotNull
    public final Map<String, AEResInfo> h() {
        return aiResInfo;
    }

    public final boolean i(@Nullable String fileFolder) {
        boolean z16;
        boolean z17 = false;
        if (fileFolder != null && fileFolder.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        ConcurrentHashMap<String, Boolean> concurrentHashMap = aiMaterialCache;
        if (concurrentHashMap.containsKey(fileFolder)) {
            Boolean bool = concurrentHashMap.get(fileFolder);
            if (bool != null) {
                z17 = bool.booleanValue();
            }
        } else {
            z17 = !g(fileFolder).isEmpty();
            concurrentHashMap.put(fileFolder, Boolean.valueOf(z17));
        }
        w53.b.a("WinkAIUtils", "hasAiAgent " + fileFolder + " " + z17);
        return z17;
    }

    public final boolean j(@NotNull String fileFolder, @Nullable LightAsset lightAsset) {
        Intrinsics.checkNotNullParameter(fileFolder, "fileFolder");
        boolean z16 = false;
        if (lightAsset == null) {
            return false;
        }
        ConcurrentHashMap<String, Boolean> concurrentHashMap = aiMaterialCache;
        if (concurrentHashMap.containsKey(fileFolder)) {
            Boolean bool = concurrentHashMap.get(fileFolder);
            if (bool != null) {
                z16 = bool.booleanValue();
            }
        } else {
            String[] renderAgentTypes = lightAsset.getRenderAgentTypes();
            if (renderAgentTypes != null) {
                if (renderAgentTypes.length == 0) {
                    z16 = true;
                }
                z16 = !z16;
            }
            concurrentHashMap.put(fileFolder, Boolean.valueOf(z16));
        }
        w53.b.a("WinkAIUtils", "hasAiAgent " + fileFolder + " " + z16);
        return z16;
    }

    public final void k(@NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        Iterator<String> it = f(material).iterator();
        while (it.hasNext()) {
            AEResInfo aEResInfo = aiResInfo.get(it.next());
            if (aEResInfo != null) {
                ah.f326668a.e(aEResInfo);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\"\u0010\u000f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"j73/a$a", "Lcom/tencent/aelight/camera/download/api/a;", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "aeResInfo", "", "localFilePath", "", "downloaded", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "", "onAEDownloadFinish", "", "currentOffset", "totalLength", "onAEProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: j73.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C10574a implements com.tencent.aelight.camera.download.api.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f409618d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ResDownLoadListener f409619e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f409620f;

        C10574a(Ref.IntRef intRef, ResDownLoadListener resDownLoadListener, String str) {
            this.f409618d = intRef;
            this.f409619e = resDownLoadListener;
            this.f409620f = str;
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEDownloadFinish(@Nullable AEResInfo aeResInfo, @Nullable String localFilePath, boolean downloaded, int errorType) {
            String soDir = FeatureManager.getSoDir();
            boolean z16 = false;
            if (aeResInfo != null && (errorType == 0 || errorType == 1)) {
                if (soDir == null || soDir.length() == 0) {
                    z16 = true;
                }
                if (!z16) {
                    ah.f326668a.e(aeResInfo);
                    Ref.IntRef intRef = this.f409618d;
                    int i3 = intRef.element - 1;
                    intRef.element = i3;
                    if (i3 == 0) {
                        this.f409619e.onDownloadFinish(true);
                        return;
                    }
                    return;
                }
                return;
            }
            this.f409619e.onDownloadFinish(false);
            w53.b.c("WinkAIUtils", this.f409620f + "\u4e0b\u8f7d\u5931\u8d25");
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEProgressUpdate(@Nullable AEResInfo aeResInfo, long currentOffset, long totalLength) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\"\u0010\u000f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"j73/a$b", "Lcom/tencent/aelight/camera/download/api/a;", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "aeResInfo", "", "localFilePath", "", "downloaded", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "", "onAEDownloadFinish", "", "currentOffset", "totalLength", "onAEProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements com.tencent.aelight.camera.download.api.a {
        b() {
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEDownloadFinish(@Nullable AEResInfo aeResInfo, @Nullable String localFilePath, boolean downloaded, int errorType) {
            String soDir = FeatureManager.getSoDir();
            if (aeResInfo != null) {
                boolean z16 = true;
                if (errorType == 0 || errorType == 1) {
                    if (soDir != null && soDir.length() != 0) {
                        z16 = false;
                    }
                    if (!z16) {
                        ms.a.f("WinkAIUtils", "bundle download checkAndRegisterAI finish " + aeResInfo.agentType);
                        ah.f326668a.e(aeResInfo);
                    }
                }
            }
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEProgressUpdate(@Nullable AEResInfo aeResInfo, long currentOffset, long totalLength) {
        }
    }
}
