package an1;

import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import uo0.k;
import uo0.p;

/* compiled from: P */
/* loaded from: classes13.dex */
public class d extends p {
    public d(p.b bVar) {
        super(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object u(String str, AppRuntime appRuntime) {
        r(new b(appRuntime, str));
        return null;
    }

    @Override // uo0.p
    protected void m(k kVar) {
        if (!this.f439365c && !kVar.j()) {
            this.f439366d.e(kVar, kVar.h(), kVar.i(), kVar.g());
        }
    }

    public void t(final String str) {
        n("GuildPartSearchSession.getPartList", new Function1() { // from class: an1.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object u16;
                u16 = d.this.u(str, (AppRuntime) obj);
                return u16;
            }
        });
    }
}
