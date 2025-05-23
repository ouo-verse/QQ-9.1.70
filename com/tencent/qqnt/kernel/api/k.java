package com.tencent.qqnt.kernel.api;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadConfig;
import com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManager;
import com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManagerDelegate;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001e\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/kernel/api/k;", "Lcom/tencent/qqnt/kernel/api/j;", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadConfig;", "createBatchUploadConfig", DownloadInfo.spKey_Config, "Lcom/tencent/qqnt/kernel/nativeinterface/IBatchUploadManagerDelegate;", "delegate", "Lcom/tencent/qqnt/kernel/nativeinterface/IBatchUploadManager;", "getBatchUploadManager", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface k extends j {
    @Nullable
    BatchUploadConfig createBatchUploadConfig();

    @Nullable
    IBatchUploadManager getBatchUploadManager(@Nullable BatchUploadConfig config, @Nullable IBatchUploadManagerDelegate delegate);
}
