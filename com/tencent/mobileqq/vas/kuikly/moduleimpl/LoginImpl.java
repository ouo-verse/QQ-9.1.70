package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0006\u001a\u00020\u00028VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/LoginImpl;", "", "Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/w;", "a", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/w;", "login", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class LoginImpl {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy login;

    public LoginImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<w>() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.LoginImpl$login$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final w invoke() {
                return new w();
            }
        });
        this.login = lazy;
    }

    @NotNull
    public w a() {
        return (w) this.login.getValue();
    }
}
