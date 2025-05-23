package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qj1.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0001H\u0016R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\f\u001a\u0004\b\r\u0010\u000eR!\u0010\u0016\u001a\f\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u00108\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\"\u0010)\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001d\u001a\u0004\b'\u0010\u001f\"\u0004\b(\u0010!R\"\u0010,\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001d\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010!R\"\u0010.\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b\u001c\u0010\u001f\"\u0004\b-\u0010!R\"\u00100\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b/\u0010!\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/c;", "Lhl1/g;", "", "getItemType", "", "getItemId", "newItem", "", "b", "a", "", "c", "I", "i", "()I", "spanCount", "", "Lqj1/l;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/IMediaDisplayable;", "Ljava/util/List;", tl.h.F, "()Ljava/util/List;", "mediaList", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "f", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "feedDetail", "d", "Z", "g", "()Z", DomainData.DOMAIN_NAME, "(Z)V", "firstLine", "e", "getLastLine", "o", "lastLine", "j", "p", "topLeftRadius", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "topRightRadius", "l", "bottomLeftRadius", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "bottomRightRadius", "<init>", "(ILjava/util/List;Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c implements hl1.g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int spanCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<l> mediaList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FeedDetailMainData feedDetail;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean firstLine;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean lastLine;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean topLeftRadius;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean topRightRadius;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean bottomLeftRadius;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean bottomRightRadius;

    /* JADX WARN: Multi-variable type inference failed */
    public c(int i3, @NotNull List<? extends l> mediaList, @NotNull FeedDetailMainData feedDetail) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Intrinsics.checkNotNullParameter(feedDetail, "feedDetail");
        this.spanCount = i3;
        this.mediaList = mediaList;
        this.feedDetail = feedDetail;
    }

    @Override // hl1.g
    public boolean a(@NotNull hl1.g newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof c)) {
            return false;
        }
        return Intrinsics.areEqual(((c) newItem).mediaList, this.mediaList);
    }

    @Override // hl1.g
    public boolean b(@NotNull hl1.g newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return newItem instanceof c;
    }

    @Override // hl1.g
    @Nullable
    public Object c(@NotNull hl1.g newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return null;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getBottomLeftRadius() {
        return this.bottomLeftRadius;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getBottomRightRadius() {
        return this.bottomRightRadius;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final FeedDetailMainData getFeedDetail() {
        return this.feedDetail;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getFirstLine() {
        return this.firstLine;
    }

    @Override // hl1.g
    public long getItemId() {
        return this.mediaList.hashCode();
    }

    @Override // hl1.g
    public int getItemType() {
        return 2;
    }

    @NotNull
    public final List<l> h() {
        return this.mediaList;
    }

    /* renamed from: i, reason: from getter */
    public final int getSpanCount() {
        return this.spanCount;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getTopLeftRadius() {
        return this.topLeftRadius;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getTopRightRadius() {
        return this.topRightRadius;
    }

    public final void l(boolean z16) {
        this.bottomLeftRadius = z16;
    }

    public final void m(boolean z16) {
        this.bottomRightRadius = z16;
    }

    public final void n(boolean z16) {
        this.firstLine = z16;
    }

    public final void o(boolean z16) {
        this.lastLine = z16;
    }

    public final void p(boolean z16) {
        this.topLeftRadius = z16;
    }

    public final void q(boolean z16) {
        this.topRightRadius = z16;
    }
}
