package org.light;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MovieConfig extends Config {
    private static final String TAG = "MovieConfig";

    public static MovieConfig make() {
        return nativeMake();
    }

    private static native MovieConfig nativeMake();
}
