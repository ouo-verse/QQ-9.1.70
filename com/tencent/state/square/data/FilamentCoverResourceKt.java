package com.tencent.state.square.data;

import hs4.c;
import hs4.u;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import xt4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0000\u001a\n\u0010\u0003\u001a\u00020\u0000*\u00020\u0001\u001a\n\u0010\u0003\u001a\u00020\u0005*\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lhs4/c;", "Lcom/tencent/state/square/data/FilamentCoverResource;", "parse", "toPB", "Lcom/tencent/state/square/data/FilamentCoverResourceItem;", "Lxt4/g;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FilamentCoverResourceKt {
    public static final c toPB(FilamentCoverResource toPB) {
        Intrinsics.checkNotNullParameter(toPB, "$this$toPB");
        c cVar = new c();
        cVar.f406129a = toPB.getCoverUrl();
        cVar.f406131c = toPB.getActionMd5();
        u uVar = new u();
        uVar.f406219a = toPB.getRecordDressKeys().getOwner();
        uVar.f406220b = toPB.getRecordDressKeys().getOther();
        Unit unit = Unit.INSTANCE;
        cVar.f406130b = uVar;
        return cVar;
    }

    public static final FilamentCoverResource parse(c cVar) {
        String str;
        String str2;
        if (cVar == null) {
            return null;
        }
        String str3 = cVar.f406129a;
        if (str3 == null) {
            str3 = "";
        }
        u uVar = cVar.f406130b;
        if (uVar == null || (str = uVar.f406219a) == null) {
            str = "";
        }
        if (uVar == null || (str2 = uVar.f406220b) == null) {
            str2 = "";
        }
        DressKeys dressKeys = new DressKeys(str, str2);
        String str4 = cVar.f406131c;
        return new FilamentCoverResource(str3, dressKeys, str4 != null ? str4 : "");
    }

    public static final g toPB(FilamentCoverResourceItem toPB) {
        Intrinsics.checkNotNullParameter(toPB, "$this$toPB");
        g gVar = new g();
        gVar.f448584a = toPB.getUin();
        gVar.f448585b = toPB.getMotionId();
        gVar.f448586c = toPB(toPB.getCover());
        return gVar;
    }
}
