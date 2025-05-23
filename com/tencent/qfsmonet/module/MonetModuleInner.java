package com.tencent.qfsmonet.module;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.module.operator.common.MonetOperator;
import com.tencent.qfsmonet.module.operator.common.MonetOperatorData;
import com.tencent.qfsmonet.process.core.MonetProcessParams;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Keep
/* loaded from: classes22.dex */
public abstract class MonetModuleInner {
    static IPatchRedirector $redirector_ = null;
    public static final String EMPTY_STRING = "";
    public static final int FIRST_OPERATOR_INDEX = 0;
    protected static final String JSON_IDENTIFIER = "identifier";
    protected static final String JSON_INPUTS = "inputs";
    protected static final String JSON_MODULE_NAME = "name";
    protected static final String JSON_OPERATOR = "operators";
    protected static final String JSON_OUTPUTS = "outputs";
    protected static final String JSON_PARAMS = "param_keys";
    protected static final String JSON_TYPE = "type";
    private static final String TAG = "MonetModuleInner";
    private ArrayList<MonetProcessParams> mDefaultParams;
    private MonetOperatorData mInputData;
    protected HashMap<String, String> mModuleCommonParams;
    private String mModuleName;
    private String mModuleProtocol;

    /* compiled from: P */
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes22.dex */
    public @interface ModuleAnnotation {
        String value();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MonetModuleInner(@NonNull String str, @NonNull MonetOperatorData monetOperatorData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) monetOperatorData);
            return;
        }
        this.mDefaultParams = new ArrayList<>();
        this.mModuleCommonParams = new HashMap<>();
        this.mModuleName = str;
        this.mInputData = monetOperatorData;
    }

    private JSONArray arrayListToJsonArray(@NonNull ArrayList<?> arrayList) {
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            Object obj = arrayList.get(i3);
            if (obj instanceof MonetOperatorData) {
                jSONArray.mo162put(((MonetOperatorData) obj).getDataName());
            } else if (obj instanceof String) {
                jSONArray.mo162put(obj);
            }
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public abstract ArrayList<MonetOperator> build();

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONArray buildOpProtocol(@NonNull ArrayList<MonetOperator> arrayList, @NonNull ArrayList<String> arrayList2) throws Exception {
        ArrayList<String> inputName;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (JSONArray) iPatchRedirector.redirect((short) 3, (Object) this, (Object) arrayList, (Object) arrayList2);
        }
        JSONArray jSONArray = new JSONArray();
        String str = "";
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            MonetOperator monetOperator = arrayList.get(i3);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("identifier", monetOperator.getOpIdentifier());
            jSONObject.put("type", monetOperator.getType());
            if (i3 == 0 && arrayList2.size() != 0) {
                str = monetOperator.getInputName().get(0);
                inputName = arrayList2;
            } else {
                inputName = monetOperator.getInputName();
            }
            ArrayList<?> arrayList3 = new ArrayList<>();
            Iterator<String> it = inputName.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!next.equals(str)) {
                    arrayList3.add(next);
                } else {
                    arrayList3.add(arrayList2.get(0));
                }
            }
            jSONObject.put(JSON_INPUTS, arrayListToJsonArray(arrayList3));
            jSONObject.put(JSON_OUTPUTS, arrayListToJsonArray(monetOperator.getOutput()));
            if (monetOperator.getOperatorParams() != null && monetOperator.getOperatorParams().size() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.mo162put(new JSONObject(monetOperator.getOperatorParams()).toString());
                jSONObject.put(JSON_PARAMS, jSONArray2);
            }
            jSONArray.mo162put(jSONObject);
        }
        return jSONArray;
    }

    @NonNull
    public ArrayList<MonetOperatorData> getInputData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new ArrayList<MonetOperatorData>() { // from class: com.tencent.qfsmonet.module.MonetModuleInner.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MonetModuleInner.this);
                } else {
                    add(MonetModuleInner.this.mInputData);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayList<String> getInputName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ArrayList) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < getInputData().size(); i3++) {
            arrayList.add(getInputData().get(i3).getDataName());
        }
        return arrayList;
    }

    public ArrayList<MonetProcessParams> getModuleProcessParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mDefaultParams;
    }

    @NonNull
    public String getProtocol() {
        ArrayList<MonetOperator> build;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (!TextUtils.isEmpty(this.mModuleProtocol)) {
            return this.mModuleProtocol;
        }
        try {
            build = build();
        } catch (Exception e16) {
            com.tencent.qfsmonet.utils.a.b(TAG, "build protocol ex=" + e16.toString());
        }
        if (build != null && !build.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", this.mModuleName);
            jSONObject.put(JSON_OPERATOR, buildOpProtocol(build, getInputName()));
            this.mModuleProtocol = jSONObject.toString();
            return this.mModuleProtocol;
        }
        return "";
    }

    public void moduleWillLoad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    public void moduleWillRemove() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    public ArrayList<MonetProcessParams> parseParameters(@Nullable Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this, (Object) map);
        }
        return this.mDefaultParams;
    }

    public void setCommonParameters(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
        }
    }
}
