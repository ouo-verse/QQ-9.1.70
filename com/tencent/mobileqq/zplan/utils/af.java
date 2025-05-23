package com.tencent.mobileqq.zplan.utils;

import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J \u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u0007J\u000f\u0010\u0011\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/af;", "", "", "d", "", "scene", "uin", "", "e", "", "f", "Lcom/tencent/mobileqq/zplan/model/AccessibleDetail;", "b", "c", "detailResult", "flushDisk", "g", "a", "()V", "Z", "cachedInit", "<init>", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class af {

    /* renamed from: a, reason: collision with root package name */
    public static final af f335758a = new af();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean cachedInit;

    af() {
    }

    private final synchronized void d() {
        if (cachedInit) {
            return;
        }
        QLog.i("ZPlanAccessibleCache", 1, "initMemoryCache from disk");
        uk3.b.f439110a.d(uk3.a.f439108a.a());
        cachedInit = true;
    }

    public final void a() {
        try {
            uk3.a.f439108a.c();
        } catch (Throwable th5) {
            QLog.e("ZPlanAccessibleCache", 1, "flushCacheToDisk exception", th5);
        }
    }

    public final AccessibleDetail b(long uin, long scene) {
        uk3.b bVar = uk3.b.f439110a;
        AccessibleDetail b16 = bVar.b(uin, scene);
        if (b16 != null) {
            return b16;
        }
        d();
        return bVar.b(uin, scene);
    }

    public final AccessibleDetail c(long uin, long scene) {
        return uk3.b.f439110a.b(uin, scene);
    }

    public final boolean e(long scene, long uin) {
        AccessibleDetail b16 = b(uin, scene);
        if (b16 == null) {
            return false;
        }
        return b16.isAccessible();
    }

    public final int f(long scene, long uin) {
        AccessibleDetail b16 = uk3.b.f439110a.b(uin, scene);
        if (b16 != null) {
            return b16.isAccessible() ? 1 : 0;
        }
        QLog.i("ZPlanAccessibleCache", 2, "memory CHACHE_INVALID");
        return -1;
    }

    public final void g(long uin, AccessibleDetail detailResult, boolean flushDisk) {
        Intrinsics.checkNotNullParameter(detailResult, "detailResult");
        AccessibleDetail b16 = b(uin, detailResult.getAppid());
        uk3.b.f439110a.e(uin, detailResult);
        if (flushDisk) {
            a();
        }
        uk3.h.f439122a.c(b16, b(uin, detailResult.getAppid()));
    }

    public static /* synthetic */ void h(af afVar, long j3, AccessibleDetail accessibleDetail, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        afVar.g(j3, accessibleDetail, z16);
    }
}
