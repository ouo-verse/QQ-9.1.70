package com.google.android.exoplayer2.upstream;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class DataSourceException extends IOException {
    public static final int POSITION_OUT_OF_RANGE = 0;
    public final int reason;

    public DataSourceException(int i3) {
        this.reason = i3;
    }
}
