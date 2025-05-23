package com.tencent.qqnt.aio.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.aio.utils.p;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/api/IRobotLoadingMsgFlagService;", "Lmqq/app/api/IRuntimeService;", "", "robotUin", "", "lastMsgId", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "addRobotLoadingMsgFlag", "removeLoadingMsgFlag", "Lcom/tencent/qqnt/aio/utils/p;", "getLastLoadingMsgInfo", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface IRobotLoadingMsgFlagService extends IRuntimeService {
    void addRobotLoadingMsgFlag(@NotNull String robotUin, long lastMsgId, @NotNull MsgRecord msgRecord);

    @Nullable
    p getLastLoadingMsgInfo(@NotNull String robotUin);

    void removeLoadingMsgFlag(@NotNull String robotUin);
}
