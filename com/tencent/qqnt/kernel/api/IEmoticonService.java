package com.tencent.qqnt.kernel.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTCommAbilitySession;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(needUin = false, process = {"all"})
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/kernel/api/IEmoticonService;", "Lmqq/app/api/IRuntimeService;", "getCommAbilitySession", "Lcom/tencent/qqnt/kernel/nativeinterface/IQQNTCommAbilitySession;", "getYellowFaceForManagerService", "Lcom/tencent/qqnt/kernel/api/IYellowFaceForManagerService;", "kernel_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public interface IEmoticonService extends IRuntimeService {
    @Nullable
    IQQNTCommAbilitySession getCommAbilitySession();

    @Nullable
    IYellowFaceForManagerService getYellowFaceForManagerService();
}
