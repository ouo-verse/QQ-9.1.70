package com.tencent.mobileqq.zootopia.download;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J*\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/w;", "", "", "modId", "", "b", "", "code", "errMsg", "d", "Lcom/tencent/mobileqq/zootopia/download/x;", "task", tl.h.F, "a", "e", "", "progress", "c", "g", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface w {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class a {
        public static void a(w wVar, String modId, x xVar) {
            Intrinsics.checkNotNullParameter(modId, "modId");
        }

        public static void b(w wVar, String modId, float f16, x xVar) {
            Intrinsics.checkNotNullParameter(modId, "modId");
        }

        public static void c(w wVar, String modId, x xVar) {
            Intrinsics.checkNotNullParameter(modId, "modId");
        }

        public static void d(w wVar, String modId, x xVar) {
            Intrinsics.checkNotNullParameter(modId, "modId");
        }
    }

    void a(String modId, x task);

    void b(String modId);

    void c(String modId, float progress, x task);

    void d(String modId, int code, String errMsg);

    void e(String modId, x task);

    void f(String modId, int code, String errMsg, x task);

    void g(String modId, x task);

    void h(String modId, x task);
}
