package com.tencent.timi.game.api.cookie;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/timi/game/api/cookie/QQLiveCookieConstants;", "", "()V", "Companion", "CookieKeys", "timi-game-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class QQLiveCookieConstants {

    @NotNull
    public static final String I_LIVE_DOMAIN = "ilive.qq.com";

    @NotNull
    public static final String NOW_DOMAIN = "now.qq.com";

    @NotNull
    public static final String QQ_LIVE_DOMAIN = "qlive.qq.com";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/timi/game/api/cookie/QQLiveCookieConstants$CookieKeys;", "", "()V", "COOKIE_KEY_NOW_PSKEY", "", "COOKIE_KEY_P_SKEY", "COOKIE_KEY_P_UIN", "COOKIE_KEY_QLIVE_P_UIN", "COOKIE_KEY_QQ_LIVE_PSKEY", "COOKIE_KEY_UIN", "timi-game-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes26.dex */
    public static final class CookieKeys {

        @NotNull
        public static final String COOKIE_KEY_NOW_PSKEY = "now_p_skey";

        @NotNull
        public static final String COOKIE_KEY_P_SKEY = "p_skey";

        @NotNull
        public static final String COOKIE_KEY_P_UIN = "p_uin";

        @NotNull
        public static final String COOKIE_KEY_QLIVE_P_UIN = "qlive_p_uin";

        @NotNull
        public static final String COOKIE_KEY_QQ_LIVE_PSKEY = "qlive_p_skey";

        @NotNull
        public static final String COOKIE_KEY_UIN = "uin";

        @NotNull
        public static final CookieKeys INSTANCE = new CookieKeys();

        CookieKeys() {
        }
    }
}
