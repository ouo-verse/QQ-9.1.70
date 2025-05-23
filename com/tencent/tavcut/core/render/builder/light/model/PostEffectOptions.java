package com.tencent.tavcut.core.render.builder.light.model;

import com.tencent.ams.mosaic.jsengine.component.imagegallery.ImageGalleryComponent;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.qcircle.weseevideo.model.template.movie.AIAbilityModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\bW\b\u0086\b\u0018\u00002\u00020\u0001B\u00f1\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010%J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u0010\u0010N\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u00102J\u0010\u0010O\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u00102J\u0010\u0010P\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u0010\u0010R\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u0010\u0010S\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u0010\u0010T\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u0010\u0010U\u001a\u0004\u0018\u00010\u0017H\u00c6\u0003\u00a2\u0006\u0002\u0010HJ\u000f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019H\u00c6\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010X\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u0010\u0010[\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u0010\u0010\\\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u0010\u0010]\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u0010\u0010^\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u0010\u0010_\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u0010\u0010`\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u0010\u0010a\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010c\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u0010\u0010d\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u0010\u0010e\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u00102J\u0010\u0010f\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u00102J\u0010\u0010g\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010i\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u00fa\u0002\u0010j\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001\u00a2\u0006\u0002\u0010kJ\u0013\u0010l\u001a\u00020\u00172\b\u0010m\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010n\u001a\u00020\u0007H\u00d6\u0001J\t\u0010o\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b+\u0010)R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b,\u0010)R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b-\u0010)R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b.\u0010)R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u0015\u0010\"\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b0\u0010)R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u00103\u001a\u0004\b6\u00102R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b7\u0010)R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b8\u0010)R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010'R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b:\u0010)R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b;\u0010)R\u0015\u0010$\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b<\u0010)R\u0015\u0010 \u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b=\u0010)R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b>\u0010)R\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b?\u0010)R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b@\u0010)R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\bA\u0010)R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\bB\u0010)R\u0015\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u00103\u001a\u0004\bC\u00102R\u0015\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u00103\u001a\u0004\bD\u00102R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\bE\u0010)R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010'R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\n\n\u0002\u0010I\u001a\u0004\bG\u0010HR\u0015\u0010!\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\bJ\u0010)R\u0015\u0010#\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\bK\u0010)\u00a8\u0006p"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/model/PostEffectOptions;", "", AIAbilityModel.AI_KEY, "", "subEffectType", "kiraEffectType", "effectStrength", "", "starMaxScale", "", "starMinScale", "starScalePeriod", c.W, "maxCorners", "minDistance", "highLightThreshold", "fastNumPercentage", "seedNum", "clusterDistance", "shakeDisPlacement", "sleepTime", "clusterMaxSize", "switchEnvironment", "", "filePaths", "", "brightness", "contrast", "hue", "highlights", "sharpness", "shadows", "saturation", "temperature", ImageGalleryComponent.AnimationType.FADE, "vignetting", "pitu_mode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBlendMode", "()Ljava/lang/String;", "getBrightness", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getClusterDistance", "getClusterMaxSize", "getContrast", "getEffectStrength", "getEffectType", "getFade", "getFastNumPercentage", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getFilePaths", "()Ljava/util/List;", "getHighLightThreshold", "getHighlights", "getHue", "getKiraEffectType", "getMaxCorners", "getMinDistance", "getPitu_mode", "getSaturation", "getSeedNum", "getShadows", "getShakeDisPlacement", "getSharpness", "getSleepTime", "getStarMaxScale", "getStarMinScale", "getStarScalePeriod", "getSubEffectType", "getSwitchEnvironment", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTemperature", "getVignetting", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tencent/tavcut/core/render/builder/light/model/PostEffectOptions;", "equals", "other", "hashCode", "toString", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class PostEffectOptions {

    @Nullable
    private final String blendMode;

    @Nullable
    private final Integer brightness;

    @Nullable
    private final Integer clusterDistance;

    @Nullable
    private final Integer clusterMaxSize;

    @Nullable
    private final Integer contrast;

    @Nullable
    private final Integer effectStrength;

    @Nullable
    private final String effectType;

    @Nullable
    private final Integer fade;

    @Nullable
    private final Float fastNumPercentage;

    @NotNull
    private final List<String> filePaths;

    @Nullable
    private final Float highLightThreshold;

    @Nullable
    private final Integer highlights;

    @Nullable
    private final Integer hue;

    @Nullable
    private final String kiraEffectType;

    @Nullable
    private final Integer maxCorners;

    @Nullable
    private final Integer minDistance;

    @Nullable
    private final Integer pitu_mode;

    @Nullable
    private final Integer saturation;

    @Nullable
    private final Integer seedNum;

    @Nullable
    private final Integer shadows;

    @Nullable
    private final Integer shakeDisPlacement;

    @Nullable
    private final Integer sharpness;

    @Nullable
    private final Integer sleepTime;

    @Nullable
    private final Float starMaxScale;

    @Nullable
    private final Float starMinScale;

    @Nullable
    private final Integer starScalePeriod;

    @Nullable
    private final String subEffectType;

    @Nullable
    private final Boolean switchEnvironment;

    @Nullable
    private final Integer temperature;

    @Nullable
    private final Integer vignetting;

    public PostEffectOptions() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getEffectType() {
        return this.effectType;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Integer getMinDistance() {
        return this.minDistance;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Float getHighLightThreshold() {
        return this.highLightThreshold;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final Float getFastNumPercentage() {
        return this.fastNumPercentage;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final Integer getSeedNum() {
        return this.seedNum;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final Integer getClusterDistance() {
        return this.clusterDistance;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final Integer getShakeDisPlacement() {
        return this.shakeDisPlacement;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final Integer getSleepTime() {
        return this.sleepTime;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final Integer getClusterMaxSize() {
        return this.clusterMaxSize;
    }

    @Nullable
    /* renamed from: component18, reason: from getter */
    public final Boolean getSwitchEnvironment() {
        return this.switchEnvironment;
    }

    @NotNull
    public final List<String> component19() {
        return this.filePaths;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getSubEffectType() {
        return this.subEffectType;
    }

    @Nullable
    /* renamed from: component20, reason: from getter */
    public final Integer getBrightness() {
        return this.brightness;
    }

    @Nullable
    /* renamed from: component21, reason: from getter */
    public final Integer getContrast() {
        return this.contrast;
    }

    @Nullable
    /* renamed from: component22, reason: from getter */
    public final Integer getHue() {
        return this.hue;
    }

    @Nullable
    /* renamed from: component23, reason: from getter */
    public final Integer getHighlights() {
        return this.highlights;
    }

    @Nullable
    /* renamed from: component24, reason: from getter */
    public final Integer getSharpness() {
        return this.sharpness;
    }

    @Nullable
    /* renamed from: component25, reason: from getter */
    public final Integer getShadows() {
        return this.shadows;
    }

    @Nullable
    /* renamed from: component26, reason: from getter */
    public final Integer getSaturation() {
        return this.saturation;
    }

    @Nullable
    /* renamed from: component27, reason: from getter */
    public final Integer getTemperature() {
        return this.temperature;
    }

    @Nullable
    /* renamed from: component28, reason: from getter */
    public final Integer getFade() {
        return this.fade;
    }

    @Nullable
    /* renamed from: component29, reason: from getter */
    public final Integer getVignetting() {
        return this.vignetting;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getKiraEffectType() {
        return this.kiraEffectType;
    }

    @Nullable
    /* renamed from: component30, reason: from getter */
    public final Integer getPitu_mode() {
        return this.pitu_mode;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getEffectStrength() {
        return this.effectStrength;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Float getStarMaxScale() {
        return this.starMaxScale;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Float getStarMinScale() {
        return this.starMinScale;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Integer getStarScalePeriod() {
        return this.starScalePeriod;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getBlendMode() {
        return this.blendMode;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Integer getMaxCorners() {
        return this.maxCorners;
    }

    @NotNull
    public final PostEffectOptions copy(@Nullable String effectType, @Nullable String subEffectType, @Nullable String kiraEffectType, @Nullable Integer effectStrength, @Nullable Float starMaxScale, @Nullable Float starMinScale, @Nullable Integer starScalePeriod, @Nullable String blendMode, @Nullable Integer maxCorners, @Nullable Integer minDistance, @Nullable Float highLightThreshold, @Nullable Float fastNumPercentage, @Nullable Integer seedNum, @Nullable Integer clusterDistance, @Nullable Integer shakeDisPlacement, @Nullable Integer sleepTime, @Nullable Integer clusterMaxSize, @Nullable Boolean switchEnvironment, @NotNull List<String> filePaths, @Nullable Integer brightness, @Nullable Integer contrast, @Nullable Integer hue, @Nullable Integer highlights, @Nullable Integer sharpness, @Nullable Integer shadows, @Nullable Integer saturation, @Nullable Integer temperature, @Nullable Integer fade, @Nullable Integer vignetting, @Nullable Integer pitu_mode) {
        Intrinsics.checkParameterIsNotNull(filePaths, "filePaths");
        return new PostEffectOptions(effectType, subEffectType, kiraEffectType, effectStrength, starMaxScale, starMinScale, starScalePeriod, blendMode, maxCorners, minDistance, highLightThreshold, fastNumPercentage, seedNum, clusterDistance, shakeDisPlacement, sleepTime, clusterMaxSize, switchEnvironment, filePaths, brightness, contrast, hue, highlights, sharpness, shadows, saturation, temperature, fade, vignetting, pitu_mode);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof PostEffectOptions) {
                PostEffectOptions postEffectOptions = (PostEffectOptions) other;
                if (!Intrinsics.areEqual(this.effectType, postEffectOptions.effectType) || !Intrinsics.areEqual(this.subEffectType, postEffectOptions.subEffectType) || !Intrinsics.areEqual(this.kiraEffectType, postEffectOptions.kiraEffectType) || !Intrinsics.areEqual(this.effectStrength, postEffectOptions.effectStrength) || !Intrinsics.areEqual((Object) this.starMaxScale, (Object) postEffectOptions.starMaxScale) || !Intrinsics.areEqual((Object) this.starMinScale, (Object) postEffectOptions.starMinScale) || !Intrinsics.areEqual(this.starScalePeriod, postEffectOptions.starScalePeriod) || !Intrinsics.areEqual(this.blendMode, postEffectOptions.blendMode) || !Intrinsics.areEqual(this.maxCorners, postEffectOptions.maxCorners) || !Intrinsics.areEqual(this.minDistance, postEffectOptions.minDistance) || !Intrinsics.areEqual((Object) this.highLightThreshold, (Object) postEffectOptions.highLightThreshold) || !Intrinsics.areEqual((Object) this.fastNumPercentage, (Object) postEffectOptions.fastNumPercentage) || !Intrinsics.areEqual(this.seedNum, postEffectOptions.seedNum) || !Intrinsics.areEqual(this.clusterDistance, postEffectOptions.clusterDistance) || !Intrinsics.areEqual(this.shakeDisPlacement, postEffectOptions.shakeDisPlacement) || !Intrinsics.areEqual(this.sleepTime, postEffectOptions.sleepTime) || !Intrinsics.areEqual(this.clusterMaxSize, postEffectOptions.clusterMaxSize) || !Intrinsics.areEqual(this.switchEnvironment, postEffectOptions.switchEnvironment) || !Intrinsics.areEqual(this.filePaths, postEffectOptions.filePaths) || !Intrinsics.areEqual(this.brightness, postEffectOptions.brightness) || !Intrinsics.areEqual(this.contrast, postEffectOptions.contrast) || !Intrinsics.areEqual(this.hue, postEffectOptions.hue) || !Intrinsics.areEqual(this.highlights, postEffectOptions.highlights) || !Intrinsics.areEqual(this.sharpness, postEffectOptions.sharpness) || !Intrinsics.areEqual(this.shadows, postEffectOptions.shadows) || !Intrinsics.areEqual(this.saturation, postEffectOptions.saturation) || !Intrinsics.areEqual(this.temperature, postEffectOptions.temperature) || !Intrinsics.areEqual(this.fade, postEffectOptions.fade) || !Intrinsics.areEqual(this.vignetting, postEffectOptions.vignetting) || !Intrinsics.areEqual(this.pitu_mode, postEffectOptions.pitu_mode)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final String getBlendMode() {
        return this.blendMode;
    }

    @Nullable
    public final Integer getBrightness() {
        return this.brightness;
    }

    @Nullable
    public final Integer getClusterDistance() {
        return this.clusterDistance;
    }

    @Nullable
    public final Integer getClusterMaxSize() {
        return this.clusterMaxSize;
    }

    @Nullable
    public final Integer getContrast() {
        return this.contrast;
    }

    @Nullable
    public final Integer getEffectStrength() {
        return this.effectStrength;
    }

    @Nullable
    public final String getEffectType() {
        return this.effectType;
    }

    @Nullable
    public final Integer getFade() {
        return this.fade;
    }

    @Nullable
    public final Float getFastNumPercentage() {
        return this.fastNumPercentage;
    }

    @NotNull
    public final List<String> getFilePaths() {
        return this.filePaths;
    }

    @Nullable
    public final Float getHighLightThreshold() {
        return this.highLightThreshold;
    }

    @Nullable
    public final Integer getHighlights() {
        return this.highlights;
    }

    @Nullable
    public final Integer getHue() {
        return this.hue;
    }

    @Nullable
    public final String getKiraEffectType() {
        return this.kiraEffectType;
    }

    @Nullable
    public final Integer getMaxCorners() {
        return this.maxCorners;
    }

    @Nullable
    public final Integer getMinDistance() {
        return this.minDistance;
    }

    @Nullable
    public final Integer getPitu_mode() {
        return this.pitu_mode;
    }

    @Nullable
    public final Integer getSaturation() {
        return this.saturation;
    }

    @Nullable
    public final Integer getSeedNum() {
        return this.seedNum;
    }

    @Nullable
    public final Integer getShadows() {
        return this.shadows;
    }

    @Nullable
    public final Integer getShakeDisPlacement() {
        return this.shakeDisPlacement;
    }

    @Nullable
    public final Integer getSharpness() {
        return this.sharpness;
    }

    @Nullable
    public final Integer getSleepTime() {
        return this.sleepTime;
    }

    @Nullable
    public final Float getStarMaxScale() {
        return this.starMaxScale;
    }

    @Nullable
    public final Float getStarMinScale() {
        return this.starMinScale;
    }

    @Nullable
    public final Integer getStarScalePeriod() {
        return this.starScalePeriod;
    }

    @Nullable
    public final String getSubEffectType() {
        return this.subEffectType;
    }

    @Nullable
    public final Boolean getSwitchEnvironment() {
        return this.switchEnvironment;
    }

    @Nullable
    public final Integer getTemperature() {
        return this.temperature;
    }

    @Nullable
    public final Integer getVignetting() {
        return this.vignetting;
    }

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
        int i39;
        int i46;
        int i47;
        int i48;
        int i49;
        int i56;
        int i57;
        int i58;
        int i59;
        int i65;
        int i66;
        int i67;
        int i68;
        int i69;
        int i75;
        int i76;
        int i77;
        String str = this.effectType;
        int i78 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i79 = i3 * 31;
        String str2 = this.subEffectType;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i85 = (i79 + i16) * 31;
        String str3 = this.kiraEffectType;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i86 = (i85 + i17) * 31;
        Integer num = this.effectStrength;
        if (num != null) {
            i18 = num.hashCode();
        } else {
            i18 = 0;
        }
        int i87 = (i86 + i18) * 31;
        Float f16 = this.starMaxScale;
        if (f16 != null) {
            i19 = f16.hashCode();
        } else {
            i19 = 0;
        }
        int i88 = (i87 + i19) * 31;
        Float f17 = this.starMinScale;
        if (f17 != null) {
            i26 = f17.hashCode();
        } else {
            i26 = 0;
        }
        int i89 = (i88 + i26) * 31;
        Integer num2 = this.starScalePeriod;
        if (num2 != null) {
            i27 = num2.hashCode();
        } else {
            i27 = 0;
        }
        int i95 = (i89 + i27) * 31;
        String str4 = this.blendMode;
        if (str4 != null) {
            i28 = str4.hashCode();
        } else {
            i28 = 0;
        }
        int i96 = (i95 + i28) * 31;
        Integer num3 = this.maxCorners;
        if (num3 != null) {
            i29 = num3.hashCode();
        } else {
            i29 = 0;
        }
        int i97 = (i96 + i29) * 31;
        Integer num4 = this.minDistance;
        if (num4 != null) {
            i36 = num4.hashCode();
        } else {
            i36 = 0;
        }
        int i98 = (i97 + i36) * 31;
        Float f18 = this.highLightThreshold;
        if (f18 != null) {
            i37 = f18.hashCode();
        } else {
            i37 = 0;
        }
        int i99 = (i98 + i37) * 31;
        Float f19 = this.fastNumPercentage;
        if (f19 != null) {
            i38 = f19.hashCode();
        } else {
            i38 = 0;
        }
        int i100 = (i99 + i38) * 31;
        Integer num5 = this.seedNum;
        if (num5 != null) {
            i39 = num5.hashCode();
        } else {
            i39 = 0;
        }
        int i101 = (i100 + i39) * 31;
        Integer num6 = this.clusterDistance;
        if (num6 != null) {
            i46 = num6.hashCode();
        } else {
            i46 = 0;
        }
        int i102 = (i101 + i46) * 31;
        Integer num7 = this.shakeDisPlacement;
        if (num7 != null) {
            i47 = num7.hashCode();
        } else {
            i47 = 0;
        }
        int i103 = (i102 + i47) * 31;
        Integer num8 = this.sleepTime;
        if (num8 != null) {
            i48 = num8.hashCode();
        } else {
            i48 = 0;
        }
        int i104 = (i103 + i48) * 31;
        Integer num9 = this.clusterMaxSize;
        if (num9 != null) {
            i49 = num9.hashCode();
        } else {
            i49 = 0;
        }
        int i105 = (i104 + i49) * 31;
        Boolean bool = this.switchEnvironment;
        if (bool != null) {
            i56 = bool.hashCode();
        } else {
            i56 = 0;
        }
        int i106 = (i105 + i56) * 31;
        List<String> list = this.filePaths;
        if (list != null) {
            i57 = list.hashCode();
        } else {
            i57 = 0;
        }
        int i107 = (i106 + i57) * 31;
        Integer num10 = this.brightness;
        if (num10 != null) {
            i58 = num10.hashCode();
        } else {
            i58 = 0;
        }
        int i108 = (i107 + i58) * 31;
        Integer num11 = this.contrast;
        if (num11 != null) {
            i59 = num11.hashCode();
        } else {
            i59 = 0;
        }
        int i109 = (i108 + i59) * 31;
        Integer num12 = this.hue;
        if (num12 != null) {
            i65 = num12.hashCode();
        } else {
            i65 = 0;
        }
        int i110 = (i109 + i65) * 31;
        Integer num13 = this.highlights;
        if (num13 != null) {
            i66 = num13.hashCode();
        } else {
            i66 = 0;
        }
        int i111 = (i110 + i66) * 31;
        Integer num14 = this.sharpness;
        if (num14 != null) {
            i67 = num14.hashCode();
        } else {
            i67 = 0;
        }
        int i112 = (i111 + i67) * 31;
        Integer num15 = this.shadows;
        if (num15 != null) {
            i68 = num15.hashCode();
        } else {
            i68 = 0;
        }
        int i113 = (i112 + i68) * 31;
        Integer num16 = this.saturation;
        if (num16 != null) {
            i69 = num16.hashCode();
        } else {
            i69 = 0;
        }
        int i114 = (i113 + i69) * 31;
        Integer num17 = this.temperature;
        if (num17 != null) {
            i75 = num17.hashCode();
        } else {
            i75 = 0;
        }
        int i115 = (i114 + i75) * 31;
        Integer num18 = this.fade;
        if (num18 != null) {
            i76 = num18.hashCode();
        } else {
            i76 = 0;
        }
        int i116 = (i115 + i76) * 31;
        Integer num19 = this.vignetting;
        if (num19 != null) {
            i77 = num19.hashCode();
        } else {
            i77 = 0;
        }
        int i117 = (i116 + i77) * 31;
        Integer num20 = this.pitu_mode;
        if (num20 != null) {
            i78 = num20.hashCode();
        }
        return i117 + i78;
    }

    @NotNull
    public String toString() {
        return "PostEffectOptions(effectType=" + this.effectType + ", subEffectType=" + this.subEffectType + ", kiraEffectType=" + this.kiraEffectType + ", effectStrength=" + this.effectStrength + ", starMaxScale=" + this.starMaxScale + ", starMinScale=" + this.starMinScale + ", starScalePeriod=" + this.starScalePeriod + ", blendMode=" + this.blendMode + ", maxCorners=" + this.maxCorners + ", minDistance=" + this.minDistance + ", highLightThreshold=" + this.highLightThreshold + ", fastNumPercentage=" + this.fastNumPercentage + ", seedNum=" + this.seedNum + ", clusterDistance=" + this.clusterDistance + ", shakeDisPlacement=" + this.shakeDisPlacement + ", sleepTime=" + this.sleepTime + ", clusterMaxSize=" + this.clusterMaxSize + ", switchEnvironment=" + this.switchEnvironment + ", filePaths=" + this.filePaths + ", brightness=" + this.brightness + ", contrast=" + this.contrast + ", hue=" + this.hue + ", highlights=" + this.highlights + ", sharpness=" + this.sharpness + ", shadows=" + this.shadows + ", saturation=" + this.saturation + ", temperature=" + this.temperature + ", fade=" + this.fade + ", vignetting=" + this.vignetting + ", pitu_mode=" + this.pitu_mode + ")";
    }

    public PostEffectOptions(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable Float f16, @Nullable Float f17, @Nullable Integer num2, @Nullable String str4, @Nullable Integer num3, @Nullable Integer num4, @Nullable Float f18, @Nullable Float f19, @Nullable Integer num5, @Nullable Integer num6, @Nullable Integer num7, @Nullable Integer num8, @Nullable Integer num9, @Nullable Boolean bool, @NotNull List<String> filePaths, @Nullable Integer num10, @Nullable Integer num11, @Nullable Integer num12, @Nullable Integer num13, @Nullable Integer num14, @Nullable Integer num15, @Nullable Integer num16, @Nullable Integer num17, @Nullable Integer num18, @Nullable Integer num19, @Nullable Integer num20) {
        Intrinsics.checkParameterIsNotNull(filePaths, "filePaths");
        this.effectType = str;
        this.subEffectType = str2;
        this.kiraEffectType = str3;
        this.effectStrength = num;
        this.starMaxScale = f16;
        this.starMinScale = f17;
        this.starScalePeriod = num2;
        this.blendMode = str4;
        this.maxCorners = num3;
        this.minDistance = num4;
        this.highLightThreshold = f18;
        this.fastNumPercentage = f19;
        this.seedNum = num5;
        this.clusterDistance = num6;
        this.shakeDisPlacement = num7;
        this.sleepTime = num8;
        this.clusterMaxSize = num9;
        this.switchEnvironment = bool;
        this.filePaths = filePaths;
        this.brightness = num10;
        this.contrast = num11;
        this.hue = num12;
        this.highlights = num13;
        this.sharpness = num14;
        this.shadows = num15;
        this.saturation = num16;
        this.temperature = num17;
        this.fade = num18;
        this.vignetting = num19;
        this.pitu_mode = num20;
    }

    public /* synthetic */ PostEffectOptions(String str, String str2, String str3, Integer num, Float f16, Float f17, Integer num2, String str4, Integer num3, Integer num4, Float f18, Float f19, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Boolean bool, List list, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Integer num17, Integer num18, Integer num19, Integer num20, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : num, (i3 & 16) != 0 ? null : f16, (i3 & 32) != 0 ? null : f17, (i3 & 64) != 0 ? null : num2, (i3 & 128) != 0 ? null : str4, (i3 & 256) != 0 ? null : num3, (i3 & 512) != 0 ? null : num4, (i3 & 1024) != 0 ? null : f18, (i3 & 2048) != 0 ? null : f19, (i3 & 4096) != 0 ? null : num5, (i3 & 8192) != 0 ? null : num6, (i3 & 16384) != 0 ? null : num7, (i3 & 32768) != 0 ? null : num8, (i3 & 65536) != 0 ? null : num9, (i3 & 131072) != 0 ? null : bool, (i3 & 262144) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 524288) != 0 ? null : num10, (i3 & 1048576) != 0 ? null : num11, (i3 & 2097152) != 0 ? null : num12, (i3 & 4194304) != 0 ? null : num13, (i3 & 8388608) != 0 ? null : num14, (i3 & 16777216) != 0 ? null : num15, (i3 & 33554432) != 0 ? null : num16, (i3 & 67108864) != 0 ? null : num17, (i3 & 134217728) != 0 ? null : num18, (i3 & 268435456) != 0 ? null : num19, (i3 & 536870912) != 0 ? null : num20);
    }
}
