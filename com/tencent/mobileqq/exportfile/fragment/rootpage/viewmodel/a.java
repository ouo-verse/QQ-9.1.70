package com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u0082\u0001\u0002\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/rootpage/viewmodel/a;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "name", "<init>", "(Ljava/lang/String;)V", "Lcom/tencent/mobileqq/exportfile/fragment/rootpage/viewmodel/b;", "Lcom/tencent/mobileqq/exportfile/fragment/rootpage/viewmodel/c;", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String name;

    public /* synthetic */ a(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) defaultConstructorMarker);
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.name;
    }

    a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.name = str;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }
}
