package com.tencent.qfsmonet.module;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qfsmonet.api.module.IMonetModule;
import com.tencent.qfsmonet.api.module.singleinput.IMonetPatchModule;
import com.tencent.qfsmonet.module.MonetModuleInner;
import com.tencent.qfsmonet.module.operator.MonetPatchOperator;
import com.tencent.qfsmonet.module.operator.common.MonetOperator;
import com.tencent.qfsmonet.module.operator.common.MonetOperatorData;
import com.tencent.qfsmonet.process.core.MonetProcessParams;
import java.util.ArrayList;

@MonetModuleInner.ModuleAnnotation(IMonetModule.SINGLE_INPUT_PATCH)
/* loaded from: classes22.dex */
public class MonetPatchModule extends MonetModuleInner implements IMonetPatchModule {
    static IPatchRedirector $redirector_ = null;
    private static final MonetOperatorData INPUT_DATA;
    private static final String MODULE_INPUT = "patch_input";
    private static final String MODULE_NAME = "Patch";
    ArrayList<MonetProcessParams> mParamsList;
    private MonetOperator mPatchOperator;
    private final Object mSync;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20526);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INPUT_DATA = new MonetOperatorData(MODULE_INPUT, 6408);
        }
    }

    public MonetPatchModule() {
        super(MODULE_NAME, INPUT_DATA);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mPatchOperator = new MonetPatchOperator();
        this.mSync = new Object();
        this.mParamsList = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qfsmonet.module.MonetModuleInner
    public ArrayList<MonetOperator> build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        this.mPatchOperator.addInput(new MonetOperatorData(MODULE_INPUT, 6408));
        ArrayList<MonetOperator> arrayList = new ArrayList<>();
        arrayList.add(this.mPatchOperator);
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
        return IMonetModule.SINGLE_INPUT_PATCH;
    }

    @Override // com.tencent.qfsmonet.api.module.singleinput.IMonetPatchModule
    public void setPatchParams(String str, String str2, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, str3, str4, str5);
            return;
        }
        synchronized (this.mSync) {
            this.mParamsList.add(createMonetParam(this.mPatchOperator, MonetPatchOperator.PATCH_COUNT, str));
            this.mParamsList.add(createMonetParam(this.mPatchOperator, MonetPatchOperator.PATCH_TYPE_STR, str2));
            this.mParamsList.add(createMonetParam(this.mPatchOperator, MonetPatchOperator.PATCH_LOC_DESC1_STR, str3));
            this.mParamsList.add(createMonetParam(this.mPatchOperator, MonetPatchOperator.PATCH_LOC_DESC2_STR, str4));
            this.mParamsList.add(createMonetParam(this.mPatchOperator, MonetPatchOperator.PATCH_LOC_DESC3_STR, str5));
        }
    }
}
