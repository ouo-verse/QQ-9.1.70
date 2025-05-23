package cq0;

import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002R0\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcq0/c;", "", "", "styleId", "Lcq0/d;", "a", "parserId", "b", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mStyleParserMap", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f391633a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, d> mStyleParserMap = new HashMap<>();

    c() {
    }

    private final d a(int styleId) {
        if (styleId != 0) {
            if (styleId != 1) {
                return new a();
            }
            return new b();
        }
        return new a();
    }

    @NotNull
    public final d b(int parserId) {
        HashMap<Integer, d> hashMap = mStyleParserMap;
        d dVar = hashMap.get(Integer.valueOf(parserId));
        if (dVar == null) {
            d a16 = a(parserId);
            hashMap.put(Integer.valueOf(parserId), a16);
            return a16;
        }
        return dVar;
    }
}
