package cooperation.plugin.patch;

import com.google.gson.Gson;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class d {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a implements ParameterizedType {

        /* renamed from: d, reason: collision with root package name */
        Class f390352d;

        public a(Class cls) {
            this.f390352d = cls;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return new Type[]{this.f390352d};
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return null;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return List.class;
        }
    }

    public static <T> List<T> a(String str, Class cls) {
        return (List) new Gson().fromJson(str, new a(cls));
    }

    public static <T> T b(String str, Class<T> cls) {
        return (T) new Gson().fromJson(str, (Class) cls);
    }
}
