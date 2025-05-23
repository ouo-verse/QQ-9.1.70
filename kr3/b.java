package kr3;

import android.view.Window;
import com.tencent.qmethod.pandoraex.monitor.SilentCallMonitor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ6\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u0006H\u0096\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lkr3/b;", "Ljava/lang/reflect/InvocationHandler;", "", "proxy", "Ljava/lang/reflect/Method;", "method", "", "args", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "Landroid/view/Window$Callback;", "a", "Landroid/view/Window$Callback;", "callback", "<init>", "(Landroid/view/Window$Callback;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class b implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Window.Callback callback;

    public b(@Nullable Window.Callback callback) {
        this.callback = callback;
    }

    @Override // java.lang.reflect.InvocationHandler
    @Nullable
    public Object invoke(@Nullable Object proxy, @NotNull Method method, @Nullable Object[] args) {
        Intrinsics.checkParameterIsNotNull(method, "method");
        if (Intrinsics.areEqual(method.getName(), "dispatchTouchEvent")) {
            SilentCallMonitor.onUserInteraction();
        }
        Window.Callback callback = this.callback;
        if (callback == null) {
            return null;
        }
        if (args == null) {
            return method.invoke(callback, new Object[0]);
        }
        return method.invoke(callback, Arrays.copyOf(args, args.length));
    }
}
