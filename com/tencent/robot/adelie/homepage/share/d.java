package com.tencent.robot.adelie.homepage.share;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.FetchShareInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.FetchShareInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.IFetchShareInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotShareScene;
import com.tencent.qqnt.kernel.nativeinterface.RobotShareTarget;
import com.tencent.robot.qqmc.RobotQQMC;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J.\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\u0011\u0010\u000e\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0011\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/robot/adelie/homepage/share/d;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotShareScene;", "shareScene", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotShareTarget;", "shareTarget", "Lkotlin/Function1;", "", "", "callback", "b", "Lcom/tencent/adelie/qqmc/model/a;", "g", "()Lcom/tencent/adelie/qqmc/model/a;", "shareConfig", "d", "()Ljava/lang/String;", "copyUrlText", "e", "copyUrlTips", "Lcom/tencent/mobileqq/sharehelper/d;", "f", "()Lcom/tencent/mobileqq/sharehelper/d;", "qzoneLinkShareInfo", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function1 function1, int i3, String str, FetchShareInfoRsp fetchShareInfoRsp) {
        String str2;
        boolean z16;
        QLog.d("AdelieHomePageShareProvider", 1, "result:" + i3 + " errMsg:" + str);
        if (fetchShareInfoRsp != null) {
            str2 = fetchShareInfoRsp.ark;
        } else {
            str2 = null;
        }
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("AdelieHomePageShareProvider", 1, "fetchRobotShareInfo failed fetch arkInfo");
            if (function1 != null) {
                function1.invoke("");
                return;
            }
            return;
        }
        if (function1 != null) {
            function1.invoke(str2);
        }
    }

    public final void b(@NotNull RobotShareScene shareScene, @NotNull RobotShareTarget shareTarget, @Nullable final Function1<? super String, Unit> callback) {
        IKernelService iKernelService;
        ac robotService;
        Intrinsics.checkNotNullParameter(shareScene, "shareScene");
        Intrinsics.checkNotNullParameter(shareTarget, "shareTarget");
        FetchShareInfoReq fetchShareInfoReq = new FetchShareInfoReq();
        fetchShareInfoReq.scene = shareScene;
        fetchShareInfoReq.target = shareTarget;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null && (robotService = iKernelService.getRobotService()) != null) {
            robotService.fetchShareInfo(fetchShareInfoReq, new IFetchShareInfoCallback() { // from class: com.tencent.robot.adelie.homepage.share.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IFetchShareInfoCallback
                public final void onResult(int i3, String str, FetchShareInfoRsp fetchShareInfoRsp) {
                    d.c(Function1.this, i3, str, fetchShareInfoRsp);
                }
            });
        }
    }

    @NotNull
    public final String d() {
        return "\u70b9\u51fb\u94fe\u63a5\u4f53\u9a8cQQ\u667a\u80fd\u4f53\uff1a";
    }

    @NotNull
    public final String e() {
        return "\u590d\u5236\u6210\u529f";
    }

    @NotNull
    public final com.tencent.mobileqq.sharehelper.d f() {
        String currentUin;
        com.tencent.mobileqq.sharehelper.d dVar = new com.tencent.mobileqq.sharehelper.d();
        com.tencent.adelie.qqmc.model.b b16 = g().b();
        dVar.n(b16.c());
        String str = "";
        dVar.j("");
        dVar.p(b16.d());
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(b16.a());
        dVar.l(arrayList);
        dVar.o(b16.b());
        dVar.k(0);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (currentUin = peekAppRuntime.getCurrentUin()) != null) {
            str = currentUin;
        }
        dVar.i(str);
        dVar.m(2000);
        return dVar;
    }

    @NotNull
    public final com.tencent.adelie.qqmc.model.a g() {
        return RobotQQMC.INSTANCE.getAdelieHomePageShareConfig();
    }
}
