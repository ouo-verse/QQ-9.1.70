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
import com.tencent.qcircle.weseevideo.model.template.movie.AIAbilityModel;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002!\"B\u00b7\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\u0002\u0010\u0016J\u00bd\u0001\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\tH\u0016R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0018R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/PostEffect;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/PostEffect$Builder;", TemplateParser.KEY_ENTITY_ID, "", TemplateParser.KEY_COMPONENT_ID, NodeProps.ENABLED, "", "type", "", AIAbilityModel.AI_KEY, "sharpness", "brightness", "contrast", "hue", "highlights", "shadows", "saturation", "temperature", "src", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/PostEffect;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class PostEffect extends AndroidMessage<PostEffect, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<PostEffect> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<PostEffect> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 7)
    @JvmField
    @Nullable
    public final Integer brightness;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @JvmField
    @Nullable
    public final Integer componentID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 8)
    @JvmField
    @Nullable
    public final Integer contrast;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @JvmField
    @Nullable
    public final String effectType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 3)
    @JvmField
    @Nullable
    public final Boolean enabled;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @JvmField
    @Nullable
    public final Integer entityId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 10)
    @JvmField
    @Nullable
    public final Integer highlights;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    @JvmField
    @Nullable
    public final Integer hue;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 12)
    @JvmField
    @Nullable
    public final Integer saturation;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 11)
    @JvmField
    @Nullable
    public final Integer shadows;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    @JvmField
    @Nullable
    public final Integer sharpness;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 14)
    @JvmField
    @Nullable
    public final String src;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 13)
    @JvmField
    @Nullable
    public final Integer temperature;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @JvmField
    @Nullable
    public final String type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\u0015\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0017J\u0015\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0017J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0015\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\u0019J\u0015\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0017J\u0015\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0017J\u0015\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0017J\u0015\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0017J\u0015\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0017J\u0015\u0010\u0013\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0017J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\nJ\u0015\u0010\u0015\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0017J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\nR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/PostEffect$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/PostEffect;", "()V", "brightness", "", "Ljava/lang/Integer;", TemplateParser.KEY_COMPONENT_ID, "contrast", AIAbilityModel.AI_KEY, "", NodeProps.ENABLED, "", "Ljava/lang/Boolean;", TemplateParser.KEY_ENTITY_ID, "highlights", "hue", "saturation", "shadows", "sharpness", "src", "temperature", "type", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/PostEffect$Builder;", "build", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/PostEffect$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<PostEffect, Builder> {

        @JvmField
        @Nullable
        public Integer brightness;

        @JvmField
        @Nullable
        public Integer componentID;

        @JvmField
        @Nullable
        public Integer contrast;

        @JvmField
        @Nullable
        public String effectType;

        @JvmField
        @Nullable
        public Boolean enabled;

        @JvmField
        @Nullable
        public Integer entityId;

        @JvmField
        @Nullable
        public Integer highlights;

        @JvmField
        @Nullable
        public Integer hue;

        @JvmField
        @Nullable
        public Integer saturation;

        @JvmField
        @Nullable
        public Integer shadows;

        @JvmField
        @Nullable
        public Integer sharpness;

        @JvmField
        @Nullable
        public String src;

        @JvmField
        @Nullable
        public Integer temperature;

        @JvmField
        @Nullable
        public String type;

        @NotNull
        public final Builder brightness(@Nullable Integer brightness) {
            this.brightness = brightness;
            return this;
        }

        @NotNull
        public final Builder componentID(@Nullable Integer componentID) {
            this.componentID = componentID;
            return this;
        }

        @NotNull
        public final Builder contrast(@Nullable Integer contrast) {
            this.contrast = contrast;
            return this;
        }

        @NotNull
        public final Builder effectType(@Nullable String effectType) {
            this.effectType = effectType;
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
        public final Builder saturation(@Nullable Integer saturation) {
            this.saturation = saturation;
            return this;
        }

        @NotNull
        public final Builder shadows(@Nullable Integer shadows) {
            this.shadows = shadows;
            return this;
        }

        @NotNull
        public final Builder sharpness(@Nullable Integer sharpness) {
            this.sharpness = sharpness;
            return this;
        }

        @NotNull
        public final Builder src(@Nullable String src) {
            this.src = src;
            return this;
        }

        @NotNull
        public final Builder temperature(@Nullable Integer temperature) {
            this.temperature = temperature;
            return this;
        }

        @NotNull
        public final Builder type(@Nullable String type) {
            this.type = type;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public PostEffect build() {
            return new PostEffect(this.entityId, this.componentID, this.enabled, this.type, this.effectType, this.sharpness, this.brightness, this.contrast, this.hue, this.highlights, this.shadows, this.saturation, this.temperature, this.src, buildUnknownFields());
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(PostEffect.class);
        final String str = "type.googleapis.com/publisher.PostEffect";
        ProtoAdapter<PostEffect> protoAdapter = new ProtoAdapter<PostEffect>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.PostEffect$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public PostEffect decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                long beginMessage = reader.beginMessage();
                Integer num = null;
                Integer num2 = null;
                Boolean bool = null;
                String str2 = null;
                String str3 = null;
                Integer num3 = null;
                Integer num4 = null;
                Integer num5 = null;
                Integer num6 = null;
                Integer num7 = null;
                Integer num8 = null;
                Integer num9 = null;
                Integer num10 = null;
                String str4 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new PostEffect(num, num2, bool, str2, str3, num3, num4, num5, num6, num7, num8, num9, num10, str4, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                    switch (nextTag) {
                        case 1:
                            num = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 2:
                            num2 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 3:
                            bool = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 4:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            num3 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 7:
                            num4 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 8:
                            num5 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 9:
                            num6 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 10:
                            num7 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 11:
                            num8 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 12:
                            num9 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 13:
                            num10 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 14:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull PostEffect value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                protoAdapter2.encodeWithTag(writer, 1, value.entityId);
                protoAdapter2.encodeWithTag(writer, 2, value.componentID);
                ProtoAdapter.BOOL.encodeWithTag(writer, 3, value.enabled);
                ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
                protoAdapter3.encodeWithTag(writer, 4, value.type);
                protoAdapter3.encodeWithTag(writer, 5, value.effectType);
                protoAdapter2.encodeWithTag(writer, 6, value.sharpness);
                protoAdapter2.encodeWithTag(writer, 7, value.brightness);
                protoAdapter2.encodeWithTag(writer, 8, value.contrast);
                protoAdapter2.encodeWithTag(writer, 9, value.hue);
                protoAdapter2.encodeWithTag(writer, 10, value.highlights);
                protoAdapter2.encodeWithTag(writer, 11, value.shadows);
                protoAdapter2.encodeWithTag(writer, 12, value.saturation);
                protoAdapter2.encodeWithTag(writer, 13, value.temperature);
                protoAdapter3.encodeWithTag(writer, 14, value.src);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull PostEffect value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.entityId) + protoAdapter2.encodedSizeWithTag(2, value.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(3, value.enabled);
                ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
                return encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(4, value.type) + protoAdapter3.encodedSizeWithTag(5, value.effectType) + protoAdapter2.encodedSizeWithTag(6, value.sharpness) + protoAdapter2.encodedSizeWithTag(7, value.brightness) + protoAdapter2.encodedSizeWithTag(8, value.contrast) + protoAdapter2.encodedSizeWithTag(9, value.hue) + protoAdapter2.encodedSizeWithTag(10, value.highlights) + protoAdapter2.encodedSizeWithTag(11, value.shadows) + protoAdapter2.encodedSizeWithTag(12, value.saturation) + protoAdapter2.encodedSizeWithTag(13, value.temperature) + protoAdapter3.encodedSizeWithTag(14, value.src) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public PostEffect redact(@NotNull PostEffect value) {
                PostEffect copy;
                Intrinsics.checkParameterIsNotNull(value, "value");
                copy = value.copy((r32 & 1) != 0 ? value.entityId : null, (r32 & 2) != 0 ? value.componentID : null, (r32 & 4) != 0 ? value.enabled : null, (r32 & 8) != 0 ? value.type : null, (r32 & 16) != 0 ? value.effectType : null, (r32 & 32) != 0 ? value.sharpness : null, (r32 & 64) != 0 ? value.brightness : null, (r32 & 128) != 0 ? value.contrast : null, (r32 & 256) != 0 ? value.hue : null, (r32 & 512) != 0 ? value.highlights : null, (r32 & 1024) != 0 ? value.shadows : null, (r32 & 2048) != 0 ? value.saturation : null, (r32 & 4096) != 0 ? value.temperature : null, (r32 & 8192) != 0 ? value.src : null, (r32 & 16384) != 0 ? value.unknownFields() : ByteString.EMPTY);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public PostEffect() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    @NotNull
    public final PostEffect copy(@Nullable Integer entityId, @Nullable Integer componentID, @Nullable Boolean enabled, @Nullable String type, @Nullable String effectType, @Nullable Integer sharpness, @Nullable Integer brightness, @Nullable Integer contrast, @Nullable Integer hue, @Nullable Integer highlights, @Nullable Integer shadows, @Nullable Integer saturation, @Nullable Integer temperature, @Nullable String src, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new PostEffect(entityId, componentID, enabled, type, effectType, sharpness, brightness, contrast, hue, highlights, shadows, saturation, temperature, src, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof PostEffect)) {
            return false;
        }
        PostEffect postEffect = (PostEffect) other;
        if (Intrinsics.areEqual(unknownFields(), postEffect.unknownFields()) && Intrinsics.areEqual(this.entityId, postEffect.entityId) && Intrinsics.areEqual(this.componentID, postEffect.componentID) && Intrinsics.areEqual(this.enabled, postEffect.enabled) && Intrinsics.areEqual(this.type, postEffect.type) && Intrinsics.areEqual(this.effectType, postEffect.effectType) && Intrinsics.areEqual(this.sharpness, postEffect.sharpness) && Intrinsics.areEqual(this.brightness, postEffect.brightness) && Intrinsics.areEqual(this.contrast, postEffect.contrast) && Intrinsics.areEqual(this.hue, postEffect.hue) && Intrinsics.areEqual(this.highlights, postEffect.highlights) && Intrinsics.areEqual(this.shadows, postEffect.shadows) && Intrinsics.areEqual(this.saturation, postEffect.saturation) && Intrinsics.areEqual(this.temperature, postEffect.temperature) && Intrinsics.areEqual(this.src, postEffect.src)) {
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
            Integer num = this.entityId;
            int i47 = 0;
            if (num != null) {
                i3 = num.hashCode();
            } else {
                i3 = 0;
            }
            int i48 = (hashCode + i3) * 37;
            Integer num2 = this.componentID;
            if (num2 != null) {
                i16 = num2.hashCode();
            } else {
                i16 = 0;
            }
            int i49 = (i48 + i16) * 37;
            Boolean bool = this.enabled;
            if (bool != null) {
                i17 = bool.hashCode();
            } else {
                i17 = 0;
            }
            int i56 = (i49 + i17) * 37;
            String str = this.type;
            if (str != null) {
                i18 = str.hashCode();
            } else {
                i18 = 0;
            }
            int i57 = (i56 + i18) * 37;
            String str2 = this.effectType;
            if (str2 != null) {
                i19 = str2.hashCode();
            } else {
                i19 = 0;
            }
            int i58 = (i57 + i19) * 37;
            Integer num3 = this.sharpness;
            if (num3 != null) {
                i26 = num3.hashCode();
            } else {
                i26 = 0;
            }
            int i59 = (i58 + i26) * 37;
            Integer num4 = this.brightness;
            if (num4 != null) {
                i27 = num4.hashCode();
            } else {
                i27 = 0;
            }
            int i65 = (i59 + i27) * 37;
            Integer num5 = this.contrast;
            if (num5 != null) {
                i28 = num5.hashCode();
            } else {
                i28 = 0;
            }
            int i66 = (i65 + i28) * 37;
            Integer num6 = this.hue;
            if (num6 != null) {
                i29 = num6.hashCode();
            } else {
                i29 = 0;
            }
            int i67 = (i66 + i29) * 37;
            Integer num7 = this.highlights;
            if (num7 != null) {
                i36 = num7.hashCode();
            } else {
                i36 = 0;
            }
            int i68 = (i67 + i36) * 37;
            Integer num8 = this.shadows;
            if (num8 != null) {
                i37 = num8.hashCode();
            } else {
                i37 = 0;
            }
            int i69 = (i68 + i37) * 37;
            Integer num9 = this.saturation;
            if (num9 != null) {
                i38 = num9.hashCode();
            } else {
                i38 = 0;
            }
            int i75 = (i69 + i38) * 37;
            Integer num10 = this.temperature;
            if (num10 != null) {
                i39 = num10.hashCode();
            } else {
                i39 = 0;
            }
            int i76 = (i75 + i39) * 37;
            String str3 = this.src;
            if (str3 != null) {
                i47 = str3.hashCode();
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
        if (this.effectType != null) {
            arrayList.add("effectType=" + Internal.sanitize(this.effectType));
        }
        if (this.sharpness != null) {
            arrayList.add("sharpness=" + this.sharpness);
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
        if (this.shadows != null) {
            arrayList.add("shadows=" + this.shadows);
        }
        if (this.saturation != null) {
            arrayList.add("saturation=" + this.saturation);
        }
        if (this.temperature != null) {
            arrayList.add("temperature=" + this.temperature);
        }
        if (this.src != null) {
            arrayList.add("src=" + Internal.sanitize(this.src));
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "PostEffect{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ PostEffect(Integer num, Integer num2, Boolean bool, String str, String str2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, String str3, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : num2, (i3 & 4) != 0 ? null : bool, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : str2, (i3 & 32) != 0 ? null : num3, (i3 & 64) != 0 ? null : num4, (i3 & 128) != 0 ? null : num5, (i3 & 256) != 0 ? null : num6, (i3 & 512) != 0 ? null : num7, (i3 & 1024) != 0 ? null : num8, (i3 & 2048) != 0 ? null : num9, (i3 & 4096) != 0 ? null : num10, (i3 & 8192) == 0 ? str3 : null, (i3 & 16384) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.entityId = this.entityId;
        builder.componentID = this.componentID;
        builder.enabled = this.enabled;
        builder.type = this.type;
        builder.effectType = this.effectType;
        builder.sharpness = this.sharpness;
        builder.brightness = this.brightness;
        builder.contrast = this.contrast;
        builder.hue = this.hue;
        builder.highlights = this.highlights;
        builder.shadows = this.shadows;
        builder.saturation = this.saturation;
        builder.temperature = this.temperature;
        builder.src = this.src;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostEffect(@Nullable Integer num, @Nullable Integer num2, @Nullable Boolean bool, @Nullable String str, @Nullable String str2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5, @Nullable Integer num6, @Nullable Integer num7, @Nullable Integer num8, @Nullable Integer num9, @Nullable Integer num10, @Nullable String str3, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.entityId = num;
        this.componentID = num2;
        this.enabled = bool;
        this.type = str;
        this.effectType = str2;
        this.sharpness = num3;
        this.brightness = num4;
        this.contrast = num5;
        this.hue = num6;
        this.highlights = num7;
        this.shadows = num8;
        this.saturation = num9;
        this.temperature = num10;
        this.src = str3;
    }
}
