package com.tencent.qqmini.miniapp.util;

import com.tencent.qqmini.miniapp.util.VideoCompress;
import com.tencent.qqmini.sdk.launcher.utils.LocalMediaInfo;

/* loaded from: classes23.dex */
public abstract class VideoCompressProxy {
    protected VideoCompress.Option compressOption;
    protected VideoCompress.Listener compresslistener;
    protected LocalMediaInfo mediaInfo;
    protected String outputPath;

    public abstract void execute();

    public VideoCompressProxy listen(VideoCompress.Listener listener) {
        this.compresslistener = listener;
        return this;
    }

    public VideoCompressProxy setMedia(LocalMediaInfo localMediaInfo) {
        this.mediaInfo = localMediaInfo;
        return this;
    }

    public VideoCompressProxy setOption(VideoCompress.Option option) {
        this.compressOption = option;
        return this;
    }

    public VideoCompressProxy setOutputPath(String str) {
        this.outputPath = str;
        return this;
    }
}
