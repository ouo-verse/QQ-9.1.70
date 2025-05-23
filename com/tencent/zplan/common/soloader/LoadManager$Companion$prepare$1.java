package com.tencent.zplan.common.soloader;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.zplan.common.utils.LogUtil;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lx4.d;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 2})
/* loaded from: classes27.dex */
final class LoadManager$Companion$prepare$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f385266d;

    @Override // java.lang.Runnable
    public final void run() {
        List<b> sorted;
        a prepare;
        synchronized (c.f385268b) {
            a aVar = (a) c.f385268b.get(this.f385266d);
            if (aVar != null) {
                lx4.d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    d.a.c(a16, "LoadManager", 1, "prepare loaded soItem=" + aVar, null, 8, null);
                    throw null;
                }
                throw null;
            }
        }
        synchronized (c.f385267a) {
            Collection values = c.f385267a.values();
            Intrinsics.checkNotNullExpressionValue(values, "loaders.values");
            sorted = CollectionsKt___CollectionsKt.sorted(values);
        }
        for (b bVar : sorted) {
            LogUtil logUtil = LogUtil.f385285b;
            lx4.d a17 = logUtil.a();
            if (a17 != null) {
                d.a.c(a17, "LoadManager", 1, "try prepare loader=" + bVar, null, 8, null);
            }
            try {
                prepare = bVar.prepare(this.f385266d);
            } catch (Throwable th5) {
                lx4.d a18 = LogUtil.f385285b.a();
                if (a18 != null) {
                    d.a.b(a18, "LoadManager", 1, "prepare failed loader=" + bVar + " soNickname=" + this.f385266d + TokenParser.SP + th5, null, 8, null);
                }
            }
            if (prepare == null) {
                lx4.d a19 = logUtil.a();
                if (a19 != null) {
                    d.a.c(a19, "LoadManager", 1, "prepare get failed null loader=" + bVar + " soNickname=" + this.f385266d, null, 8, null);
                }
            } else {
                lx4.d a26 = logUtil.a();
                if (a26 != null) {
                    d.a.c(a26, "LoadManager", 1, "prepare finished loader=" + bVar + " soNickname=" + this.f385266d + " soItem=" + prepare, null, 8, null);
                    throw null;
                }
                throw null;
            }
        }
        throw null;
    }
}
