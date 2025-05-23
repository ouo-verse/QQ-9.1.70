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
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import java.util.ArrayList;
import kotlin.Metadata;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002#$B\u00b7\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\u0002\u0010\u0017J\u00bd\u0001\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\b\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0002H\u0016J\b\u0010\"\u001a\u00020\u0013H\u0016R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0018R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0019R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0018R\u0014\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0019R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0019R\u0014\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0019R\u0014\u0010\r\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0019R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0019R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0019R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0019R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0018R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/Beauty;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/Beauty$Builder;", TemplateParser.KEY_COMPONENT_ID, "", NodeProps.ENABLED, "", TemplateParser.KEY_ENTITY_ID, "deepSmoothAlpha", "", "eyeLightenAlpha", "eyePouchAlpha", "eyebrowContrastAlpha", "faceFeatureBlendFaceAlpha", "faceFeatureTeethLutAlpha", "imageContrastAlpha", "skinColorSlider", "wrinkleAlpha", "type", "", "version", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Float;", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/Beauty;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class Beauty extends AndroidMessage<Beauty, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<Beauty> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<Beauty> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @JvmField
    @Nullable
    public final Integer componentID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    @JvmField
    @Nullable
    public final Float deepSmoothAlpha;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 2)
    @JvmField
    @Nullable
    public final Boolean enabled;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    @JvmField
    @Nullable
    public final Integer entityId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 5)
    @JvmField
    @Nullable
    public final Float eyeLightenAlpha;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
    @JvmField
    @Nullable
    public final Float eyePouchAlpha;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 7)
    @JvmField
    @Nullable
    public final Float eyebrowContrastAlpha;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 8)
    @JvmField
    @Nullable
    public final Float faceFeatureBlendFaceAlpha;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 9)
    @JvmField
    @Nullable
    public final Float faceFeatureTeethLutAlpha;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 10)
    @JvmField
    @Nullable
    public final Float imageContrastAlpha;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 11)
    @JvmField
    @Nullable
    public final Float skinColorSlider;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    @JvmField
    @Nullable
    public final String type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 14)
    @JvmField
    @Nullable
    public final Integer version;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 12)
    @JvmField
    @Nullable
    public final Float wrinkleAlpha;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\u0015\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u001aJ\u0015\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u001bJ\u0015\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u001cJ\u0015\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u001aJ\u0015\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u001bJ\u0015\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u001bJ\u0015\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u001bJ\u0015\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u001bJ\u0015\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u001bJ\u0015\u0010\u0013\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u001bJ\u0015\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0015\u0010\u0017\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u001aJ\u0015\u0010\u0018\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u001bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\t\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/Beauty$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/Beauty;", "()V", TemplateParser.KEY_COMPONENT_ID, "", "Ljava/lang/Integer;", "deepSmoothAlpha", "", "Ljava/lang/Float;", NodeProps.ENABLED, "", "Ljava/lang/Boolean;", TemplateParser.KEY_ENTITY_ID, "eyeLightenAlpha", "eyePouchAlpha", "eyebrowContrastAlpha", "faceFeatureBlendFaceAlpha", "faceFeatureTeethLutAlpha", "imageContrastAlpha", "skinColorSlider", "type", "", "version", "wrinkleAlpha", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/Beauty$Builder;", "(Ljava/lang/Float;)Lcom/tencent/tavcut/composition/model/component/Beauty$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/Beauty$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<Beauty, Builder> {

        @JvmField
        @Nullable
        public Integer componentID;

        @JvmField
        @Nullable
        public Float deepSmoothAlpha;

        @JvmField
        @Nullable
        public Boolean enabled;

        @JvmField
        @Nullable
        public Integer entityId;

        @JvmField
        @Nullable
        public Float eyeLightenAlpha;

        @JvmField
        @Nullable
        public Float eyePouchAlpha;

        @JvmField
        @Nullable
        public Float eyebrowContrastAlpha;

        @JvmField
        @Nullable
        public Float faceFeatureBlendFaceAlpha;

        @JvmField
        @Nullable
        public Float faceFeatureTeethLutAlpha;

        @JvmField
        @Nullable
        public Float imageContrastAlpha;

        @JvmField
        @Nullable
        public Float skinColorSlider;

        @JvmField
        @Nullable
        public String type;

        @JvmField
        @Nullable
        public Integer version;

        @JvmField
        @Nullable
        public Float wrinkleAlpha;

        @NotNull
        public final Builder componentID(@Nullable Integer componentID) {
            this.componentID = componentID;
            return this;
        }

        @NotNull
        public final Builder deepSmoothAlpha(@Nullable Float deepSmoothAlpha) {
            this.deepSmoothAlpha = deepSmoothAlpha;
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
        public final Builder eyeLightenAlpha(@Nullable Float eyeLightenAlpha) {
            this.eyeLightenAlpha = eyeLightenAlpha;
            return this;
        }

        @NotNull
        public final Builder eyePouchAlpha(@Nullable Float eyePouchAlpha) {
            this.eyePouchAlpha = eyePouchAlpha;
            return this;
        }

        @NotNull
        public final Builder eyebrowContrastAlpha(@Nullable Float eyebrowContrastAlpha) {
            this.eyebrowContrastAlpha = eyebrowContrastAlpha;
            return this;
        }

        @NotNull
        public final Builder faceFeatureBlendFaceAlpha(@Nullable Float faceFeatureBlendFaceAlpha) {
            this.faceFeatureBlendFaceAlpha = faceFeatureBlendFaceAlpha;
            return this;
        }

        @NotNull
        public final Builder faceFeatureTeethLutAlpha(@Nullable Float faceFeatureTeethLutAlpha) {
            this.faceFeatureTeethLutAlpha = faceFeatureTeethLutAlpha;
            return this;
        }

        @NotNull
        public final Builder imageContrastAlpha(@Nullable Float imageContrastAlpha) {
            this.imageContrastAlpha = imageContrastAlpha;
            return this;
        }

        @NotNull
        public final Builder skinColorSlider(@Nullable Float skinColorSlider) {
            this.skinColorSlider = skinColorSlider;
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
        public final Builder wrinkleAlpha(@Nullable Float wrinkleAlpha) {
            this.wrinkleAlpha = wrinkleAlpha;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public Beauty build() {
            return new Beauty(this.componentID, this.enabled, this.entityId, this.deepSmoothAlpha, this.eyeLightenAlpha, this.eyePouchAlpha, this.eyebrowContrastAlpha, this.faceFeatureBlendFaceAlpha, this.faceFeatureTeethLutAlpha, this.imageContrastAlpha, this.skinColorSlider, this.wrinkleAlpha, this.type, this.version, buildUnknownFields());
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Beauty.class);
        final String str = "type.googleapis.com/publisher.Beauty";
        ProtoAdapter<Beauty> protoAdapter = new ProtoAdapter<Beauty>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.Beauty$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Beauty decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                long beginMessage = reader.beginMessage();
                Integer num = null;
                Boolean bool = null;
                Integer num2 = null;
                Float f16 = null;
                Float f17 = null;
                Float f18 = null;
                Float f19 = null;
                Float f26 = null;
                Float f27 = null;
                Float f28 = null;
                Float f29 = null;
                Float f36 = null;
                String str2 = null;
                Integer num3 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new Beauty(num, bool, num2, f16, f17, f18, f19, f26, f27, f28, f29, f36, str2, num3, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                    switch (nextTag) {
                        case 1:
                            num = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 2:
                            bool = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 3:
                            num2 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 4:
                            f16 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 5:
                            f17 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 6:
                            f18 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 7:
                            f19 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 8:
                            f26 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 9:
                            f27 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 10:
                            f28 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 11:
                            f29 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 12:
                            f36 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 13:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 14:
                            num3 = ProtoAdapter.INT32.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull Beauty value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                protoAdapter2.encodeWithTag(writer, 1, value.componentID);
                ProtoAdapter.BOOL.encodeWithTag(writer, 2, value.enabled);
                protoAdapter2.encodeWithTag(writer, 3, value.entityId);
                ProtoAdapter<Float> protoAdapter3 = ProtoAdapter.FLOAT;
                protoAdapter3.encodeWithTag(writer, 4, value.deepSmoothAlpha);
                protoAdapter3.encodeWithTag(writer, 5, value.eyeLightenAlpha);
                protoAdapter3.encodeWithTag(writer, 6, value.eyePouchAlpha);
                protoAdapter3.encodeWithTag(writer, 7, value.eyebrowContrastAlpha);
                protoAdapter3.encodeWithTag(writer, 8, value.faceFeatureBlendFaceAlpha);
                protoAdapter3.encodeWithTag(writer, 9, value.faceFeatureTeethLutAlpha);
                protoAdapter3.encodeWithTag(writer, 10, value.imageContrastAlpha);
                protoAdapter3.encodeWithTag(writer, 11, value.skinColorSlider);
                protoAdapter3.encodeWithTag(writer, 12, value.wrinkleAlpha);
                ProtoAdapter.STRING.encodeWithTag(writer, 13, value.type);
                protoAdapter2.encodeWithTag(writer, 14, value.version);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull Beauty value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(2, value.enabled) + protoAdapter2.encodedSizeWithTag(3, value.entityId);
                ProtoAdapter<Float> protoAdapter3 = ProtoAdapter.FLOAT;
                return encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(4, value.deepSmoothAlpha) + protoAdapter3.encodedSizeWithTag(5, value.eyeLightenAlpha) + protoAdapter3.encodedSizeWithTag(6, value.eyePouchAlpha) + protoAdapter3.encodedSizeWithTag(7, value.eyebrowContrastAlpha) + protoAdapter3.encodedSizeWithTag(8, value.faceFeatureBlendFaceAlpha) + protoAdapter3.encodedSizeWithTag(9, value.faceFeatureTeethLutAlpha) + protoAdapter3.encodedSizeWithTag(10, value.imageContrastAlpha) + protoAdapter3.encodedSizeWithTag(11, value.skinColorSlider) + protoAdapter3.encodedSizeWithTag(12, value.wrinkleAlpha) + ProtoAdapter.STRING.encodedSizeWithTag(13, value.type) + protoAdapter2.encodedSizeWithTag(14, value.version) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public Beauty redact(@NotNull Beauty value) {
                Beauty copy;
                Intrinsics.checkParameterIsNotNull(value, "value");
                copy = value.copy((r32 & 1) != 0 ? value.componentID : null, (r32 & 2) != 0 ? value.enabled : null, (r32 & 4) != 0 ? value.entityId : null, (r32 & 8) != 0 ? value.deepSmoothAlpha : null, (r32 & 16) != 0 ? value.eyeLightenAlpha : null, (r32 & 32) != 0 ? value.eyePouchAlpha : null, (r32 & 64) != 0 ? value.eyebrowContrastAlpha : null, (r32 & 128) != 0 ? value.faceFeatureBlendFaceAlpha : null, (r32 & 256) != 0 ? value.faceFeatureTeethLutAlpha : null, (r32 & 512) != 0 ? value.imageContrastAlpha : null, (r32 & 1024) != 0 ? value.skinColorSlider : null, (r32 & 2048) != 0 ? value.wrinkleAlpha : null, (r32 & 4096) != 0 ? value.type : null, (r32 & 8192) != 0 ? value.version : null, (r32 & 16384) != 0 ? value.unknownFields() : ByteString.EMPTY);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public Beauty() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    @NotNull
    public final Beauty copy(@Nullable Integer componentID, @Nullable Boolean enabled, @Nullable Integer entityId, @Nullable Float deepSmoothAlpha, @Nullable Float eyeLightenAlpha, @Nullable Float eyePouchAlpha, @Nullable Float eyebrowContrastAlpha, @Nullable Float faceFeatureBlendFaceAlpha, @Nullable Float faceFeatureTeethLutAlpha, @Nullable Float imageContrastAlpha, @Nullable Float skinColorSlider, @Nullable Float wrinkleAlpha, @Nullable String type, @Nullable Integer version, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new Beauty(componentID, enabled, entityId, deepSmoothAlpha, eyeLightenAlpha, eyePouchAlpha, eyebrowContrastAlpha, faceFeatureBlendFaceAlpha, faceFeatureTeethLutAlpha, imageContrastAlpha, skinColorSlider, wrinkleAlpha, type, version, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Beauty)) {
            return false;
        }
        Beauty beauty = (Beauty) other;
        if (Intrinsics.areEqual(unknownFields(), beauty.unknownFields()) && Intrinsics.areEqual(this.componentID, beauty.componentID) && Intrinsics.areEqual(this.enabled, beauty.enabled) && Intrinsics.areEqual(this.entityId, beauty.entityId) && Intrinsics.areEqual(this.deepSmoothAlpha, beauty.deepSmoothAlpha) && Intrinsics.areEqual(this.eyeLightenAlpha, beauty.eyeLightenAlpha) && Intrinsics.areEqual(this.eyePouchAlpha, beauty.eyePouchAlpha) && Intrinsics.areEqual(this.eyebrowContrastAlpha, beauty.eyebrowContrastAlpha) && Intrinsics.areEqual(this.faceFeatureBlendFaceAlpha, beauty.faceFeatureBlendFaceAlpha) && Intrinsics.areEqual(this.faceFeatureTeethLutAlpha, beauty.faceFeatureTeethLutAlpha) && Intrinsics.areEqual(this.imageContrastAlpha, beauty.imageContrastAlpha) && Intrinsics.areEqual(this.skinColorSlider, beauty.skinColorSlider) && Intrinsics.areEqual(this.wrinkleAlpha, beauty.wrinkleAlpha) && Intrinsics.areEqual(this.type, beauty.type) && Intrinsics.areEqual(this.version, beauty.version)) {
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
        int i46 = this.hashCode;
        if (i46 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Integer num = this.componentID;
            int i47 = 0;
            if (num != null) {
                i3 = num.hashCode();
            } else {
                i3 = 0;
            }
            int i48 = (hashCode + i3) * 37;
            Boolean bool = this.enabled;
            if (bool != null) {
                i16 = bool.hashCode();
            } else {
                i16 = 0;
            }
            int i49 = (i48 + i16) * 37;
            Integer num2 = this.entityId;
            if (num2 != null) {
                i17 = num2.hashCode();
            } else {
                i17 = 0;
            }
            int i56 = (i49 + i17) * 37;
            Float f16 = this.deepSmoothAlpha;
            if (f16 != null) {
                i18 = f16.hashCode();
            } else {
                i18 = 0;
            }
            int i57 = (i56 + i18) * 37;
            Float f17 = this.eyeLightenAlpha;
            if (f17 != null) {
                i19 = f17.hashCode();
            } else {
                i19 = 0;
            }
            int i58 = (i57 + i19) * 37;
            Float f18 = this.eyePouchAlpha;
            if (f18 != null) {
                i26 = f18.hashCode();
            } else {
                i26 = 0;
            }
            int i59 = (i58 + i26) * 37;
            Float f19 = this.eyebrowContrastAlpha;
            if (f19 != null) {
                i27 = f19.hashCode();
            } else {
                i27 = 0;
            }
            int i65 = (i59 + i27) * 37;
            Float f26 = this.faceFeatureBlendFaceAlpha;
            if (f26 != null) {
                i28 = f26.hashCode();
            } else {
                i28 = 0;
            }
            int i66 = (i65 + i28) * 37;
            Float f27 = this.faceFeatureTeethLutAlpha;
            if (f27 != null) {
                i29 = f27.hashCode();
            } else {
                i29 = 0;
            }
            int i67 = (i66 + i29) * 37;
            Float f28 = this.imageContrastAlpha;
            if (f28 != null) {
                i36 = f28.hashCode();
            } else {
                i36 = 0;
            }
            int i68 = (i67 + i36) * 37;
            Float f29 = this.skinColorSlider;
            if (f29 != null) {
                i37 = f29.hashCode();
            } else {
                i37 = 0;
            }
            int i69 = (i68 + i37) * 37;
            Float f36 = this.wrinkleAlpha;
            if (f36 != null) {
                i38 = f36.hashCode();
            } else {
                i38 = 0;
            }
            int i75 = (i69 + i38) * 37;
            String str = this.type;
            if (str != null) {
                i39 = str.hashCode();
            } else {
                i39 = 0;
            }
            int i76 = (i75 + i39) * 37;
            Integer num3 = this.version;
            if (num3 != null) {
                i47 = num3.hashCode();
            }
            int i77 = i76 + i47;
            this.hashCode = i77;
            return i77;
        }
        return i46;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        if (this.componentID != null) {
            arrayList.add("componentID=" + this.componentID);
        }
        if (this.enabled != null) {
            arrayList.add("enabled=" + this.enabled);
        }
        if (this.entityId != null) {
            arrayList.add("entityId=" + this.entityId);
        }
        if (this.deepSmoothAlpha != null) {
            arrayList.add("deepSmoothAlpha=" + this.deepSmoothAlpha);
        }
        if (this.eyeLightenAlpha != null) {
            arrayList.add("eyeLightenAlpha=" + this.eyeLightenAlpha);
        }
        if (this.eyePouchAlpha != null) {
            arrayList.add("eyePouchAlpha=" + this.eyePouchAlpha);
        }
        if (this.eyebrowContrastAlpha != null) {
            arrayList.add("eyebrowContrastAlpha=" + this.eyebrowContrastAlpha);
        }
        if (this.faceFeatureBlendFaceAlpha != null) {
            arrayList.add("faceFeatureBlendFaceAlpha=" + this.faceFeatureBlendFaceAlpha);
        }
        if (this.faceFeatureTeethLutAlpha != null) {
            arrayList.add("faceFeatureTeethLutAlpha=" + this.faceFeatureTeethLutAlpha);
        }
        if (this.imageContrastAlpha != null) {
            arrayList.add("imageContrastAlpha=" + this.imageContrastAlpha);
        }
        if (this.skinColorSlider != null) {
            arrayList.add("skinColorSlider=" + this.skinColorSlider);
        }
        if (this.wrinkleAlpha != null) {
            arrayList.add("wrinkleAlpha=" + this.wrinkleAlpha);
        }
        if (this.type != null) {
            arrayList.add("type=" + Internal.sanitize(this.type));
        }
        if (this.version != null) {
            arrayList.add("version=" + this.version);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "Beauty{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ Beauty(Integer num, Boolean bool, Integer num2, Float f16, Float f17, Float f18, Float f19, Float f26, Float f27, Float f28, Float f29, Float f36, String str, Integer num3, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : bool, (i3 & 4) != 0 ? null : num2, (i3 & 8) != 0 ? null : f16, (i3 & 16) != 0 ? null : f17, (i3 & 32) != 0 ? null : f18, (i3 & 64) != 0 ? null : f19, (i3 & 128) != 0 ? null : f26, (i3 & 256) != 0 ? null : f27, (i3 & 512) != 0 ? null : f28, (i3 & 1024) != 0 ? null : f29, (i3 & 2048) != 0 ? null : f36, (i3 & 4096) != 0 ? null : str, (i3 & 8192) == 0 ? num3 : null, (i3 & 16384) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.componentID = this.componentID;
        builder.enabled = this.enabled;
        builder.entityId = this.entityId;
        builder.deepSmoothAlpha = this.deepSmoothAlpha;
        builder.eyeLightenAlpha = this.eyeLightenAlpha;
        builder.eyePouchAlpha = this.eyePouchAlpha;
        builder.eyebrowContrastAlpha = this.eyebrowContrastAlpha;
        builder.faceFeatureBlendFaceAlpha = this.faceFeatureBlendFaceAlpha;
        builder.faceFeatureTeethLutAlpha = this.faceFeatureTeethLutAlpha;
        builder.imageContrastAlpha = this.imageContrastAlpha;
        builder.skinColorSlider = this.skinColorSlider;
        builder.wrinkleAlpha = this.wrinkleAlpha;
        builder.type = this.type;
        builder.version = this.version;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Beauty(@Nullable Integer num, @Nullable Boolean bool, @Nullable Integer num2, @Nullable Float f16, @Nullable Float f17, @Nullable Float f18, @Nullable Float f19, @Nullable Float f26, @Nullable Float f27, @Nullable Float f28, @Nullable Float f29, @Nullable Float f36, @Nullable String str, @Nullable Integer num3, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.componentID = num;
        this.enabled = bool;
        this.entityId = num2;
        this.deepSmoothAlpha = f16;
        this.eyeLightenAlpha = f17;
        this.eyePouchAlpha = f18;
        this.eyebrowContrastAlpha = f19;
        this.faceFeatureBlendFaceAlpha = f26;
        this.faceFeatureTeethLutAlpha = f27;
        this.imageContrastAlpha = f28;
        this.skinColorSlider = f29;
        this.wrinkleAlpha = f36;
        this.type = str;
        this.version = num3;
    }
}
