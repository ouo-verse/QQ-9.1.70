package g34;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\u0004H&\u00a8\u0006\f"}, d2 = {"Lg34/b;", "", "Lg34/a;", "dataSource", "", "c", "", "needAnim", "b", "r", "a", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class a {
        public static /* synthetic */ void a(b bVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = false;
                }
                bVar.b(z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dismissDialog");
        }
    }

    boolean a();

    void b(boolean needAnim);

    void c(@NotNull g34.a dataSource);

    void onDestroy();

    boolean r();
}
