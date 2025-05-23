package com.tencent.robot.adelie.homepage;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.opr.helper.sr.SuperResolutionHelper;
import com.tencent.mobileqq.qne.api.IQneApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qne.model.QneInterpreter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.qqmc.RobotQQMC;
import com.tencent.robot.qqmc.model.RobotHomeSuperResolutionConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u001f\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR$\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u0007\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/robot/adelie/homepage/g;", "", "", "c", "d", "Landroidx/lifecycle/MutableLiveData;", "La24/i;", "b", "Landroidx/lifecycle/MutableLiveData;", "a", "()Landroidx/lifecycle/MutableLiveData;", "changeRobotLiveData", "Lcom/tencent/mobileqq/opr/helper/sr/SuperResolutionHelper;", "Lcom/tencent/mobileqq/opr/helper/sr/SuperResolutionHelper;", "()Lcom/tencent/mobileqq/opr/helper/sr/SuperResolutionHelper;", "setSuperResolutionHelper", "(Lcom/tencent/mobileqq/opr/helper/sr/SuperResolutionHelper;)V", "superResolutionHelper", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f366352a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<a24.i> changeRobotLiveData = new MutableLiveData<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static SuperResolutionHelper superResolutionHelper;

    g() {
    }

    @NotNull
    public final MutableLiveData<a24.i> a() {
        return changeRobotLiveData;
    }

    @Nullable
    public final SuperResolutionHelper b() {
        return superResolutionHelper;
    }

    public final synchronized void c() {
        String str;
        RobotHomeSuperResolutionConfig homePageSuperResolutionConfig = RobotQQMC.INSTANCE.getHomePageSuperResolutionConfig();
        QneInterpreter qneInterpreter = QneInterpreter.f344344a;
        boolean f16 = homePageSuperResolutionConfig.f(qneInterpreter);
        com.tencent.qne.model.f c16 = qneInterpreter.c();
        if (c16 != null) {
            str = c16.b();
        } else {
            str = null;
        }
        QLog.i("AdelieSharedSingletonVM", 1, homePageSuperResolutionConfig + " support npu:" + str + ", cpu:" + qneInterpreter.a().b() + MsgSummary.STR_COLON + f16);
        if (!f16) {
            return;
        }
        if (superResolutionHelper != null) {
            return;
        }
        IQneApi iQneApi = (IQneApi) QRoute.api(IQneApi.class);
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        superResolutionHelper = iQneApi.createSuperResolutionHelper(context, homePageSuperResolutionConfig.getModelConfig(), homePageSuperResolutionConfig.getTaskQueueConfig(), homePageSuperResolutionConfig.getOnlyDownloadOnWifi());
    }

    public final synchronized void d() {
        SuperResolutionHelper superResolutionHelper2 = superResolutionHelper;
        if (superResolutionHelper2 != null) {
            superResolutionHelper2.o();
        }
        superResolutionHelper = null;
    }
}
