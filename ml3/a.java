package ml3;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H'\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0007H&\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lml3/a;", "T", "", "callback", "", "a", "(Ljava/lang/Object;)V", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "b", "(Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;)V", "", "c", "(Ljava/lang/Object;)Z", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public interface a<T> {
    @Deprecated(message = "can not auto remove CallBack !!", replaceWith = @ReplaceWith(expression = "addCallBack(callback: T, lifecycleOwner: LifecycleOwner)", imports = {}))
    void a(T callback);

    void b(T callback, @NotNull LifecycleOwner lifecycleOwner);

    boolean c(T callback);
}
