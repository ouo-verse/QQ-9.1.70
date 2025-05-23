package com.google.android.exoplayer2.drm;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DecryptionException extends Exception {
    public final int errorCode;

    public DecryptionException(int i3, String str) {
        super(str);
        this.errorCode = i3;
    }
}
