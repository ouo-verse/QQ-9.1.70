package iu3;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\u001a\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0002H\u0000\u001a\u0012\u0010\b\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00000\u0006H\u0000\u001a)\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001a!\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0006H\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a!\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0006H\u0000\u00a2\u0006\u0004\b\u0010\u0010\u000f\u001a!\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0006H\u0000\u00a2\u0006\u0004\b\u0011\u0010\u000f\u001a!\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0006H\u0000\u00a2\u0006\u0004\b\u0012\u0010\u000f\u001a!\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0006H\u0000\u00a2\u0006\u0004\b\u0013\u0010\u000f\u001a!\u0010\u0014\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0006H\u0000\u00a2\u0006\u0004\b\u0014\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"", "j", "", "", "Lorg/json/JSONObject;", "i", "", "Lorg/json/JSONArray;", h.F, "T", "", "index", "a", "(Ljava/util/List;I)Ljava/lang/Object;", "c", "(Ljava/util/List;)Ljava/lang/Object;", "e", "g", "d", "b", "f", "lib_minigame_internalRelease"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class a {
    public static final <T> T a(@NotNull List<? extends Object> arg, int i3) {
        Intrinsics.checkParameterIsNotNull(arg, "$this$arg");
        return (T) arg.get(i3);
    }

    public static final <T> T b(@NotNull List<? extends Object> fifthArg) {
        Intrinsics.checkParameterIsNotNull(fifthArg, "$this$fifthArg");
        return (T) a(fifthArg, 4);
    }

    public static final <T> T c(@NotNull List<? extends Object> firstArg) {
        Intrinsics.checkParameterIsNotNull(firstArg, "$this$firstArg");
        return (T) a(firstArg, 0);
    }

    public static final <T> T d(@NotNull List<? extends Object> fourthArg) {
        Intrinsics.checkParameterIsNotNull(fourthArg, "$this$fourthArg");
        return (T) a(fourthArg, 3);
    }

    public static final <T> T e(@NotNull List<? extends Object> secondArg) {
        Intrinsics.checkParameterIsNotNull(secondArg, "$this$secondArg");
        return (T) a(secondArg, 1);
    }

    public static final <T> T f(@NotNull List<? extends Object> sixthArg) {
        Intrinsics.checkParameterIsNotNull(sixthArg, "$this$sixthArg");
        return (T) a(sixthArg, 5);
    }

    public static final <T> T g(@NotNull List<? extends Object> thirdArg) {
        Intrinsics.checkParameterIsNotNull(thirdArg, "$this$thirdArg");
        return (T) a(thirdArg, 2);
    }

    @NotNull
    public static final JSONArray h(@NotNull List<? extends Object> toJSONArray) {
        Intrinsics.checkParameterIsNotNull(toJSONArray, "$this$toJSONArray");
        JSONArray jSONArray = new JSONArray();
        for (Object obj : toJSONArray) {
            if (obj instanceof Integer) {
                jSONArray.put(((Number) obj).intValue());
            } else if (obj instanceof Long) {
                jSONArray.put(((Number) obj).longValue());
            } else if (obj instanceof Float) {
                jSONArray.mo162put(obj);
            } else if (obj instanceof Double) {
                jSONArray.put(((Number) obj).doubleValue());
            } else if (obj instanceof String) {
                jSONArray.mo162put(obj);
            } else if (obj instanceof Boolean) {
                jSONArray.put(((Boolean) obj).booleanValue());
            } else if (obj instanceof Map) {
                if (obj != null) {
                    jSONArray.mo162put(i((Map) obj));
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                }
            } else if (!(obj instanceof List)) {
                continue;
            } else if (obj != null) {
                jSONArray.mo162put(h((List) obj));
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            }
        }
        return jSONArray;
    }

    @Nullable
    public static final JSONObject i(@NotNull Map<String, ? extends Object> toJSONObject) {
        Intrinsics.checkParameterIsNotNull(toJSONObject, "$this$toJSONObject");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ? extends Object> entry : toJSONObject.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null) {
                if (value instanceof Integer) {
                    jSONObject.put(key, ((Number) value).intValue());
                } else if (value instanceof Long) {
                    jSONObject.put(key, ((Number) value).longValue());
                } else if (value instanceof Double) {
                    jSONObject.put(key, ((Number) value).doubleValue());
                } else if (value instanceof Float) {
                    jSONObject.put(key, value);
                } else if (value instanceof String) {
                    jSONObject.put(key, value);
                } else if (value instanceof Boolean) {
                    jSONObject.put(key, ((Boolean) value).booleanValue());
                } else if (value instanceof JSONObject) {
                    jSONObject.put(key, value);
                } else if (value instanceof Map) {
                    if (value != null) {
                        JSONObject i3 = i((Map) value);
                        if (i3 == null) {
                            i3 = new JSONObject();
                        }
                        jSONObject.put(key, i3);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                    }
                } else if (value instanceof List) {
                    if (value != null) {
                        jSONObject.put(key, h((List) value));
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                    }
                } else {
                    return null;
                }
            }
        }
        return jSONObject;
    }

    @NotNull
    public static final Object j(@NotNull Object toKotlinObject) {
        List list;
        String jSONObject;
        Intrinsics.checkParameterIsNotNull(toKotlinObject, "$this$toKotlinObject");
        if (toKotlinObject instanceof Map) {
            JSONObject i3 = i((Map) toKotlinObject);
            if (i3 != null && (jSONObject = i3.toString()) != null) {
                return jSONObject;
            }
            return toKotlinObject;
        }
        if (toKotlinObject instanceof List) {
            String jSONArray = h((List) toKotlinObject).toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONArray, "(this as List<Any>).toJSONArray().toString()");
            return jSONArray;
        }
        if (toKotlinObject instanceof JSONObject) {
            return toKotlinObject.toString();
        }
        if (toKotlinObject instanceof Object[]) {
            list = ArraysKt___ArraysKt.toList((Object[]) toKotlinObject);
            if (list != null) {
                String jSONArray2 = h(list).toString();
                Intrinsics.checkExpressionValueIsNotNull(jSONArray2, "(this.toList() as List<A\u2026.toJSONArray().toString()");
                return jSONArray2;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        }
        return toKotlinObject;
    }
}
