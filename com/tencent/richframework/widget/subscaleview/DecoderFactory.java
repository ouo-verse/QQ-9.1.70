package com.tencent.richframework.widget.subscaleview;

import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface DecoderFactory<T> {
    @NonNull
    T make() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;
}
