package com.google.gson;

import java.lang.reflect.Type;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface JsonDeserializer<T> {
    T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException;
}
