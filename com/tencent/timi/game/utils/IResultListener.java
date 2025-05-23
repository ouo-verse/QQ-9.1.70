package com.tencent.timi.game.utils;

import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IResultListener<T> {
    void onError(int i3, String str);

    void onSuccess(@Nullable T t16);
}
