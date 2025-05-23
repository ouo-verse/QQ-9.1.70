package com.tencent.lbssearch.object.deserializer;

import com.tencent.map.tools.json.JsonParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes7.dex */
public class RoutePlanningStepDeserializer implements JsonParser.Deserializer<List<Integer>> {
    static IPatchRedirector $redirector_;

    public RoutePlanningStepDeserializer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.map.tools.json.JsonParser.Deserializer
    public List<Integer> deserialize(Object obj, String str, Object obj2) throws JSONException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, this, obj, str, obj2);
        }
        ArrayList arrayList = new ArrayList();
        if (obj2 instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj2;
            if (jSONArray.length() == 2) {
                arrayList.add(Integer.valueOf(jSONArray.getInt(0) / 2));
                arrayList.add(Integer.valueOf(jSONArray.getInt(1) / 2));
            }
        }
        return arrayList;
    }
}
