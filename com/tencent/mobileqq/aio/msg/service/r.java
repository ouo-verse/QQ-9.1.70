package com.tencent.mobileqq.aio.msg.service;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.RoamDatemsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\nR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/service/r;", "", "", "a", "I", "b", "()I", "result", "", "Ljava/lang/String;", "()Ljava/lang/String;", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/RoamDatemsg;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/RoamDatemsg;", "()Lcom/tencent/qqnt/kernel/nativeinterface/RoamDatemsg;", "roamDatemsg", "<init>", "(ILjava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/RoamDatemsg;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class r {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int result;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String errMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final RoamDatemsg roamDatemsg;

    public r(int i3, @NotNull String errMsg, @Nullable RoamDatemsg roamDatemsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), errMsg, roamDatemsg);
            return;
        }
        this.result = i3;
        this.errMsg = errMsg;
        this.roamDatemsg = roamDatemsg;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.errMsg;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.result;
    }

    @Nullable
    public final RoamDatemsg c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RoamDatemsg) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.roamDatemsg;
    }
}
