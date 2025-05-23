package com.tencent.mobileqq.signature.topic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.signature.view.SignatureBlockContainerLayout;
import com.tencent.mobileqq.vas.inject.ISignatureStatusManager;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b implements ISignatureStatusManager.ISignatureTopicObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private SignatureBlockContainerLayout f288456a;

    public b(SignatureBlockContainerLayout signatureBlockContainerLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) signatureBlockContainerLayout);
        } else {
            this.f288456a = signatureBlockContainerLayout;
        }
    }

    @Override // com.tencent.mobileqq.vas.inject.ISignatureStatusManager.ISignatureTopicObserver
    public void onGetRecommendTopic(boolean z16, int i3, List<ISignatureStatusManager.TopicInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), list);
            return;
        }
        if (list != null && list.size() > 0) {
            this.f288456a.a(0);
            if (this.f288456a.f288478e.e(list, true)) {
                this.f288456a.f288478e.notifyDataSetChanged();
                return;
            }
            return;
        }
        if (i3 == 0) {
            this.f288456a.a(2);
        } else {
            this.f288456a.a(1);
        }
    }
}
