package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000f\u001a\u0004\b\u0003\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/h;", "", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/i;", "a", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/i;", "b", "()Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/i;", "sessionWrapper", "", "Z", "c", "()Z", "isEnd", "", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/g;", "Ljava/util/List;", "()Ljava/util/List;", "recommendList", "<init>", "(Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/i;ZLjava/util/List;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i sessionWrapper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isEnd;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<g> recommendList;

    public h(@NotNull i sessionWrapper, boolean z16, @NotNull List<g> recommendList) {
        Intrinsics.checkNotNullParameter(sessionWrapper, "sessionWrapper");
        Intrinsics.checkNotNullParameter(recommendList, "recommendList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, sessionWrapper, Boolean.valueOf(z16), recommendList);
            return;
        }
        this.sessionWrapper = sessionWrapper;
        this.isEnd = z16;
        this.recommendList = recommendList;
    }

    @NotNull
    public final List<g> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.recommendList;
    }

    @NotNull
    public final i b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (i) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.sessionWrapper;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isEnd;
    }
}
