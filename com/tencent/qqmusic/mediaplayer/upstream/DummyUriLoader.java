package com.tencent.qqmusic.mediaplayer.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.tencent.qqmusic.mediaplayer.upstream.UriLoader;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DummyUriLoader implements UriLoader {

    @Nullable
    private final Uri uri;

    public DummyUriLoader() {
        this(null);
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.UriLoader
    public boolean isLoading() {
        return false;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.UriLoader
    public void startLoading(int i3, TimeUnit timeUnit, UriLoader.Callback callback) {
        Uri uri = this.uri;
        if (uri == null) {
            callback.onSucceed(null);
        } else {
            callback.onSucceed(new StreamingRequest(uri, null));
        }
    }

    public DummyUriLoader(@Nullable Uri uri) {
        this.uri = uri;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.UriLoader
    public void cancelLoading() {
    }
}
