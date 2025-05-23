package com.tencent.qqnt.rich;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/rich/k;", "", "Lcom/tencent/qqnt/rich/g;", "a", "Lcom/tencent/qqnt/rich/g;", "()Lcom/tencent/qqnt/rich/g;", "markdownOption", "Lcom/tencent/qqnt/rich/h;", "b", "Lcom/tencent/qqnt/rich/h;", "()Lcom/tencent/qqnt/rich/h;", "morphisOption", "<init>", "(Lcom/tencent/qqnt/rich/g;Lcom/tencent/qqnt/rich/h;)V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g markdownOption;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h morphisOption;

    public k(@NotNull g markdownOption, @NotNull h morphisOption) {
        Intrinsics.checkNotNullParameter(markdownOption, "markdownOption");
        Intrinsics.checkNotNullParameter(morphisOption, "morphisOption");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) markdownOption, (Object) morphisOption);
        } else {
            this.markdownOption = markdownOption;
            this.morphisOption = morphisOption;
        }
    }

    @NotNull
    public final g a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (g) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.markdownOption;
    }

    @NotNull
    public final h b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (h) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.morphisOption;
    }

    public /* synthetic */ k(g gVar, h hVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new g(null, null, null, null, null, 31, null) : gVar, (i3 & 2) != 0 ? new h(null, null, 3, null) : hVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, gVar, hVar, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
