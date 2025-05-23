package com.tencent.now.linkscreengame.model;

import com.tencent.qqlive.common.api.AegisLogger;
import g55.as;
import g55.at;
import g55.au;
import g55.av;
import g55.q;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/now/linkscreengame/model/b;", "", "", "pkId", "", "f", "Lg55/q;", "rsp", "a", "j", "c", "d", "Lg55/au;", "pkMsg", "i", "b", h.F, "newPkId", "oldPkId", "g", "", "pkStatus", "e", "<init>", "()V", "qq-live-linkscreen-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f338501a = new b();

    b() {
    }

    private final long a(q rsp) {
        long j3;
        av avVar;
        at atVar = rsp.f401379b;
        long j16 = 0;
        if (atVar != null && (avVar = atVar.f401334j) != null) {
            j3 = avVar.f401343b - avVar.f401342a;
        } else {
            j3 = 0;
        }
        if (atVar != null) {
            j16 = atVar.f401330f - atVar.f401335k;
        }
        return j16 + j3;
    }

    private final boolean f(long pkId) {
        if (pkId == 0) {
            return false;
        }
        return true;
    }

    public final boolean b(@NotNull au pkMsg) {
        boolean z16;
        Intrinsics.checkNotNullParameter(pkMsg, "pkMsg");
        as asVar = pkMsg.f401339d;
        if (asVar != null && asVar.f401321j == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        return false;
    }

    public final boolean c(@NotNull q rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        int i3 = rsp.f401381d;
        AegisLogger.INSTANCE.i("PK_Biz|LinkPlayPBUtils", "GetAnchorPKInfoRsp pkStatus: " + i3);
        if (i3 != 3 && i3 != 4 && i3 != 5 && i3 != 6) {
            return false;
        }
        return true;
    }

    public final boolean d(@NotNull q rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        long a16 = a(rsp);
        AegisLogger.INSTANCE.i("PK_Biz|LinkPlayPBUtils", "getPKRemainTimeSec result: " + a16);
        if (c(rsp) && a16 > 5) {
            return true;
        }
        return false;
    }

    public final boolean e(int pkStatus) {
        if (pkStatus != 5 && pkStatus != 6) {
            return false;
        }
        return true;
    }

    public final boolean g(long newPkId, long oldPkId) {
        if (f(oldPkId) && newPkId != oldPkId) {
            return true;
        }
        return false;
    }

    public final boolean h(@NotNull au pkMsg, long pkId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(pkMsg, "pkMsg");
        if (f(pkId)) {
            as asVar = pkMsg.f401339d;
            if (asVar != null && asVar.f401312a == pkId) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return true;
            }
        }
        return false;
    }

    public final boolean i(@NotNull au pkMsg) {
        Intrinsics.checkNotNullParameter(pkMsg, "pkMsg");
        if (pkMsg.f401337b == 1) {
            return true;
        }
        return false;
    }

    public final boolean j(@NotNull q rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        int i3 = rsp.f401383f;
        if (i3 != 2 && i3 != 3) {
            return false;
        }
        return true;
    }
}
