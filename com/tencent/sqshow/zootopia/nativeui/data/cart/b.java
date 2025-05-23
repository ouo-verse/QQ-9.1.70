package com.tencent.sqshow.zootopia.nativeui.data.cart;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.az;
import uv4.bc;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u001a\n\u0010\u0007\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\b\u001a\u00020\u0003*\u00020\u0000\u001a\u0014\u0010\t\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\n"}, d2 = {"Luv4/az;", "", "gender", "", "c", "ignoreExpeience", "a", "e", "f", "d", "superqqshow-portal-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b {
    public static final boolean a(az azVar, boolean z16) {
        int i3;
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        if (azVar.E && ((i3 = azVar.f440292s) == 1 || i3 == 2)) {
            if (azVar.f440295v <= 0) {
                return true;
            }
            if (!z16 && azVar.A != 0) {
                return true;
            }
        }
        return false;
    }

    public static final boolean c(az azVar, int i3) {
        bc bcVar;
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        if (azVar.f440288o != null || (bcVar = azVar.f440287n) == null) {
            return false;
        }
        if (bcVar != null && bcVar.f440312a == 0) {
            return false;
        }
        return (azVar.f440295v <= 0 || azVar.A != 0) && !d(azVar, i3);
    }

    public static final boolean d(az azVar, int i3) {
        return r94.b.B(com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.g(Integer.valueOf(i3)), azVar != null ? Integer.valueOf(azVar.f440296w) : null);
    }

    public static final boolean e(az azVar) {
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        return ((long) azVar.A) > NetConnInfoCenter.getServerTime();
    }

    public static final boolean f(az azVar) {
        Intrinsics.checkNotNullParameter(azVar, "<this>");
        return (azVar.f440276c == 0 || azVar.f440293t == null) ? false : true;
    }

    public static /* synthetic */ boolean b(az azVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return a(azVar, z16);
    }
}
