package com.tencent.sqshow.zootopia.nativeui.ue;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/ue/q;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/p;", "panelGroupDataRepo", "Lb94/d;", "a", "Lb94/a;", "engineApi", "Lcom/tencent/sqshow/zootopia/nativeui/ue/t;", "b", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f371395a = new q();

    q() {
    }

    public final b94.d a(com.tencent.sqshow.zootopia.nativeui.data.repo.p panelGroupDataRepo) {
        Intrinsics.checkNotNullParameter(panelGroupDataRepo, "panelGroupDataRepo");
        return new PortalStoreAvatarDressController(panelGroupDataRepo);
    }

    public final t b(b94.a engineApi) {
        Intrinsics.checkNotNullParameter(engineApi, "engineApi");
        return new i(engineApi);
    }
}
