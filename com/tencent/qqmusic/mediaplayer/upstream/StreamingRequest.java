package com.tencent.qqmusic.mediaplayer.upstream;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class StreamingRequest {

    @Nullable
    public final Map<String, String> headers;

    @NonNull
    public final Uri uri;

    public StreamingRequest(@NonNull Uri uri, @Nullable Map<String, String> map) {
        this.uri = uri;
        this.headers = map;
    }

    public String toString() {
        return "StreamingRequest{uri='" + this.uri + "', headers=" + this.headers + '}';
    }
}
