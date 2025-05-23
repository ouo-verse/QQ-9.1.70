package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel;

import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.report.JoinStatus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/c;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "id", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/report/JoinStatus;", "b", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/report/JoinStatus;", "()Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/report/JoinStatus;", "state", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/report/JoinStatus;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JoinStatus state;

    public c(@NotNull String id5, @NotNull JoinStatus state) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(state, "state");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) id5, (Object) state);
        } else {
            this.id = id5;
            this.state = state;
        }
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.id;
    }

    @NotNull
    public final JoinStatus b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (JoinStatus) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.state;
    }
}
