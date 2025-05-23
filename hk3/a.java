package hk3;

import com.tencent.sqshow.zootopia.utils.w;
import iv4.f;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\n"}, d2 = {"Lhk3/a;", "", "", "b", "Liv4/f;", "c", "Lkv4/a;", "getSelfUserInfo", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: hk3.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10446a {
        public static f a(a aVar) {
            return null;
        }

        public static String b(a aVar) {
            return "";
        }

        public static kv4.a c(a aVar) {
            Long longOrNull;
            kv4.a aVar2 = new kv4.a();
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(w.f373306a.b());
            aVar2.f413322a = longOrNull != null ? longOrNull.longValue() : 0L;
            return aVar2;
        }

        public static boolean d(a aVar) {
            return false;
        }
    }

    boolean a();

    String b();

    f c();

    kv4.a getSelfUserInfo();
}
