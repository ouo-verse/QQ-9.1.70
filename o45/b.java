package o45;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.h;

/* compiled from: P */
/* loaded from: classes29.dex */
final class b<T> implements h<T, RequestBody> {

    /* renamed from: c, reason: collision with root package name */
    private static final MediaType f422072c = MediaType.get("application/json; charset=UTF-8");

    /* renamed from: a, reason: collision with root package name */
    private final Gson f422073a;

    /* renamed from: b, reason: collision with root package name */
    private final TypeAdapter<T> f422074b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f422073a = gson;
        this.f422074b = typeAdapter;
    }

    @Override // retrofit2.h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RequestBody convert(T t16) throws IOException {
        Buffer buffer = new Buffer();
        JsonWriter newJsonWriter = this.f422073a.newJsonWriter(new OutputStreamWriter(buffer.outputStream(), StandardCharsets.UTF_8));
        this.f422074b.write(newJsonWriter, t16);
        newJsonWriter.close();
        return RequestBody.create(f422072c, buffer.readByteString());
    }
}
