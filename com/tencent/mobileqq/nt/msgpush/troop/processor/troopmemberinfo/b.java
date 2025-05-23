package com.tencent.mobileqq.nt.msgpush.troop.processor.troopmemberinfo;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nt.msgpush.factory.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import tencent.im.msg.nt_im_msg_general_flags_body$ResvAttr;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/nt/msgpush/troop/processor/troopmemberinfo/b;", "Lcom/tencent/mobileqq/nt/msgpush/factory/f;", "Lcom/tencent/mobileqq/nt/msgpush/factory/a;", "convertResultData", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class b implements f {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.nt.msgpush.factory.f
    public void a(@NotNull com.tencent.mobileqq.nt.msgpush.factory.a convertResultData) {
        nt_im_msg_general_flags_body$ResvAttr g16;
        byte[] bArr;
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) convertResultData);
            return;
        }
        Intrinsics.checkNotNullParameter(convertResultData, "convertResultData");
        com.tencent.mobileqq.nt.msgpush.troop.processor.a b16 = convertResultData.b();
        if (b16 != null && (g16 = b16.g()) != null && g16.has()) {
            IRuntimeService iRuntimeService = null;
            if (g16.bytes_hudong_mark.has()) {
                bArr = g16.bytes_hudong_mark.get().toByteArray();
            } else {
                bArr = null;
            }
            String i3 = com.tencent.mobileqq.troop.honor.util.a.i(bArr);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(ITroopHonorService.class, "");
            }
            ITroopHonorService iTroopHonorService = (ITroopHonorService) iRuntimeService;
            if (iTroopHonorService != null) {
                iTroopHonorService.updateTroopMemberHonor(b16.e(), b16.h(), i3, (byte) g16.uint32_group_rich_flag.get(), b16.d());
            }
        }
    }
}
