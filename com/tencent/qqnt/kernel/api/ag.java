package com.tencent.qqnt.kernel.api;

import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUidInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback;
import java.util.HashSet;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0004H'\u00a2\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000f\u001a\u00020\u000e2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\n2\u0006\u0010\r\u001a\u00020\fH'J(\u0010\u0012\u001a\u00020\u000e2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00040\tj\b\u0012\u0004\u0012\u00020\u0004`\n2\u0006\u0010\r\u001a\u00020\u0011H'\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/kernel/api/ag;", "Lcom/tencent/qqnt/kernel/api/j;", "", "uin", "", "u", "uid", "z0", "(Ljava/lang/String;)Ljava/lang/Long;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "uinSet", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGetUidInfoCallback;", "cb", "", "getUid", "uidSet", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGetUinInfoCallback;", "getUin", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface ag extends j {
    @Deprecated(message = "\u4f7f\u7528\u5173\u7cfb\u94fe\u63a5\u53e3\u66ff\u4ee3", replaceWith = @ReplaceWith(expression = "IRelationNTUinAndUidApi.getUidFromUin", imports = {}))
    void getUid(@NotNull HashSet<Long> uinSet, @NotNull IKernelGetUidInfoCallback cb5);

    @Deprecated(message = "\u4f7f\u7528\u5173\u7cfb\u94fe\u63a5\u53e3\u66ff\u4ee3", replaceWith = @ReplaceWith(expression = "IRelationNTUinAndUidApi.getUinFromUid", imports = {}))
    void getUin(@NotNull HashSet<String> uidSet, @NotNull IKernelGetUinInfoCallback cb5);

    @Deprecated(message = "\u4f7f\u7528\u5173\u7cfb\u94fe\u63a5\u53e3\u66ff\u4ee3", replaceWith = @ReplaceWith(expression = "IRelationNTUinAndUidApi.getUidFromUin", imports = {}))
    @Nullable
    String u(long uin);

    @Deprecated(message = "\u4f7f\u7528\u5173\u7cfb\u94fe\u63a5\u53e3\u66ff\u4ee3", replaceWith = @ReplaceWith(expression = "IRelationNTUinAndUidApi.getUinFromUid", imports = {}))
    @Nullable
    Long z0(@NotNull String uid);
}
