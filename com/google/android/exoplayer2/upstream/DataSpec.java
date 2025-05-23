package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class DataSpec {
    public static final int FLAG_ALLOW_CACHING_UNKNOWN_LENGTH = 2;
    public static final int FLAG_ALLOW_GZIP = 1;
    public final long absoluteStreamPosition;
    public final int flags;

    @Nullable
    public final String key;
    public final long length;
    public final long position;
    public final byte[] postBody;
    public final Uri uri;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Flags {
    }

    public DataSpec(Uri uri) {
        this(uri, 0);
    }

    public boolean isFlagSet(int i3) {
        if ((this.flags & i3) == i3) {
            return true;
        }
        return false;
    }

    public DataSpec subrange(long j3) {
        long j16 = this.length;
        return subrange(j3, j16 != -1 ? j16 - j3 : -1L);
    }

    public String toString() {
        return "DataSpec[" + this.uri + ", " + Arrays.toString(this.postBody) + ", " + this.absoluteStreamPosition + ", " + this.position + ", " + this.length + ", " + this.key + ", " + this.flags + "]";
    }

    public DataSpec(Uri uri, int i3) {
        this(uri, 0L, -1L, null, i3);
    }

    public DataSpec subrange(long j3, long j16) {
        return (j3 == 0 && this.length == j16) ? this : new DataSpec(this.uri, this.postBody, this.absoluteStreamPosition + j3, this.position + j3, j16, this.key, this.flags);
    }

    public DataSpec(Uri uri, long j3, long j16, @Nullable String str) {
        this(uri, j3, j3, j16, str, 0);
    }

    public DataSpec(Uri uri, long j3, long j16, String str, int i3) {
        this(uri, j3, j3, j16, str, i3);
    }

    public DataSpec(Uri uri, long j3, long j16, long j17, String str, int i3) {
        this(uri, null, j3, j16, j17, str, i3);
    }

    public DataSpec(Uri uri, byte[] bArr, long j3, long j16, long j17, @Nullable String str, int i3) {
        boolean z16 = true;
        Assertions.checkArgument(j3 >= 0);
        Assertions.checkArgument(j16 >= 0);
        if (j17 <= 0 && j17 != -1) {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        this.uri = uri;
        this.postBody = bArr;
        this.absoluteStreamPosition = j3;
        this.position = j16;
        this.length = j17;
        this.key = str;
        this.flags = i3;
    }
}
