package com.tencent.qfsmonet.module;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qfsmonet.api.data.MonetPacketDescriptor;
import com.tencent.qfsmonet.api.module.singleinput.IMonetTMESuperResolutionModule;
import com.tencent.qfsmonet.module.MonetModuleInner;
import com.tencent.qfsmonet.module.operator.MonetTMEDNOperator;
import com.tencent.qfsmonet.module.operator.common.MonetOperator;
import com.tencent.qfsmonet.module.operator.common.MonetOperatorData;
import java.util.ArrayList;

/* compiled from: P */
@MonetModuleInner.ModuleAnnotation("MonetTMEDenoiseModule")
/* loaded from: classes22.dex */
public class MonetTMEDenoiseModule extends MonetModuleInner implements IMonetTMESuperResolutionModule {
    static IPatchRedirector $redirector_ = null;
    private static final MonetOperatorData INPUT_DATA;
    private static final String MODULE_INPUT = "denoise_input";
    private static final String MODULE_NAME = "Denoise";
    private static final String TAG = "MonetTMEDenoiseModule";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22923);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INPUT_DATA = new MonetOperatorData(MODULE_INPUT, MonetPacketDescriptor.MonetDataFormat.RGBA32F);
        }
    }

    public MonetTMEDenoiseModule() {
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
            MonetTMEDNOperator monetTMEDNOperator = new MonetTMEDNOperator();
            monetTMEDNOperator.addInput(INPUT_DATA);
            arrayList.add(monetTMEDNOperator);
        } catch (Exception e16) {
            com.tencent.qfsmonet.utils.a.b("MonetTMEDenoiseModule", "build protocol, ex=" + e16.toString());
        }
        return arrayList;
    }

    @Override // com.tencent.qfsmonet.api.module.IMonetModule
    public String getModuleType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "MonetTMEDenoiseModule";
    }
}
