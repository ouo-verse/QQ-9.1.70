package com.tencent.videocut.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.tencent.ark.ark;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0013\u0007B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ'\u0010\f\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00028\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000b\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/videocut/utils/GsonUtils;", "", "T", "", ark.ARKMETADATA_JSON, "Ljava/lang/Class;", "clazz", "a", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "Lcom/google/gson/Gson;", "gson", "obj", "b", "(Lcom/google/gson/Gson;Ljava/lang/Object;)Ljava/lang/String;", "c", "(Ljava/lang/Object;)Ljava/lang/String;", "Lcom/google/gson/Gson;", "<init>", "()V", "MapDeserializerDoubleAsIntFix", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class GsonUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static Gson gson;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final GsonUtils f384219b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ2\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0005\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/videocut/utils/GsonUtils$MapDeserializerDoubleAsIntFix;", "Lcom/google/gson/JsonDeserializer;", "", "", "", "Lcom/google/gson/JsonElement;", "jsonElement", "Ljava/lang/reflect/Type;", "type", "Lcom/google/gson/JsonDeserializationContext;", "jsonDeserializationContext", "a", "input", "b", "<init>", "()V", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class MapDeserializerDoubleAsIntFix implements JsonDeserializer<Map<String, ? extends Object>> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final MapDeserializerDoubleAsIntFix f384220a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(MessageHandlerConstants.NOTIFY_TYPE_HIBOOM_AUTH);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                f384220a = new MapDeserializerDoubleAsIntFix();
            }
        }

        MapDeserializerDoubleAsIntFix() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.google.gson.JsonDeserializer
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<String, Object> deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (Map) iPatchRedirector.redirect((short) 1, this, jsonElement, type, jsonDeserializationContext);
            }
            Intrinsics.checkNotNullParameter(jsonElement, "jsonElement");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(jsonDeserializationContext, "jsonDeserializationContext");
            return (Map) b(jsonElement);
        }

        @Nullable
        public final Object b(@NotNull JsonElement input) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this, (Object) input);
            }
            Intrinsics.checkNotNullParameter(input, "input");
            if (input.isJsonArray()) {
                ArrayList arrayList = new ArrayList();
                JsonArray asJsonArray = input.getAsJsonArray();
                Intrinsics.checkNotNullExpressionValue(asJsonArray, "input.asJsonArray");
                Iterator<JsonElement> it = asJsonArray.iterator();
                while (it.hasNext()) {
                    JsonElement anArr = it.next();
                    Intrinsics.checkNotNullExpressionValue(anArr, "anArr");
                    arrayList.add(b(anArr));
                }
                return arrayList;
            }
            if (input.isJsonObject()) {
                LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                JsonObject asJsonObject = input.getAsJsonObject();
                Intrinsics.checkNotNullExpressionValue(asJsonObject, "input.asJsonObject");
                Set<Map.Entry<String, JsonElement>> entrySet = asJsonObject.entrySet();
                Intrinsics.checkNotNullExpressionValue(entrySet, "obj.entrySet()");
                for (Map.Entry<String, JsonElement> entry : entrySet) {
                    linkedTreeMap.put(entry.getKey(), b(entry.getValue()));
                }
                return linkedTreeMap;
            }
            if (input.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = input.getAsJsonPrimitive();
                Intrinsics.checkNotNullExpressionValue(asJsonPrimitive, "input.asJsonPrimitive");
                if (asJsonPrimitive.isBoolean()) {
                    return Boolean.valueOf(asJsonPrimitive.getAsBoolean());
                }
                if (asJsonPrimitive.isString()) {
                    return asJsonPrimitive.getAsString();
                }
                if (asJsonPrimitive.isNumber()) {
                    Number asNumber = asJsonPrimitive.getAsNumber();
                    Intrinsics.checkNotNullExpressionValue(asNumber, "prim.asNumber");
                    if (Math.ceil(asNumber.doubleValue()) == asNumber.longValue()) {
                        return Long.valueOf(asNumber.longValue());
                    }
                    return Double.valueOf(asNumber.doubleValue());
                }
                return null;
            }
            return null;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/videocut/utils/GsonUtils$a;", "Lcom/google/gson/stream/JsonReader;", "", "nextInt", "", "nextBoolean", "", "nextDouble", "", "nextLong", "", "nextString", "nextName", "Ljava/io/Reader;", "input", "<init>", "(Ljava/io/Reader;)V", "d", "a", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a extends JsonReader {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/videocut/utils/GsonUtils$a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.tencent.videocut.utils.GsonUtils$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes27.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8062);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 8)) {
                redirector.redirect((short) 8);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public a(@Nullable Reader reader) {
            super(reader);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) reader);
            }
        }

        @Override // com.google.gson.stream.JsonReader
        public boolean nextBoolean() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            try {
                return super.nextBoolean();
            } catch (Exception e16) {
                com.tencent.videocut.utils.log.b.b("ProxyJsonReader", "nextBoolean", e16);
                return false;
            }
        }

        @Override // com.google.gson.stream.JsonReader
        public double nextDouble() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Double) iPatchRedirector.redirect((short) 3, (Object) this)).doubleValue();
            }
            try {
                return super.nextDouble();
            } catch (Exception e16) {
                com.tencent.videocut.utils.log.b.b("ProxyJsonReader", "nextDouble", e16);
                return 0.0d;
            }
        }

        @Override // com.google.gson.stream.JsonReader
        public int nextInt() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
            }
            try {
                return super.nextInt();
            } catch (Exception e16) {
                com.tencent.videocut.utils.log.b.b("ProxyJsonReader", "nextInt", e16);
                return 0;
            }
        }

        @Override // com.google.gson.stream.JsonReader
        public long nextLong() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            try {
                return super.nextLong();
            } catch (Exception e16) {
                com.tencent.videocut.utils.log.b.b("ProxyJsonReader", "nextLong", e16);
                return 0L;
            }
        }

        @Override // com.google.gson.stream.JsonReader
        @NotNull
        public String nextName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            try {
                String nextName = super.nextName();
                Intrinsics.checkNotNullExpressionValue(nextName, "super.nextName()");
                return nextName;
            } catch (Exception e16) {
                com.tencent.videocut.utils.log.b.b("ProxyJsonReader", "nextName", e16);
                return "";
            }
        }

        @Override // com.google.gson.stream.JsonReader
        @NotNull
        public String nextString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            try {
                String nextString = super.nextString();
                Intrinsics.checkNotNullExpressionValue(nextString, "super.nextString()");
                return nextString;
            } catch (Exception e16) {
                com.tencent.videocut.utils.log.b.b("ProxyJsonReader", "nextString", e16);
                return "";
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8263);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 32)) {
            redirector.redirect((short) 32);
            return;
        }
        f384219b = new GsonUtils();
        Gson create = new GsonBuilder().serializeSpecialFloatingPointValues().serializeNulls().create();
        Intrinsics.checkNotNullExpressionValue(create, "GsonBuilder().serializeS\u2026serializeNulls().create()");
        gson = create;
    }

    GsonUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        }
    }

    @Nullable
    public final <T> T a(@Nullable String json, @Nullable Class<T> clazz) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, (Object) this, (Object) json, (Object) clazz);
        }
        try {
            a aVar = new a(new StringReader(json));
            aVar.setLenient(false);
            return (T) gson.fromJson(aVar, clazz);
        } catch (Exception e16) {
            com.tencent.videocut.utils.log.b.c("GsonUtils", e16);
            return null;
        }
    }

    @Nullable
    public final <T> String b(@Nullable Gson gson2, T obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) gson2, (Object) obj);
        }
        if (gson2 == null) {
            return null;
        }
        try {
            return gson2.toJson(obj);
        } catch (Exception e16) {
            com.tencent.videocut.utils.log.b.c("GsonUtils", e16);
            return null;
        }
    }

    @Nullable
    public final <T> String c(T obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) obj);
        }
        return b(gson, obj);
    }
}
