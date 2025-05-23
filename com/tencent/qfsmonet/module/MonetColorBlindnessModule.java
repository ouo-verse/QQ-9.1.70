package com.tencent.qfsmonet.module;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qfsmonet.api.module.singleinput.IMonetColorBlindnessModule;
import com.tencent.qfsmonet.module.MonetModuleInner;
import com.tencent.qfsmonet.module.operator.MonetColorBlindnessOperator;
import com.tencent.qfsmonet.module.operator.common.MonetOperator;
import com.tencent.qfsmonet.module.operator.common.MonetOperatorData;
import com.tencent.qfsmonet.process.core.MonetProcessParams;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
@MonetModuleInner.ModuleAnnotation("MonetColorBlindnessModule")
/* loaded from: classes22.dex */
public class MonetColorBlindnessModule extends MonetModuleInner implements IMonetColorBlindnessModule {
    static IPatchRedirector $redirector_ = null;
    private static final MonetOperatorData INPUT_DATA;
    private static final String MODULE_INPUT = "color_blindness_input";
    private static final String MODULE_NAME = "ColorBlindness";
    private static String PARAM_KEY_COLOR_BLINDNESS_MODE = null;
    private static String PARAM_KEY_LUT_PATH = null;
    private static final String TAG = "MonetColorBlindnessModule";
    private String mColorBlindnessMode;
    private boolean mColorBlindnessModeChangeState;
    private MonetOperator mColorBlindnessOperator;
    private String mLookUpTablePath;
    private boolean mLookUpTablePathChangeState;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17629);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        PARAM_KEY_COLOR_BLINDNESS_MODE = "color_blindness_mode";
        PARAM_KEY_LUT_PATH = "color_blindness_path";
        INPUT_DATA = new MonetOperatorData(MODULE_INPUT, 6408);
    }

    public MonetColorBlindnessModule() {
        super(MODULE_NAME, INPUT_DATA);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mColorBlindnessMode = "";
        this.mColorBlindnessModeChangeState = false;
        this.mLookUpTablePath = "";
        this.mLookUpTablePathChangeState = false;
    }

    private MonetProcessParams transformProcessParams(String str, String str2) {
        return new MonetProcessParams(this.mColorBlindnessOperator.getOpIdentifier(), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qfsmonet.module.MonetModuleInner
    @NonNull
    public ArrayList<MonetOperator> build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_KEY_COLOR_BLINDNESS_MODE, this.mColorBlindnessMode);
        hashMap.put(PARAM_KEY_LUT_PATH, this.mLookUpTablePath);
        MonetColorBlindnessOperator monetColorBlindnessOperator = new MonetColorBlindnessOperator(hashMap);
        monetColorBlindnessOperator.addInput(INPUT_DATA);
        ArrayList<MonetOperator> arrayList = new ArrayList<>();
        arrayList.add(monetColorBlindnessOperator);
        this.mColorBlindnessOperator = monetColorBlindnessOperator;
        return arrayList;
    }

    @Override // com.tencent.qfsmonet.module.MonetModuleInner
    public ArrayList<MonetProcessParams> getModuleProcessParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList<MonetProcessParams> arrayList = new ArrayList<>();
        if (this.mColorBlindnessModeChangeState && !TextUtils.isEmpty(this.mColorBlindnessMode)) {
            arrayList.add(transformProcessParams(PARAM_KEY_COLOR_BLINDNESS_MODE, this.mColorBlindnessMode));
            this.mColorBlindnessModeChangeState = false;
        }
        if (this.mLookUpTablePathChangeState && !TextUtils.isEmpty(this.mLookUpTablePath)) {
            arrayList.add(transformProcessParams(PARAM_KEY_LUT_PATH, this.mLookUpTablePath));
            this.mLookUpTablePathChangeState = false;
        }
        return arrayList;
    }

    @Override // com.tencent.qfsmonet.api.module.IMonetModule
    public String getModuleType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "MonetColorBlindnessModule";
    }

    @Override // com.tencent.qfsmonet.api.module.singleinput.IMonetColorBlindnessModule
    public void setColorBlindnessMode(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.mColorBlindnessMode = str;
            this.mColorBlindnessModeChangeState = true;
        }
    }

    @Override // com.tencent.qfsmonet.api.module.singleinput.IMonetColorBlindnessModule
    public void setLutPath(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.mLookUpTablePath = str;
            this.mLookUpTablePathChangeState = true;
        }
    }
}
