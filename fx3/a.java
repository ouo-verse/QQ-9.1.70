package fx3;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0005H&J\u0018\u0010\t\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0005H&J\b\u0010\n\u001a\u00020\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lfx3/a;", "T", "", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroidx/lifecycle/Observer;", "observer", "", "observe", "removeObserver", "a", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface a<T> {
    void a();

    void observe(@NotNull LifecycleOwner owner, @NotNull Observer<? super T> observer);

    void removeObserver(@NotNull Observer<? super T> observer);
}
