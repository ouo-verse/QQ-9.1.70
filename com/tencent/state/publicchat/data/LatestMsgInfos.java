package com.tencent.state.publicchat.data;

import com.tencent.mobileqq.vas.banner.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import xs4.f;
import zr4.e;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001a\u0010\u001bB\u0013\b\u0016\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u001a\u0010\u001eJ\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0005H\u00c6\u0003J-\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005H\u00c6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/publicchat/data/LatestMsgInfos;", "", "", "Lcom/tencent/state/publicchat/data/MsgInfo;", "component1", "", "component2", "component3", "msgInfos", "offset", "channelId", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/List;", "getMsgInfos", "()Ljava/util/List;", "J", "getOffset", "()J", "getChannelId", "<init>", "(Ljava/util/List;JJ)V", "Lxs4/f;", "pb", "(Lxs4/f;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class LatestMsgInfos {
    private final long channelId;
    private final List<MsgInfo> msgInfos;
    private final long offset;

    public LatestMsgInfos(List<MsgInfo> msgInfos, long j3, long j16) {
        Intrinsics.checkNotNullParameter(msgInfos, "msgInfos");
        this.msgInfos = msgInfos;
        this.offset = j3;
        this.channelId = j16;
    }

    public final List<MsgInfo> component1() {
        return this.msgInfos;
    }

    /* renamed from: component2, reason: from getter */
    public final long getOffset() {
        return this.offset;
    }

    /* renamed from: component3, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final LatestMsgInfos copy(List<MsgInfo> msgInfos, long offset, long channelId) {
        Intrinsics.checkNotNullParameter(msgInfos, "msgInfos");
        return new LatestMsgInfos(msgInfos, offset, channelId);
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final List<MsgInfo> getMsgInfos() {
        return this.msgInfos;
    }

    public final long getOffset() {
        return this.offset;
    }

    public int hashCode() {
        List<MsgInfo> list = this.msgInfos;
        return ((((list != null ? list.hashCode() : 0) * 31) + c.a(this.offset)) * 31) + c.a(this.channelId);
    }

    public String toString() {
        return "LatestMsgInfos(msgInfos=" + this.msgInfos + ", offset=" + this.offset + ", channelId=" + this.channelId + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LatestMsgInfos(f fVar) {
        this(r1, fVar != null ? fVar.f448487b : 0L, fVar != null ? fVar.f448488c : 0L);
        List emptyList;
        e[] eVarArr;
        if (fVar == null || (eVarArr = fVar.f448486a) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = new ArrayList(eVarArr.length);
            for (e eVar : eVarArr) {
                emptyList.add(new MsgInfo(eVar));
            }
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LatestMsgInfos)) {
            return false;
        }
        LatestMsgInfos latestMsgInfos = (LatestMsgInfos) other;
        return Intrinsics.areEqual(this.msgInfos, latestMsgInfos.msgInfos) && this.offset == latestMsgInfos.offset && this.channelId == latestMsgInfos.channelId;
    }

    public static /* synthetic */ LatestMsgInfos copy$default(LatestMsgInfos latestMsgInfos, List list, long j3, long j16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = latestMsgInfos.msgInfos;
        }
        if ((i3 & 2) != 0) {
            j3 = latestMsgInfos.offset;
        }
        long j17 = j3;
        if ((i3 & 4) != 0) {
            j16 = latestMsgInfos.channelId;
        }
        return latestMsgInfos.copy(list, j17, j16);
    }
}
