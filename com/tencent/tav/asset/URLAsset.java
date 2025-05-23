package com.tencent.tav.asset;

import androidx.annotation.NonNull;
import com.tencent.tav.asset.AsynchronousKeyValueLoading;
import java.net.URL;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class URLAsset extends Asset {
    public String audiovisualMIMETypes;
    public String audiovisualTypes;

    public URLAsset(@NonNull String str) {
        super(str);
    }

    public String getAudiovisualMIMETypes() {
        return this.audiovisualMIMETypes;
    }

    public String getAudiovisualTypes() {
        return this.audiovisualTypes;
    }

    @Override // com.tencent.tav.asset.AsynchronousKeyValueLoading
    public int statusOfValueForKey(String str) throws Exception {
        return 1;
    }

    public URLAsset(@NonNull String str, boolean z16) {
        super(str, z16);
    }

    public URLAsset(URL url) {
        super(url);
    }

    @Override // com.tencent.tav.asset.AsynchronousKeyValueLoading
    public void loadValuesAsynchronouslyForKeys(List<String> list, AsynchronousKeyValueLoading.loadCallback loadcallback) {
    }
}
