package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.hydevteam.common.annotation.API;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import java.io.File;

/* compiled from: P */
@API
/* loaded from: classes7.dex */
public interface Downloader {
    @API
    ProgressFuture<File> download(TargetDownloadInfo targetDownloadInfo, File file, File file2);
}
