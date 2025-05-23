package ll3;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\u0004\b\u0002\u0010\u00052\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lll3/b;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Context", "", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public interface b<I extends ol3.b, S extends MviUIState, Context> {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes21.dex */
    public static final class a {
        public static <I extends ol3.b, S extends MviUIState, Context> void a(@NotNull b<I, S, Context> bVar, @NotNull I intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
        }

        public static <I extends ol3.b, S extends MviUIState, Context> boolean b(@NotNull b<I, S, Context> bVar, @NotNull LiveData<S> stateLiveData, @NotNull Observer<S> observer) {
            Intrinsics.checkNotNullParameter(stateLiveData, "stateLiveData");
            Intrinsics.checkNotNullParameter(observer, "observer");
            return false;
        }

        public static <I extends ol3.b, S extends MviUIState, Context> void d(@NotNull b<I, S, Context> bVar) {
        }

        public static <I extends ol3.b, S extends MviUIState, Context> void c(@NotNull b<I, S, Context> bVar, Context context) {
        }
    }
}
