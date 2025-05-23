package com.tencent.robot.aio.action.api.impl;

import com.tencent.aio.api.runtime.a;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.aio.action.api.IRobotAIOSchemaApi;
import com.tencent.robot.api.IRobotStoryBoardApi;
import com.tencent.videocut.utils.dsl.b;
import java.util.Deque;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\rR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/robot/aio/action/api/impl/RobotAIOSchemaApiImpl;", "Lcom/tencent/robot/aio/action/api/IRobotAIOSchemaApi;", "", "uid", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "isUidEquals", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "from", "showStoryListFloat", "Lcom/tencent/aio/api/runtime/a;", "Ljava/util/Deque;", "aioContextStack", "Ljava/util/Deque;", "<init>", "()V", "Companion", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotAIOSchemaApiImpl implements IRobotAIOSchemaApi {

    @NotNull
    private static final String TAG = "RobotAIOSchemaApiImpl";

    @Nullable
    private a aioContext;

    @NotNull
    private Deque<a> aioContextStack = new LinkedList();

    private final boolean isUidEquals(String uid, a aioContext) {
        boolean z16;
        if (uid.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        return Intrinsics.areEqual(uid, aioContext.g().r().c().j());
    }

    @Override // com.tencent.robot.aio.action.api.IRobotAIOSchemaApi
    public void onCreate(@NotNull a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        QLog.i(TAG, 4, "onCreate aioContext hash: " + aioContext);
        this.aioContext = aioContext;
        this.aioContextStack.push(aioContext);
    }

    @Override // com.tencent.robot.aio.action.api.IRobotAIOSchemaApi
    public void onDestroy(@NotNull a aioContext) {
        a aVar;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        if (this.aioContextStack.contains(aioContext)) {
            this.aioContextStack.remove(aioContext);
        }
        if (Intrinsics.areEqual(this.aioContext, aioContext)) {
            if (!this.aioContextStack.isEmpty()) {
                aVar = this.aioContextStack.pop();
            } else {
                aVar = null;
            }
            this.aioContext = aVar;
        }
        QLog.i(TAG, 4, "onDestroy aioContext hash: " + aioContext + ", current aioContext hash: " + this.aioContext);
    }

    @Override // com.tencent.robot.aio.action.api.IRobotAIOSchemaApi
    public void showStoryListFloat(@NotNull String uid, @NotNull String from) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(from, "from");
        a aVar = this.aioContext;
        if (aVar != null) {
            boolean isUidEquals = isUidEquals(uid, aVar);
            if (isUidEquals) {
                ((IRobotStoryBoardApi) QRoute.api(IRobotStoryBoardApi.class)).showRobotStoryBoard(aVar, from);
                new b();
            } else {
                new com.tencent.videocut.utils.dsl.a(isUidEquals);
            }
        }
    }
}
