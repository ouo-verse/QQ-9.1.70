package com.tencent.mobileqq.zootopia.portal.detail;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/a;", "", "", "mapId", "count", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lzb3/h;", "callback", "", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface a {
    void e(int mapId, int count, com.tencent.mobileqq.zootopia.api.e<zb3.h> callback);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.zootopia.portal.detail.a$a, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C9116a {
        public static /* synthetic */ void a(a aVar, int i3, int i16, com.tencent.mobileqq.zootopia.api.e eVar, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 2) != 0) {
                    i16 = 10;
                }
                aVar.e(i3, i16, eVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadMapComments");
        }
    }
}
