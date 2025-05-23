package com.tencent.tavcut.composition.model.component;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.ams.mosaic.jsengine.component.imagegallery.ImageGalleryComponent;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.qcircle.weseevideo.model.template.movie.AIAbilityModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 52\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u000245B\u00fb\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010&\u001a\u00020'\u00a2\u0006\u0002\u0010(J\u0081\u0003\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010&\u001a\u00020'\u00a2\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\u00182\b\u0010/\u001a\u0004\u0018\u000100H\u0096\u0002J\b\u00101\u001a\u00020\bH\u0016J\b\u00102\u001a\u00020\u0002H\u0016J\b\u00103\u001a\u00020\u0004H\u0016R\u0012\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010)R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010)R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010)R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010)R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010)R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010)R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010*R\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010*R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010)R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010)R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010)R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010)R\u0014\u0010%\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010)R\u0014\u0010!\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010)R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010)R\u0014\u0010 \u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010)R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010)R\u0014\u0010\u001f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010)R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010)R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010*R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010*R\u0014\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010)R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010+R\u0014\u0010\"\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010)R\u0014\u0010$\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010)\u00a8\u00066"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/PostEffectOptions;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/PostEffectOptions$Builder;", AIAbilityModel.AI_KEY, "", "subEffectType", "kiraEffectType", "effectStrength", "", "starMaxScale", "", "starMinScale", "starScalePeriod", c.W, "maxCorners", "minDistance", "highLightThreshold", "fastNumPercentage", "seedNum", "clusterDistance", "shakeDisPlacement", "sleepTime", "clusterMaxSize", "switchEnvironment", "", "filePaths", "", "brightness", "contrast", "hue", "highlights", "sharpness", "shadows", "saturation", "temperature", ImageGalleryComponent.AnimationType.FADE, "vignetting", "pitu_mode", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Float;", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/PostEffectOptions;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class PostEffectOptions extends AndroidMessage<PostEffectOptions, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<PostEffectOptions> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<PostEffectOptions> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    @JvmField
    @Nullable
    public final String blendMode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 20)
    @JvmField
    @Nullable
    public final Integer brightness;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 14)
    @JvmField
    @Nullable
    public final Integer clusterDistance;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 17)
    @JvmField
    @Nullable
    public final Integer clusterMaxSize;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 21)
    @JvmField
    @Nullable
    public final Integer contrast;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    @JvmField
    @Nullable
    public final Integer effectStrength;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @Nullable
    public final String effectType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 28)
    @JvmField
    @Nullable
    public final Integer fade;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 12)
    @JvmField
    @Nullable
    public final Float fastNumPercentage;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 19)
    @JvmField
    @NotNull
    public final List<String> filePaths;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 11)
    @JvmField
    @Nullable
    public final Float highLightThreshold;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 23)
    @JvmField
    @Nullable
    public final Integer highlights;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 22)
    @JvmField
    @Nullable
    public final Integer hue;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @JvmField
    @Nullable
    public final String kiraEffectType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    @JvmField
    @Nullable
    public final Integer maxCorners;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 10)
    @JvmField
    @Nullable
    public final Integer minDistance;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 30)
    @JvmField
    @Nullable
    public final Integer pitu_mode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 26)
    @JvmField
    @Nullable
    public final Integer saturation;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 13)
    @JvmField
    @Nullable
    public final Integer seedNum;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 25)
    @JvmField
    @Nullable
    public final Integer shadows;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 15)
    @JvmField
    @Nullable
    public final Integer shakeDisPlacement;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 24)
    @JvmField
    @Nullable
    public final Integer sharpness;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 16)
    @JvmField
    @Nullable
    public final Integer sleepTime;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 5)
    @JvmField
    @Nullable
    public final Float starMaxScale;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
    @JvmField
    @Nullable
    public final Float starMinScale;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 7)
    @JvmField
    @Nullable
    public final Integer starScalePeriod;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @JvmField
    @Nullable
    public final String subEffectType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 18)
    @JvmField
    @Nullable
    public final Boolean switchEnvironment;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 27)
    @JvmField
    @Nullable
    public final Integer temperature;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 29)
    @JvmField
    @Nullable
    public final Integer vignetting;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010*J\b\u0010+\u001a\u00020\u0002H\u0016J\u0015\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010*J\u0015\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010*J\u0015\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010*J\u0015\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010*J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010*J\u0015\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010,J\u0014\u0010\u0012\u001a\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013J\u0015\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010,J\u0015\u0010\u0015\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010*J\u0015\u0010\u0016\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010*J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\u0018\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010*J\u0015\u0010\u0019\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010*J\u0015\u0010\u001a\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010*J\u0015\u0010\u001b\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010*J\u0015\u0010\u001c\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010*J\u0015\u0010\u001d\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010*J\u0015\u0010\u001e\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010*J\u0015\u0010\u001f\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010*J\u0015\u0010 \u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010*J\u0015\u0010!\u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010,J\u0015\u0010\"\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010,J\u0015\u0010#\u001a\u00020\u00002\b\u0010#\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010*J\u0010\u0010$\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\u0005J\u0015\u0010%\u001a\u00020\u00002\b\u0010%\u001a\u0004\u0018\u00010&\u00a2\u0006\u0002\u0010-J\u0015\u0010(\u001a\u00020\u00002\b\u0010(\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010*J\u0015\u0010)\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010*R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0011R\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010 \u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010!\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\"\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010#\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0014\u0010$\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010%\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010'R\u0016\u0010(\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010)\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\b\u00a8\u0006."}, d2 = {"Lcom/tencent/tavcut/composition/model/component/PostEffectOptions$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/PostEffectOptions;", "()V", c.W, "", "brightness", "", "Ljava/lang/Integer;", "clusterDistance", "clusterMaxSize", "contrast", "effectStrength", AIAbilityModel.AI_KEY, ImageGalleryComponent.AnimationType.FADE, "fastNumPercentage", "", "Ljava/lang/Float;", "filePaths", "", "highLightThreshold", "highlights", "hue", "kiraEffectType", "maxCorners", "minDistance", "pitu_mode", "saturation", "seedNum", "shadows", "shakeDisPlacement", "sharpness", "sleepTime", "starMaxScale", "starMinScale", "starScalePeriod", "subEffectType", "switchEnvironment", "", "Ljava/lang/Boolean;", "temperature", "vignetting", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/PostEffectOptions$Builder;", "build", "(Ljava/lang/Float;)Lcom/tencent/tavcut/composition/model/component/PostEffectOptions$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/PostEffectOptions$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<PostEffectOptions, Builder> {

        @JvmField
        @Nullable
        public String blendMode;

        @JvmField
        @Nullable
        public Integer brightness;

        @JvmField
        @Nullable
        public Integer clusterDistance;

        @JvmField
        @Nullable
        public Integer clusterMaxSize;

        @JvmField
        @Nullable
        public Integer contrast;

        @JvmField
        @Nullable
        public Integer effectStrength;

        @JvmField
        @Nullable
        public String effectType;

        @JvmField
        @Nullable
        public Integer fade;

        @JvmField
        @Nullable
        public Float fastNumPercentage;

        @JvmField
        @NotNull
        public List<String> filePaths;

        @JvmField
        @Nullable
        public Float highLightThreshold;

        @JvmField
        @Nullable
        public Integer highlights;

        @JvmField
        @Nullable
        public Integer hue;

        @JvmField
        @Nullable
        public String kiraEffectType;

        @JvmField
        @Nullable
        public Integer maxCorners;

        @JvmField
        @Nullable
        public Integer minDistance;

        @JvmField
        @Nullable
        public Integer pitu_mode;

        @JvmField
        @Nullable
        public Integer saturation;

        @JvmField
        @Nullable
        public Integer seedNum;

        @JvmField
        @Nullable
        public Integer shadows;

        @JvmField
        @Nullable
        public Integer shakeDisPlacement;

        @JvmField
        @Nullable
        public Integer sharpness;

        @JvmField
        @Nullable
        public Integer sleepTime;

        @JvmField
        @Nullable
        public Float starMaxScale;

        @JvmField
        @Nullable
        public Float starMinScale;

        @JvmField
        @Nullable
        public Integer starScalePeriod;

        @JvmField
        @Nullable
        public String subEffectType;

        @JvmField
        @Nullable
        public Boolean switchEnvironment;

        @JvmField
        @Nullable
        public Integer temperature;

        @JvmField
        @Nullable
        public Integer vignetting;

        public Builder() {
            List<String> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.filePaths = emptyList;
        }

        @NotNull
        public final Builder blendMode(@Nullable String blendMode) {
            this.blendMode = blendMode;
            return this;
        }

        @NotNull
        public final Builder brightness(@Nullable Integer brightness) {
            this.brightness = brightness;
            return this;
        }

        @NotNull
        public final Builder clusterDistance(@Nullable Integer clusterDistance) {
            this.clusterDistance = clusterDistance;
            return this;
        }

        @NotNull
        public final Builder clusterMaxSize(@Nullable Integer clusterMaxSize) {
            this.clusterMaxSize = clusterMaxSize;
            return this;
        }

        @NotNull
        public final Builder contrast(@Nullable Integer contrast) {
            this.contrast = contrast;
            return this;
        }

        @NotNull
        public final Builder effectStrength(@Nullable Integer effectStrength) {
            this.effectStrength = effectStrength;
            return this;
        }

        @NotNull
        public final Builder effectType(@Nullable String effectType) {
            this.effectType = effectType;
            return this;
        }

        @NotNull
        public final Builder fade(@Nullable Integer fade) {
            this.fade = fade;
            return this;
        }

        @NotNull
        public final Builder fastNumPercentage(@Nullable Float fastNumPercentage) {
            this.fastNumPercentage = fastNumPercentage;
            return this;
        }

        @NotNull
        public final Builder filePaths(@NotNull List<String> filePaths) {
            Intrinsics.checkParameterIsNotNull(filePaths, "filePaths");
            Internal.checkElementsNotNull(filePaths);
            this.filePaths = filePaths;
            return this;
        }

        @NotNull
        public final Builder highLightThreshold(@Nullable Float highLightThreshold) {
            this.highLightThreshold = highLightThreshold;
            return this;
        }

        @NotNull
        public final Builder highlights(@Nullable Integer highlights) {
            this.highlights = highlights;
            return this;
        }

        @NotNull
        public final Builder hue(@Nullable Integer hue) {
            this.hue = hue;
            return this;
        }

        @NotNull
        public final Builder kiraEffectType(@Nullable String kiraEffectType) {
            this.kiraEffectType = kiraEffectType;
            return this;
        }

        @NotNull
        public final Builder maxCorners(@Nullable Integer maxCorners) {
            this.maxCorners = maxCorners;
            return this;
        }

        @NotNull
        public final Builder minDistance(@Nullable Integer minDistance) {
            this.minDistance = minDistance;
            return this;
        }

        @NotNull
        public final Builder pitu_mode(@Nullable Integer pitu_mode) {
            this.pitu_mode = pitu_mode;
            return this;
        }

        @NotNull
        public final Builder saturation(@Nullable Integer saturation) {
            this.saturation = saturation;
            return this;
        }

        @NotNull
        public final Builder seedNum(@Nullable Integer seedNum) {
            this.seedNum = seedNum;
            return this;
        }

        @NotNull
        public final Builder shadows(@Nullable Integer shadows) {
            this.shadows = shadows;
            return this;
        }

        @NotNull
        public final Builder shakeDisPlacement(@Nullable Integer shakeDisPlacement) {
            this.shakeDisPlacement = shakeDisPlacement;
            return this;
        }

        @NotNull
        public final Builder sharpness(@Nullable Integer sharpness) {
            this.sharpness = sharpness;
            return this;
        }

        @NotNull
        public final Builder sleepTime(@Nullable Integer sleepTime) {
            this.sleepTime = sleepTime;
            return this;
        }

        @NotNull
        public final Builder starMaxScale(@Nullable Float starMaxScale) {
            this.starMaxScale = starMaxScale;
            return this;
        }

        @NotNull
        public final Builder starMinScale(@Nullable Float starMinScale) {
            this.starMinScale = starMinScale;
            return this;
        }

        @NotNull
        public final Builder starScalePeriod(@Nullable Integer starScalePeriod) {
            this.starScalePeriod = starScalePeriod;
            return this;
        }

        @NotNull
        public final Builder subEffectType(@Nullable String subEffectType) {
            this.subEffectType = subEffectType;
            return this;
        }

        @NotNull
        public final Builder switchEnvironment(@Nullable Boolean switchEnvironment) {
            this.switchEnvironment = switchEnvironment;
            return this;
        }

        @NotNull
        public final Builder temperature(@Nullable Integer temperature) {
            this.temperature = temperature;
            return this;
        }

        @NotNull
        public final Builder vignetting(@Nullable Integer vignetting) {
            this.vignetting = vignetting;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public PostEffectOptions build() {
            return new PostEffectOptions(this.effectType, this.subEffectType, this.kiraEffectType, this.effectStrength, this.starMaxScale, this.starMinScale, this.starScalePeriod, this.blendMode, this.maxCorners, this.minDistance, this.highLightThreshold, this.fastNumPercentage, this.seedNum, this.clusterDistance, this.shakeDisPlacement, this.sleepTime, this.clusterMaxSize, this.switchEnvironment, this.filePaths, this.brightness, this.contrast, this.hue, this.highlights, this.sharpness, this.shadows, this.saturation, this.temperature, this.fade, this.vignetting, this.pitu_mode, buildUnknownFields());
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(PostEffectOptions.class);
        final String str = "type.googleapis.com/publisher.PostEffectOptions";
        ProtoAdapter<PostEffectOptions> protoAdapter = new ProtoAdapter<PostEffectOptions>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.PostEffectOptions$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public PostEffectOptions decode(@NotNull ProtoReader reader) {
                ArrayList arrayList;
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                ArrayList arrayList2 = new ArrayList();
                long beginMessage = reader.beginMessage();
                String str2 = null;
                ArrayList arrayList3 = arrayList2;
                String str3 = null;
                String str4 = null;
                Integer num = null;
                Float f16 = null;
                Float f17 = null;
                Integer num2 = null;
                String str5 = null;
                Integer num3 = null;
                Integer num4 = null;
                Float f18 = null;
                Float f19 = null;
                Integer num5 = null;
                Integer num6 = null;
                Integer num7 = null;
                Integer num8 = null;
                Integer num9 = null;
                Boolean bool = null;
                Integer num10 = null;
                Integer num11 = null;
                Integer num12 = null;
                Integer num13 = null;
                Integer num14 = null;
                Integer num15 = null;
                Integer num16 = null;
                Integer num17 = null;
                Integer num18 = null;
                Integer num19 = null;
                Integer num20 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    Float f26 = f19;
                    if (nextTag == -1) {
                        return new PostEffectOptions(str2, str3, str4, num, f16, f17, num2, str5, num3, num4, f18, f26, num5, num6, num7, num8, num9, bool, arrayList3, num10, num11, num12, num13, num14, num15, num16, num17, num18, num19, num20, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                    switch (nextTag) {
                        case 1:
                            arrayList = arrayList3;
                            str2 = ProtoAdapter.STRING.decode(reader);
                            continue;
                        case 2:
                            arrayList = arrayList3;
                            str3 = ProtoAdapter.STRING.decode(reader);
                            continue;
                        case 3:
                            arrayList = arrayList3;
                            str4 = ProtoAdapter.STRING.decode(reader);
                            continue;
                        case 4:
                            arrayList = arrayList3;
                            num = ProtoAdapter.INT32.decode(reader);
                            continue;
                        case 5:
                            arrayList = arrayList3;
                            f16 = ProtoAdapter.FLOAT.decode(reader);
                            continue;
                        case 6:
                            arrayList = arrayList3;
                            f17 = ProtoAdapter.FLOAT.decode(reader);
                            continue;
                        case 7:
                            arrayList = arrayList3;
                            num2 = ProtoAdapter.INT32.decode(reader);
                            continue;
                        case 8:
                            arrayList = arrayList3;
                            str5 = ProtoAdapter.STRING.decode(reader);
                            continue;
                        case 9:
                            arrayList = arrayList3;
                            num3 = ProtoAdapter.INT32.decode(reader);
                            continue;
                        case 10:
                            arrayList = arrayList3;
                            num4 = ProtoAdapter.INT32.decode(reader);
                            continue;
                        case 11:
                            arrayList = arrayList3;
                            f18 = ProtoAdapter.FLOAT.decode(reader);
                            continue;
                        case 12:
                            arrayList = arrayList3;
                            f26 = ProtoAdapter.FLOAT.decode(reader);
                            continue;
                        case 13:
                            arrayList = arrayList3;
                            num5 = ProtoAdapter.INT32.decode(reader);
                            continue;
                        case 14:
                            arrayList = arrayList3;
                            num6 = ProtoAdapter.INT32.decode(reader);
                            continue;
                        case 15:
                            arrayList = arrayList3;
                            num7 = ProtoAdapter.INT32.decode(reader);
                            continue;
                        case 16:
                            arrayList = arrayList3;
                            num8 = ProtoAdapter.INT32.decode(reader);
                            continue;
                        case 17:
                            arrayList = arrayList3;
                            num9 = ProtoAdapter.INT32.decode(reader);
                            continue;
                        case 18:
                            arrayList = arrayList3;
                            bool = ProtoAdapter.BOOL.decode(reader);
                            continue;
                        case 19:
                            arrayList = arrayList3;
                            arrayList.add(ProtoAdapter.STRING.decode(reader));
                            continue;
                        case 20:
                            num10 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 21:
                            num11 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 22:
                            num12 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 23:
                            num13 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 24:
                            num14 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 25:
                            num15 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 26:
                            num16 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 27:
                            num17 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 28:
                            num18 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 29:
                            num19 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 30:
                            num20 = ProtoAdapter.INT32.decode(reader);
                            break;
                        default:
                            arrayList = arrayList3;
                            reader.readUnknownField(nextTag);
                            continue;
                    }
                    arrayList = arrayList3;
                    arrayList3 = arrayList;
                    f19 = f26;
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull PostEffectOptions value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                protoAdapter2.encodeWithTag(writer, 1, value.effectType);
                protoAdapter2.encodeWithTag(writer, 2, value.subEffectType);
                protoAdapter2.encodeWithTag(writer, 3, value.kiraEffectType);
                ProtoAdapter<Integer> protoAdapter3 = ProtoAdapter.INT32;
                protoAdapter3.encodeWithTag(writer, 4, value.effectStrength);
                ProtoAdapter<Float> protoAdapter4 = ProtoAdapter.FLOAT;
                protoAdapter4.encodeWithTag(writer, 5, value.starMaxScale);
                protoAdapter4.encodeWithTag(writer, 6, value.starMinScale);
                protoAdapter3.encodeWithTag(writer, 7, value.starScalePeriod);
                protoAdapter2.encodeWithTag(writer, 8, value.blendMode);
                protoAdapter3.encodeWithTag(writer, 9, value.maxCorners);
                protoAdapter3.encodeWithTag(writer, 10, value.minDistance);
                protoAdapter4.encodeWithTag(writer, 11, value.highLightThreshold);
                protoAdapter4.encodeWithTag(writer, 12, value.fastNumPercentage);
                protoAdapter3.encodeWithTag(writer, 13, value.seedNum);
                protoAdapter3.encodeWithTag(writer, 14, value.clusterDistance);
                protoAdapter3.encodeWithTag(writer, 15, value.shakeDisPlacement);
                protoAdapter3.encodeWithTag(writer, 16, value.sleepTime);
                protoAdapter3.encodeWithTag(writer, 17, value.clusterMaxSize);
                ProtoAdapter.BOOL.encodeWithTag(writer, 18, value.switchEnvironment);
                protoAdapter2.asRepeated().encodeWithTag(writer, 19, value.filePaths);
                protoAdapter3.encodeWithTag(writer, 20, value.brightness);
                protoAdapter3.encodeWithTag(writer, 21, value.contrast);
                protoAdapter3.encodeWithTag(writer, 22, value.hue);
                protoAdapter3.encodeWithTag(writer, 23, value.highlights);
                protoAdapter3.encodeWithTag(writer, 24, value.sharpness);
                protoAdapter3.encodeWithTag(writer, 25, value.shadows);
                protoAdapter3.encodeWithTag(writer, 26, value.saturation);
                protoAdapter3.encodeWithTag(writer, 27, value.temperature);
                protoAdapter3.encodeWithTag(writer, 28, value.fade);
                protoAdapter3.encodeWithTag(writer, 29, value.vignetting);
                protoAdapter3.encodeWithTag(writer, 30, value.pitu_mode);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull PostEffectOptions value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.effectType) + protoAdapter2.encodedSizeWithTag(2, value.subEffectType) + protoAdapter2.encodedSizeWithTag(3, value.kiraEffectType);
                ProtoAdapter<Integer> protoAdapter3 = ProtoAdapter.INT32;
                int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(4, value.effectStrength);
                ProtoAdapter<Float> protoAdapter4 = ProtoAdapter.FLOAT;
                return encodedSizeWithTag2 + protoAdapter4.encodedSizeWithTag(5, value.starMaxScale) + protoAdapter4.encodedSizeWithTag(6, value.starMinScale) + protoAdapter3.encodedSizeWithTag(7, value.starScalePeriod) + protoAdapter2.encodedSizeWithTag(8, value.blendMode) + protoAdapter3.encodedSizeWithTag(9, value.maxCorners) + protoAdapter3.encodedSizeWithTag(10, value.minDistance) + protoAdapter4.encodedSizeWithTag(11, value.highLightThreshold) + protoAdapter4.encodedSizeWithTag(12, value.fastNumPercentage) + protoAdapter3.encodedSizeWithTag(13, value.seedNum) + protoAdapter3.encodedSizeWithTag(14, value.clusterDistance) + protoAdapter3.encodedSizeWithTag(15, value.shakeDisPlacement) + protoAdapter3.encodedSizeWithTag(16, value.sleepTime) + protoAdapter3.encodedSizeWithTag(17, value.clusterMaxSize) + ProtoAdapter.BOOL.encodedSizeWithTag(18, value.switchEnvironment) + protoAdapter2.asRepeated().encodedSizeWithTag(19, value.filePaths) + protoAdapter3.encodedSizeWithTag(20, value.brightness) + protoAdapter3.encodedSizeWithTag(21, value.contrast) + protoAdapter3.encodedSizeWithTag(22, value.hue) + protoAdapter3.encodedSizeWithTag(23, value.highlights) + protoAdapter3.encodedSizeWithTag(24, value.sharpness) + protoAdapter3.encodedSizeWithTag(25, value.shadows) + protoAdapter3.encodedSizeWithTag(26, value.saturation) + protoAdapter3.encodedSizeWithTag(27, value.temperature) + protoAdapter3.encodedSizeWithTag(28, value.fade) + protoAdapter3.encodedSizeWithTag(29, value.vignetting) + protoAdapter3.encodedSizeWithTag(30, value.pitu_mode) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public PostEffectOptions redact(@NotNull PostEffectOptions value) {
                PostEffectOptions copy;
                Intrinsics.checkParameterIsNotNull(value, "value");
                copy = value.copy((r49 & 1) != 0 ? value.effectType : null, (r49 & 2) != 0 ? value.subEffectType : null, (r49 & 4) != 0 ? value.kiraEffectType : null, (r49 & 8) != 0 ? value.effectStrength : null, (r49 & 16) != 0 ? value.starMaxScale : null, (r49 & 32) != 0 ? value.starMinScale : null, (r49 & 64) != 0 ? value.starScalePeriod : null, (r49 & 128) != 0 ? value.blendMode : null, (r49 & 256) != 0 ? value.maxCorners : null, (r49 & 512) != 0 ? value.minDistance : null, (r49 & 1024) != 0 ? value.highLightThreshold : null, (r49 & 2048) != 0 ? value.fastNumPercentage : null, (r49 & 4096) != 0 ? value.seedNum : null, (r49 & 8192) != 0 ? value.clusterDistance : null, (r49 & 16384) != 0 ? value.shakeDisPlacement : null, (r49 & 32768) != 0 ? value.sleepTime : null, (r49 & 65536) != 0 ? value.clusterMaxSize : null, (r49 & 131072) != 0 ? value.switchEnvironment : null, (r49 & 262144) != 0 ? value.filePaths : null, (r49 & 524288) != 0 ? value.brightness : null, (r49 & 1048576) != 0 ? value.contrast : null, (r49 & 2097152) != 0 ? value.hue : null, (r49 & 4194304) != 0 ? value.highlights : null, (r49 & 8388608) != 0 ? value.sharpness : null, (r49 & 16777216) != 0 ? value.shadows : null, (r49 & 33554432) != 0 ? value.saturation : null, (r49 & 67108864) != 0 ? value.temperature : null, (r49 & 134217728) != 0 ? value.fade : null, (r49 & 268435456) != 0 ? value.vignetting : null, (r49 & 536870912) != 0 ? value.pitu_mode : null, (r49 & 1073741824) != 0 ? value.unknownFields() : ByteString.EMPTY);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public PostEffectOptions() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.MAX_VALUE, null);
    }

    @NotNull
    public final PostEffectOptions copy(@Nullable String effectType, @Nullable String subEffectType, @Nullable String kiraEffectType, @Nullable Integer effectStrength, @Nullable Float starMaxScale, @Nullable Float starMinScale, @Nullable Integer starScalePeriod, @Nullable String blendMode, @Nullable Integer maxCorners, @Nullable Integer minDistance, @Nullable Float highLightThreshold, @Nullable Float fastNumPercentage, @Nullable Integer seedNum, @Nullable Integer clusterDistance, @Nullable Integer shakeDisPlacement, @Nullable Integer sleepTime, @Nullable Integer clusterMaxSize, @Nullable Boolean switchEnvironment, @NotNull List<String> filePaths, @Nullable Integer brightness, @Nullable Integer contrast, @Nullable Integer hue, @Nullable Integer highlights, @Nullable Integer sharpness, @Nullable Integer shadows, @Nullable Integer saturation, @Nullable Integer temperature, @Nullable Integer fade, @Nullable Integer vignetting, @Nullable Integer pitu_mode, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(filePaths, "filePaths");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new PostEffectOptions(effectType, subEffectType, kiraEffectType, effectStrength, starMaxScale, starMinScale, starScalePeriod, blendMode, maxCorners, minDistance, highLightThreshold, fastNumPercentage, seedNum, clusterDistance, shakeDisPlacement, sleepTime, clusterMaxSize, switchEnvironment, filePaths, brightness, contrast, hue, highlights, sharpness, shadows, saturation, temperature, fade, vignetting, pitu_mode, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof PostEffectOptions)) {
            return false;
        }
        PostEffectOptions postEffectOptions = (PostEffectOptions) other;
        if (Intrinsics.areEqual(unknownFields(), postEffectOptions.unknownFields()) && Intrinsics.areEqual(this.effectType, postEffectOptions.effectType) && Intrinsics.areEqual(this.subEffectType, postEffectOptions.subEffectType) && Intrinsics.areEqual(this.kiraEffectType, postEffectOptions.kiraEffectType) && Intrinsics.areEqual(this.effectStrength, postEffectOptions.effectStrength) && Intrinsics.areEqual(this.starMaxScale, postEffectOptions.starMaxScale) && Intrinsics.areEqual(this.starMinScale, postEffectOptions.starMinScale) && Intrinsics.areEqual(this.starScalePeriod, postEffectOptions.starScalePeriod) && Intrinsics.areEqual(this.blendMode, postEffectOptions.blendMode) && Intrinsics.areEqual(this.maxCorners, postEffectOptions.maxCorners) && Intrinsics.areEqual(this.minDistance, postEffectOptions.minDistance) && Intrinsics.areEqual(this.highLightThreshold, postEffectOptions.highLightThreshold) && Intrinsics.areEqual(this.fastNumPercentage, postEffectOptions.fastNumPercentage) && Intrinsics.areEqual(this.seedNum, postEffectOptions.seedNum) && Intrinsics.areEqual(this.clusterDistance, postEffectOptions.clusterDistance) && Intrinsics.areEqual(this.shakeDisPlacement, postEffectOptions.shakeDisPlacement) && Intrinsics.areEqual(this.sleepTime, postEffectOptions.sleepTime) && Intrinsics.areEqual(this.clusterMaxSize, postEffectOptions.clusterMaxSize) && Intrinsics.areEqual(this.switchEnvironment, postEffectOptions.switchEnvironment) && Intrinsics.areEqual(this.filePaths, postEffectOptions.filePaths) && Intrinsics.areEqual(this.brightness, postEffectOptions.brightness) && Intrinsics.areEqual(this.contrast, postEffectOptions.contrast) && Intrinsics.areEqual(this.hue, postEffectOptions.hue) && Intrinsics.areEqual(this.highlights, postEffectOptions.highlights) && Intrinsics.areEqual(this.sharpness, postEffectOptions.sharpness) && Intrinsics.areEqual(this.shadows, postEffectOptions.shadows) && Intrinsics.areEqual(this.saturation, postEffectOptions.saturation) && Intrinsics.areEqual(this.temperature, postEffectOptions.temperature) && Intrinsics.areEqual(this.fade, postEffectOptions.fade) && Intrinsics.areEqual(this.vignetting, postEffectOptions.vignetting) && Intrinsics.areEqual(this.pitu_mode, postEffectOptions.pitu_mode)) {
            return true;
        }
        return false;
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
        int i77 = this.hashCode;
        if (i77 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.effectType;
            int i78 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i79 = (hashCode + i3) * 37;
            String str2 = this.subEffectType;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i85 = (i79 + i16) * 37;
            String str3 = this.kiraEffectType;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i86 = (i85 + i17) * 37;
            Integer num = this.effectStrength;
            if (num != null) {
                i18 = num.hashCode();
            } else {
                i18 = 0;
            }
            int i87 = (i86 + i18) * 37;
            Float f16 = this.starMaxScale;
            if (f16 != null) {
                i19 = f16.hashCode();
            } else {
                i19 = 0;
            }
            int i88 = (i87 + i19) * 37;
            Float f17 = this.starMinScale;
            if (f17 != null) {
                i26 = f17.hashCode();
            } else {
                i26 = 0;
            }
            int i89 = (i88 + i26) * 37;
            Integer num2 = this.starScalePeriod;
            if (num2 != null) {
                i27 = num2.hashCode();
            } else {
                i27 = 0;
            }
            int i95 = (i89 + i27) * 37;
            String str4 = this.blendMode;
            if (str4 != null) {
                i28 = str4.hashCode();
            } else {
                i28 = 0;
            }
            int i96 = (i95 + i28) * 37;
            Integer num3 = this.maxCorners;
            if (num3 != null) {
                i29 = num3.hashCode();
            } else {
                i29 = 0;
            }
            int i97 = (i96 + i29) * 37;
            Integer num4 = this.minDistance;
            if (num4 != null) {
                i36 = num4.hashCode();
            } else {
                i36 = 0;
            }
            int i98 = (i97 + i36) * 37;
            Float f18 = this.highLightThreshold;
            if (f18 != null) {
                i37 = f18.hashCode();
            } else {
                i37 = 0;
            }
            int i99 = (i98 + i37) * 37;
            Float f19 = this.fastNumPercentage;
            if (f19 != null) {
                i38 = f19.hashCode();
            } else {
                i38 = 0;
            }
            int i100 = (i99 + i38) * 37;
            Integer num5 = this.seedNum;
            if (num5 != null) {
                i39 = num5.hashCode();
            } else {
                i39 = 0;
            }
            int i101 = (i100 + i39) * 37;
            Integer num6 = this.clusterDistance;
            if (num6 != null) {
                i46 = num6.hashCode();
            } else {
                i46 = 0;
            }
            int i102 = (i101 + i46) * 37;
            Integer num7 = this.shakeDisPlacement;
            if (num7 != null) {
                i47 = num7.hashCode();
            } else {
                i47 = 0;
            }
            int i103 = (i102 + i47) * 37;
            Integer num8 = this.sleepTime;
            if (num8 != null) {
                i48 = num8.hashCode();
            } else {
                i48 = 0;
            }
            int i104 = (i103 + i48) * 37;
            Integer num9 = this.clusterMaxSize;
            if (num9 != null) {
                i49 = num9.hashCode();
            } else {
                i49 = 0;
            }
            int i105 = (i104 + i49) * 37;
            Boolean bool = this.switchEnvironment;
            if (bool != null) {
                i56 = bool.hashCode();
            } else {
                i56 = 0;
            }
            int hashCode2 = (((i105 + i56) * 37) + this.filePaths.hashCode()) * 37;
            Integer num10 = this.brightness;
            if (num10 != null) {
                i57 = num10.hashCode();
            } else {
                i57 = 0;
            }
            int i106 = (hashCode2 + i57) * 37;
            Integer num11 = this.contrast;
            if (num11 != null) {
                i58 = num11.hashCode();
            } else {
                i58 = 0;
            }
            int i107 = (i106 + i58) * 37;
            Integer num12 = this.hue;
            if (num12 != null) {
                i59 = num12.hashCode();
            } else {
                i59 = 0;
            }
            int i108 = (i107 + i59) * 37;
            Integer num13 = this.highlights;
            if (num13 != null) {
                i65 = num13.hashCode();
            } else {
                i65 = 0;
            }
            int i109 = (i108 + i65) * 37;
            Integer num14 = this.sharpness;
            if (num14 != null) {
                i66 = num14.hashCode();
            } else {
                i66 = 0;
            }
            int i110 = (i109 + i66) * 37;
            Integer num15 = this.shadows;
            if (num15 != null) {
                i67 = num15.hashCode();
            } else {
                i67 = 0;
            }
            int i111 = (i110 + i67) * 37;
            Integer num16 = this.saturation;
            if (num16 != null) {
                i68 = num16.hashCode();
            } else {
                i68 = 0;
            }
            int i112 = (i111 + i68) * 37;
            Integer num17 = this.temperature;
            if (num17 != null) {
                i69 = num17.hashCode();
            } else {
                i69 = 0;
            }
            int i113 = (i112 + i69) * 37;
            Integer num18 = this.fade;
            if (num18 != null) {
                i75 = num18.hashCode();
            } else {
                i75 = 0;
            }
            int i114 = (i113 + i75) * 37;
            Integer num19 = this.vignetting;
            if (num19 != null) {
                i76 = num19.hashCode();
            } else {
                i76 = 0;
            }
            int i115 = (i114 + i76) * 37;
            Integer num20 = this.pitu_mode;
            if (num20 != null) {
                i78 = num20.hashCode();
            }
            int i116 = i115 + i78;
            this.hashCode = i116;
            return i116;
        }
        return i77;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        if (this.effectType != null) {
            arrayList.add("effectType=" + Internal.sanitize(this.effectType));
        }
        if (this.subEffectType != null) {
            arrayList.add("subEffectType=" + Internal.sanitize(this.subEffectType));
        }
        if (this.kiraEffectType != null) {
            arrayList.add("kiraEffectType=" + Internal.sanitize(this.kiraEffectType));
        }
        if (this.effectStrength != null) {
            arrayList.add("effectStrength=" + this.effectStrength);
        }
        if (this.starMaxScale != null) {
            arrayList.add("starMaxScale=" + this.starMaxScale);
        }
        if (this.starMinScale != null) {
            arrayList.add("starMinScale=" + this.starMinScale);
        }
        if (this.starScalePeriod != null) {
            arrayList.add("starScalePeriod=" + this.starScalePeriod);
        }
        if (this.blendMode != null) {
            arrayList.add("blendMode=" + Internal.sanitize(this.blendMode));
        }
        if (this.maxCorners != null) {
            arrayList.add("maxCorners=" + this.maxCorners);
        }
        if (this.minDistance != null) {
            arrayList.add("minDistance=" + this.minDistance);
        }
        if (this.highLightThreshold != null) {
            arrayList.add("highLightThreshold=" + this.highLightThreshold);
        }
        if (this.fastNumPercentage != null) {
            arrayList.add("fastNumPercentage=" + this.fastNumPercentage);
        }
        if (this.seedNum != null) {
            arrayList.add("seedNum=" + this.seedNum);
        }
        if (this.clusterDistance != null) {
            arrayList.add("clusterDistance=" + this.clusterDistance);
        }
        if (this.shakeDisPlacement != null) {
            arrayList.add("shakeDisPlacement=" + this.shakeDisPlacement);
        }
        if (this.sleepTime != null) {
            arrayList.add("sleepTime=" + this.sleepTime);
        }
        if (this.clusterMaxSize != null) {
            arrayList.add("clusterMaxSize=" + this.clusterMaxSize);
        }
        if (this.switchEnvironment != null) {
            arrayList.add("switchEnvironment=" + this.switchEnvironment);
        }
        if (!this.filePaths.isEmpty()) {
            arrayList.add("filePaths=" + Internal.sanitize(this.filePaths));
        }
        if (this.brightness != null) {
            arrayList.add("brightness=" + this.brightness);
        }
        if (this.contrast != null) {
            arrayList.add("contrast=" + this.contrast);
        }
        if (this.hue != null) {
            arrayList.add("hue=" + this.hue);
        }
        if (this.highlights != null) {
            arrayList.add("highlights=" + this.highlights);
        }
        if (this.sharpness != null) {
            arrayList.add("sharpness=" + this.sharpness);
        }
        if (this.shadows != null) {
            arrayList.add("shadows=" + this.shadows);
        }
        if (this.saturation != null) {
            arrayList.add("saturation=" + this.saturation);
        }
        if (this.temperature != null) {
            arrayList.add("temperature=" + this.temperature);
        }
        if (this.fade != null) {
            arrayList.add("fade=" + this.fade);
        }
        if (this.vignetting != null) {
            arrayList.add("vignetting=" + this.vignetting);
        }
        if (this.pitu_mode != null) {
            arrayList.add("pitu_mode=" + this.pitu_mode);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "PostEffectOptions{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ PostEffectOptions(String str, String str2, String str3, Integer num, Float f16, Float f17, Integer num2, String str4, Integer num3, Integer num4, Float f18, Float f19, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Boolean bool, List list, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Integer num17, Integer num18, Integer num19, Integer num20, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : num, (i3 & 16) != 0 ? null : f16, (i3 & 32) != 0 ? null : f17, (i3 & 64) != 0 ? null : num2, (i3 & 128) != 0 ? null : str4, (i3 & 256) != 0 ? null : num3, (i3 & 512) != 0 ? null : num4, (i3 & 1024) != 0 ? null : f18, (i3 & 2048) != 0 ? null : f19, (i3 & 4096) != 0 ? null : num5, (i3 & 8192) != 0 ? null : num6, (i3 & 16384) != 0 ? null : num7, (i3 & 32768) != 0 ? null : num8, (i3 & 65536) != 0 ? null : num9, (i3 & 131072) != 0 ? null : bool, (i3 & 262144) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 524288) != 0 ? null : num10, (i3 & 1048576) != 0 ? null : num11, (i3 & 2097152) != 0 ? null : num12, (i3 & 4194304) != 0 ? null : num13, (i3 & 8388608) != 0 ? null : num14, (i3 & 16777216) != 0 ? null : num15, (i3 & 33554432) != 0 ? null : num16, (i3 & 67108864) != 0 ? null : num17, (i3 & 134217728) != 0 ? null : num18, (i3 & 268435456) != 0 ? null : num19, (i3 & 536870912) != 0 ? null : num20, (i3 & 1073741824) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.effectType = this.effectType;
        builder.subEffectType = this.subEffectType;
        builder.kiraEffectType = this.kiraEffectType;
        builder.effectStrength = this.effectStrength;
        builder.starMaxScale = this.starMaxScale;
        builder.starMinScale = this.starMinScale;
        builder.starScalePeriod = this.starScalePeriod;
        builder.blendMode = this.blendMode;
        builder.maxCorners = this.maxCorners;
        builder.minDistance = this.minDistance;
        builder.highLightThreshold = this.highLightThreshold;
        builder.fastNumPercentage = this.fastNumPercentage;
        builder.seedNum = this.seedNum;
        builder.clusterDistance = this.clusterDistance;
        builder.shakeDisPlacement = this.shakeDisPlacement;
        builder.sleepTime = this.sleepTime;
        builder.clusterMaxSize = this.clusterMaxSize;
        builder.switchEnvironment = this.switchEnvironment;
        builder.filePaths = this.filePaths;
        builder.brightness = this.brightness;
        builder.contrast = this.contrast;
        builder.hue = this.hue;
        builder.highlights = this.highlights;
        builder.sharpness = this.sharpness;
        builder.shadows = this.shadows;
        builder.saturation = this.saturation;
        builder.temperature = this.temperature;
        builder.fade = this.fade;
        builder.vignetting = this.vignetting;
        builder.pitu_mode = this.pitu_mode;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostEffectOptions(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable Float f16, @Nullable Float f17, @Nullable Integer num2, @Nullable String str4, @Nullable Integer num3, @Nullable Integer num4, @Nullable Float f18, @Nullable Float f19, @Nullable Integer num5, @Nullable Integer num6, @Nullable Integer num7, @Nullable Integer num8, @Nullable Integer num9, @Nullable Boolean bool, @NotNull List<String> filePaths, @Nullable Integer num10, @Nullable Integer num11, @Nullable Integer num12, @Nullable Integer num13, @Nullable Integer num14, @Nullable Integer num15, @Nullable Integer num16, @Nullable Integer num17, @Nullable Integer num18, @Nullable Integer num19, @Nullable Integer num20, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(filePaths, "filePaths");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
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
}
