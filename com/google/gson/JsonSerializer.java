package com.google.gson;

import java.lang.reflect.Type;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface JsonSerializer<T> {
    JsonElement serialize(T t16, Type type, JsonSerializationContext jsonSerializationContext);
}
