package com.tencent.mobileqq.troop.homework.clockin.publish.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolTaskRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u000b\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/publish/model/b;", "", "", "c", "", "toString", "", "a", "I", "()I", "code", "b", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "msg", "Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolTaskRsp;", "Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolTaskRsp;", "()Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolTaskRsp;", "rsp", "<init>", "(ILjava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolTaskRsp;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int code;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String msg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PublishGroupSchoolTaskRsp rsp;

    public b(int i3, @NotNull String msg2, @NotNull PublishGroupSchoolTaskRsp rsp) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), msg2, rsp);
            return;
        }
        this.code = i3;
        this.msg = msg2;
        this.rsp = rsp;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.code;
    }

    @NotNull
    public final PublishGroupSchoolTaskRsp b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (PublishGroupSchoolTaskRsp) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.rsp;
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

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "HWClockInPublishResult, code:" + this.code + ", msg:" + this.msg;
    }
}
