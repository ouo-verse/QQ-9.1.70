package com.tencent.qqnt.aio.robot.api.impl;

import com.tencent.qqnt.aio.interceptor.sendmsg.a;
import com.tencent.qqnt.aio.robot.api.IAIORobotApi;
import com.tencent.robot.aio.input.inputbar.config.RobotAtConfigParser;
import com.tencent.robot.aio.input.inputbar.interceptor.GroupRobotAIOSendMsgInterceptor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/robot/api/impl/AIORobotApiImpl;", "Lcom/tencent/qqnt/aio/robot/api/IAIORobotApi;", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/a;", "createAIOSendMsgInterceptor", "", "isInterceptAtRobotSendMsgEnable", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIORobotApiImpl implements IAIORobotApi {
    @Override // com.tencent.qqnt.aio.robot.api.IAIORobotApi
    @NotNull
    public a createAIOSendMsgInterceptor() {
        return new GroupRobotAIOSendMsgInterceptor();
    }

    @Override // com.tencent.qqnt.aio.robot.api.IAIORobotApi
    public boolean isInterceptAtRobotSendMsgEnable() {
        return RobotAtConfigParser.INSTANCE.a().getEnable();
    }
}
