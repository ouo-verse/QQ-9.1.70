package com.tencent.mobileqq.nt.msgpush.factory;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/nt/msgpush/factory/e;", "", "", "byteArray", "", "b", "", "Lcom/tencent/mobileqq/nt/msgpush/factory/f;", "a", "()Ljava/util/List;", "processorList", "Lcom/tencent/mobileqq/nt/msgpush/factory/d;", "c", "()Lcom/tencent/mobileqq/nt/msgpush/factory/d;", "businessDataConvertor", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public interface e {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class a {
        public static void a(@NotNull e eVar, @NotNull byte[] byteArray) {
            Intrinsics.checkNotNullParameter(byteArray, "byteArray");
            com.tencent.mobileqq.nt.msgpush.factory.a a16 = eVar.c().a(byteArray);
            if (a16 != null) {
                Iterator<T> it = eVar.a().iterator();
                while (it.hasNext()) {
                    ((f) it.next()).a(a16);
                }
            }
        }
    }

    @NotNull
    List<f> a();

    void b(@NotNull byte[] byteArray);

    @NotNull
    d c();
}
