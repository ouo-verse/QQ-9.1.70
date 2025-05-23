package com.tencent.mobileqq.zplan.aio.couple;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import msf.msgcomm.nt_msg_common$Msg;
import tencent.im.s2c.msgtype0x210.submsgtype0x165.Submsgtype0x165$MsgBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0006B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007R \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/couple/a;", "", "", "fromUin", "seq", "", "a", "", "msgBuf", "Lcom/tencent/mobileqq/zplan/aio/couple/a$a;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "pushSceneMap", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f330997a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<Long, Long> pushSceneMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/couple/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "fromUin", "b", "I", "()I", WadlProxyConsts.SCENE_ID, "<init>", "(JI)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.aio.couple.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class MsgContent {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long fromUin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int sceneId;

        public MsgContent() {
            this(0L, 0, 3, null);
        }

        /* renamed from: a, reason: from getter */
        public final long getFromUin() {
            return this.fromUin;
        }

        /* renamed from: b, reason: from getter */
        public final int getSceneId() {
            return this.sceneId;
        }

        public int hashCode() {
            return (com.tencent.mobileqq.vas.banner.c.a(this.fromUin) * 31) + this.sceneId;
        }

        public String toString() {
            return "MsgContent(fromUin=" + this.fromUin + ", sceneId=" + this.sceneId + ")";
        }

        public MsgContent(long j3, int i3) {
            this.fromUin = j3;
            this.sceneId = i3;
        }

        public /* synthetic */ MsgContent(long j3, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 0L : j3, (i16 & 2) != 0 ? 0 : i3);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MsgContent)) {
                return false;
            }
            MsgContent msgContent = (MsgContent) other;
            return this.fromUin == msgContent.fromUin && this.sceneId == msgContent.sceneId;
        }
    }

    a() {
    }

    private final boolean a(long fromUin, long seq) {
        ConcurrentHashMap<Long, Long> concurrentHashMap = pushSceneMap;
        Long l3 = concurrentHashMap.get(Long.valueOf(fromUin));
        if (l3 == null) {
            concurrentHashMap.put(Long.valueOf(fromUin), Long.valueOf(seq));
            return true;
        }
        if (seq < l3.longValue()) {
            return false;
        }
        concurrentHashMap.put(Long.valueOf(fromUin), Long.valueOf(seq));
        return true;
    }

    public final MsgContent b(byte[] msgBuf) {
        Intrinsics.checkNotNullParameter(msgBuf, "msgBuf");
        nt_msg_common$Msg nt_msg_common_msg = new nt_msg_common$Msg();
        nt_msg_common_msg.mergeFrom(msgBuf);
        long j3 = nt_msg_common_msg.routing_head.from_uin.get();
        Submsgtype0x165$MsgBody submsgtype0x165$MsgBody = new Submsgtype0x165$MsgBody();
        submsgtype0x165$MsgBody.mergeFrom(nt_msg_common_msg.body.msg_content.get().toByteArray());
        int i3 = submsgtype0x165$MsgBody.scene_id.get();
        if (!a(j3, submsgtype0x165$MsgBody.seq.get())) {
            return new MsgContent(0L, 0, 3, null);
        }
        return new MsgContent(j3, i3);
    }
}
