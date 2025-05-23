package com.tencent.qqnt.kernel.listeneradapt;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener;
import com.tencent.qqnt.kernel.nativeinterface.RobotAIOEvent;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.bk;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/kernel/listeneradapt/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRobotListener;", "", "onRobotFriendListChanged", "onRobotListChanged", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "onRobotProfileChanged", "<init>", "()V", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class a implements IKernelRobotListener {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
    public /* synthetic */ void onRobotAIOEventChanged(RobotAIOEvent robotAIOEvent) {
        bk.a(this, robotAIOEvent);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
    public /* synthetic */ void onRobotCoreInfoChanged(RobotCoreInfo robotCoreInfo) {
        bk.b(this, robotCoreInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
    public /* synthetic */ void onRobotFeatureChanged(GroupRobotProfile groupRobotProfile) {
        bk.c(this, groupRobotProfile);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
    public void onRobotFriendListChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
    public void onRobotListChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
    public void onRobotProfileChanged(@Nullable GroupRobotProfile robotProfile) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) robotProfile);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
    public /* synthetic */ void onRobotTabListChanged(String str) {
        bk.g(this, str);
    }
}
