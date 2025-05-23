package com.tencent.mobileqq.guild.feed.feedsquare.widget;

import android.view.ViewConfiguration;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
final class GuildFeedSquareFeedItemView$tapTimeout$2 extends Lambda implements Function0<Long> {
    public static final GuildFeedSquareFeedItemView$tapTimeout$2 INSTANCE = new GuildFeedSquareFeedItemView$tapTimeout$2();

    GuildFeedSquareFeedItemView$tapTimeout$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Long invoke() {
        return Long.valueOf(ViewConfiguration.getTapTimeout());
    }
}
