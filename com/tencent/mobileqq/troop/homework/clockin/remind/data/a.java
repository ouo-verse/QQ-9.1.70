package com.tencent.mobileqq.troop.homework.clockin.remind.data;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0010\u001e\u001a\u00020\u0007\u0012\u0006\u0010 \u001a\u00020\u0007\u0012\u0006\u0010#\u001a\u00020\u0004\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0013\u0010\fR\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u000f\u0010\u0019R\u0017\u0010\u001e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010 \u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010#\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010!\u001a\u0004\b\u0017\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/remind/data/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "troopUin", "", "b", "J", "()J", "clockInDate", "c", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "Lcom/tencent/mobileqq/troop/homework/clockin/remind/data/b;", "d", "Ljava/util/List;", "()Ljava/util/List;", "studentList", "Z", "f", "()Z", "isAllRemind", "g", "isEnd", "I", "()I", "totalCount", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/util/List;ZZI)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long clockInDate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String taskId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<b> studentList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isAllRemind;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isEnd;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int totalCount;

    public a(@NotNull String troopUin, long j3, @NotNull String taskId, @NotNull List<b> studentList, boolean z16, boolean z17, int i3) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(studentList, "studentList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopUin, Long.valueOf(j3), taskId, studentList, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
            return;
        }
        this.troopUin = troopUin;
        this.clockInDate = j3;
        this.taskId = taskId;
        this.studentList = studentList;
        this.isAllRemind = z16;
        this.isEnd = z17;
        this.totalCount = i3;
    }

    public final long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.clockInDate;
    }

    @NotNull
    public final List<b> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.studentList;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.taskId;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.totalCount;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.troopUin, aVar.troopUin) && this.clockInDate == aVar.clockInDate && Intrinsics.areEqual(this.taskId, aVar.taskId) && Intrinsics.areEqual(this.studentList, aVar.studentList) && this.isAllRemind == aVar.isAllRemind && this.isEnd == aVar.isEnd && this.totalCount == aVar.totalCount) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isAllRemind;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.isEnd;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        int hashCode = ((((((this.troopUin.hashCode() * 31) + androidx.fragment.app.a.a(this.clockInDate)) * 31) + this.taskId.hashCode()) * 31) + this.studentList.hashCode()) * 31;
        boolean z16 = this.isAllRemind;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        boolean z17 = this.isEnd;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((i17 + i3) * 31) + this.totalCount;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return "HWClockInRemindFragmentData(troopUin=" + this.troopUin + ", clockInDate=" + this.clockInDate + ", taskId=" + this.taskId + ", studentList=" + this.studentList + ", isAllRemind=" + this.isAllRemind + ", isEnd=" + this.isEnd + ", totalCount=" + this.totalCount + ")";
    }
}
