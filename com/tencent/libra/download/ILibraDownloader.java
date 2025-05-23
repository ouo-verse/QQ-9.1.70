package com.tencent.libra.download;

import androidx.annotation.NonNull;
import com.tencent.libra.request.Option;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface ILibraDownloader {
    boolean canDownload(Option option);

    void cancel(Option option);

    void downLoad(Option option, PicDownLoadListener picDownLoadListener);

    boolean needDownloadOnWorkThread();

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class PicDownLoadListener {
        Option mOption;

        public PicDownLoadListener(@NonNull Option option) {
            this.mOption = option;
        }

        public void onResult(boolean z16, int i3) {
        }
    }
}
