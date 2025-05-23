package com.tencent.qqnt.kernel.api;

import com.tencent.qqnt.kernel.nativeinterface.GroupVideoCmdReq;
import com.tencent.qqnt.kernel.nativeinterface.IGroupVideoCmdRequestRsp;
import com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0007\u001a\u00020\u0004H&J\u001c\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/kernel/api/e;", "Lcom/tencent/qqnt/kernel/api/j;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelAVSDKListener;", "listener", "", "addKernelAVSDKListener", "removeKernelAVSDKListener", "allowAlbumNotify", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupVideoCmdReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupVideoCmdRequestRsp;", "cb", "startGroupVideoCmdRequestFromAVSDK", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface e extends j {
    void addKernelAVSDKListener(@Nullable IKernelAVSDKListener listener);

    void allowAlbumNotify();

    void removeKernelAVSDKListener(@Nullable IKernelAVSDKListener listener);

    void startGroupVideoCmdRequestFromAVSDK(@Nullable GroupVideoCmdReq req, @Nullable IGroupVideoCmdRequestRsp cb5);
}
