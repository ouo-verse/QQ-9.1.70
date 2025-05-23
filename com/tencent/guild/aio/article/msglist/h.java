package com.tencent.guild.aio.article.msglist;

import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/h;", "Lcom/tencent/mvi/base/route/k;", "<init>", "()V", "a", "b", "c", "Lcom/tencent/guild/aio/article/msglist/h$a;", "Lcom/tencent/guild/aio/article/msglist/h$b;", "Lcom/tencent/guild/aio/article/msglist/h$c;", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class h implements com.tencent.mvi.base.route.k {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/h$a;", "Lcom/tencent/guild/aio/article/msglist/h;", "", "a", "J", "()J", "msgId", "<init>", "(J)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends h {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long msgId;

        public a(long j3) {
            super(null);
            this.msgId = j3;
        }

        /* renamed from: a, reason: from getter */
        public final long getMsgId() {
            return this.msgId;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/h$b;", "Lcom/tencent/guild/aio/article/msglist/h;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends h {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final MsgRecord msgRecord;

        public b(@Nullable MsgRecord msgRecord) {
            super(null);
            this.msgRecord = msgRecord;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final MsgRecord getMsgRecord() {
            return this.msgRecord;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/h$c;", "Lcom/tencent/guild/aio/article/msglist/h;", "", "a", "J", "()J", "mainMsgSeq", "<init>", "(J)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends h {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long mainMsgSeq;

        public c(long j3) {
            super(null);
            this.mainMsgSeq = j3;
        }

        /* renamed from: a, reason: from getter */
        public final long getMainMsgSeq() {
            return this.mainMsgSeq;
        }
    }

    public /* synthetic */ h(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    h() {
    }
}
