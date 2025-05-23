package com.google.gson;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class JsonNull extends JsonElement {
    public static final JsonNull INSTANCE = new JsonNull();

    @Deprecated
    public JsonNull() {
    }

    public boolean equals(Object obj) {
        if (this != obj && !(obj instanceof JsonNull)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return JsonNull.class.hashCode();
    }

    @Override // com.google.gson.JsonElement
    public JsonNull deepCopy() {
        return INSTANCE;
    }
}
