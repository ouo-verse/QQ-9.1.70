package com.tencent.qqnt.aio.refresher;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/bd;", "Lcom/tencent/qqnt/aio/refresher/bf;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/qqnt/aio/refresher/bg;", "rsp", "<init>", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;Lcom/tencent/qqnt/aio/refresher/bg;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class bd extends bf {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd(@NotNull AIOMsgItem msgItem, @Nullable bg bgVar) {
        super(msgItem, bgVar);
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgItem, (Object) bgVar);
    }

    public /* synthetic */ bd(AIOMsgItem aIOMsgItem, bg bgVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aIOMsgItem, (i3 & 2) != 0 ? null : bgVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, aIOMsgItem, bgVar, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
