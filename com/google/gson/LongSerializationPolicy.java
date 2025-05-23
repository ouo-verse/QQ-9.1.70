package com.google.gson;

/* loaded from: classes2.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.google.gson.LongSerializationPolicy.1
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l3) {
            return new JsonPrimitive((Number) l3);
        }
    },
    STRING { // from class: com.google.gson.LongSerializationPolicy.2
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l3) {
            return new JsonPrimitive(String.valueOf(l3));
        }
    };

    public abstract JsonElement serialize(Long l3);
}
