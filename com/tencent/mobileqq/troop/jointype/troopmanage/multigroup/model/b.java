package com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006R\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\n\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\b\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/b;", "", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/a;", "a", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/a;", "e", "()Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/a;", "totalMember", "b", "avgMember", "c", "d", "totalManagerNum", "", "J", "getTotalGroupNum", "()J", "totalGroupNum", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/d;", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/d;", "()Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/d;", "jumpInfo", "", "f", "Ljava/lang/String;", "()Ljava/lang/String;", "groupWording", "<init>", "(Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/a;Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/a;Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/a;JLcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/d;Ljava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a totalMember;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a avgMember;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a totalManagerNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long totalGroupNum;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d jumpInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String groupWording;

    public b(@NotNull a totalMember, @NotNull a avgMember, @NotNull a totalManagerNum, long j3, @NotNull d jumpInfo, @NotNull String groupWording) {
        Intrinsics.checkNotNullParameter(totalMember, "totalMember");
        Intrinsics.checkNotNullParameter(avgMember, "avgMember");
        Intrinsics.checkNotNullParameter(totalManagerNum, "totalManagerNum");
        Intrinsics.checkNotNullParameter(jumpInfo, "jumpInfo");
        Intrinsics.checkNotNullParameter(groupWording, "groupWording");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, totalMember, avgMember, totalManagerNum, Long.valueOf(j3), jumpInfo, groupWording);
            return;
        }
        this.totalMember = totalMember;
        this.avgMember = avgMember;
        this.totalManagerNum = totalManagerNum;
        this.totalGroupNum = j3;
        this.jumpInfo = jumpInfo;
        this.groupWording = groupWording;
    }

    @NotNull
    public final a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.avgMember;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.groupWording;
    }

    @NotNull
    public final d c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (d) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.jumpInfo;
    }

    @NotNull
    public final a d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.totalManagerNum;
    }

    @NotNull
    public final a e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.totalMember;
    }
}
