package com.tencent.mobileqq.springhb.api.impl;

import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.springhb.api.ISpringHbUtilApi;
import com.tencent.mobileqq.springhb.debug.ReportDebugFragment;
import com.tencent.mobileqq.springhb.n;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0014\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/springhb/api/impl/SpringHbUtilApiImpl;", "Lcom/tencent/mobileqq/springhb/api/ISpringHbUtilApi;", "()V", "getConfContentMd5", "", "configId", "", "getConfTaskId", "getReportDebugFragment", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "saveConfContentMd5", "", "md5", "saveConfTaskId", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "springhb-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class SpringHbUtilApiImpl implements ISpringHbUtilApi {
    static IPatchRedirector $redirector_;

    public SpringHbUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbUtilApi
    @Nullable
    public String getConfContentMd5(int configId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, configId);
        }
        return n.p(configId);
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbUtilApi
    public int getConfTaskId(int configId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, configId)).intValue();
        }
        return n.q(configId);
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbUtilApi
    @Nullable
    public Class<? extends QPublicBaseFragment> getReportDebugFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return ReportDebugFragment.class;
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbUtilApi
    public void saveConfContentMd5(int configId, @Nullable String md5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, configId, (Object) md5);
        } else {
            n.P(configId, md5);
        }
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbUtilApi
    public void saveConfTaskId(int configId, int taskId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(configId), Integer.valueOf(taskId));
        } else {
            n.Q(configId, taskId);
        }
    }
}
