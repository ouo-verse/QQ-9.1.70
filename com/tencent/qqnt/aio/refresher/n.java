package com.tencent.qqnt.aio.refresher;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/n;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/g;", "", "requestClass", "Lcom/tencent/mobileqq/aio/msglist/holder/external/e;", "helper", "Lcom/tencent/mobileqq/aio/msglist/holder/external/c;", "a", "type", "Lcom/tencent/mobileqq/aio/msglist/holder/external/d;", "b", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class n implements com.tencent.mobileqq.aio.msglist.holder.external.g {
    static IPatchRedirector $redirector_;

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.g
    @Nullable
    public com.tencent.mobileqq.aio.msglist.holder.external.c a(@NotNull String requestClass, @NotNull com.tencent.mobileqq.aio.msglist.holder.external.e helper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.msglist.holder.external.c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) requestClass, (Object) helper);
        }
        Intrinsics.checkNotNullParameter(requestClass, "requestClass");
        Intrinsics.checkNotNullParameter(helper, "helper");
        if (Intrinsics.areEqual(requestClass, Reflection.getOrCreateKotlinClass(g.class).getQualifiedName())) {
            return new i(helper);
        }
        if (Intrinsics.areEqual(requestClass, Reflection.getOrCreateKotlinClass(ar.class).getQualifiedName())) {
            return new at(helper);
        }
        if (Intrinsics.areEqual(requestClass, Reflection.getOrCreateKotlinClass(ae.class).getQualifiedName())) {
            return new ag(helper);
        }
        if (Intrinsics.areEqual(requestClass, Reflection.getOrCreateKotlinClass(m.class).getQualifiedName())) {
            return new l(helper);
        }
        if (Intrinsics.areEqual(requestClass, Reflection.getOrCreateKotlinClass(r.class).getQualifiedName())) {
            return new s(helper);
        }
        if (Intrinsics.areEqual(requestClass, Reflection.getOrCreateKotlinClass(y.class).getQualifiedName())) {
            return new aa(helper);
        }
        if (Intrinsics.areEqual(requestClass, Reflection.getOrCreateKotlinClass(ak.class).getQualifiedName())) {
            return new al(helper);
        }
        if (Intrinsics.areEqual(requestClass, Reflection.getOrCreateKotlinClass(ai.class).getQualifiedName())) {
            return new ah(helper);
        }
        if (Intrinsics.areEqual(requestClass, Reflection.getOrCreateKotlinClass(ao.class).getQualifiedName())) {
            return new aq(helper);
        }
        if (Intrinsics.areEqual(requestClass, Reflection.getOrCreateKotlinClass(a.class).getQualifiedName())) {
            return new ax(helper);
        }
        if (Intrinsics.areEqual(requestClass, Reflection.getOrCreateKotlinClass(v.class).getQualifiedName())) {
            return new au(helper);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.g
    @Nullable
    public com.tencent.mobileqq.aio.msglist.holder.external.d b(@NotNull String type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.aio.msglist.holder.external.d) iPatchRedirector.redirect((short) 3, (Object) this, (Object) type);
        }
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(g.class).getQualifiedName())) {
            return new f();
        }
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(o.class).getQualifiedName())) {
            return new q();
        }
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(az.class).getQualifiedName())) {
            return new bb();
        }
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(d.class).getQualifiedName())) {
            return new ay();
        }
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(ac.class).getQualifiedName())) {
            return new ab();
        }
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(bf.class).getQualifiedName())) {
            return new be();
        }
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(bh.class).getQualifiedName())) {
            return new bc();
        }
        return null;
    }
}
