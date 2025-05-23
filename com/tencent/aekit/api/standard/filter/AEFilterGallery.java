package com.tencent.aekit.api.standard.filter;

import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.ttpic.GPUImageLookupFilter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AEFilterGallery extends AEChainI {
    static IPatchRedirector $redirector_;
    private GPUImageLookupFilter mLookupFilter;

    public AEFilterGallery() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mLookupFilter = new GPUImageLookupFilter();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.aekit.openrender.internal.AEChainI
    public void apply() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (!this.mIsApplied) {
            this.mLookupFilter.apply();
            this.mIsApplied = true;
        }
    }

    @Override // com.tencent.aekit.openrender.internal.AEChainI
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.mLookupFilter.clearGLSLSelf();
            this.mIsApplied = false;
        }
    }

    @Override // com.tencent.aekit.openrender.internal.AEChainI
    public Frame render(Frame frame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Frame) iPatchRedirector.redirect((short) 5, (Object) this, (Object) frame);
        }
        return this.mLookupFilter.RenderProcess(frame.getTextureId(), frame.width, frame.height);
    }

    public void setAdjustParam(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else {
            this.mLookupFilter.setAdjustParam(f16);
        }
    }

    public void updateLut(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.mLookupFilter.updateLut(str);
        }
    }

    public AEFilterGallery(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mLookupFilter = new GPUImageLookupFilter(str);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
    }
}
