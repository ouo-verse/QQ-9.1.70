package com.tencent.timi.game.tgpa.data;

import com.tencent.timi.game.utils.l;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public class CyminiTGPAData {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    @interface TGPADataKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    @interface TGPAResourceProgressType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    @interface TGPASceneType {
    }

    public static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e16) {
            l.f("CyminiTGPAData", "getTGPADataKeyFromString parse error", e16);
            return 0;
        }
    }

    public static int b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e16) {
            l.f("CyminiTGPAData", "getTGPAResourceProgressTypeFromString parse error", e16);
            return 0;
        }
    }

    public static int c(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e16) {
            l.f("CyminiTGPAData", "getTGPASceneTypeFromString parse error", e16);
            return 0;
        }
    }

    public static JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("1111", "test notify");
            return jSONObject;
        } catch (Exception e16) {
            l.f("CyminiTGPAData", "getTestNofityJson error ", e16);
            return null;
        }
    }
}
