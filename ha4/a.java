package ha4;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lha4/a;", "", "", "itemIndex", "", "b", "e", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public interface a {
    void b(int itemIndex);

    void e();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: ha4.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10428a {
        public static /* synthetic */ void a(a aVar, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 1) != 0) {
                    i3 = -1;
                }
                aVar.b(i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onColorEntranceClick");
        }
    }
}
