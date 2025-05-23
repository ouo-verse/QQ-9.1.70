package com.tencent.guild.aio.article.title.action;

import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/guild/aio/article/title/action/GuildArticleTitleActionUIState;", "Lcom/tencent/aio/base/mvi/part/TitleUIState;", "()V", "GuildAIOTitleMultiUIState", "GuildArticleMoreUIState", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public class GuildArticleTitleActionUIState implements TitleUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/article/title/action/GuildArticleTitleActionUIState$GuildAIOTitleMultiUIState;", "Lcom/tencent/guild/aio/article/title/action/GuildArticleTitleActionUIState;", "", "d", "Z", "a", "()Z", "isMultiMode", "<init>", "(Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildAIOTitleMultiUIState extends GuildArticleTitleActionUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isMultiMode;

        public GuildAIOTitleMultiUIState(boolean z16) {
            this.isMultiMode = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsMultiMode() {
            return this.isMultiMode;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/article/title/action/GuildArticleTitleActionUIState$GuildArticleMoreUIState;", "Lcom/tencent/guild/aio/article/title/action/GuildArticleTitleActionUIState;", "", "d", "Z", "a", "()Z", ViewStickEventHelper.IS_SHOW, "<init>", "(Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildArticleMoreUIState extends GuildArticleTitleActionUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isShow;

        public GuildArticleMoreUIState(boolean z16) {
            this.isShow = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsShow() {
            return this.isShow;
        }
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }
}
