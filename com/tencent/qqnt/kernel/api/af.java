package com.tencent.qqnt.kernel.api;

import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.qqnt.kernel.nativeinterface.CacheFileType;
import com.tencent.qqnt.kernel.nativeinterface.CacheOrderType;
import com.tencent.qqnt.kernel.nativeinterface.ChatCacheDeleteInfo;
import com.tencent.qqnt.kernel.nativeinterface.CleanFileDetail;
import com.tencent.qqnt.kernel.nativeinterface.FileCacheInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetChatCacheInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetFileCacheInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelScanEndCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H&J\u0016\u0010\f\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J4\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u0016H&J@\u0010\u001f\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u000e\u001a\u0004\u0018\u00010\u001eH&J2\u0010$\u001a\u00020\u00072\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\t2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010#H&J\u001c\u0010'\u001a\u00020\u00072\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040%H&J\b\u0010(\u001a\u00020\u0007H&J\b\u0010)\u001a\u00020\u0007H&J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020#H&J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+H&\u00a8\u0006."}, d2 = {"Lcom/tencent/qqnt/kernel/api/af;", "Lcom/tencent/qqnt/kernel/api/j;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelStorageCleanListener;", "listener", "", "B0", "listenerId", "", "t", "Ljava/util/ArrayList;", "", "paths", "G0", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelScanEndCallback;", "result", "Z", "", "chatType", "pageSize", "Lcom/tencent/qqnt/kernel/nativeinterface/CacheOrderType;", "order", "pageIndex", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGetChatCacheInfoCallback;", "getChatCacheInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/CacheFileType;", TagName.FILE_TYPE, "", "restart", "Lcom/tencent/qqnt/kernel/nativeinterface/FileCacheInfo;", "lastRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGetFileCacheInfoCallback;", "getFileCacheInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/ChatCacheDeleteInfo;", "chats", "fileKeys", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "clearChatCacheInfo", "Ljava/util/HashMap;", "data", "addReportData", "reportData", "closeCleanWindow", "clearAllChatCacheInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/CleanFileDetail;", "fileInfo", "addNewDownloadOrUploadFile", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface af extends j {
    long B0(@Nullable IKernelStorageCleanListener listener);

    void G0(@NotNull ArrayList<String> paths);

    void Z(@Nullable IKernelScanEndCallback result);

    void addNewDownloadOrUploadFile(@NotNull CleanFileDetail fileInfo);

    void addReportData(@NotNull HashMap<String, Long> data);

    void clearAllChatCacheInfo(@NotNull IOperateCallback result);

    void clearChatCacheInfo(@Nullable ArrayList<ChatCacheDeleteInfo> chats, @Nullable ArrayList<Long> fileKeys, @Nullable IOperateCallback result);

    void closeCleanWindow();

    void getChatCacheInfo(int chatType, int pageSize, @Nullable CacheOrderType order, int pageIndex, @Nullable IKernelGetChatCacheInfoCallback result);

    void getFileCacheInfo(@Nullable CacheFileType fileType, boolean restart, int pageSize, @Nullable CacheOrderType order, @Nullable FileCacheInfo lastRecord, @Nullable IKernelGetFileCacheInfoCallback result);

    void reportData();

    void t(long listenerId);
}
