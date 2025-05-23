package com.tencent.tuxmetersdk.gsonadapter;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class NullableJsonElementTypeAdapterFactory implements TypeAdapterFactory {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class NullableJsonElementTypeAdapter extends TypeAdapter<JsonElement> {
        static IPatchRedirector $redirector_;
        private final TypeAdapter<JsonElement> delegate;

        public NullableJsonElementTypeAdapter(TypeAdapter<JsonElement> typeAdapter) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) typeAdapter);
            } else {
                this.delegate = typeAdapter;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public JsonElement read2(JsonReader jsonReader) throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (JsonElement) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jsonReader);
            }
            if (jsonReader.peek() == JsonToken.NULL) {
                return null;
            }
            return this.delegate.read2(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.delegate.write(jsonWriter, jsonElement);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) jsonWriter, (Object) jsonElement);
            }
        }
    }

    public NullableJsonElementTypeAdapterFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TypeAdapter) iPatchRedirector.redirect((short) 2, (Object) this, (Object) gson, (Object) typeToken);
        }
        if (JsonElement.class.isAssignableFrom(typeToken.getRawType())) {
            return new NullableJsonElementTypeAdapter(gson.getAdapter(JsonElement.class));
        }
        return null;
    }
}
