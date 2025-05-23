package com.tencent.mobileqq.troop.homework.homework.submit.sso;

import com.google.protobuf.CodedOutputStream;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/f;", "Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/h;", "", "a", "Lcom/google/protobuf/CodedOutputStream;", "output", "", "writeTo", "getSerializedSize", "Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/a;", "Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/a;", "getContent", "()Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/a;", "content", "<init>", "(Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/a;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class f implements h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a content;

    public f(@NotNull a content) {
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) content);
        } else {
            this.content = content;
        }
    }

    private final int a() {
        a aVar = this.content;
        if (aVar instanceof e) {
            return 1;
        }
        if (aVar instanceof k) {
            return 2;
        }
        if (aVar instanceof b) {
            return 3;
        }
        if (aVar instanceof j) {
            return 4;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.tencent.mobileqq.troop.homework.homework.submit.sso.h
    public int getSerializedSize() {
        int c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            c16 = c.c(a(), this.content);
            return c16;
        }
        return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
    }

    @Override // com.tencent.mobileqq.troop.homework.homework.submit.sso.h
    public void writeTo(@NotNull CodedOutputStream output) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) output);
        } else {
            Intrinsics.checkNotNullParameter(output, "output");
            c.d(output, a(), this.content);
        }
    }
}
