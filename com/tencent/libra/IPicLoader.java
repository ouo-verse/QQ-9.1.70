package com.tencent.libra;

import androidx.annotation.NonNull;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;

/* loaded from: classes7.dex */
public interface IPicLoader {
    void cancelDownload(@NonNull Option option);

    void deleteSdCacheIfNeed();

    void download(Option option, IPicLoadStateListener iPicLoadStateListener);

    String getDownloadCommonRootPath();

    String getDownloadRootPath();

    String getDownloadTmpRootPath();

    String getPicLocalPath(Option option);

    LibraRequestKey getRequestKey(Option option);

    boolean hasCache(Option option);

    void loadImage(Option option, IPicLoadStateListener iPicLoadStateListener);

    void release();

    void removeCache(Option option);
}
