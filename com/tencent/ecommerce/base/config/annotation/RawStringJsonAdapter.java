package com.tencent.ecommerce.base.config.annotation;

import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes32.dex */
public class RawStringJsonAdapter extends TypeAdapter<String> {
    @Override // com.google.gson.TypeAdapter
    /* renamed from: read, reason: avoid collision after fix types in other method */
    public String read2(JsonReader jsonReader) throws IOException {
        return new JsonParser().parse(jsonReader).toString();
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, String str) throws IOException {
        jsonWriter.jsonValue(str);
    }
}
