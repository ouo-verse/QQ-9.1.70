package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001:\u0001+J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0005H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\bH&J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u000fH&JL\u0010\u001c\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052:\b\u0002\u0010\u001d\u001a4\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001eH&J7\u0010#\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052%\b\u0002\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u0003\u0018\u00010$H&J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\rH&J\u0018\u0010(\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\rH&J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasAudioApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "closeLogic", "", OperateCustomButton.OPERATE_CREATE, "", "path", "getAudioDuration", "", "token", "getCurrentPosition", "getDuration", "getVolume", "", "isLooping", "", "isPlaying", "next", "openLogic", "bookId", "pause", "play", "release", "resume", "seekTo", com.tencent.luggage.wxa.c8.c.G, "setLoop", "isLoop", "setOnErrorListener", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "what", "code", "setPlayStateListener", "Lkotlin/Function1;", "state", "setSpeed", "speed", "setVolume", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "stop", "PlayState", "vas-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasAudioApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasAudioApi$PlayState;", "", "(Ljava/lang/String;I)V", "IDLE", "PLAYING", "PAUSED", "STOPPED", "FINISHED", "vas-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public enum PlayState {
        IDLE,
        PLAYING,
        PAUSED,
        STOPPED,
        FINISHED
    }

    void closeLogic();

    @NotNull
    String create(@NotNull String path);

    int getAudioDuration(@NotNull String token, @NotNull String path);

    int getCurrentPosition(@NotNull String token);

    int getDuration(@NotNull String token);

    float getVolume(@NotNull String token);

    boolean isLooping(@NotNull String token);

    boolean isPlaying(@NotNull String token);

    void next(@NotNull String path);

    void openLogic(@NotNull String bookId);

    void pause(@NotNull String token);

    void play(@NotNull String token, @NotNull String path);

    void release(@NotNull String token);

    void resume(@NotNull String token);

    void seekTo(@NotNull String token, int pos);

    void setLoop(@NotNull String token, boolean isLoop);

    void setOnErrorListener(@NotNull String token, @Nullable Function2<? super Integer, ? super Integer, Unit> callback);

    void setPlayStateListener(@NotNull String token, @Nullable Function1<? super Integer, Unit> callback);

    void setSpeed(@NotNull String token, float speed);

    void setVolume(@NotNull String token, float volume);

    void stop(@NotNull String token);
}
