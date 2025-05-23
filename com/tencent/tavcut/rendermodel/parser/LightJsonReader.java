package com.tencent.tavcut.rendermodel.parser;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.tavcut.composition.model.component.AITextureComponent;
import com.tencent.tavcut.composition.model.component.AudioSource;
import com.tencent.tavcut.composition.model.component.Beauty;
import com.tencent.tavcut.composition.model.component.CameraComponent;
import com.tencent.tavcut.composition.model.component.CustomGraph;
import com.tencent.tavcut.composition.model.component.EntityIdentifier;
import com.tencent.tavcut.composition.model.component.FaceTracking;
import com.tencent.tavcut.composition.model.component.FilterGroup;
import com.tencent.tavcut.composition.model.component.GAN;
import com.tencent.tavcut.composition.model.component.Image;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.LUTFilter;
import com.tencent.tavcut.composition.model.component.MultiMedia;
import com.tencent.tavcut.composition.model.component.PAGAsset;
import com.tencent.tavcut.composition.model.component.PostEffect;
import com.tencent.tavcut.composition.model.component.RandomGroup;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import com.tencent.tavcut.composition.model.component.Script;
import com.tencent.tavcut.composition.model.component.Smooth;
import com.tencent.tavcut.composition.model.component.Stretch;
import com.tencent.tavcut.composition.model.component.SubAssetComponent;
import com.tencent.tavcut.composition.model.component.TimeOffset;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.composition.model.component.Transition;
import com.tencent.tavcut.composition.model.component.TransitionTrigger;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.rendermodel.properties.Layout;
import com.tencent.tavcut.rendermodel.properties.Properties;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000f\n\u0002\u0010\u001c\n\u0002\b\u0006*\u0001\u000b\u0018\u0000 42\u00020\u0001:\u0003345B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0018\u001a\u00020\u0019J\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001b0\u00072\u0006\u0010\u0018\u001a\u00020\u0019J0\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u001d\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u0002H\u001e0 H\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0015\u0010#\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0000\u00a2\u0006\u0002\b$J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\bJ\u001c\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001b0\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0015\u0010)\u001a\u00020*2\u0006\u0010\u0018\u001a\u00020\u0019H\u0000\u00a2\u0006\u0002\b+J\u000e\u0010,\u001a\u00020&2\u0006\u0010\u0018\u001a\u00020\u0019JB\u0010-\u001a\u0002H.\"\u0004\b\u0000\u0010\u001e\"\u000e\b\u0001\u0010.*\b\u0012\u0004\u0012\u0002H.0/*\b\u0012\u0004\u0012\u0002H\u001e002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H.0 H\u0082\b\u00a2\u0006\u0002\u00102R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\f\u00a8\u00066"}, d2 = {"Lcom/tencent/tavcut/rendermodel/parser/LightJsonReader;", "", "()V", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "supportComponentTable", "", "", "Ljava/lang/Class;", "timeRangeDecoder", "com/tencent/tavcut/rendermodel/parser/LightJsonReader$timeRangeDecoder$1", "Lcom/tencent/tavcut/rendermodel/parser/LightJsonReader$timeRangeDecoder$1;", "findMaxCid", "", "prevMax", "entity", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "fixComponentId", "root", "fixEntityIterate", "emitter", "Lcom/tencent/tavcut/rendermodel/parser/LightJsonReader$CidEmitter;", "readAllEntity", "reader", "Lcom/google/gson/stream/JsonReader;", "readAllInputSource", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "readArray", "", "T", "inner", "Lkotlin/Function1;", "readComponent", "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "readEntity", "readEntity$lib_tavcut_model_release", "readFullRenderModel", "Lcom/tencent/tavcut/rendermodel/RenderModel;", ark.ARKMETADATA_JSON, "readInputSource", "readProperties", "Lcom/tencent/tavcut/rendermodel/properties/Properties;", "readProperties$lib_tavcut_model_release", "readRenderModel", "maxOf", BdhLogUtil.LogTag.Tag_Req, "", "", "selector", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "CidEmitter", "Companion", "ReaderExclusionStrategy", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class LightJsonReader {
    private static final Set<String> SKIP_NAMES;
    private final Gson gson;
    private final Map<String, Class<?>> supportComponentTable;
    private final LightJsonReader$timeRangeDecoder$1 timeRangeDecoder;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/tavcut/rendermodel/parser/LightJsonReader$CidEmitter;", "", "max", "", "(I)V", "getMax", "()I", "setMax", "next", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class CidEmitter {
        private int max;

        public CidEmitter(int i3) {
            this.max = i3;
        }

        public final int getMax() {
            return this.max;
        }

        public final int next() {
            int i3 = this.max + 1;
            this.max = i3;
            return i3;
        }

        public final void setMax(int i3) {
            this.max = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/tavcut/rendermodel/parser/LightJsonReader$ReaderExclusionStrategy;", "Lcom/google/gson/ExclusionStrategy;", "(Lcom/tencent/tavcut/rendermodel/parser/LightJsonReader;)V", "shouldSkipClass", "", "clazz", "Ljava/lang/Class;", "shouldSkipField", "f", "Lcom/google/gson/FieldAttributes;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public final class ReaderExclusionStrategy implements ExclusionStrategy {
        public ReaderExclusionStrategy() {
        }

        @Override // com.google.gson.ExclusionStrategy
        public boolean shouldSkipClass(@Nullable Class<?> clazz) {
            return false;
        }

        @Override // com.google.gson.ExclusionStrategy
        public boolean shouldSkipField(@Nullable FieldAttributes f16) {
            String str;
            if (f16 != null) {
                str = f16.getName();
            } else {
                str = null;
            }
            if (str != null) {
                return LightJsonReader.SKIP_NAMES.contains(f16.getName());
            }
            return false;
        }
    }

    static {
        Set<String> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"root", "inputSources", Constants.Service.PROPERTIES});
        SKIP_NAMES = of5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.tavcut.rendermodel.parser.LightJsonReader$timeRangeDecoder$1, java.lang.Object] */
    public LightJsonReader() {
        Map<String, Class<?>> mapOf;
        ?? r06 = new JsonDeserializer<TimeRange>() { // from class: com.tencent.tavcut.rendermodel.parser.LightJsonReader$timeRangeDecoder$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.gson.JsonDeserializer
            @NotNull
            public TimeRange deserialize(@Nullable JsonElement json, @Nullable Type typeOfT, @Nullable JsonDeserializationContext context) {
                JsonObject asJsonObject = json != null ? json.getAsJsonObject() : null;
                if (asJsonObject != null) {
                    JsonElement jsonElement = asJsonObject.get("startTime");
                    Intrinsics.checkExpressionValueIsNotNull(jsonElement, "it.get(\"startTime\")");
                    long asLong = jsonElement.getAsLong();
                    JsonElement jsonElement2 = asJsonObject.get("duration");
                    Intrinsics.checkExpressionValueIsNotNull(jsonElement2, "it.get(\"duration\")");
                    return new TimeRange(asLong, jsonElement2.getAsLong(), null, 4, null);
                }
                return new TimeRange(0L, 0L, null, 4, null);
            }
        };
        this.timeRangeDecoder = r06;
        this.gson = new GsonBuilder().registerTypeAdapter(TimeRange.class, r06).create();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("ScreenTransform", ScreenTransform.class), TuplesKt.to("EntityIdentifier", EntityIdentifier.class), TuplesKt.to("MultiMedia", MultiMedia.class), TuplesKt.to("Camera", CameraComponent.class), TuplesKt.to("TimeOffset", TimeOffset.class), TuplesKt.to("PAGAsset", PAGAsset.class), TuplesKt.to("LUTFilter", LUTFilter.class), TuplesKt.to("FilterGroup", FilterGroup.class), TuplesKt.to("RandomGroup", RandomGroup.class), TuplesKt.to("AudioSource", AudioSource.class), TuplesKt.to("TransitionTrigger", TransitionTrigger.class), TuplesKt.to("Transition", Transition.class), TuplesKt.to("PostEffect", PostEffect.class), TuplesKt.to("SubAssetComponent", SubAssetComponent.class), TuplesKt.to("AITextureComponent", AITextureComponent.class), TuplesKt.to("Image", Image.class), TuplesKt.to("CustomGraph", CustomGraph.class), TuplesKt.to("Script", Script.class), TuplesKt.to("Stretch", Stretch.class), TuplesKt.to("Beauty", Beauty.class), TuplesKt.to("FaceTracking", FaceTracking.class), TuplesKt.to("Smooth", Smooth.class), TuplesKt.to("GAN", GAN.class));
        this.supportComponentTable = mapOf;
    }

    private final int findMaxCid(int prevMax, Entity entity) {
        int i3;
        int i16;
        Iterator<T> it = entity.getComponents().iterator();
        if (it.hasNext()) {
            Integer id5 = ((IdentifyComponent) it.next()).getId();
            if (id5 != null) {
                i3 = id5.intValue();
            } else {
                i3 = 0;
            }
            while (it.hasNext()) {
                Integer id6 = ((IdentifyComponent) it.next()).getId();
                if (id6 != null) {
                    i16 = id6.intValue();
                } else {
                    i16 = 0;
                }
                if (Intrinsics.compare(i3, i16) < 0) {
                    i3 = i16;
                }
            }
            int max = Math.max(i3, prevMax);
            if (!entity.getChildren().isEmpty()) {
                Iterator<T> it5 = entity.getChildren().iterator();
                if (it5.hasNext()) {
                    int findMaxCid = findMaxCid(max, (Entity) it5.next());
                    while (it5.hasNext()) {
                        int findMaxCid2 = findMaxCid(max, (Entity) it5.next());
                        if (Intrinsics.compare(findMaxCid, findMaxCid2) < 0) {
                            findMaxCid = findMaxCid2;
                        }
                    }
                    return findMaxCid;
                }
                throw new NoSuchElementException();
            }
            return max;
        }
        throw new NoSuchElementException();
    }

    private final Entity fixComponentId(Entity root) {
        if (root == null) {
            return root;
        }
        return fixEntityIterate(root, new CidEmitter(findMaxCid(0, root)));
    }

    private final Entity fixEntityIterate(Entity root, CidEmitter emitter) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        List<IdentifyComponent> components = root.getComponents();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(components, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (IdentifyComponent identifyComponent : components) {
            Integer id5 = identifyComponent.getId();
            if (id5 != null && id5.intValue() == 0) {
                identifyComponent = IdentifyComponent.copy$default(identifyComponent, Integer.valueOf(emitter.next()), null, null, null, 14, null);
            }
            arrayList.add(identifyComponent);
        }
        List<Entity> children = root.getChildren();
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(children, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it = children.iterator();
        while (it.hasNext()) {
            arrayList2.add(fixEntityIterate((Entity) it.next(), emitter));
        }
        return Entity.copy$default(root, 0, null, arrayList2, arrayList, false, 0, 51, null);
    }

    private final <T, R extends Comparable<? super R>> R maxOf(@NotNull Iterable<? extends T> iterable, Function1<? super T, ? extends R> function1) {
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            R invoke = function1.invoke(it.next());
            while (it.hasNext()) {
                R invoke2 = function1.invoke(it.next());
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    private final <T> List<T> readArray(JsonReader reader, Function1<? super JsonReader, ? extends T> inner) {
        reader.beginArray();
        ArrayList arrayList = new ArrayList();
        while (reader.hasNext()) {
            arrayList.add(inner.invoke(reader));
        }
        reader.endArray();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IdentifyComponent readComponent(JsonReader reader) {
        Object data;
        Integer num;
        JsonElement parse = new JsonParser().parse(reader);
        Intrinsics.checkExpressionValueIsNotNull(parse, "JsonParser().parse(reader)");
        JsonObject asJsonObject = parse.getAsJsonObject();
        JsonElement jsonElement = asJsonObject.get("type");
        Intrinsics.checkExpressionValueIsNotNull(jsonElement, "obj.get(TemplateParser.KEY_TYPE)");
        Class<?> cls = this.supportComponentTable.get(jsonElement.getAsString());
        if (cls != null) {
            data = this.gson.fromJson((JsonElement) asJsonObject, (Class<Object>) cls);
        } else {
            data = asJsonObject;
        }
        JsonElement jsonElement2 = asJsonObject.get(TemplateParser.KEY_COMPONENT_ID);
        Integer num2 = null;
        if (jsonElement2 != null) {
            num = Integer.valueOf(jsonElement2.getAsInt());
        } else {
            num = null;
        }
        JsonElement jsonElement3 = asJsonObject.get(TemplateParser.KEY_ENTITY_ID);
        if (jsonElement3 != null) {
            num2 = Integer.valueOf(jsonElement3.getAsInt());
        } else {
            JsonElement jsonElement4 = asJsonObject.get("id");
            if (jsonElement4 != null) {
                num2 = Integer.valueOf(jsonElement4.getAsInt());
            }
        }
        if (num == null) {
            num = -1;
        }
        if (num2 == null) {
            num2 = -1;
        }
        Intrinsics.checkExpressionValueIsNotNull(data, "data");
        return new IdentifyComponent(num, num2, data, null, 8, null);
    }

    private final Map<String, InputSource> readInputSource(JsonReader reader) {
        Object fromJson = this.gson.fromJson(reader, new TypeToken<Map<String, ? extends InputSource>>() { // from class: com.tencent.tavcut.rendermodel.parser.LightJsonReader$readInputSource$typeToken$1
        }.getType());
        Intrinsics.checkExpressionValueIsNotNull(fromJson, "gson.fromJson(reader, typeToken)");
        return (Map) fromJson;
    }

    @Nullable
    public final Entity readAllEntity(@NotNull JsonReader reader) {
        Intrinsics.checkParameterIsNotNull(reader, "reader");
        reader.beginObject();
        Entity entity = null;
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName != null && nextName.hashCode() == 3506402 && nextName.equals("root")) {
                entity = readEntity$lib_tavcut_model_release(reader);
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return entity;
    }

    @NotNull
    public final Map<String, InputSource> readAllInputSource(@NotNull JsonReader reader) {
        Map<String, InputSource> emptyMap;
        Intrinsics.checkParameterIsNotNull(reader, "reader");
        emptyMap = MapsKt__MapsKt.emptyMap();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName != null && nextName.hashCode() == -1035508594 && nextName.equals("inputSources")) {
                emptyMap = readInputSource(reader);
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return emptyMap;
    }

    @NotNull
    public final Entity readEntity$lib_tavcut_model_release(@NotNull JsonReader reader) {
        Intrinsics.checkParameterIsNotNull(reader, "reader");
        reader.beginObject();
        Entity entity = new Entity(0, null, null, null, false, 0, 63, null);
        String name = entity.getName();
        int id5 = entity.getId();
        List<IdentifyComponent> components = entity.getComponents();
        List<Entity> children = entity.getChildren();
        boolean enable = entity.getEnable();
        int version = entity.getVersion();
        boolean z16 = enable;
        List<IdentifyComponent> list = components;
        String str = name;
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName != null) {
                switch (nextName.hashCode()) {
                    case -1609594047:
                        if (!nextName.equals(NodeProps.ENABLED)) {
                            break;
                        } else {
                            z16 = reader.nextBoolean();
                            break;
                        }
                    case -447446250:
                        if (!nextName.equals("components")) {
                            break;
                        } else {
                            list = readArray(reader, new LightJsonReader$readEntity$1(this));
                            break;
                        }
                    case 3355:
                        if (!nextName.equals("id")) {
                            break;
                        } else {
                            id5 = reader.nextInt();
                            break;
                        }
                    case 3373707:
                        if (!nextName.equals("name")) {
                            break;
                        } else {
                            str = reader.nextString();
                            Intrinsics.checkExpressionValueIsNotNull(str, "reader.nextString()");
                            break;
                        }
                    case 351608024:
                        if (!nextName.equals("version")) {
                            break;
                        } else {
                            version = reader.nextInt();
                            break;
                        }
                    case 1659526655:
                        if (!nextName.equals(Node.CHILDREN_ATTR)) {
                            break;
                        } else {
                            children = readArray(reader, new LightJsonReader$readEntity$2(this));
                            break;
                        }
                }
            }
            reader.skipValue();
        }
        reader.endObject();
        return entity.copy(id5, str, children, list, z16, version);
    }

    @NotNull
    public final RenderModel readFullRenderModel(@NotNull String json) {
        RenderModel copy;
        Intrinsics.checkParameterIsNotNull(json, "json");
        RenderModel renderModel = (RenderModel) new GsonBuilder().setExclusionStrategies(new ReaderExclusionStrategy()).create().fromJson(json, RenderModel.class);
        RenderModel readRenderModel = readRenderModel(new JsonReader(new StringReader(json)));
        copy = renderModel.copy((r32 & 1) != 0 ? renderModel.renderScene : null, (r32 & 2) != 0 ? renderModel.root : readRenderModel.getRoot(), (r32 & 4) != 0 ? renderModel.inputSources : readRenderModel.getInputSources(), (r32 & 8) != 0 ? renderModel.painting : null, (r32 & 16) != 0 ? renderModel.clipsAssets : null, (r32 & 32) != 0 ? renderModel.modifyClipsDuration : false, (r32 & 64) != 0 ? renderModel.seekTolerance : 0, (r32 & 128) != 0 ? renderModel.properties : readRenderModel.getProperties(), (r32 & 256) != 0 ? renderModel.audioAssets : null, (r32 & 512) != 0 ? renderModel.timeLines : null, (r32 & 1024) != 0 ? renderModel.maxDuration : 0L, (r32 & 2048) != 0 ? renderModel.componentLevel : 0, (r32 & 4096) != 0 ? renderModel.voiceChangerConfig : null, (r32 & 8192) != 0 ? renderModel.customRenderConfig : null);
        return copy;
    }

    @NotNull
    public final Properties readProperties$lib_tavcut_model_release(@NotNull JsonReader reader) {
        Intrinsics.checkParameterIsNotNull(reader, "reader");
        reader.beginObject();
        Layout layout = null;
        JsonArray jsonArray = null;
        JsonArray jsonArray2 = null;
        JsonArray jsonArray3 = null;
        JsonObject jsonObject = null;
        JsonArray jsonArray4 = null;
        JsonArray jsonArray5 = null;
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName != null) {
                switch (nextName.hashCode()) {
                    case -1684501870:
                        if (!nextName.equals("movieConfig")) {
                            break;
                        } else {
                            JsonElement parse = new JsonParser().parse(reader);
                            Intrinsics.checkExpressionValueIsNotNull(parse, "JsonParser().parse(reader)");
                            jsonObject = parse.getAsJsonObject();
                            break;
                        }
                    case -1109722326:
                        if (!nextName.equals(TtmlNode.TAG_LAYOUT)) {
                            break;
                        } else {
                            Gson gson = this.gson;
                            JsonElement parse2 = new JsonParser().parse(reader);
                            Intrinsics.checkExpressionValueIsNotNull(parse2, "JsonParser().parse(reader)");
                            layout = (Layout) gson.fromJson((JsonElement) parse2.getAsJsonObject(), Layout.class);
                            break;
                        }
                    case -10585181:
                        if (!nextName.equals("boundsTrackerPlaceHolders")) {
                            break;
                        } else {
                            JsonElement parse3 = new JsonParser().parse(reader);
                            Intrinsics.checkExpressionValueIsNotNull(parse3, "JsonParser().parse(reader)");
                            jsonArray = parse3.getAsJsonArray();
                            break;
                        }
                    case 97615364:
                        if (!nextName.equals("fonts")) {
                            break;
                        } else {
                            JsonElement parse4 = new JsonParser().parse(reader);
                            Intrinsics.checkExpressionValueIsNotNull(parse4, "JsonParser().parse(reader)");
                            jsonArray3 = parse4.getAsJsonArray();
                            break;
                        }
                    case 280514122:
                        if (!nextName.equals("materialConfigs")) {
                            break;
                        } else {
                            JsonElement parse5 = new JsonParser().parse(reader);
                            Intrinsics.checkExpressionValueIsNotNull(parse5, "JsonParser().parse(reader)");
                            jsonArray4 = parse5.getAsJsonArray();
                            break;
                        }
                    case 843857523:
                        if (!nextName.equals("musicIDs")) {
                            break;
                        } else {
                            JsonElement parse6 = new JsonParser().parse(reader);
                            Intrinsics.checkExpressionValueIsNotNull(parse6, "JsonParser().parse(reader)");
                            jsonArray2 = parse6.getAsJsonArray();
                            break;
                        }
                    case 1234514922:
                        if (!nextName.equals("resourceIDs")) {
                            break;
                        } else {
                            JsonElement parse7 = new JsonParser().parse(reader);
                            Intrinsics.checkExpressionValueIsNotNull(parse7, "JsonParser().parse(reader)");
                            jsonArray5 = parse7.getAsJsonArray();
                            break;
                        }
                }
            }
            reader.skipValue();
        }
        reader.endObject();
        return new Properties(layout, jsonArray, jsonArray2, jsonArray3, jsonObject, jsonArray4, jsonArray5);
    }

    @NotNull
    public final RenderModel readRenderModel(@NotNull JsonReader reader) {
        Map<String, InputSource> emptyMap;
        Map mutableMap;
        Intrinsics.checkParameterIsNotNull(reader, "reader");
        emptyMap = MapsKt__MapsKt.emptyMap();
        reader.beginObject();
        Entity entity = null;
        Properties properties = null;
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName != null) {
                int hashCode = nextName.hashCode();
                if (hashCode != -1035508594) {
                    if (hashCode != -926053069) {
                        if (hashCode == 3506402 && nextName.equals("root")) {
                            entity = readEntity$lib_tavcut_model_release(reader);
                        }
                    } else if (nextName.equals(Constants.Service.PROPERTIES)) {
                        properties = readProperties$lib_tavcut_model_release(reader);
                    }
                } else if (nextName.equals("inputSources")) {
                    emptyMap = readInputSource(reader);
                }
            }
            reader.skipValue();
        }
        reader.endObject();
        Entity fixComponentId = fixComponentId(entity);
        mutableMap = MapsKt__MapsKt.toMutableMap(emptyMap);
        return new RenderModel(null, fixComponentId, mutableMap, null, null, false, 0, properties, null, null, 0L, 0, null, null, 16249, null);
    }
}
