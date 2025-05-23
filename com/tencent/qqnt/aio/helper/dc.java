package com.tencent.qqnt.aio.helper;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener;
import com.tencent.qqnt.kernel.nativeinterface.StatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserDetailInfo;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J8\u0010\u000b\u001a\u00020\u00042.\u0010\n\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0006j\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u0001`\tH\u0016J8\u0010\f\u001a\u00020\u00042.\u0010\n\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0006j\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u0001`\tH\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/helper/dc;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelProfileListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/UserDetailInfo;", "info", "", "onUserDetailInfoChanged", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/StatusInfo;", "Lkotlin/collections/HashMap;", "status", "onStatusUpdate", "onStatusAsyncFieldUpdate", "onSelfStatusChanged", "<init>", "()V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public class dc implements IKernelProfileListener {
    static IPatchRedirector $redirector_;

    public dc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public void onSelfStatusChanged(@Nullable StatusInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) info);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public void onStatusAsyncFieldUpdate(@Nullable HashMap<String, StatusInfo> status) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) status);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public void onStatusUpdate(@Nullable HashMap<String, StatusInfo> status) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) status);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public /* synthetic */ void onStrangerRemarkChanged(HashMap hashMap) {
        com.tencent.qqnt.kernel.nativeinterface.be.e(this, hashMap);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public void onUserDetailInfoChanged(@Nullable UserDetailInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) info);
        }
    }
}
