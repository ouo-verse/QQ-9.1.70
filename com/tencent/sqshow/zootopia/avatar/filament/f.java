package com.tencent.sqshow.zootopia.avatar.filament;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0014\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/filament/f;", "", "Lcom/tencent/mobileqq/zplan/api/a;", "configData", "", "loadConfig", "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "La84/a;", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface f {
    a84.a a(com.tencent.zplan.zplantracing.c zplanSpanContext);

    void loadConfig(com.tencent.mobileqq.zplan.api.a configData);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class a {
        public static /* synthetic */ a84.a a(f fVar, com.tencent.zplan.zplantracing.c cVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    cVar = null;
                }
                return fVar.a(cVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildFilamentComponent");
        }

        public static /* synthetic */ void b(f fVar, com.tencent.mobileqq.zplan.api.a aVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    aVar = null;
                }
                fVar.loadConfig(aVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadConfig");
        }
    }
}
