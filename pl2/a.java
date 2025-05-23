package pl2;

import android.app.Activity;
import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lpl2/a;", "Lpl2/b;", "Landroid/app/Activity;", "getActivity", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface a extends b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: pl2.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C11026a {
        @Nullable
        public static Context a(@NotNull a aVar) {
            return aVar.getActivity();
        }

        public static boolean b(@NotNull a aVar) {
            Activity activity = aVar.getActivity();
            if (activity != null && !activity.isFinishing()) {
                return true;
            }
            return false;
        }
    }

    @Nullable
    Activity getActivity();
}
