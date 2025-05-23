package com.tencent.qfsmonet.module;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qfsmonet.api.module.IMonetModule;
import com.tencent.qfsmonet.api.module.singleinput.IMonetGaussianBlurVideoOverlayModule;
import com.tencent.qfsmonet.module.MonetModuleInner;
import com.tencent.qfsmonet.module.operator.common.MonetOperator;
import com.tencent.qfsmonet.module.operator.common.MonetOperatorData;
import com.tencent.qfsmonet.module.operator.imageprocessing.MonetHorizonGaussianBlurOperator;
import com.tencent.qfsmonet.module.operator.imageprocessing.MonetVerticalGaussianBlurOperator;
import com.tencent.qfsmonet.module.operator.renderprocessing.MonetImageCropOperator;
import com.tencent.qfsmonet.module.operator.renderprocessing.MonetOverlayOperator;
import com.tencent.qfsmonet.module.operator.renderprocessing.MonetResizeOperator;
import com.tencent.qfsmonet.process.core.MonetProcessParams;
import java.util.ArrayList;

/* compiled from: P */
@MonetModuleInner.ModuleAnnotation(IMonetModule.SINGLE_INPUT_SUPER_RESOLUTION)
/* loaded from: classes22.dex */
public class MonetGaussianBlurVideoOverlayModule extends MonetModuleInner implements IMonetGaussianBlurVideoOverlayModule {
    static IPatchRedirector $redirector_ = null;
    private static final MonetOperatorData INPUT_DATA;
    private static final String MODULE_INPUT = "blur_video_overlay_input";
    private static final String MODULE_NAME = "GaussianBlurVideoOverlay";
    private static final String TAG = "MonetGaussianBlurVideoOverlayModule";
    private GsRect mBlurRect;
    private MonetOperator mCropOperator;
    private MonetOperator mHBlurOperator;
    private MonetOperator mOverlayOperator;
    private GsRect mOverlayRect;
    ArrayList<MonetProcessParams> mParamsList;
    private MonetOperator mResizeOperator;
    private final Object mSync;
    private MonetOperator mVBlurOperator;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18535);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INPUT_DATA = new MonetOperatorData(MODULE_INPUT, 6408);
        }
    }

    public MonetGaussianBlurVideoOverlayModule() {
        super(MODULE_NAME, INPUT_DATA);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mSync = new Object();
        this.mCropOperator = new MonetImageCropOperator();
        this.mHBlurOperator = new MonetHorizonGaussianBlurOperator();
        this.mVBlurOperator = new MonetVerticalGaussianBlurOperator();
        this.mResizeOperator = new MonetResizeOperator();
        this.mOverlayOperator = new MonetOverlayOperator();
        AnonymousClass1 anonymousClass1 = null;
        this.mBlurRect = new GsRect(this, anonymousClass1);
        this.mOverlayRect = new GsRect(this, anonymousClass1);
        this.mParamsList = new ArrayList<>();
        setUpOps();
    }

    private void setUpOps() {
        MonetOperator monetOperator = this.mCropOperator;
        MonetOperatorData monetOperatorData = INPUT_DATA;
        monetOperator.addInput(monetOperatorData);
        this.mHBlurOperator.addInput(this.mCropOperator.getOutput().get(0));
        this.mVBlurOperator.addInput(this.mHBlurOperator.getOutput().get(0));
        this.mResizeOperator.addInput(this.mVBlurOperator.getOutput().get(0));
        this.mOverlayOperator.addInput(this.mResizeOperator.getOutput().get(0));
        this.mOverlayOperator.addInput(monetOperatorData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qfsmonet.module.MonetModuleInner
    public ArrayList<MonetOperator> build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList<MonetOperator> arrayList = new ArrayList<>();
        try {
            arrayList.add(this.mCropOperator);
            arrayList.add(this.mHBlurOperator);
            arrayList.add(this.mVBlurOperator);
            arrayList.add(this.mResizeOperator);
            arrayList.add(this.mOverlayOperator);
        } catch (Exception e16) {
            com.tencent.qfsmonet.utils.a.b("MonetGaussianBlurVideoOverlayModule", "build protocol, ex=" + e16.toString());
        }
        return arrayList;
    }

    MonetProcessParams createMonetParam(MonetOperator monetOperator, String str, String str2) {
        return new MonetProcessParams(monetOperator.getOpIdentifier(), str, str2);
    }

    @Override // com.tencent.qfsmonet.module.MonetModuleInner
    public ArrayList<MonetProcessParams> getModuleProcessParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        synchronized (this.mSync) {
            if (this.mParamsList.size() == 0) {
                return this.mParamsList;
            }
            ArrayList<MonetProcessParams> arrayList = new ArrayList<>(this.mParamsList);
            this.mParamsList.clear();
            return arrayList;
        }
    }

    @Override // com.tencent.qfsmonet.api.module.IMonetModule
    public String getModuleType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "MonetGaussianBlurVideoOverlayModule";
    }

    @Override // com.tencent.qfsmonet.api.module.singleinput.IMonetGaussianBlurVideoOverlayModule
    public void setBlurBackgroundSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        synchronized (this.mSync) {
            this.mParamsList.add(createMonetParam(this.mResizeOperator, MonetResizeOperator.RESIZE_W_KEY, Integer.toString(i3)));
            this.mParamsList.add(createMonetParam(this.mResizeOperator, MonetResizeOperator.RESIZE_H_KEY, Integer.toString(i16)));
        }
    }

    @Override // com.tencent.qfsmonet.api.module.singleinput.IMonetGaussianBlurVideoOverlayModule
    public void setBlurRect(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        GsRect gsRect = this.mBlurRect;
        gsRect.f342559x = f16;
        gsRect.f342560y = f17;
        gsRect.f342558w = f18;
        gsRect.f342557h = f19;
        synchronized (this.mSync) {
            this.mParamsList.add(createMonetParam(this.mCropOperator, MonetImageCropOperator.CROP_X_KEY, Float.toString(this.mBlurRect.f342559x)));
            this.mParamsList.add(createMonetParam(this.mCropOperator, MonetImageCropOperator.CROP_Y_KEY, Float.toString(this.mBlurRect.f342560y)));
            this.mParamsList.add(createMonetParam(this.mCropOperator, MonetImageCropOperator.CROP_W_KEY, Float.toString(this.mBlurRect.f342558w)));
            this.mParamsList.add(createMonetParam(this.mCropOperator, MonetImageCropOperator.CROP_H_KEY, Float.toString(this.mBlurRect.f342557h)));
        }
    }

    @Override // com.tencent.qfsmonet.api.module.singleinput.IMonetGaussianBlurVideoOverlayModule
    public void setOverlayRect(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        GsRect gsRect = this.mOverlayRect;
        gsRect.f342559x = f16;
        gsRect.f342560y = f17;
        gsRect.f342558w = f18;
        gsRect.f342557h = f19;
        synchronized (this.mSync) {
            this.mParamsList.add(createMonetParam(this.mOverlayOperator, MonetOverlayOperator.OVERLAY_X_KEY, Float.toString(this.mOverlayRect.f342559x)));
            this.mParamsList.add(createMonetParam(this.mOverlayOperator, MonetOverlayOperator.OVERLAY_Y_KEY, Float.toString(this.mOverlayRect.f342560y)));
            this.mParamsList.add(createMonetParam(this.mOverlayOperator, MonetOverlayOperator.OVERLAY_W_KEY, Float.toString(this.mOverlayRect.f342558w)));
            this.mParamsList.add(createMonetParam(this.mOverlayOperator, MonetOverlayOperator.OVERLAY_H_KEY, Float.toString(this.mOverlayRect.f342557h)));
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private class GsRect {
        static IPatchRedirector $redirector_;

        /* renamed from: h, reason: collision with root package name */
        float f342557h;

        /* renamed from: w, reason: collision with root package name */
        float f342558w;

        /* renamed from: x, reason: collision with root package name */
        float f342559x;

        /* renamed from: y, reason: collision with root package name */
        float f342560y;

        GsRect() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MonetGaussianBlurVideoOverlayModule.this);
                return;
            }
            this.f342559x = 0.0f;
            this.f342560y = 0.0f;
            this.f342558w = 1.0f;
            this.f342557h = 1.0f;
        }

        /* synthetic */ GsRect(MonetGaussianBlurVideoOverlayModule monetGaussianBlurVideoOverlayModule, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) monetGaussianBlurVideoOverlayModule, (Object) anonymousClass1);
        }
    }
}
