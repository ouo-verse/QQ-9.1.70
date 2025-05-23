package com.google.gson;

import java.lang.reflect.Type;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface JsonSerializationContext {
    JsonElement serialize(Object obj);

    JsonElement serialize(Object obj, Type type);
}
