package com.tencent.tavcut.core.render.builder.light.model;

import androidx.fragment.app.a;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.tavcut.core.render.builder.light.model.properties.Properties;
import com.tencent.tavcut.core.render.builder.light.model.type.VoiceEnum;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.WatermarkConfig;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.Size;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bK\b\u0086\b\u0018\u0000 n2\u00020\u0001:\u0001nB\u00f1\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\t\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0013\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010!\u001a\u00020\u0011\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u00a2\u0006\u0002\u0010%J\t\u0010V\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\tH\u00c6\u0003J\u000f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00190\u000eH\u00c6\u0003J\t\u0010Y\u001a\u00020\u001bH\u00c6\u0003J\t\u0010Z\u001a\u00020\u0013H\u00c6\u0003J\u0011\u0010[\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000eH\u00c6\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010 H\u00c6\u0003J\t\u0010]\u001a\u00020\u0011H\u00c6\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010$H\u00c6\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0015\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J\t\u0010c\u001a\u00020\fH\u00c6\u0003J\u000f\u0010d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u00c6\u0003J\t\u0010e\u001a\u00020\u0011H\u00c6\u0003J\t\u0010f\u001a\u00020\u0013H\u00c6\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0015H\u00c6\u0003J\u00f5\u0001\u0010h\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\t2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00132\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\u00112\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u00c6\u0001J\u0013\u0010i\u001a\u00020\u00112\b\u0010j\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010k\u001a\u00020\u001bJ\t\u0010l\u001a\u00020\u0013H\u00d6\u0001J\t\u0010m\u001a\u00020\u0007H\u00d6\u0001R\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\t\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010'R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0011\u0010\u001c\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010!\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010'R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0011\u0010\u001a\u001a\u00020\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u00103\"\u0004\b>\u00105R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u0010-R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u00108\"\u0004\bO\u0010:R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u0010)R\u0019\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bQ\u0010)R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010U\u00a8\u0006o"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "", "renderScene", "Lcom/tencent/tavcut/core/render/builder/light/model/RenderScene;", "root", "Lorg/light/lightAssetKit/Entity;", "jsonData", "", "inputSources", "", "Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "painting", "Lcom/tencent/tavcut/core/render/builder/light/model/Painting;", "clipsAssets", "", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "modifyClipsDuration", "", "seekTolerance", "", Constants.Service.PROPERTIES, "Lcom/tencent/tavcut/core/render/builder/light/model/properties/Properties;", "audioAssets", "Lcom/tencent/tavcut/core/render/builder/light/model/AudioSource;", "timeLines", "Lcom/tencent/tavcut/core/render/builder/light/model/Timeline;", "maxDuration", "", "componentLevel", "voiceChangerConfig", "Lcom/tencent/tavcut/core/render/builder/light/model/type/VoiceEnum;", "customRenderConfig", "Lcom/tencent/tavcut/core/render/builder/light/model/CustomRenderConfig;", "exportMode", "stickerValue", "watermarkConfig", "Lorg/light/WatermarkConfig;", "(Lcom/tencent/tavcut/core/render/builder/light/model/RenderScene;Lorg/light/lightAssetKit/Entity;Ljava/lang/String;Ljava/util/Map;Lcom/tencent/tavcut/core/render/builder/light/model/Painting;Ljava/util/List;ZILcom/tencent/tavcut/core/render/builder/light/model/properties/Properties;Ljava/util/Map;Ljava/util/List;JILjava/util/List;Lcom/tencent/tavcut/core/render/builder/light/model/CustomRenderConfig;ZLjava/lang/String;Lorg/light/WatermarkConfig;)V", "getAudioAssets", "()Ljava/util/Map;", "getClipsAssets", "()Ljava/util/List;", "setClipsAssets", "(Ljava/util/List;)V", "getComponentLevel", "()I", "getCustomRenderConfig", "()Lcom/tencent/tavcut/core/render/builder/light/model/CustomRenderConfig;", "setCustomRenderConfig", "(Lcom/tencent/tavcut/core/render/builder/light/model/CustomRenderConfig;)V", "getExportMode", "()Z", "setExportMode", "(Z)V", "getInputSources", "getJsonData", "()Ljava/lang/String;", "setJsonData", "(Ljava/lang/String;)V", "getMaxDuration", "()J", "getModifyClipsDuration", "setModifyClipsDuration", "getPainting", "()Lcom/tencent/tavcut/core/render/builder/light/model/Painting;", "setPainting", "(Lcom/tencent/tavcut/core/render/builder/light/model/Painting;)V", "getProperties", "()Lcom/tencent/tavcut/core/render/builder/light/model/properties/Properties;", "setProperties", "(Lcom/tencent/tavcut/core/render/builder/light/model/properties/Properties;)V", "getRenderScene", "()Lcom/tencent/tavcut/core/render/builder/light/model/RenderScene;", "getRoot", "()Lorg/light/lightAssetKit/Entity;", "setRoot", "(Lorg/light/lightAssetKit/Entity;)V", "getSeekTolerance", "getStickerValue", "setStickerValue", "getTimeLines", "getVoiceChangerConfig", "getWatermarkConfig", "()Lorg/light/WatermarkConfig;", "setWatermarkConfig", "(Lorg/light/WatermarkConfig;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getDurationMs", "hashCode", "toString", "Companion", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class LAKRenderModel {
    public static final int CAMERA_COMPONENT_LEVEL = 3;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DEFAULT_BG_COLOR = "#00000000";
    private static final Painting DEFAULT_PAINTING;

    @NotNull
    private static final Size DEFAULT_SIZE;
    public static final int DEFAULT_TEMPLATE_HEIGHT = 1280;
    public static final int DEFAULT_TEMPLATE_WIDTH = 720;
    public static final long DURATION_UNLIMITED = -1;

    @NotNull
    private final Map<String, AudioSource> audioAssets;

    @NotNull
    private List<ClipSource> clipsAssets;
    private final int componentLevel;

    @Nullable
    private CustomRenderConfig customRenderConfig;
    private boolean exportMode;

    @NotNull
    private final Map<String, InputSource> inputSources;

    @Nullable
    private String jsonData;
    private final long maxDuration;
    private boolean modifyClipsDuration;

    @NotNull
    private Painting painting;

    @Nullable
    private Properties properties;

    @NotNull
    private final RenderScene renderScene;

    @Nullable
    private Entity root;
    private final int seekTolerance;

    @Nullable
    private String stickerValue;

    @NotNull
    private final List<Timeline> timeLines;

    @Nullable
    private final List<VoiceEnum> voiceChangerConfig;

    @Nullable
    private WatermarkConfig watermarkConfig;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel$Companion;", "", "()V", "CAMERA_COMPONENT_LEVEL", "", "DEFAULT_BG_COLOR", "", "DEFAULT_PAINTING", "Lcom/tencent/tavcut/core/render/builder/light/model/Painting;", "DEFAULT_SIZE", "Lorg/light/lightAssetKit/components/Size;", "getDEFAULT_SIZE", "()Lorg/light/lightAssetKit/components/Size;", "DEFAULT_TEMPLATE_HEIGHT", "DEFAULT_TEMPLATE_WIDTH", "DURATION_UNLIMITED", "", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final Size getDEFAULT_SIZE() {
            return LAKRenderModel.DEFAULT_SIZE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Size size = new Size(720, 1280);
        DEFAULT_SIZE = size;
        DEFAULT_PAINTING = new Painting(null, DEFAULT_BG_COLOR, size, null, null, 24, null);
    }

    public LAKRenderModel() {
        this(null, null, null, null, null, null, false, 0, null, null, null, 0L, 0, null, null, false, null, null, 262143, null);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final RenderScene getRenderScene() {
        return this.renderScene;
    }

    @NotNull
    public final Map<String, AudioSource> component10() {
        return this.audioAssets;
    }

    @NotNull
    public final List<Timeline> component11() {
        return this.timeLines;
    }

    /* renamed from: component12, reason: from getter */
    public final long getMaxDuration() {
        return this.maxDuration;
    }

    /* renamed from: component13, reason: from getter */
    public final int getComponentLevel() {
        return this.componentLevel;
    }

    @Nullable
    public final List<VoiceEnum> component14() {
        return this.voiceChangerConfig;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final CustomRenderConfig getCustomRenderConfig() {
        return this.customRenderConfig;
    }

    /* renamed from: component16, reason: from getter */
    public final boolean getExportMode() {
        return this.exportMode;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final String getStickerValue() {
        return this.stickerValue;
    }

    @Nullable
    /* renamed from: component18, reason: from getter */
    public final WatermarkConfig getWatermarkConfig() {
        return this.watermarkConfig;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Entity getRoot() {
        return this.root;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getJsonData() {
        return this.jsonData;
    }

    @NotNull
    public final Map<String, InputSource> component4() {
        return this.inputSources;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final Painting getPainting() {
        return this.painting;
    }

    @NotNull
    public final List<ClipSource> component6() {
        return this.clipsAssets;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getModifyClipsDuration() {
        return this.modifyClipsDuration;
    }

    /* renamed from: component8, reason: from getter */
    public final int getSeekTolerance() {
        return this.seekTolerance;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Properties getProperties() {
        return this.properties;
    }

    @NotNull
    public final LAKRenderModel copy(@NotNull RenderScene renderScene, @Nullable Entity root, @Nullable String jsonData, @NotNull Map<String, InputSource> inputSources, @NotNull Painting painting, @NotNull List<ClipSource> clipsAssets, boolean modifyClipsDuration, int seekTolerance, @Nullable Properties properties, @NotNull Map<String, AudioSource> audioAssets, @NotNull List<Timeline> timeLines, long maxDuration, int componentLevel, @Nullable List<? extends VoiceEnum> voiceChangerConfig, @Nullable CustomRenderConfig customRenderConfig, boolean exportMode, @Nullable String stickerValue, @Nullable WatermarkConfig watermarkConfig) {
        Intrinsics.checkParameterIsNotNull(renderScene, "renderScene");
        Intrinsics.checkParameterIsNotNull(inputSources, "inputSources");
        Intrinsics.checkParameterIsNotNull(painting, "painting");
        Intrinsics.checkParameterIsNotNull(clipsAssets, "clipsAssets");
        Intrinsics.checkParameterIsNotNull(audioAssets, "audioAssets");
        Intrinsics.checkParameterIsNotNull(timeLines, "timeLines");
        return new LAKRenderModel(renderScene, root, jsonData, inputSources, painting, clipsAssets, modifyClipsDuration, seekTolerance, properties, audioAssets, timeLines, maxDuration, componentLevel, voiceChangerConfig, customRenderConfig, exportMode, stickerValue, watermarkConfig);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof LAKRenderModel) {
                LAKRenderModel lAKRenderModel = (LAKRenderModel) other;
                if (!Intrinsics.areEqual(this.renderScene, lAKRenderModel.renderScene) || !Intrinsics.areEqual(this.root, lAKRenderModel.root) || !Intrinsics.areEqual(this.jsonData, lAKRenderModel.jsonData) || !Intrinsics.areEqual(this.inputSources, lAKRenderModel.inputSources) || !Intrinsics.areEqual(this.painting, lAKRenderModel.painting) || !Intrinsics.areEqual(this.clipsAssets, lAKRenderModel.clipsAssets) || this.modifyClipsDuration != lAKRenderModel.modifyClipsDuration || this.seekTolerance != lAKRenderModel.seekTolerance || !Intrinsics.areEqual(this.properties, lAKRenderModel.properties) || !Intrinsics.areEqual(this.audioAssets, lAKRenderModel.audioAssets) || !Intrinsics.areEqual(this.timeLines, lAKRenderModel.timeLines) || this.maxDuration != lAKRenderModel.maxDuration || this.componentLevel != lAKRenderModel.componentLevel || !Intrinsics.areEqual(this.voiceChangerConfig, lAKRenderModel.voiceChangerConfig) || !Intrinsics.areEqual(this.customRenderConfig, lAKRenderModel.customRenderConfig) || this.exportMode != lAKRenderModel.exportMode || !Intrinsics.areEqual(this.stickerValue, lAKRenderModel.stickerValue) || !Intrinsics.areEqual(this.watermarkConfig, lAKRenderModel.watermarkConfig)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final Map<String, AudioSource> getAudioAssets() {
        return this.audioAssets;
    }

    @NotNull
    public final List<ClipSource> getClipsAssets() {
        return this.clipsAssets;
    }

    public final int getComponentLevel() {
        return this.componentLevel;
    }

    @Nullable
    public final CustomRenderConfig getCustomRenderConfig() {
        return this.customRenderConfig;
    }

    public final long getDurationMs() {
        return 0L;
    }

    public final boolean getExportMode() {
        return this.exportMode;
    }

    @NotNull
    public final Map<String, InputSource> getInputSources() {
        return this.inputSources;
    }

    @Nullable
    public final String getJsonData() {
        return this.jsonData;
    }

    public final long getMaxDuration() {
        return this.maxDuration;
    }

    public final boolean getModifyClipsDuration() {
        return this.modifyClipsDuration;
    }

    @NotNull
    public final Painting getPainting() {
        return this.painting;
    }

    @Nullable
    public final Properties getProperties() {
        return this.properties;
    }

    @NotNull
    public final RenderScene getRenderScene() {
        return this.renderScene;
    }

    @Nullable
    public final Entity getRoot() {
        return this.root;
    }

    public final int getSeekTolerance() {
        return this.seekTolerance;
    }

    @Nullable
    public final String getStickerValue() {
        return this.stickerValue;
    }

    @NotNull
    public final List<Timeline> getTimeLines() {
        return this.timeLines;
    }

    @Nullable
    public final List<VoiceEnum> getVoiceChangerConfig() {
        return this.voiceChangerConfig;
    }

    @Nullable
    public final WatermarkConfig getWatermarkConfig() {
        return this.watermarkConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        RenderScene renderScene = this.renderScene;
        int i39 = 0;
        if (renderScene != null) {
            i3 = renderScene.hashCode();
        } else {
            i3 = 0;
        }
        int i46 = i3 * 31;
        Entity entity = this.root;
        if (entity != null) {
            i16 = entity.hashCode();
        } else {
            i16 = 0;
        }
        int i47 = (i46 + i16) * 31;
        String str = this.jsonData;
        if (str != null) {
            i17 = str.hashCode();
        } else {
            i17 = 0;
        }
        int i48 = (i47 + i17) * 31;
        Map<String, InputSource> map = this.inputSources;
        if (map != null) {
            i18 = map.hashCode();
        } else {
            i18 = 0;
        }
        int i49 = (i48 + i18) * 31;
        Painting painting = this.painting;
        if (painting != null) {
            i19 = painting.hashCode();
        } else {
            i19 = 0;
        }
        int i56 = (i49 + i19) * 31;
        List<ClipSource> list = this.clipsAssets;
        if (list != null) {
            i26 = list.hashCode();
        } else {
            i26 = 0;
        }
        int i57 = (i56 + i26) * 31;
        boolean z16 = this.modifyClipsDuration;
        int i58 = 1;
        int i59 = z16;
        if (z16 != 0) {
            i59 = 1;
        }
        int i65 = (((i57 + i59) * 31) + this.seekTolerance) * 31;
        Properties properties = this.properties;
        if (properties != null) {
            i27 = properties.hashCode();
        } else {
            i27 = 0;
        }
        int i66 = (i65 + i27) * 31;
        Map<String, AudioSource> map2 = this.audioAssets;
        if (map2 != null) {
            i28 = map2.hashCode();
        } else {
            i28 = 0;
        }
        int i67 = (i66 + i28) * 31;
        List<Timeline> list2 = this.timeLines;
        if (list2 != null) {
            i29 = list2.hashCode();
        } else {
            i29 = 0;
        }
        int a16 = (((((i67 + i29) * 31) + a.a(this.maxDuration)) * 31) + this.componentLevel) * 31;
        List<VoiceEnum> list3 = this.voiceChangerConfig;
        if (list3 != null) {
            i36 = list3.hashCode();
        } else {
            i36 = 0;
        }
        int i68 = (a16 + i36) * 31;
        CustomRenderConfig customRenderConfig = this.customRenderConfig;
        if (customRenderConfig != null) {
            i37 = customRenderConfig.hashCode();
        } else {
            i37 = 0;
        }
        int i69 = (i68 + i37) * 31;
        boolean z17 = this.exportMode;
        if (!z17) {
            i58 = z17 ? 1 : 0;
        }
        int i75 = (i69 + i58) * 31;
        String str2 = this.stickerValue;
        if (str2 != null) {
            i38 = str2.hashCode();
        } else {
            i38 = 0;
        }
        int i76 = (i75 + i38) * 31;
        WatermarkConfig watermarkConfig = this.watermarkConfig;
        if (watermarkConfig != null) {
            i39 = watermarkConfig.hashCode();
        }
        return i76 + i39;
    }

    public final void setClipsAssets(@NotNull List<ClipSource> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.clipsAssets = list;
    }

    public final void setCustomRenderConfig(@Nullable CustomRenderConfig customRenderConfig) {
        this.customRenderConfig = customRenderConfig;
    }

    public final void setExportMode(boolean z16) {
        this.exportMode = z16;
    }

    public final void setJsonData(@Nullable String str) {
        this.jsonData = str;
    }

    public final void setModifyClipsDuration(boolean z16) {
        this.modifyClipsDuration = z16;
    }

    public final void setPainting(@NotNull Painting painting) {
        Intrinsics.checkParameterIsNotNull(painting, "<set-?>");
        this.painting = painting;
    }

    public final void setProperties(@Nullable Properties properties) {
        this.properties = properties;
    }

    public final void setRoot(@Nullable Entity entity) {
        this.root = entity;
    }

    public final void setStickerValue(@Nullable String str) {
        this.stickerValue = str;
    }

    public final void setWatermarkConfig(@Nullable WatermarkConfig watermarkConfig) {
        this.watermarkConfig = watermarkConfig;
    }

    @NotNull
    public String toString() {
        return "LAKRenderModel(renderScene=" + this.renderScene + ", root=" + this.root + ", jsonData=" + this.jsonData + ", inputSources=" + this.inputSources + ", painting=" + this.painting + ", clipsAssets=" + this.clipsAssets + ", modifyClipsDuration=" + this.modifyClipsDuration + ", seekTolerance=" + this.seekTolerance + ", properties=" + this.properties + ", audioAssets=" + this.audioAssets + ", timeLines=" + this.timeLines + ", maxDuration=" + this.maxDuration + ", componentLevel=" + this.componentLevel + ", voiceChangerConfig=" + this.voiceChangerConfig + ", customRenderConfig=" + this.customRenderConfig + ", exportMode=" + this.exportMode + ", stickerValue=" + this.stickerValue + ", watermarkConfig=" + this.watermarkConfig + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LAKRenderModel(@NotNull RenderScene renderScene, @Nullable Entity entity, @Nullable String str, @NotNull Map<String, InputSource> inputSources, @NotNull Painting painting, @NotNull List<ClipSource> clipsAssets, boolean z16, int i3, @Nullable Properties properties, @NotNull Map<String, AudioSource> audioAssets, @NotNull List<Timeline> timeLines, long j3, int i16, @Nullable List<? extends VoiceEnum> list, @Nullable CustomRenderConfig customRenderConfig, boolean z17, @Nullable String str2, @Nullable WatermarkConfig watermarkConfig) {
        Intrinsics.checkParameterIsNotNull(renderScene, "renderScene");
        Intrinsics.checkParameterIsNotNull(inputSources, "inputSources");
        Intrinsics.checkParameterIsNotNull(painting, "painting");
        Intrinsics.checkParameterIsNotNull(clipsAssets, "clipsAssets");
        Intrinsics.checkParameterIsNotNull(audioAssets, "audioAssets");
        Intrinsics.checkParameterIsNotNull(timeLines, "timeLines");
        this.renderScene = renderScene;
        this.root = entity;
        this.jsonData = str;
        this.inputSources = inputSources;
        this.painting = painting;
        this.clipsAssets = clipsAssets;
        this.modifyClipsDuration = z16;
        this.seekTolerance = i3;
        this.properties = properties;
        this.audioAssets = audioAssets;
        this.timeLines = timeLines;
        this.maxDuration = j3;
        this.componentLevel = i16;
        this.voiceChangerConfig = list;
        this.customRenderConfig = customRenderConfig;
        this.exportMode = z17;
        this.stickerValue = str2;
        this.watermarkConfig = watermarkConfig;
    }

    public /* synthetic */ LAKRenderModel(RenderScene renderScene, Entity entity, String str, Map map, Painting painting, List list, boolean z16, int i3, Properties properties, Map map2, List list2, long j3, int i16, List list3, CustomRenderConfig customRenderConfig, boolean z17, String str2, WatermarkConfig watermarkConfig, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? RenderScene.PLAY : renderScene, (i17 & 2) != 0 ? null : entity, (i17 & 4) != 0 ? null : str, (i17 & 8) != 0 ? MapsKt__MapsKt.emptyMap() : map, (i17 & 16) != 0 ? DEFAULT_PAINTING : painting, (i17 & 32) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i17 & 64) != 0 ? true : z16, (i17 & 128) != 0 ? 0 : i3, (i17 & 256) != 0 ? null : properties, (i17 & 512) != 0 ? MapsKt__MapsKt.emptyMap() : map2, (i17 & 1024) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i17 & 2048) != 0 ? -1L : j3, (i17 & 4096) != 0 ? 3 : i16, (i17 & 8192) != 0 ? null : list3, (i17 & 16384) != 0 ? null : customRenderConfig, (i17 & 32768) != 0 ? false : z17, (i17 & 65536) != 0 ? null : str2, (i17 & 131072) != 0 ? null : watermarkConfig);
    }
}
