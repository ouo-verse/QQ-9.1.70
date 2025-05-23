package com.tencent.tavcut.rendermodel.parser;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.msf.core.auth.k;
import com.tencent.tavcut.composition.model.component.EntityIdentifier;
import com.tencent.tavcut.composition.model.component.Priority;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0003\u0011\u0012\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/tavcut/rendermodel/parser/LightJsonExporter;", "", "()V", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "toComponentJson", "", HippyQQConstants.URL_COMPONENT_NAME, "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "toEntityJson", "entity", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "toTemplateFullJson", "model", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "toTemplateJson", "Companion", "IdentifyComponentTypeAdapter", "RenderModelExclusionStrategy", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class LightJsonExporter {
    private static final Set<String> SKIP_FILED_NAMES;
    private final Gson gson = new GsonBuilder().registerTypeAdapter(IdentifyComponent.class, new IdentifyComponentTypeAdapter()).setExclusionStrategies(new RenderModelExclusionStrategy()).serializeSpecialFloatingPointValues().setPrettyPrinting().create();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/tavcut/rendermodel/parser/LightJsonExporter$IdentifyComponentTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "(Lcom/tencent/tavcut/rendermodel/parser/LightJsonExporter;)V", k.f247491e, "in", "Lcom/google/gson/stream/JsonReader;", k.f247492f, "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public final class IdentifyComponentTypeAdapter extends TypeAdapter<IdentifyComponent> {
        public IdentifyComponentTypeAdapter() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        @NotNull
        /* renamed from: read */
        public IdentifyComponent read2(@Nullable JsonReader in5) {
            Object fromJson = new Gson().fromJson(in5, IdentifyComponent.class);
            Intrinsics.checkExpressionValueIsNotNull(fromJson, "Gson().fromJson(`in`, Id\u2026ifyComponent::class.java)");
            return (IdentifyComponent) fromJson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(@Nullable JsonWriter out, @Nullable IdentifyComponent value) {
            JsonObject rawData;
            JsonObject deepCopy;
            JsonElement jsonTree = LightJsonExporter.this.gson.toJsonTree(value != null ? value.getData() : null);
            if (!(jsonTree instanceof JsonObject)) {
                jsonTree = null;
            }
            JsonObject jsonObject = (JsonObject) jsonTree;
            if (jsonObject != null) {
                if ((value != null ? value.getData() : null) instanceof Priority) {
                    return;
                }
                if ((value != null ? value.getData() : null) instanceof EntityIdentifier) {
                    jsonObject.addProperty("id", value.getEntityId());
                } else {
                    jsonObject.addProperty(TemplateParser.KEY_COMPONENT_ID, value != null ? value.getId() : null);
                    jsonObject.addProperty(TemplateParser.KEY_ENTITY_ID, value != null ? value.getEntityId() : null);
                }
                if (value != null && (rawData = value.getRawData()) != null && (deepCopy = rawData.deepCopy()) != null) {
                    Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
                    Intrinsics.checkExpressionValueIsNotNull(entrySet, "element.entrySet()");
                    Iterator<T> it = entrySet.iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        deepCopy.add((String) entry.getKey(), (JsonElement) entry.getValue());
                    }
                    if ((out != null ? out.jsonValue(LightJsonExporter.this.gson.toJson((JsonElement) deepCopy)) : null) != null) {
                        return;
                    }
                }
                if (out != null) {
                    out.jsonValue(LightJsonExporter.this.gson.toJson((JsonElement) jsonObject));
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/tavcut/rendermodel/parser/LightJsonExporter$RenderModelExclusionStrategy;", "Lcom/google/gson/ExclusionStrategy;", "(Lcom/tencent/tavcut/rendermodel/parser/LightJsonExporter;)V", "shouldSkipClass", "", "clazz", "Ljava/lang/Class;", "shouldSkipField", "f", "Lcom/google/gson/FieldAttributes;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    private final class RenderModelExclusionStrategy implements ExclusionStrategy {
        public RenderModelExclusionStrategy() {
        }

        @Override // com.google.gson.ExclusionStrategy
        public boolean shouldSkipClass(@Nullable Class<?> clazz) {
            return false;
        }

        @Override // com.google.gson.ExclusionStrategy
        public boolean shouldSkipField(@Nullable FieldAttributes f16) {
            String str;
            String str2 = null;
            if (f16 != null) {
                str = f16.getName();
            } else {
                str = null;
            }
            if (str != null) {
                Set set = LightJsonExporter.SKIP_FILED_NAMES;
                if (f16 != null) {
                    str2 = f16.getName();
                }
                return set.contains(str2);
            }
            return false;
        }
    }

    static {
        Set<String> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"renderScene", "timeLines", "clipsAssets", "painting", "modifyClipsDuration", "seekTolerance", "voiceChangerConfig"});
        SKIP_FILED_NAMES = of5;
    }

    @NotNull
    public final String toComponentJson(@NotNull IdentifyComponent component) {
        Intrinsics.checkParameterIsNotNull(component, "component");
        String json = this.gson.toJson(component);
        Intrinsics.checkExpressionValueIsNotNull(json, "gson.toJson(component)");
        return json;
    }

    @NotNull
    public final String toEntityJson(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        String json = this.gson.toJson(entity);
        Intrinsics.checkExpressionValueIsNotNull(json, "gson.toJson(entity)");
        return json;
    }

    @NotNull
    public final String toTemplateFullJson(@NotNull RenderModel model) {
        Intrinsics.checkParameterIsNotNull(model, "model");
        String json = new GsonBuilder().registerTypeAdapter(IdentifyComponent.class, new IdentifyComponentTypeAdapter()).serializeSpecialFloatingPointValues().setPrettyPrinting().create().toJson(model);
        Intrinsics.checkExpressionValueIsNotNull(json, "localGson.toJson(model)");
        return json;
    }

    @NotNull
    public final String toTemplateJson(@NotNull RenderModel model) {
        Intrinsics.checkParameterIsNotNull(model, "model");
        String json = this.gson.toJson(model);
        Intrinsics.checkExpressionValueIsNotNull(json, "gson.toJson(model)");
        return json;
    }
}
