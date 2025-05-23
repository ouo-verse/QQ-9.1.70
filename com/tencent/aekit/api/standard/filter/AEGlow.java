package com.tencent.aekit.api.standard.filter;

import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.HDRHSVFilter;
import com.tencent.filter.ttpic.GPUImageLookupFilter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.filter.AlphaAdjustFilter;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AEGlow extends AEChainI {
    static IPatchRedirector $redirector_ = null;
    private static final String DEAULT_ASSETS_PATH = "assets://luts/";
    private static final String LUT_NAME = "eftXuanlan_lf.png";
    private float alpha;
    private String lutRes;
    private AlphaAdjustFilter mAlphaFilter;
    private HDRHSVFilter mHDRHSVFilter;
    private GPUImageLookupFilter mLookUpFilter;

    public AEGlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.alpha = 0.0f;
        this.lutRes = getLutRes();
        this.mHDRHSVFilter = new HDRHSVFilter();
        this.mLookUpFilter = new GPUImageLookupFilter(this.lutRes);
        this.mAlphaFilter = new AlphaAdjustFilter();
    }

    public void applyFilterChain(boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (!TextUtils.isEmpty(this.lutRes) && !this.mIsApplied) {
            HashMap hashMap = new HashMap();
            hashMap.put("stretechMag", Float.valueOf(25.0f));
            hashMap.put("sharpnessMag", Float.valueOf(0.3f));
            hashMap.put("saturationMag", Float.valueOf(1.3f));
            hashMap.put("percent", Float.valueOf(0.001f));
            this.mHDRHSVFilter.setParameterDic(hashMap);
            this.mHDRHSVFilter.applyFilterChain(z16, i3, i16);
            this.mLookUpFilter.apply();
            this.mAlphaFilter.apply();
            this.mAlphaFilter.setAdjustParam(this.alpha);
            this.mIsApplied = true;
        }
    }

    @Override // com.tencent.aekit.openrender.internal.AEChainI
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (!TextUtils.isEmpty(this.lutRes) && this.mIsApplied) {
            this.mHDRHSVFilter.clearGLSLSelf();
            this.mLookUpFilter.clearGLSLSelf();
            this.mAlphaFilter.clearGLSLSelf();
            this.mIsApplied = false;
        }
    }

    public String getLutRes() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (!TextUtils.isEmpty(FeatureManager.getResourceDir())) {
            str = FileUtils.getRealPath(FeatureManager.getResourceDir()) + LUT_NAME;
        } else {
            str = "assets://luts/eftXuanlan_lf.png";
        }
        if (!FileUtils.assetAndPathExist(AEModule.getContext(), str)) {
            return null;
        }
        return str;
    }

    public String printParamInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "AEGlow {TAG =AEGlow , alpha='" + this.alpha + '}';
    }

    @Override // com.tencent.aekit.openrender.internal.AEChainI
    public Frame render(Frame frame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Frame) iPatchRedirector.redirect((short) 4, (Object) this, (Object) frame);
        }
        if (!TextUtils.isEmpty(this.lutRes) && this.alpha != 0.0f) {
            Frame RenderProcess = this.mHDRHSVFilter.RenderProcess(frame.getTextureId(), frame.width, frame.height);
            Frame RenderProcess2 = this.mLookUpFilter.RenderProcess(RenderProcess.getTextureId(), frame.width, frame.height);
            if (this.alpha == 1.0f) {
                RenderProcess.unlock();
                frame.unlock();
                return RenderProcess2;
            }
            this.mAlphaFilter.setFilterTexture(RenderProcess2.getTextureId());
            this.mAlphaFilter.RenderProcess(frame.getTextureId(), frame.width, frame.height, -1, 0.0d, RenderProcess);
            RenderProcess2.unlock();
            frame.unlock();
            return RenderProcess;
        }
        return frame;
    }

    public void setAlpha(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
        } else {
            this.alpha = f16;
            this.mAlphaFilter.setAdjustParam(f16);
        }
    }
}
