package com.tencent.qqnt.kernel.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Service(needUin = false, process = {"all"})
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J,\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0007H&J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/kernel/api/IKInvorker;", "Lmqq/app/api/IRuntimeService;", "", "Lcom/tencent/qqnt/kernel/invorker/i;", "getServiceMsgs", "", "serviceInd", "", "methodName", "parasInd", "cmd", "", "call", "Lcom/tencent/qqnt/kernel/invorker/e;", "listener", "addListener", "removeListener", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface IKInvorker extends IRuntimeService {
    void addListener(@NotNull com.tencent.qqnt.kernel.invorker.e listener);

    void call(int serviceInd, @NotNull String methodName, int parasInd, @NotNull String cmd);

    @NotNull
    List<com.tencent.qqnt.kernel.invorker.i> getServiceMsgs();

    void removeListener(@NotNull com.tencent.qqnt.kernel.invorker.e listener);
}
