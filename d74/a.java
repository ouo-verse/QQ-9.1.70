package d74;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\u0002H&\u00a8\u0006\n"}, d2 = {"Ld74/a;", "", "", "showDialog", "", "needAnim", "b", "r", "a", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: d74.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C10165a {
        public static /* synthetic */ void a(a aVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = false;
                }
                aVar.b(z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dismissDialog");
        }
    }

    boolean a();

    void b(boolean needAnim);

    void onDestroy();

    boolean r();

    void showDialog();
}
