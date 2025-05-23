package com.tencent.luggage.wxa.yb;

import com.tencent.luggage.wxa.fn.c;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f145514a = new a(null);

    public static final void a(JSONObject jSONObject, String str, Object obj, boolean z16) {
        f145514a.a(jSONObject, str, obj, z16);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(JSONObject obj, String key, Object obj2, boolean z16) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            Intrinsics.checkNotNullParameter(key, "key");
            if (obj2 == null) {
                obj.remove(key);
                return;
            }
            if (obj2 instanceof LinkedList) {
                obj.put(key, a((LinkedList) obj2));
                return;
            }
            if (obj2 instanceof com.tencent.luggage.wxa.fn.b) {
                obj.put(key, ((com.tencent.luggage.wxa.fn.b) obj2).c());
                return;
            }
            try {
                if (obj2 instanceof c) {
                    if (z16) {
                        obj.put(key, com.tencent.luggage.wxa.yb.a.b(((c) obj2).a(), 0));
                    } else {
                        obj.put(key, ((c) obj2).d());
                    }
                } else if (obj2 instanceof byte[]) {
                    obj.put(key, "ByteArray[" + ((byte[]) obj2).length + "]");
                } else if (a(obj2)) {
                    obj.put(key, obj2);
                }
            } catch (Exception unused) {
            }
        }

        public final JSONArray a(LinkedList linkedList) {
            JSONArray jSONArray = new JSONArray();
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    Object item = it.next();
                    if (item instanceof LinkedList) {
                        jSONArray.mo162put(a((LinkedList) item));
                    } else if (item instanceof com.tencent.luggage.wxa.fn.b) {
                        jSONArray.mo162put(((com.tencent.luggage.wxa.fn.b) item).c());
                    } else if (item instanceof c) {
                        try {
                            jSONArray.mo162put(((c) item).d());
                        } catch (Exception unused) {
                        }
                    } else {
                        Intrinsics.checkNotNullExpressionValue(item, "item");
                        if (a(item)) {
                            jSONArray.mo162put(item);
                        }
                    }
                }
            }
            return jSONArray;
        }

        public final boolean a(Object obj) {
            if ((obj instanceof String) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                return true;
            }
            return obj instanceof Character;
        }
    }
}
