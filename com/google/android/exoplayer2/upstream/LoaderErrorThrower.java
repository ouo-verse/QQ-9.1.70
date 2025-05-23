package com.google.android.exoplayer2.upstream;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface LoaderErrorThrower {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Dummy implements LoaderErrorThrower {
        @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
        public void maybeThrowError() throws IOException {
        }

        @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
        public void maybeThrowError(int i3) throws IOException {
        }
    }

    void maybeThrowError() throws IOException;

    void maybeThrowError(int i3) throws IOException;
}
