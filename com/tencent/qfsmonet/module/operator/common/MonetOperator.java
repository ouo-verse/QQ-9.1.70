package com.tencent.qfsmonet.module.operator.common;

import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.utils.a;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class MonetOperator {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_OUTPUT_SIZE = 1;
    private static final String TAG = "MonetOperator";
    private ArrayList<String> mInputNameList;
    private String mOperatorType;
    private ArrayList<MonetOperatorData> mOutputDataList;
    private HashMap<String, String> mParamsMap;

    /* JADX INFO: Access modifiers changed from: protected */
    public MonetOperator(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.mInputNameList = new ArrayList<>();
        this.mOutputDataList = new ArrayList<>();
        this.mOperatorType = str;
        this.mParamsMap = new HashMap<>();
    }

    public void addInput(@NonNull MonetOperatorData monetOperatorData) throws IllegalArgumentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) monetOperatorData);
        } else {
            if (!TextUtils.isEmpty(monetOperatorData.getDataName())) {
                if (this.mInputNameList.contains(monetOperatorData.getDataName())) {
                    a.h(TAG, "dup add! check protocol.");
                    return;
                } else {
                    this.mInputNameList.add(monetOperatorData.getDataName());
                    return;
                }
            }
            throw new IllegalArgumentException("input name empty! check protocol.");
        }
    }

    @NonNull
    public ArrayList<String> getInputName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mInputNameList;
    }

    @NonNull
    public String getOpIdentifier() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mOperatorType + "_" + hashCode();
    }

    @NonNull
    public HashMap<String, String> getOperatorParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (HashMap) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mParamsMap;
    }

    @NonNull
    public ArrayList<MonetOperatorData> getOutput() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (this.mOutputDataList.size() > 0) {
            return this.mOutputDataList;
        }
        for (int i3 = 0; i3 < getOutputSize(); i3++) {
            this.mOutputDataList.add(new MonetOperatorData(getType() + "_" + hashCode() + "_output_" + i3, 6408));
        }
        return this.mOutputDataList;
    }

    @IntRange(from = 1)
    protected int getOutputSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 1;
    }

    @NonNull
    public String getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mOperatorType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MonetOperator(@NonNull String str, @NonNull HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) hashMap);
            return;
        }
        this.mInputNameList = new ArrayList<>();
        this.mOutputDataList = new ArrayList<>();
        this.mOperatorType = str;
        this.mParamsMap = hashMap;
    }
}
