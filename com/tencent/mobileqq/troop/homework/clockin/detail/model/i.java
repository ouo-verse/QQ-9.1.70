package com.tencent.mobileqq.troop.homework.clockin.detail.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\b\u0010\u0010R\u0011\u0010\u0014\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/i;", "", "", "a", "I", "()I", "code", "", "b", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "msg", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;", "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;", "data", "", "()Z", "isSuccess", "<init>", "(ILjava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int code;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String msg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final GroupSchoolTaskData data;

    public i(int i3, @NotNull String msg2, @Nullable GroupSchoolTaskData groupSchoolTaskData) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), msg2, groupSchoolTaskData);
            return;
        }
        this.code = i3;
        this.msg = msg2;
        this.data = groupSchoolTaskData;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.code;
    }

    @Nullable
    public final GroupSchoolTaskData b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (GroupSchoolTaskData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.data;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.code == 0) {
            return true;
        }
        return false;
    }
}
