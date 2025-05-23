package com.tencent.rapier;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ$\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/rapier/h;", "Lcom/google/protobuf/nano/MessageNano;", "T", "Lcom/tencent/rapier/e;", "Lcom/tencent/rapier/k;", "rapier", "Ljava/lang/reflect/Type;", "type", "Lcom/tencent/rapier/d;", "", "a", "b", "<init>", "()V", "rapier_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class h<T extends MessageNano> implements e<T> {
    static IPatchRedirector $redirector_;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.rapier.e
    @NotNull
    public d<T, byte[]> a(@NotNull k rapier, @NotNull Type type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (d) iPatchRedirector.redirect((short) 1, (Object) this, (Object) rapier, (Object) type);
        }
        Intrinsics.checkNotNullParameter(rapier, "rapier");
        Intrinsics.checkNotNullParameter(type, "type");
        return new i();
    }

    @Override // com.tencent.rapier.e
    @NotNull
    public d<byte[], T> b(@NotNull k rapier, @NotNull Type type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) rapier, (Object) type);
        }
        Intrinsics.checkNotNullParameter(rapier, "rapier");
        Intrinsics.checkNotNullParameter(type, "type");
        return new j(type);
    }
}
