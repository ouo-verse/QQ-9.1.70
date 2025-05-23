package com.tencent.mobileqq.guild.feed.morepanel;

import com.tencent.mobileqq.widget.share.ShareActionSheet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\f\u00a2\u0006\u0004\b\u000f\u0010\u0010J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/l;", "Lcom/tencent/mobileqq/guild/feed/morepanel/f;", "", "", "b", "isShowing", "", "hideTitle", "recentContact", "shareChannel", "appendAction", "a", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "actionSheet", "<init>", "(Lcom/tencent/mobileqq/widget/share/ShareActionSheet;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class l implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ShareActionSheet actionSheet;

    public l(@NotNull ShareActionSheet actionSheet) {
        Intrinsics.checkNotNullParameter(actionSheet, "actionSheet");
        this.actionSheet = actionSheet;
    }

    private final int b(boolean z16) {
        if (z16) {
            return 0;
        }
        return 8;
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.f
    public void a(boolean recentContact, boolean shareChannel, boolean appendAction) {
        this.actionSheet.setRowVisibility(b(recentContact), b(shareChannel), b(appendAction));
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.f
    public void hideTitle() {
        this.actionSheet.hideTitle();
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.f
    public boolean isShowing() {
        if (this.actionSheet.isShowing()) {
            return true;
        }
        return false;
    }
}
