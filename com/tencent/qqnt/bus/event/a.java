package com.tencent.qqnt.bus.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.state.data.SquareJSConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0010\u0010\tR(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\u0004\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/bus/event/a;", "Lzv3/a;", "", "", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "setUinList", "(Ljava/util/List;)V", SquareJSConst.Params.PARAMS_UIN_LIST, "J", "()J", "setUin", "(J)V", "uin", "<init>", "bus_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a implements zv3.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Long> uinList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long uin;

    public a(@NotNull List<Long> uinList) {
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            CollectionsKt__CollectionsKt.emptyList();
            this.uinList = uinList;
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) uinList);
        }
    }

    public final long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.uin;
    }

    @NotNull
    public final List<Long> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (List) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.uinList;
    }
}
