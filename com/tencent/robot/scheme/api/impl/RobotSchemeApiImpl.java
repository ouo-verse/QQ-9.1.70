package com.tencent.robot.scheme.api.impl;

import com.tencent.robot.scheme.api.IRobotSchemeApi;
import d54.g;
import e54.d;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H\u0016J\u0010\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H\u0016J\u0010\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/scheme/api/impl/RobotSchemeApiImpl;", "Lcom/tencent/robot/scheme/api/IRobotSchemeApi;", "()V", "createAdelieJumpParserClass", "Ljava/lang/Class;", "", "createQRobotJumpParserClass", "createRobotAIOJumpParserClass", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RobotSchemeApiImpl implements IRobotSchemeApi {
    @Override // com.tencent.robot.scheme.api.IRobotSchemeApi
    @NotNull
    public Class<? extends Object> createAdelieJumpParserClass() {
        return g.class;
    }

    @Override // com.tencent.robot.scheme.api.IRobotSchemeApi
    @NotNull
    public Class<? extends Object> createQRobotJumpParserClass() {
        return d.class;
    }

    @Override // com.tencent.robot.scheme.api.IRobotSchemeApi
    @NotNull
    public Class<? extends Object> createRobotAIOJumpParserClass() {
        return com.tencent.robot.scheme.api.impl.robotaio.d.class;
    }
}
