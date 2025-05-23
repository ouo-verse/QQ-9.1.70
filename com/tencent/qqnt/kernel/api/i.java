package com.tencent.qqnt.kernel.api;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.qqnt.kernel.nativeinterface.BaseEmojiPathInfo;
import com.tencent.qqnt.kernel.nativeinterface.DownloadBaseEmojiByIdReq;
import com.tencent.qqnt.kernel.nativeinterface.DownloadBaseEmojiByUrlReq;
import com.tencent.qqnt.kernel.nativeinterface.GetBaseEmojiPathReq;
import com.tencent.qqnt.kernel.nativeinterface.IDownloadBaseEmojiByIdCallback;
import com.tencent.qqnt.kernel.nativeinterface.IDownloadBaseEmojiByIdWithUrlCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFetchFullSysEmojisCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.PullSysEmojisReq;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\bH&J\u001a\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\fH&J\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0011H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/kernel/api/i;", "Lcom/tencent/qqnt/kernel/api/j;", "Lcom/tencent/qqnt/kernel/nativeinterface/PullSysEmojisReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/IFetchFullSysEmojisCallback;", "callback", "", "fetchFullSysEmojis", "Lcom/tencent/qqnt/kernel/nativeinterface/GetBaseEmojiPathReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/BaseEmojiPathInfo;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/qqnt/kernel/nativeinterface/DownloadBaseEmojiByUrlReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IDownloadBaseEmojiByIdWithUrlCallback;", "downloadBaseEmojiByIdWithUrl", "Lcom/tencent/qqnt/kernel/nativeinterface/DownloadBaseEmojiByIdReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IDownloadBaseEmojiByIdCallback;", "downloadBaseEmojiById", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "delAllBaseEmojiResource", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface i extends j {
    @Nullable
    BaseEmojiPathInfo S(@NotNull GetBaseEmojiPathReq req);

    void delAllBaseEmojiResource(@NotNull IOperateCallback callback);

    void downloadBaseEmojiById(@NotNull DownloadBaseEmojiByIdReq req, @Nullable IDownloadBaseEmojiByIdCallback callback);

    void downloadBaseEmojiByIdWithUrl(@NotNull DownloadBaseEmojiByUrlReq req, @Nullable IDownloadBaseEmojiByIdWithUrlCallback callback);

    void fetchFullSysEmojis(@NotNull PullSysEmojisReq req, @Nullable IFetchFullSysEmojisCallback callback);
}
