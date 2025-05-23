package com.tencent.guild.aio.article.title.navigate;

import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/guild/aio/article/title/navigate/GuildArticleTitleNavigateUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "MainMsgSummaryUIState", "ShowNavigateUIState", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public class GuildArticleTitleNavigateUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/article/title/navigate/GuildArticleTitleNavigateUIState$MainMsgSummaryUIState;", "Lcom/tencent/guild/aio/article/title/navigate/GuildArticleTitleNavigateUIState;", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "summary", "<init>", "(Ljava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class MainMsgSummaryUIState extends GuildArticleTitleNavigateUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String summary;

        public MainMsgSummaryUIState(@NotNull String summary) {
            Intrinsics.checkNotNullParameter(summary, "summary");
            this.summary = summary;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getSummary() {
            return this.summary;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/article/title/navigate/GuildArticleTitleNavigateUIState$ShowNavigateUIState;", "Lcom/tencent/guild/aio/article/title/navigate/GuildArticleTitleNavigateUIState;", "", "d", "I", "a", "()I", "visibility", "<init>", "(I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class ShowNavigateUIState extends GuildArticleTitleNavigateUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int visibility;

        public ShowNavigateUIState(int i3) {
            this.visibility = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getVisibility() {
            return this.visibility;
        }
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }
}
