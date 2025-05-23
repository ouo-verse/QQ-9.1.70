package mw2;

import com.google.gson.Gson;
import java.util.Map;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    public static String a(Map<String, Object> map) {
        try {
            if (!y.i(map)) {
                return new Gson().toJson(map);
            }
        } catch (Exception unused) {
        }
        return "";
    }
}
