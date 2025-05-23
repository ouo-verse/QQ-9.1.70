package com.tencent.qqnt.aio.assistedchat.panel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/l;", "", "", "chatType", "Lcom/tencent/qqnt/aio/assistedchat/panel/o;", "a", "", "Lcom/tencent/qqnt/aio/assistedchat/panel/q;", "b", "Ljava/util/Map;", "loaderMap", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f349194a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, q> loaderMap;

    static {
        Map<Integer, q> mapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58983);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f349194a = new l();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(104, new q()), TuplesKt.to(119, new q()));
        loaderMap = mapOf;
    }

    l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final o a(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (o) iPatchRedirector.redirect((short) 2, (Object) this, chatType);
        }
        q qVar = loaderMap.get(Integer.valueOf(chatType));
        if (qVar != null) {
            return qVar;
        }
        o a16 = a.f349144a.a(chatType);
        if (a16 != null) {
            return a16;
        }
        return new n();
    }
}
