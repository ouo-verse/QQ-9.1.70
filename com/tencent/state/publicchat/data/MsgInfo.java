package com.tencent.state.publicchat.data;

import androidx.core.app.NotificationCompat;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zr4.e;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b#\u0010$B\u0013\b\u0016\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b#\u0010&J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\t\u001a\u00020\bH\u00c6\u0003J\t\u0010\u000b\u001a\u00020\nH\u00c6\u0003J1\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\nH\u00c6\u0001J\t\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0013H\u00d6\u0001J\u0013\u0010\u0016\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\r\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/state/publicchat/data/MsgInfo;", "", "Lzr4/e;", "toPB", "Lcom/tencent/state/publicchat/data/MsgHeader;", "component1", "Lcom/tencent/state/publicchat/data/UserInfo;", "component2", "", "component3", "", "component4", "header", QCircleAlphaUserReporter.KEY_USER, "body", NotificationCompat.CATEGORY_SYSTEM, "copy", "", "toString", "", "hashCode", "other", "equals", "Lcom/tencent/state/publicchat/data/MsgHeader;", "getHeader", "()Lcom/tencent/state/publicchat/data/MsgHeader;", "Lcom/tencent/state/publicchat/data/UserInfo;", "getUser", "()Lcom/tencent/state/publicchat/data/UserInfo;", "[B", "getBody", "()[B", "Z", "getSys", "()Z", "<init>", "(Lcom/tencent/state/publicchat/data/MsgHeader;Lcom/tencent/state/publicchat/data/UserInfo;[BZ)V", "pb", "(Lzr4/e;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class MsgInfo {
    private final byte[] body;
    private final MsgHeader header;
    private final boolean sys;
    private final UserInfo user;

    public MsgInfo(MsgHeader header, UserInfo user, byte[] body, boolean z16) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(body, "body");
        this.header = header;
        this.user = user;
        this.body = body;
        this.sys = z16;
    }

    /* renamed from: component1, reason: from getter */
    public final MsgHeader getHeader() {
        return this.header;
    }

    /* renamed from: component2, reason: from getter */
    public final UserInfo getUser() {
        return this.user;
    }

    /* renamed from: component3, reason: from getter */
    public final byte[] getBody() {
        return this.body;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getSys() {
        return this.sys;
    }

    public final MsgInfo copy(MsgHeader header, UserInfo user, byte[] body, boolean sys) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(body, "body");
        return new MsgInfo(header, user, body, sys);
    }

    public final byte[] getBody() {
        return this.body;
    }

    public final MsgHeader getHeader() {
        return this.header;
    }

    public final boolean getSys() {
        return this.sys;
    }

    public final UserInfo getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        MsgHeader msgHeader = this.header;
        int hashCode = (msgHeader != null ? msgHeader.hashCode() : 0) * 31;
        UserInfo userInfo = this.user;
        int hashCode2 = (hashCode + (userInfo != null ? userInfo.hashCode() : 0)) * 31;
        byte[] bArr = this.body;
        int hashCode3 = (hashCode2 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        boolean z16 = this.sys;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode3 + i3;
    }

    public final e toPB() {
        e eVar = new e();
        eVar.f453103a = this.header.toPB();
        eVar.f453104b = this.user.toPB();
        eVar.f453105c = this.body;
        eVar.f453106d = this.sys;
        return eVar;
    }

    public String toString() {
        return "MsgInfo(header=" + this.header + ", user=" + this.user + ", body=" + Arrays.toString(this.body) + ", sys=" + this.sys + ")";
    }

    public MsgInfo(e eVar) {
        this(new MsgHeader(eVar != null ? eVar.f453103a : null), new UserInfo(eVar != null ? eVar.f453104b : null), (eVar == null || (r3 = eVar.f453105c) == null) ? new byte[0] : r3, eVar != null ? eVar.f453106d : false);
        byte[] bArr;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MsgInfo)) {
            return false;
        }
        MsgInfo msgInfo = (MsgInfo) other;
        return Intrinsics.areEqual(this.header, msgInfo.header) && Intrinsics.areEqual(this.user, msgInfo.user) && Intrinsics.areEqual(this.body, msgInfo.body) && this.sys == msgInfo.sys;
    }

    public static /* synthetic */ MsgInfo copy$default(MsgInfo msgInfo, MsgHeader msgHeader, UserInfo userInfo, byte[] bArr, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            msgHeader = msgInfo.header;
        }
        if ((i3 & 2) != 0) {
            userInfo = msgInfo.user;
        }
        if ((i3 & 4) != 0) {
            bArr = msgInfo.body;
        }
        if ((i3 & 8) != 0) {
            z16 = msgInfo.sys;
        }
        return msgInfo.copy(msgHeader, userInfo, bArr, z16);
    }
}
