package com.google.gson;

import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class TypeAdapter<T> {
    public final T fromJson(Reader reader) throws IOException {
        return read2(new JsonReader(reader));
    }

    public final T fromJsonTree(JsonElement jsonElement) {
        try {
            return read2(new JsonTreeReader(jsonElement));
        } catch (IOException e16) {
            throw new JsonIOException(e16);
        }
    }

    public final TypeAdapter<T> nullSafe() {
        return new TypeAdapter<T>() { // from class: com.google.gson.TypeAdapter.1
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public T read2(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return (T) TypeAdapter.this.read2(jsonReader);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, T t16) throws IOException {
                if (t16 == null) {
                    jsonWriter.nullValue();
                } else {
                    TypeAdapter.this.write(jsonWriter, t16);
                }
            }
        };
    }

    /* renamed from: read */
    public abstract T read2(JsonReader jsonReader) throws IOException;

    public final void toJson(Writer writer, T t16) throws IOException {
        write(new JsonWriter(writer), t16);
    }

    public final JsonElement toJsonTree(T t16) {
        try {
            JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
            write(jsonTreeWriter, t16);
            return jsonTreeWriter.get();
        } catch (IOException e16) {
            throw new JsonIOException(e16);
        }
    }

    public abstract void write(JsonWriter jsonWriter, T t16) throws IOException;

    public final T fromJson(String str) throws IOException {
        return fromJson(new StringReader(str));
    }

    public final String toJson(T t16) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t16);
            return stringWriter.toString();
        } catch (IOException e16) {
            throw new AssertionError(e16);
        }
    }
}
