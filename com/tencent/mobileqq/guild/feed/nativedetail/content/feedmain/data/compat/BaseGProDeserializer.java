package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.compat;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tencent.ark.ark;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.util.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003BA\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\u0012\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u0018\u00a2\u0006\u0004\b!\u0010\"J/\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ/\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002\u00a2\u0006\u0004\b\u000e\u0010\rJ'\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0016R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001aR \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010 \u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/compat/BaseGProDeserializer;", "", "T", "Lcom/google/gson/JsonDeserializer;", "t", "Ljava/lang/reflect/Field;", "field", "Lcom/google/gson/JsonArray;", "value", "Lcom/google/gson/JsonDeserializationContext;", "context", "", "a", "(Ljava/lang/Object;Ljava/lang/reflect/Field;Lcom/google/gson/JsonArray;Lcom/google/gson/JsonDeserializationContext;)V", "b", "Lcom/google/gson/JsonElement;", ark.ARKMETADATA_JSON, "Ljava/lang/reflect/Type;", "typeOfT", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Object;", "Ljava/lang/Class;", "Ljava/lang/Class;", "clazz", "", "", "Ljava/util/Map;", "globalJsonKeyToNamingMapping", "c", "jsonKeyToNamingMapping", "d", "Ljava/lang/String;", "tag", "<init>", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/Map;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class BaseGProDeserializer<T> implements JsonDeserializer<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<T> clazz;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, String> globalJsonKeyToNamingMapping;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, String> jsonKeyToNamingMapping;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    public BaseGProDeserializer(@NotNull Class<T> clazz, @NotNull Map<String, String> globalJsonKeyToNamingMapping, @NotNull Map<String, String> jsonKeyToNamingMapping) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(globalJsonKeyToNamingMapping, "globalJsonKeyToNamingMapping");
        Intrinsics.checkNotNullParameter(jsonKeyToNamingMapping, "jsonKeyToNamingMapping");
        this.clazz = clazz;
        this.globalJsonKeyToNamingMapping = globalJsonKeyToNamingMapping;
        this.jsonKeyToNamingMapping = jsonKeyToNamingMapping;
        this.tag = "BaseGProDeserializer." + clazz.getSimpleName();
    }

    /* JADX WARN: Incorrect type for immutable var: ssa=byte[], code=boolean[], for r0v5, types: [byte[]] */
    /* JADX WARN: Incorrect type for immutable var: ssa=char[], code=boolean[], for r0v4, types: [char[]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int[]] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v7, types: [double[]] */
    /* JADX WARN: Type inference failed for: r0v8, types: [float[]] */
    /* JADX WARN: Type inference failed for: r0v9, types: [long[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void a(T t16, Field field, JsonArray value, JsonDeserializationContext context) {
        boolean[] zArr;
        JsonElement f16;
        Class<?> type = field.getType();
        int i3 = 0;
        if (Intrinsics.areEqual(type, int[].class)) {
            int size = value.size();
            zArr = new int[size];
            while (i3 < size) {
                zArr[i3] = value.get(i3).getAsInt();
                i3++;
            }
        } else if (Intrinsics.areEqual(type, long[].class)) {
            int size2 = value.size();
            zArr = new long[size2];
            while (i3 < size2) {
                zArr[i3] = value.get(i3).getAsLong();
                i3++;
            }
        } else if (Intrinsics.areEqual(type, float[].class)) {
            int size3 = value.size();
            zArr = new float[size3];
            while (i3 < size3) {
                zArr[i3] = value.get(i3).getAsFloat();
                i3++;
            }
        } else if (Intrinsics.areEqual(type, double[].class)) {
            int size4 = value.size();
            zArr = new double[size4];
            while (i3 < size4) {
                zArr[i3] = value.get(i3).getAsDouble();
                i3++;
            }
        } else if (Intrinsics.areEqual(type, boolean[].class)) {
            int size5 = value.size();
            zArr = new boolean[size5];
            while (i3 < size5) {
                zArr[i3] = value.get(i3).getAsBoolean();
                i3++;
            }
        } else if (Intrinsics.areEqual(type, byte[].class)) {
            int size6 = value.size();
            zArr = new byte[size6];
            while (i3 < size6) {
                zArr[i3] = value.get(i3).getAsByte();
                i3++;
            }
        } else if (Intrinsics.areEqual(type, char[].class)) {
            int size7 = value.size();
            zArr = new char[size7];
            while (i3 < size7) {
                zArr[i3] = value.get(i3).getAsCharacter();
                i3++;
            }
        } else {
            int size8 = value.size();
            Object[] objArr = new Object[size8];
            while (i3 < size8) {
                JsonElement jsonElement = value.get(i3);
                Intrinsics.checkNotNullExpressionValue(jsonElement, "value[i]");
                f16 = a.f(jsonElement, this.globalJsonKeyToNamingMapping);
                Object deserialize = context.deserialize(f16, field.getType().getComponentType());
                Intrinsics.checkNotNullExpressionValue(deserialize, "context.deserialize(valu\u2026field.type.componentType)");
                objArr[i3] = deserialize;
                i3++;
            }
            zArr = objArr;
        }
        field.set(t16, zArr);
    }

    private final void b(T t16, Field field, JsonArray value, JsonDeserializationContext context) {
        ParameterizedType parameterizedType;
        Collection linkedHashSet;
        JsonElement f16;
        Type[] actualTypeArguments;
        Object firstOrNull;
        Type genericType = field.getGenericType();
        Type type = null;
        if (genericType instanceof ParameterizedType) {
            parameterizedType = (ParameterizedType) genericType;
        } else {
            parameterizedType = null;
        }
        if (parameterizedType != null && (actualTypeArguments = parameterizedType.getActualTypeArguments()) != null) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(actualTypeArguments);
            type = (Type) firstOrNull;
        }
        if (type == null) {
            Logger logger = Logger.f235387a;
            String str = this.tag;
            logger.d().w(str, 1, "failed to deserialize list: " + field.getName() + ", genericType: " + field.getGenericType());
            return;
        }
        Class<?> type2 = field.getType();
        if (Intrinsics.areEqual(type2, ArrayList.class)) {
            linkedHashSet = new ArrayList();
        } else if (Intrinsics.areEqual(type2, LinkedList.class)) {
            linkedHashSet = new LinkedList();
        } else if (Intrinsics.areEqual(type2, HashSet.class)) {
            linkedHashSet = new HashSet();
        } else if (Intrinsics.areEqual(type2, LinkedHashSet.class)) {
            linkedHashSet = new LinkedHashSet();
        } else {
            Logger logger2 = Logger.f235387a;
            String str2 = this.tag;
            logger2.d().w(str2, 1, "Unsupported type for " + field.getName() + MsgSummary.STR_COLON + field.getType());
            return;
        }
        Iterator<JsonElement> it = value.iterator();
        while (it.hasNext()) {
            JsonElement item = it.next();
            Intrinsics.checkNotNullExpressionValue(item, "item");
            f16 = a.f(item, this.globalJsonKeyToNamingMapping);
            Object deserialize = context.deserialize(f16, type);
            Intrinsics.checkNotNullExpressionValue(deserialize, "context.deserialize(item\u2026NamingMapping), itemType)");
            linkedHashSet.add(deserialize);
        }
        field.set(t16, linkedHashSet);
    }

    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public T deserialize(@NotNull JsonElement json, @NotNull Type typeOfT, @NotNull JsonDeserializationContext context) {
        JsonElement f16;
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(typeOfT, "typeOfT");
        Intrinsics.checkNotNullParameter(context, "context");
        JsonObject asJsonObject = json.getAsJsonObject();
        T t16 = this.clazz.newInstance();
        for (String str : asJsonObject.keySet()) {
            String str2 = this.globalJsonKeyToNamingMapping.get(str);
            if (str2 == null && (str2 = this.jsonKeyToNamingMapping.get(str)) == null) {
                str2 = str;
            }
            try {
                Field field = this.clazz.getDeclaredField(str2);
                JsonElement value = asJsonObject.get(str);
                field.setAccessible(true);
                if ((value instanceof JsonArray) && ((JsonArray) value).size() > 0) {
                    if (field.getType().isArray()) {
                        Intrinsics.checkNotNullExpressionValue(t16, "t");
                        Intrinsics.checkNotNullExpressionValue(field, "field");
                        a(t16, field, (JsonArray) value, context);
                    } else {
                        Intrinsics.checkNotNullExpressionValue(t16, "t");
                        Intrinsics.checkNotNullExpressionValue(field, "field");
                        b(t16, field, (JsonArray) value, context);
                    }
                } else {
                    Intrinsics.checkNotNullExpressionValue(value, "value");
                    f16 = a.f(value, this.globalJsonKeyToNamingMapping);
                    field.set(t16, context.deserialize(f16, field.getType()));
                }
            } catch (IllegalAccessException unused) {
                Logger logger = Logger.f235387a;
                String str3 = this.tag;
                Logger.b bVar = new Logger.b();
                String str4 = "IllegalAccessException: " + str2;
                if (str4 instanceof String) {
                    bVar.a().add(str4);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e(str3, 1, (String) it.next(), null);
                }
            } catch (NoSuchFieldException unused2) {
                Logger logger2 = Logger.f235387a;
                String str5 = this.tag;
                Logger.b bVar2 = new Logger.b();
                String str6 = "NoSuchFieldException: " + str2;
                if (str6 instanceof String) {
                    bVar2.a().add(str6);
                }
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e(str5, 1, (String) it5.next(), null);
                }
            } catch (Exception e16) {
                Logger logger3 = Logger.f235387a;
                String str7 = this.tag;
                Logger.b bVar3 = new Logger.b();
                String str8 = "Exception while deserialize: " + str2;
                if (str8 instanceof String) {
                    bVar3.a().add(str8);
                }
                Iterator<T> it6 = bVar3.a().iterator();
                while (it6.hasNext()) {
                    Logger.f235387a.d().e(str7, 1, (String) it6.next(), e16);
                }
            }
        }
        Intrinsics.checkNotNullExpressionValue(t16, "t");
        return t16;
    }

    public /* synthetic */ BaseGProDeserializer(Class cls, Map map, Map map2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, (i3 & 2) != 0 ? a.g(b.f221028d.a()) : map, (i3 & 4) != 0 ? a.e(cls) : map2);
    }
}
