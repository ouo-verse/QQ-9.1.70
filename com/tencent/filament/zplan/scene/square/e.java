package com.tencent.filament.zplan.scene.square;

import com.tencent.filament.zplan.app.impl.FilamentThreadHandler;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/e;", "", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "a", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2305;", "b", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "Lcom/tencent/filament/zplan/app/impl/FilamentThreadHandler;", "c", "", "g", "Lcom/tencent/filament/zplan/scene/square/SquareMapEvent;", "event", "", "e", "Lcom/tencent/filament/zplan/scene/square/n;", "f", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface e {
    @NotNull
    FilamentUrlTemplate a();

    @Nullable
    FilamentViewerV2305 b();

    @NotNull
    FilamentThreadHandler c();

    void e(@NotNull SquareMapEvent event);

    @Nullable
    n f();

    long g();

    @NotNull
    CoroutineScope getCoroutineScope();
}
