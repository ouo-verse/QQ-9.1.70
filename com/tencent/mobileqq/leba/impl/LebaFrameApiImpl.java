package com.tencent.mobileqq.leba.impl;

import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.leba.ILebaFrameApi;
import com.tencent.mobileqq.leba.Leba;
import com.tencent.mobileqq.leba.feed.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LebaFrameApiImpl implements ILebaFrameApi {
    static IPatchRedirector $redirector_;

    public LebaFrameApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaFrameApi
    public Class<? extends Frame> getLebaFrameClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return Leba.class;
    }

    @Override // com.tencent.mobileqq.leba.ILebaFrameApi
    public boolean isLeba(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        return str.equals(Leba.class.getName());
    }

    @Override // com.tencent.mobileqq.leba.ILebaFrameApi
    public boolean isLebaFrame(be beVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) beVar)).booleanValue();
        }
        return beVar instanceof Leba;
    }

    @Override // com.tencent.mobileqq.leba.ILebaFrameApi
    public Frame newLebaFrame(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Frame) iPatchRedirector.redirect((short) 9, (Object) this, (Object) frameFragment);
        }
        return new Leba();
    }

    @Override // com.tencent.mobileqq.leba.ILebaFrameApi
    public void onPostThemeChanged(be beVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) beVar);
        } else if (beVar != null && (beVar instanceof Leba)) {
            ((Leba) beVar).onPostThemeChanged();
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaFrameApi
    public void onSwitchToLeba(be beVar, boolean z16, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, beVar, Boolean.valueOf(z16), redTypeInfo);
        } else if (beVar != null && (beVar instanceof Leba)) {
            ((Leba) beVar).onSwitchToLeba(z16, redTypeInfo);
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaFrameApi
    public void showLebaFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            d.d(false);
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaFrameApi
    public void showQzoneFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            d.d(true);
        }
    }
}
