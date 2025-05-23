package com.tencent.ecommerce.base.network.json;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.io.IOException;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002J,\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/base/network/json/IgnoreFailureTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "T", "Lcom/google/gson/TypeAdapter;", "delegate", "a", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/reflect/TypeToken;", "type", OperateCustomButton.OPERATE_CREATE, "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class IgnoreFailureTypeAdapterFactory implements TypeAdapterFactory {
    private final <T> TypeAdapter<T> a(final TypeAdapter<T> delegate) {
        return new TypeAdapter<T>() { // from class: com.tencent.ecommerce.base.network.json.IgnoreFailureTypeAdapterFactory$createCustomTypeAdapter$1
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public T read2(JsonReader in5) throws IOException {
                try {
                    return (T) TypeAdapter.this.read2(in5);
                } catch (Exception unused) {
                    in5.skipValue();
                    return null;
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, T value) throws IOException {
                TypeAdapter.this.write(out, value);
            }
        };
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        return a(gson.getDelegateAdapter(this, type));
    }
}
