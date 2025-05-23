package com.tencent.tavcut.model;

import android.os.Parcelable;
import androidx.fragment.app.a;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.EnumAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.tavcut.composition.model.component.Rect;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import com.tencent.tavcut.model.ClipSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003&'(B\u0093\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\u0002\u0010\u0017J\u009b\u0001\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0002H\u0016J\b\u0010%\u001a\u00020\u0004H\u0016R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0019R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\r\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001a\u00a8\u0006)"}, d2 = {"Lcom/tencent/tavcut/model/ClipSource;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/model/ClipSource$Builder;", "sourceId", "", "path", "type", "Lcom/tencent/tavcut/model/ClipSource$ClipType;", "duration", "", "speed", "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "startOffset", "matrix", "", "photoEffectPath", "transform", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "clipRect", "Lcom/tencent/tavcut/composition/model/component/Rect;", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/tavcut/model/ClipSource$ClipType;JLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;Lcom/tencent/tavcut/composition/model/component/ScreenTransform;Lcom/tencent/tavcut/composition/model/component/Rect;Lokio/ByteString;)V", "matrix$annotations", "()V", "Ljava/lang/Float;", "Ljava/lang/Long;", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/tavcut/model/ClipSource$ClipType;JLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;Lcom/tencent/tavcut/composition/model/component/ScreenTransform;Lcom/tencent/tavcut/composition/model/component/Rect;Lokio/ByteString;)Lcom/tencent/tavcut/model/ClipSource;", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "ClipType", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class ClipSource extends AndroidMessage<ClipSource, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<ClipSource> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<ClipSource> CREATOR;
    public static final float DEFAULT_SPEED = 1.0f;
    public static final float DEFAULT_VOLUME = 1.0f;

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.Rect#ADAPTER", tag = 11)
    @JvmField
    @Nullable
    public final Rect clipRect;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.REQUIRED, tag = 4)
    @JvmField
    public final long duration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", label = WireField.Label.REPEATED, tag = 8)
    @JvmField
    @NotNull
    public final List<Float> matrix;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @JvmField
    @Nullable
    public final String path;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    @JvmField
    @Nullable
    public final String photoEffectPath;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @Nullable
    public final String sourceId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 5)
    @JvmField
    @Nullable
    public final Float speed;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 7)
    @JvmField
    @Nullable
    public final Long startOffset;

    @WireField(adapter = "com.tencent.tavcut.composition.model.component.ScreenTransform#ADAPTER", tag = 10)
    @JvmField
    @Nullable
    public final ScreenTransform transform;

    @WireField(adapter = "com.tencent.tavcut.model.ClipSource$ClipType#ADAPTER", tag = 3)
    @JvmField
    @Nullable
    public final ClipType type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
    @JvmField
    @Nullable
    public final Float volume;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\t\u001a\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\rJ\u0015\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u0019J\u0015\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u001aJ\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0015\u0010\u0017\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u0019R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0011\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/tavcut/model/ClipSource$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/model/ClipSource;", "()V", "clipRect", "Lcom/tencent/tavcut/composition/model/component/Rect;", "duration", "", "Ljava/lang/Long;", "matrix", "", "", "path", "", "photoEffectPath", "sourceId", "speed", "Ljava/lang/Float;", "startOffset", "transform", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "type", "Lcom/tencent/tavcut/model/ClipSource$ClipType;", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "build", "(Ljava/lang/Float;)Lcom/tencent/tavcut/model/ClipSource$Builder;", "(Ljava/lang/Long;)Lcom/tencent/tavcut/model/ClipSource$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<ClipSource, Builder> {

        @JvmField
        @Nullable
        public Rect clipRect;

        @JvmField
        @Nullable
        public Long duration;

        @JvmField
        @NotNull
        public List<Float> matrix;

        @JvmField
        @Nullable
        public String path;

        @JvmField
        @Nullable
        public String photoEffectPath;

        @JvmField
        @Nullable
        public String sourceId;

        @JvmField
        @Nullable
        public Float speed;

        @JvmField
        @Nullable
        public Long startOffset;

        @JvmField
        @Nullable
        public ScreenTransform transform;

        @JvmField
        @Nullable
        public ClipType type;

        @JvmField
        @Nullable
        public Float volume;

        public Builder() {
            List<Float> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.matrix = emptyList;
        }

        @NotNull
        public final Builder clipRect(@Nullable Rect clipRect) {
            this.clipRect = clipRect;
            return this;
        }

        @NotNull
        public final Builder duration(long duration) {
            this.duration = Long.valueOf(duration);
            return this;
        }

        @Deprecated(message = "matrix is deprecated")
        @NotNull
        public final Builder matrix(@NotNull List<Float> matrix) {
            Intrinsics.checkParameterIsNotNull(matrix, "matrix");
            Internal.checkElementsNotNull(matrix);
            this.matrix = matrix;
            return this;
        }

        @NotNull
        public final Builder path(@Nullable String path) {
            this.path = path;
            return this;
        }

        @NotNull
        public final Builder photoEffectPath(@Nullable String photoEffectPath) {
            this.photoEffectPath = photoEffectPath;
            return this;
        }

        @NotNull
        public final Builder sourceId(@Nullable String sourceId) {
            this.sourceId = sourceId;
            return this;
        }

        @NotNull
        public final Builder speed(@Nullable Float speed) {
            this.speed = speed;
            return this;
        }

        @NotNull
        public final Builder startOffset(@Nullable Long startOffset) {
            this.startOffset = startOffset;
            return this;
        }

        @NotNull
        public final Builder transform(@Nullable ScreenTransform transform) {
            this.transform = transform;
            return this;
        }

        @NotNull
        public final Builder type(@Nullable ClipType type) {
            this.type = type;
            return this;
        }

        @NotNull
        public final Builder volume(@Nullable Float volume) {
            this.volume = volume;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public ClipSource build() {
            String str = this.sourceId;
            String str2 = this.path;
            ClipType clipType = this.type;
            Long l3 = this.duration;
            if (l3 != null) {
                return new ClipSource(str, str2, clipType, l3.longValue(), this.speed, this.volume, this.startOffset, this.matrix, this.photoEffectPath, this.transform, this.clipRect, buildUnknownFields());
            }
            throw Internal.missingRequiredFields(l3, "duration");
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/tavcut/model/ClipSource$ClipType;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "PHOTO", "VIDEO", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public enum ClipType implements WireEnum {
        PHOTO(0),
        VIDEO(1);


        @JvmField
        @NotNull
        public static final ProtoAdapter<ClipType> ADAPTER;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int value;

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/tavcut/model/ClipSource$ClipType$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/model/ClipSource$ClipType;", "fromValue", "value", "", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
        /* loaded from: classes26.dex */
        public static final class Companion {
            Companion() {
            }

            @JvmStatic
            @Nullable
            public final ClipType fromValue(int value) {
                if (value != 0) {
                    if (value != 1) {
                        return null;
                    }
                    return ClipType.VIDEO;
                }
                return ClipType.PHOTO;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ClipType.class);
            ADAPTER = new EnumAdapter<ClipType>(orCreateKotlinClass) { // from class: com.tencent.tavcut.model.ClipSource$ClipType$Companion$ADAPTER$1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.squareup.wire.EnumAdapter
                @Nullable
                public ClipSource.ClipType fromValue(int value) {
                    return ClipSource.ClipType.INSTANCE.fromValue(value);
                }
            };
        }

        ClipType(int i3) {
            this.value = i3;
        }

        @JvmStatic
        @Nullable
        public static final ClipType fromValue(int i3) {
            return INSTANCE.fromValue(i3);
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            return this.value;
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ClipSource.class);
        final String str = "type.googleapis.com/publisher.ClipSource";
        ProtoAdapter<ClipSource> protoAdapter = new ProtoAdapter<ClipSource>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.model.ClipSource$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0051. Please report as an issue. */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public ClipSource decode(@NotNull ProtoReader reader) {
                long j3;
                Long l3;
                ClipSource.ClipType decode;
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long beginMessage = reader.beginMessage();
                Long l16 = null;
                String str2 = null;
                String str3 = null;
                ClipSource.ClipType clipType = null;
                Float f16 = null;
                Float f17 = null;
                Long l17 = null;
                String str4 = null;
                ScreenTransform screenTransform = null;
                Rect rect = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        ByteString endMessageAndGetUnknownFields = reader.endMessageAndGetUnknownFields(beginMessage);
                        if (l16 != null) {
                            return new ClipSource(str2, str3, clipType, l16.longValue(), f16, f17, l17, arrayList, str4, screenTransform, rect, endMessageAndGetUnknownFields);
                        }
                        throw Internal.missingRequiredFields(l16, "duration");
                    }
                    switch (nextTag) {
                        case 1:
                            j3 = beginMessage;
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            j3 = beginMessage;
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            try {
                                decode = ClipSource.ClipType.ADAPTER.decode(reader);
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                e = e16;
                            }
                            try {
                                Unit unit = Unit.INSTANCE;
                                clipType = decode;
                                j3 = beginMessage;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e17) {
                                e = e17;
                                clipType = decode;
                                j3 = beginMessage;
                                l3 = l16;
                                reader.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e.value));
                                Unit unit2 = Unit.INSTANCE;
                                l16 = l3;
                                beginMessage = j3;
                            }
                        case 4:
                            l16 = ProtoAdapter.INT64.decode(reader);
                            j3 = beginMessage;
                            break;
                        case 5:
                            f16 = ProtoAdapter.FLOAT.decode(reader);
                            j3 = beginMessage;
                            break;
                        case 6:
                            f17 = ProtoAdapter.FLOAT.decode(reader);
                            j3 = beginMessage;
                            break;
                        case 7:
                            l17 = ProtoAdapter.INT64.decode(reader);
                            j3 = beginMessage;
                            break;
                        case 8:
                            arrayList.add(ProtoAdapter.FLOAT.decode(reader));
                            j3 = beginMessage;
                            l3 = l16;
                            l16 = l3;
                            break;
                        case 9:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            j3 = beginMessage;
                            break;
                        case 10:
                            screenTransform = ScreenTransform.ADAPTER.decode(reader);
                            j3 = beginMessage;
                            break;
                        case 11:
                            rect = Rect.ADAPTER.decode(reader);
                            j3 = beginMessage;
                            break;
                        default:
                            j3 = beginMessage;
                            l3 = l16;
                            reader.readUnknownField(nextTag);
                            l16 = l3;
                            break;
                    }
                    beginMessage = j3;
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull ClipSource value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                protoAdapter2.encodeWithTag(writer, 1, value.sourceId);
                protoAdapter2.encodeWithTag(writer, 2, value.path);
                ClipSource.ClipType.ADAPTER.encodeWithTag(writer, 3, value.type);
                ProtoAdapter<Long> protoAdapter3 = ProtoAdapter.INT64;
                protoAdapter3.encodeWithTag(writer, 4, Long.valueOf(value.duration));
                ProtoAdapter<Float> protoAdapter4 = ProtoAdapter.FLOAT;
                protoAdapter4.encodeWithTag(writer, 5, value.speed);
                protoAdapter4.encodeWithTag(writer, 6, value.volume);
                protoAdapter3.encodeWithTag(writer, 7, value.startOffset);
                protoAdapter4.asRepeated().encodeWithTag(writer, 8, value.matrix);
                protoAdapter2.encodeWithTag(writer, 9, value.photoEffectPath);
                ScreenTransform.ADAPTER.encodeWithTag(writer, 10, value.transform);
                Rect.ADAPTER.encodeWithTag(writer, 11, value.clipRect);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull ClipSource value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.sourceId) + protoAdapter2.encodedSizeWithTag(2, value.path) + ClipSource.ClipType.ADAPTER.encodedSizeWithTag(3, value.type);
                ProtoAdapter<Long> protoAdapter3 = ProtoAdapter.INT64;
                int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(4, Long.valueOf(value.duration));
                ProtoAdapter<Float> protoAdapter4 = ProtoAdapter.FLOAT;
                return encodedSizeWithTag2 + protoAdapter4.encodedSizeWithTag(5, value.speed) + protoAdapter4.encodedSizeWithTag(6, value.volume) + protoAdapter3.encodedSizeWithTag(7, value.startOffset) + protoAdapter4.asRepeated().encodedSizeWithTag(8, value.matrix) + protoAdapter2.encodedSizeWithTag(9, value.photoEffectPath) + ScreenTransform.ADAPTER.encodedSizeWithTag(10, value.transform) + Rect.ADAPTER.encodedSizeWithTag(11, value.clipRect) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public ClipSource redact(@NotNull ClipSource value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ScreenTransform screenTransform = value.transform;
                ScreenTransform redact = screenTransform != null ? ScreenTransform.ADAPTER.redact(screenTransform) : null;
                Rect rect = value.clipRect;
                return ClipSource.copy$default(value, null, null, null, 0L, null, null, null, null, null, redact, rect != null ? Rect.ADAPTER.redact(rect) : null, ByteString.EMPTY, 511, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ClipSource(String str, String str2, ClipType clipType, long j3, Float f16, Float f17, Long l3, List list, String str3, ScreenTransform screenTransform, Rect rect, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r4, r5, r6, j3, r9, r10, r11, r12, (i3 & 256) != 0 ? null : str3, (i3 & 512) != 0 ? null : screenTransform, (i3 & 1024) != 0 ? null : rect, (i3 & 2048) != 0 ? ByteString.EMPTY : byteString);
        List list2;
        List emptyList;
        String str4 = (i3 & 1) != 0 ? null : str;
        String str5 = (i3 & 2) != 0 ? null : str2;
        ClipType clipType2 = (i3 & 4) != 0 ? null : clipType;
        Float f18 = (i3 & 16) != 0 ? null : f16;
        Float f19 = (i3 & 32) != 0 ? null : f17;
        Long l16 = (i3 & 64) != 0 ? null : l3;
        if ((i3 & 128) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList;
        } else {
            list2 = list;
        }
    }

    public static /* synthetic */ ClipSource copy$default(ClipSource clipSource, String str, String str2, ClipType clipType, long j3, Float f16, Float f17, Long l3, List list, String str3, ScreenTransform screenTransform, Rect rect, ByteString byteString, int i3, Object obj) {
        String str4;
        String str5;
        ClipType clipType2;
        long j16;
        Float f18;
        Float f19;
        Long l16;
        List list2;
        String str6;
        ScreenTransform screenTransform2;
        Rect rect2;
        ByteString byteString2;
        if ((i3 & 1) != 0) {
            str4 = clipSource.sourceId;
        } else {
            str4 = str;
        }
        if ((i3 & 2) != 0) {
            str5 = clipSource.path;
        } else {
            str5 = str2;
        }
        if ((i3 & 4) != 0) {
            clipType2 = clipSource.type;
        } else {
            clipType2 = clipType;
        }
        if ((i3 & 8) != 0) {
            j16 = clipSource.duration;
        } else {
            j16 = j3;
        }
        if ((i3 & 16) != 0) {
            f18 = clipSource.speed;
        } else {
            f18 = f16;
        }
        if ((i3 & 32) != 0) {
            f19 = clipSource.volume;
        } else {
            f19 = f17;
        }
        if ((i3 & 64) != 0) {
            l16 = clipSource.startOffset;
        } else {
            l16 = l3;
        }
        if ((i3 & 128) != 0) {
            list2 = clipSource.matrix;
        } else {
            list2 = list;
        }
        if ((i3 & 256) != 0) {
            str6 = clipSource.photoEffectPath;
        } else {
            str6 = str3;
        }
        if ((i3 & 512) != 0) {
            screenTransform2 = clipSource.transform;
        } else {
            screenTransform2 = screenTransform;
        }
        if ((i3 & 1024) != 0) {
            rect2 = clipSource.clipRect;
        } else {
            rect2 = rect;
        }
        if ((i3 & 2048) != 0) {
            byteString2 = clipSource.unknownFields();
        } else {
            byteString2 = byteString;
        }
        return clipSource.copy(str4, str5, clipType2, j16, f18, f19, l16, list2, str6, screenTransform2, rect2, byteString2);
    }

    @NotNull
    public final ClipSource copy(@Nullable String sourceId, @Nullable String path, @Nullable ClipType type, long duration, @Nullable Float speed, @Nullable Float volume, @Nullable Long startOffset, @NotNull List<Float> matrix, @Nullable String photoEffectPath, @Nullable ScreenTransform transform, @Nullable Rect clipRect, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(matrix, "matrix");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new ClipSource(sourceId, path, type, duration, speed, volume, startOffset, matrix, photoEffectPath, transform, clipRect, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ClipSource)) {
            return false;
        }
        ClipSource clipSource = (ClipSource) other;
        if (Intrinsics.areEqual(unknownFields(), clipSource.unknownFields()) && Intrinsics.areEqual(this.sourceId, clipSource.sourceId) && Intrinsics.areEqual(this.path, clipSource.path) && this.type == clipSource.type && this.duration == clipSource.duration && Intrinsics.areEqual(this.speed, clipSource.speed) && Intrinsics.areEqual(this.volume, clipSource.volume) && Intrinsics.areEqual(this.startOffset, clipSource.startOffset) && Intrinsics.areEqual(this.matrix, clipSource.matrix) && Intrinsics.areEqual(this.photoEffectPath, clipSource.photoEffectPath) && Intrinsics.areEqual(this.transform, clipSource.transform) && Intrinsics.areEqual(this.clipRect, clipSource.clipRect)) {
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
        int i29 = this.hashCode;
        if (i29 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.sourceId;
            int i36 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i37 = (hashCode + i3) * 37;
            String str2 = this.path;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i38 = (i37 + i16) * 37;
            ClipType clipType = this.type;
            if (clipType != null) {
                i17 = clipType.hashCode();
            } else {
                i17 = 0;
            }
            int a16 = (((i38 + i17) * 37) + a.a(this.duration)) * 37;
            Float f16 = this.speed;
            if (f16 != null) {
                i18 = f16.hashCode();
            } else {
                i18 = 0;
            }
            int i39 = (a16 + i18) * 37;
            Float f17 = this.volume;
            if (f17 != null) {
                i19 = f17.hashCode();
            } else {
                i19 = 0;
            }
            int i46 = (i39 + i19) * 37;
            Long l3 = this.startOffset;
            if (l3 != null) {
                i26 = l3.hashCode();
            } else {
                i26 = 0;
            }
            int hashCode2 = (((i46 + i26) * 37) + this.matrix.hashCode()) * 37;
            String str3 = this.photoEffectPath;
            if (str3 != null) {
                i27 = str3.hashCode();
            } else {
                i27 = 0;
            }
            int i47 = (hashCode2 + i27) * 37;
            ScreenTransform screenTransform = this.transform;
            if (screenTransform != null) {
                i28 = screenTransform.hashCode();
            } else {
                i28 = 0;
            }
            int i48 = (i47 + i28) * 37;
            Rect rect = this.clipRect;
            if (rect != null) {
                i36 = rect.hashCode();
            }
            int i49 = i48 + i36;
            this.hashCode = i49;
            return i49;
        }
        return i29;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        if (this.sourceId != null) {
            arrayList.add("sourceId=" + Internal.sanitize(this.sourceId));
        }
        if (this.path != null) {
            arrayList.add("path=" + Internal.sanitize(this.path));
        }
        if (this.type != null) {
            arrayList.add("type=" + this.type);
        }
        arrayList.add("duration=" + this.duration);
        if (this.speed != null) {
            arrayList.add("speed=" + this.speed);
        }
        if (this.volume != null) {
            arrayList.add("volume=" + this.volume);
        }
        if (this.startOffset != null) {
            arrayList.add("startOffset=" + this.startOffset);
        }
        if (!this.matrix.isEmpty()) {
            arrayList.add("matrix=" + this.matrix);
        }
        if (this.photoEffectPath != null) {
            arrayList.add("photoEffectPath=" + Internal.sanitize(this.photoEffectPath));
        }
        if (this.transform != null) {
            arrayList.add("transform=" + this.transform);
        }
        if (this.clipRect != null) {
            arrayList.add("clipRect=" + this.clipRect);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "ClipSource{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.sourceId = this.sourceId;
        builder.path = this.path;
        builder.type = this.type;
        builder.duration = Long.valueOf(this.duration);
        builder.speed = this.speed;
        builder.volume = this.volume;
        builder.startOffset = this.startOffset;
        builder.matrix = this.matrix;
        builder.photoEffectPath = this.photoEffectPath;
        builder.transform = this.transform;
        builder.clipRect = this.clipRect;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClipSource(@Nullable String str, @Nullable String str2, @Nullable ClipType clipType, long j3, @Nullable Float f16, @Nullable Float f17, @Nullable Long l3, @NotNull List<Float> matrix, @Nullable String str3, @Nullable ScreenTransform screenTransform, @Nullable Rect rect, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(matrix, "matrix");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.sourceId = str;
        this.path = str2;
        this.type = clipType;
        this.duration = j3;
        this.speed = f16;
        this.volume = f17;
        this.startOffset = l3;
        this.matrix = matrix;
        this.photoEffectPath = str3;
        this.transform = screenTransform;
        this.clipRect = rect;
    }

    @Deprecated(message = "matrix is deprecated")
    public static /* synthetic */ void matrix$annotations() {
    }
}
