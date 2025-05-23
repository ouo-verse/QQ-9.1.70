package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\t\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\r\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/c;", "", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/l;", "a", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/l;", "b", "()Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/l;", "c", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/l;)V", "msgOpType", "", "Z", "()Z", "includeLocation", "<init>", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/l;Z)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private l msgOpType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean includeLocation;

    public c(@NotNull l msgOpType, boolean z16) {
        Intrinsics.checkNotNullParameter(msgOpType, "msgOpType");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, msgOpType, Boolean.valueOf(z16));
        } else {
            this.msgOpType = msgOpType;
            this.includeLocation = z16;
        }
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.includeLocation;
    }

    @NotNull
    public final l b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (l) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.msgOpType;
    }

    public final void c(@NotNull l lVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) lVar);
        } else {
            Intrinsics.checkNotNullParameter(lVar, "<set-?>");
            this.msgOpType = lVar;
        }
    }

    public /* synthetic */ c(l lVar, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(lVar, (i3 & 2) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, this, lVar, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
