package jk1;

import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0012\u001a\u0004\b\f\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Ljk1/a;", "Lij1/b;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "", "k", "", "j", "", "traceId", "e", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", h.F, "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "i", "()Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "initBean", "", "I", "()I", "extType", "<init>", "(Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends ij1.b<GProStFeed> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedGalleryInitBean initBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int extType;

    public /* synthetic */ a(GuildFeedGalleryInitBean guildFeedGalleryInitBean, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(guildFeedGalleryInitBean, (i16 & 2) != 0 ? 0 : i3);
    }

    @Override // ij1.b
    public void e(@Nullable String traceId) {
        super.e(traceId);
        this.initBean.setTraceId(traceId);
    }

    /* renamed from: h, reason: from getter */
    public final int getExtType() {
        return this.extType;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final GuildFeedGalleryInitBean getInitBean() {
        return this.initBean;
    }

    public final boolean j() {
        return this.initBean.isFromTroop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k(@NotNull GProStFeed stFeed) {
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        this.f407799e = stFeed;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull GuildFeedGalleryInitBean initBean, int i3) {
        super(initBean.getFeed());
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.initBean = initBean;
        this.extType = i3;
    }
}
