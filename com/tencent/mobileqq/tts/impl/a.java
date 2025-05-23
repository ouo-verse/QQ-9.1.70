package com.tencent.mobileqq.tts.impl;

import com.tencent.mobileqq.tts.ITtsPlayer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\tH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/tts/impl/a;", "", "", "getSpeech", "Lcom/tencent/mobileqq/tts/ITtsPlayer;", "player", "", "a", "stop", "", "isRunning", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface a {
    void a(@NotNull ITtsPlayer player);

    @NotNull
    String getSpeech();

    boolean isRunning();

    void stop();
}
