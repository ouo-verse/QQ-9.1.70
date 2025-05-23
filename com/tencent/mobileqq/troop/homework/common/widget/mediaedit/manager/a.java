package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskCheckInInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;", "b", "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;", "detail", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskCheckInInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskCheckInInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskCheckInInfo;", "clockInInfo", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskCheckInInfo;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GroupSchoolTaskData detail;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GroupSchoolTaskCheckInInfo clockInInfo;

    public a(@NotNull GroupSchoolTaskData detail, @NotNull GroupSchoolTaskCheckInInfo clockInInfo) {
        Intrinsics.checkNotNullParameter(detail, "detail");
        Intrinsics.checkNotNullParameter(clockInInfo, "clockInInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) detail, (Object) clockInInfo);
        } else {
            this.detail = detail;
            this.clockInInfo = clockInInfo;
        }
    }

    @NotNull
    public final GroupSchoolTaskCheckInInfo a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (GroupSchoolTaskCheckInInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.clockInInfo;
    }

    @NotNull
    public final GroupSchoolTaskData b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (GroupSchoolTaskData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.detail;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.detail, aVar.detail) && Intrinsics.areEqual(this.clockInInfo, aVar.clockInInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return (this.detail.hashCode() * 31) + this.clockInInfo.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "ClockInItemData(detail=" + this.detail + ", clockInInfo=" + this.clockInInfo + ")";
    }
}
