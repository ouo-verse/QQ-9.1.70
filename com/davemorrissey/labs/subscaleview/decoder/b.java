package com.davemorrissey.labs.subscaleview.decoder;

import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface b<T> {
    @NonNull
    T make() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;
}
