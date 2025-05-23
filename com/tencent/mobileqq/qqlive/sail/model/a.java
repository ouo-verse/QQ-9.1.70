package com.tencent.mobileqq.qqlive.sail.model;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.sail.room.l;
import com.tencent.mobileqq.transfile.dns.DomainData;
import gr4.o;
import gr4.v;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import pt3.j;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\b\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00060\u0000H\u0007\u00a2\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002*\b\u0012\u0004\u0012\u00020\u00060\u0000H\u0007\u00a2\u0006\u0004\b\n\u0010\u0005\u001a\u0019\u0010\f\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u000b0\u0000H\u0007\u00a2\u0006\u0004\b\f\u0010\t\u001a\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002*\b\u0012\u0004\u0012\u00020\u000b0\u0000H\u0007\u00a2\u0006\u0004\b\r\u0010\u0005\u001a\u0019\u0010\u000f\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u000e0\u0000H\u0007\u00a2\u0006\u0004\b\u000f\u0010\t\u001a\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0002*\b\u0012\u0004\u0012\u00020\u000e0\u0000H\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0005\u001a\u0019\u0010\u0012\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00110\u0000H\u0007\u00a2\u0006\u0004\b\u0012\u0010\t\u001a\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0002*\b\u0012\u0004\u0012\u00020\u00110\u0000H\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0005\u001a\u0019\u0010\u0015\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00140\u0000H\u0007\u00a2\u0006\u0004\b\u0015\u0010\t\u001a\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0002*\b\u0012\u0004\u0012\u00020\u00140\u0000H\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0005\u001a\u0019\u0010\u0018\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00170\u0000H\u0007\u00a2\u0006\u0004\b\u0018\u0010\t\u001a\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u0002*\b\u0012\u0004\u0012\u00020\u00170\u0000H\u0007\u00a2\u0006\u0004\b\u0019\u0010\u0005\u001a\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0002*\b\u0012\u0004\u0012\u00020\u001a0\u0000H\u0007\u00a2\u0006\u0004\b\u001b\u0010\u0005\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "Lgr4/o;", "Lcom/tencent/mobileqq/qqlive/sail/room/l;", "Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;", "l", "(Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;)Lcom/tencent/mobileqq/qqlive/sail/room/l;", "Lgr4/v;", "", "e", "(Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;)Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lgr4/e;", "c", "j", "Lpt3/j;", "f", DomainData.DOMAIN_NAME, "Lpt3/b;", "a", "i", "Llt3/c;", "d", "k", "Lrt3/h;", "b", "g", "Lrt3/f;", h.F, "qq-live-sdk-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    @JvmName(name = "isOKEndNewRsp")
    public static final boolean a(@NotNull QQLiveResponse<pt3.b> qQLiveResponse) {
        boolean z16;
        Intrinsics.checkNotNullParameter(qQLiveResponse, "<this>");
        if (qQLiveResponse.isFailed()) {
            return false;
        }
        if (qQLiveResponse.getRsp() != null && r6.f427119a == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    @JvmName(name = "isOKEnterRoomReply")
    public static final boolean b(@NotNull QQLiveResponse<rt3.h> qQLiveResponse) {
        Intrinsics.checkNotNullParameter(qQLiveResponse, "<this>");
        if (!qQLiveResponse.isFailed() && qQLiveResponse.getRsp() != null) {
            return true;
        }
        return false;
    }

    @JvmName(name = "isOKEnterRsp")
    public static final boolean c(@NotNull QQLiveResponse<gr4.e> qQLiveResponse) {
        boolean z16;
        Intrinsics.checkNotNullParameter(qQLiveResponse, "<this>");
        if (qQLiveResponse.isFailed()) {
            return false;
        }
        if (qQLiveResponse.getRsp() != null && r6.f403111a == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    @JvmName(name = "isOKHeartbeatRsp")
    public static final boolean d(@NotNull QQLiveResponse<lt3.c> qQLiveResponse) {
        boolean z16;
        Intrinsics.checkNotNullParameter(qQLiveResponse, "<this>");
        if (qQLiveResponse.isFailed()) {
            return false;
        }
        if (qQLiveResponse.getRsp() != null && r6.f415549a == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    @JvmName(name = "isOKSetRsp")
    public static final boolean e(@NotNull QQLiveResponse<v> qQLiveResponse) {
        boolean z16;
        Intrinsics.checkNotNullParameter(qQLiveResponse, "<this>");
        if (qQLiveResponse.isFailed()) {
            return false;
        }
        if (qQLiveResponse.getRsp() != null && r6.f403228a == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    @JvmName(name = "isOKStartNewRsp")
    public static final boolean f(@NotNull QQLiveResponse<j> qQLiveResponse) {
        boolean z16;
        Intrinsics.checkNotNullParameter(qQLiveResponse, "<this>");
        if (qQLiveResponse.isFailed()) {
            return false;
        }
        if (qQLiveResponse.getRsp() != null && r6.f427161a == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    @JvmName(name = "toEnterRoomReply")
    @NotNull
    public static final l<rt3.h> g(@NotNull QQLiveResponse<rt3.h> qQLiveResponse) {
        Intrinsics.checkNotNullParameter(qQLiveResponse, "<this>");
        if (b(qQLiveResponse)) {
            return new l<>(qQLiveResponse.getRsp(), 0L, null, 0, 12, null);
        }
        return new l<>(null, qQLiveResponse.getRetCode(), qQLiveResponse.getErrMsg(), 2);
    }

    @JvmName(name = "toHuYaEnterRoomReply")
    @NotNull
    public static final l<rt3.f> h(@NotNull QQLiveResponse<rt3.f> qQLiveResponse) {
        Intrinsics.checkNotNullParameter(qQLiveResponse, "<this>");
        if (!qQLiveResponse.isFailed() && qQLiveResponse.getRsp() != null) {
            return new l<>(qQLiveResponse.getRsp(), 0L, null, 0, 12, null);
        }
        return new l<>(null, qQLiveResponse.getRetCode(), qQLiveResponse.getErrMsg(), 2);
    }

    @JvmName(name = "toRoomResultEndNewRsp")
    @NotNull
    public static final l<pt3.b> i(@NotNull QQLiveResponse<pt3.b> qQLiveResponse) {
        Intrinsics.checkNotNullParameter(qQLiveResponse, "<this>");
        if (a(qQLiveResponse)) {
            return new l<>(qQLiveResponse.getRsp(), 0L, null, 0, 12, null);
        }
        if (qQLiveResponse.getRsp() == null) {
            return new l<>(null, qQLiveResponse.getRetCode(), qQLiveResponse.getErrMsg(), 2);
        }
        Intrinsics.checkNotNull(qQLiveResponse.getRsp());
        return new l<>(null, r13.f427119a, "", 3);
    }

    @JvmName(name = "toRoomResultEnterRsp")
    @NotNull
    public static final l<gr4.e> j(@NotNull QQLiveResponse<gr4.e> qQLiveResponse) {
        Intrinsics.checkNotNullParameter(qQLiveResponse, "<this>");
        if (c(qQLiveResponse)) {
            return new l<>(qQLiveResponse.getRsp(), 0L, null, 0, 12, null);
        }
        if (qQLiveResponse.getRsp() == null) {
            return new l<>(null, qQLiveResponse.getRetCode(), qQLiveResponse.getErrMsg(), 2);
        }
        gr4.e rsp = qQLiveResponse.getRsp();
        Intrinsics.checkNotNull(rsp);
        long j3 = rsp.f403111a;
        gr4.e rsp2 = qQLiveResponse.getRsp();
        Intrinsics.checkNotNull(rsp2);
        return new l<>(null, j3, rsp2.f403112b, 3);
    }

    @JvmName(name = "toRoomResultHeartbeatRsp")
    @NotNull
    public static final l<lt3.c> k(@NotNull QQLiveResponse<lt3.c> qQLiveResponse) {
        Intrinsics.checkNotNullParameter(qQLiveResponse, "<this>");
        if (d(qQLiveResponse)) {
            return new l<>(qQLiveResponse.getRsp(), 0L, null, 0, 12, null);
        }
        if (qQLiveResponse.getRsp() == null) {
            return new l<>(null, qQLiveResponse.getRetCode(), qQLiveResponse.getErrMsg(), 2);
        }
        Intrinsics.checkNotNull(qQLiveResponse.getRsp());
        return new l<>(null, r13.f415549a, "", 3);
    }

    @JvmName(name = "toRoomResultPrepareRsp")
    @NotNull
    public static final l<AnchorRoomInfo> l(@NotNull QQLiveResponse<o> qQLiveResponse) {
        o rsp;
        Intrinsics.checkNotNullParameter(qQLiveResponse, "<this>");
        if (qQLiveResponse.isSuccess() && qQLiveResponse.getRetCode() == 0 && (rsp = qQLiveResponse.getRsp()) != null) {
            AnchorRoomInfo a16 = AnchorRoomInfo.INSTANCE.a(rsp);
            if (rsp.f403157a == 0) {
                return new l<>(a16, 0L, null, 0, 12, null);
            }
            return new l<>(a16, rsp.f403157a, rsp.f403158b, 3);
        }
        return new l<>(null, qQLiveResponse.getRetCode(), qQLiveResponse.getErrMsg(), 2);
    }

    @JvmName(name = "toRoomResultSetRsp")
    @NotNull
    public static final l<v> m(@NotNull QQLiveResponse<v> qQLiveResponse) {
        Intrinsics.checkNotNullParameter(qQLiveResponse, "<this>");
        if (e(qQLiveResponse)) {
            return new l<>(qQLiveResponse.getRsp(), 0L, null, 0, 12, null);
        }
        if (qQLiveResponse.getRsp() == null) {
            return new l<>(null, qQLiveResponse.getRetCode(), qQLiveResponse.getErrMsg(), 2);
        }
        v rsp = qQLiveResponse.getRsp();
        Intrinsics.checkNotNull(rsp);
        long j3 = rsp.f403228a;
        v rsp2 = qQLiveResponse.getRsp();
        Intrinsics.checkNotNull(rsp2);
        return new l<>(null, j3, rsp2.f403229b, 3);
    }

    @JvmName(name = "toRoomResultStartNewRsp")
    @NotNull
    public static final l<j> n(@NotNull QQLiveResponse<j> qQLiveResponse) {
        Intrinsics.checkNotNullParameter(qQLiveResponse, "<this>");
        if (f(qQLiveResponse)) {
            return new l<>(qQLiveResponse.getRsp(), 0L, null, 0, 12, null);
        }
        if (qQLiveResponse.getRsp() == null) {
            return new l<>(null, qQLiveResponse.getRetCode(), qQLiveResponse.getErrMsg(), 2);
        }
        Intrinsics.checkNotNull(qQLiveResponse.getRsp());
        return new l<>(null, r13.f427161a, "", 3);
    }
}
