package com.tencent.mobileqq.qqlive.sail.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.model.player.PlayerConfig;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/util/a;", "", "Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;", "a", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f273183a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53116);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f273183a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final PlayerConfig a() {
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (PlayerConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String d16 = ht3.a.d("qqlive_room_player_config", "");
        isBlank = StringsKt__StringsJVMKt.isBlank(d16);
        if (isBlank) {
            AegisLogger.INSTANCE.i("Audience|PlayerConfigParser", "parse", "no config");
            return new PlayerConfig(129, false, false, 0L, false, false, null, 0L, 0L, 0L, 0L, 0L, 0L, null, 0.0f, false, 0L, 0L, false, false, null, 0L, false, 8388606, null);
        }
        try {
            JSONObject jSONObject = new JSONObject(d16);
            return new PlayerConfig(129, false, false, jSONObject.getLong("replayIntervalMs"), false, false, null, jSONObject.getLong("minBufferDuration"), jSONObject.getLong("maxBufferDuration"), jSONObject.getLong("minBufferingTimeMs"), jSONObject.getLong("maxBufferingTimeMs"), jSONObject.getLong("bufferingTimeoutMs"), jSONObject.getLong("bufferingPacketDurationMin"), PlayerConfig.Companion.LatencyStrategy.INSTANCE.a(jSONObject.getInt("latencyStrategy")), (float) jSONObject.getDouble("speedUpRate"), jSONObject.getBoolean("isEnableDownloadProxy"), jSONObject.getLong("flvPreloadDurationMs"), jSONObject.getLong("flvPreloadSize"), jSONObject.getBoolean("isSupportQuicFLv"), jSONObject.getBoolean("enableQuicPlaintext"), null, jSONObject.getLong("updateDownloadQualityIntervalMs"), false, 5242998, null);
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Audience|PlayerConfigParser", "parse", "error, ", e16);
            return new PlayerConfig(129, false, false, 0L, false, false, null, 0L, 0L, 0L, 0L, 0L, 0L, null, 0.0f, false, 0L, 0L, false, false, null, 0L, false, 8388606, null);
        }
    }
}
