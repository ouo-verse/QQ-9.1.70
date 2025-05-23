package com.tencent.timi.game.emo.data;

import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/timi/game/emo/data/HotPicEmoInfo;", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "", "d", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "a", "(Ljava/lang/String;)V", "url", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class HotPicEmoInfo extends EmoticonInfo {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String url;

    public final void a(@Nullable String str) {
        this.url = str;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }
}
