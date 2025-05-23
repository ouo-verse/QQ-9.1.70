package com.tencent.filament.zplan.business.api;

import androidx.annotation.Keep;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.engine.js.FilamentEventDispatcher;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&J&\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H&J\b\u0010\u0019\u001a\u00020\u0004H&J\b\u0010\u001b\u001a\u00020\u001aH&J\b\u0010\u001c\u001a\u00020\u001aH&J\b\u0010\u001d\u001a\u00020\u001aH&J\b\u0010\u001f\u001a\u00020\u001eH&J\u001f\u0010 \u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!J\u0013\u0010\"\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010#\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/filament/zplan/business/api/IBusinessScene;", "", "Lcom/tencent/filament/zplan/engine/js/FilamentEventDispatcher;", "dispatcher", "", "setEventDispatcher", "Lcom/tencent/filament/zplan/business/api/b;", "task", "setExecuteFunk", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2;", "viewer", "setViewer", "", "event", "eventData", "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "processDispatchEvent", "", "now", "Lcom/tencent/filament/zplan/business/api/a;", "animate", "Lcom/tencent/filament/zplan/business/api/c;", "listener", "setReloadAvatarListener", "onFirstRenderEnd", "", "canRender", "needRecordFirstFrame", "launchOnIOThread", "Lcom/tencent/filament/zplan/business/api/SceneType;", "getSceneType", "onLaunch", "(Lcom/tencent/zplan/zplantracing/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onTerminate", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface IBusinessScene {
    @Nullable
    a animate(double now, @Nullable com.tencent.zplan.zplantracing.c zplanSpanContext);

    boolean canRender();

    @NotNull
    SceneType getSceneType();

    boolean launchOnIOThread();

    boolean needRecordFirstFrame();

    void onFirstRenderEnd();

    @Nullable
    Object onLaunch(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object onPause(@NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object onTerminate(@NotNull Continuation<? super Unit> continuation);

    void processDispatchEvent(@NotNull String event, @Nullable String eventData, @Nullable com.tencent.zplan.zplantracing.c zplanSpanContext);

    void setEventDispatcher(@Nullable FilamentEventDispatcher dispatcher);

    void setExecuteFunk(@Nullable b task);

    void setReloadAvatarListener(@NotNull c listener);

    void setViewer(@Nullable FilamentViewerV2 viewer);
}
