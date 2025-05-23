package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/g;", "", "", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/f;", "a", "Ljava/util/List;", "()Ljava/util/List;", "files", "<init>", "(Ljava/util/List;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<f> files;

    public g(@NotNull List<f> files) {
        Intrinsics.checkNotNullParameter(files, "files");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) files);
        } else {
            this.files = files;
        }
    }

    @NotNull
    public final List<f> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.files;
    }
}
