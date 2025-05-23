package com.tencent.luggage.wxa.v2;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface e {
    public static final a B = a.f143007a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f143007a = new a();

        public final int a(JSONObject json, String field, String str, e[] enums) {
            boolean contains$default;
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(field, "field");
            Intrinsics.checkNotNullParameter(str, "default");
            Intrinsics.checkNotNullParameter(enums, "enums");
            String value = json.optString(field, str);
            int i3 = 0;
            for (e eVar : enums) {
                Intrinsics.checkNotNullExpressionValue(value, "value");
                String lowerCase = eVar.getName().toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) value, (CharSequence) lowerCase, false, 2, (Object) null);
                if (contains$default) {
                    i3 |= eVar.a();
                }
            }
            return i3;
        }
    }

    int a();

    boolean a(int i3);

    String getName();
}
