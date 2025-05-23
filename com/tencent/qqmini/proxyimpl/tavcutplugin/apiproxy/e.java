package com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy;

import android.graphics.PointF;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.composition.model.component.AudioSource;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.PAGAsset;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.model.LightAssetModel;
import com.tencent.tavcut.model.PagEffectData;
import com.tencent.tavcut.model.TextLayerData;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.session.a;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.light.LightAsset;
import xd4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 +2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\bK\u0010LJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\t\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J(\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J,\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001e0#2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0002J*\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020 0%2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010!\u001a\u00020 H\u0002J\u0016\u0010(\u001a\u00020\u00042\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001dJ\u0010\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u0002J4\u00101\u001a\u0002002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\b\u0010-\u001a\u0004\u0018\u00010\f2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u001dJ\u0006\u00102\u001a\u00020 J\u0014\u00103\u001a\u0002002\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ.\u00106\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u00105\u001a\u0002042\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u00107\u001a\u00020\u0004J\u0006\u00108\u001a\u00020\u0004J\u000e\u00109\u001a\u00020\u00042\u0006\u00105\u001a\u000204J\u000e\u0010<\u001a\u00020\u00042\u0006\u0010;\u001a\u00020:R\"\u0010C\u001a\u00020=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010J\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I\u00a8\u0006M"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/e;", "", "", "templatePath", "", "o", "", "lightBundleMap", "agentType", "u", "bundleDir", "p", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/m;", "tavMusic", "a", "userName", "filePath", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement;", "l", "", tl.h.F, "Lxd4/e;", "componentCreator", "", "scale", "Landroid/graphics/PointF;", "pointF", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "i", "", "Lcom/tencent/tavcut/model/ClipSource;", "originalClipResourceList", "", "startTime", "duration", "Ljava/util/ArrayList;", "k", "Lkotlin/Pair;", "j", "bundleList", "d", "Lcom/tencent/tavcut/model/LightAssetModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "clipSourceList", "music", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/k;", "fontList", "", "r", "g", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/tav/coremedia/CMTimeRange;", "timeRange", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "e", "t", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/o;", "player", DomainData.DOMAIN_NAME, "Lcom/tencent/tavcut/session/a;", "Lcom/tencent/tavcut/session/a;", "f", "()Lcom/tencent/tavcut/session/a;", "setCutSession", "(Lcom/tencent/tavcut/session/a;)V", "cutSession", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "getStickerEntity", "()Lcom/tencent/tavcut/rendermodel/entity/Entity;", "setStickerEntity", "(Lcom/tencent/tavcut/rendermodel/entity/Entity;)V", "stickerEntity", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private com.tencent.tavcut.session.a cutSession = od4.b.f422509e.h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Entity stickerEntity;

    private final void a(TavMusic tavMusic) {
        ee4.b.a("WS_TavCutSession", "[addMusic] tavMusic=" + tavMusic);
        od4.b bVar = od4.b.f422509e;
        xd4.e n3 = bVar.n();
        xd4.f p16 = bVar.p();
        InputSource f16 = bVar.q().f(tavMusic.getMusicPath(), new TimeRange(0L, this.cutSession.getTotalDurationUs(), null, 4, null), tavMusic.getMusicId());
        this.cutSession.j(f16);
        ArrayList arrayList = new ArrayList();
        String str = f16.key;
        if (str == null) {
            str = "";
        }
        AudioSource c16 = n3.c(str, 1.0f, 1.0f);
        arrayList.add(new IdentifyComponent(n3.m()));
        arrayList.add(new IdentifyComponent(c16));
        this.cutSession.o(p16.a(JsonUtils.KEY_BGM, arrayList));
    }

    private final int h(String filePath) {
        List<TextLayerData> list;
        PagEffectData z16 = od4.b.f422509e.z(filePath);
        if (z16 != null && (list = z16.textLayerList) != null) {
            int i3 = 0;
            for (Object obj : list) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if (Intrinsics.areEqual(((TextLayerData) obj).layerName, "userName")) {
                    return i3;
                }
                i3 = i16;
            }
        }
        return 0;
    }

    private final Pair<Integer, Long> j(List<ClipSource> originalClipResourceList, long startTime) {
        long j3 = 0;
        int i3 = 0;
        for (Object obj : originalClipResourceList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            long j16 = ((ClipSource) obj).duration;
            if (j3 + j16 >= startTime) {
                return new Pair<>(Integer.valueOf(i3), Long.valueOf(startTime - j3));
            }
            j3 += j16;
            i3 = i16;
        }
        return new Pair<>(0, 0L);
    }

    private final PAGAsset.Replacement l(String userName, String filePath) {
        return new PAGAsset.Replacement(Integer.valueOf(h(filePath)), userName, 1, null, null, null, null, null, null, 504, null);
    }

    private final void o(String templatePath) {
        Map<String, String> lightBundleMap = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleMap();
        QLog.i("WS_TavCutSession", 1, "registerAiPath---" + lightBundleMap);
        if (lightBundleMap == null || lightBundleMap.isEmpty()) {
            return;
        }
        LightAsset lightAsset = VideoMaterial.loadLightAsset(templatePath).getLightAsset();
        String[] renderAgentTypes = lightAsset != null ? lightAsset.getRenderAgentTypes() : null;
        QLog.i("WS_TavCutSession", 1, "registerAiPath---material need abilities=" + Arrays.toString(renderAgentTypes));
        if (renderAgentTypes != null) {
            for (String it : renderAgentTypes) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                u(lightBundleMap, it);
            }
        }
    }

    private final void u(Map<String, String> lightBundleMap, String agentType) {
        String str = lightBundleMap.get(agentType);
        if (str == null || str.length() == 0) {
            return;
        }
        p(agentType, lightBundleMap.get(agentType));
    }

    public final List<String> c(String templatePath) {
        Intrinsics.checkNotNullParameter(templatePath, "templatePath");
        VideoMaterial loadLightAsset = VideoMaterial.loadLightAsset(templatePath);
        ee4.b.a("WS_TavCutSession", "[checkLightTemplateBundleStatus] videoMaterial=" + loadLightAsset + "}");
        List<String> bundleList = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getNeedDownloadList(loadLightAsset);
        ee4.b.a("WS_TavCutSession", "[checkLightTemplateBundleStatus] ");
        Intrinsics.checkNotNullExpressionValue(bundleList, "bundleList");
        return bundleList;
    }

    public final void e() {
        this.cutSession.flush();
    }

    /* renamed from: f, reason: from getter */
    public final com.tencent.tavcut.session.a getCutSession() {
        return this.cutSession;
    }

    public final long g() {
        return this.cutSession.getTotalDurationUs();
    }

    public final LightAssetModel m(String templatePath) {
        Intrinsics.checkNotNullParameter(templatePath, "templatePath");
        return od4.b.f422509e.w(templatePath);
    }

    public final void n(o player) {
        Intrinsics.checkNotNullParameter(player, "player");
        RenderModel renderModel = this.cutSession.getRenderModel();
        if (renderModel != null) {
            com.tencent.tavcut.session.a h16 = od4.b.f422509e.h();
            this.cutSession = h16;
            h16.g(renderModel);
            player.p(this.cutSession, false);
        }
    }

    public final void q() {
        Entity entity = this.stickerEntity;
        if (entity == null) {
            return;
        }
        this.cutSession.a(entity.getId());
        this.stickerEntity = null;
    }

    public final boolean s(List<ClipSource> clipSourceList) {
        Intrinsics.checkNotNullParameter(clipSourceList, "clipSourceList");
        RenderModel x16 = od4.b.f422509e.x(null);
        if (x16 == null) {
            return false;
        }
        this.cutSession.g(x16);
        this.cutSession.getClipSourceOperator().g(clipSourceList);
        return true;
    }

    private final ArrayList<ClipSource> k(List<ClipSource> originalClipResourceList, long startTime, long duration) {
        ArrayList<ClipSource> arrayList = new ArrayList<>();
        Pair<Integer, Long> j3 = j(originalClipResourceList, startTime);
        int intValue = j3.getFirst().intValue();
        long longValue = j3.getSecond().longValue();
        ee4.b.a("WS_TavCutSession", "[getTargetClipSourceList] startIndex=" + intValue + " startOffset=" + longValue);
        long j16 = 0;
        int i3 = 0;
        for (Object obj : originalClipResourceList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ClipSource clipSource = (ClipSource) obj;
            if (i3 == intValue) {
                long j17 = clipSource.duration - longValue;
                Long l3 = clipSource.startOffset;
                ClipSource copy$default = ClipSource.copy$default(clipSource, null, null, null, Math.min(duration, j17), null, null, l3 != null ? Long.valueOf(l3.longValue() + longValue) : null, null, null, null, null, null, InnerShareData.SUB_SCENE_ARK_INVITE_API, null);
                j16 += copy$default.duration;
                arrayList.add(copy$default);
            } else if (i3 > intValue && j16 < duration) {
                long j18 = clipSource.duration;
                if (j16 + j18 < duration) {
                    j16 += j18;
                    arrayList.add(ClipSource.copy$default(clipSource, null, null, null, 0L, null, null, null, null, null, null, null, null, 4095, null));
                } else {
                    arrayList.add(ClipSource.copy$default(clipSource, null, null, null, duration - j16, null, null, null, null, null, null, null, null, 4087, null));
                }
            }
            i3 = i16;
        }
        return arrayList;
    }

    private final void p(String agentType, String bundleDir) {
        if (bundleDir == null || bundleDir.length() == 0) {
            ee4.b.b("WS_TavCutSession", "[registerAiPath] aiAbility is null or empty!");
            return;
        }
        od4.b.f422509e.A(agentType, bundleDir);
        ee4.b.a("WS_TavCutSession", "[registerAiPath] agent=" + agentType + " bundleDir=" + bundleDir);
    }

    public final void d(List<String> bundleList) {
        if (bundleList == null || bundleList.isEmpty()) {
            return;
        }
        ee4.b.a("WS_TavCutSession", "start download light resource abilities");
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSpecificBundles(bundleList);
        ee4.b.a("WS_TavCutSession", "finish download light resource abilities");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0088, code lost:
    
        r0 = r8.copy((r32 & 1) != 0 ? r8.renderScene : null, (r32 & 2) != 0 ? r8.root : null, (r32 & 4) != 0 ? r8.inputSources : null, (r32 & 8) != 0 ? r8.painting : null, (r32 & 16) != 0 ? r8.clipsAssets : r13, (r32 & 32) != 0 ? r8.modifyClipsDuration : false, (r32 & 64) != 0 ? r8.seekTolerance : 0, (r32 & 128) != 0 ? r8.properties : null, (r32 & 256) != 0 ? r8.audioAssets : null, (r32 & 512) != 0 ? r8.timeLines : null, (r32 & 1024) != 0 ? r8.maxDuration : 0, (r32 & 2048) != 0 ? r8.componentLevel : 0, (r32 & 4096) != 0 ? r8.voiceChangerConfig : null, (r32 & 8192) != 0 ? r8.customRenderConfig : null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t(CMTimeRange timeRange) {
        RenderModel copy;
        Intrinsics.checkNotNullParameter(timeRange, "timeRange");
        long timeUs = timeRange.getStart().getTimeUs();
        long timeUs2 = timeRange.getDuration().getTimeUs();
        RenderModel renderModel = this.cutSession.getRenderModel();
        List<ClipSource> clipsAssets = renderModel != null ? renderModel.getClipsAssets() : null;
        ee4.b.a("WS_TavCutSession", "[setTimeRange] startTime=" + timeUs + " duration=" + timeUs2 + " originalClipResourceList=" + clipsAssets);
        List<ClipSource> list = clipsAssets;
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList<ClipSource> k3 = k(clipsAssets, timeUs, timeUs2);
        ee4.b.a("WS_TavCutSession", "[setTimeRange] targetClipResourceList=" + k3);
        RenderModel renderModel2 = this.cutSession.getRenderModel();
        if (renderModel2 == null || copy == null) {
            return;
        }
        this.cutSession.g(copy);
    }

    private final ScreenTransform i(xd4.e componentCreator, double scale, PointF pointF, String filePath) {
        float f16 = 2;
        float f17 = f16 * ((float) (pointF.x - 0.5d));
        float f18 = f16 * ((float) (0.5d - pointF.y));
        if (od4.b.f422509e.z(filePath) == null) {
            return componentCreator.m();
        }
        return componentCreator.r(f17, f18, r0.width, r0.height, (float) scale, 0.0f);
    }

    public final void b(String filePath, CMTimeRange timeRange, String userName, double scale, PointF pointF) {
        List<PAGAsset.Replacement> listOf;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(timeRange, "timeRange");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(pointF, "pointF");
        if (this.stickerEntity != null) {
            return;
        }
        od4.b bVar = od4.b.f422509e;
        xd4.e n3 = bVar.n();
        xd4.f p16 = bVar.p();
        InputSource b16 = g.a.b(bVar.q(), filePath, null, 2, null);
        String str = b16.key;
        if (str == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new IdentifyComponent(i(n3, scale, pointF, filePath)));
        listOf = CollectionsKt__CollectionsJVMKt.listOf(l(userName, filePath));
        arrayList.add(new IdentifyComponent(n3.p(str, 0, listOf, PAGAsset.PagScaleMode.LETTERBOX)));
        arrayList.add(new IdentifyComponent(n3.e(timeRange.getStart().getTimeUs(), timeRange.getDuration().getTimeUs())));
        arrayList.add(new IdentifyComponent(n3.a("STICKER")));
        this.cutSession.j(b16);
        this.stickerEntity = a.C9882a.a(this.cutSession, p16.a("STICKER", arrayList), 0, 2, null);
    }

    public final boolean r(String templatePath, List<ClipSource> clipSourceList, TavMusic music, List<TavFont> fontList) {
        RenderModel renderModel;
        LightAssetModel.MaterialConfig materialConfig;
        List<ClipSource> clipSourceList2 = clipSourceList;
        Intrinsics.checkNotNullParameter(templatePath, "templatePath");
        Intrinsics.checkNotNullParameter(clipSourceList2, "clipSourceList");
        Intrinsics.checkNotNullParameter(fontList, "fontList");
        ee4.b.a("WS_TavCutSession", "[setLightTemplate] apply template");
        o(templatePath);
        od4.b bVar = od4.b.f422509e;
        LightAssetModel w3 = bVar.w(templatePath);
        int i3 = (w3 == null || (materialConfig = w3.materialConfig) == null) ? 0 : materialConfig.maxAssetCount;
        if (clipSourceList.size() > i3) {
            clipSourceList2 = clipSourceList2.subList(0, i3);
        }
        RenderModel x16 = bVar.x(templatePath);
        if (x16 != null) {
            renderModel = x16.copy((r32 & 1) != 0 ? x16.renderScene : null, (r32 & 2) != 0 ? x16.root : null, (r32 & 4) != 0 ? x16.inputSources : null, (r32 & 8) != 0 ? x16.painting : null, (r32 & 16) != 0 ? x16.clipsAssets : clipSourceList2, (r32 & 32) != 0 ? x16.modifyClipsDuration : false, (r32 & 64) != 0 ? x16.seekTolerance : 0, (r32 & 128) != 0 ? x16.properties : null, (r32 & 256) != 0 ? x16.audioAssets : null, (r32 & 512) != 0 ? x16.timeLines : null, (r32 & 1024) != 0 ? x16.maxDuration : 0L, (r32 & 2048) != 0 ? x16.componentLevel : 0, (r32 & 4096) != 0 ? x16.voiceChangerConfig : null, (r32 & 8192) != 0 ? x16.customRenderConfig : null);
        } else {
            renderModel = null;
        }
        RenderModel j3 = bVar.j(renderModel, clipSourceList2);
        if (j3 == null) {
            return false;
        }
        this.cutSession.g(j3);
        this.cutSession.getClipSourceOperator().g(j3.getClipsAssets());
        ee4.b.a("WS_TavCutSession", "fontList=" + fontList);
        for (TavFont tavFont : fontList) {
            this.cutSession.registerFont(tavFont.getFontFamily(), tavFont.getFontStyle(), tavFont.getFontPath());
        }
        if (music == null) {
            return true;
        }
        a(music);
        return true;
    }
}
