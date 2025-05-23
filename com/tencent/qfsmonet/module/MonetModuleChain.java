package com.tencent.qfsmonet.module;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qfsmonet.api.module.IMonetModule;
import com.tencent.qfsmonet.api.module.IMonetSingleInputModule;
import com.tencent.qfsmonet.api.module.singleinput.IMonetModuleChain;
import com.tencent.qfsmonet.module.operator.common.MonetOperator;
import com.tencent.qfsmonet.module.operator.common.MonetOperatorData;
import com.tencent.qfsmonet.process.core.MonetProcessParams;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MonetModuleChain extends MonetModuleInner implements IMonetModuleChain {
    static IPatchRedirector $redirector_ = null;
    private static final MonetOperatorData DEFAULT_INPUT_DATA;
    private static final String MODULE_INPUT = "monet_chain_input";
    private static final String MODULE_NAME = "MonetModuleChain";
    private static final String TAG = "MonetModuleChain";
    private ArrayList<IMonetSingleInputModule> mMonetModuleList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19556);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            DEFAULT_INPUT_DATA = new MonetOperatorData(MODULE_INPUT, 6408);
        }
    }

    public MonetModuleChain() {
        super(IMonetModule.SINGLE_INPUT_MODULE_CHAIN, DEFAULT_INPUT_DATA);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mMonetModuleList = new ArrayList<>();
        }
    }

    @NonNull
    private JSONArray buildModuleProtocol() throws Exception {
        JSONArray jSONArray = new JSONArray();
        ArrayList<String> inputName = getInputName();
        int i3 = 0;
        while (i3 < this.mMonetModuleList.size()) {
            ArrayList<MonetOperator> build = ((MonetModuleInner) this.mMonetModuleList.get(i3)).build();
            JSONArray buildOpProtocol = buildOpProtocol(build, inputName);
            ArrayList<String> outputName = getOutputName(build.get(build.size() - 1).getOutput());
            convertArrayJson(buildOpProtocol, jSONArray);
            i3++;
            inputName = outputName;
        }
        return jSONArray;
    }

    private void convertArrayJson(JSONArray jSONArray, JSONArray jSONArray2) throws Exception {
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            jSONArray2.mo162put(jSONArray.get(i3));
        }
    }

    private ArrayList<String> getOutputName(@NonNull ArrayList<MonetOperatorData> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList2.add(arrayList.get(i3).getDataName());
        }
        return arrayList2;
    }

    @Override // com.tencent.qfsmonet.api.module.singleinput.IMonetModuleChain
    public void addSingleModule(@NonNull IMonetSingleInputModule iMonetSingleInputModule) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) iMonetSingleInputModule);
        } else if (this.mMonetModuleList.contains(iMonetSingleInputModule)) {
            com.tencent.qfsmonet.utils.a.c(IMonetModule.SINGLE_INPUT_MODULE_CHAIN, "had added.");
        } else {
            this.mMonetModuleList.add(iMonetSingleInputModule);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qfsmonet.module.MonetModuleInner
    @NonNull
    public ArrayList<MonetOperator> build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.qfsmonet.module.MonetModuleInner
    @NonNull
    public ArrayList<MonetOperatorData> getInputData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.mMonetModuleList.isEmpty()) {
            return new ArrayList<MonetOperatorData>() { // from class: com.tencent.qfsmonet.module.MonetModuleChain.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MonetModuleChain.this);
                    } else {
                        add(MonetModuleChain.DEFAULT_INPUT_DATA);
                    }
                }
            };
        }
        return ((MonetModuleInner) this.mMonetModuleList.get(0)).getInputData();
    }

    @Override // com.tencent.qfsmonet.module.MonetModuleInner
    public ArrayList<MonetProcessParams> getModuleProcessParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        ArrayList<MonetProcessParams> arrayList = new ArrayList<>();
        Iterator<IMonetSingleInputModule> it = this.mMonetModuleList.iterator();
        while (it.hasNext()) {
            arrayList.addAll(((MonetModuleInner) ((IMonetSingleInputModule) it.next())).getModuleProcessParams());
        }
        return arrayList;
    }

    @Override // com.tencent.qfsmonet.api.module.IMonetModule
    @NonNull
    public String getModuleType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return IMonetModule.SINGLE_INPUT_MODULE_CHAIN;
    }

    @Override // com.tencent.qfsmonet.module.MonetModuleInner
    @NonNull
    public String getProtocol() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.mMonetModuleList.isEmpty()) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", IMonetModule.SINGLE_INPUT_MODULE_CHAIN);
            jSONObject.put("operators", buildModuleProtocol());
            return jSONObject.toString();
        } catch (Exception e16) {
            com.tencent.qfsmonet.utils.a.b(IMonetModule.SINGLE_INPUT_MODULE_CHAIN, "ex=" + e16.toString());
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qfsmonet.api.module.singleinput.IMonetModuleChain
    public void removeSingleModule(@NonNull IMonetSingleInputModule iMonetSingleInputModule) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) iMonetSingleInputModule);
        } else {
            ((MonetModuleInner) iMonetSingleInputModule).moduleWillRemove();
            this.mMonetModuleList.remove(iMonetSingleInputModule);
        }
    }

    @Override // com.tencent.qfsmonet.module.MonetModuleInner
    public void setCommonParameters(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2);
        } else {
            if (str == null) {
                return;
            }
            Iterator<IMonetSingleInputModule> it = this.mMonetModuleList.iterator();
            while (it.hasNext()) {
                ((MonetModuleInner) ((IMonetSingleInputModule) it.next())).setCommonParameters(str, str2);
            }
        }
    }
}
