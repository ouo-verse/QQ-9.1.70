package com.tencent.mobileqq.guild.feed.feedsquare.widget;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
final class GuildFeedSquareFeedItemView$tapRunnable$2 extends Lambda implements Function0<Runnable> {
    final /* synthetic */ GuildFeedSquareFeedItemView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedSquareFeedItemView$tapRunnable$2(GuildFeedSquareFeedItemView guildFeedSquareFeedItemView) {
        super(0);
        this.this$0 = guildFeedSquareFeedItemView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildFeedSquareFeedItemView this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        z16 = this$0.isReleased;
        if (!z16) {
            this$0.setPressed(true);
        }
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Runnable invoke() {
        final GuildFeedSquareFeedItemView guildFeedSquareFeedItemView = this.this$0;
        return new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.f
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedSquareFeedItemView$tapRunnable$2.b(GuildFeedSquareFeedItemView.this);
            }
        };
    }
}
