package com.tencent.icgame.game.liveroom.impl.room.audience.component.audiofocus;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/audience/component/audiofocus/a;", "", "Landroid/media/AudioFocusRequest;", "a", "Landroid/media/AudioFocusRequest;", "()Landroid/media/AudioFocusRequest;", "setFocusRequest", "(Landroid/media/AudioFocusRequest;)V", "focusRequest", "Landroid/os/Handler;", "handler", "Landroid/media/AudioAttributes;", "audioAttributes", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "focusChangeListener", "<init>", "(Landroid/os/Handler;Landroid/media/AudioAttributes;Landroid/media/AudioManager$OnAudioFocusChangeListener;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @RequiresApi(26)
    @NotNull
    private AudioFocusRequest focusRequest;

    public a(@NotNull Handler handler, @NotNull AudioAttributes audioAttributes, @NotNull AudioManager.OnAudioFocusChangeListener focusChangeListener) {
        AudioFocusRequest.Builder audioAttributes2;
        AudioFocusRequest.Builder onAudioFocusChangeListener;
        AudioFocusRequest build;
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(audioAttributes, "audioAttributes");
        Intrinsics.checkNotNullParameter(focusChangeListener, "focusChangeListener");
        audioAttributes2 = new AudioFocusRequest.Builder(1).setAudioAttributes(audioAttributes);
        onAudioFocusChangeListener = audioAttributes2.setOnAudioFocusChangeListener(focusChangeListener, handler);
        build = onAudioFocusChangeListener.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(AudioManager.AUD\u2026handler)\n        .build()");
        this.focusRequest = build;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final AudioFocusRequest getFocusRequest() {
        return this.focusRequest;
    }
}
