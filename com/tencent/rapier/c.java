package com.tencent.rapier;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u0004\b\u0001\u0010\u00032\b\u0012\u0004\u0012\u00028\u00010\u0004B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\b\u001a\u00028\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/rapier/c;", "Lcom/google/protobuf/nano/MessageNano;", "ResponseT", "ReturnT", "Lcom/tencent/rapier/n;", "", "", "args", "a", "([Ljava/lang/Object;)Ljava/lang/Object;", "Lcom/tencent/rapier/e;", "b", "Lcom/tencent/rapier/e;", "converterFactory", "Lcom/tencent/rapier/k;", "c", "Lcom/tencent/rapier/k;", "rapier", "Ljava/lang/reflect/Method;", "d", "Ljava/lang/reflect/Method;", "method", "Lcom/tencent/rapier/m;", "e", "Lcom/tencent/rapier/m;", "requestFactory", "<init>", "(Lcom/tencent/rapier/k;Ljava/lang/reflect/Method;Lcom/tencent/rapier/m;)V", "rapier_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class c<ResponseT extends MessageNano, ReturnT> extends n<ReturnT> {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private e<ResponseT> converterFactory;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final k rapier;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Method method;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final m requestFactory;

    public c(@NotNull k rapier, @NotNull Method method, @NotNull m requestFactory) {
        Intrinsics.checkNotNullParameter(rapier, "rapier");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, rapier, method, requestFactory);
            return;
        }
        this.rapier = rapier;
        this.method = method;
        this.requestFactory = requestFactory;
        this.converterFactory = new h();
    }

    @Override // com.tencent.rapier.n
    public ReturnT a(@NotNull Object[] args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (ReturnT) iPatchRedirector.redirect((short) 1, (Object) this, (Object) args);
        }
        Intrinsics.checkNotNullParameter(args, "args");
        return (ReturnT) new o(this.rapier, this.method, args, this.requestFactory, this.converterFactory);
    }
}
