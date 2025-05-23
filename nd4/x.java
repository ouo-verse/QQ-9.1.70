package nd4;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
final class x {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, a> f420048a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T extends a> T a(String str) {
        T t16 = (T) this.f420048a.get(str);
        if (t16 != null) {
            return t16;
        }
        throw new IllegalArgumentException(String.format("\u672a\u6ce8\u518c\u76d1\u63a7\u9879\u540d\u79f0\uff1a%s\uff0c\u8bf7\u6ce8\u518c", str));
    }

    public <T extends a> T b(T t16) {
        String d16 = t16.d();
        T t17 = (T) this.f420048a.putIfAbsent(d16, t16);
        if (t17 != null) {
            String name = t17.getClass().getName();
            String name2 = t16.getClass().getName();
            if (name.equals(name2)) {
                return t17;
            }
            throw new IllegalArgumentException(String.format("\u76d1\u63a7\u9879\u5df2\u6ce8\u518c\uff0c\u4e14\u7c7b\u578b\u4e0d\u5339\u914d\u3002 \u76d1\u63a7\u9879\u540d\u79f0: %s\u3002 \u6b32\u6ce8\u518c\u7684\u7c7b\u578b : %s\u3002\u5df2\u6ce8\u518c\u7684\u7c7b\u578b: %s\"", d16, name2, name));
        }
        return t16;
    }
}
