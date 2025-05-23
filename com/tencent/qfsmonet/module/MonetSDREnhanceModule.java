package com.tencent.qfsmonet.module;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qfsmonet.api.module.IMonetModule;
import com.tencent.qfsmonet.api.module.singleinput.IMonetSDREnhanceModule;
import com.tencent.qfsmonet.module.MonetModuleInner;
import com.tencent.qfsmonet.module.operator.MonetSDREnhanceOperator;
import com.tencent.qfsmonet.module.operator.common.MonetOperator;
import com.tencent.qfsmonet.module.operator.common.MonetOperatorData;
import java.util.ArrayList;

/* compiled from: P */
@MonetModuleInner.ModuleAnnotation(IMonetModule.SINGLE_INPUT_SDR_ENHANCE)
/* loaded from: classes22.dex */
public class MonetSDREnhanceModule extends MonetModuleInner implements IMonetSDREnhanceModule {
    static IPatchRedirector $redirector_ = null;
    private static final MonetOperatorData INPUT_DATA;
    private static final String MODULE_INPUT = "sdr_enhance_input";
    private static final String MODULE_NAME = "SDREnhance";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21295);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INPUT_DATA = new MonetOperatorData(MODULE_INPUT, 6408);
        }
    }

    public MonetSDREnhanceModule() {
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
        MonetOperatorData monetOperatorData = new MonetOperatorData(MODULE_INPUT, 6408);
        MonetSDREnhanceOperator monetSDREnhanceOperator = new MonetSDREnhanceOperator();
        monetSDREnhanceOperator.addInput(monetOperatorData);
        ArrayList<MonetOperator> arrayList = new ArrayList<>();
        arrayList.add(monetSDREnhanceOperator);
        return arrayList;
    }

    @Override // com.tencent.qfsmonet.api.module.IMonetModule
    public String getModuleType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return IMonetModule.SINGLE_INPUT_SDR_ENHANCE;
    }
}
