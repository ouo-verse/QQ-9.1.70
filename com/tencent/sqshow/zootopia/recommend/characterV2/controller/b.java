package com.tencent.sqshow.zootopia.recommend.characterV2.controller;

import kotlin.Metadata;
import qv4.z;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/b;", "", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/z;", "callback", "", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface b {
    void b(com.tencent.mobileqq.zootopia.api.e<z> callback);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(b bVar, com.tencent.mobileqq.zootopia.api.e eVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    eVar = null;
                }
                bVar.b(eVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestRoleData");
        }
    }
}
