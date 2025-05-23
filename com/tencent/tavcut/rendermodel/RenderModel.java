package com.tencent.tavcut.rendermodel;

import androidx.fragment.app.a;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.tavcut.composition.model.component.AudioSource;
import com.tencent.tavcut.composition.model.component.BackgroundFillMode;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.composition.model.component.Timeline;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.model.Painting;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.rendermodel.properties.Properties;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\b\u0086\b\u0018\u0000 O2\u00020\u0001:\u0001OB\u00c3\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u0007\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\r\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0012\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\r\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0002\u0010 J\t\u0010;\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00180\rH\u00c6\u0003J\t\u0010=\u001a\u00020\u001aH\u00c6\u0003J\t\u0010>\u001a\u00020\u0012H\u00c6\u0003J\u0011\u0010?\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\rH\u00c6\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u001fH\u00c6\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0015\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u00c6\u0003J\t\u0010C\u001a\u00020\u000bH\u00c6\u0003J\u000f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00c6\u0003J\t\u0010E\u001a\u00020\u0010H\u00c6\u0003J\t\u0010F\u001a\u00020\u0012H\u00c6\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0014H\u00c6\u0003J\u0015\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u0007H\u00c6\u0003J\u00c7\u0001\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u00072\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\r2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00122\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\r2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u00c6\u0001J\u0013\u0010J\u001a\u00020\u00102\b\u0010K\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010L\u001a\u00020\u001aJ\t\u0010M\u001a\u00020\u0012H\u00d6\u0001J\t\u0010N\u001a\u00020\bH\u00d6\u0001R\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u001b\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010&R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\r\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010$R\u0019\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010$\u00a8\u0006P"}, d2 = {"Lcom/tencent/tavcut/rendermodel/RenderModel;", "", "renderScene", "Lcom/tencent/tavcut/rendermodel/RenderScene;", "root", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "inputSources", "", "", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "painting", "Lcom/tencent/tavcut/model/Painting;", "clipsAssets", "", "Lcom/tencent/tavcut/model/ClipSource;", "modifyClipsDuration", "", "seekTolerance", "", Constants.Service.PROPERTIES, "Lcom/tencent/tavcut/rendermodel/properties/Properties;", "audioAssets", "Lcom/tencent/tavcut/composition/model/component/AudioSource;", "timeLines", "Lcom/tencent/tavcut/composition/model/component/Timeline;", "maxDuration", "", "componentLevel", "voiceChangerConfig", "Lcom/tencent/tavcut/rendermodel/VoiceEnum;", "customRenderConfig", "Lcom/tencent/tavcut/rendermodel/CustomRenderConfig;", "(Lcom/tencent/tavcut/rendermodel/RenderScene;Lcom/tencent/tavcut/rendermodel/entity/Entity;Ljava/util/Map;Lcom/tencent/tavcut/model/Painting;Ljava/util/List;ZILcom/tencent/tavcut/rendermodel/properties/Properties;Ljava/util/Map;Ljava/util/List;JILjava/util/List;Lcom/tencent/tavcut/rendermodel/CustomRenderConfig;)V", "getAudioAssets", "()Ljava/util/Map;", "getClipsAssets", "()Ljava/util/List;", "getComponentLevel", "()I", "getCustomRenderConfig", "()Lcom/tencent/tavcut/rendermodel/CustomRenderConfig;", "setCustomRenderConfig", "(Lcom/tencent/tavcut/rendermodel/CustomRenderConfig;)V", "getInputSources", "getMaxDuration", "()J", "getModifyClipsDuration", "()Z", "getPainting", "()Lcom/tencent/tavcut/model/Painting;", "getProperties", "()Lcom/tencent/tavcut/rendermodel/properties/Properties;", "getRenderScene", "()Lcom/tencent/tavcut/rendermodel/RenderScene;", "getRoot", "()Lcom/tencent/tavcut/rendermodel/entity/Entity;", "getSeekTolerance", "getTimeLines", "getVoiceChangerConfig", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getDurationMs", "hashCode", "toString", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class RenderModel {
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
    private final List<ClipSource> clipsAssets;
    private final int componentLevel;

    @Nullable
    private CustomRenderConfig customRenderConfig;

    @NotNull
    private final Map<String, InputSource> inputSources;
    private final long maxDuration;
    private final boolean modifyClipsDuration;

    @NotNull
    private final Painting painting;

    @Nullable
    private final Properties properties;

    @NotNull
    private final RenderScene renderScene;

    @Nullable
    private final Entity root;
    private final int seekTolerance;

    @NotNull
    private final List<Timeline> timeLines;

    @Nullable
    private final List<VoiceEnum> voiceChangerConfig;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/tavcut/rendermodel/RenderModel$Companion;", "", "()V", "CAMERA_COMPONENT_LEVEL", "", "DEFAULT_BG_COLOR", "", "DEFAULT_PAINTING", "Lcom/tencent/tavcut/model/Painting;", "DEFAULT_SIZE", "Lcom/tencent/tavcut/composition/model/component/Size;", "getDEFAULT_SIZE", "()Lcom/tencent/tavcut/composition/model/component/Size;", "DEFAULT_TEMPLATE_HEIGHT", "DEFAULT_TEMPLATE_WIDTH", "DURATION_UNLIMITED", "", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final Size getDEFAULT_SIZE() {
            return RenderModel.DEFAULT_SIZE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Size size = new Size(720, 1280, null, 4, null);
        DEFAULT_SIZE = size;
        DEFAULT_PAINTING = new Painting(size, null, BackgroundFillMode.SOLID_COLOR, null, DEFAULT_BG_COLOR, null, null, 106, null);
    }

    public RenderModel() {
        this(null, null, null, null, null, false, 0, null, null, null, 0L, 0, null, null, 16383, null);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final RenderScene getRenderScene() {
        return this.renderScene;
    }

    @NotNull
    public final List<Timeline> component10() {
        return this.timeLines;
    }

    /* renamed from: component11, reason: from getter */
    public final long getMaxDuration() {
        return this.maxDuration;
    }

    /* renamed from: component12, reason: from getter */
    public final int getComponentLevel() {
        return this.componentLevel;
    }

    @Nullable
    public final List<VoiceEnum> component13() {
        return this.voiceChangerConfig;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final CustomRenderConfig getCustomRenderConfig() {
        return this.customRenderConfig;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Entity getRoot() {
        return this.root;
    }

    @NotNull
    public final Map<String, InputSource> component3() {
        return this.inputSources;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final Painting getPainting() {
        return this.painting;
    }

    @NotNull
    public final List<ClipSource> component5() {
        return this.clipsAssets;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getModifyClipsDuration() {
        return this.modifyClipsDuration;
    }

    /* renamed from: component7, reason: from getter */
    public final int getSeekTolerance() {
        return this.seekTolerance;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Properties getProperties() {
        return this.properties;
    }

    @NotNull
    public final Map<String, AudioSource> component9() {
        return this.audioAssets;
    }

    @NotNull
    public final RenderModel copy(@NotNull RenderScene renderScene, @Nullable Entity root, @NotNull Map<String, InputSource> inputSources, @NotNull Painting painting, @NotNull List<ClipSource> clipsAssets, boolean modifyClipsDuration, int seekTolerance, @Nullable Properties properties, @NotNull Map<String, AudioSource> audioAssets, @NotNull List<Timeline> timeLines, long maxDuration, int componentLevel, @Nullable List<? extends VoiceEnum> voiceChangerConfig, @Nullable CustomRenderConfig customRenderConfig) {
        Intrinsics.checkParameterIsNotNull(renderScene, "renderScene");
        Intrinsics.checkParameterIsNotNull(inputSources, "inputSources");
        Intrinsics.checkParameterIsNotNull(painting, "painting");
        Intrinsics.checkParameterIsNotNull(clipsAssets, "clipsAssets");
        Intrinsics.checkParameterIsNotNull(audioAssets, "audioAssets");
        Intrinsics.checkParameterIsNotNull(timeLines, "timeLines");
        return new RenderModel(renderScene, root, inputSources, painting, clipsAssets, modifyClipsDuration, seekTolerance, properties, audioAssets, timeLines, maxDuration, componentLevel, voiceChangerConfig, customRenderConfig);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof RenderModel) {
                RenderModel renderModel = (RenderModel) other;
                if (!Intrinsics.areEqual(this.renderScene, renderModel.renderScene) || !Intrinsics.areEqual(this.root, renderModel.root) || !Intrinsics.areEqual(this.inputSources, renderModel.inputSources) || !Intrinsics.areEqual(this.painting, renderModel.painting) || !Intrinsics.areEqual(this.clipsAssets, renderModel.clipsAssets) || this.modifyClipsDuration != renderModel.modifyClipsDuration || this.seekTolerance != renderModel.seekTolerance || !Intrinsics.areEqual(this.properties, renderModel.properties) || !Intrinsics.areEqual(this.audioAssets, renderModel.audioAssets) || !Intrinsics.areEqual(this.timeLines, renderModel.timeLines) || this.maxDuration != renderModel.maxDuration || this.componentLevel != renderModel.componentLevel || !Intrinsics.areEqual(this.voiceChangerConfig, renderModel.voiceChangerConfig) || !Intrinsics.areEqual(this.customRenderConfig, renderModel.customRenderConfig)) {
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

    @NotNull
    public final Map<String, InputSource> getInputSources() {
        return this.inputSources;
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

    @NotNull
    public final List<Timeline> getTimeLines() {
        return this.timeLines;
    }

    @Nullable
    public final List<VoiceEnum> getVoiceChangerConfig() {
        return this.voiceChangerConfig;
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
        RenderScene renderScene = this.renderScene;
        int i36 = 0;
        if (renderScene != null) {
            i3 = renderScene.hashCode();
        } else {
            i3 = 0;
        }
        int i37 = i3 * 31;
        Entity entity = this.root;
        if (entity != null) {
            i16 = entity.hashCode();
        } else {
            i16 = 0;
        }
        int i38 = (i37 + i16) * 31;
        Map<String, InputSource> map = this.inputSources;
        if (map != null) {
            i17 = map.hashCode();
        } else {
            i17 = 0;
        }
        int i39 = (i38 + i17) * 31;
        Painting painting = this.painting;
        if (painting != null) {
            i18 = painting.hashCode();
        } else {
            i18 = 0;
        }
        int i46 = (i39 + i18) * 31;
        List<ClipSource> list = this.clipsAssets;
        if (list != null) {
            i19 = list.hashCode();
        } else {
            i19 = 0;
        }
        int i47 = (i46 + i19) * 31;
        boolean z16 = this.modifyClipsDuration;
        int i48 = z16;
        if (z16 != 0) {
            i48 = 1;
        }
        int i49 = (((i47 + i48) * 31) + this.seekTolerance) * 31;
        Properties properties = this.properties;
        if (properties != null) {
            i26 = properties.hashCode();
        } else {
            i26 = 0;
        }
        int i56 = (i49 + i26) * 31;
        Map<String, AudioSource> map2 = this.audioAssets;
        if (map2 != null) {
            i27 = map2.hashCode();
        } else {
            i27 = 0;
        }
        int i57 = (i56 + i27) * 31;
        List<Timeline> list2 = this.timeLines;
        if (list2 != null) {
            i28 = list2.hashCode();
        } else {
            i28 = 0;
        }
        int a16 = (((((i57 + i28) * 31) + a.a(this.maxDuration)) * 31) + this.componentLevel) * 31;
        List<VoiceEnum> list3 = this.voiceChangerConfig;
        if (list3 != null) {
            i29 = list3.hashCode();
        } else {
            i29 = 0;
        }
        int i58 = (a16 + i29) * 31;
        CustomRenderConfig customRenderConfig = this.customRenderConfig;
        if (customRenderConfig != null) {
            i36 = customRenderConfig.hashCode();
        }
        return i58 + i36;
    }

    public final void setCustomRenderConfig(@Nullable CustomRenderConfig customRenderConfig) {
        this.customRenderConfig = customRenderConfig;
    }

    @NotNull
    public String toString() {
        return "RenderModel(renderScene=" + this.renderScene + ", root=" + this.root + ", inputSources=" + this.inputSources + ", painting=" + this.painting + ", clipsAssets=" + this.clipsAssets + ", modifyClipsDuration=" + this.modifyClipsDuration + ", seekTolerance=" + this.seekTolerance + ", properties=" + this.properties + ", audioAssets=" + this.audioAssets + ", timeLines=" + this.timeLines + ", maxDuration=" + this.maxDuration + ", componentLevel=" + this.componentLevel + ", voiceChangerConfig=" + this.voiceChangerConfig + ", customRenderConfig=" + this.customRenderConfig + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RenderModel(@NotNull RenderScene renderScene, @Nullable Entity entity, @NotNull Map<String, InputSource> inputSources, @NotNull Painting painting, @NotNull List<ClipSource> clipsAssets, boolean z16, int i3, @Nullable Properties properties, @NotNull Map<String, AudioSource> audioAssets, @NotNull List<Timeline> timeLines, long j3, int i16, @Nullable List<? extends VoiceEnum> list, @Nullable CustomRenderConfig customRenderConfig) {
        Intrinsics.checkParameterIsNotNull(renderScene, "renderScene");
        Intrinsics.checkParameterIsNotNull(inputSources, "inputSources");
        Intrinsics.checkParameterIsNotNull(painting, "painting");
        Intrinsics.checkParameterIsNotNull(clipsAssets, "clipsAssets");
        Intrinsics.checkParameterIsNotNull(audioAssets, "audioAssets");
        Intrinsics.checkParameterIsNotNull(timeLines, "timeLines");
        this.renderScene = renderScene;
        this.root = entity;
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
    }

    public /* synthetic */ RenderModel(RenderScene renderScene, Entity entity, Map map, Painting painting, List list, boolean z16, int i3, Properties properties, Map map2, List list2, long j3, int i16, List list3, CustomRenderConfig customRenderConfig, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? RenderScene.PLAY : renderScene, (i17 & 2) != 0 ? null : entity, (i17 & 4) != 0 ? MapsKt__MapsKt.emptyMap() : map, (i17 & 8) != 0 ? DEFAULT_PAINTING : painting, (i17 & 16) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i17 & 32) != 0 ? true : z16, (i17 & 64) != 0 ? 0 : i3, (i17 & 128) != 0 ? null : properties, (i17 & 256) != 0 ? MapsKt__MapsKt.emptyMap() : map2, (i17 & 512) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i17 & 1024) != 0 ? -1L : j3, (i17 & 2048) != 0 ? 3 : i16, (i17 & 4096) != 0 ? null : list3, (i17 & 8192) == 0 ? customRenderConfig : null);
    }
}
