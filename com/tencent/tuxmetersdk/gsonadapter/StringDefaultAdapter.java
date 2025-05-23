package com.tencent.tuxmetersdk.gsonadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class StringDefaultAdapter extends TypeAdapter<String> {
    static IPatchRedirector $redirector_;

    public StringDefaultAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read, reason: avoid collision after fix types in other method */
    public String read2(JsonReader jsonReader) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jsonReader);
        }
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return "";
        }
        return jsonReader.nextString();
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, String str) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jsonWriter, (Object) str);
        } else if (str == null) {
            jsonWriter.value("");
        } else {
            jsonWriter.value(str);
        }
    }
}
