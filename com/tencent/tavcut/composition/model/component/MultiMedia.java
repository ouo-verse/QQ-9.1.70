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
import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.hippy.qq.view.pag.HippyQQPagViewController;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.tavcut.composition.model.component.MultiMedia;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
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

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 12\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003012B\u00a7\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\"\u001a\u00020#\u00a2\u0006\u0002\u0010$J\u00ad\u0002\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\"\u001a\u00020#\u00a2\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010,H\u0096\u0002J\b\u0010-\u001a\u00020\u0004H\u0016J\b\u0010.\u001a\u00020\u0002H\u0016J\b\u0010/\u001a\u00020\tH\u0016R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010%R\u0012\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010%R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010&R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010%R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010'R\u0012\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010&R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010%R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010%R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010%R\u0014\u0010 \u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010%R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010%R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010'R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010%R\u0014\u0010!\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010&R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010'R\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/MultiMedia;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/MultiMedia$Builder;", TemplateParser.KEY_ENTITY_ID, "", TemplateParser.KEY_COMPONENT_ID, NodeProps.ENABLED, "", "type", "", "fillScale", "", JsonUtils.KEY_IMAGE_DURATIONS, "Lcom/tencent/tavcut/composition/model/component/MultiMedia$ImageDuration;", "imageEffect", "key", "maxSourceCount", "minDuration", "minSourceCount", HippyQQPagViewController.PropertyName.SCALE_MODE, "size", "Lcom/tencent/tavcut/composition/model/component/Size;", "speed", "src", "version", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "backgroundColor", "backgroundFillMode", JsonUtils.KEY_VOLUME_EFFECTS, "", "Lcom/tencent/tavcut/composition/model/component/VolumeEffect;", "backgroundPagPath", "resLoopCount", "visibleWhileOverTime", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Float;Lcom/tencent/tavcut/composition/model/component/MultiMedia$ImageDuration;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tencent/tavcut/composition/model/component/Size;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "Ljava/lang/Float;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Float;Lcom/tencent/tavcut/composition/model/component/MultiMedia$ImageDuration;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tencent/tavcut/composition/model/component/Size;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/MultiMedia;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "ImageDuration", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class MultiMedia extends AndroidMessage<MultiMedia, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<MultiMedia> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<MultiMedia> CREATOR;
    public static final int DEFAULT_BACKGROUNDFILLMODE = 1;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 18)
    @JvmField
    @Nullable
    public final String backgroundColor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 19)
    @JvmField
    @Nullable
    public final Integer backgroundFillMode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 21)
    @JvmField
    @Nullable
    public final String backgroundPagPath;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @JvmField
    @Nullable
    public final Integer componentID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 3)
    @JvmField
    @Nullable
    public final Boolean enabled;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @JvmField
    @Nullable
    public final Integer entityId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 5)
    @JvmField
    @Nullable
    public final Float fillScale;

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.MultiMedia$ImageDuration#ADAPTER", tag = 6)
    @JvmField
    @Nullable
    public final ImageDuration imageDurations;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 7)
    @JvmField
    @Nullable
    public final Boolean imageEffect;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    @JvmField
    @Nullable
    public final String key;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    @JvmField
    @Nullable
    public final Integer maxSourceCount;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 10)
    @JvmField
    @Nullable
    public final Integer minDuration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 11)
    @JvmField
    @Nullable
    public final Integer minSourceCount;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 22)
    @JvmField
    @Nullable
    public final Integer resLoopCount;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 12)
    @JvmField
    @Nullable
    public final Integer scaleMode;

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.Size#ADAPTER", tag = 13)
    @JvmField
    @Nullable
    public final Size size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 14)
    @JvmField
    @Nullable
    public final Float speed;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 15)
    @JvmField
    @Nullable
    public final String src;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @JvmField
    @Nullable
    public final String type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 16)
    @JvmField
    @Nullable
    public final Integer version;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 23)
    @JvmField
    @Nullable
    public final Boolean visibleWhileOverTime;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 17)
    @JvmField
    @Nullable
    public final Float volume;

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.VolumeEffect#ADAPTER", label = WireField.Label.REPEATED, tag = 20)
    @JvmField
    @NotNull
    public final List<VolumeEffect> volumeEffects;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010&J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\b\u0010'\u001a\u00020\u0002H\u0016J\u0015\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010&J\u0015\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010(J\u0015\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010&J\u0015\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010)J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0015\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010(J\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\u0016\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010&J\u0015\u0010\u0017\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010&J\u0015\u0010\u0018\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010&J\u0015\u0010\u0019\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010&J\u0015\u0010\u001a\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010&J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0015\u0010\u001d\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010)J\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005J\u0015\u0010 \u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010&J\u0015\u0010!\u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010(J\u0015\u0010\"\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010)J\u0014\u0010#\u001a\u00020\u00002\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0011R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0011R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010 \u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010!\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\"\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0011R\u0018\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/MultiMedia$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/MultiMedia;", "()V", "backgroundColor", "", "backgroundFillMode", "", "Ljava/lang/Integer;", "backgroundPagPath", TemplateParser.KEY_COMPONENT_ID, NodeProps.ENABLED, "", "Ljava/lang/Boolean;", TemplateParser.KEY_ENTITY_ID, "fillScale", "", "Ljava/lang/Float;", JsonUtils.KEY_IMAGE_DURATIONS, "Lcom/tencent/tavcut/composition/model/component/MultiMedia$ImageDuration;", "imageEffect", "key", "maxSourceCount", "minDuration", "minSourceCount", "resLoopCount", HippyQQPagViewController.PropertyName.SCALE_MODE, "size", "Lcom/tencent/tavcut/composition/model/component/Size;", "speed", "src", "type", "version", "visibleWhileOverTime", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, JsonUtils.KEY_VOLUME_EFFECTS, "", "Lcom/tencent/tavcut/composition/model/component/VolumeEffect;", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/MultiMedia$Builder;", "build", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/MultiMedia$Builder;", "(Ljava/lang/Float;)Lcom/tencent/tavcut/composition/model/component/MultiMedia$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<MultiMedia, Builder> {

        @JvmField
        @Nullable
        public String backgroundColor;

        @JvmField
        @Nullable
        public Integer backgroundFillMode;

        @JvmField
        @Nullable
        public String backgroundPagPath;

        @JvmField
        @Nullable
        public Integer componentID;

        @JvmField
        @Nullable
        public Boolean enabled;

        @JvmField
        @Nullable
        public Integer entityId;

        @JvmField
        @Nullable
        public Float fillScale;

        @JvmField
        @Nullable
        public ImageDuration imageDurations;

        @JvmField
        @Nullable
        public Boolean imageEffect;

        @JvmField
        @Nullable
        public String key;

        @JvmField
        @Nullable
        public Integer maxSourceCount;

        @JvmField
        @Nullable
        public Integer minDuration;

        @JvmField
        @Nullable
        public Integer minSourceCount;

        @JvmField
        @Nullable
        public Integer resLoopCount;

        @JvmField
        @Nullable
        public Integer scaleMode;

        @JvmField
        @Nullable
        public Size size;

        @JvmField
        @Nullable
        public Float speed;

        @JvmField
        @Nullable
        public String src;

        @JvmField
        @Nullable
        public String type;

        @JvmField
        @Nullable
        public Integer version;

        @JvmField
        @Nullable
        public Boolean visibleWhileOverTime;

        @JvmField
        @Nullable
        public Float volume;

        @JvmField
        @NotNull
        public List<VolumeEffect> volumeEffects;

        public Builder() {
            List<VolumeEffect> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.volumeEffects = emptyList;
        }

        @NotNull
        public final Builder backgroundColor(@Nullable String backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        @NotNull
        public final Builder backgroundFillMode(@Nullable Integer backgroundFillMode) {
            this.backgroundFillMode = backgroundFillMode;
            return this;
        }

        @NotNull
        public final Builder backgroundPagPath(@Nullable String backgroundPagPath) {
            this.backgroundPagPath = backgroundPagPath;
            return this;
        }

        @NotNull
        public final Builder componentID(@Nullable Integer componentID) {
            this.componentID = componentID;
            return this;
        }

        @NotNull
        public final Builder enabled(@Nullable Boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        @NotNull
        public final Builder entityId(@Nullable Integer entityId) {
            this.entityId = entityId;
            return this;
        }

        @NotNull
        public final Builder fillScale(@Nullable Float fillScale) {
            this.fillScale = fillScale;
            return this;
        }

        @NotNull
        public final Builder imageDurations(@Nullable ImageDuration imageDurations) {
            this.imageDurations = imageDurations;
            return this;
        }

        @NotNull
        public final Builder imageEffect(@Nullable Boolean imageEffect) {
            this.imageEffect = imageEffect;
            return this;
        }

        @NotNull
        public final Builder key(@Nullable String key) {
            this.key = key;
            return this;
        }

        @NotNull
        public final Builder maxSourceCount(@Nullable Integer maxSourceCount) {
            this.maxSourceCount = maxSourceCount;
            return this;
        }

        @NotNull
        public final Builder minDuration(@Nullable Integer minDuration) {
            this.minDuration = minDuration;
            return this;
        }

        @NotNull
        public final Builder minSourceCount(@Nullable Integer minSourceCount) {
            this.minSourceCount = minSourceCount;
            return this;
        }

        @NotNull
        public final Builder resLoopCount(@Nullable Integer resLoopCount) {
            this.resLoopCount = resLoopCount;
            return this;
        }

        @NotNull
        public final Builder scaleMode(@Nullable Integer scaleMode) {
            this.scaleMode = scaleMode;
            return this;
        }

        @NotNull
        public final Builder size(@Nullable Size size) {
            this.size = size;
            return this;
        }

        @NotNull
        public final Builder speed(@Nullable Float speed) {
            this.speed = speed;
            return this;
        }

        @NotNull
        public final Builder src(@Nullable String src) {
            this.src = src;
            return this;
        }

        @NotNull
        public final Builder type(@Nullable String type) {
            this.type = type;
            return this;
        }

        @NotNull
        public final Builder version(@Nullable Integer version) {
            this.version = version;
            return this;
        }

        @NotNull
        public final Builder visibleWhileOverTime(@Nullable Boolean visibleWhileOverTime) {
            this.visibleWhileOverTime = visibleWhileOverTime;
            return this;
        }

        @NotNull
        public final Builder volume(@Nullable Float volume) {
            this.volume = volume;
            return this;
        }

        @NotNull
        public final Builder volumeEffects(@NotNull List<VolumeEffect> volumeEffects) {
            Intrinsics.checkParameterIsNotNull(volumeEffects, "volumeEffects");
            Internal.checkElementsNotNull(volumeEffects);
            this.volumeEffects = volumeEffects;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public MultiMedia build() {
            return new MultiMedia(this.entityId, this.componentID, this.enabled, this.type, this.fillScale, this.imageDurations, this.imageEffect, this.key, this.maxSourceCount, this.minDuration, this.minSourceCount, this.scaleMode, this.size, this.speed, this.src, this.version, this.volume, this.backgroundColor, this.backgroundFillMode, this.volumeEffects, this.backgroundPagPath, this.resLoopCount, this.visibleWhileOverTime, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B'\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ-\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\t\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/MultiMedia$ImageDuration;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/MultiMedia$ImageDuration$Builder;", "maxDuration", "", "minDuration", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/MultiMedia$ImageDuration;", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class ImageDuration extends AndroidMessage<ImageDuration, Builder> {

        @JvmField
        @NotNull
        public static final ProtoAdapter<ImageDuration> ADAPTER;

        @JvmField
        @NotNull
        public static final Parcelable.Creator<ImageDuration> CREATOR;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
        @JvmField
        @Nullable
        public final Integer maxDuration;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
        @JvmField
        @Nullable
        public final Integer minDuration;

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0015\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\tJ\u0015\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/MultiMedia$ImageDuration$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/MultiMedia$ImageDuration;", "()V", "maxDuration", "", "Ljava/lang/Integer;", "minDuration", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/MultiMedia$ImageDuration$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
        /* loaded from: classes26.dex */
        public static final class Builder extends Message.Builder<ImageDuration, Builder> {

            @JvmField
            @Nullable
            public Integer maxDuration;

            @JvmField
            @Nullable
            public Integer minDuration;

            @NotNull
            public final Builder maxDuration(@Nullable Integer maxDuration) {
                this.maxDuration = maxDuration;
                return this;
            }

            @NotNull
            public final Builder minDuration(@Nullable Integer minDuration) {
                this.minDuration = minDuration;
                return this;
            }

            @Override // com.squareup.wire.Message.Builder
            @NotNull
            public ImageDuration build() {
                return new ImageDuration(this.maxDuration, this.minDuration, buildUnknownFields());
            }
        }

        static {
            final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
            final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ImageDuration.class);
            final String str = "type.googleapis.com/publisher.MultiMedia.ImageDuration";
            ProtoAdapter<ImageDuration> protoAdapter = new ProtoAdapter<ImageDuration>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.MultiMedia$ImageDuration$Companion$ADAPTER$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                @NotNull
                public MultiMedia.ImageDuration decode(@NotNull ProtoReader reader) {
                    Intrinsics.checkParameterIsNotNull(reader, "reader");
                    long beginMessage = reader.beginMessage();
                    Integer num = null;
                    Integer num2 = null;
                    while (true) {
                        int nextTag = reader.nextTag();
                        if (nextTag == -1) {
                            return new MultiMedia.ImageDuration(num, num2, reader.endMessageAndGetUnknownFields(beginMessage));
                        }
                        if (nextTag == 1) {
                            num = ProtoAdapter.INT32.decode(reader);
                        } else if (nextTag != 2) {
                            reader.readUnknownField(nextTag);
                        } else {
                            num2 = ProtoAdapter.INT32.decode(reader);
                        }
                    }
                }

                @Override // com.squareup.wire.ProtoAdapter
                public void encode(@NotNull ProtoWriter writer, @NotNull MultiMedia.ImageDuration value) {
                    Intrinsics.checkParameterIsNotNull(writer, "writer");
                    Intrinsics.checkParameterIsNotNull(value, "value");
                    ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                    protoAdapter2.encodeWithTag(writer, 1, value.maxDuration);
                    protoAdapter2.encodeWithTag(writer, 2, value.minDuration);
                    writer.writeBytes(value.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public int encodedSize(@NotNull MultiMedia.ImageDuration value) {
                    Intrinsics.checkParameterIsNotNull(value, "value");
                    ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                    return protoAdapter2.encodedSizeWithTag(1, value.maxDuration) + protoAdapter2.encodedSizeWithTag(2, value.minDuration) + value.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                @NotNull
                public MultiMedia.ImageDuration redact(@NotNull MultiMedia.ImageDuration value) {
                    Intrinsics.checkParameterIsNotNull(value, "value");
                    return MultiMedia.ImageDuration.copy$default(value, null, null, ByteString.EMPTY, 3, null);
                }
            };
            ADAPTER = protoAdapter;
            CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
        }

        public ImageDuration() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ ImageDuration copy$default(ImageDuration imageDuration, Integer num, Integer num2, ByteString byteString, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                num = imageDuration.maxDuration;
            }
            if ((i3 & 2) != 0) {
                num2 = imageDuration.minDuration;
            }
            if ((i3 & 4) != 0) {
                byteString = imageDuration.unknownFields();
            }
            return imageDuration.copy(num, num2, byteString);
        }

        @NotNull
        public final ImageDuration copy(@Nullable Integer maxDuration, @Nullable Integer minDuration, @NotNull ByteString unknownFields) {
            Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
            return new ImageDuration(maxDuration, minDuration, unknownFields);
        }

        public boolean equals(@Nullable Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof ImageDuration)) {
                return false;
            }
            ImageDuration imageDuration = (ImageDuration) other;
            if (Intrinsics.areEqual(unknownFields(), imageDuration.unknownFields()) && Intrinsics.areEqual(this.maxDuration, imageDuration.maxDuration) && Intrinsics.areEqual(this.minDuration, imageDuration.minDuration)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i3;
            int i16 = this.hashCode;
            if (i16 == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                Integer num = this.maxDuration;
                int i17 = 0;
                if (num != null) {
                    i3 = num.hashCode();
                } else {
                    i3 = 0;
                }
                int i18 = (hashCode + i3) * 37;
                Integer num2 = this.minDuration;
                if (num2 != null) {
                    i17 = num2.hashCode();
                }
                int i19 = i18 + i17;
                this.hashCode = i19;
                return i19;
            }
            return i16;
        }

        @Override // com.squareup.wire.Message
        @NotNull
        public String toString() {
            String joinToString$default;
            ArrayList arrayList = new ArrayList();
            if (this.maxDuration != null) {
                arrayList.add("maxDuration=" + this.maxDuration);
            }
            if (this.minDuration != null) {
                arrayList.add("minDuration=" + this.minDuration);
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "ImageDuration{", "}", 0, null, null, 56, null);
            return joinToString$default;
        }

        public /* synthetic */ ImageDuration(Integer num, Integer num2, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : num2, (i3 & 4) != 0 ? ByteString.EMPTY : byteString);
        }

        @Override // com.squareup.wire.Message
        @NotNull
        public Builder newBuilder() {
            Builder builder = new Builder();
            builder.maxDuration = this.maxDuration;
            builder.minDuration = this.minDuration;
            builder.addUnknownFields(unknownFields());
            return builder;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImageDuration(@Nullable Integer num, @Nullable Integer num2, @NotNull ByteString unknownFields) {
            super(ADAPTER, unknownFields);
            Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
            this.maxDuration = num;
            this.minDuration = num2;
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiMedia.class);
        final String str = "type.googleapis.com/publisher.MultiMedia";
        ProtoAdapter<MultiMedia> protoAdapter = new ProtoAdapter<MultiMedia>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.MultiMedia$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public MultiMedia decode(@NotNull ProtoReader reader) {
                ArrayList arrayList;
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                ArrayList arrayList2 = new ArrayList();
                long beginMessage = reader.beginMessage();
                Integer num = null;
                ArrayList arrayList3 = arrayList2;
                Integer num2 = null;
                Boolean bool = null;
                String str2 = null;
                Float f16 = null;
                MultiMedia.ImageDuration imageDuration = null;
                Boolean bool2 = null;
                String str3 = null;
                Integer num3 = null;
                Integer num4 = null;
                Integer num5 = null;
                Integer num6 = null;
                Size size = null;
                Float f17 = null;
                String str4 = null;
                Integer num7 = null;
                Float f18 = null;
                String str5 = null;
                Integer num8 = null;
                String str6 = null;
                Integer num9 = null;
                Boolean bool3 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    Integer num10 = num6;
                    if (nextTag == -1) {
                        return new MultiMedia(num, num2, bool, str2, f16, imageDuration, bool2, str3, num3, num4, num5, num10, size, f17, str4, num7, f18, str5, num8, arrayList3, str6, num9, bool3, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                    switch (nextTag) {
                        case 1:
                            arrayList = arrayList3;
                            num = ProtoAdapter.INT32.decode(reader);
                            continue;
                        case 2:
                            arrayList = arrayList3;
                            num2 = ProtoAdapter.INT32.decode(reader);
                            continue;
                        case 3:
                            arrayList = arrayList3;
                            bool = ProtoAdapter.BOOL.decode(reader);
                            continue;
                        case 4:
                            arrayList = arrayList3;
                            str2 = ProtoAdapter.STRING.decode(reader);
                            continue;
                        case 5:
                            arrayList = arrayList3;
                            f16 = ProtoAdapter.FLOAT.decode(reader);
                            continue;
                        case 6:
                            arrayList = arrayList3;
                            imageDuration = MultiMedia.ImageDuration.ADAPTER.decode(reader);
                            continue;
                        case 7:
                            arrayList = arrayList3;
                            bool2 = ProtoAdapter.BOOL.decode(reader);
                            continue;
                        case 8:
                            arrayList = arrayList3;
                            str3 = ProtoAdapter.STRING.decode(reader);
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
                            num5 = ProtoAdapter.INT32.decode(reader);
                            continue;
                        case 12:
                            arrayList = arrayList3;
                            num10 = ProtoAdapter.INT32.decode(reader);
                            continue;
                        case 13:
                            arrayList = arrayList3;
                            size = Size.ADAPTER.decode(reader);
                            continue;
                        case 14:
                            arrayList = arrayList3;
                            f17 = ProtoAdapter.FLOAT.decode(reader);
                            continue;
                        case 15:
                            arrayList = arrayList3;
                            str4 = ProtoAdapter.STRING.decode(reader);
                            continue;
                        case 16:
                            arrayList = arrayList3;
                            num7 = ProtoAdapter.INT32.decode(reader);
                            continue;
                        case 17:
                            arrayList = arrayList3;
                            f18 = ProtoAdapter.FLOAT.decode(reader);
                            continue;
                        case 18:
                            arrayList = arrayList3;
                            str5 = ProtoAdapter.STRING.decode(reader);
                            continue;
                        case 19:
                            arrayList = arrayList3;
                            num8 = ProtoAdapter.INT32.decode(reader);
                            continue;
                        case 20:
                            arrayList = arrayList3;
                            arrayList.add(VolumeEffect.ADAPTER.decode(reader));
                            continue;
                        case 21:
                            str6 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 22:
                            num9 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 23:
                            bool3 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        default:
                            arrayList = arrayList3;
                            reader.readUnknownField(nextTag);
                            continue;
                    }
                    arrayList = arrayList3;
                    arrayList3 = arrayList;
                    num6 = num10;
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull MultiMedia value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                protoAdapter2.encodeWithTag(writer, 1, value.entityId);
                protoAdapter2.encodeWithTag(writer, 2, value.componentID);
                ProtoAdapter<Boolean> protoAdapter3 = ProtoAdapter.BOOL;
                protoAdapter3.encodeWithTag(writer, 3, value.enabled);
                ProtoAdapter<String> protoAdapter4 = ProtoAdapter.STRING;
                protoAdapter4.encodeWithTag(writer, 4, value.type);
                ProtoAdapter<Float> protoAdapter5 = ProtoAdapter.FLOAT;
                protoAdapter5.encodeWithTag(writer, 5, value.fillScale);
                MultiMedia.ImageDuration.ADAPTER.encodeWithTag(writer, 6, value.imageDurations);
                protoAdapter3.encodeWithTag(writer, 7, value.imageEffect);
                protoAdapter4.encodeWithTag(writer, 8, value.key);
                protoAdapter2.encodeWithTag(writer, 9, value.maxSourceCount);
                protoAdapter2.encodeWithTag(writer, 10, value.minDuration);
                protoAdapter2.encodeWithTag(writer, 11, value.minSourceCount);
                protoAdapter2.encodeWithTag(writer, 12, value.scaleMode);
                Size.ADAPTER.encodeWithTag(writer, 13, value.size);
                protoAdapter5.encodeWithTag(writer, 14, value.speed);
                protoAdapter4.encodeWithTag(writer, 15, value.src);
                protoAdapter2.encodeWithTag(writer, 16, value.version);
                protoAdapter5.encodeWithTag(writer, 17, value.volume);
                protoAdapter4.encodeWithTag(writer, 18, value.backgroundColor);
                protoAdapter2.encodeWithTag(writer, 19, value.backgroundFillMode);
                VolumeEffect.ADAPTER.asRepeated().encodeWithTag(writer, 20, value.volumeEffects);
                protoAdapter4.encodeWithTag(writer, 21, value.backgroundPagPath);
                protoAdapter2.encodeWithTag(writer, 22, value.resLoopCount);
                protoAdapter3.encodeWithTag(writer, 23, value.visibleWhileOverTime);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull MultiMedia value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.entityId) + protoAdapter2.encodedSizeWithTag(2, value.componentID);
                ProtoAdapter<Boolean> protoAdapter3 = ProtoAdapter.BOOL;
                int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(3, value.enabled);
                ProtoAdapter<String> protoAdapter4 = ProtoAdapter.STRING;
                int encodedSizeWithTag3 = encodedSizeWithTag2 + protoAdapter4.encodedSizeWithTag(4, value.type);
                ProtoAdapter<Float> protoAdapter5 = ProtoAdapter.FLOAT;
                return encodedSizeWithTag3 + protoAdapter5.encodedSizeWithTag(5, value.fillScale) + MultiMedia.ImageDuration.ADAPTER.encodedSizeWithTag(6, value.imageDurations) + protoAdapter3.encodedSizeWithTag(7, value.imageEffect) + protoAdapter4.encodedSizeWithTag(8, value.key) + protoAdapter2.encodedSizeWithTag(9, value.maxSourceCount) + protoAdapter2.encodedSizeWithTag(10, value.minDuration) + protoAdapter2.encodedSizeWithTag(11, value.minSourceCount) + protoAdapter2.encodedSizeWithTag(12, value.scaleMode) + Size.ADAPTER.encodedSizeWithTag(13, value.size) + protoAdapter5.encodedSizeWithTag(14, value.speed) + protoAdapter4.encodedSizeWithTag(15, value.src) + protoAdapter2.encodedSizeWithTag(16, value.version) + protoAdapter5.encodedSizeWithTag(17, value.volume) + protoAdapter4.encodedSizeWithTag(18, value.backgroundColor) + protoAdapter2.encodedSizeWithTag(19, value.backgroundFillMode) + VolumeEffect.ADAPTER.asRepeated().encodedSizeWithTag(20, value.volumeEffects) + protoAdapter4.encodedSizeWithTag(21, value.backgroundPagPath) + protoAdapter2.encodedSizeWithTag(22, value.resLoopCount) + protoAdapter3.encodedSizeWithTag(23, value.visibleWhileOverTime) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public MultiMedia redact(@NotNull MultiMedia value) {
                MultiMedia copy;
                Intrinsics.checkParameterIsNotNull(value, "value");
                MultiMedia.ImageDuration imageDuration = value.imageDurations;
                MultiMedia.ImageDuration redact = imageDuration != null ? MultiMedia.ImageDuration.ADAPTER.redact(imageDuration) : null;
                Size size = value.size;
                copy = value.copy((r42 & 1) != 0 ? value.entityId : null, (r42 & 2) != 0 ? value.componentID : null, (r42 & 4) != 0 ? value.enabled : null, (r42 & 8) != 0 ? value.type : null, (r42 & 16) != 0 ? value.fillScale : null, (r42 & 32) != 0 ? value.imageDurations : redact, (r42 & 64) != 0 ? value.imageEffect : null, (r42 & 128) != 0 ? value.key : null, (r42 & 256) != 0 ? value.maxSourceCount : null, (r42 & 512) != 0 ? value.minDuration : null, (r42 & 1024) != 0 ? value.minSourceCount : null, (r42 & 2048) != 0 ? value.scaleMode : null, (r42 & 4096) != 0 ? value.size : size != null ? Size.ADAPTER.redact(size) : null, (r42 & 8192) != 0 ? value.speed : null, (r42 & 16384) != 0 ? value.src : null, (r42 & 32768) != 0 ? value.version : null, (r42 & 65536) != 0 ? value.volume : null, (r42 & 131072) != 0 ? value.backgroundColor : null, (r42 & 262144) != 0 ? value.backgroundFillMode : null, (r42 & 524288) != 0 ? value.volumeEffects : Internal.m87redactElements(value.volumeEffects, VolumeEffect.ADAPTER), (r42 & 1048576) != 0 ? value.backgroundPagPath : null, (r42 & 2097152) != 0 ? value.resLoopCount : null, (r42 & 4194304) != 0 ? value.visibleWhileOverTime : null, (r42 & 8388608) != 0 ? value.unknownFields() : ByteString.EMPTY);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public MultiMedia() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16777215, null);
    }

    @NotNull
    public final MultiMedia copy(@Nullable Integer entityId, @Nullable Integer componentID, @Nullable Boolean enabled, @Nullable String type, @Nullable Float fillScale, @Nullable ImageDuration imageDurations, @Nullable Boolean imageEffect, @Nullable String key, @Nullable Integer maxSourceCount, @Nullable Integer minDuration, @Nullable Integer minSourceCount, @Nullable Integer scaleMode, @Nullable Size size, @Nullable Float speed, @Nullable String src, @Nullable Integer version, @Nullable Float volume, @Nullable String backgroundColor, @Nullable Integer backgroundFillMode, @NotNull List<VolumeEffect> volumeEffects, @Nullable String backgroundPagPath, @Nullable Integer resLoopCount, @Nullable Boolean visibleWhileOverTime, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(volumeEffects, "volumeEffects");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new MultiMedia(entityId, componentID, enabled, type, fillScale, imageDurations, imageEffect, key, maxSourceCount, minDuration, minSourceCount, scaleMode, size, speed, src, version, volume, backgroundColor, backgroundFillMode, volumeEffects, backgroundPagPath, resLoopCount, visibleWhileOverTime, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof MultiMedia)) {
            return false;
        }
        MultiMedia multiMedia = (MultiMedia) other;
        if (Intrinsics.areEqual(unknownFields(), multiMedia.unknownFields()) && Intrinsics.areEqual(this.entityId, multiMedia.entityId) && Intrinsics.areEqual(this.componentID, multiMedia.componentID) && Intrinsics.areEqual(this.enabled, multiMedia.enabled) && Intrinsics.areEqual(this.type, multiMedia.type) && Intrinsics.areEqual(this.fillScale, multiMedia.fillScale) && Intrinsics.areEqual(this.imageDurations, multiMedia.imageDurations) && Intrinsics.areEqual(this.imageEffect, multiMedia.imageEffect) && Intrinsics.areEqual(this.key, multiMedia.key) && Intrinsics.areEqual(this.maxSourceCount, multiMedia.maxSourceCount) && Intrinsics.areEqual(this.minDuration, multiMedia.minDuration) && Intrinsics.areEqual(this.minSourceCount, multiMedia.minSourceCount) && Intrinsics.areEqual(this.scaleMode, multiMedia.scaleMode) && Intrinsics.areEqual(this.size, multiMedia.size) && Intrinsics.areEqual(this.speed, multiMedia.speed) && Intrinsics.areEqual(this.src, multiMedia.src) && Intrinsics.areEqual(this.version, multiMedia.version) && Intrinsics.areEqual(this.volume, multiMedia.volume) && Intrinsics.areEqual(this.backgroundColor, multiMedia.backgroundColor) && Intrinsics.areEqual(this.backgroundFillMode, multiMedia.backgroundFillMode) && Intrinsics.areEqual(this.volumeEffects, multiMedia.volumeEffects) && Intrinsics.areEqual(this.backgroundPagPath, multiMedia.backgroundPagPath) && Intrinsics.areEqual(this.resLoopCount, multiMedia.resLoopCount) && Intrinsics.areEqual(this.visibleWhileOverTime, multiMedia.visibleWhileOverTime)) {
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
        int i65 = this.hashCode;
        if (i65 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Integer num = this.entityId;
            int i66 = 0;
            if (num != null) {
                i3 = num.hashCode();
            } else {
                i3 = 0;
            }
            int i67 = (hashCode + i3) * 37;
            Integer num2 = this.componentID;
            if (num2 != null) {
                i16 = num2.hashCode();
            } else {
                i16 = 0;
            }
            int i68 = (i67 + i16) * 37;
            Boolean bool = this.enabled;
            if (bool != null) {
                i17 = bool.hashCode();
            } else {
                i17 = 0;
            }
            int i69 = (i68 + i17) * 37;
            String str = this.type;
            if (str != null) {
                i18 = str.hashCode();
            } else {
                i18 = 0;
            }
            int i75 = (i69 + i18) * 37;
            Float f16 = this.fillScale;
            if (f16 != null) {
                i19 = f16.hashCode();
            } else {
                i19 = 0;
            }
            int i76 = (i75 + i19) * 37;
            ImageDuration imageDuration = this.imageDurations;
            if (imageDuration != null) {
                i26 = imageDuration.hashCode();
            } else {
                i26 = 0;
            }
            int i77 = (i76 + i26) * 37;
            Boolean bool2 = this.imageEffect;
            if (bool2 != null) {
                i27 = bool2.hashCode();
            } else {
                i27 = 0;
            }
            int i78 = (i77 + i27) * 37;
            String str2 = this.key;
            if (str2 != null) {
                i28 = str2.hashCode();
            } else {
                i28 = 0;
            }
            int i79 = (i78 + i28) * 37;
            Integer num3 = this.maxSourceCount;
            if (num3 != null) {
                i29 = num3.hashCode();
            } else {
                i29 = 0;
            }
            int i85 = (i79 + i29) * 37;
            Integer num4 = this.minDuration;
            if (num4 != null) {
                i36 = num4.hashCode();
            } else {
                i36 = 0;
            }
            int i86 = (i85 + i36) * 37;
            Integer num5 = this.minSourceCount;
            if (num5 != null) {
                i37 = num5.hashCode();
            } else {
                i37 = 0;
            }
            int i87 = (i86 + i37) * 37;
            Integer num6 = this.scaleMode;
            if (num6 != null) {
                i38 = num6.hashCode();
            } else {
                i38 = 0;
            }
            int i88 = (i87 + i38) * 37;
            Size size = this.size;
            if (size != null) {
                i39 = size.hashCode();
            } else {
                i39 = 0;
            }
            int i89 = (i88 + i39) * 37;
            Float f17 = this.speed;
            if (f17 != null) {
                i46 = f17.hashCode();
            } else {
                i46 = 0;
            }
            int i95 = (i89 + i46) * 37;
            String str3 = this.src;
            if (str3 != null) {
                i47 = str3.hashCode();
            } else {
                i47 = 0;
            }
            int i96 = (i95 + i47) * 37;
            Integer num7 = this.version;
            if (num7 != null) {
                i48 = num7.hashCode();
            } else {
                i48 = 0;
            }
            int i97 = (i96 + i48) * 37;
            Float f18 = this.volume;
            if (f18 != null) {
                i49 = f18.hashCode();
            } else {
                i49 = 0;
            }
            int i98 = (i97 + i49) * 37;
            String str4 = this.backgroundColor;
            if (str4 != null) {
                i56 = str4.hashCode();
            } else {
                i56 = 0;
            }
            int i99 = (i98 + i56) * 37;
            Integer num8 = this.backgroundFillMode;
            if (num8 != null) {
                i57 = num8.hashCode();
            } else {
                i57 = 0;
            }
            int hashCode2 = (((i99 + i57) * 37) + this.volumeEffects.hashCode()) * 37;
            String str5 = this.backgroundPagPath;
            if (str5 != null) {
                i58 = str5.hashCode();
            } else {
                i58 = 0;
            }
            int i100 = (hashCode2 + i58) * 37;
            Integer num9 = this.resLoopCount;
            if (num9 != null) {
                i59 = num9.hashCode();
            } else {
                i59 = 0;
            }
            int i101 = (i100 + i59) * 37;
            Boolean bool3 = this.visibleWhileOverTime;
            if (bool3 != null) {
                i66 = bool3.hashCode();
            }
            int i102 = i101 + i66;
            this.hashCode = i102;
            return i102;
        }
        return i65;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        if (this.entityId != null) {
            arrayList.add("entityId=" + this.entityId);
        }
        if (this.componentID != null) {
            arrayList.add("componentID=" + this.componentID);
        }
        if (this.enabled != null) {
            arrayList.add("enabled=" + this.enabled);
        }
        if (this.type != null) {
            arrayList.add("type=" + Internal.sanitize(this.type));
        }
        if (this.fillScale != null) {
            arrayList.add("fillScale=" + this.fillScale);
        }
        if (this.imageDurations != null) {
            arrayList.add("imageDurations=" + this.imageDurations);
        }
        if (this.imageEffect != null) {
            arrayList.add("imageEffect=" + this.imageEffect);
        }
        if (this.key != null) {
            arrayList.add("key=" + Internal.sanitize(this.key));
        }
        if (this.maxSourceCount != null) {
            arrayList.add("maxSourceCount=" + this.maxSourceCount);
        }
        if (this.minDuration != null) {
            arrayList.add("minDuration=" + this.minDuration);
        }
        if (this.minSourceCount != null) {
            arrayList.add("minSourceCount=" + this.minSourceCount);
        }
        if (this.scaleMode != null) {
            arrayList.add("scaleMode=" + this.scaleMode);
        }
        if (this.size != null) {
            arrayList.add("size=" + this.size);
        }
        if (this.speed != null) {
            arrayList.add("speed=" + this.speed);
        }
        if (this.src != null) {
            arrayList.add("src=" + Internal.sanitize(this.src));
        }
        if (this.version != null) {
            arrayList.add("version=" + this.version);
        }
        if (this.volume != null) {
            arrayList.add("volume=" + this.volume);
        }
        if (this.backgroundColor != null) {
            arrayList.add("backgroundColor=" + Internal.sanitize(this.backgroundColor));
        }
        if (this.backgroundFillMode != null) {
            arrayList.add("backgroundFillMode=" + this.backgroundFillMode);
        }
        if (!this.volumeEffects.isEmpty()) {
            arrayList.add("volumeEffects=" + this.volumeEffects);
        }
        if (this.backgroundPagPath != null) {
            arrayList.add("backgroundPagPath=" + Internal.sanitize(this.backgroundPagPath));
        }
        if (this.resLoopCount != null) {
            arrayList.add("resLoopCount=" + this.resLoopCount);
        }
        if (this.visibleWhileOverTime != null) {
            arrayList.add("visibleWhileOverTime=" + this.visibleWhileOverTime);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "MultiMedia{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ MultiMedia(Integer num, Integer num2, Boolean bool, String str, Float f16, ImageDuration imageDuration, Boolean bool2, String str2, Integer num3, Integer num4, Integer num5, Integer num6, Size size, Float f17, String str3, Integer num7, Float f18, String str4, Integer num8, List list, String str5, Integer num9, Boolean bool3, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : num2, (i3 & 4) != 0 ? null : bool, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : f16, (i3 & 32) != 0 ? null : imageDuration, (i3 & 64) != 0 ? null : bool2, (i3 & 128) != 0 ? null : str2, (i3 & 256) != 0 ? null : num3, (i3 & 512) != 0 ? null : num4, (i3 & 1024) != 0 ? null : num5, (i3 & 2048) != 0 ? null : num6, (i3 & 4096) != 0 ? null : size, (i3 & 8192) != 0 ? null : f17, (i3 & 16384) != 0 ? null : str3, (i3 & 32768) != 0 ? null : num7, (i3 & 65536) != 0 ? null : f18, (i3 & 131072) != 0 ? null : str4, (i3 & 262144) != 0 ? null : num8, (i3 & 524288) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 1048576) != 0 ? null : str5, (i3 & 2097152) != 0 ? null : num9, (i3 & 4194304) != 0 ? null : bool3, (i3 & 8388608) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.entityId = this.entityId;
        builder.componentID = this.componentID;
        builder.enabled = this.enabled;
        builder.type = this.type;
        builder.fillScale = this.fillScale;
        builder.imageDurations = this.imageDurations;
        builder.imageEffect = this.imageEffect;
        builder.key = this.key;
        builder.maxSourceCount = this.maxSourceCount;
        builder.minDuration = this.minDuration;
        builder.minSourceCount = this.minSourceCount;
        builder.scaleMode = this.scaleMode;
        builder.size = this.size;
        builder.speed = this.speed;
        builder.src = this.src;
        builder.version = this.version;
        builder.volume = this.volume;
        builder.backgroundColor = this.backgroundColor;
        builder.backgroundFillMode = this.backgroundFillMode;
        builder.volumeEffects = this.volumeEffects;
        builder.backgroundPagPath = this.backgroundPagPath;
        builder.resLoopCount = this.resLoopCount;
        builder.visibleWhileOverTime = this.visibleWhileOverTime;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiMedia(@Nullable Integer num, @Nullable Integer num2, @Nullable Boolean bool, @Nullable String str, @Nullable Float f16, @Nullable ImageDuration imageDuration, @Nullable Boolean bool2, @Nullable String str2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5, @Nullable Integer num6, @Nullable Size size, @Nullable Float f17, @Nullable String str3, @Nullable Integer num7, @Nullable Float f18, @Nullable String str4, @Nullable Integer num8, @NotNull List<VolumeEffect> volumeEffects, @Nullable String str5, @Nullable Integer num9, @Nullable Boolean bool3, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(volumeEffects, "volumeEffects");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.entityId = num;
        this.componentID = num2;
        this.enabled = bool;
        this.type = str;
        this.fillScale = f16;
        this.imageDurations = imageDuration;
        this.imageEffect = bool2;
        this.key = str2;
        this.maxSourceCount = num3;
        this.minDuration = num4;
        this.minSourceCount = num5;
        this.scaleMode = num6;
        this.size = size;
        this.speed = f17;
        this.src = str3;
        this.version = num7;
        this.volume = f18;
        this.backgroundColor = str4;
        this.backgroundFillMode = num8;
        this.volumeEffects = volumeEffects;
        this.backgroundPagPath = str5;
        this.resLoopCount = num9;
        this.visibleWhileOverTime = bool3;
    }
}
