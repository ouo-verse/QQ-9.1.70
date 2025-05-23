package com.tencent.mobileqq.troop.homework.homework.submit.sso;

import com.google.protobuf.CodedOutputStream;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/g;", "Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/h;", "Lcom/google/protobuf/CodedOutputStream;", "output", "", "writeTo", "", "getSerializedSize", "", "Lcom/tencent/mobileqq/troop/homework/homework/submit/sso/f;", "a", "Ljava/util/List;", "contentList", "<init>", "(Ljava/util/List;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class g implements h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<f> contentList;

    public g(@NotNull List<f> contentList) {
        Intrinsics.checkNotNullParameter(contentList, "contentList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) contentList);
        } else {
            this.contentList = contentList;
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.homework.submit.sso.h
    public int getSerializedSize() {
        int c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        Iterator<f> it = this.contentList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            c16 = c.c(8, it.next());
            i3 += c16;
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.troop.homework.homework.submit.sso.h
    public void writeTo(@NotNull CodedOutputStream output) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) output);
            return;
        }
        Intrinsics.checkNotNullParameter(output, "output");
        Iterator<f> it = this.contentList.iterator();
        while (it.hasNext()) {
            c.d(output, 8, it.next());
        }
    }
}
