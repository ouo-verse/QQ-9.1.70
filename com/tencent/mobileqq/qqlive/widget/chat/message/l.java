package com.tencent.mobileqq.qqlive.widget.chat.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.MessageOuterClass$TimMsgBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/message/l;", "", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "a", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "()Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "msg", "", "b", "J", "()J", "timestamp", "<init>", "(Ltrpc/yes/common/MessageOuterClass$TimMsgBody;J)V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MessageOuterClass$TimMsgBody msg;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long timestamp;

    public l(@NotNull MessageOuterClass$TimMsgBody msg2, long j3) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msg2, Long.valueOf(j3));
        } else {
            this.msg = msg2;
            this.timestamp = j3;
        }
    }

    @NotNull
    public final MessageOuterClass$TimMsgBody a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageOuterClass$TimMsgBody) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.msg;
    }

    public final long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.timestamp;
    }
}
