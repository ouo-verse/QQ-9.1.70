package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.AiGenTemplateInfo;
import com.tencent.qqnt.kernel.nativeinterface.FetchAiGenTemplateInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.IAiGenTemplateInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "seq", "", "invoke", "(I)Lkotlin/Unit;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
final class RobotService$fetchAiGenTemplateInfo$2 extends Lambda implements Function1<Integer, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ IAiGenTemplateInfoCallback $cb;
    final /* synthetic */ FetchAiGenTemplateInfoReq $fetchAiGenTemplateInfoReq;
    final /* synthetic */ RobotService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotService$fetchAiGenTemplateInfo$2(RobotService robotService, FetchAiGenTemplateInfoReq fetchAiGenTemplateInfoReq, IAiGenTemplateInfoCallback iAiGenTemplateInfoCallback) {
        super(1);
        this.this$0 = robotService;
        this.$fetchAiGenTemplateInfoReq = fetchAiGenTemplateInfoReq;
        this.$cb = iAiGenTemplateInfoCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, robotService, fetchAiGenTemplateInfoReq, iAiGenTemplateInfoCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(RobotService this$0, final IAiGenTemplateInfoCallback iAiGenTemplateInfoCallback, final int i3, final String str, final AiGenTemplateInfo aiGenTemplateInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.nt
            @Override // java.lang.Runnable
            public final void run() {
                RobotService$fetchAiGenTemplateInfo$2.d(IAiGenTemplateInfoCallback.this, i3, str, aiGenTemplateInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(IAiGenTemplateInfoCallback iAiGenTemplateInfoCallback, int i3, String str, AiGenTemplateInfo aiGenTemplateInfo) {
        if (iAiGenTemplateInfoCallback != null) {
            iAiGenTemplateInfoCallback.onResult(i3, str, aiGenTemplateInfo);
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
        FetchAiGenTemplateInfoReq fetchAiGenTemplateInfoReq = this.$fetchAiGenTemplateInfoReq;
        final RobotService robotService = this.this$0;
        final IAiGenTemplateInfoCallback iAiGenTemplateInfoCallback = this.$cb;
        service.fetchAiGenTemplateInfo(fetchAiGenTemplateInfoReq, new IAiGenTemplateInfoCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ns
            @Override // com.tencent.qqnt.kernel.nativeinterface.IAiGenTemplateInfoCallback
            public final void onResult(int i16, String str, AiGenTemplateInfo aiGenTemplateInfo) {
                RobotService$fetchAiGenTemplateInfo$2.c(RobotService.this, iAiGenTemplateInfoCallback, i16, str, aiGenTemplateInfo);
            }
        });
        return Unit.INSTANCE;
    }
}
