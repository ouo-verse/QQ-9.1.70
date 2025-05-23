package com.tencent.qqnt.bus.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/bus/event/b;", "Lzv3/a;", "", "Lcom/tencent/qqnt/bus/event/f;", "a", "Ljava/util/List;", "getUnreadItems", "()Ljava/util/List;", "unreadItems", "<init>", "(Ljava/util/List;)V", "bus_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b implements zv3.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<f> unreadItems;

    public b(@NotNull List<f> unreadItems) {
        Intrinsics.checkNotNullParameter(unreadItems, "unreadItems");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) unreadItems);
        } else {
            this.unreadItems = unreadItems;
        }
    }
}
