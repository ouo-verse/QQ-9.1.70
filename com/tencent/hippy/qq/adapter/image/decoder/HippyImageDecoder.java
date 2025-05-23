package com.tencent.hippy.qq.adapter.image.decoder;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface HippyImageDecoder<T, Z> {
    Z decode(@NonNull T t16, int i3, int i16);

    boolean handles(@NonNull T t16);
}
