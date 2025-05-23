package com.tencent.robot.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.opr.helper.sr.SuperResolutionHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.kuikly.database.AdelieKuiklyDatabase;
import com.tencent.robot.api.IRobotCacheApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/robot/api/impl/RobotCacheApiImpl;", "Lcom/tencent/robot/api/IRobotCacheApi;", "", "clearAdelieKuiklyDB", "clearAdelieGuideCache", "clearAdelieSuperResolutionCache", "<init>", "()V", "Companion", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotCacheApiImpl implements IRobotCacheApi {

    @NotNull
    public static final String TAG = "RobotCacheApi";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearAdelieKuiklyDB$lambda$0() {
        try {
            AdelieKuiklyDatabase.INSTANCE.a().c().deleteAll();
            QLog.i(TAG, 1, "clearAdelieKuiklyDB success");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "clearAdelieKuiklyDB error, " + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearAdelieSuperResolutionCache$lambda$1() {
        SuperResolutionHelper.Companion companion = SuperResolutionHelper.INSTANCE;
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        companion.b(context);
    }

    @Override // com.tencent.robot.api.IRobotCacheApi
    public void clearAdelieKuiklyDB() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                RobotCacheApiImpl.clearAdelieKuiklyDB$lambda$0();
            }
        }, 32, null, true);
    }

    @Override // com.tencent.robot.api.IRobotCacheApi
    public void clearAdelieSuperResolutionCache() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.api.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                RobotCacheApiImpl.clearAdelieSuperResolutionCache$lambda$1();
            }
        }, 64, null, true);
    }

    @Override // com.tencent.robot.api.IRobotCacheApi
    public void clearAdelieGuideCache() {
    }
}
