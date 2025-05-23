package com.tencent.hippykotlin.demo.pages.adelie.common.compose.util;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class StateHolder<T> {
    public final MutableState<T> _state;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public StateHolder() {
        this(r0, 1, r0);
        DefaultConstructorMarker defaultConstructorMarker = null;
    }

    public StateHolder(T t16) {
        MutableState<T> mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t16, null, 2, null);
        this._state = mutableStateOf$default;
    }

    public /* synthetic */ StateHolder(Object obj, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null);
    }
}
