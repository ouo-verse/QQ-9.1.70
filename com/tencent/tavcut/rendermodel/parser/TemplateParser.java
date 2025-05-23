package com.tencent.tavcut.rendermodel.parser;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tencent.ark.ark;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001fJ\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\"2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0007J\u000e\u0010%\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/tencent/tavcut/rendermodel/parser/TemplateParser;", "", "()V", "COMPONENT_ID_INVALID", "", "ENTITY_ID_INVALID", "KEY_COMPONENT_ID", "", "KEY_ENTITY_ID", "KEY_ID", "KEY_TYPE", "TAG", "exporter", "Lcom/tencent/tavcut/rendermodel/parser/LightJsonExporter;", "gson", "Lcom/google/gson/Gson;", "reader", "Lcom/tencent/tavcut/rendermodel/parser/LightJsonReader;", "dumpFullJson", "model", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "dumpInputSource", "inputSource", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "dumpJson", HippyQQConstants.URL_COMPONENT_NAME, "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "entity", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "fromFile", "jsonFile", "Ljava/io/File;", "fromFileEntity", "fromFileInputSource", "", "fromFullJson", ark.ARKMETADATA_JSON, "fromJson", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class TemplateParser {
    public static final int COMPONENT_ID_INVALID = -1;
    public static final int ENTITY_ID_INVALID = -1;

    @NotNull
    public static final String KEY_COMPONENT_ID = "componentID";

    @NotNull
    public static final String KEY_ENTITY_ID = "entityId";

    @NotNull
    public static final String KEY_ID = "id";

    @NotNull
    public static final String KEY_TYPE = "type";
    private static final String TAG = "TemplateParser";
    public static final TemplateParser INSTANCE = new TemplateParser();
    private static final Gson gson = new Gson();
    private static final LightJsonReader reader = new LightJsonReader();
    private static final LightJsonExporter exporter = new LightJsonExporter();

    TemplateParser() {
    }

    @NotNull
    public final String dumpFullJson(@NotNull RenderModel model) {
        Intrinsics.checkParameterIsNotNull(model, "model");
        return exporter.toTemplateFullJson(model);
    }

    @NotNull
    public final String dumpInputSource(@NotNull InputSource inputSource) {
        Map mapOf;
        Intrinsics.checkParameterIsNotNull(inputSource, "inputSource");
        Gson gson2 = gson;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(inputSource.key, inputSource));
        String json = gson2.toJson(mapOf);
        Intrinsics.checkExpressionValueIsNotNull(json, "gson.toJson(mapOf(inputSource.key to inputSource))");
        return json;
    }

    @NotNull
    public final String dumpJson(@NotNull RenderModel model) {
        Intrinsics.checkParameterIsNotNull(model, "model");
        return exporter.toTemplateJson(model);
    }

    @Nullable
    public final RenderModel fromFile(@NotNull File jsonFile) {
        Intrinsics.checkParameterIsNotNull(jsonFile, "jsonFile");
        try {
            if (jsonFile.exists()) {
                return reader.readRenderModel(new JsonReader(new FileReader(jsonFile)));
            }
            return null;
        } catch (Exception e16) {
            Log.e(TAG, "fromFile() called with: jsonFile = " + jsonFile, e16);
            return null;
        }
    }

    @Nullable
    public final Entity fromFileEntity(@NotNull File jsonFile) {
        Intrinsics.checkParameterIsNotNull(jsonFile, "jsonFile");
        try {
            if (jsonFile.exists()) {
                return reader.readAllEntity(new JsonReader(new FileReader(jsonFile)));
            }
            return null;
        } catch (Exception e16) {
            Log.e(TAG, "fromFileEntity() called with: jsonFile = " + jsonFile, e16);
            return null;
        }
    }

    @NotNull
    public final Map<String, InputSource> fromFileInputSource(@NotNull File jsonFile) {
        Map<String, InputSource> emptyMap;
        Intrinsics.checkParameterIsNotNull(jsonFile, "jsonFile");
        try {
            if (jsonFile.exists()) {
                return reader.readAllInputSource(new JsonReader(new FileReader(jsonFile)));
            }
        } catch (Exception e16) {
            Log.e(TAG, "fromFileInputSource() called with: jsonFile = " + jsonFile, e16);
        }
        emptyMap = MapsKt__MapsKt.emptyMap();
        return emptyMap;
    }

    @NotNull
    public final RenderModel fromFullJson(@NotNull String json) {
        Intrinsics.checkParameterIsNotNull(json, "json");
        return reader.readFullRenderModel(json);
    }

    @NotNull
    public final RenderModel fromJson(@NotNull String json) {
        Intrinsics.checkParameterIsNotNull(json, "json");
        return reader.readRenderModel(new JsonReader(new StringReader(json)));
    }

    @NotNull
    public final String dumpJson(@NotNull IdentifyComponent component) {
        Intrinsics.checkParameterIsNotNull(component, "component");
        return exporter.toComponentJson(component);
    }

    @NotNull
    public final String dumpJson(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        return exporter.toEntityJson(entity);
    }
}
