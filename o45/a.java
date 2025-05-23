package o45;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.ac;
import retrofit2.h;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class a extends h.a {

    /* renamed from: a, reason: collision with root package name */
    private final Gson f422071a;

    a(Gson gson) {
        this.f422071a = gson;
    }

    public static a f(Gson gson) {
        if (gson != null) {
            return new a(gson);
        }
        throw new NullPointerException("gson == null");
    }

    @Override // retrofit2.h.a
    public h<?, RequestBody> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, ac acVar) {
        return new b(this.f422071a, this.f422071a.getAdapter(TypeToken.get(type)));
    }

    @Override // retrofit2.h.a
    public h<ResponseBody, ?> d(Type type, Annotation[] annotationArr, ac acVar) {
        return new c(this.f422071a, this.f422071a.getAdapter(TypeToken.get(type)));
    }
}
