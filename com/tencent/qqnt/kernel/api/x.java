package com.tencent.qqnt.kernel.api;

import com.tencent.qqnt.kernel.nativeinterface.IFetchNearbyProUserInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelNearbyProListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.NearbyProCommonExtInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&JD\u0010\u0014\u001a\u00020\u00042\u001e\u0010\u0010\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rj\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u0001`\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u0013H&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/kernel/api/x;", "Lcom/tencent/qqnt/kernel/api/j;", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "cb", "", "Y", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelNearbyProListener;", "listener", "addKernelNearbyProListener", "removeKernelNearbyProListener", "Lcom/tencent/qqnt/kernel/nativeinterface/NearbyProCommonExtInfo;", "extInfo", "setCommonExtInfo", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "tinyIdList", "", "forceUpdate", "Lcom/tencent/qqnt/kernel/nativeinterface/IFetchNearbyProUserInfoCallback;", "fetchNearbyProUserInfo", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface x extends j {
    void Y(@NotNull IOperateCallback cb5);

    void addKernelNearbyProListener(@NotNull IKernelNearbyProListener listener);

    void fetchNearbyProUserInfo(@Nullable ArrayList<Long> tinyIdList, @Nullable NearbyProCommonExtInfo extInfo, boolean forceUpdate, @Nullable IFetchNearbyProUserInfoCallback cb5);

    void removeKernelNearbyProListener(@NotNull IKernelNearbyProListener listener);

    void setCommonExtInfo(@NotNull NearbyProCommonExtInfo extInfo);
}
