package com.tencent.mobileqq.aio.msg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/b;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "", "i2", "W0", "Z", com.tencent.mobileqq.msf.core.auth.k.f247491e, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "<init>", "(ZLcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b extends AIOMsgItem {
    static IPatchRedirector $redirector_;

    /* renamed from: W0, reason: from kotlin metadata */
    private final boolean read;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(boolean z16, @NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), msgRecord);
        } else {
            this.read = z16;
        }
    }

    public final boolean i2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.read;
    }
}
