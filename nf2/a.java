package nf2;

import android.content.Intent;
import android.os.Bundle;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0003*\u00020\u0005\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0005\u001a\u0016\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000*\u00020\u0005\u001a&\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\nj\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002`\u000b*\u00020\u0005\u00a8\u0006\r"}, d2 = {"", "", "", "Landroid/os/Bundle;", "b", "Lorg/json/JSONObject;", "c", "Landroid/content/Intent;", "d", "a", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "e", "qqecommerce-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    @NotNull
    public static final Map<String, Object> a(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            Intrinsics.checkNotNullExpressionValue(key, "key");
            Object opt = jSONObject.opt(key);
            if (opt == null) {
                opt = "";
            }
            linkedHashMap.put(key, opt);
        }
        return linkedHashMap;
    }

    @NotNull
    public static final Bundle b(@NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof String) {
                bundle.putString(str, (String) obj);
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                bundle.putInt(str, ((Number) obj).intValue());
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Number) obj).longValue());
            } else if (obj instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) obj);
            }
        }
        return bundle;
    }

    @NotNull
    public static final Bundle c(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Bundle bundle = new Bundle();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object opt = jSONObject.opt(str);
            if (opt instanceof String) {
                bundle.putString(str, (String) opt);
            } else if (opt instanceof Integer) {
                bundle.putInt(str, ((Number) opt).intValue());
            } else if (opt instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) opt).booleanValue());
            } else if (opt instanceof Float) {
                bundle.putFloat(str, ((Number) opt).floatValue());
            } else if (opt instanceof Double) {
                bundle.putDouble(str, ((Number) opt).doubleValue());
            } else if (opt instanceof Long) {
                bundle.putLong(str, ((Number) opt).longValue());
            } else if (opt instanceof Short) {
                bundle.putShort(str, ((Number) opt).shortValue());
            } else if (opt instanceof Byte) {
                bundle.putByte(str, ((Number) opt).byteValue());
            } else if (opt instanceof Character) {
                bundle.putChar(str, ((Character) opt).charValue());
            } else if (opt instanceof JSONObject) {
                bundle.putBundle(str, c((JSONObject) opt));
            }
        }
        return bundle;
    }

    @NotNull
    public static final Intent d(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intent intent = new Intent();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object opt = jSONObject.opt(str);
            if (opt instanceof String) {
                intent.putExtra(str, (String) opt);
            } else if (opt instanceof Integer) {
                intent.putExtra(str, ((Number) opt).intValue());
            } else if (opt instanceof Boolean) {
                intent.putExtra(str, ((Boolean) opt).booleanValue());
            } else if (opt instanceof Float) {
                intent.putExtra(str, ((Number) opt).floatValue());
            } else if (opt instanceof Double) {
                intent.putExtra(str, ((Number) opt).doubleValue());
            } else if (opt instanceof Long) {
                intent.putExtra(str, ((Number) opt).longValue());
            } else if (opt instanceof Short) {
                intent.putExtra(str, ((Number) opt).shortValue());
            } else if (opt instanceof Byte) {
                intent.putExtra(str, ((Number) opt).byteValue());
            } else if (opt instanceof Character) {
                intent.putExtra(str, ((Character) opt).charValue());
            } else if (opt instanceof JSONObject) {
                intent.putExtra(str, c((JSONObject) opt));
            }
        }
        return intent;
    }

    @NotNull
    public static final LinkedHashMap<String, Object> e(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            Object opt = jSONObject.opt(key);
            if (opt instanceof JSONObject) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(key, e((JSONObject) opt));
            } else if (opt instanceof JSONArray) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(key, opt.toString());
            } else if (opt != null) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(key, opt);
            }
        }
        return linkedHashMap;
    }
}
