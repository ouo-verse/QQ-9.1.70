package k74;

import com.tencent.raft.codegenmeta.utils.Constants;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00052\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR.\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0007\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lk74/h;", "", "", "description", "Lk74/e;", "c", "toString", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "name", "Ljava/util/HashMap;", "Ljava/lang/reflect/Method;", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "setMethods", "(Ljava/util/HashMap;)V", Constants.Service.METHODS, "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class h {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private HashMap<Method, e> methods = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u00a8\u0006\t"}, d2 = {"Lk74/h$a;", "", "T", "Ljava/lang/Class;", "clazz", "Lk74/h;", "a", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: k74.h$a, reason: from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T> h a(Class<T> clazz) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            h hVar = new h();
            hVar.d(clazz.getName());
            Method[] methods = clazz.getMethods();
            Intrinsics.checkNotNullExpressionValue(methods, "clazz.methods");
            for (Method it : methods) {
                HashMap<Method, e> a16 = hVar.a();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                a16.put(it, e.INSTANCE.a(it));
            }
            return hVar;
        }

        Companion() {
        }
    }

    public final HashMap<Method, e> a() {
        return this.methods;
    }

    /* renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final e c(String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        for (Map.Entry<Method, e> entry : this.methods.entrySet()) {
            Intrinsics.checkNotNullExpressionValue(entry, "methods.entries");
            e value = entry.getValue();
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.tencent.sqshow.ipc.MethodToken");
            if (value.i(description)) {
                return value;
            }
        }
        return null;
    }

    public final void d(String str) {
        this.name = str;
    }

    public String toString() {
        String str = "name : " + this.name + ", methods:";
        Iterator<Map.Entry<Method, e>> it = this.methods.entrySet().iterator();
        while (it.hasNext()) {
            str = str + "  " + it.next().getKey() + TokenParser.SP;
        }
        return str;
    }
}
