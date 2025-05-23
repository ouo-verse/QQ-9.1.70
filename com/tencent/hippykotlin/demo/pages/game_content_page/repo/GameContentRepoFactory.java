package com.tencent.hippykotlin.demo.pages.game_content_page.repo;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GameContentRepoFactory {
    public static final GameContentRepoFactory INSTANCE = new GameContentRepoFactory();

    public final IGameContentRepo create$qecommerce_biz_release(int i3, String str, int i16) {
        if (i3 == 0) {
            return new GameContentMockRepo(str);
        }
        if (i3 == 1) {
            return new GameContentNetRepo(str, i16);
        }
        if (i3 != 2) {
            return new GameContentNetRepo(str, i16);
        }
        return new GameContentCacheRepo(str);
    }
}
