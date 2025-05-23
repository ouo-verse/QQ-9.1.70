package com.tencent.mobileqq.qqlive.sail.room;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J;\u0010\u000b\u001a\u00020\b21\u0010\n\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0002j\b\u0012\u0004\u0012\u00020\u0004`\tH&J\b\u0010\f\u001a\u00020\bH&J\b\u0010\r\u001a\u00020\bH&J\b\u0010\u000e\u001a\u00020\bH&J\b\u0010\u000f\u001a\u00020\bH&J\b\u0010\u0010\u001a\u00020\u0004H&J\b\u0010\u0012\u001a\u00020\u0011H&J\b\u0010\u0014\u001a\u00020\u0013H&J\b\u0010\u0016\u001a\u00020\u0015H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&J\u001a\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&J\u0012\u0010\u001e\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/f;", "", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqlive/sail/room/l;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/mobileqq/qqlive/sail/room/Resulter;", "callback", "v", "pause", "resume", "stop", "destroy", "isDestroyed", "Lcom/tencent/mobileqq/qqlive/sail/model/d;", "b", "", "getRoomId", "", "getAppID", "Lcom/tencent/mobileqq/qqlive/sail/room/LiveRoomInteractive;", "o", "", "cmd", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "listener", "p", "e", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface f {
    @NotNull
    com.tencent.mobileqq.qqlive.sail.model.d b();

    void destroy();

    void e(@Nullable g listener);

    @NotNull
    String getAppID();

    long getRoomId();

    boolean isDestroyed();

    @Nullable
    LiveRoomInteractive o();

    void p(int cmd, @Nullable g listener);

    void pause();

    void resume();

    void stop();

    void v(@NotNull Function1<? super l<Boolean>, Unit> callback);
}
