package com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/d;", "", "", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "dataCenter", "b", "d", "memberManage", "addManage", "batchManage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String dataCenter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String memberManage;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String addManage;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String batchManage;

    public d(@NotNull String dataCenter, @NotNull String memberManage, @NotNull String addManage, @NotNull String batchManage) {
        Intrinsics.checkNotNullParameter(dataCenter, "dataCenter");
        Intrinsics.checkNotNullParameter(memberManage, "memberManage");
        Intrinsics.checkNotNullParameter(addManage, "addManage");
        Intrinsics.checkNotNullParameter(batchManage, "batchManage");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, dataCenter, memberManage, addManage, batchManage);
            return;
        }
        this.dataCenter = dataCenter;
        this.memberManage = memberManage;
        this.addManage = addManage;
        this.batchManage = batchManage;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.addManage;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.batchManage;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.dataCenter;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.memberManage;
    }
}
