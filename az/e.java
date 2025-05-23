package az;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Laz/e;", "", "", "fromScene", "Laz/a;", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f27359a = new e();

    e() {
    }

    public final a a(String fromScene) {
        if (fromScene != null) {
            int hashCode = fromScene.hashCode();
            if (hashCode != 80261941) {
                if (hashCode != 80448268) {
                    if (hashCode == 1838805840 && fromScene.equals("from_section")) {
                        return new d();
                    }
                } else if (fromScene.equals("from_like")) {
                    return new c();
                }
            } else if (fromScene.equals("from_fans")) {
                return new b();
            }
        }
        throw new IllegalArgumentException("the argument is not found when createPresenter in WSMsgDetailPresenterFactory");
    }
}
