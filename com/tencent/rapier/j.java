package com.tencent.rapier;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010\n\u001a\u00020\b\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/rapier/j;", "Lcom/google/protobuf/nano/MessageNano;", "T", "Lcom/tencent/rapier/d;", "", "value", "a", "([B)Lcom/google/protobuf/nano/MessageNano;", "Ljava/lang/reflect/Type;", "Ljava/lang/reflect/Type;", "type", "<init>", "(Ljava/lang/reflect/Type;)V", "rapier_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class j<T extends MessageNano> implements d<byte[], T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Type type;

    public j(@NotNull Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) type);
        } else {
            this.type = type;
        }
    }

    @Override // com.tencent.rapier.d
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public T convert(@NotNull byte[] value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (T) iPatchRedirector.redirect((short) 1, (Object) this, (Object) value);
        }
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            Type type = this.type;
            if (type != null) {
                T t16 = (T) MessageNano.mergeFrom((MessageNano) ((Class) type).newInstance(), value);
                Intrinsics.checkNotNullExpressionValue(t16, "MessageNano.mergeFrom(response, value)");
                return t16;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<T>");
        } catch (ClassNotFoundException unused) {
            throw InvalidMethodException.INSTANCE.e();
        }
    }
}
