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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002 !B\u00a1\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\u0002\u0010\u0015J\u00a7\u0001\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u00102\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\tH\u0016R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u00128\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0016R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0016R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0016R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u00108\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/tavcut/composition/model/component/AITextureComponent;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/AITextureComponent$Builder;", TemplateParser.KEY_COMPONENT_ID, "", NodeProps.ENABLED, "", TemplateParser.KEY_ENTITY_ID, "type", "", "version", "level", "aiType", "isRealTimeResult", "aiInputType", "renderTargetList", "", "aiTextureInputParams", "", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/AITextureComponent;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class AITextureComponent extends AndroidMessage<AITextureComponent, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<AITextureComponent> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<AITextureComponent> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    @JvmField
    @Nullable
    public final String aiInputType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    @JvmField
    @NotNull
    public final Map<String, Boolean> aiTextureInputParams;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    @JvmField
    @Nullable
    public final String aiType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @JvmField
    @Nullable
    public final Integer componentID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 2)
    @JvmField
    @Nullable
    public final Boolean enabled;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    @JvmField
    @Nullable
    public final Integer entityId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    @JvmField
    @Nullable
    public final Boolean isRealTimeResult;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    @JvmField
    @Nullable
    public final Integer level;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 10)
    @JvmField
    @NotNull
    public final List<String> renderTargetList;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @JvmField
    @Nullable
    public final String type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    @JvmField
    @Nullable
    public final Integer version;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u0006\u001a\u00020\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0015\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u0017J\u0015\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u0018J\u0015\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u0017J\u0015\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u0018J\u0015\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u0017J\u0014\u0010\u0012\u001a\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\u0015\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\fR\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/AITextureComponent$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/AITextureComponent;", "()V", "aiInputType", "", "aiTextureInputParams", "", "", "aiType", TemplateParser.KEY_COMPONENT_ID, "", "Ljava/lang/Integer;", NodeProps.ENABLED, "Ljava/lang/Boolean;", TemplateParser.KEY_ENTITY_ID, "isRealTimeResult", "level", "renderTargetList", "", "type", "version", "build", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/AITextureComponent$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/AITextureComponent$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<AITextureComponent, Builder> {

        @JvmField
        @Nullable
        public String aiInputType;

        @JvmField
        @NotNull
        public Map<String, Boolean> aiTextureInputParams;

        @JvmField
        @Nullable
        public String aiType;

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
        public Boolean isRealTimeResult;

        @JvmField
        @Nullable
        public Integer level;

        @JvmField
        @NotNull
        public List<String> renderTargetList;

        @JvmField
        @Nullable
        public String type;

        @JvmField
        @Nullable
        public Integer version;

        public Builder() {
            List<String> emptyList;
            Map<String, Boolean> emptyMap;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.renderTargetList = emptyList;
            emptyMap = MapsKt__MapsKt.emptyMap();
            this.aiTextureInputParams = emptyMap;
        }

        @NotNull
        public final Builder aiInputType(@Nullable String aiInputType) {
            this.aiInputType = aiInputType;
            return this;
        }

        @NotNull
        public final Builder aiTextureInputParams(@NotNull Map<String, Boolean> aiTextureInputParams) {
            Intrinsics.checkParameterIsNotNull(aiTextureInputParams, "aiTextureInputParams");
            this.aiTextureInputParams = aiTextureInputParams;
            return this;
        }

        @NotNull
        public final Builder aiType(@Nullable String aiType) {
            this.aiType = aiType;
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
        public final Builder isRealTimeResult(@Nullable Boolean isRealTimeResult) {
            this.isRealTimeResult = isRealTimeResult;
            return this;
        }

        @NotNull
        public final Builder level(@Nullable Integer level) {
            this.level = level;
            return this;
        }

        @NotNull
        public final Builder renderTargetList(@NotNull List<String> renderTargetList) {
            Intrinsics.checkParameterIsNotNull(renderTargetList, "renderTargetList");
            Internal.checkElementsNotNull(renderTargetList);
            this.renderTargetList = renderTargetList;
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

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public AITextureComponent build() {
            return new AITextureComponent(this.componentID, this.enabled, this.entityId, this.type, this.version, this.level, this.aiType, this.isRealTimeResult, this.aiInputType, this.renderTargetList, this.aiTextureInputParams, buildUnknownFields());
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(AITextureComponent.class);
        final String str = "type.googleapis.com/publisher.AITextureComponent";
        ProtoAdapter<AITextureComponent> protoAdapter = new ProtoAdapter<AITextureComponent>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.AITextureComponent$Companion$ADAPTER$1
            private final ProtoAdapter<Map<String, Boolean>> aiTextureInputParamsAdapter = ProtoAdapter.INSTANCE.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.BOOL);

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public AITextureComponent decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                ArrayList arrayList = new ArrayList();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                long beginMessage = reader.beginMessage();
                Integer num = null;
                Boolean bool = null;
                Integer num2 = null;
                String str2 = null;
                Integer num3 = null;
                Integer num4 = null;
                String str3 = null;
                Boolean bool2 = null;
                String str4 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new AITextureComponent(num, bool, num2, str2, num3, num4, str3, bool2, str4, arrayList, linkedHashMap, reader.endMessageAndGetUnknownFields(beginMessage));
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
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            num3 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 6:
                            num4 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 7:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 8:
                            bool2 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 9:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 10:
                            arrayList.add(ProtoAdapter.STRING.decode(reader));
                            break;
                        case 11:
                            linkedHashMap.putAll(this.aiTextureInputParamsAdapter.decode(reader));
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull AITextureComponent value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                protoAdapter2.encodeWithTag(writer, 1, value.componentID);
                ProtoAdapter<Boolean> protoAdapter3 = ProtoAdapter.BOOL;
                protoAdapter3.encodeWithTag(writer, 2, value.enabled);
                protoAdapter2.encodeWithTag(writer, 3, value.entityId);
                ProtoAdapter<String> protoAdapter4 = ProtoAdapter.STRING;
                protoAdapter4.encodeWithTag(writer, 4, value.type);
                protoAdapter2.encodeWithTag(writer, 5, value.version);
                protoAdapter2.encodeWithTag(writer, 6, value.level);
                protoAdapter4.encodeWithTag(writer, 7, value.aiType);
                protoAdapter3.encodeWithTag(writer, 8, value.isRealTimeResult);
                protoAdapter4.encodeWithTag(writer, 9, value.aiInputType);
                protoAdapter4.asRepeated().encodeWithTag(writer, 10, value.renderTargetList);
                this.aiTextureInputParamsAdapter.encodeWithTag(writer, 11, value.aiTextureInputParams);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull AITextureComponent value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.componentID);
                ProtoAdapter<Boolean> protoAdapter3 = ProtoAdapter.BOOL;
                int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(2, value.enabled) + protoAdapter2.encodedSizeWithTag(3, value.entityId);
                ProtoAdapter<String> protoAdapter4 = ProtoAdapter.STRING;
                return encodedSizeWithTag2 + protoAdapter4.encodedSizeWithTag(4, value.type) + protoAdapter2.encodedSizeWithTag(5, value.version) + protoAdapter2.encodedSizeWithTag(6, value.level) + protoAdapter4.encodedSizeWithTag(7, value.aiType) + protoAdapter3.encodedSizeWithTag(8, value.isRealTimeResult) + protoAdapter4.encodedSizeWithTag(9, value.aiInputType) + protoAdapter4.asRepeated().encodedSizeWithTag(10, value.renderTargetList) + this.aiTextureInputParamsAdapter.encodedSizeWithTag(11, value.aiTextureInputParams) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public AITextureComponent redact(@NotNull AITextureComponent value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                return AITextureComponent.copy$default(value, null, null, null, null, null, null, null, null, null, null, null, ByteString.EMPTY, 2047, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public AITextureComponent() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    public static /* synthetic */ AITextureComponent copy$default(AITextureComponent aITextureComponent, Integer num, Boolean bool, Integer num2, String str, Integer num3, Integer num4, String str2, Boolean bool2, String str3, List list, Map map, ByteString byteString, int i3, Object obj) {
        Integer num5;
        Boolean bool3;
        Integer num6;
        String str4;
        Integer num7;
        Integer num8;
        String str5;
        Boolean bool4;
        String str6;
        List list2;
        Map map2;
        ByteString byteString2;
        if ((i3 & 1) != 0) {
            num5 = aITextureComponent.componentID;
        } else {
            num5 = num;
        }
        if ((i3 & 2) != 0) {
            bool3 = aITextureComponent.enabled;
        } else {
            bool3 = bool;
        }
        if ((i3 & 4) != 0) {
            num6 = aITextureComponent.entityId;
        } else {
            num6 = num2;
        }
        if ((i3 & 8) != 0) {
            str4 = aITextureComponent.type;
        } else {
            str4 = str;
        }
        if ((i3 & 16) != 0) {
            num7 = aITextureComponent.version;
        } else {
            num7 = num3;
        }
        if ((i3 & 32) != 0) {
            num8 = aITextureComponent.level;
        } else {
            num8 = num4;
        }
        if ((i3 & 64) != 0) {
            str5 = aITextureComponent.aiType;
        } else {
            str5 = str2;
        }
        if ((i3 & 128) != 0) {
            bool4 = aITextureComponent.isRealTimeResult;
        } else {
            bool4 = bool2;
        }
        if ((i3 & 256) != 0) {
            str6 = aITextureComponent.aiInputType;
        } else {
            str6 = str3;
        }
        if ((i3 & 512) != 0) {
            list2 = aITextureComponent.renderTargetList;
        } else {
            list2 = list;
        }
        if ((i3 & 1024) != 0) {
            map2 = aITextureComponent.aiTextureInputParams;
        } else {
            map2 = map;
        }
        if ((i3 & 2048) != 0) {
            byteString2 = aITextureComponent.unknownFields();
        } else {
            byteString2 = byteString;
        }
        return aITextureComponent.copy(num5, bool3, num6, str4, num7, num8, str5, bool4, str6, list2, map2, byteString2);
    }

    @NotNull
    public final AITextureComponent copy(@Nullable Integer componentID, @Nullable Boolean enabled, @Nullable Integer entityId, @Nullable String type, @Nullable Integer version, @Nullable Integer level, @Nullable String aiType, @Nullable Boolean isRealTimeResult, @Nullable String aiInputType, @NotNull List<String> renderTargetList, @NotNull Map<String, Boolean> aiTextureInputParams, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(renderTargetList, "renderTargetList");
        Intrinsics.checkParameterIsNotNull(aiTextureInputParams, "aiTextureInputParams");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new AITextureComponent(componentID, enabled, entityId, type, version, level, aiType, isRealTimeResult, aiInputType, renderTargetList, aiTextureInputParams, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof AITextureComponent)) {
            return false;
        }
        AITextureComponent aITextureComponent = (AITextureComponent) other;
        if (Intrinsics.areEqual(unknownFields(), aITextureComponent.unknownFields()) && Intrinsics.areEqual(this.componentID, aITextureComponent.componentID) && Intrinsics.areEqual(this.enabled, aITextureComponent.enabled) && Intrinsics.areEqual(this.entityId, aITextureComponent.entityId) && Intrinsics.areEqual(this.type, aITextureComponent.type) && Intrinsics.areEqual(this.version, aITextureComponent.version) && Intrinsics.areEqual(this.level, aITextureComponent.level) && Intrinsics.areEqual(this.aiType, aITextureComponent.aiType) && Intrinsics.areEqual(this.isRealTimeResult, aITextureComponent.isRealTimeResult) && Intrinsics.areEqual(this.aiInputType, aITextureComponent.aiInputType) && Intrinsics.areEqual(this.renderTargetList, aITextureComponent.renderTargetList) && Intrinsics.areEqual(this.aiTextureInputParams, aITextureComponent.aiTextureInputParams)) {
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
            Integer num = this.componentID;
            int i36 = 0;
            if (num != null) {
                i3 = num.hashCode();
            } else {
                i3 = 0;
            }
            int i37 = (hashCode + i3) * 37;
            Boolean bool = this.enabled;
            if (bool != null) {
                i16 = bool.hashCode();
            } else {
                i16 = 0;
            }
            int i38 = (i37 + i16) * 37;
            Integer num2 = this.entityId;
            if (num2 != null) {
                i17 = num2.hashCode();
            } else {
                i17 = 0;
            }
            int i39 = (i38 + i17) * 37;
            String str = this.type;
            if (str != null) {
                i18 = str.hashCode();
            } else {
                i18 = 0;
            }
            int i46 = (i39 + i18) * 37;
            Integer num3 = this.version;
            if (num3 != null) {
                i19 = num3.hashCode();
            } else {
                i19 = 0;
            }
            int i47 = (i46 + i19) * 37;
            Integer num4 = this.level;
            if (num4 != null) {
                i26 = num4.hashCode();
            } else {
                i26 = 0;
            }
            int i48 = (i47 + i26) * 37;
            String str2 = this.aiType;
            if (str2 != null) {
                i27 = str2.hashCode();
            } else {
                i27 = 0;
            }
            int i49 = (i48 + i27) * 37;
            Boolean bool2 = this.isRealTimeResult;
            if (bool2 != null) {
                i28 = bool2.hashCode();
            } else {
                i28 = 0;
            }
            int i56 = (i49 + i28) * 37;
            String str3 = this.aiInputType;
            if (str3 != null) {
                i36 = str3.hashCode();
            }
            int hashCode2 = ((((i56 + i36) * 37) + this.renderTargetList.hashCode()) * 37) + this.aiTextureInputParams.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i29;
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
        if (this.type != null) {
            arrayList.add("type=" + Internal.sanitize(this.type));
        }
        if (this.version != null) {
            arrayList.add("version=" + this.version);
        }
        if (this.level != null) {
            arrayList.add("level=" + this.level);
        }
        if (this.aiType != null) {
            arrayList.add("aiType=" + Internal.sanitize(this.aiType));
        }
        if (this.isRealTimeResult != null) {
            arrayList.add("isRealTimeResult=" + this.isRealTimeResult);
        }
        if (this.aiInputType != null) {
            arrayList.add("aiInputType=" + Internal.sanitize(this.aiInputType));
        }
        if (!this.renderTargetList.isEmpty()) {
            arrayList.add("renderTargetList=" + Internal.sanitize(this.renderTargetList));
        }
        if (!this.aiTextureInputParams.isEmpty()) {
            arrayList.add("aiTextureInputParams=" + this.aiTextureInputParams);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "AITextureComponent{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ AITextureComponent(Integer num, Boolean bool, Integer num2, String str, Integer num3, Integer num4, String str2, Boolean bool2, String str3, List list, Map map, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : bool, (i3 & 4) != 0 ? null : num2, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : num3, (i3 & 32) != 0 ? null : num4, (i3 & 64) != 0 ? null : str2, (i3 & 128) != 0 ? null : bool2, (i3 & 256) == 0 ? str3 : null, (i3 & 512) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 1024) != 0 ? MapsKt__MapsKt.emptyMap() : map, (i3 & 2048) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.componentID = this.componentID;
        builder.enabled = this.enabled;
        builder.entityId = this.entityId;
        builder.type = this.type;
        builder.version = this.version;
        builder.level = this.level;
        builder.aiType = this.aiType;
        builder.isRealTimeResult = this.isRealTimeResult;
        builder.aiInputType = this.aiInputType;
        builder.renderTargetList = this.renderTargetList;
        builder.aiTextureInputParams = this.aiTextureInputParams;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AITextureComponent(@Nullable Integer num, @Nullable Boolean bool, @Nullable Integer num2, @Nullable String str, @Nullable Integer num3, @Nullable Integer num4, @Nullable String str2, @Nullable Boolean bool2, @Nullable String str3, @NotNull List<String> renderTargetList, @NotNull Map<String, Boolean> aiTextureInputParams, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(renderTargetList, "renderTargetList");
        Intrinsics.checkParameterIsNotNull(aiTextureInputParams, "aiTextureInputParams");
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.componentID = num;
        this.enabled = bool;
        this.entityId = num2;
        this.type = str;
        this.version = num3;
        this.level = num4;
        this.aiType = str2;
        this.isRealTimeResult = bool2;
        this.aiInputType = str3;
        this.renderTargetList = renderTargetList;
        this.aiTextureInputParams = aiTextureInputParams;
    }
}
