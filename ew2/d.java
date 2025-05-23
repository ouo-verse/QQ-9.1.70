package ew2;

import cooperation.qzone.util.PerfTracer;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d {
    public static String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
            return URLEncoder.encode(jSONObject.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return "__CLICK_LPP__";
        } catch (JSONException e17) {
            e17.printStackTrace();
            return "__CLICK_LPP__";
        }
    }
}
