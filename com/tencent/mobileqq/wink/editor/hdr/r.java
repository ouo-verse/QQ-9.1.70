package com.tencent.mobileqq.wink.editor.hdr;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J8\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\nH\u0096\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/hdr/r;", "Ljava/lang/reflect/InvocationHandler;", "", "active", "", "a", "", "proxy", "Ljava/lang/reflect/Method;", "method", "", "args", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/lang/Object;", "getTarget", "()Ljava/lang/Object;", "target", "b", "Z", "isActive", "<init>", "(Ljava/lang/Object;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class r implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object target;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isActive;

    public r(@NotNull Object target) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.target = target;
        this.isActive = true;
    }

    public final void a(boolean active) {
        this.isActive = active;
    }

    @Override // java.lang.reflect.InvocationHandler
    @Nullable
    public Object invoke(@Nullable Object proxy, @Nullable Method method, @Nullable Object[] args) {
        String str;
        if (!this.isActive) {
            if (method != null) {
                str = method.getName();
            } else {
                str = null;
            }
            w53.b.f("WinkListenerDelegate", "do " + str + ", but is not Active");
            return null;
        }
        if (method == null) {
            return null;
        }
        Object obj = this.target;
        if (args == null) {
            args = new Object[0];
        }
        return method.invoke(obj, Arrays.copyOf(args, args.length));
    }
}
