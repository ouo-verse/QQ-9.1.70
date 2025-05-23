package com.tencent.mobileqq.profilecommon.processor;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorHandler;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import java.nio.ByteBuffer;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class HonorRichProcessor extends AbsProfileCommonProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    long f260938a;

    public HonorRichProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public String getProcessorKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "HonorRichProcessor";
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public boolean interceptProfileModifyPush(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
        }
        if (i3 == 42511) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onProcessProfileModifyPush(int i3, ByteStringMicro byteStringMicro) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) byteStringMicro);
            return;
        }
        if (i3 == 42511) {
            try {
                if (this.appRuntime instanceof QQAppInterface) {
                    if (((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).isTroopListInited()) {
                        ((ITroopHonorService) this.appRuntime.getRuntimeService(ITroopHonorService.class, "")).saveHostHonorListRichTag(ByteBuffer.wrap(byteStringMicro.toByteArray()).asShortBuffer().get());
                        ITroopHonorHandler iTroopHonorHandler = (ITroopHonorHandler) this.appRuntime.getRuntimeService(ITroopHonorHandler.class, "");
                        if (iTroopHonorHandler != null) {
                            iTroopHonorHandler.getHostTroopHonorList(true);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopHonor", 2, "honor_rich_push ok\uff1a" + ((int) byteStringMicro.byteAt(1)));
                    }
                }
            } catch (Exception e16) {
                QLog.d("TroopHonor", 1, "honor_rich_push error\uff1a" + e16.getMessage());
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onProcessProfileModifyPushBegin(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
        } else {
            this.f260938a = j3;
        }
    }
}
