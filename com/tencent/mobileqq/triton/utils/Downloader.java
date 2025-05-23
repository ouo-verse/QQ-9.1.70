package com.tencent.mobileqq.triton.utils;

import androidx.annotation.AnyThread;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\nJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/triton/utils/Downloader;", "", "download", "", "url", "", "toPath", "Ljava/io/File;", "listener", "Lcom/tencent/mobileqq/triton/utils/Downloader$Listener;", "Listener", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public interface Downloader {
    @AnyThread
    void download(@NotNull String url, @NotNull File toPath, @NotNull Listener listener);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0003H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/triton/utils/Downloader$Listener;", "", "onFail", "", "errorMsg", "", "onProgress", "totalBytes", "", "currentBytes", "onSuccess", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public interface Listener {
        void onFail(@NotNull String errorMsg);

        void onProgress(long totalBytes, long currentBytes);

        void onSuccess();

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
        /* loaded from: classes19.dex */
        public static final class DefaultImpls {
            public static void onProgress(Listener listener, long j3, long j16) {
            }
        }
    }
}
