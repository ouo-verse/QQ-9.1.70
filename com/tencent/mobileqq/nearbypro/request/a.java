package com.tencent.mobileqq.nearbypro.request;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.nearbypro.base.c;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.utils.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0006\u0010\u0005\u001a\u00020\u0004\u001a\n\u0010\u0007\u001a\u00020\u0002*\u00020\u0006\u001a\u0006\u0010\b\u001a\u00020\u0006\u00a8\u0006\t"}, d2 = {"", PreloadTRTCPlayerParams.KEY_SIG, "", "d", "Lcom/tencent/mobileqq/nearbypro/request/CommonExtSig;", "b", "Lnp4/c;", "c", "a", "qq_nearby_pro_base_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {
    @NotNull
    public static final np4.c a() {
        np4.c cVar = new np4.c();
        c(cVar);
        return cVar;
    }

    @NotNull
    public static final CommonExtSig b() {
        return (CommonExtSig) c.a.e(j.d(), "nearby_pro_req_sig", CommonExtSig.class, new CommonExtSig(), null, false, 24, null);
    }

    public static final void c(@NotNull np4.c cVar) {
        boolean z16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        np4.b bVar = new np4.b();
        bVar.f420670a = j.a().b();
        bVar.f420671b = m.b();
        bVar.f420672c = 109;
        cVar.f420673a = bVar;
        CommonExtSig b16 = b();
        if (b16.getSig().length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            j.c().d("NBP.CommonExt", "sig isEmpty");
        }
        cVar.f420674b = b16.getSig();
    }

    public static final void d(@NotNull byte[] sig) {
        Intrinsics.checkNotNullParameter(sig, "sig");
        c.a.l(j.d(), "nearby_pro_req_sig", new CommonExtSig(sig, System.currentTimeMillis() / 1000), null, false, 12, null);
    }
}
