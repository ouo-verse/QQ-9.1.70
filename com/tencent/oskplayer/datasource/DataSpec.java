package com.tencent.oskplayer.datasource;

import android.net.Uri;
import com.tencent.oskplayer.util.Assertions;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class DataSpec {
    public static final int FLAG_ALLOW_GZIP = 1;
    public final long absoluteStreamPosition;
    public final int flags;
    public final String key;
    public final long length;
    public String originUrl;
    public final long position;
    public final int priority;
    public final Uri uri;
    public final String uuid;

    public DataSpec(Uri uri, String str) {
        this(uri, 0, str);
    }

    public String toString() {
        return "DataSpec[uri=" + this.uri + ", originUrl=" + this.originUrl + ", absPos=" + this.absoluteStreamPosition + ", pos=" + this.position + ", len=" + this.length + ", key=" + this.key + ", flags=" + this.flags + ", uuid=" + this.uuid + "]";
    }

    public DataSpec(Uri uri, int i3, String str) {
        this(uri, 0L, -1L, null, i3, str);
    }

    public DataSpec(Uri uri, long j3, long j16, String str, String str2) {
        this(uri, j3, j3, j16, str, 0, str2);
    }

    public DataSpec(Uri uri, long j3, long j16, String str, int i3, String str2) {
        this(uri, j3, j3, j16, str, i3, str2);
    }

    public DataSpec(Uri uri, long j3, long j16, long j17, String str, int i3, String str2, int i16) {
        boolean z16 = true;
        try {
            Assertions.checkArgument(j3 >= 0);
            Assertions.checkArgument(j16 >= 0);
            if (j17 <= 0 && j17 != -1) {
                z16 = false;
            }
            Assertions.checkArgument(z16);
            this.uri = uri;
            this.absoluteStreamPosition = j3;
            this.position = j16;
            this.length = j17;
            this.key = str;
            this.flags = i3;
            this.uuid = str2;
            this.priority = i16;
        } catch (IllegalArgumentException e16) {
            throw new IllegalDataSpecException(e16);
        }
    }

    public DataSpec(Uri uri, long j3, long j16, long j17, String str, int i3, String str2) {
        this(uri, j3, j16, j17, str, i3, str2, -1);
    }

    public DataSpec(Uri uri, String str, long j3, long j16, long j17, String str2, int i3, String str3) {
        boolean z16 = true;
        try {
            Assertions.checkArgument(j3 >= 0);
            Assertions.checkArgument(j16 >= 0);
            if (j17 <= 0 && j17 != -1) {
                z16 = false;
            }
            Assertions.checkArgument(z16);
            this.originUrl = str;
            this.uri = uri;
            this.absoluteStreamPosition = j3;
            this.position = j16;
            this.length = j17;
            this.key = str2;
            this.flags = i3;
            this.uuid = str3;
            this.priority = -1;
        } catch (IllegalArgumentException e16) {
            throw new IllegalDataSpecException(e16);
        }
    }
}
