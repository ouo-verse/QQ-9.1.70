package com.tencent.qqlive.module.videoreport.storage.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* compiled from: P */
/* loaded from: classes22.dex */
public class GsonHelper {
    public static Gson build() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeHierarchyAdapter(Number.class, new JsonSerializer<Number>() { // from class: com.tencent.qqlive.module.videoreport.storage.util.GsonHelper.1
            @Override // com.google.gson.JsonSerializer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public JsonElement serialize(Number number, Type type, JsonSerializationContext jsonSerializationContext) {
                return new JsonPrimitive(String.valueOf(number));
            }
        });
        return gsonBuilder.create();
    }
}
