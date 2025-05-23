package com.tencent.qmethod.pandoraex.core.strategy;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.tencent.qmethod.pandoraex.api.g;
import com.tencent.qmethod.pandoraex.core.o;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CacheStrategyFactory {

    /* renamed from: a, reason: collision with root package name */
    private static g f344155a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f344156b = "provider_strategy";

    public static g a(Context context) {
        String str = f344156b;
        if ("mmkv_strategy".equals(str)) {
            return a.p(context);
        }
        if ("provider_strategy".equals(str)) {
            return b.q(context);
        }
        if ("custom_strategy".equals(str)) {
            return f344155a;
        }
        o.c("PrivacyInfoCacheStrategyFactory", "getStrategyInstance is null! currentStrategy is " + str + " mStrategy is " + f344156b);
        return b.q(context);
    }

    public static void b(g gVar) {
        f344156b = "custom_strategy";
        f344155a = gVar;
    }

    public static void c(Context context, boolean z16) {
        f344156b = "mmkv_strategy";
        a.r(context, z16);
    }

    public static void d(Context context, boolean z16, String str) {
        f344156b = "mmkv_strategy";
        a.s(context, z16, str);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class CharSequenceAdapter extends TypeAdapter<CharSequence> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CharSequence read2(JsonReader jsonReader) throws IOException {
            return (CharSequence) new Gson().fromJson(jsonReader.nextString(), String.class);
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, CharSequence charSequence) throws IOException {
        }
    }
}
