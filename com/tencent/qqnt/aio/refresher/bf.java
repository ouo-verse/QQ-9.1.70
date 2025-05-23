package com.tencent.qqnt.aio.refresher;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R$\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/bf;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/h;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "a", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/qqnt/aio/refresher/bg;", "b", "Lcom/tencent/qqnt/aio/refresher/bg;", "()Lcom/tencent/qqnt/aio/refresher/bg;", "c", "(Lcom/tencent/qqnt/aio/refresher/bg;)V", "rsp", "<init>", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;Lcom/tencent/qqnt/aio/refresher/bg;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public class bf implements com.tencent.mobileqq.aio.msglist.holder.external.h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOMsgItem msgItem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private bg rsp;

    public bf(@NotNull AIOMsgItem msgItem, @Nullable bg bgVar) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgItem, (Object) bgVar);
        } else {
            this.msgItem = msgItem;
            this.rsp = bgVar;
        }
    }

    @NotNull
    public final AIOMsgItem a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.msgItem;
    }

    @Nullable
    public final bg b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (bg) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.rsp;
    }

    public final void c(@Nullable bg bgVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bgVar);
        } else {
            this.rsp = bgVar;
        }
    }

    public /* synthetic */ bf(AIOMsgItem aIOMsgItem, bg bgVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aIOMsgItem, (i3 & 2) != 0 ? null : bgVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, aIOMsgItem, bgVar, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
