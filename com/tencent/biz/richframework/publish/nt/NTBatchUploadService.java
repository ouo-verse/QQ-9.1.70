package com.tencent.biz.richframework.publish.nt;

import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.k;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/biz/richframework/publish/nt/NTBatchUploadService;", "", "Lcom/tencent/qqnt/kernel/api/k;", "getBatchUploadService", "<init>", "()V", "rfw-upload_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class NTBatchUploadService {
    public static final NTBatchUploadService INSTANCE = new NTBatchUploadService();

    NTBatchUploadService() {
    }

    @JvmStatic
    public static final k getBatchUploadService() {
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")) == null) {
            return null;
        }
        return iKernelService.getBatchUploadService();
    }
}
