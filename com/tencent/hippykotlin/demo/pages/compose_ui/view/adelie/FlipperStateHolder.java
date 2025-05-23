package com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.kuikly.core.timer.Timer;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class FlipperStateHolder {
    public final MutableState contentViewHeight$delegate;
    public int currentPlayIndex;
    public int currentShowIndex;
    public final int intervalTimeMs;
    public final MutableState isAnimating$delegate;
    public int prePlayIndex;
    public final int size;
    public Timer timer;

    public FlipperStateHolder(int i3, int i16) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        this.size = i3;
        this.intervalTimeMs = i16;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.isAnimating$delegate = mutableStateOf$default;
        this.currentShowIndex = -1;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
        this.contentViewHeight$delegate = mutableStateOf$default2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isAnimating() {
        return ((Boolean) this.isAnimating$delegate.getValue()).booleanValue();
    }
}
