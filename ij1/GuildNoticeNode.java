package ij1;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qqnt.kernelgpro.nativeinterface.GuildInteractiveNotificationItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0006B%\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0016\u0012\b\b\u0002\u0010\"\u001a\u00020\t\u00a2\u0006\u0004\b#\u0010$J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0004J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\"\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lij1/q;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GuildInteractiveNotificationItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "e", "a", "f", "b", "", "toString", "", "hashCode", "other", "equals", "Lij1/o;", "Lij1/o;", "d", "()Lij1/o;", "setRedPoint", "(Lij1/o;)V", "redPoint", "", "J", "getMessageTime", "()J", "setMessageTime", "(J)V", "messageTime", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "message", "<init>", "(Lij1/o;JLjava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ij1.q, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildNoticeNode {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private GuildNoticeBlockRedPoint redPoint;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private long messageTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String message;

    public GuildNoticeNode() {
        this(null, 0L, null, 7, null);
    }

    public final boolean a() {
        boolean z16;
        if (this.message.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        this.message = "";
        return true;
    }

    public final boolean b() {
        if (this.redPoint.getCount() == 0) {
            return false;
        }
        this.redPoint.c(0);
        return true;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final GuildNoticeBlockRedPoint getRedPoint() {
        return this.redPoint;
    }

    public final boolean e(@NotNull GuildInteractiveNotificationItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        boolean z16 = !Intrinsics.areEqual(this.message, item.managerAbstract);
        if (z16) {
            String str = item.managerAbstract;
            Intrinsics.checkNotNullExpressionValue(str, "item.managerAbstract");
            this.message = str;
        }
        return z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildNoticeNode)) {
            return false;
        }
        GuildNoticeNode guildNoticeNode = (GuildNoticeNode) other;
        if (Intrinsics.areEqual(this.redPoint, guildNoticeNode.redPoint) && this.messageTime == guildNoticeNode.messageTime && Intrinsics.areEqual(this.message, guildNoticeNode.message)) {
            return true;
        }
        return false;
    }

    public final boolean f(@NotNull GuildInteractiveNotificationItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        boolean z16 = false;
        GuildNoticeBlockRedPoint guildNoticeBlockRedPoint = new GuildNoticeBlockRedPoint(0, 0, 3, null);
        guildNoticeBlockRedPoint.d(item.unreadType);
        guildNoticeBlockRedPoint.c(item.count);
        if (this.redPoint.getCount() != guildNoticeBlockRedPoint.getCount() || this.redPoint.getRedPointType() != guildNoticeBlockRedPoint.getRedPointType()) {
            z16 = true;
        }
        this.redPoint = guildNoticeBlockRedPoint;
        Logger.f235387a.d().d("GuildNoticeNode", 1, "updateRedPoint(" + getRedPoint() + ") " + z16);
        return z16;
    }

    public int hashCode() {
        return (((this.redPoint.hashCode() * 31) + androidx.fragment.app.a.a(this.messageTime)) * 31) + this.message.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildNoticeNode(redPoint=" + this.redPoint + ", messageTime=" + this.messageTime + ", message=" + this.message + ")";
    }

    public GuildNoticeNode(@NotNull GuildNoticeBlockRedPoint redPoint, long j3, @NotNull String message) {
        Intrinsics.checkNotNullParameter(redPoint, "redPoint");
        Intrinsics.checkNotNullParameter(message, "message");
        this.redPoint = redPoint;
        this.messageTime = j3;
        this.message = message;
    }

    public /* synthetic */ GuildNoticeNode(GuildNoticeBlockRedPoint guildNoticeBlockRedPoint, long j3, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new GuildNoticeBlockRedPoint(0, 0, 3, null) : guildNoticeBlockRedPoint, (i3 & 2) != 0 ? 0L : j3, (i3 & 4) != 0 ? "" : str);
    }
}
