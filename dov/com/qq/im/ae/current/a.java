package dov.com.qq.im.ae.current;

import com.tencent.aio.data.AIOParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import su3.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/aio/api/runtime/a;", "Ldov/com/qq/im/ae/current/SessionWrap;", "a", "(Lcom/tencent/aio/api/runtime/a;)Ldov/com/qq/im/ae/current/SessionWrap;", "sessionWrap", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class a {
    @NotNull
    public static final SessionWrap a(@NotNull com.tencent.aio.api.runtime.a aVar) {
        String valueOf;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        SessionWrap sessionWrap = new SessionWrap();
        AIOParam aioParam = aVar.g();
        Intrinsics.checkNotNullExpressionValue(aioParam, "aioParam");
        long a16 = c.a(aioParam);
        if (a16 == 0) {
            valueOf = "";
        } else {
            valueOf = String.valueOf(a16);
        }
        sessionWrap.f394447d = valueOf;
        sessionWrap.f394448e = aVar.g().r().c().g();
        sessionWrap.f394450h = valueOf;
        sessionWrap.f394452m = aVar.g().r().c().j();
        int e16 = aVar.g().r().c().e();
        sessionWrap.f394451i = e16;
        sessionWrap.f394449f = com.tencent.nt.adapter.session.c.c(e16);
        return sessionWrap;
    }
}
