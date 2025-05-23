package com.tencent.mobileqq.guild.feed.morepanel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/j;", "Lcom/tencent/mobileqq/guild/feed/morepanel/f;", "", "isShowing", "", "hideTitle", "recentContact", "shareChannel", "appendAction", "a", "Lcom/tencent/mobileqq/sharepanel/f;", "Lcom/tencent/mobileqq/sharepanel/f;", "sharePanel", "<init>", "(Lcom/tencent/mobileqq/sharepanel/f;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.sharepanel.f sharePanel;

    public j(@NotNull com.tencent.mobileqq.sharepanel.f sharePanel) {
        Intrinsics.checkNotNullParameter(sharePanel, "sharePanel");
        this.sharePanel = sharePanel;
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.f
    public boolean isShowing() {
        this.sharePanel.dismiss();
        return false;
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.f
    public void hideTitle() {
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.f
    public void a(boolean recentContact, boolean shareChannel, boolean appendAction) {
    }
}
