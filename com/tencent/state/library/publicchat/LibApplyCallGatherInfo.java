package com.tencent.state.library.publicchat;

import bs4.f;
import bs4.j;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import ft4.b;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001c\u0010\u001dB\u0013\b\u0016\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b\u001c\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/library/publicchat/LibApplyCallGatherInfo;", "", "Lbs4/j;", "component1", "Lbs4/f;", "component2", "", "component3", QCircleAlphaUserReporter.KEY_USER, "room", "msgOffset", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Lbs4/j;", "getUser", "()Lbs4/j;", "Lbs4/f;", "getRoom", "()Lbs4/f;", "[B", "getMsgOffset", "()[B", "<init>", "(Lbs4/j;Lbs4/f;[B)V", "Lft4/b;", "pb", "(Lft4/b;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final /* data */ class LibApplyCallGatherInfo {
    private final byte[] msgOffset;
    private final f room;
    private final j user;

    public LibApplyCallGatherInfo(j user, f room, byte[] msgOffset) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(room, "room");
        Intrinsics.checkNotNullParameter(msgOffset, "msgOffset");
        this.user = user;
        this.room = room;
        this.msgOffset = msgOffset;
    }

    /* renamed from: component1, reason: from getter */
    public final j getUser() {
        return this.user;
    }

    /* renamed from: component2, reason: from getter */
    public final f getRoom() {
        return this.room;
    }

    /* renamed from: component3, reason: from getter */
    public final byte[] getMsgOffset() {
        return this.msgOffset;
    }

    public final LibApplyCallGatherInfo copy(j user, f room, byte[] msgOffset) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(room, "room");
        Intrinsics.checkNotNullParameter(msgOffset, "msgOffset");
        return new LibApplyCallGatherInfo(user, room, msgOffset);
    }

    public final byte[] getMsgOffset() {
        return this.msgOffset;
    }

    public final f getRoom() {
        return this.room;
    }

    public final j getUser() {
        return this.user;
    }

    public int hashCode() {
        j jVar = this.user;
        int hashCode = (jVar != null ? jVar.hashCode() : 0) * 31;
        f fVar = this.room;
        int hashCode2 = (hashCode + (fVar != null ? fVar.hashCode() : 0)) * 31;
        byte[] bArr = this.msgOffset;
        return hashCode2 + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }

    public String toString() {
        return "LibApplyCallGatherInfo(user=" + this.user + ", room=" + this.room + ", msgOffset=" + Arrays.toString(this.msgOffset) + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LibApplyCallGatherInfo(b bVar) {
        this(r1, r0, (bVar == null || (r4 = bVar.f400614c) == null) ? new byte[0] : r4);
        byte[] bArr;
        j d16 = j.d(bVar != null ? bVar.f400612a : null);
        Intrinsics.checkNotNullExpressionValue(d16, "UserInfo.parseFrom(pb?.user)");
        f c16 = f.c(bVar != null ? bVar.f400613b : null);
        Intrinsics.checkNotNullExpressionValue(c16, "RoomInfo.parseFrom(pb?.room)");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LibApplyCallGatherInfo)) {
            return false;
        }
        LibApplyCallGatherInfo libApplyCallGatherInfo = (LibApplyCallGatherInfo) other;
        return Intrinsics.areEqual(this.user, libApplyCallGatherInfo.user) && Intrinsics.areEqual(this.room, libApplyCallGatherInfo.room) && Intrinsics.areEqual(this.msgOffset, libApplyCallGatherInfo.msgOffset);
    }

    public static /* synthetic */ LibApplyCallGatherInfo copy$default(LibApplyCallGatherInfo libApplyCallGatherInfo, j jVar, f fVar, byte[] bArr, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            jVar = libApplyCallGatherInfo.user;
        }
        if ((i3 & 2) != 0) {
            fVar = libApplyCallGatherInfo.room;
        }
        if ((i3 & 4) != 0) {
            bArr = libApplyCallGatherInfo.msgOffset;
        }
        return libApplyCallGatherInfo.copy(jVar, fVar, bArr);
    }
}
