package com.tencent.guild.aio.article.title;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/guild/aio/article/title/GuildArticleTitleEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "NavigateMainMsgIntent", "TitleBarNavigateVisibleIntent", "TitleBarUserInfoVisibleIntent", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public class GuildArticleTitleEvent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/article/title/GuildArticleTitleEvent$NavigateMainMsgIntent;", "Lcom/tencent/guild/aio/article/title/GuildArticleTitleEvent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class NavigateMainMsgIntent extends GuildArticleTitleEvent {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/article/title/GuildArticleTitleEvent$TitleBarNavigateVisibleIntent;", "Lcom/tencent/guild/aio/article/title/GuildArticleTitleEvent;", "", "d", "I", "a", "()I", "visibility", "<init>", "(I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class TitleBarNavigateVisibleIntent extends GuildArticleTitleEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int visibility;

        public TitleBarNavigateVisibleIntent(int i3) {
            this.visibility = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getVisibility() {
            return this.visibility;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/article/title/GuildArticleTitleEvent$TitleBarUserInfoVisibleIntent;", "Lcom/tencent/guild/aio/article/title/GuildArticleTitleEvent;", "", "d", "I", "a", "()I", "visibility", "<init>", "(I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class TitleBarUserInfoVisibleIntent extends GuildArticleTitleEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int visibility;

        public TitleBarUserInfoVisibleIntent(int i3) {
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

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }
}
