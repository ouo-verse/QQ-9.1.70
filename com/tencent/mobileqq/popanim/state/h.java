package com.tencent.mobileqq.popanim.state;

import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class h extends a {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(RelativeLayout relativeLayout, f fVar) {
        super(relativeLayout, fVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) relativeLayout, (Object) fVar);
        }
    }

    @Override // com.tencent.mobileqq.popanim.state.a
    public void a(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        QQEmoticonPanelLinearLayoutHelper a16 = this.f259124f.a();
        if (a16 == null) {
            return;
        }
        a16.removeStickerMaskOnPanel();
    }

    @Override // com.tencent.mobileqq.popanim.state.a
    public void b(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.mobileqq.popanim.state.a
    public boolean c(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.f259124f.c();
        }
        return true;
    }
}
