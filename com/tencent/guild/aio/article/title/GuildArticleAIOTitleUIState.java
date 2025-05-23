package com.tencent.guild.aio.article.title;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/guild/aio/article/title/GuildArticleAIOTitleUIState;", "Lcom/tencent/aio/base/mvi/part/TitleUIState;", "()V", "TitleAlphaUIState", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public class GuildArticleAIOTitleUIState implements TitleUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/article/title/GuildArticleAIOTitleUIState$TitleAlphaUIState;", "Lcom/tencent/guild/aio/article/title/GuildArticleAIOTitleUIState;", "", "d", UserInfo.SEX_FEMALE, "getAlpha", "()F", c.f123400v, "<init>", "(F)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class TitleAlphaUIState extends GuildArticleAIOTitleUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final float alpha;

        public TitleAlphaUIState(float f16) {
            this.alpha = f16;
        }
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }
}
