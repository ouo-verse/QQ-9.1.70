package ij1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\f\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lij1/n;", "Lij1/v;", "Lij1/q;", "", tl.h.F, "Lij1/q;", "i", "()Lij1/q;", "guildNoticeNode", "I", "j", "()I", "pageFrom", "<init>", "(Lij1/q;I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class n extends v<GuildNoticeNode> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildNoticeNode guildNoticeNode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int pageFrom;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NotNull GuildNoticeNode guildNoticeNode, int i3) {
        super(guildNoticeNode);
        Intrinsics.checkNotNullParameter(guildNoticeNode, "guildNoticeNode");
        this.guildNoticeNode = guildNoticeNode;
        this.pageFrom = i3;
    }

    @Override // ij1.v
    public int h() {
        return 1;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final GuildNoticeNode getGuildNoticeNode() {
        return this.guildNoticeNode;
    }

    /* renamed from: j, reason: from getter */
    public final int getPageFrom() {
        return this.pageFrom;
    }
}
