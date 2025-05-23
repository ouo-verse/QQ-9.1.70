package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.IFetchAllRobotsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService;
import com.tencent.qqnt.kernel.nativeinterface.RobotCategoryInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "seq", "", "invoke", "(I)Lkotlin/Unit;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
final class RobotService$fetchAllRobots$2 extends Lambda implements Function1<Integer, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ RobotCategoryInfo $categoryInfo;
    final /* synthetic */ IFetchAllRobotsCallback $cb;
    final /* synthetic */ boolean $restart;
    final /* synthetic */ RobotService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotService$fetchAllRobots$2(RobotService robotService, boolean z16, RobotCategoryInfo robotCategoryInfo, IFetchAllRobotsCallback iFetchAllRobotsCallback) {
        super(1);
        this.this$0 = robotService;
        this.$restart = z16;
        this.$categoryInfo = robotCategoryInfo;
        this.$cb = iFetchAllRobotsCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, robotService, Boolean.valueOf(z16), robotCategoryInfo, iFetchAllRobotsCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(RobotService this$0, final IFetchAllRobotsCallback iFetchAllRobotsCallback, final int i3, final String str, final ArrayList arrayList, final ArrayList arrayList2, final boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.nv
            @Override // java.lang.Runnable
            public final void run() {
                RobotService$fetchAllRobots$2.d(IFetchAllRobotsCallback.this, i3, str, arrayList, arrayList2, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(IFetchAllRobotsCallback iFetchAllRobotsCallback, int i3, String str, ArrayList arrayList, ArrayList arrayList2, boolean z16) {
        if (iFetchAllRobotsCallback != null) {
            iFetchAllRobotsCallback.onResult(i3, str, arrayList, arrayList2, z16);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        return invoke(num.intValue());
    }

    @Nullable
    public final Unit invoke(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        IKernelRobotService service = this.this$0.getService();
        if (service == null) {
            return null;
        }
        boolean z16 = this.$restart;
        RobotCategoryInfo robotCategoryInfo = this.$categoryInfo;
        final RobotService robotService = this.this$0;
        final IFetchAllRobotsCallback iFetchAllRobotsCallback = this.$cb;
        service.fetchAllRobots(z16, robotCategoryInfo, new IFetchAllRobotsCallback() { // from class: com.tencent.qqnt.kernel.api.impl.nu
            @Override // com.tencent.qqnt.kernel.nativeinterface.IFetchAllRobotsCallback
            public final void onResult(int i16, String str, ArrayList arrayList, ArrayList arrayList2, boolean z17) {
                RobotService$fetchAllRobots$2.c(RobotService.this, iFetchAllRobotsCallback, i16, str, arrayList, arrayList2, z17);
            }
        });
        return Unit.INSTANCE;
    }
}
