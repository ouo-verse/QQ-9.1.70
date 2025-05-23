package com.tencent.mobileqq.guild.message.directmessage.utils;

import com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNode;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0006B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/utils/a;", "", "", "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/a;", "nodes", "Lcom/tencent/mobileqq/guild/message/directmessage/utils/a$a;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f230539a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/utils/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "d", "(J)V", "redPointCount", "c", "grayPointCount", "<init>", "(JJ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.message.directmessage.utils.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class UnreadResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private long redPointCount;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private long grayPointCount;

        public UnreadResult() {
            this(0L, 0L, 3, null);
        }

        /* renamed from: a, reason: from getter */
        public final long getGrayPointCount() {
            return this.grayPointCount;
        }

        /* renamed from: b, reason: from getter */
        public final long getRedPointCount() {
            return this.redPointCount;
        }

        public final void c(long j3) {
            this.grayPointCount = j3;
        }

        public final void d(long j3) {
            this.redPointCount = j3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnreadResult)) {
                return false;
            }
            UnreadResult unreadResult = (UnreadResult) other;
            if (this.redPointCount == unreadResult.redPointCount && this.grayPointCount == unreadResult.grayPointCount) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (androidx.fragment.app.a.a(this.redPointCount) * 31) + androidx.fragment.app.a.a(this.grayPointCount);
        }

        @NotNull
        public String toString() {
            return "UnreadResult(redPointCount=" + this.redPointCount + ", grayPointCount=" + this.grayPointCount + ")";
        }

        public UnreadResult(long j3, long j16) {
            this.redPointCount = j3;
            this.grayPointCount = j16;
        }

        public /* synthetic */ UnreadResult(long j3, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? 0L : j16);
        }
    }

    a() {
    }

    @JvmStatic
    @NotNull
    public static final UnreadResult a(@NotNull List<DirectMessageNode> nodes) {
        Intrinsics.checkNotNullParameter(nodes, "nodes");
        UnreadResult unreadResult = new UnreadResult(0L, 0L, 3, null);
        for (DirectMessageNode directMessageNode : nodes) {
            if (!directMessageNode.getIsInBlack()) {
                int notifyType = directMessageNode.getNotifyType();
                int i3 = 0;
                if (notifyType != 1) {
                    if (notifyType == 3) {
                        long grayPointCount = unreadResult.getGrayPointCount();
                        UnreadInfo unreadInfo = directMessageNode.getUnreadInfo();
                        if (unreadInfo != null) {
                            i3 = unreadInfo.j();
                        }
                        unreadResult.c(grayPointCount + i3);
                    }
                } else {
                    long redPointCount = unreadResult.getRedPointCount();
                    UnreadInfo unreadInfo2 = directMessageNode.getUnreadInfo();
                    if (unreadInfo2 != null) {
                        i3 = unreadInfo2.j();
                    }
                    unreadResult.d(redPointCount + i3);
                }
            }
        }
        return unreadResult;
    }
}
