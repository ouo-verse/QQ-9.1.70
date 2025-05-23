package com.tencent.lbssearch.object.deserializer;

import android.text.TextUtils;
import com.tencent.lbssearch.object.result.TransitResultObject;
import com.tencent.map.tools.json.JsonParser;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TransitResultSegmentDeserializer implements JsonParser.Deserializer<TransitResultObject.Segment> {
    static IPatchRedirector $redirector_;

    public TransitResultSegmentDeserializer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.map.tools.json.JsonParser.Deserializer
    public TransitResultObject.Segment deserialize(Object obj, String str, Object obj2) throws JSONException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TransitResultObject.Segment) iPatchRedirector.redirect((short) 2, this, obj, str, obj2);
        }
        if (obj2 == null || !(obj2 instanceof JSONObject)) {
            return null;
        }
        JSONObject jSONObject = (JSONObject) obj2;
        String string = jSONObject.getString("mode");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        if ("WALKING".equalsIgnoreCase(string)) {
            return (TransitResultObject.Segment) JsonUtils.parseToModel(jSONObject, TransitResultObject.Walking.class, new Object[0]);
        }
        if ("TRANSIT".equalsIgnoreCase(string)) {
            return (TransitResultObject.Segment) JsonUtils.parseToModel(jSONObject, TransitResultObject.Transit.class, new Object[0]);
        }
        return null;
    }
}
