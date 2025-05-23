package dq0;

import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R0\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0007j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\t\u00a8\u0006\r"}, d2 = {"Ldq0/e;", "", "", "styleId", "Ldq0/f;", "a", "b", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mStyleMap", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f394583a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, f> mStyleMap = new HashMap<>();

    e() {
    }

    private final f a(int styleId) {
        if (styleId != 0) {
            if (styleId != 1) {
                if (styleId != 2 && styleId != 3) {
                    return new b();
                }
            } else {
                return new d();
            }
        }
        return new b();
    }

    @NotNull
    public final f b(int styleId) {
        HashMap<Integer, f> hashMap = mStyleMap;
        f fVar = hashMap.get(Integer.valueOf(styleId));
        if (fVar == null) {
            f a16 = a(styleId);
            hashMap.put(Integer.valueOf(styleId), a16);
            return a16;
        }
        return fVar;
    }
}
