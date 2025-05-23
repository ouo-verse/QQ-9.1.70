package com.tencent.qfsmonet.module;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qfsmonet.api.data.MonetPacketDescriptor;
import com.tencent.qfsmonet.api.module.singleinput.IMonetSuperResolutionModule;
import com.tencent.qfsmonet.module.MonetModuleInner;
import com.tencent.qfsmonet.module.operator.MonetRGB2YUVOperator;
import com.tencent.qfsmonet.module.operator.MonetSrAssembleOperator;
import com.tencent.qfsmonet.module.operator.MonetSrConvOperator;
import com.tencent.qfsmonet.module.operator.MonetYUV2RGBOperator;
import com.tencent.qfsmonet.module.operator.common.MonetOperator;
import com.tencent.qfsmonet.module.operator.common.MonetOperatorData;
import java.util.ArrayList;

/* compiled from: P */
@MonetModuleInner.ModuleAnnotation("MonetSuperResolutionModule")
/* loaded from: classes22.dex */
public class MonetSuperResolutionModule extends MonetModuleInner implements IMonetSuperResolutionModule {
    static IPatchRedirector $redirector_ = null;
    private static final MonetOperatorData INPUT_DATA;
    private static final String MODULE_INPUT = "super_resolution_input";
    private static final String MODULE_NAME = "SuperResolution";
    private static final String TAG = "MonetSuperResolutionModule";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21956);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INPUT_DATA = new MonetOperatorData(MODULE_INPUT, MonetPacketDescriptor.MonetDataFormat.RGBA32F);
        }
    }

    public MonetSuperResolutionModule() {
        super(MODULE_NAME, INPUT_DATA);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
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
            MonetRGB2YUVOperator monetRGB2YUVOperator = new MonetRGB2YUVOperator();
            monetRGB2YUVOperator.addInput(INPUT_DATA);
            MonetSrConvOperator monetSrConvOperator = new MonetSrConvOperator();
            monetSrConvOperator.addInput(monetRGB2YUVOperator.getOutput().get(0));
            MonetSrAssembleOperator monetSrAssembleOperator = new MonetSrAssembleOperator();
            monetSrAssembleOperator.addInput(monetSrConvOperator.getOutput().get(0));
            MonetYUV2RGBOperator monetYUV2RGBOperator = new MonetYUV2RGBOperator();
            monetYUV2RGBOperator.addInput(monetSrAssembleOperator.getOutput().get(0));
            monetYUV2RGBOperator.addInput(monetRGB2YUVOperator.getOutput().get(0));
            arrayList.add(monetRGB2YUVOperator);
            arrayList.add(monetSrConvOperator);
            arrayList.add(monetSrAssembleOperator);
            arrayList.add(monetYUV2RGBOperator);
        } catch (Exception e16) {
            com.tencent.qfsmonet.utils.a.b("MonetSuperResolutionModule", "build protocol, ex=" + e16.toString());
        }
        return arrayList;
    }

    @Override // com.tencent.qfsmonet.api.module.IMonetModule
    public String getModuleType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "MonetSuperResolutionModule";
    }
}
