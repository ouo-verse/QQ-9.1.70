package com.tencent.rapier;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/rapier/i;", "T", "Lcom/tencent/rapier/d;", "", "value", "a", "(Ljava/lang/Object;)[B", "<init>", "()V", "rapier_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class i<T> implements d<T, byte[]> {
    static IPatchRedirector $redirector_;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.rapier.d
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public byte[] convert(T value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (byte[]) iPatchRedirector.redirect((short) 1, (Object) this, (Object) value);
        }
        if (value instanceof MessageNano) {
            byte[] byteArray = MessageNano.toByteArray((MessageNano) value);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(value)");
            return byteArray;
        }
        throw InvalidMethodException.INSTANCE.e();
    }
}
