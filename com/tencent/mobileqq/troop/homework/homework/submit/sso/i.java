package com.tencent.mobileqq.troop.homework.homework.submit.sso;

import com.google.protobuf.CodedOutputStream;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.homework.submit.sso.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/i;", "Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/h;", "Lcom/google/protobuf/CodedOutputStream;", "output", "", "writeTo", "", "getSerializedSize", "", "a", "J", "hwId", "Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/g;", "b", "Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/g;", "commentInfo", "<init>", "(JLcom/tencent/mobileqq/troop/homework/homework/submit/sso/g;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class i implements h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long hwId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g commentInfo;

    public i(long j3, @NotNull g commentInfo) {
        Intrinsics.checkNotNullParameter(commentInfo, "commentInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), commentInfo);
        } else {
            this.hwId = j3;
            this.commentInfo = commentInfo;
        }
    }

    @NotNull
    public byte[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return h.a.a(this);
    }

    @Override // com.tencent.mobileqq.troop.homework.homework.submit.sso.h
    public int getSerializedSize() {
        int c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        long j3 = this.hwId;
        int i3 = 0;
        if (j3 != 0) {
            i3 = 0 + CodedOutputStream.a0(1, j3);
        }
        c16 = c.c(2, this.commentInfo);
        return i3 + c16;
    }

    @Override // com.tencent.mobileqq.troop.homework.homework.submit.sso.h
    public void writeTo(@NotNull CodedOutputStream output) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) output);
            return;
        }
        Intrinsics.checkNotNullParameter(output, "output");
        long j3 = this.hwId;
        if (j3 != 0) {
            output.d1(1, j3);
        }
        c.d(output, 2, this.commentInfo);
    }
}
