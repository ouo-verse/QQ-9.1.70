package com.tencent.richframework.widget.subscaleview;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes25.dex */
public class CompatDecoderFactory<T> implements DecoderFactory<T> {
    private final Bitmap.Config bitmapConfig;
    private final Class<? extends T> clazz;

    public CompatDecoderFactory(@NonNull Class<? extends T> cls) {
        this(cls, null);
    }

    @Override // com.tencent.richframework.widget.subscaleview.DecoderFactory
    @NonNull
    public T make() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if (this.bitmapConfig == null) {
            return this.clazz.newInstance();
        }
        return this.clazz.getConstructor(Bitmap.Config.class).newInstance(this.bitmapConfig);
    }

    public CompatDecoderFactory(@NonNull Class<? extends T> cls, Bitmap.Config config) {
        this.clazz = cls;
        this.bitmapConfig = config;
    }
}
