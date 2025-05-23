package com.google.android.apps.internal.games.memoryadvice;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class MemoryAdvisor extends c {

    /* renamed from: h, reason: collision with root package name */
    private static final String f32919h = c.class.getSimpleName();

    /* renamed from: f, reason: collision with root package name */
    private final JSONObject f32920f;

    /* renamed from: g, reason: collision with root package name */
    private final JSONObject f32921g;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum MemoryState {
        UNKNOWN,
        OK,
        APPROACHING_LIMIT,
        CRITICAL
    }

    public MemoryAdvisor(Context context) {
        this(context, f(context.getAssets()));
    }

    @Deprecated
    public static boolean b(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("warnings");
        if (optJSONArray == null) {
            return false;
        }
        for (int i3 = 0; i3 != optJSONArray.length(); i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject != null && "red".equals(optJSONObject.optString("level"))) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public static boolean c(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("warnings");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            return true;
        }
        return false;
    }

    public static long d(JSONObject jSONObject) {
        if (!jSONObject.has("predictions")) {
            return 0L;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("predictions");
            Iterator keys = jSONObject2.keys();
            if (!keys.hasNext()) {
                return 0L;
            }
            long j3 = Long.MAX_VALUE;
            do {
                j3 = Math.min(j3, jSONObject2.getLong((String) keys.next()));
            } while (keys.hasNext());
            return j3;
        } catch (JSONException e16) {
            Log.w(f32919h, "Problem getting memory estimate", e16);
            return 0L;
        }
    }

    private static JSONObject f(AssetManager assetManager) {
        try {
            return new JSONObject(e.f(assetManager.open("memoryadvice/default.json")));
        } catch (IOException | JSONException e16) {
            Log.e(f32919h, "Problem getting default params", e16);
            return new JSONObject();
        }
    }

    public static MemoryState g(JSONObject jSONObject) {
        if (b(jSONObject)) {
            return MemoryState.CRITICAL;
        }
        if (c(jSONObject)) {
            return MemoryState.APPROACHING_LIMIT;
        }
        return MemoryState.OK;
    }

    private static Long h(JSONObject jSONObject, String str) {
        Long h16;
        try {
            if (jSONObject.has(str)) {
                return Long.valueOf(jSONObject.getLong(str));
            }
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                Object obj = jSONObject.get((String) keys.next());
                if ((obj instanceof JSONObject) && (h16 = h((JSONObject) obj, str)) != null) {
                    return h16;
                }
            }
            return null;
        } catch (JSONException e16) {
            Log.w(f32919h, "Problem fetching value", e16);
            return null;
        }
    }

    @Override // com.google.android.apps.internal.games.memoryadvice.c
    public /* bridge */ /* synthetic */ JSONObject a(JSONObject jSONObject) {
        return super.a(jSONObject);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public org.json.JSONObject e() {
        /*
            Method dump skipped, instructions count: 1132
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.apps.internal.games.memoryadvice.MemoryAdvisor.e():org.json.JSONObject");
    }

    public MemoryAdvisor(Context context, JSONObject jSONObject) {
        super(context, jSONObject.optJSONObject("metrics"));
        this.f32921g = jSONObject;
        this.f32920f = a.b(context.getAssets(), jSONObject, this.f32930b);
    }
}
