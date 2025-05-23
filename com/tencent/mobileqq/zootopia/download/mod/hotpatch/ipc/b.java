package com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc;

import com.tencent.mobileqq.zootopia.download.mod.hotpatch.ZPlanModHotPatchConfig;
import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J,\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/mod/hotpatch/ipc/b;", "", "", "downloadSrc", "modId", "", "fromEnterMod", "needMobileDownloadTips", "", "downloadModHotPatchResource", "Lcom/tencent/mobileqq/zootopia/download/mod/hotpatch/ZPlanModHotPatchConfig;", "getModHotPatchConfig", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = ModHotPatchIPCImplForZPlan.class)
/* loaded from: classes35.dex */
public interface b {
    void downloadModHotPatchResource(String downloadSrc, String modId, boolean fromEnterMod, boolean needMobileDownloadTips);

    ZPlanModHotPatchConfig getModHotPatchConfig(String modId);
}
