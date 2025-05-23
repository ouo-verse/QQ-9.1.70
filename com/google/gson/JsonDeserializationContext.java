package com.google.gson;

import java.lang.reflect.Type;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface JsonDeserializationContext {
    <T> T deserialize(JsonElement jsonElement, Type type) throws JsonParseException;
}
