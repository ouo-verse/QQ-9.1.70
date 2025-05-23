package com.tencent.timi.game.api.cookie;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH&J\u001c\u0010\f\u001a\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\bH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/timi/game/api/cookie/IQQLiveCookieStrategy;", "", "buildAsync", "", "callback", "Lcom/tencent/timi/game/api/cookie/CookieDataCallback;", "buildSync", "", "", "isCookieExpired", "", "domain", "isCookieLegal", "cookies", "removeCookies", "timi-game-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public interface IQQLiveCookieStrategy {
    void buildAsync(@NotNull CookieDataCallback callback);

    @NotNull
    Map<String, String> buildSync();

    boolean isCookieExpired(@NotNull String domain);

    boolean isCookieLegal(@NotNull Map<String, String> cookies);

    void removeCookies(@NotNull String domain);
}
