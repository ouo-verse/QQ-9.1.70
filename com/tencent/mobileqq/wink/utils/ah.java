package com.tencent.mobileqq.wink.utils;

import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.tavcut.core.render.log.TavLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightAsset;
import org.light.LightConstants;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0016\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0002J\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0016j\b\u0012\u0004\u0012\u00020\u0002`\u00172\u0006\u0010\u0011\u001a\u00020\u0002J\u000e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001cR0\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00190\u001ej\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0019`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/ah;", "", "", "assetFeatureKey", "", "lightBundleMap", "", "g", "agentType", "bundleDir", "", "i", "Lorg/light/LightAsset;", "lightAsset", "d", "", "c", "templatePath", "Lcom/tencent/aelight/camera/download/api/a;", "callback", tl.h.F, "f", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "aeResInfo", "e", "Ljava/util/List;", "needCheckAIAbilities", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "aiAbilityToAEResInfo", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ah {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ah f326668a = new ah();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> needCheckAIAbilities;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LinkedHashMap<String, AEResInfo> aiAbilityToAEResInfo;

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"ai.face", "ai.gan", "ai.hand", "ai.faceStaticFeature", "ai.catFace", "ai.rgbDepth", "ai.segmentHair", "ai.segmentSky", "ai.body", "ai.emotion", "ai.body3d", "ai.segment", "ai.headInset", LightConstants.AssetFeatureKey.NEED_PIC_ENHANCE, LightConstants.AssetFeatureKey.NEED_REALTIME_PIC_ENHANCE});
        needCheckAIAbilities = listOf;
        LinkedHashMap<String, AEResInfo> linkedHashMap = new LinkedHashMap<>();
        AEResInfo LIGHT_RES_BUNDLE_HAND = AEResInfo.LIGHT_RES_BUNDLE_HAND;
        Intrinsics.checkNotNullExpressionValue(LIGHT_RES_BUNDLE_HAND, "LIGHT_RES_BUNDLE_HAND");
        linkedHashMap.put("ai.hand", LIGHT_RES_BUNDLE_HAND);
        AEResInfo LIGHT_RES_BUNDLE_FACE_STATIC_FEATURE = AEResInfo.LIGHT_RES_BUNDLE_FACE_STATIC_FEATURE;
        Intrinsics.checkNotNullExpressionValue(LIGHT_RES_BUNDLE_FACE_STATIC_FEATURE, "LIGHT_RES_BUNDLE_FACE_STATIC_FEATURE");
        linkedHashMap.put("ai.faceStaticFeature", LIGHT_RES_BUNDLE_FACE_STATIC_FEATURE);
        AEResInfo LIGHT_RES_BUNDLE_CAT = AEResInfo.LIGHT_RES_BUNDLE_CAT;
        Intrinsics.checkNotNullExpressionValue(LIGHT_RES_BUNDLE_CAT, "LIGHT_RES_BUNDLE_CAT");
        linkedHashMap.put("ai.catFace", LIGHT_RES_BUNDLE_CAT);
        AEResInfo LIGHT_RES_BUNDLE_DEPTH = AEResInfo.LIGHT_RES_BUNDLE_DEPTH;
        Intrinsics.checkNotNullExpressionValue(LIGHT_RES_BUNDLE_DEPTH, "LIGHT_RES_BUNDLE_DEPTH");
        linkedHashMap.put("ai.rgbDepth", LIGHT_RES_BUNDLE_DEPTH);
        AEResInfo LIGHT_RES_BUNDLE_SEG_HAIR = AEResInfo.LIGHT_RES_BUNDLE_SEG_HAIR;
        Intrinsics.checkNotNullExpressionValue(LIGHT_RES_BUNDLE_SEG_HAIR, "LIGHT_RES_BUNDLE_SEG_HAIR");
        linkedHashMap.put("ai.segmentHair", LIGHT_RES_BUNDLE_SEG_HAIR);
        AEResInfo LIGHT_RES_BUNDLE_SEG_SKY = AEResInfo.LIGHT_RES_BUNDLE_SEG_SKY;
        Intrinsics.checkNotNullExpressionValue(LIGHT_RES_BUNDLE_SEG_SKY, "LIGHT_RES_BUNDLE_SEG_SKY");
        linkedHashMap.put("ai.segmentSky", LIGHT_RES_BUNDLE_SEG_SKY);
        AEResInfo LIGHT_RES_BUNDLE_SEG_HEAD = AEResInfo.LIGHT_RES_BUNDLE_SEG_HEAD;
        Intrinsics.checkNotNullExpressionValue(LIGHT_RES_BUNDLE_SEG_HEAD, "LIGHT_RES_BUNDLE_SEG_HEAD");
        linkedHashMap.put("ai.headInset", LIGHT_RES_BUNDLE_SEG_HEAD);
        AEResInfo LIGHT_RES_BUNDLE_BODY = AEResInfo.LIGHT_RES_BUNDLE_BODY;
        Intrinsics.checkNotNullExpressionValue(LIGHT_RES_BUNDLE_BODY, "LIGHT_RES_BUNDLE_BODY");
        linkedHashMap.put("ai.body", LIGHT_RES_BUNDLE_BODY);
        AEResInfo LIGHT_RES_BUNDLE_EMOTION = AEResInfo.LIGHT_RES_BUNDLE_EMOTION;
        Intrinsics.checkNotNullExpressionValue(LIGHT_RES_BUNDLE_EMOTION, "LIGHT_RES_BUNDLE_EMOTION");
        linkedHashMap.put("ai.emotion", LIGHT_RES_BUNDLE_EMOTION);
        AEResInfo LIGHT_RES_BUNDLE_BODY_3D = AEResInfo.LIGHT_RES_BUNDLE_BODY_3D;
        Intrinsics.checkNotNullExpressionValue(LIGHT_RES_BUNDLE_BODY_3D, "LIGHT_RES_BUNDLE_BODY_3D");
        linkedHashMap.put("ai.body3d", LIGHT_RES_BUNDLE_BODY_3D);
        AEResInfo LIGHT_RES_BUNDLE_PIC_ENHANCE = AEResInfo.LIGHT_RES_BUNDLE_PIC_ENHANCE;
        Intrinsics.checkNotNullExpressionValue(LIGHT_RES_BUNDLE_PIC_ENHANCE, "LIGHT_RES_BUNDLE_PIC_ENHANCE");
        linkedHashMap.put(LightConstants.AssetFeatureKey.NEED_PIC_ENHANCE, LIGHT_RES_BUNDLE_PIC_ENHANCE);
        AEResInfo LIGHT_RES_BUNDLE_BG_SEG = AEResInfo.LIGHT_RES_BUNDLE_BG_SEG;
        Intrinsics.checkNotNullExpressionValue(LIGHT_RES_BUNDLE_BG_SEG, "LIGHT_RES_BUNDLE_BG_SEG");
        linkedHashMap.put("ai.segment", LIGHT_RES_BUNDLE_BG_SEG);
        AEResInfo LIGHT_RES_BUNDLE_FACE = AEResInfo.LIGHT_RES_BUNDLE_FACE;
        Intrinsics.checkNotNullExpressionValue(LIGHT_RES_BUNDLE_FACE, "LIGHT_RES_BUNDLE_FACE");
        linkedHashMap.put("ai.face", LIGHT_RES_BUNDLE_FACE);
        AEResInfo LIGHT_RES_BUNDLE_PIC_ENHANCE_REALTIME = AEResInfo.LIGHT_RES_BUNDLE_PIC_ENHANCE_REALTIME;
        Intrinsics.checkNotNullExpressionValue(LIGHT_RES_BUNDLE_PIC_ENHANCE_REALTIME, "LIGHT_RES_BUNDLE_PIC_ENHANCE_REALTIME");
        linkedHashMap.put(LightConstants.AssetFeatureKey.NEED_REALTIME_PIC_ENHANCE, LIGHT_RES_BUNDLE_PIC_ENHANCE_REALTIME);
        AEResInfo LIGHT_RES_BASE_PACKAGE = AEResInfo.LIGHT_RES_BASE_PACKAGE;
        Intrinsics.checkNotNullExpressionValue(LIGHT_RES_BASE_PACKAGE, "LIGHT_RES_BASE_PACKAGE");
        linkedHashMap.put("ai.gan", LIGHT_RES_BASE_PACKAGE);
        aiAbilityToAEResInfo = linkedHashMap;
    }

    ah() {
    }

    private final List<String> c(LightAsset lightAsset) {
        List<String> emptyList;
        if (lightAsset == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        List<String> list = needCheckAIAbilities;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (lightAsset.needRenderAbility((String) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final boolean d(LightAsset lightAsset) {
        if (lightAsset != null) {
            return lightAsset.needRenderAbility("material.sticker3d");
        }
        return false;
    }

    private final boolean g(String assetFeatureKey, Map<String, String> lightBundleMap) {
        AEResInfo aEResInfo = aiAbilityToAEResInfo.get(assetFeatureKey);
        if (aEResInfo != null) {
            if (((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(aEResInfo)) {
                ah ahVar = f326668a;
                String str = aEResInfo.agentType;
                Intrinsics.checkNotNullExpressionValue(str, "it.agentType");
                ahVar.i(str, lightBundleMap.get(aEResInfo.agentType));
                return true;
            }
            ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(aEResInfo.agentType);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(String agentType, String bundleDir) {
        boolean z16;
        if (bundleDir != null && bundleDir.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            TavLogger.e("WinkVideoTavCut", "[registerAiPath] bundleDir is null or empty!");
            return;
        }
        try {
            rd4.c.f431135f.B(agentType, bundleDir);
        } catch (IllegalStateException e16) {
            TavLogger.e("WinkVideoTavCut", "[registerAiPath] IllegalStateException:" + e16.getMessage());
        }
        TavLogger.d("WinkVideoTavCut", "[registerAiPath] agent=" + agentType + " bundleDir=" + bundleDir);
    }

    @NotNull
    public final ArrayList<String> b(@NotNull String templatePath) {
        Object obj;
        AEResInfo aEResInfo;
        Intrinsics.checkNotNullParameter(templatePath, "templatePath");
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList();
        if (!com.tencent.mobileqq.wink.l.d() && !com.tencent.mobileqq.wink.l.e()) {
            return arrayList;
        }
        LightAsset c16 = com.tencent.videocut.render.utils.b.f384205a.c(templatePath);
        arrayList2.addAll(c(c16));
        if (d(c16)) {
            arrayList.add(AEResInfo.LIGHT_RES_BUNDLE_ACE3D.agentType);
        }
        for (String str : arrayList2) {
            Iterator<T> it = needCheckAIAbilities.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual((String) obj, str)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (obj != null && (aEResInfo = aiAbilityToAEResInfo.get(str)) != null) {
                arrayList.add(aEResInfo.agentType);
            }
        }
        return arrayList;
    }

    public final void e(@NotNull AEResInfo aeResInfo) {
        Intrinsics.checkNotNullParameter(aeResInfo, "aeResInfo");
        Map<String, String> lightBundleMap = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleMap();
        if (aeResInfo.agentType.equals("k3D_MM_AGENT_V2") || aeResInfo.agentType.equals("k3D_MM_AGENT")) {
            IAEResUtil iAEResUtil = (IAEResUtil) QRoute.api(IAEResUtil.class);
            AEResInfo aEResInfo = AEResInfo.LIGHT_RES_BUNDLE_3DMM;
            if (iAEResUtil.isAEResExist(aEResInfo)) {
                String str = aeResInfo.agentType;
                Intrinsics.checkNotNullExpressionValue(str, "aeResInfo.agentType");
                i(str, lightBundleMap.get(aEResInfo.agentType));
            }
        }
        if (((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(aeResInfo)) {
            String str2 = aeResInfo.agentType;
            Intrinsics.checkNotNullExpressionValue(str2, "aeResInfo.agentType");
            i(str2, lightBundleMap.get(aeResInfo.agentType));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean f(@NotNull String templatePath) {
        boolean z16;
        Object obj;
        Intrinsics.checkNotNullParameter(templatePath, "templatePath");
        Map<String, String> lightBundleMap = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleMap();
        LightAsset c16 = com.tencent.videocut.render.utils.b.f384205a.c(templatePath);
        List<String> c17 = c(c16);
        if (d(c16)) {
            IAEResUtil iAEResUtil = (IAEResUtil) QRoute.api(IAEResUtil.class);
            AEResInfo aEResInfo = AEResInfo.LIGHT_RES_BUNDLE_ACE3D;
            if (iAEResUtil.isAEResExist(aEResInfo)) {
                String str = aEResInfo.agentType;
                Intrinsics.checkNotNullExpressionValue(str, "LIGHT_RES_BUNDLE_ACE3D.agentType");
                i(str, lightBundleMap.get(aEResInfo.agentType));
            } else {
                ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(aEResInfo.agentType);
                z16 = false;
                for (String str2 : c17) {
                    Iterator<T> it = needCheckAIAbilities.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            if (Intrinsics.areEqual((String) obj, str2)) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    if (obj != null) {
                        ah ahVar = f326668a;
                        Intrinsics.checkNotNullExpressionValue(lightBundleMap, "lightBundleMap");
                        z16 &= ahVar.g(str2, lightBundleMap);
                    }
                }
                return z16;
            }
        }
        z16 = true;
        while (r0.hasNext()) {
        }
        return z16;
    }

    public final void h(@NotNull String templatePath, @NotNull com.tencent.aelight.camera.download.api.a callback) {
        Object obj;
        Intrinsics.checkNotNullParameter(templatePath, "templatePath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ms.a.f("WinkAiBundleRegisterHelper", "registerFilamentAIPath ");
        Map<String, String> lightBundleMap = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleMap();
        LightAsset c16 = com.tencent.videocut.render.utils.b.f384205a.c(templatePath);
        List<String> c17 = c(c16);
        if (d(c16)) {
            IAEResUtil iAEResUtil = (IAEResUtil) QRoute.api(IAEResUtil.class);
            AEResInfo aEResInfo = AEResInfo.LIGHT_RES_BUNDLE_ACE3D;
            if (iAEResUtil.isAEResExist(aEResInfo)) {
                ms.a.f("WinkAiBundleRegisterHelper", "registerFilamentAIPath exists");
                String str = aEResInfo.agentType;
                Intrinsics.checkNotNullExpressionValue(str, "LIGHT_RES_BUNDLE_ACE3D.agentType");
                i(str, lightBundleMap.get(aEResInfo.agentType));
                callback.onAEDownloadFinish(aEResInfo, "", true, 0);
            } else {
                ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(aEResInfo.agentType, new a(callback));
            }
        } else {
            callback.onAEDownloadFinish(AEResInfo.LIGHT_RES_BUNDLE_ACE3D, "", true, 0);
        }
        for (String str2 : c17) {
            Iterator<T> it = needCheckAIAbilities.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual((String) obj, str2)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (obj != null) {
                ah ahVar = f326668a;
                Intrinsics.checkNotNullExpressionValue(lightBundleMap, "lightBundleMap");
                ahVar.g(str2, lightBundleMap);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J,\u0010\u000f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/wink/utils/ah$a", "Lcom/tencent/aelight/camera/download/api/a;", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "aeResInfo", "", "currentOffset", "totalLength", "", "onAEProgressUpdate", "", "localFilePath", "", "downloaded", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "onAEDownloadFinish", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements com.tencent.aelight.camera.download.api.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.aelight.camera.download.api.a f326671d;

        a(com.tencent.aelight.camera.download.api.a aVar) {
            this.f326671d = aVar;
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEDownloadFinish(@Nullable AEResInfo aeResInfo, @Nullable String localFilePath, boolean downloaded, int errorType) {
            ms.a.f("WinkAiBundleRegisterHelper", "registerFilamentAIPath onAEDownloadFinish");
            Map<String, String> lightBundleMap = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleMap();
            AEResInfo aEResInfo = AEResInfo.LIGHT_RES_BUNDLE_ACE3D;
            if (!lightBundleMap.containsKey(aEResInfo.agentType)) {
                ms.a.c("WinkAiBundleRegisterHelper", "registerFilamentAIPath onAEDownloadFinish bad path ");
            }
            ah ahVar = ah.f326668a;
            String str = aEResInfo.agentType;
            Intrinsics.checkNotNullExpressionValue(str, "LIGHT_RES_BUNDLE_ACE3D.agentType");
            ahVar.i(str, lightBundleMap.get(aEResInfo.agentType));
            this.f326671d.onAEDownloadFinish(aeResInfo, localFilePath, downloaded, errorType);
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEProgressUpdate(@Nullable AEResInfo aeResInfo, long currentOffset, long totalLength) {
        }
    }
}
