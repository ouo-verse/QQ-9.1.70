package o45;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.h;

/* compiled from: P */
/* loaded from: classes29.dex */
final class c<T> implements h<ResponseBody, T> {

    /* renamed from: a, reason: collision with root package name */
    private final Gson f422075a;

    /* renamed from: b, reason: collision with root package name */
    private final TypeAdapter<T> f422076b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f422075a = gson;
        this.f422076b = typeAdapter;
    }

    @Override // retrofit2.h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public T convert(ResponseBody responseBody) throws IOException {
        JsonReader newJsonReader = this.f422075a.newJsonReader(responseBody.charStream());
        try {
            T read2 = this.f422076b.read2(newJsonReader);
            if (newJsonReader.peek() == JsonToken.END_DOCUMENT) {
                return read2;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}
