package com.tencent.mobileqq.flock.ktx;

import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y45.k;
import y45.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0003\"\u0015\u0010\f\u001a\u00020\u0001*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u0004\u0018\u00010\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e*\u0004\u0018\u00010\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010\"\u0017\u0010\u0016\u001a\u00020\u0001*\u0004\u0018\u00010\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u000e*\u0004\u0018\u00010\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\"\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u000e*\u0004\u0018\u00010\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Ly45/o;", "", "g", "(Ly45/o;)Z", IProfileProtocolConst.PARAM_IS_FRIEND, "i", "isMale", "f", "isFemale", "Ly45/k;", tl.h.F, "(Ly45/k;)Z", "isJoin", "Ly45/a;", "", "d", "(Ly45/a;)Ljava/lang/String;", "startTimeStr", "c", "startAndEndTimeStr", "e", "(Ly45/a;)Z", "isActive", "Ly45/b;", "b", "(Ly45/b;)Ljava/lang/String;", "firstTag", "a", "decodeContent", "qq-flock-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class e {
    @Nullable
    public static final String a(@Nullable y45.b bVar) {
        boolean z16;
        if (bVar == null) {
            return null;
        }
        String str = bVar.f449372g;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        return com.tencent.mobileqq.flock.utils.a.a(bVar.f449372g);
    }

    @Nullable
    public static final String b(@Nullable y45.b bVar) {
        y45.f[] fVarArr;
        Object orNull;
        if (bVar == null || (fVarArr = bVar.f449383r) == null) {
            return null;
        }
        orNull = ArraysKt___ArraysKt.getOrNull(fVarArr, 0);
        y45.f fVar = (y45.f) orNull;
        if (fVar == null) {
            return null;
        }
        return fVar.f449392b;
    }

    @Nullable
    public static final String c(@Nullable y45.a aVar) {
        if (aVar == null) {
            return null;
        }
        long j3 = aVar.f449361a;
        if (j3 == 0 && aVar.f449362b == 0) {
            return null;
        }
        if (j3 == 0) {
            return com.tencent.mobileqq.flock.utils.g.f210486a.a(aVar.f449362b);
        }
        long j16 = aVar.f449362b;
        if (j16 == 0) {
            return com.tencent.mobileqq.flock.utils.g.f210486a.a(j3);
        }
        com.tencent.mobileqq.flock.utils.g gVar = com.tencent.mobileqq.flock.utils.g.f210486a;
        if (gVar.d(j3, j16)) {
            return gVar.a(aVar.f449361a) + "-" + gVar.c(aVar.f449362b);
        }
        return gVar.a(aVar.f449361a) + "-" + gVar.a(aVar.f449362b);
    }

    @Nullable
    public static final String d(@Nullable y45.a aVar) {
        if (aVar == null) {
            return null;
        }
        long j3 = aVar.f449361a;
        if (j3 == 0) {
            return null;
        }
        return com.tencent.mobileqq.flock.utils.g.f210486a.a(j3);
    }

    public static final boolean e(@Nullable y45.a aVar) {
        if (aVar == null) {
            return true;
        }
        if (aVar.f449363c != 0) {
            long j3 = aVar.f449364d;
            if (j3 <= 0 || j3 * 1000 > System.currentTimeMillis()) {
                return true;
            }
            return false;
        }
        long j16 = aVar.f449362b;
        if (j16 == 0 || j16 * 1000 > System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    public static final boolean f(@NotNull o oVar) {
        Intrinsics.checkNotNullParameter(oVar, "<this>");
        if (oVar.f449452d == 2) {
            return true;
        }
        return false;
    }

    public static final boolean g(@NotNull o oVar) {
        Intrinsics.checkNotNullParameter(oVar, "<this>");
        if (oVar.f449455g == 1) {
            return true;
        }
        return false;
    }

    public static final boolean h(@NotNull k kVar) {
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        if (kVar.f449418d == 1) {
            return true;
        }
        return false;
    }

    public static final boolean i(@NotNull o oVar) {
        Intrinsics.checkNotNullParameter(oVar, "<this>");
        if (oVar.f449452d == 1) {
            return true;
        }
        return false;
    }
}
