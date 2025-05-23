package na4;

import com.tencent.sqshow.zootopia.player.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import na4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\f"}, d2 = {"Lna4/a;", "", "Lcom/tencent/sqshow/zootopia/player/f;", "options", "Lna4/d$b;", "callBack", "", "b", "", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class a {
    public final String a(f options) {
        if (options == null) {
            String simpleName = getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "{\n            javaClass.simpleName\n        }");
            return simpleName;
        }
        String simpleName2 = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName2, "{\n            javaClass.simpleName\n        }");
        return simpleName2;
    }

    public abstract void b(f options, d.b callBack);
}
