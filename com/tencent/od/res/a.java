package com.tencent.od.res;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.timi.game.api.remoteres.ZipInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0017\u0010\u0004\u001a\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/timi/game/api/remoteres/b;", "a", "Lcom/tencent/timi/game/api/remoteres/b;", "()Lcom/tencent/timi/game/api/remoteres/b;", "VOICE_GAME_RES", "qq-live-od-adapter-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final ZipInfo f339489a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19800);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f339489a = new ZipInfo("https://dlied5v6.qq.com/now/qq-live/voice-room/voice-game/071e157cd5cb52923d9e17331e0245e8.zip", "071e157cd5cb52923d9e17331e0245e8");
        }
    }

    @NotNull
    public static final ZipInfo a() {
        return f339489a;
    }
}
