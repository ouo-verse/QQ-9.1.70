package com.tencent.mobileqq.zootopia.permission.follow.data;

import com.tencent.mobileqq.zootopia.api.e;
import hu4.d;
import hu4.g;
import hu4.j;
import hu4.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u001c\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zootopia/permission/follow/data/b;", "Lcom/tencent/mobileqq/mvvm/a;", "", "privacyType", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lhu4/d;", "resultCallback", "", "j", "Lhu4/g;", "privacyInfo", "Lhu4/k;", "k", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b extends com.tencent.mobileqq.mvvm.a {
    public final void j(int privacyType, e<d> resultCallback) {
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        hu4.c cVar = new hu4.c();
        cVar.f406345a = privacyType;
        tc3.a.b(tc3.a.f435851a, cVar, resultCallback, 0, 4, null);
    }

    public final void k(g privacyInfo, e<k> resultCallback) {
        Intrinsics.checkNotNullParameter(privacyInfo, "privacyInfo");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        j jVar = new j();
        jVar.f406382a = privacyInfo;
        tc3.a.d(tc3.a.f435851a, jVar, resultCallback, 0, 4, null);
    }
}
